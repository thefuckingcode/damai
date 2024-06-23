package com.youku.tinywindow.floatwindow.permission.rom;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.sdk.m.c.a;
import com.taobao.weex.annotation.JSMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public class RomUtils {
    private static final String TAG = "RomUtils";

    public static boolean checkIs360Rom() {
        String manufacturer = Build.getMANUFACTURER();
        return manufacturer.contains("QiKU") || manufacturer.contains("360");
    }

    public static boolean checkIsHuaweiRom() {
        return Build.getMANUFACTURER().contains("HUAWEI");
    }

    public static boolean checkIsMeizuRom() {
        String systemProperty = getSystemProperty("ro.build.display.id");
        if (TextUtils.isEmpty(systemProperty)) {
            return false;
        }
        if (systemProperty.contains("flyme") || systemProperty.toLowerCase().contains("flyme")) {
            return true;
        }
        return false;
    }

    public static boolean checkIsMiuiRom() {
        return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name"));
    }

    public static boolean checkIsOppoRom() {
        String manufacturer = Build.getMANUFACTURER();
        return manufacturer.contains("OPPO") || manufacturer.contains("oppo");
    }

    public static double getEmuiVersion() {
        try {
            String systemProperty = getSystemProperty(a.a);
            return Double.parseDouble(systemProperty.substring(systemProperty.indexOf(JSMethod.NOT_SET) + 1));
        } catch (Exception e) {
            e.printStackTrace();
            return 4.0d;
        }
    }

    public static int getMiuiVersion() {
        String systemProperty = getSystemProperty("ro.miui.ui.version.name");
        if (systemProperty == null) {
            return -1;
        }
        try {
            return Integer.parseInt(systemProperty.substring(1));
        } catch (Exception unused) {
            Log.e(TAG, "get miui version code error, version : " + systemProperty);
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a A[SYNTHETIC, Splitter:B:17:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067 A[SYNTHETIC, Splitter:B:25:0x0067] */
    public static String getSystemProperty(String str) {
        Throwable th;
        BufferedReader bufferedReader;
        IOException e;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    Log.e(TAG, "Exception while closing InputStream", e2);
                }
                return readLine;
            } catch (IOException e3) {
                e = e3;
                try {
                    Log.e(TAG, "Unable to read sysprop " + str, e);
                    if (bufferedReader != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                            Log.e(TAG, "Exception while closing InputStream", e4);
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
            Log.e(TAG, "Unable to read sysprop " + str, e);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    Log.e(TAG, "Exception while closing InputStream", e6);
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }
}
