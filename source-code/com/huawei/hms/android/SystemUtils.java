package com.huawei.hms.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import tb.gl1;

/* compiled from: Taobao */
public class SystemUtils {
    public static String a() {
        return getSystemProperties("ro.product.locale", "");
    }

    public static String b() {
        return getSystemProperties("ro.product.locale.region", "");
    }

    public static String getLocalCountry() {
        Locale locale = Locale.getDefault();
        return locale != null ? locale.getCountry() : "";
    }

    public static String getNetType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null || !activeNetworkInfo.isAvailable()) ? "" : activeNetworkInfo.getTypeName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0024, code lost:
        com.huawei.hms.support.log.HMSLog.e("SystemUtils", "An exception occurred while reading: getSystemProperties:" + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003a, code lost:
        return r8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:5:? A[ExcHandler: ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:1:0x000b] */
    public static String getSystemProperties(String str, String str2) {
        Class<?> cls = Class.forName("android.os.SystemProperties");
        try {
            return (String) cls.getDeclaredMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }

    public static boolean isChinaROM() {
        String b = b();
        if (!TextUtils.isEmpty(b)) {
            return AdvanceSetting.CLEAR_NOTIFICATION.equalsIgnoreCase(b);
        }
        String a = a();
        if (!TextUtils.isEmpty(a)) {
            return a.toLowerCase(Locale.US).contains(AdvanceSetting.CLEAR_NOTIFICATION);
        }
        String localCountry = getLocalCountry();
        if (!TextUtils.isEmpty(localCountry)) {
            return AdvanceSetting.CLEAR_NOTIFICATION.equalsIgnoreCase(localCountry);
        }
        return false;
    }

    public static boolean isEMUI() {
        StringBuilder sb = new StringBuilder();
        sb.append("is Emui :");
        int i = HwBuildEx.VERSION.EMUI_SDK_INT;
        sb.append(i);
        HMSLog.i("SystemUtils", sb.toString());
        return i > 0;
    }

    public static boolean isSystemApp(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException e) {
            HMSLog.e("SystemUtils", "isSystemApp Exception: " + e);
        } catch (RuntimeException e2) {
            HMSLog.e("SystemUtils", "isSystemApp RuntimeException:" + e2);
        }
        if (packageInfo != null || (packageInfo.applicationInfo.flags & 1) <= 0) {
            return false;
        }
        return true;
        packageInfo = null;
        if (packageInfo != null) {
        }
        return false;
    }

    public static boolean isTVDevice() {
        return getSystemProperties("ro.build.characteristics", "default").equalsIgnoreCase("tv");
    }
}
