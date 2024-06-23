package com.taobao.monitor.impl.data.lifecycle;

import com.taobao.application.common.IApmEventListener;
import com.taobao.application.common.impl.a;
import tb.k9;
import tb.u6;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class BackgroundForegroundEventImpl {
    private final k9 a = new k9();
    private final IApmEventListener b;
    private boolean c;
    private final Runnable d;
    private final Runnable e;

    BackgroundForegroundEventImpl() {
        new u6();
        this.b = a.g().b();
        this.c = false;
        this.d = new Runnable() {
            /* class com.taobao.monitor.impl.data.lifecycle.BackgroundForegroundEventImpl.AnonymousClass1 */

            public void run() {
                if (BackgroundForegroundEventImpl.this.c) {
                    BackgroundForegroundEventImpl.this.a.b(true);
                }
            }
        };
        this.e = new Runnable() {
            /* class com.taobao.monitor.impl.data.lifecycle.BackgroundForegroundEventImpl.AnonymousClass2 */

            public void run() {
                if (BackgroundForegroundEventImpl.this.c) {
                    BackgroundForegroundEventImpl.this.b.onEvent(50);
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.c = false;
        this.a.a(false);
        this.a.b(false);
        this.b.onEvent(2);
        a.g().getAsyncHandler().removeCallbacks(this.d);
        a.g().getAsyncHandler().removeCallbacks(this.e);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.c = true;
        this.a.a(true);
        this.b.onEvent(1);
        a.g().getAsyncHandler().postDelayed(this.d, 300000);
        a.g().getAsyncHandler().postDelayed(this.e, 10000);
    }
}
