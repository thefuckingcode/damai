package com.ali.user.open.core.webview;

/* compiled from: Taobao */
public interface IWebViewClient {
    void onPageFinished(String str);

    void onPageStarted(String str);

    void onReceivedTitle(String str);

    boolean shouldOverrideUrlLoading(String str);
}
