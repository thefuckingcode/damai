package android.taobao.windvane.extra.uc;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.cache.WVMemoryCache;
import android.taobao.windvane.cache.WVMemoryCacheInfo;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.config.WVUCPrecacheManager;
import android.taobao.windvane.config.WVURLConfig;
import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jspatch.WVJsPatch;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.monitor.WVErrorMonitorInterface;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.urlintercept.WVURLInterceptService;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.DigestUtils;
import android.taobao.windvane.util.FullTraceUtils;
import android.taobao.windvane.util.MimeTypeEnum;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import android.taobao.windvane.webview.IFullTrace;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVURLFilter;
import android.taobao.windvane.webview.WVWrapWebResourceResponse;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.monitor.procedure.ViewToken;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.weaver.prefetch.WMLPrefetch;
import com.tencent.open.SocialConstants;
import com.uc.webview.export.SslErrorHandler;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;
import com.uc.webview.export.extension.RenderProcessGoneDetail;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.extension.UCExtension;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class WVUCWebViewClient extends WebViewClient {
    private static final String SANDBOX_TAG = "WVUCWebViewClient.sandbox";
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_SMS = "sms:";
    public static final String SCHEME_TEL = "tel:";
    private static final String TAG = "WVUCWebViewClient";
    public int crashCount = 0;
    boolean isError;
    protected WeakReference<Context> mContext;
    private Runnable mCrashCountReseter = new Runnable() {
        /* class android.taobao.windvane.extra.uc.WVUCWebViewClient.AnonymousClass5 */

        public void run() {
            TaoLog.e(WVUCWebViewClient.SANDBOX_TAG, "crash count reset - " + WVUCWebViewClient.this.crashCount);
            WVUCWebViewClient.this.crashCount = 0;
        }
    };
    private Handler mRenderProcessHandler;
    private boolean useOldBridge = false;

    public WVUCWebViewClient(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    public static String getMetaDataScript() {
        String[] strArr = {"WV.Meta.Performance.JSFSP"};
        String str = "(function(){var d=document,r={}";
        String str2 = "";
        for (int i = 0; i < 1; i++) {
            str = str + String.format(",n%d='%s',e%d=d.getElementById(n%d)", Integer.valueOf(i), strArr[i], Integer.valueOf(i), Integer.valueOf(i));
            str2 = str2 + String.format("if(e%d){r[n%d]=e%d.getAttribute('value')}", Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i));
        }
        return str + String.format(";%sreturn JSON.stringify(r);})()", str2);
    }

    private void getMetaInfo(final WVUCWebView wVUCWebView) {
        String metaDataScript = getMetaDataScript();
        if (metaDataScript != null && wVUCWebView != null) {
            wVUCWebView.evaluateJavascript(metaDataScript, new ValueCallback<String>() {
                /* class android.taobao.windvane.extra.uc.WVUCWebViewClient.AnonymousClass1 */

                public void onReceiveValue(String str) {
                    try {
                        JSONObject metaObject = WVUCWebViewClient.this.getMetaObject(str);
                        if (metaObject == null) {
                            return;
                        }
                        if (wVUCWebView != null) {
                            if (!metaObject.has("WV.Meta.Performance.JSFSP")) {
                                wVUCWebView.setTag(ViewToken.APM_VIEW_TOKEN, ViewToken.APM_VIEW_VALID);
                                TaoLog.d(WVUCWebViewClient.TAG, "no JSFSP setTag " + SystemClock.uptimeMillis());
                            } else if (TextUtils.isEmpty(metaObject.optString("WV.Meta.Performance.JSFSP"))) {
                                wVUCWebView.setTag(ViewToken.APM_VIEW_TOKEN, ViewToken.APM_VIEW_VALID);
                                TaoLog.d(WVUCWebViewClient.TAG, "no version setTag " + SystemClock.uptimeMillis());
                            } else if (!wVUCWebView.isReportedFSP()) {
                                wVUCWebView.setTag(ViewToken.APM_VIEW_TOKEN, ViewToken.APM_VIEW_INVALID);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ef A[SYNTHETIC, Splitter:B:43:0x00ef] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0139  */
    private WebResourceResponse shouldInterceptRequestInternal(WebView webView, String str, WVEventResult wVEventResult) {
        WVMemoryCacheInfo memoryCacheByUrl;
        FileInputStream fileInputStream;
        Object obj;
        if (!wVEventResult.isSuccess || (obj = wVEventResult.resultObj) == null || !(obj instanceof WVWrapWebResourceResponse)) {
            if (WVMonitorService.getPerformanceMonitor() != null) {
                WVMonitorService.getPerformanceMonitor().didGetResourceStatusCode(str, 0, WVUCWebView.getFromType(), null, null);
            }
            WebResourceResponse webResourceResponse = null;
            if (WVCacheManager.getInstance().isCacheEnabled(str)) {
                String removeScheme = WVUrlUtil.removeScheme(str);
                try {
                    fileInputStream = new FileInputStream(new File(WVCacheManager.getInstance().getCacheDir(true) + File.separator + DigestUtils.md5ToHex(removeScheme)));
                    try {
                        WebResourceResponse webResourceResponse2 = new WebResourceResponse("image/png", "UTF-8", fileInputStream);
                        HashMap hashMap = new HashMap();
                        hashMap.put("Access-Control-Allow-Origin", jl1.MUL);
                        webResourceResponse2.setResponseHeaders(hashMap);
                        return webResourceResponse2;
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
                    webResourceResponse = new WebResourceResponse(MimeTypeEnum.HTML.getMimeType(), "UTF-8", new ByteArrayInputStream(memoryCacheByUrl.mCachedDatas));
                }
                WVMemoryCache.getInstance().clearCacheByUrl(str);
                TaoLog.i(TAG, "WVMemoryCacheInfo 命中 : " + str);
                return webResourceResponse;
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.d(TAG, "shouldInterceptRequest : " + str);
            }
            return super.shouldInterceptRequest(webView, str);
        }
        WVWrapWebResourceResponse wVWrapWebResourceResponse = (WVWrapWebResourceResponse) obj;
        if (TaoLog.getLogStatus()) {
            TaoLog.e("ZCache", "预加载命中 : " + str);
        }
        WebResourceResponse webResourceResponse3 = new WebResourceResponse(wVWrapWebResourceResponse.mMimeType, wVWrapWebResourceResponse.mEncoding, wVWrapWebResourceResponse.mInputStream);
        try {
            if (wVWrapWebResourceResponse.mHeaders != null) {
                try {
                    if (!WVServerConfig.isAllowAccess(str) || wVWrapWebResourceResponse.mHeaders.containsKey("Access-Control-Allow-Origin")) {
                        webResourceResponse3.setResponseHeaders(wVWrapWebResourceResponse.mHeaders);
                    } else {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.putAll(wVWrapWebResourceResponse.mHeaders);
                        hashMap2.put("Access-Control-Allow-Origin", jl1.MUL);
                        webResourceResponse3.setResponseHeaders(hashMap2);
                        TaoLog.w(TAG, "add cross origin header");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else if (WVServerConfig.isAllowAccess(str)) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("Access-Control-Allow-Origin", jl1.MUL);
                webResourceResponse3.setResponseHeaders(hashMap3);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return webResourceResponse3;
    }

    private void tryPreCacheResources(WebView webView) {
        if (WVUCPrecacheManager.canClearPrecache()) {
            WVUCPrecacheManager.resetClearConfig();
            UCCore.clearPrecacheResources(null);
            WVUCPrecacheManager.setHasPrecache(false);
        }
        if (WVUCPrecacheManager.canPrecache()) {
            WVUCPrecacheManager.resetClearConfig();
            WVUCPrecacheManager.resetPrecacheConfig();
            HashSet<String> preMemCacheUrlSet = WVUCPrecacheManager.preMemCacheUrlSet();
            if (preMemCacheUrlSet != null) {
                HashMap hashMap = new HashMap();
                Iterator<String> it = preMemCacheUrlSet.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    WebResourceResponse shouldInterceptRequest = shouldInterceptRequest(webView, new WebResourceRequest(next, new HashMap()));
                    if (shouldInterceptRequest != null) {
                        hashMap.put(next, shouldInterceptRequest);
                    }
                }
                if (hashMap.size() > 0) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("maxAge", "3600");
                    hashMap2.put("ignoreQuery", "1");
                    UCCore.precacheResources(hashMap, hashMap2);
                    WVUCPrecacheManager.setHasPrecache(true);
                }
            }
        }
    }

    public JSONObject getMetaObject(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("\"") && str.endsWith("\"")) {
                str = str.substring(1, str.length() - 1);
            }
            return new JSONObject(str.replace("\\", ""));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.uc.webview.export.WebViewClient
    public void onPageFinished(final WebView webView, final String str) {
        String str2;
        TaoLog.e(TAG, "onPageFinished : " + str);
        if (webView instanceof IFullTrace) {
            IFullTrace iFullTrace = (IFullTrace) webView;
            FullTraceUtils.addStage(iFullTrace.getSpanWrapper(), "onPageFinished");
            FullTraceUtils.addProperty(iFullTrace.getSpanWrapper(), "H5_URL", str);
        }
        try {
            if (webView instanceof WVUCWebView) {
                getMetaInfo((WVUCWebView) webView);
            } else {
                TaoLog.e(TAG, "view is " + webView);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        WVUCWebView wVUCWebView = (WVUCWebView) webView;
        wVUCWebView.wvh5PPManager.pageDidFinishLoad(str, webView);
        final long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        if (!this.isError && webView.getVisibility() == 4) {
            this.isError = false;
            webView.setVisibility(0);
        }
        super.onPageFinished(webView, str);
        UCExtension uCExtension = null;
        if (webView instanceof WVUCWebView) {
            wVUCWebView.setCurrentUrl(str, "onPageFinished");
            wVUCWebView.onMessage(401, null);
        }
        if (webView instanceof IWVWebView) {
            IWVWebView iWVWebView = (IWVWebView) webView;
            WVEventService.getInstance().onEvent(1002, iWVWebView, str, new Object[0]);
            WVJsPatch.getInstance().execute(iWVWebView, str);
            iWVWebView.fireEvent("WindVaneReady", String.format("{'version':'%s'}", GlobalConfig.VERSION));
        }
        if (WVMonitorService.getPerformanceMonitor() != null) {
            UCExtension uCExtension2 = webView.getUCExtension();
            if (uCExtension2 != null) {
                z = uCExtension2.isLoadFromCachedPage();
            }
            str2 = null;
            WVMonitorService.getPerformanceMonitor().didGetPageStatusCode(str, -1, z ? 72 : WVUCWebView.getFromType(), null, null, null, null, null);
            uCExtension = uCExtension2;
        } else {
            str2 = null;
        }
        webView.evaluateJavascript("(function(p){if(!p||!p.timing)return;var t=p.timing,s=t.navigationStart,sc=t.secureConnectionStart,dc=t.domComplete,les=t.loadEventStart,lee=t.loadEventEnd;return JSON.stringify({dns:t.domainLookupEnd-t.domainLookupStart,c:t.connectEnd-t.connectStart,scs:sc>0?sc-s:0,req:t.requestStart-s,rps:t.responseStart-s,rpe:t.responseEnd-s,dl:t.domLoading-s,dcl:t.domContentLoadedEventEnd-s,dc:dc>0?dc-s:0,les:les>0?les-s:0,lee:lee>0?lee-s:0})})(window.performance)", new ValueCallback<String>() {
            /* class android.taobao.windvane.extra.uc.WVUCWebViewClient.AnonymousClass2 */

            public void onReceiveValue(String str) {
                if (WVMonitorService.getPerformanceMonitor() != null) {
                    WVMonitorService.getPerformanceMonitor().didPagePerformanceInfo(str, str);
                    WVMonitorService.getPerformanceMonitor().didPageFinishLoadAtTime(str, currentTimeMillis);
                }
            }
        });
        TaoLog.i(TAG, str + " LayerType : " + webView.getLayerType());
        if (webView.getCurrentViewCoreType() == 2) {
            webView.evaluateJavascript("javascript:(function(f){if(f.__windvane__.call) return true; else return false})(window)", new ValueCallback<String>() {
                /* class android.taobao.windvane.extra.uc.WVUCWebViewClient.AnonymousClass3 */

                public void onReceiveValue(String str) {
                    TaoLog.i("WVJsBridge", "has windvane :" + str);
                    if ("false".equals(str)) {
                        webView.loadUrl("javascript:(function(f){try{if(f.__windvane__.nativeCall&&!f.__windvane__.call){var h=f.__windvane__||(f.__windvane__={});var c=\"wvapi:\"+(Math.floor(Math.random()*(1<<16))),a=0,b={},g=function(j){if(j&&typeof j==\"string\"){try{return JSON.parse(j)}catch(i){return{ret:\"HY_RESULT_PARSE_ERROR\"}}}else{return j||{}}};h.call=function(i,m,l,e,k){if(typeof l!=\"function\"){l=null}if(typeof e!=\"function\"){e=null}var j=c+(a++);b[j]={s:l,f:e,};if(k>0){b[j].t=setTimeout(function(){h.onFailure(j,{ret:\"HY_TIMEOUT\"})},k)}if(!m){m={}}if(typeof m!=\"string\"){m=JSON.stringify(m)}f.__windvane__.nativeCall(i,m,j,location.href)};h.find=function(i,j){var e=b[i]||{};if(e.t){clearTimeout(e.t);delete e.t}if(!j){delete b[i]}return e};h.onSuccess=function(j,e,k){var i=h.find(j,k).s;if(i){i(g(e))}};h.onFailure=function(j,e){var i=h.find(j,false).f;if(i){i(g(e))}}}}catch(d){}})(window);");
                    }
                }
            });
        }
        if (WebView.getCoreType() == 1 || WebView.getCoreType() == 3) {
            TaoLog.d(TAG, "onPageFinished.  core type = " + WebView.getCoreType());
            AppMonitorUtil.commitSuccess(AppMonitorUtil.MONITOR_POINT_WEB_CORE_TYPE_BY_PV, str2);
            if (WVMonitorService.getWvMonitorInterface() != null) {
                WVMonitorService.getWvMonitorInterface().commitCoreTypeByPV(String.valueOf(WVCommonConfig.commonConfig.initUCCorePolicy), "U4");
            }
            if (uCExtension != null && !((WVUCWebView) webView).isStaticWebView()) {
                if (CommonUtils.isMainProcess(webView.getContext())) {
                    uCExtension.getCoreStatus(2, new ValueCallback<Object>() {
                        /* class android.taobao.windvane.extra.uc.WVUCWebViewClient.AnonymousClass4 */

                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(Object obj) {
                            if (obj instanceof Map) {
                                Map map = (Map) obj;
                                if (WVMonitorService.getWvMonitorInterface() != null) {
                                    String str = (String) map.get("rt");
                                    String str2 = (String) map.get("rtWhy");
                                    String str3 = (String) map.get("gt");
                                    String str4 = (String) map.get("gtWhy");
                                    HashMap hashMap = new HashMap();
                                    hashMap.put(TLogEventConst.PARAM_UPLOAD_STAGE, "onPageFinish");
                                    hashMap.put("requireRenderType", Integer.valueOf(WVCore.getInstance().getUsedWebMulti()));
                                    hashMap.put("realRenderType", str);
                                    hashMap.put("renderTypeReason", str2);
                                    hashMap.put("requireGpuType", Integer.valueOf(WVCore.getInstance().getUsedGpuMulti()));
                                    hashMap.put("realGpuType", str3);
                                    hashMap.put("gpuTypeReason", str4);
                                    WVMonitorService.getWvMonitorInterface().commitWebMultiTypeByPV(String.valueOf(WVCore.getInstance().getUsedWebMulti()), str, str2, String.valueOf(WVCore.getInstance().getUsedGpuMulti()), str3, str4);
                                }
                            }
                        }
                    });
                } else if (WVMonitorService.getWvMonitorInterface() != null) {
                    WVMonitorService.getWvMonitorInterface().commitWebMultiTypeByPV("0", "0", "-1", "0", "0", "-1");
                }
            }
        } else {
            AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_WEB_CORE_TYPE_BY_PV, WebView.getCoreType(), "", "");
            if (WVMonitorService.getWvMonitorInterface() != null) {
                WVMonitorService.getWvMonitorInterface().commitCoreTypeByPV(String.valueOf(WVCommonConfig.commonConfig.initUCCorePolicy), "Android");
            }
        }
        if (WebView.getCoreType() == 3) {
            if (webView.getContext() != null) {
                WVUCWebView.createStaticWebViewIfNeeded(webView.getContext());
            }
            tryPreCacheResources(webView);
        }
    }

    @Override // com.uc.webview.export.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (webView instanceof IFullTrace) {
            FullTraceUtils.addStage(((IFullTrace) webView).getFalcoSpan(), "onPageStarted");
        }
        WVUCWebView wVUCWebView = (WVUCWebView) webView;
        wVUCWebView.wvh5PPManager.pageDidStartLoad();
        this.isError = false;
        if (WVMonitorService.getPerformanceMonitor() != null) {
            WVMonitorService.getPerformanceMonitor().didPageStartLoadAtTime(str, System.currentTimeMillis());
        }
        if (webView instanceof WVUCWebView) {
            WVEventService.getInstance().onEvent(1001, (IWVWebView) webView, str, bitmap);
            wVUCWebView.onMessage(400, null);
            wVUCWebView.mPageStart = System.currentTimeMillis();
        }
        WVJsBridge.getInstance().tryToRunTailBridges();
        TaoLog.e(TAG, "onPageStarted : " + str);
    }

    @Override // com.uc.webview.export.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        FalcoSpan falcoSpan;
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "Receive error, code: " + i + "; desc: " + str + "; url: " + str2);
        }
        if (webView instanceof IWVWebView) {
            if (WVEventService.getInstance().onEvent(1005, (IWVWebView) webView, str2, Integer.valueOf(i), str, str2).isSuccess) {
                return;
            }
        }
        String url = webView.getUrl();
        if ((webView instanceof IFullTrace) && (falcoSpan = ((IFullTrace) webView).getFalcoSpan()) != null) {
            FullTraceUtils.addStage(falcoSpan, "onReceivedError");
            falcoSpan.setTag("errorCode", Integer.valueOf(i));
            falcoSpan.setTag(SocialConstants.PARAM_COMMENT, str);
            falcoSpan.setTag("failingUrl", str2);
            falcoSpan.finish("onReceivedError");
        }
        WVUCWebView wVUCWebView = (WVUCWebView) webView;
        wVUCWebView.wvh5PPManager.pageDidFailLoadWithError(String.valueOf(i), str);
        if (((i > -16 && i < 0) || i == -80 || i == -50) && (webView instanceof WVUCWebView) && (url == null || url.equals(str2))) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("cause", str + " [" + i + jl1.ARRAY_END_STR);
            hashMap.put("url", str2);
            this.isError = true;
            webView.setVisibility(4);
            wVUCWebView.onMessage(402, hashMap);
        }
        if (WVMonitorService.getErrorMonitor() != null) {
            WVErrorMonitorInterface errorMonitor = WVMonitorService.getErrorMonitor();
            if (url != null) {
                str2 = url;
            }
            errorMonitor.didOccurNativeError(str2, i, str);
        }
    }

    @Override // com.uc.webview.export.WebViewClient
    @SuppressLint({"NewApi"})
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String sslError2 = sslError.toString();
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "onReceivedSslError  url: " + sslError.getUrl() + "errorMsg:" + sslError2);
        }
        String url = webView.getUrl();
        if (webView instanceof WVUCWebView) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("cause", "SSL_ERROR");
            hashMap.put("url", url);
            ((WVUCWebView) webView).onMessage(402, hashMap);
        }
        if (webView instanceof IWVWebView) {
            WVEventService.getInstance().onEvent(1006, (IWVWebView) webView, url, sslError2);
        }
        if (WVMonitorService.getErrorMonitor() != null) {
            WVMonitorService.getErrorMonitor().didOccurNativeError(url, 1006, sslError2);
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // com.uc.webview.export.WebViewClient
    public boolean onRenderProcessGone(final WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        TaoLog.e(SANDBOX_TAG, "onRenderProcessGone webview:" + webView + ", crash:" + renderProcessGoneDetail.didCrash() + ", priority:" + renderProcessGoneDetail.rendererPriorityAtExit());
        int i = this.crashCount;
        if (i >= 5) {
            if (WVMonitorService.getWvMonitorInterface() != null) {
                WVMonitorService.getWvMonitorInterface().commitRenderType(webView.getUrl(), "R_Fail", WVCommonConfig.commonConfig.webMultiPolicy);
            }
            this.crashCount = 0;
            Log.e(SANDBOX_TAG, "onRenderProcessGone webview:" + webView.getClass().getSimpleName() + ", crash:" + renderProcessGoneDetail.didCrash(), new Throwable());
            return false;
        } else if (webView != null) {
            this.crashCount = i + 1;
            if (this.mRenderProcessHandler == null) {
                this.mRenderProcessHandler = new Handler(Looper.getMainLooper());
            }
            this.mRenderProcessHandler.postDelayed(new Runnable() {
                /* class android.taobao.windvane.extra.uc.WVUCWebViewClient.AnonymousClass6 */

                public void run() {
                    if (!webView.isDestroied()) {
                        webView.reload();
                    }
                }
            }, 200);
            this.mRenderProcessHandler.removeCallbacks(this.mCrashCountReseter);
            this.mRenderProcessHandler.postDelayed(this.mCrashCountReseter, 20000);
            return true;
        } else {
            TaoLog.e(SANDBOX_TAG, "onRenderProcessGone - WebView is null");
            return false;
        }
    }

    @Override // com.uc.webview.export.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        int i = 3;
        if (WebView.getCoreType() != 3) {
            TaoLog.e(TAG, "Only U4 WebView will use shouldInterceptRequest(API Level 21), return null.");
            return null;
        } else if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            TaoLog.e(TAG, "shouldInterceptRequest, invalid request.");
            return null;
        } else {
            String uri = webResourceRequest.getUrl().toString();
            if (WVUCPrecacheManager.getInstance().hasPrecacheDoc(uri)) {
                WVUCPrecacheManager.getInstance().clearPrecacheDoc(uri);
                return null;
            } else if (!(webView instanceof IWVWebView)) {
                return null;
            } else {
                if (!(webView instanceof WVUCWebView) || ((WVUCWebView) webView).getUCExtension() == null) {
                    i = 2;
                }
                return shouldInterceptRequestInternal(webView, uri, WVEventService.getInstance().onEvent(1008, (IWVWebView) webView, uri, webResourceRequest.getRequestHeaders(), Integer.valueOf(i)));
            }
        }
    }

    @Override // com.uc.webview.export.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            if (webView instanceof IFullTrace) {
                FullTraceUtils.addCustomStageAndFinish(((IFullTrace) webView).getFalcoSpan(), null);
                ((IFullTrace) webView).setFalcoSpan(FullTraceUtils.makeSpanChildOf("windvaneSubPage", "H5SubPage", ((IFullTrace) webView).getOpenTracingContext()));
            }
        } catch (Throwable th) {
            TaoLog.e(TAG, "getSpan failed " + CommonUtils.getStackTrace(th));
        }
        if (!WVUrlUtil.isCommonUrl(str) || !WVServerConfig.isBlackUrl(str, (IWVWebView) webView)) {
            IWVWebView iWVWebView = (IWVWebView) webView;
            if (WVURLFilter.doFilter(str, this.mContext.get(), iWVWebView)) {
                TaoLog.e(TAG, "shouldOverrideUrlLoading filter url=" + str);
                AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_URL_CONFIG_FILTER_TYPE, 3, "WVUCWebView.shouldOverrideUrlLoading", str);
                return true;
            } else if ((webView instanceof IWVWebView) && WVEventService.getInstance().onEvent(1003, iWVWebView, str, new Object[0]).isSuccess) {
                return true;
            } else {
                Context context = webView.getContext();
                if (str.startsWith("mailto:") || str.startsWith("tel:") || str.startsWith(SCHEME_SMS)) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        intent.setFlags(268435456);
                        if (context != null) {
                            context.startActivity(intent);
                        }
                    } catch (ActivityNotFoundException unused) {
                        TaoLog.e(TAG, "shouldOverrideUrlLoading: ActivityNotFoundException, url=" + str);
                    }
                    return true;
                }
                WVUCWebView wVUCWebView = (WVUCWebView) webView;
                wVUCWebView.wvh5PPManager.receiveHtmlUrl(str);
                try {
                    if ((webView instanceof IWVWebView) && WVURLInterceptService.getWVURLIntercepter() != null && WVURLInterceptService.getWVURLIntercepter().isOpenURLIntercept()) {
                        if (WVURLInterceptService.getWVURLIntercepter().isNeedupdateURLRule(false)) {
                            WVURLInterceptService.getWVURLIntercepter().updateURLRule();
                        }
                        if (WVURLInterceptService.getWVURLIntercepter().shouldOverrideUrlLoading(context, (IWVWebView) webView, str)) {
                            TaoLog.i(TAG, "intercept url : " + str);
                            return true;
                        }
                    }
                } catch (Exception e) {
                    TaoLog.e(TAG, "shouldOverrideUrlLoading: doFilter error, " + e.getMessage());
                }
                if (webView instanceof WVUCWebView) {
                    UCNetworkDelegate.getInstance().onUrlChange(wVUCWebView, str);
                    wVUCWebView.setCachedUrl(str);
                }
                TaoLog.i(TAG, "shouldOverrideUrlLoading : " + str);
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("userAgent", webView.getSettings().getUserAgentString());
                    WMLPrefetch.getInstance().prefetchData(str, hashMap);
                } catch (Throwable th2) {
                    TaoLog.e(TAG, "failed to call prefetch: " + th2.getMessage());
                    th2.printStackTrace();
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        } else {
            String forbiddenDomainRedirectURL = WVURLConfig.getInstance().getForbiddenDomainRedirectURL();
            if (TextUtils.isEmpty(forbiddenDomainRedirectURL)) {
                HashMap hashMap2 = new HashMap(2);
                hashMap2.put("cause", "ACCESS_FORBIDDEN");
                hashMap2.put("url", str);
                ((WVUCWebView) webView).onMessage(402, hashMap2);
            } else {
                webView.loadUrl(forbiddenDomainRedirectURL);
            }
            return true;
        }
    }

    @Override // com.uc.webview.export.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        int i = 3;
        if (WebView.getCoreType() == 3) {
            TaoLog.e(TAG, "U4 WebView will not use shouldInterceptRequest(API Level 11), return null.");
            return null;
        } else if (!(webView instanceof IWVWebView)) {
            return null;
        } else {
            int i2 = 2;
            if (webView instanceof WVUCWebView) {
                if (((WVUCWebView) webView).getUCExtension() == null) {
                    i = 2;
                }
                i2 = i;
            }
            return shouldInterceptRequestInternal(webView, str, WVEventService.getInstance().onEvent(1004, (IWVWebView) webView, str, Integer.valueOf(i2)));
        }
    }
}
