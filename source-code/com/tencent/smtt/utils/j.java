package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* compiled from: PropertyUtils */
public class j {
    private static Class a;
    private static Method b;

    static {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            a = cls;
            b = cls.getDeclaredMethod("get", String.class, String.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return b(str, str2);
    }

    private static String b(String str, String str2) {
        Method method;
        Class cls = a;
        if (cls == null || (method = b) == null) {
            return str2;
        }
        try {
            return (String) method.invoke(cls, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }
}
