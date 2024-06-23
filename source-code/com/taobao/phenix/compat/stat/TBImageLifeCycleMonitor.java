package com.taobao.phenix.compat.stat;

import com.taobao.phenix.lifecycle.IPhenixLifeCycle;
import java.util.Map;
import tb.aq1;
import tb.qk2;

/* compiled from: Taobao */
public class TBImageLifeCycleMonitor implements IPhenixLifeCycle {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final TBImageLifeCycleMonitor a = new TBImageLifeCycleMonitor();
    }

    public static TBImageLifeCycleMonitor a() {
        return a.a;
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onCancel(final String str, final String str2, final Map<String, Object> map) {
        qk2.a(new Runnable() {
            /* class com.taobao.phenix.compat.stat.TBImageLifeCycleMonitor.AnonymousClass3 */

            public void run() {
                aq1.b().onCancel(str, str2, map);
            }
        });
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onError(final String str, final String str2, final Map<String, Object> map) {
        qk2.a(new Runnable() {
            /* class com.taobao.phenix.compat.stat.TBImageLifeCycleMonitor.AnonymousClass2 */

            public void run() {
                aq1.b().onError(str, str2, map);
            }
        });
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onEvent(final String str, final String str2, final Map<String, Object> map) {
        qk2.a(new Runnable() {
            /* class com.taobao.phenix.compat.stat.TBImageLifeCycleMonitor.AnonymousClass5 */

            public void run() {
                aq1.b().onEvent(str, str2, map);
            }
        });
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onFinished(final String str, final String str2, final Map<String, Object> map) {
        qk2.a(new Runnable() {
            /* class com.taobao.phenix.compat.stat.TBImageLifeCycleMonitor.AnonymousClass4 */

            public void run() {
                aq1.b().onFinished(str, str2, map);
            }
        });
    }

    @Override // com.taobao.phenix.lifecycle.IPhenixLifeCycle
    public void onRequest(final String str, final String str2, final Map<String, Object> map) {
        qk2.a(new Runnable() {
            /* class com.taobao.phenix.compat.stat.TBImageLifeCycleMonitor.AnonymousClass1 */

            public void run() {
                aq1.b().onRequest(str, str2, map);
            }
        });
    }
}
