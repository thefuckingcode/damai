package com.ali.user.mobile.login.service.impl;

import android.text.TextUtils;
import android.util.Log;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.AppMonitorAdapter;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.model.FingerprintLoginInfo;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.filter.IAfterFilter;
import com.ali.user.mobile.rpc.login.model.AliUserResponseData;
import com.ali.user.mobile.rpc.login.model.DefaultLoginResponseData;
import com.ali.user.mobile.rpc.login.model.TokenLoginRequest;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.FingerprintService;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.SharedPreferencesUtil;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Properties;

/* compiled from: Taobao */
public class FingerprintLoginServiceImpl {
    private static final String INFO_SP_KEY = "fingerprint_login_info";
    private static final String TAG = "login.FingerprintLoginService";
    private static FingerprintLoginServiceImpl instance;
    private FingerprintLoginInfo fingerprintLoginInfo;

    private void closeFingerprintInfo(FingerprintLoginInfo fingerprintLoginInfo2, boolean z) {
        fingerprintLoginInfo2.open = false;
        if (z) {
            fingerprintLoginInfo2.loginEntrance = null;
        }
        resetFingerprintInfo(fingerprintLoginInfo2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fingerprintLoginUT(LoginParam loginParam, RpcResponse rpcResponse) {
        String str;
        try {
            Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            if (rpcResponse == null || (str = rpcResponse.actionType) == null) {
                AppMonitorAdapter.commitFail("Page_Member_Login", "Login_Fingerprint", "0", UTConstant.CustomEvent.UT_NETWORK_FAIL);
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, "0", LoginType.LocalLoginType.BIO_LOGIN, properties);
            } else if ("SUCCESS".equals(str)) {
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_SUCCESS, "", LoginType.LocalLoginType.BIO_LOGIN, properties);
                AppMonitorAdapter.commitSuccess("Page_Member_Login", "Login_Fingerprint");
            } else if (!"H5".equals(rpcResponse.actionType)) {
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, "0", LoginType.LocalLoginType.BIO_LOGIN, properties);
                AppMonitorAdapter.commitFail("Page_Member_Login", "Login_Fingerprint", "0", rpcResponse.message);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            AppMonitorAdapter.commitFail("Page_Member_Login", "Login_Fingerprint", "0", UTConstant.CustomEvent.UT_NETWORK_FAIL);
        }
    }

    public static FingerprintLoginServiceImpl getInstance() {
        if (instance == null) {
            instance = new FingerprintLoginServiceImpl();
        }
        return instance;
    }

    private boolean isSupportedLoginEntrance(String str) {
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void resetFingerprintInfo(FingerprintLoginInfo fingerprintLoginInfo2) {
        if (fingerprintLoginInfo2 != null) {
            fingerprintLoginInfo2.token = null;
            fingerprintLoginInfo2.showLoginId = "";
        }
    }

    public void applyFingerprintLoginToken() {
        T t;
        FingerprintLoginInfo fingerprintLoginInfo2 = null;
        try {
            if (isFingerprintLoginAvailable()) {
                fingerprintLoginInfo2 = getFingerprintLoginInfo();
                if (!fingerprintLoginInfo2.open) {
                    return;
                }
                if (isSupportedLoginEntrance(fingerprintLoginInfo2.loginEntrance)) {
                    RpcRequest rpcRequest = new RpcRequest();
                    rpcRequest.API_NAME = ApiConstants.ApiName.FINGER_PRINT_APPLY_TOKEN;
                    rpcRequest.VERSION = "1.0";
                    rpcRequest.NEED_ECODE = true;
                    rpcRequest.NEED_SESSION = true;
                    rpcRequest.preDomain = DataProviderFactory.getDataProvider().getSessionPreDomain();
                    rpcRequest.onlineDomain = DataProviderFactory.getDataProvider().getSessionOnlineDomain();
                    TokenLoginRequest tokenLoginRequest = new TokenLoginRequest();
                    tokenLoginRequest.appName = DataProviderFactory.getDataProvider().getAppkey();
                    tokenLoginRequest.t = System.currentTimeMillis();
                    tokenLoginRequest.appVersion = AppInfo.getInstance().getAndroidAppVersion();
                    tokenLoginRequest.sdkVersion = AppInfo.getInstance().getSdkVersion();
                    rpcRequest.addParam("tokenInfo", JSON.toJSONString(tokenLoginRequest));
                    rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
                    rpcRequest.addParam("ext", JSON.toJSONString(new HashMap()));
                    RpcResponse post = ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, RpcResponse.class);
                    if (post.code != 3000 || (t = post.returnValue) == null) {
                        resetFingerprintInfo(fingerprintLoginInfo2);
                        updateFingerprintInfo(fingerprintLoginInfo2);
                    }
                    T t2 = t;
                    fingerprintLoginInfo2.token = t2.getString("fingerprintLoginToken");
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = t2.getLongValue("fingerprintLoginToken_expire_in");
                    Long.signum(longValue);
                    fingerprintLoginInfo2.tokenExpireTime = currentTimeMillis + (longValue * 1000);
                    fingerprintLoginInfo2.showLoginId = t2.getString("showLoginId");
                    fingerprintLoginInfo2.userId = t2.getLongValue("havanaId");
                    updateFingerprintInfo(fingerprintLoginInfo2);
                }
            }
        } catch (Exception e) {
            TLogAdapter.e(TAG, "applyFingerprintLoginToken error", e);
            resetFingerprintInfo(null);
        }
    }

