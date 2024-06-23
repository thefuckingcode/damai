package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.o;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

/* access modifiers changed from: package-private */
public class SystemWebViewClient extends WebViewClient {
    private static String c;
    private WebViewClient a;
    private WebView b;

    SystemWebViewClient(WebView webView, WebViewClient webViewClient) {
        this.b = webView;
        this.a = webViewClient;
    }

    public void onLoadResource(WebView webView, String str) {
        this.b.a(webView);
        this.a.onLoadResource(this.b, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null || this.b.showDebugView(str)) {
            return true;
        }
        this.b.a(webView);
        return this.a.shouldOverrideUrlLoading(this.b, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean z;
        String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (uri == null || this.b.showDebugView(uri)) {
            return true;
        }
        this.b.a(webView);
        if (Build.VERSION.SDK_INT >= 24) {
            Object a2 = k.a(webResourceRequest, "isRedirect");
            if (a2 instanceof Boolean) {
                z = ((Boolean) a2).booleanValue();
                return this.a.shouldOverrideUrlLoading(this.b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
            }
        }
        z = false;
        return this.a.shouldOverrideUrlLoading(this.b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest;
        if (Build.VERSION.SDK_INT >= 11 && (shouldInterceptRequest = this.a.shouldInterceptRequest(this.b, str)) != null) {
            return new WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        boolean z;
        com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest;
        if (Build.VERSION.SDK_INT < 21 || webResourceRequest == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Object a2 = k.a(webResourceRequest, "isRedirect");
            if (a2 instanceof Boolean) {
                z = ((Boolean) a2).booleanValue();
                shouldInterceptRequest = this.a.shouldInterceptRequest(this.b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
                if (shouldInterceptRequest != null) {
                    return null;
                }
                WebResourceResponse webResourceResponse = new WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
                webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
                int statusCode = shouldInterceptRequest.getStatusCode();
                String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
                if (statusCode != webResourceResponse.getStatusCode() || (reasonPhrase != null && !reasonPhrase.equals(webResourceResponse.getReasonPhrase()))) {
                    webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
                }
                return webResourceResponse;
            }
        }
        z = false;
        shouldInterceptRequest = this.a.shouldInterceptRequest(this.b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
        if (shouldInterceptRequest != null) {
        }
    }

    static class e implements com.tencent.smtt.export.external.interfaces.WebResourceRequest {
        private String a;
        private boolean b;
        private boolean c;
        private boolean d;
        private String e;
        private Map<String, String> f;

        public e(String str, boolean z, boolean z2, boolean z3, String str2, Map<String, String> map) {
            this.a = str;
            this.b = z;
            this.c = z2;
            this.d = z3;
            this.e = str2;
            this.f = map;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return Uri.parse(this.a);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.b;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            return this.c;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.d;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.e;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.f;
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.b.a(webView);
        return this.a.shouldOverrideKeyEvent(this.b, keyEvent);
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        this.b.a(webView);
        this.a.onFormResubmission(this.b, message, message2);
    }

    public void onPageFinished(WebView webView, String str) {
        o a2;
        if (c == null && (a2 = o.a()) != null) {
            a2.a(true);
            c = Boolean.toString(true);
        }
        this.b.a(webView);
        this.b.a++;
        this.a.onPageFinished(this.b, str);
        if (TbsConfig.APP_QZONE.equals(webView.getContext().getApplicationInfo().packageName)) {
            this.b.a(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.d();
        if (!TbsShareManager.mHasQueryed && this.b.getContext() != null && TbsShareManager.isThirdPartyApp(this.b.getContext())) {
            TbsShareManager.mHasQueryed = true;
            new Thread(new Runnable() {
                /* class com.tencent.smtt.sdk.SystemWebViewClient.AnonymousClass1 */

                public void run() {
                    if (!TbsShareManager.forceLoadX5FromTBSDemo(SystemWebViewClient.this.b.getContext()) && TbsDownloader.needDownload(SystemWebViewClient.this.b.getContext(), false)) {
                        TbsDownloader.startDownload(SystemWebViewClient.this.b.getContext());
                    }
                }
            }).start();
        }
        if (this.b.getContext() != null && !TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport()) {
            TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
            TbsLogReport.getInstance(this.b.getContext()).dailyReport();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.b.a(webView);
        this.a.onPageStarted(this.b, str, bitmap);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.b.a(webView);
        this.a.onReceivedError(this.b, i, str, str2);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        this.b.a(webView);
        AnonymousClass2 r2 = null;
        f fVar = webResourceRequest != null ? new f(webResourceRequest) : null;
        if (webResourceError != null) {
            r2 = new com.tencent.smtt.export.external.interfaces.WebResourceError() {
                /* class com.tencent.smtt.sdk.SystemWebViewClient.AnonymousClass2 */

                @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
                public CharSequence getDescription() {
                    return webResourceError.getDescription();
                }

                @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
                public int getErrorCode() {
                    return webResourceError.getErrorCode();
                }
            };
        }
        this.a.onReceivedError(this.b, fVar, r2);
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.b.a(webView);
        this.a.onReceivedHttpError(this.b, new f(webResourceRequest), new g(webResourceResponse));
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.b.a(webView);
        this.a.onReceivedHttpAuthRequest(this.b, new b(httpAuthHandler), str, str2);
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        this.b.a(webView);
        this.a.doUpdateVisitedHistory(this.b, str, z);
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT >= 12) {
            this.b.a(webView);
            this.a.onReceivedLoginRequest(this.b, str, str2, str3);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (Build.VERSION.SDK_INT >= 8) {
            this.b.a(webView);
            this.a.onReceivedSslError(this.b, new c(sslErrorHandler), new d(sslError));
        }
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.a(webView);
            this.a.onReceivedClientCertRequest(this.b, new a(clientCertRequest));
        }
    }

    private static class a extends com.tencent.smtt.export.external.interfaces.ClientCertRequest {
        private ClientCertRequest a;

        public a(ClientCertRequest clientCertRequest) {
            this.a = clientCertRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void cancel() {
            this.a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String getHost() {
            return this.a.getHost();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String[] getKeyTypes() {
            return this.a.getKeyTypes();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public int getPort() {
            return this.a.getPort();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public Principal[] getPrincipals() {
            return this.a.getPrincipals();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void ignore() {
            this.a.ignore();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            this.a.proceed(privateKey, x509CertificateArr);
        }
    }

    public void onScaleChanged(WebView webView, float f2, float f3) {
        this.b.a(webView);
        this.a.onScaleChanged(this.b, f2, f3);
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        this.b.a(webView);
        this.a.onTooManyRedirects(this.b, message, message2);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.b.a(webView);
        this.a.onUnhandledKeyEvent(this.b, keyEvent);
    }

    private static class b implements com.tencent.smtt.export.external.interfaces.HttpAuthHandler {
        private HttpAuthHandler a;

        b(HttpAuthHandler httpAuthHandler) {
            this.a = httpAuthHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void proceed(String str, String str2) {
            this.a.proceed(str, str2);
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void cancel() {
            this.a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public boolean useHttpAuthUsernamePassword() {
            return this.a.useHttpAuthUsernamePassword();
        }
    }

    private static class c implements com.tencent.smtt.export.external.interfaces.SslErrorHandler {
        SslErrorHandler a;

        c(SslErrorHandler sslErrorHandler) {
            this.a = sslErrorHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void proceed() {
            this.a.proceed();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void cancel() {
            this.a.cancel();
        }
    }

    private static class d implements com.tencent.smtt.export.external.interfaces.SslError {
        SslError a;

        d(SslError sslError) {
            this.a = sslError;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public SslCertificate getCertificate() {
            return this.a.getCertificate();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean addError(int i) {
            return this.a.addError(i);
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean hasError(int i) {
            return this.a.hasError(i);
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public int getPrimaryError() {
            return this.a.getPrimaryError();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public String getUrl() {
            return this.a.getUrl();
        }
    }

    private static class f implements com.tencent.smtt.export.external.interfaces.WebResourceRequest {
        WebResourceRequest a;

        f(WebResourceRequest webResourceRequest) {
            this.a = webResourceRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.a.getMethod();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.a.getRequestHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return this.a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.a.hasGesture();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.a.isForMainFrame();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            if (Build.VERSION.SDK_INT >= 24) {
                Object a2 = k.a(this.a, "isRedirect");
                if (a2 instanceof Boolean) {
                    return ((Boolean) a2).booleanValue();
                }
            }
            return false;
        }
    }

    private static class g extends com.tencent.smtt.export.external.interfaces.WebResourceResponse {
        WebResourceResponse a;

        public g(WebResourceResponse webResourceResponse) {
            this.a = webResourceResponse;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public InputStream getData() {
            return this.a.getData();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getEncoding() {
            return this.a.getEncoding();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getMimeType() {
            return this.a.getMimeType();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getReasonPhrase() {
            return this.a.getReasonPhrase();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public Map<String, String> getResponseHeaders() {
            return this.a.getResponseHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public int getStatusCode() {
            return this.a.getStatusCode();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setData(InputStream inputStream) {
            this.a.setData(inputStream);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setEncoding(String str) {
            this.a.setEncoding(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setMimeType(String str) {
            this.a.setMimeType(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setResponseHeaders(Map<String, String> map) {
            this.a.setResponseHeaders(map);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setStatusCodeAndReasonPhrase(int i, String str) {
            this.a.setStatusCodeAndReasonPhrase(i, str);
        }
    }

    public void onPageCommitVisible(WebView webView, String str) {
        this.b.a(webView);
        this.a.onPageCommitVisible(this.b, str);
    }
}
