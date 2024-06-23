package com.ta.audid.utils;

import tb.gl1;

@Deprecated
/* compiled from: Taobao */
public class SystemProperties {
    @Deprecated
    public static String get(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, str);
        } catch (Exception e) {
            UtdidLogger.se("", e, new Object[0]);
            return "";
        }
    }

    @Deprecated
    public static String get(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            UtdidLogger.se("", e, new Object[0]);
            return str2;
        }
    }
}
