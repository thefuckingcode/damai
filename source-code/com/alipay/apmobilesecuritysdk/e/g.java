package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import com.alipay.sdk.m.b0.e;
import com.alipay.sdk.m.y.c;
import com.alipay.sdk.m.z.a;

/* compiled from: Taobao */
public final class g {
    public static synchronized String a(Context context, String str) {
        synchronized (g.class) {
            String a = e.a(context, "openapi_file_pri", "openApi" + str, "");
            if (a.a(a)) {
                return "";
            }
            String b = c.b(c.a(), a);
            return a.a(b) ? "" : b;
        }
    }

    public static synchronized void a() {
        synchronized (g.class) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (g.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (edit != null) {
                edit.clear();
                edit.commit();
            }
        }
    }

    public static synchronized void a(Context context, String str, String str2) {
        synchronized (g.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
                if (edit != null) {
                    edit.putString("openApi" + str, c.a(c.a(), str2));
                    edit.commit();
                }
            } catch (Throwable unused) {
            }
        }
    }
}
