package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;

/* compiled from: SysCoreQUA2Utils */
public class l {
    private static String a = null;
    private static String b = "GA";
    private static String c = "GE";
    private static String d = "9422";
    private static String e = "0";
    private static String f = "";
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = a(context, String.valueOf(WebView.getTbsSDKVersion(context)), "0", b, c, d, e, f, g);
        a = a2;
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010a  */
    private static String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        String str8;
        String str9;
        String a2;
        String str10;
        PackageManager.NameNotFoundException e2;
        StringBuilder sb = new StringBuilder();
        String str11 = b(context) + "*" + c(context);
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
            str8 = applicationInfo.packageName;
            try {
                if (!TextUtils.isEmpty(str7)) {
                    str9 = str7;
                } else {
                    str9 = packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException e3) {
                e2 = e3;
                e2.printStackTrace();
                str9 = "";
                String a3 = a(str8);
                String str12 = "PAD";
                str12 = "PHONE";
                sb.append("QV");
                sb.append("=");
                sb.append("3");
                a(sb, "PL", "ADR");
                a(sb, "PR", a3);
                a(sb, "PP", str8);
                a(sb, "PPVN", str9);
                if (!TextUtils.isEmpty(str)) {
                }
                a(sb, "CO", "SYS");
                if (!TextUtils.isEmpty(str2)) {
                }
                a(sb, "PB", str4);
                a(sb, "VE", str3);
                a(sb, "DE", str12);
                a(sb, "CHID", TextUtils.isEmpty(str6) ? "0" : str6);
                a(sb, "LCID", str5);
                a2 = a();
                a2 = new String(a2.getBytes("UTF-8"), "ISO8859-1");
                if (!TextUtils.isEmpty(a2)) {
                }
                a(sb, "RL", str11);
                str10 = Build.VERSION.RELEASE;
                str10 = new String(str10.getBytes("UTF-8"), "ISO8859-1");
                if (!TextUtils.isEmpty(str10)) {
                }
                a(sb, "API", Build.VERSION.SDK_INT + "");
                return sb.toString();
            }
        } catch (PackageManager.NameNotFoundException e4) {
            e2 = e4;
            str8 = "";
            e2.printStackTrace();
            str9 = "";
            String a32 = a(str8);
            String str122 = "PAD";
            str122 = "PHONE";
            sb.append("QV");
            sb.append("=");
            sb.append("3");
            a(sb, "PL", "ADR");
            a(sb, "PR", a32);
            a(sb, "PP", str8);
            a(sb, "PPVN", str9);
            if (!TextUtils.isEmpty(str)) {
            }
            a(sb, "CO", "SYS");
            if (!TextUtils.isEmpty(str2)) {
            }
            a(sb, "PB", str4);
            a(sb, "VE", str3);
            a(sb, "DE", str122);
            a(sb, "CHID", TextUtils.isEmpty(str6) ? "0" : str6);
            a(sb, "LCID", str5);
            a2 = a();
            a2 = new String(a2.getBytes("UTF-8"), "ISO8859-1");
            if (!TextUtils.isEmpty(a2)) {
            }
            a(sb, "RL", str11);
            str10 = Build.VERSION.RELEASE;
            str10 = new String(str10.getBytes("UTF-8"), "ISO8859-1");
            if (!TextUtils.isEmpty(str10)) {
            }
            a(sb, "API", Build.VERSION.SDK_INT + "");
            return sb.toString();
        }
        String a322 = a(str8);
        String str1222 = "PAD";
        if (!"QB".equals(a322) ? !d(context) : !z) {
            str1222 = "PHONE";
        }
        sb.append("QV");
        sb.append("=");
        sb.append("3");
        a(sb, "PL", "ADR");
        a(sb, "PR", a322);
        a(sb, "PP", str8);
        a(sb, "PPVN", str9);
        if (!TextUtils.isEmpty(str)) {
            a(sb, "TBSVC", str);
        }
        a(sb, "CO", "SYS");
        if (!TextUtils.isEmpty(str2)) {
            a(sb, "COVC", str2);
        }
        a(sb, "PB", str4);
        a(sb, "VE", str3);
        a(sb, "DE", str1222);
        a(sb, "CHID", TextUtils.isEmpty(str6) ? "0" : str6);
        a(sb, "LCID", str5);
        a2 = a();
        try {
            a2 = new String(a2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(a2)) {
            a(sb, "MO", a2);
        }
        a(sb, "RL", str11);
        str10 = Build.VERSION.RELEASE;
        try {
            str10 = new String(str10.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception unused2) {
        }
        if (!TextUtils.isEmpty(str10)) {
            a(sb, "OS", str10);
        }
        a(sb, "API", Build.VERSION.SDK_INT + "");
        return sb.toString();
    }

    private static void a(StringBuilder sb, String str, String str2) {
        sb.append("&");
        sb.append(str);
        sb.append("=");
        sb.append(str2);
    }

    private static String a(String str) {
        if (TbsConfig.APP_WX.equals(str)) {
            return "WX";
        }
        if (TbsConfig.APP_QQ.equals(str)) {
            return "QQ";
        }
        if (TbsConfig.APP_QZONE.equals(str)) {
            return "QZ";
        }
        return TbsConfig.APP_QB.equals(str) ? "QB" : "TRD";
    }

    private static int b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return defaultDisplay.getWidth();
        }
        return -1;
    }

    private static int c(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return defaultDisplay.getHeight();
        }
        return -1;
    }

    private static String a() {
        return " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
    }

    private static boolean d(Context context) {
        if (h) {
            return i;
        }
        try {
            boolean z = (Math.min(b(context), c(context)) * 160) / e(context) >= 700;
            i = z;
            h = true;
            return z;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static int e(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay == null) {
            return 160;
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }
}
