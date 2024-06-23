package android.taobao.windvane.jsbridge;

import android.os.Looper;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.fullspan.SpanWrapper;
import android.taobao.windvane.util.FullTraceUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IFullTrace;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import tb.jl1;

/* compiled from: Taobao */
public class WVBridgeEngine implements Serializable {
    private static final String FAILURE_CALLBACK_PREFIX = "javascript:window.__windvane__&&window.__windvane__.onFailure&&window.__windvane__.onFailure";
    private static final String SUCCESS_CALLBACK_PREFIX = "javascript:window.__windvane__&&window.__windvane__.onSuccess&&window.__windvane__.onSuccess";
    public static final String WINDVANE_CORE_JS = "(function(f){try{if(f.__windvane__.nativeCall&&!f.__windvane__.call){var h=f.__windvane__||(f.__windvane__={});var c=\"wvapi:\"+(Math.floor(Math.random()*(1<<16))),a=0,b={},g=function(j){if(j&&typeof j==\"string\"){try{return JSON.parse(j)}catch(i){return{ret:\"HY_RESULT_PARSE_ERROR\"}}}else{return j||{}}};h.call=function(i,m,l,e,k){if(typeof l!=\"function\"){l=null}if(typeof e!=\"function\"){e=null}var j=c+(a++);b[j]={s:l,f:e,};if(k>0){b[j].t=setTimeout(function(){h.onFailure(j,{ret:\"HY_TIMEOUT\"})},k)}if(!m){m={}}if(typeof m!=\"string\"){m=JSON.stringify(m)}f.__windvane__.nativeCall(i,m,j,location.href)};h.find=function(i,j){var e=b[i]||{};if(e.t){clearTimeout(e.t);delete e.t}if(!j){delete b[i]}return e};h.onSuccess=function(j,e,k){var i=h.find(j,k).s;if(i){i(g(e))}};h.onFailure=function(j,e){var i=h.find(j,false).f;if(i){i(g(e))}}}}catch(d){}})(window);";
    private static ExecutorService sExecutors = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private IWVWebView mWebview = null;

