package com.taomai.android.h5container.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVContextUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import kotlin.Metadata;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TaoMaiWebChromeClient$handleOnShowFileChooser$1 implements Runnable {
    final /* synthetic */ WebChromeClient.FileChooserParams $fileChooserParams;
    final /* synthetic */ WebView $webView;

    TaoMaiWebChromeClient$handleOnShowFileChooser$1(WebChromeClient.FileChooserParams fileChooserParams, WebView webView) {
        this.$fileChooserParams = fileChooserParams;
        this.$webView = webView;
    }

    public final void run() {
        TaoLog.d("TaoMaiWebChromeClient", " onShowFileChooser permission granted");
        Intent createIntent = this.$fileChooserParams.createIntent();
        WebView webView = this.$webView;
        k21.f(webView);
        Context realContext = WVContextUtil.getRealContext(webView.getContext());
        if (realContext instanceof Activity) {
            ((Activity) realContext).startActivityForResult(Intent.createChooser(createIntent, "choose"), 15);
        }
    }
}
