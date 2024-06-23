package com.taobao.phenix.cache.memory;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.pexode.mimetype.MimeType;
import com.taobao.phenix.bitmap.BitmapPool;
import com.taobao.phenix.cache.LruCache;
import com.taobao.phenix.cache.memory.StaticCachedImage;
import com.taobao.phenix.request.b;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.BaseChainProducer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import tb.b40;
import tb.cs1;
import tb.ln0;
import tb.me;
import tb.qd0;
import tb.so1;
import tb.t5;
import tb.tp1;
import tb.vr2;

/* compiled from: Taobao */
public class MemoryCacheProducer extends BaseChainProducer<so1, b40, com.taobao.phenix.request.a> {
    private static final StaticCachedImage.StaticImageRecycleListener l = new a();
    private final LruCache<String, me> j;
    private final LimitedQueue<String> k = new LimitedQueue<>(1024);

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class LimitedQueue<E> extends ConcurrentLinkedQueue<E> {
        private int limit;

        public LimitedQueue(int i) {
            this.limit = i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.AbstractQueue, java.util.Queue, java.util.concurrent.ConcurrentLinkedQueue
        public boolean add(E e) {
            boolean add = super.add(e);
            while (add && size() > this.limit) {
                super.remove();
            }
            return add;
        }
    }

    /* compiled from: Taobao */
    static class a implements StaticCachedImage.StaticImageRecycleListener {
        a() {
        }

        @Override // com.taobao.phenix.cache.memory.StaticCachedImage.StaticImageRecycleListener
        public void recycle(StaticCachedImage staticCachedImage) {
            BitmapPool a = tp1.o().a().build();
            if (a != null) {
                a.putIntoPool(staticCachedImage);
            }
        }
    }

    public MemoryCacheProducer(LruCache<String, me> lruCache) {
        super(1, 1);
        cs1.c(lruCache);
        this.j = lruCache;
    }

    private void I(Consumer<so1, com.taobao.phenix.request.a> consumer) {
        if (tp1.o().k() != null) {
            tp1.o().k().onStart(consumer.getContext().U());
        }
    }

    public static so1 J(LruCache<String, me> lruCache, String str, boolean z) {
        me meVar = lruCache.get(str);
        if (meVar == null) {
            return null;
        }
        so1 M = M(meVar, z);
        if (M != null) {
            M.c(true);
            Bitmap bitmap = M.getBitmap();
            if (bitmap != null && bitmap.isRecycled()) {
                lruCache.remove(str);
                vr2.i("MemoryCache", "remove image(exist cache but bitmap is recycled), key=%s, releasable=%b", str, Boolean.valueOf(z));
                return null;
            }
        }
        return M;
    }

    public static so1 K(LruCache<String, me> lruCache, String str, boolean z) {
        me meVar = lruCache.get(str);
        if (meVar == null) {
            return null;
        }
        so1 M = M(meVar, z);
        if (M != null) {
            M.c(true);
            Bitmap bitmap = M.getBitmap();
            if (bitmap != null && bitmap.isRecycled()) {
                lruCache.remove(str);
                vr2.i("MemoryCache", "remove image(exist cache but bitmap is recycled), key=%s, releasable=%b", str, Boolean.valueOf(z));
                return null;
            }
        }
        return M;
    }

    private static me L(com.taobao.phenix.request.a aVar, b40 b40, StaticCachedImage.StaticImageRecycleListener staticImageRecycleListener) {
        b G = aVar.G();
        if (b40.f()) {
            return new StaticCachedImage(b40.b(), b40.c(), G.j(), G.f(), G.e(), aVar.E()).l(staticImageRecycleListener);
        }
        return new t5(b40.a(), G.j(), G.f(), G.e(), aVar.E());
    }

    private static so1 M(me meVar, boolean z) {
        return meVar.e(z, tp1.o().applicationContext() != null ? tp1.o().applicationContext().getResources() : null);
    }

    /* renamed from: H */
    public void consumeNewResult(Consumer<so1, com.taobao.phenix.request.a> consumer, boolean z, b40 b40) {
        boolean z2;
        me meVar;
        com.taobao.phenix.request.a context = consumer.getContext();
        boolean b0 = context.b0();
        String K = context.K();
        me meVar2 = null;
        so1 J = context.d0() ? null : J(this.j, K, b0);
        boolean z3 = J == null;
        MimeType g = b40.d() != null ? b40.d().g() : null;
        boolean z4 = tp1.w && Build.VERSION.SDK_INT == 28 && g != null && (g.g(com.taobao.pexode.mimetype.a.WEBP) || g.g(com.taobao.pexode.mimetype.a.WEBP_A));
        if (z3) {
            if (z4) {
                meVar = L(context, b40, null);
            } else {
                meVar = L(context, b40, l);
            }
            meVar2 = meVar;
            J = M(meVar2, b0);
            z2 = context.k() && z && b40.g();
            qd0 d = b40.d();
            if (d != null) {
                J.b(d.k);
                J.d(d.p);
                if (!z) {
                    d.release();
                }
            }
        } else {
            if (context.k()) {
                vr2.q("MemoryCache", context, "found existing cache before new CachedRootImage with pipeline consume result, key=%s", K);
            }
            z2 = false;
        }
        context.r0(System.currentTimeMillis());
        ln0.g(context.U());
        vr2.o("Phenix", "Dispatch Image to UI Thread.", context, true);
        consumer.onNewResult(J, z);
        if (z2) {
            boolean put = this.j.put(context.L(), K, meVar2);
            this.k.add(K);
            vr2.k("MemoryCache", context, "write into memcache with priority=%d, result=%B, value=%s", Integer.valueOf(context.L()), Boolean.valueOf(put), meVar2);
        } else if (z3 && z && b40.g()) {
            vr2.q("MemoryCache", context, "skip to write into memcache cause the request is not pipeline, key=%s", K);
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.qg
    public boolean a(Consumer<so1, com.taobao.phenix.request.a> consumer) {
        com.taobao.phenix.request.a context = consumer.getContext();
        ln0.e(context.U());
        if (consumer.getContext().d0()) {
            I(consumer);
            vr2.o("Phenix", "start & end ", context, true);
            return false;
        }
        vr2.o("Phenix", "start", context, true);
        o(consumer);
        String K = context.K();
        boolean b0 = context.b0();
        so1 J = J(this.j, K, b0);
        boolean z = J != null;
        vr2.k("MemoryCache", context, "read from memcache, result=%B, key=%s", Boolean.valueOf(z), K);
        if (!z && tp1.o().p() && context.Y()) {
            String F = context.F();
            if (!TextUtils.isEmpty(F)) {
                Iterator<String> it = this.k.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(F) && next.contains(F)) {
                        J = K(this.j, next, b0);
                        break;
                    }
                }
            }
        }
        if (!z && J == null && context.T() != null) {
            String j2 = context.T().j();
            so1 J2 = J(this.j, j2, b0);
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(J2 != null);
            objArr[1] = j2;
            vr2.k("MemoryCache", context, "secondary read from memcache, result=%B, key=%s", objArr);
            if (J2 != null) {
                J2.d(true);
                context.x();
            }
            J = J2;
        }
        n(consumer, z);
        if (J != null) {
            consumer.onNewResult(J, z);
            context.U().u(true);
        } else {
            context.U().u(false);
        }
        if (z || J != null || !context.Z()) {
            if (!z && J == null) {
                I(consumer);
            }
            vr2.o("Phenix", "End", context, z);
            return z;
        }
        consumer.onFailure(new MemOnlyFailedException());
        return true;
    }
}
