package com.taobao.monitor.impl.data.gc;

import com.taobao.monitor.impl.trace.ApplicationGCDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import tb.b0;
import tb.i20;
import tb.qs0;

/* compiled from: Taobao */
class GCSignalSender {
    private static InnerRunnable a = new InnerRunnable();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class InnerRunnable implements Runnable {
        private InnerRunnable() {
        }

        public void run() {
            qs0.e().d().removeCallbacks(GCSignalSender.a);
            IDispatcher a = b0.a(b0.APPLICATION_GC_DISPATCHER);
            if (a instanceof ApplicationGCDispatcher) {
                ((ApplicationGCDispatcher) a).f();
            }
            i20.a("gc", new Object[0]);
        }
    }
}
