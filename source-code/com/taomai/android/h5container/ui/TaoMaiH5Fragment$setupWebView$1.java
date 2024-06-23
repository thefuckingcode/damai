package com.taomai.android.h5container.ui;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taomai.android.h5container.webview.TaoMaiWebChromeClient;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.j91;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J$\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J2\u0010\u0016\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0017"}, d2 = {"com/taomai/android/h5container/ui/TaoMaiH5Fragment$setupWebView$1", "Lcom/taomai/android/h5container/webview/TaoMaiWebChromeClient;", "Landroid/webkit/WebView;", "view", "", "newProgress", "Ltb/ur2;", "onProgressChanged", "Landroid/view/View;", "requestedOrientation", "Landroid/webkit/WebChromeClient$CustomViewCallback;", WXBridgeManager.METHOD_CALLBACK, "onShowCustomView", "onHideCustomView", "webView", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "filePathCallback", "Landroid/webkit/WebChromeClient$FileChooserParams;", "fileChooserParams", "", "onShowFileChooser", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TaoMaiH5Fragment$setupWebView$1 extends TaoMaiWebChromeClient {
    final /* synthetic */ TaoMaiH5Fragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaoMaiH5Fragment$setupWebView$1(TaoMaiH5Fragment taoMaiH5Fragment, Context context) {
        super(context);
        this.this$0 = taoMaiH5Fragment;
    }

    public void onHideCustomView() {
        super.onHideCustomView();
        j91.a("Kian", "onHideCustomView");
        this.this$0.hideCustomView(true);
    }

    @Override // android.taobao.windvane.webview.WVWebChromeClient
    public void onProgressChanged(@Nullable WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.this$0.updateProgress(i);
    }

    public void onShowCustomView(@Nullable View view, int i, @Nullable WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, i, customViewCallback);
    }

    @Override // com.taomai.android.h5container.webview.TaoMaiWebChromeClient, android.webkit.WebChromeClient
    public boolean onShowFileChooser(@Nullable WebView webView, @Nullable ValueCallback<Uri[]> valueCallback, @Nullable WebChromeClient.FileChooserParams fileChooserParams) {
        TaoMaiH5Fragment.access$setFilePathCallback$p(this.this$0, valueCallback);
        return handleOnShowFileChooser(webView, valueCallback, fileChooserParams);
    }

    public void onShowCustomView(@Nullable View view, @Nullable WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
        this.this$0.showCustomView(view, customViewCallback);
    }
}
