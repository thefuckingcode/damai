package com.alipay.android.phone.mobilesdk.socketcraft.util;

/* compiled from: Taobao */
public class StringUtils {
    public static final boolean isEmpty(String str) {
        return "".equals(str) || str == null || str.trim().length() <= 0;
    }
}
