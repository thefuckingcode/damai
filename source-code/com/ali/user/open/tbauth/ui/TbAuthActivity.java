package com.ali.user.open.tbauth.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.tbauth.TbAuthComponent;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.ali.user.open.tbauth.task.RpcPresenter;
import com.ali.user.open.tbauth.ui.context.CallbackContext;

/* compiled from: Taobao */
public class TbAuthActivity extends Activity {
    public static final String TAG = "login.TbAuthActivity";
    LinearLayout hiddenLayout;

    /* access modifiers changed from: protected */
    public void auth() {
        int intExtra = getIntent().getIntExtra("login_type", 0);
        if (intExtra == 1) {
            RpcPresenter.loginByIVToken(this, getIntent().getIntExtra("site", 0), getIntent().getStringExtra("loginToken"), getIntent().getStringExtra("scene"), getIntent().getStringExtra(TbAuthConstants.H5_QUERY_STR), (LoginCallback) CallbackContext.loginCallback);
        } else if (intExtra != 4) {
            TbAuthComponent.INSTANCE.showLogin(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        SDKLogger.d(TAG, "onActivityResult requestCode = " + i + " resultCode=" + i2);
        if (!KernelContext.checkServiceValid()) {
            finish();
            return;
        }
        this.hiddenLayout.setClickable(true);
        this.hiddenLayout.setLongClickable(true);
        super.onActivityResult(i, i2, intent);
        if (CallbackContext.activity == null) {
            CallbackContext.setActivity(this);
        }
        CallbackContext.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout linearLayout = new LinearLayout(this);
        this.hiddenLayout = linearLayout;
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.hiddenLayout);
        if (KernelContext.applicationContext == null) {
            KernelContext.applicationContext = getApplicationContext();
        }
        this.hiddenLayout.setOnClickListener(new View.OnClickListener() {
            /* class com.ali.user.open.tbauth.ui.TbAuthActivity.AnonymousClass1 */

            public void onClick(View view) {
                SDKLogger.e(TbAuthActivity.TAG, "click to destroy");
                TbAuthActivity.this.finish();
            }
        });
        this.hiddenLayout.setClickable(true);
        this.hiddenLayout.setLongClickable(true);
        if (!KernelContext.checkServiceValid()) {
            SDKLogger.d(TAG, "static field null");
            finish();
            return;
        }
        CallbackContext.setActivity(this);
        SDKLogger.e(TAG, "before mtop call showLogin");
        auth();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!KernelContext.checkServiceValid()) {
            finish();
        }
    }
}
