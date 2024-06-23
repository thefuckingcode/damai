package tb;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;

/* compiled from: Taobao */
public final class j53 {
    public static NetworkInfo a(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                t43.b(Constants.TAG, "get CONNECTIVITY_SERVICE is null", null);
                return null;
            }
            NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
            if ((activeNetworkInfo != null && activeNetworkInfo.isConnected()) || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null) {
                return activeNetworkInfo;
            }
            for (int i = 0; i < allNetworkInfo.length; i++) {
                if (allNetworkInfo[i] != null && allNetworkInfo[i].isConnected()) {
                    return allNetworkInfo[i];
                }
            }
            return activeNetworkInfo;
        } catch (Throwable th) {
            t43.c(Constants.TAG, "get network info error", th);
            return null;
        }
    }

    public static String b(Context context) {
        if (d(context)) {
            return "denied";
        }
        NetworkInfo a = a(context);
        if (a == null) {
            return "disconnected";
        }
        if (a.getType() == 1) {
            return "wifi";
        }
        int subtype = a.getSubtype();
        if (subtype == 20) {
            return "5g";
        }
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3g";
            case 13:
                return "4g";
            default:
                String subtypeName = a.getSubtypeName();
                return TextUtils.isEmpty(subtypeName) ? "unknown" : (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? "3g" : subtypeName;
        }
    }

    private static boolean c(Context context) {
        try {
            return context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0;
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        return !c(context);
    }
}
