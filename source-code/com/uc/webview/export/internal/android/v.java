package com.uc.webview.export.internal.android;

import com.uc.webview.export.internal.a;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
public final class v extends a {
    Runnable f = new w(this);

    @Override // com.uc.webview.export.internal.a
    public final void a(IWebView iWebView, int i) {
        if (i == 0) {
            if (a.d != 1) {
                a.d = 1;
            }
        } else if (a.d == 1) {
            a.e.removeCallbacks(this.f);
            a.e.post(this.f);
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
}
