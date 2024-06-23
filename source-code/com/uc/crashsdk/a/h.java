package com.uc.crashsdk.a;

import android.os.Build;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import com.alibaba.motu.crashreporter2.CrashReporter;
import com.alibaba.security.common.track.model.a;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.google.android.material.timepicker.TimeModel;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.b;
import com.uc.crashsdk.e;
import com.uc.crashsdk.g;
import com.youku.alixplayer.util.PlaybackParamKey;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import mtopsdk.xstate.util.XStateConstants;
import org.apache.commons.lang3.StringUtils;
import tb.z7;

/* compiled from: Taobao */
public class h {
    static final /* synthetic */ boolean a = true;
    private static final Object b = new Object();
    private static final Map<String, String> c = new HashMap();
    private static int d = 0;
    private static final Map<String, a> e = new HashMap();
    private static final Object f = new Object();
    private static final Object g = new Object();
    private static final SparseArray<String> h = new SparseArray<>();
    private static boolean i = false;
    private static boolean j = false;
    private static final Object k = new Object();
    private static String l = null;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        long a = 0;
        int b = 0;
        Map<String, String> c = new HashMap();
        private String d;
        private boolean e = false;
        private boolean f = false;

        a(String str, boolean z, boolean z2) {
            this.d = str;
            this.e = z;
            this.f = z2;
        }

        private long d(String str) {
            return g.c(a(str));
        }

        /* access modifiers changed from: package-private */
        public final void a(String str, String str2) {
            this.c.put(str, str2);
        }

        /* access modifiers changed from: package-private */
        public final String b(String str) {
            String a2 = a(str);
            return a2 == null ? "" : a2;
        }

