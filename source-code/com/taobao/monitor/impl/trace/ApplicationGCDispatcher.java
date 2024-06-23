package com.taobao.monitor.impl.trace;

import com.taobao.monitor.impl.trace.AbsDispatcher;

/* compiled from: Taobao */
public class ApplicationGCDispatcher extends AbsDispatcher<ApplicationGCListener> {

    /* compiled from: Taobao */
    public interface ApplicationGCListener {
        void gc();
    }

    /* compiled from: Taobao */
    class a implements AbsDispatcher.ListenerCaller<ApplicationGCListener> {
        a(ApplicationGCDispatcher applicationGCDispatcher) {
        }

        /* renamed from: a */
        public void callListener(ApplicationGCListener applicationGCListener) {
            applicationGCListener.gc();
        }
    }

    public void f() {
        c(new a(this));
    }
}
