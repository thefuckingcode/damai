package com.taobao.monitor.impl.trace;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import com.taobao.monitor.impl.trace.AbsDispatcher;
import tb.i20;
import tb.qs0;

/* compiled from: Taobao */
public class ApplicationLowMemoryDispatcher extends AbsDispatcher<LowMemoryListener> implements ComponentCallbacks {

    /* compiled from: Taobao */
    public interface LowMemoryListener {
        void onLowMemory();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements AbsDispatcher.ListenerCaller<LowMemoryListener> {
        a(ApplicationLowMemoryDispatcher applicationLowMemoryDispatcher) {
        }

        /* renamed from: a */
        public void callListener(LowMemoryListener lowMemoryListener) {
            lowMemoryListener.onLowMemory();
        }
    }

    public ApplicationLowMemoryDispatcher() {
        qs0.e().a().registerComponentCallbacks(this);
    }

    public void f() {
        c(new a(this));
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        i20.a("ApplicationLowMemory", "onLowMemory");
        f();
    }
}
