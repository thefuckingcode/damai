package android.taobao.windvane.service;

import android.content.Context;
import android.taobao.windvane.webview.IWVWebView;

/* compiled from: Taobao */
public class WVEventContext {
    public Context context = null;
    public String url = null;
    public IWVWebView webView = null;

    public WVEventContext() {
    }

    public WVEventContext(IWVWebView iWVWebView, String str) {
        this.webView = iWVWebView;
        this.url = str;
    }
}
