package com.uc.crashsdk;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.taobao.windvane.util.ConfigStorage;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.alibaba.aliweex.adapter.module.audio.IWXAudio;
import com.alibaba.wireless.security.SecExceptionCode;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.e;
import com.uc.crashsdk.a.f;
import com.uc.crashsdk.a.g;
import com.uc.crashsdk.a.h;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: Taobao */
public class b {
    private static boolean A = false;
    private static boolean B = false;
    private static boolean C = false;
    private static boolean D = false;
    private static boolean E = false;
    private static boolean F = false;
    private static final Object G = new Object();
    private static String H = null;
    private static int I = 0;
    private static boolean J = false;
    private static boolean K = false;
    private static boolean L = true;
    private static RandomAccessFile M = null;
    private static boolean N = false;
    private static final Object O = new Object();
    private static String P = null;
    private static boolean Q = false;
    private static volatile Object[] R = null;
    private static Runnable S = new e(101);
    private static boolean T = false;
    private static long U = 0;
    private static final Object V = new Object();
    private static long W = 0;
    private static boolean X = false;
    private static boolean Y = false;
    private static boolean Z = false;
    public static boolean a = false;
    private static long aa = 0;
    private static final WeakHashMap<Activity, Integer> ab = new WeakHashMap<>();
    private static boolean ac = false;
    private static String ad = null;
    private static boolean ae = false;
    private static boolean af = false;
    private static boolean ag = false;
    private static boolean ah = false;
    private static boolean ai = false;
    private static final Object aj = new Object();
    private static PendingIntent ak = null;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static final Object e = new Object();
    public static boolean f = false;
    public static boolean g = true;
    public static boolean h = false;
    static final /* synthetic */ boolean i = true;
    private static String j;
    private static String k;
    private static String l;
    private static String m;
    private static String n;
    private static String o;
    private static String p;
    private static String q;
    private static String r;
    private static String s;
    private static String t;
    private static String u;
    private static String v;
    private static String w;
    private static boolean x;
    private static boolean y;
    private static volatile boolean z;

    public static boolean A() {
        return Y || !ad();
    }

    static boolean B() {
        return Y && !x;
    }

    static void C() {
        f.a(2, new e(100));
    }

    static void D() {
        String str;
        if (d && (str = ad) != null) {
            JNIBridge.set((int) SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR, str);
        }
    }

    static String E() {
        String str = ad;
        return str == null ? "" : str;
    }

    public static boolean F() {
        if (!ae) {
            if (!g.a(a.a) && a.a.equals(e.h())) {
                af = true;
                if (d) {
                    JNIBridge.set(2, true);
                }
            }
            ae = true;
        }
        return af;
    }

    static void G() {
        ag = true;
        if (d) {
            JNIBridge.set(34, true);
        }
    }

    public static boolean H() {
        return ag;
    }

    public static int I() {
        boolean U2 = U();
        return t() ? U2 ? 3 : 6 : s() ? U2 ? 2 : 5 : U2 ? 4 : 1;
    }

    public static int J() {
        boolean V2 = V();
        boolean W2 = W();
        boolean X2 = X();
        if (t()) {
            if (V2) {
                return 12;
            }
            if (W2) {
                return 14;
            }
            return X2 ? 16 : 98;
        } else if (!s()) {
            return 1;
        } else {
            if (V2) {
                return 11;
            }
            if (W2) {
                return 13;
            }
            return X2 ? 15 : 97;
        }
    }

    static void K() {
        if (d) {
            JNIBridge.nativeSet(27, (long) I, "12", null);
            JNIBridge.set(30, L);
        }
    }

    public static boolean L() {
        if (!ai) {
            synchronized (aj) {
                if (!ai) {
                    ah = ae();
                    ai = true;
                }
            }
        }
        return ah;
    }

    public static void M() {
        if (!e.F() && !L() && ak == null && g.h() >= 0) {
            try {
                Context a2 = g.a();
                Intent launchIntentForPackage = a2.getPackageManager().getLaunchIntentForPackage(a2.getPackageName());
                launchIntentForPackage.addFlags(335544320);
                ak = PendingIntent.getActivity(a2, 0, launchIntentForPackage, 0);
            } catch (Throwable th) {
                g.a(th);
            }
        }
    }

