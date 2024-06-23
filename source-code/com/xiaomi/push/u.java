package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import tb.gl1;

/* compiled from: Taobao */
public class u {
    public static String a(String str, String str2) {
        try {
            return (String) v.a(null, "android.os.SystemProperties").getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            b.m182a("SystemProperties.get: " + e);
            return str2;
        }
    }
}
