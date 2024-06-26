package com.taobao.android.sns4android.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.service.SNSBindService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.open.core.Site;
import com.ali.user.open.jsbridge.UccJsBridge;
import com.taobao.android.sns4android.SNSAuth;
import com.taobao.android.sns4android.SNSPlatform;
import com.youku.passport.libs.TlSite;
import org.json.JSONObject;

/* compiled from: Taobao */
public class AccountBindJSBridge extends WVApiPlugin {
    public static int PARAM_ERROR_CODE = 1003;
    public static String PARAM_ERROR_MESSAGE = "E_PARAM_ERROR";
    protected WVCallBackContext mCallback;
    protected String mTargetSite;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements CommonCallback {
        a() {
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onFail(int i, String str) {
            AccountBindJSBridge.this.setErrorCallback(i, str);
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onSuccess() {
            AccountBindJSBridge.this.setSuccessCallback();
        }
    }

    public static SNSPlatform convertSNSPlatform(String str) {
        if (TextUtils.equals(str, Site.QQ)) {
            return SNSPlatform.PLATFORM_QQ;
        }
        if (TextUtils.equals(str, "alipay") || TextUtils.equals(str, "alipay3")) {
            return SNSPlatform.PLATFORM_ALIPAY;
        }
        if (TextUtils.equals(str, Site.WEIBO) || TextUtils.equals(str, TlSite.TLSITE_WEIBO)) {
            return SNSPlatform.PLATFORM_WEIBO;
        }
        if (TextUtils.equals(str, "weixin") || TextUtils.equals(str, "wechat")) {
            return SNSPlatform.PLATFORM_WEIXIN;
        }
        if (TextUtils.equals(str, "taobao")) {
            return SNSPlatform.PLATFORM_TAOBAO;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setErrorCallback(int i, String str) {
        if (this.mCallback != null) {
            WVResult wVResult = new WVResult();
            wVResult.addData("code", Integer.valueOf(i));
            wVResult.addData("message", str);
            this.mCallback.error(wVResult);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSuccessCallback() {
        if (this.mCallback != null) {
            WVResult wVResult = new WVResult();
            wVResult.setResult(WVResult.SUCCESS);
            this.mCallback.success(wVResult);
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!"thirdPartyAuthBind".equals(str)) {
            return false;
        }
        thirdPartyAuthBind(str2, wVCallBackContext);
        return true;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11101) {
            SNSAuth.onActivityResult(SNSPlatform.PLATFORM_QQ, i, i2, intent);
            return;
        }
        SNSAuth.onActivityResult(SNSPlatform.PLATFORM_WEIBO, i, i2, intent);
        SNSAuth.onActivityResult(SNSPlatform.PLATFORM_WEIXIN, i, i2, intent);
        SNSAuth.onActivityResult(SNSPlatform.PLATFORM_ALIPAY, i, i2, intent);
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onDestroy() {
        super.onDestroy();
        if (ServiceFactory.getService(SNSBindService.class) != null) {
            ((SNSBindService) ServiceFactory.getService(SNSBindService.class)).clean();
        }
    }

    public synchronized void thirdPartyAuthBind(String str, WVCallBackContext wVCallBackContext) {
        this.mCallback = wVCallBackContext;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("platform");
            this.mTargetSite = optString;
            if (TextUtils.equals(optString, "taobao")) {
                try {
                    jSONObject.put("site", "taobao");
                    UccJsBridge.getInstance().uccBind((Activity) this.mContext, jSONObject.toString(), wVCallBackContext);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                if (TextUtils.equals(optString, "youku")) {
                    try {
                        jSONObject.put("site", "youku");
                        UccJsBridge.getInstance().uccBind((Activity) this.mContext, jSONObject.toString(), wVCallBackContext);
                        return;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (ServiceFactory.getService(SNSBindService.class) != null) {
                    ((SNSBindService) ServiceFactory.getService(SNSBindService.class)).bind((Activity) this.mContext, convertSNSPlatform(optString), new a());
                }
            }
        } catch (Exception e) {
            setErrorCallback(PARAM_ERROR_CODE, PARAM_ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
