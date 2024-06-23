package com.ali.user.open.ucc.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.model.LoginDataModel;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.OauthService;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccServiceProvider;
import com.ali.user.open.ucc.biz.UccBindPresenter;
import com.ali.user.open.ucc.biz.UccH5Presenter;
import com.ali.user.open.ucc.model.UccParams;
import com.ali.user.open.ucc.util.UTHitConstants;
import com.ali.user.open.ucc.util.UTHitUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.security.util.SignConstants;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
public abstract class BaseUccServiceProvider implements UccServiceProvider {
    public static final String TAG = "TaobaoUccServiceProviderImpl";

    private void authByNatvie(final Activity activity, final UccParams uccParams, AppCredential appCredential, final Map<String, String> map, final UccCallback uccCallback) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(ParamsConstants.Key.PARAM_ONLY_AUTHCODE, "1");
        map.put(ParamsConstants.Key.PARAM_IS_BIND, "1");
        map.put(ParamsConstants.Key.PARAM_TRACE_ID, uccParams.traceId);
        map.put("userToken", uccParams.userToken);
        ((OauthService) AliMemberSDK.getService(OauthService.class)).oauth(activity, uccParams.bindSite, map, new OauthCallback() {
            /* class com.ali.user.open.ucc.base.BaseUccServiceProvider.AnonymousClass1 */

            private void resultHit(String str) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GoOauthResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.oauth.OauthCallback
            public void onFail(String str, int i, String str2) {
                resultHit(i + "");
                if (i == 10003 || i == 15) {
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_Cancel", uccParams, new HashMap());
                } else if (i == 1011) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("needSession", "1");
                    UccBindPresenter instance = UccBindPresenter.getInstance();
                    Activity activity = activity;
                    UccParams uccParams = uccParams;
                    instance.getUserInfo(activity, uccParams, uccParams.userToken, "userToken", "native", hashMap, uccCallback);
                }
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(str, i, str2);
                }
            }

