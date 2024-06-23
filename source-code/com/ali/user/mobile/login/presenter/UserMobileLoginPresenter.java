package com.ali.user.mobile.login.presenter;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.ali.user.mobile.base.helper.SDKExceptionHelper;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.data.LoginComponent;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.login.LoginApi;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.login.ui.BaseLoginView;
import com.ali.user.mobile.login.ui.UserMobileLoginView;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.navigation.NavigatorManager;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.mobile.register.model.BaseRegistRequest;
import com.ali.user.mobile.register.model.MtopRegisterInitcontextResponseData;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.CountryCodeUtil;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.ali.user.mobile.utils.ResourceUtil;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginStatus;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class UserMobileLoginPresenter extends BaseLoginPresenter {
    private static final String TAG = ("login." + UserMobileLoginPresenter.class.getSimpleName());

    public UserMobileLoginPresenter(BaseLoginView baseLoginView, LoginParam loginParam) {
        super(baseLoginView, loginParam);
    }

    private TrackingModel buildTrackingModel() {
        TrackingModel trackingModel = new TrackingModel();
        trackingModel.pageName = this.mViewer.getPageName();
        trackingModel.pageSpm = this.mViewer.getPageSpm();
        trackingModel.loginType = LoginType.LocalLoginType.SMS_LOGIN;
        trackingModel.traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.SMS_LOGIN, trackingModel.pageName);
        return trackingModel;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dismissLoading() {
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView != null && baseLoginView.isActive()) {
            this.mViewer.dismissLoading();
        }
    }

    private void getRegion(final RpcRequestCallback rpcRequestCallback) {
        BackgroundExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.AnonymousClass3 */

            public void run() {
                final MtopRegisterInitcontextResponseData mtopRegisterInitcontextResponseData;
                new BaseRegistRequest().ext = new HashMap();
                try {
                    mtopRegisterInitcontextResponseData = (MtopRegisterInitcontextResponseData) LoginComponent.getInstance().getCountryList();
                } catch (Throwable th) {
                    th.printStackTrace();
                    mtopRegisterInitcontextResponseData = null;
                }
                MainThreadExecutor.execute(new Runnable() {
                    /* class com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.AnonymousClass3.AnonymousClass1 */

                    public void run() {
                        RpcRequestCallback rpcRequestCallback = rpcRequestCallback;
                        if (rpcRequestCallback != null) {
                            MtopRegisterInitcontextResponseData mtopRegisterInitcontextResponseData = mtopRegisterInitcontextResponseData;
                            if (mtopRegisterInitcontextResponseData == null) {
                                rpcRequestCallback.onSystemError(null);
                            } else if (mtopRegisterInitcontextResponseData.code == 3000) {
                                rpcRequestCallback.onSuccess(mtopRegisterInitcontextResponseData);
                            } else {
                                rpcRequestCallback.onError(mtopRegisterInitcontextResponseData);
                            }
                        }
                    }
                });
            }
        });
    }

    private void newSendSms(String str) {
        this.mViewer.showLoading();
        snewSndSMSAction(this.mLoginParam, str, new LoginTasksCallback<LoginReturnData>() {
            /* class com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.AnonymousClass7 */

            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onCancel() {
                UserMobileLoginPresenter.this.dismissLoading();
            }

            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onFail(LoginException<LoginReturnData> loginException) {
                LoginParam loginParam;
                BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView != null && baseLoginView.isActive()) {
                    UserMobileLoginPresenter.this.dismissLoading();
                    if (loginException.getCode() != 800) {
                        String msg = loginException.getMsg();
                        if (TextUtils.isEmpty(msg)) {
                            msg = ResourceUtil.getStringById("aliuser_network_error");
                        }
                        UserMobileLoginPresenter.this.mViewer.toast(msg, 0);
                    } else if (UserMobileLoginPresenter.this.mViewer == null) {
                    } else {
                        if (loginException.getOrinResponse().code != 14100 || (loginParam = UserMobileLoginPresenter.this.mLoginParam) == null || TextUtils.isEmpty(loginParam.smsSid) || TextUtils.isEmpty(UserMobileLoginPresenter.this.mLoginParam.codeLength)) {
                            String str = loginException.getOrinResponse().message;
                            if (TextUtils.isEmpty(str)) {
                                str = ResourceUtil.getStringById("aliuser_network_error");
                            }
                            BaseLoginView baseLoginView2 = UserMobileLoginPresenter.this.mViewer;
                            baseLoginView2.alert(str, "", baseLoginView2.getBaseActivity().getResources().getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() {
                                /* class com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.AnonymousClass7.AnonymousClass2 */

                                public void onClick(DialogInterface dialogInterface, int i) {
                                    BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                                    if (baseLoginView != null && baseLoginView.isActive()) {
                                        UserMobileLoginPresenter.this.mViewer.dismissAlertDialog();
                                    }
                                }
                            }, null, null);
                            return;
                        }
                        ((UserMobileLoginView) UserMobileLoginPresenter.this.mViewer).onSMSOverLimit(loginException.getOrinResponse());
                    }
                }
            }

            @Override // com.ali.user.mobile.callback.LoginTasksCallback
            public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
                BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView != null && baseLoginView.isActive()) {
                    UserMobileLoginPresenter.this.dismissLoading();
                    T t = rpcResponse.returnValue;
                    if (t != null) {
                        UserMobileLoginPresenter.this.mLoginParam.smsSid = t.extMap.get("smsSid");
                        UserMobileLoginPresenter.this.mLoginParam.codeLength = t.extMap.get(RegistConstants.REGISTER_CODE_LENGTH);
                        if (!TextUtils.isEmpty(t.extMap.get("helpVideoUrl"))) {
                            UserMobileLoginPresenter.this.mLoginParam.helpUrl = t.extMap.get("helpVideoUrl");
                        }
                        if (!TextUtils.equals(rpcResponse.actionType, "SUCCESS")) {
                            return;
                        }
                        if (rpcResponse.code == 14050) {
                            BaseLoginView baseLoginView2 = UserMobileLoginPresenter.this.mViewer;
                            baseLoginView2.alert("", rpcResponse.message, baseLoginView2.getBaseActivity().getResources().getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() {
                                /* class com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.AnonymousClass7.AnonymousClass1 */

                                public void onClick(DialogInterface dialogInterface, int i) {
                                    BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                                    if (baseLoginView != null && baseLoginView.isActive()) {
                                        UserMobileLoginPresenter.this.mViewer.dismissAlertDialog();
                                    }
                                }
                            }, null, null);
                            ((UserMobileLoginView) UserMobileLoginPresenter.this.mViewer).onSendSMSSuccess(DateUtils.MILLIS_PER_MINUTE, false);
                            return;
                        }
                        ((UserMobileLoginView) UserMobileLoginPresenter.this.mViewer).onSendSMSSuccess(DateUtils.MILLIS_PER_MINUTE, true);
                    }
                }
            }
        });
    }

    private void sendSMSAction(final LoginParam loginParam, final String str, final RpcRequestCallback rpcRequestCallback) {
        BackgroundExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.AnonymousClass6 */

            public void run() {
                BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView != null && baseLoginView.isHistoryMode()) {
                    UserMobileLoginPresenter.this.matchHistoryAccount();
                }
                MainThreadExecutor.execute(new Runnable() {
                    /* class com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.AnonymousClass6.AnonymousClass1 */

                    public void run() {
                        AnonymousClass6 r0 = AnonymousClass6.this;
                        if (rpcRequestCallback != null) {
                            if (TextUtils.isEmpty(str)) {
                                LoginComponent instance = LoginComponent.getInstance();
                                AnonymousClass6 r1 = AnonymousClass6.this;
                                instance.sendSmsByLogin(loginParam, rpcRequestCallback);
                                return;
                            }
                            AnonymousClass6 r02 = AnonymousClass6.this;
                            loginParam.loginAccount = str;
                            LoginComponent instance2 = LoginComponent.getInstance();
                            AnonymousClass6 r12 = AnonymousClass6.this;
                            instance2.sendSmsByLoginWithNick(loginParam, rpcRequestCallback);
                        }
                    }
                });
            }
        });
    }

    private void snewSndSMSAction(LoginParam loginParam, String str, LoginTasksCallback<LoginReturnData> loginTasksCallback) {
        if (TextUtils.isEmpty(str)) {
            LoginApi.smsSend(loginParam, buildTrackingModel(), this.mViewer, loginTasksCallback);
            return;
        }
        loginParam.loginAccount = str;
        LoginApi.nickSmsSend(loginParam, buildTrackingModel(), this.mViewer, loginTasksCallback);
    }

    public void buildSMSLoginParam(String str, String str2, boolean z) {
        if (this.mLoginParam == null) {
            this.mLoginParam = new LoginParam();
        }
        this.mLoginParam.nativeLoginType = LoginType.ServerLoginType.SMSLogin.getType();
        this.mLoginParam.isFromAccount = this.mViewer.isHistoryMode();
        this.mLoginParam.loginSite = this.mViewer.getLoginSite();
        LoginParam loginParam = this.mLoginParam;
        loginParam.loginAccount = str;
        loginParam.smsCode = str2;
        if (loginParam.externParams == null) {
            loginParam.externParams = new HashMap();
        }
        this.mLoginParam.externParams.put("apiReferer", ApiReferer.generateApiReferer());
        this.mLoginParam.externParams.put("showReigsterPolicy", "true");
        this.mLoginParam.loginType = this.mViewer.getLoginType().getType();
        this.mLoginParam.countryCode = ((UserMobileLoginView) this.mViewer).getCountryCode();
        this.mLoginParam.phoneCode = ((UserMobileLoginView) this.mViewer).getPhoneCode();
        LoginParam loginParam2 = this.mLoginParam;
        loginParam2.deviceTokenKey = "";
        loginParam2.havanaId = 0;
        loginParam2.enableVoiceSMS = z;
    }

    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void login() {
        if (LoginSwitch.isInABTestRegion("api", 10000)) {
            BaseLoginView baseLoginView = this.mViewer;
            if (baseLoginView != null && baseLoginView.isActive()) {
                LoginApi.smsLogin(this.mLoginParam.clone(), buildTrackingModel(), this.mViewer, new LoginTasksCallback<LoginReturnData>() {
                    /* class com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.AnonymousClass1 */

                    @Override // com.ali.user.mobile.callback.LoginTasksCallback
                    public void onCancel() {
                        UserMobileLoginPresenter.this.dismissLoading();
                    }

                    @Override // com.ali.user.mobile.callback.LoginTasksCallback
                    public void onFail(LoginException<LoginReturnData> loginException) {
                        BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                        if (baseLoginView != null && baseLoginView.isActive()) {
                            UserMobileLoginPresenter.this.dismissLoading();
                            if (loginException.getCode() == 700) {
                                UserMobileLoginPresenter userMobileLoginPresenter = UserMobileLoginPresenter.this;
                                userMobileLoginPresenter.onReceiveAlert(userMobileLoginPresenter.mLoginParam, loginException.getOrinResponse());
                                return;
                            }
                            UserMobileLoginPresenter.this.mViewer.toast(loginException.getMsg(), 0);
                        }
                    }

                    @Override // com.ali.user.mobile.callback.LoginTasksCallback
                    public void onSuccess(RpcResponse<LoginReturnData> rpcResponse) {
                        UserMobileLoginPresenter.this.dismissLoading();
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
    public void onReceiveAlert(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        String str;
        if (this.mViewer != null) {
            String str2 = rpcResponse.message;
            T t = rpcResponse.returnValue;
            if (t == null || t.extMap == null) {
                str = "";
            } else {
                str = t.extMap.get(ApiConstants.ApiField.SNS_BIND_TITLE);
                str2 = rpcResponse.returnValue.extMap.get(ApiConstants.ApiField.SNS_BIND_CONTENT);
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = ResourceUtil.getStringById("aliuser_network_error");
            }
            BaseLoginView baseLoginView = this.mViewer;
            baseLoginView.alert(str, str2, baseLoginView.getBaseActivity().getResources().getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() {
                /* class com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.AnonymousClass4 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                    if (baseLoginView != null && baseLoginView.isActive()) {
                        UserMobileLoginPresenter.this.mViewer.dismissAlertDialog();
                        ((UserMobileLoginView) UserMobileLoginPresenter.this.mViewer).onCheckCodeError();
                    }
                }
            }, null, null);
        }
    }

    public void region() {
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView != null && baseLoginView.isActive()) {
            this.mViewer.showLoading();
            getRegion(new RpcRequestCallback() {
                /* class com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.AnonymousClass2 */

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onError(RpcResponse rpcResponse) {
                    BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                    if (baseLoginView != null && baseLoginView.isActive()) {
                        UserMobileLoginPresenter.this.mViewer.dismissLoading();
                        SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException((Integer) 6, ""));
                    }
                }

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onSuccess(RpcResponse rpcResponse) {
                    MtopRegisterInitcontextResponseData mtopRegisterInitcontextResponseData;
                    T t;
                    BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                    if (baseLoginView != null && baseLoginView.isActive() && (mtopRegisterInitcontextResponseData = (MtopRegisterInitcontextResponseData) rpcResponse) != null && (t = mtopRegisterInitcontextResponseData.returnValue) != null && t.countrycodes != null) {
                        ArrayList<RegionInfo> fillData = CountryCodeUtil.fillData(ResourceUtil.getStringById("aliuser_common_region"), mtopRegisterInitcontextResponseData.returnValue.countrycodes, new HashMap(), new ArrayList());
                        UserMobileLoginPresenter.this.mViewer.dismissLoading();
                        UserMobileLoginPresenter.this.mViewer.onGetRegion(fillData);
                    }
                }

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onSystemError(RpcResponse rpcResponse) {
                    BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                    if (baseLoginView != null && baseLoginView.isActive()) {
                        UserMobileLoginPresenter.this.mViewer.dismissLoading();
                        SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException((Integer) 6, ""));
                    }
                }
            });
        }
    }

    public void sendSMS() {
        sendSMS("");
    }

    public void sendSMS(String str) {
        if (LoginSwitch.isInABTestRegion("api", 10000)) {
            newSendSms(str);
            return;
        }
        this.mViewer.showLoading();
        sendSMSAction(getLoginParam(), str, new RpcRequestCallback() {
            /* class com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.AnonymousClass5 */

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                LoginParam loginParam;
                BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView != null && baseLoginView.isActive()) {
                    UserMobileLoginPresenter.this.mViewer.dismissLoading();
                    if (rpcResponse == null) {
                        return;
                    }
                    if (TextUtils.equals(rpcResponse.actionType, ApiConstants.ResultActionType.TOAST)) {
                        UserMobileLoginPresenter userMobileLoginPresenter = UserMobileLoginPresenter.this;
                        if (userMobileLoginPresenter.mViewer == null) {
                            return;
                        }
                        if (rpcResponse.code != 14100 || (loginParam = userMobileLoginPresenter.mLoginParam) == null || TextUtils.isEmpty(loginParam.smsSid) || TextUtils.isEmpty(UserMobileLoginPresenter.this.mLoginParam.codeLength)) {
                            String str = rpcResponse.message;
                            if (TextUtils.isEmpty(str)) {
                                str = ResourceUtil.getStringById("aliuser_network_error");
                            }
                            BaseLoginView baseLoginView2 = UserMobileLoginPresenter.this.mViewer;
                            baseLoginView2.alert("", str, baseLoginView2.getBaseActivity().getResources().getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() {
                                /* class com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.AnonymousClass5.AnonymousClass2 */

                                public void onClick(DialogInterface dialogInterface, int i) {
                                    BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                                    if (baseLoginView != null && baseLoginView.isActive()) {
                                        UserMobileLoginPresenter.this.mViewer.dismissAlertDialog();
                                    }
                                }
                            }, null, null);
                            return;
                        }
                        ((UserMobileLoginView) UserMobileLoginPresenter.this.mViewer).onSMSOverLimit(rpcResponse);
                        return;
                    }
                    T t = rpcResponse.returnValue;
                    if (t == null) {
                        String str2 = rpcResponse.message;
                        if (TextUtils.isEmpty(str2)) {
                            str2 = ResourceUtil.getStringById("aliuser_network_error");
                        }
                        UserMobileLoginPresenter.this.mViewer.toast(str2, 0);
                    } else if (!TextUtils.equals(rpcResponse.actionType, "H5")) {
                    } else {
                        if (!TextUtils.isEmpty(t.h5Url)) {
                            String str3 = t.h5Url;
                            LoginParam loginParam2 = UserMobileLoginPresenter.this.mLoginParam;
                            loginParam2.tokenType = TokenType.SMS_LOGIN;
                            loginParam2.errorCode = "" + rpcResponse.code;
                            NavigatorManager.getInstance().navToWebViewPage(UserMobileLoginPresenter.this.mViewer.getBaseActivity(), str3, UserMobileLoginPresenter.this.mLoginParam, t);
                            return;
                        }
                        String str4 = rpcResponse.message;
                        if (TextUtils.isEmpty(str4)) {
                            str4 = ResourceUtil.getStringById("aliuser_network_error");
                        }
                        UserMobileLoginPresenter.this.mViewer.toast(str4, 0);
                    }
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView != null && baseLoginView.isActive()) {
                    UserMobileLoginPresenter.this.mViewer.dismissLoading();
                    T t = rpcResponse.returnValue;
                    if (t != null) {
                        UserMobileLoginPresenter.this.mLoginParam.smsSid = t.extMap.get("smsSid");
                        UserMobileLoginPresenter.this.mLoginParam.codeLength = t.extMap.get(RegistConstants.REGISTER_CODE_LENGTH);
                        if (!TextUtils.isEmpty(t.extMap.get("helpVideoUrl"))) {
                            UserMobileLoginPresenter.this.mLoginParam.helpUrl = t.extMap.get("helpVideoUrl");
                        }
                        if (!TextUtils.equals(rpcResponse.actionType, "SUCCESS")) {
                            return;
                        }
                        if (rpcResponse.code == 14050) {
                            BaseLoginView baseLoginView2 = UserMobileLoginPresenter.this.mViewer;
                            baseLoginView2.alert("", rpcResponse.message, baseLoginView2.getBaseActivity().getResources().getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() {
                                /* class com.ali.user.mobile.login.presenter.UserMobileLoginPresenter.AnonymousClass5.AnonymousClass1 */

                                public void onClick(DialogInterface dialogInterface, int i) {
                                    BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                                    if (baseLoginView != null && baseLoginView.isActive()) {
                                        UserMobileLoginPresenter.this.mViewer.dismissAlertDialog();
                                    }
                                }
                            }, null, null);
                            ((UserMobileLoginView) UserMobileLoginPresenter.this.mViewer).onSendSMSSuccess(DateUtils.MILLIS_PER_MINUTE, false);
                            return;
                        }
                        ((UserMobileLoginView) UserMobileLoginPresenter.this.mViewer).onSendSMSSuccess(DateUtils.MILLIS_PER_MINUTE, true);
                    }
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                BaseLoginView baseLoginView = UserMobileLoginPresenter.this.mViewer;
                if (baseLoginView != null && baseLoginView.isActive()) {
                    UserMobileLoginPresenter.this.mViewer.dismissLoading();
                    if (rpcResponse != null) {
                        SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException(Integer.valueOf(rpcResponse.code), rpcResponse.message));
                    } else {
                        SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException((Integer) 6, ""));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void login(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        if (!TextUtils.isEmpty(loginParam.token)) {
            if (!TextUtils.isEmpty(loginParam.snsType)) {
                LoginStatus.loginEntrance = loginParam.snsType;
            } else {
                LoginStatus.loginEntrance = loginParam.tokenType;
            }
            LoginDataRepository.getInstance().loginByToken(loginParam, rpcRequestCallback);
            return;
        }
        if (TextUtils.isEmpty(loginParam.snsToken)) {
            LoginStatus.loginEntrance = LoginType.ServerLoginType.SMSLogin.getType();
        }
        LoginComponent.getInstance().smsLogin(loginParam, rpcRequestCallback);
    }
}
