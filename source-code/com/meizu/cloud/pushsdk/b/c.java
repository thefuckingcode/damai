package com.meizu.cloud.pushsdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.b.b.a;
import com.meizu.cloud.pushsdk.b.b.d;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.DeviceUtils;

/* compiled from: Taobao */
public class c {
    private static String a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        a = !a() ? d(context) : b(context);
        return a;
    }

    public static boolean a() {
        String a2 = i.a("ro.target.product");
        if (!TextUtils.isEmpty(a2)) {
            DebugLogger.i(DeviceUtils.TAG, "current product is " + a2);
            return false;
        }
        DebugLogger.i(DeviceUtils.TAG, "current product is phone");
        return true;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String b(Context context) {
        T t;
        try {
            d a2 = a.a("android.telephony.MzTelephonyManager").a("getDeviceId", new Class[0]).a(new Object[0]);
            if (!a2.a || TextUtils.isEmpty(a2.b)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return null;
                }
                t = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDeviceId(telephonyManager);
            } else {
                t = a2.b;
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String c(Context context) {
        return null;
    }

    private static String d(Context context) {
        StringBuilder sb = new StringBuilder();
        String serial = Build.getSERIAL();
        DebugLogger.i(DeviceUtils.TAG, "device serial " + serial);
        if (!TextUtils.isEmpty(serial)) {
            sb.append(serial);
            String c = c(context);
            DebugLogger.e(DeviceUtils.TAG, "mac address " + c);
            if (!TextUtils.isEmpty(c)) {
                sb.append(c.replace(":", "").toUpperCase());
                return sb.toString();
            }
        }
        return null;
    }
}
