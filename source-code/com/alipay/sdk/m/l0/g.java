package com.alipay.sdk.m.l0;

import tb.gl1;

/* compiled from: Taobao */
public class g {
    public static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }
}
