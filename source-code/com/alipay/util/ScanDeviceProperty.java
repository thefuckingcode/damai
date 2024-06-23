package com.alipay.util;

import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.mobile.scan.util.BQCSystemUtil;
import com.alipay.sdk.m.c.a;

/* compiled from: Taobao */
public class ScanDeviceProperty {
    private static String a;
    private static String b;
    private static String c;
    private static String d;
    private static String e;

    private static String a() {
        if (b == null) {
            try {
                b = Build.getBRAND();
            } catch (Throwable unused) {
            }
        }
        return b;
    }

    private static String b() {
        if (c == null) {
            try {
                c = Build.getMANUFACTURER().toLowerCase();
            } catch (Throwable unused) {
            }
        }
        return c;
    }

    public static String getHardware() {
        if (e == null) {
            try {
                e = android.os.Build.HARDWARE.toLowerCase();
            } catch (Throwable unused) {
            }
        }
        return e;
    }

    public static String getRomVersion() {
        if (d == null) {
            try {
                if (isXiaomiDevice()) {
                    d = BQCSystemUtil.reflectSystemProperties("ro.build.version.incremental");
                } else if (isVivoDevice()) {
                    d = BQCSystemUtil.reflectSystemProperties("ro.vivo.os.build.display.id");
                } else if (isOppoDevice()) {
                    d = BQCSystemUtil.reflectSystemProperties("ro.build.version.opporom");
                } else if (isHuaweiDevice()) {
                    d = BQCSystemUtil.reflectSystemProperties(a.a);
                }
                String str = d;
                if (str != null) {
                    d = str.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return d;
    }

    public static boolean isHUAWEIChip() {
        String hardware = getHardware();
        if (TextUtils.isEmpty(hardware)) {
            return false;
        }
        if (hardware.startsWith("kirin") || hardware.startsWith("hi")) {
            return true;
        }
        return false;
    }

    public static boolean isHuaweiDevice() {
        if (a != null || (!"huawei".equals(a()) && !"huawei".equals(b()))) {
            return "huawei".equals(a);
        }
        a = "huawei";
        return true;
    }

    public static boolean isMTKChip() {
        String hardware = getHardware();
        if (TextUtils.isEmpty(hardware)) {
            return false;
        }
        return hardware.startsWith("mt");
    }

    public static boolean isOppoDevice() {
        if (a != null || (!"oppo".equals(a()) && !"oppo".equals(b()))) {
            return "oppo".equals(a);
        }
        a = "oppo";
        return true;
    }

    public static boolean isQCOMChip() {
        String hardware = getHardware();
        if (TextUtils.isEmpty(hardware)) {
            return false;
        }
        return hardware.startsWith("qcom");
    }

    public static boolean isVivoDevice() {
        if (a != null || (!"vivo".equals(a()) && !"vivo".equals(b()))) {
            return "vivo".equals(a);
        }
        a = "vivo";
        return true;
    }

    public static boolean isXiaomiDevDevice() {
        if (!isXiaomiDevice()) {
            return false;
        }
        String romVersion = getRomVersion();
        if (!TextUtils.isEmpty(romVersion)) {
            return !romVersion.startsWith("v");
        }
        return false;
    }

    public static boolean isXiaomiDevice() {
        if (a != null || (!"xiaomi".equals(a()) && !"xiaomi".equals(b()))) {
            try {
                String reflectSystemProperties = BQCSystemUtil.reflectSystemProperties("ro.build.fingerprint");
                if (!TextUtils.isEmpty(reflectSystemProperties) && reflectSystemProperties.toLowerCase().contains("xiaomi")) {
                    a = "xiaomi";
                }
            } catch (Throwable unused) {
            }
            return "xiaomi".equals(a);
        }
        a = "xiaomi";
        return true;
    }
}
