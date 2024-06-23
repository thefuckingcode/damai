package com.amap.api.mapcore.util;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public final class js {
    static long d;
    static long e;
    static long f;
    public static long g;
    static long h;
    public static HashMap<String, Long> s = new HashMap<>(36);
    public static long t = 0;
    static int u = 0;
    public static long w = 0;
    WifiManager a;
    ArrayList<ScanResult> b = new ArrayList<>();
    ArrayList<kx> c = new ArrayList<>();
    Context i;
    boolean j = false;
    StringBuilder k = null;
    boolean l = true;
    boolean m = true;
    boolean n = true;
    String o = null;
    TreeMap<Integer, ScanResult> p = null;
    public boolean q = true;
    public boolean r = false;
    ConnectivityManager v = null;
    volatile boolean x = false;
    private volatile WifiInfo y = null;
    private long z = 30000;

    public js(Context context, WifiManager wifiManager) {
        this.a = wifiManager;
        this.i = context;
    }

    private static boolean a(int i2) {
        int i3 = 20;
        try {
            i3 = WifiManager.calculateSignalLevel(i2, 20);
        } catch (ArithmeticException e2) {
            jy.a(e2, "Aps", "wifiSigFine");
        }
        return i3 > 0;
    }

    public static boolean a(WifiInfo wifiInfo) {
        return wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getSSID()) && kc.a(wifiInfo.getBSSID());
    }

    private void d(boolean z2) {
        String str;
        ArrayList<ScanResult> arrayList = this.b;
        if (!(arrayList == null || arrayList.isEmpty())) {
            if (kc.b() - g > DateUtils.MILLIS_PER_HOUR) {
                b();
            }
            if (this.p == null) {
                this.p = new TreeMap<>(Collections.reverseOrder());
            }
            this.p.clear();
            if (this.r && z2) {
                try {
                    this.c.clear();
                } catch (Throwable unused) {
                }
            }
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ScanResult scanResult = this.b.get(i2);
                if (kc.a(scanResult != null ? scanResult.BSSID : "") && (size <= 20 || a(scanResult.level))) {
                    if (this.r && z2) {
                        try {
                            kx kxVar = new kx(false);
                            kxVar.b = scanResult.SSID;
                            kxVar.d = scanResult.frequency;
                            kxVar.e = scanResult.timestamp;
                            kxVar.a = kx.a(scanResult.BSSID);
                            kxVar.c = (short) scanResult.level;
                            if (Build.VERSION.SDK_INT >= 17) {
                                short elapsedRealtime = (short) ((int) ((SystemClock.elapsedRealtime() - (scanResult.timestamp / 1000)) / 1000));
                                kxVar.g = elapsedRealtime;
                                if (elapsedRealtime < 0) {
                                    kxVar.g = 0;
                                }
                            }
                            kxVar.f = System.currentTimeMillis();
                            this.c.add(kxVar);
                        } catch (Throwable unused2) {
                        }
                    }
                    if (!TextUtils.isEmpty(scanResult.SSID)) {
                        if (!"<unknown ssid>".equals(scanResult.SSID)) {
                            str = String.valueOf(i2);
                        }
                        this.p.put(Integer.valueOf((scanResult.level * 25) + i2), scanResult);
                    } else {
                        str = "unkwn";
                    }
                    scanResult.SSID = str;
                    this.p.put(Integer.valueOf((scanResult.level * 25) + i2), scanResult);
                }
            }
            this.b.clear();
            for (ScanResult scanResult2 : this.p.values()) {
                this.b.add(scanResult2);
            }
            this.p.clear();
        }
    }

    private void e(boolean z2) {
        this.l = z2;
        this.m = true;
        this.n = true;
        this.z = 30000;
    }

    public static String i() {
        return String.valueOf(kc.b() - g);
    }

    private List<ScanResult> j() {
        long b2;
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            try {
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (Build.VERSION.SDK_INT >= 17) {
                    HashMap<String, Long> hashMap = new HashMap<>(36);
                    for (ScanResult scanResult : scanResults) {
                        hashMap.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                    }
                    if (s.isEmpty() || !s.equals(hashMap)) {
                        s = hashMap;
                        b2 = kc.b();
                    }
                    this.o = null;
                    return scanResults;
                }
                b2 = kc.b();
                t = b2;
                this.o = null;
                return scanResults;
            } catch (SecurityException e2) {
                this.o = e2.getMessage();
            } catch (Throwable th) {
                this.o = null;
                jy.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private WifiInfo k() {
        try {
            WifiManager wifiManager = this.a;
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
            return null;
        } catch (Throwable th) {
            jy.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    private int l() {
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean m() {
        long b2 = kc.b() - d;
        if (b2 < 4900) {
            return false;
        }
        if (n() && b2 < 9900) {
            return false;
        }
        if (u > 1) {
            long j2 = this.z;
            if (j2 == 30000) {
                j2 = jx.b() != -1 ? jx.b() : 30000;
            }
            if (Build.VERSION.SDK_INT >= 28 && b2 < j2) {
                return false;
            }
        }
        if (this.a == null) {
            return false;
        }
        d = kc.b();
        int i2 = u;
        if (i2 < 2) {
            u = i2 + 1;
        }
        return this.a.startScan();
    }

    private boolean n() {
        if (this.v == null) {
            this.v = (ConnectivityManager) kc.a(this.i, "connectivity");
        }
        return a(this.v);
    }

    private boolean o() {
        if (this.a == null) {
            return false;
        }
        return kc.c(this.i);
    }

    private void p() {
        if (s()) {
            long b2 = kc.b();
            if (b2 - e >= 10000) {
                this.b.clear();
                h = g;
            }
            q();
            if (b2 - e >= 10000) {
                for (int i2 = 20; i2 > 0 && g == h; i2--) {
                    try {
                        Thread.sleep(150);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void q() {
        if (s()) {
            try {
                if (m()) {
                    f = kc.b();
                }
            } catch (Throwable th) {
                jy.a(th, "WifiManager", "wifiScan");
            }
        }
    }

    private void r() {
        if (h != g) {
            List<ScanResult> list = null;
            try {
                list = j();
            } catch (Throwable th) {
                jy.a(th, "WifiManager", "updateScanResult");
            }
            h = g;
            if (list != null) {
                this.b.clear();
                this.b.addAll(list);
                return;
            }
            this.b.clear();
        }
    }

    private boolean s() {
        boolean o2 = o();
        this.q = o2;
        if (o2 && this.l) {
            if (f == 0) {
                return true;
            }
            if (kc.b() - f >= 4900 && kc.b() - g >= 1500) {
                kc.b();
                return true;
            }
        }
        return false;
    }

    public final ArrayList<ScanResult> a() {
        if (this.b == null) {
            return null;
        }
        ArrayList<ScanResult> arrayList = new ArrayList<>();
        if (!this.b.isEmpty()) {
            arrayList.addAll(this.b);
        }
        return arrayList;
    }

    public final void a(boolean z2) {
        Context context = this.i;
        if (jx.a() && this.n && this.a != null && context != null && z2 && kc.c() > 17) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                if (((Integer) ka.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                    ka.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
                }
            } catch (Throwable th) {
                jy.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
            }
        }
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.a;
        if (wifiManager == null) {
            return false;
        }
        try {
            return kc.a(com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == 1 && a(wifiManager.getConnectionInfo());
        } catch (Throwable th) {
            jy.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void b() {
        this.y = null;
        this.b.clear();
    }

    public final void b(boolean z2) {
        if (z2) {
            p();
        } else {
            q();
        }
        boolean z3 = false;
        if (this.x) {
            this.x = false;
            b();
        }
        r();
        if (kc.b() - g > 20000) {
            this.b.clear();
        }
        e = kc.b();
        if (this.b.isEmpty()) {
            g = kc.b();
            List<ScanResult> j2 = j();
            if (j2 != null) {
                this.b.addAll(j2);
                z3 = true;
            }
        }
        d(z3);
    }

    public final void c() {
        if (this.a != null && kc.b() - g > 4900) {
            g = kc.b();
        }
    }

    public final void c(boolean z2) {
        e(z2);
    }

    public final void d() {
        int i2;
        if (this.a != null) {
            try {
                i2 = l();
            } catch (Throwable th) {
                jy.a(th, "Aps", "onReceive part");
                i2 = 4;
            }
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            if (i2 == 0 || i2 == 1 || i2 == 4) {
                this.x = true;
            }
        }
    }

    public final boolean e() {
        return this.q;
    }

    public final WifiInfo f() {
        this.y = k();
        return this.y;
    }

    public final boolean g() {
        return this.j;
    }

    public final void h() {
        b();
        this.b.clear();
    }
}
