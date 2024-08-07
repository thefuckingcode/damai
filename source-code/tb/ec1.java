package tb;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.taobao.phenix.builder.Builder;
import com.taobao.phenix.cache.LruCache;

/* compiled from: Taobao */
public class ec1 implements Builder<LruCache<String, me>> {
    private boolean a;
    private LruCache<String, me> b;
    private Context c;
    private Integer d;
    private Float e;
    private ComponentCallbacks2 f;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements ComponentCallbacks2 {
        final /* synthetic */ LruCache a;

        a(LruCache lruCache) {
            this.a = lruCache;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            vr2.a(com.taobao.phenix.cache.memory.a.TAG, "ComponentCallbacks2 onTrimMemory, level=%d", Integer.valueOf(i));
            if (i >= 60) {
                this.a.clear();
                vr2.i(com.taobao.phenix.cache.memory.a.TAG, "clear all at TRIM_MEMORY_MODERATE", new Object[0]);
            } else if (i >= 40) {
                int size = this.a.size() / 2;
                this.a.trimTo(size);
                vr2.i(com.taobao.phenix.cache.memory.a.TAG, "trim to size=%d at TRIM_MEMORY_BACKGROUND", Integer.valueOf(size));
            }
        }
    }

    private static int b(Context context) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        long min = Math.min(maxMemory, activityManager != null ? (long) (activityManager.getMemoryClass() * 1048576) : 0);
        return Math.min(36700160, min < 33554432 ? 6291456 : min < 67108864 ? 10485760 : (int) (min / 5));
    }

    private LruCache<String, me> d(LruCache<String, me> lruCache) {
        if (Build.VERSION.SDK_INT >= 14) {
            a aVar = new a(lruCache);
            this.f = aVar;
            this.c.registerComponentCallbacks(aVar);
        }
        return lruCache;
    }

    /* renamed from: a */
    public synchronized LruCache<String, me> build() {
        if (this.a) {
            return this.b;
        }
        Context applicationContext = tp1.o().applicationContext();
        this.c = applicationContext;
        cs1.d(applicationContext, "Phenix.with(Context) hasn't been called before MemCacheBuilder building");
        this.a = true;
        LruCache<String, me> lruCache = this.b;
        if (lruCache != null) {
            int maxSize = lruCache.maxSize();
            float hotPercent = this.b.hotPercent();
            Integer num = this.d;
            int intValue = num != null ? num.intValue() : maxSize;
            Float f2 = this.e;
            float floatValue = f2 != null ? f2.floatValue() : hotPercent;
            if (maxSize != intValue || ((double) Math.abs(hotPercent - floatValue)) >= 1.0E-4d) {
                this.b.resize(intValue, floatValue);
            }
            return d(this.b);
        }
        if (this.d == null) {
            this.d = Integer.valueOf(b(this.c));
        }
        if (this.e == null) {
            this.e = Float.valueOf(0.2f);
        }
        com.taobao.phenix.cache.memory.a aVar = new com.taobao.phenix.cache.memory.a(this.d.intValue(), this.e.floatValue());
        this.b = aVar;
        return d(aVar);
    }

    /* access modifiers changed from: package-private */
    public LruCache<String, me> c() {
        return this.b;
    }

    /* renamed from: e */
    public ec1 with(LruCache<String, me> lruCache) {
        cs1.e(!this.a, "MemCacheBuilder has been built, not allow with() now");
        cs1.c(lruCache);
        this.b = lruCache;
        return this;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            super.finalize();
            ComponentCallbacks2 componentCallbacks2 = this.f;
            if (componentCallbacks2 != null) {
                this.c.unregisterComponentCallbacks(componentCallbacks2);
            }
        } catch (Throwable unused) {
            if (this.f != null) {
                this.c.unregisterComponentCallbacks(this.f);
            }
        }
    }
}
