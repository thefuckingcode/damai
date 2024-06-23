package com.alipay.sdk.m.s;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class a {
    public static final String A = "act_info";
    public static final String B = "UTF-8";
    public static final String C = "new_external_info==";
    public static final String m = "\"&";
    public static final String n = "&";
    public static final String o = "bizcontext=\"";
    public static final String p = "bizcontext=";
    public static final String q = "\"";
    public static final String r = "appkey";
    public static final String s = "ty";
    public static final String t = "sv";
    public static final String u = "an";
    public static final String v = "setting";
    public static final String w = "av";
    public static final String x = "sdk_start_time";
    public static final String y = "extInfo";
    public static final String z = "ap_link_token";
    public String a = "";
    public String b = "";
    public Context c = null;
    public final String d;
    public final long e;
    public final int f;
    public final String g;
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;
    public final ActivityInfo k;
    public final b l;

    public a(Context context, String str, String str2) {
        String str3;
        boolean isEmpty = TextUtils.isEmpty(str2);
        this.l = new b(context, isEmpty);
        String b2 = b(str, this.b);
        this.d = b2;
        this.e = SystemClock.elapsedRealtime();
        this.f = n.g();
        ActivityInfo a2 = n.a(context);
        this.k = a2;
        this.g = str2;
        if (!isEmpty) {
            com.alipay.sdk.m.k.a.a(this, b.l, "eptyp", str2 + "|" + b2);
            if (a2 != null) {
                str3 = a2.name + "|" + a2.launchMode;
            } else {
                str3 = "null";
            }
            com.alipay.sdk.m.k.a.a(this, b.l, "actInfo", str3);
            com.alipay.sdk.m.k.a.a(this, b.l, NotificationCompat.CATEGORY_SYSTEM, n.a(this));
            com.alipay.sdk.m.k.a.a(this, b.l, "sdkv", "5c4d8f1-clean");
        }
        try {
            this.c = context.getApplicationContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.a = packageInfo.versionName;
            this.b = packageInfo.packageName;
        } catch (Exception e2) {
            e.a(e2);
        }
        if (!isEmpty) {
            com.alipay.sdk.m.k.a.a(this, b.l, IRequestConst.U + n.g());
            com.alipay.sdk.m.k.a.a(this, b.l, b.Q, "" + SystemClock.elapsedRealtime());
            com.alipay.sdk.m.k.a.a(context, this, str, this.d);
        }
        if (!isEmpty && com.alipay.sdk.m.m.a.D().s()) {
            com.alipay.sdk.m.m.a.D().a(this, this.c, true, 2);
        }
    }

    private String f(String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject;
        String substring = str.substring(str2.length());
        boolean z2 = false;
        String substring2 = substring.substring(0, substring.length() - str3.length());
        if (substring2.length() < 2 || !substring2.startsWith("\"") || !substring2.endsWith("\"")) {
            jSONObject = new JSONObject(substring2);
        } else {
            jSONObject = new JSONObject(substring2.substring(1, substring2.length() - 1));
            z2 = true;
        }
        String a2 = a(jSONObject);
        if (z2) {
            a2 = "\"" + a2 + "\"";
        }
        return str2 + a2 + str3;
    }

    private String g(String str) {
        try {
            String d2 = d(str, "&", p);
            if (TextUtils.isEmpty(d2)) {
                return str + "&" + c(p, "");
            }
            int indexOf = str.indexOf(d2);
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + d2.length());
            return substring + f(d2, p, "") + substring2;
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(this, b.l, "fmt1", th, str);
            return str;
        }
    }

    public static a h() {
        return null;
    }

    private String h(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str.substring(19));
            jSONObject.put("bizcontext", e(jSONObject.optString("bizcontext")));
            return C + jSONObject.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    private String i(String str) {
        try {
            String d2 = d(str, m, o);
            if (TextUtils.isEmpty(d2)) {
                return str + "&" + c(o, "\"");
            }
            if (!d2.endsWith("\"")) {
                d2 = d2 + "\"";
            }
            int indexOf = str.indexOf(d2);
            return str.substring(0, indexOf) + f(d2, o, "\"") + str.substring(indexOf + d2.length());
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(this, b.l, "fmt2", th, str);
            return str;
        }
    }

    private boolean j(String str) {
        return !str.contains(m);
    }

    private JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(z, this.d);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public Context a() {
        return this.c;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.i;
    }

    public boolean e() {
        return this.h;
    }

    public static String b(String str, String str2) {
        try {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[4];
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            if (str2 == null) {
                str2 = "";
            }
            objArr[1] = str2;
            objArr[2] = Long.valueOf(System.currentTimeMillis());
            objArr[3] = UUID.randomUUID().toString();
            return String.format("EP%s%s_%s", "1", n.g(String.format(locale, "%s%s%d%s", objArr)), Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable unused) {
            return "-";
        }
    }

    private String d(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(str2);
        for (int i2 = 0; i2 < split.length; i2++) {
            if (!TextUtils.isEmpty(split[i2]) && split[i2].startsWith(str3)) {
                return split[i2];
            }
        }
        return null;
    }

    private String e(String str) throws JSONException {
        return a(new JSONObject(str));
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(C)) {
            return h(str);
        }
        if (j(str)) {
            return g(str);
        }
        return i(str);
    }

    public void c(boolean z2) {
        this.j = z2;
    }

    /* renamed from: com.alipay.sdk.m.s.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class C0134a {
        public static final HashMap<UUID, a> a = new HashMap<>();
        public static final HashMap<String, a> b = new HashMap<>();
        public static final String c = "i_uuid_b_c";

        public static void a(a aVar, Intent intent) {
            if (aVar != null && intent != null) {
                UUID randomUUID = UUID.randomUUID();
                a.put(randomUUID, aVar);
                intent.putExtra(c, randomUUID);
            }
        }

        public static a a(Intent intent) {
            if (intent == null) {
                return null;
            }
            Serializable serializableExtra = intent.getSerializableExtra(c);
            if (serializableExtra instanceof UUID) {
                return a.remove((UUID) serializableExtra);
            }
            return null;
        }

        public static void a(a aVar, String str) {
            if (aVar != null && !TextUtils.isEmpty(str)) {
                b.put(str, aVar);
            }
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return b.remove(str);
        }
    }

    private String c(String str, String str2) {
        return str + a(new JSONObject()) + str2;
    }

    public String a(JSONObject jSONObject) {
        String str;
        try {
            if (!jSONObject.has("appkey")) {
                jSONObject.put("appkey", com.alipay.sdk.m.l.a.f);
            }
            if (!jSONObject.has(s)) {
                jSONObject.put(s, "and_lite");
            }
            if (!jSONObject.has(t)) {
                jSONObject.put(t, "h.a.3.8.11");
            }
            if (!jSONObject.has(u)) {
                jSONObject.put(u, this.b);
            }
            if (!jSONObject.has(w)) {
                jSONObject.put(w, this.a);
            }
            if (!jSONObject.has(x)) {
                jSONObject.put(x, System.currentTimeMillis());
            }
            if (!jSONObject.has(y)) {
                jSONObject.put(y, k());
            }
            if (!jSONObject.has(A)) {
                if (this.k != null) {
                    str = this.k.name + "|" + this.k.launchMode;
                } else {
                    str = "null";
                }
                jSONObject.put(A, str);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(this, b.l, "fmt3", th, String.valueOf(jSONObject));
            e.a(th);
            return jSONObject != null ? jSONObject.toString() : "{}";
        }
    }

    public void b(boolean z2) {
        this.h = z2;
    }

    public boolean f() {
        return this.j;
    }

    public static HashMap<String, String> a(a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (aVar != null) {
            hashMap.put("sdk_ver", "15.8.11");
            hashMap.put("app_name", aVar.b);
            hashMap.put("token", aVar.d);
            hashMap.put("call_type", aVar.g);
            hashMap.put("ts_api_invoke", String.valueOf(aVar.e));
            com.alipay.sdk.m.u.a.a(aVar, hashMap);
        }
        return hashMap;
    }

    public void a(boolean z2) {
        this.i = z2;
    }
}
