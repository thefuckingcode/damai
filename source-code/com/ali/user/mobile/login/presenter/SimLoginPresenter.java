package com.ali.user.mobile.login.presenter;

import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.model.Login2RegParam;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginApi;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.login.ui.BaseLoginView;
import com.ali.user.mobile.login.ui.OneKeyLoginView;
import com.ali.user.mobile.login.ui.RecommendLoginView;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
public class SimLoginPresenter extends BaseLoginPresenter {
    protected static final String TAG = ("login." + SimLoginPresenter.class.getSimpleName());

    public SimLoginPresenter(BaseLoginView baseLoginView, LoginParam loginParam) {
        super(baseLoginView, loginParam);
    }

    private TrackingModel buildTrackingModel() {
        TrackingModel trackingModel = new TrackingModel();
        trackingModel.pageName = this.mViewer.getPageName();
        trackingModel.pageSpm = this.mViewer.getPageSpm();
        trackingModel.loginType = LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN;
        trackingModel.traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.MOBILE_VERIFY_LOGIN, trackingModel.pageName);
        return trackingModel;
    }

    public void login(LoginParam loginParam) {
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView != null && baseLoginView.isActive()) {
            LoginApi.mobileVerifyLogin(loginParam, buildTrackingModel(), this.mViewer, new LoginTasksCallback<LoginReturnData>() {
                /* class com.ali.user.mobile.login.presenter.SimLoginPresenter.AnonymousClass1 */

                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onCancel() {
                }

                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onFail(LoginException<LoginReturnData> loginException) {
                    BaseLoginView baseLoginView = SimLoginPresenter.this.mViewer;
                    if (baseLoginView != null && baseLoginView.isActive()) {
                        if (loginException.getCode() == 1601) {
                            BaseLoginView baseLoginView2 = SimLoginPresenter.this.mViewer;
                            if (baseLoginView2 instanceof OneKeyLoginView) {
                                ((OneKeyLoginView) baseLoginView2).onGetAccessTokenFail();
                            } else if (baseLoginView2 instanceof RecommendLoginView) {
                                ((RecommendLoginView) baseLoginView2).onGetAccessTokenFail();
                            }
                        } else if (loginException.getCode() == 1303 && loginException.getOrinResponse() != null && loginException.getOrinResponse().returnValue != null) {
                            BaseLoginView baseLoginView3 = SimLoginPresenter.this.mViewer;
                            if (baseLoginView3 instanceof OneKeyLoginView) {
                                ((OneKeyLoginView) baseLoginView3).onNeedVerifyMobileForReg(loginException.getMsg(), loginException.getOrinResponse().returnValue.mobile);
                            } else if (baseLoginView3 instanceof RecommendLoginView) {
                                ((RecommendLoginView) baseLoginView3).onNeedVerifyMobileForReg(loginException.getMsg(), loginException.getOrinResponse().returnValue.mobile);
                            }
                        } else if (loginException.getCode() == 800 || loginException.getCode() == 700) {
                            SimLoginPresenter simLoginPresenter = SimLoginPresenter.this;
                            simLoginPresenter.onReceiveToast(simLoginPresenter.mLoginParam, loginException.getOrinResponse());
                        } else {
                            SimLoginPresenter.this.mViewer.toast(loginException.getMsg(), 0);
                        }
                    }
                }

                @Override // com.ali.user.mobile.callback.LoginTasksCallback
                public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
                }
            });
        }
    }

    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void onLoginSuccess(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        T t;
        if (rpcResponse != null && (t = rpcResponse.returnValue) != null) {
            LoginDataHelper.processLoginReturnData(true, t, loginParam, "", null);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void onReceiveRegister(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        if (this.mViewer != null) {
            T t = rpcResponse.returnValue;
            String str = rpcResponse.message;
            loginParam.token = null;
            if (rpcResponse.code == 14044) {
                String str2 = loginParam.loginSourcePage;
                Properties properties = new Properties();
                properties.setProperty("monitor", "T");
                UserTrackAdapter.sendUT(str2, UTConstant.CustomEvent.UT_SINGLE_LOGIN_FAILURE, UTConstant.ErrorCode.LOGIN2REG_CANCEL_ALERT, LoginType.LocalLoginType.SIM_LOGIN, properties);
                BaseLoginView baseLoginView = this.mViewer;
                if (baseLoginView instanceof RecommendLoginView) {
                    ((RecommendLoginView) baseLoginView).onNeedVerifyMobileForReg(str, t.mobile);
                } else if (baseLoginView instanceof OneKeyLoginView) {
                    ((OneKeyLoginView) baseLoginView).onNeedVerifyMobileForReg(str, t.mobile);
                }
            } else {
                String str3 = "";
                if (this.mLoginParam != null) {
                    Properties properties2 = new Properties();
                    properties2.setProperty("sdkTraceId", this.mLoginParam.traceId + str3);
                    UserTrackAdapter.sendUT(this.mLoginParam.loginSourcePage, UTConstant.CustomEvent.UT_LOGIN_TO_REG, properties2);
                }
                boolean z = true;
                Map<String, String> map = t.extMap;
                if (map != null) {
                    if ("false".equals(map.get("showTaobaoAgreement")) || "false".equals(t.extMap.get("showAgreement"))) {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(t.extMap.get("regHintTitle"))) {
                        str = t.extMap.get("regHintTitle");
                    }
                    if (!TextUtils.isEmpty(t.extMap.get("regHintSubTitle"))) {
                        str3 = t.extMap.get("regHintSubTitle");
                    }
                }
                Login2RegParam login2RegParam = new Login2RegParam();
                login2RegParam.needAlert = z;
                login2RegParam.token = t.token;
                login2RegParam.title = str;
                login2RegParam.subTitle = str3;
                BaseLoginView baseLoginView2 = this.mViewer;
                if (baseLoginView2 instanceof RecommendLoginView) {
                    baseLoginView2.onNeedReg(login2RegParam);
                } else if (baseLoginView2 instanceof OneKeyLoginView) {
                    baseLoginView2.onNeedReg(login2RegParam);
                }
            }
        }
    }

    public void simLoginWithUserInput(String str, String str2) {
        LoginParam loginParam = this.mLoginParam;
        loginParam.token = str;
        loginParam.tokenType = str2;
        login();
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void updateLoginParam(LoginParam loginParam, RpcResponse rpcResponse) {
        String str = TokenType.NUMBER.equals(loginParam.tokenType) ? loginParam.token : "";
        super.updateLoginParam(loginParam, rpcResponse);
        if (!TextUtils.isEmpty(str)) {
            loginParam.token = str;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void login(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        if (TextUtils.isEmpty(loginParam.token) || !TokenType.NUMBER.equals(loginParam.tokenType)) {
            super.login(loginParam, rpcRequestCallback);
        } else {
            LoginDataRepository.getInstance().simLoginWithUserInput(loginParam, rpcRequestCallback);
        }
    }

    public void simLoginWithUserInput(String str) {
        if (this.mLoginParam == null) {
            this.mLoginParam = new LoginParam();
        }
        LoginParam loginParam = this.mLoginParam;
        loginParam.loginAccount = str;
        login(loginParam);
    }
}
