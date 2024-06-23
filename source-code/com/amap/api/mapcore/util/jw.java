package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.sdk.m.u.c;
import java.util.ArrayList;
import java.util.zip.CRC32;
import tb.a90;
import tb.jl1;

@SuppressLint({"NewApi"})
/* compiled from: Taobao */
public final class jw {
    protected static String J;
    protected static String L;
    protected String A = null;
    protected String B = null;
    protected ArrayList<la> C = new ArrayList<>();
    protected String D = null;
    protected String E = null;
    protected ArrayList<ScanResult> F = new ArrayList<>();
    protected String G = null;
    protected String H = null;
    protected byte[] I = null;
    protected String K = null;
    protected String M = null;
    protected String N = null;
    private byte[] O = null;
    private int P = 0;
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
            jy.a(th, "Req", "copyContentWithByteLen");
            bArr[i2] = 0;
        }
    }

    private String a(String str, int i2) {
        String[] split = this.B.split("\\*")[i2].split(",");
        if ("lac".equals(str)) {
            return split[0];
        }
        if ("cellid".equals(str)) {
            return split[1];
        }
        if ("signal".equals(str)) {
            return split[2];
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r0.length != 6) goto L_0x000f;
     */
    private byte[] a(String str) {
        String[] split = str.split(":");
        byte[] bArr = new byte[6];
        if (split != null) {
            try {
            } catch (Throwable th) {
                jy.a(th, "Req", "getMacBa " + str);
                return a(c.b);
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

    private String b(String str) {
        String str2 = this.A;
        if (!str2.contains(str + jl1.G)) {
            return "0";
        }
        String str3 = this.A;
        int indexOf = str3.indexOf(str + jl1.G);
        String str4 = this.A;
        return this.A.substring(indexOf + str.length() + 1, str4.indexOf("</" + str));
    }

    private void b() {
        String[] strArr = {this.a, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.A, this.B, this.E, this.G, this.H, J, this.N};
        for (int i2 = 0; i2 < 28; i2++) {
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
        if (!lb.a(this.z)) {
            this.z = 0;
        }
        if (this.I == null) {
            this.I = new byte[0];
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(1:2)(1:3)|4|(1:6)(1:7)|8|(9:10|(2:12|13)|16|17|(1:21)|22|(2:24|25)|29|(1:33))(1:34)|(2:35|36)|39|(2:41|(1:43)(1:44))(1:45)|46|(3:48|(2:50|(1:52)(3:53|(1:57)|58))(3:59|(4:62|(2:64|119)(1:120)|65|60)|118)|66)(1:67)|68|(1:73)(1:72)|74|(2:(2:77|(7:79|(1:81)|84|85|86|(1:90)|91))|(1:95))(2:96|(1:98))|99|(1:101)|102|103|104|(1:106)|107|108|(1:110)|111|112|(1:114)|115|117) */
    /* JADX WARNING: Can't wrap try/catch for region: R(30:0|(1:2)(1:3)|4|(1:6)(1:7)|8|(9:10|(2:12|13)|16|17|(1:21)|22|(2:24|25)|29|(1:33))(1:34)|35|36|39|(2:41|(1:43)(1:44))(1:45)|46|(3:48|(2:50|(1:52)(3:53|(1:57)|58))(3:59|(4:62|(2:64|119)(1:120)|65|60)|118)|66)(1:67)|68|(1:73)(1:72)|74|(2:(2:77|(7:79|(1:81)|84|85|86|(1:90)|91))|(1:95))(2:96|(1:98))|99|(1:101)|102|103|104|(1:106)|107|108|(1:110)|111|112|(1:114)|115|117) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x033a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:111:0x0348 */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0342 A[Catch:{ all -> 0x0348 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0350 A[Catch:{ all -> 0x0356 }] */
    public final void a(Context context, boolean z2, boolean z3, lb lbVar, js jsVar, ConnectivityManager connectivityManager, String str) {
        String str2;
        String str3;
        String str4;
        int i2;
        NetworkInfo networkInfo;
        String str5;
        String str6;
        ArrayList<ScanResult> arrayList;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        ArrayList<ScanResult> arrayList2;
        int i3;
        String f2 = gc.f(context);
        int d2 = kc.d();
        this.K = str;
        if (!z3) {
            str3 = "UC_nlp_20131029";
            str2 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        } else {
            str3 = "api_serverSDK_130905";
            str2 = "S128DF1572465B890OE3F7A13167KLEI";
        }
        StringBuilder sb = new StringBuilder();
        int e2 = lbVar.e();
        int f3 = lbVar.f();
        TelephonyManager g2 = lbVar.g();
        ArrayList<la> c2 = lbVar.c();
        ArrayList<la> d3 = lbVar.d();
        ArrayList<ScanResult> a2 = jsVar.a();
        String str12 = f3 == 2 ? "1" : "0";
        if (g2 != null) {
            if (TextUtils.isEmpty(jy.e)) {
                try {
                    jy.e = gg.w(context);
                } catch (Throwable th) {
                    str4 = "1";
                    jy.a(th, "Aps", "getApsReq part4");
                }
            }
            str4 = "1";
            i2 = d2;
            if (TextUtils.isEmpty(jy.e) && Build.VERSION.SDK_INT < 29) {
                jy.e = "888888888888888";
            }
            if (TextUtils.isEmpty(jy.f)) {
                try {
                    jy.f = gg.y(context);
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    jy.a(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(jy.f) && Build.VERSION.SDK_INT < 29) {
                jy.f = "888888888888888";
            }
        } else {
            i2 = d2;
            str4 = "1";
        }
        try {
            networkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
        } catch (Throwable th3) {
            jy.a(th3, "Aps", "getApsReq part");
            networkInfo = null;
        }
        boolean a3 = jsVar.a(connectivityManager);
        if (kc.a(networkInfo) != -1) {
            str6 = kc.b(g2);
            str5 = a3 ? "2" : str4;
        } else {
            str6 = "";
            str5 = str6;
        }
        if (!c2.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            str10 = f2;
            str9 = "0";
            str8 = str2;
            str7 = str3;
            if (f3 == 1) {
                la laVar = c2.get(0);
                arrayList = a2;
                sb2.delete(0, sb2.length());
                sb2.append("<mcc>");
                sb2.append(laVar.a);
                sb2.append("</mcc>");
                sb2.append("<mnc>");
                sb2.append(laVar.b);
                sb2.append("</mnc>");
                sb2.append("<lac>");
                sb2.append(laVar.c);
                sb2.append("</lac>");
                sb2.append("<cellid>");
                sb2.append(laVar.d);
                sb2.append("</cellid>");
                sb2.append("<signal>");
                sb2.append(laVar.j);
                sb2.append("</signal>");
                str11 = sb2.toString();
                for (int i4 = 1; i4 < c2.size(); i4++) {
                    la laVar2 = c2.get(i4);
                    sb.append(laVar2.c);
                    sb.append(",");
                    sb.append(laVar2.d);
                    sb.append(",");
                    sb.append(laVar2.j);
                    if (i4 < c2.size() - 1) {
                        sb.append(jl1.MUL);
                    }
                }
            } else if (f3 != 2) {
                arrayList = a2;
                str11 = "";
            } else {
                la laVar3 = c2.get(0);
                sb2.delete(0, sb2.length());
                sb2.append("<mcc>");
                sb2.append(laVar3.a);
                sb2.append("</mcc>");
                sb2.append("<sid>");
                sb2.append(laVar3.g);
                sb2.append("</sid>");
                sb2.append("<nid>");
                sb2.append(laVar3.h);
                sb2.append("</nid>");
                sb2.append("<bid>");
                sb2.append(laVar3.i);
                sb2.append("</bid>");
                if (laVar3.f > 0 && laVar3.e > 0) {
                    sb2.append("<lon>");
                    sb2.append(laVar3.f);
                    sb2.append("</lon>");
                    sb2.append("<lat>");
                    sb2.append(laVar3.e);
                    sb2.append("</lat>");
                }
                sb2.append("<signal>");
                sb2.append(laVar3.j);
                sb2.append("</signal>");
                str11 = sb2.toString();
                arrayList = a2;
            }
            sb2.delete(0, sb2.length());
        } else {
            str10 = f2;
            str7 = str3;
            str8 = str2;
            arrayList = a2;
            str9 = "0";
            str11 = "";
        }
        if ((e2 & 4) != 4 || d3.isEmpty()) {
            this.C.clear();
        } else {
            this.C.clear();
            this.C.addAll(d3);
        }
        StringBuilder sb3 = new StringBuilder();
        if (jsVar.e()) {
            if (a3) {
                WifiInfo f4 = jsVar.f();
                if (js.a(f4)) {
                    sb3.append(f4.getBSSID());
                    sb3.append(",");
                    int rssi = f4.getRssi();
                    if (rssi < -128 || rssi > 127) {
                        rssi = 0;
                    }
                    sb3.append(rssi);
                    sb3.append(",");
                    String ssid = f4.getSSID();
                    try {
                        i3 = f4.getSSID().getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                        i3 = 32;
                    }
                    if (i3 >= 32) {
                        ssid = "unkwn";
                    }
                    sb3.append(ssid.replace(jl1.MUL, "."));
                }
            }
            if (!(arrayList == null || (arrayList2 = this.F) == null)) {
                arrayList2.clear();
                this.F.addAll(arrayList);
            }
        } else {
            jsVar.b();
            ArrayList<ScanResult> arrayList3 = this.F;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
        }
        this.b = 0;
        if (!z2) {
            this.b = (short) (2 | 0);
        }
        this.c = str7;
        this.d = str8;
        this.f = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
        this.g = "android" + Build.VERSION.getRELEASE();
        this.h = kc.b(context);
        this.i = str12;
        this.j = str9;
        this.k = str9;
        this.l = str9;
        this.m = str9;
        this.n = str9;
        this.o = str10;
        this.p = jy.e;
        this.q = jy.f;
        this.s = String.valueOf(i2);
        this.t = kc.d(context);
        this.v = "4.9.0";
        this.w = null;
        this.u = "";
        this.x = str6;
        this.y = str5;
        this.z = e2;
        this.A = str11;
        this.B = sb.toString();
        this.D = lbVar.j();
        this.G = js.i();
        this.E = sb3.toString();
        if (TextUtils.isEmpty(J)) {
            J = gg.i(context);
        }
        if (TextUtils.isEmpty(L)) {
            L = gg.b(context);
        }
        if (TextUtils.isEmpty(this.N)) {
            this.N = gg.j(context);
        }
        sb.delete(0, sb.length());
        sb3.delete(0, sb3.length());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:150:0x041d, code lost:
        if (r14 < -128) goto L_0x0419;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x03c4  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x03ca  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0487 A[Catch:{ all -> 0x049c }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x048a A[Catch:{ all -> 0x049c }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x048e A[Catch:{ all -> 0x049c }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x04af A[Catch:{ all -> 0x04d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x04c1 A[SYNTHETIC, Splitter:B:181:0x04c1] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x04e8  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x04eb  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x04fa  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0510  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0220 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0307  */
    public final byte[] a() {
        int i2;
        int i3;
        int i4;
        String str;
        int i5;
        int i6;
        int i7;
        int min;
        byte b2;
        int i8;
        int i9;
        int i10;
        byte[] bArr;
        int i11;
        int i12;
        byte[] bArr2;
        int i13;
        byte[] bArr3;
        boolean isEmpty;
        byte[] bytes;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int parseInt;
        int length;
        int length2;
        b();
        byte[] bArr4 = new byte[2];
        byte[] bArr5 = new byte[4];
        byte[] bArr6 = this.I;
        int i21 = 4096;
        if (bArr6 != null) {
            i21 = 4096 + bArr6.length + 1;
        }
        byte[] bArr7 = this.O;
        if (bArr7 == null || i21 > this.P) {
            bArr7 = new byte[i21];
            this.O = bArr7;
            this.P = i21;
        }
        byte b3 = 0;
        bArr7[0] = kc.e(this.a);
        byte[] a2 = kc.a(this.b, (byte[]) null);
        System.arraycopy(a2, 0, bArr7, 1, a2.length);
        int a3 = a(this.q, bArr7, a(this.p, bArr7, a(this.h, bArr7, a(this.u, bArr7, a(this.g, bArr7, a(this.f, bArr7, a(this.e, bArr7, a(this.o, bArr7, a(this.d, bArr7, a(this.c, bArr7, a2.length + 1))))))))));
        try {
            if (TextUtils.isEmpty(this.t)) {
                bArr7[a3] = 0;
                i2 = a3 + 1;
                int a4 = a(this.x, bArr7, a(L, bArr7, a(J, bArr7, a(this.w, bArr7, a(this.v, bArr7, i2)))));
                bArr7[a4] = Byte.parseByte(this.y);
                int i22 = a4 + 1;
                bArr7[i22] = Byte.parseByte(this.j);
                int i23 = i22 + 1;
                int i24 = this.z;
                i3 = i24 & 3;
                bArr7[i23] = (byte) i24;
                i4 = i23 + 1;
                if (i3 == 1 || i3 == 2) {
                    byte[] b4 = kc.b(b("mcc"));
                    System.arraycopy(b4, 0, bArr7, i4, b4.length);
                    int length3 = i4 + b4.length;
                    if (i3 != 1) {
                        byte[] b5 = kc.b(b(a90.MNC));
                        System.arraycopy(b5, 0, bArr7, length3, b5.length);
                        int length4 = length3 + b5.length;
                        byte[] b6 = kc.b(b("lac"));
                        System.arraycopy(b6, 0, bArr7, length4, b6.length);
                        length = length4 + b6.length;
                        byte[] c2 = kc.c(b("cellid"));
                        System.arraycopy(c2, 0, bArr7, length, c2.length);
                        length2 = c2.length;
                    } else {
                        if (i3 == 2) {
                            byte[] b7 = kc.b(b("sid"));
                            System.arraycopy(b7, 0, bArr7, length3, b7.length);
                            int length5 = length3 + b7.length;
                            byte[] b8 = kc.b(b("nid"));
                            System.arraycopy(b8, 0, bArr7, length5, b8.length);
                            int length6 = length5 + b8.length;
                            byte[] b9 = kc.b(b("bid"));
                            System.arraycopy(b9, 0, bArr7, length6, b9.length);
                            int length7 = length6 + b9.length;
                            byte[] c3 = kc.c(b("lon"));
                            System.arraycopy(c3, 0, bArr7, length7, c3.length);
                            length = length7 + c3.length;
                            byte[] c4 = kc.c(b("lat"));
                            System.arraycopy(c4, 0, bArr7, length, c4.length);
                            length2 = c4.length;
                        }
                        parseInt = Integer.parseInt(b("signal"));
                        if (parseInt > 127 || parseInt < -128) {
                            parseInt = 0;
                        }
                        bArr7[length3] = (byte) parseInt;
                        int i25 = length3 + 1;
                        byte[] a5 = kc.a(0, bArr4);
                        System.arraycopy(a5, 0, bArr7, i25, a5.length);
                        i4 = i25 + 2;
                        if (i3 == 1) {
                            if (TextUtils.isEmpty(this.B)) {
                                bArr7[i4] = 0;
                            } else {
                                int length8 = this.B.split("\\*").length;
                                bArr7[i4] = (byte) length8;
                                i4++;
                                for (int i26 = 0; i26 < length8; i26++) {
                                    byte[] b10 = kc.b(a("lac", i26));
                                    System.arraycopy(b10, 0, bArr7, i4, b10.length);
                                    int length9 = i4 + b10.length;
                                    byte[] c5 = kc.c(a("cellid", i26));
                                    System.arraycopy(c5, 0, bArr7, length9, c5.length);
                                    int length10 = length9 + c5.length;
                                    int parseInt2 = Integer.parseInt(a("signal", i26));
                                    if (parseInt2 > 127 || parseInt2 < -128) {
                                        parseInt2 = 0;
                                    }
                                    bArr7[length10] = (byte) parseInt2;
                                    i4 = length10 + 1;
                                }
                            }
                        } else if (i3 == 2) {
                            bArr7[i4] = 0;
                        }
                        i4++;
                    }
                    length3 = length + length2;
                    parseInt = Integer.parseInt(b("signal"));
                    parseInt = 0;
                    bArr7[length3] = (byte) parseInt;
                    int i252 = length3 + 1;
                    byte[] a52 = kc.a(0, bArr4);
                    System.arraycopy(a52, 0, bArr7, i252, a52.length);
                    i4 = i252 + 2;
                    if (i3 == 1) {
                    }
                    i4++;
                }
                str = this.D;
                if (str != null && (this.z & 8) == 8) {
                    try {
                        byte[] bytes2 = str.getBytes("GBK");
                        int min2 = Math.min(bytes2.length, 60);
                        bArr7[i4] = (byte) min2;
                        i4++;
                        System.arraycopy(bytes2, 0, bArr7, i4, min2);
                        i5 = i4 + min2;
                    } catch (Exception unused) {
                    }
                    ArrayList<la> arrayList = this.C;
                    int size = arrayList.size();
                    if ((this.z & 4) == 4 || size <= 0) {
                        bArr7[i5] = 0;
                        i6 = i5 + 1;
                    } else {
                        if (!arrayList.get(0).p) {
                            size--;
                        }
                        bArr7[i5] = (byte) size;
                        i6 = i5 + 1;
                        for (int i27 = 0; i27 < size; i27++) {
                            la laVar = arrayList.get(i27);
                            if (laVar.p) {
                                int i28 = laVar.k;
                                if (i28 == 1 || i28 == 3 || i28 == 4) {
                                    byte b11 = (byte) i28;
                                    if (laVar.n) {
                                        b11 = (byte) (b11 | 8);
                                    }
                                    bArr7[i6] = b11;
                                    int i29 = i6 + 1;
                                    byte[] a6 = kc.a(laVar.a, bArr4);
                                    System.arraycopy(a6, 0, bArr7, i29, a6.length);
                                    int length11 = i29 + a6.length;
                                    byte[] a7 = kc.a(laVar.b, bArr4);
                                    System.arraycopy(a7, 0, bArr7, length11, a7.length);
                                    int length12 = length11 + a7.length;
                                    byte[] a8 = kc.a(laVar.c, bArr4);
                                    System.arraycopy(a8, 0, bArr7, length12, a8.length);
                                    i20 = length12 + a8.length;
                                    byte[] b12 = kc.b(laVar.d, bArr5);
                                    System.arraycopy(b12, 0, bArr7, i20, b12.length);
                                    i19 = b12.length;
                                } else {
                                    if (i28 == 2) {
                                        byte b13 = (byte) i28;
                                        if (laVar.n) {
                                            b13 = (byte) (b13 | 8);
                                        }
                                        bArr7[i6] = b13;
                                        int i30 = i6 + 1;
                                        byte[] a9 = kc.a(laVar.a, bArr4);
                                        System.arraycopy(a9, 0, bArr7, i30, a9.length);
                                        int length13 = i30 + a9.length;
                                        byte[] a10 = kc.a(laVar.g, bArr4);
                                        System.arraycopy(a10, 0, bArr7, length13, a10.length);
                                        int length14 = length13 + a10.length;
                                        byte[] a11 = kc.a(laVar.h, bArr4);
                                        System.arraycopy(a11, 0, bArr7, length14, a11.length);
                                        int length15 = length14 + a11.length;
                                        byte[] a12 = kc.a(laVar.i, bArr4);
                                        System.arraycopy(a12, 0, bArr7, length15, a12.length);
                                        int length16 = length15 + a12.length;
                                        byte[] b14 = kc.b(laVar.f, bArr5);
                                        System.arraycopy(b14, 0, bArr7, length16, b14.length);
                                        i20 = length16 + b14.length;
                                        byte[] b15 = kc.b(laVar.e, bArr5);
                                        System.arraycopy(b15, 0, bArr7, i20, b15.length);
                                        i19 = b15.length;
                                    }
                                    i18 = laVar.j;
                                    if (i18 > 127 || i18 < -128) {
                                        i18 = 99;
                                    }
                                    bArr7[i6] = (byte) i18;
                                    int i31 = i6 + 1;
                                    byte[] a13 = kc.a(laVar.l, bArr4);
                                    System.arraycopy(a13, 0, bArr7, i31, a13.length);
                                    i6 = i31 + a13.length;
                                    if (Double.valueOf(a90.VER_CODE_OLD).doubleValue() >= 5.0d) {
                                        int i32 = laVar.k;
                                        if (i32 != 3) {
                                            if (i32 != 4) {
                                            }
                                        }
                                        int i33 = laVar.o;
                                        int i34 = 32767;
                                        if (i33 > 32767) {
                                            i33 = 32767;
                                        }
                                        if (i33 >= 0) {
                                            i34 = i33;
                                        }
                                        byte[] a14 = kc.a(i34, bArr4);
                                        System.arraycopy(a14, 0, bArr7, i6, a14.length);
                                        i6 += a14.length;
                                    }
                                }
                                i6 = i20 + i19;
                                i18 = laVar.j;
                                i18 = 99;
                                bArr7[i6] = (byte) i18;
                                int i312 = i6 + 1;
                                byte[] a132 = kc.a(laVar.l, bArr4);
                                System.arraycopy(a132, 0, bArr7, i312, a132.length);
                                i6 = i312 + a132.length;
                                if (Double.valueOf(a90.VER_CODE_OLD).doubleValue() >= 5.0d) {
                                }
                            }
                        }
                    }
                    if (this.E.length() == 0) {
                        bArr7[i6] = 0;
                        i7 = i6 + 1;
                    } else {
                        bArr7[i6] = 1;
                        int i35 = i6 + 1;
                        try {
                            String[] split = this.E.split(",");
                            byte[] a15 = a(split[0]);
                            System.arraycopy(a15, 0, bArr7, i35, a15.length);
                            int length17 = i35 + a15.length;
                            try {
                                byte[] bytes3 = split[2].getBytes("GBK");
                                int length18 = bytes3.length;
                                if (length18 > 127) {
                                    length18 = 127;
                                }
                                bArr7[length17] = (byte) length18;
                                int i36 = length17 + 1;
                                System.arraycopy(bytes3, 0, bArr7, i36, length18);
                                i17 = i36 + length18;
                            } catch (Throwable th) {
                                jy.a(th, "Req", "buildV4Dot214");
                                bArr7[length17] = 0;
                                i17 = length17 + 1;
                            }
                            int parseInt3 = Integer.parseInt(split[1]);
                            if (parseInt3 > 127 || parseInt3 < -128) {
                                parseInt3 = 0;
                            }
                            bArr7[i17] = Byte.parseByte(String.valueOf(parseInt3));
                        } catch (Throwable th2) {
                            jy.a(th2, "Req", "buildV4Dot216");
                            byte[] a16 = a(c.b);
                            System.arraycopy(a16, 0, bArr7, i35, a16.length);
                            int length19 = i35 + a16.length;
                            bArr7[length19] = 0;
                            i17 = length19 + 1;
                            bArr7[i17] = Byte.parseByte("0");
                        }
                        i7 = i17 + 1;
                    }
                    ArrayList<ScanResult> arrayList2 = this.F;
                    min = Math.min(arrayList2.size(), 25);
                    if (min == 0) {
                        bArr7[i7] = 0;
                        i8 = i7 + 1;
                        b2 = 0;
                    } else {
                        bArr7[i7] = (byte) min;
                        int i37 = i7 + 1;
                        boolean z2 = kc.c() >= 17;
                        long j2 = 0;
                        if (z2) {
                            j2 = kc.b() / 1000;
                        }
                        int i38 = 0;
                        while (i38 < min) {
                            ScanResult scanResult = arrayList2.get(i38);
                            byte[] a17 = a(scanResult.BSSID);
                            System.arraycopy(a17, b3, bArr7, i37, a17.length);
                            int length20 = i37 + a17.length;
                            try {
                                byte[] bytes4 = scanResult.SSID.getBytes("GBK");
                                bArr7[length20] = (byte) bytes4.length;
                                length20++;
                                System.arraycopy(bytes4, b3, bArr7, length20, bytes4.length);
                                i15 = length20 + bytes4.length;
                                i14 = 1;
                            } catch (Exception unused2) {
                                bArr7[length20] = b3;
                                i14 = 1;
                                i15 = length20 + 1;
                            }
                            int i39 = scanResult.level;
                            if (i39 > 127) {
                            }
                            i39 = 0;
                            bArr7[i15] = Byte.parseByte(String.valueOf(i39));
                            int i40 = i15 + i14;
                            if (!z2 || (i16 = (int) (j2 - ((scanResult.timestamp / 1000000) + 1))) < 0) {
                                i16 = 0;
                            }
                            if (i16 > 65535) {
                                i16 = 65535;
                            }
                            byte[] a18 = kc.a(i16, bArr4);
                            System.arraycopy(a18, 0, bArr7, i40, a18.length);
                            int length21 = i40 + a18.length;
                            byte[] a19 = kc.a(scanResult.frequency, bArr4);
                            System.arraycopy(a19, 0, bArr7, length21, a19.length);
                            i37 = length21 + a19.length;
                            i38++;
                            j2 = j2;
                            b3 = 0;
                        }
                        b2 = 0;
                        byte[] a20 = kc.a(Integer.parseInt(this.G), bArr4);
                        System.arraycopy(a20, 0, bArr7, i37, a20.length);
                        i8 = i37 + a20.length;
                    }
                    bArr7[i8] = b2;
                    i9 = i8 + 1;
                    bytes = this.H.getBytes("GBK");
                    if (bytes.length > 127) {
                        bytes = null;
                    }
                    if (bytes == null) {
                        bArr7[i9] = 0;
                        i10 = i9 + 1;
                        bArr = new byte[]{0, 0};
                        try {
                            isEmpty = TextUtils.isEmpty(this.K);
                            if (!isEmpty) {
                                bArr = kc.a(this.K.length(), bArr4);
                            }
                            System.arraycopy(bArr, 0, bArr7, i10, 2);
                            i12 = i10 + 2;
                            if (!isEmpty) {
                                try {
                                    byte[] bytes5 = this.K.getBytes("GBK");
                                    System.arraycopy(bytes5, 0, bArr7, i12, bytes5.length);
                                    i12 += bytes5.length;
                                } catch (Throwable unused3) {
                                }
                            }
                            i11 = 2;
                        } catch (Throwable unused4) {
                            i11 = 2;
                            i12 = i10 + 2;
                        }
                        try {
                            System.arraycopy(kc.a(0, bArr4), 0, bArr7, i12, i11);
                        } catch (Throwable unused5) {
                        }
                        int i41 = i12 + i11;
                        byte[] bArr8 = new byte[i11];
                        // fill-array-data instruction
                        bArr8[0] = 0;
                        bArr8[1] = 0;
                        try {
                            System.arraycopy(bArr8, 0, bArr7, i41, i11);
                        } catch (Throwable unused6) {
                        }
                        int i42 = i41 + i11;
                        bArr2 = this.I;
                        if (bArr2 == null) {
                            i13 = bArr2.length;
                            bArr3 = null;
                        } else {
                            bArr3 = null;
                            i13 = 0;
                        }
                        byte[] a21 = kc.a(i13, bArr3);
                        System.arraycopy(a21, 0, bArr7, i42, a21.length);
                        int length22 = i42 + a21.length;
                        if (i13 > 0) {
                            byte[] bArr9 = this.I;
                            System.arraycopy(bArr9, 0, bArr7, length22, bArr9.length);
                            length22 += this.I.length;
                        }
                        if (Double.valueOf(a90.VER_CODE_OLD).doubleValue() >= 5.0d) {
                            bArr7[length22] = 0;
                            length22 = a(this.N, bArr7, length22 + 1);
                        }
                        byte[] bArr10 = new byte[length22];
                        System.arraycopy(bArr7, 0, bArr10, 0, length22);
                        CRC32 crc32 = new CRC32();
                        crc32.update(bArr10);
                        byte[] a22 = kc.a(crc32.getValue());
                        byte[] bArr11 = new byte[(length22 + 8)];
                        System.arraycopy(bArr10, 0, bArr11, 0, length22);
                        System.arraycopy(a22, 0, bArr11, length22, 8);
                        return bArr11;
                    }
                    bArr7[i9] = (byte) bytes.length;
                    int i43 = i9 + 1;
                    System.arraycopy(bytes, 0, bArr7, i43, bytes.length);
                    i10 = i43 + bytes.length;
                    bArr = new byte[]{0, 0};
                    isEmpty = TextUtils.isEmpty(this.K);
                    if (!isEmpty) {
                    }
                    System.arraycopy(bArr, 0, bArr7, i10, 2);
                    i12 = i10 + 2;
                    if (!isEmpty) {
                    }
                    i11 = 2;
                    System.arraycopy(kc.a(0, bArr4), 0, bArr7, i12, i11);
                    int i412 = i12 + i11;
                    byte[] bArr82 = new byte[i11];
                    // fill-array-data instruction
                    bArr82[0] = 0;
                    bArr82[1] = 0;
                    System.arraycopy(bArr82, 0, bArr7, i412, i11);
                    int i422 = i412 + i11;
                    bArr2 = this.I;
                    if (bArr2 == null) {
                    }
                    byte[] a212 = kc.a(i13, bArr3);
                    System.arraycopy(a212, 0, bArr7, i422, a212.length);
                    int length222 = i422 + a212.length;
                    if (i13 > 0) {
                    }
                    if (Double.valueOf(a90.VER_CODE_OLD).doubleValue() >= 5.0d) {
                    }
                    byte[] bArr102 = new byte[length222];
                    System.arraycopy(bArr7, 0, bArr102, 0, length222);
                    CRC32 crc322 = new CRC32();
                    crc322.update(bArr102);
                    byte[] a222 = kc.a(crc322.getValue());
                    byte[] bArr112 = new byte[(length222 + 8)];
                    System.arraycopy(bArr102, 0, bArr112, 0, length222);
                    System.arraycopy(a222, 0, bArr112, length222, 8);
                    return bArr112;
                }
                bArr7[i4] = 0;
                i5 = i4 + 1;
                ArrayList<la> arrayList3 = this.C;
                int size2 = arrayList3.size();
                if ((this.z & 4) == 4) {
                }
                bArr7[i5] = 0;
                i6 = i5 + 1;
                if (this.E.length() == 0) {
                }
                ArrayList<ScanResult> arrayList22 = this.F;
                min = Math.min(arrayList22.size(), 25);
                if (min == 0) {
                }
                bArr7[i8] = b2;
                i9 = i8 + 1;
                try {
                    bytes = this.H.getBytes("GBK");
                    if (bytes.length > 127) {
                    }
                    if (bytes == null) {
                    }
                } catch (Throwable unused7) {
                    bArr7[i9] = 0;
                }
            } else {
                byte[] a23 = a(this.t);
                bArr7[a3] = (byte) a23.length;
                int i44 = a3 + 1;
                System.arraycopy(a23, 0, bArr7, i44, a23.length);
                i2 = i44 + a23.length;
                int a42 = a(this.x, bArr7, a(L, bArr7, a(J, bArr7, a(this.w, bArr7, a(this.v, bArr7, i2)))));
                bArr7[a42] = Byte.parseByte(this.y);
                int i222 = a42 + 1;
                bArr7[i222] = Byte.parseByte(this.j);
                int i232 = i222 + 1;
                int i242 = this.z;
                i3 = i242 & 3;
                bArr7[i232] = (byte) i242;
                i4 = i232 + 1;
                byte[] b42 = kc.b(b("mcc"));
                System.arraycopy(b42, 0, bArr7, i4, b42.length);
                int length32 = i4 + b42.length;
                if (i3 != 1) {
                }
                length32 = length + length2;
                parseInt = Integer.parseInt(b("signal"));
                parseInt = 0;
                bArr7[length32] = (byte) parseInt;
                int i2522 = length32 + 1;
                byte[] a522 = kc.a(0, bArr4);
                System.arraycopy(a522, 0, bArr7, i2522, a522.length);
                i4 = i2522 + 2;
                if (i3 == 1) {
                }
                i4++;
                str = this.D;
                byte[] bytes22 = str.getBytes("GBK");
                int min22 = Math.min(bytes22.length, 60);
                bArr7[i4] = (byte) min22;
                i4++;
                System.arraycopy(bytes22, 0, bArr7, i4, min22);
                i5 = i4 + min22;
                ArrayList<la> arrayList32 = this.C;
                int size22 = arrayList32.size();
                if ((this.z & 4) == 4) {
                }
                bArr7[i5] = 0;
                i6 = i5 + 1;
                if (this.E.length() == 0) {
                }
                ArrayList<ScanResult> arrayList222 = this.F;
                min = Math.min(arrayList222.size(), 25);
                if (min == 0) {
                }
                bArr7[i8] = b2;
                i9 = i8 + 1;
                bytes = this.H.getBytes("GBK");
                if (bytes.length > 127) {
                }
                if (bytes == null) {
                }
            }
        } catch (Throwable th3) {
            jy.a(th3, "Req", "buildV4Dot219");
            bArr7[a3] = 0;
        }
    }
}
