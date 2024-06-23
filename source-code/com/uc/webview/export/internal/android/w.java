package com.uc.webview.export.internal.android;

import com.uc.webview.export.internal.a;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.utility.Log;
import java.util.Iterator;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class w implements Runnable {
    final /* synthetic */ v a;

    w(v vVar) {
        this.a = vVar;
    }

    public final void run() {
        boolean z;
        Iterator it = a.a.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((IWebView) it.next()).getView().getWindowVisibility() == 0) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z && a.d == 1) {
            if (IWaStat.WaStat.getPrintLogEnable()) {
                Log.d("SDKWaStat", "WebViewDetector:onPause");
            }
            IWaStat.WaStat.saveData();
            int unused = a.d = 0;
        }
    }
}
