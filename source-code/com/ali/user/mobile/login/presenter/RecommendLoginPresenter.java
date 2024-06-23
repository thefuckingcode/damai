package com.ali.user.mobile.login.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.model.AppLaunchInfoResponseData;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.login.ui.BaseLoginView;
import com.ali.user.mobile.login.ui.LoginModeState;
import com.ali.user.mobile.login.ui.RecommendLoginView;
import com.ali.user.mobile.model.DeviceTokenSignParam;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.security.AlibabaSecurityTokenService;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.NetworkUtil;
import com.ali.user.mobile.utils.ResourceUtil;
import com.ali.user.mobile.utils.SharedPreferencesUtil;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class RecommendLoginPresenter extends BaseLoginPresenter {
    protected static final String TAG = ("login." + RecommendLoginPresenter.class.getSimpleName());

    public RecommendLoginPresenter(BaseLoginView baseLoginView, LoginParam loginParam) {
        super(baseLoginView, loginParam);
    }

    protected static void buildLoginFlowRequest(LoginParam loginParam, LoginFlowRequest loginFlowRequest) {
        Context applicationContext = DataProviderFactory.getApplicationContext();
        UserLoginServiceImpl.getInstance();
        UserLoginServiceImpl.buildBaseRequest(loginParam, loginFlowRequest);
        loginFlowRequest.mobileNetworkOn = NetworkUtil.checkEnv(applicationContext);
        loginFlowRequest.loginId = loginParam.loginAccount;
        loginFlowRequest.t = System.currentTimeMillis();
        loginFlowRequest.locale = ResourceUtil.getLocaleStr();
        loginFlowRequest.site = 0;
    }

    public static AppLaunchInfoResponseData fireAppLaunchRequest(LoginParam loginParam, HistoryAccount historyAccount) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.API_CALLED_BEFORE_LOGIN_PAGE;
        rpcRequest.VERSION = "1.0";
        rpcRequest.timeoutMilliSecond = 1000;
        AppLaunchRequest appLaunchRequest = new AppLaunchRequest();
        buildLoginFlowRequest(loginParam, appLaunchRequest);
        HashMap hashMap = new HashMap();
        appLaunchRequest.ext = hashMap;
        hashMap.put("lastLoginType", getLastLoginType());
        if (historyAccount != null) {
            appLaunchRequest.deviceTokenKey = historyAccount.tokenKey;
            appLaunchRequest.hid = String.valueOf(historyAccount.userId);
            DeviceTokenSignParam deviceTokenSignParam = new DeviceTokenSignParam();
            if (!TextUtils.isEmpty(DataProviderFactory.getDataProvider().getAppkey())) {
                deviceTokenSignParam.addAppKey(DataProviderFactory.getDataProvider().getAppkey());
            }
            deviceTokenSignParam.addAppVersion(AppInfo.getInstance().getAndroidAppVersion());
            deviceTokenSignParam.addHavanaId(String.valueOf(historyAccount.userId));
            deviceTokenSignParam.addTimestamp(String.valueOf(appLaunchRequest.t));
            deviceTokenSignParam.addSDKVersion(AppInfo.getInstance().getSdkVersion());
            if (!TextUtils.isEmpty(historyAccount.tokenKey)) {
                appLaunchRequest.deviceTokenSign = AlibabaSecurityTokenService.sign(historyAccount.tokenKey, deviceTokenSignParam.build());
            }
        } else {
            appLaunchRequest.firstLogin = true;
        }
        if (!(ServiceFactory.getService(NumberAuthService.class) == null || ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap() == null || !LoginSwitch.getSwitch("getloginflow_take_maskmobile", "true"))) {
            appLaunchRequest.maskMobile = ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap().get("number");
        }
        rpcRequest.addParam("loginInfo", JSON.toJSONString(appLaunchRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(UserLoginServiceImpl.getScanFaceWSecurityData()));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("sdkTraceId", loginParam.traceId);
        rpcRequest.addParam("ext", JSON.toJSONString(hashMap2));
        return (AppLaunchInfoResponseData) ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, AppLaunchInfoResponseData.class);
    }

    public static String getLastLoginType() {
        String str = (String) SharedPreferencesUtil.getData(DataProviderFactory.getApplicationContext(), "login_type", "");
        if (LoginType.ServerLoginType.AlipaySSOLogin.getType().equals(str)) {
            return "alipay";
        }
        if (LoginType.ServerLoginType.PasswordLogin.getType().equals(str)) {
            return "pwd";
        }
        if (LoginType.ServerLoginType.SMSLogin.getType().equals(str)) {
            return "sms";
        }
        if (LoginType.ServerLoginType.FaceLogin.getType().equals(str)) {
            return BaseCellItem.TYPE_FACE;
        }
        return LoginType.ServerLoginType.SimLogin.getType().equals(str) ? "sim" : str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onGetLoginFlowError(RpcResponse rpcResponse, String str) {
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView != null && baseLoginView.isActive()) {
            this.mViewer.dismissLoading();
            if (rpcResponse == null || rpcResponse.code == 7) {
                String str2 = rpcResponse != null ? rpcResponse.message : "";
                if (TextUtils.isEmpty(str2)) {
                    str2 = ResourceUtil.getStringById("aliuser_network_error");
                }
                this.mViewer.toast(str2, 0);
                return;
            }
            onFlowLimitLocked(str);
        }
    }

    public void getLoginFlow() {
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView != null && baseLoginView.isActive()) {
            this.mViewer.showLoading();
            getLoginFlowRequest(this.mLoginParam, new RpcRequestCallback() {
                /* class com.ali.user.mobile.login.presenter.RecommendLoginPresenter.AnonymousClass1 */

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onError(RpcResponse rpcResponse) {
                    RecommendLoginPresenter.this.mViewer.dismissLoading();
                    if (rpcResponse != null && TextUtils.equals(rpcResponse.actionType, ApiConstants.ResultActionType.FORCE_TOAST)) {
                        RecommendLoginPresenter.this.mViewer.toast(rpcResponse.message, 1);
                    } else if (rpcResponse != null && "mobileNeedCheck".equals(rpcResponse.codeGroup) && ApiConstants.ResultActionType.TOAST.equals(rpcResponse.actionType)) {
                        RecommendLoginPresenter recommendLoginPresenter = RecommendLoginPresenter.this;
                        ((RecommendLoginView) recommendLoginPresenter.mViewer).onNeedAlert(recommendLoginPresenter.mLoginParam, rpcResponse);
                    } else if (rpcResponse == null || !"guideH5".equals(rpcResponse.codeGroup)) {
                        RecommendLoginPresenter recommendLoginPresenter2 = RecommendLoginPresenter.this;
                        LoginParam loginParam = recommendLoginPresenter2.mLoginParam;
                        recommendLoginPresenter2.onGetLoginFlowError(rpcResponse, loginParam == null ? "" : loginParam.loginAccount);
                    } else {
                        RecommendLoginPresenter recommendLoginPresenter3 = RecommendLoginPresenter.this;
                        ((RecommendLoginView) recommendLoginPresenter3.mViewer).onGuideH5(recommendLoginPresenter3.mLoginParam, rpcResponse);
                    }
                }

                /* JADX WARNING: Removed duplicated region for block: B:26:0x0090  */
                /* JADX WARNING: Removed duplicated region for block: B:31:0x00a6 A[SYNTHETIC, Splitter:B:31:0x00a6] */
                /* JADX WARNING: Removed duplicated region for block: B:43:0x00f8  */
                /* JADX WARNING: Removed duplicated region for block: B:44:0x0104  */
                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onSuccess(RpcResponse rpcResponse) {
                    boolean z;
                    String[] strArr;
                    BaseLoginView baseLoginView = RecommendLoginPresenter.this.mViewer;
                    if (baseLoginView != null && baseLoginView.isActive()) {
                        RecommendLoginPresenter.this.mViewer.dismissLoading();
                        BaseLoginView baseLoginView2 = RecommendLoginPresenter.this.mViewer;
                        if (baseLoginView2 != null && baseLoginView2.isActive() && rpcResponse != null) {
                            T t = ((LoginFlowResponseData) rpcResponse).returnValue;
                            if (TextUtils.equals(rpcResponse.actionType, "SUCCESS")) {
                                UserTrackAdapter.sendUT(UTConstans.PageName.UT_PAGE_RECOMMEND_LOGIN, UTConstans.CustomEvent.UT_RECOMMEND_LOGIN_SUCCESS, "recommendLogin=" + t.recommendLoginFlow, null);
                                ArrayList arrayList = new ArrayList();
                                if (!TextUtils.equals(t.recommendLoginFlow, LoginModeState.SIM_LOGIN.name())) {
                                    if (!TextUtils.equals(t.recommendLoginFlow, LoginModeState.BIOMETRIC.name()) || !TextUtils.isEmpty(SecurityGuardManagerWraper.getFingerValue(t.biometricId))) {
                                        arrayList.add(t.recommendLoginFlow);
                                    } else {
                                        z = true;
                                        strArr = t.otherLoginFlows;
                                        if (strArr != null && strArr.length > 0) {
                                            for (String str : strArr) {
                                                if (!TextUtils.equals(str, LoginModeState.SIM_LOGIN.name())) {
                                                    arrayList.add(str);
                                                }
                                            }
                                        }
                                        if (z) {
                                            try {
                                                if (arrayList.size() > 0) {
                                                    UserTrackAdapter.sendUT("recommendFingerButNoData");
                                                    t.recommendLoginFlow = (String) arrayList.get(0);
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        LoginParam loginParam = new LoginParam();
                                        loginParam.loginAccount = t.loginId;
                                        loginParam.countryCode = t.countryCode;
                                        loginParam.phoneCode = t.phoneCode;
                                        loginParam.callRpc = RecommendLoginPresenter.this.mLoginParam.callRpc;
                                        loginParam.havanaId = Long.parseLong(t.havanaId);
                                        ((RecommendLoginView) RecommendLoginPresenter.this.mViewer).updateAccountInfo(t);
                                        if (!TextUtils.equals(t.recommendLoginFlow, LoginModeState.SMS_LOGIN.name())) {
                                            ((RecommendLoginView) RecommendLoginPresenter.this.mViewer).onRecommendSmsLogin(t.recommendLoginFlow, arrayList, loginParam);
                                            return;
                                        } else if (TextUtils.equals(t.recommendLoginFlow, LoginModeState.PASSWORD.name())) {
                                            ((RecommendLoginView) RecommendLoginPresenter.this.mViewer).onRecommendPwdLogin(t.recommendLoginFlow, arrayList, loginParam);
                                            return;
                                        } else if (TextUtils.equals(t.recommendLoginFlow, LoginModeState.SIM_LOGIN.name())) {
                                            ((RecommendLoginView) RecommendLoginPresenter.this.mViewer).onRecommendSimLogin(t.recommendLoginFlow, arrayList, loginParam);
                                            return;
                                        } else if (TextUtils.equals(t.recommendLoginFlow, LoginModeState.SCAN_FACE.name())) {
                                            ((RecommendLoginView) RecommendLoginPresenter.this.mViewer).onRecommendFaceLogin(t.recommendLoginFlow, arrayList, loginParam);
                                            return;
                                        } else if (TextUtils.equals(t.recommendLoginFlow, LoginModeState.BIOMETRIC.name())) {
                                            ((RecommendLoginView) RecommendLoginPresenter.this.mViewer).onRecommendBioLogin(t.recommendLoginFlow, arrayList, loginParam);
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                z = false;
                                strArr = t.otherLoginFlows;
                                while (r5 < r4) {
                                }
                                if (z) {
                                }
                                LoginParam loginParam2 = new LoginParam();
                                loginParam2.loginAccount = t.loginId;
                                loginParam2.countryCode = t.countryCode;
                                loginParam2.phoneCode = t.phoneCode;
                                loginParam2.callRpc = RecommendLoginPresenter.this.mLoginParam.callRpc;
                                try {
                                    loginParam2.havanaId = Long.parseLong(t.havanaId);
                                } catch (Throwable unused) {
                                }
                                ((RecommendLoginView) RecommendLoginPresenter.this.mViewer).updateAccountInfo(t);
                                if (!TextUtils.equals(t.recommendLoginFlow, LoginModeState.SMS_LOGIN.name())) {
                                }
                            } else {
                                onError(rpcResponse);
                            }
                        }
                    }
                }

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onSystemError(RpcResponse rpcResponse) {
                    RecommendLoginPresenter recommendLoginPresenter = RecommendLoginPresenter.this;
                    LoginParam loginParam = recommendLoginPresenter.mLoginParam;
                    recommendLoginPresenter.onGetLoginFlowError(rpcResponse, loginParam == null ? "" : loginParam.loginAccount);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r3v4. Raw type applied. Possible types: java.util.Map<java.lang.String, java.lang.String> */
    public void getLoginFlowRequest(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        Map map;
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.API_NAME = ApiConstants.ApiName.GET_LOGIN_FLOW;
        rpcRequest.VERSION = "1.0";
        LoginFlowRequest loginFlowRequest = new LoginFlowRequest();
        buildLoginFlowRequest(loginParam, loginFlowRequest);
        UserLoginServiceImpl.addExt(loginFlowRequest);
        rpcRequest.addParam("loginInfo", JSON.toJSONString(loginFlowRequest));
        rpcRequest.addParam("riskControlInfo", JSON.toJSONString(UserLoginServiceImpl.getScanFaceWSecurityData()));
        Map hashMap = new HashMap();
        if (!(loginParam == null || (map = loginParam.externParams) == null)) {
            hashMap = map;
        }
        hashMap.put("sdkTraceId", loginParam.traceId);
        if (!(ServiceFactory.getService(NumberAuthService.class) == null || ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap() == null || !LoginSwitch.getSwitch("getloginflow_take_maskmobile", "true"))) {
            String str = ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap().get("number");
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("maskMobile", str);
            }
        }
        if (LoginSwitch.getSwitch("isRecommendNotOpenFace", "true")) {
            hashMap.put("isRecommendNotOpenFace", "true");
        }
        rpcRequest.addParam("ext", JSON.toJSONString(hashMap));
        ((RpcService) ServiceFactory.getService(RpcService.class)).remoteBusiness(rpcRequest, LoginFlowResponseData.class, rpcRequestCallback);
    }

    /* access modifiers changed from: protected */
    public void onFlowLimitLocked(String str) {
        ((RecommendLoginView) this.mViewer).onFlowLimitLocked(str);
    }
}
