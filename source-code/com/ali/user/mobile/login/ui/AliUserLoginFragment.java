package com.ali.user.mobile.login.ui;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.BooleanOrangeResult;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.helper.ActivityUIHelper;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.LoginFrom;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.login.presenter.BioPresenter;
import com.ali.user.mobile.login.presenter.FaceLoginPresenter;
import com.ali.user.mobile.login.presenter.RegionPresenter;
import com.ali.user.mobile.login.presenter.UserLoginPresenter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.mobile.register.ui.AliUserRegisterChoiceRegionActivity;
import com.ali.user.mobile.register.ui.RegionDialogFragment;
import com.ali.user.mobile.register.ui.RegionListener;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.widget.BottomMenuFragment;
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
import tb.jl1;

/* compiled from: Taobao */
public class AliUserLoginFragment extends BaseLoginFragment implements UserLoginView {
    protected static final String TAG = AliUserLoginFragment.class.getSimpleName();
    private boolean checkcodeUT = true;
    protected boolean faceLoginEnable = false;
    protected boolean isForceNormalMode = false;
    private boolean isInBindMode;
    protected LoginParam loginParam = null;
    protected View mAccountClearBtn;
    protected EditText mAccountET;
    protected TextView mAccountTV;
    protected boolean mActiveLogin = false;
    protected String mCurrentAccount;
    protected String mCurrentPassword;
    protected String mCurrentSelectedAccount;
    protected LinearLayout mFirstLoginLL;
    protected TextView mForgetPasswordTV;
    protected LinearLayout mHistoryLoginLL;
    protected Button mLoginBtn;
    protected LinearLayout mLoginBtnLL;
    protected LinearLayout mLoginLL;
    protected View mPasswordClearBtn;
    protected EditText mPasswordET;
    protected TextView mRegTV;
    protected RegionInfo mRegionInfo;
    protected RegionPresenter mRegionPresenter;
    protected TextView mRegionTV;
    protected ImageView mShowPasswordIV;
    protected String mSource;
    protected TextView mSwitchFaceLoginBtn;
    protected TextView mSwitchMoreLoginBtn;
    protected TextView mSwitchSmsLoginBtn;
    protected TextWatcher mTextWatcherAccount = null;
    protected TextWatcher mTextWatcherPassword = null;
    public UserLoginPresenter mUserLoginPresenter;
    protected boolean smsLoginEnable = false;

