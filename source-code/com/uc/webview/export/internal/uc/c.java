package com.uc.webview.export.internal.uc;

import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.a;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.utility.Log;
import java.util.Iterator;

/* compiled from: Taobao */
final class c implements Runnable {
    c() {
    }

    public final void run() {
        UCMobileWebKit uCMobileWebKit;
        boolean z = false;
        try {
            Iterator it = a.a.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((IWebView) it.next()).getView().getWindowVisibility() == 0) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z && a.d == 1) {
                if (IWaStat.WaStat.getPrintLogEnable()) {
                    Log.d("WebViewDetector", "WebViewDetector:onPause");
                }
                IWaStat.WaStat.saveData();
                if (!SDKFactory.f && (uCMobileWebKit = SDKFactory.d) != null) {
                    uCMobileWebKit.onPause();
                }
                int unused = a.d = 0;
            }
        } catch (Throwable unused2) {
        }
    }
}
