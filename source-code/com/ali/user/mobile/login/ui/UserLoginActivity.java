package com.ali.user.mobile.login.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.ali.user.mobile.app.constant.FragmentConstant;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.BooleanOrangeResult;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.base.ui.BaseFragment;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.filter.LoginFilterCallback;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.action.LoginResActions;
import com.ali.user.mobile.login.model.AppLaunchInfo;
import com.ali.user.mobile.login.model.AppLaunchInfoResponseData;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.login.presenter.RecommendLoginPresenter;
import com.ali.user.mobile.login.service.impl.UserLoginServiceImpl;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.LoginType;
import com.ali.user.mobile.model.TokenType;
import com.ali.user.mobile.rpc.HistoryAccount;
import com.ali.user.mobile.rpc.LoginHistory;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.safe.AES;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.FaceService;
import com.ali.user.mobile.service.FingerprintService;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.utils.Constants;
import com.ali.user.mobile.utils.SharedPreferencesUtil;
import com.ali.user.mobile.utils.UTConstans;
import com.ali.user.mobile.verify.VerifyApi;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.constants.LoginStatus;
import com.taobao.login4android.log.LoginTLogAdapter;
import com.taobao.login4android.session.SessionManager;
import com.taobao.login4android.utils.ReflectionHelper;
import com.taobao.statistic.TBS;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import tb.jl1;