        /* access modifiers changed from: package-private */
        public final boolean c(String str) {
            if (g.a(str)) {
                return false;
            }
            String str2 = null;
            long j = 0;
            HashMap hashMap = new HashMap();
            Map c2 = h.c(str);
            int i = 0;
            for (String str3 : c2.keySet()) {
                String str4 = (String) c2.get(str3);
                if (str3.equals("lt")) {
                    str2 = str4;
                } else if (this.e && str3.equals("up")) {
                    j = g.c(str4);
                } else if (!this.e || !str3.equals("pid")) {
                    hashMap.put(str3, str4);
                } else {
                    i = (int) g.c(str4);
                }
            }
            String str5 = this.d;
            if (!(str5 == null || str5.equals(str2))) {
                return false;
            }
            this.a = j;
            this.b = i;
            this.d = str2;
            this.c = hashMap;
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void a(String str, long j) {
            long d2 = d(str) + j;
            if (d2 <= 100) {
                j = d2 < 0 ? 0 : d2;
            }
            a(str, String.valueOf(j));
        }

        /* access modifiers changed from: package-private */
        public final boolean a(a aVar) {
            if (!this.f) {
                a.a("crashsdk", String.format(Locale.US, "WaItem '%s' is not mergable!", this.d), null);
                return false;
            }
            for (String str : aVar.c.keySet()) {
                if (str.startsWith("c_")) {
                    a(str, aVar.a(str));
                } else {
                    long d2 = aVar.d(str);
                    if (d2 == 0) {
                        a(str, aVar.a(str));
                    } else if (d2 < 100) {
                        a(str, d2);
                    }
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public final String a(String str) {
            return this.c.get(str);
        }

        /* access modifiers changed from: package-private */
        public final String a(boolean z, boolean z2, boolean z3) {
            if (this.d == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (z) {
                h.b(sb, "lt", "uc");
                h.b(sb, "pre", g.e());
                h.b(sb, "pkg", com.uc.crashsdk.a.a);
                h.b(sb, "rom", Build.VERSION.getRELEASE());
                h.b(sb, "brd", Build.getBRAND());
                h.b(sb, "model", Build.getMODEL());
                h.a(sb, a.C0103a.a, (long) Build.VERSION.SDK_INT);
                h.b(sb, "cpu", e.e());
                h.b(sb, "hdw", e.f());
                long o = h.o();
                h.a(sb, "ram", o);
                h.b(sb, "aram", h.a(o));
                h.b(sb, "cver", CrashReporter._VERSION);
                h.b(sb, "cseq", "200915125514");
                h.b(sb, "ctag", "release");
                h.b(sb, "aver", com.uc.crashsdk.a.a());
                h.b(sb, "ver", g.R());
                h.b(sb, IRequestConst.SVER, g.S());
                h.b(sb, "seq", g.T());
                h.b(sb, "grd", b.A() ? "fg" : "bg");
                h.b(sb, "os", "android");
                sb.append(StringUtils.LF);
            }
            h.b(sb, "lt", this.d);
            h.a(sb, this.c);
            if (this.e && !z2) {
                long j = this.a;
                if (j != 0) {
                    h.b(sb, "up", String.valueOf(j));
                }
                if (z3) {
                    h.b(sb, "pid", String.format(Locale.US, TimeModel.NUMBER_FORMAT, Integer.valueOf(Process.myPid())));
                } else {
                    int i = this.b;
                    if (i != 0) {
                        h.b(sb, "pid", String.format(Locale.US, TimeModel.NUMBER_FORMAT, Integer.valueOf(i)));
                    }
                }
            }
            sb.append(StringUtils.LF);
            return sb.toString();
        }
    }

    static /* synthetic */ String a(long j2) {
        if (j2 < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
            return "512M";
        }
        return String.format(Locale.US, "%dG", Long.valueOf(((j2 / 1024) + 512) / 1024));
    }

    /* access modifiers changed from: private */
    public static void b(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("`");
    }

    static /* synthetic */ Map c(String str) {
        HashMap hashMap = new HashMap();
        String[] split = str.split("`");
        for (String str2 : split) {
            if (str2.length() > 1) {
                String[] split2 = str2.split("=", 3);
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }

    public static void d() {
        b(2, 2000);
        a(1, 70000);
    }

    public static boolean e() {
        return j;
    }

    public static void f() {
        b(1, 2000);
    }

    public static void g() {
        b(3, 0);
    }

    public static void h() {
        b(4, 0);
    }

    public static void i() {
        if (g.O()) {
            f.a(1, new e(303));
        }
    }

    static byte[] j() {
        return new byte[]{z7.DEL, 100, 110, 31};
    }

    public static void k() {
        synchronized (k) {
            l = null;
        }
    }

    private static String m() {
        return g.U() + "pv.wa";
    }

    private static String n() {
        return g.U() + "cdt.wa";
    }

    /* access modifiers changed from: private */
    public static long o() {
        Iterator<String> it = g.a(new File("/proc/meminfo"), 2).iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("MemTotal:")) {
                try {
                    return Long.parseLong(next.replaceAll("\\D+", ""));
                } catch (NumberFormatException e2) {
                    g.a(e2);
                }
            }
        }
        return 0;
    }

    private static String p() {
        String str = l;
        if (g.a(str)) {
            synchronized (k) {
                String str2 = "https://applog.uc.cn/collect";
                if (g.P()) {
                    str2 = "https://gjapplog.ucweb.com/collect";
                }
                str = g.a(b.k(), str2, true);
                l = str;
            }
        }
        return str;
    }

    static /* synthetic */ void a(StringBuilder sb, String str, long j2) {
        b(sb, str, String.valueOf(j2));
    }

    public static void b() {
        a(2, 0);
    }

    public static void c() {
        a(3, 0);
    }

    private static void b(int i2, long j2) {
        if (g.O()) {
            f.a(1, new e(301, new Object[]{Integer.valueOf(i2)}), j2);
        }
    }

    private static boolean d(String str) {
        File file = new File(str);
        Iterator<a> it = a(file, "cst", 30).iterator();
        while (it.hasNext()) {
            a next = it.next();
            String a2 = next.a("prc");
            if (!g.a(a2)) {
                Map<String, a> map = e;
                a aVar = map.get(a2);
                if (aVar != null) {
                    aVar.a(next);
                } else {
                    map.put(a2, next);
                }
            }
        }
        Map<String, a> map2 = e;
        boolean b2 = b(e.q(), a((Iterable<a>) map2.values(), true, false).toString());
        g.b(file);
        if (b2 || g.a(file, a((Iterable<a>) map2.values(), false, true).toString())) {
            map2.clear();
        }
        return true;
    }

    static /* synthetic */ void a(StringBuilder sb, Map map) {
        for (String str : map.keySet()) {
            b(sb, str, (String) map.get(str));
        }
    }

    static void a(String str) {
        synchronized (b) {
            File file = new File(m());
            a aVar = new a(XStateConstants.KEY_PV, true, true);
            String c2 = g.c(file);
            if (!g.a(c2)) {
                aVar.c(c2);
            }
            aVar.a(str, 1);
            aVar.a("aujv", 1);
            g.a(file, aVar.a(false, false, false));
        }
    }

    static boolean b(int i2, Object[] objArr) {
        switch (i2) {
            case 351:
                if (a || objArr != null) {
                    String str = (String) objArr[0];
                    int intValue = ((Integer) objArr[1]).intValue();
                    if (intValue == 1) {
                        if (j) {
                            return false;
                        }
                        j = true;
                    }
                    File file = new File(str);
                    ArrayList<a> a2 = a(file, "crp", 100);
                    if (intValue != 4) {
                        a aVar = new a("crp", false, false);
                        String str2 = "1";
                        if (intValue == 1) {
                            aVar.a("et", String.valueOf(b.I()));
                            aVar.a("ete", String.valueOf(b.J()));
                        } else if (intValue == 3) {
                            aVar.a("et", str2);
                            aVar.a("ete", str2);
                        } else if (intValue == 2) {
                            aVar.a("hpv", str2);
                        }
                        aVar.a("prc", e.h());
                        if (!b.F()) {
                            str2 = "0";
                        }
                        aVar.a(MonitorType.IMPRESSION, str2);
                        a(aVar);
                        a2.add(0, aVar);
                    }
                    if (!a2.isEmpty()) {
                        boolean b2 = b(e.q(), a((Iterable<a>) a2, true, false).toString());
                        g.b(file);
                        if (!b2) {
                            g.a(file, a((Iterable<a>) a2, false, true).toString());
                        }
                    }
                    return true;
                }
                throw new AssertionError();
            case 352:
                if (a || objArr != null) {
                    return d((String) objArr[0]);
                }
                throw new AssertionError();
            case 353:
                if (a || objArr != null) {
                    return b((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                }
                throw new AssertionError();
            case PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH /*{ENCODED_INT: 354}*/:
                if (a || objArr != null) {
                    File file2 = new File((String) objArr[0]);
                    boolean b3 = b(e.q(), a((Iterable<a>) a(file2, "cst", 30), true, false).toString());
                    if (b3) {
                        g.b(file2);
                    }
                    return b3;
                }
                throw new AssertionError();
            default:
                return false;
        }
    }

    public static void a() {
        a(0, b.H() ? 700000 : 70000);
    }

    private static void a(int i2, long j2) {
        if (b.F()) {
            f.a(0, new e(302, new Object[]{Integer.valueOf(i2)}), j2);
        }
    }

    public static boolean a(String str, String str2) {
        String str3;
        try {
            String str4 = "c_" + str.replaceAll("[^0-9a-zA-Z-_]", "-");
            if (g.a(str2)) {
                str3 = "";
            } else {
                str3 = str2.replaceAll("[`=]", "-");
            }
            Map<String, String> map = c;
            synchronized (map) {
                if (map.get(str4) == null) {
                    int i2 = d;
                    if (i2 >= 20) {
                        return false;
                    }
                    d = i2 + 1;
                }
                map.put(str4, str3);
                return true;
            }
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    public static void b(boolean z) {
        if (!a(z, "crash detail upload")) {
            String str = g.U() + "dt.wa";
            b.a(f, str, new e(352, new Object[]{str}));
            String n = n();
            b.a(g, n, new e(PlaybackParamKey.KEY_PARAMETER_SET_RENDER_SWITCH, new Object[]{n}));
        }
    }

    private static boolean b(String str, String str2, boolean z, boolean z2) {
        a aVar;
        File file = new File(n());
        ArrayList<a> a2 = a(file, "cst", 30);
        String str3 = str + str2;
        Iterator<a> it = a2.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (str3.equals(aVar.b("prc") + aVar.b("typ"))) {
                break;
            }
        }
        if (aVar == null) {
            aVar = new a("cst", false, true);
            aVar.a("prc", str);
            aVar.a("typ", str2);
            a(aVar);
            a2.add(aVar);
        }
        aVar.a("cnt", 1);
        if (z) {
            aVar.a("lim", 1);
        }
        if (z2) {
            aVar.a("syu", 1);
        }
        return g.a(file, a((Iterable<a>) a2, false, false).toString());
    }

    private static void a(a aVar) {
        Map<String, String> map = c;
        synchronized (map) {
            for (String str : map.keySet()) {
                aVar.a(str, c.get(str));
            }
        }
    }

    public static void a(boolean z) {
        a(1, z);
    }

    public static boolean a(boolean z, String str) {
        if (!b.d || z || !JNIBridge.nativeIsCrashing()) {
            return false;
        }
        a.b("crashsdk", "Native is crashing, skip stat for " + str);
        return true;
    }

    private static void a(int i2, boolean z) {
        if (!a(z, "crash rate")) {
            String str = g.U() + "cr.wa";
            b.a(b, str, new e(351, new Object[]{str, Integer.valueOf(i2)}));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0077  */
    private static boolean b(String str, String str2) {
        boolean z;
        String d2;
        String str3;
        byte[] a2;
        if (g.a(str2)) {
            return true;
        }
        byte[] bytes = str2.getBytes();
        try {
            byte[] bArr = new byte[16];
            c.a(bArr, 0, c.a());
            c.a(bArr, 4, j());
            c.a(bArr, 8, com.uc.crashsdk.a.f());
            c.a(bArr, 12, d.d());
            byte[] a3 = c.a(bytes, bArr);
            if (a3 != null) {
                bytes = a3;
                z = true;
                if (str == null) {
                    str = "unknown";
                }
                String str4 = !g.P() ? "4ea4e41a3993" : "28ef1713347d";
                String valueOf = String.valueOf(System.currentTimeMillis());
                d2 = g.d(str4 + str + valueOf + "AppChk#2014");
                if (d2 != null) {
                    str3 = null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(p());
                    sb.append("?chk=");
                    sb.append(d2.substring(d2.length() - 8, d2.length()));
                    sb.append("&vno=");
                    sb.append(valueOf);
                    sb.append("&uuid=");
                    sb.append(str);
                    sb.append("&app=");
                    sb.append(str4);
                    if (z) {
                        sb.append("&enc=aes");
                    }
                    str3 = sb.toString();
                }
                if (str3 == null && (a2 = c.a(str3, bytes)) != null && new String(a2).contains("retcode=0")) {
                    return true;
                }
                return false;
            }
        } catch (Throwable th) {
            g.a(th);
        }
        z = false;
        if (str == null) {
        }
        if (!g.P()) {
        }
        String valueOf2 = String.valueOf(System.currentTimeMillis());
        d2 = g.d(str4 + str + valueOf2 + "AppChk#2014");
        if (d2 != null) {
        }
        if (str3 == null) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006a, code lost:
        if (r3 == false) goto L_0x006c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00af  */
    static void a(int i2, Object[] objArr) {
        String q;
        long j2;
        String str;
        boolean z;
        switch (i2) {
            case 301:
                if (a || objArr != null) {
                    a(((Integer) objArr[0]).intValue(), false);
                    return;
                }
                throw new AssertionError();
            case 302:
                if (a || objArr != null) {
                    synchronized (b) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        if (intValue == 0) {
                            if (!i) {
                                i = true;
                            }
                        }
                        if (!com.uc.crashsdk.a.b.equals("2.0") || !b.c(268435456)) {
                            File file = new File(m());
                            String c2 = g.c(file);
                            a aVar = new a(XStateConstants.KEY_PV, true, true);
                            if (!g.a(c2)) {
                                aVar.c(c2);
                            }
                            if (intValue == 0) {
                                if (aVar.b != Process.myPid()) {
                                    z = false;
                                    break;
                                } else {
                                    z = true;
                                    break;
                                }
                            }
                            if (intValue == 0) {
                                aVar.a(XStateConstants.KEY_PV, 1);
                                str = "fjv";
                            } else if (intValue == 1) {
                                str = "hpv";
                            } else {
                                if (intValue == 2) {
                                    aVar.a(XStateConstants.KEY_PV, 1);
                                    str = "npv";
                                }
                                q = e.q();
                                j2 = aVar.a;
                                if ((j2 != 0 || System.currentTimeMillis() - j2 >= 28800000) ? b(q, aVar.a(true, true, false)) : false) {
                                    aVar.c = new HashMap();
                                    aVar.a = System.currentTimeMillis();
                                    aVar.b = Process.myPid();
                                }
                                g.a(file, aVar.a(false, false, true));
                            }
                            aVar.a(str, 1);
                            q = e.q();
                            j2 = aVar.a;
                            if ((j2 != 0 || System.currentTimeMillis() - j2 >= 28800000) ? b(q, aVar.a(true, true, false)) : false) {
                            }
                            g.a(file, aVar.a(false, false, true));
                        }
                    }
                    return;
                }
                throw new AssertionError();
            case 303:
                b(false);
                return;
            default:
                if (!a) {
                    throw new AssertionError();
                }
                return;
        }
    }

    static void b(String str) {
        synchronized (k) {
            l = str;
            String k2 = b.k();
            b.a(k2, str + StringUtils.LF);
        }
    }

    private static StringBuilder a(Iterable<a> iterable, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (a aVar : iterable) {
            if (z3) {
                sb.append(aVar.a(z, z, z2));
                z3 = false;
            } else {
                sb.append(aVar.a(false, z, z2));
            }
        }
        return sb;
    }

    public static void a(String str, int i2, int i3) {
        if (g.O()) {
            synchronized (f) {
                Map<String, a> map = e;
                a aVar = map.get(str);
                if (aVar == null) {
                    aVar = new a("cst", false, true);
                    map.put(str, aVar);
                    a(aVar);
                }
                SparseArray<String> sparseArray = h;
                synchronized (sparseArray) {
                    if (sparseArray.size() == 0) {
                        a(100, XStateConstants.KEY_PV);
                        a(102, "hpv");
                        a(1, "all");
                        a(2, "afg");
                        a(101, "abg");
                        a(3, "jfg");
                        a(4, "jbg");
                        a(7, "nfg");
                        a(8, "nbg");
                        a(27, "nafg");
                        a(28, "nabg");
                        a(9, "nho");
                        a(10, "uar");
                        a(29, "ulm");
                        a(30, "ukt");
                        a(31, "uet");
                        a(32, "urs");
                        a(11, "ufg");
                        a(12, "ubg");
                        a(40, "anf");
                        a(41, "anb");
                        a(42, "ancf");
                        a(43, "ancb");
                        a(13, "lup");
                        a(14, "luf");
                        a(15, "lef");
                        a(200, "ltf");
                        a(16, "laf");
                        a(22, "lac");
                        a(23, "lau");
                        a(17, "llf");
                        a(18, "lul");
                        a(19, "lub");
                        a(20, "luc");
                        a(21, "luu");
                        a(24, "lzc");
                        a(201, "lec");
                        a(25, "lrc");
                        a(26, "lss");
                    }
                }
                String str2 = sparseArray.get(i2);
                if (str2 == null) {
                    a.a("crashsdk", "map key is not set with: " + i2, null);
                }
                aVar.a("prc", str);
                if (str2 != null) {
                    aVar.a(str2, String.valueOf(i3));
                }
            }
        }
    }

    public static boolean a(String str, String str2, boolean z, boolean z2) {
        if (!g.O()) {
            return false;
        }
        String n = n();
        return b.a(g, n, new e(353, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}));
    }

    private static void a(int i2, String str) {
        h.put(i2, str);
    }

    private static ArrayList<a> a(File file, String str, int i2) {
        ArrayList<String> a2 = g.a(file, i2);
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<String> it = a2.iterator();
        while (it.hasNext()) {
            a aVar = new a(str, false, false);
            if (aVar.c(it.next())) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
