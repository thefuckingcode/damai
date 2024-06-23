package com.youku.live.dsl.utils;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: Taobao */
public interface ILaifengWebViewBinderInterface {
    boolean bindWebView(WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient);

    boolean loadWebView(WebView webView, String str);
}
