package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import android.widget.Toast;
import java.net.URLDecoder;
import org.json.JSONObject;

/* compiled from: Taobao */
public class WVUIToast extends WVApiPlugin {
    private static final String TAG = "WVUIToast";

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!"toast".equals(str)) {
            return false;
        }
        toast(wVCallBackContext, str2);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    public synchronized void toast(WVCallBackContext wVCallBackContext, String str) {
        int i;
        if (!WVUtils.isNotificationEnabled(this.mContext)) {
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", "no permission");
            wVCallBackContext.error(wVResult);
            return;
        }
        String str2 = "";
        int i2 = 1;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(URLDecoder.decode(str, "utf-8"));
                str2 = jSONObject.optString("message");
                i = jSONObject.optInt("duration");
            } catch (Exception unused) {
                Toast makeText = Toast.makeText(this.mContext, str, 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
            if (!TextUtils.isEmpty(str2)) {
                if (i <= 3) {
                    i2 = i;
                }
                Toast makeText2 = Toast.makeText(this.mContext, str2, i2);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            }
            wVCallBackContext.success();
        }
        i = 0;
        if (!TextUtils.isEmpty(str2)) {
        }
        wVCallBackContext.success();
    }
}
