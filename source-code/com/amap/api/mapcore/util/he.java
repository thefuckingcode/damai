package com.amap.api.mapcore.util;

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

/* compiled from: Taobao */
public class he {
    private static WeakReference<in> a = null;
    private static boolean b = true;
    private static WeakReference<jh> c;
    private static WeakReference<jh> d;
    private static String[] e = new String[10];
    private static int f;
    private static boolean g;
    private static int h;
    private static gm i;

    static void b(Context context) {
        jf jfVar = new jf(b);
        b = false;
        a(context, jfVar, hb.c);
    }

    static void c(Context context) {
        WeakReference<jh> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new WeakReference<>(new jg(context, 3600000, "hKey", new ji(context, false)));
        }
        a(context, c.get(), hb.d);
    }

    static void d(Context context) {
        WeakReference<jh> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new WeakReference<>(new jg(context, 3600000, "gKey", new ji(context, false)));
        }
        a(context, d.get(), hb.b);
    }

    private static boolean a(gm gmVar) {
        return gmVar != null && gmVar.f();
    }

    private static void a(Context context, gm gmVar, int i2, String str, String str2) {
        String str3;
        String a2 = iu.a();
        String a3 = iu.a(gc.a(context), iu.a(context, gmVar), a2, i2, str, str2);
        if (a3 != null && !"".equals(a3)) {
            String c2 = gk.c(str2);
            if (i2 == 1) {
                str3 = hb.b;
            } else if (i2 == 2) {
                str3 = hb.d;
            } else if (i2 == 0) {
                str3 = hb.c;
            } else {
                return;
            }
            a(context, c2, str3, a3);
        }
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        try {
            int i2 = f;
            while (true) {
                if (i2 >= 10) {
                    break;
                } else if (i2 > 9) {
                    break;
                } else {
                    sb.append(e[i2]);
                    i2++;
                }
            }
            for (int i3 = 0; i3 < f; i3++) {
                sb.append(e[i3]);
            }
        } catch (Throwable th) {
            hd.c(th, "alg", "gLI");
        }
        return sb.toString();
    }

    static void a(Context context) {
        String a2;
        gm gmVar;
        List<gm> b2 = hb.b(context);
        if (b2 != null && b2.size() != 0 && (a2 = a(b2)) != null && !"".equals(a2) && (gmVar = i) != null) {
            a(context, gmVar, 2, "ANR", a2);
        }
    }

    public static void a(Context context, gm gmVar, String str, int i2, String str2, String str3) {
        if (str2 != null && !"".equals(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("class:");
            sb.append(str2);
            if (str3 != null) {
                sb.append(" method:");
                sb.append(str3);
                sb.append("$");
                sb.append("<br/>");
            }
            sb.append(str);
            a(context, gmVar, i2, str2, sb.toString());
        }
    }

    public static void a(Context context, Throwable th, int i2, String str, String str2) {
        String a2 = gn.a(th);
        gm a3 = a(context, a2);
        if (a(a3)) {
            String replaceAll = a2.replaceAll(StringUtils.LF, "<br/>");
            String a4 = a(th);
            if (a4 != null && !"".equals(a4)) {
                StringBuilder sb = new StringBuilder();
                if (str != null) {
                    sb.append("class:");
                    sb.append(str);
                }
                if (str2 != null) {
                    sb.append(" method:");
                    sb.append(str2);
                    sb.append("$");
                    sb.append("<br/>");
                }
                sb.append(replaceAll);
                a(context, a3, i2, a4, sb.toString());
            }
        }
    }

    static void a(gm gmVar, Context context, String str, String str2) {
        if (a(gmVar) && str != null && !"".equals(str)) {
            a(context, gmVar, 1, str, str2);
        }
    }

    private static void a(Context context, String str, String str2, String str3) {
        in a2 = iu.a(a);
        iu.a(context, a2, str2, 1000, 40960, "1");
        if (a2.e == null) {
            a2.e = new ht(new hu(new hw(new hx())));
        }
        try {
            io.a(str, gn.a(str3.replaceAll(StringUtils.LF, "<br/>")), a2);
        } catch (Throwable unused) {
        }
    }

    private static void a(final Context context, final jh jhVar, final String str) {
        hd.d().submit(new Runnable() {
            /* class com.amap.api.mapcore.util.he.AnonymousClass1 */

            public void run() {
                try {
                    synchronized (he.class) {
                        in a2 = iu.a(he.a);
                        iu.a(context, a2, str, 1000, 40960, "1");
                        a2.f = jhVar;
                        if (a2.g == null) {
                            a2.g = new iy(new ix(context, new jc(), new hu(new hw(new hx())), "EImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMiLA=", gc.f(context), gg.w(context), gc.c(context), Build.getMODEL(), gc.b(context), gc.d(context), Build.VERSION.getRELEASE()));
                        }
                        a2.h = 3600000;
                        io.a(a2);
                    }
                } catch (Throwable th) {
                    hd.c(th, "lg", "pul");
                }
            }
        });
    }

    static gm a(Context context, String str) {
        List<gm> b2 = hb.b(context);
        if (b2 == null) {
            b2 = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (gm gmVar : b2) {
                if (hb.a(gmVar.g(), str)) {
                    return gmVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return gn.a();
                } catch (gb e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    gm b3 = gn.b();
                    b3.a(true);
                    return b3;
                } catch (gb e3) {
                    e3.printStackTrace();
                }
            }
        }
        return null;
    }

    private static String a(Throwable th) {
        return th.toString();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x008c */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00aa A[SYNTHETIC, Splitter:B:54:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d2 A[SYNTHETIC, Splitter:B:76:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00e8 A[RETURN] */
    static String a(List<gm> list) {
        FileInputStream fileInputStream;
        ia iaVar;
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
                iaVar = new ia(fileInputStream, ib.a);
                boolean z = false;
                while (true) {
                    try {
                        String trim = iaVar.a().trim();
                        if (trim.contains("pid")) {
                            while (!trim.startsWith("\"main\"")) {
                                trim = iaVar.a();
                            }
                            z = true;
                        }
                        if (trim.equals("") && z) {
                            break;
                        } else if (z) {
                            a(trim);
                            int i2 = h;
                            if (i2 == 5) {
                                break;
                            } else if (!g) {
                                Iterator<gm> it = list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    gm next = it.next();
                                    boolean b2 = hb.b(next.g(), trim);
                                    g = b2;
                                    if (b2) {
                                        i = next;
                                        break;
                                    }
                                }
                            } else {
                                h = i2 + 1;
                            }
                        }
                    } catch (EOFException unknown) {
                        try {
                            iaVar.close();
                        } catch (Throwable th2) {
                            hd.c(th2, "alg", "getA");
                        }
                        try {
                            fileInputStream.close();
                            break;
                        } catch (Throwable th3) {
                            hd.c(th3, "alg", "getA");
                        }
                    } catch (FileNotFoundException unused) {
                        if (iaVar != null) {
                        }
                        if (fileInputStream != null) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            hd.c(th, "alg", "getA");
                            if (iaVar != null) {
                            }
                            if (fileInputStream != null) {
                            }
                        } catch (Throwable th5) {
                            hd.c(th5, "alg", "getA");
                        }
                    }
                }
            } catch (FileNotFoundException unused2) {
                iaVar = null;
                if (iaVar != null) {
                }
                if (fileInputStream != null) {
                }
                if (g) {
                }
            } catch (Throwable th6) {
                th = th6;
                iaVar = null;
                hd.c(th, "alg", "getA");
                if (iaVar != null) {
                }
                if (fileInputStream != null) {
                }
                if (g) {
                }
            }
            if (g) {
                return b();
            }
            return null;
        } catch (FileNotFoundException unused3) {
            iaVar = null;
            fileInputStream = null;
            if (iaVar != null) {
                try {
                    iaVar.close();
                } catch (Throwable th7) {
                    hd.c(th7, "alg", "getA");
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (g) {
            }
        } catch (Throwable th8) {
            th = th8;
            iaVar = null;
            fileInputStream = null;
            hd.c(th, "alg", "getA");
            if (iaVar != null) {
                try {
                    iaVar.close();
                } catch (Throwable th9) {
                    hd.c(th9, "alg", "getA");
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (g) {
            }
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        throw th;
        throw th;
    }

    private static void a(String str) {
        try {
            if (f > 9) {
                f = 0;
            }
            String[] strArr = e;
            int i2 = f;
            strArr[i2] = str;
            f = i2 + 1;
        } catch (Throwable th) {
            hd.c(th, "alg", "aDa");
        }
    }
}
