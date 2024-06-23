package com.alipay.sdk.m.a0;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.alibaba.security.common.track.model.a;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import java.io.File;
import tb.gl1;

/* compiled from: Taobao */
public final class d {
    public static d a = new d();

    public static d a() {
        return a;
    }

    public static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057 A[Catch:{ Exception -> 0x0068 }, RETURN] */
    public static boolean a(Context context) {
        boolean z;
        try {
            if (!Build.HARDWARE.contains("goldfish") && !com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getPRODUCT().contains(a.C0103a.a)) {
                if (!Build.FINGERPRINT.contains("generic")) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        String deviceId = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDeviceId(telephonyManager);
                        if (deviceId != null) {
                            int length = deviceId.length();
                            if (length != 0) {
                                int i = 0;
                                while (true) {
                                    if (i < length) {
                                        if (!Character.isWhitespace(deviceId.charAt(i)) && deviceId.charAt(i) != '0') {
                                            z = false;
                                            break;
                                        }
                                        i++;
                                    } else {
                                        break;
                                    }
                                }
                                if (z) {
                                    return true;
                                }
                            }
                        }
                        z = true;
                        if (z) {
                        }
                    }
                    return com.alipay.sdk.m.z.a.a(Settings.Secure.getString(context.getContentResolver(), "android_id"));
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String b() {
        return "android";
    }

    public static boolean c() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i = 0; i < 5; i++) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String d() {
        return Build.BOARD;
    }

    public static String e() {
        return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND();
    }

    public static String f() {
        return Build.DEVICE;
    }

    public static String g() {
        return Build.DISPLAY;
    }

    public static String h() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String i() {
        return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER();
    }

    public static String j() {
        return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
    }

    public static String k() {
        return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getPRODUCT();
    }

    public static String l() {
        return Build.VERSION.getRELEASE();
    }

    public static String m() {
        return Build.VERSION.SDK;
    }

    public static String n() {
        return android.os.Build.TAGS;
    }

    public static String o() {
        return a("ro.kernel.qemu", "0");
    }
}
