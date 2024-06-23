package android.taobao.windvane.extra.jsbridge;

import android.net.Uri;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.extra.uc.preRender.PreRenderWebView;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.WVReporter;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVWebView;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONObject;

/* compiled from: Taobao */
public class WVReporterExtra extends WVReporter {
    @Override // android.taobao.windvane.jsbridge.api.WVReporter, android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("reportPerformanceCheckResult".equals(str)) {
            reportPerformanceCheckResult(wVCallBackContext, str2);
        } else if (!"reportPrerenderStatus".equals(str)) {
            return false;
        } else {
            reportPrerenderStatus(wVCallBackContext, str2);
        }
        return super.execute(str, str2, wVCallBackContext);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f  */
    public void reportPerformanceCheckResult(WVCallBackContext wVCallBackContext, String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            long optLong = jSONObject.optLong("score", 0);
            String optString = jSONObject.optString("version", "");
            String optString2 = jSONObject.optString("result", "");
            String optString3 = jSONObject.optString("detail", "");
            String url = this.mWebView.getUrl();
            String str3 = null;
            try {
                IWVWebView iWVWebView = this.mWebView;
                if (iWVWebView instanceof WVWebView) {
                    str3 = ((WVWebView) iWVWebView).bizCode;
                } else if (iWVWebView instanceof WVUCWebView) {
                    str3 = ((WVUCWebView) iWVWebView).bizCode;
                }
            } catch (Throwable unused) {
            }
            Uri parse = Uri.parse(url);
            if (parse != null && parse.isHierarchical()) {
                String queryParameter = parse.getQueryParameter("wvBizCode");
                if (!TextUtils.isEmpty(queryParameter)) {
                    str2 = queryParameter;
                    if (WVMonitorService.getPerformanceMonitor() != null) {
                        WVMonitorService.getPerformanceMonitor().didPerformanceCheckResult(url, optLong, optString, str2, optString2);
                    }
                    if (TaoLog.getLogStatus()) {
                        Log.e("WindVaneWebPerfCheck", String.format("WindVaneWebPerfCheck: %s|%d|%s", url, Long.valueOf(optLong), optString3));
                    }
                    wVCallBackContext.success();
                }
            }
            str2 = str3;
            if (WVMonitorService.getPerformanceMonitor() != null) {
            }
            if (TaoLog.getLogStatus()) {
            }
            wVCallBackContext.success();
        } catch (Exception e) {
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", e.getMessage());
            wVCallBackContext.error(wVResult);
        }
    }

    public void reportPrerenderStatus(WVCallBackContext wVCallBackContext, String str) {
        try {
            boolean optBoolean = new JSONObject(str).optBoolean("success", true);
            try {
                IWVWebView iWVWebView = this.mWebView;
                if (iWVWebView instanceof PreRenderWebView) {
                    ((PreRenderWebView) iWVWebView).setPreRenderSuccess(optBoolean);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            Log.e("reportPrerenderStatus", "setPreRenderSuccess " + optBoolean);
            wVCallBackContext.success();
        } catch (Exception e) {
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", e.getMessage());
            wVCallBackContext.error(wVResult);
        }
    }
}
