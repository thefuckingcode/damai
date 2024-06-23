package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;
import com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.smtt.sdk.WebView;

/* compiled from: SmttWebChromeClient */
class f extends X5ProxyWebChromeClient {
    private WebView a;
    private WebChromeClient b;

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
    }

    public f(IX5WebChromeClient iX5WebChromeClient, WebView webView, WebChromeClient webChromeClient) {
        super(iX5WebChromeClient);
        this.a = webView;
        this.b = webChromeClient;
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        this.b.onExceededDatabaseQuota(str, str2, j, j2, j3, new a(quotaUpdater));
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return this.b.getDefaultVideoPoster();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onCloseWindow(IX5WebViewBase iX5WebViewBase) {
        this.a.a(iX5WebViewBase);
        this.b.onCloseWindow(this.a);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.b.onConsoleMessage(consoleMessage);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, final Message message) {
        WebView webView = this.a;
        webView.getClass();
        final WebView.WebViewTransport webViewTransport = new WebView.WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new Runnable() {
            /* class com.tencent.smtt.sdk.f.AnonymousClass1 */

            public void run() {
                WebView webView = webViewTransport.getWebView();
                if (webView != null) {
                    ((IX5WebViewBase.WebViewTransport) message.obj).setWebView(webView.c());
                }
                message.sendToTarget();
            }
        });
        obtain.obj = webViewTransport;
        return this.b.onCreateWindow(this.a, z, z2, obtain);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        this.b.onGeolocationPermissionsHidePrompt();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        this.b.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onHideCustomView() {
        this.b.onHideCustomView();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.a.a(iX5WebViewBase);
        return this.b.onJsAlert(this.a, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.a.a(iX5WebViewBase);
        return this.b.onJsConfirm(this.a, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        this.a.a(iX5WebViewBase);
        return this.b.onJsPrompt(this.a, str, str2, str3, jsPromptResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.a.a(iX5WebViewBase);
        return this.b.onJsBeforeUnload(this.a, str, str2, jsResult);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsTimeout() {
        return this.b.onJsTimeout();
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i) {
        this.a.a(iX5WebViewBase);
        this.b.onProgressChanged(this.a, i);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        this.b.onReachedMaxAppCacheSize(j, j2, new a(quotaUpdater));
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap) {
        this.a.a(iX5WebViewBase);
        this.b.onReceivedIcon(this.a, bitmap);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        this.a.a(iX5WebViewBase);
        this.b.onReceivedTouchIconUrl(this.a, str, z);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str) {
        this.a.a(iX5WebViewBase);
        this.b.onReceivedTitle(this.a, str);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onRequestFocus(IX5WebViewBase iX5WebViewBase) {
        this.a.a(iX5WebViewBase);
        this.b.onRequestFocus(this.a);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, customViewCallback);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onShowCustomView(View view, int i, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, i, customViewCallback);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void openFileChooser(final ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z) {
        this.b.openFileChooser(new ValueCallback<Uri>() {
            /* class com.tencent.smtt.sdk.f.AnonymousClass2 */

            /* renamed from: a */
            public void onReceiveValue(Uri uri) {
                valueCallback.onReceiveValue(new Uri[]{uri});
            }
        }, str, str2);
    }

    @Override // com.tencent.smtt.export.external.proxy.ProxyWebChromeClient, com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, final ValueCallback<Uri[]> valueCallback, final IX5WebChromeClient.FileChooserParams fileChooserParams) {
        AnonymousClass3 r0 = new ValueCallback<Uri[]>() {
            /* class com.tencent.smtt.sdk.f.AnonymousClass3 */

            /* renamed from: a */
            public void onReceiveValue(Uri[] uriArr) {
                valueCallback.onReceiveValue(uriArr);
            }
        };
        AnonymousClass4 r3 = new WebChromeClient.FileChooserParams() {
            /* class com.tencent.smtt.sdk.f.AnonymousClass4 */

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public int getMode() {
                return fileChooserParams.getMode();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String[] getAcceptTypes() {
                return fileChooserParams.getAcceptTypes();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public boolean isCaptureEnabled() {
                return fileChooserParams.isCaptureEnabled();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public CharSequence getTitle() {
                return fileChooserParams.getTitle();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String getFilenameHint() {
                return fileChooserParams.getFilenameHint();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public Intent createIntent() {
                return fileChooserParams.createIntent();
            }
        };
        this.a.a(iX5WebViewBase);
        return this.b.onShowFileChooser(this.a, r0, r3);
    }

    /* compiled from: SmttWebChromeClient */
    class a implements WebStorage.QuotaUpdater {
        QuotaUpdater a;

        a(QuotaUpdater quotaUpdater) {
            this.a = quotaUpdater;
        }

        @Override // com.tencent.smtt.sdk.WebStorage.QuotaUpdater
        public void updateQuota(long j) {
            this.a.updateQuota(j);
        }
    }
}
