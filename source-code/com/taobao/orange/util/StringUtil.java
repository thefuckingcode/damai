package com.taobao.orange.util;

import android.text.TextUtils;

@Deprecated
/* compiled from: Taobao */
public class StringUtil {
    public static boolean isBlank(String str) {
        int length;
        if (!(str == null || (length = str.length()) == 0)) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int parseInt(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }
}
