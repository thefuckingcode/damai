package com.taomai.android.h5container.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.alibaba.security.common.track.model.a;
import com.taomai.android.h5container.webview.TaoMaiWebClient;
import com.taomai.android.h5container.webview.TaoMaiWebView;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.text.o;
import org.jetbrains.annotations.Nullable;
import tb.im2;
import tb.j91;
import tb.jl1;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J.\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u0015\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0016"}, d2 = {"com/taomai/android/h5container/ui/TaoMaiH5Fragment$setupWebView$2", "Lcom/taomai/android/h5container/webview/TaoMaiWebClient;", "Landroid/webkit/WebView;", "view", "", "url", "Landroid/graphics/Bitmap;", "favicon", "Ltb/ur2;", "onPageStarted", "onPageFinished", "", "errorCode", SocialConstants.PARAM_COMMENT, "failingUrl", "onReceivedError", a.c.d, "Landroid/webkit/WebResourceRequest;", "webResourceRequest", "Landroid/webkit/WebResourceResponse;", "webResourceResponse", "onReceivedHttpError", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TaoMaiH5Fragment$setupWebView$2 extends TaoMaiWebClient {
    final /* synthetic */ TaoMaiH5Fragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaoMaiH5Fragment$setupWebView$2(TaoMaiH5Fragment taoMaiH5Fragment, Context context) {
        super(context);
        this.this$0 = taoMaiH5Fragment;
    }

    @Override // android.taobao.windvane.webview.WVWebViewClient
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        im2 access$getTransparentTitleHelper$p;
        super.onPageFinished(webView, str);
        TaoMaiH5Fragment.access$getRefreshLayout$p(this.this$0).setRefreshing(false);
        TaoMaiH5Fragment.access$setLoadSuccess$p(this.this$0, true);
        TaoMaiH5Fragment.access$setTitleIfNeed(this.this$0, webView != null ? webView.getTitle() : null);
        this.this$0.notifyProgressEnd();
        TaoMaiH5Fragment.access$hideLoading(this.this$0);
        TaoMaiH5Fragment.access$hideEmptyOrErrorView(this.this$0);
        if (!TaoMaiH5Fragment.access$getHasSetTransparentTitleFromBridge$p(this.this$0) && (access$getTransparentTitleHelper$p = TaoMaiH5Fragment.access$getTransparentTitleHelper$p(this.this$0)) != null) {
            access$getTransparentTitleHelper$p.j(null);
        }
        Function2<WebView, String, ur2> pageLoadFinishListener = this.this$0.getPageLoadFinishListener();
        if (pageLoadFinishListener != null) {
            pageLoadFinishListener.invoke(webView, str);
        }
    }

    @Override // android.taobao.windvane.webview.WVWebViewClient
    public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.this$0.setHookBackKey(false);
        TaoMaiH5Fragment.access$resetTitleStatus(this.this$0);
        TaoMaiH5Fragment.access$showLoading(this.this$0);
        this.this$0.showProgressIfEnable();
        TaoMaiH5Fragment.access$setLoadSuccess$p(this.this$0, false);
        Function3<WebView, String, Bitmap, ur2> pageLoadStartListener = this.this$0.getPageLoadStartListener();
        if (pageLoadStartListener != null) {
            pageLoadStartListener.invoke(webView, str, bitmap);
        }
    }

    @Override // android.taobao.windvane.webview.WVWebViewClient
    public void onReceivedError(@Nullable WebView webView, int i, @Nullable String str, @Nullable String str2) {
        super.onReceivedError(webView, i, str, str2);
        j91.b("TaoMaiH5Container", "H5Page load error: code:" + i + "   description:" + str + "   url:" + str2);
        TaoMaiH5Fragment.access$getRefreshLayout$p(this.this$0).setRefreshing(false);
        TaoMaiH5Fragment.access$hideLoading(this.this$0);
        TaoMaiH5Fragment.access$showEmptyOrErrorView(this.this$0);
        TaoMaiWebView webView2 = this.this$0.getWebView();
        k21.f(webView2);
        webView2.loadUrl("javascript:document.body.innerHTML=\"" + "" + jl1.QUOTE);
        Function4<WebView, Integer, String, String, ur2> pageLoadErrorListener = this.this$0.getPageLoadErrorListener();
        if (pageLoadErrorListener != null) {
            pageLoadErrorListener.invoke(webView, Integer.valueOf(i), str, str2);
        }
    }

    public void onReceivedHttpError(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest, @Nullable WebResourceResponse webResourceResponse) {
        Uri url;
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (k21.d((webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString(), TaoMaiH5Fragment.access$getUrl$p(this.this$0))) {
            String valueOf = String.valueOf(webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null);
            if ((o.L(valueOf, "4", false, 2, null)) || (o.L(valueOf, "5", false, 2, null))) {
                TaoMaiH5Fragment.access$getRefreshLayout$p(this.this$0).setRefreshing(false);
                TaoMaiH5Fragment.access$hideLoading(this.this$0);
                TaoMaiWebView webView2 = this.this$0.getWebView();
                k21.f(webView2);
                webView2.loadUrl("javascript:document.body.innerHTML=\"" + "" + jl1.QUOTE);
                TaoMaiH5Fragment.access$showEmptyOrErrorView(this.this$0);
            }
        }
    }
}