    static boolean N() {
        if (ak == null) {
            a.b("Restart intent is null!");
            return false;
        }
        try {
            a.a("crashsdk", "restarting ...");
            ((AlarmManager) g.a().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 200, ak);
            return true;
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    private static String Q() {
        if (j == null) {
            j = d("ss");
        }
        return j;
    }

    private static String R() {
        if (l == null) {
            l = d("ctn");
        }
        return l;
    }

    private static String S() {
        if (m == null) {
            m = d("cta");
        }
        return m;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0070 A[Catch:{ all -> 0x0074 }] */
    private static void T() {
        boolean z2;
        if (!z && !y) {
            synchronized (G) {
                if (!z) {
                    f(g.U());
                    String p2 = p();
                    File file = new File(b());
                    File file2 = new File(R());
                    A = "f".equals(p2);
                    B = "b".equals(p2);
                    D = file.exists();
                    boolean exists = file2.exists();
                    E = exists;
                    if (!D) {
                        if (!exists) {
                            z2 = false;
                            C = z2;
                            if (!z2 && (A || B)) {
                                boolean r2 = r();
                                F = r2;
                                C = r2;
                            }
                            if (z()) {
                                Z();
                            }
                            z = true;
                        }
                    }
                    z2 = true;
                    C = z2;
                    boolean r22 = r();
                    F = r22;
                    C = r22;
                    try {
                        if (z()) {
                        }
                    } catch (Throwable th) {
                        g.a(th);
                    }
                    z = true;
                }
            }
        }
    }

    private static boolean U() {
        T();
        return C;
    }

    private static boolean V() {
        T();
        return D;
    }

    private static boolean W() {
        T();
        return E;
    }

    private static boolean X() {
        T();
        return F;
    }

    private static void Y() {
        if (d) {
            JNIBridge.set(26, x);
        }
    }

    private static void Z() {
        if (!T) {
            T = true;
            try {
                new File(b()).delete();
            } catch (Throwable th) {
                g.a(th);
            }
            try {
                new File(R()).delete();
            } catch (Throwable th2) {
                g.a(th2);
            }
            try {
                if (d) {
                    JNIBridge.cmd(16);
                } else {
                    new File(S()).delete();
                }
            } catch (Throwable th3) {
                g.a(th3);
            }
        }
        Object[] ab2 = ab();
        if (ab2[0].equals(P) || R != null) {
            Q = true;
            aa();
            return;
        }
        a(ab2);
    }

    static String a() {
        String str = H;
        if (str != null) {
            return str;
        }
        String h2 = e.h();
        if (g.a(h2)) {
            H = "LLUN";
        } else {
            int i2 = 0;
            if (h2.length() > 48) {
                h2 = h2.substring(0, 48);
                i2 = h2.length() - 48;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bytes = h2.getBytes();
            for (int length = bytes.length - 1; length >= 0; length--) {
                byte b2 = bytes[length];
                if (b2 == 46) {
                    sb.append(YKUpsConvert.CHAR_ZERO);
                } else if (b2 == 58) {
                    sb.append('1');
                } else if (b2 >= 97 && b2 <= 122) {
                    sb.append((char) ((b2 + 65) - 97));
                } else if (b2 >= 65 && b2 <= 90) {
                    sb.append((char) b2);
                } else if (b2 < 48 || b2 > 57) {
                    sb.append('2');
                } else {
                    sb.append((char) b2);
                }
            }
            if (i2 > 0) {
                sb.append(String.valueOf(i2));
            }
            H = sb.toString();
        }
        return H;
    }

    private static void aa() {
        if (!f.b(S)) {
            f.a(1, S);
            return;
        }
        Object[] objArr = R;
        if (objArr == null || !ab()[0].equals(objArr[0])) {
            f.a(S);
            f.a(1, S);
        }
    }

    private static Object[] ab() {
        synchronized (V) {
            long j2 = W + 1;
            W = j2;
            if (x) {
                return new Object[]{"e", Long.valueOf(j2)};
            } else if (B()) {
                return new Object[]{"f", Long.valueOf(W)};
            } else {
                return new Object[]{"b", Long.valueOf(W)};
            }
        }
    }

    private static Object ac() {
        Object a2;
        Object a3 = a((Application) g.a(), Application.class, "mLoadedApk");
        if (a3 != null && (a2 = a(a3, (Class<?>) null, "mActivityThread")) != null) {
            return a2;
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, new Object[0]);
            }
        } catch (Throwable th) {
            g.a(th);
        }
        return null;
    }

    private static boolean ad() {
        String a2 = g.a(new File("/proc/self/cgroup"), 512, false);
        if (g.a(a2)) {
            return false;
        }
        if (a2.contains("/bg_non_interactive") || a2.contains("/background")) {
            return true;
        }
        return false;
    }

    private static boolean ae() {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("isIsolated", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke != null && (invoke instanceof Boolean)) {
                    return ((Boolean) invoke).booleanValue();
                }
            }
        } catch (Throwable th) {
            g.a(th);
        }
        int myUid = Process.myUid() % 100000;
        return myUid >= 99000 && myUid <= 99999;
    }

