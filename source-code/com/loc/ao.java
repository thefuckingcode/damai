package com.loc;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tb.e33;
import tb.f33;
import tb.g33;
import tb.h33;
import tb.r23;

/* compiled from: Taobao */
public class ao {
    private static WeakReference<r23> a = null;
    private static boolean b = true;
    private static WeakReference<g33> c;
    private static WeakReference<g33> d;
    private static String[] e = new String[10];
    private static int f;
    private static boolean g;
    private static int h;
    private static u1 i;

    private static u1 a(String str) {
        List<u1> b2 = al.b();
        if (b2 == null) {
            b2 = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (u1 u1Var : b2) {
                if (al.f(u1Var.i(), str)) {
                    return u1Var;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return v1.a();
                } catch (k e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    u1 q = v1.q();
                    q.c(true);
                    return q;
                } catch (k e3) {
                    e3.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00a3 */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c1 A[SYNTHETIC, Splitter:B:59:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e9 A[SYNTHETIC, Splitter:B:81:0x00e9] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00ff A[RETURN] */
    private static String b(List<u1> list) {
        FileInputStream fileInputStream;
        w wVar;
        Throwable th;
        try {
            File file = new File("/data/anr/traces.txt");
            if (!file.exists()) {
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                int available = fileInputStream.available();
                if (available > 1024000) {
                    fileInputStream.skip((long) (available - 1024000));
                }
                wVar = new w(fileInputStream, v.b);
                boolean z = false;
                while (true) {
                    try {
                        String trim = wVar.a().trim();
                        if (trim.contains("pid")) {
                            while (!trim.startsWith("\"main\"")) {
                                trim = wVar.a();
                            }
                            z = true;
                        }
                        if (!trim.equals("") || !z) {
                            if (z) {
                                try {
                                    if (f > 9) {
                                        f = 0;
                                    }
                                    String[] strArr = e;
                                    int i2 = f;
                                    strArr[i2] = trim;
                                    f = i2 + 1;
                                } catch (Throwable th2) {
                                    an.m(th2, "alg", "aDa");
                                }
                                int i3 = h;
                                if (i3 != 5) {
                                    if (!g) {
                                        Iterator<u1> it = list.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            u1 next = it.next();
                                            boolean h2 = al.h(next.i(), trim);
                                            g = h2;
                                            if (h2) {
                                                i = next;
                                                break;
                                            }
                                        }
                                    } else {
                                        h = i3 + 1;
                                    }
                                }
                            }
                        }
                    } catch (EOFException unknown) {
                        wVar.close();
                        fileInputStream.close();
                        break;
                    } catch (FileNotFoundException unused) {
                        if (wVar != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        if (g) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            an.m(th, "alg", "getA");
                            if (wVar != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            if (g) {
                            }
                        } catch (Throwable th4) {
                            an.m(th4, "alg", "getA");
                        }
                    }
                    try {
                        wVar.close();
                    } catch (Throwable th5) {
                        an.m(th5, "alg", "getA");
                    }
                    try {
                        fileInputStream.close();
                        break;
                    } catch (Throwable th6) {
                        an.m(th6, "alg", "getA");
                    }
                }
            } catch (FileNotFoundException unused2) {
                wVar = null;
                if (wVar != null) {
                }
                if (fileInputStream != null) {
                }
                if (g) {
                }
            } catch (Throwable th7) {
                th = th7;
                wVar = null;
                an.m(th, "alg", "getA");
                if (wVar != null) {
                }
                if (fileInputStream != null) {
                }
                if (g) {
                }
            }
            if (g) {
                return j();
            }
            return null;
        } catch (FileNotFoundException unused3) {
            wVar = null;
            fileInputStream = null;
            if (wVar != null) {
                try {
                    wVar.close();
                } catch (Throwable th8) {
                    an.m(th8, "alg", "getA");
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (g) {
            }
        } catch (Throwable th9) {
            th = th9;
            wVar = null;
            fileInputStream = null;
            an.m(th, "alg", "getA");
            if (wVar != null) {
                try {
                    wVar.close();
                } catch (Throwable th10) {
                    an.m(th10, "alg", "getA");
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (g) {
            }
        }
        throw th;
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        throw th;
    }

    static void d(Context context) {
        String b2;
        u1 u1Var;
        List<u1> b3 = al.b();
        if (b3 != null && b3.size() != 0 && (b2 = b(b3)) != null && !"".equals(b2) && (u1Var = i) != null) {
            e(context, u1Var, 2, "ANR", b2);
        }
    }

    private static void e(Context context, u1 u1Var, int i2, String str, String str2) {
        String str3;
        String a2 = e0.a();
        String b2 = e0.b(context, u1Var);
        l.a(context);
        String c2 = e0.c(b2, a2, i2, str, str2);
        if (c2 != null && !"".equals(c2)) {
            String d2 = r1.d(str2);
            if (i2 == 1) {
                str3 = al.b;
            } else if (i2 == 2) {
                str3 = al.d;
            } else if (i2 == 0) {
                str3 = al.c;
            } else {
                return;
            }
            r23 d3 = e0.d(a);
            e0.e(context, d3, str3, 1000, 4096000, "1");
            if (d3.e == null) {
                d3.e = new p(new q(new s(new u())));
            }
            try {
                b0.c(d2, v1.p(c2.replaceAll(StringUtils.LF, "<br/>")), d3);
            } catch (Throwable unused) {
            }
        }
    }

    public static void f(Context context, Throwable th, int i2, String str, String str2) {
        String e2 = v1.e(th);
        u1 a2 = a(e2);
        if (i(a2)) {
            String replaceAll = e2.replaceAll(StringUtils.LF, "<br/>");
            String th2 = th.toString();
            if (th2 != null && !"".equals(th2)) {
                StringBuilder sb = new StringBuilder();
                if (str != null) {
                    sb.append("class:");
                    sb.append(str);
                }
                if (str2 != null) {
                    sb.append(" method:");
                    sb.append(str2);
                    sb.append("$<br/>");
                }
                sb.append(replaceAll);
                e(context, a2, i2, th2, sb.toString());
            }
        }
    }

    private static void g(final Context context, final g33 g33, final String str) {
        o0.f().d(new ck() {
            /* class com.loc.ao.AnonymousClass1 */

            @Override // com.loc.ck
            public final void a() {
                try {
                    synchronized (ao.class) {
                        r23 d = e0.d(ao.a);
                        e0.e(context, d, str, 1000, 4096000, "1");
                        d.f = g33;
                        if (d.g == null) {
                            d.g = new i0(new h0(context, new n0(), new q(new s(new u())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", l.j(context), o.h0(context), o.g0(context), l.g(context), Build.getMODEL(), l.e(context), l.h(context), Build.VERSION.getRELEASE()));
                        }
                        d.h = 3600000;
                        b0.a(d);
                    }
                } catch (Throwable th) {
                    an.m(th, "lg", "pul");
                }
            }
        });
    }

    static void h(u1 u1Var, Context context, String str, String str2) {
        if (i(u1Var) && str != null && !"".equals(str)) {
            e(context, u1Var, 1, str, str2);
        }
    }

    private static boolean i(u1 u1Var) {
        return u1Var != null && u1Var.h();
    }

    private static String j() {
        StringBuilder sb = new StringBuilder();
        try {
            int i2 = f;
            while (i2 < 10 && i2 <= 9) {
                sb.append(e[i2]);
                i2++;
            }
            for (int i3 = 0; i3 < f; i3++) {
                sb.append(e[i3]);
            }
        } catch (Throwable th) {
            an.m(th, "alg", "gLI");
        }
        return sb.toString();
    }

    static void k(Context context) {
        e33 e33 = new e33(b);
        b = false;
        g(context, e33, al.c);
    }

    static void l(Context context) {
        WeakReference<g33> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new WeakReference<>(new f33(context, 3600000, "hKey", new h33(context)));
        }
        g(context, c.get(), al.d);
    }

    static void m(Context context) {
        WeakReference<g33> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new WeakReference<>(new f33(context, 3600000, "gKey", new h33(context)));
        }
        g(context, d.get(), al.b);
    }
}