    public boolean canUseFingerprintLogin() {
        FingerprintLoginInfo fingerprintLoginInfo2;
        try {
            if (isFingerprintLoginAvailable() && (fingerprintLoginInfo2 = getFingerprintLoginInfo()) != null && isSupportedLoginEntrance(fingerprintLoginInfo2.loginEntrance) && fingerprintLoginInfo2.token != null && System.currentTimeMillis() < fingerprintLoginInfo2.tokenExpireTime) {
                return true;
            }
            return false;
        } catch (Exception e) {
            TLogAdapter.e(TAG, "canUseFingerprintLogin error", e);
            return false;
        }
    }

    public void clearFingerprintInfo(AliUserResponseData aliUserResponseData) {
        try {
            if (isFingerprintLoginAvailable()) {
                getFingerprintLoginInfo().token = null;
            }
        } catch (Exception e) {
            TLogAdapter.e(TAG, "clearFingerprintInfo error", e);
        }
    }

    public void closeFingerprintLoginSet() {
        FingerprintLoginInfo fingerprintLoginInfo2 = getFingerprintLoginInfo();
        closeFingerprintInfo(fingerprintLoginInfo2, false);
        updateFingerprintInfo(fingerprintLoginInfo2);
    }

    public void closeLead(String str) {
        if (!TextUtils.isEmpty(str)) {
            FingerprintLoginInfo fingerprintLoginInfo2 = getFingerprintLoginInfo();
            fingerprintLoginInfo2.notLeads.put(str, Boolean.TRUE);
            closeFingerprintInfo(fingerprintLoginInfo2, false);
            updateFingerprintInfo(fingerprintLoginInfo2);
        }
    }

    public void disableFingerprintLogin() {
        FingerprintLoginInfo fingerprintLoginInfo2 = getFingerprintLoginInfo();
        fingerprintLoginInfo2.disable = true;
        updateFingerprintInfo(fingerprintLoginInfo2);
    }

    public FingerprintLoginInfo getFingerprintLoginInfo() {
        FingerprintLoginInfo fingerprintLoginInfo2 = this.fingerprintLoginInfo;
        if (fingerprintLoginInfo2 != null) {
            return fingerprintLoginInfo2;
        }
        String str = (String) SharedPreferencesUtil.getData(DataProviderFactory.getApplicationContext(), INFO_SP_KEY, "{}");
        Log.e("TAG", "info=" + str);
        FingerprintLoginInfo fingerprintLoginInfo3 = (FingerprintLoginInfo) JSON.parseObject(str, FingerprintLoginInfo.class);
        this.fingerprintLoginInfo = fingerprintLoginInfo3;
        return fingerprintLoginInfo3;
    }

    public String getShowLoginId() {
        FingerprintLoginInfo fingerprintLoginInfo2 = getFingerprintLoginInfo();
        return fingerprintLoginInfo2 != null ? fingerprintLoginInfo2.showLoginId : "";
    }

