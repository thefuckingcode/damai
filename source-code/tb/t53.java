package tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.sdk.m.u.c;
import com.loc.b1;
import com.loc.c1;
import com.loc.ev;
import com.loc.j1;
import com.loc.l;
import com.loc.m1;
import com.loc.o;
import com.loc.y0;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

@SuppressLint({"NewApi"})
/* compiled from: Taobao */
public final class t53 {
    protected static String Q;
    protected static String R;
    protected ArrayList<b1> A = new ArrayList<>();
    protected ArrayList<b1> B = new ArrayList<>();
    protected String C = null;
    protected String D = null;
    protected ArrayList<y0> E = new ArrayList<>();
    protected String F = null;
    protected String G = null;
    protected byte[] H = null;
    private byte[] I = null;
    private int J = 0;
    protected String K = null;
    protected String L = null;
    protected String M = null;
    protected int N = 0;
    private List<h53> O = null;
    private List<b1> P = Collections.synchronizedList(new ArrayList());
    public String a = "1";
    protected short b = 0;
    protected String c = null;
    protected String d = null;
    protected String e = null;
    protected String f = null;
    protected String g = null;
    public String h = null;
    public String i = null;
    protected String j = null;
    protected String k = null;
    protected String l = null;
    protected String m = null;
    protected String n = null;
    protected String o = null;
    protected String p = null;
    protected String q = null;
    protected String r = null;
    protected String s = null;
    protected String t = null;
    protected String u = null;
    protected String v = null;
    protected String w = null;
    protected String x = null;
    protected String y = null;
    protected int z = 0;

    private static int a(String str, byte[] bArr, int i2) {
        try {
            if (TextUtils.isEmpty(str)) {
                bArr[i2] = 0;
                return i2 + 1;
            }
            byte[] bytes = str.getBytes("GBK");
            int length = bytes.length;
            if (length > 127) {
                length = 127;
            }
            bArr[i2] = (byte) length;
            int i3 = i2 + 1;
            System.arraycopy(bytes, 0, bArr, i3, length);
            return i3 + length;
        } catch (Throwable th) {
            j1.h(th, "Req", "copyContentWithByteLen");
            bArr[i2] = 0;
        }
    }

    private static void c(b1 b1Var, List<b1> list) {
        if (b1Var != null && list != null) {
            int size = list.size();
            if (size == 0) {
                list.add(b1Var);
                return;
            }
            long j2 = AbsPerformance.LONG_NIL;
            int i2 = 0;
            int i3 = -1;
            int i4 = -1;
            while (true) {
                if (i2 >= size) {
                    i3 = i4;
                    break;
                }
                b1 b1Var2 = list.get(i2);
                if (b1Var.c() == null || !b1Var.c().equals(b1Var2.c())) {
                    j2 = Math.min(j2, b1Var2.t);
                    if (j2 == b1Var2.t) {
                        i4 = i2;
                    }
                    i2++;
                } else {
                    int i5 = b1Var.s;
                    if (i5 != b1Var2.s) {
                        b1Var2.t = b1Var.t;
                        b1Var2.s = i5;
                    }
                }
            }
            if (i3 < 0) {
                return;
            }
            if (size < 3) {
                list.add(b1Var);
            } else if (b1Var.t > j2 && i3 < size) {
                list.remove(i3);
                list.add(b1Var);
            }
        }
    }

