package android.taobao.windvane.extra.jsbridge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import org.json.JSONObject;

/* compiled from: Taobao */
public class WVApplication extends WVApiPlugin {
    private void getNotificationSettings(WVCallBackContext wVCallBackContext, String str) {
        WVResult wVResult = new WVResult();
        if (Build.VERSION.SDK_INT < 22) {
            wVResult.addData("status", "unknown");
            wVCallBackContext.success(wVResult);
        } else if (!WVUtils.isNotificationEnabled(this.mContext)) {
            wVResult.addData("status", "denied");
            wVCallBackContext.success(wVResult);
        } else {
            wVResult.addData("status", "authorized");
            wVCallBackContext.success(wVResult);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(4:8|(2:10|(2:12|13))|14|23)(2:15|(2:17|18)(2:19|24))) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0096, code lost:
        r4.error();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
    private void openSettings(WVCallBackContext wVCallBackContext, String str) {
        String str2 = new JSONObject(str).optString("type", "");
        wVCallBackContext.error(new WVResult("HY_PARAM_ERR"));
        str2 = null;
        if ("Notification".equals(str2)) {
            if (Build.VERSION.SDK_INT >= 21) {
                Intent intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("app_package", this.mContext.getPackageName());
                intent.putExtra("app_uid", this.mContext.getApplicationInfo().uid);
                Context context = this.mContext;
                if (context != null) {
                    context.startActivity(intent);
                    wVCallBackContext.success();
                    return;
                }
            }
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", "fail to open Notification Settings");
            wVCallBackContext.error(wVResult);
            return;
        }
        Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        Context context2 = this.mContext;
        if (context2 != null) {
            intent2.setData(Uri.fromParts("package", context2.getPackageName(), null));
            this.mContext.startActivity(intent2);
            wVCallBackContext.success();
            return;
        }
        WVResult wVResult2 = new WVResult();
        wVResult2.addData("msg", "fail to open Application Settings");
        wVCallBackContext.error(wVResult2);
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("getNotificationSettings".equals(str)) {
            getNotificationSettings(wVCallBackContext, str2);
            return true;
        } else if (!"openSettings".equals(str)) {
            return false;
        } else {
            openSettings(wVCallBackContext, str2);
            return true;
        }
    }
}
