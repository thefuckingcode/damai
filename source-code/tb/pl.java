package tb;

import android.os.Handler;
import android.util.LruCache;
import com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure;
import com.taobao.android.dinamicx.videoc.expose.core.IExposure;
import com.taobao.android.dinamicx.videoc.expose.core.listener.OnAfterCancelDataExposeListener;
import com.taobao.android.dinamicx.videoc.expose.core.listener.OnBeforeDataExposeListener;
import com.taobao.android.dinamicx.videoc.expose.core.listener.OnDataExposeListener;
import com.taobao.android.dinamicx.videoc.expose.core.listener.OnValidateExposeDataListener;
import java.util.Map;

/* compiled from: Taobao */
public class pl<ExposeKey, ExposeData> extends AbstractExposure<ExposeKey, ExposeData> {
    private final OnBeforeDataExposeListener<ExposeKey, ExposeData> e;
    private final OnValidateExposeDataListener<ExposeKey, ExposeData> f;
    private final OnDataExposeListener<ExposeKey, ExposeData> g;
    private final OnAfterCancelDataExposeListener<ExposeKey, ExposeData> h;
    private final long i;
    private final Handler j;
    private final int k;
    private final LruCache<ExposeKey, AbstractExposure.a<ExposeData>> l;

    /* compiled from: Taobao */
    public static class a<ExposeKey, ExposeData> implements IExposure.Builder<ExposeKey, ExposeData> {
        private OnBeforeDataExposeListener<ExposeKey, ExposeData> a;
        private OnValidateExposeDataListener<ExposeKey, ExposeData> b;
        private OnDataExposeListener<ExposeKey, ExposeData> c;
        private OnAfterCancelDataExposeListener<ExposeKey, ExposeData> d;
        private long e;
        private Handler f;
        private int g;
        private LruCache<ExposeKey, AbstractExposure.a<ExposeData>> h;

        /* renamed from: a */
        public pl<ExposeKey, ExposeData> build() {
            return new pl<>(this.b, this.a, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public a<ExposeKey, ExposeData> b(LruCache<ExposeKey, AbstractExposure.a<ExposeData>> lruCache) {
            this.h = lruCache;
            return this;
        }

        public a<ExposeKey, ExposeData> c(long j) {
            this.e = j;
            return this;
        }

        public a<ExposeKey, ExposeData> d(Handler handler) {
            this.f = handler;
            return this;
        }

        public a<ExposeKey, ExposeData> e(OnAfterCancelDataExposeListener<ExposeKey, ExposeData> onAfterCancelDataExposeListener) {
            this.d = onAfterCancelDataExposeListener;
            return this;
        }

        public a<ExposeKey, ExposeData> f(OnBeforeDataExposeListener<ExposeKey, ExposeData> onBeforeDataExposeListener) {
            this.a = onBeforeDataExposeListener;
            return this;
        }

        public a<ExposeKey, ExposeData> g(OnDataExposeListener<ExposeKey, ExposeData> onDataExposeListener) {
            this.c = onDataExposeListener;
            return this;
        }

        public a<ExposeKey, ExposeData> h(OnValidateExposeDataListener<ExposeKey, ExposeData> onValidateExposeDataListener) {
            this.b = onValidateExposeDataListener;
            return this;
        }
    }

    public pl(OnValidateExposeDataListener<ExposeKey, ExposeData> onValidateExposeDataListener, OnBeforeDataExposeListener<ExposeKey, ExposeData> onBeforeDataExposeListener, OnDataExposeListener<ExposeKey, ExposeData> onDataExposeListener, OnAfterCancelDataExposeListener<ExposeKey, ExposeData> onAfterCancelDataExposeListener, long j2, Handler handler, int i2, LruCache<ExposeKey, AbstractExposure.a<ExposeData>> lruCache) {
        this.e = onBeforeDataExposeListener;
        this.f = onValidateExposeDataListener;
        this.g = onDataExposeListener;
        this.h = onAfterCancelDataExposeListener;
        this.i = j2;
        this.j = handler;
        this.k = i2;
        this.l = lruCache;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    public int b() {
        int i2 = this.k;
        if (i2 > 0) {
            return i2;
        }
        return super.b();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    public LruCache<ExposeKey, AbstractExposure.a<ExposeData>> d() {
        LruCache<ExposeKey, AbstractExposure.a<ExposeData>> lruCache = this.l;
        if (lruCache != null) {
            return lruCache;
        }
        return super.d();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    public Handler e() {
        Handler handler = this.j;
        if (handler != null) {
            return handler;
        }
        return super.e();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    public long f() {
        long j2 = this.i;
        if (j2 > 0) {
            return j2;
        }
        return super.f();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    public void i(ExposeKey exposekey, ExposeData exposedata, String str) {
        OnAfterCancelDataExposeListener<ExposeKey, ExposeData> onAfterCancelDataExposeListener = this.h;
        if (onAfterCancelDataExposeListener != null) {
            onAfterCancelDataExposeListener.onAfterCancelDataExpose(exposekey, exposedata, str);
        } else {
            super.i(exposekey, exposedata, str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    public boolean j(ExposeKey exposekey, ExposeData exposedata, String str) {
        OnBeforeDataExposeListener<ExposeKey, ExposeData> onBeforeDataExposeListener = this.e;
        if (onBeforeDataExposeListener != null) {
            return onBeforeDataExposeListener.onBeforeExposeData(exposekey, exposedata, str);
        }
        return super.j(exposekey, exposedata, str);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    public void m(ExposeKey exposekey, ExposeData exposedata, String str) {
        OnDataExposeListener<ExposeKey, ExposeData> onDataExposeListener = this.g;
        if (onDataExposeListener != null) {
            onDataExposeListener.onDataExpose(exposekey, exposedata, str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.videoc.expose.core.AbstractExposure
    public boolean p(ExposeKey exposekey, ExposeData exposedata, String str, Map<ExposeKey, ExposeData> map) {
        OnValidateExposeDataListener<ExposeKey, ExposeData> onValidateExposeDataListener = this.f;
        if (onValidateExposeDataListener != null) {
            return onValidateExposeDataListener.onValidateExposeData(exposekey, exposedata, str, map);
        }
        return false;
    }
}
