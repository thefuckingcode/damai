package com.ali.user.mobile.login.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.ali.user.mobile.app.LoginContext;
import com.ali.user.mobile.app.constant.FragmentConstant;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.data.model.Login2RegParam;
import com.ali.user.mobile.helper.ActivityUIHelper;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.AppMonitorAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.presenter.FaceLoginPresenter;
import com.ali.user.mobile.login.presenter.SMSNickLoginPresenter;
import com.ali.user.mobile.login.presenter.UserMobileLoginPresenter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.navigation.NavigatorManager;
import com.ali.user.mobile.register.ui.AliUserSmsCodeView;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.service.FaceService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.widget.AliUserDialog;
import com.ali.user.mobile.ui.widget.BottomMenuFragment;
import com.ali.user.mobile.ui.widget.CountDownButton;
import com.ali.user.mobile.ui.widget.MenuItemOnClickListener;
import com.ali.user.mobile.utils.ElderUtil;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.ui.TaobaoRegProtocolDialogFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class AliUserSMSLoginVerificationFragment extends BaseLoginFragment implements UserMobileLoginView {
    public static ILoginMethodChange mLoginMethodChange;
    protected String fromPageTag;
    protected long havanaId;
    protected LoginParam loginParam = null;
    AliUserDialog mAliUserDialog;
    protected ArrayList<String> mAvailableLoginModes;
    protected TextView mChangeLogin;
    protected String mMaskMobile;
    protected SMSNickLoginPresenter mNickLoginPresenter;
    protected String mOutterSourcePage;
    protected UserMobileLoginPresenter mPresenter;
    protected CountDownButton mSendSMSCodeBtn;
    protected AliUserSmsCodeView mSmsCodeView;
    protected String preCheckVerify;
    TaobaoRegProtocolDialogFragment regProtocolDialog;
    protected String verify;

    /* access modifiers changed from: package-private */
    /* renamed from: com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment$11  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$com$ali$user$mobile$login$ui$LoginModeState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[LoginModeState.values().length];
            $SwitchMap$com$ali$user$mobile$login$ui$LoginModeState = iArr;
            iArr[LoginModeState.SMS_LOGIN.ordinal()] = 1;
            $SwitchMap$com$ali$user$mobile$login$ui$LoginModeState[LoginModeState.PASSWORD.ordinal()] = 2;
            $SwitchMap$com$ali$user$mobile$login$ui$LoginModeState[LoginModeState.SIM_LOGIN.ordinal()] = 3;
            try {
                $SwitchMap$com$ali$user$mobile$login$ui$LoginModeState[LoginModeState.SCAN_FACE.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void initParams() {
        Bundle arguments = getArguments();
        this.loginParam = null;
        if (arguments != null) {
            String str = (String) arguments.get(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
            arguments.putString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, "");
            if (!TextUtils.isEmpty(str)) {
                LoginParam loginParam2 = (LoginParam) JSON.parseObject(str, LoginParam.class);
                this.loginParam = loginParam2;
                if (loginParam2 != null) {
                    this.mOutterSourcePage = loginParam2.loginSourcePage;
                    loginParam2.loginSourcePage = getPageName();
                    this.loginParam.loginSourceSpm = getPageSpm();
                }
            }
            this.mMaskMobile = (String) arguments.get("maskMobile");
            arguments.putString("maskMobile", "");
            this.fromPageTag = arguments.getString("pageTag");
            String string = arguments.getString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_METHODS);
            this.preCheckVerify = arguments.getString("preCheckVerify");
            this.verify = arguments.getString("verify");
            this.havanaId = arguments.getLong("havanaId");
            if (!TextUtils.isEmpty(string)) {
                try {
                    ArrayList<String> arrayList = (ArrayList) JSON.parseObject(string, ArrayList.class);
                    this.mAvailableLoginModes = arrayList;
                    if (arrayList != null) {
                        LoginModeState loginModeState = LoginModeState.SCAN_FACE;
                        if (!arrayList.contains(loginModeState.name()) && ("true".equals(this.preCheckVerify) || "true".equals(this.verify))) {
                            this.mAvailableLoginModes.add(loginModeState.name());
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        this.mPresenter = new UserMobileLoginPresenter(this, this.loginParam);
        this.mNickLoginPresenter = new SMSNickLoginPresenter(this, this.loginParam);
        this.mFaceLoginPresenter = new FaceLoginPresenter(this, this.loginParam);
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public void alert(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        toast(str2, 0);
        onCheckCodeError();
    }

    /* access modifiers changed from: protected */
    public void doDirectRegister(String str) {
        String str2 = "";
        if (this.loginParam != null) {
            Properties properties = new Properties();
            properties.setProperty("sdkTraceId", this.loginParam.traceId + str2);
            UserTrackAdapter.sendUT(getPageName(), UTConstant.CustomEvent.UT_LOGIN_TO_REG, properties);
        }
        UserMobileLoginPresenter userMobileLoginPresenter = this.mPresenter;
        LoginParam loginParam2 = this.loginParam;
        if (loginParam2 != null) {
            str2 = loginParam2.traceId;
        }
        userMobileLoginPresenter.directRegister(null, str, str2);
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public String getCountryCode() {
        LoginParam loginParam2 = this.loginParam;
        return loginParam2 == null ? "CN" : loginParam2.countryCode;
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public int getLayoutContent() {
        return R.layout.aliuser_fragment_sms_login_verification;
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageName() {
        if (this.loginParam == null || TextUtils.isEmpty(this.mOutterSourcePage)) {
            return UTConstans.PageName.UT_PAGE_LOGIN_SMS_CODE;
        }
        return this.mOutterSourcePage + "_inputcode";
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageSpm() {
        return UTConstans.PageName.F_SMS_CODE;
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public String getPhoneCode() {
        LoginParam loginParam2 = this.loginParam;
        return loginParam2 == null ? "86" : loginParam2.phoneCode;
    }

    /* access modifiers changed from: protected */
    public void goBack() {
        try {
            this.mUserLoginActivity.mFragmentManager.popBackStack();
            this.mUserLoginActivity.mCurrentFragmentTag = TextUtils.isEmpty(this.fromPageTag) ? FragmentConstant.RECOMMEND_LOGIN_FRAGMENT_TAG : this.fromPageTag;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        ArrayList<String> arrayList;
        LoginParam loginParam2;
        this.mUserLoginActivity = (UserLoginActivity) getActivity();
        try {
            ((BaseActivity) getActivity()).getSupportActionBar().setTitle("");
            ((BaseActivity) getActivity()).setNavigationBackIcon();
        } catch (Throwable unused) {
        }
        TextView textView = (TextView) view.findViewById(R.id.aliuser_login_sms_code_secondary_title_tv);
        LoginParam loginParam3 = this.loginParam;
        if (loginParam3 != null && !TextUtils.isEmpty(loginParam3.loginAccount)) {
            String str = this.mMaskMobile;
            if (TextUtils.isEmpty(str)) {
                if ("86".equals(this.loginParam.phoneCode)) {
                    String str2 = this.loginParam.loginAccount;
                    if (str2.length() == 11) {
                        str2 = this.loginParam.loginAccount.substring(0, 3) + " " + this.loginParam.loginAccount.substring(3, 7) + " " + this.loginParam.loginAccount.substring(7, 11);
                    }
                    str = AltriaXLaunchTime.SPACE + str2;
                } else {
                    str = " +" + this.loginParam.phoneCode + AltriaXLaunchTime.SPACE + this.loginParam.loginAccount;
                }
            }
            String string = getString(R.string.aliuser_sms_code_secondary_title, str);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            try {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#111111")), 7, string.length() - 10, 33);
                spannableStringBuilder.setSpan(new StyleSpan(1), 7, string.length() - 10, 33);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            textView.setText(spannableStringBuilder);
        }
        AliUserSmsCodeView aliUserSmsCodeView = (AliUserSmsCodeView) view.findViewById(R.id.aliuser_login_sms_code_view);
        this.mSmsCodeView = aliUserSmsCodeView;
        if (!(aliUserSmsCodeView == null || (loginParam2 = this.loginParam) == null || TextUtils.isEmpty(loginParam2.codeLength))) {
            this.mSmsCodeView.setTextCount(Integer.parseInt(this.loginParam.codeLength));
        }
        this.mSmsCodeView.setOnCompletedListener(new AliUserSmsCodeView.OnCompletedListener() {
            /* class com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.AnonymousClass1 */

            @Override // com.ali.user.mobile.register.ui.AliUserSmsCodeView.OnCompletedListener
            public void onCompleted(String str) {
                AliUserSMSLoginVerificationFragment.this.submitLoginForm();
            }
        });
        this.mSmsCodeView.focus();
        this.mSmsCodeView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.AnonymousClass2 */

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    AliUserSMSLoginVerificationFragment.this.addControl("inputcode_input");
                }
            }
        });
        CountDownButton countDownButton = (CountDownButton) view.findViewById(R.id.aliuser_login_send_smscode_btn);
        this.mSendSMSCodeBtn = countDownButton;
        countDownButton.setOnClickListener(this);
        this.mSendSMSCodeBtn.setGetCodeTitle(R.string.aliuser_signup_verification_reGetCode2);
        this.mSendSMSCodeBtn.setTickTitleRes(R.string.aliuser_sms_code_success_hint2);
        this.mSendSMSCodeBtn.startCountDown(DateUtils.MILLIS_PER_MINUTE, 1000);
        TextView textView2 = (TextView) view.findViewById(R.id.aliuser_change_login);
        this.mChangeLogin = textView2;
        if (textView2 != null) {
            if (!LoginSwitch.getSwitch("showOther", "true") || (arrayList = this.mAvailableLoginModes) == null || arrayList.size() <= 1) {
                this.mChangeLogin.setVisibility(8);
            } else {
                this.mChangeLogin.setOnClickListener(new View.OnClickListener() {
                    /* class com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.AnonymousClass3 */

                    public void onClick(View view) {
                        AliUserSMSLoginVerificationFragment.this.addControl(UTConstans.Controls.UT_CHOOSE_OTHER);
                        AliUserSMSLoginVerificationFragment.this.showMoreLoginModeMenu(LoginModeState.SMS_LOGIN);
                    }
                });
            }
        }
        if (this.needAdaptElder) {
            ElderUtil.scaleTextSize(this.mSendSMSCodeBtn, this.mChangeLogin, textView);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!TextUtils.isEmpty(this.mMaskMobile)) {
            this.mNickLoginPresenter.onActivityResult(i, i2, intent);
        } else {
            this.mPresenter.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment
    public boolean onBackPressed() {
        this.mAliUserDialog = AliUserDialog.Builder(getActivity()).setTitle(getString(R.string.aliuser_exit_smscode_hint)).setOnNegativeClickListener(getString(R.string.aliuser_text_back), new AliUserDialog.NegativeClickListener() {
            /* class com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.AnonymousClass10 */

            @Override // com.ali.user.mobile.ui.widget.AliUserDialog.NegativeClickListener
            public void onClick(View view) {
                AliUserDialog aliUserDialog = AliUserSMSLoginVerificationFragment.this.mAliUserDialog;
                if (aliUserDialog != null) {
                    aliUserDialog.dismiss();
                }
                AliUserSMSLoginVerificationFragment.this.addControl(UTConstans.Controls.UT_REG_BACK_BUTTON_CLICK);
                if (AliUserSMSLoginVerificationFragment.this.isActive() && AliUserSMSLoginVerificationFragment.this.getActivity() != null) {
                    AliUserSMSLoginVerificationFragment.this.goBack();
                }
            }
        }).setOnPositiveClickListener(getString(R.string.aliuser_wait_a_moment), new AliUserDialog.PositiveClickListener() {
            /* class com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.AnonymousClass9 */

            @Override // com.ali.user.mobile.ui.widget.AliUserDialog.PositiveClickListener
            public void onClick(View view) {
                AliUserDialog aliUserDialog = AliUserSMSLoginVerificationFragment.this.mAliUserDialog;
                if (aliUserDialog != null) {
                    aliUserDialog.dismiss();
                }
                AliUserSMSLoginVerificationFragment.this.addControl(UTConstans.Controls.UT_REG_BACK_BUTTON_CANCEL);
            }
        }).build().shown();
        return true;
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onCheckCodeError() {
        AliUserSmsCodeView aliUserSmsCodeView = this.mSmsCodeView;
        if (aliUserSmsCodeView != null) {
            aliUserSmsCodeView.clearText();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void onClick(View view) {
        if (view.getId() == R.id.aliuser_login_send_smscode_btn) {
            addControl("inputcode_again");
            sendCodeAction();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            initParams();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        UserMobileLoginPresenter userMobileLoginPresenter = this.mPresenter;
        if (userMobileLoginPresenter == null || userMobileLoginPresenter.getLoginParam() == null || TextUtils.isEmpty(this.mPresenter.getLoginParam().helpUrl)) {
            menu.clear();
            return;
        }
        menuInflater.inflate(R.menu.aliuser_menu, menu);
        try {
            MenuItem findItem = menu.findItem(R.id.aliuser_menu_item_help);
            SpannableString spannableString = new SpannableString(getResources().getString(R.string.aliuser_sms_need_help));
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.aliuser_color_orange)), 0, spannableString.length(), 0);
            findItem.setTitle(spannableString);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onFaceLogin() {
        if (ServiceFactory.getService(FaceService.class) != null) {
            LoginParam loginParam2 = new LoginParam();
            loginParam2.havanaId = this.havanaId;
            loginParam2.traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.SCAN_FACE_LOGIN, getPageName(), AppInfo.getInstance().getUtdid() + String.valueOf(System.currentTimeMillis() / 1000));
            loginParam2.loginSourceType = LoginType.LocalLoginType.SCAN_FACE_LOGIN;
            loginParam2.loginSourcePage = getPageName();
            loginParam2.loginSourceSpm = getPageSpm();
            LoginContext.sCurrentLoginParam = loginParam2;
            HashMap hashMap = new HashMap();
            hashMap.put("sdkTraceId", loginParam2.traceId + "");
            UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.SCAN_FACE_LOGIN, hashMap);
            if ("true".equals(this.verify)) {
                this.mFaceLoginPresenter.fetchScanToken(loginParam2);
            } else if ("true".equals(this.preCheckVerify)) {
                this.mFaceLoginPresenter.activeFaceLogin(loginParam2);
            }
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public void onNeedReg(Login2RegParam login2RegParam) {
        final String str = login2RegParam.token;
        boolean z = login2RegParam.needAlert;
        String str2 = login2RegParam.tips;
        if (z && LoginSwitch.isInABTestRegion(LoginSwitch.DIRECT_REGISTER_ALERT, 10000)) {
            TaobaoRegProtocolDialogFragment rrotocolFragment = getRrotocolFragment();
            this.regProtocolDialog = rrotocolFragment;
            rrotocolFragment.setNegativeVisible(false);
            TaobaoRegProtocolDialogFragment taobaoRegProtocolDialogFragment = this.regProtocolDialog;
            taobaoRegProtocolDialogFragment.contentVisible = false;
            taobaoRegProtocolDialogFragment.setTitle(str2);
            this.regProtocolDialog.setPostiveBtnText(getString(R.string.aliuser_reg_instant));
            this.regProtocolDialog.setPositive(new View.OnClickListener() {
                /* class com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.AnonymousClass7 */

                public void onClick(View view) {
                    UserTrackAdapter.sendControlUT(AliUserSMSLoginVerificationFragment.this.getPageName(), UTConstant.Controls.UT_SMS_ARGREE_REGISTER);
                    AliUserSMSLoginVerificationFragment.this.doDirectRegister(str);
                }
            });
            this.regProtocolDialog.setCancelListener(new View.OnClickListener() {
                /* class com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.AnonymousClass8 */

                public void onClick(View view) {
                    TaobaoRegProtocolDialogFragment taobaoRegProtocolDialogFragment = AliUserSMSLoginVerificationFragment.this.regProtocolDialog;
                    if (taobaoRegProtocolDialogFragment != null) {
                        taobaoRegProtocolDialogFragment.dismiss();
                    }
                }
            });
            this.regProtocolDialog.show(getActivity().getSupportFragmentManager(), getPageName());
        } else if (isActive()) {
            doDirectRegister(str);
        }
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onSMSOverLimit(RpcResponse rpcResponse) {
        if (isActive() && rpcResponse != null && rpcResponse.code == 14100) {
            onSendSMSSuccess(DateUtils.MILLIS_PER_MINUTE, false);
        }
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onSMSSendFail(RpcResponse rpcResponse) {
        AliUserSmsCodeView aliUserSmsCodeView = this.mSmsCodeView;
        if (aliUserSmsCodeView != null) {
            aliUserSmsCodeView.clearText();
        }
    }

    /* access modifiers changed from: protected */
    public void onSendSMSAction() {
        if (!TextUtils.isEmpty(this.mMaskMobile)) {
            SMSNickLoginPresenter sMSNickLoginPresenter = this.mNickLoginPresenter;
            if (sMSNickLoginPresenter != null && sMSNickLoginPresenter.getLoginParam() != null) {
                this.mNickLoginPresenter.getLoginParam().loginSourcePage = getPageName();
                this.mNickLoginPresenter.getLoginParam().loginSourceSpm = getPageSpm();
                this.mNickLoginPresenter.getLoginParam().loginSourceType = LoginType.LocalLoginType.NICK_SMS_LOGIN;
                this.mNickLoginPresenter.getLoginParam().traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.NICK_SMS_LOGIN, getPageName());
                HashMap hashMap = new HashMap();
                hashMap.put("sdkTraceId", this.mNickLoginPresenter.getLoginParam().traceId + "");
                UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstans.CustomEvent.UT_SMS_ACTION, "", LoginType.LocalLoginType.NICK_SMS_LOGIN, hashMap);
                SMSNickLoginPresenter sMSNickLoginPresenter2 = this.mNickLoginPresenter;
                sMSNickLoginPresenter2.sendSMS(sMSNickLoginPresenter2.getLoginParam().loginAccount);
                return;
            }
            return;
        }
        UserMobileLoginPresenter userMobileLoginPresenter = this.mPresenter;
        if (userMobileLoginPresenter != null && userMobileLoginPresenter.getLoginParam() != null) {
            this.mPresenter.getLoginParam().loginSourcePage = getPageName();
            this.mPresenter.getLoginParam().loginSourceSpm = getPageSpm();
            this.mPresenter.getLoginParam().loginSourceType = LoginType.LocalLoginType.SMS_LOGIN;
            this.mPresenter.getLoginParam().traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.SMS_LOGIN, getPageName());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("sdkTraceId", this.mPresenter.getLoginParam().traceId + "");
            UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstans.CustomEvent.UT_SMS_ACTION, "", LoginType.LocalLoginType.SMS_LOGIN, hashMap2);
            AppMonitorAdapter.commitSuccess("Page_Member_Login", "loginMonitorPoint", "action=smsAction;biz=smsLogin;page=" + getPageName());
            this.mPresenter.sendSMS();
        }
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onSendSMSSuccess(long j, boolean z) {
        this.mSendSMSCodeBtn.startCountDown(j, 1000);
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void openHelp() {
        NavigatorManager.getInstance().navToTransparentWeb(getActivity(), this.mPresenter.getLoginParam().helpUrl);
    }

    /* access modifiers changed from: protected */
    public void sendCodeAction() {
        MainThreadExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.AnonymousClass6 */

            public void run() {
                AliUserSmsCodeView aliUserSmsCodeView = AliUserSMSLoginVerificationFragment.this.mSmsCodeView;
                if (aliUserSmsCodeView != null) {
                    aliUserSmsCodeView.clearText();
                }
                try {
                    AliUserSMSLoginVerificationFragment.this.onSendSMSAction();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public void setLoginAccountInfo(String str) {
    }

    /* access modifiers changed from: protected */
    public void showMoreLoginModeMenu(LoginModeState loginModeState) {
        this.mChangeLogin.postDelayed(new Runnable() {
            /* class com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.AnonymousClass4 */

            public void run() {
                try {
                    if (((BaseFragment) AliUserSMSLoginVerificationFragment.this).mActivityHelper != null) {
                        ((BaseFragment) AliUserSMSLoginVerificationFragment.this).mActivityHelper.hideInputMethod();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, 100);
        BottomMenuFragment bottomMenuFragment = getBottomMenuFragment();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.mAvailableLoginModes.iterator();
        while (it.hasNext()) {
            final String next = it.next();
            if (!TextUtils.equals(loginModeState.name(), next)) {
                com.ali.user.mobile.ui.widget.MenuItem menuItem = new com.ali.user.mobile.ui.widget.MenuItem();
                final LoginModeState valueOf = LoginModeState.valueOf(next);
                int i = valueOf.loginModeName;
                if (i > 0) {
                    menuItem.setText(getString(i));
                    menuItem.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem) {
                        /* class com.ali.user.mobile.login.ui.AliUserSMSLoginVerificationFragment.AnonymousClass5 */

                        @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                        public void onClickMenuItem(View view, com.ali.user.mobile.ui.widget.MenuItem menuItem) {
                            if (AliUserSMSLoginVerificationFragment.this.isActive()) {
                                AliUserSMSLoginVerificationFragment.this.switchLoginModeHit(valueOf);
                                if (AliUserSMSLoginVerificationFragment.this.havanaId == 0 || !LoginModeState.SCAN_FACE.name().equals(next)) {
                                    ILoginMethodChange iLoginMethodChange = AliUserSMSLoginVerificationFragment.mLoginMethodChange;
                                    if (iLoginMethodChange != null) {
                                        iLoginMethodChange.onMethodChange(valueOf);
                                    }
                                    AliUserSMSLoginVerificationFragment.mLoginMethodChange = null;
                                    if (AliUserSMSLoginVerificationFragment.this.isActive() && AliUserSMSLoginVerificationFragment.this.getActivity() != null) {
                                        AliUserSMSLoginVerificationFragment.this.goBack();
                                        return;
                                    }
                                    return;
                                }
                                AliUserSMSLoginVerificationFragment.this.onFaceLogin();
                            }
                        }
                    });
                    arrayList.add(menuItem);
                }
            }
        }
        bottomMenuFragment.setMenuItems(arrayList);
        bottomMenuFragment.setMenuTitle(getString(R.string.aliuser_more_login_mode_title));
        bottomMenuFragment.show(getFragmentManager(), getPageName());
    }

    public void submitLoginForm() {
        String str = !TextUtils.isEmpty(this.mMaskMobile) ? LoginType.LocalLoginType.NICK_SMS_LOGIN : LoginType.LocalLoginType.SMS_LOGIN;
        HashMap hashMap = new HashMap();
        hashMap.put("sdkTraceId", this.loginParam.traceId + "");
        UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstant.CustomEvent.UT_LOGIN_ACTION, "", str, hashMap);
        if (!LoginSwitch.isInABTestRegion("api", 10000)) {
            Properties properties = new Properties();
            properties.setProperty("sdkTraceId", this.loginParam.traceId + "");
            properties.setProperty("monitor", "T");
            properties.setProperty("site", getLoginSite() + "");
            properties.setProperty("loginId", this.loginParam.loginAccount + "");
            UserTrackAdapter.sendUT(getPageName(), UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", str, properties);
        }
        try {
            ActivityUIHelper activityUIHelper = this.mActivityHelper;
            if (activityUIHelper != null) {
                activityUIHelper.hideInputMethod();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.mMaskMobile)) {
            this.mNickLoginPresenter.buildSMSLoginParam(this.loginParam.loginAccount, this.mSmsCodeView.getText(), false);
            this.mNickLoginPresenter.login();
            return;
        }
        this.mPresenter.buildSMSLoginParam(this.loginParam.loginAccount, this.mSmsCodeView.getText(), false);
        this.mPresenter.login();
    }

    /* access modifiers changed from: protected */
    public void switchLoginModeHit(LoginModeState loginModeState) {
        int i = AnonymousClass11.$SwitchMap$com$ali$user$mobile$login$ui$LoginModeState[loginModeState.ordinal()];
        if (i == 1) {
            UserTrackAdapter.sendControlUT(getPageName(), getPageSpm(), "chooseother_sms", "");
        } else if (i == 2) {
            UserTrackAdapter.sendControlUT(getPageName(), getPageSpm(), "chooseother_pwd", "");
        } else if (i == 3) {
            UserTrackAdapter.sendControlUT(getPageName(), getPageSpm(), "chooseother_onekey", "");
        } else if (i == 4) {
            UserTrackAdapter.sendControlUT(getPageName(), getPageSpm(), "chooseother_face", "");
        }
    }
}
