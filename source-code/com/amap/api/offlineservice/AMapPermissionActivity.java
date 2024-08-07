package com.amap.api.offlineservice;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class AMapPermissionActivity extends Activity {
    private boolean a = true;
    protected String[] needPermissions = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE"};

    @TargetApi(23)
    private List<String> b(String[] strArr) {
        try {
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 23 && getApplicationInfo().targetSdkVersion >= 23) {
                for (String str : strArr) {
                    if (a(str) != 0 || b(str)) {
                        arrayList.add(str);
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            if (Build.VERSION.SDK_INT >= 23 && i == 0 && !a(iArr)) {
                a();
                this.a = false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        try {
            super.onResume();
            if (Build.VERSION.SDK_INT >= 23 && this.a) {
                a(this.needPermissions);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @TargetApi(23)
    private void a(String... strArr) {
        List<String> b;
        try {
            if (Build.VERSION.SDK_INT >= 23 && getApplicationInfo().targetSdkVersion >= 23 && (b = b(strArr)) != null && b.size() > 0) {
                try {
                    getClass().getMethod("requestPermissions", String[].class, Integer.TYPE).invoke(this, (String[]) b.toArray(new String[b.size()]), 0);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean b(String str) {
        try {
            return ((Boolean) getClass().getMethod("shouldShowRequestPermissionRationale", String.class).invoke(this, str)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private int a(String str) {
        try {
            return ((Integer) getClass().getMethod("checkSelfPermission", String.class).invoke(this, str)).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(int[] iArr) {
        try {
            for (int i : iArr) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    private void a() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(PurchaseConstants.NORMAL_WARNING_TITLE);
            builder.setMessage("当前应用缺少必要权限。\\n\\n请点击\\\"设置\\\"-\\\"权限\\\"-打开所需权限");
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                /* class com.amap.api.offlineservice.AMapPermissionActivity.AnonymousClass1 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        AMapPermissionActivity.this.finish();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
                /* class com.amap.api.offlineservice.AMapPermissionActivity.AnonymousClass2 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        AMapPermissionActivity.this.b();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            builder.setCancelable(false);
            builder.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
