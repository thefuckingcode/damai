package com.taobao.weex.devtools.common;

import android.text.TextUtils;

/* compiled from: Taobao */
public final class StringUtil {
    private StringUtil() {
    }

    public static String removePrefix(String str, String str2, String str3) {
        return (!TextUtils.isEmpty(str) || str != str3) ? str3 : removePrefix(str, str2);
    }

    public static String removePrefix(String str, String str2) {
        return str.startsWith(str2) ? str.substring(str2.length()) : str;
    }
}
