package com.amap.api.col.s;

import android.content.Context;
import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.report.PrivacyDoubleListReporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class bt {
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

        public final int a() {
            return this.d;
        }

        public static a a(int i) {
            a aVar = NotAgree;
            if (i == aVar.a()) {
                return aVar;
            }
            a aVar2 = DidAgree;
            if (i == aVar2.a()) {
                return aVar2;
            }
            return Unknow;
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

        public final int a() {
            return this.d;
        }

        public static b a(int i) {
            b bVar = NotContain;
            if (i == bVar.a()) {
                return bVar;
            }
            b bVar2 = DidContain;
            if (i == bVar2.a()) {
                return bVar2;
            }
            return Unknow;
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

        public final int a() {
            return this.d;
        }

        public static d a(int i) {
            d dVar = NotShow;
            if (i == dVar.a()) {
                return dVar;
            }
            d dVar2 = DidShow;
            if (i == dVar2.a()) {
                return dVar2;
            }
            return Unknow;
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(Context context, JSONObject jSONObject) {
        try {
            cn cnVar = new cn();
            cnVar.b = context;
            cnVar.a = jSONObject;
            new cz();
            dg a2 = cz.a(cnVar);
            if (a2 == null) {
                return false;
            }
            JSONObject jSONObject2 = new JSONObject(bw.a(a2.a));
            if (!jSONObject2.has("status") || jSONObject2.getInt("status") != 1) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void d(Context context) {
        synchronized (bt.class) {
            if (context != null) {
                if (!l) {
                    e(context);
                    l = true;
                }
                try {
                    co.a(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(a.a()), Integer.valueOf(b.a()), Long.valueOf(e), c, d, Integer.valueOf(f.a()), Long.valueOf(g), h, i, Long.valueOf(j), Long.valueOf(k)));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static void e(Context context) {
        if (context != null) {
            String str = null;
            try {
                str = co.a(context, "AMap.privacy.data", "AMap.privacy.data");
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
    public static String f(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Upload";
    }

    private static String g(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Reload";
    }

    public static void a(Context context, boolean z, boolean z2, bv bvVar) {
        d dVar;
        b bVar;
        if (z2) {
            dVar = d.DidShow;
        } else {
            dVar = d.NotShow;
        }
        if (z) {
            bVar = b.DidContain;
        } else {
            bVar = b.NotContain;
        }
        a(context, dVar, bVar, bvVar);
    }

    private static synchronized void a(Context context, d dVar, b bVar, bv bvVar) {
        synchronized (bt.class) {
            if (context != null && bvVar != null) {
                if (!l) {
                    e(context);
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
                    c = bvVar.b();
                    d = bvVar.c();
                    long currentTimeMillis = System.currentTimeMillis();
                    e = currentTimeMillis;
                    j = currentTimeMillis;
                    d(context);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static String b(long j2) {
        return String.format("%d-%s", Long.valueOf(j2), "privacy.data");
    }

    /* access modifiers changed from: private */
    public static ArrayList<File> b(String str) {
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

    static /* synthetic */ void b(Context context) {
        try {
            Iterator<File> it = b(g(context)).iterator();
            while (it.hasNext()) {
                File next = it.next();
                try {
                    String name = next.getName();
                    if (!name.endsWith("-privacy.data")) {
                        next.delete();
                    } else {
                        String[] split = name.split("-");
                        if (split == null && split.length != 2) {
                            next.delete();
                        } else if (Long.parseLong(split[0]) <= 0) {
                            next.delete();
                        } else {
                            FileInputStream fileInputStream = new FileInputStream(next);
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            if (b(context, new JSONObject(new String(co.b(context, bArr))))) {
                                next.delete();
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, boolean z, bv bvVar) {
        a aVar;
        if (z) {
            aVar = a.DidAgree;
        } else {
            aVar = a.NotAgree;
        }
        a(context, aVar, bvVar);
    }

    private static synchronized void a(Context context, a aVar, bv bvVar) {
        synchronized (bt.class) {
            if (context != null && bvVar != null) {
                if (!l) {
                    e(context);
                    l = true;
                }
                if (aVar != f) {
                    f = aVar;
                    h = bvVar.b();
                    i = bvVar.c();
                    long currentTimeMillis = System.currentTimeMillis();
                    g = currentTimeMillis;
                    j = currentTimeMillis;
                    d(context);
                }
            }
        }
    }

    public static synchronized bu a(final Context context, bv bvVar) {
        boolean z;
        synchronized (bt.class) {
            bu buVar = null;
            if (context == null || bvVar == null) {
                return new bu(c.IllegalArgument, bvVar);
            }
            if (!l) {
                e(context);
                l = true;
            }
            if (b != d.DidShow) {
                if (b == d.Unknow) {
                    buVar = new bu(c.ShowUnknowCode, bvVar);
                } else if (b == d.NotShow) {
                    buVar = new bu(c.ShowNoShowCode, bvVar);
                }
                z = false;
            } else {
                z = true;
            }
            if (z && a != b.DidContain) {
                if (a == b.Unknow) {
                    buVar = new bu(c.InfoUnknowCode, bvVar);
                } else if (a == b.NotContain) {
                    buVar = new bu(c.InfoNotContainCode, bvVar);
                }
                z = false;
            }
            if (z && f != a.DidAgree) {
                if (f == a.Unknow) {
                    buVar = new bu(c.AgreeUnknowCode, bvVar);
                } else if (f == a.NotAgree) {
                    buVar = new bu(c.AgreeNotAgreeCode, bvVar);
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
                    ed.a().b(new ee() {
                        /* class com.amap.api.col.s.bt.AnonymousClass2 */

                        @Override // com.amap.api.col.s.ee
                        public final void a() {
                            if (z2) {
                                Iterator it = bt.b(bt.f(context)).iterator();
                                while (it.hasNext()) {
                                    bt.a(context, ((File) it.next()).getName());
                                }
                            }
                            bt.d(context);
                            bt.a(context, jSONObject, j2);
                            boolean b2 = bt.b(context, jSONObject);
                            if (b2) {
                                bt.b(context, bt.b(j2));
                            }
                            if (z2) {
                                bt.b(context);
                            }
                            if (!b2) {
                                bt.a(context, bt.b(j2));
                            }
                        }
                    });
                } catch (Throwable unused) {
                }
            } else if (m) {
                ed.a().b(new ee() {
                    /* class com.amap.api.col.s.bt.AnonymousClass1 */

                    @Override // com.amap.api.col.s.ee
                    public final void a() {
                        Iterator it = bt.b(bt.f(context)).iterator();
                        while (it.hasNext()) {
                            bt.a(context, ((File) it.next()).getName());
                        }
                        bt.b(context);
                    }
                });
            }
            m = false;
            String f2 = bk.f(context);
            if (f2 == null || f2.length() <= 0) {
                buVar = new bu(c.InvaildUserKeyCode, bvVar);
                Log.e(bvVar.b(), String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(buVar.a.a()), buVar.b));
            }
            if (z) {
                buVar = new bu(c.SuccessCode, bvVar);
            } else {
                Log.e(bvVar.b(), String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(buVar.a.a()), buVar.b));
            }
            return buVar;
        }
    }

    static /* synthetic */ void b(Context context, String str) {
        if (str != null && str.length() != 0) {
            try {
                String f2 = f(context);
                File file = new File(f2 + "/" + str);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(Context context, String str) {
        if (str != null && str.length() != 0) {
            try {
                String f2 = f(context);
                File file = new File(f2 + "/" + str);
                if (file.exists()) {
                    String g2 = g(context);
                    File file2 = new File(g2 + "/" + str);
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
    static /* synthetic */ void a(Context context, JSONObject jSONObject, long j2) {
        Throwable th;
        FileOutputStream fileOutputStream = null;
        try {
            byte[] a2 = co.a(context, jSONObject.toString().getBytes());
            String b2 = b(j2);
            String f2 = f(context);
            File file = new File(f2 + "/" + b2);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(a2);
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
}
