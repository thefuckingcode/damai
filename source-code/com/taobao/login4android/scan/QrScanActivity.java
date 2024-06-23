package com.taobao.login4android.scan;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.model.LoginConstant;
import com.taobao.login4android.sdk.R;

/* compiled from: Taobao */
public class QrScanActivity extends BaseActivity {
    public static final String FRAGMENT_LABEL = "aliuser_qrcode_confirm";
    private Fragment mFragment;
    protected FragmentManager mFragmentManager;
    public String mScene;

    private void initParam() {
        if (getIntent() != null) {
            try {
                this.mScene = getIntent().getStringExtra(LoginConstant.SCAN_SCENE);
                UserTrackAdapter.skipPage(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void openConfirm(Intent intent, LoginApprearanceExtensions loginApprearanceExtensions) {
        Fragment qrScanFragment = new QrScanFragment();
        if (!(loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomiedScanFragment() == null)) {
            try {
                qrScanFragment = (Fragment) loginApprearanceExtensions.getFullyCustomiedScanFragment().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        openFragment(intent, qrScanFragment);
    }

    private void openFragment(Intent intent, Fragment fragment) {
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(FRAGMENT_LABEL);
        if (findFragmentByTag != null) {
            this.mFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
        if (intent != null) {
            fragment.setArguments(intent.getExtras());
        }
        this.mFragment = fragment;
        this.mFragmentManager.beginTransaction().add(R.id.loginContainer, fragment, FRAGMENT_LABEL).commitAllowingStateLoss();
    }

    private void openFragmentById(Intent intent) {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (intent.getData() == null || !"youku://passport/qrlogin".equals(intent.getData().toString())) {
            openConfirm(intent, loginApprearanceExtensions);
        } else {
            openYoukuConfirm(intent, loginApprearanceExtensions);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a  */
    private void openYoukuConfirm(Intent intent, LoginApprearanceExtensions loginApprearanceExtensions) {
        Fragment fragment;
        if (!(loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizedScanYoukuFragment() == null)) {
            try {
                fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedScanYoukuFragment().newInstance();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (fragment == null) {
                openFragment(intent, fragment);
                return;
            } else {
                finish();
                return;
            }
        }
        fragment = null;
        if (fragment == null) {
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public int getLayoutContent() {
        return R.layout.user_scan_activity;
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public void initViews() {
        super.initViews();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.aliuser_scan_login_title);
        }
        openFragmentById(getIntent());
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        Fragment fragment = this.mFragment;
        if (fragment != null && fragment.isVisible()) {
            Fragment fragment2 = this.mFragment;
            if (fragment2 instanceof QrScanFragment) {
                ((QrScanFragment) fragment2).handleBack();
                return;
            }
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.ali.user.mobile.base.ui.BaseActivity
    public void onCreate(Bundle bundle) {
        this.mFragmentManager = getSupportFragmentManager();
        initParam();
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initParam();
        openFragmentById(intent);
    }
}
