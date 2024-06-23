package cn.damai.h5container;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.WebResourceError;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebView;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class DMH5Fragment$createWebViewClient$1 extends DmWebViewClient {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ DMH5Fragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DMH5Fragment$createWebViewClient$1(DMH5Fragment dMH5Fragment) {
        super(dMH5Fragment);
        this.this$0 = dMH5Fragment;
    }

    @Override // com.uc.webview.export.WebViewClient, cn.damai.h5container.DmWebViewClient, tb.bj2, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-763941222")) {
            ipChange.ipc$dispatch("-763941222", new Object[]{this, webView, str});
            return;
        }
        super.onPageFinished(webView, str);
        this.this$0.handleOnPageFinished(webView, str);
    }

    @Override // com.uc.webview.export.WebViewClient, cn.damai.h5container.DmWebViewClient, tb.bj2, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1464101321")) {
            ipChange.ipc$dispatch("-1464101321", new Object[]{this, webView, str, bitmap});
            return;
        }
        super.onPageStarted(webView, str, bitmap);
        this.this$0.handleOnPageStarted(webView, str, bitmap);
    }

    @Override // com.uc.webview.export.WebViewClient, cn.damai.h5container.DmWebViewClient, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public void onReceivedError(@Nullable WebView webView, int i, @Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1108421227")) {
            ipChange.ipc$dispatch("-1108421227", new Object[]{this, webView, Integer.valueOf(i), str, str2});
            return;
        }
        super.onReceivedError(webView, i, str, str2);
        this.this$0.handleOnReceivedError(webView, i, str, str2);
    }

    @Override // com.uc.webview.export.WebViewClient, cn.damai.h5container.DmWebViewClient
    public void onReceivedError(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest, @Nullable WebResourceError webResourceError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-595392887")) {
            ipChange.ipc$dispatch("-595392887", new Object[]{this, webView, webResourceRequest, webResourceError});
            return;
        }
        super.onReceivedError(this.this$0.getWebView(), webResourceRequest, webResourceError);
        this.this$0.handleOnReceivedError(webView, webResourceRequest, webResourceError);
    }
}
