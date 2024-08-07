package com.ta.audid.permission;

import android.content.Context;
import android.os.Binder;

/* compiled from: Taobao */
public class PermissionUtils {
    public static boolean checkReadPhoneStatePermissionGranted(Context context) {
        try {
            return selfPermissionGranted(context, "android.permission.READ_PHONE_STATE");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean checkStoragePermissionGranted(Context context) {
        try {
            return selfPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean selfPermissionGranted(Context context, String str) {
        if (context != null && context.checkPermission(str, Binder.getCallingPid(), Binder.getCallingUid()) == 0) {
            return true;
        }
        return false;
    }
}
