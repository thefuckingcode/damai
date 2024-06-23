package com.uc.webview.export.internal.update;

import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.update.UpdateService;
import com.uc.webview.export.internal.update.b;
import java.io.File;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class i implements Runnable {
    final /* synthetic */ UpdateService a;
    final /* synthetic */ b.a b;

    i(b.a aVar, UpdateService updateService) {
        this.b = aVar;
        this.a = updateService;
    }

    public final void run() {
        try {
            File extractDir = this.a.getExtractDir();
            if (extractDir != null) {
                UCCyclone.recursiveDelete(extractDir, true, null);
            }
        } catch (Throwable unused) {
        }
    }
}
