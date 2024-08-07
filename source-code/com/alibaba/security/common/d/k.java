package com.alibaba.security.common.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.util.Patterns;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager;

/* compiled from: Taobao */
public final class k {
    public static final String a = "none";
    public static final String b = "wifi";
    public static final String c = "2G";
    public static final String d = "3G";
    public static final String e = "4G";
    public static final String f = "5G";
    public static final String g = "other";

    private static boolean a(Context context) {
        return !TextUtils.isEmpty(TelephonyManager.getSimOperator((android.telephony.TelephonyManager) context.getSystemService("phone")));
    }

    private static String b(Context context) {
        if (!(!TextUtils.isEmpty(TelephonyManager.getSimOperator((android.telephony.TelephonyManager) context.getApplicationContext().getSystemService("phone"))))) {
            return "unknown";
        }
        String simOperator = TelephonyManager.getSimOperator((android.telephony.TelephonyManager) context.getSystemService("phone"));
        if ("46001".equals(simOperator) || "46006".equals(simOperator) || "46009".equals(simOperator)) {
            return "中国联通";
        }
        if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46004".equals(simOperator) || "46007".equals(simOperator)) {
            return "中国移动";
        }
        return ("46003".equals(simOperator) || "46005".equals(simOperator) || "46011".equals(simOperator)) ? "中国电信" : simOperator;
    }

    private static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
            return false;
        }
        return true;
    }

    private static boolean d(Context context) {
        String str;
        int i;
        if (Build.VERSION.SDK_INT >= 14) {
            str = System.getProperty("http.proxyHost");
            String property = System.getProperty("http.proxyPort");
            if (property == null) {
                property = "-1";
            }
            i = Integer.parseInt(property);
        } else {
            String host = Proxy.getHost(context);
            i = Proxy.getPort(context);
            str = host;
        }
        return !TextUtils.isEmpty(str) && i != -1;
    }

    private static String a(Context context, String str) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null || !activeNetworkInfo.isAvailable()) {
            return "none";
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            return "wifi";
        }
        int i = 0;
        try {
            i = TelephonyManager.getNetworkType((android.telephony.TelephonyManager) context.getSystemService("phone"));
        } catch (Exception e2) {
            TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog(b.a(e2));
            createSdkExceptionLog.addTag10("Android");
            createSdkExceptionLog.setVerifyToken(str);
            a.C0102a.a.a(createSdkExceptionLog);
            e2.printStackTrace();
        }
        if (i == 20) {
            return "5G";
        }
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "other";
        }
    }

    private static boolean a(String str) {
        return Patterns.WEB_URL.matcher(str).matches();
    }
}
