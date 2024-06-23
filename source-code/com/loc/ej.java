package com.loc;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import cn.damai.common.app.ShareperfenceConstants;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.Locale;
import tb.g53;
import tb.h53;
import tb.i53;
import tb.q23;
import tb.r53;
import tb.s53;
import tb.t53;

@SuppressLint({"NewApi"})
/* compiled from: Taobao */
public final class ej {
    public static String[] O = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    public static String P = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private static volatile boolean Q = false;
    boolean A = false;
    int B = 12;
    private boolean C = true;
    z0 D = null;
    boolean E = false;
    g53 F = null;
    String G = null;
    private Handler H;
    private ev I;
    boolean J = false;
    IntentFilter K = null;
    LocationManager L = null;
    private String M;
    private ek N;
    Context a = null;
    ConnectivityManager b = null;
    i53 c = null;
    c1 d = null;
    f1 e = null;
    s53 f = null;
    ArrayList<y0> g = new ArrayList<>();
    a h = null;
    AMapLocationClientOption i = new AMapLocationClientOption();
    eo j = null;
    long k = 0;
    private int l = 0;
    t53 m = null;
    boolean n = false;
    private String o = null;
    h1 p = null;
    StringBuilder q = new StringBuilder();
    boolean r = true;
    boolean s = true;
    AMapLocationClientOption.GeoLanguage t = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean u = true;
    boolean v = false;
    WifiInfo w = null;
    boolean x = true;
    private String y = null;
    StringBuilder z = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends BroadcastReceiver {
        a() {
        }

        public final void onReceive(Context context, Intent intent) {
            i53 i53;
            i53 i532;
            if (context != null && intent != null) {
                try {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action)) {
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            i53 i533 = ej.this.c;
                            if (i533 != null) {
                                i533.t();
                            }
                            try {
                                if (intent.getExtras() != null && intent.getExtras().getBoolean("resultsUpdated", true) && (i532 = ej.this.c) != null) {
                                    i532.s();
                                }
                            } catch (Throwable unused) {
                            }
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED") && (i53 = ej.this.c) != null) {
                            i53.u();
                        }
                    }
                } catch (Throwable th) {
                    j1.h(th, "Aps", "onReceive");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[AMapLocationClientOption.GeoLanguage.values().length];
            a = iArr;
            iArr[AMapLocationClientOption.GeoLanguage.DEFAULT.ordinal()] = 1;
            a[AMapLocationClientOption.GeoLanguage.ZH.ordinal()] = 2;
            try {
                a[AMapLocationClientOption.GeoLanguage.EN.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public ej(boolean z2) {
        this.J = z2;
    }

    private void D() {
        if (this.p != null) {
            try {
                if (this.i == null) {
                    this.i = new AMapLocationClientOption();
                }
                this.p.e(this.i.getHttpTimeOut(), this.i.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS), E());
            } catch (Throwable unused) {
            }
        }
    }

    private int E() {
        int i2;
        if (!(this.i.getGeoLanguage() == null || (i2 = b.a[this.i.getGeoLanguage().ordinal()]) == 1)) {
            if (i2 != 2) {
                return i2 != 3 ? 0 : 2;
            }
            return 1;
        }
    }

    private void F() {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        AMapLocationClientOption.GeoLanguage geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean z6 = true;
        try {
            geoLanguage = this.i.getGeoLanguage();
            z3 = this.i.isNeedAddress();
            try {
                z2 = this.i.isOffset();
            } catch (Throwable unused) {
                z5 = true;
                z2 = z6;
                z4 = z5;
                this.s = z2;
                this.r = z3;
                this.u = z4;
                this.t = geoLanguage;
            }
            try {
                z4 = this.i.isLocationCacheEnable();
            } catch (Throwable unused2) {
                z6 = z2;
                z5 = true;
                z2 = z6;
                z4 = z5;
                this.s = z2;
                this.r = z3;
                this.u = z4;
                this.t = geoLanguage;
            }
            try {
                this.v = this.i.isOnceLocationLatest();
                this.E = this.i.isSensorEnable();
                if (!(z2 == this.s && z3 == this.r && z4 == this.u && geoLanguage == this.t)) {
                    M();
                }
            } catch (Throwable unused3) {
                z5 = z4;
                z6 = z2;
                z2 = z6;
                z4 = z5;
                this.s = z2;
                this.r = z3;
                this.u = z4;
                this.t = geoLanguage;
            }
        } catch (Throwable unused4) {
            z3 = true;
            z5 = true;
            z2 = z6;
            z4 = z5;
            this.s = z2;
            this.r = z3;
            this.u = z4;
            this.t = geoLanguage;
        }
        this.s = z2;
        this.r = z3;
        this.u = z4;
        this.t = geoLanguage;
    }

    private void G() {
        try {
            if (this.h == null) {
                this.h = new a();
            }
            if (this.K == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.K = intentFilter;
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.K.addAction("android.net.wifi.SCAN_RESULTS");
            }
            this.a.registerReceiver(this.h, this.K);
        } catch (Throwable th) {
            j1.h(th, "Aps", "initBroadcastListener");
        }
    }

    private byte[] H() throws Throwable {
        if (this.m == null) {
            this.m = new t53();
        }
        if (this.i == null) {
            this.i = new AMapLocationClientOption();
        }
        this.m.b(this.a, this.i.isNeedAddress(), this.i.isOffset(), this.d, this.c, this.b, this.G, this.I);
        return this.m.e();
    }

    private boolean I() {
        return this.k == 0 || m1.B() - this.k > 20000;
    }

    private void J() {
        i53 i53 = this.c;
        if (i53 != null) {
            i53.e(this.n);
        }
    }

    private boolean K() {
        ArrayList<y0> p2 = this.c.p();
        this.g = p2;
        return p2 == null || p2.size() <= 0;
    }

    private void L() {
        if (this.y != null) {
            this.y = null;
        }
        StringBuilder sb = this.z;
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    private void M() {
        try {
            f1 f1Var = this.e;
            if (f1Var != null) {
                f1Var.f();
            }
            y(null);
            this.C = false;
            g53 g53 = this.F;
            if (g53 != null) {
                g53.c();
            }
        } catch (Throwable th) {
            j1.h(th, "Aps", "cleanCache");
        }
    }

    private static eo b(int i2, String str) {
        eo eoVar = new eo("");
        eoVar.setErrorCode(i2);
        eoVar.setLocationDetail(str);
        if (i2 == 15) {
            l1.p(null, 2151);
        }
        return eoVar;
    }

    private eo e(eo eoVar, q23 q23, ei eiVar) {
        if (q23 != null) {
            try {
                byte[] bArr = q23.a;
                if (bArr != null) {
                    if (bArr.length != 0) {
                        s53 s53 = new s53();
                        String str = new String(q23.a, "UTF-8");
                        if (str.contains("\"status\":\"0\"")) {
                            eo c2 = s53.c(str, this.a, q23, eiVar);
                            c2.h(this.z.toString());
                            return c2;
                        } else if (!str.contains("</body></html>")) {
                            return null;
                        } else {
                            eoVar.setErrorCode(5);
                            i53 i53 = this.c;
                            if (i53 == null || !i53.h(this.b)) {
                                eiVar.f("#0502");
                                this.q.append("请求可能被劫持了#0502");
                                l1.p(null, 2052);
                            } else {
                                eiVar.f("#0501");
                                this.q.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                                l1.p(null, 2051);
                            }
                            eoVar.setLocationDetail(this.q.toString());
                            return eoVar;
                        }
                    }
                }
            } catch (Throwable th) {
                eoVar.setErrorCode(4);
                j1.h(th, "Aps", "checkResponseEntity");
                eiVar.f("#0403");
                StringBuilder sb = this.q;
                sb.append("check response exception ex is" + th.getMessage() + "#0403");
                eoVar.setLocationDetail(this.q.toString());
                return eoVar;
            }
        }
        eoVar.setErrorCode(4);
        this.q.append("网络异常,请求异常#0403");
        eiVar.f("#0403");
        eoVar.h(this.z.toString());
        eoVar.setLocationDetail(this.q.toString());
        if (q23 != null) {
            l1.p(q23.d, 2041);
        }
        return eoVar;
    }

    private StringBuilder h(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        sb.append(this.d.H());
        sb.append(this.c.z());
        return sb;
    }

    private boolean o(long j2) {
        if (!this.C) {
            this.C = true;
            return false;
        }
        if (m1.B() - j2 < 800) {
            long j3 = 0;
            if (m1.r(this.j)) {
                j3 = m1.g() - this.j.getTime();
            }
            if (j3 <= 10000) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013f  */
    @SuppressLint({"NewApi"})
    private eo p(boolean z2, ei eiVar) {
        StringBuilder sb;
        StringBuilder sb2;
        String str;
        ek ekVar;
        String str2;
        eo e2;
        try {
            if (TextUtils.isEmpty(this.M)) {
                this.M = v1.r(o.w(this.a) + "," + o.R(this.a));
            }
            StringBuilder sb3 = this.q;
            sb3.append("#id:");
            sb3.append(this.M);
        } catch (Throwable unused) {
        }
        String str3 = "";
        eo eoVar = new eo(str3);
        String str4 = null;
        try {
            byte[] H2 = H();
            long B2 = m1.B();
            this.k = B2;
            eiVar.a(B2);
            try {
                j1.r(this.a);
                r53 d2 = this.p.d(this.a, H2, j1.d(), j1.n(), z2);
                d2.j();
                String m2 = d2.m();
                m.c(this.a);
                boolean z3 = !TextUtils.isEmpty(m2) && m2.contains("dualstack");
                int i2 = fc.j;
                if (m.q() && m.G() && z3) {
                    i2 = fc.k;
                }
                if (!m.C()) {
                    str4 = fc.c(this.a).d(d2, i2);
                }
                eiVar.a(i2 == fc.k ? "v6" : "v4");
                q23 c2 = this.p.c(d2);
                long B3 = m1.B();
                if (!TextUtils.isEmpty(str4)) {
                    if (!c2.e) {
                        fc.c(this.a).g(true, i2);
                    } else {
                        fc.c(this.a).g(false, i2);
                        fc.c(this.a).f(i2);
                    }
                }
                if (c2 != null && !TextUtils.isEmpty(str4)) {
                    if (!c2.e) {
                        eiVar.b(str4);
                        eiVar.c("SUCCESS");
                        ekVar = this.N;
                        if (ekVar != null) {
                            ekVar.r();
                        }
                        eiVar.b(B3);
                        if (c2 == null) {
                            if (!TextUtils.isEmpty(c2.c)) {
                                StringBuilder sb4 = this.q;
                                sb4.append("#csid:" + c2.c);
                            }
                            str2 = c2.d;
                            eoVar.h(this.z.toString());
                        } else {
                            str2 = str3;
                        }
                        e2 = e(eoVar, c2, eiVar);
                        if (e2 == null) {
                            return e2;
                        }
                        byte[] g2 = e1.g(c2.a);
                        if (g2 == null) {
                            eoVar.setErrorCode(5);
                            eiVar.f("#0503");
                            this.q.append("解密数据失败#0503");
                            eoVar.setLocationDetail(this.q.toString());
                            l1.p(str2, 2053);
                            return eoVar;
                        }
                        eo a2 = this.f.a(eoVar, g2, eiVar);
                        if (!m1.r(a2)) {
                            String b2 = a2.b();
                            this.o = b2;
                            l1.p(str2, !TextUtils.isEmpty(b2) ? 2062 : 2061);
                            a2.setErrorCode(6);
                            eiVar.f("#0601");
                            StringBuilder sb5 = this.q;
                            StringBuilder sb6 = new StringBuilder("location faile retype:");
                            sb6.append(a2.d());
                            sb6.append(" rdesc:");
                            if (!TextUtils.isEmpty(this.o)) {
                                str3 = this.o;
                            }
                            sb6.append(str3);
                            sb6.append("#0601");
                            sb5.append(sb6.toString());
                            a2.h(this.z.toString());
                            a2.setLocationDetail(this.q.toString());
                            return a2;
                        }
                        w(a2);
                        a2.setOffset(this.s);
                        a2.a(this.r);
                        a2.f(String.valueOf(this.t));
                        a2.e("new");
                        a2.setLocationDetail(this.q.toString());
                        this.G = a2.a();
                        return a2;
                    }
                    eiVar.b(str4);
                    eiVar.c("FAIL");
                }
                eiVar.d("SUCCESS");
                ekVar = this.N;
                if (ekVar != null) {
                }
                eiVar.b(B3);
                if (c2 == null) {
                }
                e2 = e(eoVar, c2, eiVar);
                if (e2 == null) {
                }
            } catch (Throwable th) {
                m1.B();
                eiVar.d("FAIL");
                fc.c(this.a).g(false, fc.j);
                j1.h(th, "Aps", "getApsLoc req");
                l1.s("/mobile/binary", th);
                if (!m1.Q(this.a)) {
                    eiVar.f("#0401");
                    sb2 = this.q;
                    str = "网络异常，未连接到网络，请连接网络#0401";
                } else {
                    if (th instanceof k) {
                        k kVar = th;
                        if (kVar.a().contains("网络异常状态码")) {
                            eiVar.f("#0404");
                            StringBuilder sb7 = this.q;
                            sb7.append("网络异常，状态码错误#0404");
                            sb7.append(kVar.f());
                            eo b3 = b(4, this.q.toString());
                            b3.h(this.z.toString());
                            return b3;
                        } else if (kVar.f() == 23 || Math.abs((m1.B() - this.k) - this.i.getHttpTimeOut()) < 500) {
                            eiVar.f("#0402");
                            sb2 = this.q;
                            str = "网络异常，连接超时#0402";
                        } else {
                            sb = new StringBuilder("#0403,");
                        }
                    } else {
                        sb = new StringBuilder("#0403,");
                    }
                    sb.append(th.getMessage());
                    eiVar.f(sb.toString());
                    this.q.append("网络异常,请求异常#0403");
                    eo b32 = b(4, this.q.toString());
                    b32.h(this.z.toString());
                    return b32;
                }
                sb2.append(str);
                eo b322 = b(4, this.q.toString());
                b322.h(this.z.toString());
                return b322;
            }
        } catch (Throwable th2) {
            eiVar.f("#0301");
            StringBuilder sb8 = this.q;
            sb8.append("get parames error:" + th2.getMessage() + "#0301");
            l1.p(null, 2031);
            eo b4 = b(3, this.q.toString());
            b4.h(this.z.toString());
            return b4;
        }
    }

    private void r(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(v1.v("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.n = true;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01be, code lost:
        if (com.loc.m1.W(r16.a) == false) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01ce, code lost:
        if (com.loc.m1.W(r16.a) == false) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0255, code lost:
        if (r16.x == false) goto L_0x0293;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0290, code lost:
        if (r16.x == false) goto L_0x0293;
     */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x037a  */
    /* JADX WARNING: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    private String u(ei eiVar) {
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        String str2;
        StringBuilder sb3;
        String str3;
        StringBuilder sb4;
        int C2 = this.d.C();
        b1 z2 = this.d.z();
        b1 A2 = this.d.A();
        ArrayList<y0> arrayList = this.g;
        boolean z3 = arrayList == null || arrayList.isEmpty();
        String str4 = "";
        if (z2 == null && A2 == null && z3) {
            if (this.b == null) {
                this.b = (ConnectivityManager) m1.h(this.a, "connectivity");
            }
            if (m1.K() >= 31) {
                if (m1.n(this.a) && !this.c.w()) {
                    this.B = 18;
                    this.q.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1802");
                    l1.p(null, 2132);
                    eiVar.f("#1802");
                    return str4;
                }
            } else if (m1.n(this.a) && !this.c.v()) {
                this.B = 18;
                this.q.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
                l1.p(null, 2132);
                eiVar.f("#1801");
                return str4;
            }
            if (m1.K() >= 28) {
                if (this.L == null) {
                    this.L = (LocationManager) this.a.getApplicationContext().getSystemService("location");
                }
                if (!((Boolean) k1.c(this.L, "isLocationEnabled", new Object[0])).booleanValue()) {
                    this.B = 12;
                    this.q.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                    eiVar.f("#1206");
                    l1.p(null, 2121);
                    return str4;
                }
            }
            if (!m1.U(this.a)) {
                this.B = 12;
                this.q.append("定位权限被禁用,请授予应用定位权限#1201");
                eiVar.f("#1201");
                l1.p(null, 2121);
                return str4;
            } else if (m1.K() < 24 || m1.K() >= 28 || Settings.Secure.getInt(this.a.getContentResolver(), "location_mode", 0) != 0) {
                String F2 = this.d.F();
                String n2 = this.c.n();
                if (this.c.h(this.b) && n2 != null) {
                    this.B = 12;
                    eiVar.f("#1202");
                    this.q.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
                    l1.p(null, 2121);
                    return str4;
                } else if (F2 != null) {
                    this.B = 12;
                    if (!this.c.v()) {
                        eiVar.f("#1204");
                        sb4 = this.q;
                        str3 = "WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204";
                    } else {
                        eiVar.f("#1205");
                        sb4 = this.q;
                        str3 = "获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205";
                    }
                    sb4.append(str3);
                    l1.p(null, 2121);
                    return str4;
                } else if (this.c.v() || this.d.I()) {
                    if (!this.c.v()) {
                        eiVar.f("#1301");
                        sb3 = this.q;
                        str2 = "获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301";
                    } else {
                        str2 = "#1302";
                        eiVar.f(str2);
                        if (this.c.l() != null) {
                            this.q.append("获取到的基站和WIFI信息均为空，请检查是否授予APP定位权限");
                        } else {
                            this.q.append("获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限");
                        }
                        this.q.append("或后台运行没有后台定位权限");
                        sb3 = this.q;
                    }
                    sb3.append(str2);
                    this.B = 13;
                    l1.p(null, 2131);
                    return str4;
                } else {
                    this.B = 19;
                    eiVar.f("#1901");
                    this.q.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
                    l1.p(null, 2133);
                    return str4;
                }
            } else {
                this.B = 12;
                eiVar.f("#1206");
                this.q.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                l1.p(null, 2121);
                return str4;
            }
        } else {
            WifiInfo x2 = this.c.x();
            this.w = x2;
            this.x = i53.i(x2);
            String str5 = "cgi";
            if (C2 != 0) {
                if (C2 != 1) {
                    if (C2 != 2) {
                        this.B = 11;
                        l1.p(null, 2111);
                        eiVar.f("#1101");
                        this.q.append("get cgi failure#1101");
                    } else if (z2 != null) {
                        sb2 = new StringBuilder();
                        sb2.append(z2.a);
                        sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        sb2.append(z2.b);
                        sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        sb2.append(z2.h);
                        sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        sb2.append(z2.i);
                        sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        sb2.append(z2.j);
                        sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        sb2.append("network");
                        sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        if (this.g.isEmpty()) {
                        }
                    }
                    if (TextUtils.isEmpty(str4)) {
                        return str4;
                    }
                    if (!str4.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                        str4 = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str4;
                    }
                    return m1.T() + str4;
                }
                if (z2 != null) {
                    sb2 = new StringBuilder();
                    sb2.append(z2.a);
                    sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb2.append(z2.b);
                    sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb2.append(z2.c);
                    sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb2.append(z2.d);
                    sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb2.append("network");
                    sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    if (this.g.isEmpty()) {
                    }
                }
                if (TextUtils.isEmpty(str4)) {
                }
                str5 = "cgiwifi";
            } else {
                boolean z4 = !this.g.isEmpty() || this.x;
                boolean z5 = A2 != null;
                if (!z5) {
                    if (this.x && this.g.isEmpty()) {
                        this.B = 2;
                        eiVar.f("#0201");
                        this.q.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
                        l1.p(null, 2021);
                        return str4;
                    } else if (this.g.size() == 1) {
                        this.B = 2;
                        if (!this.x) {
                            eiVar.f("#0202");
                            this.q.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                            l1.p(null, GLMapStaticValue.MAP_PARAMETERNAME_CLEAR_INDOORBUILDING_LAST);
                            return str4;
                        } else if (this.g.get(0).h) {
                            eiVar.f("#0202");
                            this.q.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                            l1.p(null, 2021);
                            return str4;
                        }
                    }
                }
                String format = String.format(Locale.US, "#%s#", "network");
                if (z5) {
                    sb2 = new StringBuilder();
                    sb2.append(A2.b());
                    if (!this.g.isEmpty() || this.x) {
                        str5 = "cgiwifi";
                    }
                    sb2.append("network");
                    sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                } else if (z4) {
                    sb2 = new StringBuilder();
                    sb2.append(format);
                    sb2.append("wifi");
                    str4 = sb2.toString();
                    if (TextUtils.isEmpty(str4)) {
                    }
                } else {
                    this.B = 2;
                    if (!this.c.v()) {
                        eiVar.f("#0203");
                        sb = this.q;
                        str = "当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203";
                    } else {
                        eiVar.f("#0204");
                        sb = this.q;
                        str = "当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204";
                    }
                    sb.append(str);
                    l1.p(null, GLMapStaticValue.MAP_PARAMETERNAME_CLEAR_INDOORBUILDING_LAST);
                    if (TextUtils.isEmpty(str4)) {
                    }
                }
            }
            sb2.append(str5);
            str4 = sb2.toString();
            if (TextUtils.isEmpty(str4)) {
            }
        }
    }

    private static void w(eo eoVar) {
        if (eoVar.getErrorCode() != 0 || eoVar.getLocationType() != 0) {
            return;
        }
        if ("-5".equals(eoVar.d()) || "1".equals(eoVar.d()) || "2".equals(eoVar.d()) || "14".equals(eoVar.d()) || "24".equals(eoVar.d()) || "-1".equals(eoVar.d())) {
            eoVar.setLocationType(5);
        } else {
            eoVar.setLocationType(6);
        }
    }

    private void y(eo eoVar) {
        if (eoVar != null) {
            this.j = eoVar;
        }
    }

    public final void A() {
        ek ekVar = this.N;
        if (ekVar != null) {
            ekVar.r();
        }
    }

    public final void B() {
        try {
            if (this.a != null) {
                if (this.N == null) {
                    this.N = new ek(this.a);
                }
                this.N.g(this.d, this.c, this.H);
            }
        } catch (Throwable th) {
            an.m(th, "as", ReportManager.f);
        }
    }

    public final void C() {
        ek ekVar = this.N;
        if (ekVar != null) {
            ekVar.d();
        }
    }

    public final eo a(double d2, double d3) {
        try {
            String b2 = this.p.b(this.a, d2, d3);
            if (!b2.contains("\"status\":\"1\"")) {
                return null;
            }
            eo b3 = this.f.b(b2);
            b3.setLatitude(d2);
            b3.setLongitude(d3);
            return b3;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0164 A[Catch:{ all -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0168 A[Catch:{ all -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x019d  */
    public final eo c(ei eiVar) throws Throwable {
        String u2;
        float f2;
        z0 z0Var;
        long j2;
        boolean z2;
        x();
        eiVar.e("conitue");
        if (this.a == null) {
            eiVar.f("#0101");
            this.q.append("context is null#0101");
            return b(1, this.q.toString());
        }
        int i2 = this.l + 1;
        this.l = i2;
        if (i2 == 1) {
            J();
        }
        if (!o(this.k) || !m1.r(this.j)) {
            z0 z0Var2 = this.D;
            if (z0Var2 != null) {
                if (this.E) {
                    z0Var2.a();
                } else {
                    z0Var2.c();
                }
            }
            try {
                if (!this.i.isOnceLocationLatest()) {
                    if (this.i.isOnceLocation()) {
                        z2 = false;
                        this.c.k(z2);
                        this.g = this.c.p();
                        this.d.o(false, K());
                        u2 = u(eiVar);
                        this.y = u2;
                        if (!TextUtils.isEmpty(u2)) {
                            return b(this.B, this.q.toString());
                        }
                        this.z = h(this.z);
                        if (this.c.y()) {
                            eo b2 = b(15, "networkLocation has been mocked!#1502");
                            eiVar.f("#1502");
                            b2.setMock(true);
                            b2.setTrustedLevel(4);
                            return b2;
                        }
                        eo b3 = this.e.b(this.d, I(), this.j, this.c, this.z, this.y, this.a, false);
                        if (m1.r(b3)) {
                            b3.setTrustedLevel(2);
                        } else {
                            b3 = p(true, eiVar);
                            if (m1.r(b3)) {
                                b3.e("new");
                                this.e.k(this.z.toString());
                                this.e.j(this.d.z());
                            } else {
                                eo b4 = this.e.b(this.d, false, this.j, this.c, this.z, this.y, this.a, true);
                                if (m1.r(b4)) {
                                    eiVar.f("#0001");
                                    b4.setTrustedLevel(2);
                                    y(b4);
                                    b3 = b4;
                                }
                                if (!(this.c == null || b3 == null)) {
                                    j2 = i53.j();
                                    if (j2 > 15) {
                                        b3.setTrustedLevel(1);
                                    } else if (j2 <= 120) {
                                        b3.setTrustedLevel(2);
                                    } else if (j2 <= 600) {
                                        b3.setTrustedLevel(3);
                                    } else {
                                        b3.setTrustedLevel(4);
                                    }
                                }
                                this.e.m(this.y, this.z, b3, this.a, true);
                                m1.r(b3);
                                StringBuilder sb = this.z;
                                sb.delete(0, sb.length());
                                if (b3 != null) {
                                    if (!this.E || (z0Var = this.D) == null) {
                                        b3.setAltitude(0.0d);
                                        f2 = 0.0f;
                                        b3.setBearing(0.0f);
                                    } else {
                                        b3.setAltitude(z0Var.e());
                                        b3.setBearing(this.D.g());
                                        f2 = (float) this.D.h();
                                    }
                                    b3.setSpeed(f2);
                                }
                                y(b3);
                                return this.j;
                            }
                        }
                        y(b3);
                        try {
                            j2 = i53.j();
                            if (j2 > 15) {
                            }
                        } catch (Throwable unused) {
                        }
                        this.e.m(this.y, this.z, b3, this.a, true);
                        m1.r(b3);
                        StringBuilder sb2 = this.z;
                        sb2.delete(0, sb2.length());
                        if (b3 != null) {
                        }
                        y(b3);
                        return this.j;
                    }
                }
                z2 = true;
                this.c.k(z2);
                this.g = this.c.p();
            } catch (Throwable th) {
                j1.h(th, "Aps", "getLocation getScanResultsParam");
            }
            try {
                this.d.o(false, K());
            } catch (Throwable th2) {
                j1.h(th2, "Aps", "getLocation getCgiListParam");
            }
            u2 = u(eiVar);
            this.y = u2;
            if (!TextUtils.isEmpty(u2)) {
            }
        } else {
            if (this.u && i1.f(this.j.getTime())) {
                this.j.setLocationType(2);
            }
            return this.j;
        }
    }

    public final eo d(eo eoVar) {
        this.F.d(this.u);
        return this.F.b(eoVar);
    }

    public final eo f(boolean z2) {
        int i2;
        String sb;
        if (this.c.y()) {
            i2 = 15;
            sb = "networkLocation has been mocked!#1502";
        } else if (TextUtils.isEmpty(this.y)) {
            i2 = this.B;
            sb = this.q.toString();
        } else {
            eo a2 = this.e.a(this.a, this.y, this.z, true, z2);
            if (m1.r(a2)) {
                y(a2);
            }
            return a2;
        }
        return b(i2, sb);
    }

    public final eo g(boolean z2, ei eiVar) {
        eiVar.e(z2 ? "statics" : ShareperfenceConstants.FIRST);
        if (this.a == null) {
            eiVar.f("#0101");
            this.q.append("context is null#0101");
            l1.p(null, 2011);
            return b(1, this.q.toString());
        } else if (this.c.y()) {
            eiVar.f("#1502");
            return b(15, "networkLocation has been mocked!#1502");
        } else {
            q();
            if (TextUtils.isEmpty(this.y)) {
                return b(this.B, this.q.toString());
            }
            eo p2 = p(z2, eiVar);
            if (m1.r(p2) && !Q) {
                this.e.k(this.z.toString());
                this.e.j(this.d.z());
                y(p2);
            }
            Q = true;
            return p2;
        }
    }

    public final void i() {
        c1 c1Var = this.d;
        if (c1Var != null) {
            c1Var.r();
        }
    }

    public final void j(Context context) {
        try {
            if (this.a == null) {
                this.F = new g53();
                Context applicationContext = context.getApplicationContext();
                this.a = applicationContext;
                m1.D(applicationContext);
                if (this.c == null) {
                    this.c = new i53(this.a, (WifiManager) m1.h(this.a, "wifi"), this.H);
                }
                if (this.d == null) {
                    this.d = new c1(this.a, this.H);
                }
                this.I = new ev(context, this.H);
                if (this.e == null) {
                    this.e = new f1();
                }
                if (this.f == null) {
                    this.f = new s53();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            j1.h(th, "Aps", "initBase");
        }
    }

    public final void k(Handler handler) {
        this.H = handler;
    }

    public final void l(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() == 0) {
            h53 h53 = new h53();
            h53.a = aMapLocation.getLocationType();
            h53.d = aMapLocation.getTime();
            h53.e = (int) aMapLocation.getAccuracy();
            h53.b = aMapLocation.getLatitude();
            h53.c = aMapLocation.getLongitude();
            if (aMapLocation.getLocationType() == 1) {
                this.I.c(h53);
            }
        }
    }

    public final void m(AMapLocationClientOption aMapLocationClientOption) {
        this.i = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.i = new AMapLocationClientOption();
        }
        i53 i53 = this.c;
        if (i53 != null) {
            this.i.isWifiActiveScan();
            i53.f(this.i.isWifiScan(), this.i.isMockEnable(), AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        D();
        f1 f1Var = this.e;
        if (f1Var != null) {
            f1Var.i(this.i);
        }
        s53 s53 = this.f;
        if (s53 != null) {
            s53.d(this.i);
        }
        F();
    }

    public final void n(eo eoVar, int i2) {
        if (eoVar != null && eoVar.getErrorCode() == 0) {
            h53 h53 = new h53();
            h53.d = eoVar.getTime();
            h53.e = (int) eoVar.getAccuracy();
            h53.b = eoVar.getLatitude();
            h53.c = eoVar.getLongitude();
            h53.a = i2;
            h53.g = Integer.parseInt(eoVar.d());
            h53.h = eoVar.l();
            this.I.g(h53);
        }
    }

    public final void q() {
        this.p = h1.a(this.a);
        D();
        if (this.b == null) {
            this.b = (ConnectivityManager) m1.h(this.a, "connectivity");
        }
        if (this.m == null) {
            this.m = new t53();
        }
    }

    public final void s(ei eiVar) {
        try {
            if (!this.A) {
                L();
                if (this.v) {
                    G();
                }
                this.c.k(this.v);
                this.g = this.c.p();
                this.d.o(true, K());
                String u2 = u(eiVar);
                this.y = u2;
                if (!TextUtils.isEmpty(u2)) {
                    this.z = h(this.z);
                }
                this.A = true;
            }
        } catch (Throwable th) {
            j1.h(th, "Aps", "initFirstLocateParam");
        }
    }

    public final void t(eo eoVar) {
        if (m1.r(eoVar)) {
            this.e.m(this.y, this.z, eoVar, this.a, true);
        }
    }

    public final void v() {
        if (this.D == null) {
            this.D = new z0(this.a);
        }
        G();
        this.c.k(false);
        this.g = this.c.p();
        this.d.o(false, K());
        this.e.g(this.a);
        r(this.a);
    }

    public final void x() {
        if (this.q.length() > 0) {
            StringBuilder sb = this.q;
            sb.delete(0, sb.length());
        }
    }

    @SuppressLint({"NewApi"})
    public final void z() {
        a aVar;
        this.G = null;
        this.A = false;
        f1 f1Var = this.e;
        if (f1Var != null) {
            f1Var.t(this.a);
        }
        g53 g53 = this.F;
        if (g53 != null) {
            g53.c();
        }
        if (this.f != null) {
            this.f = null;
        }
        ev evVar = this.I;
        if (evVar != null) {
            evVar.d(this.J);
        }
        try {
            Context context = this.a;
            if (!(context == null || (aVar = this.h) == null)) {
                context.unregisterReceiver(aVar);
            }
        } catch (Throwable th) {
            this.h = null;
            throw th;
        }
        this.h = null;
        c1 c1Var = this.d;
        if (c1Var != null) {
            c1Var.n(this.J);
        }
        i53 i53 = this.c;
        if (i53 != null) {
            i53.m(this.J);
        }
        ArrayList<y0> arrayList = this.g;
        if (arrayList != null) {
            arrayList.clear();
        }
        z0 z0Var = this.D;
        if (z0Var != null) {
            z0Var.i();
        }
        this.j = null;
        this.a = null;
        this.z = null;
        this.L = null;
    }
}
