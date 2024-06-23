package android.taobao.windvane.jsbridge.api;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.taobao.windvane.config.EnvEnum;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.jsbridge.IJsApiFailedCallBack;
import android.taobao.windvane.jsbridge.IJsApiSucceedCallBack;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVCallMethodContext;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.WVAPI;
import android.taobao.windvane.monitor.UserTrackUtil;
import android.taobao.windvane.runtimepermission.PermissionChecker;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.WVWebView;
import android.text.TextUtils;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class WVBase extends WVApiPlugin {
    private void copyToClipboard(WVCallBackContext wVCallBackContext, String str) {
        JSONException e;
        String str2 = "HY_PARAM_ERR";
        WVResult wVResult = new WVResult(str2);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("text")) {
                    String string = jSONObject.getString("text");
                    if (Build.VERSION.SDK_INT >= 11) {
                        ((ClipboardManager) this.mWebView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(string, string));
                        WVResult wVResult2 = new WVResult(WVResult.SUCCESS);
                        try {
                            wVCallBackContext.success(wVResult2);
                            return;
                        } catch (JSONException e2) {
                            e = e2;
                            wVResult = wVResult2;
                            e.printStackTrace();
                            wVResult.addData("msg", str2);
                            wVCallBackContext.error(wVResult);
                        }
                    } else {
                        wVResult = new WVResult("HY_FAILED");
                        str2 = "HY_FAILED";
                    }
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                wVResult.addData("msg", str2);
                wVCallBackContext.error(wVResult);
            }
        }
        wVResult.addData("msg", str2);
        wVCallBackContext.error(wVResult);
    }

    public void addTailJSBridge(WVCallBackContext wVCallBackContext, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(PushClientConstants.TAG_CLASS_NAME);
            String string2 = jSONObject.getString("handlerName");
            String string3 = jSONObject.getString("params");
            WVCallMethodContext wVCallMethodContext = new WVCallMethodContext();
            wVCallMethodContext.objectName = string;
            wVCallMethodContext.methodName = string2;
            wVCallMethodContext.params = string3;
            wVCallMethodContext.webview = this.mWebView;
            wVCallMethodContext.succeedCallBack = new IJsApiSucceedCallBack() {
                /* class android.taobao.windvane.jsbridge.api.WVBase.AnonymousClass1 */

                @Override // android.taobao.windvane.jsbridge.IJsApiSucceedCallBack
                public void succeed(String str) {
                }
            };
            wVCallMethodContext.failedCallBack = new IJsApiFailedCallBack() {
                /* class android.taobao.windvane.jsbridge.api.WVBase.AnonymousClass2 */

                @Override // android.taobao.windvane.jsbridge.IJsApiFailedCallBack
                public void fail(String str) {
                }
            };
            if (WVJsBridge.getInstance().mTailBridges == null) {
                WVJsBridge.getInstance().mTailBridges = new ArrayList<>();
            }
            WVJsBridge.getInstance().mTailBridges.add(wVCallMethodContext);
            TaoLog.i(WVAPI.PluginName.API_BASE, "addTailJSBridge : " + str);
        } catch (Exception unused) {
        }
    }

    public void checkPermissions(WVCallBackContext wVCallBackContext, String str) {
        try {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("permissions");
                if (jSONArray.length() < 1) {
                    wVCallBackContext.error("HY_PARAM_ERR");
                    return;
                }
                String[] strArr = new String[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    strArr[i] = (String) jSONArray.get(i);
                }
                Map<String, String> checkPermissions = PermissionChecker.checkPermissions(this.mContext, strArr);
                if (checkPermissions == null || checkPermissions.size() <= 0) {
                    wVCallBackContext.error(new WVResult("HY_FAILED"));
                    return;
                }
                WVResult wVResult = new WVResult(WVResult.SUCCESS);
                wVResult.addData("result", new JSONObject(checkPermissions));
                wVCallBackContext.success(wVResult);
            } catch (JSONException e) {
                e.printStackTrace();
                WVResult wVResult2 = new WVResult("HY_PARAM_ERR");
                wVResult2.addData("reason", "JSONException: " + e);
                wVCallBackContext.error(wVResult2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            WVResult wVResult3 = new WVResult("HY_PARAM_ERR");
            wVResult3.addData("reason", "JSONException: " + e2);
            wVCallBackContext.error(wVResult3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008c  */
    public void commitUTEvent(WVCallBackContext wVCallBackContext, String str) {
        boolean z = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("eventId");
            String string = jSONObject.getString("arg1");
            String string2 = jSONObject.getString("arg2");
            String string3 = jSONObject.getString(UTDataCollectorNodeColumn.ARG3);
            JSONObject jSONObject2 = jSONObject.getJSONObject("args");
            String[] strArr = null;
            if (jSONObject2 != null) {
                strArr = new String[jSONObject2.length()];
                Iterator<String> keys = jSONObject2.keys();
                int i2 = 0;
                while (keys.hasNext()) {
                    String next = keys.next();
                    strArr[i2] = String.format("%s=%s", next, jSONObject2.getString(next));
                    i2++;
                }
            }
            if (64403 == i) {
                try {
                    UserTrackUtil.commitEvent(i, string, string2, string3, strArr);
                } catch (JSONException unused) {
                }
                WVResult wVResult = new WVResult();
                if (!z) {
                    wVCallBackContext.success(wVResult);
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d(WVAPI.PluginName.API_BASE, "commitUTEvent: param=" + str);
                        return;
                    }
                    return;
                }
                TaoLog.e(WVAPI.PluginName.API_BASE, "commitUTEvent: parameter error, param=" + str);
                wVResult.setResult("HY_PARAM_ERR");
                wVCallBackContext.error(wVResult);
                return;
            }
        } catch (JSONException unused2) {
        }
        z = false;
        WVResult wVResult2 = new WVResult();
        if (!z) {
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("isWindVaneSDK".equals(str)) {
            isWindVaneSDK(wVCallBackContext, str2);
            return true;
        } else if ("plusUT".equals(str)) {
            plusUT(wVCallBackContext, str2);
            return true;
        } else if ("commitUTEvent".equals(str)) {
            commitUTEvent(wVCallBackContext, str2);
            return true;
        } else if ("isInstall".equals(str)) {
            isInstall(wVCallBackContext, str2);
            return true;
        } else if ("isAppsInstalled".equals(str)) {
            isAppsInstalled(wVCallBackContext, str2);
            return true;
        } else if ("copyToClipboard".equals(str)) {
            copyToClipboard(wVCallBackContext, str2);
            return true;
        } else if ("addTailJSBridge".equals(str)) {
            addTailJSBridge(wVCallBackContext, str2);
            return true;
        } else if (!"checkPermissions".equals(str)) {
            return false;
        } else {
            checkPermissions(wVCallBackContext, str2);
            return true;
        }
    }

    public void isAppsInstalled(WVCallBackContext wVCallBackContext, String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            WVResult wVResult = new WVResult();
            PackageManager packageManager = this.mWebView.getContext().getPackageManager();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    PackageInfo packageInfo = null;
                    try {
                        packageInfo = packageManager.getPackageInfo(jSONObject.getJSONObject(next).optString("android"), 0);
                    } catch (Exception unused) {
                    }
                    if (packageInfo == null) {
                        str2 = "0";
                    } else {
                        str2 = "1";
                    }
                    wVResult.addData(next, str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                    wVResult.addData(next, "0");
                }
            }
            wVResult.setSuccess();
            wVCallBackContext.success(wVResult);
        } catch (JSONException e2) {
            e2.printStackTrace();
            wVCallBackContext.error();
        }
    }

    public void isInstall(WVCallBackContext wVCallBackContext, String str) {
        String str2;
        try {
            str2 = new JSONObject(str).getString("android");
        } catch (JSONException unused) {
            TaoLog.e(WVAPI.PluginName.API_BASE, "isInstall parse params error, params: " + str);
            str2 = null;
        }
        WVResult wVResult = new WVResult();
        boolean isAppInstalled = CommonUtils.isAppInstalled(this.mWebView.getContext(), str2);
        if (TaoLog.getLogStatus()) {
            TaoLog.d(WVAPI.PluginName.API_BASE, "isInstall " + isAppInstalled + " for package " + str2);
        }
        if (isAppInstalled) {
            wVCallBackContext.success(wVResult);
        } else {
            wVCallBackContext.error(wVResult);
        }
    }

    public void isWindVaneSDK(WVCallBackContext wVCallBackContext, String str) {
        String str2;
        WVResult wVResult = new WVResult();
        wVResult.addData("os", "android");
        wVResult.addData("version", GlobalConfig.VERSION);
        wVResult.addData("debug", Boolean.valueOf(EnvUtil.isAppDebug()));
        if (TaoLog.getLogStatus()) {
            TaoLog.d(WVAPI.PluginName.API_BASE, "isWindVaneSDK: version=8.5.0");
        }
        if (EnvEnum.DAILY.equals(GlobalConfig.env)) {
            str2 = "daily";
        } else {
            str2 = EnvEnum.PRE.equals(GlobalConfig.env) ? "pre" : "release";
        }
        wVResult.addData("env", str2);
        wVResult.addData("container", this.mWebView instanceof WVWebView ? "WVWebView" : "WVUCWebView");
        wVCallBackContext.success(wVResult);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b  */
    public void plusUT(WVCallBackContext wVCallBackContext, String str) {
        JSONObject jSONObject;
        boolean z = true;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            int i = jSONObject2.getInt("eid");
            String string = jSONObject2.getString("a1");
            String string2 = jSONObject2.getString("a2");
            String string3 = jSONObject2.getString("a3");
            String[] strArr = new String[0];
            if (jSONObject2.has("args") && (jSONObject = jSONObject2.getJSONObject("args")) != null) {
                strArr = new String[jSONObject.length()];
                Iterator<String> keys = jSONObject.keys();
                int i2 = 0;
                while (keys.hasNext()) {
                    String next = keys.next();
                    strArr[i2] = String.format("%s=%s", next, jSONObject.getString(next));
                    i2++;
                }
            }
            if ((i >= 9100 && i < 9200) || i == 19999) {
                try {
                    UserTrackUtil.commitEvent(i, string, string2, string3, strArr);
                } catch (JSONException unused) {
                }
                WVResult wVResult = new WVResult();
                if (!z) {
                    wVCallBackContext.success(wVResult);
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d(WVAPI.PluginName.API_BASE, "plusUT: param=" + str);
                        return;
                    }
                    return;
                }
                TaoLog.e(WVAPI.PluginName.API_BASE, "plusUT: parameter error, param=" + str);
                wVResult.setResult("HY_PARAM_ERR");
                wVCallBackContext.error(wVResult);
                return;
            }
        } catch (JSONException unused2) {
        }
        z = false;
        WVResult wVResult2 = new WVResult();
        if (!z) {
        }
    }
}
