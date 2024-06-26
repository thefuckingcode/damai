package com.taobao.android.dinamicx.videoc.expose.core;

import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public abstract class AbstractExposure<ExposeKey, ExposeData> implements IExposure<ExposeKey, ExposeData> {
    public static final int DEFAULT_CACHE_SIZE = 8;
    public static final long DEFAULT_EXPOSE_DELAY = 0;
    protected Handler a;
    protected final Map<ExposeKey, a<ExposeData>> b = new HashMap();
    protected LruCache<ExposeKey, a<ExposeData>> c;
    protected final Map<ExposeKey, ExposeData> d = new HashMap();

    /* compiled from: Taobao */
    public static class a<ExposeData> {
        ExposeData a;
        String b;
        Runnable c;

        a(ExposeData exposedata, String str, Runnable runnable) {
            this.a = exposedata;
            this.b = str;
            this.c = runnable;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Map<ExposeKey, ExposeData> c() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<ExposeKey, a<ExposeData>> entry : this.c.snapshot().entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().a);
        }
        return hashMap;
    }

    private void g(ExposeKey exposekey, ExposeData exposedata, String str, long j) {
        if (h()) {
            a<ExposeData> remove = this.b.remove(exposekey);
            if (remove != null) {
                this.a.removeCallbacks(remove.c);
            }
            q(exposekey, exposedata, str, j);
        }
    }

    private boolean h() {
        return this.a != null;
    }

    private void q(ExposeKey exposekey, ExposeData exposedata, String str, long j) {
        Runnable k = k(exposekey, exposedata, str);
        this.b.put(exposekey, new a<>(exposedata, str, k));
        this.a.postDelayed(k, j);
    }

    /* access modifiers changed from: protected */
    public int b() {
        return 8;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure
    public void cancelExpose(ExposeKey exposekey, String str) {
        cancelExpose(exposekey, str, true);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure
    public void clearCache() {
        if (h() && this.c.size() != 0) {
            for (Map.Entry<ExposeKey, a<ExposeData>> entry : this.c.snapshot().entrySet()) {
                cancelExpose(entry.getKey(), entry.getValue().b);
            }
            this.c.evictAll();
        }
    }

    /* access modifiers changed from: protected */
    public LruCache<ExposeKey, a<ExposeData>> d() {
        return new LruCache<>(b());
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure
    public void destroy() {
        if (h()) {
            this.a = null;
            n();
        }
    }

    /* access modifiers changed from: protected */
    public Handler e() {
        return new Handler(l());
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure
    public void expose(@NonNull ExposeKey exposekey, ExposeData exposedata, String str) {
        g(exposekey, exposedata, str, f());
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure
    public void exposeAtOnce(@NonNull ExposeKey exposekey, @Nullable ExposeData exposedata, String str) {
        g(exposekey, exposedata, str, 0);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure
    public void exposeCache() {
        if (h() && this.c.size() != 0) {
            try {
                for (Map.Entry<ExposeKey, a<ExposeData>> entry : this.c.snapshot().entrySet()) {
                    exposeAtOnce(entry.getKey(), entry.getValue().a, entry.getValue().b);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public long f() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void i(ExposeKey exposekey, @Nullable ExposeData exposedata, String str) {
    }

    /* access modifiers changed from: protected */
    public boolean j(ExposeKey exposekey, ExposeData exposedata, String str) {
        return false;
    }

    /* access modifiers changed from: protected */
    public Runnable k(final ExposeKey exposekey, final ExposeData exposedata, final String str) {
        return new Runnable() {
            /* class com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure */
            /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure */
            /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure */
            /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure */
            /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: android.util.LruCache<ExposeKey, com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure$a<ExposeData>> */
            /* JADX WARN: Multi-variable type inference failed */
            public void run() {
                AbstractExposure.this.b.remove(exposekey);
                if (!AbstractExposure.this.j(exposekey, exposedata, str)) {
                    AbstractExposure abstractExposure = AbstractExposure.this;
                    if (!abstractExposure.p(exposekey, exposedata, str, abstractExposure.c())) {
                        AbstractExposure.this.c.put(exposekey, new a(exposedata, str, this));
                        return;
                    }
                    AbstractExposure.this.m(exposekey, exposedata, str);
                    AbstractExposure.this.removeCache(exposekey, str);
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public Looper l() {
        return Looper.getMainLooper();
    }

    /* access modifiers changed from: protected */
    public abstract void m(ExposeKey exposekey, ExposeData exposedata, String str);

    /* access modifiers changed from: protected */
    public void n() {
    }

    /* access modifiers changed from: protected */
    public void o() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean p(ExposeKey exposekey, ExposeData exposedata, String str, Map<ExposeKey, ExposeData> map);

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure
    public void prepare() {
        if (!h()) {
            this.a = e();
            this.c = d();
            o();
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure
    public Map<ExposeKey, ExposeData> removeAllExposeData() {
        HashMap hashMap = new HashMap(this.d);
        this.d.clear();
        return hashMap;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure
    public ExposeData removeCache(@Nullable ExposeKey exposekey, String str) {
        a<ExposeData> remove;
        if (!h() || (remove = this.c.remove(exposekey)) == null) {
            return null;
        }
        this.a.removeCallbacks(remove.c);
        return remove.a;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure
    public void removeExposeData(@NonNull ExposeKey exposekey, String str) {
        this.d.remove(exposekey);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure
    public void storeExposeData(@NonNull ExposeKey exposekey, @Nullable ExposeData exposedata) {
        this.d.put(exposekey, exposedata);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure
    public void triggerExpose(@NonNull String str) {
        for (Map.Entry<ExposeKey, ExposeData> entry : this.d.entrySet()) {
            expose(entry.getKey(), entry.getValue(), str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure
    public void triggerExposeAtOnce(@NonNull String str) {
        if (h()) {
            for (Map.Entry<ExposeKey, ExposeData> entry : this.d.entrySet()) {
                k(entry.getKey(), entry.getValue(), str).run();
            }
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposure
    public void cancelExpose(@Nullable ExposeKey exposekey, String str, boolean z) {
        ExposeData removeCache = removeCache(exposekey, str);
        a<ExposeData> remove = this.b.remove(exposekey);
        if (remove != null) {
            this.a.removeCallbacks(remove.c);
        }
        if (z) {
            i(exposekey, removeCache, str);
        }
    }
}
