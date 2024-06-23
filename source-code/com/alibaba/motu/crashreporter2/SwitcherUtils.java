package com.alibaba.motu.crashreporter2;

import android.preference.PreferenceManager;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class SwitcherUtils {
    SwitcherUtils() {
    }

    public static String valueOf(String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(Global.getContext()).getString(str, str2);
    }
}
