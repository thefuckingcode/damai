package com.loc;

import android.text.TextUtils;
import com.loc.bg;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;
import tb.p23;
import tb.t13;
import tb.v13;

/* compiled from: Taobao */
public abstract class bl {
    int a = 20000;
    Proxy b = null;
    bg.a c;
    private boolean d = false;
    private int e = 20000;
    private boolean f = true;
    private String g;
    private boolean h;
    private boolean i;
    private a j = a.NORMAL;
    private b k = b.FIRST_NONDEGRADE;

    /* compiled from: Taobao */
    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);
        
        private int f;

        private a(int i) {
            this.f = i;
        }
    }

    /* compiled from: Taobao */
    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);
        
        private int h;

        private b(int i2) {
            this.h = i2;
        }

        public final int a() {
            return this.h;
        }

        public final boolean b() {
            int i2 = this.h;
            return i2 == FIRST_NONDEGRADE.h || i2 == NEVER_GRADE.h || i2 == FIX_NONDEGRADE.h;
        }

        public final boolean c() {
            int i2 = this.h;
            return i2 == DEGRADE_BYERROR.h || i2 == DEGRADE_ONLY.h || i2 == FIX_DEGRADE_BYERROR.h || i2 == FIX_DEGRADE_ONLY.h;
        }

        public final boolean d() {
            int i2 = this.h;
            return i2 == DEGRADE_BYERROR.h || i2 == FIX_DEGRADE_BYERROR.h;
        }

        public final boolean e() {
            return this.h == NEVER_GRADE.h;
        }
    }

    /* compiled from: Taobao */
    public enum c {
        HTTP(0),
        HTTPS(1);
        
        private int c;

        private c(int i) {
            this.c = i;
        }
    }

    private static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return n(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th) {
            v13.e(th, "ht", "pnfh");
            return null;
        }
    }

    private String k(String str) {
        byte[] r = r();
        if (r == null || r.length == 0) {
            return str;
        }
        Map<String, String> q = q();
        HashMap<String, String> hashMap = bg.e;
        if (hashMap != null) {
            if (q != null) {
                q.putAll(hashMap);
            } else {
                q = hashMap;
            }
        }
        if (q == null) {
            return str;
        }
        String c2 = bj.c(q);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(c2);
        return stringBuffer.toString();
    }

    private static String n(String str) {
        String str2;
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("&");
                if (split.length > 1) {
                    int length = split.length;
                    int i2 = 0;
                    String str4 = str3;
                    while (true) {
                        if (i2 >= length) {
                            str2 = str3;
                            break;
                        }
                        str2 = split[i2];
                        if (str2.contains("sdkversion")) {
                            str4 = str2;
                        }
                        if (str2.contains("product")) {
                            break;
                        }
                        i2++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split2 = str2.split("=");
                        if (split2.length > 1) {
                            str3 = split2[1].trim();
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(t13.a(str3))) {
                                String[] split3 = str4.split("=");
                                if (split3.length > 1) {
                                    t13.b(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            v13.e(th, "ht", "pnfp");
        }
        return str3;
    }

    public final void A() {
        this.d = true;
    }

    /* access modifiers changed from: protected */
    public final boolean B() {
        return this.i;
    }

    public final bg.a C() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public final b D() {
        return this.k;
    }

    /* access modifiers changed from: protected */
    public final int E() {
        return this.e;
    }

    public final void F() {
        this.f = false;
    }

    /* access modifiers changed from: protected */
    public final String G() {
        return this.g;
    }

    /* access modifiers changed from: protected */
    public final boolean H() {
        return this.h;
    }

    /* access modifiers changed from: protected */
    public final String I() {
        Throwable th;
        String str;
        try {
            str = t();
            try {
                return TextUtils.isEmpty(str) ? this.d ? n(((p23) this).S()) : a(b()) : str;
            } catch (Throwable th2) {
                th = th2;
                v13.e(th, "ht", "pnfr");
                return str;
            }
        } catch (Throwable th3) {
            th = th3;
            str = "";
            v13.e(th, "ht", "pnfr");
            return str;
        }
    }

    public abstract Map<String, String> b();

    public final void c(int i2) {
        this.a = i2;
    }

    public final void d(a aVar) {
        this.j = aVar;
    }

    public final void e(b bVar) {
        this.k = bVar;
    }

    public final void f(c cVar) {
        this.i = cVar == c.HTTPS;
    }

    public final void g(String str) {
        this.g = str;
    }

    public final void h(Proxy proxy) {
        this.b = proxy;
    }

    public final void i(boolean z) {
        this.h = z;
    }

    public abstract String j();

    public final void l(int i2) {
    }

    public String m() {
        return j();
    }

    public final void o(int i2) {
        this.e = i2;
    }

    /* access modifiers changed from: protected */
    public boolean p() {
        return this.f;
    }

    public abstract Map<String, String> q();

    public abstract byte[] r();

    /* access modifiers changed from: protected */
    public String s() {
        return "";
    }

    public String t() {
        return "";
    }

    /* access modifiers changed from: package-private */
    public final String u() {
        return k(j());
    }

    /* access modifiers changed from: package-private */
    public final String v() {
        return k(m());
    }

    public final int w() {
        return this.a;
    }

    public final Proxy x() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public final a y() {
        return this.j;
    }

    /* access modifiers changed from: protected */
    public final boolean z() {
        return this.d;
    }
}
