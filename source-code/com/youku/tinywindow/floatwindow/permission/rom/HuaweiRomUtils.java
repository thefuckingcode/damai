package com.youku.tinywindow.floatwindow.permission.rom;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

/* compiled from: Taobao */
public class HuaweiRomUtils {
    private static final String TAG = "HuaweiRomUtils";

    public static void applyPermission(Context context) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
            if (RomUtils.getEmuiVersion() == 3.1d) {
                context.startActivity(intent);
                return;
            }
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
            context.startActivity(intent);
        } catch (SecurityException e) {
            Intent intent2 = new Intent();
            intent2.setFlags(268435456);
            intent2.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            context.startActivity(intent2);
            Log.e(TAG, Log.getStackTraceString(e));
        } catch (ActivityNotFoundException e2) {
            Intent intent3 = new Intent();
            intent3.setFlags(268435456);
            intent3.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
            context.startActivity(intent3);
            e2.printStackTrace();
            Log.e(TAG, Log.getStackTraceString(e2));
        } catch (Exception e3) {
            Toast.makeText(context, "进入设置页面失败，请手动设置", 1).show();
            Log.e(TAG, Log.getStackTraceString(e3));
        }
    }

    public static boolean checkFloatWindowPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return checkOp(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    private static boolean checkOp(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                if (((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                Log.e(TAG, Log.getStackTraceString(e));
            }
        } else {
            Log.e(TAG, "Below API 19 cannot invoke!");
            return false;
        }
    }
}
