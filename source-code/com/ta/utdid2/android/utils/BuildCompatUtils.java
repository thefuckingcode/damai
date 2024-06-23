package com.ta.utdid2.android.utils;

import android.os.Build;

/* compiled from: Taobao */
public class BuildCompatUtils {
    public static boolean isAtLeastM() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isAtLeastQ() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        String str = Build.VERSION.CODENAME;
        if (str.length() != 1 || str.charAt(0) < 'Q' || str.charAt(0) > 'Z') {
            return false;
        }
        return true;
    }
}
