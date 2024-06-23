package com.alipay.sdk.m.t;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.m.u.e;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: Taobao */
public class a {
    public static final String g = "alipay_tid_storage";
    public static final String h = "tidinfo";
    public static final String i = "tid";
    public static final String j = "client_key";
    public static final String k = "timestamp";
    public static final String l = "vimei";
    public static final String m = "vimsi";
    public static Context n;
    public static a o;
    public String a;
    public String b;
    public long c;
    public String d;
    public String e;
    public boolean f = false;

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (o == null) {
                o = new a();
            }
            if (n == null) {
                o.c(context);
            }
            aVar = o;
        }
        return aVar;
    }

    private boolean b(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    private void c(Context context) {
        if (context != null) {
            n = context.getApplicationContext();
        }
        if (!this.f) {
            this.f = true;
            l();
        }
    }

    private String k() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(9000) + 1000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c  */
    private void l() {
        String str;
        String str2;
        String str3;
        String str4;
        Exception e2;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        String str5 = null;
        try {
            String a2 = C0135a.a(g, h, true);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject = new JSONObject(a2);
                str4 = jSONObject.optString("tid", "");
                try {
                    str2 = jSONObject.optString(j, "");
                } catch (Exception e3) {
                    e2 = e3;
                    str2 = null;
                    str = str2;
                    e.a(e2);
                    str3 = str5;
                    str5 = str4;
                    e.b(com.alipay.sdk.m.l.a.z, "tid_str: load");
                    if (b(str5, str2, str, str3)) {
                    }
                }
                try {
                    valueOf = Long.valueOf(jSONObject.optLong("timestamp", System.currentTimeMillis()));
                    str = jSONObject.optString(l, "");
                    try {
                        str5 = jSONObject.optString(m, "");
                    } catch (Exception e4) {
                        e2 = e4;
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    str = null;
                    e.a(e2);
                    str3 = str5;
                    str5 = str4;
                    e.b(com.alipay.sdk.m.l.a.z, "tid_str: load");
                    if (b(str5, str2, str, str3)) {
                    }
                }
                str3 = str5;
                str5 = str4;
                e.b(com.alipay.sdk.m.l.a.z, "tid_str: load");
                if (b(str5, str2, str, str3)) {
                    m();
                    return;
                }
                this.a = str5;
                this.b = str2;
                this.c = valueOf.longValue();
                this.d = str;
                this.e = str3;
                return;
            }
            str3 = null;
            str2 = null;
            str = null;
            e.b(com.alipay.sdk.m.l.a.z, "tid_str: load");
            if (b(str5, str2, str, str3)) {
            }
        } catch (Exception e6) {
            e2 = e6;
            str4 = null;
            str2 = null;
            str = str2;
            e.a(e2);
            str3 = str5;
            str5 = str4;
            e.b(com.alipay.sdk.m.l.a.z, "tid_str: load");
            if (b(str5, str2, str, str3)) {
            }
        }
    }

    private void m() {
        this.a = "";
        this.b = b();
        this.c = System.currentTimeMillis();
        this.d = k();
        this.e = k();
        C0135a.b(g, h);
    }

    private void n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.a);
            jSONObject.put(j, this.b);
            jSONObject.put("timestamp", this.c);
            jSONObject.put(l, this.d);
            jSONObject.put(m, this.e);
            C0135a.a(g, h, jSONObject.toString(), true);
        } catch (Exception e2) {
            e.a(e2);
        }
    }

    private void o() {
    }

    public String d() {
        return this.a;
    }

    public Long e() {
        return Long.valueOf(this.c);
    }

    public String f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }

    public boolean h() {
        return i();
    }

    public boolean i() {
        return TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e);
    }

    public String b() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    /* renamed from: com.alipay.sdk.m.t.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0135a {
        public static boolean a(String str, String str2) {
            if (a.n == null) {
                return false;
            }
            return a.n.getSharedPreferences(str, 0).contains(str2);
        }

        public static void b(String str, String str2) {
            if (a.n != null) {
                a.n.getSharedPreferences(str, 0).edit().remove(str2).apply();
            }
        }

        public static boolean c(String str, String str2) {
            if (a.n == null) {
                return false;
            }
            return a.n.getSharedPreferences(str, 0).contains(str2);
        }

        public static String d(String str, String str2) {
            return a(str, str2, true);
        }

        public static String a(String str, String str2, boolean z) {
            if (a.n == null) {
                return null;
            }
            String string = a.n.getSharedPreferences(str, 0).getString(str2, null);
            if (!TextUtils.isEmpty(string) && z) {
                string = com.alipay.sdk.m.n.e.a(a(), string, string);
                if (TextUtils.isEmpty(string)) {
                    e.b(com.alipay.sdk.m.l.a.z, "tid_str: pref failed");
                }
            }
            e.b(com.alipay.sdk.m.l.a.z, "tid_str: from local");
            return string;
        }

        public static void a(String str, String str2, String str3) {
            a(str, str2, str3, true);
        }

        public static void a(String str, String str2, String str3, boolean z) {
            if (a.n != null) {
                SharedPreferences sharedPreferences = a.n.getSharedPreferences(str, 0);
                if (z) {
                    String a = a();
                    String b = com.alipay.sdk.m.n.e.b(a, str3, str3);
                    if (TextUtils.isEmpty(b)) {
                        String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, a);
                    }
                    str3 = b;
                }
                sharedPreferences.edit().putString(str2, str3).apply();
            }
        }

        public static String a() {
            String str;
            try {
                str = a.n.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                e.a(th);
                str = "";
            }
            return (str + "0000000000000000000000000000").substring(0, 24);
        }
    }

    public String c() {
        return this.b;
    }

    public void a() {
        e.b(com.alipay.sdk.m.l.a.z, "tid_str: del");
        m();
    }

    public void a(String str, String str2) {
        e.b(com.alipay.sdk.m.l.a.z, "tid_str: save");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.a = str;
            this.b = str2;
            this.c = System.currentTimeMillis();
            n();
            o();
        }
    }
}
