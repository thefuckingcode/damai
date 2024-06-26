package com.ali.user.open.core.webview;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.taobao.windvane.WindVaneSDK;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.ali.user.mobile.utils.StringUtil;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.R;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.config.WebViewOption;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import tb.v;

/* compiled from: Taobao */
public class BaseWebViewActivity extends AppCompatActivity implements IWebViewClient {
    public static final String TAG = "BaseWebViewActivity";
    protected String CALLBACK = StringUtil.CALLBACK;
    protected boolean forceUcWebView;
    protected IWebViewProxy memberWebView;

    public boolean checkWebviewBridge(String str) {
        Uri parse = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getAuthority());
        sb.append(parse.getPath());
        return this.CALLBACK.contains(sb.toString());
    }

    /* access modifiers changed from: protected */
    public boolean checkWindVaneExist() {
        try {
            int i = WindVaneSDK.a;
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public IWebViewProxy createWebView() {
        if (ConfigManager.getInstance().getWebViewOption() != WebViewOption.UC && !this.forceUcWebView) {
            return new SystemWebViewProxy(this);
        }
        if (checkWindVaneExist()) {
            return new WVUcWebViewProxy(this);
        }
        return new SystemWebViewProxy(this);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.member_sdk_activity_webview;
    }

    /* access modifiers changed from: protected */
    public void initParams(Intent intent) {
        checkWindVaneExist();
    }

    /* access modifiers changed from: protected */
    public void initViews(Bundle bundle) {
        Uri data;
        setContentView(getLayout());
        setActionBar();
        this.memberWebView = createWebView();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ali_user_webview_container);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        IWebViewProxy iWebViewProxy = this.memberWebView;
        if (iWebViewProxy == null || iWebViewProxy.getWebView() == null) {
            finish();
            return;
        }
        frameLayout.addView(this.memberWebView.getWebView(), layoutParams);
        String stringExtra = getIntent().getStringExtra("url");
        if (TextUtils.isEmpty(stringExtra) && (data = getIntent().getData()) != null) {
            stringExtra = data.getQueryParameter("url");
            SDKLogger.e(TAG, "read url fomr uri:");
        }
        String str = TAG;
        SDKLogger.d(str, "onCreate url=" + stringExtra);
        if (!KernelContext.checkServiceValid() || TextUtils.isEmpty(stringExtra)) {
            finish();
        } else if (!CommonUtils.isNetworkAvailable()) {
            CommonUtils.toast("member_sdk_network_not_available_message");
        } else {
            try {
                this.memberWebView.resumeTimers();
                this.memberWebView.onResume();
            } catch (Exception unused) {
            }
            loadUrl(stringExtra);
        }
    }

    /* access modifiers changed from: protected */
    public void loadUrl(String str) {
        IWebViewProxy iWebViewProxy;
        if (!TextUtils.isEmpty(str) && (iWebViewProxy = this.memberWebView) != null) {
            iWebViewProxy.loadUrl(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onBackHistory() {
        setResult(ResultCode.USER_CANCEL.code, new Intent());
        finish();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        onBackHistory();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        if ("true".equals(pipOrange()) && Build.VERSION.SDK_INT >= 26) {
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            int height = defaultDisplay.getHeight();
            int width = defaultDisplay.getWidth();
            String str = TAG;
            Log.e(str, "height=" + height + ",width=" + width);
            if (height > width) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(((WindowManager) getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
                int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
                int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
                Log.e(str, "height=" + i2 + ",width=" + i);
                float f = displayMetrics.density;
                int i3 = (int) (((float) i) / f);
                int i4 = (int) (((float) i2) / f);
                Log.e(str, "dp width=" + i3 + ",height=" + i4);
                Configuration configuration = getResources().getConfiguration();
                if (getResources().getConfiguration().orientation != 1) {
                    Log.e(str, "force portrait");
                    configuration.orientation = 1;
                    configuration.screenHeightDp = i4;
                    configuration.screenWidthDp = i3;
                    onConfigurationChanged(configuration);
                }
            }
        }
        super.onCreate(bundle);
        try {
            initParams(getIntent());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            initViews(bundle);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        IWebViewProxy iWebViewProxy = this.memberWebView;
        if (iWebViewProxy == null || iWebViewProxy.getWebView() == null) {
            SDKLogger.e(TAG, "init webview failed,finish");
            finish();
            return;
        }
        if (KernelContext.applicationContext == null) {
            KernelContext.applicationContext = getApplicationContext();
        }
        if (ConfigManager.getInstance().getWebViewOption() == WebViewOption.SYSTEM && this.memberWebView != null) {
            if (AliMemberSDK.getService(UserTrackerService.class) != null) {
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).skipPage(this);
            }
            this.memberWebView.addBridgeObject("ALBBUserTrackJSBridge", new UserTrackBridge());
            this.memberWebView.addBridgeObject("aluWVJSBridge", new UserInfoBridge());
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        IWebViewProxy iWebViewProxy = this.memberWebView;
        if (!(iWebViewProxy == null || iWebViewProxy.getWebView() == null)) {
            ViewGroup viewGroup = (ViewGroup) this.memberWebView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.memberWebView.getWebView());
            }
            this.memberWebView.removeAllViews();
            this.memberWebView.destroy();
            this.memberWebView = null;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onFailure(ResultCode resultCode) {
        finish();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        Uri data;
        super.onNewIntent(intent);
        try {
            String stringExtra = intent.getStringExtra("url");
            if (TextUtils.isEmpty(stringExtra) && (data = getIntent().getData()) != null) {
                stringExtra = data.getQueryParameter("url");
                this.forceUcWebView = true;
                SDKLogger.e(TAG, "read url fomr uri:");
            }
            String str = TAG;
            SDKLogger.d(str, "onCreate url=" + stringExtra);
            if (!KernelContext.checkServiceValid()) {
                finish();
            } else if (!CommonUtils.isNetworkAvailable()) {
                CommonUtils.toast("member_sdk_network_not_available_message");
            } else {
                try {
                    this.memberWebView.resumeTimers();
                    this.memberWebView.onResume();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                loadUrl(stringExtra);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.open.core.webview.IWebViewClient
    public void onPageFinished(String str) {
    }

    @Override // com.ali.user.open.core.webview.IWebViewClient
    public void onPageStarted(String str) {
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        if (AliMemberSDK.getService(UserTrackerService.class) != null) {
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).pageDisAppear(this);
        }
    }

    @Override // com.ali.user.open.core.webview.IWebViewClient
    public void onReceivedTitle(String str) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        IWebViewProxy iWebViewProxy = this.memberWebView;
        if (iWebViewProxy != null) {
            try {
                iWebViewProxy.resumeTimers();
                this.memberWebView.onResume();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public String pipOrange() {
        return "true";
    }

    public Bundle serialBundle(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String[] split = str.split("&");
        Bundle bundle = new Bundle();
        for (String str2 : split) {
            int indexOf = str2.indexOf("=");
            if (indexOf > 0 && indexOf < str2.length() - 1) {
                bundle.putString(str2.substring(0, indexOf), str2.substring(indexOf + 1));
            }
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void setActionBar() {
        AliUccCustomToolbar aliUccCustomToolbar = (AliUccCustomToolbar) findViewById(R.id.ali_user_webview_toolbar);
        setSupportActionBar(aliUccCustomToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            if (aliUccCustomToolbar != null) {
                aliUccCustomToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    /* class com.ali.user.open.core.webview.BaseWebViewActivity.AnonymousClass1 */

                    public void onClick(View view) {
                        BaseWebViewActivity.this.onBackHistory();
                    }
                });
            }
        }
    }

    public void setResult(ResultCode resultCode) {
        onFailure(resultCode);
    }

    @Override // com.ali.user.open.core.webview.IWebViewClient
    public boolean shouldOverrideUrlLoading(String str) {
        loadUrl(str);
        return true;
    }
}
