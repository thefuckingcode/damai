package com.ali.user.mobile.login.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.data.model.Login2RegParam;
import com.ali.user.mobile.helper.ActivityUIHelper;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.AppMonitorAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginFrom;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.login.presenter.BioPresenter;
import com.ali.user.mobile.login.presenter.FaceLoginPresenter;
import com.ali.user.mobile.login.presenter.UserMobileLoginPresenter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.mobile.register.ui.AliUserRegisterChoiceRegionActivity;
import com.ali.user.mobile.register.ui.RegionDialogFragment;
import com.ali.user.mobile.register.ui.RegionListener;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.widget.BottomMenuFragment;
import com.ali.user.mobile.ui.widget.CountDownButton;
import com.ali.user.mobile.ui.widget.MenuItem;
import com.ali.user.mobile.ui.widget.MenuItemOnClickListener;
import com.ali.user.mobile.utils.CountryUtil;
import com.ali.user.mobile.utils.ElderUtil;
import com.ali.user.mobile.utils.StringUtil;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import org.apache.commons.lang3.time.DateUtils;
import tb.jl1;

/* compiled from: Taobao */
public class AliUserMobileLoginFragment extends BaseLoginFragment implements UserMobileLoginView {
    protected static final String TAG = AliUserMobileLoginFragment.class.getSimpleName();
    protected boolean checkcodeUT = true;
    protected boolean faceLoginEnable = false;
    protected boolean hasSendSms = false;
    protected boolean isAutoSendSms = false;
    protected boolean isBindPhone = false;
    protected boolean isForceNormalMode = false;
    protected boolean isVoice = false;
    protected LoginParam loginParam = null;
    protected boolean mActiveLogin = false;
    protected String mCurrentAccount;
    protected String mCurrentSelectedAccount;
    protected LinearLayout mFirstLoginLL;
    protected LinearLayout mHistoryLoginLL;
    protected Button mLoginBtn;
    protected LinearLayout mLoginBtnShadow;
    protected View mMobileClearBtn;
    protected EditText mMobileET;
    protected UserMobileLoginPresenter mMobileLoginPresenter;
    protected TextView mMobileTV;
    protected TextWatcher mMobileTextWatcher;
    protected TextView mRegTV;
    protected RegionInfo mRegionInfo;
    protected TextView mRegionTV;
    protected LinearLayout mRootView;
    protected EditText mSMSCodeET;
    protected CountDownButton mSendSMSCodeBtn;
    protected TextWatcher mSmsCodeTextWatcher;
    protected TextView mSmsSuccessTipTV;
    protected String mSource;
    protected TextView mSwitchFaceLoginBtn;
    protected TextView mSwitchMoreLoginBtn;
    protected TextView mSwitchPwdLoginBtn;
    protected LinearLayout mVoiceRR;
    protected TextView mVoiceTV;
    protected boolean mobileUT = true;
    protected int originalAccountETPadding;
    protected boolean pwdLoginEnable = false;
    protected String snsBindProtocolUrl;
    protected boolean snsSupportOverSeaMobile = true;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class LoginTextWatcher implements TextWatcher {
        private WeakReference<EditText> editText;

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AliUserMobileLoginFragment.this.onAccountTextChanged(this.editText.get(), charSequence);
        }

        private LoginTextWatcher(EditText editText2) {
            this.editText = new WeakReference<>(editText2);
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(21)
    /* compiled from: Taobao */
    public class MobileTextWatcher extends PhoneNumberFormattingTextWatcher {
        private WeakReference<EditText> editText;

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AliUserMobileLoginFragment.this.onAccountTextChanged(this.editText.get(), charSequence);
        }

        private MobileTextWatcher(EditText editText2, String str) {
            super(str);
            this.editText = new WeakReference<>(editText2);
        }
    }

    /* access modifiers changed from: protected */
    public void adjustMobileETMaxLength() {
        RegionInfo regionInfo = this.mRegionInfo;
        if (regionInfo == null || !TextUtils.equals("CN", regionInfo.domain)) {
            EditText editText = this.mMobileET;
            if (editText != null) {
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
                if (Build.VERSION.SDK_INT >= 21) {
                    LoginTextWatcher loginTextWatcher = new LoginTextWatcher(this.mMobileET);
                    this.mMobileTextWatcher = loginTextWatcher;
                    this.mMobileET.addTextChangedListener(loginTextWatcher);
                    return;
                }
                return;
            }
            return;
        }
        this.mMobileET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        if (Build.VERSION.SDK_INT >= 21) {
            TextWatcher mobileTextWatcherAPI21 = getMobileTextWatcherAPI21();
            this.mMobileTextWatcher = mobileTextWatcherAPI21;
            this.mMobileET.addTextChangedListener(mobileTextWatcherAPI21);
        }
    }

    /* access modifiers changed from: protected */
    public void applyRegion() {
        this.mMobileLoginPresenter.region();
    }