    private void d(ArrayList<b1> arrayList, ArrayList<b1> arrayList2) {
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<b1> it = arrayList2.iterator();
            while (it.hasNext()) {
                b1 next = it.next();
                if (next.r && next.n) {
                    c(next, this.P);
                    return;
                }
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            c(arrayList.get(0), this.P);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r0.length != 6) goto L_0x000f;
     */
    private byte[] f(String str) {
        String[] split = str.split(":");
        byte[] bArr = new byte[6];
        if (split != null) {
            try {
            } catch (Throwable th) {
                j1.h(th, "Req", "getMacBa ".concat(str));
                return f(c.b);
            }
        }
        split = new String[6];
        for (int i2 = 0; i2 < 6; i2++) {
            split[i2] = "0";
        }
        for (int i3 = 0; i3 < split.length; i3++) {
            if (split[i3].length() > 2) {
                split[i3] = split[i3].substring(0, 2);
            }
            bArr[i3] = (byte) Integer.parseInt(split[i3], 16);
        }
        return bArr;
    }

    private void g() {
        String[] strArr = {this.a, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.D, this.F, this.G, Q, this.L, this.M};
        for (int i2 = 0; i2 < 27; i2++) {
            if (TextUtils.isEmpty(strArr[i2])) {
                strArr[i2] = "";
            }
        }
        if (TextUtils.isEmpty(this.j) || (!"0".equals(this.j) && !"2".equals(this.j))) {
            this.j = "0";
        }
        if (TextUtils.isEmpty(this.k) || (!"0".equals(this.k) && !"1".equals(this.k))) {
            this.k = "0";
        }
        if (TextUtils.isEmpty(this.y) || (!"1".equals(this.y) && !"2".equals(this.y))) {
            this.y = "0";
        }
        if (!c1.p(this.z)) {
            this.z = 0;
        }
        if (this.H == null) {
            this.H = new byte[0];
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(31:0|(1:2)(1:3)|4|(1:6)(1:7)|8|(9:10|(2:12|13)|16|17|(1:21)|22|(2:24|25)|29|(1:33))(1:34)|(2:35|36)|39|(2:41|(1:43)(1:44))(1:45)|46|(1:51)(1:50)|52|(2:(2:55|(7:57|(1:59)|62|63|64|(1:68)|69))|(1:73))(2:74|(1:76))|77|(1:79)|80|81|82|(1:84)|85|86|(1:88)|89|90|(1:92)|93|94|(1:96)|(2:97|98)|101|102) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x01fa */
    /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x0208 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x0216 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x0224 */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0202 A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0210 A[Catch:{ all -> 0x0216 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x021e A[Catch:{ all -> 0x0224 }] */
    public final void b(Context context, boolean z2, boolean z3, c1 c1Var, i53 i53, ConnectivityManager connectivityManager, String str, ev evVar) {
        String str2;
        String str3;
        StringBuilder sb;
        String str4;
        NetworkInfo networkInfo;
        String str5;
        String str6;
        ArrayList<y0> arrayList;
        int i2;
        String j2 = l.j(context);
        int P2 = m1.P();
        this.K = str;
        this.O = null;
        if (!z3) {
            str3 = "UC_nlp_20131029";
            str2 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        } else {
            str3 = "api_serverSDK_130905";
            str2 = "S128DF1572465B890OE3F7A13167KLEI";
        }
        StringBuilder sb2 = new StringBuilder();
        int B2 = c1Var.B();
        int C2 = c1Var.C();
        TelephonyManager D2 = c1Var.D();
        ArrayList<b1> v2 = c1Var.v();
        ArrayList<b1> w2 = c1Var.w();
        ArrayList<y0> p2 = i53.p();
        String str7 = C2 == 2 ? "1" : "0";
        if (D2 != null) {
            if (TextUtils.isEmpty(j1.g)) {
                try {
                    j1.g = o.h0(context);
                } catch (Throwable th) {
                    str4 = "1";
                    j1.h(th, "Aps", "getApsReq part4");
                }
            }
            str4 = "1";
            sb = sb2;
            if (TextUtils.isEmpty(j1.g) && Build.VERSION.SDK_INT < 29) {
                j1.g = "888888888888888";
            }
            if (TextUtils.isEmpty(j1.h)) {
                try {
                    j1.h = o.k0(context);
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    j1.h(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(j1.h) && Build.VERSION.SDK_INT < 29) {
                j1.h = "888888888888888";
            }
        } else {
            sb = sb2;
            str4 = "1";
        }
        try {
            networkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
        } catch (Throwable th3) {
            j1.h(th3, "Aps", "getApsReq part");
            networkInfo = null;
        }
        boolean h2 = i53.h(connectivityManager);
        if (m1.f(networkInfo) != -1) {
            str6 = m1.k(context, D2);
            str5 = h2 ? "2" : str4;
        } else {
            str6 = "";
            str5 = str6;
        }
        if ((B2 & 4) != 4 || w2.isEmpty()) {
            this.B.clear();
        } else {
            this.B.clear();
            this.B.addAll(w2);
        }
        this.A.clear();
        this.A.addAll(v2);
        StringBuilder sb3 = new StringBuilder();
        if (i53.v()) {
            if (h2) {
                WifiInfo x2 = i53.x();
                if (i53.i(x2)) {
                    sb3.append(x2.getBSSID());
                    sb3.append(",");
                    int rssi = x2.getRssi();
                    if (rssi < -128 || rssi > 127) {
                        rssi = 0;
                    }
                    sb3.append(rssi);
                    sb3.append(",");
                    String ssid = x2.getSSID();
                    try {
                        i2 = x2.getSSID().getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                        i2 = 32;
                    }
                    if (i2 >= 32) {
                        ssid = "unkwn";
                    }
                    sb3.append(ssid.replace(jl1.MUL, "."));
                }
            }
            if (!(p2 == null || (arrayList = this.E) == null)) {
                arrayList.clear();
                this.E.addAll(p2);
            }
        } else {
            i53.r();
            ArrayList<y0> arrayList2 = this.E;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
        this.b = 0;
        if (!z2) {
            this.b = (short) (2 | 0);
        }
        this.c = str3;
        this.d = str2;
        this.f = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
        this.g = "android" + Build.VERSION.getRELEASE();
        this.h = m1.D(context);
        this.i = str7;
        this.j = "0";
        this.k = "0";
        this.l = "0";
        this.m = "0";
        this.n = "0";
        this.o = j2;
        this.p = j1.g;
        this.q = j1.h;
        this.s = String.valueOf(P2);
        this.t = m1.b0(context);
        this.v = "6.1.0";
        this.w = null;
        this.u = "";
        this.x = str6;
        this.y = str5;
        this.z = B2;
        this.C = c1Var.G();
        this.F = i53.A();
        this.D = sb3.toString();
        this.N = (int) ((m1.B() - i53.B()) / 1000);
        if (TextUtils.isEmpty(Q)) {
            Q = o.R(context);
        }
        if (TextUtils.isEmpty(R)) {
            R = o.w(context);
        }
        if (TextUtils.isEmpty(this.L)) {
            this.L = o.T(context);
        }
        if (TextUtils.isEmpty(this.M)) {
            this.M = o.Q(context);
        }
        try {
            this.O = evVar.a(this.B, this.E);
            d(this.A, this.B);
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        sb.delete(0, sb.length());
        sb3.delete(0, sb3.length());
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x035e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0541  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0601  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0607  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x06bb A[Catch:{ all -> 0x06d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x06be A[Catch:{ all -> 0x06d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x06c2 A[Catch:{ all -> 0x06d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x06e3 A[Catch:{ all -> 0x0704 }] */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x06f5 A[SYNTHETIC, Splitter:B:274:0x06f5] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x071c  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x071e  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x072d  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0747  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x083d  */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x08e7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0255  */
    public final byte[] e() {
        int i2;
        int i3;
        int i4;
        byte[] bArr;
        String str;
        int i5;
        byte b2;
        byte[] bArr2;
        int i6;
        int i7;
        byte b3;
        int i8;
        int min;
        byte b4;
        int i9;
        int i10;
        int i11;
        byte[] bArr3;
        int i12;
        int i13;
        int length;
        int i14;
        int i15;
        boolean isEmpty;
        byte[] bytes;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        byte[] bArr4;
        int length2;
        int length3;
        int i21;
        long j2;
        int length4;
        int length5;
        g();
        int i22 = 2;
        byte[] bArr5 = new byte[2];
        byte[] bArr6 = new byte[4];
        byte[] bArr7 = this.H;
        int i23 = 4096;
        int i24 = 1;
        if (bArr7 != null) {
            i23 = 4096 + bArr7.length + 1;
        }
        byte[] bArr8 = this.I;
        if (bArr8 == null || i23 > this.J) {
            bArr8 = new byte[i23];
            this.I = bArr8;
            this.J = i23;
        }
        int i25 = 0;
        bArr8[0] = m1.X(this.a);
        byte[] bArr9 = null;
        byte[] v2 = m1.v(this.b, null);
        System.arraycopy(v2, 0, bArr8, 1, v2.length);
        int a2 = a(this.q, bArr8, a(this.p, bArr8, a(this.h, bArr8, a(this.u, bArr8, a(this.g, bArr8, a(this.f, bArr8, a(this.e, bArr8, a(this.o, bArr8, a(this.d, bArr8, a(this.c, bArr8, v2.length + 1))))))))));
        try {
            if (TextUtils.isEmpty(this.t)) {
                bArr8[a2] = 0;
                i2 = a2 + 1;
                int a3 = a(this.x, bArr8, a(R, bArr8, a(Q, bArr8, a(this.w, bArr8, a(this.v, bArr8, i2)))));
                bArr8[a3] = Byte.parseByte(this.y);
                int i26 = a3 + 1;
                bArr8[i26] = Byte.parseByte(this.j);
                int i27 = i26 + 1;
                int i28 = this.z;
                i3 = i28 & 3;
                bArr8[i27] = (byte) i28;
                i4 = i27 + 1;
                long j3 = 0;
                if (i3 != 1 || i3 == 2) {
                    byte[] v3 = m1.v(this.A.size() <= 0 ? this.A.get(0).a : 0, null);
                    System.arraycopy(v3, 0, bArr8, i4, v3.length);
                    int length6 = i4 + v3.length;
                    if (i3 != 1) {
                        byte[] v4 = m1.v(this.A.size() > 0 ? this.A.get(0).b : 0, null);
                        System.arraycopy(v4, 0, bArr8, length6, v4.length);
                        int length7 = length6 + v4.length;
                        byte[] v5 = m1.v(this.A.size() > 0 ? this.A.get(0).c : 0, null);
                        System.arraycopy(v5, 0, bArr8, length7, v5.length);
                        length4 = length7 + v5.length;
                        byte[] H2 = m1.H(this.A.size() > 0 ? this.A.get(0).d : 0, null);
                        System.arraycopy(H2, 0, bArr8, length4, H2.length);
                        length5 = H2.length;
                    } else {
                        if (i3 == 2) {
                            byte[] v6 = m1.v(this.A.size() > 0 ? this.A.get(0).h : 0, null);
                            System.arraycopy(v6, 0, bArr8, length6, v6.length);
                            int length8 = length6 + v6.length;
                            byte[] v7 = m1.v(this.A.size() > 0 ? this.A.get(0).i : 0, null);
                            System.arraycopy(v7, 0, bArr8, length8, v7.length);
                            int length9 = length8 + v7.length;
                            byte[] v8 = m1.v(this.A.size() > 0 ? this.A.get(0).j : 0, null);
                            System.arraycopy(v8, 0, bArr8, length9, v8.length);
                            int length10 = length9 + v8.length;
                            byte[] H3 = m1.H(this.A.size() > 0 ? this.A.get(0).g : 0, null);
                            System.arraycopy(H3, 0, bArr8, length10, H3.length);
                            length4 = length10 + H3.length;
                            byte[] H4 = m1.H(this.A.size() > 0 ? this.A.get(0).f : 0, null);
                            System.arraycopy(H4, 0, bArr8, length4, H4.length);
                            length5 = H4.length;
                        }
                        i21 = this.A.size() > 0 ? this.A.get(0).k : 0;
                        if (i21 > 127 || i21 < -128) {
                            i21 = 0;
                        }
                        bArr8[length6] = (byte) i21;
                        int i29 = length6 + 1;
                        if (this.A.size() > 0) {
                            bArr = bArr6;
                            j2 = (m1.B() - this.A.get(0).t) / 1000;
                        } else {
                            bArr = bArr6;
                            j2 = 0;
                        }
                        if (j2 > 65535) {
                            j2 = 65535;
                        }
                        if (j2 < 0) {
                            j2 = 0;
                        }
                        byte[] v9 = m1.v((int) j2, bArr5);
                        System.arraycopy(v9, 0, bArr8, i29, v9.length);
                        i4 = i29 + 2;
                        if (i3 == 1) {
                            if (this.A.size() == 0) {
                                bArr8[i4] = 0;
                            } else {
                                int size = this.A.size();
                                bArr8[i4] = (byte) size;
                                i4++;
                                int i30 = 0;
                                while (i30 < size) {
                                    byte[] v10 = m1.v(this.A.size() > 0 ? this.A.get(i30).c : 0, bArr9);
                                    System.arraycopy(v10, i25, bArr8, i4, v10.length);
                                    int length11 = i4 + v10.length;
                                    byte[] H5 = m1.H(this.A.size() > 0 ? this.A.get(i30).d : 0, bArr9);
                                    System.arraycopy(H5, i25, bArr8, length11, H5.length);
                                    int length12 = length11 + H5.length;
                                    int i31 = this.A.size() > 0 ? this.A.get(i30).k : 0;
                                    if (i31 > 127 || i31 < -128) {
                                        i31 = 0;
                                    }
                                    bArr8[length12] = (byte) i31;
                                    i4 = length12 + i24;
                                    if (Double.valueOf(j1.a).doubleValue() >= 5.2d) {
                                        long B2 = this.A.size() > 0 ? (m1.B() - this.A.get(i25).t) / 1000 : 0;
                                        if (B2 > 65535) {
                                            B2 = 65535;
                                        }
                                        if (B2 < 0) {
                                            B2 = 0;
                                        }
                                        byte[] v11 = m1.v((int) B2, bArr5);
                                        System.arraycopy(v11, 0, bArr8, i4, v11.length);
                                        i4 += v11.length;
                                    }
                                    i30++;
                                    i24 = 1;
                                    i25 = 0;
                                    bArr9 = null;
                                }
                            }
                        } else if (i3 == 2) {
                            bArr8[i4] = 0;
                        }
                        i4++;
                    }
                    length6 = length4 + length5;
                    if (this.A.size() > 0) {
                    }
                    i21 = 0;
                    bArr8[length6] = (byte) i21;
                    int i292 = length6 + 1;
                    if (this.A.size() > 0) {
                    }
                    if (j2 > 65535) {
                    }
                    if (j2 < 0) {
                    }
                    byte[] v92 = m1.v((int) j2, bArr5);
                    System.arraycopy(v92, 0, bArr8, i292, v92.length);
                    i4 = i292 + 2;
                    if (i3 == 1) {
                    }
                    i4++;
                } else {
                    bArr = bArr6;
                }
                str = this.C;
                if (str != null && (this.z & 8) == 8) {
                    try {
                        byte[] bytes2 = str.getBytes("GBK");
                        int min2 = Math.min(bytes2.length, 60);
                        bArr8[i4] = (byte) min2;
                        i4++;
                        System.arraycopy(bytes2, 0, bArr8, i4, min2);
                        i5 = i4 + min2;
                    } catch (Exception unused) {
                    }
                    ArrayList<b1> arrayList = this.B;
                    int size2 = arrayList.size();
                    int i32 = 5;
                    int i33 = 3;
                    if ((this.z & 4) == 4 || size2 <= 0) {
                        bArr2 = bArr;
                        bArr8[i5] = 0;
                        b2 = 1;
                        i6 = i5 + 1;
                    } else {
                        arrayList.get(0);
                        bArr8[i5] = (byte) size2;
                        int i34 = 1;
                        i6 = i5 + 1;
                        int i35 = 0;
                        while (i35 < size2) {
                            b1 b1Var = arrayList.get(i35);
                            int i36 = b1Var.l;
                            if (i36 == i34 || i36 == i33 || i36 == 4) {
                                i20 = size2;
                                bArr4 = bArr;
                                byte b5 = (byte) i36;
                                if (b1Var.n) {
                                    b5 = (byte) (b5 | 8);
                                }
                                bArr8[i6] = b5;
                                int i37 = i6 + 1;
                                byte[] v12 = m1.v(b1Var.a, bArr5);
                                System.arraycopy(v12, 0, bArr8, i37, v12.length);
                                int length13 = i37 + v12.length;
                                byte[] v13 = m1.v(b1Var.b, bArr5);
                                System.arraycopy(v13, 0, bArr8, length13, v13.length);
                                int length14 = length13 + v13.length;
                                byte[] v14 = m1.v(b1Var.c, bArr5);
                                System.arraycopy(v14, 0, bArr8, length14, v14.length);
                                int length15 = length14 + v14.length;
                                byte[] H6 = m1.H(b1Var.d, bArr4);
                                System.arraycopy(H6, 0, bArr8, length15, H6.length);
                                i6 = length15 + H6.length;
                            } else if (i36 == i22) {
                                byte b6 = (byte) i36;
                                if (b1Var.n) {
                                    b6 = (byte) (b6 | 8);
                                }
                                bArr8[i6] = b6;
                                int i38 = i6 + 1;
                                byte[] v15 = m1.v(b1Var.a, bArr5);
                                System.arraycopy(v15, 0, bArr8, i38, v15.length);
                                int length16 = i38 + v15.length;
                                byte[] v16 = m1.v(b1Var.h, bArr5);
                                System.arraycopy(v16, 0, bArr8, length16, v16.length);
                                int length17 = length16 + v16.length;
                                byte[] v17 = m1.v(b1Var.i, bArr5);
                                System.arraycopy(v17, 0, bArr8, length17, v17.length);
                                int length18 = length17 + v17.length;
                                byte[] v18 = m1.v(b1Var.j, bArr5);
                                System.arraycopy(v18, 0, bArr8, length18, v18.length);
                                int length19 = length18 + v18.length;
                                byte[] H7 = m1.H(b1Var.g, bArr);
                                System.arraycopy(H7, 0, bArr8, length19, H7.length);
                                int length20 = length19 + H7.length;
                                byte[] H8 = m1.H(b1Var.f, bArr);
                                System.arraycopy(H8, 0, bArr8, length20, H8.length);
                                i6 = length20 + H8.length;
                                i20 = size2;
                                bArr4 = bArr;
                            } else {
                                bArr4 = bArr;
                                if (i36 == i32) {
                                    byte b7 = (byte) i36;
                                    if (b1Var.n) {
                                        b7 = (byte) (b7 | 8);
                                    }
                                    bArr8[i6] = b7;
                                    int i39 = i6 + 1;
                                    byte[] v19 = m1.v(b1Var.a, bArr5);
                                    System.arraycopy(v19, 0, bArr8, i39, v19.length);
                                    int length21 = i39 + v19.length;
                                    byte[] v20 = m1.v(b1Var.b, bArr5);
                                    System.arraycopy(v20, 0, bArr8, length21, v20.length);
                                    int length22 = length21 + v20.length;
                                    byte[] v21 = m1.v(b1Var.c, bArr5);
                                    System.arraycopy(v21, 0, bArr8, length22, v21.length);
                                    int length23 = length22 + v21.length;
                                    i20 = size2;
                                    System.arraycopy(m1.w(b1Var.e), 0, bArr8, length23, 8);
                                    i6 = length23 + 8;
                                } else {
                                    i20 = size2;
                                }
                            }
                            int i40 = b1Var.k;
                            if (i40 > 127 || i40 < -128) {
                                i40 = 99;
                            }
                            bArr8[i6] = (byte) i40;
                            int i41 = i6 + 1;
                            byte[] v22 = m1.v((short) ((int) ((m1.B() - b1Var.t) / 1000)), bArr5);
                            System.arraycopy(v22, 0, bArr8, i41, v22.length);
                            i6 = i41 + v22.length;
                            int i42 = b1Var.l;
                            int i43 = 32767;
                            if (i42 == 3 || i42 == 4 || i42 == 5) {
                                if (Double.valueOf(j1.a).doubleValue() >= 5.0d) {
                                    int i44 = b1Var.o;
                                    if (i44 > 32767) {
                                        i44 = 32767;
                                    }
                                    if (i44 >= 0) {
                                        i43 = i44;
                                    }
                                    byte[] v23 = m1.v(i43, bArr5);
                                    System.arraycopy(v23, 0, bArr8, i6, v23.length);
                                    i6 += v23.length;
                                    if (Double.valueOf(j1.a).doubleValue() >= 5.3d) {
                                        byte[] H9 = m1.H(b1Var.p, bArr4);
                                        System.arraycopy(H9, 0, bArr8, i6, H9.length);
                                        length2 = i6 + H9.length;
                                        byte[] H10 = m1.H(b1Var.q, bArr4);
                                        System.arraycopy(H10, 0, bArr8, length2, H10.length);
                                        length3 = H10.length;
                                    }
                                }
                                i35++;
                                bArr = bArr4;
                                size2 = i20;
                                i22 = 2;
                                i34 = 1;
                                i33 = 3;
                                i32 = 5;
                            } else {
                                if (i42 == 1 && Double.valueOf(j1.a).doubleValue() >= 5.3d) {
                                    int i45 = b1Var.o;
                                    if (i45 > 32767) {
                                        i45 = 32767;
                                    }
                                    if (i45 >= 0) {
                                        i43 = i45;
                                    }
                                    byte[] v24 = m1.v(i43, bArr5);
                                    System.arraycopy(v24, 0, bArr8, i6, v24.length);
                                    int length24 = i6 + v24.length;
                                    byte[] H11 = m1.H(b1Var.p, bArr4);
                                    System.arraycopy(H11, 0, bArr8, length24, H11.length);
                                    length2 = length24 + H11.length;
                                    byte[] H12 = m1.H(b1Var.q, bArr4);
                                    System.arraycopy(H12, 0, bArr8, length2, H12.length);
                                    length3 = H12.length;
                                }
                                i35++;
                                bArr = bArr4;
                                size2 = i20;
                                i22 = 2;
                                i34 = 1;
                                i33 = 3;
                                i32 = 5;
                            }
                            i6 = length2 + length3;
                            i35++;
                            bArr = bArr4;
                            size2 = i20;
                            i22 = 2;
                            i34 = 1;
                            i33 = 3;
                            i32 = 5;
                        }
                        bArr2 = bArr;
                        b2 = 1;
                    }
                    if (!TextUtils.isEmpty(this.D) || this.D.length() == 0) {
                        i8 = 1;
                        b3 = 0;
                        bArr8[i6] = 0;
                        i7 = i6 + 1;
                    } else {
                        bArr8[i6] = b2;
                        int i46 = i6 + 1;
                        try {
                            String[] split = this.D.split(",");
                            byte[] f2 = f(split[0]);
                            System.arraycopy(f2, 0, bArr8, i46, f2.length);
                            int length25 = i46 + f2.length;
                            try {
                                byte[] bytes3 = split[2].getBytes("GBK");
                                int length26 = bytes3.length;
                                if (length26 > 127) {
                                    length26 = 127;
                                }
                                bArr8[length25] = (byte) length26;
                                int i47 = length25 + 1;
                                System.arraycopy(bytes3, 0, bArr8, i47, length26);
                                i19 = i47 + length26;
                            } catch (Throwable th) {
                                j1.h(th, "Req", "buildV4Dot214");
                                bArr8[length25] = 0;
                                i19 = length25 + 1;
                            }
                            int parseInt = Integer.parseInt(split[1]);
                            if (parseInt > 127 || parseInt < -128) {
                                parseInt = 0;
                            }
                            bArr8[i19] = Byte.parseByte(String.valueOf(parseInt));
                            i7 = i19 + 1;
                            if (Double.valueOf(j1.a).doubleValue() >= 5.2d) {
                                byte[] v25 = m1.v(this.N, bArr5);
                                System.arraycopy(v25, 0, bArr8, i7, v25.length);
                                i7 += v25.length;
                            }
                            i8 = 1;
                            b3 = 0;
                        } catch (Throwable th2) {
                            j1.h(th2, "Req", "buildV4Dot216");
                            byte[] f3 = f(c.b);
                            b3 = 0;
                            System.arraycopy(f3, 0, bArr8, i46, f3.length);
                            int length27 = i46 + f3.length;
                            bArr8[length27] = 0;
                            i8 = 1;
                            int i48 = length27 + 1;
                            bArr8[i48] = Byte.parseByte("0");
                            i7 = i48 + 1;
                        }
                    }
                    ArrayList<y0> arrayList2 = this.E;
                    min = Math.min(arrayList2.size(), 25);
                    if (min == 0) {
                        bArr8[i7] = b3;
                        i9 = i7 + i8;
                        b4 = 0;
                    } else {
                        bArr8[i7] = (byte) min;
                        int i49 = i7 + i8;
                        boolean z2 = m1.K() >= 17;
                        if (z2) {
                            j3 = m1.B() / 1000;
                        }
                        for (int i50 = 0; i50 < min; i50++) {
                            y0 y0Var = arrayList2.get(i50);
                            byte[] f4 = f(y0.c(y0Var.a));
                            System.arraycopy(f4, 0, bArr8, i49, f4.length);
                            int length28 = i49 + f4.length;
                            try {
                                byte[] bytes4 = y0Var.b.getBytes("GBK");
                                bArr8[length28] = (byte) bytes4.length;
                                length28++;
                                System.arraycopy(bytes4, 0, bArr8, length28, bytes4.length);
                                i17 = length28 + bytes4.length;
                                i16 = 1;
                            } catch (Exception unused2) {
                                bArr8[length28] = 0;
                                i16 = 1;
                                i17 = length28 + 1;
                            }
                            int i51 = y0Var.c;
                            if (i51 > 127) {
                                i51 = 0;
                            } else if (i51 < -128) {
                                i51 = 0;
                            }
                            bArr8[i17] = Byte.parseByte(String.valueOf(i51));
                            int i52 = i17 + i16;
                            if (!z2 || (i18 = (int) (j3 - (y0Var.f / 1000))) < 0) {
                                i18 = 0;
                            }
                            if (i18 > 65535) {
                                i18 = 65535;
                            }
                            byte[] v26 = m1.v(i18, bArr5);
                            System.arraycopy(v26, 0, bArr8, i52, v26.length);
                            int length29 = i52 + v26.length;
                            byte[] v27 = m1.v(y0Var.d, bArr5);
                            System.arraycopy(v27, 0, bArr8, length29, v27.length);
                            i49 = length29 + v27.length;
                        }
                        b4 = 0;
                        byte[] v28 = m1.v(Integer.parseInt(this.F), bArr5);
                        System.arraycopy(v28, 0, bArr8, i49, v28.length);
                        i9 = i49 + v28.length;
                    }
                    bArr8[i9] = b4;
                    i10 = i9 + 1;
                    bytes = this.G.getBytes("GBK");
                    if (bytes.length > 127) {
                        bytes = null;
                    }
                    if (bytes == null) {
                        bArr8[i10] = 0;
                        i11 = i10 + 1;
                        bArr3 = new byte[]{0, 0};
                        try {
                            isEmpty = TextUtils.isEmpty(this.K);
                            if (!isEmpty) {
                                bArr3 = m1.v(this.K.length(), bArr5);
                            }
                            System.arraycopy(bArr3, 0, bArr8, i11, 2);
                            i12 = i11 + 2;
                            if (!isEmpty) {
                                try {
                                    byte[] bytes5 = this.K.getBytes("GBK");
                                    System.arraycopy(bytes5, 0, bArr8, i12, bytes5.length);
                                    i12 += bytes5.length;
                                } catch (Throwable unused3) {
                                }
                            }
                            i13 = 2;
                        } catch (Throwable unused4) {
                            i13 = 2;
                            i12 = i11 + 2;
                        }
                        try {
                            System.arraycopy(m1.v(0, bArr5), 0, bArr8, i12, i13);
                        } catch (Throwable unused5) {
                        }
                        int i53 = i12 + i13;
                        byte[] bArr10 = new byte[i13];
                        // fill-array-data instruction
                        bArr10[0] = 0;
                        bArr10[1] = 0;
                        try {
                            System.arraycopy(bArr10, 0, bArr8, i53, i13);
                        } catch (Throwable unused6) {
                        }
                        int i54 = i53 + i13;
                        byte[] bArr11 = this.H;
                        length = bArr11 == null ? bArr11.length : 0;
                        byte[] v29 = m1.v(length, null);
                        System.arraycopy(v29, 0, bArr8, i54, v29.length);
                        int length30 = i54 + v29.length;
                        if (length > 0) {
                            byte[] bArr12 = this.H;
                            System.arraycopy(bArr12, 0, bArr8, length30, bArr12.length);
                            length30 += this.H.length;
                        }
                        if (Double.valueOf(j1.a).doubleValue() >= 5.0d) {
                            List<b1> list = this.P;
                            int size3 = list != null ? list.size() : 0;
                            bArr8[length30] = (byte) size3;
                            int i55 = length30 + 1;
                            byte[] bArr13 = new byte[i55];
                            System.arraycopy(bArr8, 0, bArr13, 0, i55);
                            if (size3 > 0) {
                                try {
                                    int i56 = i55;
                                    for (b1 b1Var2 : this.P) {
                                        int i57 = b1Var2.l;
                                        if (!(i57 == 1 || i57 == 3)) {
                                            if (i57 != 4) {
                                                if (i57 == 2) {
                                                    byte b8 = (byte) i57;
                                                    if (b1Var2.n) {
                                                        b8 = (byte) (b8 | 8);
                                                    }
                                                    bArr8[i56] = b8;
                                                    int i58 = i56 + 1;
                                                    byte[] v30 = m1.v(b1Var2.h, bArr5);
                                                    System.arraycopy(v30, 0, bArr8, i58, v30.length);
                                                    int length31 = i58 + v30.length;
                                                    byte[] v31 = m1.v(b1Var2.i, bArr5);
                                                    System.arraycopy(v31, 0, bArr8, length31, v31.length);
                                                    i15 = length31 + v31.length;
                                                    byte[] v32 = m1.v(b1Var2.j, bArr5);
                                                    System.arraycopy(v32, 0, bArr8, i15, v32.length);
                                                    i14 = v32.length;
                                                    i56 = i15 + i14;
                                                    byte[] v33 = m1.v((short) ((int) ((m1.B() - b1Var2.t) / 1000)), bArr5);
                                                    System.arraycopy(v33, 0, bArr8, i56, v33.length);
                                                    i56 += v33.length;
                                                } else {
                                                    if (i57 == 5) {
                                                        byte b9 = (byte) i57;
                                                        if (b1Var2.n) {
                                                            b9 = (byte) (b9 | 8);
                                                        }
                                                        bArr8[i56] = b9;
                                                        int i59 = i56 + 1;
                                                        byte[] v34 = m1.v(b1Var2.c, bArr5);
                                                        System.arraycopy(v34, 0, bArr8, i59, v34.length);
                                                        int length32 = i59 + v34.length;
                                                        System.arraycopy(m1.w(b1Var2.e), 0, bArr8, length32, 8);
                                                        i56 = length32 + 8;
                                                    }
                                                    byte[] v332 = m1.v((short) ((int) ((m1.B() - b1Var2.t) / 1000)), bArr5);
                                                    System.arraycopy(v332, 0, bArr8, i56, v332.length);
                                                    i56 += v332.length;
                                                }
                                            }
                                        }
                                        byte b10 = (byte) i57;
                                        if (b1Var2.n) {
                                            b10 = (byte) (b10 | 8);
                                        }
                                        bArr8[i56] = b10;
                                        int i60 = i56 + 1;
                                        byte[] v35 = m1.v(b1Var2.c, bArr5);
                                        System.arraycopy(v35, 0, bArr8, i60, v35.length);
                                        i15 = i60 + v35.length;
                                        byte[] H13 = m1.H(b1Var2.d, bArr2);
                                        System.arraycopy(H13, 0, bArr8, i15, H13.length);
                                        i14 = H13.length;
                                        i56 = i15 + i14;
                                        byte[] v3322 = m1.v((short) ((int) ((m1.B() - b1Var2.t) / 1000)), bArr5);
                                        System.arraycopy(v3322, 0, bArr8, i56, v3322.length);
                                        i56 += v3322.length;
                                    }
                                    i55 = i56;
                                } catch (Throwable unused7) {
                                    System.arraycopy(bArr13, 0, bArr8, 0, i55);
                                    bArr8[i55 - 1] = 0;
                                }
                            }
                            length30 = a(this.L, bArr8, i55);
                        }
                        if (Double.valueOf(j1.a).doubleValue() >= 5.2d) {
                            List<h53> list2 = this.O;
                            int size4 = list2 == null ? 0 : list2.size();
                            bArr8[length30] = (byte) size4;
                            length30++;
                            if (size4 > 0) {
                                for (h53 h53 : this.O) {
                                    int currentTimeMillis = ((int) (System.currentTimeMillis() - h53.d)) / 1000;
                                    if (currentTimeMillis > 65535) {
                                        currentTimeMillis = 65535;
                                    }
                                    System.arraycopy(m1.v(currentTimeMillis, bArr5), 0, bArr8, length30, 2);
                                    int i61 = length30 + 2;
                                    System.arraycopy(m1.H((int) Math.round(h53.c * 1.0E7d), bArr2), 0, bArr8, i61, 4);
                                    int i62 = i61 + 4;
                                    System.arraycopy(m1.H((int) Math.round(h53.b * 1.0E7d), bArr2), 0, bArr8, i62, 4);
                                    int i63 = i62 + 4;
                                    float f5 = (float) h53.e;
                                    if (f5 > 65535.0f) {
                                        f5 = 65535.0f;
                                    }
                                    System.arraycopy(m1.v((int) f5, bArr5), 0, bArr8, i63, 2);
                                    int i64 = i63 + 2;
                                    System.arraycopy(m1.v((short) ((h53.h | (h53.a << 13) | (h53.g << 6)) & 65535), bArr5), 0, bArr8, i64, 2);
                                    length30 = i64 + 2;
                                }
                            }
                        }
                        if (Double.valueOf(j1.a).doubleValue() >= 5.3d) {
                            length30 = a(this.M, bArr8, length30);
                        }
                        byte[] bArr14 = new byte[length30];
                        System.arraycopy(bArr8, 0, bArr14, 0, length30);
                        CRC32 crc32 = new CRC32();
                        crc32.update(bArr14);
                        byte[] w2 = m1.w(crc32.getValue());
                        byte[] bArr15 = new byte[(length30 + 8)];
                        System.arraycopy(bArr14, 0, bArr15, 0, length30);
                        System.arraycopy(w2, 0, bArr15, length30, 8);
                        return bArr15;
                    }
                    bArr8[i10] = (byte) bytes.length;
                    int i65 = i10 + 1;
                    System.arraycopy(bytes, 0, bArr8, i65, bytes.length);
                    i11 = i65 + bytes.length;
                    bArr3 = new byte[]{0, 0};
                    isEmpty = TextUtils.isEmpty(this.K);
                    if (!isEmpty) {
                    }
                    System.arraycopy(bArr3, 0, bArr8, i11, 2);
                    i12 = i11 + 2;
                    if (!isEmpty) {
                    }
                    i13 = 2;
                    System.arraycopy(m1.v(0, bArr5), 0, bArr8, i12, i13);
                    int i532 = i12 + i13;
                    byte[] bArr102 = new byte[i13];
                    // fill-array-data instruction
                    bArr102[0] = 0;
                    bArr102[1] = 0;
                    System.arraycopy(bArr102, 0, bArr8, i532, i13);
                    int i542 = i532 + i13;
                    byte[] bArr112 = this.H;
                    if (bArr112 == null) {
                    }
                    byte[] v292 = m1.v(length, null);
                    System.arraycopy(v292, 0, bArr8, i542, v292.length);
                    int length302 = i542 + v292.length;
                    if (length > 0) {
                    }
                    if (Double.valueOf(j1.a).doubleValue() >= 5.0d) {
                    }
                    if (Double.valueOf(j1.a).doubleValue() >= 5.2d) {
                    }
                    if (Double.valueOf(j1.a).doubleValue() >= 5.3d) {
                    }
                    byte[] bArr142 = new byte[length302];
                    System.arraycopy(bArr8, 0, bArr142, 0, length302);
                    CRC32 crc322 = new CRC32();
                    crc322.update(bArr142);
                    byte[] w22 = m1.w(crc322.getValue());
                    byte[] bArr152 = new byte[(length302 + 8)];
                    System.arraycopy(bArr142, 0, bArr152, 0, length302);
                    System.arraycopy(w22, 0, bArr152, length302, 8);
                    return bArr152;
                }
                bArr8[i4] = 0;
                i5 = i4 + 1;
                ArrayList<b1> arrayList3 = this.B;
                int size22 = arrayList3.size();
                int i322 = 5;
                int i332 = 3;
                if ((this.z & 4) == 4) {
                }
                bArr2 = bArr;
                bArr8[i5] = 0;
                b2 = 1;
                i6 = i5 + 1;
                if (!TextUtils.isEmpty(this.D)) {
                }
                i8 = 1;
                b3 = 0;
                bArr8[i6] = 0;
                i7 = i6 + 1;
                ArrayList<y0> arrayList22 = this.E;
                min = Math.min(arrayList22.size(), 25);
                if (min == 0) {
                }
                bArr8[i9] = b4;
                i10 = i9 + 1;
                try {
                    bytes = this.G.getBytes("GBK");
                    if (bytes.length > 127) {
                    }
                    if (bytes == null) {
                    }
                } catch (Throwable unused8) {
                    bArr8[i10] = 0;
                }
            } else {
                byte[] f6 = f(this.t);
                bArr8[a2] = (byte) f6.length;
                int i66 = a2 + 1;
                System.arraycopy(f6, 0, bArr8, i66, f6.length);
                i2 = i66 + f6.length;
                int a32 = a(this.x, bArr8, a(R, bArr8, a(Q, bArr8, a(this.w, bArr8, a(this.v, bArr8, i2)))));
                bArr8[a32] = Byte.parseByte(this.y);
                int i262 = a32 + 1;
                bArr8[i262] = Byte.parseByte(this.j);
                int i272 = i262 + 1;
                int i282 = this.z;
                i3 = i282 & 3;
                bArr8[i272] = (byte) i282;
                i4 = i272 + 1;
                long j32 = 0;
                if (i3 != 1) {
                }
                byte[] v36 = m1.v(this.A.size() <= 0 ? this.A.get(0).a : 0, null);
                System.arraycopy(v36, 0, bArr8, i4, v36.length);
                int length62 = i4 + v36.length;
                if (i3 != 1) {
                }
                length62 = length4 + length5;
                if (this.A.size() > 0) {
                }
                i21 = 0;
                bArr8[length62] = (byte) i21;
                int i2922 = length62 + 1;
                if (this.A.size() > 0) {
                }
                if (j2 > 65535) {
                }
                if (j2 < 0) {
                }
                byte[] v922 = m1.v((int) j2, bArr5);
                System.arraycopy(v922, 0, bArr8, i2922, v922.length);
                i4 = i2922 + 2;
                if (i3 == 1) {
                }
                i4++;
                str = this.C;
                byte[] bytes22 = str.getBytes("GBK");
                int min22 = Math.min(bytes22.length, 60);
                bArr8[i4] = (byte) min22;
                i4++;
                System.arraycopy(bytes22, 0, bArr8, i4, min22);
                i5 = i4 + min22;
                ArrayList<b1> arrayList32 = this.B;
                int size222 = arrayList32.size();
                int i3222 = 5;
                int i3322 = 3;
                if ((this.z & 4) == 4) {
                }
                bArr2 = bArr;
                bArr8[i5] = 0;
                b2 = 1;
                i6 = i5 + 1;
                if (!TextUtils.isEmpty(this.D)) {
                }
                i8 = 1;
                b3 = 0;
                bArr8[i6] = 0;
                i7 = i6 + 1;
                ArrayList<y0> arrayList222 = this.E;
                min = Math.min(arrayList222.size(), 25);
                if (min == 0) {
                }
                bArr8[i9] = b4;
                i10 = i9 + 1;
                bytes = this.G.getBytes("GBK");
                if (bytes.length > 127) {
                }
                if (bytes == null) {
                }
            }
        } catch (Throwable th3) {
            j1.h(th3, "Req", "buildV4Dot219");
            bArr8[a2] = 0;
        }
    }
}
