package com.loc;

import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.amap.api.maps.AMapException;
import com.heytap.mcssdk.constant.MessageConstant$MessageType;
import com.loc.bg;
import com.loc.bl;
import com.loc.m;
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
import tb.o23;
import tb.q23;
import tb.v13;

/* compiled from: Taobao */
public final class bj {
    private static SoftReference<SSLContext> o;
    private static SoftReference<a0> p;
    private boolean a;
    private SSLContext b;
    private Proxy c;
    private String d;
    private bg.a e;
    private d f;
    private String g = "";
    private boolean h;
    private String i;
    private String j;
    private boolean k = false;
    private boolean l = false;
    private String m = "";
    private f n = new f();

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
            StringBuilder sb;
            StringBuilder sb2;
            StringBuilder sb3;
            StringBuilder sb4;
            try {
                String str = this.f + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                if (!TextUtils.isEmpty(this.e)) {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(this.e);
                    sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                } else {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append("-#");
                }
                String str2 = (sb.toString() + this.h + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.j + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
                if (!TextUtils.isEmpty(this.b)) {
                    sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(this.b);
                    sb2.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append("-#");
                }
                String sb5 = sb2.toString();
                if (this.f == 1) {
                    sb3 = new StringBuilder();
                    sb3.append(sb5);
                    sb3.append(this.d);
                    sb3.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                } else {
                    sb3 = new StringBuilder();
                    sb3.append(sb5);
                    sb3.append("-#");
                }
                String sb6 = sb3.toString();
                if (this.f == 1) {
                    sb4 = new StringBuilder();
                    sb4.append(sb6);
                    sb4.append(this.i);
                    sb4.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                } else {
                    sb4 = new StringBuilder();
                    sb4.append(sb6);
                    sb4.append("-#");
                }
                String f2 = p1.f(o23.a(((sb4.toString() + this.c + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                bj.f();
                return f2;
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
        public bl.b b = bl.b.FIRST_NONDEGRADE;
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
            String f2 = p1.f(o23.a(((((str2 + this.b.a() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.h + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.j + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + this.f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            bj.f();
            return f2;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.a + '\'' + ", degradeType=" + this.b + ", serverIp='" + this.c + '\'' + ", path='" + this.d + '\'' + ", hostname='" + this.e + '\'' + ", totalTime=" + this.f + ", DNSTime=" + this.g + ", connectionTime=" + this.h + ", writeTime=" + this.i + ", readTime=" + this.j + ", serverTime='" + this.k + '\'' + ", datasize='" + this.l + '\'' + ", errorcode=" + this.m + ", errorcodeSub=" + this.n + '}';
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

        /* synthetic */ d(byte b2) {
            this();
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
            eVar2.c(str);
            this.a.add(eVar2);
            return eVar2;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class e implements HostnameVerifier {
        private String a;
        private String b;

        private e() {
        }

        /* synthetic */ e(byte b2) {
            this();
        }

        public final String a() {
            return this.b;
        }

        public final void b(String str) {
            String[] split;
            if (TextUtils.isEmpty(this.a) || !str.contains(":") || (split = str.split(":")) == null || split.length <= 0) {
                this.a = str;
            } else {
                this.a = split[0];
            }
        }

        public final void c(String str) {
            this.b = str;
        }

        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return !TextUtils.isEmpty(this.a) ? this.a.equals(str) : !TextUtils.isEmpty(this.b) ? defaultHostnameVerifier.verify(this.b, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
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

        public final void a() {
            this.c.h = SystemClock.elapsedRealtime() - this.b;
        }

        public final void b(int i) {
            "----errorcode-----".concat(String.valueOf(i));
            bj.f();
            try {
                this.c.f = SystemClock.elapsedRealtime() - this.a;
                c cVar = this.c;
                cVar.m = i;
                if (cVar.b.e()) {
                    m.p(false, this.c.e);
                }
                boolean i2 = bj.this.i(this.c.e);
                if (i2) {
                    if (bj.this.l && !TextUtils.isEmpty(bj.this.j) && this.c.b.b()) {
                        m.H();
                    }
                    if (this.c.b.c()) {
                        m.p(this.c.b.c(), this.c.e);
                    }
                    m.F(this.e);
                    m.o(false, this.d);
                    m.y(this.c);
                }
                m.n(this.g.toString(), this.c.b.c(), true, i2);
                this.c.toString();
                bj.f();
            } catch (Throwable unused) {
            }
        }

        public final void c(long j) {
            DecimalFormat decimalFormat = new DecimalFormat(PurchaseConstants.NULL_PRICE);
            this.c.l = decimalFormat.format((double) (((float) j) / 1024.0f));
        }

        public final void d(bl blVar, URL url) {
            this.g = url;
            this.c.d = url.getPath();
            this.c.e = url.getHost();
            if (!TextUtils.isEmpty(bj.this.j) && blVar.D().b()) {
                c cVar = this.c;
                cVar.c = cVar.e.replace(jl1.ARRAY_START_STR, "").replace(jl1.ARRAY_END_STR, "");
                this.c.e = bj.this.j;
            }
            if (blVar.D().b()) {
                blVar.g(this.c.e);
            }
            if (blVar.D().d()) {
                this.f = blVar.G();
            }
        }

        public final void e(q23 q23) {
            c a2;
            try {
                this.c.f = SystemClock.elapsedRealtime() - this.a;
                if (q23 != null) {
                    q23.e = this.c.b.c();
                }
                if (this.c.b.b()) {
                    c cVar = this.c;
                    if (cVar.f > 10000) {
                        m.p(false, cVar.e);
                    }
                }
                if (this.c.b.d()) {
                    m.p(false, this.f);
                }
                boolean i = bj.this.i(this.c.e);
                if (i) {
                    m.F(this.c);
                    m.o(true, this.d);
                    c cVar2 = this.c;
                    if (cVar2.f > ((long) m.r) && (a2 = cVar2.clone()) != null) {
                        a2.m = 1;
                        m.y(a2);
                        a2.toString();
                        bj.f();
                    }
                }
                m.n(this.g.toString(), this.c.b.c(), false, i);
                this.c.toString();
                bj.f();
            } catch (Throwable unused) {
            }
        }

        public final void f() {
            this.c.i = SystemClock.elapsedRealtime() - this.b;
        }

        public final void g(int i) {
            this.c.n = i;
        }

        public final void h() {
            this.c.j = SystemClock.elapsedRealtime() - this.b;
        }

        public final void i() {
            c a2 = this.c.clone();
            if (this.c.f > ((long) m.r)) {
                a2.m = 1;
            }
            m.j(a2);
        }
    }

    bj() {
        m.K();
        try {
            this.d = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            v13.e(th, "ht", ReportManager.g);
        }
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

    static String c(Map<String, String> map) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01c2 A[Catch:{ all -> 0x01e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01e5 A[Catch:{ all -> 0x01e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01f6 A[SYNTHETIC, Splitter:B:132:0x01f6] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0200 A[SYNTHETIC, Splitter:B:137:0x0200] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x020a A[SYNTHETIC, Splitter:B:142:0x020a] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0214 A[SYNTHETIC, Splitter:B:147:0x0214] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private q23 d(b bVar) throws k, IOException {
        Throwable th;
        PushbackInputStream pushbackInputStream;
        InputStream inputStream;
        ?? r4;
        ConnectTimeoutException e2;
        SocketTimeoutException e3;
        IOException e4;
        Object obj;
        Object obj2;
        Object obj3;
        char c2;
        boolean z;
        String str = "";
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            y.b();
            HttpURLConnection httpURLConnection = bVar.a;
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            int responseCode = httpURLConnection.getResponseCode();
            if (headerFields != null) {
                List<String> list = headerFields.get("gsid");
                if (list != null && list.size() > 0) {
                    str = list.get(0);
                }
                this.n.c.k = l(headerFields);
                try {
                    if (!TextUtils.isEmpty(this.g)) {
                        if (!this.k) {
                            z = j(headerFields, true);
                            c2 = 2;
                        } else if (headerFields.containsKey(IRequestConst.SC)) {
                            z = j(headerFields, false);
                            c2 = 1;
                        } else {
                            m.z(this.g);
                            z = false;
                            c2 = 0;
                        }
                        if (z) {
                            if (this.g.equals("loc")) {
                                String str2 = this.m;
                                if (TextUtils.isEmpty(str2)) {
                                    str2 = httpURLConnection.getURL().getHost();
                                }
                                m.m(this.g, c2 == 2, str2, str2, this.j);
                            } else {
                                m.B(this.g, c2 == 2);
                            }
                        } else if (c2 == 1) {
                            y.j(false, this.g);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            if (responseCode == 200) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    this.n.b = SystemClock.elapsedRealtime();
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
                            this.n.h();
                            an.n();
                            q23 q23 = new q23();
                            q23.a = byteArrayOutputStream2.toByteArray();
                            q23.b = headerFields;
                            q23.c = this.d;
                            q23.d = str;
                            y.i(httpURLConnection.getURL(), q23);
                            this.n.c((long) q23.a.length);
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Throwable th2) {
                                v13.e(th2, "ht", "par");
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th3) {
                                    v13.e(th3, "ht", "par");
                                }
                            }
                            try {
                                pushbackInputStream.close();
                            } catch (Throwable th4) {
                                v13.e(th4, "ht", "par");
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (Throwable th5) {
                                v13.e(th5, "ht", "par");
                            }
                            return q23;
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
                        k kVar = new k("IO 操作异常 - IOException", str, this.d);
                        if (!TextUtils.isEmpty(e4.getMessage()) && e4.getMessage().equals("thread interrupted")) {
                            kVar.j();
                        }
                        throw kVar;
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
                            v13.e(th10, "ht", "par");
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th11) {
                            v13.e(th11, "ht", "par");
                        }
                    }
                    if (pushbackInputStream != null) {
                        try {
                            pushbackInputStream.close();
                        } catch (Throwable th12) {
                            v13.e(th12, "ht", "par");
                        }
                    }
                    if (r4 != 0) {
                        try {
                            r4.close();
                        } catch (Throwable th13) {
                            v13.e(th13, "ht", "par");
                        }
                    }
                    throw th;
                }
            } else {
                k kVar2 = new k("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode + AltriaXLaunchTime.SPACE + str + " " + this.d, str, this.d);
                kVar2.a(httpURLConnection.getResponseMessage());
                kVar2.a(headerFields);
                this.n.g(responseCode);
                this.n.b(10);
                kVar2.h();
                throw kVar2;
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

    public static void f() {
    }

    private void g(Map<String, String> map, HttpURLConnection httpURLConnection) {
        String str;
        c N;
        if (map != null) {
            try {
                for (String str2 : map.keySet()) {
                    httpURLConnection.addRequestProperty(str2, map.get(str2));
                }
            } catch (Throwable th) {
                v13.e(th, "ht", "adh");
                return;
            }
        }
        HashMap<String, String> hashMap = bg.d;
        if (hashMap != null) {
            for (String str3 : hashMap.keySet()) {
                httpURLConnection.addRequestProperty(str3, bg.d.get(str3));
            }
        }
        if (!this.i.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.g) && m.r(this.g)) {
            this.k = true;
            httpURLConnection.addRequestProperty("lct", String.valueOf(m.D(this.g)));
        }
        httpURLConnection.addRequestProperty("csid", this.d);
        if (i(this.n.c.e)) {
            f fVar = this.n;
            if (TextUtils.isEmpty(fVar.c.c)) {
                str = "";
            } else {
                String f2 = p1.f(o23.a(fVar.c.c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                String str4 = fVar.c.c;
                str = f2;
            }
            if (!TextUtils.isEmpty(str)) {
                httpURLConnection.addRequestProperty("sip", str);
            }
            if (m.y && (N = m.N()) != null) {
                httpURLConnection.addRequestProperty("nls", N.b());
                this.n.e = N;
            }
            a M = m.M();
            if (M != null) {
                httpURLConnection.addRequestProperty("nlf", M.b());
                this.n.d = M;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean i(String str) {
        if (!this.h) {
            return (!TextUtils.isEmpty(this.j) && (this.j.contains("rest") || this.j.contains("apilocate"))) || o(str);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f A[Catch:{ all -> 0x0072 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040 A[Catch:{ all -> 0x0072 }] */
    private boolean j(Map<String, List<String>> map, boolean z) {
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
                            return m.s(this.g, Long.valueOf(str2).longValue());
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

    private a0 k() {
        try {
            SoftReference<a0> softReference = p;
            if (softReference == null || softReference.get() == null) {
                p = new SoftReference<>(new a0(m.g, this.b));
            }
            a0 a0Var = o != null ? p.get() : null;
            return a0Var == null ? new a0(m.g, this.b) : a0Var;
        } catch (Throwable th) {
            an.m(th, "ht", "gsf");
            return null;
        }
    }

    private static String l(Map<String, List<String>> map) {
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

    private void m(bl blVar) throws k {
        this.f = new d((byte) 0);
        this.l = blVar.H();
        this.c = blVar.x();
        this.e = blVar.C();
        this.h = blVar.z();
        this.g = blVar.I();
        this.a = q1.a().e(blVar.B());
        String v = blVar.D().b() ? blVar.v() : blVar.u();
        this.i = v;
        this.i = y.a(v, this.g);
        this.j = blVar.s();
        if ("loc".equals(this.g)) {
            String u = blVar.u();
            String v2 = blVar.v();
            if (!TextUtils.isEmpty(u)) {
                try {
                    new URL(u).getHost();
                } catch (Exception unused) {
                }
            }
            if (!TextUtils.isEmpty(v2)) {
                try {
                    if (TextUtils.isEmpty(this.j)) {
                        new URL(v2).getHost();
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    private static boolean o(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x020a A[SYNTHETIC, Splitter:B:111:0x020a] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c9 A[SYNTHETIC, Splitter:B:41:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01e7 A[SYNTHETIC, Splitter:B:99:0x01e7] */
    private b p(bl blVar) throws IOException, k {
        boolean z;
        String str;
        URLConnection a2;
        HttpsURLConnection httpsURLConnection;
        SSLContext sSLContext;
        HttpsURLConnection httpsURLConnection2;
        a0 k2;
        bl.b D;
        String str2;
        String str3;
        f fVar = this.n;
        bl.b D2 = blVar.D();
        c cVar = fVar.c;
        cVar.a = bj.this.d;
        cVar.b = D2;
        fVar.a = SystemClock.elapsedRealtime();
        Map<String, String> b2 = blVar.b();
        if (b2 == null) {
            b2 = new HashMap<>();
        }
        e a3 = this.f.a(this.j);
        int i2 = bg.a;
        String str4 = this.i;
        Uri parse = Uri.parse(str4);
        String host = parse.getHost();
        if (i2 == 1) {
            str = bg.b;
        } else if (i2 != 2) {
            str = "";
        } else {
            HashMap<String, String> hashMap = bg.c;
            str = hashMap != null ? hashMap.get(host) : "";
            z = false;
            if (!TextUtils.isEmpty(str)) {
                blVar.F();
                str4 = parse.buildUpon().encodedAuthority(str).build().toString();
                if (z) {
                    b2.put("targetHost", host);
                    this.m = host;
                }
                if (z && this.a) {
                    a3.b(str);
                }
            }
            this.i = str4;
            URL url = new URL(this.i);
            this.n.d(blVar, url);
            if (o(url.getHost()) && blVar.p()) {
                D = blVar.D();
                str2 = this.n.c.e;
                if (!i(str2) && ((D.b() && m.t) || (D.c() && m.L(str2)))) {
                    try {
                        this.n.b = SystemClock.elapsedRealtime();
                        InetAddress[] allByName = InetAddress.getAllByName(this.n.c.e);
                        if (allByName == null || allByName.length <= 0 || allByName[0] == null) {
                            str3 = "";
                        } else {
                            boolean z2 = m.q() && m.G();
                            "---canUseIpv6---".concat(String.valueOf(z2));
                            if (z2) {
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
                        f fVar2 = this.n;
                        "---onDNSEnd---ip=".concat(String.valueOf(str3));
                        fVar2.c.c = str3.replace(jl1.ARRAY_START_STR, "").replace(jl1.ARRAY_END_STR, "");
                        fVar2.c.g = SystemClock.elapsedRealtime() - fVar2.b;
                        if (!TextUtils.isEmpty(str3)) {
                            Uri parse2 = Uri.parse(this.i);
                            String host2 = parse2.getHost();
                            Uri build = parse2.buildUpon().encodedAuthority(str3).build();
                            this.j = host2;
                            b2.put("host", host2);
                            if (this.a) {
                                a3.c(host2);
                            }
                            this.i = build.toString();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.a) {
                this.i = q1.b(this.i);
            }
            Objects.toString(blVar.D());
            URL url2 = new URL(this.i);
            bg.a aVar = this.e;
            a2 = aVar == null ? aVar.a() : null;
            if (a2 == null) {
                Proxy proxy = this.c;
                a2 = proxy != null ? url2.openConnection(proxy) : url2.openConnection();
            }
            if (!this.a) {
                try {
                    SoftReference<SSLContext> softReference = o;
                    if (softReference == null || softReference.get() == null) {
                        o = new SoftReference<>(SSLContext.getInstance("TLS"));
                    }
                    SoftReference<SSLContext> softReference2 = o;
                    if (softReference2 != null) {
                        sSLContext = softReference2.get();
                        if (sSLContext == null) {
                            try {
                                sSLContext = SSLContext.getInstance("TLS");
                            } catch (Throwable th) {
                                v13.e(th, "ht", "ne");
                            }
                        }
                        sSLContext.init(null, null, null);
                        this.b = sSLContext;
                        httpsURLConnection2 = (HttpsURLConnection) a2;
                        if (m.f.a || (k2 = k()) == null) {
                            httpsURLConnection2.setSSLSocketFactory(this.b.getSocketFactory());
                        } else {
                            httpsURLConnection2.setSSLSocketFactory(k2);
                            k2.b();
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
                httpsURLConnection2 = (HttpsURLConnection) a2;
                if (m.f.a) {
                }
                httpsURLConnection2.setSSLSocketFactory(this.b.getSocketFactory());
                httpsURLConnection2.setHostnameVerifier(a3);
                httpsURLConnection = httpsURLConnection2;
            } else {
                httpsURLConnection = (HttpURLConnection) a2;
            }
            if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
                httpsURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
            }
            int E = (int) (((long) blVar.E()) - (this.n.c.g / 1000));
            g(b2, httpsURLConnection);
            httpsURLConnection.setConnectTimeout(E);
            httpsURLConnection.setReadTimeout(E);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            return new b(httpsURLConnection);
        }
        z = true;
        if (!TextUtils.isEmpty(str)) {
        }
        this.i = str4;
        URL url3 = new URL(this.i);
        this.n.d(blVar, url3);
        D = blVar.D();
        str2 = this.n.c.e;
        if (!i(str2) && ((D.b() && m.t) || (D.c() && m.L(str2)))) {
        }
        if (this.a) {
        }
        Objects.toString(blVar.D());
        URL url22 = new URL(this.i);
        bg.a aVar2 = this.e;
        if (aVar2 == null) {
        }
        if (a2 == null) {
        }
        if (!this.a) {
        }
        httpsURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
        int E2 = (int) (((long) blVar.E()) - (this.n.c.g / 1000));
        g(b2, httpsURLConnection);
        httpsURLConnection.setConnectTimeout(E2);
        httpsURLConnection.setReadTimeout(E2);
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(true);
        return new b(httpsURLConnection);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0093  */
    public final q23 e(bl blVar) throws k {
        SSLException e2;
        ConnectException e3;
        ConnectTimeoutException e4;
        MalformedURLException e5;
        UnknownHostException e6;
        SocketException e7;
        SocketTimeoutException e8;
        IOException e9;
        k e10;
        Throwable th;
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        Throwable th2;
        HttpURLConnection httpURLConnection = null;
        try {
            m(blVar);
            q23 q = y.q(this.i, this.g);
            if (q != null) {
                this.n.i();
                return q;
            }
            b p2 = p(blVar);
            HttpURLConnection httpURLConnection2 = p2.a;
            try {
                this.n.b = SystemClock.elapsedRealtime();
                httpURLConnection2.connect();
                this.n.a();
                byte[] r = blVar.r();
                if (r == null || r.length == 0) {
                    Map<String, String> q2 = blVar.q();
                    HashMap<String, String> hashMap = bg.e;
                    if (hashMap != null) {
                        if (q2 != null) {
                            q2.putAll(hashMap);
                        } else {
                            q2 = hashMap;
                        }
                    }
                    String c2 = c(q2);
                    if (!TextUtils.isEmpty(c2)) {
                        r = v1.p(c2);
                    }
                }
                if (r != null && r.length > 0) {
                    try {
                        this.n.b = SystemClock.elapsedRealtime();
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
                            this.n.f();
                            throw th2;
                        }
                        try {
                            dataOutputStream.write(r);
                            dataOutputStream.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.n.f();
                        } catch (Throwable th4) {
                            th2 = th4;
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            this.n.f();
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
                        this.n.f();
                        throw th2;
                    }
                }
                q23 d2 = d(p2);
                this.n.e(d2);
                try {
                    httpURLConnection2.disconnect();
                } catch (Throwable th6) {
                    v13.e(th6, "ht", "mPt");
                }
                this.n.i();
                return d2;
            } catch (SSLException e11) {
                e2 = e11;
                e2.printStackTrace();
                this.n.g(a(e2));
                this.n.b(4);
                throw new k("IO 操作异常 - IOException");
            } catch (ConnectException e12) {
                e3 = e12;
                e3.printStackTrace();
                this.n.g(a(e3));
                this.n.b(6);
                throw new k(AMapException.ERROR_CONNECTION);
            } catch (ConnectTimeoutException e13) {
                e4 = e13;
                e4.printStackTrace();
                this.n.g(a(e4));
                this.n.b(2);
                throw new k("IO 操作异常 - IOException");
            } catch (MalformedURLException e14) {
                e5 = e14;
                e5.printStackTrace();
                this.n.b(8);
                throw new k("url异常 - MalformedURLException");
            } catch (UnknownHostException e15) {
                e6 = e15;
                e6.printStackTrace();
                this.n.b(5);
                throw new k("未知主机 - UnKnowHostException");
            } catch (SocketException e16) {
                e7 = e16;
                e7.printStackTrace();
                this.n.g(a(e7));
                this.n.b(6);
                throw new k(AMapException.ERROR_SOCKET);
            } catch (SocketTimeoutException e17) {
                e8 = e17;
                e8.printStackTrace();
                this.n.g(a(e8));
                this.n.b(2);
                throw new k("socket 连接超时 - SocketTimeoutException");
            } catch (InterruptedIOException unused) {
                this.n.g(7101);
                this.n.b(7);
                throw new k(AMapException.ERROR_UNKNOWN);
            } catch (IOException e18) {
                e9 = e18;
                e9.printStackTrace();
                this.n.b(7);
                throw new k("IO 操作异常 - IOException");
            } catch (k e19) {
                e10 = e19;
                this.n.b(e10.g());
                v13.e(e10, "ht", "mPt");
                throw e10;
            } catch (Throwable th7) {
                th = th7;
                httpURLConnection = httpURLConnection2;
                v13.e(th, "ht", "mPt");
                this.n.b(9);
                throw new k(AMapException.ERROR_UNKNOWN);
            }
        } catch (SSLException e20) {
            e2 = e20;
            e2.printStackTrace();
            this.n.g(a(e2));
            this.n.b(4);
            throw new k("IO 操作异常 - IOException");
        } catch (ConnectException e21) {
            e3 = e21;
            e3.printStackTrace();
            this.n.g(a(e3));
            this.n.b(6);
            throw new k(AMapException.ERROR_CONNECTION);
        } catch (ConnectTimeoutException e22) {
            e4 = e22;
            e4.printStackTrace();
            this.n.g(a(e4));
            this.n.b(2);
            throw new k("IO 操作异常 - IOException");
        } catch (MalformedURLException e23) {
            e5 = e23;
            e5.printStackTrace();
            this.n.b(8);
            throw new k("url异常 - MalformedURLException");
        } catch (UnknownHostException e24) {
            e6 = e24;
            e6.printStackTrace();
            this.n.b(5);
            throw new k("未知主机 - UnKnowHostException");
        } catch (SocketException e25) {
            e7 = e25;
            e7.printStackTrace();
            this.n.g(a(e7));
            this.n.b(6);
            throw new k(AMapException.ERROR_SOCKET);
        } catch (SocketTimeoutException e26) {
            e8 = e26;
            e8.printStackTrace();
            this.n.g(a(e8));
            this.n.b(2);
            throw new k("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused2) {
            this.n.g(7101);
            this.n.b(7);
            throw new k(AMapException.ERROR_UNKNOWN);
        } catch (IOException e27) {
            e9 = e27;
            e9.printStackTrace();
            this.n.b(7);
            throw new k("IO 操作异常 - IOException");
        } catch (k e28) {
            e10 = e28;
            if (!e10.i() && e10.g() != 10) {
                this.n.b(e10.g());
            }
            v13.e(e10, "ht", "mPt");
            throw e10;
        } catch (Throwable th8) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th9) {
                    v13.e(th9, "ht", "mPt");
                }
            }
            this.n.i();
            throw th8;
        }
    }
}
