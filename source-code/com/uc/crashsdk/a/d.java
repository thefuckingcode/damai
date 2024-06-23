package com.uc.crashsdk.a;

import android.os.Process;
import com.alibaba.motu.crashreporter2.CrashReporter;
import com.uc.crashsdk.a;
import com.uc.crashsdk.b;
import com.uc.crashsdk.e;
import com.uc.crashsdk.g;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class d {
    static final /* synthetic */ boolean a = true;
    private static boolean b = true;
    private static final Object c = new Object();
    private static boolean d = false;
    private static String e = "hsdk";
    private static String f = "alid ";
    private static String g;
    private static final Object h = new Object();
    private static String i;

    public static void a() {
        f.a(0, new e(500), b.H() ? 900000 : 90000);
    }

    public static String b() {
        try {
            return "inv" + f + "cras" + e;
        } catch (Throwable th) {
            g.b(th);
            return "";
        }
    }

    public static void c() {
        synchronized (h) {
            i = null;
        }
    }

    static byte[] d() {
        return new byte[]{6, 0, 23, 8};
    }

    public static boolean e() {
        try {
            if (!e.F()) {
                if (!b.L()) {
                    a(true);
                    return b;
                }
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    private static String f() {
        String str = i;
        if (g.a(str)) {
            synchronized (h) {
                String str2 = "https://woodpecker.uc.cn";
                if (g.P()) {
                    str2 = "https://wpk-auth.ucweb.com";
                }
                str = g.a(b.j(), str2 + "/api/crashsdk/validate", true);
                i = str;
            }
        }
        return str;
    }

    private static String g() {
        byte[] bArr;
        String f2;
        byte[] a2;
        byte[] bArr2;
        StringBuilder sb = new StringBuilder();
        a(sb, "platform", g.e());
        a(sb, "pkgname", a.a);
        a(sb, "process", e.h());
        a(sb, "version", a.a());
        a(sb, "cver", CrashReporter._VERSION);
        a(sb, "ctag", "release");
        a(sb, "inter", g.P() ? "true" : "false");
        a(sb, "os", "android");
        String sb2 = sb.toString();
        byte[] bArr3 = new byte[16];
        c.a(bArr3, 0, h.j());
        c.a(bArr3, 4, c.a());
        c.a(bArr3, 8, d());
        c.a(bArr3, 12, a.f());
        try {
            bArr = c.a(sb2.getBytes(), bArr3, true);
        } catch (Throwable th) {
            g.a(th);
            bArr = null;
        }
        if (bArr == null || (f2 = f()) == null || (a2 = c.a(f2, bArr)) == null) {
            return null;
        }
        try {
            bArr2 = c.a(a2, bArr3, false);
        } catch (Throwable th2) {
            g.a(th2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            return new String(bArr2);
        }
        return null;
    }

    public static void a(int i2) {
        if (i2 == 500) {
            synchronized (c) {
                g = null;
                a(!b.F());
                if (g.b(g)) {
                    h.a(g);
                }
            }
        } else if (!a) {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0083 A[ADDED_TO_REGION] */
    private static boolean a(boolean z) {
        int i2;
        boolean z2;
        String str;
        if (d) {
            return false;
        }
        d = !z;
        if ((a.b.equals("2.0") && b.c(536870912)) || !b.A()) {
            return false;
        }
        String n = b.n();
        String a2 = b.a(n);
        String str2 = null;
        long j = 0;
        if (g.b(a2)) {
            String[] split = a2.split(" ", 4);
            if (split.length == 3) {
                str2 = split[0];
                j = g.c(split[1]);
                i2 = (int) g.c(split[2]);
                b = true;
                if (System.currentTimeMillis() - j < 259200000) {
                    if (!"o".equals(str2)) {
                        if ("2".equals(str2)) {
                            b = false;
                        } else if ("1".equals(str2)) {
                            b = false;
                        }
                    }
                    z2 = false;
                    if (z2 || z) {
                        return true;
                    }
                    if (i2 == Process.myPid()) {
                        return false;
                    }
                    g = "per";
                    String g2 = g();
                    if (g2 == null || !g2.contains("retcode=")) {
                        if (g2 == null) {
                            g = "ner";
                        } else {
                            g = "ser";
                        }
                        return false;
                    }
                    if (g2.contains("retcode=0")) {
                        b = true;
                        str = "o";
                        g = "aus";
                    } else {
                        b = false;
                        if ("1".equals(str2)) {
                            str = "2";
                            g = "auf2";
                        } else {
                            str = "1";
                            g = "auf1";
                        }
                    }
                    b.a(n, String.format(Locale.US, "%s %d %d", str, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid())));
                    if (g.b(g2)) {
                        for (String str3 : g2.split("`", 30)) {
                            String[] split2 = str3.split("=", 2);
                            if (split2.length == 2) {
                                String trim = split2[0].trim();
                                String trim2 = split2[1].trim();
                                boolean z3 = g.b(trim2) && trim2.startsWith("http");
                                if ("logurl".equals(trim)) {
                                    if (z3) {
                                        e.b(trim2);
                                    }
                                } else if ("staturl".equals(trim)) {
                                    if (z3) {
                                        h.b(trim2);
                                    }
                                } else if ("policyurl".equals(trim)) {
                                    if (z3) {
                                        synchronized (h) {
                                            i = trim2;
                                            b.a(b.j(), trim2 + StringUtils.LF);
                                        }
                                    } else {
                                        continue;
                                    }
                                } else if ("logpolicy".equals(trim)) {
                                    e.c(trim2);
                                }
                            }
                        }
                    }
                    return true;
                }
                z2 = true;
                if (z2) {
                }
                return true;
            }
        }
        i2 = 0;
        b = true;
        if (System.currentTimeMillis() - j < 259200000) {
        }
        z2 = true;
        if (z2) {
        }
        return true;
    }

    private static StringBuilder a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb;
    }
}
