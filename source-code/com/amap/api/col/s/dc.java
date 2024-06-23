package com.amap.api.col.s;

import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.amap.api.col.s.bl;
import com.amap.api.col.s.cz;
import com.amap.api.col.s.df;
import com.amap.api.maps.AMapException;
import com.heytap.mcssdk.constant.MessageConstant$MessageType;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import org.apache.http.conn.ConnectTimeoutException;
import tb.jl1;

/* compiled from: Taobao */
public final class dc {
    private static SoftReference<SSLContext> k;
    private static SoftReference<dd> t;
    private boolean a;
    private SSLContext b;
    private Proxy c;
    private volatile boolean d = false;
    private long e = -1;
    private long f = 0;
    private String g;
    private cz.a h;
    private d i;
    private String j = "";
    private boolean l;
    private String m;
    private String n;
    private boolean o = false;
    private boolean p = false;
    private String q = "";
    private String r = "";
    private String s = "";
    private f u = new f();

    /* compiled from: Taobao */
    public static class a implements Cloneable, Comparable {
        public int a;
        public String b;
        public String c;
        public String d;
        public String e;
        public int f;
        public int g;
        public int h;
        public long i;
        public volatile AtomicInteger j = new AtomicInteger(1);

        public a(c cVar) {
            this.b = cVar.c;
            this.c = cVar.e;
            this.e = cVar.d;
            this.f = cVar.m;
            this.g = cVar.n;
            this.h = cVar.b.a();
            this.d = cVar.a;
            this.i = cVar.f;
            if (this.f == 10) {
                this.a = 0;
            }
        }

