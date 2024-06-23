package com.ali.user.open.oauth.alipay3;

import android.text.TextUtils;
import cn.damai.pay.alipay.AlixDefine;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.device.DeviceInfo;
import com.ali.user.open.core.model.RpcRequest;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.model.UccBaseRequest;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.service.RpcService;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.core.util.RiskControlInfoContext;
import com.ali.user.open.oauth.alipay3.model.UccMtopGenerateAlipayAuthUrlRequest;
import com.ali.user.open.oauth.alipay3.model.UccMtopGenerateAlipayAuthUrlResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class AlipayRpcPresenter {
    public static void buildBaseUccRequest(UccBaseRequest uccBaseRequest) {
        uccBaseRequest.appName = ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey();
        uccBaseRequest.appVersion = CommonUtils.getAndroidAppVersion();
        uccBaseRequest.deviceName = Build.getMODEL();
        uccBaseRequest.sdkVersion = KernelContext.getSdkVersion();
        uccBaseRequest.utdid = DeviceInfo.deviceId;
        uccBaseRequest.locale = DeviceInfo.getLocale(KernelContext.applicationContext);
    }

    public static void getAlipayInsideSign(Map<String, String> map, final GetSignCallback getSignCallback) {
        getAlipayInsideSignRequest(map, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.oauth.alipay3.AlipayRpcPresenter.AnonymousClass2 */

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                CommonUtils.onFailure(getSignCallback, rpcResponse.code, rpcResponse.message);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
                r3 = r3;
             */
            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                final T t;
                if (rpcResponse != null && (r3 = rpcResponse.returnValue) != null && t != null && !TextUtils.isEmpty(t.returnUrl) && getSignCallback != null) {
                    ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                        /* class com.ali.user.open.oauth.alipay3.AlipayRpcPresenter.AnonymousClass2.AnonymousClass1 */

                        public void run() {
                            getSignCallback.onGetSignSuccessed(t.returnUrl);
                        }
                    });
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                CommonUtils.onFailure(getSignCallback, rpcResponse.code, rpcResponse.message);
            }
        });
    }

    public static void getAlipayInsideSignRequest(Map<String, String> map, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.alibaba.ucc.getalipayauthurl";
        rpcRequest.version = "1.0";
        UccMtopGenerateAlipayAuthUrlRequest uccMtopGenerateAlipayAuthUrlRequest = new UccMtopGenerateAlipayAuthUrlRequest();
        buildBaseUccRequest(uccMtopGenerateAlipayAuthUrlRequest);
        uccMtopGenerateAlipayAuthUrlRequest.site = AliMemberSDK.getMasterSite();
        if (map != null && !TextUtils.isEmpty(map.get("userToken"))) {
            uccMtopGenerateAlipayAuthUrlRequest.userToken = map.get("userToken");
        }
        rpcRequest.addParam("request", JSON.toJSONString(uccMtopGenerateAlipayAuthUrlRequest));
        rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, UccMtopGenerateAlipayAuthUrlResponse.class, rpcRequestCallbackWithCode);
    }

    public static void getAlipaySign(final GetSignCallback getSignCallback, SignRequest signRequest) {
        getAlipaySign(signRequest, new RpcRequestCallbackWithCode() {
            /* class com.ali.user.open.oauth.alipay3.AlipayRpcPresenter.AnonymousClass1 */

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                CommonUtils.onFailure(getSignCallback, rpcResponse.code, rpcResponse.message);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                T t;
                if (rpcResponse == null || (t = rpcResponse.returnValue) == null) {
                    CommonUtils.onFailure(getSignCallback, 203, "");
                    return;
                }
                final String str = t.queryUrlArgs;
                if (getSignCallback != null) {
                    ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
                        /* class com.ali.user.open.oauth.alipay3.AlipayRpcPresenter.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            getSignCallback.onGetSignSuccessed(str);
                        }
                    });
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                CommonUtils.onFailure(getSignCallback, rpcResponse.code, rpcResponse.message);
            }
        });
    }

    public static void getAlipaySign(SignRequest signRequest, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.taobao.login.signForAlipaySNSLogin";
        rpcRequest.version = "1.0";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appName", ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey());
            jSONObject.put("appVersion", CommonUtils.getAndroidAppVersion());
            jSONObject.put("ttid", "android_1.0.2");
            jSONObject.put("utdid", DeviceInfo.deviceId);
            jSONObject.put("sdkVersion", KernelContext.getSdkVersion());
            jSONObject.put("deviceId", DeviceInfo.deviceId);
            jSONObject.put("site", Site.getHavanaSite(AliMemberSDK.getMasterSite()));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("target_id", signRequest.target_id);
            jSONObject2.put("pid", signRequest.pid);
            jSONObject2.put("app_id", signRequest.app_id);
            jSONObject2.put(AlixDefine.sign_type, signRequest.sign_type);
            jSONObject2.put("scope", TextUtils.isEmpty(signRequest.scope) ? "auth_user" : signRequest.scope);
            jSONObject2.put("apiVersion", "2.0");
            try {
                jSONObject2.put("deviceName", Build.getMODEL());
            } catch (Exception e) {
                e.printStackTrace();
            }
            jSONObject.put("ext", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        rpcRequest.addParam("loginInfo", jSONObject.toString());
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, SignResult.class, rpcRequestCallbackWithCode);
    }
}
