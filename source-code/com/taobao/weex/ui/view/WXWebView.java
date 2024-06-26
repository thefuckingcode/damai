package com.taobao.weex.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.ui.component.WXWeb;
import com.taobao.weex.ui.view.IWebView;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class WXWebView implements IWebView {
    private static final String BRIDGE_NAME = "__WEEX_WEB_VIEW_BRIDGE";
    private static final boolean DOWNGRADE_JS_INTERFACE;
    private static final int POST_MESSAGE = 1;
    private static final int SDK_VERSION;
    private Context mContext;
    private Handler mMessageHandler;
    private IWebView.OnErrorListener mOnErrorListener;
    private IWebView.OnMessageListener mOnMessageListener;
    private IWebView.OnPageListener mOnPageListener;
    private String mOrigin;
    private ProgressBar mProgressBar;
    private boolean mShowLoading = true;
    private WebView mWebView;

    /* compiled from: Taobao */
    private static class MessageHandler extends Handler {
        private final WeakReference<WXWebView> mWv;

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1 && this.mWv.get() != null && this.mWv.get().mOnMessageListener != null) {
                this.mWv.get().mOnMessageListener.onMessage((Map) message.obj);
            }
        }

        private MessageHandler(WXWebView wXWebView) {
            this.mWv = new WeakReference<>(wXWebView);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        SDK_VERSION = i;
        DOWNGRADE_JS_INTERFACE = i < 17;
    }

    public WXWebView(Context context, String str) {
        this.mContext = context;
        this.mOrigin = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void evaluateJS(String str) {
        if (SDK_VERSION < 19) {
            this.mWebView.loadUrl(str);
        } else {
            this.mWebView.evaluateJavascript(str, null);
        }
    }

    @Nullable
    private WebView getWebView() {
        return this.mWebView;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void initWebView(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setAllowFileAccess(false);
        webView.setWebViewClient(new WebViewClient() {
            /* class com.taobao.weex.ui.view.WXWebView.AnonymousClass1 */

            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                WXLogUtils.v("tag", "onPageFinished " + str);
                if (WXWebView.this.mOnPageListener != null) {
                    WXWebView.this.mOnPageListener.onPageFinish(str, webView.canGoBack(), webView.canGoForward());
                }
                if (WXWebView.this.mOnMessageListener != null) {
                    WXWebView wXWebView = WXWebView.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("javascript:(window.postMessage = function(message, targetOrigin) {if (message == null || !targetOrigin) return;");
                    sb.append(WXWebView.DOWNGRADE_JS_INTERFACE ? "prompt('__WEEX_WEB_VIEW_BRIDGE://postMessage?message=' + JSON.stringify(message) + '&targetOrigin=' + targetOrigin)" : "__WEEX_WEB_VIEW_BRIDGE.postMessage(JSON.stringify(message), targetOrigin);");
                    sb.append("})");
                    wXWebView.evaluateJS(sb.toString());
                }
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                WXLogUtils.v("tag", "onPageStarted " + str);
                if (WXWebView.this.mOnPageListener != null) {
                    WXWebView.this.mOnPageListener.onPageStart(str);
                }
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (WXWebView.this.mOnErrorListener != null) {
                    WXWebView.this.mOnErrorListener.onError("error", "page error");
                }
            }

            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (WXWebView.this.mOnErrorListener != null) {
                    WXWebView.this.mOnErrorListener.onError("error", "http error");
                }
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                if (WXWebView.this.mOnErrorListener != null) {
                    WXWebView.this.mOnErrorListener.onError("error", "ssl error");
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                WXLogUtils.v("tag", "onPageOverride " + str);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            /* class com.taobao.weex.ui.view.WXWebView.AnonymousClass2 */

            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                Uri parse = Uri.parse(str2);
                if (!TextUtils.equals(parse.getScheme(), WXWebView.BRIDGE_NAME)) {
                    return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                }
                if (TextUtils.equals(parse.getAuthority(), WXWeb.POST_MESSAGE)) {
                    WXWebView.this.onMessage(parse.getQueryParameter("message"), parse.getQueryParameter("targetOrigin"));
                    jsPromptResult.confirm("success");
                    return true;
                }
                jsPromptResult.confirm("fail");
                return true;
            }

            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                boolean z = true;
                WXWebView.this.showWebView(i == 100);
                WXWebView wXWebView = WXWebView.this;
                if (i == 100) {
                    z = false;
                }
                wXWebView.showProgressBar(z);
                WXLogUtils.v("tag", "onPageProgressChanged " + i);
            }

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (WXWebView.this.mOnPageListener != null) {
                    WXWebView.this.mOnPageListener.onReceivedTitle(webView.getTitle());
                }
            }
        });
        if (!DOWNGRADE_JS_INTERFACE) {
            webView.addJavascriptInterface(new Object() {
                /* class com.taobao.weex.ui.view.WXWebView.AnonymousClass3 */

                @JavascriptInterface
                public void postMessage(String str, String str2) {
                    WXWebView.this.onMessage(str, str2);
                }
            }, BRIDGE_NAME);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onMessage(String str, String str2) {
        if (str != null && str2 != null && this.mOnMessageListener != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("data", JSON.parse(str));
                hashMap.put("origin", str2);
                hashMap.put("type", "message");
                Message message = new Message();
                message.what = 1;
                message.obj = hashMap;
                this.mMessageHandler.sendMessage(message);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showProgressBar(boolean z) {
        if (this.mShowLoading) {
            this.mProgressBar.setVisibility(z ? 0 : 8);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showWebView(boolean z) {
        this.mWebView.setVisibility(z ? 0 : 4);
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void destroy() {
        if (getWebView() != null) {
            getWebView().removeAllViews();
            getWebView().destroy();
            this.mWebView = null;
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public View getView() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setBackgroundColor(-1);
        this.mWebView = new WebView(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.mWebView.setLayoutParams(layoutParams);
        frameLayout.addView(this.mWebView);
        initWebView(this.mWebView);
        this.mProgressBar = new ProgressBar(this.mContext);
        showProgressBar(false);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        this.mProgressBar.setLayoutParams(layoutParams2);
        layoutParams2.gravity = 17;
        frameLayout.addView(this.mProgressBar);
        this.mMessageHandler = new MessageHandler();
        return frameLayout;
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void goBack() {
        if (getWebView() != null) {
            getWebView().goBack();
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void goForward() {
        if (getWebView() != null) {
            getWebView().goForward();
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void loadDataWithBaseURL(String str) {
        if (getWebView() != null) {
            getWebView().loadDataWithBaseURL(this.mOrigin, str, "text/html", "utf-8", null);
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void loadUrl(String str) {
        if (getWebView() != null) {
            getWebView().loadUrl(str);
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void postMessage(Object obj) {
        if (getWebView() != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", (Object) "message");
                jSONObject.put("data", obj);
                jSONObject.put("origin", (Object) this.mOrigin);
                evaluateJS("javascript:(function () {var initData = " + jSONObject.toString() + ";" + "try {" + "var event = new MessageEvent('message', initData);" + "window.dispatchEvent(event);" + "} catch (e) {}" + "})();");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void reload() {
        if (getWebView() != null) {
            getWebView().reload();
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void setOnErrorListener(IWebView.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void setOnMessageListener(IWebView.OnMessageListener onMessageListener) {
        this.mOnMessageListener = onMessageListener;
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void setOnPageListener(IWebView.OnPageListener onPageListener) {
        this.mOnPageListener = onPageListener;
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void setShowLoading(boolean z) {
        this.mShowLoading = z;
    }
}
