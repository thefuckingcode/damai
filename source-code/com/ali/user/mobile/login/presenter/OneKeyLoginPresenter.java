package com.ali.user.mobile.login.presenter;

import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.model.Login2RegParam;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginApi;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.login.ui.BaseLoginView;
import com.ali.user.mobile.login.ui.OneKeyLoginFragment;
import com.ali.user.mobile.login.ui.OneKeyLoginView;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.ui.R;
import com.taobao.login4android.config.LoginSwitch;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
public class OneKeyLoginPresenter extends BaseLoginPresenter {
    protected static final String TAG = ("login." + OneKeyLoginPresenter.class.getSimpleName());

    public OneKeyLoginPresenter(BaseLoginView baseLoginView, LoginParam loginParam) {
        super(baseLoginView, loginParam);
    }

    private TrackingModel buildTrackingModel() {
        TrackingModel trackingModel = new TrackingModel();
        trackingModel.pageName = this.mViewer.getPageName();
        trackingModel.pageSpm = this.mViewer.getPageSpm();
        trackingModel.loginType = LoginType.LocalLoginType.SIM_LOGIN;
        trackingModel.traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.SIM_LOGIN, trackingModel.pageName);
        return trackingModel;
    }

    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void login() {
        if (LoginSwitch.isInABTestRegion("api", 10000)) {
            BaseLoginView baseLoginView = this.mViewer;
            if (baseLoginView != null && baseLoginView.isActive()) {
                LoginApi.simLogin(this.mLoginParam, buildTrackingModel(), this.mViewer, new LoginTasksCallback<LoginReturnData>() {
                    /* class com.ali.user.mobile.login.presenter.OneKeyLoginPresenter.AnonymousClass1 */

                    @Override // com.ali.user.mobile.callback.LoginTasksCallback
                    public void onCancel() {
                    }

                    @Override // com.ali.user.mobile.callback.LoginTasksCallback
                    public void onFail(LoginException<LoginReturnData> loginException) {
                        BaseLoginView baseLoginView = OneKeyLoginPresenter.this.mViewer;
                        if (baseLoginView != null && baseLoginView.isActive()) {
                            if (loginException.getCode() == 1501 || loginException.getCode() == 1502) {
                                OneKeyLoginPresenter.this.mViewer.toast(DataProviderFactory.getApplicationContext().getString(R.string.aliuser_onekey_login_fail_tip), 0);
                                BaseLoginView baseLoginView2 = OneKeyLoginPresenter.this.mViewer;
                                if (baseLoginView2 instanceof OneKeyLoginFragment) {
                                    ((OneKeyLoginFragment) baseLoginView2).switchToRecommendLogin();
                                }
                            } else if (loginException.getCode() == 1303 && loginException.getOrinResponse() != null && loginException.getOrinResponse().returnValue != null) {
                                BaseLoginView baseLoginView3 = OneKeyLoginPresenter.this.mViewer;
                                if (baseLoginView3 instanceof OneKeyLoginFragment) {
                                    ((OneKeyLoginFragment) baseLoginView3).onNeedVerifyMobileForReg(loginException.getMsg(), loginException.getOrinResponse().returnValue.mobile);
                                }
                            } else if (loginException.getCode() == 800 || loginException.getCode() == 700) {
                                OneKeyLoginPresenter oneKeyLoginPresenter = OneKeyLoginPresenter.this;
                                oneKeyLoginPresenter.onReceiveToast(oneKeyLoginPresenter.mLoginParam, loginException.getOrinResponse());
                            } else {
                                OneKeyLoginPresenter.this.mViewer.toast(loginException.getMsg(), 0);
                            }
                        }
                    }

                    @Override // com.ali.user.mobile.callback.LoginTasksCallback
                    public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
                    }
                });
                return;
            }
            return;
        }
        super.login();
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
                ((OneKeyLoginView) this.mViewer).onNeedVerifyMobileForReg(str, t.mobile);
                return;
            }
            boolean z = true;
            Map<String, String> map = t.extMap;
            String str3 = "";
            if (map != null) {
                if ("false".equals(map.get("showTaobaoAgreement")) || "false".equals(t.extMap.get("showAgreement"))) {
                    z = false;
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
            login2RegParam.tips = str;
            this.mViewer.onNeedReg(login2RegParam);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void onReceiveTokenLogin(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        T t;
        if (this.mViewer != null && rpcResponse != null && (t = rpcResponse.returnValue) != null) {
            T t2 = t;
            long j = 1000;
            Map<String, String> map = t2.extMap;
            if (map != null && !TextUtils.isEmpty(map.get("syncWaitTime"))) {
                try {
                    j = Long.parseLong(t2.extMap.get("syncWaitTime"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            ((OneKeyLoginView) this.mViewer).waitTokenLogin(t2.token, j);
        }
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
            LoginDataRepository.getInstance().simLogin(loginParam, rpcRequestCallback);
        }
    }
}
