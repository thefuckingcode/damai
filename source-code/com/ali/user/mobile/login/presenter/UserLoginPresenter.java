package com.ali.user.mobile.login.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.helper.SDKExceptionHelper;
import com.ali.user.mobile.callback.LoginTasksCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.exception.LoginException;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.LongLifeCycleUserTrack;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginApi;
import com.ali.user.mobile.login.LoginDataRepository;
import com.ali.user.mobile.login.ui.BaseLoginFragment;
import com.ali.user.mobile.login.ui.BaseLoginView;
import com.ali.user.mobile.login.ui.UserLoginView;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.navigation.NavigatorManager;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.h5.MtopAccountCenterUrlResponseData;
import com.ali.user.mobile.rpc.h5.MtopFoundPasswordResponseData;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.url.model.AccountCenterParam;
import com.ali.user.mobile.url.service.impl.UrlFetchServiceImpl;
import com.ali.user.mobile.utils.StringUtil;
import com.taobao.login4android.config.LoginSwitch;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
public class UserLoginPresenter extends BaseLoginPresenter {
    public UserLoginPresenter(BaseLoginView baseLoginView, LoginParam loginParam) {
        super(baseLoginView, loginParam);
    }

    private TrackingModel buildTrackingModel() {
        TrackingModel trackingModel = new TrackingModel();
        trackingModel.pageName = this.mViewer.getPageName();
        trackingModel.pageSpm = this.mViewer.getPageSpm();
        trackingModel.loginType = LoginType.LocalLoginType.PWD_LOGIN;
        trackingModel.traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.PWD_LOGIN, trackingModel.pageName);
        return trackingModel;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handlePhoneLoginFindPwd(MtopFoundPasswordResponseData mtopFoundPasswordResponseData, final String str, final String str2) {
        if (mtopFoundPasswordResponseData == null) {
            this.mViewer.toast(DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error), 0);
            return;
        }
        final HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(mtopFoundPasswordResponseData.mobileLoginUrl)) {
            String string = this.mViewer.getBaseActivity().getResources().getString(R.string.aliuser_find_pwd_phone_hint, StringUtil.dataMasking(mtopFoundPasswordResponseData.secMobile));
            hashMap.put(string, mtopFoundPasswordResponseData.mobileLoginUrl);
            arrayList.add(string);
        }
        if (!TextUtils.isEmpty(mtopFoundPasswordResponseData.passwordFindUrl)) {
            String string2 = this.mViewer.getBaseActivity().getResources().getString(R.string.aliuser_alert_findpwd);
            hashMap.put(string2, mtopFoundPasswordResponseData.passwordFindUrl);
            arrayList.add(string2);
        }
        if (arrayList.size() > 1) {
            arrayList.add(this.mViewer.getBaseActivity().getResources().getString(R.string.aliuser_cancel));
            final String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            this.mViewer.alertList(strArr, new DialogInterface.OnClickListener() {
                /* class com.ali.user.mobile.login.presenter.UserLoginPresenter.AnonymousClass4 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    BaseLoginView baseLoginView = UserLoginPresenter.this.mViewer;
                    if (baseLoginView != null && baseLoginView.isActive()) {
                        if (TextUtils.equals(UserLoginPresenter.this.mViewer.getBaseActivity().getResources().getString(R.string.aliuser_cancel), strArr[i])) {
                            UserTrackAdapter.control(UTConstant.PageName.UT_PAGE_HISTORY_LOGIN, UTConstant.PageName.F_HISTORY_LOGIN, "Button-ForgetPwd-Cancel");
                            UserLoginPresenter.this.mViewer.dismissAlertDialog();
                            return;
                        }
                        LoginParam loginParam = new LoginParam();
                        loginParam.tokenType = TokenType.FIND_PWD;
                        loginParam.isFromAccount = true;
                        loginParam.source = str2;
                        BaseLoginView baseLoginView2 = UserLoginPresenter.this.mViewer;
                        if (baseLoginView2 instanceof BaseLoginFragment) {
                            loginParam.loginSourcePage = ((BaseLoginFragment) baseLoginView2).getPageName();
                            loginParam.loginSourceSpm = ((BaseLoginFragment) UserLoginPresenter.this.mViewer).getPageSpm();
                        } else {
                            loginParam.loginSourcePage = UTConstant.PageName.UT_PAGE_HISTORY_LOGIN;
                        }
                        LoginReturnData loginReturnData = new LoginReturnData();
                        loginReturnData.site = UserLoginPresenter.this.mViewer.getLoginSite();
                        if (i == 0) {
                            loginParam.traceId = ApiReferer.generateTraceId("h5MobileLogin", loginParam.loginSourcePage);
                            loginParam.loginSourceType = "h5MobileLogin";
                            HashMap hashMap = new HashMap();
                            hashMap.put("sdkTraceId", loginParam.traceId + "");
                            UserTrackAdapter.control(loginParam.loginSourcePage, loginParam.loginSourceSpm, "Button-LoginByPhone", "", hashMap);
                            loginReturnData.scene = "1016";
                        } else {
                            loginParam.traceId = str;
                            loginParam.loginSourceType = LoginType.LocalLoginType.RETRIVE_PWD_LOGIN;
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("sdkTraceId", loginParam.traceId + "");
                            UserTrackAdapter.control(loginParam.loginSourcePage, loginParam.loginSourceSpm, "Button-ResetPwd", "", hashMap2);
                            loginReturnData.scene = "1014";
                        }
                        HistoryAccount historyAccount = UserLoginPresenter.this.mViewer.getHistoryAccount();
                        if (historyAccount != null) {
                            loginReturnData.showLoginId = historyAccount.userInputName;
                        }
                        loginParam.errorCode = "0";
                        NavigatorManager.getInstance().navToWebViewPage(UserLoginPresenter.this.mViewer.getBaseActivity(), (String) hashMap.get(strArr[i]), loginParam, loginReturnData);
                    }
                }
            }, true);
        } else if (arrayList.size() == 1) {
            LoginParam loginParam = new LoginParam();
            loginParam.tokenType = TokenType.FIND_PWD;
            loginParam.isFromAccount = true;
            LoginReturnData loginReturnData = new LoginReturnData();
            loginReturnData.site = this.mViewer.getLoginSite();
            loginReturnData.scene = "1014";
            loginParam.errorCode = "0";
            NavigatorManager.getInstance().navToWebViewPage(this.mViewer.getBaseActivity(), mtopFoundPasswordResponseData.passwordFindUrl, loginParam, loginReturnData);
        } else {
            this.mViewer.toast(DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error), 0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void cleanDataHodler() {
        super.cleanDataHodler();
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView instanceof UserLoginView) {
            ((UserLoginView) baseLoginView).clearPasswordInput();
        }
    }

    public void fetchUrlAndToWebView(Context context, String str, String str2, String str3) {
        fetchUrlAndToWebView(context, str, str2, this.mViewer.getLoginSite(), str3);
    }

    public void fetchUrlAndToWebViewWithUserId(Context context, String str, final long j, final String str2) {
        String str3;
        String str4;
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView != null && baseLoginView.isActive()) {
            this.mViewer.showLoading();
            BaseLoginView baseLoginView2 = this.mViewer;
            if (baseLoginView2 instanceof BaseLoginFragment) {
                str4 = ((BaseLoginFragment) baseLoginView2).getPageName();
                str3 = ((BaseLoginFragment) this.mViewer).getPageSpm();
            } else {
                str4 = UTConstant.PageName.UT_PAGE_HISTORY_LOGIN;
                str3 = UTConstant.PageName.F_HISTORY_LOGIN;
            }
            final String generateTraceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.RETRIVE_PWD_LOGIN, str4);
            HashMap hashMap = new HashMap();
            hashMap.put("sdkTraceId", generateTraceId);
            UserTrackAdapter.control(str4, str3, UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.RETRIVE_PWD_LOGIN, hashMap);
            new CoordinatorWrapper().execute(new AsyncTask<Object, Void, MtopFoundPasswordResponseData>() {
                /* class com.ali.user.mobile.login.presenter.UserLoginPresenter.AnonymousClass3 */

                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public MtopFoundPasswordResponseData doInBackground(Object... objArr) {
                    try {
                        AccountCenterParam accountCenterParam = new AccountCenterParam();
                        accountCenterParam.havanaId = String.valueOf(j);
                        HistoryAccount findHistoryAccount = SecurityGuardManagerWraper.findHistoryAccount(j);
                        if (findHistoryAccount != null) {
                            accountCenterParam.deviceTokenKey = findHistoryAccount.tokenKey;
                        }
                        accountCenterParam.fromSite = UserLoginPresenter.this.mViewer.getLoginSite();
                        accountCenterParam.traceId = generateTraceId;
                        return UrlFetchServiceImpl.getInstance().foundPassword(accountCenterParam);
                    } catch (RpcException | Exception unused) {
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(MtopFoundPasswordResponseData mtopFoundPasswordResponseData) {
                    BaseLoginView baseLoginView;
                    BaseLoginView baseLoginView2 = UserLoginPresenter.this.mViewer;
                    if (baseLoginView2 != null && baseLoginView2.isActive()) {
                        try {
                            UserLoginPresenter.this.handlePhoneLoginFindPwd(mtopFoundPasswordResponseData, generateTraceId, str2);
                            baseLoginView = UserLoginPresenter.this.mViewer;
                            if (baseLoginView == null) {
                                return;
                            }
                        } catch (RpcException e) {
                            SDKExceptionHelper.getInstance().rpcExceptionHandler(e);
                            baseLoginView = UserLoginPresenter.this.mViewer;
                            if (baseLoginView == null) {
                                return;
                            }
                        } catch (Exception unused) {
                            baseLoginView = UserLoginPresenter.this.mViewer;
                            if (baseLoginView == null) {
                                return;
                            }
                        } catch (Throwable th) {
                            BaseLoginView baseLoginView3 = UserLoginPresenter.this.mViewer;
                            if (baseLoginView3 != null) {
                                baseLoginView3.dismissLoading();
                            }
                            throw th;
                        }
                        baseLoginView.dismissLoading();
                    }
                }
            }, new Object[0]);
        }
    }

    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void login() {
        if (LoginSwitch.isInABTestRegion("api", 10000)) {
            BaseLoginView baseLoginView = this.mViewer;
            if (baseLoginView != null && baseLoginView.isActive()) {
                LoginApi.pwdLogin(this.mLoginParam.clone(), buildTrackingModel(), this.mViewer, new LoginTasksCallback<LoginReturnData>() {
                    /* class com.ali.user.mobile.login.presenter.UserLoginPresenter.AnonymousClass1 */

                    @Override // com.ali.user.mobile.callback.LoginTasksCallback
                    public void onCancel() {
                    }

                    @Override // com.ali.user.mobile.callback.LoginTasksCallback
                    public void onFail(LoginException<LoginReturnData> loginException) {
                        BaseLoginView baseLoginView = UserLoginPresenter.this.mViewer;
                        if (baseLoginView != null && baseLoginView.isActive()) {
                            if (loginException.getCode() == 800 || loginException.getCode() == 700) {
                                UserLoginPresenter userLoginPresenter = UserLoginPresenter.this;
                                userLoginPresenter.onReceiveToast(userLoginPresenter.mLoginParam, loginException.getOrinResponse());
                                return;
                            }
                            UserLoginPresenter.this.mViewer.toast(loginException.getMsg(), 0);
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
    public void onReceiveToast(LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse) {
        if (!this.mViewer.loginFailHandler(rpcResponse)) {
            if (!TextUtils.isEmpty(LongLifeCycleUserTrack.getResultScene())) {
                LongLifeCycleUserTrack.sendUT(LongLifeCycleUserTrack.getResultScene() + "_FAILURE");
            }
            BaseLoginView baseLoginView = this.mViewer;
            if (baseLoginView != null && (baseLoginView instanceof UserLoginView)) {
                ((UserLoginView) baseLoginView).showFindPasswordAlert(loginParam, rpcResponse);
            }
        }
    }

    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void setSnsToken(String str) {
        if (this.mLoginParam == null) {
            this.mLoginParam = new LoginParam();
        }
        LoginParam loginParam = this.mLoginParam;
        loginParam.snsToken = str;
        loginParam.loginSite = DataProviderFactory.getDataProvider().getSite();
        LoginParam loginParam2 = this.mLoginParam;
        if (loginParam2.externParams == null) {
            loginParam2.externParams = new HashMap();
        }
        this.mLoginParam.externParams.put("apiReferer", ApiReferer.generateApiReferer());
    }

    public void fetchUrlAndToWebView(Context context, final String str, final String str2, final int i, final String str3) {
        String str4;
        String str5;
        BaseLoginView baseLoginView = this.mViewer;
        if (baseLoginView != null && baseLoginView.isActive()) {
            this.mViewer.showLoading();
            BaseLoginView baseLoginView2 = this.mViewer;
            if (baseLoginView2 instanceof BaseLoginFragment) {
                str5 = ((BaseLoginFragment) baseLoginView2).getPageName();
                str4 = ((BaseLoginFragment) this.mViewer).getPageSpm();
            } else {
                str4 = null;
                str5 = UTConstant.PageName.UT_PAGE_FIRST_LOGIN;
            }
            final String generateTraceId = ApiReferer.generateTraceId(str2, str5);
            HashMap hashMap = new HashMap();
            hashMap.put("sdkTraceId", generateTraceId);
            UserTrackAdapter.control(str5, str4, UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.RETRIVE_PWD_LOGIN, hashMap);
            new CoordinatorWrapper().execute(new AsyncTask<Object, Void, MtopAccountCenterUrlResponseData>() {
                /* class com.ali.user.mobile.login.presenter.UserLoginPresenter.AnonymousClass2 */

                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public MtopAccountCenterUrlResponseData doInBackground(Object... objArr) {
                    try {
                        AccountCenterParam accountCenterParam = new AccountCenterParam();
                        int i = i;
                        if (23 != i) {
                            accountCenterParam.userInputName = str;
                        }
                        accountCenterParam.scene = "foundpassword";
                        accountCenterParam.traceId = generateTraceId;
                        accountCenterParam.fromSite = i;
                        return UrlFetchServiceImpl.getInstance().foundH5urls(accountCenterParam);
                    } catch (RpcException | Exception unused) {
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(MtopAccountCenterUrlResponseData mtopAccountCenterUrlResponseData) {
                    BaseLoginView baseLoginView;
                    BaseLoginView baseLoginView2 = UserLoginPresenter.this.mViewer;
                    if (baseLoginView2 != null && baseLoginView2.isActive()) {
                        if (mtopAccountCenterUrlResponseData == null) {
                            try {
                                UserLoginPresenter.this.mViewer.toast(DataProviderFactory.getApplicationContext().getString(R.string.aliuser_network_error), 0);
                                BaseLoginView baseLoginView3 = UserLoginPresenter.this.mViewer;
                                if (baseLoginView3 != null) {
                                    baseLoginView3.dismissLoading();
                                }
                            } catch (RpcException e) {
                                SDKExceptionHelper.getInstance().rpcExceptionHandler(e);
                                baseLoginView = UserLoginPresenter.this.mViewer;
                                if (baseLoginView == null) {
                                }
                            } catch (Exception unused) {
                                baseLoginView = UserLoginPresenter.this.mViewer;
                                if (baseLoginView == null) {
                                }
                            } catch (Throwable th) {
                                BaseLoginView baseLoginView4 = UserLoginPresenter.this.mViewer;
                                if (baseLoginView4 != null) {
                                    baseLoginView4.dismissLoading();
                                }
                                throw th;
                            }
                        } else {
                            if (mtopAccountCenterUrlResponseData.h5Url != null) {
                                LoginParam loginParam = new LoginParam();
                                loginParam.tokenType = TokenType.FIND_PWD;
                                loginParam.traceId = generateTraceId;
                                loginParam.loginSourceType = str2;
                                loginParam.source = str3;
                                BaseLoginView baseLoginView5 = UserLoginPresenter.this.mViewer;
                                if (baseLoginView5 instanceof BaseLoginFragment) {
                                    loginParam.loginSourcePage = ((BaseLoginFragment) baseLoginView5).getPageName();
                                    loginParam.loginSourceSpm = ((BaseLoginFragment) UserLoginPresenter.this.mViewer).getPageSpm();
                                } else {
                                    loginParam.loginSourcePage = UTConstant.PageName.UT_PAGE_FIRST_LOGIN;
                                }
                                LoginReturnData loginReturnData = new LoginReturnData();
                                loginReturnData.site = UserLoginPresenter.this.mViewer.getLoginSite();
                                loginParam.errorCode = "0";
                                NavigatorManager.getInstance().navToWebViewPage(UserLoginPresenter.this.mViewer.getBaseActivity(), mtopAccountCenterUrlResponseData.h5Url, loginParam, loginReturnData);
                            } else {
                                UserLoginPresenter.this.mViewer.toast(mtopAccountCenterUrlResponseData.errorMessage, 0);
                            }
                            baseLoginView = UserLoginPresenter.this.mViewer;
                            if (baseLoginView == null) {
                                return;
                            }
                            baseLoginView.dismissLoading();
                        }
                    }
                }
            }, new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.presenter.BaseLoginPresenter
    public void login(LoginParam loginParam, RpcRequestCallback rpcRequestCallback) {
        if (!TextUtils.isEmpty(loginParam.token)) {
            LoginDataRepository.getInstance().loginByToken(loginParam, rpcRequestCallback);
        } else {
            LoginDataRepository.getInstance().unifyLoginWithTaobaoGW(loginParam, rpcRequestCallback);
        }
    }
}
