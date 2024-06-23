package com.loc;

import android.content.Context;
import android.taobao.windvane.connect.api.ApiResponse;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.loc.bl;
import com.uc.webview.export.media.CommandID;
import java.util.HashMap;
import java.util.Locale;
import tb.gl1;
import tb.q23;
import tb.r53;

/* compiled from: Taobao */
public final class h1 {
    private static h1 e;
    private Context a = null;
    private int b = j1.i;
    private boolean c = false;
    private int d = 0;

    private h1(Context context) {
        try {
            q1.a().c(context);
        } catch (Throwable unused) {
        }
        this.a = context;
        bg.b();
    }

    public static h1 a(Context context) {
        if (e == null) {
            e = new h1(context);
        }
        return e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00e5 A[Catch:{ all -> 0x00f8 }] */
    public final String b(Context context, double d2, double d3) {
        String str;
        try {
            HashMap hashMap = new HashMap(16);
            r53 r53 = new r53(context, j1.q());
            hashMap.clear();
            hashMap.put("Content-Type", IRequestConst.CONTENT_TYPE_POST);
            hashMap.put(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
            hashMap.put(IRequestConst.USER_AGENT, "AMAP_Location_SDK_Android 6.1.0");
            HashMap hashMap2 = new HashMap(16);
            hashMap2.put("custom", "26260A1F00020002");
            hashMap2.put("key", l.j(context));
            int i = this.d;
            if (i != 0) {
                if (i == 1) {
                    str = "zh-CN";
                } else if (i == 2) {
                    str = "en";
                }
                hashMap2.put("language", str);
                hashMap2.put("curLocationType", !m1.f0(this.a) ? "coarseLoc" : "fineLoc");
                String a2 = o1.a();
                String c2 = o1.c(context, a2, v1.s(hashMap2));
                hashMap2.put("ts", a2);
                hashMap2.put("scode", c2);
                r53.Y(("output=json&radius=1000&extensions=all&location=" + d3 + "," + d2).getBytes("UTF-8"));
                r53.a0(false);
                r53.X(true);
                r53.V(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.1.0", "loc", 3));
                r53.U(hashMap2);
                r53.W(hashMap);
                r53.h(t1.c(context));
                r53.c(j1.i);
                r53.l(j1.i);
                r53.c0("http://dualstack-arestapi.amap.com/v3/geocode/regeo");
                r53.Z("http://restsdk.amap.com/v3/geocode/regeo");
                if (this.c) {
                    r53.f(bl.c.HTTPS);
                }
                return new String(bg.c(r53).a, "utf-8");
            }
            hashMap2.remove("language");
            hashMap2.put("curLocationType", !m1.f0(this.a) ? "coarseLoc" : "fineLoc");
            String a22 = o1.a();
            String c22 = o1.c(context, a22, v1.s(hashMap2));
            hashMap2.put("ts", a22);
            hashMap2.put("scode", c22);
            r53.Y(("output=json&radius=1000&extensions=all&location=" + d3 + "," + d2).getBytes("UTF-8"));
            r53.a0(false);
            r53.X(true);
            r53.V(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.1.0", "loc", 3));
            r53.U(hashMap2);
            r53.W(hashMap);
            r53.h(t1.c(context));
            r53.c(j1.i);
            r53.l(j1.i);
            try {
                r53.c0("http://dualstack-arestapi.amap.com/v3/geocode/regeo");
                r53.Z("http://restsdk.amap.com/v3/geocode/regeo");
                if (this.c) {
                }
                return new String(bg.c(r53).a, "utf-8");
            } catch (Throwable th) {
                j1.h(th, "LocNetManager", gl1.TYPE_OPEN_URL_METHOD_POST);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public final q23 c(r53 r53) throws Throwable {
        if (this.c) {
            r53.f(bl.c.HTTPS);
        }
        return bg.c(r53);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    public final r53 d(Context context, byte[] bArr, String str, String str2, boolean z) {
        String str3;
        try {
            HashMap hashMap = new HashMap(16);
            r53 r53 = new r53(context, j1.q());
            try {
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
                hashMap.put(IRequestConst.USER_AGENT, "AMAP_Location_SDK_Android 6.1.0");
                hashMap.put(ApiResponse.KEY, l.j(context));
                hashMap.put("enginever", j1.a);
                String a2 = o1.a();
                String c2 = o1.c(context, a2, "key=" + l.j(context));
                hashMap.put("ts", a2);
                hashMap.put("scode", c2);
                if (Double.valueOf(j1.a).doubleValue() >= 5.3d) {
                    hashMap.put("aps_s_src", "openapi");
                }
                hashMap.put("encr", "1");
                r53.W(hashMap);
                String str4 = "loc";
                if (!z) {
                    str4 = "locf";
                }
                r53.a0(true);
                r53.V(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.1.0", str4, 3));
                r53.X(z);
                r53.Z(str);
                r53.c0(str2);
                r53.b0(m1.x(bArr));
                r53.h(t1.c(context));
                HashMap hashMap2 = new HashMap(16);
                hashMap2.put("output", "bin");
                hashMap2.put("policy", "3103");
                int i = this.d;
                if (i != 0) {
                    if (i == 1) {
                        str3 = "language:cn";
                    } else if (i == 2) {
                        str3 = "language:en";
                    }
                    hashMap2.put("custom", str3);
                    r53.U(hashMap2);
                    r53.c(this.b);
                    r53.l(this.b);
                    if (this.c) {
                        return r53;
                    }
                    r53.f(bl.c.HTTPS);
                    return r53;
                }
                hashMap2.remove("custom");
                r53.U(hashMap2);
                r53.c(this.b);
                r53.l(this.b);
                if (this.c) {
                }
            } catch (Throwable unused) {
                return r53;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final void e(long j, boolean z, int i) {
        try {
            this.c = z;
            this.b = Long.valueOf(j).intValue();
            this.d = i;
        } catch (Throwable th) {
            j1.h(th, "LocNetManager", CommandID.setOption);
        }
    }
}
