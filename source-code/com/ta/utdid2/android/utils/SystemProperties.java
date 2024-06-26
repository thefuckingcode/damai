package com.ta.utdid2.android.utils;

import com.ta.audid.utils.UtdidLogger;
import tb.gl1;

/* compiled from: Taobao */
public class SystemProperties {
    public static String get(String str) {
        return get(str, "");
    }

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
