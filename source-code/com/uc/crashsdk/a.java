package com.uc.crashsdk;

import android.content.pm.PackageInfo;
import android.util.Log;
import android.util.SparseArray;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.uc.crashsdk.a.b;
import com.uc.crashsdk.a.e;
import com.uc.crashsdk.a.f;
import com.uc.crashsdk.a.g;
import com.uc.crashsdk.export.LogType;
import java.io.File;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class a {
    private static final HashMap<String, Object[]> A = new HashMap<>();
    private static final List<String> B = new ArrayList();
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;
    private static Runnable F = new e(201);
    private static boolean G = false;
    private static boolean H = false;
    private static boolean I = false;
    public static String a = "";
    public static String b = "";
    static boolean c = false;
    static final /* synthetic */ boolean d = true;
    private static final Map<String, String> e = new HashMap();
    private static final List<String> f = new ArrayList();
    private static String g = "";
    private static String h = null;
    private static int i = -1;
    private static long j = 0;
    private static final HashMap<String, Object[]> k = new HashMap<>();
    private static final List<String> l = new ArrayList();
    private static int m = 0;
    private static int n = 0;
    private static int o = 0;
    private static int p = 0;
    private static final HashMap<String, Object[]> q = new HashMap<>();
    private static final List<String> r = new ArrayList();
    private static int s = 0;
    private static int t = 0;
    private static int u = 0;
    private static int v = 0;
    private static int w = 0;
    private static int x = 0;
    private static final SparseArray<Object[]> y = new SparseArray<>();
    private static final List<Integer> z = new ArrayList();

    public static String a() {
        String str = h;
        if (str != null) {
            return str;
        }
        return o() ? h : "";
    }

    static long b() {
        return j;
    }

    static int c() {
        if (i == -1) {
            o();
        }
        return i;
    }

    static void d() {
        StringBuilder sb = new StringBuilder();
        synchronized (e) {
            for (String str : f) {
                String str2 = e.get(str);
                sb.append(str);
                sb.append(": ");
                if (str2 != null) {
                    sb.append(str2);
                }
                sb.append(StringUtils.LF);
            }
        }
        sb.append(String.format(Locale.US, "(saved at %s)\n", e.n()));
        b.a(b.h(), sb.toString());
    }

    static void e() {
        if (d || b.d) {
            synchronized (e) {
                for (String str : f) {
                    JNIBridge.nativeAddHeaderInfo(str, e.get(str));
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public static byte[] f() {
        return new byte[]{24, 99, 121, 60};
    }

    static void g() {
        if (d || b.d) {
            synchronized (k) {
                for (String str : l) {
                    Object[] objArr = k.get(str);
                    int intValue = ((Integer) objArr[0]).intValue();
                    if ((1048833 & intValue) != 0) {
                        JNIBridge.nativeAddDumpFile(str, (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), intValue, ((Boolean) objArr[4]).booleanValue());
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    static String h() {
        StringBuilder sb = new StringBuilder();
        synchronized (k) {
            boolean z2 = true;
            for (String str : l) {
                if (LogType.isForJava(((Integer) k.get(str)[0]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    static void i() {
        if (d || b.d) {
            synchronized (q) {
                for (String str : r) {
                    Object[] objArr = q.get(str);
                    int intValue = ((Integer) objArr[0]).intValue();
                    if ((1048833 & intValue) != 0) {
                        JNIBridge.nativeAddCallbackInfo(str, intValue, ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    static String j() {
        String sb;
        synchronized (q) {
            StringBuilder sb2 = new StringBuilder();
            List<String> list = r;
            synchronized (list) {
                boolean z2 = true;
                for (String str : list) {
                    if (LogType.isForJava(((Integer) q.get(str)[0]).intValue())) {
                        if (!z2) {
                            sb2.append("`");
                        }
                        sb2.append(str);
                        z2 = false;
                    }
                }
            }
            sb = sb2.toString();
        }
        return sb;
    }

    static void k() {
        if (d || b.d) {
            synchronized (A) {
                for (String str : B) {
                    Object[] objArr = A.get(str);
                    int intValue = ((Integer) objArr[0]).intValue();
                    int intValue2 = ((Integer) objArr[1]).intValue();
                    List list = (List) objArr[2];
                    if ((1048577 & intValue2) != 0 && JNIBridge.nativeCreateCachedInfo(str, intValue, intValue2) != 0) {
                        Iterator it = list.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (!JNIBridge.nativeAddCachedInfo(str, (String) it.next())) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    static String l() {
        StringBuilder sb = new StringBuilder();
        synchronized (A) {
            boolean z2 = true;
            for (String str : B) {
                if (LogType.isForJava(((Integer) A.get(str)[1]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    static String m() {
        if (!G) {
            String a2 = b.a(b.m());
            g = a2;
            G = true;
            if (a2 == null) {
                g = "";
            }
        }
        return g;
    }

    public static void n() {
        p();
        if (!H) {
            H = true;
            f.a(0, new e(202));
        } else if (b.d) {
            JNIBridge.set(128, g);
        }
    }

    private static boolean o() {
        try {
            PackageInfo packageInfo = g.a().getPackageManager().getPackageInfo(a, 0);
            h = packageInfo.versionName;
            j = packageInfo.lastUpdateTime;
            i = packageInfo.versionCode;
            return true;
        } catch (Throwable th) {
            g.b(th);
            return false;
        }
    }

    private static void p() {
        if (I || !e.a()) {
            return;
        }
        if (b.d || !b.g) {
            String format = String.format(Locale.US, "%s/%s/%s", g.R(), g.S(), g.T());
            com.uc.crashsdk.a.a.b("crashsdk", "UUID: " + e.q());
            com.uc.crashsdk.a.a.b("crashsdk", "Version: " + format);
            com.uc.crashsdk.a.a.b("crashsdk", "Process Name: " + e.h());
            I = true;
        }
    }

    private static StringBuilder b(String str, boolean z2) {
        String str2;
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr = q.get(str);
            if (objArr == null) {
                try {
                    str2 = "Unknown callback: " + str;
                } catch (Throwable th) {
                    sb.append("[DEBUG] Callback occurred new exception:\n");
                    sb.append(Log.getStackTraceString(th));
                }
            } else {
                Callable callable = (Callable) objArr[1];
                if (callable != null) {
                    str2 = (String) callable.call();
                } else {
                    str2 = d.a(str, z2);
                }
            }
            if (str2 != null) {
                sb.append(str2);
            }
        } catch (Throwable th2) {
            g.a(th2);
        }
        try {
            if (sb.length() == 0) {
                sb.append("(data is null)\n");
            }
        } catch (Throwable th3) {
            g.a(th3);
        }
        return sb;
    }

    public static void a(String str, String str2) {
        Map<String, String> map = e;
        synchronized (map) {
            if (!map.containsKey(str)) {
                f.add(str);
            }
            map.put(str, str2);
            if (b.d) {
                JNIBridge.nativeAddHeaderInfo(str, str2);
            }
            e.y();
        }
    }

    static ArrayList<String> c(String str) {
        if (g.a(str)) {
            return null;
        }
        String[] split = str.split(";", 20);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : split) {
            if (!g.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    static void a(OutputStream outputStream, String str) {
        synchronized (e) {
            for (String str2 : f) {
                try {
                    StringBuilder sb = new StringBuilder(11);
                    sb.append(str2);
                    sb.append(": ");
                    String str3 = e.get(str2);
                    if (str3 != null) {
                        sb.append(str3);
                    }
                    sb.append(StringUtils.LF);
                    outputStream.write(sb.toString().getBytes(str));
                } catch (Throwable th) {
                    e.a(th, outputStream);
                }
            }
        }
    }

    public static int b(String str, String str2) {
        int i2;
        int i3 = 0;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str2.length() > 2048) {
            str2 = str2.substring(0, 2048);
        }
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            if (objArr != null) {
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (list.size() >= intValue) {
                    list.remove(0);
                }
                list.add(str2);
                if (LogType.isForJava(intValue2)) {
                    i3 = LogType.addType(0, 16);
                }
                if (!b.d) {
                    if (LogType.isForNative(intValue2)) {
                        i3 = LogType.addType(i3, 1);
                    }
                    if (LogType.isForANR(intValue2)) {
                        i3 = LogType.addType(i3, 1048576);
                    }
                }
                i2 = i3;
                i3 = intValue2;
            } else {
                i2 = 0;
            }
            if (b.d && JNIBridge.nativeAddCachedInfo(str, str2)) {
                if (LogType.isForNative(i3)) {
                    i2 = LogType.addType(i2, 1);
                }
                if (LogType.isForANR(i3)) {
                    i2 = LogType.addType(i2, 1048576);
                }
            }
        }
        return i2;
    }

    public static int a(String str, String str2, boolean z2, boolean z3, int i2, boolean z4) {
        int i3;
        int i4;
        boolean z5;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.length() > 256) {
            com.uc.crashsdk.a.a.a("crashsdk", "addDumpFile: description is too long!", null);
            return 0;
        }
        HashMap<String, Object[]> hashMap = k;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                i4 = ((Integer) hashMap.get(str)[0]).intValue();
                i3 = LogType.addType(i4, i2);
            } else {
                i3 = i2;
                i4 = 0;
            }
            if (LogType.isForJava(i3) && !LogType.isForJava(i4)) {
                int i5 = m;
                if (i5 >= 10) {
                    i3 = LogType.removeType(i3, 16);
                } else {
                    m = i5 + 1;
                }
            }
            if (LogType.isForNative(i3) && !LogType.isForNative(i4)) {
                int i6 = n;
                if (i6 >= 10) {
                    i3 = LogType.removeType(i3, 1);
                } else {
                    n = i6 + 1;
                }
            }
            if (LogType.isForUnexp(i3) && !LogType.isForUnexp(i4)) {
                int i7 = o;
                if (i7 >= 10) {
                    i3 = LogType.removeType(i3, 256);
                } else {
                    o = i7 + 1;
                }
            }
            if (LogType.isForANR(i3) && !LogType.isForANR(i4)) {
                int i8 = p;
                if (i8 >= 10) {
                    i3 = LogType.removeType(i3, 1048576);
                } else {
                    p = i8 + 1;
                }
            }
            if ((1048849 & i3) == 0) {
                z5 = false;
            } else {
                if (i4 == 0) {
                    l.add(str);
                }
                z5 = true;
            }
            if (!z5) {
                return i3;
            }
            if (b.d && (1048833 & i2) != 0) {
                int nativeAddDumpFile = JNIBridge.nativeAddDumpFile(str, str2, z2, z3, i2, z4);
                if (!LogType.isForNative(nativeAddDumpFile)) {
                    i3 = LogType.removeType(i3, 1);
                }
                if (!LogType.isForUnexp(nativeAddDumpFile)) {
                    i3 = LogType.removeType(i3, 256);
                }
                if (!LogType.isForANR(nativeAddDumpFile)) {
                    i3 = LogType.removeType(i3, 1048576);
                }
            }
            hashMap.put(str, new Object[]{Integer.valueOf(i3), str2, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)});
            return i3;
        }
    }

    static void b(OutputStream outputStream, String str, String str2, ArrayList<String> arrayList) {
        synchronized (A) {
            for (String str3 : B) {
                Object[] objArr = A.get(str3);
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                List<String> list = (List) objArr[2];
                if (arrayList == null) {
                    if (!LogType.isForJava(intValue2)) {
                    }
                } else if (!a(arrayList, str3)) {
                }
                try {
                    outputStream.write(String.format(Locale.US, "%s (%d/%d)\n", str3, Integer.valueOf(list.size()), Integer.valueOf(intValue)).getBytes(str));
                } catch (Throwable th) {
                    e.a(th, outputStream);
                }
                try {
                    for (String str4 : list) {
                        outputStream.write(str4.getBytes(str));
                        outputStream.write(StringUtils.LF.getBytes(str));
                    }
                } catch (Throwable th2) {
                    e.a(th2, outputStream);
                }
                try {
                    outputStream.write(StringUtils.LF.getBytes(str));
                    outputStream.write(str2.getBytes(str));
                } catch (Throwable th3) {
                    e.a(th3, outputStream);
                }
            }
            if (arrayList != null && e.F()) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!a(B, next)) {
                        e.a(outputStream, "CUSTOMCACHEDINFO", next);
                    }
                }
            }
        }
    }

    static void a(OutputStream outputStream, String str, ArrayList<String> arrayList) {
        Throwable th;
        int i2;
        boolean z2 = arrayList == null;
        boolean F2 = e.F();
        synchronized (k) {
            int i3 = 0;
            for (String str2 : l) {
                try {
                    Object[] objArr = k.get(str2);
                    if (arrayList == null) {
                        if (!LogType.isForJava(((Integer) objArr[0]).intValue())) {
                        }
                    } else if (!a(arrayList, str2)) {
                    }
                    if (((Boolean) objArr[3]).booleanValue()) {
                        try {
                            outputStream.write((str2 + StringUtils.LF).getBytes(str));
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    int i4 = i3 > 153600 ? 153600 : i3;
                    try {
                        int min = Math.min(20480, 153600 - i4);
                        boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
                        String str3 = (String) objArr[1];
                        boolean booleanValue2 = ((Boolean) objArr[4]).booleanValue();
                        if (!F2 || str3.startsWith("/proc/")) {
                            if (booleanValue) {
                                i2 = e.a(outputStream, str3, min);
                            } else {
                                i2 = e.b(outputStream, str3, min);
                            }
                            i4 += i2;
                        } else {
                            e.a(outputStream, "FILE", str3, min, booleanValue, booleanValue2);
                        }
                        i3 = i4;
                        if (booleanValue2 && z2 && !F2) {
                            File file = new File(str3);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        i3 = i4;
                        e.a(th, outputStream);
                    }
                } catch (Throwable th4) {
                    th = th4;
                    e.a(th, outputStream);
                }
            }
            if (arrayList != null && F2) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!a(l, next)) {
                        e.a(outputStream, "CUSTOMDUMPFILE", next);
                    }
                }
            }
        }
    }

    static String b(String str) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            int intValue = ((Integer) objArr[0]).intValue();
            List<String> list = (List) objArr[2];
            sb.append(String.format(Locale.US, "%s (%d/%d)\n", str, Integer.valueOf(list.size()), Integer.valueOf(intValue)));
            for (String str2 : list) {
                sb.append(str2);
                sb.append(StringUtils.LF);
            }
        }
        return sb.toString();
    }

    static String a(String str) {
        HashMap<String, Object[]> hashMap = k;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            if (objArr == null) {
                return null;
            }
            int i2 = 1;
            boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[3]).booleanValue();
            Locale locale = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = (String) objArr[1];
            objArr2[1] = "`";
            objArr2[2] = Integer.valueOf(booleanValue ? 1 : 0);
            if (!booleanValue2) {
                i2 = 0;
            }
            objArr2[3] = Integer.valueOf(i2);
            return String.format(locale, "%s%s%d%d", objArr2);
        }
    }

    private static boolean a(List<String> list, String str) {
        if (g.a(str)) {
            return false;
        }
        for (String str2 : list) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ed A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ef  */
    public static int a(String str, int i2, Callable<String> callable, long j2, int i3) {
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i6;
        boolean z7;
        boolean z8;
        if (str == null) {
            return 0;
        }
        HashMap<String, Object[]> hashMap = q;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                i5 = ((Integer) hashMap.get(str)[0]).intValue();
                i4 = LogType.addType(i5, i2);
                if (i5 == i4) {
                    return i5;
                }
            } else {
                i4 = i2;
                i5 = 0;
            }
            if (LogType.isForJava(i4) && !LogType.isForJava(i5)) {
                int i7 = s;
                if (i7 < 8) {
                    if (j2 != 0) {
                        int i8 = w;
                        if (i8 < 6) {
                            w = i8 + 1;
                        }
                    } else if (i7 - w >= 6) {
                    }
                    s = i7 + 1;
                    z8 = false;
                    if (z8) {
                        i4 = LogType.removeType(i4, 16);
                    }
                }
                z8 = true;
                if (z8) {
                }
            }
            if (!LogType.isForNative(i4) || LogType.isForNative(i5)) {
                z3 = false;
                z2 = false;
            } else {
                int i9 = t;
                if (i9 < 6) {
                    if (j2 != 0) {
                        int i10 = x;
                        if (i10 < 4) {
                            x = i10 + 1;
                            t = i9 + 1;
                            z7 = false;
                            z3 = true;
                            z2 = true;
                            if (z7) {
                                i4 = LogType.removeType(i4, 1);
                            }
                        }
                    } else if (i9 - x < 4) {
                        t = i9 + 1;
                        z7 = false;
                        z3 = true;
                        z2 = false;
                        if (z7) {
                        }
                    }
                }
                z7 = true;
                z3 = false;
                z2 = false;
                if (z7) {
                }
            }
            if (LogType.isForANR(i4) && !LogType.isForANR(i5)) {
                int i11 = v;
                if (i11 >= 6) {
                    i4 = LogType.removeType(i4, 1048576);
                } else {
                    v = i11 + 1;
                    z4 = true;
                    if (LogType.isForUnexp(i4) && !LogType.isForUnexp(i5)) {
                        i6 = u;
                        if (i6 < 6) {
                            i4 = LogType.removeType(i4, 256);
                        } else {
                            u = i6 + 1;
                            z5 = true;
                            if ((1048849 & i4) != 0) {
                                z6 = false;
                            } else {
                                if (i5 == 0) {
                                    r.add(str);
                                }
                                z6 = true;
                            }
                            if (z6) {
                                return i4;
                            }
                            if (b.d && (1048833 & i2) != 0) {
                                int nativeAddCallbackInfo = JNIBridge.nativeAddCallbackInfo(str, i2, j2, i3);
                                if (!LogType.isForNative(nativeAddCallbackInfo)) {
                                    i4 = LogType.removeType(i4, 1);
                                    if (z3) {
                                        t--;
                                    }
                                    if (z2) {
                                        x--;
                                    }
                                }
                                if (!LogType.isForANR(nativeAddCallbackInfo)) {
                                    i4 = LogType.removeType(i4, 1048576);
                                    if (z4) {
                                        v--;
                                    }
                                }
                                if (!LogType.isForUnexp(nativeAddCallbackInfo)) {
                                    i4 = LogType.removeType(i4, 256);
                                    if (z5) {
                                        u--;
                                    }
                                }
                            }
                            hashMap.put(str, new Object[]{Integer.valueOf(i4), callable, Long.valueOf(j2), Integer.valueOf(i3)});
                            return i4;
                        }
                    }
                    z5 = false;
                    if ((1048849 & i4) != 0) {
                    }
                    if (z6) {
                    }
                }
            }
            z4 = false;
            i6 = u;
            if (i6 < 6) {
            }
        }
    }

    static void a(OutputStream outputStream, String str, String str2, ArrayList<String> arrayList) {
        String str3;
        synchronized (q) {
            for (String str4 : r) {
                try {
                    Object[] objArr = q.get(str4);
                    int intValue = ((Integer) objArr[0]).intValue();
                    if (arrayList == null) {
                        if (!LogType.isForJava(intValue)) {
                        }
                    } else if (!a(arrayList, str4)) {
                    }
                    outputStream.write((str4 + StringUtils.LF).getBytes(str));
                    long longValue = ((Long) objArr[2]).longValue();
                    if (longValue != 0) {
                        str3 = JNIBridge.nativeGetCallbackInfo(str4, longValue, ((Integer) objArr[3]).intValue(), false);
                    } else {
                        str3 = b(str4, false).toString();
                    }
                    if (str3 == null || str3.length() <= 0) {
                        outputStream.write("(data is null)\n".getBytes(str));
                    } else {
                        outputStream.write(str3.getBytes(str));
                    }
                } catch (Throwable th) {
                    e.a(th, outputStream);
                }
                try {
                    outputStream.write(StringUtils.LF.getBytes(str));
                    outputStream.write(str2.getBytes(str));
                } catch (Throwable th2) {
                    e.a(th2, outputStream);
                }
            }
            if (arrayList != null && e.F()) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!a(r, next)) {
                        e.a(outputStream, "CUSTOMCALLBACKINFO", next);
                    }
                }
            }
        }
    }

    static String a(String str, boolean z2) {
        String str2;
        HashMap<String, Object[]> hashMap = q;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            long longValue = ((Long) objArr[2]).longValue();
            if (longValue != 0) {
                str2 = JNIBridge.nativeGetCallbackInfo(str, longValue, ((Integer) objArr[3]).intValue(), z2);
            } else {
                str2 = b(str, z2).toString();
            }
        }
        return str2;
    }

    private static boolean a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        SparseArray<Object[]> sparseArray = y;
        synchronized (sparseArray) {
            int id = (int) thread.getId();
            if (sparseArray.get(id) == null) {
                z.add(Integer.valueOf(id));
            }
            sparseArray.put(id, new Object[]{new WeakReference(thread), str});
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0084 A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087 A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ca A[Catch:{ all -> 0x0100 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d8 A[Catch:{ all -> 0x0100 }] */
    static void a(OutputStream outputStream, String str, String str2) {
        Thread thread;
        String str3;
        StackTraceElement[] stackTrace;
        int length;
        int i2;
        Throwable th;
        synchronized (y) {
            Thread currentThread = Thread.currentThread();
            for (Integer num : z) {
                int intValue = num.intValue();
                try {
                    Object[] objArr = y.get(intValue);
                    if (objArr != null) {
                        thread = (Thread) ((WeakReference) objArr[0]).get();
                        try {
                            str3 = (String) objArr[1];
                            if (thread == null) {
                                try {
                                    com.uc.crashsdk.a.a.b("Thread (" + str3 + AVFSCacheConstants.COMMA_SEP + intValue + ") has exited!");
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } else {
                                if (currentThread == thread) {
                                }
                                try {
                                    Locale locale = Locale.US;
                                    outputStream.write(String.format(locale, "Thread Name: '%s'\n", str3).getBytes(str));
                                    outputStream.write(String.format(locale, "\"%s\"%s prio=%d tid=%d %s\n", thread.getName(), thread.isDaemon() ? " daemon" : "", Integer.valueOf(thread.getPriority()), Integer.valueOf(intValue), thread.getState().toString()).getBytes(str));
                                } catch (Throwable th3) {
                                    e.a(th3, outputStream);
                                }
                                try {
                                    stackTrace = thread.getStackTrace();
                                    if (stackTrace.length == 0) {
                                        outputStream.write("  (no stack frames)".getBytes(str));
                                    }
                                    length = stackTrace.length;
                                    i2 = 0;
                                    boolean z2 = true;
                                    while (i2 < length) {
                                        StackTraceElement stackTraceElement = stackTrace[i2];
                                        if (!z2) {
                                            outputStream.write(StringUtils.LF.getBytes(str));
                                        }
                                        outputStream.write(String.format(Locale.US, "  at %s", stackTraceElement.toString()).getBytes(str));
                                        i2++;
                                        z2 = false;
                                    }
                                } catch (Throwable th4) {
                                    e.a(th4, outputStream);
                                }
                                try {
                                    outputStream.write(StringUtils.LF.getBytes(str));
                                    outputStream.write(str2.getBytes(str));
                                } catch (Throwable th5) {
                                    e.a(th5, outputStream);
                                }
                            }
                        } catch (Throwable th6) {
                            str3 = null;
                            th = th6;
                            e.a(th, outputStream);
                            Locale locale2 = Locale.US;
                            outputStream.write(String.format(locale2, "Thread Name: '%s'\n", str3).getBytes(str));
                            outputStream.write(String.format(locale2, "\"%s\"%s prio=%d tid=%d %s\n", thread.getName(), thread.isDaemon() ? " daemon" : "", Integer.valueOf(thread.getPriority()), Integer.valueOf(intValue), thread.getState().toString()).getBytes(str));
                            stackTrace = thread.getStackTrace();
                            if (stackTrace.length == 0) {
                            }
                            length = stackTrace.length;
                            i2 = 0;
                            boolean z22 = true;
                            while (i2 < length) {
                            }
                            outputStream.write(StringUtils.LF.getBytes(str));
                            outputStream.write(str2.getBytes(str));
                        }
                    }
                } catch (Throwable th7) {
                    thread = null;
                    th = th7;
                    str3 = null;
                    e.a(th, outputStream);
                    Locale locale22 = Locale.US;
                    outputStream.write(String.format(locale22, "Thread Name: '%s'\n", str3).getBytes(str));
                    outputStream.write(String.format(locale22, "\"%s\"%s prio=%d tid=%d %s\n", thread.getName(), thread.isDaemon() ? " daemon" : "", Integer.valueOf(thread.getPriority()), Integer.valueOf(intValue), thread.getState().toString()).getBytes(str));
                    stackTrace = thread.getStackTrace();
                    if (stackTrace.length == 0) {
                    }
                    length = stackTrace.length;
                    i2 = 0;
                    boolean z222 = true;
                    while (i2 < length) {
                    }
                    outputStream.write(StringUtils.LF.getBytes(str));
                    outputStream.write(str2.getBytes(str));
                }
            }
        }
    }

    public static int a(String str, int i2, int i3) {
        int i4;
        int i5;
        boolean z2;
        if (str == null || i2 <= 0) {
            return 0;
        }
        if (i2 > 1500) {
            com.uc.crashsdk.a.a.a("crashsdk", "createCachedInfo: capacity is too large!", null);
            return 0;
        }
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                i5 = ((Integer) hashMap.get(str)[1]).intValue();
                i4 = LogType.addType(i5, i3);
            } else {
                i4 = i3;
                i5 = 0;
            }
            if (LogType.isForJava(i4) && !LogType.isForJava(i5)) {
                int i6 = C;
                if (i6 >= 8) {
                    i4 = LogType.removeType(i4, 16);
                } else {
                    C = i6 + 1;
                }
            }
            if (LogType.isForNative(i4) && !LogType.isForNative(i5)) {
                int i7 = D;
                if (i7 >= 8) {
                    i4 = LogType.removeType(i4, 1);
                } else {
                    D = i7 + 1;
                }
            }
            if (LogType.isForANR(i4) && !LogType.isForANR(i5)) {
                int i8 = E;
                if (i8 >= 8) {
                    i4 = LogType.removeType(i4, 1048576);
                } else {
                    E = i8 + 1;
                }
            }
            if ((1048849 & i4) == 0) {
                z2 = false;
            } else {
                if (i5 == 0) {
                    B.add(str);
                }
                z2 = true;
            }
            if (!z2) {
                return i4;
            }
            if (b.d && (i3 & 1048577) != 0) {
                int nativeCreateCachedInfo = JNIBridge.nativeCreateCachedInfo(str, i2, i4);
                if (!LogType.isForNative(nativeCreateCachedInfo)) {
                    i4 = LogType.removeType(i4, 1);
                }
                if (!LogType.isForANR(nativeCreateCachedInfo)) {
                    i4 = LogType.removeType(i4, 1048576);
                }
            }
            hashMap.put(str, new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), new ArrayList()});
            return i4;
        }
    }

    public static int a(int i2, String str) {
        if (g.a(str)) {
            str = Thread.currentThread().getName();
        }
        boolean z2 = false;
        z2 = false;
        if (LogType.isForNative(i2) || LogType.isForANR(i2)) {
            if (b.d) {
                synchronized (y) {
                    JNIBridge.nativeCmd(4, (long) i2, str, null);
                }
                z2 = LogType.isForNative(i2);
                if (LogType.isForANR(i2)) {
                    z2 = (z2 ? 1 : 0) | true;
                }
            } else {
                com.uc.crashsdk.a.a.a("crashsdk", "crashsdk so has not loaded!", null);
            }
        }
        if (!LogType.isForJava(i2)) {
            int i3 = z2 ? 1 : 0;
            int i4 = z2 ? 1 : 0;
            int i5 = z2 ? 1 : 0;
            int i6 = z2 ? 1 : 0;
            int i7 = z2 ? 1 : 0;
            return i3;
        }
        a(str, Thread.currentThread());
        int i8 = z2 ? 1 : 0;
        char c2 = z2 ? 1 : 0;
        char c3 = z2 ? 1 : 0;
        char c4 = z2 ? 1 : 0;
        return i8 | 16;
    }

    public static boolean a(boolean z2) {
        int i2;
        if (!b.c) {
            com.uc.crashsdk.a.a.a("crashsdk", "Unexp log not enabled, skip update unexp info!");
            return false;
        } else if (e.F() || b.L()) {
            return false;
        } else {
            if (z2) {
                f.a(F);
                i2 = 0;
            } else if (!b.B()) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stop update unexp info in background!");
                return false;
            } else if (g.E() <= 0) {
                return false;
            } else {
                if (f.b(F)) {
                    return true;
                }
                i2 = g.E() * 1000;
            }
            f.a(0, F, (long) i2);
            return true;
        }
    }

    public static void a(int i2) {
        if (i2 == 201) {
            com.uc.crashsdk.a.a.a("crashsdk", "Begin update info ...");
            long currentTimeMillis = System.currentTimeMillis();
            if (b.d && c) {
                JNIBridge.nativeCmd(11, (long) g.E(), String.valueOf(g.F()), null);
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Update info took " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            a(false);
        } else if (i2 == 202) {
            p();
            Locale locale = Locale.US;
            String format = String.format(locale, "%s/%s/%s", g.R(), g.S(), g.T());
            g = m();
            if (b.d) {
                JNIBridge.set(128, g);
            }
            boolean z2 = !format.equals(g);
            if (z2) {
                b.a(b.m(), format);
            }
            if (z2 && g.u()) {
                com.uc.crashsdk.a.a.a("crashsdk", String.format(locale, "Is new version ('%s' -> '%s'), deleting old stats data!", g, format));
                b.v();
            }
        } else if (!d) {
            throw new AssertionError();
        }
    }
}
