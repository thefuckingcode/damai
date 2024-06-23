package com.ali.user.mobile.login.tasks;

import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.NumAuthTokenCallback;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.ali.user.mobile.utils.ResourceUtil;
import java.util.HashMap;
import java.util.Properties;

/* compiled from: Taobao */
public class SimLoginTask extends BaseLoginTask {
    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void buildLoginParam(final CommonDataCallback commonDataCallback) {
        BackgroundExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.login.tasks.SimLoginTask.AnonymousClass1 */

            public void run() {
                SimLoginTask.this.matchHistoryAccount();
                MainThreadExecutor.execute(new Runnable() {
                    /* class com.ali.user.mobile.login.tasks.SimLoginTask.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        SimLoginTask.this.fetchSimLoginToken(commonDataCallback);
                    }
                });
            }
        });
    }

    public void buildTokenParam(LoginParam loginParam, String str, String str2, String str3) {
        if (this.loginParam == null) {
            this.loginParam = new LoginParam();
        }
        this.loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
        LoginParam loginParam2 = this.loginParam;
        loginParam2.token = str;
        loginParam2.tokenType = str2;
        loginParam2.scene = str3;
        if (loginParam2.externParams == null) {
            loginParam2.externParams = new HashMap();
        }
        this.loginParam.externParams.put("apiReferer", ApiReferer.generateApiReferer());
        if (loginParam != null) {
            LoginParam loginParam3 = this.loginParam;
            loginParam3.traceId = loginParam.traceId;
            loginParam3.loginSourcePage = loginParam.loginSourcePage;
            loginParam3.loginSourceSpm = loginParam.loginSourceSpm;
            loginParam3.loginSourceType = loginParam.loginSourceType;
        }
    }

    /* access modifiers changed from: protected */
    public void fetchSimLoginToken(final CommonDataCallback commonDataCallback) {
        String str;
        if (this.loginParam == null) {
            LoginParam loginParam = new LoginParam();
            this.loginParam = loginParam;
            loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
        }
        TrackingModel trackingModel = this.trackingModel;
        final String str2 = trackingModel == null ? UTConstant.PageName.UT_PAGE_EXTEND : trackingModel.pageName;
        if (trackingModel == null) {
            str = "";
        } else {
            str = trackingModel.pageSpm;
        }
        this.loginParam.traceId = trackingModel != null ? trackingModel.traceId : ApiReferer.generateTraceId(LoginType.LocalLoginType.SIM_LOGIN, str2);
        LoginParam loginParam2 = this.loginParam;
        loginParam2.loginSourceType = LoginType.LocalLoginType.SIM_LOGIN;
        loginParam2.loginSourcePage = str2;
        loginParam2.loginSourceSpm = str;
        loginParam2.nativeLoginType = getLoginType();
        HashMap hashMap = new HashMap();
        hashMap.put("sdkTraceId", this.loginParam.traceId + "");
        UserTrackAdapter.control(str2, str, UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.SIM_LOGIN, hashMap);
        if (ServiceFactory.getService(NumberAuthService.class) != null) {
            showLoading();
            final Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(str2, "get_onekey_login_token_commit", "", LoginType.LocalLoginType.SIM_LOGIN, properties);
            ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getLoginToken("openLoginView", new NumAuthTokenCallback() {
                /* class com.ali.user.mobile.login.tasks.SimLoginTask.AnonymousClass2 */

                @Override // com.ali.user.mobile.model.NumAuthTokenCallback
                public void onGetAuthTokenFail(int i, String str) {
                    SimLoginTask.this.dismissLoading();
                    Properties properties = new Properties();
                    properties.setProperty("code", i + "");
                    properties.setProperty("cause", str + "");
                    UserTrackAdapter.sendUT(str2, "get_login_token_fail", properties);
                    String str2 = str2;
                    UserTrackAdapter.sendUT(str2, "get_onekey_login_token_failure", i + "", LoginType.LocalLoginType.SIM_LOGIN, properties);
                    CommonDataCallback commonDataCallback = commonDataCallback;
                    if (commonDataCallback != null) {
                        commonDataCallback.onFail(1501, str);
                    }
                }

                @Override // com.ali.user.mobile.model.NumAuthTokenCallback
                public void onGetAuthTokenSuccess(String str) {
                    UserTrackAdapter.sendUT(str2, "get_login_token_success");
                    UserTrackAdapter.sendUT(str2, "get_onekey_login_token_success", "", LoginType.LocalLoginType.SIM_LOGIN, properties);
                    Properties properties = new Properties();
                    if (SimLoginTask.this.loginParam != null) {
                        properties.setProperty("sdkTraceId", SimLoginTask.this.loginParam.traceId + "");
                    }
                    properties.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                    properties.setProperty("loginId", SimLoginTask.this.loginParam.loginAccount + "");
                    properties.setProperty("monitor", "T");
                    UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.SIM_LOGIN, properties);
                    SimLoginTask simLoginTask = SimLoginTask.this;
                    simLoginTask.buildTokenParam(simLoginTask.loginParam, str, TokenType.NUMBER, "");
                    CommonDataCallback commonDataCallback = commonDataCallback;
                    if (commonDataCallback != null) {
                        commonDataCallback.onSuccess(null);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public String getLoginType() {
        return LoginType.ServerLoginType.SimLogin.getType();
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void invokeLoginRpc(LoginParam loginParam, RpcRequestCallback<LoginReturnData> rpcRequestCallback) {
        LoginDataRepository.getInstance().simLogin(loginParam, rpcRequestCallback);
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void onReceiveRegister(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (rpcResponse.code == 14044) {
            String str = loginParam != null ? loginParam.loginSourcePage : UTConstant.PageName.UT_PAGE_EXTEND;
            Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, UTConstant.ErrorCode.LOGIN2REG_CANCEL_ALERT, LoginType.LocalLoginType.SIM_LOGIN, properties);
            if (loginTasksCallback != null) {
                loginTasksCallback.onFail(new LoginException<>(1303, "", rpcResponse));
                return;
            }
            return;
        }
        super.onReceiveRegister(loginParam, rpcResponse, loginTasksCallback);
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void onReceiverOtherError(RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (loginTasksCallback == null) {
            return;
        }
        if (rpcResponse == null || rpcResponse.code != 14076) {
            loginTasksCallback.onFail(new LoginException<>(rpcResponse == null ? 1100 : rpcResponse.code, rpcResponse == null ? ResourceUtil.getStringById("aliuser_network_error") : rpcResponse.message, rpcResponse));
        } else {
            loginTasksCallback.onFail(new LoginException<>(1502, rpcResponse.message, rpcResponse));
        }
    }
}
