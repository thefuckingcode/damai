package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.huawei.hms.opendevice.c;
import com.loc.m;
import io.flutter.wpkbridge.U4WPKAdapter;
import java.util.ArrayList;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.x53;

/* compiled from: Taobao */
public final class i1 {
    private static String A = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
    private static long B = 0;
    public static boolean C = false;
    public static boolean D = false;
    public static int E = 20480;
    public static int F = 10800000;
    private static volatile boolean a = false;
    private static boolean b = true;
    private static int c = 1000;
    private static int d = 200;
    private static boolean e = false;
    private static int f = 20;
    private static int g;
    private static volatile int h;
    private static volatile boolean i = false;
    private static boolean j = true;
    private static long k = 300000;
    private static boolean l = false;
    private static double m = 0.618d;
    private static boolean n = true;
    private static int o = 80;
    static long p = DateUtils.MILLIS_PER_HOUR;
    private static boolean q = true;
    private static boolean r = false;
    static boolean s = true;
    private static boolean t = true;
    private static long u = -1;
    private static boolean v = true;
    private static int w = 1;
    private static boolean x = false;
    private static int y = 5;
    private static boolean z = false;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements m.a {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // com.loc.m.a
        public final void a(m.b bVar) {
            i1.g(this.a, bVar);
        }
    }

    static {
        new ArrayList();
        new ArrayList();
    }

    public static boolean A() {
        return r;
    }

    public static boolean B() {
        return s;
    }

    public static boolean C() {
        return t;
    }

    public static long D() {
        return u;
    }

    public static boolean E() {
        return z;
    }

    public static boolean F() {
        return x;
    }

    public static String G() {
        return v1.v(A);
    }

    public static boolean H() {
        return v && w > 0;
    }

    public static int I() {
        return w;
    }

    public static long J() {
        return B;
    }

