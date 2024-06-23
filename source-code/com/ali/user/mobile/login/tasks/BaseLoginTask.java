package com.ali.user.mobile.login.tasks;

import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.BaseView;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.model.Login2RegParam;
import com.ali.user.mobile.eventbus.Event;
import com.ali.user.mobile.eventbus.EventBus;
import com.ali.user.mobile.eventbus.EventBusEnum;
import com.ali.user.mobile.eventbus.EventListener;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.filter.LoginFilterCallback;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.AppMonitorAdapter;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.AccountType;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.register.RegisterApi;
import com.ali.user.mobile.register.RegisterException;
import com.ali.user.mobile.register.tasks.BaseRegisterTask;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.rpc.register.model.OceanRegisterResult;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.url.service.impl.UrlUtil;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.ali.user.mobile.utils.ResourceUtil;
import com.ali.user.open.ucc.util.UccConstants;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.constants.LoginConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
public abstract class BaseLoginTask {
    protected static final String TAG = "BaseLoginTask";
    protected WeakReference<BaseView> baseView;
    protected LoginParam loginParam;
    protected TrackingModel trackingModel;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class LoginRpcRequestCallback implements RpcRequestCallback<LoginReturnData> {
        private final LoginParam loginParam;
        private final LoginTasksCallback<LoginReturnData> loginResultCallback;

        public LoginRpcRequestCallback(LoginParam loginParam2, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
            this.loginParam = loginParam2;
            this.loginResultCallback = loginTasksCallback;
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onError(RpcResponse<LoginReturnData> rpcResponse) {
            BaseLoginTask.this.dismissLoading();
            BaseLoginTask.this.processLoginResult(this.loginParam, rpcResponse, this.loginResultCallback);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
            BaseLoginTask.this.dismissLoading();
            BaseLoginTask.this.processLoginResult(this.loginParam, rpcResponse, this.loginResultCallback);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSystemError(RpcResponse<LoginReturnData> rpcResponse) {
            BaseLoginTask.this.dismissLoading();
            LoginTasksCallback<LoginReturnData> loginTasksCallback = this.loginResultCallback;
            if (loginTasksCallback != null) {
                loginTasksCallback.onFail(new LoginException<>(rpcResponse == null ? 1100 : rpcResponse.code, rpcResponse == null ? ResourceUtil.getStringById("aliuser_network_error") : rpcResponse.message, rpcResponse));
            }
        }
    }

    private RpcRequestCallback<LoginReturnData> createLoginRpcCallback(LoginParam loginParam2, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        return new LoginRpcRequestCallback(loginParam2, loginTasksCallback);
    }

    /* access modifiers changed from: protected */
    public void buildLoginParam(final CommonDataCallback commonDataCallback) {
        MainThreadExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.login.tasks.BaseLoginTask.AnonymousClass2 */

            public void run() {
                commonDataCallback.onSuccess(null);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void directRegister(final LoginParam loginParam2, Login2RegParam login2RegParam, final LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        String str;
        String str2;
        final String str3;
        if (loginParam2 != null) {
            str3 = loginParam2.loginSourcePage;
            str2 = loginParam2.loginSourceSpm;
            str = loginParam2.traceId;
        } else {
            str3 = UTConstant.PageName.UT_PAGE_FIRST_LOGIN;
            str2 = null;
            str = "";
        }
        final String generateTraceId = TextUtils.isEmpty(str) ? ApiReferer.generateTraceId(LoginType.LocalLoginType.LOGIN2REGISTER_LOGIN, str3) : str;
        HashMap hashMap = new HashMap();
        hashMap.put("sdkTraceId", generateTraceId);
        UserTrackAdapter.control(str3, str2, UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.LOGIN2REGISTER_LOGIN, hashMap);
        RegistParam registParam = new RegistParam();
        if (DataProviderFactory.getDataProvider().isYoukuApps()) {
            registParam.userSiteHere = true;
            registParam.registSite = 23;
            if (login2RegParam.needTaobao) {
                registParam.registerSiteString = "taobao";
            }
        }
        showLoading();
        RegisterApi.directRegister(registParam, login2RegParam.token, null, this.trackingModel, this.baseView.get(), new BaseRegisterTask.RegisterTasksCallback<OceanRegisterResult>() {
            /* class com.ali.user.mobile.login.tasks.BaseLoginTask.AnonymousClass9 */

            @Override // com.ali.user.mobile.register.tasks.BaseRegisterTask.RegisterTasksCallback
            public void onCancel() {
                LoginTasksCallback loginTasksCallback = loginTasksCallback;
                if (loginTasksCallback != null) {
                    loginTasksCallback.onCancel();
                }
            }

            @Override // com.ali.user.mobile.register.tasks.BaseRegisterTask.RegisterTasksCallback
            public void onFail(RegisterException<OceanRegisterResult> registerException) {
                String str;
                BaseLoginTask.this.dismissLoading();
                if (registerException == null) {
                    str = UTConstant.ErrorCode.LOGIN2REG_ERROR;
                } else if (registerException.getOrinResponse() == null) {
                    str = registerException.getCode() + "";
                } else if (!RpcException.isSystemError(registerException.getOrinResponse().code) || TextUtils.isEmpty(registerException.getOrinResponse().msgCode)) {
                    str = registerException.getOrinResponse().code + "";
                } else {
                    str = registerException.getOrinResponse().msgCode;
                }
                String loginTypeByTraceId = UTConstant.getLoginTypeByTraceId(generateTraceId);
                Properties properties = new Properties();
                properties.setProperty("monitor", "T");
                UserTrackAdapter.sendUT(str3, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, str, loginTypeByTraceId, properties);
                Properties properties2 = new Properties();
                properties2.setProperty("monitor", "T");
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_LOGIN_TO_REG_FAILURE, str, UTConstant.getLoginTypeByTraceId(generateTraceId), properties2);
                LoginTasksCallback loginTasksCallback = loginTasksCallback;
                if (loginTasksCallback != null) {
                    loginTasksCallback.onFail(new LoginException(registerException == null ? Integer.parseInt(UTConstant.ErrorCode.LOGIN2REG_ERROR) : registerException.getCode(), registerException == null ? ResourceUtil.getStringById("aliuser_network_error") : registerException.getMsg()));
                }
            }

            @Override // com.ali.user.mobile.register.tasks.BaseRegisterTask.RegisterTasksCallback
            public void onSuccess(RpcResponse<OceanRegisterResult> rpcResponse) {
                BaseLoginTask.this.dismissLoading();
                if (rpcResponse != null) {
                    AppMonitorAdapter.commitSuccess("Page_Member_Register", "Register_Result");
                    Properties properties = new Properties();
                    properties.setProperty("monitor", "T");
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.UT_LOGIN_TO_REG_SUCCESS, "", UTConstant.getLoginTypeByTraceId(generateTraceId), properties);
                    if (rpcResponse.returnValue != null) {
                        BroadCastHelper.sendBroadcast(LoginAction.NOTIFY_REGISTER_SUCCESS, new HashMap());
                        LoginParam loginParam = loginParam2;
                        loginParam.token = rpcResponse.returnValue.continueLoginToken;
                        loginParam.scene = "1012";
                        loginParam.tokenType = UTConstant.CustomEvent.UT_TYPE_SMS_LOGIN_TO_REG;
                        if (loginParam != null) {
                            loginParam.loginSourcePage = loginParam.loginSourcePage;
                            loginParam.loginSourceSpm = loginParam.loginSourceSpm;
                        }
                        loginParam.traceId = generateTraceId;
                        loginParam.loginSourceType = LoginType.LocalLoginType.LOGIN2REGISTER_LOGIN;
                        loginParam.loginType = AccountType.TAOBAO_ACCOUNT.getType();
                        loginParam2.nativeLoginType = BaseLoginTask.this.getLoginType();
                        BaseLoginTask.this.invokeTokenLoginRpc(loginParam2, loginTasksCallback);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void dismissLoading() {
        MainThreadExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.login.tasks.BaseLoginTask.AnonymousClass4 */

            public void run() {
                WeakReference<BaseView> weakReference = BaseLoginTask.this.baseView;
                if (weakReference != null && weakReference.get() != null) {
                    BaseLoginTask.this.baseView.get().dismissLoading();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public abstract String getLoginType();

    /* access modifiers changed from: protected */
    public abstract void invokeLoginRpc(LoginParam loginParam2, RpcRequestCallback<LoginReturnData> rpcRequestCallback);

    /* access modifiers changed from: protected */
    public void invokeTokenLoginRpc(LoginParam loginParam2, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        showLoading();
        LoginDataRepository.getInstance().loginByToken(loginParam2, createLoginRpcCallback(loginParam2, loginTasksCallback));
    }

    public void login(LoginParam loginParam2, TrackingModel trackingModel2, BaseView baseView2, final LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        this.loginParam = loginParam2;
        this.trackingModel = trackingModel2;
        this.baseView = new WeakReference<>(baseView2);
        buildLoginParam(new CommonDataCallback() {
            /* class com.ali.user.mobile.login.tasks.BaseLoginTask.AnonymousClass1 */

            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onFail(int i, String str) {
                LoginTasksCallback loginTasksCallback = loginTasksCallback;
                if (loginTasksCallback != null) {
                    loginTasksCallback.onFail(new LoginException(i, str));
                }
            }

            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onSuccess(Map<String, String> map) {
                BaseLoginTask baseLoginTask = BaseLoginTask.this;
                baseLoginTask.startLogin(baseLoginTask.loginParam, loginTasksCallback);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void matchHistoryAccount() {
        HistoryAccount matchHistoryAccount;
        LoginParam loginParam2 = this.loginParam;
        if (loginParam2 != null && loginParam2.isFromAccount && (matchHistoryAccount = SecurityGuardManagerWraper.matchHistoryAccount(loginParam2.loginAccount)) != null) {
            LoginParam loginParam3 = this.loginParam;
            loginParam3.deviceTokenKey = matchHistoryAccount.tokenKey;
            loginParam3.havanaId = matchHistoryAccount.userId;
            loginParam3.isFromAccount = true;
        }
    }

    /* access modifiers changed from: protected */
    public void navToWebViewPage(LoginParam loginParam2, final RpcResponse<LoginReturnData> rpcResponse, final LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        T t = rpcResponse.returnValue;
        EventBus.getDefault().registerEventListener(EventBusEnum.EventName.ACTION_H5, new EventListener() {
            /* class com.ali.user.mobile.login.tasks.BaseLoginTask.AnonymousClass7 */

            @Override // com.ali.user.mobile.eventbus.EventListener
            public void onEvent(Event event) {
                Map<String, Object> map;
                LoginTasksCallback loginTasksCallback;
                EventBus.getDefault().unregisterEventListener(EventBusEnum.EventName.ACTION_H5, this);
                if (event == null || (map = event.params) == null) {
                    LoginTasksCallback loginTasksCallback2 = loginTasksCallback;
                    if (loginTasksCallback2 != null) {
                        String str = rpcResponse.message;
                        if (str == null) {
                            str = ResourceUtil.getStringById("aliuser_network_error");
                        }
                        loginTasksCallback2.onFail(new LoginException(605, str, rpcResponse));
                        return;
                    }
                    return;
                }
                String str2 = (String) map.get(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
                String str3 = (String) event.params.get("result");
                if (!TextUtils.isEmpty(str2) && TextUtils.equals(str3, "success")) {
                    LoginParam loginParam = (LoginParam) JSON.parseObject(str2, LoginParam.class);
                    if (loginParam == null) {
                        loginParam = new LoginParam();
                    }
                    BaseLoginTask.this.invokeTokenLoginRpc(loginParam, loginTasksCallback);
                } else if (!TextUtils.equals(str3, "cancel") || (loginTasksCallback = loginTasksCallback) == null) {
                    LoginTasksCallback loginTasksCallback3 = loginTasksCallback;
                    if (loginTasksCallback3 != null) {
                        String str4 = rpcResponse.message;
                        if (str4 == null) {
                            str4 = ResourceUtil.getStringById("aliuser_network_error");
                        }
                        loginTasksCallback3.onFail(new LoginException(604, str4, rpcResponse));
                    }
                } else {
                    loginTasksCallback.onCancel();
                }
            }
        });
        if (loginParam2 == null) {
            loginParam2 = new LoginParam();
        }
        loginParam2.scene = t.scene;
        loginParam2.token = t.token;
        loginParam2.loginSite = t.site;
        loginParam2.h5QueryString = null;
        Map<String, String> map = t.extMap;
        if (map != null) {
            if (loginParam2.externParams == null) {
                loginParam2.externParams = map;
            } else {
                loginParam2.externParams = new HashMap();
                for (Map.Entry<String, String> entry : t.extMap.entrySet()) {
                    loginParam2.externParams.put(entry.getKey(), entry.getValue());
                }
            }
        }
        UrlParam urlParam = new UrlParam();
        urlParam.url = t.h5Url;
        urlParam.token = t.token;
        urlParam.scene = t.scene;
        urlParam.loginId = t.showLoginId;
        urlParam.loginParam = loginParam2;
        ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).navToWebViewPage(EventBusEnum.EventName.ACTION_H5, urlParam);
    }

    /* access modifiers changed from: protected */
    public void onNeedVerification(LoginParam loginParam2, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (loginTasksCallback != null) {
            loginTasksCallback.onFail(new LoginException<>(603, ""));
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveAlert(LoginParam loginParam2, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (loginTasksCallback != null) {
            loginTasksCallback.onFail(new LoginException<>(700, rpcResponse == null ? ResourceUtil.getStringById("aliuser_network_error") : rpcResponse.message, rpcResponse));
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveAlertWithH5(LoginParam loginParam2, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (loginTasksCallback != null) {
            loginTasksCallback.onFail(new LoginException<>(1000, rpcResponse == null ? ResourceUtil.getStringById("aliuser_network_error") : rpcResponse.message, rpcResponse));
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveH5(LoginParam loginParam2, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        T t = rpcResponse.returnValue;
        if (t != null) {
            if (!TextUtils.isEmpty(t.h5Url)) {
                navToWebViewPage(loginParam2, rpcResponse, loginTasksCallback);
            } else if (loginTasksCallback != null) {
                String str = rpcResponse.message;
                if (str == null) {
                    str = ResourceUtil.getStringById("aliuser_network_error");
                }
                loginTasksCallback.onFail(new LoginException<>(602, str, rpcResponse));
            }
        } else if (loginTasksCallback != null) {
            String str2 = rpcResponse.message;
            if (str2 == null) {
                str2 = ResourceUtil.getStringById("aliuser_network_error");
            }
            loginTasksCallback.onFail(new LoginException<>(601, str2, rpcResponse));
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveNotSuccessActionType(LoginParam loginParam2, RpcResponse<LoginReturnData> rpcResponse) {
        if (rpcResponse != null) {
            String valueOf = String.valueOf(rpcResponse.code);
            String str = rpcResponse.message;
            if (str == null) {
                str = "";
            }
            AppMonitorAdapter.commitFail("Page_Login", "login", valueOf, str);
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveNotify(LoginParam loginParam2, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (loginTasksCallback != null) {
            loginTasksCallback.onFail(new LoginException<>(900, rpcResponse == null ? ResourceUtil.getStringById("aliuser_network_error") : rpcResponse.message, rpcResponse));
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveRegister(LoginParam loginParam2, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        T t = rpcResponse.returnValue;
        String str = rpcResponse.message;
        loginParam2.token = null;
        Map<String, String> map = t.extMap;
        boolean z = true;
        boolean z2 = map != null && "true".equals(map.get("needTaobao"));
        Map<String, String> map2 = t.extMap;
        if (map2 != null && ("false".equals(map2.get("showTaobaoAgreement")) || "false".equals(t.extMap.get("showAgreement")))) {
            z = false;
        }
        Login2RegParam login2RegParam = new Login2RegParam();
        login2RegParam.h5Url = t.h5Url;
        login2RegParam.needAlert = z;
        login2RegParam.needTaobao = z2;
        login2RegParam.token = t.token;
        login2RegParam.tips = str;
        Properties properties = new Properties();
        properties.setProperty("sdkTraceId", loginParam2.traceId + "");
        UserTrackAdapter.sendUT(loginParam2.loginSourcePage, UTConstant.CustomEvent.UT_LOGIN_TO_REG, properties);
        directRegister(loginParam2, login2RegParam, loginTasksCallback);
    }

    /* access modifiers changed from: protected */
    public void onReceiveSuccess(final LoginParam loginParam2, final RpcResponse<LoginReturnData> rpcResponse, final LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        T t;
        AppMonitorAdapter.commitSuccess("Page_Login", "login");
        if (rpcResponse == null || (t = rpcResponse.returnValue) == null || t.extMap == null || TextUtils.isEmpty(t.extMap.get("loginPostUrl"))) {
            onSuccessCall(loginParam2, rpcResponse, loginTasksCallback);
        } else {
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).navToLoginPostPage(DataProviderFactory.getApplicationContext(), rpcResponse.returnValue.extMap.get("loginPostUrl"), new LoginFilterCallback() {
                /* class com.ali.user.mobile.login.tasks.BaseLoginTask.AnonymousClass5 */

                @Override // com.ali.user.mobile.filter.LoginFilterCallback
                public void onFail(int i, Map<String, String> map) {
                    BaseLoginTask.this.onSuccessCall(loginParam2, rpcResponse, loginTasksCallback);
                }

                @Override // com.ali.user.mobile.filter.LoginFilterCallback
                public void onSuccess() {
                    BaseLoginTask.this.onSuccessCall(loginParam2, rpcResponse, loginTasksCallback);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveToast(LoginParam loginParam2, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (loginTasksCallback != null) {
            loginTasksCallback.onFail(new LoginException<>(800, rpcResponse == null ? ResourceUtil.getStringById("aliuser_network_error") : rpcResponse.message, rpcResponse));
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveTokenLogin(final LoginParam loginParam2, RpcResponse<LoginReturnData> rpcResponse, final LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        long j;
        T t = rpcResponse.returnValue;
        Map<String, String> map = t.extMap;
        if (map != null && !TextUtils.isEmpty(map.get("syncWaitTime"))) {
            try {
                j = Long.parseLong(t.extMap.get("syncWaitTime"));
            } catch (Throwable th) {
                th.printStackTrace();
                j = 1000;
            }
            loginParam2.token = t.token;
            loginParam2.scene = t.scene;
            MainThreadExecutor.postDelayed(new Runnable() {
                /* class com.ali.user.mobile.login.tasks.BaseLoginTask.AnonymousClass6 */

                public void run() {
                    BaseLoginTask.this.invokeTokenLoginRpc(loginParam2, loginTasksCallback);
                }
            }, j);
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveUCCH5(final LoginParam loginParam2, RpcResponse<LoginReturnData> rpcResponse, final LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        String str = rpcResponse.returnValue.h5Url;
        UrlParam urlParam = new UrlParam();
        urlParam.url = str;
        urlParam.loginType = loginParam2.nativeLoginType;
        T t = rpcResponse.returnValue;
        if (t != null) {
            urlParam.token = t.token;
            urlParam.scene = t.scene;
        }
        urlParam.loginParam = loginParam2;
        UrlUtil.OpenUCC(DataProviderFactory.getApplicationContext(), urlParam, new CommonDataCallback() {
            /* class com.ali.user.mobile.login.tasks.BaseLoginTask.AnonymousClass8 */

            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onFail(int i, String str) {
                LoginTasksCallback loginTasksCallback = loginTasksCallback;
                if (loginTasksCallback != null) {
                    loginTasksCallback.onFail(new LoginException(1202, ResourceUtil.getStringById("aliuser_network_error")));
                }
            }

            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onSuccess(Map<String, String> map) {
                if (map != null) {
                    String str = map.get(UccConstants.PARAM_LOGIN_DATA);
                    if (!TextUtils.isEmpty(str)) {
                        RpcResponse<LoginReturnData> rpcResponse = new RpcResponse<>();
                        rpcResponse.returnValue = (T) ((LoginReturnData) JSON.parseObject(str, LoginReturnData.class));
                        rpcResponse.actionType = "SUCCESS";
                        BaseLoginTask.this.onReceiveSuccess(loginParam2, rpcResponse, loginTasksCallback);
                        return;
                    }
                    LoginTasksCallback loginTasksCallback = loginTasksCallback;
                    if (loginTasksCallback != null) {
                        loginTasksCallback.onFail(new LoginException(1201, ResourceUtil.getStringById("aliuser_network_error")));
                        return;
                    }
                    return;
                }
                LoginTasksCallback loginTasksCallback2 = loginTasksCallback;
                if (loginTasksCallback2 != null) {
                    loginTasksCallback2.onFail(new LoginException(1201, ResourceUtil.getStringById("aliuser_network_error")));
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onReceiverOtherError(RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (loginTasksCallback != null) {
            loginTasksCallback.onFail(new LoginException<>(rpcResponse == null ? 1100 : rpcResponse.code, rpcResponse == null ? ResourceUtil.getStringById("aliuser_network_error") : rpcResponse.message, rpcResponse));
        }
    }

    /* access modifiers changed from: protected */
    public void onSuccessCall(LoginParam loginParam2, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        processLoginSessionData(loginParam2, rpcResponse);
        if (loginTasksCallback != null) {
            loginTasksCallback.onSuccess(rpcResponse);
        }
    }

    /* access modifiers changed from: protected */
    public void processLoginResult(LoginParam loginParam2, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (rpcResponse != null) {
            String str = rpcResponse.actionType;
            String str2 = TAG;
            TLogAdapter.d(str2, "loginType=" + loginParam2.nativeLoginType + ", actionType=" + str + ", msg=" + rpcResponse.message);
            if (TextUtils.isEmpty(str)) {
                onReceiveNotSuccessActionType(loginParam2, rpcResponse);
                onReceiverOtherError(rpcResponse, loginTasksCallback);
            } else if ("SUCCESS".equals(str)) {
                onReceiveSuccess(loginParam2, rpcResponse, loginTasksCallback);
            } else {
                onReceiveNotSuccessActionType(loginParam2, rpcResponse);
                if ("H5".equals(str)) {
                    onReceiveH5(loginParam2, rpcResponse, loginTasksCallback);
                } else if (ApiConstants.ResultActionType.TOAST.equals(str)) {
                    onReceiveToast(loginParam2, rpcResponse, loginTasksCallback);
                } else if (ApiConstants.ResultActionType.ALERT.equals(str)) {
                    onReceiveAlert(loginParam2, rpcResponse, loginTasksCallback);
                } else if (ApiConstants.ResultActionType.REGISTER.equals(str)) {
                    onReceiveRegister(loginParam2, rpcResponse, loginTasksCallback);
                } else if (ApiConstants.ResultActionType.NOTIFY.equals(str)) {
                    onReceiveNotify(loginParam2, rpcResponse, loginTasksCallback);
                } else if (ApiConstants.ResultActionType.UCC_H5.equals(str)) {
                    onReceiveUCCH5(loginParam2, rpcResponse, loginTasksCallback);
                } else if (ApiConstants.ResultActionType.ALERT_WITH_H5.equals(str)) {
                    onReceiveAlertWithH5(loginParam2, rpcResponse, loginTasksCallback);
                } else if (ApiConstants.ResultActionType.TOKENLOGIN.equals(str)) {
                    onReceiveTokenLogin(loginParam2, rpcResponse, loginTasksCallback);
                } else {
                    onReceiverOtherError(rpcResponse, loginTasksCallback);
                }
            }
        } else {
            onReceiveNotSuccessActionType(loginParam2, null);
            onReceiverOtherError(null, loginTasksCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void processLoginSessionData(LoginParam loginParam2, RpcResponse<LoginReturnData> rpcResponse) {
        T t = rpcResponse.returnValue;
        if (t != null) {
            HashMap hashMap = new HashMap();
            String loginType = getLoginType();
            if (TextUtils.isEmpty(loginType) && loginParam2 != null && !TextUtils.isEmpty(loginParam2.nativeLoginType)) {
                loginType = loginParam2.nativeLoginType;
            }
            hashMap.put(LoginConstants.LOGIN_TYPE, loginType);
            LoginDataHelper.processLoginReturnData(true, t, loginParam2, "", hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void showLoading() {
        MainThreadExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.login.tasks.BaseLoginTask.AnonymousClass3 */

            public void run() {
                WeakReference<BaseView> weakReference = BaseLoginTask.this.baseView;
                if (weakReference != null && weakReference.get() != null) {
                    BaseLoginTask.this.baseView.get().showLoading();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void startLogin(LoginParam loginParam2, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        showLoading();
        invokeLoginRpc(loginParam2, createLoginRpcCallback(loginParam2, loginTasksCallback));
    }
}
