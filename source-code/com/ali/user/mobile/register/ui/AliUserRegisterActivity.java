package com.ali.user.mobile.register.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.ali.user.mobile.app.constant.FragmentConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.dataprovider.StringOrangeResult;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.WebConstant;
import com.ali.user.mobile.utils.UTConstans;
import com.ali.user.mobile.webview.WebViewActivity;
import com.alibaba.security.realidentity.jsbridge.a;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.session.SessionManager;
import java.util.Properties;

/* compiled from: Taobao */
public class AliUserRegisterActivity extends BaseActivity {
    public static final String NEW_REGISTER_PERCENT = "new_register_percent";
    private Fragment mCurrentFragment;
    protected FragmentManager mFragmentManager;
    private RegistParam mRegistParam;
    private String token = "";

    private void addControl() {
        UserTrackAdapter.sendControlUT(UTConstans.PageName.UT_PAGE_REG, UTConstans.Controls.UT_BTN_BACK);
    }

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, AliUserRegisterActivity.class);
    }

    private Fragment getMobileRegisterFragment(Intent intent, LoginApprearanceExtensions loginApprearanceExtensions) throws InstantiationException, IllegalAccessException {
        Fragment fragment;
        Fragment fragment2;
        if (intent != null && TextUtils.equals(RegPageType.TWO_STEP_MOBILE_REG, intent.getStringExtra(RegistConstants.REG_PAGE_TYPE)) && loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizedTwoStepMobileRegisterFragment() != null) {
            return (Fragment) loginApprearanceExtensions.getFullyCustomizedTwoStepMobileRegisterFragment().newInstance();
        }
        Properties properties = new Properties();
        RegistParam registParam = this.mRegistParam;
        if (registParam != null && !TextUtils.isEmpty(registParam.source)) {
            properties.put("source", this.mRegistParam.source);
        }
        properties.put("newUser", Boolean.valueOf(TextUtils.isEmpty(SessionManager.getInstance(DataProviderFactory.getApplicationContext()).getOldUserId())));
        UserTrackAdapter.sendUT("toRegisterPage", properties);
        if (DataProviderFactory.getDataProvider().supportOneKeyRegister()) {
            String str = "";
            try {
                str = intent.getStringExtra("number");
                String stringExtra = intent.getStringExtra("scene");
                if (!TextUtils.isEmpty(stringExtra)) {
                    properties.setProperty("scene", stringExtra);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                if (loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizeOneKeyRegisterFragment() == null) {
                    fragment2 = new AliUserOneKeyRegisterFragment();
                } else {
                    fragment2 = (Fragment) loginApprearanceExtensions.getFullyCustomizeOneKeyRegisterFragment().newInstance();
                }
                UserTrackAdapter.sendUT("toSimRegisterPage", properties);
                return fragment2;
            }
        }
        if (!LoginSwitch.isInABTestRegion(NEW_REGISTER_PERCENT, 10000) || !DataProviderFactory.getDataProvider().supportTwoStepMobileRegister()) {
            if (loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizeMobileRegisterFragment() == null) {
                fragment = new AliUserMobileRegisterFragment();
            } else {
                fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizeMobileRegisterFragment().newInstance();
            }
        } else if (loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizedTwoStepMobileRegisterFragment() == null) {
            fragment = new AliUserTwoStepMobileRegisterFragment();
        } else {
            fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedTwoStepMobileRegisterFragment().newInstance();
        }
        UserTrackAdapter.sendUT("toSmsRegisterPage", properties);
        return fragment;
    }

    public static void goRegHelp(Activity activity) {
        String str;
        StringOrangeResult helpLink = DataProviderFactory.getOrangeConfig().helpLink();
        if (helpLink.orangeExist) {
            str = helpLink.value;
        } else if (DataProviderFactory.getDataProvider().getSite() == 3) {
            str = LoginConstant.CBU_HELP_URL;
        } else {
            str = DataProviderFactory.getDataProvider().isTaobaoApp() ? LoginConstant.TAOBAO_HELP_URL : "https://ihelp.taobao.com/pocket/visitorServicePortal.htm?from=n_registration_inputphone";
        }
        Intent intent = new Intent(activity, WebViewActivity.class);
        intent.putExtra(WebConstant.WEBURL, str);
        activity.startActivity(intent);
    }

    private void hideAllFragment() {
        for (String str : FragmentConstant.getRegFragmentTagList()) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(str);
            if (findFragmentByTag != null) {
                this.mFragmentManager.beginTransaction().hide(findFragmentByTag).commitAllowingStateLoss();
            }
        }
    }

    private void initParam(Intent intent) {
        this.mFragmentManager = getSupportFragmentManager();
        if (intent != null) {
            this.mRegistParam = (RegistParam) intent.getParcelableExtra(RegistConstants.REGISTPARAM);
        }
        String dataString = intent.getDataString();
        try {
            if (!TextUtils.isEmpty(dataString)) {
                this.token = Uri.parse(dataString).getQueryParameter(a.d);
            }
        } catch (Throwable unused) {
        }
    }

    public void addFragment(Fragment fragment, String str) {
        hideAllFragment();
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null) {
            this.mFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
        this.mCurrentFragment = fragment;
        this.mFragmentManager.beginTransaction().add(R.id.aliuser_content_frame, fragment, str).commitAllowingStateLoss();
        this.mFragmentManager.beginTransaction().show(fragment).commitAllowingStateLoss();
    }

    public void changeFragmentByConfig(Intent intent) {
        try {
            Fragment mobileRegisterFragment = getMobileRegisterFragment(intent, AliUserLogin.mAppreanceExtentions);
            if (intent != null) {
                try {
                    Bundle extras = intent.getExtras();
                    if (extras == null) {
                        extras = new Bundle();
                    }
                    if (!TextUtils.isEmpty(this.token)) {
                        extras.putString("token", this.token);
                    }
                    mobileRegisterFragment.setArguments(extras);
                } catch (Throwable unused) {
                }
            }
            addFragment(mobileRegisterFragment, FragmentConstant.REG_FRAGMENT_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finishCurrentAndNotify() {
        Fragment fragment;
        if (getSupportFragmentManager() == null || getSupportFragmentManager().isDestroyed() || (fragment = this.mCurrentFragment) == null || !((BaseFragment) fragment).onBackPressed()) {
            try {
                addControl();
                BroadCastHelper.sendLocalBroadCast(new Intent(LoginResActions.REG_CANCEL));
                finish();
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public int getLayoutContent() {
        return R.layout.aliuser_activity_frame_content;
    }

    public void gotoMobileRegFragment(Intent intent) {
        Fragment fragment;
        try {
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizeMobileRegisterFragment() == null) {
                fragment = new AliUserMobileRegisterFragment();
            } else {
                fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizeMobileRegisterFragment().newInstance();
            }
            try {
                fragment.setArguments(intent.getExtras());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            addFragment(fragment, FragmentConstant.REG_FRAGMENT_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoSmsCodeFragment(Intent intent) {
        AliUserRegisterSMSVerificationFragment aliUserRegisterSMSVerificationFragment;
        try {
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizedRegSmsCodeFragment() == null) {
                aliUserRegisterSMSVerificationFragment = new AliUserRegisterSMSVerificationFragment();
            } else {
                aliUserRegisterSMSVerificationFragment = (AliUserRegisterSMSVerificationFragment) loginApprearanceExtensions.getFullyCustomizedRegSmsCodeFragment().newInstance();
            }
            aliUserRegisterSMSVerificationFragment.setArguments(intent.getExtras());
            addFragment(aliUserRegisterSMSVerificationFragment, FragmentConstant.REG_SMSCODE_FRAGMENT_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoTwoStepMobileRegFragment(Intent intent) {
        AliUserTwoStepMobileRegisterFragment aliUserTwoStepMobileRegisterFragment;
        try {
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizedTwoStepMobileRegisterFragment() == null) {
                aliUserTwoStepMobileRegisterFragment = new AliUserTwoStepMobileRegisterFragment();
            } else {
                aliUserTwoStepMobileRegisterFragment = (AliUserTwoStepMobileRegisterFragment) loginApprearanceExtensions.getFullyCustomizedTwoStepMobileRegisterFragment().newInstance();
            }
            try {
                aliUserTwoStepMobileRegisterFragment.setArguments(intent.getExtras());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            addFragment(aliUserTwoStepMobileRegisterFragment, FragmentConstant.REG_FRAGMENT_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public void initViews() {
        try {
            if (getSupportActionBar() != null) {
                LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
                if (loginApprearanceExtensions != null && !loginApprearanceExtensions.isNeedToolbar()) {
                    getSupportActionBar().hide();
                }
                getSupportActionBar().setTitle(R.string.aliuser_signup_page_title);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        changeFragmentByConfig(getIntent());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mCurrentFragment.onActivityResult(i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        finishCurrentAndNotify();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.ali.user.mobile.base.ui.BaseActivity
    public void onCreate(Bundle bundle) {
        this.isLoginObserver = true;
        try {
            initParam(getIntent());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        UserTrackAdapter.skipPage(this);
        super.onCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.ali.user.mobile.base.ui.BaseActivity
    public void onDestroy() {
        try {
            this.mFragmentManager = null;
            super.onDestroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            initParam(intent);
            initViews();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        try {
            super.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
