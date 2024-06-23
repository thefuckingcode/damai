package android.taobao.windvane.jsbridge;

import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVUrlMatchUtils;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.webview.IWVWebView;

/* compiled from: Taobao */
public class WVJsPreprocessor extends WVJSAPIPageAuth {
    @Override // android.taobao.windvane.jsbridge.WVJSAPIAuthCheck
    public boolean apiAuthCheck(String str, String str2, String str3, String str4) {
        if (WVUrlMatchUtils.getInstance().checkJsApiPermission(str, str2, str3)) {
            return true;
        }
        AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_URL_CONFIG_JS_API_TYPE, 1, str2 + "." + str3, str);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // android.taobao.windvane.jsbridge.WVJSAPIPageAuth
    public boolean needAuth(IWVWebView iWVWebView) {
        if (!WVCommonConfig.commonConfig.useURLConfig) {
            return false;
        }
        if (!iWVWebView.canUseGlobalUrlConfig() && !iWVWebView.canUseUrlConfig()) {
            return false;
        }
        return true;
    }
}
