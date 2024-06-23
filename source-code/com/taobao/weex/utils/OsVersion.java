package com.taobao.weex.utils;

import android.os.Build;

/* compiled from: Taobao */
public class OsVersion {
    private static boolean a = (getApiVersion() >= 18);

    public static int getApiVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean isAtLeastJB_MR2() {
        return a;
    }
}
