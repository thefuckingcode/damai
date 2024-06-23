package tb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.heytap.mcssdk.c;

/* compiled from: Taobao */
public class hu2 {
    public static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            sb.append((char) i);
        }
        return sb.toString();
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            w33.a("getVersionCode--Exception:" + e.getMessage());
            return 0;
        }
    }

    public static int c(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e) {
            w33.a("getVersionCode--Exception:" + e.getMessage());
            return 0;
        }
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            w33.a("getVersionName--Exception:" + e.getMessage());
            return "0";
        }
    }

    public static String e(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception e) {
            w33.a("getVersionName--Exception:" + e.getMessage());
            return null;
        }
    }

    public static boolean f(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            w33.b("isExistPackage NameNotFoundException:" + e.getMessage());
            return false;
        }
    }

    public static boolean g(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e) {
            w33.b("isSupportPush NameNotFoundException:" + e.getMessage());
            applicationInfo = null;
        }
        return applicationInfo != null && applicationInfo.metaData.getBoolean(str2, false);
    }

    public static boolean h(Context context) {
        return c.m().D(context);
    }

    public static int i(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                w33.b("parseInt--NumberFormatException" + e.getMessage());
            }
        }
        return -1;
    }
}
