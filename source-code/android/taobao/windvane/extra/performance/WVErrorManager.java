package android.taobao.windvane.extra.performance;

import android.taobao.windvane.WVPerformanceManager;
import android.taobao.windvane.grey.GreyPageInfo;
import android.taobao.windvane.grey.GreyPageManager;
import android.taobao.windvane.ha.WVHAManager;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import java.util.HashMap;

/* compiled from: Taobao */
public class WVErrorManager {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008c  */
    public void reportJSError(ConsoleMessage consoleMessage) {
        GreyPageInfo greyPageInfo;
        String str;
        String str2;
        String sourceId = consoleMessage.sourceId();
        if (!TextUtils.isEmpty(sourceId)) {
            greyPageInfo = GreyPageManager.getInstance().getGreyPageInfo(sourceId);
            if (greyPageInfo != null) {
                TaoLog.d("WVErrorManager", "found grey page: " + sourceId);
            }
        } else {
            greyPageInfo = null;
        }
        String jsErrorRatio = WVPerformanceManager.getInstance().getConfig().getJsErrorRatio();
        if (jsErrorRatio == null || Math.random() < Double.parseDouble(jsErrorRatio)) {
            String sourceId2 = consoleMessage.sourceId();
            String message = consoleMessage.message();
            if (message != null) {
                String[] split = message.split("\\+\\+BT\\+\\+");
                if (split.length == 2) {
                    String str3 = split[0];
                    str2 = split[1];
                    str = str3;
                    String valueOf = String.valueOf(consoleMessage.lineNumber());
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("msg", "js error: " + message);
                    if (greyPageInfo != null) {
                        hashMap.put(GreyPageInfo.KEY_AIR_TAG, greyPageInfo.generateOutputString());
                    }
                    WVHAManager.uploadApmStage("js_error", hashMap);
                    WVHAManager.reportJSError("WINDVANE_JS_ERROR", sourceId2, str2, str, valueOf, sourceId2);
                }
            }
            str2 = "";
            str = str2;
            String valueOf2 = String.valueOf(consoleMessage.lineNumber());
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("msg", "js error: " + message);
            if (greyPageInfo != null) {
            }
            WVHAManager.uploadApmStage("js_error", hashMap2);
            WVHAManager.reportJSError("WINDVANE_JS_ERROR", sourceId2, str2, str, valueOf2, sourceId2);
        }
    }
}
