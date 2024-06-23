package com.youku.usercenter.passport;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.model.RpcRequest;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.service.RpcService;
import com.ali.user.open.core.util.RiskControlInfoContext;
import com.alibaba.fastjson.JSON;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.usercenter.passport.PassportManager;
import com.youku.usercenter.passport.callback.ICallback;
import com.youku.usercenter.passport.net.NetRequest;
import com.youku.usercenter.passport.result.ConfigResult;
import com.youku.usercenter.passport.result.Result;
import com.youku.usercenter.passport.result.UserProfileDto;
import com.youku.usercenter.passport.result.VerifyCookieRequest;
import com.youku.usercenter.passport.result.VerifyCookieResponse;
import com.youku.usercenter.passport.result.VerifyCookieResult;
import com.youku.usercenter.passport.statistics.Statistics;
import com.youku.usercenter.passport.util.CookieUtil;
import com.youku.usercenter.passport.util.EncryptUtil;
import com.youku.usercenter.passport.util.Logger;
import com.youku.usercenter.passport.util.MiscUtil;
import com.youku.usercenter.passport.util.RequestUtil;
import com.youku.usercenter.passport.util.SysUtil;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import mtopsdk.common.util.HttpHeaderConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class PassportProcessor {
    public static final int AES_END = 24;
    public static final int AES_START = 8;
    public static final String TAG = "Passport.processor";
    public PassportConfig mConfig;
    public Context mContext;

    public PassportProcessor(Context context, PassportConfig passportConfig) {
        this.mContext = context;
        this.mConfig = passportConfig;
    }

    public void extendCookie(final ICallback<Result> iCallback) {
        if (iCallback != null) {
            final Result result = new Result();
            if (!SysUtil.hasActiveNetwork(this.mContext)) {
                result.setResultCode(-102);
                iCallback.onFailure(result);
                return;
            }
            try {
                Account account = PassportManager.getInstance().getAccount();
                NetRequest netRequest = new NetRequest(this.mContext);
                final String valueOf = String.valueOf(new Random().nextLong());
                String substring = EncryptUtil.encryptMD5(this.mConfig.mAppId + SysUtil.getDeviceId(this.mContext) + valueOf, true).substring(8, 24);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ptoken", EncryptUtil.encryptAES(account.mPToken, substring));
                jSONObject.put(CookieUtil.COOKIE_KEY_YKTK, account.mYktk);
                RequestUtil.addBasicInfo(jSONObject, this.mContext, this.mConfig.mAppId, valueOf);
                RequestUtil.addDeviceInfo(jSONObject, this.mContext);
                netRequest.setPostData(RequestUtil.formatPost(jSONObject.toString()));
                netRequest.startRequest(ApiGenerator.create().getExtendCookieApi(), new NetRequest.IRequestCallback() {
                    /* class com.youku.usercenter.passport.PassportProcessor.AnonymousClass3 */

                    @Override // com.youku.usercenter.passport.net.NetRequest.IRequestCallback
                    public void onFailure(int i) {
                        result.setResultCode(i);
                        iCallback.onFailure(result);
                    }

                    @Override // com.youku.usercenter.passport.net.NetRequest.IRequestCallback
                    public void onSuccess(Map<String, List<String>> map, byte[] bArr) {
                        JSONObject jSONObject;
                        boolean z;
                        String str;
                        boolean z2;
                        String str2;
                        try {
                            JSONObject response = PassportProcessor.this.getResponse(bArr);
                            int i = response.getInt("resultCode");
                            String optString = response.optString("resultMsg");
                            if (i != 0) {
                                result.setResultCode(i);
                                result.setResultMsg(optString);
                                iCallback.onFailure(result);
                                return;
                            }
                            JSONObject jSONObject2 = response.getJSONObject("content");
                            String optString2 = jSONObject2.optString("ptoken");
                            String optString3 = jSONObject2.optString(CookieUtil.COOKIE_KEY_YKTK);
                            String optString4 = jSONObject2.optString("ytid");
                            String optString5 = jSONObject2.optString("yid");
                            String optString6 = jSONObject2.optString("tid");
                            String optString7 = jSONObject2.optString("uid");
                            String optString8 = jSONObject2.optString("nickname");
                            String optString9 = jSONObject2.optString("avatarUrl");
                            long j = jSONObject2.getLong("cookieExpireTime");
                            JSONObject optJSONObject = jSONObject2.optJSONObject("sdkCookieInfo");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("profile");
                            String str3 = null;
                            if (optJSONObject2 != null) {
                                str3 = optJSONObject2.optString("email");
                                str = optJSONObject2.optString(RegistConstants.REGION_INFO);
                                String optString10 = optJSONObject2.optString("mobile");
                                z2 = optJSONObject2.optBoolean("hasMobile");
                                z = optJSONObject2.optBoolean("isLoginMobile");
                                str2 = optString10;
                                jSONObject = optJSONObject;
                            } else {
                                jSONObject = optJSONObject;
                                str2 = null;
                                str = null;
                                z2 = false;
                                z = false;
                            }
                            String decryptAES = EncryptUtil.decryptAES(optString2, EncryptUtil.encryptMD5(PassportProcessor.this.mConfig.mAppId + SysUtil.getDeviceId(PassportProcessor.this.mContext) + valueOf, true).substring(8, 24));
                            if (!PassportManager.getInstance().isLogin()) {
                                result.setResultMsg("in logout state when get refresh cookie, stay this state!");
                                iCallback.onSuccess(result);
                                return;
                            }
                            Account account = PassportManager.getInstance().getAccount();
                            account.mPToken = decryptAES;
                            account.mYktk = optString3;
                            account.mYtid = optString4;
                            account.mYid = optString5;
                            account.mTid = optString6;
                            account.mYoukuUid = optString7;
                            account.mNickName = optString8;
                            account.mAvatarUrl = optString9;
                            account.mExpireTime = j;
                            account.mEmail = str3;
                            account.mRegion = str;
                            account.mMobile = str2;
                            account.mBoundMobile = z2;
                            account.mIsLoginMobile = z;
                            account.updateExtraCookie(jSONObject);
                            account.refreshSToken();
                            if (TextUtils.isEmpty(decryptAES)) {
                                CookieUtil.clearStoken(PassportProcessor.this.mContext);
                                account.refreshCookie();
                            } else {
                                PassportManager.getInstance().startRefreshTask();
                            }
                            account.save();
                            PassportPreference.getInstance(PassportProcessor.this.mContext).setCookieRefreshTime(PassportManager.getInstance().getTimestamp());
                            result.setResultCode(0);
                            iCallback.onSuccess(result);
                            AdapterForTLog.loge("YKLogin.refreshCookie", "pToken is empty = " + TextUtils.isEmpty(decryptAES) + " yktk is empty = " + TextUtils.isEmpty(optString3));
                        } catch (Exception e) {
                            result.setResultCode(-101);
                            Logger.printStackTrace(e);
                            iCallback.onFailure(result);
                        }
                    }
                });
            } catch (Exception e) {
                iCallback.onFailure(result);
                Logger.printStackTrace(e);
            }
        } else {
            throw new IllegalArgumentException(ICallback.class.getSimpleName() + " can't be null");
        }
    }

    public void getGlobalConfig(final ICallback<ConfigResult> iCallback) {
        if (iCallback != null) {
            final ConfigResult configResult = new ConfigResult();
            if (!SysUtil.hasActiveNetwork(this.mContext)) {
                configResult.setResultCode(-102);
                iCallback.onFailure(configResult);
                return;
            }
            try {
                NetRequest netRequest = new NetRequest(this.mContext);
                String valueOf = String.valueOf(new Random().nextLong());
                JSONObject jSONObject = new JSONObject();
                RequestUtil.addBasicInfo(jSONObject, this.mContext, this.mConfig.mAppId, valueOf);
                RequestUtil.addDeviceInfo(jSONObject, this.mContext);
                netRequest.setPostData(RequestUtil.formatPost(jSONObject.toString()));
                netRequest.startRequest(ApiGenerator.create().getConfigApi(), new NetRequest.IRequestCallback() {
                    /* class com.youku.usercenter.passport.PassportProcessor.AnonymousClass4 */

                    @Override // com.youku.usercenter.passport.net.NetRequest.IRequestCallback
                    public void onFailure(int i) {
                        configResult.setResultCode(i);
                        iCallback.onFailure(configResult);
                    }

                    @Override // com.youku.usercenter.passport.net.NetRequest.IRequestCallback
                    public void onSuccess(Map<String, List<String>> map, byte[] bArr) {
                        try {
                            PassportProcessor.this.getServerTime(map);
                            JSONObject response = PassportProcessor.this.getResponse(bArr);
                            int i = response.getInt("resultCode");
                            String optString = response.optString("resultMsg");
                            if (i != 0) {
                                configResult.setResultCode(i);
                                configResult.setResultMsg(optString);
                                iCallback.onFailure(configResult);
                                return;
                            }
                            JSONObject jSONObject = response.getJSONObject("content");
                            jSONObject.remove("timestamp");
                            configResult.mConfigData = jSONObject.toString();
                            configResult.setResultCode(0);
                            iCallback.onSuccess(configResult);
                        } catch (Exception e) {
                            configResult.setResultCode(-101);
                            Logger.printStackTrace(e);
                            iCallback.onFailure(configResult);
                        }
                    }
                });
            } catch (Exception e) {
                iCallback.onFailure(configResult);
                Logger.printStackTrace(e);
            }
        } else {
            throw new IllegalArgumentException(ICallback.class.getSimpleName() + " can't be null");
        }
    }

    public JSONObject getResponse(byte[] bArr) throws JSONException {
        JSONObject jSONObject = new JSONObject(new String(bArr)).getJSONObject("data");
        RequestUtil.updateSessionId(jSONObject);
        return jSONObject;
    }

    public long getServerTime(Map<String, List<String>> map) {
        if (map == null) {
            return 0;
        }
        try {
            List<String> list = map.get(HttpHeaderConstant.DATE);
            if (list == null) {
                list = map.get("date");
            }
            long time = new Date(list.get(0)).getTime();
            PassportManager.getInstance().updateSyncTime(time);
            return time;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void havanaVerifyCookie(final ICallback<VerifyCookieResult> iCallback) {
        if (iCallback != null) {
            Account account = PassportManager.getInstance().getAccount();
            final VerifyCookieResult verifyCookieResult = new VerifyCookieResult();
            if (!SysUtil.hasActiveNetwork(this.mContext)) {
                verifyCookieResult.setResultCode(-102);
                iCallback.onFailure(verifyCookieResult);
                return;
            }
            try {
                RpcRequest rpcRequest = new RpcRequest();
                rpcRequest.target = ApiGenerator.HAVANA_VERIFY_COOKIE;
                rpcRequest.version = "1.0";
                VerifyCookieRequest verifyCookieRequest = new VerifyCookieRequest();
                verifyCookieRequest.stoken = account.getSToken();
                String encryptedYtid = PassportPreference.getInstance(this.mContext).getEncryptedYtid();
                if (TextUtils.isEmpty(encryptedYtid) || TextUtils.equals(encryptedYtid, "null")) {
                    verifyCookieRequest.needEncryptYtid = true;
                }
                rpcRequest.addParam("request", JSON.toJSONString(verifyCookieRequest));
                rpcRequest.addParam("riskControlInfo", RiskControlInfoContext.buildRiskControlInfo());
                ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, VerifyCookieResponse.class, new RpcRequestCallbackWithCode() {
                    /* class com.youku.usercenter.passport.PassportProcessor.AnonymousClass1 */

                    @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                    public void onError(String str, RpcResponse rpcResponse) {
                        if (rpcResponse != null) {
                            int i = rpcResponse.code;
                            if (14034 == i) {
                                verifyCookieResult.setResultCode(400);
                            } else if (14094 == i) {
                                verifyCookieResult.setResultCode(VerifyCookieResult.COOKIE_SDK_STOKEN_EXPIRE);
                            }
                            iCallback.onFailure(verifyCookieResult);
                        }
                    }

                    @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                    public void onSuccess(RpcResponse rpcResponse) {
                        T t;
                        boolean z;
                        String str;
                        String str2;
                        boolean z2;
                        if (rpcResponse == null || (t = rpcResponse.returnValue) == null) {
                            onSystemError("", rpcResponse);
                            return;
                        }
                        T t2 = t;
                        verifyCookieResult.mCurrentTime = t2.t;
                        String str3 = t2.uid;
                        String str4 = t2.ytid;
                        String str5 = t2.yid;
                        String str6 = t2.tid;
                        String str7 = t2.yktk;
                        Map<String, Object> map = t2.sdkCookieInfo;
                        String str8 = t2.nickName;
                        String str9 = t2.avatarUrl;
                        UserProfileDto userProfileDto = t2.profile;
                        String str10 = null;
                        if (userProfileDto != null) {
                            str10 = userProfileDto.email;
                            str2 = userProfileDto.region;
                            str = userProfileDto.mobile;
                            z = !TextUtils.isEmpty(str);
                            z2 = userProfileDto.isLoginMobile;
                        } else {
                            str2 = null;
                            str = null;
                            z2 = false;
                            z = false;
                        }
                        String str11 = t2.encryptYtId;
                        if (!TextUtils.isEmpty(str11)) {
                            PassportPreference.getInstance(PassportProcessor.this.mContext).setEncryptedYtId(str11);
                        }
                        Account account = PassportManager.getInstance().getAccount();
                        try {
                            account.updateExtraCookie(new JSONObject(JSON.toJSONString(map)));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        account.updateYktk(str7);
                        account.refreshCookie();
                        if (!TextUtils.equals(account.mYtid, str4) || !TextUtils.equals(account.mYid, str5) || !TextUtils.equals(account.mTid, str6) || !TextUtils.equals(account.mYoukuUid, str3) || !TextUtils.equals(account.mNickName, str8) || !TextUtils.equals(account.mAvatarUrl, str9) || !TextUtils.equals(account.mEmail, str10) || !TextUtils.equals(account.mRegion, str2) || !TextUtils.equals(account.mMobile, str) || account.mBoundMobile != z || account.mIsLoginMobile != z2) {
                            if (!TextUtils.isEmpty(str4)) {
                                account.mYtid = str4;
                            }
                            if (!TextUtils.isEmpty(str5)) {
                                account.mYid = str5;
                            }
                            if (!TextUtils.isEmpty(str6)) {
                                account.mTid = str6;
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                account.mYoukuUid = str3;
                            }
                            account.mNickName = str8;
                            account.mAvatarUrl = str9;
                            account.mEmail = str10;
                            account.mRegion = str2;
                            account.mMobile = str;
                            account.mBoundMobile = z;
                            account.mIsLoginMobile = z2;
                            account.save();
                        }
                        verifyCookieResult.setResultCode(0);
                        iCallback.onSuccess(verifyCookieResult);
                    }

                    @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                    public void onSystemError(String str, RpcResponse rpcResponse) {
                        verifyCookieResult.setResultCode(-101);
                        iCallback.onFailure(verifyCookieResult);
                    }
                });
            } catch (Exception e) {
                verifyCookieResult.setResultCode(-101);
                iCallback.onFailure(verifyCookieResult);
                Logger.printStackTrace(e);
            }
        } else {
            throw new IllegalArgumentException(ICallback.class.getSimpleName() + " can't be null");
        }
    }

    public void logout(String str) {
        boolean isFingerprintAuthEnabled = PassportManager.getInstance().isFingerprintAuthEnabled();
        AdapterForTLog.loge("YKLogin.logout", "Passport logout called! From = " + str + " FingerprintAuth = " + isFingerprintAuthEnabled + " trace = " + SysUtil.readThreadStack());
        Account account = PassportManager.getInstance().getAccount();
        String sToken = account.getSToken();
        String str2 = account.mYktk;
        account.clearAccount(true);
        PassportManager.getInstance().stopRefreshTask();
        try {
            NetRequest netRequest = new NetRequest(this.mContext);
            this.mConfig.userMtop();
            netRequest.addCookie("P_sck", sToken);
            if (!TextUtils.isEmpty(str2)) {
                netRequest.addCookie(CookieUtil.COOKIE_KEY_YKTK, str2);
            }
            String valueOf = String.valueOf(new Random().nextLong());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("referAction", str);
            jSONObject.put(IRequestConst.STOKEN, sToken);
            jSONObject.put(CookieUtil.COOKIE_KEY_YKTK, str2);
            RequestUtil.addBasicInfo(jSONObject, this.mContext, this.mConfig.mAppId, valueOf);
            RequestUtil.addDeviceInfo(jSONObject, this.mContext);
            RequestUtil.addExtraInfo(jSONObject, this.mContext);
            netRequest.setPostData(RequestUtil.formatPost(jSONObject.toString()));
            netRequest.startRequest(ApiGenerator.create().getLogoutApi(), null);
        } catch (Throwable th) {
            Logger.printStackTrace(th);
        }
        PassportManager.getInstance().updateAuthorizeStatus(PassportManager.AuthorizeStatus.USER_LOGOUT);
        PassportPreference.getInstance(this.mContext).setLoginUtdid("");
        PassportPreference.getInstance(this.mContext).setEncryptedYtId("");
        AdapterForTLog.loge("YKLogin.logout", "Broadcast User logout");
        MiscUtil.logoutTaobao(null);
    }

    public void processLoginResult(JSONObject jSONObject, String str, String str2) throws Exception {
        boolean z;
        JSONObject jSONObject2;
        boolean z2;
        String str3;
        String str4;
        String str5;
        String optString = jSONObject.optString("ptoken");
        String optString2 = jSONObject.optString(CookieUtil.COOKIE_KEY_YKTK);
        String optString3 = jSONObject.optString("ytid");
        String optString4 = jSONObject.optString("yid");
        String optString5 = jSONObject.optString("tid");
        String optString6 = jSONObject.optString("uid");
        String optString7 = jSONObject.optString("nickname");
        String optString8 = jSONObject.optString("avatarUrl");
        long optLong = jSONObject.optLong("cookieExpireTime");
        JSONObject optJSONObject = jSONObject.optJSONObject("sdkCookieInfo");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("profile");
        if (optJSONObject2 != null) {
            String optString9 = optJSONObject2.optString("email");
            str3 = optJSONObject2.optString(RegistConstants.REGION_INFO);
            String optString10 = optJSONObject2.optString("mobile");
            boolean optBoolean = optJSONObject2.optBoolean("hasMobile");
            z = optJSONObject2.optBoolean("isLoginMobile");
            str5 = optString10;
            jSONObject2 = optJSONObject;
            str4 = optString9;
            z2 = optBoolean;
        } else {
            jSONObject2 = optJSONObject;
            str5 = null;
            str4 = null;
            str3 = null;
            z2 = false;
            z = false;
        }
        String decryptAES = EncryptUtil.decryptAES(optString, EncryptUtil.encryptMD5(this.mConfig.mAppId + SysUtil.getDeviceId(this.mContext) + str2, true).substring(8, 24));
        Account account = PassportManager.getInstance().getAccount();
        account.saveOrClearLastAccount(false);
        account.mPToken = decryptAES;
        account.mUserName = str;
        account.mYktk = optString2;
        account.mYtid = optString3;
        account.mYid = optString4;
        account.mTid = optString5;
        account.mYoukuUid = optString6;
        account.mNickName = optString7;
        account.mAvatarUrl = optString8;
        account.mExpireTime = optLong;
        account.mEmail = str4;
        account.mRegion = str3;
        account.mMobile = str5;
        account.mBoundMobile = z2;
        account.mIsLoginMobile = z;
        account.updateExtraCookie(jSONObject2);
        account.refreshSToken();
        account.save();
        PassportPreference.getInstance(this.mContext).setCookieRefreshTime(PassportManager.getInstance().getTimestamp());
        if (TextUtils.isEmpty(decryptAES)) {
            CookieUtil.clearStoken(this.mContext);
            CookieUtil.syncCookie(this.mContext, null, optString2);
            account.refreshCookie();
        } else {
            PassportManager.getInstance().startRefreshTask();
        }
        AdapterForTLog.loge("YKLogin.Login", "pToken is empty = " + TextUtils.isEmpty(decryptAES) + " yktk is empty = " + TextUtils.isEmpty(optString2));
        Statistics.setLoginFrom(null);
    }

    public void verifyCookie(final ICallback<VerifyCookieResult> iCallback) {
        if (iCallback != null) {
            Account account = PassportManager.getInstance().getAccount();
            final VerifyCookieResult verifyCookieResult = new VerifyCookieResult();
            if (!SysUtil.hasActiveNetwork(this.mContext)) {
                verifyCookieResult.setResultCode(-102);
                iCallback.onFailure(verifyCookieResult);
                return;
            }
            try {
                NetRequest netRequest = new NetRequest(this.mContext);
                String valueOf = String.valueOf(new Random().nextLong());
                this.mConfig.userMtop();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(IRequestConst.STOKEN, account.getSToken());
                jSONObject.put(CookieUtil.COOKIE_KEY_YKTK, account.mYktk);
                Logger.e(TAG, "origin mtop request data:" + jSONObject.toString());
                RequestUtil.addBasicInfo(jSONObject, this.mContext, this.mConfig.mAppId, valueOf);
                RequestUtil.addDeviceInfo(jSONObject, this.mContext);
                RequestUtil.addExtraInfo(jSONObject, this.mContext);
                netRequest.addCookie("P_sck", account.getSToken());
                netRequest.addCookie(CookieUtil.COOKIE_KEY_YKTK, account.mYktk);
                netRequest.setPostData(RequestUtil.formatPost(jSONObject.toString()));
                netRequest.startRequest(ApiGenerator.create().getVerifyCookieApi(), new NetRequest.IRequestCallback() {
                    /* class com.youku.usercenter.passport.PassportProcessor.AnonymousClass2 */

                    @Override // com.youku.usercenter.passport.net.NetRequest.IRequestCallback
                    public void onFailure(int i) {
                        verifyCookieResult.setResultCode(i);
                        iCallback.onFailure(verifyCookieResult);
                    }

                    @Override // com.youku.usercenter.passport.net.NetRequest.IRequestCallback
                    public void onSuccess(Map<String, List<String>> map, byte[] bArr) {
                        boolean z;
                        boolean z2;
                        String str;
                        String str2;
                        try {
                            verifyCookieResult.mCurrentTime = PassportProcessor.this.getServerTime(map);
                            JSONObject response = PassportProcessor.this.getResponse(bArr);
                            int i = response.getInt("resultCode");
                            String optString = response.optString("resultMsg");
                            if (i != 0) {
                                verifyCookieResult.setResultCode(i);
                                verifyCookieResult.setResultMsg(optString);
                                iCallback.onFailure(verifyCookieResult);
                                return;
                            }
                            JSONObject optJSONObject = response.optJSONObject("content");
                            if (optJSONObject != null) {
                                String optString2 = optJSONObject.optString("uid");
                                String optString3 = optJSONObject.optString("ytid");
                                String optString4 = optJSONObject.optString("yid");
                                String optString5 = optJSONObject.optString("tid");
                                String optString6 = optJSONObject.optString(CookieUtil.COOKIE_KEY_YKTK);
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("sdkCookieInfo");
                                String optString7 = optJSONObject.optString("nickname");
                                String optString8 = optJSONObject.optString("avatarUrl");
                                JSONObject optJSONObject3 = optJSONObject.optJSONObject("profile");
                                String str3 = null;
                                if (optJSONObject3 != null) {
                                    str3 = optJSONObject3.optString("email");
                                    str2 = optJSONObject3.optString(RegistConstants.REGION_INFO);
                                    str = optJSONObject3.optString("mobile");
                                    z2 = optJSONObject3.optBoolean("hasMobile");
                                    z = optJSONObject3.optBoolean("isLoginMobile");
                                } else {
                                    str2 = null;
                                    str = null;
                                    z = false;
                                    z2 = false;
                                }
                                Account account = PassportManager.getInstance().getAccount();
                                account.updateExtraCookie(optJSONObject2);
                                account.updateYktk(optString6);
                                account.refreshCookie();
                                if (!TextUtils.equals(account.mYtid, optString3) || !TextUtils.equals(account.mYid, optString4) || !TextUtils.equals(account.mTid, optString5) || !TextUtils.equals(account.mYoukuUid, optString2) || !TextUtils.equals(account.mNickName, optString7) || !TextUtils.equals(account.mAvatarUrl, optString8) || !TextUtils.equals(account.mEmail, str3) || !TextUtils.equals(account.mRegion, str2) || !TextUtils.equals(account.mMobile, str) || account.mBoundMobile != z2 || account.mIsLoginMobile != z) {
                                    account.mYtid = optString3;
                                    account.mYid = optString4;
                                    account.mTid = optString5;
                                    account.mYoukuUid = optString2;
                                    account.mNickName = optString7;
                                    account.mAvatarUrl = optString8;
                                    account.mEmail = str3;
                                    account.mRegion = str2;
                                    account.mMobile = str;
                                    account.mBoundMobile = z2;
                                    account.mIsLoginMobile = z;
                                    account.save();
                                }
                            }
                            verifyCookieResult.setResultCode(0);
                            iCallback.onSuccess(verifyCookieResult);
                        } catch (Exception e) {
                            verifyCookieResult.setResultCode(-101);
                            Logger.printStackTrace(e);
                            iCallback.onFailure(verifyCookieResult);
                        }
                    }
                });
            } catch (Exception e) {
                iCallback.onFailure(verifyCookieResult);
                Logger.printStackTrace(e);
            }
        } else {
            throw new IllegalArgumentException(ICallback.class.getSimpleName() + " can't be null");
        }
    }
}
