package com.ali.user.mobile.login.presenter;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginApi;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.login.model.GetVerifyTokenResponseData;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.login.ui.BaseLoginView;
import com.ali.user.mobile.login.ui.FaceLoginView;
import com.ali.user.mobile.model.FaceVerifyCallback;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.service.FaceService;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.verify.impl.VerifyServiceImpl;
import com.ali.user.mobile.verify.model.GetVerifyUrlResponse;
import com.ali.user.mobile.verify.model.VerifyParam;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginStatus;
import java.util.Properties;

/* compiled from: Taobao */
public class FaceLoginPresenter extends BaseLoginPresenter {
    private static final String TAG = ("login." + FaceLoginPresenter.class.getSimpleName());

    public FaceLoginPresenter(BaseLoginView baseLoginView, LoginParam loginParam) {
        super(baseLoginView, loginParam);
    }

    private TrackingModel buildTrackingModel() {
        TrackingModel trackingModel = new TrackingModel();
        trackingModel.pageName = this.mViewer.getPageName();
        trackingModel.pageSpm = this.mViewer.getPageSpm();
        trackingModel.loginType = LoginType.LocalLoginType.SCAN_FACE_LOGIN;
        trackingModel.traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.SCAN_FACE_LOGIN, trackingModel.pageName);
        return trackingModel;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onFaceLoginError(LoginParam loginParam, RpcResponse rpcResponse, String str) {
        String str2;
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        properties.setProperty("sdkTraceId", loginParam.traceId + "");
        String str3 = loginParam.loginSourcePage;
        if (rpcResponse == null) {
            str2 = "-1";
        } else {
            str2 = rpcResponse.code + "";
        }
        UserTrackAdapter.sendUT(str3, UTConstant.CustomEvent.UT_GET_FACELOGIN_TOKEN_FAIL, str2, "preScanFaceLogin", properties);
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView != null && baseLoginView.isActive() && this.mViewer.getBaseActivity() != null) {
            this.mViewer.dismissLoading();
            this.mViewer.toast((rpcResponse == null || TextUtils.isEmpty(rpcResponse.message)) ? this.mViewer.getBaseActivity().getString(R.string.aliuser_network_error) : rpcResponse.message, 0);
        }
    }

    public void activeFaceLogin(final LoginParam loginParam) {
        if (loginParam != null) {
            new CoordinatorWrapper().execute(new AsyncTask<Object, Void, GetVerifyUrlResponse>() {
                /* class com.ali.user.mobile.login.presenter.FaceLoginPresenter.AnonymousClass3 */
                private long userId;

                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public GetVerifyUrlResponse doInBackground(Object[] objArr) {
                    VerifyParam verifyParam = new VerifyParam();
                    verifyParam.fromSite = FaceLoginPresenter.this.mViewer.getLoginSite();
                    verifyParam.actionType = "h5_non_login_open_verify";
                    LoginParam loginParam = loginParam;
                    if (loginParam != null) {
                        verifyParam.deviceTokenKey = loginParam.deviceTokenKey;
                        verifyParam.userId = loginParam.havanaId + "";
                        this.userId = loginParam.havanaId;
                    }
                    try {
                        return VerifyServiceImpl.getInstance().getNonLoginVerfiyUrl(verifyParam);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(GetVerifyUrlResponse getVerifyUrlResponse) {
                    T t;
                    if (getVerifyUrlResponse != null) {
                        if (getVerifyUrlResponse.code == 3000 && (t = getVerifyUrlResponse.returnValue) != null && !TextUtils.isEmpty(t.url)) {
                            UrlParam urlParam = new UrlParam();
                            urlParam.url = getVerifyUrlResponse.returnValue.url;
                            urlParam.ivScene = "h5_non_login_open_verify";
                            urlParam.userid = this.userId + "";
                            if (DataProviderFactory.getDataProvider().isTaobaoApp()) {
                                ((FaceService) ServiceFactory.getService(FaceService.class)).activeFaceLogin(getVerifyUrlResponse.returnValue.url, null);
                            } else {
                                ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openWebViewPage(DataProviderFactory.getApplicationContext(), urlParam);
                            }
                        } else if (getVerifyUrlResponse.code == 13050) {
                            FaceLoginPresenter.this.fetchScanToken(loginParam);
                        }
                    }
                }
            }, new Object[0]);
        }
    }

    public void fetchScanToken(final LoginParam loginParam) {
        if (LoginSwitch.isInABTestRegion("api", 10000)) {
            LoginApi.faceLogin(loginParam, buildTrackingModel(), this.mViewer, new LoginTasksCallback<LoginReturnData>() {
                /* class com.ali.user.mobile.login.presenter.FaceLoginPresenter.AnonymousClass1 */

                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onCancel() {
                }

                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onFail(LoginException<LoginReturnData> loginException) {
                    BaseLoginView baseLoginView = FaceLoginPresenter.this.mViewer;
                    if (baseLoginView != null && baseLoginView.isActive() && loginException != null) {
                        int code = loginException.getCode();
                        if (code == 1401) {
                            ((FaceLoginView) FaceLoginPresenter.this.mViewer).toLastLoginFragment();
                        } else if (code != 1402) {
                            FaceLoginPresenter.this.mViewer.toast((loginException.getOrinResponse() == null || TextUtils.isEmpty(loginException.getOrinResponse().message)) ? FaceLoginPresenter.this.mViewer.getBaseActivity().getString(R.string.aliuser_network_error) : loginException.getOrinResponse().message, 0);
                        } else {
                            BaseLoginView baseLoginView2 = FaceLoginPresenter.this.mViewer;
                            baseLoginView2.toast(baseLoginView2.getBaseActivity().getString(R.string.aliuser_scan_login_fail), 0);
                        }
                    }
                }

                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
                }
            });
            return;
        }
        this.mViewer.showLoading();
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        properties.setProperty("sdkTraceId", loginParam.traceId + "");
        UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_GET_FACELOGIN_TOKEN_COMMIT, properties);
        UserLoginServiceImpl.getInstance().getScanToken(loginParam, new RpcRequestCallback() {
            /* class com.ali.user.mobile.login.presenter.FaceLoginPresenter.AnonymousClass2 */

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                FaceLoginPresenter.this.onFaceLoginError(loginParam, rpcResponse, "Error");
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                T t;
                BaseLoginView baseLoginView = FaceLoginPresenter.this.mViewer;
                if (baseLoginView != null && baseLoginView.isActive() && FaceLoginPresenter.this.mViewer.getBaseActivity() != null) {
                    FaceLoginPresenter.this.mViewer.dismissLoading();
                    GetVerifyTokenResponseData getVerifyTokenResponseData = (GetVerifyTokenResponseData) rpcResponse;
                    if (getVerifyTokenResponseData == null || (t = getVerifyTokenResponseData.returnValue) == null || t.extMap == null) {
                        FaceLoginPresenter.this.onFaceLoginError(loginParam, rpcResponse, "Error");
                        return;
                    }
                    Properties properties = new Properties();
                    properties.setProperty("monitor", "T");
                    properties.setProperty("sdkTraceId", loginParam.traceId + "");
                    UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_GET_FACELOGIN_TOKEN_SUCCESS, properties);
                    String str = getVerifyTokenResponseData.returnValue.extMap.get("scanFaceLoginRPToken");
                    T t2 = getVerifyTokenResponseData.returnValue;
                    final String str2 = t2.token;
                    final String str3 = t2.scene;
                    if (ServiceFactory.getService(FaceService.class) != null) {
                        Properties properties2 = new Properties();
                        properties2.setProperty("monitor", "T");
                        UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_FACE_SDK_COMMIT, properties2);
                        ((FaceService) ServiceFactory.getService(FaceService.class)).nativeLogin(str, new FaceVerifyCallback() {
                            /* class com.ali.user.mobile.login.presenter.FaceLoginPresenter.AnonymousClass2.AnonymousClass1 */

                            @Override // com.ali.user.mobile.model.CommonCallback
                            public void onFail(int i, String str) {
                                BaseLoginView baseLoginView = FaceLoginPresenter.this.mViewer;
                                if (baseLoginView == null || !baseLoginView.isActive() || FaceLoginPresenter.this.mViewer.getBaseActivity() == null) {
                                    LoginStatus.resetLoginFlag();
                                    return;
                                }
                                Properties properties = new Properties();
                                properties.setProperty("monitor", "T");
                                String str2 = loginParam.loginSourcePage;
                                UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_FACE_SDK_FAIL, i + "", properties);
                                if (i == 3) {
                                    ((FaceLoginView) FaceLoginPresenter.this.mViewer).toLastLoginFragment();
                                    return;
                                }
                                FaceLoginPresenter.this.mViewer.toast(FaceLoginPresenter.this.mViewer.getBaseActivity().getString(R.string.aliuser_scan_login_fail), 0);
                            }

                            @Override // com.ali.user.mobile.model.CommonCallback
                            public void onSuccess() {
                                Properties properties = new Properties();
                                properties.setProperty("monitor", "T");
                                UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_FACE_SDK_SUCCESS, properties);
                                BaseLoginView baseLoginView = FaceLoginPresenter.this.mViewer;
                                if (baseLoginView == null || !baseLoginView.isActive() || FaceLoginPresenter.this.mViewer.getBaseActivity() == null) {
                                    LoginStatus.resetLoginFlag();
                                    return;
                                }
                                Properties properties2 = new Properties();
                                if (loginParam != null) {
                                    properties2.setProperty("sdkTraceId", loginParam.traceId + "");
                                }
                                properties2.setProperty("site", DataProviderFactory.getDataProvider().getSite() + "");
                                properties2.setProperty("monitor", "T");
                                UserTrackAdapter.sendUT(loginParam.loginSourcePage, UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.SCAN_FACE_LOGIN, properties2);
                                AnonymousClass2 r0 = AnonymousClass2.this;
                                FaceLoginPresenter.this.buildTokenParam(loginParam, str2, TokenType.FACE_LOGIN, str3);
                                FaceLoginPresenter.this.login();
                            }
                        });
                    }
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                FaceLoginPresenter.this.onFaceLoginError(loginParam, rpcResponse, "SystemError");
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void login(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        if (!TextUtils.isEmpty(loginParam.token)) {
            LoginDataRepository.getInstance().loginByToken(loginParam, rpcRequestCallback);
        }
    }
}
