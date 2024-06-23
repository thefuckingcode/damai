package com.ali.user.mobile.login.tasks;

import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.login.model.GetVerifyTokenResponseData;
import com.ali.user.mobile.login.model.GetVerifyTokenResult;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.FaceVerifyCallback;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.service.FaceService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.MainThreadExecutor;
import java.util.HashMap;
import java.util.Properties;

/* compiled from: Taobao */
public class FaceLoginTask extends BaseLoginTask {
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fetchScanToken(final CommonDataCallback commonDataCallback) {
        showLoading();
        if (this.loginParam == null) {
            LoginParam loginParam = new LoginParam();
            this.loginParam = loginParam;
            loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
        }
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        properties.setProperty("sdkTraceId", this.loginParam.traceId + "");
        UserTrackAdapter.sendUT(this.loginParam.loginSourcePage, UTConstant.CustomEvent.UT_GET_FACELOGIN_TOKEN_COMMIT, properties);
        UserLoginServiceImpl.getInstance().getScanToken(this.loginParam, new RpcRequestCallback<GetVerifyTokenResult>() {
            /* class com.ali.user.mobile.login.tasks.FaceLoginTask.AnonymousClass2 */

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse<GetVerifyTokenResult> rpcResponse) {
                FaceLoginTask faceLoginTask = FaceLoginTask.this;
                faceLoginTask.onFaceLoginError(faceLoginTask.loginParam, rpcResponse, commonDataCallback);
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse<GetVerifyTokenResult> rpcResponse) {
                T t;
                FaceLoginTask.this.dismissLoading();
                GetVerifyTokenResponseData getVerifyTokenResponseData = (GetVerifyTokenResponseData) rpcResponse;
                if (getVerifyTokenResponseData == null || (t = getVerifyTokenResponseData.returnValue) == null || t.extMap == null) {
                    FaceLoginTask faceLoginTask = FaceLoginTask.this;
                    faceLoginTask.onFaceLoginError(faceLoginTask.loginParam, rpcResponse, commonDataCallback);
                    return;
                }
                Properties properties = new Properties();
                properties.setProperty("monitor", "T");
                properties.setProperty("sdkTraceId", FaceLoginTask.this.loginParam.traceId + "");
                UserTrackAdapter.sendUT(FaceLoginTask.this.loginParam.loginSourcePage, UTConstant.CustomEvent.UT_GET_FACELOGIN_TOKEN_SUCCESS, properties);
                String str = getVerifyTokenResponseData.returnValue.extMap.get("scanFaceLoginRPToken");
                T t2 = getVerifyTokenResponseData.returnValue;
                final String str2 = t2.token;
                final String str3 = t2.scene;
                if (ServiceFactory.getService(FaceService.class) != null) {
                    Properties properties2 = new Properties();
                    properties2.setProperty("monitor", "T");
                    UserTrackAdapter.sendUT(FaceLoginTask.this.loginParam.loginSourcePage, UTConstant.CustomEvent.UT_FACE_SDK_COMMIT, properties2);
                    ((FaceService) ServiceFactory.getService(FaceService.class)).nativeLogin(str, new FaceVerifyCallback() {
                        /* class com.ali.user.mobile.login.tasks.FaceLoginTask.AnonymousClass2.AnonymousClass1 */

                        @Override // com.ali.user.mobile.model.CommonCallback
                        public void onFail(int i, String str) {
                            Properties properties = new Properties();
                            properties.setProperty("monitor", "T");
                            String str2 = FaceLoginTask.this.loginParam.loginSourcePage;
                            UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_FACE_SDK_FAIL, i + "", properties);
                            CommonDataCallback commonDataCallback = commonDataCallback;
                            if (commonDataCallback == null) {
                                return;
                            }
                            if (i == 3) {
                                commonDataCallback.onFail(1401, str);
                            } else {
                                commonDataCallback.onFail(1402, str);
                            }
                        }

                        @Override // com.ali.user.mobile.model.CommonCallback
                        public void onSuccess() {
                            Properties properties = new Properties();
                            properties.setProperty("monitor", "T");
                            UserTrackAdapter.sendUT(FaceLoginTask.this.loginParam.loginSourcePage, UTConstant.CustomEvent.UT_FACE_SDK_SUCCESS, properties);
                            Properties properties2 = new Properties();
                            if (FaceLoginTask.this.loginParam != null) {
                                properties2.setProperty("sdkTraceId", FaceLoginTask.this.loginParam.traceId + "");
                            }
                            properties2.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                            properties2.setProperty("monitor", "T");
                            UserTrackAdapter.sendUT(FaceLoginTask.this.loginParam.loginSourcePage, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.SCAN_FACE_LOGIN, properties2);
                            FaceLoginTask faceLoginTask = FaceLoginTask.this;
                            faceLoginTask.buildTokenParam(faceLoginTask.loginParam, str2, TokenType.FACE_LOGIN, str3);
                            CommonDataCallback commonDataCallback = commonDataCallback;
                            if (commonDataCallback != null) {
                                commonDataCallback.onSuccess(null);
                            }
                        }
                    });
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse<GetVerifyTokenResult> rpcResponse) {
                FaceLoginTask faceLoginTask = FaceLoginTask.this;
                faceLoginTask.onFaceLoginError(faceLoginTask.loginParam, rpcResponse, commonDataCallback);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onFaceLoginError(LoginParam loginParam, RpcResponse<GetVerifyTokenResult> rpcResponse, CommonDataCallback commonDataCallback) {
        String str;
        int i;
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        StringBuilder sb = new StringBuilder();
        sb.append(loginParam.traceId);
        String str2 = "";
        sb.append(str2);
        properties.setProperty("sdkTraceId", sb.toString());
        String str3 = loginParam.loginSourcePage;
        if (rpcResponse == null) {
            str = "-1";
        } else {
            str = rpcResponse.code + str2;
        }
        UserTrackAdapter.sendUT(str3, UTConstant.CustomEvent.UT_GET_FACELOGIN_TOKEN_FAIL, str, "preScanFaceLogin", properties);
        dismissLoading();
        if (commonDataCallback != null) {
            if (rpcResponse == null) {
                i = -1;
            } else {
                i = rpcResponse.code;
            }
            if (rpcResponse != null) {
                str2 = rpcResponse.message;
            }
            commonDataCallback.onFail(i, str2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void buildLoginParam(final CommonDataCallback commonDataCallback) {
        BackgroundExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.login.tasks.FaceLoginTask.AnonymousClass1 */

            public void run() {
                FaceLoginTask.this.matchHistoryAccount();
                MainThreadExecutor.execute(new Runnable() {
                    /* class com.ali.user.mobile.login.tasks.FaceLoginTask.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        FaceLoginTask.this.fetchScanToken(commonDataCallback);
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
        this.loginParam.nativeLoginType = getLoginType();
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
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public String getLoginType() {
        return LoginType.ServerLoginType.FaceLogin.getType();
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.tasks.BaseLoginTask
    public void invokeLoginRpc(LoginParam loginParam, RpcRequestCallback<LoginReturnData> rpcRequestCallback) {
        LoginDataRepository.getInstance().loginByToken(loginParam, rpcRequestCallback);
    }
}
