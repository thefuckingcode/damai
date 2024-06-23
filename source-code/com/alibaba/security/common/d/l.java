package com.alibaba.security.common.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.alibaba.security.common.c.a;

/* compiled from: Taobao */
public final class l {
    private static final String a = "PackageUtils";

    public static String a(Context context) {
        return context == null ? "" : context.getPackageName();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public static String b(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (Exception unused) {
            }
            return applicationInfo == null ? (String) packageManager.getApplicationLabel(applicationInfo) : "";
        } catch (Exception unused2) {
            packageManager = null;
            if (a.a()) {
                a.b();
            }
            if (applicationInfo == null) {
            }
        }
    }

    public static String c(Context context) {
        PackageInfo packageInfo = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (Exception unused) {
            if (a.a()) {
                a.b();
            }
        }
    }

    public static boolean d(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }
}