    static String b() {
        if (k == null) {
            k = d("ctj");
        }
        return k;
    }

    private static String d(String str) {
        return g.U() + a() + "." + str;
    }

    private static File[] e(String str) {
        if (i || str.length() > 0) {
            File[] listFiles = new File(g.U()).listFiles();
            if (listFiles == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (File file : listFiles) {
                if (file.getPath().endsWith(str)) {
                    arrayList.add(file);
                }
            }
            return (File[]) arrayList.toArray(new File[arrayList.size()]);
        }
        throw new AssertionError();
    }

    static File[] f() {
        return e(".stcb");
    }

    static String g() {
        if (v == null) {
            v = d("bati");
        }
        return v;
    }

    static String h() {
        if (w == null) {
            w = d("hdr");
        }
        return w;
    }

    static String i() {
        if (q == null) {
            q = g.U() + "up";
        }
        return q;
    }

    public static String j() {
        if (r == null) {
            r = g.U() + "authu";
        }
        return r;
    }

    public static String k() {
        if (s == null) {
            s = g.U() + "statu";
        }
        return s;
    }

    static String l() {
        if (t == null) {
            t = g.U() + "poli";
        }
        return t;
    }

    static String m() {
        if (u == null) {
            u = g.U() + "ver";
        }
        return u;
    }

    public static String n() {
        return g.U() + "bvu";
    }

    static String o() {
        return g.U() + "fds";
    }

    static String p() {
        return g.a(new File(Q()), 8, false);
    }

    static boolean q() {
        return y;
    }

    static boolean r() {
        if (!J) {
            if (d) {
                K = JNIBridge.cmd(15) == 1;
            } else {
                K = new File(S()).exists();
            }
            J = true;
        }
        return K;
    }

    static boolean s() {
        T();
        return A;
    }

    static boolean t() {
        T();
        return B;
    }

    static boolean u() {
        return x;
    }

    public static void v() {
        boolean z2;
        f(g.U());
        y = true;
        A = false;
        B = false;
        C = false;
        D = false;
        E = false;
        F = false;
        String[] strArr = {".st", ".wa", ".callback", ".ctn", ".ctj", ".cta", ".signal"};
        String[] strArr2 = {"up", "authu", "statu", "poli"};
        File[] listFiles = new File(g.U()).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String name = file.getName();
                int i2 = 0;
                while (true) {
                    if (i2 >= 7) {
                        z2 = false;
                        break;
                    } else if (name.endsWith(strArr[i2])) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 4) {
                            break;
                        } else if (name.equals(strArr2[i3])) {
                            z2 = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                if (z2) {
                    a.a("crashsdk", "delete file: " + file.getPath());
                    g.a(file);
                }
            }
        }
        Z();
    }

    public static void w() {
        if (!x) {
            x = true;
            if (!L() && !e.u()) {
                f(g.U());
                Y();
                Z();
            }
        }
    }

    static boolean x() {
        return f(g.U());
    }

    static boolean y() {
        return f(g.V());
    }

    static boolean z() {
        return X || !ad();
    }

    static String c() {
        if (n == null) {
            n = d("st");
        }
        return n;
    }

    static File[] d() {
        return e(".st");
    }

    private static boolean f(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        a.a("crashsdk", "Crash log directory was placed by a file!", null);
        if (!file.delete()) {
            return false;
        }
        file.mkdirs();
        return true;
    }

