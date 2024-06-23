package com.ali.user.mobile.register.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
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
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.data.model.SmsApplyResult;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.presenter.RegionPresenter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.mobile.register.model.OceanRegisterParam;
import com.ali.user.mobile.register.presenter.MobileRegisterPresenter;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.utils.CountryUtil;
import com.ali.user.mobile.utils.ElderUtil;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.ali.user.mobile.utils.ProtocolHelper;
import com.ali.user.mobile.utils.UTConstans;
import com.ali.user.mobile.webview.WebViewActivity;
import com.alibaba.fastjson.JSON;
import com.ut.mini.UTAnalytics;
import java.util.HashMap;
import java.util.Properties;

/* compiled from: Taobao */
public class AliUserTwoStepMobileRegisterFragment extends AliUserMobileRegisterFragment {
    public static final String TAG = "login.twoStepMobileReg";
    protected String mMobileNum;
    protected boolean mPreviousChecked;

    private void initParams() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mMobileNum = arguments.getString(RegistConstants.REGISTER_MOBILE_NUM);
            try {
                this.mRegionInfo = (RegionInfo) JSON.parseObject(arguments.getString(RegistConstants.REGION_INFO), RegionInfo.class);
                this.mPresenter.setSessionId(arguments.getString("session_id"));
                this.mPresenter.setCodeLength(arguments.getString(RegistConstants.REGISTER_CODE_LENGTH));
                this.mPreviousChecked = arguments.getBoolean("check");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment
    public void checkRegAble(EditText editText) {
        String mobile = getMobile();
        if (TextUtils.isEmpty(mobile) || mobile.length() < 1) {
            this.mRegBtn.setEnabled(false);
            this.mRegBtnLL.setBackgroundDrawable(null);
            return;
        }
        this.mRegBtn.setEnabled(true);
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment
    public void clearMobile() {
        this.mMobileET.getEditableText().clear();
        this.mMobileET.setEnabled(true);
        this.isVoice = false;
        this.mRegBtn.setText(getResources().getString(R.string.aliuser_agree_and_reg));
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment
    public void createPresenter() {
        this.mPresenter = new MobileRegisterPresenter(this);
        this.mRegionPresenter = new RegionPresenter(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment
    public void generateProtocol() {
        ProtocolHelper.generateProtocol(getProtocolModel(), this.mAttachedActivity, this.mProtocolTV, getPageName(), getPageSpm(), false);
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment, com.ali.user.mobile.base.ui.BaseFragment
    public int getLayoutContent() {
        return R.layout.aliuser_fragment_two_step_mobile_register;
    }

    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment, com.ali.user.mobile.register.ui.RegisterFormView, com.ali.user.mobile.base.ui.BaseFragment
    public String getPageName() {
        return UTConstans.PageName.UT_PAGE_SMS_REG;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public String getPageSpm() {
        return UTConstans.PageName.F_SMS_REG;
    }

    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment, com.ali.user.mobile.register.ui.RegisterFormView
    public String getRegType() {
        return UTConstant.Args.UT_MOBILE_REG;
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment
    public void initRegionInfo() {
        String str;
        RegionInfo regionInfo = this.mRegionInfo;
        if (regionInfo == null || TextUtils.isEmpty(regionInfo.code) || TextUtils.isEmpty(this.mRegionInfo.domain)) {
            RegionInfo currentRegion = DataProviderFactory.getDataProvider().getCurrentRegion();
            if (currentRegion == null || TextUtils.isEmpty(currentRegion.domain) || TextUtils.isEmpty(currentRegion.name) || TextUtils.isEmpty(currentRegion.code)) {
                if (currentRegion == null) {
                    str = "";
                } else {
                    str = currentRegion.domain;
                }
                currentRegion = CountryUtil.matchRegionFromLocal(getContext(), str);
            }
            this.mRegionInfo = currentRegion;
        }
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions == null || loginApprearanceExtensions.needCountryModule()) {
            RegionInfo regionInfo2 = this.mRegionInfo;
            if (regionInfo2 != null && !TextUtils.isEmpty(regionInfo2.code)) {
                this.mRegionTV.setVisibility(0);
                this.mRegionTV.setText(this.mRegionInfo.code);
                resizeMobileETPadding();
            }
        } else {
            this.mRegionTV.setVisibility(8);
        }
        adjustMobileETMaxLength();
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment, com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        try {
            ((BaseActivity) getActivity()).getSupportActionBar().setTitle("");
            ((BaseActivity) getActivity()).setNavigationCloseIcon();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        EditText editText = (EditText) view.findViewById(R.id.aliuser_register_mobile_et);
        this.mMobileET = editText;
        editText.postDelayed(new Runnable() {
            /* class com.ali.user.mobile.register.ui.AliUserTwoStepMobileRegisterFragment.AnonymousClass1 */

            public void run() {
                EditText editText;
                if (AliUserTwoStepMobileRegisterFragment.this.getContext() != null && AliUserTwoStepMobileRegisterFragment.this.isActive() && (editText = AliUserTwoStepMobileRegisterFragment.this.mMobileET) != null) {
                    editText.requestFocus();
                    AliUserTwoStepMobileRegisterFragment.this.mMobileET.requestFocusFromTouch();
                    InputMethodManager inputMethodManager = (InputMethodManager) AliUserTwoStepMobileRegisterFragment.this.getContext().getSystemService("input_method");
                    if (inputMethodManager != null) {
                        inputMethodManager.showSoftInput(AliUserTwoStepMobileRegisterFragment.this.mMobileET, 1);
                    }
                }
            }
        }, 300);
        this.mRegBtnLL = (LinearLayout) view.findViewById(R.id.aliuser_register_reg_btn_ll);
        Button button = (Button) view.findViewById(R.id.aliuser_register_reg_btn);
        this.mRegBtn = button;
        button.setOnClickListener(this);
        this.mWelcomeTV = (TextView) view.findViewById(R.id.aliuser_register_tips_tv);
        ((RelativeLayout) view.findViewById(R.id.aliuser_region_rl)).setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.aliuser_region_tv);
        this.mRegionTV = textView;
        textView.setOnClickListener(this);
        initRegionInfo();
        this.mProtocolTV = (TextView) view.findViewById(R.id.aliuser_protocol_tv);
        try {
            this.mCheckBoxSwitch = true;
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.aliuser_reg_checkbox);
            this.mProtocolCB = checkBox;
            ProtocolHelper.setCheckBox(this, checkBox, getPageName(), getPageSpm(), this.mCheckBoxSwitch, this.mPreviousChecked);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        generateProtocol();
        View findViewById = view.findViewById(R.id.aliuser_login_mobile_clear_iv);
        this.mMobileClearBtn = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        if (!TextUtils.isEmpty(this.mMobileNum)) {
            this.mMobileET.setText(this.mMobileNum);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.aliuser_reg_func_menu);
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions == null || loginApprearanceExtensions.needHelp()) {
            textView2.setVisibility(0);
            textView2.setOnClickListener(this);
        } else {
            textView2.setVisibility(8);
        }
        if (this.needAdaptElder) {
            ElderUtil.scaleTextSize(this.mMobileET, this.mRegionTV, this.mProtocolTV, this.mRegBtn, this.mWelcomeTV, textView2);
        }
    }

    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mPresenter.setSessionId("");
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public boolean onBackPressed() {
        alert(getString(R.string.aliuser_reg_retain_title), "", getString(R.string.aliuser_reg_continue), new DialogInterface.OnClickListener() {
            /* class com.ali.user.mobile.register.ui.AliUserTwoStepMobileRegisterFragment.AnonymousClass6 */

            public void onClick(DialogInterface dialogInterface, int i) {
                HashMap hashMap = new HashMap();
                hashMap.put("spm", "Sms_Reg.13987563.BackCancel.1");
                UserTrackAdapter.control(AliUserTwoStepMobileRegisterFragment.this.getPageName(), AliUserTwoStepMobileRegisterFragment.this.getPageSpm(), UTConstans.Controls.UT_REG_BACK_BUTTON_CANCEL, "", hashMap);
            }
        }, getString(R.string.aliuser_exit), new DialogInterface.OnClickListener() {
            /* class com.ali.user.mobile.register.ui.AliUserTwoStepMobileRegisterFragment.AnonymousClass7 */

            public void onClick(DialogInterface dialogInterface, int i) {
                HashMap hashMap = new HashMap();
                hashMap.put("spm", "Sms_Reg.13987563.BackButtonClick.1");
                UserTrackAdapter.control(AliUserTwoStepMobileRegisterFragment.this.getPageName(), AliUserTwoStepMobileRegisterFragment.this.getPageSpm(), UTConstans.Controls.UT_REG_BACK_BUTTON_CLICK, "", hashMap);
                if (AliUserTwoStepMobileRegisterFragment.this.getActivity() != null) {
                    AliUserTwoStepMobileRegisterFragment.this.getActivity().finish();
                }
            }
        });
        return true;
    }

    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment
    public void onClick(View view) {
        if (view.getId() == R.id.aliuser_reg_func_menu) {
            addControl(UTConstans.Controls.UT_HELP);
            openHelp();
            return;
        }
        super.onClick(view);
    }

    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment, com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initParams();
    }

    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment, androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        int i = R.id.aliuser_menu_item_help;
        if (menu.findItem(i) != null) {
            int i2 = R.id.aliuser_menu_item_more;
            if (menu.findItem(i2) != null) {
                menu.findItem(i2).setVisible(false);
                menu.findItem(i).setVisible(false);
            }
        }
    }

    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment, androidx.fragment.app.Fragment
    public void onResume() {
        UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(getActivity(), new HashMap());
        super.onResume();
    }

    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment, com.ali.user.mobile.register.ui.RegisterFormView
    public void onSMSSendFail(RpcResponse rpcResponse) {
        if (isActive()) {
            if (rpcResponse != null && rpcResponse.code == 458825) {
                UserTrackAdapter.sendUT(getPageName(), "CheckSimilarity");
                alert(rpcResponse.message, "", getString(R.string.aliuser_re_enter), new DialogInterface.OnClickListener() {
                    /* class com.ali.user.mobile.register.ui.AliUserTwoStepMobileRegisterFragment.AnonymousClass3 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        AliUserTwoStepMobileRegisterFragment.this.addControl("Button-Alert-CheckSimilarity-no");
                    }
                }, getString(R.string.aliuser_common_ok), new DialogInterface.OnClickListener() {
                    /* class com.ali.user.mobile.register.ui.AliUserTwoStepMobileRegisterFragment.AnonymousClass4 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        AliUserTwoStepMobileRegisterFragment aliUserTwoStepMobileRegisterFragment = AliUserTwoStepMobileRegisterFragment.this;
                        aliUserTwoStepMobileRegisterFragment.mobileCheckSimilarity = false;
                        aliUserTwoStepMobileRegisterFragment.addControl("Button-Alert-CheckSimilarity-yes");
                        AliUserTwoStepMobileRegisterFragment.this.sendCodeAction();
                    }
                });
            } else if (rpcResponse == null || rpcResponse.code != 458826) {
                Properties properties = new Properties();
                properties.setProperty("monitor", "T");
                String pageName = getPageName();
                String str = "";
                if (rpcResponse != null) {
                    str = rpcResponse.code + str;
                }
                UserTrackAdapter.sendUT(pageName, UTConstans.CustomEvent.UT_SMS_SEND_FAIL, str, getRegType(), properties);
                if (rpcResponse == null || rpcResponse.code == 4) {
                    toast(getString(R.string.aliuser_sever_error), 0);
                } else {
                    toast(rpcResponse.message, 0);
                }
            } else {
                toast(getResources().getString(R.string.aliuser_reg_mobile_exist), 0);
                UserTrackAdapter.sendUT(getPageName(), "RegisterBlock");
                if (getActivity() != null) {
                    LoginParam loginParam = new LoginParam();
                    loginParam.loginAccount = getMobile();
                    loginParam.callRpc = true;
                    WebViewActivity.goFistLoginPage(getActivity(), true, true, loginParam);
                }
            }
        }
    }

    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment, com.ali.user.mobile.register.ui.RegisterFormView
    public void onSendSMSSuccess(long j, SmsApplyResult smsApplyResult) {
        if (getActivity() != null) {
            Intent intent = new Intent();
            intent.putExtra(RegistConstants.REGISTER_MOBILE_NUM, getMobile());
            intent.putExtra("session_id", this.mPresenter.getSessionId());
            intent.putExtra(RegistConstants.REGISTER_CODE_LENGTH, this.mPresenter.getCodeLength());
            intent.putExtra(RegistConstants.REGISTER_TRACE_PARAM, JSON.toJSONString(this.mTraceParam));
            RegionInfo regionInfo = this.mRegionInfo;
            intent.putExtra(RegistConstants.REGION_INFO, regionInfo == null ? "" : JSON.toJSONString(regionInfo));
            if (smsApplyResult != null && !TextUtils.isEmpty(smsApplyResult.helpVideoUrl)) {
                intent.putExtra("url", smsApplyResult.helpVideoUrl);
            }
            ((AliUserRegisterActivity) getActivity()).gotoSmsCodeFragment(intent);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment
    public void openHelp() {
        AliUserRegisterActivity.goRegHelp(getBaseActivity());
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment
    public void registerAction() {
        if (!isMobileValid(getMobile())) {
            UserTrackAdapter.sendUT(getPageName(), UTConstans.CustomEvent.UT_MOBILE_INVALID);
        } else {
            OceanRegisterParam oceanRegisterParam = new OceanRegisterParam();
            this.mTraceParam = oceanRegisterParam;
            oceanRegisterParam.loginSourcePage = getPageName();
            this.mTraceParam.loginSourceSpm = getPageSpm();
            this.mTraceParam.loginSourceType = getRegType();
            this.mTraceParam.traceId = ApiReferer.generateTraceId(getRegType(), getPageName());
        }
        sendCodeAction();
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment
    public void resizeMobileETPadding() {
        this.mRegionTV.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.ali.user.mobile.register.ui.AliUserTwoStepMobileRegisterFragment.AnonymousClass5 */

            public void onGlobalLayout() {
                AliUserTwoStepMobileRegisterFragment.this.mRegionTV.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                AliUserTwoStepMobileRegisterFragment aliUserTwoStepMobileRegisterFragment = AliUserTwoStepMobileRegisterFragment.this;
                aliUserTwoStepMobileRegisterFragment.mMobileET.setPadding(aliUserTwoStepMobileRegisterFragment.mRegionTV.getWidth() + 30, AliUserTwoStepMobileRegisterFragment.this.mMobileET.getPaddingTop(), AliUserTwoStepMobileRegisterFragment.this.mRegionTV.getWidth() + 30, AliUserTwoStepMobileRegisterFragment.this.mMobileET.getPaddingBottom());
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.register.ui.AliUserMobileRegisterFragment
    public void sendCodeAction() {
        MainThreadExecutor.execute(new Runnable() {
            /* class com.ali.user.mobile.register.ui.AliUserTwoStepMobileRegisterFragment.AnonymousClass2 */

            public void run() {
                AliUserTwoStepMobileRegisterFragment aliUserTwoStepMobileRegisterFragment = AliUserTwoStepMobileRegisterFragment.this;
                aliUserTwoStepMobileRegisterFragment.mMobileStr = aliUserTwoStepMobileRegisterFragment.getMobile();
                try {
                    AliUserTwoStepMobileRegisterFragment.this.onSendSMSAction(false);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
