package com.uc.webview.export.internal.setup;

import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.internal.utility.d;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ah implements Runnable {
    final /* synthetic */ Throwable a;

    ah(Throwable th) {
        this.a = th;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
    public final void run() {
        Thread.sleep(1000);
        try {
            d.a(af.c(this.a));
        } catch (Throwable th) {
            Log.rInfo("SetupController", "generateCustomeLogInfo falied", th);
        }
    }
}