    public static void a(Context context) {
        if (!a) {
            a = true;
            m.e(context, j1.q(), j1.s(), new a(context));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:4|(2:5|6)|9|10|11|12|13|14|(4:16|17|18|(2:25|30)(2:23|24))) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x003c */
    private static void b(Context context, JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13S");
            if (optJSONObject != null) {
                try {
                    long optInt = (long) (optJSONObject.optInt("at", 123) * 60 * 1000);
                    p = optInt;
                    x53.i(editor, "13S_at", optInt);
                } catch (Throwable th) {
                    j1.h(th, "AuthUtil", "requestSdkAuthInterval");
                }
                p(optJSONObject, editor);
                boolean t2 = m.t(optJSONObject.optString("nla"), true);
                q = t2;
                x53.k(editor, "13S_nla", t2);
                boolean t3 = m.t(optJSONObject.optString("asw"), true);
                t = t3;
                x53.k(editor, "asw", t3);
                try {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("mlpl");
                    if (optJSONArray != null || optJSONArray.length() <= 0 || context == null) {
                        r = false;
                        x53.g(editor, "13S_mlpl");
                        return;
                    }
                    x53.j(editor, "13S_mlpl", v1.r(optJSONArray.toString()));
                    r = h(context, optJSONArray);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th2) {
            j1.h(th2, "AuthUtil", "loadConfigAbleStatus");
        }
    }

    private static void c(m.b bVar, SharedPreferences.Editor editor) {
        try {
            m.b.a aVar = bVar.c;
            if (aVar != null) {
                boolean z2 = aVar.a;
                b = z2;
                x53.k(editor, "exception", z2);
                JSONObject jSONObject = aVar.b;
                if (jSONObject != null) {
                    c = jSONObject.optInt("fn", c);
                    int optInt = jSONObject.optInt("mpn", d);
                    d = optInt;
                    if (optInt > 500) {
                        d = 500;
                    }
                    if (d < 30) {
                        d = 30;
                    }
                    e = m.t(jSONObject.optString("igu"), false);
                    f = jSONObject.optInt("ms", f);
                    h = jSONObject.optInt("rot", 0);
                    g = jSONObject.optInt("pms", 0);
                }
                bq.b(c, e, f, g);
                bs.f(e, g);
                x53.h(editor, "fn", c);
                x53.h(editor, "mpn", d);
                x53.k(editor, "igu", e);
                x53.h(editor, "ms", f);
                x53.h(editor, "rot", h);
                x53.h(editor, "pms", g);
            }
        } catch (Throwable th) {
            j1.h(th, "AuthUtil", "loadConfigDataUploadException");
        }
    }

    private static void d(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("11G");
            if (optJSONObject != null) {
                boolean t2 = m.t(optJSONObject.optString("able"), true);
                j = t2;
                if (t2) {
                    k = (long) (optJSONObject.optInt(c.a, 300) * 1000);
                }
                l = m.t(optJSONObject.optString("fa"), false);
                m = Math.min(1.0d, Math.max(0.2d, optJSONObject.optDouble("ms", 0.618d)));
                x53.k(editor, AdUtConstants.XAD_UT_ARG_CA, j);
                x53.i(editor, IRequestConst.CT, k);
                x53.k(editor, "11G_fa", l);
                x53.j(editor, "11G_ms", String.valueOf(m));
            }
        } catch (Throwable th) {
            j1.h(th, "AuthUtil", "loadConfigDataCacheAble");
        }
    }

    public static boolean e() {
        return b;
    }

    public static boolean f(long j2) {
        if (!j) {
            return false;
        }
        long g2 = m1.g() - j2;
        long j3 = k;
        return j3 < 0 || g2 < j3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0038 A[SYNTHETIC, Splitter:B:22:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    static boolean g(Context context, m.b bVar) {
        SharedPreferences.Editor editor;
        try {
            editor = x53.c(context, "pref");
            try {
                c(bVar, editor);
                m(context);
                JSONObject jSONObject = bVar.b;
                if (jSONObject == null) {
                    if (editor != null) {
                        try {
                            x53.f(editor);
                        } catch (Throwable unused) {
                        }
                    }
                    return true;
                }
                b(context, jSONObject, editor);
                d(jSONObject, editor);
                n(jSONObject, editor);
                q(jSONObject, editor);
                v(jSONObject, editor);
                s(jSONObject, editor);
                w(jSONObject, editor);
                k(jSONObject, editor);
                if (editor != null) {
                    try {
                        x53.f(editor);
                    } catch (Throwable unused2) {
                    }
                }
                return true;
            } catch (Throwable unused3) {
                if (editor != null) {
                }
            }
        } catch (Throwable unused4) {
            editor = null;
            if (editor != null) {
                return false;
            }
            try {
                x53.f(editor);
                return false;
            } catch (Throwable unused5) {
                return false;
            }
        }
    }

    private static boolean h(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0 && context != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (m1.F(context, jSONArray.getString(i2))) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static int i() {
        return d;
    }

    public static void j(Context context) {
        if (!i) {
            i = true;
            try {
                b = x53.l(context, "pref", "exception", b);
                m(context);
            } catch (Throwable th) {
                j1.h(th, "AuthUtil", "loadLastAbleState p1");
            }
            try {
                c = x53.a(context, "pref", "fn", c);
                d = x53.a(context, "pref", "mpn", d);
                e = x53.l(context, "pref", "igu", e);
                f = x53.a(context, "pref", "ms", f);
                h = x53.a(context, "pref", "rot", 0);
                int a2 = x53.a(context, "pref", "pms", 0);
                g = a2;
                bq.b(c, e, f, a2);
                bs.f(e, g);
            } catch (Throwable th2) {
                j1.h(th2, "AuthUtil", "loadLastAbleState p2");
            }
            try {
                j = x53.l(context, "pref", AdUtConstants.XAD_UT_ARG_CA, j);
                k = x53.b(context, "pref", IRequestConst.CT, k);
                l = x53.l(context, "pref", "11G_fa", l);
                double doubleValue = Double.valueOf(x53.e(context, "pref", "11G_ms", String.valueOf(m))).doubleValue();
                m = doubleValue;
                m = Math.max(0.2d, doubleValue);
            } catch (Throwable th3) {
                j1.h(th3, "AuthUtil", "loadLastAbleState p3");
            }
            try {
                s = x53.l(context, "pref", "fr", s);
            } catch (Throwable th4) {
                j1.h(th4, "AuthUtil", "loadLastAbleState p4");
            }
            try {
                t = x53.l(context, "pref", "asw", t);
            } catch (Throwable th5) {
                j1.h(th5, "AuthUtil", "loadLastAbleState p5");
            }
            try {
                u = x53.b(context, "pref", "awsi", u);
            } catch (Throwable th6) {
                j1.h(th6, "AuthUtil", "loadLastAbleState p6");
            }
            try {
                v = x53.l(context, "pref", "15ua", v);
                w = x53.a(context, "pref", "15un", w);
                B = x53.b(context, "pref", "15ust", B);
            } catch (Throwable th7) {
                j1.h(th7, "AuthUtil", "loadLastAbleState p7");
            }
            try {
                x = x53.l(context, "pref", "ok9", x);
                y = x53.a(context, "pref", "ok10", y);
                A = x53.e(context, "pref", "ok11", A);
            } catch (Throwable th8) {
                j1.h(th8, "AuthUtil", "loadLastAbleState p8");
            }
            try {
                C = x53.l(context, "pref", "17ya", false);
                D = x53.l(context, "pref", "17ym", false);
                F = x53.a(context, "pref", "17yi", 2) * 60 * 60 * 1000;
                E = x53.a(context, "pref", "17yx", 100) * 1024;
            } catch (Throwable th9) {
                j1.h(th9, "AuthUtil", "loadLastAbleState p9");
            }
            try {
                m1.B();
                p = x53.b(context, "pref", "13S_at", p);
                q = x53.l(context, "pref", "13S_nla", q);
                n = x53.l(context, "pref", "13J_able", n);
                o = x53.a(context, "pref", "13J_c", o);
            } catch (Throwable th10) {
                j1.h(th10, "AuthUtil", "loadLastAbleState p10");
            }
            m.x(context);
            try {
                String e2 = x53.e(context, "pref", "13S_mlpl", null);
                if (!TextUtils.isEmpty(e2)) {
                    r = h(context, new JSONArray(v1.v(e2)));
                }
            } catch (Throwable th11) {
                j1.h(th11, "AuthUtil", "loadLastAbleState p11");
            }
            try {
                boolean l2 = x53.l(context, "pref", "197a", false);
                String e3 = x53.e(context, "pref", "197dv", "");
                String e4 = x53.e(context, "pref", "197tv", "");
                if (l2 && j1.a.equals(e3)) {
                    for (String str : j1.b) {
                        if (str.equals(e4)) {
                            j1.a = e4;
                        }
                    }
                }
            } catch (Throwable th12) {
                j1.h(th12, "AuthUtil", "loadLastAbleState p12");
            }
        }
    }

    private static void k(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("197");
                if (jSONObject2 != null) {
                    boolean t2 = m.t(jSONObject2.optString("able"), false);
                    x53.k(editor, "197a", t2);
                    if (t2) {
                        x53.j(editor, "197dv", jSONObject2.optString(com.alipay.sdk.m.s.a.t, ""));
                        x53.j(editor, "197tv", jSONObject2.optString("tv", ""));
                        return;
                    }
                    x53.j(editor, "197dv", "");
                    x53.j(editor, "197tv", "");
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static int l() {
        if (h < 0) {
            h = 0;
        }
        return h;
    }

    public static void m(Context context) {
        try {
            u1 q2 = j1.q();
            q2.c(b);
            an.g(context, q2);
        } catch (Throwable unused) {
        }
    }

    private static void n(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13J");
            if (optJSONObject != null) {
                boolean t2 = m.t(optJSONObject.optString("able"), true);
                n = t2;
                if (t2) {
                    o = optJSONObject.optInt(c.a, o);
                }
                x53.k(editor, "13J_able", n);
                x53.h(editor, "13J_c", o);
            }
        } catch (Throwable th) {
            j1.h(th, "AuthUtil", "loadConfigDataGpsGeoAble");
        }
    }

    public static long o() {
        return k;
    }

    private static void p(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject != null) {
            try {
                boolean t2 = m.t(jSONObject.optString("re"), true);
                s = t2;
                x53.k(editor, "fr", t2);
            } catch (Throwable th) {
                j1.h(th, "AuthUtil", "checkReLocationAble");
            }
        }
    }

    private static void q(JSONObject jSONObject, SharedPreferences.Editor editor) {
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15O");
            if (optJSONObject != null) {
                if (!m.t(optJSONObject.optString("able"), false) || ((optJSONArray = optJSONObject.optJSONArray("fl")) != null && optJSONArray.length() > 0 && !optJSONArray.toString().contains(Build.getMANUFACTURER()))) {
                    u = -1;
                } else {
                    u = (long) (optJSONObject.optInt("iv", 30) * 1000);
                }
                x53.i(editor, "awsi", u);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean r() {
        return j;
    }

    private static void s(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("17Y");
                if (jSONObject2 != null) {
                    boolean t2 = m.t(jSONObject2.optString("able"), false);
                    C = t2;
                    x53.k(editor, "17ya", t2);
                    boolean t3 = m.t(jSONObject2.optString("mup"), false);
                    D = t3;
                    x53.k(editor, "17ym", t3);
                    int optInt = jSONObject2.optInt("max", 20);
                    if (optInt > 0) {
                        x53.h(editor, "17yx", optInt);
                        E = optInt * 1024;
                    }
                    int optInt2 = jSONObject2.optInt("inv", 3);
                    if (optInt2 > 0) {
                        x53.h(editor, "17yi", optInt2);
                        F = optInt2 * 60 * 60 * 1000;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean t() {
        return l;
    }

    public static double u() {
        return m;
    }

    private static void v(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15U");
            if (optJSONObject != null) {
                boolean t2 = m.t(optJSONObject.optString("able"), true);
                int optInt = optJSONObject.optInt("yn", w);
                B = optJSONObject.optLong("sysTime", B);
                x53.k(editor, "15ua", t2);
                x53.h(editor, "15un", optInt);
                x53.i(editor, "15ust", B);
            }
        } catch (Throwable unused) {
        }
    }

    private static void w(JSONObject jSONObject, SharedPreferences.Editor editor) {
        int parseInt;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("17J");
                if (optJSONObject != null) {
                    boolean t2 = m.t(optJSONObject.optString("able"), false);
                    x = t2;
                    x53.k(editor, "ok9", t2);
                    if (t2) {
                        String optString = optJSONObject.optString("auth");
                        String optString2 = optJSONObject.optString("ht");
                        A = optString2;
                        x53.j(editor, "ok11", optString2);
                        m.t(optString, false);
                        z = m.t(optJSONObject.optString("nr"), false);
                        String optString3 = optJSONObject.optString(U4WPKAdapter.KEY_TM);
                        if (!TextUtils.isEmpty(optString3) && (parseInt = Integer.parseInt(optString3)) > 0 && parseInt < 20) {
                            y = parseInt;
                            x53.h(editor, "ok10", parseInt);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean x() {
        return n;
    }

    public static int y() {
        return o;
    }

    public static boolean z() {
        return q;
    }
}
