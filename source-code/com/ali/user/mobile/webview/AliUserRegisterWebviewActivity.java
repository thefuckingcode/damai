package com.ali.user.mobile.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.init.Debuggable;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.register.ui.AliUserRegisterActivity;
import com.ali.user.mobile.ui.WebConstant;
import com.ali.user.mobile.utils.BundleUtil;
import com.ali.user.mobile.utils.StringUtil;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSON;
import com.uc.webview.export.WebView;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.util.Properties;

/* compiled from: Taobao */
public class AliUserRegisterWebviewActivity extends WebViewActivity {
    public static final String page = "Page_RegH5";
    public static final String spm = "a21et.b95736722";
    private String active_url = "_ap_action=registerActive";
    private String mPageFrom = "";
    private String mPageType = "";
    private Properties mUTProperties = new Properties();

    public static Intent getCallingIntent(Context context, String str, String str2, LoginParam loginParam) {
        Intent intent = new Intent(context, AliUserRegisterWebviewActivity.class);
        intent.putExtra(WebConstant.WEBURL, str);
        intent.putExtra("pageFrom", str2);
        if (loginParam != null) {
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam));
        }
        return intent;
    }

    private void goRegister() {
        Intent callingIntent = AliUserRegisterActivity.getCallingIntent(this);
        callingIntent.addFlags(ConfigReporter.BIT_GETTER_IMP);
        callingIntent.addFlags(536870912);
        finish();
        startActivity(callingIntent);
    }

    private void loginAfterRegisterUT(String str, String str2) {
        try {
            Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(this.mPageFrom, "single_register_success", "", this.mPageType, properties);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void regH5Hit(String str) {
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        UserTrackAdapter.sendUT(this.mPageFrom, str, "", this.mPageType, properties);
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.webview.WebViewActivity, com.ali.user.mobile.base.ui.BaseActivity
    public boolean needToolbar() {
        return true;
    }

    @Override // androidx.activity.ComponentActivity, com.ali.user.mobile.webview.WebViewActivity
    public void onBackPressed() {
        regH5Hit("reg_h5_handle_cancel");
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        UserTrackAdapter.sendUT(this.mPageFrom, "single_register_cancel", "", this.mPageType, properties);
        super.onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.ali.user.mobile.webview.WebViewActivity, com.ali.user.mobile.base.ui.BaseActivity
    public void onCreate(Bundle bundle) {
        this.isLoginObserver = true;
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.mPageFrom = getIntent().getStringExtra("pageFrom");
            this.mPageType = getIntent().getStringExtra(WebConstant.REG_TYPE);
            this.mOriginalLoginParam = getIntent().getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
            if (!TextUtils.isEmpty(this.mPageFrom)) {
                this.mUTProperties.put("scene", this.mPageFrom);
            }
        }
        try {
            if (getSupportActionBar() != null) {
                getSupportActionBar().show();
            }
            if (TextUtils.equals(this.mPageFrom, UTConstans.PageName.UT_PAGE_ONEKEY_REG_NEW)) {
                this.mPageType = "oneKeyRegister";
            } else {
                this.mPageType = UTConstant.Args.UT_MOBILE_REG;
            }
            regH5Hit("reg_h5_handle_commit");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, com.ali.user.mobile.webview.WebViewActivity
    public void onPause() {
        super.onPause();
        UserTrackAdapter.pageDisAppear(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, com.ali.user.mobile.webview.WebViewActivity, com.ali.user.mobile.base.ui.BaseActivity
    public void onResume() {
        super.onResume();
        UserTrackAdapter.updatePageName(this, page, spm);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
        if (r16.contains(r14.active_url) != false) goto L_0x0014;
     */
    @Override // com.ali.user.mobile.webview.WebViewActivity
    @SuppressLint({"NewApi"})
    public boolean overrideUrlLoading(WebView webView, String str) {
        if (!StringUtil.checkWebviewBridge(str)) {
        }
        this.allowReadTitle = true;
        Bundle serialBundle = BundleUtil.serialBundle(Uri.parse(str).getQuery());
        if (serialBundle == null) {
            serialBundle = new Bundle();
        }
        String string = serialBundle.getString("action");
        String string2 = serialBundle.getString("loginId");
        String string3 = serialBundle.getString("title");
        String string4 = serialBundle.getString(LoginConstant.EXT_ACTION);
        if (!TextUtils.isEmpty(string4)) {
            string = string4;
        }
        String string5 = serialBundle.getString("token");
        String string6 = serialBundle.getString("from");
        String string7 = serialBundle.getString("conflict");
        String string8 = serialBundle.getString("isVerification");
        if (Debuggable.isDebug()) {
            String str2 = "";
            if (("registe webview, from=" + string6 + ", loginId=" + string2 + ", token=" + string5) != null) {
                if ((string5 + ", mToken=" + this.mToken) != null) {
                    str2 = this.mToken;
                }
            }
            TLogAdapter.d("login.AliUserRegisterWebviewActivity", str2);
        }
        if (!TextUtils.isEmpty(string)) {
            if ("quit".equals(string)) {
                finish();
            } else if ("login".equals(string)) {
                finish();
                regH5Hit("reg_h5_handle_success");
                Properties properties = new Properties();
                properties.setProperty("monitor", "T");
                UserTrackAdapter.sendUT(this.mPageFrom, "single_register_failure", "714", this.mPageType, properties);
                goLogin(string2, null, "taobao", false, null, null, !"Reg_JoinFailed".equals(string6), false, false, null);
            } else if ("register".equals(string)) {
                Properties properties2 = new Properties();
                properties2.setProperty("monitor", "T");
                UserTrackAdapter.sendUT(this.mPageFrom, "single_register_failure", "715", this.mPageType, properties2);
                finish();
                goRegister();
            } else if ("loginAfterRegister".equals(string)) {
                loginAfterRegisterUT(string7, string8);
                regH5Hit("reg_h5_handle_success");
                Intent intent = new Intent();
                intent.setAction("com.ali.user.sdk.register.success");
                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                finish();
                goLogin(string2, string5, "taobao", true, "1012", null, true, false, false, UTConstant.CustomEvent.UT_TYPE_SMS_LOGIN_TO_REG);
            }
            return true;
        }
        if (!TextUtils.isEmpty(string3)) {
            this.allowReadTitle = false;
            if (getSupportActionBar() != null) {
                try {
                    getSupportActionBar().setTitle(string3);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            webView.loadUrl(str);
            return true;
        }
        return super.overrideUrlLoading(webView, str);
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.webview.WebViewActivity
    public void sendCancelBroadcast() {
    }
}
