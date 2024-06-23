package android.taobao.windvane.runtimepermission;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.core.app.ActivityCompat;

/* compiled from: Taobao */
public class PermissionActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static final int OVERLAY_PERMISSION_REQ_CODE = 123;
    private static final int PERMISSION_REQUEST = 0;
    public static final String TAG = "PermissionActivity";

    private void requestCustomPermission(final String[] strArr, String str) {
        if (shouldShowRequestPermissionRationale(strArr) && !TextUtils.isEmpty(str)) {
            new AlertDialog.Builder(this).setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
                /* class android.taobao.windvane.runtimepermission.PermissionActivity.AnonymousClass1 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    ActivityCompat.requestPermissions(PermissionActivity.this, strArr, 0);
                    dialogInterface.dismiss();
                }
            }).setMessage(str).setCancelable(false).show();
        } else if (strArr != null) {
            ActivityCompat.requestPermissions(this, strArr, 0);
        } else {
            TaoLog.e("PermissionActivity", "permissions==null,abort!");
        }
    }

    private boolean shouldShowRequestPermissionRationale(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 123) {
            PermissionProposer.onActivityResult(i, i2, intent);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FrameLayout frameLayout = new FrameLayout(this);
        try {
            frameLayout.setAlpha(0.0f);
        } catch (Throwable unused) {
        }
        setContentView(frameLayout);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("permissions");
        String stringExtra = getIntent().getStringExtra("explain");
        if (stringArrayExtra == null || stringArrayExtra.length != 1 || !stringArrayExtra[0].equals("android.permission.SYSTEM_ALERT_WINDOW")) {
            requestCustomPermission(stringArrayExtra, stringExtra);
            return;
        }
        startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 123);
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
            PermissionProposer.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }
}
