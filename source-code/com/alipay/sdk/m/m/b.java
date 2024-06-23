package com.alipay.sdk.m.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.sdk.m.j.a;
import com.alipay.sdk.m.u.c;
import com.alipay.sdk.m.u.n;
import java.util.Random;
import tb.jl1;

/* compiled from: Taobao */
public class b {
    public static final String d = "virtualImeiAndImsi";
    public static final String e = "virtual_imei";
    public static final String f = "virtual_imsi";
    public static volatile b g;
    public String a;
    public String b = "sdk-and-lite";
    public String c;

    public b() {
        String a2 = a.a();
        if (!a.b()) {
            this.b += '_' + a2;
        }
    }

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            if (g == null) {
                g = new b();
            }
            bVar = g;
        }
        return bVar;
    }

    public static String c() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(9000) + 1000);
    }

    public static String d() {
        return "-1;-1";
    }

    public static String e() {
        return "1";
    }

    public static String f() {
        String str;
        Context b2 = com.alipay.sdk.m.s.b.d().b();
        SharedPreferences sharedPreferences = b2.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(e, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(com.alipay.sdk.m.t.a.a(b2).d())) {
            str = c();
        } else {
            str = c.b(b2).b();
        }
        sharedPreferences.edit().putString(e, str).apply();
        return str;
    }

    public static String g() {
        String str;
        Context b2 = com.alipay.sdk.m.s.b.d().b();
        SharedPreferences sharedPreferences = b2.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(f, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(com.alipay.sdk.m.t.a.a(b2).d())) {
            String c2 = com.alipay.sdk.m.s.b.d().c();
            if (TextUtils.isEmpty(c2) || c2.length() < 18) {
                str = c();
            } else {
                str = c2.substring(3, 18);
            }
        } else {
            str = c.b(b2).c();
        }
        sharedPreferences.edit().putString(f, str).apply();
        return str;
    }

    public String a() {
        return this.c;
    }

    public static synchronized void a(String str) {
        synchronized (b.class) {
            if (!TextUtils.isEmpty(str)) {
                PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.m.s.b.d().b()).edit().putString(com.alipay.sdk.m.l.b.i, str).apply();
                com.alipay.sdk.m.l.a.e = str;
            }
        }
    }

    public static String b(com.alipay.sdk.m.s.a aVar, Context context, boolean z) {
        if (z) {
            return "-1";
        }
        try {
            WifiInfo d2 = com.alipay.sdk.m.w.b.d(aVar, context);
            if (d2 != null) {
                return d2.getSSID();
            }
            return "-1";
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "lacking_per_1", th);
            return "-1";
        }
    }

    public static String a(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            sb.append(jl1.BRACKET_START_STR);
            sb.append(packageName);
            sb.append(";");
            sb.append(packageInfo.versionCode);
            sb.append(jl1.BRACKET_END_STR);
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.t.a aVar2, boolean z) {
        Context b2 = com.alipay.sdk.m.s.b.d().b();
        c b3 = c.b(b2);
        if (TextUtils.isEmpty(this.a)) {
            String f2 = n.f();
            String e2 = n.e();
            String c2 = n.c(b2);
            String e3 = n.e(b2);
            String f3 = n.f(b2);
            String a2 = a(b2);
            this.a = "Msp/15.8.11" + " (" + f2 + ";" + e2 + ";" + c2 + ";" + e3 + ";" + f3 + ";" + a2;
        }
        String b4 = c.d(b2).b();
        String b5 = n.b(b2);
        String e4 = e();
        String c3 = b3.c();
        String b6 = b3.b();
        String g2 = g();
        String f4 = f();
        if (aVar2 != null) {
            this.c = aVar2.c();
        }
        String replace = Build.getMANUFACTURER().replace(";", " ");
        String replace2 = Build.getMODEL().replace(";", " ");
        boolean e5 = com.alipay.sdk.m.s.b.e();
        String d2 = b3.d();
        String b7 = b(aVar, b2, z);
        String a3 = a(aVar, b2, z);
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(";");
        sb.append(b4);
        sb.append(";");
        sb.append(b5);
        sb.append(";");
        sb.append(e4);
        sb.append(";");
        sb.append(c3);
        sb.append(";");
        sb.append(b6);
        sb.append(";");
        sb.append(this.c);
        sb.append(";");
        sb.append(replace);
        sb.append(";");
        sb.append(replace2);
        sb.append(";");
        sb.append(e5);
        sb.append(";");
        sb.append(d2);
        sb.append(";");
        sb.append(d());
        sb.append(";");
        sb.append(this.b);
        sb.append(";");
        sb.append(g2);
        sb.append(";");
        sb.append(f4);
        sb.append(";");
        sb.append(b7);
        sb.append(";");
        sb.append(a3);
        if (aVar2 != null) {
            String a4 = com.alipay.sdk.m.w.b.a(aVar, b2, com.alipay.sdk.m.t.a.a(b2).d(), com.alipay.sdk.m.w.b.c(aVar, b2));
            if (!TextUtils.isEmpty(a4)) {
                sb.append(";;;");
                sb.append(a4);
            }
        }
        sb.append(jl1.BRACKET_END_STR);
        return sb.toString();
    }

    public static String a(com.alipay.sdk.m.s.a aVar, Context context, boolean z) {
        if (z) {
            return "00";
        }
        try {
            WifiInfo d2 = com.alipay.sdk.m.w.b.d(aVar, context);
            if (d2 != null) {
                return d2.getBSSID();
            }
            return "00";
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "lacking_per_2", th);
            return "00";
        }
    }
}