        /* renamed from: a */
        public final a clone() {
            try {
                return (a) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public final String b() {
            String str;
            String str2;
            String str3;
            String str4;
            try {
                String str5 = this.f + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                if (!TextUtils.isEmpty(this.e)) {
                    str = str5 + this.e + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                } else {
                    str = str5 + "-#";
                }
                String str6 = (str + this.h + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.j + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                if (!TextUtils.isEmpty(this.b)) {
                    str2 = str6 + this.b + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                } else {
                    str2 = str6 + "-#";
                }
                if (this.f == 1) {
                    str3 = str2 + this.d + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                } else {
                    str3 = str2 + "-#";
                }
                if (this.f == 1) {
                    str4 = str3 + this.i + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                } else {
                    str4 = str3 + "-#";
                }
                String b2 = bp.b(cv.a(((str4 + this.c + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                dc.a();
                return b2;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.a - ((a) obj).a;
        }
    }

    /* compiled from: Taobao */
    public static class b {
        public HttpURLConnection a;
        public int b = this.b;

        public b(HttpURLConnection httpURLConnection) {
            this.a = httpURLConnection;
        }
    }

    /* compiled from: Taobao */
    public static class c implements Cloneable {
        public String a = "";
        public df.b b = df.b.FIRST_NONDEGRADE;
        public String c = "";
        public String d = "";
        public String e = "";
        public long f = 0;
        public long g = 0;
        public long h = 0;
        public long i = 0;
        public long j = 0;
        public String k = "-";
        public String l = "-";
        public int m = 0;
        public int n = 0;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final c clone() {
            try {
                return (c) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public final String b() {
            String str;
            String str2;
            if (!TextUtils.isEmpty(this.c)) {
                str = this.c + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
            } else {
                str = "-#";
            }
            if (!TextUtils.isEmpty(this.d)) {
                str2 = str + this.d + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
            } else {
                str2 = str + "-#";
            }
            String b2 = bp.b(cv.a(((((str2 + this.b.a() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.h + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.j + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            dc.a();
            return b2;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.a + '\'' + ", degradeType=" + this.b + ", serverIp='" + this.c + '\'' + ", path='" + this.d + '\'' + ", hostname='" + this.e + '\'' + ", totalTime=" + this.f + ", DNSTime=" + this.g + ", connectionTime=" + this.h + ", writeTime=" + this.i + ", readTime=" + this.j + ", serverTime='" + this.k + '\'' + ", datasize='" + this.l + '\'' + ", errorcode=" + this.m + ", errorcodeSub=" + this.n + '}';
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class e implements HostnameVerifier {
        private String a;
        private String b;

        private e() {
        }

        public final void a(String str) {
            String[] split;
            if (TextUtils.isEmpty(this.a) || !str.contains(":") || (split = str.split(":")) == null || split.length <= 0) {
                this.a = str;
            } else {
                this.a = split[0];
            }
        }

        public final void b(String str) {
            this.b = str;
        }

        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.a)) {
                return this.a.equals(str);
            }
            if (!TextUtils.isEmpty(this.b)) {
                return defaultHostnameVerifier.verify(this.b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }

        /* synthetic */ e(byte b2) {
            this();
        }

        public final String a() {
            return this.b;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class f {
        long a = 0;
        long b = 0;
        c c = new c();
        a d;
        c e;
        String f;
        URL g;

        f() {
        }

        public final void a(df dfVar, URL url) {
            this.g = url;
            this.c.d = url.getPath();
            this.c.e = url.getHost();
            if (!TextUtils.isEmpty(dc.this.n) && dfVar.t().b()) {
                c cVar = this.c;
                cVar.c = cVar.e.replace(jl1.ARRAY_START_STR, "").replace(jl1.ARRAY_END_STR, "");
                this.c.e = dc.this.n;
            }
            if (dfVar.t().b()) {
                dfVar.d(this.c.e);
            }
            if (dfVar.t().d()) {
                this.f = dfVar.w();
            }
        }

        public final void b() {
            this.c.i = SystemClock.elapsedRealtime() - this.b;
        }

        public final void c() {
            this.c.j = SystemClock.elapsedRealtime() - this.b;
        }

        public final void d() {
            c a2 = this.c.clone();
            if (this.c.f > ((long) bl.e)) {
                a2.m = 1;
            }
            bl.a(a2);
        }

        public final void b(int i) {
            this.c.n = i;
        }

        public final void a() {
            this.c.h = SystemClock.elapsedRealtime() - this.b;
        }

        public final void a(dg dgVar) {
            c a2;
            try {
                this.c.f = SystemClock.elapsedRealtime() - this.a;
                if (dgVar != null) {
                    dgVar.f = this.c.b.c();
                }
                if (this.c.b.b()) {
                    c cVar = this.c;
                    if (cVar.f > 10000) {
                        bl.a(false, cVar.e);
                    }
                }
                if (this.c.b.d()) {
                    bl.a(false, this.f);
                }
                boolean a3 = dc.this.a((dc) this.c.e);
                if (a3) {
                    bl.c(this.c);
                    bl.a(true, this.d);
                    c cVar2 = this.c;
                    if (cVar2.f > ((long) bl.e) && (a2 = cVar2.clone()) != null) {
                        a2.m = 1;
                        bl.b(a2);
                        a2.toString();
                        dc.a();
                    }
                }
                bl.a(this.g.toString(), this.c.b.c(), false, a3);
                this.c.toString();
                dc.a();
            } catch (Throwable unused) {
            }
        }

        public final void a(int i) {
            "----errorcode-----".concat(String.valueOf(i));
            dc.a();
            try {
                this.c.f = SystemClock.elapsedRealtime() - this.a;
                c cVar = this.c;
                cVar.m = i;
                if (cVar.b.e()) {
                    bl.a(false, this.c.e);
                }
                boolean a2 = dc.this.a((dc) this.c.e);
                if (a2) {
                    if (dc.this.p && !TextUtils.isEmpty(dc.this.n) && this.c.b.b()) {
                        bl.c();
                    }
                    if (this.c.b.c()) {
                        bl.a(this.c.b.c(), this.c.e);
                    }
                    bl.c(this.e);
                    bl.a(false, this.d);
                    bl.b(this.c);
                }
                bl.a(this.g.toString(), this.c.b.c(), true, a2);
                this.c.toString();
                dc.a();
            } catch (Throwable unused) {
            }
        }

        public final void a(long j) {
            DecimalFormat decimalFormat = new DecimalFormat(PurchaseConstants.NULL_PRICE);
            this.c.l = decimalFormat.format((double) (((float) j) / 1024.0f));
        }
    }

    dc() {
        bl.d();
        try {
            this.g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            ci.a(th, "ht", ReportManager.g);
        }
    }

    public static void a() {
    }

    private void c(df dfVar) throws bj {
        this.i = new d((byte) 0);
        this.p = dfVar.x();
        this.c = dfVar.n();
        this.h = dfVar.s();
        this.l = dfVar.p();
        this.j = dfVar.y();
        this.a = bq.a().b(dfVar.r());
        String l2 = dfVar.t().b() ? dfVar.l() : dfVar.k();
        this.m = l2;
        this.m = db.a(l2, this.j);
        this.n = dfVar.i();
        if ("loc".equals(this.j)) {
            String k2 = dfVar.k();
            String l3 = dfVar.l();
            if (!TextUtils.isEmpty(k2)) {
                try {
                    this.r = new URL(k2).getHost();
                } catch (Exception unused) {
                }
            }
            if (!TextUtils.isEmpty(l3)) {
                try {
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q = this.n;
                    } else {
                        this.q = new URL(l3).getHost();
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0094  */
    public final dg b(df dfVar) throws bj {
        SSLException e2;
        ConnectException e3;
        ConnectTimeoutException e4;
        MalformedURLException e5;
        UnknownHostException e6;
        SocketException e7;
        SocketTimeoutException e8;
        IOException e9;
        bj e10;
        Throwable th;
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        Throwable th2;
        HttpURLConnection httpURLConnection = null;
        try {
            c(dfVar);
            dg b2 = db.b(this.m, this.j);
            if (b2 != null) {
                this.u.d();
                return b2;
            }
            b a2 = a(dfVar, true);
            HttpURLConnection httpURLConnection2 = a2.a;
            try {
                this.u.b = SystemClock.elapsedRealtime();
                httpURLConnection2.connect();
                this.u.a();
                byte[] g2 = dfVar.g();
                if (g2 == null || g2.length == 0) {
                    Map<String, String> e11 = dfVar.e();
                    HashMap<String, String> hashMap = cz.e;
                    if (hashMap != null) {
                        if (e11 != null) {
                            e11.putAll(hashMap);
                        } else {
                            e11 = hashMap;
                        }
                    }
                    String a3 = a(e11);
                    if (!TextUtils.isEmpty(a3)) {
                        g2 = bw.a(a3);
                    }
                }
                if (g2 != null && g2.length > 0) {
                    try {
                        this.u.b = SystemClock.elapsedRealtime();
                        outputStream = httpURLConnection2.getOutputStream();
                        try {
                            dataOutputStream = new DataOutputStream(outputStream);
                        } catch (Throwable th3) {
                            dataOutputStream = null;
                            th2 = th3;
                            if (dataOutputStream != null) {
                            }
                            if (outputStream != null) {
                            }
                            this.u.b();
                            throw th2;
                        }
                        try {
                            dataOutputStream.write(g2);
                            dataOutputStream.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.u.b();
                        } catch (Throwable th4) {
                            th2 = th4;
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.u.b();
                            throw th2;
                        }
                    } catch (Throwable th5) {
                        dataOutputStream = null;
                        th2 = th5;
                        outputStream = null;
                        if (dataOutputStream != null) {
                        }
                        if (outputStream != null) {
                        }
                        this.u.b();
                        throw th2;
                    }
                }
                dg a4 = a(a2);
                this.u.a(a4);
                try {
                    httpURLConnection2.disconnect();
                } catch (Throwable th6) {
                    ci.a(th6, "ht", "mPt");
                }
                this.u.d();
                return a4;
            } catch (SSLException e12) {
                e2 = e12;
                e2.printStackTrace();
                this.u.b(a(e2));
                this.u.a(4);
                throw new bj("IO 操作异常 - IOException");
            } catch (ConnectException e13) {
                e3 = e13;
                e3.printStackTrace();
                this.u.b(a(e3));
                this.u.a(6);
                throw new bj(AMapException.ERROR_CONNECTION);
            } catch (ConnectTimeoutException e14) {
                e4 = e14;
                e4.printStackTrace();
                this.u.b(a(e4));
                this.u.a(2);
                throw new bj("IO 操作异常 - IOException");
            } catch (MalformedURLException e15) {
                e5 = e15;
                e5.printStackTrace();
                this.u.a(8);
                throw new bj("url异常 - MalformedURLException");
            } catch (UnknownHostException e16) {
                e6 = e16;
                e6.printStackTrace();
                this.u.a(5);
                throw new bj("未知主机 - UnKnowHostException");
            } catch (SocketException e17) {
                e7 = e17;
                e7.printStackTrace();
                this.u.b(a(e7));
                this.u.a(6);
                throw new bj(AMapException.ERROR_SOCKET);
            } catch (SocketTimeoutException e18) {
                e8 = e18;
                e8.printStackTrace();
                this.u.b(a(e8));
                this.u.a(2);
                throw new bj("socket 连接超时 - SocketTimeoutException");
            } catch (InterruptedIOException unused) {
                this.u.b(7101);
                this.u.a(7);
                throw new bj(AMapException.ERROR_UNKNOWN);
            } catch (IOException e19) {
                e9 = e19;
                e9.printStackTrace();
                this.u.a(7);
                throw new bj("IO 操作异常 - IOException");
            } catch (bj e20) {
                e10 = e20;
                this.u.a(e10.g());
                ci.a(e10, "ht", "mPt");
                throw e10;
            } catch (Throwable th7) {
                th = th7;
                httpURLConnection = httpURLConnection2;
                ci.a(th, "ht", "mPt");
                this.u.a(9);
                throw new bj(AMapException.ERROR_UNKNOWN);
            }
        } catch (SSLException e21) {
            e2 = e21;
            e2.printStackTrace();
            this.u.b(a(e2));
            this.u.a(4);
            throw new bj("IO 操作异常 - IOException");
        } catch (ConnectException e22) {
            e3 = e22;
            e3.printStackTrace();
            this.u.b(a(e3));
            this.u.a(6);
            throw new bj(AMapException.ERROR_CONNECTION);
        } catch (ConnectTimeoutException e23) {
            e4 = e23;
            e4.printStackTrace();
            this.u.b(a(e4));
            this.u.a(2);
            throw new bj("IO 操作异常 - IOException");
        } catch (MalformedURLException e24) {
            e5 = e24;
            e5.printStackTrace();
            this.u.a(8);
            throw new bj("url异常 - MalformedURLException");
        } catch (UnknownHostException e25) {
            e6 = e25;
            e6.printStackTrace();
            this.u.a(5);
            throw new bj("未知主机 - UnKnowHostException");
        } catch (SocketException e26) {
            e7 = e26;
            e7.printStackTrace();
            this.u.b(a(e7));
            this.u.a(6);
            throw new bj(AMapException.ERROR_SOCKET);
        } catch (SocketTimeoutException e27) {
            e8 = e27;
            e8.printStackTrace();
            this.u.b(a(e8));
            this.u.a(2);
            throw new bj("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused2) {
            this.u.b(7101);
            this.u.a(7);
            throw new bj(AMapException.ERROR_UNKNOWN);
        } catch (IOException e28) {
            e9 = e28;
            e9.printStackTrace();
            this.u.a(7);
            throw new bj("IO 操作异常 - IOException");
        } catch (bj e29) {
            e10 = e29;
            if (!e10.i() && e10.g() != 10) {
                this.u.a(e10.g());
            }
            ci.a(e10, "ht", "mPt");
            throw e10;
        } catch (Throwable th8) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th9) {
                    ci.a(th9, "ht", "mPt");
                }
            }
            this.u.d();
            throw th8;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class d {
        private Vector<e> a;
        private volatile e b;

        private d() {
            this.a = new Vector<>();
            this.b = new e((byte) 0);
        }

        public final e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.b;
            }
            for (int i = 0; i < this.a.size(); i++) {
                e eVar = this.a.get(i);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            e eVar2 = new e((byte) 0);
            eVar2.b(str);
            this.a.add(eVar2);
            return eVar2;
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    private static String a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap<String, String> hashMap = cz.e;
        if (hashMap != null) {
            if (map != null) {
                map.putAll(hashMap);
            } else {
                map = hashMap;
            }
        }
        if (map == null || map.size() <= 0) {
            return str;
        }
        int indexOf = str.indexOf("?");
        if (indexOf >= 0) {
            HashMap hashMap2 = new HashMap();
            String substring = str.substring(indexOf);
            for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                if (str3 == null) {
                    str3 = "";
                }
                String encode = URLEncoder.encode(str2);
                if (!substring.matches(".*[\\?\\&]" + encode + "=.*")) {
                    hashMap2.put(str2, str3);
                }
            }
            map = hashMap2;
        }
        if (map.size() == 0) {
            return str;
        }
        String a2 = a((Map<String, String>) map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (indexOf < 0) {
            stringBuffer.append("?");
        } else if (!str.endsWith("?") && !str.endsWith("&")) {
            stringBuffer.append("&");
        }
        if (a2 != null) {
            stringBuffer.append(a2);
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    public final dg a(df dfVar) throws bj {
        HttpURLConnection httpURLConnection = null;
        try {
            c(dfVar);
            String a2 = a(this.m, dfVar.e());
            this.m = a2;
            dg b2 = db.b(a2, this.j);
            if (b2 != null) {
                this.u.d();
                return b2;
            }
            b a3 = a(dfVar, false);
            HttpURLConnection httpURLConnection2 = a3.a;
            this.u.b = SystemClock.elapsedRealtime();
            httpURLConnection2.connect();
            this.u.a();
            dg a4 = a(a3);
            this.u.a(a4);
            try {
                httpURLConnection2.disconnect();
            } catch (Throwable th) {
                ci.a(th, "ht", "mgr");
            }
            this.u.d();
            return a4;
        } catch (ConnectException e2) {
            this.u.b(a(e2));
            this.u.a(6);
            throw new bj(AMapException.ERROR_CONNECTION);
        } catch (SSLException e3) {
            e3.printStackTrace();
            this.u.b(a(e3));
            this.u.a(4);
            throw new bj("IO 操作异常 - IOException");
        } catch (ConnectTimeoutException e4) {
            e4.printStackTrace();
            this.u.b(a(e4));
            this.u.a(2);
            throw new bj("IO 操作异常 - IOException");
        } catch (MalformedURLException unused) {
            this.u.a(8);
            throw new bj("url异常 - MalformedURLException");
        } catch (UnknownHostException unused2) {
            this.u.a(9);
            throw new bj("未知主机 - UnKnowHostException");
        } catch (SocketException e5) {
            this.u.b(a(e5));
            this.u.a(6);
            throw new bj(AMapException.ERROR_SOCKET);
        } catch (SocketTimeoutException e6) {
            this.u.b(a(e6));
            this.u.a(2);
            throw new bj("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused3) {
            this.u.b(7101);
            this.u.a(7);
            throw new bj(AMapException.ERROR_UNKNOWN);
        } catch (IOException unused4) {
            this.u.a(7);
            throw new bj("IO 操作异常 - IOException");
        } catch (bj e7) {
            if (!e7.i() && e7.g() != 10) {
                this.u.a(e7.f());
            }
            throw e7;
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th3) {
                    ci.a(th3, "ht", "mgr");
                }
            }
            this.u.d();
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x020c A[SYNTHETIC, Splitter:B:111:0x020c] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cb A[SYNTHETIC, Splitter:B:41:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01e9 A[SYNTHETIC, Splitter:B:99:0x01e9] */
    private b a(df dfVar, boolean z) throws IOException, bj {
        boolean z2;
        String str;
        URLConnection a2;
        HttpsURLConnection httpsURLConnection;
        SSLContext sSLContext;
        String str2;
        boolean z3;
        String str3;
        f fVar = this.u;
        df.b t2 = dfVar.t();
        c cVar = fVar.c;
        cVar.a = dc.this.g;
        cVar.b = t2;
        fVar.a = SystemClock.elapsedRealtime();
        Map<String, String> f2 = dfVar.f();
        if (f2 == null) {
            f2 = new HashMap<>();
        }
        e a3 = this.i.a(this.n);
        int i2 = cz.a;
        String str4 = this.m;
        Uri parse = Uri.parse(str4);
        String host = parse.getHost();
        if (i2 == 1) {
            str = cz.b;
        } else if (i2 != 2) {
            str = "";
        } else {
            HashMap<String, String> hashMap = cz.c;
            if (hashMap != null) {
                str = hashMap.get(host);
            } else {
                str = "";
            }
            z2 = false;
            if (!TextUtils.isEmpty(str)) {
                dfVar.v();
                str4 = parse.buildUpon().encodedAuthority(str).build().toString();
                if (z2) {
                    f2.put("targetHost", host);
                    this.s = host;
                }
                if (z2 && this.a) {
                    a3.a(str);
                }
            }
            this.m = str4;
            URL url = new URL(this.m);
            this.u.a(dfVar, url);
            if (b(url.getHost()) && dfVar.b_()) {
                df.b t3 = dfVar.t();
                str2 = this.u.c.e;
                if (a(str2) || ((!t3.b() || !bl.g) && (!t3.c() || !bl.e(str2)))) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    try {
                        this.u.b = SystemClock.elapsedRealtime();
                        InetAddress[] allByName = InetAddress.getAllByName(this.u.c.e);
                        if (allByName == null || allByName.length <= 0 || allByName[0] == null) {
                            str3 = "";
                        } else {
                            boolean z4 = bl.a() && bl.b();
                            "---canUseIpv6---".concat(String.valueOf(z4));
                            if (z4) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= allByName.length) {
                                        break;
                                    } else if (allByName[i3] instanceof Inet6Address) {
                                        str3 = jl1.ARRAY_START_STR + allByName[i3].getHostAddress() + jl1.ARRAY_END_STR;
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                                if (TextUtils.isEmpty(str3)) {
                                    InetAddress inetAddress = allByName[0];
                                    str3 = inetAddress.getHostAddress();
                                    if (inetAddress instanceof Inet6Address) {
                                        str3 = jl1.ARRAY_START_STR + str3 + jl1.ARRAY_END_STR;
                                    }
                                }
                            } else {
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= allByName.length) {
                                        break;
                                    } else if (allByName[i4] instanceof Inet4Address) {
                                        str3 = allByName[i4].getHostAddress();
                                        break;
                                    } else {
                                        i4++;
                                    }
                                }
                                if (TextUtils.isEmpty(str3)) {
                                }
                            }
                            str3 = "";
                            if (TextUtils.isEmpty(str3)) {
                            }
                        }
                        f fVar2 = this.u;
                        "---onDNSEnd---ip=".concat(String.valueOf(str3));
                        fVar2.c.c = str3.replace(jl1.ARRAY_START_STR, "").replace(jl1.ARRAY_END_STR, "");
                        fVar2.c.g = SystemClock.elapsedRealtime() - fVar2.b;
                        if (!TextUtils.isEmpty(str3)) {
                            Uri parse2 = Uri.parse(this.m);
                            String host2 = parse2.getHost();
                            Uri build = parse2.buildUpon().encodedAuthority(str3).build();
                            this.n = host2;
                            f2.put("host", host2);
                            if (this.a) {
                                a3.b(host2);
                            }
                            this.m = build.toString();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.a) {
                this.m = bq.a(this.m);
            }
            Objects.toString(dfVar.t());
            URL url2 = new URL(this.m);
            cz.a aVar = this.h;
            a2 = aVar == null ? aVar.a() : null;
            if (a2 == null) {
                Proxy proxy = this.c;
                if (proxy != null) {
                    a2 = url2.openConnection(proxy);
                } else {
                    a2 = url2.openConnection();
                }
            }
            if (!this.a) {
                try {
                    SoftReference<SSLContext> softReference = k;
                    if (softReference == null || softReference.get() == null) {
                        k = new SoftReference<>(SSLContext.getInstance("TLS"));
                    }
                    SoftReference<SSLContext> softReference2 = k;
                    if (softReference2 != null) {
                        sSLContext = softReference2.get();
                        if (sSLContext == null) {
                            try {
                                sSLContext = SSLContext.getInstance("TLS");
                            } catch (Throwable th) {
                                ci.a(th, "ht", "ne");
                            }
                        }
                        sSLContext.init(null, null, null);
                        this.b = sSLContext;
                        HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) a2;
                        if (!bl.f.a) {
                            dd b2 = b();
                            if (b2 != null) {
                                httpsURLConnection2.setSSLSocketFactory(b2);
                                b2.a();
                            } else {
                                httpsURLConnection2.setSSLSocketFactory(this.b.getSocketFactory());
                            }
                        } else {
                            httpsURLConnection2.setSSLSocketFactory(this.b.getSocketFactory());
                        }
                        httpsURLConnection2.setHostnameVerifier(a3);
                        httpsURLConnection = httpsURLConnection2;
                    }
                } catch (Throwable unused2) {
                }
                sSLContext = null;
                if (sSLContext == null) {
                }
                sSLContext.init(null, null, null);
                this.b = sSLContext;
                HttpsURLConnection httpsURLConnection22 = (HttpsURLConnection) a2;
                if (!bl.f.a) {
                }
                httpsURLConnection22.setHostnameVerifier(a3);
                httpsURLConnection = httpsURLConnection22;
            } else {
                httpsURLConnection = (HttpURLConnection) a2;
            }
            if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
                httpsURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
            }
            int u2 = (int) (((long) dfVar.u()) - (this.u.c.g / 1000));
            a(f2, httpsURLConnection);
            httpsURLConnection.setConnectTimeout(u2);
            httpsURLConnection.setReadTimeout(u2);
            if (!z) {
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
            } else {
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setDoInput(true);
            }
            return new b(httpsURLConnection);
        }
        z2 = true;
        if (!TextUtils.isEmpty(str)) {
        }
        this.m = str4;
        URL url3 = new URL(this.m);
        this.u.a(dfVar, url3);
        df.b t32 = dfVar.t();
        str2 = this.u.c.e;
        if (a(str2)) {
        }
        z3 = false;
        if (z3) {
        }
        if (this.a) {
        }
        Objects.toString(dfVar.t());
        URL url22 = new URL(this.m);
        cz.a aVar2 = this.h;
        if (aVar2 == null) {
        }
        if (a2 == null) {
        }
        if (!this.a) {
        }
        httpsURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
        int u22 = (int) (((long) dfVar.u()) - (this.u.c.g / 1000));
        a(f2, httpsURLConnection);
        httpsURLConnection.setConnectTimeout(u22);
        httpsURLConnection.setReadTimeout(u22);
        if (!z) {
        }
        return new b(httpsURLConnection);
    }

    private dd b() {
        try {
            SoftReference<dd> softReference = t;
            if (softReference == null || softReference.get() == null) {
                t = new SoftReference<>(new dd(bl.c, this.b));
            }
            dd ddVar = k != null ? t.get() : null;
            return ddVar == null ? new dd(bl.c, this.b) : ddVar;
        } catch (Throwable th) {
            cl.c(th, "ht", "gsf");
            return null;
        }
    }

    private static String b(Map<String, List<String>> map) {
        try {
            List<String> list = map.get(IRequestConst.SC);
            if (list == null || list.size() <= 0) {
                return "";
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                String[] split = str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                if (split.length <= 1) {
                    return "";
                }
                str = split[0];
            }
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static boolean b(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01c6 A[Catch:{ all -> 0x01ea }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01e9 A[Catch:{ all -> 0x01ea }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01fa A[SYNTHETIC, Splitter:B:136:0x01fa] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0204 A[SYNTHETIC, Splitter:B:141:0x0204] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x020e A[SYNTHETIC, Splitter:B:146:0x020e] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0218 A[SYNTHETIC, Splitter:B:151:0x0218] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a4  */
    /* JADX WARNING: Unknown variable types count: 1 */
    private dg a(b bVar) throws bj, IOException {
        Throwable th;
        PushbackInputStream pushbackInputStream;
        InputStream inputStream;
        ?? r4;
        ConnectTimeoutException e2;
        SocketTimeoutException e3;
        IOException e4;
        Object obj;
        boolean z;
        Object obj2;
        Object obj3;
        char c2;
        String str = "";
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            db.a();
            HttpURLConnection httpURLConnection = bVar.a;
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            int responseCode = httpURLConnection.getResponseCode();
            if (headerFields != null) {
                List<String> list = headerFields.get("gsid");
                if (list != null && list.size() > 0) {
                    str = list.get(0);
                }
                this.u.c.k = b(headerFields);
                try {
                    if (!TextUtils.isEmpty(this.j)) {
                        if (!this.o) {
                            z = a(headerFields, true);
                            c2 = 2;
                        } else if (headerFields.containsKey(IRequestConst.SC)) {
                            z = a(headerFields, false);
                            c2 = 1;
                        } else {
                            bl.b(this.j);
                            z = false;
                            c2 = 0;
                        }
                        if (z) {
                            try {
                                if (this.j.equals("loc")) {
                                    String str2 = this.s;
                                    if (TextUtils.isEmpty(str2)) {
                                        str2 = httpURLConnection.getURL().getHost();
                                    }
                                    bl.a(this.j, c2 == 2, str2, str2, this.n);
                                } else {
                                    bl.b(this.j, c2 == 2);
                                }
                            } catch (Throwable unused) {
                            }
                        } else if (c2 == 1) {
                            db.a(false, this.j);
                        }
                        if (responseCode != 200) {
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                this.u.b = SystemClock.elapsedRealtime();
                                inputStream = httpURLConnection.getInputStream();
                                try {
                                    pushbackInputStream = new PushbackInputStream(inputStream, 2);
                                    try {
                                        byte[] bArr = new byte[2];
                                        pushbackInputStream.read(bArr);
                                        pushbackInputStream.unread(bArr);
                                        FilterInputStream gZIPInputStream = (bArr[0] == 31 && bArr[1] == -117) ? new GZIPInputStream(pushbackInputStream) : pushbackInputStream;
                                        byte[] bArr2 = new byte[1024];
                                        while (true) {
                                            int read = gZIPInputStream.read(bArr2);
                                            if (read == -1) {
                                                break;
                                            }
                                            byteArrayOutputStream2.write(bArr2, 0, read);
                                        }
                                        this.u.c();
                                        cl.b();
                                        dg dgVar = new dg();
                                        dgVar.a = byteArrayOutputStream2.toByteArray();
                                        dgVar.b = headerFields;
                                        dgVar.c = this.g;
                                        dgVar.d = str;
                                        dgVar.e = z;
                                        db.a(httpURLConnection.getURL(), dgVar);
                                        this.u.a((long) dgVar.a.length);
                                        try {
                                            byteArrayOutputStream2.close();
                                        } catch (Throwable th2) {
                                            ci.a(th2, "ht", "par");
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Throwable th3) {
                                                ci.a(th3, "ht", "par");
                                            }
                                        }
                                        try {
                                            pushbackInputStream.close();
                                        } catch (Throwable th4) {
                                            ci.a(th4, "ht", "par");
                                        }
                                        try {
                                            gZIPInputStream.close();
                                        } catch (Throwable th5) {
                                            ci.a(th5, "ht", "par");
                                        }
                                        return dgVar;
                                    } catch (ConnectTimeoutException e5) {
                                        e2 = e5;
                                        throw e2;
                                    } catch (SocketTimeoutException e6) {
                                        e3 = e6;
                                        str = null;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        throw e3;
                                    } catch (IOException e7) {
                                        e4 = e7;
                                        obj2 = null;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        obj = obj2;
                                        try {
                                            if (!(e4 instanceof InterruptedIOException)) {
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            r4 = obj;
                                            if (byteArrayOutputStream != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (pushbackInputStream != null) {
                                            }
                                            if (r4 != 0) {
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        obj3 = null;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        r4 = obj3;
                                        if (byteArrayOutputStream != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (pushbackInputStream != null) {
                                        }
                                        if (r4 != 0) {
                                        }
                                        throw th;
                                    }
                                } catch (ConnectTimeoutException e8) {
                                    e2 = e8;
                                    throw e2;
                                } catch (SocketTimeoutException e9) {
                                    e3 = e9;
                                    str = null;
                                    pushbackInputStream = null;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    throw e3;
                                } catch (IOException e10) {
                                    e4 = e10;
                                    obj2 = null;
                                    pushbackInputStream = null;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    obj = obj2;
                                    if (!(e4 instanceof InterruptedIOException)) {
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    obj3 = null;
                                    pushbackInputStream = null;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    r4 = obj3;
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (pushbackInputStream != null) {
                                    }
                                    if (r4 != 0) {
                                    }
                                    throw th;
                                }
                            } catch (ConnectTimeoutException e11) {
                                e2 = e11;
                                throw e2;
                            } catch (SocketTimeoutException e12) {
                                e3 = e12;
                                str = null;
                                inputStream = null;
                                pushbackInputStream = null;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                throw e3;
                            } catch (IOException e13) {
                                e4 = e13;
                                obj2 = null;
                                inputStream = null;
                                pushbackInputStream = null;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                obj = obj2;
                                if (!(e4 instanceof InterruptedIOException)) {
                                    bj bjVar = new bj("IO 操作异常 - IOException", str, this.g);
                                    if (!TextUtils.isEmpty(e4.getMessage()) && e4.getMessage().equals("thread interrupted")) {
                                        bjVar.j();
                                    }
                                    throw bjVar;
                                }
                                throw e4;
                            } catch (Throwable th9) {
                                th = th9;
                                obj3 = null;
                                inputStream = null;
                                pushbackInputStream = null;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                r4 = obj3;
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable th10) {
                                        ci.a(th10, "ht", "par");
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th11) {
                                        ci.a(th11, "ht", "par");
                                    }
                                }
                                if (pushbackInputStream != null) {
                                    try {
                                        pushbackInputStream.close();
                                    } catch (Throwable th12) {
                                        ci.a(th12, "ht", "par");
                                    }
                                }
                                if (r4 != 0) {
                                    try {
                                        r4.close();
                                    } catch (Throwable th13) {
                                        ci.a(th13, "ht", "par");
                                    }
                                }
                                throw th;
                            }
                        } else {
                            bj bjVar2 = new bj("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode + AltriaXLaunchTime.SPACE + str + " " + this.g, str, this.g);
                            bjVar2.a(httpURLConnection.getResponseMessage());
                            bjVar2.a(headerFields);
                            this.u.b(responseCode);
                            this.u.a(10);
                            bjVar2.h();
                            throw bjVar2;
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            z = false;
            if (responseCode != 200) {
            }
        } catch (ConnectTimeoutException e14) {
            e2 = e14;
            throw e2;
        } catch (SocketTimeoutException e15) {
            e3 = e15;
            str = null;
            inputStream = null;
            pushbackInputStream = null;
            throw e3;
        } catch (IOException e16) {
            e4 = e16;
            obj = null;
            inputStream = null;
            pushbackInputStream = null;
            if (!(e4 instanceof InterruptedIOException)) {
            }
        } catch (Throwable th14) {
            th = th14;
            r4 = str;
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != null) {
            }
            if (pushbackInputStream != null) {
            }
            if (r4 != 0) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f A[Catch:{ all -> 0x0072 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040 A[Catch:{ all -> 0x0072 }] */
    private boolean a(Map<String, List<String>> map, boolean z) {
        boolean z2;
        List<String> list;
        try {
            List<String> list2 = map.get(IRequestConst.SC);
            if (list2 != null && list2.size() > 0) {
                String str = list2.get(0);
                if (!TextUtils.isEmpty(str)) {
                    if (str.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                        String[] split = str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        if (split.length > 1 && "1".equals(split[1])) {
                        }
                    }
                    z2 = true;
                    if (z2) {
                        return false;
                    }
                    if (!z) {
                        return true;
                    }
                    if (map.containsKey("lct") && (list = map.get("lct")) != null && list.size() > 0) {
                        String str2 = list.get(0);
                        if (!TextUtils.isEmpty(str2)) {
                            return bl.a(this.j, Long.valueOf(str2).longValue());
                        }
                    }
                    return false;
                }
            }
            z2 = false;
            if (z2) {
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        String str;
        c f2;
        if (map != null) {
            try {
                for (String str2 : map.keySet()) {
                    httpURLConnection.addRequestProperty(str2, map.get(str2));
                }
            } catch (Throwable th) {
                ci.a(th, "ht", "adh");
                return;
            }
        }
        HashMap<String, String> hashMap = cz.d;
        if (hashMap != null) {
            for (String str3 : hashMap.keySet()) {
                httpURLConnection.addRequestProperty(str3, cz.d.get(str3));
            }
        }
        if (!this.m.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.j) && bl.a(this.j)) {
            this.o = true;
            httpURLConnection.addRequestProperty("lct", String.valueOf(bl.c(this.j)));
        }
        httpURLConnection.addRequestProperty("csid", this.g);
        if (a(this.u.c.e)) {
            f fVar = this.u;
            if (TextUtils.isEmpty(fVar.c.c)) {
                str = "";
            } else {
                String b2 = bp.b(cv.a(fVar.c.c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                String str4 = fVar.c.c;
                str = b2;
            }
            if (!TextUtils.isEmpty(str)) {
                httpURLConnection.addRequestProperty("sip", str);
            }
            if (bl.j && (f2 = bl.f()) != null) {
                httpURLConnection.addRequestProperty("nls", f2.b());
                this.u.e = f2;
            }
            a e2 = bl.e();
            if (e2 != null) {
                httpURLConnection.addRequestProperty("nlf", e2.b());
                this.u.d = e2;
            }
        }
    }

    static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(key));
            sb.append("=");
            sb.append(URLEncoder.encode(value));
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean a(String str) {
        if (!this.l) {
            return (!TextUtils.isEmpty(this.n) && (this.n.contains("rest") || this.n.contains("apilocate"))) || b(str);
        }
        return true;
    }

    private static int a(Exception exc) {
        if (exc instanceof SSLHandshakeException) {
            return 4101;
        }
        if (exc instanceof SSLKeyException) {
            return 4102;
        }
        if (exc instanceof SSLProtocolException) {
            return MessageConstant$MessageType.MESSAGE_DATA;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return 4104;
        }
        if (exc instanceof ConnectException) {
            return 6101;
        }
        if (exc instanceof SocketException) {
            return 6102;
        }
        if (exc instanceof ConnectTimeoutException) {
            return 2101;
        }
        return exc instanceof SocketTimeoutException ? 2102 : 0;
    }
}
