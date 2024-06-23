package com.alipay.sdk.m.b0;

import android.content.Context;
import com.alipay.sdk.m.y.c;
import com.alipay.sdk.m.z.a;
import java.util.HashMap;

/* compiled from: Taobao */
public final class d {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        synchronized (d.class) {
            if (!a.a(str) && !a.a(str2) && context != null) {
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
