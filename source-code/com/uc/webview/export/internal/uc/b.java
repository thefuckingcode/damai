package com.uc.webview.export.internal.uc;

import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.a;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
public final class b extends a {
    static Runnable f = new c();

    @Override // com.uc.webview.export.internal.a
    public final void a(int i, int i2) {
        UCMobileWebKit uCMobileWebKit;
        if (a.b != i || a.c != i2) {
            if (!SDKFactory.f && (uCMobileWebKit = SDKFactory.d) != null) {
                uCMobileWebKit.onWindowSizeChanged();
            }
            a.b = i;
            a.c = i2;
        }
    }

    @Override // com.uc.webview.export.internal.a
    public final void b(IWebView iWebView) {
        a.a.remove(iWebView);
        if (a.a.isEmpty()) {
            if (IWaStat.WaStat.getPrintLogEnable()) {
                Log.d("SDKWaStat", "WebViewDetector:destroy");
            }
            IWaStat.WaStat.saveData(true);
        }
    }

    @Override // com.uc.webview.export.internal.a
    public final void a(IWebView iWebView, int i) {
        UCMobileWebKit uCMobileWebKit;
        Log.d("WebViewDetector", "onWindowVisibilityChanged: " + i);
        iWebView.notifyForegroundChanged(i == 0);
        if (i == 0) {
            if (a.d != 1) {
                if (!SDKFactory.f && (uCMobileWebKit = SDKFactory.d) != null) {
                    uCMobileWebKit.onResume();
                }
                Log.d("WebViewDetector", "WebViewDetector:onResume");
                a.d = 1;
            }
        } else if (a.d == 1) {
            a.e.removeCallbacks(f);
            a.e.post(f);
        }
    }
}