/* compiled from: Taobao */
public class UserLoginActivity extends BaseActivity {
    public static final String NUMBER = "number";
    public static final String NUM_PROTOCOL_NAME = "protocolName";
    public static final String NUM_PROTOCOL_URL = "protocolURL";
    private static final String TAG = "login.UserLoginActivity";
    protected AppLaunchInfoResponseData fireAppLaunchRes;
    public boolean hadReadHistory = false;
    public boolean isFaceLoginActivate;
    public boolean isFaceLoginEnvEnable;
    private boolean isOpenMobileLoginPage;
    private boolean isOpenUserLoginPage;
    public boolean mAlipayInstall = false;
    public String mBiometricToken;
    protected String mCurrentFragmentTag = FragmentConstant.PWD_LOGIN_FRAGMENT_TAG;
    protected FragmentManager mFragmentManager;
    public HistoryAccount mHistoryAccount;
    public boolean mOpenGuide;
    public boolean mShowRegTV;
    protected String mSource;
    public boolean mUserOpenFaceLogin = false;
    protected long startOpenTime;
    protected long startTime;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class LoginPreCheckTask extends AsyncTask<Object, Void, LoginHistory> {
        private WeakReference<UserLoginActivity> activityReference;
        private Intent mIntent;

        LoginPreCheckTask(UserLoginActivity userLoginActivity, Intent intent) {
            this.activityReference = new WeakReference<>(userLoginActivity);
            this.mIntent = intent;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            UserLoginActivity userLoginActivity = this.activityReference.get();
            if (userLoginActivity != null) {
                userLoginActivity.isFinishing();
            }
        }

        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public LoginHistory doInBackground(Object... objArr) {
            UserLoginActivity userLoginActivity = this.activityReference.get();
            LoginHistory loginHistory = null;
            if (userLoginActivity != null && !userLoginActivity.isFinishing()) {
                if (DataProviderFactory.getDataProvider().getMaxHistoryAccount() > 0) {
                    loginHistory = userLoginActivity.getLoginHistory(this.mIntent);
                }
                userLoginActivity.startOpenTime = System.currentTimeMillis();
                if (loginHistory != null) {
                    try {
                        if (loginHistory.accountHistory != null) {
                            userLoginActivity.checkScanFaceLoginAvailable();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                userLoginActivity.checkGuidePageAvailable();
            }
            return loginHistory;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(LoginHistory loginHistory) {
            UserLoginActivity userLoginActivity = this.activityReference.get();
            if (userLoginActivity != null && !userLoginActivity.isFinishing()) {
                userLoginActivity.openFragmentByIntent(this.mIntent);
            }
        }
    }

    /* compiled from: Taobao */
    public static class NewLoginPreCheckTask extends AsyncTask<Object, Void, LoginHistory> {
        private WeakReference<UserLoginActivity> activityReference;
        private Intent mIntent;

        NewLoginPreCheckTask(UserLoginActivity userLoginActivity, Intent intent) {
            this.activityReference = new WeakReference<>(userLoginActivity);
            this.mIntent = intent;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            UserLoginActivity userLoginActivity = this.activityReference.get();
            if (userLoginActivity != null && !userLoginActivity.isFinishing()) {
                userLoginActivity.showProgress("");
            }
        }

        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public LoginHistory doInBackground(Object... objArr) {
            List<HistoryAccount> list;
            UserLoginActivity userLoginActivity = this.activityReference.get();
            if (userLoginActivity == null || userLoginActivity.isFinishing()) {
                return null;
            }
            LoginHistory loginHistory = userLoginActivity.getLoginHistory(this.mIntent);
            userLoginActivity.startOpenTime = System.currentTimeMillis();
            try {
                Class<?> cls = Class.forName("com.taobao.login4android.activity.auth.AlipayAuth");
                userLoginActivity.mAlipayInstall = ((Boolean) ReflectionHelper.invokeMethod(cls, cls.getDeclaredMethod("isSupportAlipay", Activity.class), userLoginActivity)).booleanValue();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!LoginSwitch.isInABTestRegion(LoginSwitch.NEW_USER_CALL_APP_LAUNCH, 10000) || !(loginHistory == null || (list = loginHistory.accountHistory) == null || list.size() == 0)) {
                userLoginActivity.getOpenPageStrategy(this.mIntent);
                return loginHistory;
            }
            TLogAdapter.e(UserLoginActivity.TAG, "new user do not call app launch.");
            return loginHistory;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(LoginHistory loginHistory) {
            UserLoginActivity userLoginActivity = this.activityReference.get();
            if (userLoginActivity != null && !userLoginActivity.isFinishing()) {
                userLoginActivity.dismissProgressDialog();
                boolean z = false;
                try {
                    z = this.mIntent.getBooleanExtra(LoginConstant.FORCE_NORMAL_MODE, false);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (z || !userLoginActivity.openFragmentByAppLaunch(this.mIntent)) {
                    userLoginActivity.openFragmentByIntent(this.mIntent);
                }
            }
        }
    }

    public UserLoginActivity() {
        boolean z = true;
        this.mShowRegTV = true;
        if (!LoginStatus.enableSsoAlways && !DataProviderFactory.getDataProvider().getAppInfoFromServer()) {
            z = false;
        }
        this.mOpenGuide = z;
        this.isFaceLoginEnvEnable = false;
        this.isFaceLoginActivate = false;
        this.isOpenMobileLoginPage = false;
        this.isOpenUserLoginPage = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void checkScanFaceLoginAvailable() {
        boolean z = false;
        this.isFaceLoginActivate = false;
        this.isFaceLoginEnvEnable = false;
        if (!(ServiceFactory.getService(FaceService.class) == null || this.mHistoryAccount == null || !this.isFaceLoginActivate)) {
            z = true;
        }
        this.mUserOpenFaceLogin = z;
    }

    private boolean getAuthCheck() {
        if (!LoginSwitch.isInABTestRegion(LoginSwitch.YUNYINGSHANG_CACHE, -1) || ServiceFactory.getService(NumberAuthService.class) == null) {
            return true;
        }
        boolean checkAuth = ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).checkAuth();
        Properties properties = new Properties();
        properties.put("result", Boolean.valueOf(checkAuth));
        UserTrackAdapter.sendUT("checkAuth", properties);
        return checkAuth;
    }

    public static Intent getCallingIntent(Context context, String str, boolean z, boolean z2) {
        Class<?> userLoginActivity = AliUserLogin.mAppreanceExtentions.getUserLoginActivity();
        if (userLoginActivity == null) {
            userLoginActivity = UserLoginActivity.class;
        }
        Intent intent = new Intent(context, userLoginActivity);
        intent.putExtra(LoginConstant.LAUNCH_PASS_GUIDE_FRAGMENT, z);
        intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, str);
        intent.putExtra(LoginConstant.LAUNCH_SNS_TO_SMS_FRAGMENT, z2);
        return intent;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private LoginHistory getLoginHistory(Intent intent) {
        LoginParam loginParam;
        LoginHistory loginHistory;
        List<HistoryAccount> list;
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
                if (!TextUtils.isEmpty(stringExtra)) {
                    loginParam = (LoginParam) JSON.parseObject(stringExtra, LoginParam.class);
                    System.currentTimeMillis();
                    loginHistory = SecurityGuardManagerWraper.getLoginHistory();
                    this.hadReadHistory = true;
                    if (loginHistory != null || (list = loginHistory.accountHistory) == null || list.size() <= 0) {
                        this.mHistoryAccount = null;
                    } else {
                        if (loginParam != null) {
                            long j = loginParam.havanaId;
                            if (j > 0) {
                                this.mHistoryAccount = SecurityGuardManagerWraper.findHistoryAccount(j);
                            }
                        }
                        int i = loginHistory.index;
                        if (i < 0 || i >= loginHistory.accountHistory.size()) {
                            i = loginHistory.accountHistory.size() - 1;
                        }
                        this.mHistoryAccount = loginHistory.accountHistory.get(i);
                    }
                    HistoryAccount historyAccount = this.mHistoryAccount;
                    if (historyAccount != null && !TextUtils.isEmpty(historyAccount.biometricId)) {
                        this.mBiometricToken = SecurityGuardManagerWraper.getFingerValue(this.mHistoryAccount.biometricId);
                    }
                    return loginHistory;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        loginParam = null;
        System.currentTimeMillis();
        loginHistory = SecurityGuardManagerWraper.getLoginHistory();
        this.hadReadHistory = true;
        if (loginHistory != null) {
        }
        this.mHistoryAccount = null;
        HistoryAccount historyAccount2 = this.mHistoryAccount;
        this.mBiometricToken = SecurityGuardManagerWraper.getFingerValue(this.mHistoryAccount.biometricId);
        return loginHistory;
    }

    private void gotoGuideFragment(Intent intent, LoginApprearanceExtensions loginApprearanceExtensions) {
        try {
            addFragment(intent, (Fragment) loginApprearanceExtensions.getFullyCustomizeGuideFragment().newInstance(), FragmentConstant.GUIDE_FRAGMENT_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void openFragmentByIntent(Intent intent) {
        boolean z;
        boolean z2;
        boolean z3;
        LoginApprearanceExtensions loginApprearanceExtensions;
        HistoryAccount historyAccount;
        Throwable th;
        String str = "";
        try {
            z3 = intent.getBooleanExtra(LoginConstant.FORCE_NORMAL_MODE, false);
            try {
                z2 = intent.getBooleanExtra(LoginConstant.FORCE_NOT_FACE, false);
                try {
                    z = intent.getBooleanExtra(LoginConstant.LAUNCH_PASS_GUIDE_FRAGMENT, false);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                z2 = false;
                try {
                    th.printStackTrace();
                    z = false;
                    loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
                    BooleanOrangeResult supportGuidePage = DataProviderFactory.getOrangeConfig().supportGuidePage();
                    gotoGuideFragment(intent, loginApprearanceExtensions);
                    return;
                } catch (Throwable th4) {
                    th4.printStackTrace();
                    return;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            z3 = false;
            z2 = false;
            th.printStackTrace();
            z = false;
            loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            BooleanOrangeResult supportGuidePage2 = DataProviderFactory.getOrangeConfig().supportGuidePage();
            gotoGuideFragment(intent, loginApprearanceExtensions);
            return;
        }
        loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (!(loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizeGuideFragment() == null || !this.mOpenGuide)) {
            BooleanOrangeResult supportGuidePage22 = DataProviderFactory.getOrangeConfig().supportGuidePage();
            if (intent != null && !z && (!supportGuidePage22.orangeExist || supportGuidePage22.value)) {
                gotoGuideFragment(intent, loginApprearanceExtensions);
                return;
            }
        }
        String str2 = (String) SharedPreferencesUtil.getData(getApplicationContext(), "login_type", str);
        if (!z3) {
            try {
                if (getFingerFragment() != null && ServiceFactory.getService(FingerprintService.class) != null && ((FingerprintService) ServiceFactory.getService(FingerprintService.class)).isFingerprintAvailable() && (historyAccount = this.mHistoryAccount) != null && !TextUtils.isEmpty(historyAccount.biometricId) && new AES().checkValid() && !TextUtils.isEmpty(this.mBiometricToken) && getFingerFragment() != null) {
                    gotoFingerPage(intent);
                    return;
                }
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
        }
        try {
            str = intent.getStringExtra("number");
        } catch (Throwable th7) {
            th7.printStackTrace();
        }
        if (!TextUtils.isEmpty(str) || loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizedOneKeyLoginFragment() == null || !getAuthCheck() || (intent != null && intent.getBooleanExtra(LoginConstant.LAUNCH_SNS_TO_SMS_FRAGMENT, false))) {
            if (z3 || this.mHistoryAccount == null || DataProviderFactory.getDataProvider().isRecommendPageFirst()) {
                if (z3 && this.mHistoryAccount == null && this.mAlipayInstall && getAlipayFragment() != null) {
                    goAlipayFragment(intent);
                    return;
                } else if (DataProviderFactory.getDataProvider().supportRecommendLogin() && switchToRecommendLogin(intent)) {
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            TLogAdapter.e(TAG, "open login activity delta = " + (currentTimeMillis - this.startOpenTime));
            if (TextUtils.equals(TokenType.FACE_LOGIN, str2) && DataProviderFactory.getDataProvider().supportFaceLogin() && this.mHistoryAccount != null && intent != null && !z2 && !z3 && loginApprearanceExtensions != null && getFaceLoginFragment(loginApprearanceExtensions) != null) {
                this.isFaceLoginEnvEnable = true;
                goFaceFragment(intent);
                return;
            } else if (intent != null && intent.getBooleanExtra(LoginConstant.LAUNCH_SNS_TO_SMS_FRAGMENT, false)) {
                gotoSNS_to_SMSFragment(intent);
                return;
            } else if (!TextUtils.equals(LoginType.LocalLoginType.LOGIN_TYPE_ALIPAY, str2) || z3 || !this.mAlipayInstall || getAlipayHistoryFragment() == null) {
                goPwdOrSMSFragment(intent);
                return;
            } else {
                goAlipayHistory(intent);
                return;
            }
        } else {
            gotoOneKeyLoginFragment(intent);
            return;
        }
        this.mBiometricToken = str;
        VerifyApi.invalidAll();
        str = intent.getStringExtra("number");
        if (!TextUtils.isEmpty(str)) {
        }
        if (z3) {
        }
    }

    private void sendCancelBroadcast() {
        BroadCastHelper.sendLocalBroadCast(new Intent(Constants.RESET_LOGIN_STATUS));
    }

    public void addFragment(Intent intent, Fragment fragment, String str) {
        hideAllFragment();
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null) {
            this.mFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
        this.mFragmentManager.beginTransaction().add(R.id.aliuser_content_frame, fragment, str).commitAllowingStateLoss();
        this.mFragmentManager.beginTransaction().show(fragment).commitAllowingStateLoss();
        this.mCurrentFragmentTag = str;
    }

    /* access modifiers changed from: protected */
    public void cacheData(String str) {
        SharedPreferences sharedPreferences = DataProviderFactory.getApplicationContext().getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("data", JSON.toJSONString(this.fireAppLaunchRes));
            edit.putLong("expire_time", (System.currentTimeMillis() / 1000) + ((long) this.fireAppLaunchRes.returnValue.expireTime));
            edit.apply();
        }
    }

    /* access modifiers changed from: protected */
    public boolean cacheOneKeyAndCompareSuccess(Intent intent) {
        String str = "";
        if (intent != null) {
            try {
                str = intent.getStringExtra("number");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Map<String, String> authInfoMap = ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap();
            if (authInfoMap != null) {
                if (authInfoMap.size() != 0) {
                    String str2 = authInfoMap.get("number");
                    if (!TextUtils.isEmpty(str2) && str2.length() > 7) {
                        String substring = str2.substring(str2.lastIndexOf(jl1.MUL) + 1);
                        if (TextUtils.isEmpty(this.mHistoryAccount.loginPhone) || !this.mHistoryAccount.loginPhone.endsWith(substring)) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void callPageDisAppear() {
        UserTrackAdapter.pageDisAppear(this);
    }

    /* access modifiers changed from: protected */
    public void checkGuidePageAvailable() {
        T t;
        try {
            if (DataProviderFactory.getDataProvider().getAppInfoFromServer() && LoginStatus.askServerForGuide) {
                RpcResponse appLaunchInfo = UserLoginServiceImpl.getInstance().getAppLaunchInfo(new LoginParam());
                if (appLaunchInfo == null || (t = appLaunchInfo.returnValue) == null) {
                    this.mOpenGuide = false;
                    return;
                }
                this.mOpenGuide = t.fromOversea;
                DataProviderFactory.getDataProvider().setAppInfoFromServer(this.mOpenGuide);
                LoginStatus.askServerForGuide = false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.mOpenGuide = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean compareSuccess(Intent intent, AppLaunchInfo appLaunchInfo) {
        List<String> list;
        String str = "";
        if (intent != null) {
            try {
                str = intent.getStringExtra("number");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str) && getAuthCheck() && ServiceFactory.getService(NumberAuthService.class) != null) {
            Map<String, String> authInfoMap = ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap();
            if (authInfoMap == null || !authInfoMap.containsKey("number")) {
                UserTrackAdapter.sendUT(UTConstans.CustomEvent.UT_SIM_NO_CACHE);
            } else {
                String str2 = authInfoMap.get("number");
                if (appLaunchInfo == null || (list = appLaunchInfo.deviceMaskMobiles) == null || list.size() == 0 || appLaunchInfo.deviceMaskMobiles.contains(str2)) {
                    return true;
                }
                UserTrackAdapter.sendUT(UTConstans.CustomEvent.UT_SIM_NOT_IN_COMPARE_LIST);
                return false;
            }
        }
        return false;
    }

    public void doFinishThing() {
        BroadCastHelper.sendLocalBroadCast(new Intent(LoginResActions.LOGIN_CANCEL_ACTION));
        try {
            if (!isFinishing()) {
                UserTrackAdapter.sendUT(getPageName(), "handle_login_close_page");
                finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void finish() {
        super.finish();
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions != null && loginApprearanceExtensions.getActivityExitAnimation() > 0) {
            overridePendingTransition(0, AliUserLogin.mAppreanceExtentions.getActivityExitAnimation());
        }
    }

    public void finishCurrentAndNotify() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null && !fragmentManager.isDestroyed()) {
            if (!this.supportTaobaoOrAlipay || TextUtils.equals(this.mCurrentFragmentTag, FragmentConstant.GUIDE_FRAGMENT_TAG) || !this.mOpenGuide) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(this.mCurrentFragmentTag);
                if ((findFragmentByTag instanceof BaseFragment) && ((BaseFragment) findFragmentByTag).onBackPressed()) {
                    return;
                }
            } else {
                gotoGuideFragment(null, AliUserLogin.mAppreanceExtentions);
                return;
            }
        }
        doFinishThing();
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public void finishWhenLoginSuccess() {
        if (AliUserLogin.getLoginFilter(SessionManager.getInstance(getApplicationContext()).getLoginSite()) != null) {
            AliUserLogin.getLoginFilter(SessionManager.getInstance(getApplicationContext()).getLoginSite()).onLoginSuccess(this, new LoginFilterCallback() {
                /* class com.ali.user.mobile.login.ui.UserLoginActivity.AnonymousClass1 */

                @Override // com.ali.user.mobile.filter.LoginFilterCallback
                public void onFail(int i, Map<String, String> map) {
                    UserLoginActivity.this.runOnUiThread(new Runnable() {
                        /* class com.ali.user.mobile.login.ui.UserLoginActivity.AnonymousClass1.AnonymousClass2 */

                        public void run() {
                            UserLoginActivity.this.finish();
                        }
                    });
                }

                @Override // com.ali.user.mobile.filter.LoginFilterCallback
                public void onSuccess() {
                    UserLoginActivity.this.runOnUiThread(new Runnable() {
                        /* class com.ali.user.mobile.login.ui.UserLoginActivity.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            UserLoginActivity.this.finish();
                        }
                    });
                }
            });
        } else {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void fragmentOnActivityResult(int i, int i2, Intent intent) {
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(this.mCurrentFragmentTag);
        if (findFragmentByTag != null && findFragmentByTag.isVisible()) {
            findFragmentByTag.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public Class<?> getAlipayFragment() {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions == null) {
            return null;
        }
        return loginApprearanceExtensions.getFullyCustomizedAlipayLoginFragment();
    }

    /* access modifiers changed from: protected */
    public Class<?> getAlipayHistoryFragment() {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions == null) {
            return null;
        }
        return loginApprearanceExtensions.getFullyCustomizedAlipayHistoryFragment();
    }

    /* access modifiers changed from: protected */
    public Class<?> getFaceLoginFragment(LoginApprearanceExtensions loginApprearanceExtensions) {
        return loginApprearanceExtensions.getFullyCustomizedFaceLoginFragment();
    }

    /* access modifiers changed from: protected */
    public Class<?> getFingerFragment() {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions == null) {
            return null;
        }
        return loginApprearanceExtensions.getFingerFragment();
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public int getLayoutContent() {
        return R.layout.aliuser_activity_frame_content;
    }

    /* access modifiers changed from: protected */
    public Fragment getMobileFragment(LoginApprearanceExtensions loginApprearanceExtensions) throws IllegalAccessException, InstantiationException {
        if (loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizeMobileLoginFragment() == null) {
            return new AliUserMobileLoginFragment();
        }
        return (AliUserMobileLoginFragment) loginApprearanceExtensions.getFullyCustomizeMobileLoginFragment().newInstance();
    }

    /* access modifiers changed from: protected */
    public Class<?> getOneKeyLoginFragment(LoginApprearanceExtensions loginApprearanceExtensions) {
        return loginApprearanceExtensions.getFullyCustomizedOneKeyLoginFragment();
    }

    /* access modifiers changed from: protected */
    public void getOpenPageStrategy(Intent intent) {
        String str;
        if (this.mHistoryAccount != null) {
            str = LoginConstant.FILE_NAME_HISTORY;
        } else {
            str = LoginConstant.FILE_NAME;
        }
        readHistoryCache(str);
        if (this.fireAppLaunchRes == null && LoginSwitch.getSwitch(LoginSwitch.FIRE_APP_LAUNCH, "true")) {
            try {
                this.fireAppLaunchRes = RecommendLoginPresenter.fireAppLaunchRequest(new LoginParam(), this.mHistoryAccount);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            AppLaunchInfoResponseData appLaunchInfoResponseData = this.fireAppLaunchRes;
            if (appLaunchInfoResponseData != null && appLaunchInfoResponseData.returnValue != null) {
                cacheData(str);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getPageName() {
        return "login";
    }

    /* access modifiers changed from: protected */
    public Properties getProperty(Intent intent) {
        Properties properties = new Properties();
        if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("scene"))) {
            properties.put("pn_scene", intent.getStringExtra("scene"));
        }
        return properties;
    }

    /* access modifiers changed from: protected */
    public Fragment getSMSVerificationFragment() throws IllegalAccessException, InstantiationException {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizedLoginSmsCodeFragment() == null) {
            return new AliUserSMSLoginVerificationFragment();
        }
        return (Fragment) loginApprearanceExtensions.getFullyCustomizedLoginSmsCodeFragment().newInstance();
    }

    /* access modifiers changed from: protected */
    public Fragment getTwoStepMobileFragment(LoginApprearanceExtensions loginApprearanceExtensions) throws IllegalAccessException, InstantiationException {
        if (loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizeTwoStepMobileLoginFragment() == null) {
            return new AliUserTwoStepMobileLoginFragment();
        }
        return (Fragment) loginApprearanceExtensions.getFullyCustomizeTwoStepMobileLoginFragment().newInstance();
    }

    /* access modifiers changed from: protected */
    public Fragment getUserLoginFragment() throws IllegalAccessException, InstantiationException {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizeLoginFragment() == null) {
            return new AliUserLoginFragment();
        }
        return (AliUserLoginFragment) loginApprearanceExtensions.getFullyCustomizeLoginFragment().newInstance();
    }

    /* access modifiers changed from: protected */
    public void goAlipayFragment(Intent intent) {
        try {
            Fragment fragment = (Fragment) getAlipayFragment().newInstance();
            if (intent != null) {
                fragment.setArguments(intent.getExtras());
            }
            addFragment(intent, fragment, FragmentConstant.ALIPAY_FRAGMENT_TAG);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void goAlipayHistory(Intent intent) {
        try {
            Fragment fragment = (Fragment) getAlipayHistoryFragment().newInstance();
            if (intent != null) {
                fragment.setArguments(intent.getExtras());
            }
            addFragment(intent, fragment, FragmentConstant.ALIPAY_HISTORY_FRAGMENT_TAG);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void goFaceFragment(Intent intent) {
        try {
            Fragment fragment = (Fragment) getFaceLoginFragment(AliUserLogin.mAppreanceExtentions).newInstance();
            if (intent != null) {
                fragment.setArguments(intent.getExtras());
            }
            addFragment(intent, fragment, FragmentConstant.FACE_LOGIN_FRAGMENT_TAG);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a5  */
    public boolean goFragmentByType(String str, Intent intent, AppLaunchInfo appLaunchInfo) {
        boolean z;
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        try {
            z = intent.getBooleanExtra(LoginConstant.FORCE_NORMAL_MODE, false);
        } catch (Throwable th) {
            th.printStackTrace();
            z = false;
        }
        if (z && switchToRecommendLogin(intent)) {
            return true;
        }
        Properties property = getProperty(intent);
        if (this.mHistoryAccount != null) {
            try {
                if ("biometric".equals(str) && getFingerFragment() != null && ServiceFactory.getService(FingerprintService.class) != null && ((FingerprintService) ServiceFactory.getService(FingerprintService.class)).isFingerprintAvailable() && new AES().checkValid()) {
                    if (TextUtils.isEmpty(this.mBiometricToken)) {
                        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "EmptyBiometricToken");
                    }
                    HistoryAccount historyAccount = this.mHistoryAccount;
                    if (historyAccount == null || TextUtils.isEmpty(historyAccount.biometricId)) {
                        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "EmptyBiometricId");
                    } else if (!TextUtils.isEmpty(this.mBiometricToken) && getFingerFragment() != null) {
                        gotoFingerPage(intent);
                        return true;
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if ("sim".equals(str)) {
                UserTrackAdapter.sendUT(UTConstans.CustomEvent.UT_RECOMMEND_HISTORY_SIM, property);
                if (cacheOneKeyAndCompareSuccess(intent)) {
                    UserTrackAdapter.sendUT(UTConstans.CustomEvent.UT_RECOMMEND_HISTORY_OPEN, property);
                    gotoHistorySmsLoginPage(intent);
                    return true;
                }
            }
            if (!"alipay".equals(str) && getAlipayHistoryFragment() != null && this.mAlipayInstall) {
                goAlipayHistory(intent);
                return true;
            } else if (!BaseCellItem.TYPE_FACE.equals(str) && this.mUserOpenFaceLogin && DataProviderFactory.getDataProvider().supportFaceLogin() && !z) {
                goFaceFragment(intent);
                return true;
            } else if (!"pwd".equals(str) && DataProviderFactory.getDataProvider().supportPwdLogin() && this.mHistoryAccount.hasPwd == 1) {
                gotoPwdLoginFragment(intent);
                return true;
            } else if ("sms".equals(str) && DataProviderFactory.getDataProvider().supportMobileLogin() && !TextUtils.isEmpty(this.mHistoryAccount.loginPhone)) {
                gotoMobileLoginFragment(intent);
                return true;
            }
        } else {
            if ("sim".equals(str)) {
                UserTrackAdapter.sendUT(UTConstans.CustomEvent.UT_RECOMMEND_SIM, property);
                if (!(loginApprearanceExtensions == null || getOneKeyLoginFragment(loginApprearanceExtensions) == null || !compareSuccess(intent, appLaunchInfo))) {
                    UserTrackAdapter.sendUT(UTConstans.CustomEvent.UT_RECOMMEND_SIM_OPEN, property);
                    gotoOneKeyLoginFragment(intent);
                    return true;
                }
            }
            if ("alipay".equals(str) && getAlipayFragment() != null && this.mAlipayInstall) {
                goAlipayFragment(intent);
                return true;
            } else if ("recommend".equals(str)) {
                switchToRecommendLogin(intent);
                return true;
            }
        }
        return false;
        th.printStackTrace();
        this.mBiometricToken = "";
        VerifyApi.invalidAll();
        if ("sim".equals(str)) {
        }
        if (!"alipay".equals(str)) {
        }
        if (!BaseCellItem.TYPE_FACE.equals(str)) {
        }
        if (!"pwd".equals(str)) {
        }
        gotoMobileLoginFragment(intent);
        return true;
    }

    public void goPwdOrSMSFragment(Intent intent) {
        TLogAdapter.d(TAG, "goPwdOrSMSFragment() called with: intent = [" + intent + jl1.ARRAY_END_STR);
        String str = (String) SharedPreferencesUtil.getData(getApplicationContext(), "login_type", "");
        if (!DataProviderFactory.getDataProvider().isShowHistoryFragment() || this.mHistoryAccount == null) {
            if (this.isOpenMobileLoginPage && DataProviderFactory.getDataProvider().supportMobileLogin()) {
                gotoMobileLoginFragment(intent);
            } else if (this.isOpenUserLoginPage && DataProviderFactory.getDataProvider().supportPwdLogin()) {
                gotoPwdLoginFragment(intent);
            } else if (DataProviderFactory.getDataProvider().alwaysPwdLoginPriority() && DataProviderFactory.getDataProvider().supportPwdLogin()) {
                gotoPwdLoginFragment(intent);
            } else if (DataProviderFactory.getDataProvider().alwaysSMSLoginPriority() && DataProviderFactory.getDataProvider().supportMobileLogin()) {
                gotoMobileLoginFragment(intent);
            } else if (TextUtils.equals(str, LoginType.ServerLoginType.PasswordLogin.getType()) && DataProviderFactory.getDataProvider().supportPwdLogin()) {
                gotoPwdLoginFragment(intent);
            } else if (TextUtils.equals(str, LoginType.ServerLoginType.SMSLogin.getType()) && DataProviderFactory.getDataProvider().supportMobileLogin()) {
                gotoMobileLoginFragment(intent);
            } else if (DataProviderFactory.getDataProvider().isSmsLoginPriority() && DataProviderFactory.getDataProvider().supportMobileLogin()) {
                gotoMobileLoginFragment(intent);
            } else if (!TextUtils.isEmpty(SessionManager.getInstance(getApplicationContext()).getOldUserId()) && DataProviderFactory.getDataProvider().supportPwdLogin()) {
                gotoPwdLoginFragment(intent);
            } else if (!DataProviderFactory.getDataProvider().isSmsLoginPriority() || !DataProviderFactory.getDataProvider().supportMobileLogin()) {
                gotoPwdLoginFragment(intent);
            } else {
                gotoMobileLoginFragment(intent);
            }
        } else if (this.isOpenMobileLoginPage && DataProviderFactory.getDataProvider().supportMobileLogin()) {
            if (TextUtils.isEmpty(this.mHistoryAccount.loginPhone)) {
                intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
            }
            gotoHistorySmsLoginPage(intent);
        } else if ((this.isOpenUserLoginPage || DataProviderFactory.getDataProvider().alwaysPwdLoginPriority()) && DataProviderFactory.getDataProvider().supportPwdLogin()) {
            if (this.mHistoryAccount.hasPwd != 1) {
                intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
            }
            gotoPwdLoginFragment(intent);
        } else if (DataProviderFactory.getDataProvider().alwaysSMSLoginPriority() && DataProviderFactory.getDataProvider().supportMobileLogin()) {
            if (TextUtils.isEmpty(this.mHistoryAccount.loginPhone)) {
                intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
            }
            gotoMobileLoginFragment(intent);
        } else if (TextUtils.equals(this.mHistoryAccount.loginType, LoginType.ServerLoginType.SMSLogin.getType()) && DataProviderFactory.getDataProvider().supportMobileLogin()) {
            if (TextUtils.isEmpty(this.mHistoryAccount.loginPhone)) {
                intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
            }
            gotoHistorySmsLoginPage(intent);
        } else if (TextUtils.equals(this.mHistoryAccount.loginType, LoginType.ServerLoginType.PasswordLogin.getType()) && DataProviderFactory.getDataProvider().supportPwdLogin()) {
            if (this.mHistoryAccount.hasPwd != 1) {
                intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
            }
            gotoPwdLoginFragment(intent);
        } else if (DataProviderFactory.getDataProvider().isSmsLoginPriority() && !TextUtils.isEmpty(this.mHistoryAccount.loginPhone) && DataProviderFactory.getDataProvider().supportMobileLogin()) {
            gotoMobileLoginFragment(intent);
        } else if ((this.mHistoryAccount.hasPwd != 0 || !DataProviderFactory.getDataProvider().supportMobileLogin()) && (!DataProviderFactory.getDataProvider().supportMobileLogin() || DataProviderFactory.getDataProvider().supportPwdLogin())) {
            if (this.mHistoryAccount.hasPwd != 1) {
                intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
            }
            gotoPwdLoginFragment(intent);
        } else {
            if (TextUtils.isEmpty(this.mHistoryAccount.loginPhone)) {
                intent.putExtra(LoginConstant.FORCE_NORMAL_MODE, true);
            }
            gotoMobileLoginFragment(intent);
        }
    }

    public void goToSMSVerificationPage(Intent intent) {
        try {
            Fragment sMSVerificationFragment = getSMSVerificationFragment();
            sMSVerificationFragment.setArguments(intent.getExtras());
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(FragmentConstant.LOGIN_SMSCODE_FRAGMENT_TAG);
            if (findFragmentByTag != null) {
                this.mFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
            }
            this.mCurrentFragmentTag = FragmentConstant.LOGIN_SMSCODE_FRAGMENT_TAG;
            this.mFragmentManager.beginTransaction().replace(R.id.aliuser_content_frame, sMSVerificationFragment, FragmentConstant.LOGIN_SMSCODE_FRAGMENT_TAG).addToBackStack(null).commitAllowingStateLoss();
            this.mFragmentManager.beginTransaction().show(sMSVerificationFragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Fragment gotoAuthCheckFragmentFromGuide(Intent intent) {
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(FragmentConstant.GUIDE_FRAGMENT_TAG);
        if (findFragmentByTag != null && findFragmentByTag.isVisible()) {
            this.mFragmentManager.beginTransaction().hide(findFragmentByTag).commitAllowingStateLoss();
        }
        gotoCheckAuthFragment(intent);
        this.mFragmentManager.executePendingTransactions();
        return this.mFragmentManager.findFragmentByTag(FragmentConstant.PWD_AUTH_WITH_FIXED_NICK);
    }

    public void gotoCheckAuthFragment(Intent intent) {
        String str = "";
        try {
            str = intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Fragment fragment = null;
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (!(loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizedAuthCheckFragment() == null)) {
            fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedAuthFragment().newInstance();
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, str);
        }
        if (fragment != null) {
            fragment.setArguments(bundle);
            addFragment(intent, fragment, FragmentConstant.PWD_AUTH_WITH_FIXED_NICK);
        }
    }

    public void gotoFastRegOrLoginBind(Intent intent) {
        String str = "";
        try {
            str = intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Fragment fragment = null;
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (!(loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizedAuthCheckFragment() == null)) {
            fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedSNSChooseFragment().newInstance();
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, str);
        }
        if (fragment != null) {
            fragment.setArguments(bundle);
            addFragment(intent, fragment, FragmentConstant.SNS_FAST_REG_OR_LOGIN_BIND);
        }
    }

    /* access modifiers changed from: protected */
    public void gotoFingerPage(Intent intent) {
        try {
            Fragment fragment = (Fragment) getFingerFragment().newInstance();
            if (intent != null) {
                fragment.setArguments(intent.getExtras());
            }
            addFragment(intent, fragment, FragmentConstant.FINGER_FRAGMENT);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void gotoHistorySmsLoginPage(Intent intent) {
        LoginApprearanceExtensions loginApprearanceExtensions;
        try {
            if (!(!LoginSwitch.isInABTestRegion(LoginSwitch.ONEKEY_LOGIN_HISTORY_PERCENT, 10000) || (loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions) == null || loginApprearanceExtensions.getFullyCustomizedOneKeyLoginHistoryFragment() == null || ServiceFactory.getService(NumberAuthService.class) == null || TextUtils.isEmpty(this.mHistoryAccount.loginPhone))) {
                String str = ((NumberAuthService) ServiceFactory.getService(NumberAuthService.class)).getAuthInfoMap().get("number");
                if (!TextUtils.isEmpty(str) && str.length() > 7) {
                    if (this.mHistoryAccount.loginPhone.endsWith(str.substring(str.lastIndexOf(jl1.MUL) + 1))) {
                        Fragment fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedOneKeyLoginHistoryFragment().newInstance();
                        fragment.setArguments(intent.getExtras());
                        UserTrackAdapter.sendUT("history_sim", getProperty(intent));
                        addFragment(intent, fragment, FragmentConstant.ONE_KEY_LOGIN_HISTORY_FRAGMENT_TAG);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        gotoMobileLoginFragment(intent);
    }

    public AliUserLoginFragment gotoLoginFragmentFromGuide(Intent intent) {
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(FragmentConstant.GUIDE_FRAGMENT_TAG);
        if (findFragmentByTag != null && findFragmentByTag.isVisible()) {
            this.mFragmentManager.beginTransaction().hide(findFragmentByTag).commitAllowingStateLoss();
        }
        gotoPwdLoginFragment(intent);
        this.mFragmentManager.executePendingTransactions();
        Fragment findFragmentByTag2 = this.mFragmentManager.findFragmentByTag("aliuser_login");
        if (findFragmentByTag2 instanceof AliUserLoginFragment) {
            return (AliUserLoginFragment) findFragmentByTag2;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[Catch:{ Exception -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b1 A[Catch:{ Exception -> 0x00c7 }] */
    public void gotoMobileLoginFragment(Intent intent) {
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        boolean z4;
        Fragment fragment;
        boolean z5;
        Throwable th;
        String str2;
        Throwable th2;
        String str3 = "";
        try {
            z3 = intent.getBooleanExtra(LoginConstant.FORCE_NORMAL_MODE, false);
            try {
                str = intent.getStringExtra(LoginConstant.ACCOUNT);
            } catch (Throwable th3) {
                th = th3;
                str2 = str3;
                z2 = false;
                z = false;
                try {
                    th.printStackTrace();
                    str = str3;
                    str3 = str2;
                    z4 = false;
                    if (z3) {
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            try {
                str3 = intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
                z2 = intent.getBooleanExtra(UIBaseConstants.UT_FROM_REGIST_KEY, false);
                try {
                    z = intent.getBooleanExtra("autoSendSms", false);
                    try {
                        z4 = intent.getBooleanExtra("check", false);
                    } catch (Throwable th4) {
                        th2 = th4;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    z = false;
                    th = th2;
                    str2 = str3;
                    str3 = str;
                    th.printStackTrace();
                    str = str3;
                    str3 = str2;
                    z4 = false;
                    if (z3) {
                    }
                }
            } catch (Throwable th6) {
                th2 = th6;
                z2 = false;
                z = false;
                th = th2;
                str2 = str3;
                str3 = str;
                th.printStackTrace();
                str = str3;
                str3 = str2;
                z4 = false;
                if (z3) {
                }
            }
        } catch (Throwable th7) {
            th = th7;
            str2 = str3;
            z3 = false;
            z2 = false;
            z = false;
            th.printStackTrace();
            str = str3;
            str3 = str2;
            z4 = false;
            if (z3) {
            }
        }
        if ((z3 && this.mHistoryAccount != null) || !DataProviderFactory.getDataProvider().supportRecommendLogin() || !switchToRecommendLogin(intent)) {
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (DataProviderFactory.getDataProvider().supportTwoStepMobileLogin()) {
                fragment = getTwoStepMobileFragment(loginApprearanceExtensions);
            } else {
                fragment = getMobileFragment(loginApprearanceExtensions);
            }
            Bundle bundle = new Bundle();
            if (!z3) {
                if (DataProviderFactory.getDataProvider().isShowHistoryFragment()) {
                    z5 = false;
                    HistoryAccount historyAccount = this.mHistoryAccount;
                    boolean z6 = (historyAccount != null || !TextUtils.isEmpty(historyAccount.loginPhone)) ? z5 : true;
                    bundle.putBoolean("check", z4);
                    bundle.putBoolean(LoginConstant.FORCE_NORMAL_MODE, z6);
                    bundle.putString(LoginConstant.ACCOUNT, str);
                    bundle.putBoolean("autoSendSms", z);
                    if (!TextUtils.isEmpty(str3)) {
                        bundle.putBoolean(UIBaseConstants.UT_FROM_REGIST_KEY, z2);
                        bundle.putLong(LoginConstant.START_TIME, this.startTime);
                        bundle.putString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, str3);
                    }
                    fragment.setArguments(bundle);
                    addFragment(intent, fragment, FragmentConstant.MOBILE_LOGIN_FRAGMENT_TAG);
                }
            }
            z5 = true;
            HistoryAccount historyAccount2 = this.mHistoryAccount;
            if (historyAccount2 != null) {
            }
            bundle.putBoolean("check", z4);
            bundle.putBoolean(LoginConstant.FORCE_NORMAL_MODE, z6);
            bundle.putString(LoginConstant.ACCOUNT, str);
            bundle.putBoolean("autoSendSms", z);
            if (!TextUtils.isEmpty(str3)) {
            }
            fragment.setArguments(bundle);
            addFragment(intent, fragment, FragmentConstant.MOBILE_LOGIN_FRAGMENT_TAG);
        }
    }

    public void gotoOneKeyLoginFragment(Intent intent) {
        try {
            Fragment fragment = (Fragment) getOneKeyLoginFragment(AliUserLogin.mAppreanceExtentions).newInstance();
            fragment.setArguments(intent.getExtras());
            UserTrackAdapter.sendUT("sim", getProperty(intent));
            addFragment(intent, fragment, FragmentConstant.ONE_KEY_LOGIN_FRAGMENT_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[Catch:{ Exception -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009c A[Catch:{ Exception -> 0x00b2 }] */
    public void gotoPwdLoginFragment(Intent intent) {
        int i;
        boolean z;
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        Throwable th;
        String str2;
        Throwable th2;
        String str3 = "";
        try {
            z2 = intent.getBooleanExtra(LoginConstant.FORCE_NORMAL_MODE, false);
            try {
                str = intent.getStringExtra(LoginConstant.ACCOUNT);
            } catch (Throwable th3) {
                th = th3;
                str2 = str3;
                z = false;
                i = 0;
                try {
                    th.printStackTrace();
                    str = str3;
                    str3 = str2;
                    z3 = false;
                    if (z2) {
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            try {
                str3 = intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
                z = intent.getBooleanExtra(UIBaseConstants.UT_FROM_REGIST_KEY, false);
                try {
                    i = intent.getIntExtra("defaultTab", 0);
                    try {
                        z3 = intent.getBooleanExtra("check", false);
                    } catch (Throwable th4) {
                        th2 = th4;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    i = 0;
                    th = th2;
                    str2 = str3;
                    str3 = str;
                    th.printStackTrace();
                    str = str3;
                    str3 = str2;
                    z3 = false;
                    if (z2) {
                    }
                }
            } catch (Throwable th6) {
                th2 = th6;
                z = false;
                i = 0;
                th = th2;
                str2 = str3;
                str3 = str;
                th.printStackTrace();
                str = str3;
                str3 = str2;
                z3 = false;
                if (z2) {
                }
            }
        } catch (Throwable th7) {
            th = th7;
            str2 = str3;
            z2 = false;
            z = false;
            i = 0;
            th.printStackTrace();
            str = str3;
            str3 = str2;
            z3 = false;
            if (z2) {
            }
        }
        if ((z2 && this.mHistoryAccount != null) || !DataProviderFactory.getDataProvider().supportRecommendLogin() || !switchToRecommendLogin(intent)) {
            Fragment userLoginFragment = getUserLoginFragment();
            Bundle bundle = new Bundle();
            if (!z2) {
                if (DataProviderFactory.getDataProvider().isShowHistoryFragment()) {
                    z4 = false;
                    HistoryAccount historyAccount = this.mHistoryAccount;
                    boolean z5 = (historyAccount == null && historyAccount.hasPwd == 0) ? true : z4;
                    bundle.putBoolean("check", z3);
                    bundle.putBoolean(LoginConstant.FORCE_NORMAL_MODE, z5);
                    bundle.putInt("defaultTab", i);
                    bundle.putString(LoginConstant.ACCOUNT, str);
                    if (!TextUtils.isEmpty(str3)) {
                        bundle.putBoolean(UIBaseConstants.UT_FROM_REGIST_KEY, z);
                        bundle.putLong(LoginConstant.START_TIME, this.startTime);
                        bundle.putString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, str3);
                    }
                    userLoginFragment.setArguments(bundle);
                    addFragment(intent, userLoginFragment, FragmentConstant.PWD_LOGIN_FRAGMENT_TAG);
                }
            }
            z4 = true;
            HistoryAccount historyAccount2 = this.mHistoryAccount;
            if (historyAccount2 == null) {
            }
            bundle.putBoolean("check", z3);
            bundle.putBoolean(LoginConstant.FORCE_NORMAL_MODE, z5);
            bundle.putInt("defaultTab", i);
            bundle.putString(LoginConstant.ACCOUNT, str);
            if (!TextUtils.isEmpty(str3)) {
            }
            userLoginFragment.setArguments(bundle);
            addFragment(intent, userLoginFragment, FragmentConstant.PWD_LOGIN_FRAGMENT_TAG);
        }
    }

    public void gotoSNS_to_SMSFragment(Intent intent) {
        Fragment fragment = null;
        try {
            Bundle bundle = new Bundle();
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            boolean z = false;
            if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("number")) && !TextUtils.isEmpty(intent.getStringExtra("protocolName")) && !TextUtils.isEmpty("protocolURL")) {
                UserTrackAdapter.sendUT("SNS_AUTH_MASK_SUCCESS");
                TLogAdapter.d(TAG, "gotoSNS_to_SMSFragment: 支持 supportOneKey");
                z = true;
            }
            if (loginApprearanceExtensions != null && loginApprearanceExtensions.getFullyCustomizedSNSToSMSOneKeyLoginFragment() != null && z) {
                fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedSNSToSMSOneKeyLoginFragment().newInstance();
                bundle.putString("number", intent.getStringExtra("number"));
                bundle.putString("protocolName", intent.getStringExtra("protocolName"));
                bundle.putString("protocolURL", intent.getStringExtra("protocolURL"));
            } else if (!(loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizedSNSToSMSLoginFragment() == null)) {
                fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedSNSToSMSLoginFragment().newInstance();
            }
            if (fragment != null) {
                TLogAdapter.d(TAG, "gotoSNS_to_SMSFragment, fragment class: " + fragment.getClass().getName());
                bundle.putBoolean(LoginConstant.FORCE_NORMAL_MODE, true);
                if (!TextUtils.isEmpty(intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM))) {
                    bundle.putString(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM));
                }
                fragment.setArguments(bundle);
                addFragment(intent, fragment, FragmentConstant.SNS_TO_SMS_LOGIN_FRAGMENT_TAG);
                return;
            }
            TLogAdapter.e(TAG, "you must custom SNS2SMSFragment");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void hideAllFragment() {
        List<String> fragmentTagList = FragmentConstant.getFragmentTagList();
        if (fragmentTagList != null) {
            for (String str : fragmentTagList) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(str);
                if (findFragmentByTag != null) {
                    this.mFragmentManager.beginTransaction().hide(findFragmentByTag).commitAllowingStateLoss();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initParam(Intent intent) {
        LoginParam loginParam;
        this.isLoginObserver = true;
        UserTrackAdapter.skipPage(this);
        this.startTime = System.currentTimeMillis();
        if (intent != null) {
            try {
                this.isOpenMobileLoginPage = TextUtils.equals(intent.getStringExtra(UIBaseConstants.LoginPage.PAGE_LOGIN_TYPE), UIBaseConstants.LoginPage.PAGE_SMS_LOGIN);
                this.isOpenUserLoginPage = TextUtils.equals(intent.getStringExtra(UIBaseConstants.LoginPage.PAGE_LOGIN_TYPE), UIBaseConstants.LoginPage.PAGE_PWD_LOGIN);
                String stringExtra = intent.getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
                if (!TextUtils.isEmpty(stringExtra) && (loginParam = (LoginParam) JSON.parseObject(stringExtra, LoginParam.class)) != null) {
                    this.mSource = loginParam.source;
                }
            } catch (Throwable unused) {
                UserTrackAdapter.sendUT("Page_Login", "login_params_error");
            }
        }
        this.mFragmentManager = getSupportFragmentManager();
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public void initViews() {
        super.initViews();
        try {
            if (getSupportActionBar() != null) {
                LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
                if (loginApprearanceExtensions != null && !loginApprearanceExtensions.isNeedToolbar()) {
                    getSupportActionBar().hide();
                }
                getSupportActionBar().setTitle("");
                LoginApprearanceExtensions loginApprearanceExtensions2 = AliUserLogin.mAppreanceExtentions;
                if (loginApprearanceExtensions2 != null && !loginApprearanceExtensions2.isNeedLoginToolbar()) {
                    getSupportActionBar().hide();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        openFragmentByConfig(getIntent());
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public boolean isShowNavIcon() {
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        return loginApprearanceExtensions == null || loginApprearanceExtensions.needLoginBackButton();
    }

    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        fragmentOnActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        TBS.Page.buttonClicked("Button_back");
        finishCurrentAndNotify();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.ali.user.mobile.base.ui.BaseActivity
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.ali.user.mobile.base.ui.BaseActivity
    public void onCreate(Bundle bundle) {
        TLogAdapter.d(TAG, "onCreate");
        LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
        if (loginApprearanceExtensions != null && loginApprearanceExtensions.getActivityEnterAnimation() > 0) {
            overridePendingTransition(AliUserLogin.mAppreanceExtentions.getActivityEnterAnimation(), 0);
        }
        initParam(getIntent());
        UserTrackAdapter.sendUT("openLogin", getProperty(getIntent()));
        super.onCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.ali.user.mobile.base.ui.BaseActivity
    public void onDestroy() {
        try {
            sendCancelBroadcast();
            this.mFragmentManager = null;
            this.hadReadHistory = false;
            this.mHistoryAccount = null;
            super.onDestroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initParam(intent);
        openFragmentByConfig(intent);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        try {
            callPageDisAppear();
            super.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onSaveInstanceState(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        try {
            super.onStart();
        } catch (Throwable th) {
            th.printStackTrace();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        try {
            super.onStop();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public boolean openFragmentByAppLaunch(Intent intent) {
        T t;
        AppLaunchInfoResponseData appLaunchInfoResponseData = this.fireAppLaunchRes;
        if (!(appLaunchInfoResponseData == null || (t = appLaunchInfoResponseData.returnValue) == null || t.sortedRecommendLoginTypes == null)) {
            List<String> list = t.sortedRecommendLoginTypes;
            if (t.loginValidators != null) {
                this.isFaceLoginActivate = t.loginValidators.verify;
                this.isFaceLoginEnvEnable = t.loginValidators.preCheckVerify;
            }
            if (t.testValue != null) {
                this.mShowRegTV = t.testValue.isRegOpen;
            }
            if (t.userNotFound && this.mHistoryAccount != null) {
                UserTrackAdapter.sendUT("userNotFound");
                SecurityGuardManagerWraper.removeSessionModelFromFile(String.valueOf(this.mHistoryAccount.userId));
                SecurityGuardManagerWraper.removeHistoryAccount(SecurityGuardManagerWraper.findHistoryAccount(this.mHistoryAccount.userId));
                this.mHistoryAccount = null;
            }
            if (!this.fireAppLaunchRes.returnValue.biometricOpen) {
                UserTrackAdapter.sendUT("biometricOpenFalse");
                this.mBiometricToken = "";
            }
            this.mUserOpenFaceLogin = this.isFaceLoginActivate && ServiceFactory.getService(FaceService.class) != null;
            if (list != null && list.size() > 0) {
                LoginTLogAdapter.e(TAG, "recommend: " + JSON.toJSONString(list));
                try {
                    UserTrackAdapter.sendUT(getPageName(), "RecommendList", JSON.toJSONString(list), null);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                for (String str : list) {
                    if (goFragmentByType(str, intent, this.fireAppLaunchRes.returnValue)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void openFragmentByConfig(Intent intent) {
        if (LoginSwitch.getSwitch(LoginSwitch.OPEN_LOGIN_PAGE_WHEN_IS_LOGIN, "false")) {
            BroadCastHelper.sendLocalBroadCast(new Intent(LoginResActions.LOGIN_OPEN_ACTION));
        }
        if (DataProviderFactory.getDataProvider().useNewLoginStrategy()) {
            new CoordinatorWrapper().execute(new NewLoginPreCheckTask(this, intent), new Object[0]);
        } else {
            new CoordinatorWrapper().execute(new LoginPreCheckTask(this, intent), new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void readHistoryCache(String str) {
        SharedPreferences sharedPreferences = DataProviderFactory.getApplicationContext().getSharedPreferences(str, 0);
        if (System.currentTimeMillis() / 1000 < sharedPreferences.getLong("expire_time", 0)) {
            String string = sharedPreferences.getString("data", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.fireAppLaunchRes = (AppLaunchInfoResponseData) JSON.parseObject(string, AppLaunchInfoResponseData.class);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public boolean switchToRecommendLogin(Intent intent) {
        try {
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions == null || loginApprearanceExtensions.getFullyCustomizedRecommendLoginFragment() == null) {
                return false;
            }
            Fragment fragment = (Fragment) loginApprearanceExtensions.getFullyCustomizedRecommendLoginFragment().newInstance();
            fragment.setArguments(intent.getExtras());
            addFragment(intent, fragment, FragmentConstant.RECOMMEND_LOGIN_FRAGMENT_TAG);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
