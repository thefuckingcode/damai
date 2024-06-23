package com.ta.audid.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;

/* compiled from: Taobao */
public class AppInfoUtils {
    public static String getAppPackageName(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        return packageInfo != null ? packageInfo.packageName : "";
    }

    public static String getCurProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception e) {
            UtdidLogger.e("", e, new Object[0]);
            return null;
        }
    }

    public static boolean isMainProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        String appPackageName = getAppPackageName(context);
        if (TextUtils.isEmpty(curProcessName) || TextUtils.isEmpty(appPackageName) || curProcessName.equals(appPackageName)) {
            return true;
        }
        return false;
    }
}
