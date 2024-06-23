package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.util.ImageTool;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.alibaba.security.realidentity.jsbridge.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class WVImage extends WVApiPlugin {
    private static final String TAG = "WVImage";

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void saveImage(String str, final WVCallBackContext wVCallBackContext) {
        try {
            String optString = new JSONObject(str).optString("url", "");
            if (!TextUtils.isEmpty(optString)) {
                ImageTool.saveImageToDCIM(this.mContext, optString, new ImageTool.ImageSaveCallback() {
                    /* class android.taobao.windvane.jsbridge.api.WVImage.AnonymousClass3 */

                    @Override // android.taobao.windvane.util.ImageTool.ImageSaveCallback
                    public void error(String str) {
                        WVResult wVResult = new WVResult();
                        wVResult.addData("msg", str);
                        wVCallBackContext.error(wVResult);
                    }

                    @Override // android.taobao.windvane.util.ImageTool.ImageSaveCallback
                    public void success() {
                        wVCallBackContext.success();
                    }
                });
            }
        } catch (JSONException e) {
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", e.getMessage());
            wVCallBackContext.error(wVResult);
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, final String str2, final WVCallBackContext wVCallBackContext) {
        if (!TextUtils.equals(str, "saveImage")) {
            return false;
        }
        try {
            PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() {
                /* class android.taobao.windvane.jsbridge.api.WVImage.AnonymousClass2 */

                public void run() {
                    TaoLog.d("WVImage", "PERMISSION GRANTED");
                    WVImage.this.saveImage(str2, wVCallBackContext);
                }
            }).setTaskOnPermissionDenied(new Runnable() {
                /* class android.taobao.windvane.jsbridge.api.WVImage.AnonymousClass1 */

                public void run() {
                    WVResult wVResult = new WVResult();
                    wVResult.addData("msg", a.al);
                    wVCallBackContext.error(wVResult);
                }
            }).execute();
            return true;
        } catch (Exception e) {
            TaoLog.d("WVImage", "Run whith some exception!");
            e.printStackTrace();
            return false;
        }
    }
}
