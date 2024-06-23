package com.uc.webview.export.internal;

import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.UCSetupException;

/* compiled from: Taobao */
final class c implements Runnable {
    c() {
    }

    public final void run() {
        while (true) {
            try {
                Runnable runnable = (Runnable) SDKFactory.b.a.poll();
                if (runnable != null) {
                    runnable.run();
                } else {
                    return;
                }
            } catch (Exception e) {
                SDKFactory.b.a.clear();
                UCSetupException unused = SDKFactory.b.b = new UCSetupException((int) GlobalErrorCode.ERROR_CTID_DATA_ERROR, e);
                return;
            }
        }
    }
}
