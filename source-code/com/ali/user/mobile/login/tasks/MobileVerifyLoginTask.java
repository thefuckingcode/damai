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
import java.util.HashMap;
import java.util.Properties;

/* compiled from: Taobao */
public class MobileVerifyLoginTask extends BaseLoginTask {
    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void buildLoginParam(final CommonDataCallback commonDataCallback) {
        BackgroundExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.login.tasks.MobileVerifyLoginTask.AnonymousClass1 */

            public void run() {
                MobileVerifyLoginTask.this.matchHistoryAccount();
                MainThreadExecutor.execute(new Runnable() {
                    /* class com.ali.user.mobile.login.tasks.MobileVerifyLoginTask.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        MobileVerifyLoginTask.this.fetchVerificationToken(commonDataCallback);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: protected */
    public void fetchVerificationToken(final CommonDataCallback commonDataCallback) {
        String str;
        TrackingModel trackingModel = this.trackingModel;
        final String str2 = trackingModel == null ? UTConstant.PageName.UT_PAGE_EXTEND : trackingModel.pageName;
        if (trackingModel == null) {
            str = "";
        } else {
            str = trackingModel.pageSpm;
        }
        if (this.loginParam == null) {
            LoginParam loginParam = new LoginParam();
            this.loginParam = loginParam;
            loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
        }
        LoginParam loginParam2 = this.loginParam;
        TrackingModel trackingModel2 = this.trackingModel;
        loginParam2.traceId = trackingModel2 != null ? trackingModel2.traceId : ApiReferer.generateTraceId(LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, str2);
        LoginParam loginParam3 = this.loginParam;
        loginParam3.loginSourceType = LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN;
        loginParam3.loginSourcePage = str2;
        loginParam3.loginSourceSpm = str;
        loginParam3.nativeLoginType = getLoginType();
        HashMap hashMap = new HashMap();
        hashMap.put("sdkTraceId", this.loginParam.traceId + "");
        UserTrackAdapter.control(str2, str, UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, hashMap);
        if (ServiceFactory.getService(NumberAuthService.class) != null) {
            showLoading();
            Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(str2, "sim_access_code_commit", "", LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, properties);
            ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getToken(new NumAuthTokenCallback() {
                /* class com.ali.user.mobile.login.tasks.MobileVerifyLoginTask.AnonymousClass2 */

                @Override // com.ali.user.mobile.model.NumAuthTokenCallback
                public void onGetAuthTokenFail(int i, final String str) {
                    MobileVerifyLoginTask.this.dismissLoading();
                    Properties properties = new Properties();
                    properties.setProperty("monitor", "T");
                    String str2 = str2;
                    UserTrackAdapter.sendUT(str2, "sim_access_code_failure", i + "", LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, properties);
                    MainThreadExecutor.execute(new Runnable() {
                        /* class com.ali.user.mobile.login.tasks.MobileVerifyLoginTask.AnonymousClass2.AnonymousClass1 */

                        public void run() {
                            CommonDataCallback commonDataCallback = commonDataCallback;
                            if (commonDataCallback != null) {
                                commonDataCallback.onFail(1601, str);
                            }
                        }
                    });
                }

                @Override // com.ali.user.mobile.model.NumAuthTokenCallback
                public void onGetAuthTokenSuccess(String str) {
                    MobileVerifyLoginTask.this.dismissLoading();
                    Properties properties = new Properties();
                    properties.setProperty("monitor", "T");
                    UserTrackAdapter.sendUT(str2, "sim_access_code_success", "", LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, properties);
                    Properties properties2 = new Properties();
                    properties2.setProperty("sdkTraceId", MobileVerifyLoginTask.this.loginParam.traceId + "");
                    properties2.setProperty("monitor", "T");
                    properties2.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                    properties2.setProperty("loginId", MobileVerifyLoginTask.this.loginParam.loginAccount + "");
                    UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, properties2);
                    LoginParam loginParam = MobileVerifyLoginTask.this.loginParam;
                    loginParam.token = str;
                    loginParam.tokenType = TokenType.NUMBER;
                    CommonDataCallback commonDataCallback = commonDataCallback;
                    if (commonDataCallback != null) {
                        commonDataCallback.onSuccess(null);
                    }
                }
            });
        } else if (commonDataCallback != null) {
            commonDataCallback.onFail(1601, "");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public String getLoginType() {
        return LoginType.ServerLoginType.MobileVerifyLogin.getType();
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void invokeLoginRpc(LoginParam loginParam, RpcRequestCallback<LoginReturnData> rpcRequestCallback) {
        LoginDataRepository.getInstance().simLoginWithUserInput(loginParam, rpcRequestCallback);
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void onReceiveRegister(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (rpcResponse.code == 14044) {
            String str = loginParam != null ? loginParam.loginSourcePage : UTConstant.PageName.UT_PAGE_EXTEND;
            Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(str, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, UTConstant.ErrorCode.LOGIN2REG_CANCEL_ALERT, LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, properties);
            if (loginTasksCallback != null) {
                loginTasksCallback.onFail(new LoginException<>(1303, "", rpcResponse));
                return;
            }
            return;
        }
        super.onReceiveRegister(loginParam, rpcResponse, loginTasksCallback);
    }
}