    public static String b(String str) {
        return "debug.crs." + str;
    }

    public static void b(boolean z2) {
        if (!e.u()) {
            if (z2 && x) {
                if (g.M()) {
                    Log.v("crashsdk", "setForeground, reset sExited to false!!!");
                }
                x = false;
                Y();
            }
            boolean z3 = e.F() || L();
            long currentTimeMillis = System.currentTimeMillis();
            if (X && !Y && z2) {
                long j2 = aa;
                if (j2 != 0 && !z3 && currentTimeMillis - j2 > ConfigStorage.DEFAULT_SMALL_MAX_AGE) {
                    f.a(1, new e(104), 1000);
                }
            }
            aa = currentTimeMillis;
            Y = z2;
            if (z2) {
                X = true;
            }
            if (d) {
                JNIBridge.nativeSetForeground(z2);
            }
            if (!x && !z3) {
                T();
                Z();
                if (z2) {
                    a.a(false);
                    if (!Z) {
                        e.B();
                        Z = true;
                    }
                }
                if (!N) {
                    aa();
                }
                e.c(z2);
            }
        }
    }

    public static boolean c(int i2) {
        return (i2 & I) != 0;
    }

    static String e() {
        if (o == null) {
            o = d("stcb");
        }
        return o;
    }

    static String a(String str) {
        if (str == null || str.length() <= 0 || !str.endsWith(".st")) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".st");
        if (i || lastIndexOf >= 0) {
            String substring = str.substring(0, lastIndexOf);
            if (substring.length() <= 0) {
                return null;
            }
            return substring + ".stcb";
        }
        throw new AssertionError();
    }

    public static void a(boolean z2) {
        L = z2;
        if (d) {
            JNIBridge.set(30, z2);
        }
    }

    public static void b(int i2) {
        I = i2;
        K();
    }

    private static void a(Object[] objArr) {
        R = objArr;
        synchronized (O) {
            String str = (String) objArr[0];
            long longValue = ((Long) objArr[1]).longValue();
            if (longValue < U) {
                a.c("crashsdk", String.format(Locale.US, "Update state generation %d, last is: %d", Long.valueOf(longValue), Long.valueOf(U)));
                return;
            }
            U = longValue;
            String Q2 = Q();
            if (d) {
                RandomAccessFile randomAccessFile = M;
                if (randomAccessFile != null) {
                    g.a(randomAccessFile);
                    M = null;
                }
                boolean nativeChangeState = JNIBridge.nativeChangeState(Q2, str, N);
                N = false;
                if (!nativeChangeState) {
                    a.b("write state failed: " + str);
                }
            } else {
                RandomAccessFile randomAccessFile2 = M;
                if (randomAccessFile2 == null || N) {
                    if (randomAccessFile2 != null) {
                        g.a(randomAccessFile2);
                        M = null;
                    }
                    try {
                        RandomAccessFile randomAccessFile3 = new RandomAccessFile(Q2, "rw");
                        M = randomAccessFile3;
                        randomAccessFile3.seek(0);
                        N = false;
                    } catch (Exception e2) {
                        g.a(e2);
                    }
                }
                try {
                    M.write(str.getBytes());
                    M.seek(0);
                } catch (Exception e3) {
                    g.a(e3);
                }
            }
            P = str;
            R = null;
        }
    }

    static void b(Context context) {
        a.a("Restart APP");
        if (context != null) {
            if (p == null) {
                p = d("rt");
            }
            File file = new File(p);
            long j2 = -1;
            try {
                j2 = Long.parseLong(g.d(file));
            } catch (Throwable th) {
                g.a(th);
            }
            boolean z2 = false;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (g.h() >= 0 && (j2 <= 0 || currentTimeMillis - j2 > ((long) g.h()))) {
                f(g.U());
                g.a(file, String.valueOf(currentTimeMillis));
                z2 = true;
            }
            a.a("lastTime: " + j2 + ", currentTime: " + currentTimeMillis + ", needRestart: " + z2);
            if (z2) {
                try {
                    d.a(true);
                } catch (Throwable th2) {
                    g.a(th2);
                }
                N();
            }
        }
    }

    public static boolean a(Context context) {
        try {
            ((Application) context).registerActivityLifecycleCallbacks(new c());
            if (!g.J()) {
                return true;
            }
            C();
            return true;
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    public static void a(int i2) {
        Object a2;
        Activity activity;
        int i3;
        boolean z2 = false;
        boolean z3 = true;
        switch (i2) {
            case 100:
                Object ac2 = ac();
                if (ac2 != null && (a2 = a(ac2, (Class<?>) null, "mActivities")) != null) {
                    try {
                        boolean z4 = false;
                        for (Map.Entry entry : ((Map) a2).entrySet()) {
                            Object value = entry.getValue();
                            if (!(value == null || (activity = (Activity) a(value, (Class<?>) null, "activity")) == null)) {
                                boolean booleanValue = ((Boolean) a(value, (Class<?>) null, IWXAudio.KEY_PAUSED)).booleanValue();
                                boolean booleanValue2 = ((Boolean) a(value, (Class<?>) null, DXRecyclerLayout.LOAD_MORE_STOPED)).booleanValue();
                                WeakHashMap<Activity, Integer> weakHashMap = ab;
                                synchronized (weakHashMap) {
                                    if (booleanValue || booleanValue2) {
                                        i3 = 2;
                                    } else {
                                        i3 = 1;
                                        z4 = true;
                                    }
                                    weakHashMap.put(activity, Integer.valueOf(i3));
                                }
                            }
                            z2 = true;
                        }
                        if (z2) {
                            b(z4);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        g.a(th);
                        return;
                    }
                } else {
                    return;
                }
            case 101:
                try {
                    if (new File(Q()).exists()) {
                        z3 = false;
                    }
                    N = z3;
                    if (z3 || Q) {
                        a(ab());
                        Q = false;
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    g.a(th2);
                    return;
                }
            case 102:
                f.a(1, new e(103));
                return;
            case 103:
                try {
                    g.a(new File(S()));
                    return;
                } catch (Throwable th3) {
                    g.a(th3);
                    return;
                }
            case 104:
                h.d();
                f.a(102);
                if (F()) {
                    e.C();
                    return;
                }
                return;
            default:
                if (!i) {
                    throw new AssertionError();
                }
                return;
        }
    }

    private static Object a(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            cls = obj.getClass();
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            g.a(th);
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0067 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.nio.channels.FileLock */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006e, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x006f, code lost:
        r1 = r5;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0077, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0078, code lost:
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0093, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0094, code lost:
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006e A[ExcHandler: all (r6v6 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:38:0x0069] */
    public static boolean a(Object obj, String str, e eVar) {
        boolean z2;
        FileChannel fileChannel;
        synchronized (obj) {
            FileLock fileLock = 0;
            fileLock = 0;
            FileChannel fileChannel2 = null;
            boolean z3 = false;
            if (d) {
                int nativeOpenFile = JNIBridge.nativeOpenFile(str);
                if (nativeOpenFile < 0) {
                    a.a("crashsdk", "Can not open file: " + str, fileLock);
                    return z3;
                }
                try {
                    boolean nativeLockFile = JNIBridge.nativeLockFile(nativeOpenFile, true);
                    try {
                        z2 = eVar.a();
                    } finally {
                        if (nativeLockFile) {
                            JNIBridge.nativeLockFile(nativeOpenFile, z3);
                        }
                    }
                } finally {
                    JNIBridge.nativeCloseFile(nativeOpenFile);
                }
            } else {
                File file = new File(str);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e2) {
                        g.a(e2);
                    }
                }
                try {
                    fileChannel = new RandomAccessFile(file, "rw").getChannel();
                } catch (Exception e3) {
                    try {
                        g.a(e3);
                        fileChannel = fileLock;
                    } catch (Exception e4) {
                        Exception e5 = e4;
                        try {
                            g.a(e5);
                            g.a(fileChannel2);
                            z2 = z3;
                            return z2;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            g.a(fileChannel2);
                            throw th2;
                        }
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileLock = fileChannel.lock();
                    } catch (Exception e6) {
                        g.a(e6);
                    } catch (Throwable th3) {
                    }
                }
                try {
                    z3 = eVar.a();
                    g.a(fileChannel);
                    z2 = z3;
                } finally {
                    if (fileLock != 0) {
                        fileLock.release();
                    }
                }
            }
            return z2;
        }
    }
}
