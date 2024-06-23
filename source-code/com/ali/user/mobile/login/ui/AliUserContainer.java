package com.ali.user.mobile.login.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.ui.R;

/* compiled from: Taobao */
public class AliUserContainer extends BaseActivity {
    public static final String ACTION_TYPE = "actionType";
    public static final String TAG = "login.container";
    public static String TYPE_FINGER = "finger";
    public static CommonCallback callback;
    protected FragmentManager mFragmentManager;

    private void openFragmentByConfig(Intent intent) {
        String str;
        if (intent != null) {
            try {
                str = intent.getStringExtra("actionType");
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            str = null;
        }
        if (TYPE_FINGER.equals(str)) {
            FingerPrintDialog fingerPrintDialog = new FingerPrintDialog(callback);
            fingerPrintDialog.setArguments(intent.getExtras());
            fingerPrintDialog.show(this.mFragmentManager, "finger");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public void initViews() {
        openFragmentByConfig(getIntent());
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        try {
            if (!isFinishing()) {
                finish();
                overridePendingTransition(0, 0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.ali.user.mobile.base.ui.BaseActivity
    public void onCreate(Bundle bundle) {
        this.activityIsTranslucent = true;
        this.mFragmentManager = getSupportFragmentManager();
        super.onCreate(bundle);
        setContentView(R.layout.aliuser_activity_frame_content);
    }
}
