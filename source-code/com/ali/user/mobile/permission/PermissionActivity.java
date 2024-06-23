package com.ali.user.mobile.permission;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import com.ali.user.mobile.R;

/* compiled from: Taobao */
public class PermissionActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static final int OVERLAY_PERMISSION_REQ_CODE = 123;
    private static final int PERMISSION_REQUEST = 0;
    public static final String TAG = "PermissionActivity";

    private void requestCustomPermission(final String[] strArr, String str) {
        if (!shouldShowRequestPermissionRationale(strArr) || TextUtils.isEmpty(str)) {
            ActivityCompat.requestPermissions(this, strArr, 0);
        } else {
            new AlertDialog.Builder(this).setMessage(str).setCancelable(false).setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
                /* class com.ali.user.mobile.permission.PermissionActivity.AnonymousClass1 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    ActivityCompat.requestPermissions(PermissionActivity.this, strArr, 0);
                    dialogInterface.dismiss();
                }
            }).show();
        }
    }

    private boolean shouldShowRequestPermissionRationale(String[] strArr) {
        for (String str : strArr) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
                return true;
            }
        }
        return false;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: protected */
    @RequiresApi(api = 23)
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 123) {
            PermissionUtil.onActivityResult(i, i2, intent);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aliuser_activity_permission);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("permissions");
        String stringExtra = getIntent().getStringExtra("explain");
        if (stringArrayExtra != null && stringArrayExtra.length == 1 && stringArrayExtra[0].equals("android.permission.SYSTEM_ALERT_WINDOW")) {
            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 123);
        } else if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
            finish();
        } else {
            requestCustomPermission(stringArrayExtra, stringExtra);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return true;
    }

    @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            PermissionUtil.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }
}
