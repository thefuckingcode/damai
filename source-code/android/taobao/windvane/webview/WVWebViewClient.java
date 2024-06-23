package android.taobao.windvane.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.cache.WVMemoryCache;
import android.taobao.windvane.cache.WVMemoryCacheInfo;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.config.WVURLConfig;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jspatch.WVJsPatch;
import android.taobao.windvane.monitor.WVErrorMonitorInterface;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.urlintercept.WVURLInterceptService;
import android.taobao.windvane.util.DigestUtils;
import android.taobao.windvane.util.MimeTypeEnum;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import tb.jl1;

/* compiled from: Taobao */
public class WVWebViewClient extends WebViewClient {
    private static final String TAG = "WVWebViewClient";
    private String currentUrl = null;
    public WebViewClient extraWebViewClient = null;
    boolean isError;
    protected Context mContext;
    private long mPageFinshTime = 0;

    public WVWebViewClient(Context context) {
        this.mContext = context;
    }

    public void onPageFinished(WebView webView, final String str) {
        TaoLog.i(TAG, "onPageFinished : " + str);
        this.mPageFinshTime = System.currentTimeMillis();
        if (!this.isError && webView.getVisibility() == 4) {
            this.isError = false;
            webView.setVisibility(0);
        }
        super.onPageFinished(webView, str);
        if (webView instanceof WVWebView) {
            ((WVWebView) webView).setCurrentUrl(str, "onPageFinished");
        }
        if (webView instanceof IWVWebView) {
            IWVWebView iWVWebView = (IWVWebView) webView;
            WVEventService.getInstance().onEvent(1002, iWVWebView, str, new Object[0]);
            WVJsPatch.getInstance().execute(iWVWebView, str);
        }
        final WVWebView wVWebView = (WVWebView) webView;
        if (TaoLog.getLogStatus()) {
            TaoLog.v(TAG, "Page finish: " + str);
        }
        wVWebView.onMessage(401, null);
        wVWebView.fireEvent("WindVaneReady", String.format("{'version':'%s'}", GlobalConfig.VERSION));
        wVWebView.evaluateJavascript("(function(p){if(!p||!p.timing)return;var t=p.timing,s=t.navigationStart,sc=t.secureConnectionStart,dc=t.domComplete,lee=t.loadEventEnd;return JSON.stringify({dns:t.domainLookupEnd-t.domainLookupStart,c:t.connectEnd-t.connectStart,scs:sc>0?sc-s:0,req:t.requestStart-s,rps:t.responseStart-s,rpe:t.responseEnd-s,dl:t.domLoading-s,dcl:t.domContentLoadedEventEnd-s,dc:dc>0?dc-s:0,lee:lee>0?lee-s:0})})(window.performance)", new ValueCallback<String>() {
            /* class android.taobao.windvane.webview.WVWebViewClient.AnonymousClass1 */

            public void onReceiveValue(String str) {
                if (WVMonitorService.getPerformanceMonitor() != null) {
                    WVMonitorService.getPerformanceMonitor().didPagePerformanceInfo(str, str);
                    WVMonitorService.getPerformanceMonitor().didPageFinishLoadAtTime(str, WVWebViewClient.this.mPageFinshTime);
                }
            }
        });
        wVWebView.evaluateJavascript("javascript:(function(f){if(f.__windvane__.call) return true; else return false})(window)", new ValueCallback<String>() {
            /* class android.taobao.windvane.webview.WVWebViewClient.AnonymousClass2 */

            public void onReceiveValue(String str) {
                TaoLog.i("WVJsBridge", "has windvane :" + str);
                if ("false".equals(str)) {
                    wVWebView.loadUrl("javascript:(function(f){try{if(f.__windvane__.nativeCall&&!f.__windvane__.call){var h=f.__windvane__||(f.__windvane__={});var c=\"wvapi:\"+(Math.floor(Math.random()*(1<<16))),a=0,b={},g=function(j){if(j&&typeof j==\"string\"){try{return JSON.parse(j)}catch(i){return{ret:\"HY_RESULT_PARSE_ERROR\"}}}else{return j||{}}};h.call=function(i,m,l,e,k){if(typeof l!=\"function\"){l=null}if(typeof e!=\"function\"){e=null}var j=c+(a++);b[j]={s:l,f:e,};if(k>0){b[j].t=setTimeout(function(){h.onFailure(j,{ret:\"HY_TIMEOUT\"})},k)}if(!m){m={}}if(typeof m!=\"string\"){m=JSON.stringify(m)}f.__windvane__.nativeCall(i,m,j,location.href)};h.find=function(i,j){var e=b[i]||{};if(e.t){clearTimeout(e.t);delete e.t}if(!j){delete b[i]}return e};h.onSuccess=function(j,e,k){var i=h.find(j,k).s;if(i){i(g(e))}};h.onFailure=function(j,e){var i=h.find(j,false).f;if(i){i(g(e))}}}}catch(d){}})(window);");
                }
            }
        });
        WebViewClient webViewClient = this.extraWebViewClient;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.isError = false;
        if (webView instanceof IWVWebView) {
            WVEventService.getInstance().onEvent(1001, (IWVWebView) webView, str, bitmap);
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.i(TAG, "onPageStarted : " + str);
        }
        this.currentUrl = str;
        ((WVWebView) webView).onMessage(400, null);
        if (WVMonitorService.getPerformanceMonitor() != null) {
            WVMonitorService.getPerformanceMonitor().didPageStartLoadAtTime(str, System.currentTimeMillis());
        }
        WVJsBridge.getInstance().tryToRunTailBridges();
        WebViewClient webViewClient = this.extraWebViewClient;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "Receive error, code: " + i + "; desc: " + str + "; url: " + str2);
        }
        if (webView instanceof IWVWebView) {
            if (WVEventService.getInstance().onEvent(1005, (IWVWebView) webView, str2, Integer.valueOf(i), str, str2).isSuccess) {
                return;
            }
        }
        String url = webView.getUrl();
        if (url == null || url.equals(str2)) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("cause", str + " [" + i + jl1.ARRAY_END_STR);
            hashMap.put("url", str2);
            ((WVWebView) webView).onMessage(402, hashMap);
            this.isError = true;
            webView.setVisibility(4);
        }
        if (WVMonitorService.getErrorMonitor() != null) {
            WVErrorMonitorInterface errorMonitor = WVMonitorService.getErrorMonitor();
            if (url == null) {
                url = str2;
            }
            errorMonitor.didOccurNativeError(url, i, str);
        }
        WebViewClient webViewClient = this.extraWebViewClient;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, i, str, str2);
        }
    }

    @SuppressLint({"NewApi"})
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String sslError2 = sslError.toString();
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "onReceivedSslError  url: " + sslError.getUrl() + "errorMsg:" + sslError2);
        }
        String url = webView.getUrl();
        if (webView instanceof IWVWebView) {
            WVEventService.getInstance().onEvent(1006, (IWVWebView) webView, url, sslError2);
        }
        if (WVMonitorService.getErrorMonitor() != null) {
            WVMonitorService.getErrorMonitor().didOccurNativeError(url, 1006, sslError2);
        }
        WebViewClient webViewClient = this.extraWebViewClient;
        if (webViewClient != null) {
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f8 A[SYNTHETIC, Splitter:B:42:0x00f8] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0142  */
    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WVMemoryCacheInfo memoryCacheByUrl;
        FileInputStream fileInputStream;
        Object obj;
        if (webView instanceof IWVWebView) {
            WVEventResult onEvent = WVEventService.getInstance().onEvent(1004, (IWVWebView) webView, str, 2);
            if (onEvent.isSuccess && (obj = onEvent.resultObj) != null && (obj instanceof WVWrapWebResourceResponse)) {
                WVWrapWebResourceResponse wVWrapWebResourceResponse = (WVWrapWebResourceResponse) obj;
                if (TaoLog.getLogStatus()) {
                    TaoLog.d(TAG, "预加载命中 : " + str);
                }
                WebResourceResponse webResourceResponse = new WebResourceResponse(wVWrapWebResourceResponse.mMimeType, wVWrapWebResourceResponse.mEncoding, wVWrapWebResourceResponse.mInputStream);
                if (Build.VERSION.SDK_INT >= 21) {
                    if (wVWrapWebResourceResponse.mHeaders != null) {
                        try {
                            if (!WVServerConfig.isAllowAccess(str) || wVWrapWebResourceResponse.mHeaders.containsKey("Access-Control-Allow-Origin")) {
                                webResourceResponse.setResponseHeaders(wVWrapWebResourceResponse.mHeaders);
                            } else {
                                HashMap hashMap = new HashMap();
                                hashMap.putAll(wVWrapWebResourceResponse.mHeaders);
                                hashMap.put("Access-Control-Allow-Origin", jl1.MUL);
                                webResourceResponse.setResponseHeaders(hashMap);
                                TaoLog.w(TAG, "add cross origin header");
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } else if (WVServerConfig.isAllowAccess(str)) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("Access-Control-Allow-Origin", jl1.MUL);
                        webResourceResponse.setResponseHeaders(hashMap2);
                    }
                }
                return webResourceResponse;
            }
        }
        WebResourceResponse webResourceResponse2 = null;
        if (WVCacheManager.getInstance().isCacheEnabled(str)) {
            String removeScheme = WVUrlUtil.removeScheme(str);
            try {
                fileInputStream = new FileInputStream(new File(WVCacheManager.getInstance().getCacheDir(true) + File.separator + DigestUtils.md5ToHex(removeScheme)));
                try {
                    WebResourceResponse webResourceResponse3 = new WebResourceResponse("image/png", "UTF-8", fileInputStream);
                    if (Build.VERSION.SDK_INT >= 21) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("Access-Control-Allow-Origin", jl1.MUL);
                        webResourceResponse3.setResponseHeaders(hashMap3);
                    }
                    return webResourceResponse3;
                } catch (Exception unused) {
                    if (fileInputStream != null) {
                    }
                    memoryCacheByUrl = WVMemoryCache.getInstance().getMemoryCacheByUrl(str);
                    if (memoryCacheByUrl != null) {
                    }
                }
            } catch (Exception unused2) {
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                memoryCacheByUrl = WVMemoryCache.getInstance().getMemoryCacheByUrl(str);
                if (memoryCacheByUrl != null) {
                }
            }
        }
        memoryCacheByUrl = WVMemoryCache.getInstance().getMemoryCacheByUrl(str);
        if (memoryCacheByUrl != null) {
            if (System.currentTimeMillis() - memoryCacheByUrl.cachedTime < 2000) {
                webResourceResponse2 = new WebResourceResponse(MimeTypeEnum.HTML.getMimeType(), "UTF-8", new ByteArrayInputStream(memoryCacheByUrl.mCachedDatas));
            }
            WVMemoryCache.getInstance().clearCacheByUrl(str);
            TaoLog.i(TAG, "WVMemoryCacheInfo 命中 : " + str);
            return webResourceResponse2;
        }
        TaoLog.i(TAG, "shouldInterceptRequest : " + str);
        if (WVMonitorService.getPerformanceMonitor() != null) {
            WVMonitorService.getPerformanceMonitor().didGetResourceStatusCode(str, 0, 1, null, null);
        }
        WebViewClient webViewClient = this.extraWebViewClient;
        if (webViewClient != null) {
            return webViewClient.shouldInterceptRequest(webView, str);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!WVUrlUtil.isCommonUrl(str) || !WVServerConfig.isBlackUrl(str, (IWVWebView) webView)) {
            IWVWebView iWVWebView = (IWVWebView) webView;
            if (WVURLFilter.doFilter(str, this.mContext, iWVWebView)) {
                TaoLog.e(TAG, "shouldOverrideUrlLoading filter url=" + str);
                return true;
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.v(TAG, "shouldOverrideUrlLoading: " + str);
            }
            if ((webView instanceof IWVWebView) && WVEventService.getInstance().onEvent(1003, iWVWebView, str, new Object[0]).isSuccess) {
                return true;
            }
            if (str.startsWith("mailto:") || str.startsWith("tel:")) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(268435456);
                    this.mContext.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    TaoLog.e(TAG, "shouldOverrideUrlLoading: ActivityNotFoundException, url=" + str);
                }
                return true;
            }
            try {
                if ((webView instanceof IWVWebView) && WVURLInterceptService.getWVURLIntercepter() != null && WVURLInterceptService.getWVURLIntercepter().isOpenURLIntercept()) {
                    if (WVURLInterceptService.getWVURLIntercepter().isNeedupdateURLRule(false)) {
                        WVURLInterceptService.getWVURLIntercepter().updateURLRule();
                    }
                    if (WVURLInterceptService.getWVURLIntercepter().shouldOverrideUrlLoading(this.mContext, (IWVWebView) webView, str)) {
                        if (TaoLog.getLogStatus()) {
                            TaoLog.v(TAG, "intercept url: " + str);
                        }
                        return true;
                    }
                }
            } catch (Exception e) {
                TaoLog.e(TAG, "shouldOverrideUrlLoading: doFilter error, " + e.getMessage());
            }
            if (WVURLInterceptService.getWVABTestHandler() != null && WVUrlUtil.shouldTryABTest(str)) {
                String aBTestUrl = WVURLInterceptService.getWVABTestHandler().toABTestUrl(str);
                if (!TextUtils.isEmpty(aBTestUrl) && !aBTestUrl.equals(str)) {
                    TaoLog.i(TAG, str + " abTestUrl to : " + aBTestUrl);
                    webView.loadUrl(aBTestUrl);
                    return true;
                }
            }
            if (webView instanceof WVWebView) {
                ((WVWebView) webView).setCurrentUrl(str, "shouldOverrideUrlLoading");
            }
            TaoLog.i(TAG, "shouldOverrideUrlLoading : " + str);
            WebViewClient webViewClient = this.extraWebViewClient;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, str);
            }
            return false;
        }
        String forbiddenDomainRedirectURL = WVURLConfig.getInstance().getForbiddenDomainRedirectURL();
        if (TextUtils.isEmpty(forbiddenDomainRedirectURL)) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("cause", "ACCESS_FORBIDDEN");
            hashMap.put("url", str);
            ((WVWebView) webView).onMessage(402, hashMap);
        } else {
            webView.loadUrl(forbiddenDomainRedirectURL);
        }
        return true;
    }
}
