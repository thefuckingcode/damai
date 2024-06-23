package tb;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.taobao.phenix.builder.Builder;
import com.taobao.tcommon.core.BytesPool;

/* compiled from: Taobao */
public class ae implements Builder<BytesPool> {
    private BytesPool a;
    private Integer b;
    private boolean c;
    private ComponentCallbacks2 d;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements ComponentCallbacks2 {
        final /* synthetic */ BytesPool a;

        a(BytesPool bytesPool) {
            this.a = bytesPool;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            vr2.a("BytesPool", "ComponentCallbacks2 onTrimMemory, level=%d", Integer.valueOf(i));
            if (i >= 60) {
                this.a.clear();
                vr2.i("BytesPool", "clear all at TRIM_MEMORY_MODERATE", new Object[0]);
            }
        }
    }

    private BytesPool b(BytesPool bytesPool) {
        Context applicationContext = tp1.o().applicationContext();
        if (applicationContext != null && Build.VERSION.SDK_INT >= 14) {
            a aVar = new a(bytesPool);
            this.d = aVar;
            applicationContext.registerComponentCallbacks(aVar);
        }
        return bytesPool;
    }

    /* renamed from: a */
    public synchronized BytesPool build() {
        if (this.c) {
            return this.a;
        }
        this.c = true;
        BytesPool bytesPool = this.a;
        if (bytesPool == null) {
            Integer num = this.b;
            this.a = new o71(num != null ? num.intValue() : 1048576);
        } else {
            Integer num2 = this.b;
            if (num2 != null) {
                bytesPool.resize(num2.intValue());
            }
        }
        return b(this.a);
    }

    /* renamed from: c */
    public ae with(BytesPool bytesPool) {
        cs1.e(!this.c, "BytesPoolBuilder has been built, not allow with() now");
        this.a = bytesPool;
        return this;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        Context applicationContext;
        ComponentCallbacks2 componentCallbacks2;
        try {
            super.finalize();
            applicationContext = tp1.o().applicationContext();
            if (applicationContext == null || (componentCallbacks2 = this.d) == null) {
                return;
            }
        } catch (Throwable unused) {
            applicationContext = tp1.o().applicationContext();
            if (applicationContext == null || (componentCallbacks2 = this.d) == null) {
                return;
            }
        }
        applicationContext.unregisterComponentCallbacks(componentCallbacks2);
    }
}
