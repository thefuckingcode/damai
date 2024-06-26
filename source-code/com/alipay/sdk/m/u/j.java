package com.alipay.sdk.m.u;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.n.e;
import com.alipay.sdk.m.s.a;

/* compiled from: Taobao */
public class j {
    public static String a;

    public static synchronized boolean a(Context context, String str) {
        boolean z;
        synchronized (j.class) {
            try {
                z = PreferenceManager.getDefaultSharedPreferences(context).contains(str);
            } catch (Throwable th) {
                e.a(th);
                z = false;
            }
        }
        return z;
    }

    public static synchronized void b(Context context, String str) {
        synchronized (j.class) {
            try {
                PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).apply();
            } catch (Throwable th) {
                e.a(th);
            }
        }
        return;
    }

    public static synchronized String a(a aVar, Context context, String str, String str2) {
        String str3;
        synchronized (j.class) {
            str3 = null;
            try {
                String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
                if (!TextUtils.isEmpty(string)) {
                    str3 = e.a(a(context), string, str);
                }
                if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(str3)) {
                    com.alipay.sdk.m.k.a.b(aVar, "cp", b.F, String.format("%s,%s", str, string));
                }
            } catch (Exception e) {
                e.a(e);
            }
        }
        return str3;
    }

    public static synchronized void b(a aVar, Context context, String str, String str2) {
        synchronized (j.class) {
            try {
                String b = e.b(a(context), str2, str);
                if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(b)) {
                    com.alipay.sdk.m.k.a.b(aVar, "cp", b.G, String.format("%s,%s", str, str2));
                }
                PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, b).apply();
            } catch (Throwable th) {
                e.a(th);
            }
        }
    }

    public static String a(Context context) {
        String str;
        if (TextUtils.isEmpty(a)) {
            try {
                str = context.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                e.a(th);
                str = "";
            }
            a = (str + "0000000000000000000000000000").substring(0, 24);
        }
        return a;
    }
}