    /* access modifiers changed from: protected */
    public void checkSignInable(EditText editText) {
        EditText editText2 = this.mMobileET;
        boolean z = false;
        if (editText2 == null || this.mSMSCodeET == null) {
            this.mLoginBtn.setEnabled(false);
        } else if (editText != null) {
            String obj = editText2.getText().toString();
            if (this.isHistoryMode) {
                obj = this.mMobileTV.getText().toString();
            }
            if (editText.getId() == R.id.aliuser_login_mobile_et) {
                if (TextUtils.isEmpty(obj) || this.mSendSMSCodeBtn.isCountDowning()) {
                    this.mSendSMSCodeBtn.setEnabled(false);
                } else {
                    this.mSendSMSCodeBtn.setEnabled(true);
                }
            }
            String obj2 = this.mSMSCodeET.getText().toString();
            if (!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(obj2) && obj2.length() >= 4) {
                z = true;
            }
            this.mLoginBtn.setEnabled(z);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void doRealAction(int i) {
        if (i == 0) {
            onLoginAction();
        } else if (i == 2) {
            onFaceLogin(true);
        } else if (i == 3) {
            onSendSMSAction();
        } else if (i == LoginClickAction.ACTION_TAOBAO) {
            goTaobao();
        } else if (i == LoginClickAction.ACTION_ALIPAY) {
            goAlipay();
        } else {
            super.doRealAction(i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public String getAccountName() {
        if (this.isHistoryMode) {
            return this.mCurrentSelectedAccount;
        }
        String trim = this.mMobileET.getText().toString().trim();
        if (trim.contains(jl1.MUL)) {
            return this.mCurrentSelectedAccount;
        }
        return trim.replaceAll(" ", "");
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public String getCountryCode() {
        RegionInfo regionInfo = this.mRegionInfo;
        return (regionInfo == null || TextUtils.isEmpty(regionInfo.domain)) ? "CN" : this.mRegionInfo.domain;
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public int getLayoutContent() {
        return R.layout.aliuser_fragment_mobile_login;
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public int getLoginSite() {
        UserLoginActivity userLoginActivity;
        HistoryAccount historyAccount;
        if (!this.isHistoryMode || (userLoginActivity = this.mUserLoginActivity) == null || (historyAccount = userLoginActivity.mHistoryAccount) == null) {
            return DataProviderFactory.getDataProvider().getSite();
        }
        return historyAccount.getLoginSite();
    }

    /* access modifiers changed from: protected */
    public TextWatcher getMobileTextWatcher() {
        return new LoginTextWatcher(this.mMobileET);
    }

    /* access modifiers changed from: protected */
    public TextWatcher getMobileTextWatcherAPI21() {
        return new MobileTextWatcher(this.mMobileET, Locale.CHINA.getCountry());
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageName() {
        return this.isHistoryMode ? UTConstant.PageName.UT_PAGE_SMS_LOGIN2 : UTConstant.PageName.UT_PAGE_SMS_LOGIN1;
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageSpm() {
        return UTConstant.PageName.F_SMS2;
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public String getPhoneCode() {
        HistoryAccount historyAccount;
        if (!this.isForceNormalMode) {
            UserLoginActivity userLoginActivity = this.mUserLoginActivity;
            if (userLoginActivity.hadReadHistory && (historyAccount = userLoginActivity.mHistoryAccount) != null) {
                String str = historyAccount.mobile;
                if (!TextUtils.isEmpty(str) && str.contains("-")) {
                    String[] split = str.split("-");
                    if (split.length > 0) {
                        return split[0];
                    }
                }
            }
        }
        RegionInfo regionInfo = this.mRegionInfo;
        return (regionInfo == null || TextUtils.isEmpty(regionInfo.code)) ? "86" : this.mRegionInfo.code.replace(jl1.PLUS, "");
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void goAlipay() {
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void goTaobao() {
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void initAccountEditText(String str) {
        if (!TextUtils.isEmpty(str)) {
            setLoginAccountInfo(str);
        }
    }

    /* access modifiers changed from: protected */
    public void initMode() {
        if (this.isForceNormalMode || DataProviderFactory.getDataProvider().getMaxHistoryAccount() == 0) {
            this.isHistoryMode = false;
            if (TextUtils.isEmpty(this.mCurrentAccount)) {
                switchMode(this.isHistoryMode, null);
            } else {
                setLoginAccountInfo(this.mCurrentAccount);
            }
        } else {
            UserLoginActivity userLoginActivity = this.mUserLoginActivity;
            if (userLoginActivity.hadReadHistory) {
                HistoryAccount historyAccount = userLoginActivity.mHistoryAccount;
                if (historyAccount != null) {
                    this.isHistoryMode = true;
                    switchToHistoryMode(historyAccount);
                    return;
                }
                this.isHistoryMode = false;
                switchMode(false, null);
                return;
            }
            this.isHistoryMode = false;
            switchMode(false, null);
        }
    }

    /* access modifiers changed from: protected */
    public void initParams() {
        Bundle arguments = getArguments();
        this.loginParam = null;
        if (arguments != null) {
            try {
                this.mPreviousChecked = arguments.getBoolean("check");
                String str = (String) arguments.get(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
                arguments.putString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, "");
                if (!TextUtils.isEmpty(str)) {
                    LoginParam loginParam2 = (LoginParam) JSON.parseObject(str, LoginParam.class);
                    this.loginParam = loginParam2;
                    if (loginParam2 != null) {
                        this.snsSupportOverSeaMobile = loginParam2.supportOverseaMobile;
                        this.snsBindProtocolUrl = loginParam2.bindProtocolUrl;
                    }
                }
                this.isForceNormalMode = arguments.getBoolean(LoginConstant.FORCE_NORMAL_MODE);
                this.mCurrentAccount = arguments.getString(LoginConstant.ACCOUNT);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.isForceNormalMode = arguments.getBoolean(LoginConstant.FORCE_NORMAL_MODE);
            this.isBindPhone = arguments.getBoolean(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM_IS_BIND_PHONE);
            LoginParam loginParam3 = this.loginParam;
            if (loginParam3 != null) {
                this.hasSendSms = !TextUtils.isEmpty(loginParam3.smsSid);
                this.mSource = this.loginParam.source;
            }
            this.mCurrentAccount = arguments.getString(LoginConstant.ACCOUNT);
            this.isAutoSendSms = arguments.getBoolean("autoSendSms");
        }
        this.mMobileLoginPresenter = new UserMobileLoginPresenter(this, this.loginParam);
        this.mFaceLoginPresenter = new FaceLoginPresenter(this, this.loginParam);
        this.mBioPresenter = new BioPresenter(this, this.loginParam);
    }

    /* access modifiers changed from: protected */
    public void initRegionInfo() {
        String str;
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions == null || loginApprearanceExtensions.needCountryModule()) {
            RegionInfo currentRegion = DataProviderFactory.getDataProvider().getCurrentRegion();
            if (currentRegion == null || TextUtils.isEmpty(currentRegion.domain) || TextUtils.isEmpty(currentRegion.name) || TextUtils.isEmpty(currentRegion.code)) {
                if (currentRegion == null) {
                    str = "";
                } else {
                    str = currentRegion.domain;
                }
                currentRegion = CountryUtil.matchRegionFromLocal(getContext(), str);
            }
            if (currentRegion != null) {
                this.mRegionInfo = currentRegion;
                this.mRegionTV.setVisibility(0);
                this.mRegionTV.setText(this.mRegionInfo.code);
                resizeMobileETPadding();
            }
        } else {
            this.mRegionTV.setVisibility(8);
        }
        adjustMobileETMaxLength();
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        LoginApprearanceExtensions loginApprearanceExtensions;
        super.initViews(view);
        this.mRootView = (LinearLayout) view.findViewById(R.id.aliuser_root_ll);
        EditText editText = (EditText) view.findViewById(R.id.aliuser_login_mobile_et);
        this.mMobileET = editText;
        if (editText != null) {
            editText.setSingleLine();
            LoginTextWatcher loginTextWatcher = new LoginTextWatcher(this.mMobileET);
            this.mMobileTextWatcher = loginTextWatcher;
            this.mMobileET.addTextChangedListener(loginTextWatcher);
        }
        this.mMobileClearBtn = view.findViewById(R.id.aliuser_login_mobile_clear_iv);
        this.mRegionTV = (TextView) view.findViewById(R.id.aliuser_region_tv);
        initRegionInfo();
        EditText editText2 = (EditText) view.findViewById(R.id.aliuser_register_sms_code_et);
        this.mSMSCodeET = editText2;
        if (editText2 != null) {
            LoginTextWatcher loginTextWatcher2 = new LoginTextWatcher(editText2);
            this.mSmsCodeTextWatcher = loginTextWatcher2;
            this.mSMSCodeET.addTextChangedListener(loginTextWatcher2);
        }
        this.mSendSMSCodeBtn = (CountDownButton) view.findViewById(R.id.aliuser_login_send_smscode_btn);
        this.mHistoryLoginLL = (LinearLayout) view.findViewById(R.id.aliuser_login_history_ll);
        this.mFirstLoginLL = (LinearLayout) view.findViewById(R.id.aliuser_login_normal_ll);
        this.mMobileTV = (TextView) view.findViewById(R.id.aliuser_login_mobile_tv);
        this.mLoginBtn = (Button) view.findViewById(R.id.aliuser_login_login_btn);
        TextView textView = (TextView) view.findViewById(R.id.aliuser_login_switch_pwdlogin);
        this.mSwitchPwdLoginBtn = textView;
        if (this.isBindPhone) {
            textView.setVisibility(8);
            this.mLoginBtn.setText(R.string.aliuser_bind_and_login_title);
        }
        this.mSwitchMoreLoginBtn = (TextView) view.findViewById(R.id.aliuser_login_switch_more_login);
        this.mSwitchFaceLoginBtn = (TextView) view.findViewById(R.id.aliuser_login_switch_face_login);
        TextView textView2 = (TextView) view.findViewById(R.id.aliuser_reg_tv);
        this.mRegTV = textView2;
        if (!(textView2 == null || (loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions) == null || loginApprearanceExtensions.needRegister())) {
            this.mRegTV.setVisibility(8);
        }
        this.mSmsSuccessTipTV = (TextView) view.findViewById(R.id.aliuser_send_sms_success_tip);
        try {
            this.mVoiceRR = (LinearLayout) view.findViewById(R.id.aliuser_login_voice_rr);
            TextView textView3 = (TextView) view.findViewById(R.id.aliuser_login_send_voicecode_tv);
            this.mVoiceTV = textView3;
            if (textView3 != null) {
                textView3.setOnClickListener(new View.OnClickListener() {
                    /* class com.ali.user.mobile.login.ui.AliUserMobileLoginFragment.AnonymousClass1 */

                    public void onClick(View view) {
                        AliUserMobileLoginFragment aliUserMobileLoginFragment = AliUserMobileLoginFragment.this;
                        aliUserMobileLoginFragment.isVoice = true;
                        aliUserMobileLoginFragment.addControl("Button-SendVoiceCode");
                        AliUserMobileLoginFragment.this.onSendSMSAction();
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.mLoginBtnShadow = (LinearLayout) view.findViewById(R.id.aliuser_login_login_btn_ll);
        setOnClickListener(this.mLoginBtn, this.mSendSMSCodeBtn, this.mRegTV, this.mSwitchPwdLoginBtn, this.mRegionTV, this.mMobileClearBtn, this.mSwitchMoreLoginBtn, this.mSwitchFaceLoginBtn);
        this.mMobileLoginPresenter.onStart();
        initMode();
        showPushLogoutAlertIfHas();
        if (this.hasSendSms) {
            onSendSMSSuccess(59000, true);
        }
        if (!LoginSwitch.getSwitch(LoginSwitch.OPEN_LOGIN_PAGE_WHEN_IS_LOGIN, "false")) {
            BroadCastHelper.sendLocalBroadCast(new Intent(LoginResActions.LOGIN_OPEN_ACTION));
        }
        if (this.needAdaptElder) {
            ElderUtil.scaleTextSize(this.mProtocolTV, this.mMobileTV, this.mLoginBtn, this.mVoiceTV, this.mRegionTV, this.mRegTV, this.mMobileET, this.mSMSCodeET, this.mSendSMSCodeBtn, this.mSwitchPwdLoginBtn, this.mSwitchFaceLoginBtn, this.mSwitchMoreLoginBtn);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public boolean isHistoryMode() {
        return this.isHistoryMode;
    }

    /* access modifiers changed from: protected */
    public boolean isMobileValid(String str) {
        RegionInfo regionInfo;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!this.isHistoryMode && (regionInfo = this.mRegionInfo) != null && !TextUtils.isEmpty(regionInfo.checkPattern)) {
            String replaceAll = str.replaceAll(" ", "");
            String replace = this.mRegionInfo.code.replace(jl1.PLUS, "");
            return (replace + replaceAll).matches(this.mRegionInfo.checkPattern);
        } else if (str.length() < 6 || str.length() > 20) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onAccountTextChanged(EditText editText, CharSequence charSequence) {
        if (editText.getId() != R.id.aliuser_login_mobile_et || this.mMobileClearBtn == null) {
            if (editText.getId() == R.id.aliuser_register_sms_code_et && charSequence != null && charSequence.length() > 0 && this.checkcodeUT) {
                this.checkcodeUT = false;
                addControl("InputCode");
            }
        } else if (charSequence != null && charSequence.length() != 0) {
            if (this.mobileUT) {
                this.mobileUT = false;
                addControl("InputPhone");
            }
            if (this.mMobileClearBtn.getVisibility() != 0 && this.mMobileClearBtn.isEnabled()) {
                this.mMobileClearBtn.setVisibility(0);
            }
        } else if (this.mMobileClearBtn.getVisibility() != 8) {
            this.mMobileClearBtn.setVisibility(8);
        }
        checkSignInable(editText);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1 || i != 2001) {
            this.mMobileLoginPresenter.onActivityResult(i, i2, intent);
        } else if (intent != null) {
            RegionInfo regionInfo = (RegionInfo) intent.getParcelableExtra(RegistConstants.REGION_INFO);
            this.mRegionInfo = regionInfo;
            if (regionInfo != null) {
                this.mRegionTV.setText(regionInfo.code);
                resizeMobileETPadding();
                adjustMobileETMaxLength();
            }
        }
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onCheckCodeError() {
        this.mSMSCodeET.setText("");
    }

    /* access modifiers changed from: protected */
    public void onClearAccountBtnClickAction() {
        if (DataProviderFactory.getDataProvider().isShowHistoryFragment() || TextUtils.isEmpty(this.mMobileET.getText()) || this.mMobileET.isEnabled()) {
            this.mMobileET.getEditableText().clear();
            this.mMobileET.setEnabled(true);
            this.isVoice = false;
            setTipGone();
            LinearLayout linearLayout = this.mVoiceRR;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        onDeleteAccount();
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.aliuser_login_login_btn) {
            addCheckAction(LoginClickAction.ACTION_LOGIN);
        } else if (id == R.id.aliuser_login_send_smscode_btn) {
            this.isVoice = false;
            addCheckAction(LoginClickAction.ACTION_SEND_SMS);
        } else if (id == R.id.aliuser_login_switch_pwdlogin) {
            addControl(UTConstans.Controls.UT_CHOOSE_OHTER_PWD);
            switchToPwdLogin();
        } else if (id == R.id.aliuser_login_switch_more_login) {
            addControl("Button-ChooseMoreLogin");
            showMoreLoginBottomMenu();
        } else if (id == R.id.aliuser_login_switch_face_login) {
            addCheckAction(LoginClickAction.ACTION_FACE);
        } else if (id == R.id.aliuser_region_tv) {
            addControl("Button-Region");
            if (DataProviderFactory.getDataProvider().useRegionFragment()) {
                applyRegion();
                return;
            }
            Intent intent = new Intent(this.mAttachedActivity, AliUserRegisterChoiceRegionActivity.class);
            intent.putExtra("from_login", true);
            this.mAttachedActivity.startActivityForResult(intent, 2001);
        } else if (id == R.id.aliuser_login_mobile_clear_iv) {
            onClearAccountBtnClickAction();
        } else {
            super.onClick(view);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initParams();
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        UserMobileLoginPresenter userMobileLoginPresenter = this.mMobileLoginPresenter;
        if (userMobileLoginPresenter != null) {
            userMobileLoginPresenter.onDestory();
        }
        CountDownButton countDownButton = this.mSendSMSCodeBtn;
        if (countDownButton != null) {
            countDownButton.cancelCountDown();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        EditText editText = this.mMobileET;
        if (editText != null) {
            editText.removeTextChangedListener(this.mMobileTextWatcher);
        }
        EditText editText2 = this.mSMSCodeET;
        if (editText2 != null) {
            editText2.removeTextChangedListener(this.mSmsCodeTextWatcher);
        }
        super.onDestroyView();
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public void onError(RpcResponse rpcResponse) {
        setTipGone();
        this.mMobileLoginPresenter.onLoginFail(rpcResponse);
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.BaseView
    public void onGetRegion(List<RegionInfo> list) {
        if (isActive()) {
            RegionDialogFragment regionDialogFragment = new RegionDialogFragment();
            regionDialogFragment.setList(list);
            regionDialogFragment.setRegionListener(new RegionListener() {
                /* class com.ali.user.mobile.login.ui.AliUserMobileLoginFragment.AnonymousClass7 */

                @Override // com.ali.user.mobile.register.ui.RegionListener
                public void onClick(RegionInfo regionInfo) {
                    AliUserMobileLoginFragment aliUserMobileLoginFragment = AliUserMobileLoginFragment.this;
                    aliUserMobileLoginFragment.mRegionInfo = regionInfo;
                    if (regionInfo != null) {
                        aliUserMobileLoginFragment.mRegionTV.setText(regionInfo.code);
                        AliUserMobileLoginFragment.this.resizeMobileETPadding();
                        AliUserMobileLoginFragment.this.adjustMobileETMaxLength();
                    }
                }
            });
            regionDialogFragment.setCurrentRegion(this.mRegionInfo);
            regionDialogFragment.setupAdapter(getActivity());
            regionDialogFragment.show(getActivity().getSupportFragmentManager(), "MobileRegionDialog");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void onLoginAction() {
        LoginFrom.setCurrentLoginFrom("5");
        this.mActiveLogin = true;
        this.mCurrentAccount = getAccountName();
        String trim = this.mSMSCodeET.getText().toString().trim();
        if (TextUtils.isEmpty(this.mCurrentAccount) || !isMobileValid(this.mCurrentAccount)) {
            showErrorMessage(R.string.aliuser_login_mobile_verify_hint);
        } else if (TextUtils.isEmpty(trim)) {
            showErrorMessage(R.string.aliuser_login_sms_code_hint);
        } else if (this.mMobileLoginPresenter.getLoginParam() == null || (this.mMobileLoginPresenter.getLoginParam() != null && TextUtils.isEmpty(this.mMobileLoginPresenter.getLoginParam().smsSid))) {
            toast(getString(R.string.aliuser_send_sms_first), 0);
        } else {
            ActivityUIHelper activityUIHelper = this.mActivityHelper;
            if (activityUIHelper != null) {
                activityUIHelper.hideInputMethod();
            }
            this.mMobileLoginPresenter.buildSMSLoginParam(this.mCurrentAccount, trim, this.isVoice);
            HashMap hashMap = new HashMap();
            hashMap.put("sdkTraceId", this.mMobileLoginPresenter.getLoginParam().traceId + "");
            hashMap.put("spm", getPageSpm());
            UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.SMS_LOGIN, hashMap);
            if (!LoginSwitch.isInABTestRegion("api", 10000)) {
                Properties properties = new Properties();
                properties.setProperty("sdkTraceId", this.mMobileLoginPresenter.getLoginParam().traceId + "");
                properties.setProperty("monitor", "T");
                properties.setProperty("site", getLoginSite() + "");
                properties.setProperty("loginId", getAccountName() + "");
                UserTrackAdapter.sendUT(getPageName(), UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.SMS_LOGIN, properties);
            }
            this.mMobileLoginPresenter.login();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public void onNeedReg(Login2RegParam login2RegParam) {
        String str = login2RegParam.token;
        Properties properties = new Properties();
        StringBuilder sb = new StringBuilder();
        sb.append(this.loginParam.traceId);
        String str2 = "";
        sb.append(str2);
        properties.setProperty("sdkTraceId", sb.toString());
        UserTrackAdapter.sendUT(getPageName(), UTConstant.CustomEvent.UT_LOGIN_TO_REG, properties);
        UserMobileLoginPresenter userMobileLoginPresenter = this.mMobileLoginPresenter;
        LoginParam loginParam2 = this.loginParam;
        if (loginParam2 != null) {
            str2 = loginParam2.traceId;
        }
        userMobileLoginPresenter.directRegister(null, str, str2);
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onSMSOverLimit(RpcResponse rpcResponse) {
        if (isActive() && rpcResponse != null && rpcResponse.code == 14100) {
            onSendSMSSuccess(DateUtils.MILLIS_PER_MINUTE, false);
        }
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onSMSSendFail(RpcResponse rpcResponse) {
    }

    /* access modifiers changed from: protected */
    public void onSendSMSAction() {
        String accountName = getAccountName();
        this.mCurrentAccount = accountName;
        if (TextUtils.isEmpty(accountName) || !isMobileValid(this.mCurrentAccount)) {
            showErrorMessage(R.string.aliuser_login_mobile_verify_hint);
            return;
        }
        Properties properties = new Properties();
        properties.setProperty("result", "CheckPass");
        UserTrackAdapter.sendUT(getPageName(), "CheckPhoneResult", null, null, properties);
        this.mMobileLoginPresenter.buildSMSLoginParam(this.mCurrentAccount, null, this.isVoice);
        this.mMobileLoginPresenter.getLoginParam().loginSourcePage = getPageName();
        this.mMobileLoginPresenter.getLoginParam().loginSourceSpm = getPageSpm();
        this.mMobileLoginPresenter.getLoginParam().loginSourceType = LoginType.LocalLoginType.SMS_LOGIN;
        this.mMobileLoginPresenter.getLoginParam().traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.SMS_LOGIN, getPageName());
        HashMap hashMap = new HashMap();
        hashMap.put("sdkTraceId", this.mMobileLoginPresenter.getLoginParam().traceId + "");
        UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstans.CustomEvent.UT_SMS_ACTION, "", LoginType.LocalLoginType.SMS_LOGIN, hashMap);
        AppMonitorAdapter.commitSuccess("Page_Member_Login", "loginMonitorPoint", "action=smsAction;biz=smsLogin;page=" + getPageName());
        this.mMobileLoginPresenter.sendSMS();
    }

    @Override // com.ali.user.mobile.login.ui.UserMobileLoginView
    public void onSendSMSSuccess(long j, boolean z) {
        showSendSMSTip(z);
        this.mSendSMSCodeBtn.startCountDown(j, 1000);
        this.mSMSCodeET.postDelayed(new Runnable() {
            /* class com.ali.user.mobile.login.ui.AliUserMobileLoginFragment.AnonymousClass2 */

            public void run() {
                try {
                    AliUserMobileLoginFragment.this.mSMSCodeET.requestFocus();
                    ((InputMethodManager) ((BaseFragment) AliUserMobileLoginFragment.this).mAttachedActivity.getSystemService("input_method")).showSoftInput(AliUserMobileLoginFragment.this.mSMSCodeET, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 100);
        if (this.isVoice) {
            LinearLayout linearLayout = this.mVoiceRR;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            TextView textView = this.mSmsSuccessTipTV;
            if (textView != null) {
                textView.setText(R.string.aliuser_voice_code_success_hint);
                return;
            }
            return;
        }
        TextView textView2 = this.mSmsSuccessTipTV;
        if (textView2 != null) {
            textView2.setText(getString(R.string.aliuser_sms_code_success_hint));
        }
        if (DataProviderFactory.getDataProvider().isEnableVoiceMsg() && !"86".equals(getPhoneCode())) {
            this.mSendSMSCodeBtn.setTickListener(new CountDownButton.CountListener() {
                /* class com.ali.user.mobile.login.ui.AliUserMobileLoginFragment.AnonymousClass3 */

                @Override // com.ali.user.mobile.ui.widget.CountDownButton.CountListener
                public void onTick(long j) {
                    String trim = AliUserMobileLoginFragment.this.mSMSCodeET.getText().toString().trim();
                    AliUserMobileLoginFragment aliUserMobileLoginFragment = AliUserMobileLoginFragment.this;
                    if (!aliUserMobileLoginFragment.isVoice && 29 == j / 1000 && !"86".equals(aliUserMobileLoginFragment.getPhoneCode()) && TextUtils.isEmpty(trim)) {
                        TextView textView = AliUserMobileLoginFragment.this.mSmsSuccessTipTV;
                        if (textView != null) {
                            textView.setVisibility(8);
                        }
                        LinearLayout linearLayout = AliUserMobileLoginFragment.this.mVoiceRR;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(0);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void resizeMobileETPadding() {
        this.mRegionTV.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.ali.user.mobile.login.ui.AliUserMobileLoginFragment.AnonymousClass6 */

            public void onGlobalLayout() {
                AliUserMobileLoginFragment aliUserMobileLoginFragment = AliUserMobileLoginFragment.this;
                if (aliUserMobileLoginFragment.originalAccountETPadding == 0) {
                    aliUserMobileLoginFragment.originalAccountETPadding = aliUserMobileLoginFragment.mMobileET.getPaddingLeft();
                }
                AliUserMobileLoginFragment.this.mRegionTV.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AliUserMobileLoginFragment aliUserMobileLoginFragment2 = AliUserMobileLoginFragment.this;
                EditText editText = aliUserMobileLoginFragment2.mMobileET;
                int width = aliUserMobileLoginFragment2.mRegionTV.getWidth();
                AliUserMobileLoginFragment aliUserMobileLoginFragment3 = AliUserMobileLoginFragment.this;
                editText.setPadding(width + aliUserMobileLoginFragment3.originalAccountETPadding, aliUserMobileLoginFragment3.mMobileET.getPaddingTop(), AliUserMobileLoginFragment.this.mMobileClearBtn.getWidth() + 30, AliUserMobileLoginFragment.this.mMobileET.getPaddingBottom());
            }
        });
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public void setLoginAccountInfo(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-");
            if (split.length > 1) {
                String str2 = split[0];
                String str3 = split[1];
                if (this.mMobileET != null && TextUtils.isEmpty(getAccountName()) && !TextUtils.isEmpty(str3)) {
                    this.mMobileET.setText(str3);
                }
                if (this.mRegionTV != null && !TextUtils.isEmpty(str2)) {
                    TextView textView = this.mRegionTV;
                    textView.setText(jl1.PLUS + str2);
                    RegionInfo regionInfo = new RegionInfo();
                    this.mRegionInfo = regionInfo;
                    regionInfo.code = str2;
                }
            }
        } else if (isMobileValid(str)) {
            this.mMobileET.setText(str);
        }
    }

    /* access modifiers changed from: protected */
    public void setTipGone() {
        TextView textView = this.mSmsSuccessTipTV;
        if (textView != null) {
            textView.setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public void showErrorMessage(int i) {
        toast(getString(i), 0);
    }

    /* access modifiers changed from: protected */
    public void showMoreLoginBottomMenu() {
        if (isActive()) {
            BottomMenuFragment bottomMenuFragment = getBottomMenuFragment();
            ArrayList arrayList = new ArrayList();
            addFingeritem(bottomMenuFragment, arrayList);
            if (this.pwdLoginEnable) {
                MenuItem menuItem = new MenuItem();
                menuItem.setText(getString(R.string.aliuser_login_pwd_login));
                menuItem.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem) {
                    /* class com.ali.user.mobile.login.ui.AliUserMobileLoginFragment.AnonymousClass4 */

                    @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                    public void onClickMenuItem(View view, MenuItem menuItem) {
                        if (AliUserMobileLoginFragment.this.isActive()) {
                            AliUserMobileLoginFragment aliUserMobileLoginFragment = AliUserMobileLoginFragment.this;
                            if (aliUserMobileLoginFragment.mUserLoginActivity != null) {
                                aliUserMobileLoginFragment.addControl(UTConstans.Controls.UT_CHOOSE_OHTER_PWD);
                                AliUserMobileLoginFragment.this.switchToPwdLogin();
                            }
                        }
                    }
                });
                arrayList.add(menuItem);
            }
            if (this.faceLoginEnable) {
                MenuItem menuItem2 = new MenuItem();
                menuItem2.setText(getString(R.string.aliuser_scan_login_text));
                menuItem2.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem2) {
                    /* class com.ali.user.mobile.login.ui.AliUserMobileLoginFragment.AnonymousClass5 */

                    @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                    public void onClickMenuItem(View view, MenuItem menuItem) {
                        if (AliUserMobileLoginFragment.this.isActive()) {
                            AliUserMobileLoginFragment aliUserMobileLoginFragment = AliUserMobileLoginFragment.this;
                            if (aliUserMobileLoginFragment.mUserLoginActivity != null) {
                                aliUserMobileLoginFragment.addCheckAction(LoginClickAction.ACTION_FACE);
                            }
                        }
                    }
                });
                arrayList.add(menuItem2);
            }
            bottomMenuFragment.setMenuItems(arrayList);
            bottomMenuFragment.show(getFragmentManager(), getPageName());
        }
    }

    /* access modifiers changed from: protected */
    public void showSendSMSTip(boolean z) {
        TextView textView;
        if (z && (textView = this.mSmsSuccessTipTV) != null) {
            textView.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void switchAccount() {
        Intent intent = new Intent();
        intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
        CheckBox checkBox = this.mProtocolCB;
        if (checkBox != null) {
            intent.putExtra("check", checkBox.isChecked());
        }
        UserMobileLoginPresenter userMobileLoginPresenter = this.mMobileLoginPresenter;
        if (!(userMobileLoginPresenter == null || userMobileLoginPresenter.getLoginParam() == null)) {
            LoginParam loginParam2 = new LoginParam();
            loginParam2.source = this.mMobileLoginPresenter.getLoginParam().source;
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam2));
        }
        UserLoginActivity userLoginActivity = this.mUserLoginActivity;
        if (userLoginActivity != null) {
            userLoginActivity.gotoMobileLoginFragment(intent);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void switchMode(boolean z, HistoryAccount historyAccount) {
        UserLoginActivity userLoginActivity;
        LoginApprearanceExtensions loginApprearanceExtensions;
        if (z) {
            this.mFirstLoginLL.setVisibility(8);
            this.mHistoryLoginLL.setVisibility(0);
            if (historyAccount.hasPwd == 1 && DataProviderFactory.getDataProvider().supportPwdLogin()) {
                this.pwdLoginEnable = true;
            }
            if (DataProviderFactory.getDataProvider().supportFaceLogin()) {
                UserLoginActivity userLoginActivity2 = this.mUserLoginActivity;
                if (userLoginActivity2.isFaceLoginEnvEnable || userLoginActivity2.isFaceLoginActivate) {
                    this.faceLoginEnable = true;
                }
            }
            boolean isFingerEnable = isFingerEnable(historyAccount);
            this.fingerLoginEnable = isFingerEnable;
            boolean z2 = this.pwdLoginEnable;
            if ((z2 && this.faceLoginEnable) || isFingerEnable) {
                this.mSwitchPwdLoginBtn.setVisibility(8);
                this.mSwitchMoreLoginBtn.setVisibility(0);
                this.mSwitchFaceLoginBtn.setVisibility(8);
                ((RelativeLayout.LayoutParams) this.mSwitchMoreLoginBtn.getLayoutParams()).addRule(14, -1);
            } else if (z2) {
                this.mSwitchPwdLoginBtn.setVisibility(0);
                this.mSwitchMoreLoginBtn.setVisibility(8);
                this.mSwitchFaceLoginBtn.setVisibility(8);
                ((RelativeLayout.LayoutParams) this.mSwitchPwdLoginBtn.getLayoutParams()).addRule(14, -1);
            } else if (this.faceLoginEnable) {
                this.mSwitchPwdLoginBtn.setVisibility(8);
                this.mSwitchMoreLoginBtn.setVisibility(8);
                this.mSwitchFaceLoginBtn.setVisibility(0);
                ((RelativeLayout.LayoutParams) this.mSwitchFaceLoginBtn.getLayoutParams()).addRule(14, -1);
            } else {
                this.mSwitchPwdLoginBtn.setVisibility(8);
                this.mSwitchMoreLoginBtn.setVisibility(8);
                this.mSwitchFaceLoginBtn.setVisibility(8);
            }
            this.mRegTV.setVisibility(8);
            if (this.isAutoSendSms) {
                onSendSMSAction();
            }
        } else if (DataProviderFactory.getDataProvider().supportRecommendLogin()) {
            Intent intent = new Intent();
            CheckBox checkBox = this.mProtocolCB;
            if (checkBox != null) {
                intent.putExtra("check", checkBox.isChecked());
            }
            this.mUserLoginActivity.switchToRecommendLogin(intent);
            return;
        } else {
            this.mFirstLoginLL.setVisibility(0);
            resizeMobileETPadding();
            this.mHistoryLoginLL.setVisibility(8);
            if (DataProviderFactory.getDataProvider().supportPwdLogin()) {
                this.mSwitchPwdLoginBtn.setVisibility(0);
                ((RelativeLayout.LayoutParams) this.mSwitchPwdLoginBtn.getLayoutParams()).addRule(9);
            } else {
                this.mSwitchPwdLoginBtn.setVisibility(8);
            }
            this.mSwitchMoreLoginBtn.setVisibility(8);
            this.mSwitchFaceLoginBtn.setVisibility(8);
            if (!(this.mRegTV == null || (loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions) == null || !loginApprearanceExtensions.needRegister())) {
                this.mRegTV.setVisibility(0);
            }
            if (!(DataProviderFactory.getDataProvider().isShowHistoryFragment() || (userLoginActivity = this.mUserLoginActivity) == null || this.mMobileET == null)) {
                HistoryAccount historyAccount2 = userLoginActivity.mHistoryAccount;
                if (historyAccount2 == null || TextUtils.isEmpty(historyAccount2.loginPhone)) {
                    this.mMobileET.setText("");
                    this.mMobileET.setEnabled(true);
                    this.mMobileET.requestFocus();
                } else {
                    this.mMobileET.setText(this.mUserLoginActivity.mHistoryAccount.mobile);
                    this.mMobileET.setEnabled(false);
                }
            }
        }
        if (getActivity() != null) {
            getActivity().invalidateOptionsMenu();
        }
    }

    /* access modifiers changed from: protected */
    public void switchToHistoryMode(HistoryAccount historyAccount) {
        if (isActivityAvaiable()) {
            String str = historyAccount.mobile;
            this.mCurrentSelectedAccount = str;
            if (!TextUtils.isEmpty(str) && historyAccount.mobile.contains("-")) {
                String[] split = historyAccount.mobile.split("-");
                if (split.length > 1) {
                    this.mCurrentSelectedAccount = split[1];
                }
            }
            String dataMasking = StringUtil.dataMasking(historyAccount.mobile);
            if (!TextUtils.isEmpty(dataMasking)) {
                switchMode(this.isHistoryMode, historyAccount);
                if (!TextUtils.isEmpty(historyAccount.headImg)) {
                    updateAvatar(historyAccount.headImg);
                }
                this.mMobileTV.setText(dataMasking);
                this.mSendSMSCodeBtn.setEnabled(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void switchToPwdLogin() {
        Intent intent = new Intent();
        intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, !this.isHistoryMode);
        CheckBox checkBox = this.mProtocolCB;
        if (checkBox != null) {
            intent.putExtra("check", checkBox.isChecked());
        }
        UserMobileLoginPresenter userMobileLoginPresenter = this.mMobileLoginPresenter;
        if (!(userMobileLoginPresenter == null || userMobileLoginPresenter.getLoginParam() == null)) {
            LoginParam loginParam2 = new LoginParam();
            loginParam2.source = this.mMobileLoginPresenter.getLoginParam().source;
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam2));
        }
        this.mUserLoginActivity.gotoPwdLoginFragment(intent);
    }
}