    public boolean isFingerprintLoginAvailable() {
        FingerprintService fingerprintService = (FingerprintService) ServiceFactory.getService(FingerprintService.class);
        if (!DataProviderFactory.getDataProvider().isSupportFingerprintLogin() || fingerprintService == null || !fingerprintService.isFingerprintAvailable()) {
            return false;
        }
        return !getFingerprintLoginInfo().disable;
    }

    public boolean isFingerprintLoginOpen() {
        if (!isFingerprintLoginAvailable()) {
            return false;
        }
        return getFingerprintLoginInfo().open;
    }

    public boolean isFingerprintLoginSetable() {
        if (!isFingerprintLoginAvailable()) {
            return false;
        }
        return isSupportedLoginEntrance(getFingerprintLoginInfo().loginEntrance);
    }

    public void loginByFingerprintToken(final LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        RpcRequest rpcRequest = new RpcRequest();
        TokenLoginRequest tokenLoginRequest = new TokenLoginRequest();
        Object obj = loginParam.externParams;
        if (obj == null) {
            obj = new HashMap();
        }
        rpcRequest.API_NAME = ApiConstants.ApiName.FINGER_PRINT_LOGIN;
        rpcRequest.VERSION = "1.0";
        rpcRequest.addParam("ext", JSON.toJSONString(obj));
        int i = loginParam.loginSite;
        rpcRequest.requestSite = i;
        tokenLoginRequest.site = i;
        tokenLoginRequest.appName = DataProviderFactory.getDataProvider().getAppkey();
        tokenLoginRequest.sdkVersion = AppInfo.getInstance().getSdkVersion();
        tokenLoginRequest.ttid = DataProviderFactory.getDataProvider().getTTID();
        tokenLoginRequest.utdid = AppInfo.getInstance().getUtdid();
        tokenLoginRequest.deviceId = DataProviderFactory.getDataProvider().getDeviceId();
        final FingerprintLoginInfo fingerprintLoginInfo2 = getFingerprintLoginInfo();
        tokenLoginRequest.token = fingerprintLoginInfo2.token;
        UserLoginServiceImpl.buildExt(tokenLoginRequest);
        rpcRequest.addParam(ApiConstants.ApiField.HID, Long.valueOf(fingerprintLoginInfo2.userId));
        rpcRequest.addParam("tokenInfo", JSON.toJSONString(tokenLoginRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(SecurityGuardManagerWraper.buildWSecurityData()));
        rpcRequest.addAfter(new IAfterFilter() {
            /* class com.ali.user.mobile.login.service.impl.FingerprintLoginServiceImpl.AnonymousClass1 */

            @Override // com.ali.user.mobile.rpc.filter.IAfterFilter
            public String doAfter(RpcResponse rpcResponse) {
                FingerprintLoginServiceImpl.this.resetFingerprintInfo(fingerprintLoginInfo2);
                FingerprintLoginServiceImpl.this.updateFingerprintInfo(fingerprintLoginInfo2);
                FingerprintLoginServiceImpl.this.fingerprintLoginUT(loginParam, rpcResponse);
                return null;
            }
        });
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, DefaultLoginResponseData.class, String.valueOf(loginParam.havanaId), rpcRequestCallback);
    }

    public void openFingerprintLoginSet() {
        FingerprintLoginInfo fingerprintLoginInfo2 = getFingerprintLoginInfo();
        fingerprintLoginInfo2.open = true;
        updateFingerprintInfo(fingerprintLoginInfo2);
    }

    public void updateFingerprintInfo(FingerprintLoginInfo fingerprintLoginInfo2) {
        if (fingerprintLoginInfo2 != null) {
            try {
                fingerprintLoginInfo2.lastUpdateTime = System.currentTimeMillis();
                String jSONString = JSON.toJSONString(fingerprintLoginInfo2);
                TLogAdapter.w(TAG, "updateFingerprintInfo to " + jSONString);
                SharedPreferencesUtil.saveData(DataProviderFactory.getApplicationContext(), INFO_SP_KEY, jSONString);
            } catch (Exception e) {
                TLogAdapter.e(TAG, "updateFingerprintInfo error", e);
            }
        }
    }
}