    public WVBridgeEngine(IWVWebView iWVWebView) {
        this.mWebview = iWVWebView;
        try {
            ((ThreadPoolExecutor) sExecutors).allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String formatJsonString(String str) {
        if (str.contains(" ")) {
            try {
                str = str.replace(" ", "\\u2028");
            } catch (Exception unused) {
            }
        }
        if (str.contains(" ")) {
            try {
                str = str.replace(" ", "\\u2029");
            } catch (Exception unused2) {
            }
        }
        return str.replace("\\", "\\\\").replace("'", "\\'");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getCallbackJs(boolean z, String str, String str2) {
        if (z) {
            return "javascript:window.__windvane__&&window.__windvane__.onSuccess&&window.__windvane__.onSuccess('" + str + "','" + str2 + "');";
        }
        return "javascript:window.__windvane__&&window.__windvane__.onFailure&&window.__windvane__.onFailure('" + str + "','" + str2 + "');";
    }

    private void runOnUiThread(Runnable runnable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                runnable.run();
                return;
            }
            IWVWebView iWVWebView = this.mWebview;
            if (iWVWebView != null) {
                iWVWebView.getView().post(runnable);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void valuateJavascriptOnUiThread(final String str) {
        runOnUiThread(new Runnable() {
            /* class android.taobao.windvane.jsbridge.WVBridgeEngine.AnonymousClass4 */

            public void run() {
                WVBridgeEngine.this.mWebview.evaluateJavascript(str);
            }
        });
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void nativeCall(String str, String str2, final String str3, final String str4) {
        final WVCallMethodContext wVCallMethodContext = new WVCallMethodContext();
        String[] split = str.split("\\.");
        if (split == null || split.length != 2) {
            WVResult wVResult = new WVResult();
            wVResult.setResult(WVResult.NO_METHOD);
            new WVCallBackContext(this.mWebview, str3, "", "", null, null).error(wVResult);
            return;
        }
        wVCallMethodContext.objectName = split[0];
        wVCallMethodContext.methodName = split[1];
        wVCallMethodContext.webview = this.mWebview;
        wVCallMethodContext.token = str3;
        wVCallMethodContext.params = str2;
        if (TextUtils.isEmpty(str2)) {
            wVCallMethodContext.params = "{}";
        }
        final SpanWrapper spanWrapper = new SpanWrapper();
        IWVWebView iWVWebView = this.mWebview;
        if (iWVWebView instanceof IFullTrace) {
            spanWrapper.setFalcoSpan(FullTraceUtils.makeSpanChildOf(IWXUserTrackAdapter.JS_BRIDGE, "JSNativeCall", ((IFullTrace) iWVWebView).getSpanWrapper()));
            spanWrapper.log("nativeCall " + split[0] + "." + split[1] + " token:" + str3 + " params:" + str2);
        }
        TaoLog.i("WVJsBridge", "new bridge, reqId=[" + str3 + jl1.ARRAY_END_STR);
        wVCallMethodContext.succeedCallBack = new IExtJsApiSuccessCallBack() {
            /* class android.taobao.windvane.jsbridge.WVBridgeEngine.AnonymousClass1 */

            @Override // android.taobao.windvane.jsbridge.IJsApiSucceedCallBack
            public void succeed(String str) {
                if (TextUtils.isEmpty(str)) {
                    str = "{}";
                }
                String formatJsonString = WVBridgeEngine.this.formatJsonString(str);
                WVBridgeEngine.this.valuateJavascriptOnUiThread(WVBridgeEngine.this.getCallbackJs(true, str3, formatJsonString));
                SpanWrapper spanWrapper = spanWrapper;
                spanWrapper.releaseLog("nativeCall succeed:" + formatJsonString);
                spanWrapper.finish("succeed");
            }

            @Override // android.taobao.windvane.jsbridge.IExtJsApiSuccessCallBack
            public void successAndKeepAlive(String str) {
                if (TextUtils.isEmpty(str)) {
                    str = "{}";
                }
                String formatJsonString = WVBridgeEngine.this.formatJsonString(str);
                WVBridgeEngine.this.valuateJavascriptOnUiThread("javascript:window.__windvane__&&window.__windvane__.onSuccess&&window.__windvane__.onSuccess('" + str3 + "','" + formatJsonString + "', true);");
                SpanWrapper spanWrapper = spanWrapper;
                StringBuilder sb = new StringBuilder();
                sb.append("nativeCall successAndKeepAlive:");
                sb.append(formatJsonString);
                spanWrapper.releaseLog(sb.toString());
                spanWrapper.finish("successAndKeepAlive");
            }
        };
        wVCallMethodContext.failedCallBack = new IJsApiFailedCallBack() {
            /* class android.taobao.windvane.jsbridge.WVBridgeEngine.AnonymousClass2 */

            @Override // android.taobao.windvane.jsbridge.IJsApiFailedCallBack
            public void fail(String str) {
                if (TextUtils.isEmpty(str)) {
                    str = "{}";
                }
                String formatJsonString = WVBridgeEngine.this.formatJsonString(str);
                WVBridgeEngine.this.valuateJavascriptOnUiThread(WVBridgeEngine.this.getCallbackJs(false, str3, formatJsonString));
                SpanWrapper spanWrapper = spanWrapper;
                spanWrapper.releaseLog("nativeCall fail:" + formatJsonString);
                spanWrapper.finish("fail");
            }
        };
        sExecutors.submit(new Runnable() {
            /* class android.taobao.windvane.jsbridge.WVBridgeEngine.AnonymousClass3 */

            public void run() {
                WVJsBridge.getInstance().callMethod(wVCallMethodContext, str4);
            }
        });
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public String version() {
        TaoLog.e("WVJSPlugin", "WVJSPlugin __windvane__ version 8.5.0");
        return GlobalConfig.VERSION;
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public String windVaneCoreJs() {
        return WINDVANE_CORE_JS;
    }
}