            @Override // com.ali.user.open.oauth.OauthCallback
            public void onSuccess(String str, Map map) {
                resultHit("3000");
                String str2 = (String) map.get(SignConstants.MIDDLE_PARAM_AUTHCODE);
                String str3 = (String) map.get(XStateConstants.KEY_ACCESS_TOKEN);
                UccBindPresenter.getInstance().bindByNativeAuth(activity, uccParams, TextUtils.isEmpty(str3) ? str2 : str3, TextUtils.isEmpty(str3) ? "oauthcode" : HttpHeaderConstant.KEY_EXTDATA_ACCESSTOKEN, map, uccCallback);
            }
        });
    }

    private void authByNatvieWithIbb(final Activity activity, final UccParams uccParams, final Map<String, String> map, final UccCallback uccCallback) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(ParamsConstants.Key.PARAM_TRACE_ID, uccParams.traceId);
        ((OauthService) AliMemberSDK.getService(OauthService.class)).oauth(activity, uccParams.bindSite, map, new OauthCallback() {
            /* class com.ali.user.open.ucc.base.BaseUccServiceProvider.AnonymousClass2 */

            private void resultHit(String str) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBindWithIbb_GoOauthResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.oauth.OauthCallback
            public void onFail(String str, int i, String str2) {
                resultHit(i + "");
                if (i == 10003 || i == 15) {
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBindWithIbb_Cancel", uccParams, null);
                } else if (i == 1011) {
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBindWithIbb_NativeSkip", uccParams, null);
                }
                UccCallback uccCallback = uccCallback;
                if (uccCallback != null) {
                    uccCallback.onFail(str, i, str2);
                }
            }

            @Override // com.ali.user.open.oauth.OauthCallback
            public void onSuccess(String str, Map map) {
                resultHit("3000");
                UccBindPresenter.getInstance().getUserInfo(activity, uccParams, (String) map.get(SignConstants.MIDDLE_PARAM_AUTHCODE), "oauthcode", "native", map, uccCallback);
            }
        });
    }

    @Override // com.ali.user.open.ucc.UccServiceProvider
    public void applyToken(UccParams uccParams, Map<String, String> map, UccCallback uccCallback) {
        if (Site.isHavanaSite(uccParams.bindSite)) {
            UccBindPresenter.getInstance().applyToken(uccParams, "native", map, uccCallback);
        } else {
            uccCallback.onFail(uccParams.bindSite, 1601, "unsupportedSite");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00eb, code lost:
        if (isAuthByNative(r12, r13.bindSite, r15) == false) goto L_0x00ef;
     */
    @Override // com.ali.user.open.ucc.UccServiceProvider
    public void bind(Activity activity, UccParams uccParams, AppCredential appCredential, Map<String, String> map, UccCallback uccCallback) {
        if ((uccParams == null || TextUtils.isEmpty(uccParams.userToken)) && (map == null || TextUtils.isEmpty(map.get("requestToken")))) {
            UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_InvalidParams", uccParams, null);
            if (uccCallback != null) {
                uccCallback.onFail(uccParams.bindSite, 102, "参数错误");
            }
        } else if (map != null && !TextUtils.isEmpty(map.get(SignConstants.MIDDLE_PARAM_AUTHCODE))) {
            HashMap hashMap = new HashMap();
            String str = map.get(SignConstants.MIDDLE_PARAM_AUTHCODE);
            hashMap.put(SignConstants.MIDDLE_PARAM_AUTHCODE, str);
            map.put(ParamsConstants.Key.PARAM_ONLY_AUTHCODE, "1");
            map.put(ParamsConstants.Key.PARAM_IS_BIND, "1");
            map.put(ParamsConstants.Key.PARAM_TRACE_ID, uccParams.traceId);
            map.put("userToken", uccParams.userToken);
            UccBindPresenter.getInstance().bindByNativeAuth(activity, uccParams, str, "oauthcode", map, uccCallback);
        } else if (map == null || TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_BIND_TOKEN))) {
            boolean isH5OnlyBindSites = ConfigManager.getInstance().isH5OnlyBindSites(uccParams.bindSite);
            boolean z = false;
            if (map != null && !TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_H5ONLY))) {
                if (TextUtils.equals(map.get(ParamsConstants.Key.PARAM_H5ONLY), "1")) {
                    isH5OnlyBindSites = true;
                } else if (TextUtils.equals(map.get(ParamsConstants.Key.PARAM_H5ONLY), "0")) {
                    isH5OnlyBindSites = false;
                }
            }
            if (!isH5OnlyBindSites) {
            }
            z = true;
            if (z || (map != null && TextUtils.equals(map.get(ParamsConstants.Key.PARAM_ENABLE_RECOMMEND_BIND), "true"))) {
                UccH5Presenter.showH5BindPage(activity, uccParams, map, z, uccCallback);
                return;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("from", "bind");
            if (map != null) {
                hashMap2.put("scene", map.get("scene"));
                hashMap2.put("needSession", TextUtils.equals(map.get("needSession"), "1") ? "T" : UTConstant.Args.UT_SUCCESS_F);
            }
            UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GoOauthBindAction", uccParams, hashMap2);
            authByNatvie(activity, uccParams, appCredential, map, uccCallback);
        } else {
            map.put(ParamsConstants.Key.PARAM_TRACE_ID, uccParams.traceId);
            map.put("userToken", uccParams.userToken);
            String str2 = map.get(ParamsConstants.Key.PARAM_BIND_TOKEN_TYPE);
            if (TextUtils.isEmpty(str2)) {
                str2 = "oauthcode";
            }
            UccBindPresenter.getInstance().bindByNativeAuth(activity, uccParams, map.get(ParamsConstants.Key.PARAM_BIND_TOKEN), str2, map, uccCallback);
        }
    }

    @Override // com.ali.user.open.ucc.UccServiceProvider
    public void bindWithIBB(Activity activity, UccParams uccParams, String str, Map<String, String> map, UccCallback uccCallback) {
        if (uccParams == null || TextUtils.isEmpty(str)) {
            UTHitUtils.send(UTHitConstants.PageUccBind, "UccBindWithIbb_InvalidParams", uccParams, null);
            if (uccCallback != null) {
                uccCallback.onFail(uccParams.bindSite, 102, "参数错误");
            }
        } else if (isAuthByNative(activity, uccParams.bindSite, map)) {
            HashMap hashMap = new HashMap();
            hashMap.put("from", "bind");
            if (map != null) {
                hashMap.put("scene", map.get("scene"));
                hashMap.put("needSession", TextUtils.equals(map.get("needSession"), "1") ? "T" : UTConstant.Args.UT_SUCCESS_F);
            }
            UTHitUtils.send(UTHitConstants.PageUccBind, "UccBindWithIbb_GoOauthBindAction", uccParams, hashMap);
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(ParamsConstants.Key.PARAM_SCENE_CODE, ABLogRecorderKeys.EventIdActFail);
            map.put(ParamsConstants.Key.PARAM_IBB, str);
            authByNatvieWithIbb(activity, uccParams, map, uccCallback);
        } else {
            UccH5Presenter.showH5BindPageFoeNewBind(activity, uccParams, str, map, uccCallback);
        }
    }

    @Override // com.ali.user.open.ucc.UccServiceProvider
    public Map<String, String> buildSessionInfo(String str, String str2) {
        LoginDataModel loginDataModel;
        HashMap hashMap = new HashMap();
        if (Site.isHavanaSite(str)) {
            try {
                LoginReturnData loginReturnData = (LoginReturnData) JSON.parseObject(str2, LoginReturnData.class);
                if (!(loginReturnData == null || (loginDataModel = (LoginDataModel) JSON.parseObject(loginReturnData.data, LoginDataModel.class)) == null)) {
                    hashMap.put("openId", loginDataModel.openId);
                    hashMap.put(ParamsConstants.Key.PARAM_BIND_TOKEN, loginDataModel.bindToken);
                    hashMap.put(XStateConstants.KEY_ACCESS_TOKEN, loginDataModel.topAccessToken);
                    hashMap.put(SignConstants.MIDDLE_PARAM_AUTHCODE, loginDataModel.topAuthCode);
                    hashMap.put("userId", loginDataModel.userId);
                    hashMap.put("sid", loginDataModel.sid);
                    hashMap.put("nick", loginDataModel.nick);
                    hashMap.put("avatarUrl", loginDataModel.headPicLink);
                    hashMap.put("openSid", loginDataModel.openSid);
                }
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    @Override // com.ali.user.open.ucc.UccServiceProvider
    public void cleanUp(Context context) {
    }

    /* access modifiers changed from: protected */
    public abstract boolean isAuthByNative(Context context, String str, Map<String, String> map);

    @Override // com.ali.user.open.ucc.UccServiceProvider
    public void logout(Context context) {
    }

    @Override // com.ali.user.open.ucc.UccServiceProvider
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.ali.user.open.ucc.UccServiceProvider
    public void refreshWhenLogin(String str, String str2, boolean z) {
        ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshCookie(str, (LoginReturnData) JSON.parseObject(str2, LoginReturnData.class));
    }
}
