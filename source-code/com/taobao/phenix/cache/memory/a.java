package com.taobao.phenix.cache.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.taobao.phenix.bitmap.BitmapPool;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import tb.kg0;
import tb.me;
import tb.vr2;
import tb.wx0;

@TargetApi(19)
/* compiled from: Taobao */
public class a extends wx0<String, me> implements BitmapPool {
    public static final int CEILING_SIZE_MAX_MULTIPLE = 6;
    public static final String TAG = "ImageCachePool";
    public static final String TAG_POOL = "BitmapPool";
    public static final String TAG_RECYCLE = "ImageRecycle";
    private NavigableMap<Integer, List<String>> n = new TreeMap();
    private final Object o = new Object();
    private int p;
    private int q;
    private int r;
    private int s;

    /* access modifiers changed from: package-private */
    /* renamed from: com.taobao.phenix.cache.memory.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class C0225a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            a[Bitmap.Config.RGB_565.ordinal()] = 2;
            a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public a(int i, float f) {
        super(i, f);
        vr2.a(TAG, "init with maxSize=%K, hotPercent=%.1f%%", Integer.valueOf(i), Float.valueOf(f * 100.0f));
    }

    private int x(Bitmap.Config config) {
        if (config == null) {
            return 0;
        }
        int i = C0225a.a[config.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (!(i == 2 || i == 3)) {
                i2 = 4;
                if (i != 4) {
                    return 0;
                }
            }
        }
        return i2;
    }

    private int z(me meVar) {
        Bitmap bitmap;
        if (!(meVar instanceof StaticCachedImage) || (bitmap = ((StaticCachedImage) meVar).i) == null || bitmap.isRecycled() || !bitmap.isMutable()) {
            return 0;
        }
        return meVar.c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public void l(boolean z, String str, me meVar, boolean z2) {
        List list;
        if (z2) {
            meVar.j();
        } else {
            meVar.i(z);
        }
        synchronized (this.o) {
            if (!z) {
                int z3 = z(meVar);
                if (z3 > 0 && (list = (List) this.n.get(Integer.valueOf(z3))) != null) {
                    if (list.remove(str)) {
                        this.p -= z3;
                        this.s--;
                        vr2.a(TAG_POOL, "remove from bitmap pool when not pre-evicted(cache removed=%b), image=%s", Boolean.valueOf(z2), meVar);
                    }
                    if (list.isEmpty()) {
                        this.n.remove(Integer.valueOf(z3));
                    }
                }
            }
        }
    }

    @Override // com.taobao.phenix.bitmap.BitmapPool
    public int available() {
        return this.p;
    }

    @Override // com.taobao.phenix.cache.LruCache, tb.wx0, com.taobao.phenix.bitmap.BitmapPool
    public final synchronized void clear() {
        super.clear();
        synchronized (this.o) {
            this.p = 0;
            this.s = 0;
            this.n.clear();
        }
    }

    @Override // com.taobao.phenix.bitmap.BitmapPool
    public Bitmap getFromPool(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap;
        String str;
        int i3;
        me meVar;
        Bitmap bitmap2;
        int x = i * i2 * x(config);
        synchronized (this.o) {
            bitmap = null;
            if (x > 0) {
                Map.Entry<Integer, List<String>> ceilingEntry = this.n.ceilingEntry(Integer.valueOf(x));
                if (ceilingEntry != null) {
                    i3 = ceilingEntry.getKey().intValue();
                    if (i3 <= x * 6) {
                        List<String> value = ceilingEntry.getValue();
                        if (!value.isEmpty()) {
                            str = value.remove(0);
                            this.p -= i3;
                            this.s--;
                        } else {
                            str = null;
                        }
                        if (value.isEmpty()) {
                            this.n.remove(Integer.valueOf(i3));
                        }
                    } else {
                        str = null;
                    }
                }
            }
            str = null;
            i3 = 0;
        }
        if (str != null) {
            meVar = (me) o(str, false);
            if ((meVar instanceof StaticCachedImage) && (bitmap2 = ((StaticCachedImage) meVar).i) != null && bitmap2.isMutable() && !bitmap2.isRecycled()) {
                try {
                    bitmap2.reconfigure(i, i2, config);
                    bitmap2.setHasAlpha(true);
                    bitmap2.eraseColor(0);
                    bitmap = bitmap2;
                } catch (Throwable th) {
                    vr2.c(TAG_POOL, "reconfigure error, bitmap=%s, throwable=%s", bitmap2, th);
                }
            }
        } else {
            meVar = null;
        }
        if (bitmap != null) {
            this.q++;
            vr2.a(TAG_POOL, "get from bitmap pool, width=%d, height=%d, config=%s, redundant=%.1f, image=%s", Integer.valueOf(i), Integer.valueOf(i2), config, Float.valueOf(((float) i3) / ((float) x)), meVar);
        } else {
            this.r++;
        }
        v();
        return bitmap;
    }

    @Override // com.taobao.phenix.bitmap.BitmapPool
    public void maxPoolSize(int i) {
        u(i);
        vr2.a(TAG_POOL, "set preEvictedMaxSize(maxPoolSize=%K) in ImageCacheAndPool", Integer.valueOf(i));
    }

    @Override // com.taobao.phenix.bitmap.BitmapPool
    public boolean putIntoPool(me meVar) {
        boolean add;
        if (!d(meVar.b())) {
            vr2.a(TAG_POOL, "cannot put into bitmap pool(cache removed), image=%s", meVar);
            return false;
        }
        int z = z(meVar);
        if (z <= 0) {
            return false;
        }
        synchronized (this.o) {
            List list = (List) this.n.get(Integer.valueOf(z));
            if (list == null) {
                list = new LinkedList();
                this.n.put(Integer.valueOf(z), list);
            }
            this.p += z;
            this.s++;
            vr2.a(TAG_POOL, "put into bitmap pool, size=%d, image=%s", Integer.valueOf(z), meVar);
            add = list.add(meVar.b());
        }
        return add;
    }

    @Override // com.taobao.phenix.bitmap.BitmapPool
    public void trimPool(int i) {
        trimTo(i);
    }

    /* access modifiers changed from: protected */
    public void v() {
        if (kg0.g(3)) {
            int i = this.q;
            vr2.a(TAG_POOL, "%K/%K, rate:%.1f%%, hits:%d, misses:%d, count:%d", Integer.valueOf(this.p), Integer.valueOf(h()), Float.valueOf((((float) i) * 100.0f) / ((float) (i + this.r))), Integer.valueOf(this.q), Integer.valueOf(this.r), Integer.valueOf(this.s));
        }
    }

    /* renamed from: w */
    public final me get(String str) {
        me meVar = (me) super.get(str);
        a(TAG);
        return meVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public int e(me meVar) {
        if (meVar == null) {
            return 0;
        }
        return meVar.c();
    }
}
