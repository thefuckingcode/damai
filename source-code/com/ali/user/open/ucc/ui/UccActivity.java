package com.ali.user.open.ucc.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.SerializableMap;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccServiceImpl;
import com.ali.user.open.ucc.context.UccContext;
import com.ali.user.open.ucc.util.UccConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class UccActivity extends Activity {
    public static final String TAG = "UccActivity";
    public static boolean isUccActivityExist;
    public static UccCallback mUccCallback;
    LinearLayout hiddenLayout;
    private boolean isInUccTrustLogin = false;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void unknownFailure() {
        if (mUccCallback != null) {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    mUccCallback.onFail(intent.getStringExtra("targetSite"), 10001, "");
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            mUccCallback.onFail("taobao", 10001, "");
        }
    }

    /* access modifiers changed from: protected */
    public void auth() {
        Intent intent = getIntent();
        if (intent == null) {
            SDKLogger.e("UccActivity", "intent is null");
            unknownFailure();
            finish();
            return;
        }
        int intExtra = intent.getIntExtra(UccConstants.PARAM_FUNC_TYPE, 2);
        String stringExtra = intent.getStringExtra("targetSite");
        String stringExtra2 = intent.getStringExtra("userToken");
        HashMap hashMap = new HashMap();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                SerializableMap serializableMap = (SerializableMap) extras.getSerializable("params");
                if (serializableMap != null) {
                    hashMap.putAll(serializableMap.getMap());
                }
            } catch (Throwable unused) {
            }
        }
        if (intExtra == 1) {
            UccContext.startTrustLoginTime = 0;
            this.isInUccTrustLogin = true;
            UccServiceImpl.getInstance().trustLogin(this, stringExtra, hashMap, new UccCallback() {
                /* class com.ali.user.open.ucc.ui.UccActivity.AnonymousClass2 */

                @Override // com.ali.user.open.ucc.UccCallback
                public void onFail(String str, int i, String str2) {
                    SDKLogger.e("UccActivity", "trustlogin fail target=" + str + "  code=" + i);
                    UccCallback uccCallback = UccActivity.mUccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(str, i, str2);
                    }
                    UccActivity.this.finish();
                }

                @Override // com.ali.user.open.ucc.UccCallback
                public void onSuccess(String str, Map map) {
                    UccCallback uccCallback = UccActivity.mUccCallback;
                    if (uccCallback != null) {
                        uccCallback.onSuccess(str, map);
                    }
                    UccActivity.this.finish();
                }
            });
        } else if (intExtra != 3) {
            UccServiceImpl.getInstance().bind(this, stringExtra2, stringExtra, hashMap, new UccCallback() {
                /* class com.ali.user.open.ucc.ui.UccActivity.AnonymousClass4 */

                @Override // com.ali.user.open.ucc.UccCallback
                public void onFail(String str, int i, String str2) {
                    UccCallback uccCallback = UccActivity.mUccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(str, i, str2);
                    }
                    UccActivity.this.finish();
                }

                @Override // com.ali.user.open.ucc.UccCallback
                public void onSuccess(String str, Map map) {
                    UccCallback uccCallback = UccActivity.mUccCallback;
                    if (uccCallback != null) {
                        uccCallback.onSuccess(str, map);
                    }
                    UccActivity.this.finish();
                }
            });
        } else {
            UccServiceImpl.getInstance().doBindAlipay(this, intent.getStringExtra("bizCode"), intent.getStringExtra(UccConstants.PARAM_REALM), hashMap, new UccCallback() {
                /* class com.ali.user.open.ucc.ui.UccActivity.AnonymousClass3 */

                @Override // com.ali.user.open.ucc.UccCallback
                public void onFail(String str, int i, String str2) {
                    SDKLogger.e("UccActivity", "trustlogin fail target=" + str + "  code=" + i);
                    UccCallback uccCallback = UccActivity.mUccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail(str, i, str2);
                    }
                    UccActivity.this.finish();
                }

                @Override // com.ali.user.open.ucc.UccCallback
                public void onSuccess(String str, Map map) {
                    UccCallback uccCallback = UccActivity.mUccCallback;
                    if (uccCallback != null) {
                        uccCallback.onSuccess(str, map);
                    }
                    UccActivity.this.finish();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        SDKLogger.d("UccActivity", "onActivityResult requestCode = " + i + " resultCode=" + i2);
        if (!KernelContext.checkServiceValid()) {
            SDKLogger.e("UccActivity", "in onActivityResult,service is null");
            unknownFailure();
            finish();
            return;
        }
        super.onActivityResult(i, i2, intent);
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
            /* class com.ali.user.open.ucc.ui.UccActivity.AnonymousClass1 */

            public void onClick(View view) {
                AliMemberSDK.getMasterSite();
                if (!UccActivity.this.isInUccTrustLogin || (UccContext.startTrustLoginTime != 0 && System.currentTimeMillis() - UccContext.startTrustLoginTime >= 7000)) {
                    SDKLogger.e("UccActivity", "click to destroy");
                    UccActivity.this.unknownFailure();
                    UccActivity.this.finish();
                }
            }
        });
        this.hiddenLayout.setClickable(true);
        this.hiddenLayout.setLongClickable(true);
        if (!KernelContext.checkServiceValid()) {
            SDKLogger.e("UccActivity", "static field null");
            unknownFailure();
            finish();
            return;
        }
        SDKLogger.e("UccActivity", "before mtop call showLogin");
        auth();
        isUccActivityExist = true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        mUccCallback = null;
        isUccActivityExist = false;
        super.onDestroy();
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
            SDKLogger.e("UccActivity", "in resume,service is not valid");
            unknownFailure();
            finish();
        }
    }
}
