package com.ali.user.mobile.login.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.dataprovider.StringOrangeResult;
import com.ali.user.mobile.base.helper.LoginDataHelper;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.coordinator.Coordinator;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.data.model.Login2RegParam;
import com.ali.user.mobile.filter.LoginFilterCallback;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.AccountType;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.login.presenter.BaseLoginPresenter;
import com.ali.user.mobile.login.presenter.BioPresenter;
import com.ali.user.mobile.login.presenter.FaceLoginPresenter;
import com.ali.user.mobile.login.presenter.UserLoginPresenter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.DefaultLoginResponseData;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.FaceService;
import com.ali.user.mobile.service.FingerprintService;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.WebConstant;
import com.ali.user.mobile.ui.widget.AliUserDialog;
import com.ali.user.mobile.ui.widget.BottomMenuFragment;
import com.ali.user.mobile.ui.widget.CircleImageView;
import com.ali.user.mobile.ui.widget.MenuItem;
import com.ali.user.mobile.ui.widget.MenuItemOnClickListener;
import com.ali.user.mobile.utils.ImageUtil;
import com.ali.user.mobile.utils.LoadImageTask;
import com.ali.user.mobile.utils.MD5Util;
import com.ali.user.mobile.utils.ProtocolHelper;
import com.ali.user.mobile.utils.SharedPreferencesUtil;
import com.ali.user.mobile.webview.LoginPostHandler;
import com.ali.user.mobile.webview.WebViewActivity;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.ui.AliUserBindMobileDialog;
import com.taobao.login4android.ui.TaobaoRegProtocolDialogFragment;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class BaseLoginFragment extends BaseFragment implements View.OnClickListener {
    public static final int DAY_60_MILLIS = 889032704;
    private static final String TAG = "ui.BaseLoginFragment";
    protected boolean fingerLoginEnable;
    protected boolean isHistoryMode = false;
    protected AliUserDialog mAliUserDialog;
    protected CircleImageView mAvatarIV;
    protected BioPresenter mBioPresenter;
    protected boolean mCheckBoxSwitch;
    protected FaceLoginPresenter mFaceLoginPresenter;
    protected BaseLoginPresenter mPresenter;
    protected boolean mPreviousChecked;
    protected CheckBox mProtocolCB;
    protected TextView mProtocolTV;
    protected String mProtocolTitle;
    protected String mProtocolUrl;
    protected String mSource;
    protected UserLoginActivity mUserLoginActivity;

    public void addCheckAction(int i) {
        if (this.mCheckBoxSwitch) {
            onCheckLogin(i);
        } else {
            doRealAction(i);
        }
    }

    /* access modifiers changed from: protected */
    public void addFingeritem(BottomMenuFragment bottomMenuFragment, List<MenuItem> list) {
        if (this.fingerLoginEnable) {
            MenuItem menuItem = new MenuItem();
            menuItem.setText(getString(R.string.aliuser_finger_button_text));
            menuItem.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem) {
                /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass13 */

                @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                public void onClickMenuItem(View view, MenuItem menuItem) {
                    if (BaseLoginFragment.this.isActive()) {
                        BaseLoginFragment.this.onCheckLogin(LoginClickAction.ACTION_FINGER);
                    }
                }
            });
            list.add(menuItem);
        }
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void alert(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        super.alert(str, str2, str3, onClickListener, str4, onClickListener2);
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void alertList(String[] strArr, DialogInterface.OnClickListener onClickListener, boolean z) {
        super.alertList(strArr, onClickListener, z);
    }

    /* access modifiers changed from: protected */
    public void deleteAccount(HistoryAccount historyAccount) {
        new CoordinatorWrapper().execute(new AsyncTask<Object, Void, Void>() {
            /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass5 */

            /* access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Object... objArr) {
                SecurityGuardManagerWraper.removeAllHistoryAccount();
                return null;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Void r3) {
                if (BaseLoginFragment.this.isActive()) {
                    BaseLoginFragment baseLoginFragment = BaseLoginFragment.this;
                    baseLoginFragment.mUserLoginActivity.mHistoryAccount = null;
                    baseLoginFragment.isHistoryMode = false;
                    baseLoginFragment.switchMode(false, null);
                }
            }
        }, new Object[0]);
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void dismissAlertDialog() {
        super.dismissAlertDialog();
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void dismissLoading() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            dismissProgress();
        }
    }

    public void doPostSuccess(final LoginParam loginParam, final RpcResponse rpcResponse) {
        DefaultLoginResponseData defaultLoginResponseData;
        T t;
        dismissLoading();
        if ((rpcResponse instanceof DefaultLoginResponseData) && (defaultLoginResponseData = (DefaultLoginResponseData) rpcResponse) != null && (t = defaultLoginResponseData.returnValue) != null && t.extMap != null) {
            String str = t.extMap.get(ApiConstants.ApiField.SNS_BIND_TITLE);
            String str2 = defaultLoginResponseData.returnValue.extMap.get(ApiConstants.ApiField.SNS_BIND_CONTENT);
            final String str3 = defaultLoginResponseData.returnValue.extMap.get("loginPostUrl");
            uiShown("BindMobile");
            final AliUserBindMobileDialog aliUserBindMobileDialog = new AliUserBindMobileDialog();
            aliUserBindMobileDialog.setPageNameSpm(getPageName(), getPageSpm());
            aliUserBindMobileDialog.setPositive(new View.OnClickListener() {
                /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass9 */

                public void onClick(View view) {
                    if (BaseLoginFragment.this.isActive()) {
                        BaseLoginFragment.this.addControl("BindMobileClick-yes");
                        AliUserBindMobileDialog aliUserBindMobileDialog = aliUserBindMobileDialog;
                        if (aliUserBindMobileDialog != null) {
                            aliUserBindMobileDialog.dismissAllowingStateLoss();
                        }
                        LoginPostHandler.openPostPage(((BaseFragment) BaseLoginFragment.this).mAttachedActivity, str3, new LoginFilterCallback() {
                            /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass9.AnonymousClass1 */

                            @Override // com.ali.user.mobile.filter.LoginFilterCallback
                            public void onFail(int i, Map<String, String> map) {
                                onSuccess();
                            }

                            @Override // com.ali.user.mobile.filter.LoginFilterCallback
                            public void onSuccess() {
                                AnonymousClass9 r0 = AnonymousClass9.this;
                                LoginDataHelper.onLoginSuccess(loginParam, rpcResponse);
                            }
                        });
                        return;
                    }
                    LoginDataHelper.onLoginSuccess(loginParam, rpcResponse);
                }
            });
            aliUserBindMobileDialog.setNagetive(new View.OnClickListener() {
                /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass10 */

                public void onClick(View view) {
                    AliUserBindMobileDialog aliUserBindMobileDialog;
                    if (BaseLoginFragment.this.isActive() && (aliUserBindMobileDialog = aliUserBindMobileDialog) != null) {
                        aliUserBindMobileDialog.dismissAllowingStateLoss();
                    }
                    BaseLoginFragment.this.addControl("BindMobileClick-no");
                    LoginDataHelper.onLoginSuccess(loginParam, rpcResponse);
                }
            });
            if (!TextUtils.isEmpty(str)) {
                aliUserBindMobileDialog.setTitle(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                aliUserBindMobileDialog.setContent(Html.fromHtml(str2));
            }
            aliUserBindMobileDialog.show(getActivity().getSupportFragmentManager(), getPageName());
        }
    }

    public void doRealAction(int i) {
        if (i == LoginClickAction.ACTION_LOGIN) {
            onLoginAction();
        } else if (i == LoginClickAction.ACTION_FACE) {
            onFaceLogin(true);
        } else if (i == LoginClickAction.ACTION_ALIPAY) {
            goAlipay();
        } else if (i == LoginClickAction.ACTION_TAOBAO) {
            goTaobao();
        } else if (i == LoginClickAction.ACTION_FIND_PWD) {
            UserTrackAdapter.sendControlUT(getPageName(), "Button-ForgetPwd");
            onForgetPasswordAction();
        } else if (i == LoginClickAction.ACTION_FINGER) {
            onFingerLogin();
        }
    }

    /* access modifiers changed from: protected */
    public void generateProtocol(String str, String str2) {
        ProtocolHelper.generateProtocol(ProtocolHelper.getProtocolModel(getActivity(), str, str2, !this.isHistoryMode), this.mAttachedActivity, this.mProtocolTV, getPageName(), getPageSpm(), false);
    }

    /* access modifiers changed from: protected */
    public String getAccountName() {
        return "";
    }

    /* access modifiers changed from: protected */
    public BottomMenuFragment getBottomMenuFragment() {
        return new BottomMenuFragment();
    }

    public HistoryAccount getHistoryAccount() {
        UserLoginActivity userLoginActivity = this.mUserLoginActivity;
        if (userLoginActivity != null) {
            return userLoginActivity.mHistoryAccount;
        }
        return null;
    }

    public int getLoginSite() {
        return DataProviderFactory.getDataProvider().getSite();
    }

    public AccountType getLoginType() {
        return AccountType.TAOBAO_ACCOUNT;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public String getPageName() {
        return UTConstant.PageName.UT_PAGE_FIRST_LOGIN;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public String getPageSpm() {
        return "a21et." + getPageName();
    }

    /* access modifiers changed from: protected */
    public TaobaoRegProtocolDialogFragment getRrotocolFragment() {
        return new TaobaoRegProtocolDialogFragment();
    }

    /* access modifiers changed from: protected */
    public void goAlipay() {
    }

    /* access modifiers changed from: protected */
    public void goTaobao() {
    }

    /* access modifiers changed from: protected */
    public void initAccountEditText(String str) {
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        this.mUserLoginActivity = (UserLoginActivity) getActivity();
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.aliuser_login_avatar);
        this.mAvatarIV = circleImageView;
        if (circleImageView != null) {
            circleImageView.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass1 */

                public boolean onLongClick(View view) {
                    BaseLoginFragment.this.onDeleteAccount();
                    return false;
                }
            });
        }
        try {
            setCheckBoxSwitch();
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.aliuser_reg_checkbox);
            this.mProtocolCB = checkBox;
            ProtocolHelper.setCheckBox(this, checkBox, getPageName(), getPageSpm(), this.mCheckBoxSwitch, this.mPreviousChecked);
            this.mProtocolTV = (TextView) view.findViewById(R.id.aliuser_protocol_tv);
            if (this.mCheckBoxSwitch) {
                generateProtocol("", "");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isFaceLoginEnable() {
        UserLoginActivity userLoginActivity;
        return DataProviderFactory.getDataProvider().supportFaceLogin() && (userLoginActivity = this.mUserLoginActivity) != null && (userLoginActivity.isFaceLoginEnvEnable || userLoginActivity.isFaceLoginActivate);
    }

    /* access modifiers changed from: package-private */
    public boolean isFingerEnable(HistoryAccount historyAccount) {
        return historyAccount != null && !TextUtils.isEmpty(historyAccount.biometricId) && ServiceFactory.getService(FingerprintService.class) != null && ((FingerprintService) ServiceFactory.getService(FingerprintService.class)).isFingerprintAvailable() && !TextUtils.isEmpty(this.mUserLoginActivity.mBiometricToken);
    }

    public boolean isHistoryMode() {
        return this.isHistoryMode;
    }

    public boolean loginFailHandler(RpcResponse rpcResponse) {
        return false;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public boolean onBackPressed() {
        addControl("close");
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCheckLogin(final int i) {
        CheckBox checkBox;
        if (!this.mCheckBoxSwitch || (checkBox = this.mProtocolCB) == null || checkBox.isChecked()) {
            doRealAction(i);
        } else if (isActive()) {
            uiShown("checkAgreement_dialog");
            final TaobaoRegProtocolDialogFragment rrotocolFragment = getRrotocolFragment();
            rrotocolFragment.setNeedAdaptElder(this.needAdaptElder);
            rrotocolFragment.setPageNameSpm(getPageName(), getPageSpm());
            rrotocolFragment.setFirst(!this.isHistoryMode);
            rrotocolFragment.setPostiveBtnText(getString(R.string.aliuser_agree));
            rrotocolFragment.setNegativeBtnText(getString(R.string.aliuser_protocol_disagree));
            rrotocolFragment.setNagetive(new View.OnClickListener() {
                /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass11 */

                public void onClick(View view) {
                    if (BaseLoginFragment.this.isActive()) {
                        BaseLoginFragment.this.addControl("Agreement_Button_Cancel");
                        rrotocolFragment.dismissAllowingStateLoss();
                    }
                }
            });
            rrotocolFragment.setPositive(new View.OnClickListener() {
                /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass12 */

                public void onClick(View view) {
                    if (BaseLoginFragment.this.isActive()) {
                        BaseLoginFragment.this.addControl("Agreement_Button_Agree");
                        rrotocolFragment.dismissAllowingStateLoss();
                        BaseLoginFragment.this.mProtocolCB.setChecked(true);
                        BaseLoginFragment.this.doRealAction(i);
                    }
                }
            });
            rrotocolFragment.setOneKeyProtocol(this.mProtocolTitle);
            rrotocolFragment.setOneKeyProtocolUrl(this.mProtocolUrl);
            rrotocolFragment.show(getActivity().getSupportFragmentManager(), getPageName());
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.aliuser_reg_tv) {
            addControl("Button-Reg");
            RegistParam registParam = new RegistParam();
            registParam.registSite = getLoginSite();
            registParam.regFrom = DataProviderFactory.getDataProvider().getRegFrom();
            registParam.source = this.mSource;
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openRegisterPage(this.mAttachedActivity, registParam);
        }
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        menuInflater.inflate(R.menu.aliuser_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    /* access modifiers changed from: protected */
    public void onDeleteAccount() {
        if (isActivityAvaiable()) {
            alert(getActivity().getString(R.string.aliuser_account_remove_title), getActivity().getString(R.string.aliuser_account_remove_info), getActivity().getString(R.string.aliuser_account_remove_delete), new DialogInterface.OnClickListener() {
                /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass4 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    BaseLoginFragment.this.addControl("Button-DeleteUser");
                    BaseLoginFragment baseLoginFragment = BaseLoginFragment.this;
                    baseLoginFragment.deleteAccount(baseLoginFragment.mUserLoginActivity.mHistoryAccount);
                }
            }, getActivity().getString(R.string.aliuser_confirm_cancel), null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mUserLoginActivity = null;
        super.onDestroy();
    }

    public void onError(RpcResponse rpcResponse) {
        onLoginFail(rpcResponse);
    }

    /* access modifiers changed from: protected */
    public void onFaceLogin(boolean z) {
        if (ServiceFactory.getService(FaceService.class) != null) {
            LoginParam loginParam = new LoginParam();
            HistoryAccount historyAccount = this.mUserLoginActivity.mHistoryAccount;
            loginParam.havanaId = historyAccount.userId;
            loginParam.deviceTokenKey = historyAccount.tokenKey;
            loginParam.traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.SCAN_FACE_LOGIN, getPageName());
            loginParam.loginSourceType = LoginType.LocalLoginType.SCAN_FACE_LOGIN;
            loginParam.loginSourcePage = getPageName();
            loginParam.loginSourceSpm = getPageSpm();
            HashMap hashMap = new HashMap();
            hashMap.put("sdkTraceId", loginParam.traceId + "");
            UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.SCAN_FACE_LOGIN, hashMap);
            FaceLoginPresenter faceLoginPresenter = this.mFaceLoginPresenter;
            if (faceLoginPresenter == null) {
                return;
            }
            if (z) {
                faceLoginPresenter.activeFaceLogin(loginParam);
            } else {
                faceLoginPresenter.fetchScanToken(loginParam);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFingerLogin() {
        BioPresenter bioPresenter;
        if (ServiceFactory.getService(FingerprintService.class) != null && (bioPresenter = this.mBioPresenter) != null) {
            bioPresenter.buildLoginParam();
            this.mBioPresenter.mLoginParam.traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.BIO_LOGIN, getPageName());
            LoginParam loginParam = this.mBioPresenter.mLoginParam;
            loginParam.loginSourcePage = LoginType.LocalLoginType.BIO_LOGIN;
            loginParam.loginSourcePage = getPageName();
            this.mBioPresenter.mLoginParam.loginSourceSpm = getPageSpm();
            HashMap hashMap = new HashMap();
            hashMap.put("sdkTraceId", this.mBioPresenter.mLoginParam.traceId + "");
            UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.BIO_LOGIN, hashMap);
            if (getHistoryAccount() != null) {
                this.mBioPresenter.mLoginParam.biometricId = getHistoryAccount().biometricId;
            }
            this.mBioPresenter.login();
        }
    }

    /* access modifiers changed from: protected */
    public void onForgetPasswordAction() {
    }

    public void onGetRegion(List<RegionInfo> list) {
    }

    /* access modifiers changed from: protected */
    public void onLoginAction() {
    }

    public void onLoginFail(RpcResponse<LoginReturnData> rpcResponse) {
        LoginStatus.setLastRefreshCookieTime(0);
    }

    public void onNeedReg(Login2RegParam login2RegParam) {
    }

    public void onNotify(RpcResponse rpcResponse) {
        if (rpcResponse == null || rpcResponse.returnValue == null) {
            toast("业务方请自行处理该类型错误", 0);
        } else {
            toast(rpcResponse.message, 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.aliuser_menu_item_help) {
            openHelp();
        } else if (itemId == R.id.aliuser_menu_item_more) {
            addControl("Button-More");
            showBottomMenu();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onPostSuccess(LoginParam loginParam, RpcResponse rpcResponse) {
        doPostSuccess(loginParam, rpcResponse);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        int i = R.id.aliuser_menu_item_help;
        if (menu.findItem(i) != null) {
            int i2 = R.id.aliuser_menu_item_more;
            if (menu.findItem(i2) != null) {
                if (this.isHistoryMode) {
                    menu.findItem(i).setVisible(false);
                    menu.findItem(i2).setVisible(true);
                } else {
                    menu.findItem(i2).setVisible(false);
                    LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
                    if (loginApprearanceExtensions == null || loginApprearanceExtensions.needHelp()) {
                        menu.findItem(i).setVisible(true);
                    } else {
                        menu.findItem(i).setVisible(false);
                    }
                }
            }
        }
        super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public void onPwdError() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        UserTrackAdapter.updatePageName(getActivity(), getPageName(), getPageSpm());
    }

    public void onSuccess(LoginParam loginParam, RpcResponse rpcResponse) {
        dismissLoading();
        LoginDataHelper.onLoginSuccess(loginParam, rpcResponse);
    }

    /* access modifiers changed from: protected */
    public void openFindAccountPage() {
        if (isActivityAvaiable()) {
            addControl("Button-Help");
            Intent intent = new Intent(this.mAttachedActivity, WebViewActivity.class);
            intent.putExtra(WebConstant.WEBURL, LoginConstant.FIND_ACCOUNT_URL);
            startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void openHelp() {
        String str;
        UserLoginActivity userLoginActivity;
        HistoryAccount historyAccount;
        if (isActivityAvaiable()) {
            addControl("Button-Help");
            StringOrangeResult helpLink = DataProviderFactory.getOrangeConfig().helpLink();
            if (helpLink.orangeExist) {
                str = helpLink.value;
            } else if (getLoginSite() == 3) {
                str = LoginConstant.CBU_HELP_URL;
            } else if (DataProviderFactory.getDataProvider().isTaobaoApp()) {
                str = LoginConstant.TAOBAO_HELP_URL;
            } else {
                if (!(!isHistoryMode() || (userLoginActivity = this.mUserLoginActivity) == null || (historyAccount = userLoginActivity.mHistoryAccount) == null)) {
                    long j = historyAccount.userId;
                    if (j > 0) {
                        if (j > 0) {
                            try {
                                str = "https://ihelp.taobao.com/pocket/visitorServicePortal.htm?from=n_signin_history" + "&bizUserId=" + URLEncoder.encode(SecurityGuardManagerWraper.staticSafeEncrypt(String.valueOf(j)), "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                        str = "https://ihelp.taobao.com/pocket/visitorServicePortal.htm?from=n_signin_history";
                    }
                }
                str = "https://ihelp.taobao.com/pocket/visitorServicePortal.htm?from=n_signin_taobao";
                String accountName = getAccountName();
                if (!TextUtils.isEmpty(accountName)) {
                    str = str + "&bizUserName=" + accountName;
                }
            }
            Intent intent = new Intent(this.mAttachedActivity, WebViewActivity.class);
            intent.putExtra(WebConstant.WEBURL, str);
            startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void pwdErrorToSMS() {
        UserLoginActivity userLoginActivity;
        Intent intent = new Intent();
        CheckBox checkBox = this.mProtocolCB;
        if (checkBox != null) {
            intent.putExtra("check", checkBox.isChecked());
        }
        intent.putExtra("autoSendSms", true);
        if (isActive() && (userLoginActivity = this.mUserLoginActivity) != null) {
            userLoginActivity.gotoMobileLoginFragment(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void setCheckBoxSwitch() {
        this.mCheckBoxSwitch = true;
    }

    public void setLoginAccountInfo(String str) {
    }

    /* access modifiers changed from: protected */
    public void setOnClickListener(View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                view.setClickable(true);
                view.setOnClickListener(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void showBottomMenu() {
        if (isActive() && isVisible()) {
            BottomMenuFragment bottomMenuFragment = getBottomMenuFragment();
            ArrayList arrayList = new ArrayList();
            MenuItem menuItem = new MenuItem();
            menuItem.setText(getString(R.string.aliuser_other_account_login));
            menuItem.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem) {
                /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass6 */

                @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                public void onClickMenuItem(View view, MenuItem menuItem) {
                    if (BaseLoginFragment.this.isActive()) {
                        BaseLoginFragment.this.addControl("Button-ChooseOtherAccountLogin");
                        BaseLoginFragment.this.switchAccount();
                    }
                }
            });
            if (this.isHistoryMode) {
                arrayList.add(menuItem);
            }
            MenuItem menuItem2 = new MenuItem();
            menuItem2.setText(getString(R.string.aliuser_reg));
            menuItem2.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem2) {
                /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass7 */

                @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                public void onClickMenuItem(View view, MenuItem menuItem) {
                    if (BaseLoginFragment.this.isActive()) {
                        BaseLoginFragment.this.addControl("Button-Reg");
                        RegistParam registParam = new RegistParam();
                        registParam.registSite = BaseLoginFragment.this.getLoginSite();
                        registParam.regFrom = DataProviderFactory.getDataProvider().getRegFrom();
                        registParam.source = BaseLoginFragment.this.mSource;
                        ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openRegisterPage(((BaseFragment) BaseLoginFragment.this).mAttachedActivity, registParam);
                    }
                }
            });
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions == null || loginApprearanceExtensions.needRegister()) {
                arrayList.add(menuItem2);
            }
            LoginApprearanceExtensions loginApprearanceExtensions2 = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions2 == null || loginApprearanceExtensions2.needHelp()) {
                MenuItem menuItem3 = new MenuItem();
                menuItem3.setText(getString(R.string.aliuser_help));
                menuItem3.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem3) {
                    /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass8 */

                    @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                    public void onClickMenuItem(View view, MenuItem menuItem) {
                        if (BaseLoginFragment.this.isActive()) {
                            BaseLoginFragment.this.openHelp();
                        }
                    }
                });
                arrayList.add(menuItem3);
            }
            bottomMenuFragment.setMenuItems(arrayList);
            bottomMenuFragment.show(getFragmentManager(), getPageName());
        }
    }

    public void showFindPasswordAlert(final LoginParam loginParam, RpcResponse<LoginReturnData> rpcResponse, final UserLoginPresenter userLoginPresenter, final EditText editText, final ImageView imageView) {
        String str;
        String str2;
        AliUserDialog.PositiveClickListener positiveClickListener;
        String str3;
        String str4;
        UserLoginActivity userLoginActivity;
        String string = getResources().getString(R.string.aliuser_common_ok);
        final boolean z = true;
        String str5 = "";
        if (rpcResponse != null && !TextUtils.isEmpty(rpcResponse.codeGroup) && loginParam != null && TextUtils.equals(ApiConstants.CodeGroup.PWD_CAN_SMS_ERROR, rpcResponse.codeGroup)) {
            T t = rpcResponse.returnValue;
            if (t == null || t.extMap == null) {
                str2 = str5;
                str = str2;
            } else {
                str2 = t.extMap.get(ApiConstants.ApiField.SNS_BIND_TITLE);
                str = rpcResponse.returnValue.extMap.get(ApiConstants.ApiField.SNS_BIND_CONTENT);
            }
            str4 = getResources().getString(R.string.aliuser_login_sms_login2);
            str3 = getResources().getString(R.string.aliuser_cancel);
            positiveClickListener = new AliUserDialog.PositiveClickListener() {
                /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass14 */

                @Override // com.ali.user.mobile.ui.widget.AliUserDialog.PositiveClickListener
                public void onClick(View view) {
                    AliUserDialog aliUserDialog = BaseLoginFragment.this.mAliUserDialog;
                    if (aliUserDialog != null) {
                        aliUserDialog.dismiss();
                    }
                    BaseLoginFragment.this.addControl("Button-Nick-Sms-Login");
                    BaseLoginFragment.this.pwdErrorToSMS();
                }
            };
        } else if (rpcResponse == null || TextUtils.isEmpty(rpcResponse.codeGroup) || loginParam == null || !TextUtils.equals(ApiConstants.CodeGroup.PWD_CAN_FACE_ERROR, rpcResponse.codeGroup) || ServiceFactory.getService(FaceService.class) == null) {
            if (rpcResponse != null && !TextUtils.isEmpty(rpcResponse.codeGroup) && loginParam != null && (userLoginActivity = this.mUserLoginActivity) != null && userLoginActivity.mAlipayInstall && TextUtils.equals(ApiConstants.CodeGroup.PWD_CAN_ALIPAY, rpcResponse.codeGroup) && LoginSwitch.isInABTestRegion(LoginSwitch.PWD_ERROR_TO_ALIPAY, 10000)) {
                T t2 = rpcResponse.returnValue;
                if (t2 == null || t2.extMap == null) {
                    str2 = str5;
                    str = str2;
                } else {
                    str2 = t2.extMap.get(ApiConstants.ApiField.SNS_BIND_TITLE);
                    str = rpcResponse.returnValue.extMap.get(ApiConstants.ApiField.SNS_BIND_CONTENT);
                }
                str4 = getResources().getString(R.string.ali_user_alipay_login);
                str3 = getResources().getString(R.string.aliuser_re_enter);
                positiveClickListener = new AliUserDialog.PositiveClickListener() {
                    /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass16 */

                    @Override // com.ali.user.mobile.ui.widget.AliUserDialog.PositiveClickListener
                    public void onClick(View view) {
                        if (BaseLoginFragment.this.isActive()) {
                            AliUserDialog aliUserDialog = BaseLoginFragment.this.mAliUserDialog;
                            if (aliUserDialog != null) {
                                aliUserDialog.dismiss();
                            }
                            BaseLoginFragment.this.addControl("Button-Nick-Alipay-Login");
                            BaseLoginFragment.this.goAlipay();
                        }
                    }
                };
            } else if (rpcResponse == null || TextUtils.isEmpty(rpcResponse.codeGroup) || loginParam == null || TextUtils.isEmpty(loginParam.loginType) || (!TextUtils.equals(ApiConstants.CodeGroup.PWD_ERROR, rpcResponse.codeGroup) && !TextUtils.equals("noRecord", rpcResponse.codeGroup))) {
                positiveClickListener = null;
                str3 = string;
                str2 = str5;
                str = str2;
                str4 = str;
            } else {
                String string2 = getResources().getString(R.string.aliuser_alert_findpwd);
                positiveClickListener = new AliUserDialog.PositiveClickListener() {
                    /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass17 */

                    @Override // com.ali.user.mobile.ui.widget.AliUserDialog.PositiveClickListener
                    public void onClick(View view) {
                        if (BaseLoginFragment.this.isActive()) {
                            BaseLoginFragment.this.addControl("Button-Alert-ResetPwd");
                            UserLoginPresenter userLoginPresenter = userLoginPresenter;
                            BaseActivity baseActivity = ((BaseFragment) BaseLoginFragment.this).mAttachedActivity;
                            LoginParam loginParam = loginParam;
                            userLoginPresenter.fetchUrlAndToWebView(baseActivity, loginParam.loginAccount, LoginType.LocalLoginType.RETRIVE_PWD_LOGIN, loginParam.source);
                            AliUserDialog aliUserDialog = BaseLoginFragment.this.mAliUserDialog;
                            if (aliUserDialog != null) {
                                aliUserDialog.dismiss();
                            }
                        }
                    }
                };
                str2 = str5;
                str = str2;
                str3 = string;
                str4 = string2;
            }
            z = false;
        } else {
            T t3 = rpcResponse.returnValue;
            if (t3 == null || t3.extMap == null) {
                str2 = str5;
                str = str2;
            } else {
                str2 = t3.extMap.get(ApiConstants.ApiField.SNS_BIND_TITLE);
                str = rpcResponse.returnValue.extMap.get(ApiConstants.ApiField.SNS_BIND_CONTENT);
            }
            str4 = getResources().getString(R.string.aliuser_scan_login_text);
            str3 = getResources().getString(R.string.aliuser_cancel);
            positiveClickListener = new AliUserDialog.PositiveClickListener() {
                /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass15 */

                @Override // com.ali.user.mobile.ui.widget.AliUserDialog.PositiveClickListener
                public void onClick(View view) {
                    if (BaseLoginFragment.this.isActive()) {
                        AliUserDialog aliUserDialog = BaseLoginFragment.this.mAliUserDialog;
                        if (aliUserDialog != null) {
                            aliUserDialog.dismiss();
                        }
                        BaseLoginFragment.this.addControl("Button-Nick-Face-Login");
                        BaseLoginFragment.this.onFaceLogin(true);
                    }
                }
            };
        }
        if (TextUtils.isEmpty(str)) {
            if (rpcResponse == null) {
                str = str5;
            } else {
                str = rpcResponse.message;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        } else {
            str5 = str;
        }
        AliUserDialog.Builder onNegativeClickListener = AliUserDialog.Builder(getActivity()).setTitle(str2).setMessage(str5).setOnNegativeClickListener(str3, new AliUserDialog.NegativeClickListener() {
            /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass18 */

            @Override // com.ali.user.mobile.ui.widget.AliUserDialog.NegativeClickListener
            public void onClick(View view) {
                AliUserDialog aliUserDialog = BaseLoginFragment.this.mAliUserDialog;
                if (aliUserDialog != null) {
                    aliUserDialog.dismiss();
                }
                if (z && BaseLoginFragment.this.isActive()) {
                    BaseLoginFragment.this.onPwdError();
                    if (BaseLoginFragment.this.isActive() && editText != null && imageView != null && LoginSwitch.getSwitch("show_password_hint", "true")) {
                        editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        imageView.setImageResource(R.drawable.aliuser_ic_visibility);
                        imageView.setContentDescription(BaseLoginFragment.this.getString(R.string.aliuser_assist_password_show));
                        imageView.setTag(Boolean.TRUE);
                        UserTrackAdapter.sendControlUT(BaseLoginFragment.this.getPageName(), "Button-ShowPwd");
                    }
                }
            }
        });
        if (!TextUtils.isEmpty(str4)) {
            onNegativeClickListener.setOnPositiveClickListener(str4, positiveClickListener);
        }
        this.mAliUserDialog = onNegativeClickListener.build().shown();
        HashMap hashMap = new HashMap();
        if (rpcResponse != null) {
            hashMap.put("code", String.valueOf(rpcResponse.code));
        }
        if (rpcResponse != null && !TextUtils.isEmpty(rpcResponse.codeGroup)) {
            hashMap.put("codeGroup", rpcResponse.codeGroup);
        }
        UserTrackAdapter.sendUserTrack(getPageName(), "ShowPwdError", hashMap);
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void showLoading() {
        showProgress("");
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"StaticFieldLeak"})
    public void showPushLogoutAlertIfHas() {
        if (getContext() != null) {
            if (System.currentTimeMillis() - ((Long) SharedPreferencesUtil.getData(getContext().getApplicationContext(), "pushLogoutTime", 0L)).longValue() < DateUtils.MILLIS_PER_MINUTE) {
                String str = (String) SharedPreferencesUtil.getData(getContext().getApplicationContext(), "pushLogoutContent", "");
                if (!TextUtils.isEmpty(str)) {
                    alert("", str, getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() {
                        /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass2 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            BaseLoginFragment.this.dismissAlertDialog();
                        }
                    }, null, null);
                }
            }
            Coordinator.execute(new Runnable() {
                /* class com.ali.user.mobile.login.ui.BaseLoginFragment.AnonymousClass3 */

                public void run() {
                    SharedPreferencesUtil.saveData(BaseLoginFragment.this.getContext().getApplicationContext(), "pushLogoutContent", "");
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void switchAccount() {
    }

    /* access modifiers changed from: protected */
    public void switchMode(boolean z, HistoryAccount historyAccount) {
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void toast(String str, int i) {
        super.toast(str, i);
    }

    /* access modifiers changed from: protected */
    public void updateAvatar(String str) {
        if (!TextUtils.isEmpty(str)) {
            Bitmap bitmapFromMemoryCache = ImageUtil.getBitmapFromMemoryCache(MD5Util.getMD5(str));
            CircleImageView circleImageView = this.mAvatarIV;
            if (circleImageView == null) {
                return;
            }
            if (bitmapFromMemoryCache != null) {
                circleImageView.setImageBitmap(bitmapFromMemoryCache);
                return;
            }
            new LoadImageTask(DataProviderFactory.getApplicationContext(), this.mAvatarIV, "HeadImages", 160).execute(str);
            this.mAvatarIV.setImageResource(R.drawable.aliuser_placeholder);
        }
    }
}