    @TargetApi(21)
    /* compiled from: Taobao */
    public class MobileTextWatcher extends PhoneNumberFormattingTextWatcher {
        private WeakReference<EditText> editText;

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.editText.get().getId() == R.id.aliuser_login_mobile_et && AliUserLoginFragment.this.mAccountClearBtn != null) {
                if (charSequence == null || charSequence.length() == 0) {
                    if (AliUserLoginFragment.this.mAccountClearBtn.getVisibility() != 8) {
                        AliUserLoginFragment.this.mAccountClearBtn.setVisibility(8);
                    }
                } else if (AliUserLoginFragment.this.mAccountClearBtn.getVisibility() != 0 && AliUserLoginFragment.this.mAccountClearBtn.isEnabled()) {
                    AliUserLoginFragment.this.mAccountClearBtn.setVisibility(0);
                }
            }
            AliUserLoginFragment.this.checkSignInable();
        }

        private MobileTextWatcher(EditText editText2, String str) {
            super(str);
            this.editText = new WeakReference<>(editText2);
        }
    }

    private void initTextWatcher() {
        initAccountWatcher();
        this.mTextWatcherPassword = new TextWatcher() {
            /* class com.ali.user.mobile.login.ui.AliUserLoginFragment.AnonymousClass1 */

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AliUserLoginFragment.this.beforePasspordChange();
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AliUserLoginFragment.this.mPasswordClearBtn != null) {
                    if (charSequence == null || charSequence.length() == 0) {
                        if (AliUserLoginFragment.this.mPasswordClearBtn.getVisibility() != 8) {
                            AliUserLoginFragment.this.mPasswordClearBtn.setVisibility(8);
                        }
                    } else if (AliUserLoginFragment.this.mPasswordClearBtn.getVisibility() != 0) {
                        AliUserLoginFragment.this.mPasswordClearBtn.setVisibility(0);
                    }
                }
                AliUserLoginFragment aliUserLoginFragment = AliUserLoginFragment.this;
                if (aliUserLoginFragment.mPasswordET != null) {
                    aliUserLoginFragment.checkSignInable();
                    if (charSequence != null && charSequence.length() > 0 && AliUserLoginFragment.this.checkcodeUT) {
                        AliUserLoginFragment.this.checkcodeUT = false;
                        AliUserLoginFragment.this.addControl("password_input");
                    }
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void adjustMobileETMaxLength() {
        RegionInfo regionInfo = this.mRegionInfo;
        if (regionInfo == null || !TextUtils.equals("CN", regionInfo.domain) || !DataProviderFactory.getDataProvider().enableMobilePwdLogin()) {
            this.mAccountET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
            if (Build.VERSION.SDK_INT >= 21) {
                initAccountWatcher();
                this.mAccountET.addTextChangedListener(this.mTextWatcherAccount);
                return;
            }
            return;
        }
        this.mAccountET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        if (Build.VERSION.SDK_INT >= 21) {
            MobileTextWatcher mobileTextWatcher = new MobileTextWatcher(this.mAccountET, Locale.CHINA.getCountry());
            this.mTextWatcherAccount = mobileTextWatcher;
            this.mAccountET.addTextChangedListener(mobileTextWatcher);
        }
    }

    /* access modifiers changed from: protected */
    public void applyRegion() {
        this.mRegionPresenter.region(0);
    }

    /* access modifiers changed from: protected */
    public void beforeAccountChange() {
    }

    /* access modifiers changed from: protected */
    public void beforePasspordChange() {
    }

    /* access modifiers changed from: protected */
    public void checkSignInable() {
        String obj = this.mAccountET.getText().toString();
        if (this.isHistoryMode) {
            obj = this.mAccountTV.getText().toString();
        }
        this.mLoginBtn.setEnabled(!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(this.mPasswordET.getText().toString()));
    }

    @Override // com.ali.user.mobile.login.ui.UserLoginView
    public void clearPasswordInput() {
        EditText editText = this.mPasswordET;
        if (editText != null) {
            editText.setText("");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public String getAccountName() {
        if (this.isHistoryMode) {
            return this.mCurrentSelectedAccount;
        }
        RegionInfo regionInfo = this.mRegionInfo;
        if (regionInfo == null || "+86".equals(regionInfo.code)) {
            return this.mAccountET.getText().toString().trim().replaceAll(" ", "");
        }
        return this.mRegionInfo.code.replace(jl1.PLUS, "") + "-" + this.mAccountET.getText().toString().trim().replaceAll(" ", "");
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public int getLayoutContent() {
        return R.layout.aliuser_fragment_user_login;
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public int getLoginSite() {
        HistoryAccount historyAccount;
        if (!this.isHistoryMode || (historyAccount = this.mUserLoginActivity.mHistoryAccount) == null) {
            return DataProviderFactory.getDataProvider().getSite();
        }
        return historyAccount.getLoginSite();
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageName() {
        return this.isHistoryMode ? UTConstant.PageName.UT_PAGE_HISTORY_LOGIN : UTConstant.PageName.UT_PAGE_FIRST_LOGIN;
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageSpm() {
        return UTConstant.PageName.F_HISTORY_LOGIN;
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void initAccountEditText(String str) {
        if (this.mAccountET != null && TextUtils.isEmpty(getAccountName()) && !TextUtils.isEmpty(str)) {
            this.mAccountET.setText(str);
        }
    }

    /* access modifiers changed from: protected */
    public void initAccountWatcher() {
        this.mTextWatcherAccount = new TextWatcher() {
            /* class com.ali.user.mobile.login.ui.AliUserLoginFragment.AnonymousClass2 */

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AliUserLoginFragment.this.beforeAccountChange();
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AliUserLoginFragment.this.mAccountClearBtn != null) {
                    if (charSequence == null || charSequence.length() == 0) {
                        if (AliUserLoginFragment.this.mAccountClearBtn.getVisibility() != 8) {
                            AliUserLoginFragment.this.mAccountClearBtn.setVisibility(8);
                        }
                    } else if (AliUserLoginFragment.this.mAccountClearBtn.getVisibility() != 0 && AliUserLoginFragment.this.mAccountClearBtn.isEnabled()) {
                        AliUserLoginFragment.this.mAccountClearBtn.setVisibility(0);
                    }
                }
                AliUserLoginFragment.this.checkSignInable();
            }
        };
    }

    /* access modifiers changed from: protected */
    public void initMode() {
        if (this.isForceNormalMode || DataProviderFactory.getDataProvider().getMaxHistoryAccount() == 0) {
            this.isHistoryMode = false;
            if (TextUtils.isEmpty(this.mCurrentAccount)) {
                switchMode(this.isHistoryMode, null);
            } else {
                this.mAccountET.setText(this.mCurrentAccount);
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
            this.mPreviousChecked = arguments.getBoolean("check");
            String str = (String) arguments.get(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
            arguments.putString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, "");
            if (!TextUtils.isEmpty(str)) {
                LoginParam loginParam2 = (LoginParam) JSON.parseObject(str, LoginParam.class);
                this.loginParam = loginParam2;
                if (loginParam2 != null) {
                    this.mSource = loginParam2.source;
                }
            }
            this.isForceNormalMode = arguments.getBoolean(LoginConstant.FORCE_NORMAL_MODE);
            this.mCurrentAccount = arguments.getString(LoginConstant.ACCOUNT);
        }
        this.mUserLoginPresenter = new UserLoginPresenter(this, this.loginParam);
        this.mRegionPresenter = new RegionPresenter(this);
        this.mFaceLoginPresenter = new FaceLoginPresenter(this, this.loginParam);
        this.mBioPresenter = new BioPresenter(this, this.loginParam);
    }

    /* access modifiers changed from: protected */
    public void initRegionInfo() {
        String str;
        if (this.mRegionTV != null && DataProviderFactory.getDataProvider().enableMobilePwdLogin()) {
            this.mRegionTV.setVisibility(0);
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
                LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
                if (loginApprearanceExtensions == null || loginApprearanceExtensions.needCountryModule()) {
                    this.mRegionTV.setVisibility(0);
                    this.mRegionTV.setText(this.mRegionInfo.code);
                } else {
                    this.mRegionTV.setVisibility(8);
                }
            }
            adjustMobileETMaxLength();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        LoginApprearanceExtensions loginApprearanceExtensions;
        super.initViews(view);
        initTextWatcher();
        this.mLoginLL = (LinearLayout) view.findViewById(R.id.aliuser_user_login_ll);
        EditText editText = (EditText) view.findViewById(R.id.aliuser_login_account_et);
        this.mAccountET = editText;
        if (editText != null) {
            editText.setSingleLine();
        }
        this.mAccountClearBtn = view.findViewById(R.id.aliuser_login_account_clear_iv);
        this.mHistoryLoginLL = (LinearLayout) view.findViewById(R.id.aliuser_login_history_ll);
        this.mFirstLoginLL = (LinearLayout) view.findViewById(R.id.aliuser_login_normal_ll);
        this.mAccountTV = (TextView) view.findViewById(R.id.aliuser_login_account_tv);
        EditText editText2 = this.mAccountET;
        if (editText2 != null) {
            editText2.addTextChangedListener(this.mTextWatcherAccount);
            this.mAccountET.setTypeface(Typeface.SANS_SERIF);
        }
        EditText editText3 = (EditText) view.findViewById(R.id.aliuser_login_password_et);
        this.mPasswordET = editText3;
        if (editText3 != null) {
            editText3.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.mPasswordET.addTextChangedListener(this.mTextWatcherPassword);
            this.mPasswordET.setTypeface(Typeface.SANS_SERIF);
        }
        this.mPasswordClearBtn = view.findViewById(R.id.aliuser_login_password_clear_iv);
        Button button = (Button) view.findViewById(R.id.aliuser_login_login_btn);
        this.mLoginBtn = button;
        if (button != null) {
            button.setEnabled(false);
        }
        TextView textView = (TextView) view.findViewById(R.id.aliuser_login_forgot_password_tv);
        this.mForgetPasswordTV = textView;
        if (textView != null) {
            BooleanOrangeResult needFindPassword = DataProviderFactory.getOrangeConfig().needFindPassword();
            if (needFindPassword.orangeExist && !needFindPassword.value) {
                this.mForgetPasswordTV.setVisibility(8);
            }
        }
        this.mShowPasswordIV = (ImageView) view.findViewById(R.id.aliuser_login_show_password_btn);
        this.mRegionTV = (TextView) view.findViewById(R.id.aliuser_region_tv);
        initRegionInfo();
        this.mLoginBtnLL = (LinearLayout) view.findViewById(R.id.aliuser_login_login_btn_ll);
        TextView textView2 = (TextView) view.findViewById(R.id.aliuser_reg_tv);
        this.mRegTV = textView2;
        if (textView2 == null || (loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions) == null || !loginApprearanceExtensions.needRegister()) {
            TextView textView3 = this.mRegTV;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        } else {
            this.mRegTV.setVisibility(0);
        }
        this.mSwitchSmsLoginBtn = (TextView) view.findViewById(R.id.aliuser_login_switch_smslogin);
        try {
            this.mSwitchMoreLoginBtn = (TextView) view.findViewById(R.id.aliuser_login_switch_more_login);
            this.mSwitchFaceLoginBtn = (TextView) view.findViewById(R.id.aliuser_login_switch_face_login);
        } catch (Throwable unused) {
        }
        ImageView imageView = this.mShowPasswordIV;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        setOnClickListener(this.mLoginBtn, this.mForgetPasswordTV, this.mRegionTV, this.mAccountClearBtn, this.mPasswordClearBtn, this.mRegTV, this.mSwitchSmsLoginBtn, this.mSwitchMoreLoginBtn, this.mSwitchFaceLoginBtn);
        this.mUserLoginPresenter.onStart();
        this.mRegionPresenter.onStart();
        initMode();
        showPushLogoutAlertIfHas();
        if (!LoginSwitch.getSwitch(LoginSwitch.OPEN_LOGIN_PAGE_WHEN_IS_LOGIN, "false")) {
            BroadCastHelper.sendLocalBroadCast(new Intent(LoginResActions.LOGIN_OPEN_ACTION));
        }
        if (this.needAdaptElder) {
            ElderUtil.scaleTextSize(this.mProtocolTV, this.mRegTV, this.mAccountTV, this.mSwitchFaceLoginBtn, this.mSwitchMoreLoginBtn, this.mSwitchSmsLoginBtn, this.mLoginBtn, this.mForgetPasswordTV, this.mAccountET, this.mPasswordET);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public boolean isHistoryMode() {
        return this.isHistoryMode;
    }

    /* access modifiers changed from: protected */
    public boolean isMobileValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^1[0-9]{10}$");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        TextView textView;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1 || i != 2001) {
            this.mUserLoginPresenter.onActivityResult(i, i2, intent);
        } else if (intent != null) {
            RegionInfo regionInfo = (RegionInfo) intent.getParcelableExtra(RegistConstants.REGION_INFO);
            this.mRegionInfo = regionInfo;
            if (regionInfo != null && (textView = this.mRegionTV) != null) {
                textView.setText(regionInfo.code);
                adjustMobileETMaxLength();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onClearAccountBtnClickAction() {
        if (DataProviderFactory.getDataProvider().isShowHistoryFragment() || TextUtils.isEmpty(this.mAccountET.getText()) || this.mAccountET.isEnabled()) {
            this.mAccountET.getEditableText().clear();
            this.mAccountET.setEnabled(true);
            return;
        }
        onDeleteAccount();
        this.mAccountET.setEnabled(true);
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.aliuser_login_login_btn) {
            addCheckAction(LoginClickAction.ACTION_LOGIN);
        } else if (id == R.id.aliuser_login_forgot_password_tv) {
            addControl("Button-ForgetPwd");
            onForgetPasswordAction();
        } else if (id == R.id.aliuser_login_account_clear_iv) {
            onClearAccountBtnClickAction();
        } else if (id == R.id.aliuser_login_password_clear_iv) {
            this.mPasswordET.getEditableText().clear();
        } else if (id == R.id.aliuser_login_show_password_btn) {
            int selectionEnd = this.mPasswordET.getSelectionEnd();
            if (view.getTag() == null || !((Boolean) view.getTag()).booleanValue()) {
                this.mPasswordET.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                this.mShowPasswordIV.setImageResource(R.drawable.aliuser_ic_visibility);
                this.mShowPasswordIV.setContentDescription(getString(R.string.aliuser_assist_password_show));
                view.setTag(Boolean.TRUE);
                addControl("Button-ShowPwd");
            } else {
                this.mPasswordET.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.mShowPasswordIV.setImageResource(R.drawable.aliuser_ic_visibility_off);
                this.mShowPasswordIV.setContentDescription(getString(R.string.aliuser_assist_password_hide));
                view.setTag(Boolean.FALSE);
                addControl("Button-HidePwd");
            }
            if (selectionEnd > 0) {
                this.mPasswordET.setSelection(selectionEnd);
            }
            this.mPasswordET.postInvalidate();
        } else if (id == R.id.aliuser_login_switch_smslogin) {
            addControl(UTConstans.Controls.UT_CHOOSE_OTHER_SMS);
            switchToSmsLogin();
        } else if (id == R.id.aliuser_login_switch_face_login) {
            addCheckAction(LoginClickAction.ACTION_FACE);
        } else if (id == R.id.aliuser_login_switch_more_login) {
            addControl("Button-ChooseMoreLogin");
            showMoreLoginBottomMenu();
        } else if (id == R.id.aliuser_region_tv) {
            addControl("Button-Region");
            if (DataProviderFactory.getDataProvider().useRegionFragment()) {
                applyRegion();
                return;
            }
            Intent intent = new Intent(this.mAttachedActivity, AliUserRegisterChoiceRegionActivity.class);
            intent.putExtra("from_login", true);
            this.mAttachedActivity.startActivityForResult(intent, 2001);
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
        UserLoginPresenter userLoginPresenter = this.mUserLoginPresenter;
        if (userLoginPresenter != null) {
            userLoginPresenter.onDestory();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        EditText editText = this.mAccountET;
        if (editText != null) {
            editText.removeTextChangedListener(this.mTextWatcherAccount);
        }
        EditText editText2 = this.mPasswordET;
        if (editText2 != null) {
            editText2.removeTextChangedListener(this.mTextWatcherPassword);
        }
        super.onDestroyView();
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void onForgetPasswordAction() {
        HistoryAccount historyAccount;
        String accountName = getAccountName();
        UserLoginPresenter userLoginPresenter = this.mUserLoginPresenter;
        String str = (userLoginPresenter == null || userLoginPresenter.getLoginParam() == null) ? "" : this.mUserLoginPresenter.mLoginParam.source;
        if (!this.isHistoryMode || (historyAccount = this.mUserLoginActivity.mHistoryAccount) == null) {
            this.mUserLoginPresenter.fetchUrlAndToWebView(this.mAttachedActivity, accountName, LoginType.LocalLoginType.RETRIVE_PWD_LOGIN, str);
        } else if (historyAccount.alipayHid != 0) {
            alert("", this.mAttachedActivity.getResources().getString(R.string.aliuser_alipay_findpwd), this.mAttachedActivity.getResources().getString(R.string.aliuser_confirm), new DialogInterface.OnClickListener() {
                /* class com.ali.user.mobile.login.ui.AliUserLoginFragment.AnonymousClass5 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    ((BaseFragment) AliUserLoginFragment.this).mActivityHelper.dismissAlertDialog();
                }
            }, null, null);
        } else if (TextUtils.isEmpty(historyAccount.tokenKey) || getLoginSite() != 0) {
            this.mUserLoginPresenter.fetchUrlAndToWebView(this.mAttachedActivity, accountName, LoginType.LocalLoginType.RETRIVE_PWD_LOGIN, str);
        } else {
            this.mUserLoginPresenter.fetchUrlAndToWebViewWithUserId(this.mAttachedActivity, accountName, this.mUserLoginActivity.mHistoryAccount.userId, str);
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.base.BaseView
    public void onGetRegion(List<RegionInfo> list) {
        if (isActive()) {
            RegionDialogFragment regionDialogFragment = new RegionDialogFragment();
            regionDialogFragment.setList(list);
            regionDialogFragment.setRegionListener(new RegionListener() {
                /* class com.ali.user.mobile.login.ui.AliUserLoginFragment.AnonymousClass6 */

                @Override // com.ali.user.mobile.register.ui.RegionListener
                public void onClick(RegionInfo regionInfo) {
                    AliUserLoginFragment aliUserLoginFragment = AliUserLoginFragment.this;
                    aliUserLoginFragment.mRegionInfo = regionInfo;
                    if (regionInfo != null) {
                        aliUserLoginFragment.mRegionTV.setText(regionInfo.code);
                        AliUserLoginFragment.this.adjustMobileETMaxLength();
                    }
                }
            });
            regionDialogFragment.setCurrentRegion(this.mRegionInfo);
            regionDialogFragment.setupAdapter(getActivity());
            regionDialogFragment.show(getActivity().getSupportFragmentManager(), "UserRegionDialog");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void onLoginAction() {
        LoginFrom.setCurrentLoginFrom("4");
        this.mActiveLogin = true;
        this.mCurrentAccount = getAccountName();
        this.mCurrentPassword = this.mPasswordET.getText().toString().trim();
        if (TextUtils.isEmpty(this.mCurrentAccount)) {
            showErrorMessage(R.string.aliuser_sign_in_account_hint);
        } else if (TextUtils.isEmpty(this.mCurrentPassword)) {
            showErrorMessage(R.string.aliuser_sign_in_please_enter_password);
        } else {
            ActivityUIHelper activityUIHelper = this.mActivityHelper;
            if (activityUIHelper != null) {
                activityUIHelper.hideInputMethod();
            }
            this.mUserLoginPresenter.buildLoginParam(this.mCurrentAccount, this.mCurrentPassword);
            this.mUserLoginPresenter.getLoginParam().traceId = ApiReferer.generateTraceId(LoginType.LocalLoginType.PWD_LOGIN, getPageName());
            this.mUserLoginPresenter.getLoginParam().loginSourceType = LoginType.LocalLoginType.PWD_LOGIN;
            this.mUserLoginPresenter.getLoginParam().loginSourcePage = getPageName();
            this.mUserLoginPresenter.getLoginParam().loginSourceSpm = getPageSpm();
            if (this.mUserLoginActivity != null) {
                this.mUserLoginPresenter.getLoginParam().alipayInstalled = this.mUserLoginActivity.mAlipayInstall;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("sdkTraceId", this.mUserLoginPresenter.getLoginParam().traceId + "");
            hashMap.put("spm", getPageSpm());
            UserTrackAdapter.control(getPageName(), getPageSpm(), UTConstant.CustomEvent.UT_LOGIN_ACTION, "", LoginType.LocalLoginType.PWD_LOGIN, hashMap);
            if (!LoginSwitch.isInABTestRegion("api", 10000)) {
                Properties properties = new Properties();
                properties.setProperty("sdkTraceId", this.mUserLoginPresenter.getLoginParam().traceId + "");
                properties.setProperty("monitor", "T");
                properties.setProperty("site", getLoginSite() + "");
                properties.setProperty("loginId", this.mCurrentAccount + "");
                UserTrackAdapter.sendUT(getPageName(), UTConstant.CustomEvent.UT_SINGLE_LOGIN_COMMIT, "", LoginType.LocalLoginType.PWD_LOGIN, properties);
            }
            this.mUserLoginPresenter.login();
        }
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.UserLoginView
    public void onPwdError() {
    }

    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public void setLoginAccountInfo(String str) {
        this.mAccountET.setText(str);
    }

    public void setSnsToken(String str) {
        this.isInBindMode = true;
        UserLoginPresenter userLoginPresenter = this.mUserLoginPresenter;
        if (userLoginPresenter != null) {
            userLoginPresenter.setSnsToken(str);
        }
    }

    /* access modifiers changed from: protected */
    public void showErrorMessage(int i) {
        toast(getString(i), 0);
    }

    @Override // com.ali.user.mobile.login.ui.UserLoginView
    public void showFindPasswordAlert(LoginParam loginParam2, RpcResponse<LoginReturnData> rpcResponse) {
        showFindPasswordAlert(loginParam2, rpcResponse, this.mUserLoginPresenter, this.mPasswordET, this.mShowPasswordIV);
    }

    /* access modifiers changed from: protected */
    public void showMoreLoginBottomMenu() {
        if (isActive()) {
            BottomMenuFragment bottomMenuFragment = getBottomMenuFragment();
            ArrayList arrayList = new ArrayList();
            addFingeritem(bottomMenuFragment, arrayList);
            if (this.smsLoginEnable) {
                MenuItem menuItem = new MenuItem();
                menuItem.setText(getString(R.string.aliuser_login_sms_login));
                menuItem.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem) {
                    /* class com.ali.user.mobile.login.ui.AliUserLoginFragment.AnonymousClass3 */

                    @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                    public void onClickMenuItem(View view, MenuItem menuItem) {
                        if (AliUserLoginFragment.this.isActive()) {
                            AliUserLoginFragment.this.addControl(UTConstans.Controls.UT_CHOOSE_OTHER_SMS);
                            AliUserLoginFragment.this.switchToSmsLogin();
                        }
                    }
                });
                arrayList.add(menuItem);
            }
            if (this.faceLoginEnable) {
                MenuItem menuItem2 = new MenuItem();
                menuItem2.setText(getString(R.string.aliuser_scan_login_text));
                menuItem2.setMenuItemOnClickListener(new MenuItemOnClickListener(bottomMenuFragment, menuItem2) {
                    /* class com.ali.user.mobile.login.ui.AliUserLoginFragment.AnonymousClass4 */

                    @Override // com.ali.user.mobile.ui.widget.MenuItemOnClickListener
                    public void onClickMenuItem(View view, MenuItem menuItem) {
                        if (AliUserLoginFragment.this.isActive()) {
                            AliUserLoginFragment.this.onCheckLogin(LoginClickAction.ACTION_FACE);
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
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void switchAccount() {
        Intent intent = new Intent();
        intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
        UserLoginPresenter userLoginPresenter = this.mUserLoginPresenter;
        if (!(userLoginPresenter == null || userLoginPresenter.getLoginParam() == null)) {
            LoginParam loginParam2 = new LoginParam();
            loginParam2.source = this.mUserLoginPresenter.getLoginParam().source;
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam2));
        }
        CheckBox checkBox = this.mProtocolCB;
        if (checkBox != null) {
            intent.putExtra("check", checkBox.isChecked());
        }
        UserLoginActivity userLoginActivity = this.mUserLoginActivity;
        if (userLoginActivity != null) {
            userLoginActivity.gotoPwdLoginFragment(intent);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c5 A[Catch:{ all -> 0x015c }] */
    @Override // com.ali.user.mobile.login.ui.BaseLoginFragment
    public void switchMode(boolean z, HistoryAccount historyAccount) {
        UserLoginActivity userLoginActivity;
        EditText editText;
        LoginApprearanceExtensions loginApprearanceExtensions;
        TextView textView;
        if (z) {
            try {
                this.mFirstLoginLL.setVisibility(8);
                this.mHistoryLoginLL.setVisibility(0);
                if (historyAccount != null && !TextUtils.isEmpty(historyAccount.loginPhone)) {
                    if (historyAccount.alipayHid != 0) {
                        this.smsLoginEnable = false;
                    } else if (DataProviderFactory.getDataProvider().supportMobileLogin()) {
                        this.smsLoginEnable = true;
                    }
                }
                if (DataProviderFactory.getDataProvider().supportFaceLogin()) {
                    UserLoginActivity userLoginActivity2 = this.mUserLoginActivity;
                    if (userLoginActivity2.isFaceLoginEnvEnable || userLoginActivity2.isFaceLoginActivate) {
                        this.faceLoginEnable = true;
                    }
                }
                boolean isFingerEnable = isFingerEnable(historyAccount);
                this.fingerLoginEnable = isFingerEnable;
                if (!isFingerEnable) {
                    boolean z2 = this.smsLoginEnable;
                    if (!z2 || !this.faceLoginEnable) {
                        if (z2) {
                            this.mSwitchSmsLoginBtn.setVisibility(0);
                            this.mSwitchMoreLoginBtn.setVisibility(8);
                            this.mSwitchFaceLoginBtn.setVisibility(8);
                            ((RelativeLayout.LayoutParams) this.mSwitchSmsLoginBtn.getLayoutParams()).addRule(14, -1);
                        } else if (this.faceLoginEnable) {
                            this.mSwitchSmsLoginBtn.setVisibility(8);
                            this.mSwitchMoreLoginBtn.setVisibility(8);
                            this.mSwitchFaceLoginBtn.setVisibility(0);
                            ((RelativeLayout.LayoutParams) this.mSwitchFaceLoginBtn.getLayoutParams()).addRule(14, -1);
                        } else {
                            this.mSwitchSmsLoginBtn.setVisibility(8);
                            this.mSwitchMoreLoginBtn.setVisibility(8);
                            this.mSwitchFaceLoginBtn.setVisibility(8);
                        }
                        textView = this.mRegTV;
                        if (textView != null) {
                            textView.setVisibility(8);
                        }
                    }
                }
                this.mSwitchSmsLoginBtn.setVisibility(8);
                this.mSwitchMoreLoginBtn.setVisibility(0);
                this.mSwitchFaceLoginBtn.setVisibility(8);
                ((RelativeLayout.LayoutParams) this.mSwitchMoreLoginBtn.getLayoutParams()).addRule(14, -1);
                textView = this.mRegTV;
                if (textView != null) {
                }
            } catch (Throwable unused) {
                return;
            }
        } else {
            this.mFirstLoginLL.setVisibility(0);
            this.mHistoryLoginLL.setVisibility(8);
            if (DataProviderFactory.getDataProvider().supportMobileLogin()) {
                this.mSwitchSmsLoginBtn.setVisibility(0);
                ((RelativeLayout.LayoutParams) this.mSwitchSmsLoginBtn.getLayoutParams()).addRule(9);
            } else {
                this.mSwitchSmsLoginBtn.setVisibility(8);
            }
            this.mSwitchMoreLoginBtn.setVisibility(8);
            this.mSwitchFaceLoginBtn.setVisibility(8);
            if (this.mRegTV == null || (loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions) == null || !loginApprearanceExtensions.needRegister()) {
                TextView textView2 = this.mRegTV;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            } else {
                this.mRegTV.setVisibility(0);
            }
            if (!(DataProviderFactory.getDataProvider().isShowHistoryFragment() || (userLoginActivity = this.mUserLoginActivity) == null || (editText = this.mAccountET) == null)) {
                HistoryAccount historyAccount2 = userLoginActivity.mHistoryAccount;
                if (historyAccount2 == null || historyAccount2.hasPwd != 1) {
                    editText.setText("");
                    this.mAccountET.setEnabled(true);
                    this.mAccountET.requestFocus();
                } else {
                    editText.setText(historyAccount2.userInputName);
                    this.mAccountET.setEnabled(false);
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
            String str = historyAccount.userInputName;
            this.mCurrentSelectedAccount = str;
            String dataMasking = StringUtil.dataMasking(str);
            if (!TextUtils.isEmpty(dataMasking)) {
                this.mAccountTV.setText(dataMasking);
                updateAvatar(historyAccount.headImg);
                switchMode(this.isHistoryMode, historyAccount);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void switchToSmsLogin() {
        EditText editText;
        Intent intent = new Intent();
        intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, !this.isHistoryMode);
        if (!this.isHistoryMode && (editText = this.mAccountET) != null) {
            String obj = editText.getText().toString();
            if (isMobileValid(obj)) {
                intent.putExtra(LoginConstant.ACCOUNT, obj);
            }
        }
        CheckBox checkBox = this.mProtocolCB;
        if (checkBox != null) {
            intent.putExtra("check", checkBox.isChecked());
        }
        UserLoginPresenter userLoginPresenter = this.mUserLoginPresenter;
        if (!(userLoginPresenter == null || userLoginPresenter.getLoginParam() == null)) {
            LoginParam loginParam2 = new LoginParam();
            loginParam2.source = this.mUserLoginPresenter.getLoginParam().source;
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam2));
        }
        this.mUserLoginActivity.gotoMobileLoginFragment(intent);
    }
}
