package com.alipay.sdk.m.b0;

import android.content.Context;
import com.alipay.sdk.m.y.c;
import java.util.HashMap;

/* compiled from: Taobao */
public class a {
    public static String a(Context context, String str, String str2) {
        synchronized (a.class) {
            String str3 = null;
            if (context != null) {
                if (!com.alipay.sdk.m.z.a.a(str) && !com.alipay.sdk.m.z.a.a(str2)) {
                    try {
                        String a = e.a(context, str, str2, "");
                        if (com.alipay.sdk.m.z.a.a(a)) {
                            return null;
                        }
                        str3 = c.b(c.a(), a);
                        return str3;
                    } catch (Throwable unused) {
                    }
                }
            }
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
            if (!com.alipay.sdk.m.z.a.a(str) && !com.alipay.sdk.m.z.a.a(str2) && context != null) {
                try {
                    String a = c.a(c.a(), str3);
                    HashMap hashMap = new HashMap();
                    hashMap.put(str2, a);
                    e.a(context, str, hashMap);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
