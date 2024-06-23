package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;

/* compiled from: Taobao */
public class WVUI extends WVApiPlugin {
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("showLoadingBox".equals(str)) {
            showLoading(str2, wVCallBackContext);
            return true;
        } else if (!"hideLoadingBox".equals(str)) {
            return false;
        } else {
            hideLoading(str2, wVCallBackContext);
            return true;
        }
    }

    public final void hideLoading(String str, WVCallBackContext wVCallBackContext) {
        this.mWebView.hideLoadingView();
        wVCallBackContext.success();
    }

    public final void showLoading(String str, WVCallBackContext wVCallBackContext) {
        this.mWebView.showLoadingView();
        wVCallBackContext.success();
    }
}
