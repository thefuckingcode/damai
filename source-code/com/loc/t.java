package com.loc;

import android.content.Context;
import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.report.PrivacyDoubleListReporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import tb.q23;
import tb.w13;
import tb.y13;

/* compiled from: Taobao */
public final class t {
    private static volatile b a = b.Unknow;
    private static volatile d b = d.Unknow;
    private static volatile String c = "";
    private static volatile String d = "";
    private static volatile long e = -1;
    private static volatile a f = a.Unknow;
    private static volatile long g = -1;
    private static volatile String h = "";
    private static volatile String i = "";
    private static volatile long j = 0;
    private static volatile long k = 0;
    private static volatile boolean l = false;
    private static volatile boolean m = true;

    /* compiled from: Taobao */
    public enum a {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);
        
        private int d;

        private a(int i) {
            this.d = i;
        }

        public static a a(int i) {
            a aVar = NotAgree;
            if (i == aVar.a()) {
                return aVar;
            }
            a aVar2 = DidAgree;
            return i == aVar2.a() ? aVar2 : Unknow;
        }

        public final int a() {
            return this.d;
        }
    }

    /* compiled from: Taobao */
    public enum b {
        Unknow(-1),
        NotContain(0),
        DidContain(1);
        
        private int d;

        private b(int i) {
            this.d = i;
        }

        public static b a(int i) {
            b bVar = NotContain;
            if (i == bVar.a()) {
                return bVar;
            }
            b bVar2 = DidContain;
            return i == bVar2.a() ? bVar2 : Unknow;
        }

        public final int a() {
            return this.d;
        }
    }

    /* compiled from: Taobao */
    public enum c {
        SuccessCode(0),
        ShowUnknowCode(555570),
        ShowNoShowCode(555571),
        InfoUnknowCode(555572),
        InfoNotContainCode(555573),
        AgreeUnknowCode(555574),
        AgreeNotAgreeCode(555575),
        InvaildUserKeyCode(10001),
        IllegalArgument(20001);
        
        private final int j;

        private c(int i) {
            this.j = i;
        }

        public final int a() {
            return this.j;
        }
    }

    /* compiled from: Taobao */
    public enum d {
        Unknow(-1),
        NotShow(0),
        DidShow(1);
        
        private int d;

        private d(int i) {
            this.d = i;
        }

        public static d a(int i) {
            d dVar = NotShow;
            if (i == dVar.a()) {
                return dVar;
            }
            d dVar2 = DidShow;
            return i == dVar2.a() ? dVar2 : Unknow;
        }

        public final int a() {
            return this.d;
        }
    }

    public static synchronized s1 a(final Context context, u1 u1Var) {
        boolean z;
        synchronized (t.class) {
            s1 s1Var = null;
            if (context == null || u1Var == null) {
                return new s1(c.IllegalArgument, u1Var);
            }
            if (!l) {
                s(context);
                l = true;
            }
            if (b != d.DidShow) {
                if (b == d.Unknow) {
                    s1Var = new s1(c.ShowUnknowCode, u1Var);
                } else if (b == d.NotShow) {
                    s1Var = new s1(c.ShowNoShowCode, u1Var);
                }
                z = false;
            } else {
                z = true;
            }
            if (z && a != b.DidContain) {
                if (a == b.Unknow) {
                    s1Var = new s1(c.InfoUnknowCode, u1Var);
                } else if (a == b.NotContain) {
                    s1Var = new s1(c.InfoNotContainCode, u1Var);
                }
                z = false;
            }
            if (z && f != a.DidAgree) {
                if (f == a.Unknow) {
                    s1Var = new s1(c.AgreeUnknowCode, u1Var);
                } else if (f == a.NotAgree) {
                    s1Var = new s1(c.AgreeNotAgreeCode, u1Var);
                }
                z = false;
            }
            if (k != j) {
                final long j2 = j;
                k = j;
                try {
                    final JSONObject jSONObject = new JSONObject();
                    jSONObject.put(PrivacyDoubleListReporter.UT_KEY, a.a());
                    jSONObject.put("privacyShow", b.a());
                    jSONObject.put("showTime", e);
                    jSONObject.put("show2SDK", c);
                    jSONObject.put("show2SDKVer", d);
                    jSONObject.put("privacyAgree", f.a());
                    jSONObject.put("agreeTime", g);
                    jSONObject.put("agree2SDK", h);
                    jSONObject.put("agree2SDKVer", i);
                    final boolean z2 = m;
                    o0.f().d(new ck() {
                        /* class com.loc.t.AnonymousClass2 */

                        @Override // com.loc.ck
                        public final void a() {
                            if (z2) {
                                Iterator it = t.m(t.t(context)).iterator();
                                while (it.hasNext()) {
                                    t.g(context, ((File) it.next()).getName());
                                }
                            }
                            t.r(context);
                            t.h(context, jSONObject, j2);
                            boolean p = t.p(context, jSONObject);
                            if (p) {
                                t.o(context, t.l(j2));
                            }
                            if (z2) {
                                t.n(context);
                            }
                            if (!p) {
                                t.g(context, t.l(j2));
                            }
                        }
                    });
                } catch (Throwable unused) {
                }
            } else if (m) {
                o0.f().d(new ck() {
                    /* class com.loc.t.AnonymousClass1 */

                    @Override // com.loc.ck
                    public final void a() {
                        Iterator it = t.m(t.t(context)).iterator();
                        while (it.hasNext()) {
                            t.g(context, ((File) it.next()).getName());
                        }
                        t.n(context);
                    }
                });
            }
            m = false;
            String j3 = l.j(context);
            if (j3 == null || j3.length() <= 0) {
                s1Var = new s1(c.InvaildUserKeyCode, u1Var);
                Log.e(u1Var.a(), String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(s1Var.a.a()), s1Var.b));
            }
            if (z) {
                s1Var = new s1(c.SuccessCode, u1Var);
            } else {
                Log.e(u1Var.a(), String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(s1Var.a.a()), s1Var.b));
            }
            return s1Var;
        }
    }

    private static synchronized void e(Context context, a aVar, u1 u1Var) {
        synchronized (t.class) {
            if (context != null && u1Var != null) {
                if (!l) {
                    s(context);
                    l = true;
                }
                if (aVar != f) {
                    f = aVar;
                    h = u1Var.a();
                    i = u1Var.e();
                    long currentTimeMillis = System.currentTimeMillis();
                    g = currentTimeMillis;
                    j = currentTimeMillis;
                    r(context);
                }
            }
        }
    }

    private static synchronized void f(Context context, d dVar, b bVar, u1 u1Var) {
        synchronized (t.class) {
            if (context != null && u1Var != null) {
                if (!l) {
                    s(context);
                    l = true;
                }
                Boolean bool = Boolean.FALSE;
                if (dVar != b) {
                    bool = Boolean.TRUE;
                    b = dVar;
                }
                if (bVar != a) {
                    bool = Boolean.TRUE;
                    a = bVar;
                }
                if (bool.booleanValue()) {
                    c = u1Var.a();
                    d = u1Var.e();
                    long currentTimeMillis = System.currentTimeMillis();
                    e = currentTimeMillis;
                    j = currentTimeMillis;
                    r(context);
                }
            }
        }
    }

    static /* synthetic */ void g(Context context, String str) {
        if (str != null && str.length() != 0) {
            try {
                String t = t(context);
                File file = new File(t + "/" + str);
                if (file.exists()) {
                    String u = u(context);
                    File file2 = new File(u + "/" + str);
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    file.renameTo(file2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a A[SYNTHETIC, Splitter:B:18:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    static /* synthetic */ void h(Context context, JSONObject jSONObject, long j2) {
        Throwable th;
        FileOutputStream fileOutputStream = null;
        try {
            byte[] m2 = y13.m(context, jSONObject.toString().getBytes());
            String l2 = l(j2);
            String t = t(context);
            File file = new File(t + "/" + l2);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(m2);
                try {
                    fileOutputStream2.close();
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            } catch (Throwable th3) {
                fileOutputStream = fileOutputStream2;
                th = th3;
                try {
                    th.printStackTrace();
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                            return;
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        } catch (Throwable th6) {
            th = th6;
            th.printStackTrace();
            if (fileOutputStream == null) {
            }
        }
        throw th;
    }

    public static void i(Context context, boolean z, u1 u1Var) {
        e(context, z ? a.DidAgree : a.NotAgree, u1Var);
    }

    public static void j(Context context, boolean z, boolean z2, u1 u1Var) {
        f(context, z2 ? d.DidShow : d.NotShow, z ? b.DidContain : b.NotContain, u1Var);
    }

    /* access modifiers changed from: private */
    public static String l(long j2) {
        return String.format("%d-%s", Long.valueOf(j2), "privacy.data");
    }

    /* access modifiers changed from: private */
    public static ArrayList<File> m(String str) {
        ArrayList<File> arrayList = new ArrayList<>();
        if (!(str == null || str.length() == 0)) {
            File file = new File(str);
            if (!file.exists()) {
                return arrayList;
            }
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ void n(Context context) {
        try {
            Iterator<File> it = m(u(context)).iterator();
            while (it.hasNext()) {
                File next = it.next();
                try {
                    String name = next.getName();
                    if (name.endsWith("-privacy.data")) {
                        String[] split = name.split("-");
                        if (split != null || split.length == 2) {
                            if (Long.parseLong(split[0]) > 0) {
                                FileInputStream fileInputStream = new FileInputStream(next);
                                byte[] bArr = new byte[fileInputStream.available()];
                                fileInputStream.read(bArr);
                                if (!p(context, new JSONObject(new String(y13.q(context, bArr))))) {
                                }
                            }
                        }
                    }
                    next.delete();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    static /* synthetic */ void o(Context context, String str) {
        if (str != null && str.length() != 0) {
            try {
                String t = t(context);
                File file = new File(t + "/" + str);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean p(Context context, JSONObject jSONObject) {
        try {
            w13 w13 = new w13();
            w13.m = context;
            w13.l = jSONObject;
            new bg();
            q23 c2 = bg.c(w13);
            if (c2 == null) {
                return false;
            }
            JSONObject jSONObject2 = new JSONObject(v1.g(c2.a));
            return jSONObject2.has("status") && jSONObject2.getInt("status") == 1;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void r(Context context) {
        synchronized (t.class) {
            if (context != null) {
                if (!l) {
                    s(context);
                    l = true;
                }
                try {
                    y13.d(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(a.a()), Integer.valueOf(b.a()), Long.valueOf(e), c, d, Integer.valueOf(f.a()), Long.valueOf(g), h, i, Long.valueOf(j), Long.valueOf(k)));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static void s(Context context) {
        if (context != null) {
            String str = null;
            try {
                str = y13.c(context, "AMap.privacy.data", "AMap.privacy.data");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (str != null) {
                String[] split = str.split("&");
                if (split.length == 11) {
                    try {
                        a = b.a(Integer.parseInt(split[0]));
                        b = d.a(Integer.parseInt(split[1]));
                        e = Long.parseLong(split[2]);
                        d = split[3];
                        d = split[4];
                        f = a.a(Integer.parseInt(split[5]));
                        g = Long.parseLong(split[6]);
                        h = split[7];
                        i = split[8];
                        j = Long.parseLong(split[9]);
                        k = Long.parseLong(split[10]);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static String t(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Upload";
    }

    private static String u(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Reload";
    }
}
