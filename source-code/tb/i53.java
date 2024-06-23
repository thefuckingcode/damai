package tb;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.loc.d1;
import com.loc.ek;
import com.loc.i1;
import com.loc.j1;
import com.loc.k1;
import com.loc.m1;
import com.loc.y0;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public final class i53 {
    static long A;
    public static HashMap<String, Long> B = new HashMap<>(36);
    public static long C = 0;
    static int D = 0;
    public static long E = 0;
    static long w;
    static long x;
    static long y;
    public static long z;
    WifiManager a;
    ArrayList<y0> b = new ArrayList<>();
    ArrayList<y0> c = new ArrayList<>();
    Context d;
    boolean e = false;
    StringBuilder f = null;
    boolean g = true;
    boolean h = true;
    boolean i = true;
    private volatile WifiInfo j = null;
    String k = null;
    TreeMap<Integer, y0> l = null;
    public boolean m = true;
    public boolean n = true;
    public boolean o = false;
    d1 p;
    String q = "";
    long r = 0;
    ConnectivityManager s = null;
    private long t = 30000;
    private ek u;
    volatile boolean v = false;

    public i53(Context context, WifiManager wifiManager, Handler handler) {
        this.a = wifiManager;
        this.d = context;
        d1 d1Var = new d1(context, "wifiAgee", handler);
        this.p = d1Var;
        d1Var.c();
    }

    public static String A() {
        return String.valueOf(m1.B() - z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087 A[Catch:{ SecurityException -> 0x010c, all -> 0x0101 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009f A[Catch:{ SecurityException -> 0x010c, all -> 0x0101 }] */
    private List<y0> C() {
        List<ScanResult> list;
        int size;
        int i2;
        long B2;
        if (this.a != null) {
            try {
                if (m1.N(this.d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                    list = this.a.getScanResults();
                } else {
                    j1.h(new Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");
                    list = null;
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    HashMap<String, Long> hashMap = new HashMap<>(36);
                    if (list != null) {
                        for (ScanResult scanResult : list) {
                            hashMap.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                        }
                    }
                    if (B.isEmpty() || !B.equals(hashMap)) {
                        B = hashMap;
                        B2 = m1.B();
                    }
                    this.k = null;
                    ArrayList arrayList = new ArrayList();
                    this.q = "";
                    this.j = x();
                    if (i(this.j)) {
                        this.q = this.j.getBSSID();
                    }
                    if (list != null && list.size() > 0) {
                        size = list.size();
                        for (i2 = 0; i2 < size; i2++) {
                            ScanResult scanResult2 = list.get(i2);
                            y0 y0Var = new y0(!TextUtils.isEmpty(this.q) && this.q.equals(scanResult2.BSSID));
                            y0Var.b = scanResult2.SSID;
                            y0Var.d = scanResult2.frequency;
                            y0Var.e = scanResult2.timestamp;
                            y0Var.a = y0.a(scanResult2.BSSID);
                            y0Var.c = (short) scanResult2.level;
                            if (Build.VERSION.SDK_INT >= 17) {
                                short elapsedRealtime = (short) ((int) ((SystemClock.elapsedRealtime() - (scanResult2.timestamp / 1000)) / 1000));
                                y0Var.g = elapsedRealtime;
                                if (elapsedRealtime < 0) {
                                    y0Var.g = 0;
                                }
                            }
                            y0Var.f = m1.B();
                            arrayList.add(y0Var);
                        }
                    }
                    this.p.f(arrayList);
                    return arrayList;
                }
                B2 = m1.B();
                C = B2;
                this.k = null;
                ArrayList arrayList2 = new ArrayList();
                this.q = "";
                this.j = x();
                if (i(this.j)) {
                }
                size = list.size();
                while (i2 < size) {
                }
                this.p.f(arrayList2);
                return arrayList2;
            } catch (SecurityException e2) {
                this.k = e2.getMessage();
            } catch (Throwable th) {
                this.k = null;
                j1.h(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private int D() {
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean E() {
        long B2 = m1.B() - w;
        if (B2 < 4900) {
            return false;
        }
        if (F() && B2 < 9900) {
            return false;
        }
        if (D > 1) {
            long j2 = this.t;
            if (j2 == 30000) {
                j2 = i1.D() != -1 ? i1.D() : 30000;
            }
            if (Build.VERSION.SDK_INT >= 28 && B2 < j2) {
                return false;
            }
        }
        if (this.a != null) {
            w = m1.B();
            int i2 = D;
            if (i2 < 2) {
                D = i2 + 1;
            }
            if (m1.N(this.d, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF")) {
                return this.a.startScan();
            }
            j1.h(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
        }
        return false;
    }

    private boolean F() {
        if (this.s == null) {
            this.s = (ConnectivityManager) m1.h(this.d, "connectivity");
        }
        return h(this.s);
    }

    private boolean G() {
        if (this.a == null) {
            return false;
        }
        return m1.Y(this.d);
    }

    private void H() {
        if (b()) {
            long B2 = m1.B();
            if (B2 - x >= 10000) {
                this.b.clear();
                A = z;
            }
            I();
            if (B2 - x >= 10000) {
                for (int i2 = 20; i2 > 0 && z == A; i2--) {
                    try {
                        Thread.sleep(150);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void I() {
        if (b()) {
            try {
                if (E()) {
                    y = m1.B();
                }
            } catch (Throwable th) {
                j1.h(th, "WifiManager", "wifiScan");
            }
        }
    }

    private void J() {
        if (A != z) {
            List<y0> list = null;
            try {
                list = C();
            } catch (Throwable th) {
                j1.h(th, "WifiManager", "updateScanResult");
            }
            A = z;
            if (list != null) {
                this.b.clear();
                this.b.addAll(list);
                return;
            }
            this.b.clear();
        }
    }

    private void K() {
        int i2;
        try {
            if (this.a != null) {
                try {
                    i2 = D();
                } catch (Throwable th) {
                    j1.h(th, "OPENSDK_WMW", "cwsc");
                    i2 = 4;
                }
                if (this.b == null) {
                    this.b = new ArrayList<>();
                }
                if (i2 == 0 || i2 == 1 || i2 == 4) {
                    r();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void a() {
        try {
            if (m1.N(this.d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                this.n = this.a.isWifiEnabled();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean b() {
        this.m = G();
        a();
        if (this.m && this.g) {
            if (y == 0) {
                return true;
            }
            if (m1.B() - y >= 4900 && m1.B() - z >= 1500) {
                m1.B();
                return true;
            }
        }
        return false;
    }

    private static boolean g(int i2) {
        int i3 = 20;
        try {
            i3 = WifiManager.calculateSignalLevel(i2, 20);
        } catch (ArithmeticException e2) {
            j1.h(e2, "Aps", "wifiSigFine");
        }
        return i3 > 0;
    }

    public static boolean i(WifiInfo wifiInfo) {
        return wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getSSID()) && m1.s(wifiInfo.getBSSID());
    }

    public static long j() {
        return ((m1.B() - C) / 1000) + 1;
    }

    private void o(boolean z2) {
        String str;
        ArrayList<y0> arrayList = this.b;
        if (!(arrayList == null || arrayList.isEmpty())) {
            if (m1.B() - z > DateUtils.MILLIS_PER_HOUR) {
                r();
            }
            if (this.l == null) {
                this.l = new TreeMap<>(Collections.reverseOrder());
            }
            this.l.clear();
            if (this.o && z2) {
                try {
                    this.c.clear();
                } catch (Throwable unused) {
                }
            }
            int size = this.b.size();
            this.r = 0;
            for (int i2 = 0; i2 < size; i2++) {
                y0 y0Var = this.b.get(i2);
                if (y0Var.h) {
                    this.r = y0Var.f;
                }
                if (m1.s(y0.c(y0Var.a)) && (size <= 20 || g(y0Var.c))) {
                    if (this.o && z2) {
                        this.c.add(y0Var);
                    }
                    if (!TextUtils.isEmpty(y0Var.b)) {
                        if (!"<unknown ssid>".equals(y0Var.b)) {
                            str = String.valueOf(i2);
                        }
                        this.l.put(Integer.valueOf((y0Var.c * 25) + i2), y0Var);
                    } else {
                        str = "unkwn";
                    }
                    y0Var.b = str;
                    this.l.put(Integer.valueOf((y0Var.c * 25) + i2), y0Var);
                }
            }
            this.b.clear();
            for (y0 y0Var2 : this.l.values()) {
                this.b.add(y0Var2);
            }
            this.l.clear();
        }
    }

    public final long B() {
        return this.r;
    }

    public final ArrayList<y0> c() {
        if (!this.o) {
            return this.c;
        }
        k(true);
        return this.c;
    }

    public final void d(ek ekVar) {
        this.u = ekVar;
    }

    public final void e(boolean z2) {
        Context context = this.d;
        if (i1.C() && this.i && this.a != null && context != null && z2 && m1.K() > 17) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                if (((Integer) k1.e("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                    k1.e("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
                }
            } catch (Throwable th) {
                j1.h(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
            }
        }
    }

    public final void f(boolean z2, boolean z3, boolean z4, long j2) {
        this.g = z2;
        this.h = z3;
        this.i = z4;
        if (j2 < 10000) {
            this.t = 10000;
        } else {
            this.t = j2;
        }
    }

    public final boolean h(ConnectivityManager connectivityManager) {
        try {
            return m1.f(com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == 1 && i(l());
        } catch (Throwable th) {
            j1.h(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void k(boolean z2) {
        if (z2) {
            H();
        } else {
            I();
        }
        boolean z3 = false;
        if (this.v) {
            this.v = false;
            K();
        }
        J();
        if (m1.B() - z > 20000) {
            this.b.clear();
        }
        x = m1.B();
        if (this.b.isEmpty()) {
            z = m1.B();
            List<y0> C2 = C();
            if (C2 != null) {
                this.b.addAll(C2);
                z3 = true;
            }
        }
        o(z3);
    }

    public final WifiInfo l() {
        try {
            if (this.a == null) {
                return null;
            }
            if (m1.N(this.d, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                return this.a.getConnectionInfo();
            }
            j1.h(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");
            return null;
        } catch (Throwable th) {
            j1.h(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    public final void m(boolean z2) {
        r();
        this.b.clear();
        this.p.g(z2);
    }

    public final String n() {
        return this.k;
    }

    public final ArrayList<y0> p() {
        if (this.b == null) {
            return null;
        }
        ArrayList<y0> arrayList = new ArrayList<>();
        if (!this.b.isEmpty()) {
            arrayList.addAll(this.b);
        }
        return arrayList;
    }

    public final void q() {
        try {
            this.o = true;
            List<y0> C2 = C();
            if (C2 != null) {
                this.b.clear();
                this.b.addAll(C2);
            }
            o(true);
        } catch (Throwable unused) {
        }
    }

    public final void r() {
        this.j = null;
        this.b.clear();
    }

    public final void s() {
        E = System.currentTimeMillis();
        ek ekVar = this.u;
        if (ekVar != null) {
            ekVar.l();
        }
    }

    public final void t() {
        if (this.a != null && m1.B() - z > 4900) {
            z = m1.B();
        }
    }

    public final void u() {
        if (this.a != null) {
            this.v = true;
        }
    }

    public final boolean v() {
        return this.m;
    }

    public final boolean w() {
        return this.n;
    }

    public final WifiInfo x() {
        this.j = l();
        return this.j;
    }

    public final boolean y() {
        return this.e;
    }

    public final String z() {
        boolean z2;
        String str;
        StringBuilder sb = this.f;
        if (sb == null) {
            this.f = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        this.e = false;
        int size = this.b.size();
        int i2 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i2 < size) {
            String c2 = y0.c(this.b.get(i2).a);
            if (!this.h && !"<unknown ssid>".equals(this.b.get(i2).b)) {
                z3 = true;
            }
            if (TextUtils.isEmpty(this.q) || !this.q.equals(c2)) {
                z2 = z4;
                str = "nb";
            } else {
                str = oj2.TAG_ACCESS;
                z2 = true;
            }
            this.f.append(String.format(Locale.US, "#%s,%s", c2, str));
            i2++;
            z4 = z2;
        }
        if (this.b.size() == 0) {
            z3 = true;
        }
        if (!this.h && !z3) {
            this.e = true;
        }
        if (!z4 && !TextUtils.isEmpty(this.q)) {
            StringBuilder sb2 = this.f;
            sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            sb2.append(this.q);
            this.f.append(",access");
        }
        return this.f.toString();
    }
}
