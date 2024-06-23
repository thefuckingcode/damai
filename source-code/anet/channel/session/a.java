package anet.channel.session;

import android.net.Network;
import android.os.Build;
import android.util.Pair;
import anet.channel.RequestCb;
import anet.channel.request.a;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import mtopsdk.network.util.Constants;
import org.apache.http.conn.ConnectTimeoutException;
import tb.ag2;
import tb.fe0;
import tb.h42;
import tb.ov1;
import tb.pd;
import tb.rd;
import tb.ry0;
import tb.w6;
import tb.wy0;
import tb.yy0;

/* compiled from: Taobao */
public class a {

    /* access modifiers changed from: package-private */
    /* renamed from: anet.channel.session.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0003a implements HostnameVerifier {
        final /* synthetic */ String a;

        C0003a(String str) {
            this.a = str;
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, sSLSession);
        }
    }

    /* compiled from: Taobao */
    public static class b {
        public int a;
        public Map<String, List<String>> b;
        public int c;
        public boolean d;
    }

    public static b a(anet.channel.request.a aVar) {
        return d(aVar, null, false);
    }

    public static void b(anet.channel.request.a aVar, RequestCb requestCb) {
        d(aVar, requestCb, false);
    }

    public static void c(anet.channel.request.a aVar, RequestCb requestCb, boolean z) {
        d(aVar, requestCb, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0314, code lost:
        tb.h42.a().c(r12.h());
        f(r12, r10, r1, tb.fe0.ERROR_HOST_NOT_VERIFY_ERROR, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0325, code lost:
        f(r12, r10, r1, -101, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x033d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x033e, code lost:
        anet.channel.util.ALog.d("awcn.HttpConnector", "http disconnect", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0347, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0371, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0372, code lost:
        anet.channel.util.ALog.d("awcn.HttpConnector", "http disconnect", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x037c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0396, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0397, code lost:
        anet.channel.util.ALog.d("awcn.HttpConnector", "http disconnect", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x03a0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x03a1, code lost:
        r18 = r3;
        r19 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03a5, code lost:
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x03d4, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", r11, r12.n(), r19, ((javax.net.ssl.HttpsURLConnection) r13).getSSLSocketFactory(), r18, ((javax.net.ssl.HttpsURLConnection) r13).getHostnameVerifier());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x03ff, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0400, code lost:
        anet.channel.util.ALog.d("awcn.HttpConnector", "http disconnect", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x040a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x040b, code lost:
        r18 = r3;
        r19 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x040f, code lost:
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x043e, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", r11, r12.n(), r19, ((javax.net.ssl.HttpsURLConnection) r13).getSSLSocketFactory(), r18, ((javax.net.ssl.HttpsURLConnection) r13).getHostnameVerifier());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0469, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x046a, code lost:
        anet.channel.util.ALog.d("awcn.HttpConnector", "http disconnect", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0474, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0091, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0491, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0492, code lost:
        anet.channel.util.ALog.d("awcn.HttpConnector", "http disconnect", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x049c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x04b8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0092, code lost:
        r2 = r0;
        r18 = r3;
        r19 = r4;
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x04b9, code lost:
        anet.channel.util.ALog.d("awcn.HttpConnector", "http disconnect", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x04c2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x04de, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04df, code lost:
        anet.channel.util.ALog.d("awcn.HttpConnector", "http disconnect", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x04e8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x009a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009b, code lost:
        r2 = r0;
        r18 = r3;
        r19 = r4;
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02f6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02f9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0300, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0308, code lost:
        r7 = r0.getMessage();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0314 A[Catch:{ all -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0325 A[Catch:{ all -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0338 A[SYNTHETIC, Splitter:B:105:0x0338] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0347 A[ExcHandler: IOException (e java.io.IOException), PHI: r13 
      PHI: (r13v21 java.net.HttpURLConnection) = (r13v1 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection) binds: [B:9:0x0036, B:10:?, B:19:0x00b6, B:20:?, B:22:0x00bb, B:23:?, B:12:0x0040, B:13:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x036c A[SYNTHETIC, Splitter:B:112:0x036c] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x037c A[ExcHandler: CancellationException (e java.util.concurrent.CancellationException), PHI: r13 
      PHI: (r13v19 java.net.HttpURLConnection) = (r13v1 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection) binds: [B:9:0x0036, B:10:?, B:19:0x00b6, B:20:?, B:22:0x00bb, B:23:?, B:12:0x0040, B:13:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0391 A[SYNTHETIC, Splitter:B:119:0x0391] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x03d4  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x03fa A[SYNTHETIC, Splitter:B:131:0x03fa] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0464 A[SYNTHETIC, Splitter:B:143:0x0464] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0474 A[ExcHandler: ConnectException (e java.net.ConnectException), PHI: r13 
      PHI: (r13v9 java.net.HttpURLConnection) = (r13v1 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection) binds: [B:9:0x0036, B:10:?, B:19:0x00b6, B:20:?, B:22:0x00bb, B:23:?, B:12:0x0040, B:13:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x048c A[SYNTHETIC, Splitter:B:150:0x048c] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x049c A[ExcHandler: ConnectTimeoutException (e org.apache.http.conn.ConnectTimeoutException), PHI: r13 
      PHI: (r13v7 java.net.HttpURLConnection) = (r13v1 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection) binds: [B:9:0x0036, B:10:?, B:19:0x00b6, B:20:?, B:22:0x00bb, B:23:?, B:12:0x0040, B:13:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x04b4 A[SYNTHETIC, Splitter:B:157:0x04b4] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x04c2 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), PHI: r13 
      PHI: (r13v5 java.net.HttpURLConnection) = (r13v1 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection) binds: [B:9:0x0036, B:10:?, B:19:0x00b6, B:20:?, B:22:0x00bb, B:23:?, B:12:0x0040, B:13:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x04da A[SYNTHETIC, Splitter:B:164:0x04da] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x04e8 A[ExcHandler: UnknownHostException (e java.net.UnknownHostException), PHI: r13 
      PHI: (r13v3 java.net.HttpURLConnection) = (r13v1 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection) binds: [B:9:0x0036, B:10:?, B:19:0x00b6, B:20:?, B:22:0x00bb, B:23:?, B:12:0x0040, B:13:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0300 A[ExcHandler: Exception (e java.lang.Exception), PHI: r13 
      PHI: (r13v23 java.net.HttpURLConnection) = (r13v1 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection), (r13v24 java.net.HttpURLConnection) binds: [B:9:0x0036, B:10:?, B:19:0x00b6, B:20:?, B:22:0x00bb, B:23:?, B:12:0x0040, B:13:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0308 A[Catch:{ all -> 0x02fc }] */
    private static b d(anet.channel.request.a aVar, RequestCb requestCb, boolean z) {
        SSLHandshakeException e;
        SSLException e2;
        RequestCb requestCb2;
        int i;
        String d;
        RequestCb requestCb3 = requestCb;
        String str = Constants.Protocol.CONTENT_ENCODING;
        String str2 = "hostnameVerifier";
        String str3 = "sslSocketFactory";
        String str4 = "SSL Error Info.";
        String str5 = "";
        b bVar = new b();
        Throwable th = null;
        if (aVar == null || aVar.p() == null) {
            if (requestCb3 != null) {
                requestCb3.onFinish(-102, fe0.b(-102), new RequestStatistic(null, null));
            }
            return bVar;
        }
        anet.channel.request.a aVar2 = aVar;
        HttpURLConnection httpURLConnection = null;
        while (true) {
            if (!NetworkStatusHelper.n()) {
                f(aVar2, bVar, requestCb3, -200, th);
                break;
            }
            try {
                httpURLConnection = e(aVar2, z);
                if (ALog.g(2)) {
                    ALog.f("awcn.HttpConnector", str5, aVar2.n(), "request URL", httpURLConnection.getURL().toString());
                    ALog.f("awcn.HttpConnector", str5, aVar2.n(), "request Method", httpURLConnection.getRequestMethod());
                    ALog.f("awcn.HttpConnector", str5, aVar2.n(), "request headers", httpURLConnection.getRequestProperties().toString());
                }
                String str6 = str2;
                String str7 = str3;
                aVar2.r.reqHeadDeflateSize = (long) httpURLConnection.getRequestProperties().toString().length();
                RequestStatistic requestStatistic = aVar2.r;
                String str8 = str4;
                requestStatistic.reqHeadInflateSize = requestStatistic.reqHeadDeflateSize;
                aVar2.r.sendStart = System.currentTimeMillis();
                anet.channel.fulltrace.a.f().log(aVar2.r.span, "netReqSendStart", "type=HttpURLConnection");
                RequestStatistic requestStatistic2 = aVar2.r;
                try {
                    requestStatistic2.processTime = requestStatistic2.sendStart - aVar2.r.start;
                    httpURLConnection.connect();
                    h(httpURLConnection, aVar2);
                    aVar2.r.sendEnd = System.currentTimeMillis();
                    RequestStatistic requestStatistic3 = aVar2.r;
                    requestStatistic3.sendDataTime = requestStatistic3.sendEnd - aVar2.r.sendStart;
                    bVar.a = httpURLConnection.getResponseCode();
                    bVar.b = ry0.b(httpURLConnection.getHeaderFields());
                    ALog.f("awcn.HttpConnector", str5, aVar2.n(), "response code", Integer.valueOf(bVar.a));
                    ALog.f("awcn.HttpConnector", str5, aVar2.n(), "response headers", bVar.b);
                    if (!ry0.a(aVar2, bVar.a) || (d = ry0.d(bVar.b, "Location")) == null) {
                        break;
                    }
                    yy0 g = yy0.g(d);
                    if (g == null) {
                        ALog.e("awcn.HttpConnector", "redirect url is invalid!", aVar2.n(), "redirect url", d);
                        break;
                    }
                    ALog.f("awcn.HttpConnector", "redirect", aVar2.n(), "to url", g.toString());
                    aVar2 = aVar2.u().R("GET").M(null).a0(g).V(aVar2.m() + 1).Y(null).Q(null).J();
                    aVar2.r.recordRedirect(bVar.a, g.l());
                    aVar2.r.locationUrl = d;
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e3) {
                        ALog.d("awcn.HttpConnector", "http disconnect", null, e3, new Object[0]);
                    }
                    requestCb3 = requestCb;
                    str4 = str8;
                    str2 = str6;
                    str3 = str7;
                    str = str;
                    th = null;
                } catch (UnknownHostException e4) {
                    UnknownHostException e5 = e4;
                    requestCb3 = requestCb;
                    f(aVar2, bVar, requestCb3, fe0.ERROR_UNKNOWN_HOST_EXCEPTION, e5);
                    ALog.e("awcn.HttpConnector", "Unknown Host Exception", aVar2.n(), "host", aVar2.h(), e5);
                    NetworkStatusHelper.r();
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e6) {
                            ALog.d("awcn.HttpConnector", "http disconnect", null, e6, new Object[0]);
                        }
                    }
                    return bVar;
                } catch (SocketTimeoutException e7) {
                    SocketTimeoutException e8 = e7;
                    requestCb3 = requestCb;
                    f(aVar2, bVar, requestCb3, fe0.ERROR_SOCKET_TIME_OUT, e8);
                    ALog.d("awcn.HttpConnector", "HTTP Socket Timeout", aVar2.n(), e8, new Object[0]);
                    NetworkStatusHelper.r();
                    if (httpURLConnection != null) {
                    }
                    return bVar;
                } catch (ConnectTimeoutException e9) {
                    ConnectTimeoutException e10 = e9;
                    requestCb3 = requestCb;
                    f(aVar2, bVar, requestCb3, -400, e10);
                    ALog.d("awcn.HttpConnector", "HTTP Connect Timeout", aVar2.n(), e10, new Object[0]);
                    NetworkStatusHelper.r();
                    if (httpURLConnection != null) {
                    }
                    return bVar;
                } catch (ConnectException e11) {
                    ConnectException e12 = e11;
                    requestCb3 = requestCb;
                    f(aVar2, bVar, requestCb3, fe0.ERROR_CONNECT_EXCEPTION, e12);
                    ALog.d("awcn.HttpConnector", "HTTP Connect Exception", aVar2.n(), e12, new Object[0]);
                    NetworkStatusHelper.r();
                    if (httpURLConnection != null) {
                    }
                    return bVar;
                } catch (SSLHandshakeException e13) {
                    e = e13;
                    requestCb3 = requestCb;
                    SSLHandshakeException sSLHandshakeException = e;
                    h42.a().c(aVar2.h());
                    f(aVar2, bVar, requestCb3, fe0.ERROR_SSL_ERROR, sSLHandshakeException);
                    ALog.e("awcn.HttpConnector", "HTTP Connect SSLHandshakeException", aVar2.n(), "host", aVar2.h(), sSLHandshakeException);
                    if (httpURLConnection instanceof HttpsURLConnection) {
                    }
                    if (httpURLConnection != null) {
                    }
                    return bVar;
                } catch (SSLException e14) {
                    e2 = e14;
                    requestCb3 = requestCb;
                    SSLException sSLException = e2;
                    h42.a().c(aVar2.h());
                    f(aVar2, bVar, requestCb3, fe0.ERROR_SSL_ERROR, sSLException);
                    ALog.e("awcn.HttpConnector", "connect SSLException", aVar2.n(), "host", aVar2.h(), sSLException);
                    if (httpURLConnection instanceof HttpsURLConnection) {
                    }
                    if (httpURLConnection != null) {
                    }
                    return bVar;
                } catch (CancellationException e15) {
                    CancellationException e16 = e15;
                    requestCb3 = requestCb;
                    f(aVar2, bVar, requestCb3, fe0.ERROR_REQUEST_CANCEL, e16);
                    ALog.d("awcn.HttpConnector", "HTTP Request Cancel", aVar2.n(), e16, new Object[0]);
                    if (httpURLConnection != null) {
                    }
                    return bVar;
                } catch (IOException e17) {
                    IOException e18 = e17;
                    requestCb3 = requestCb;
                    f(aVar2, bVar, requestCb3, fe0.ERROR_IO_EXCEPTION, e18);
                    ALog.e("awcn.HttpConnector", "IO Exception", aVar2.n(), "host", aVar2.h(), e18);
                    NetworkStatusHelper.r();
                    if (httpURLConnection != null) {
                    }
                    return bVar;
                } catch (Exception e19) {
                    Exception e20 = e19;
                    requestCb3 = requestCb;
                    try {
                        if (e20.getMessage() != null) {
                        }
                        if (!str5.contains("not verified")) {
                        }
                        ALog.d("awcn.HttpConnector", "HTTP Exception", aVar2.n(), e20, new Object[0]);
                        if (httpURLConnection != null) {
                        }
                        return bVar;
                    } catch (Throwable th2) {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception e21) {
                                ALog.d("awcn.HttpConnector", "http disconnect", null, e21, new Object[0]);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (UnknownHostException e22) {
            } catch (SocketTimeoutException e23) {
            } catch (ConnectTimeoutException e24) {
            } catch (ConnectException e25) {
            } catch (SSLHandshakeException e26) {
                e = e26;
                SSLHandshakeException sSLHandshakeException2 = e;
                h42.a().c(aVar2.h());
                f(aVar2, bVar, requestCb3, fe0.ERROR_SSL_ERROR, sSLHandshakeException2);
                ALog.e("awcn.HttpConnector", "HTTP Connect SSLHandshakeException", aVar2.n(), "host", aVar2.h(), sSLHandshakeException2);
                if (httpURLConnection instanceof HttpsURLConnection) {
                }
                if (httpURLConnection != null) {
                }
                return bVar;
            } catch (SSLException e27) {
                e2 = e27;
                SSLException sSLException2 = e2;
                h42.a().c(aVar2.h());
                f(aVar2, bVar, requestCb3, fe0.ERROR_SSL_ERROR, sSLException2);
                ALog.e("awcn.HttpConnector", "connect SSLException", aVar2.n(), "host", aVar2.h(), sSLException2);
                if (httpURLConnection instanceof HttpsURLConnection) {
                }
                if (httpURLConnection != null) {
                }
                return bVar;
            } catch (CancellationException e28) {
            } catch (IOException e29) {
            } catch (Exception e30) {
            }
        }
        aVar2.r.contentEncoding = ry0.d(bVar.b, str);
        aVar2.r.contentType = ry0.d(bVar.b, "Content-Type");
        if (a.c.HEAD.equals(aVar2.k()) || (i = bVar.a) == 304 || i == 204 || (i >= 100 && i < 200)) {
            requestCb2 = requestCb;
            if (requestCb2 != null) {
                requestCb2.onResponseCode(bVar.a, bVar.b);
            }
            aVar2.r.rspStart = System.currentTimeMillis();
        } else {
            int f = ry0.f(bVar.b);
            bVar.c = f;
            aVar2.r.contentLength = (long) f;
            boolean equalsIgnoreCase = "gzip".equalsIgnoreCase(aVar2.r.contentEncoding);
            bVar.d = equalsIgnoreCase;
            if (equalsIgnoreCase) {
                bVar.b.remove(str);
                bVar.b.remove(Constants.Protocol.CONTENT_LENGTH);
            }
            requestCb2 = requestCb;
            if (requestCb2 != null) {
                requestCb2.onResponseCode(bVar.a, bVar.b);
            }
            aVar2.r.rspStart = System.currentTimeMillis();
            g(httpURLConnection, aVar2, bVar, requestCb2);
        }
        RequestStatistic requestStatistic4 = aVar2.r;
        requestStatistic4.firstDataTime = requestStatistic4.rspStart - aVar2.r.sendEnd;
        aVar2.r.rspHeadDeflateSize = (long) bVar.b.toString().length();
        RequestStatistic requestStatistic5 = aVar2.r;
        requestStatistic5.rspHeadInflateSize = requestStatistic5.rspHeadDeflateSize;
        if (!aVar2.r.isDone.get()) {
            aVar2.r.ret = 1;
            aVar2.r.statusCode = bVar.a;
            aVar2.r.msg = "SUCCESS";
            aVar2.r.rspEnd = System.currentTimeMillis();
            anet.channel.fulltrace.a.f().log(aVar2.r.span, "netRspRecvEnd", null);
        }
        if (requestCb2 != null) {
            requestCb2.onFinish(bVar.a, "SUCCESS", aVar2.r);
        }
        try {
            httpURLConnection.disconnect();
        } catch (Exception e31) {
            ALog.d("awcn.HttpConnector", "http disconnect", null, e31, new Object[0]);
        }
        return bVar;
    }

    private static HttpURLConnection e(anet.channel.request.a aVar, boolean z) throws IOException {
        HttpURLConnection httpURLConnection;
        Pair<String, Integer> l = NetworkStatusHelper.l();
        Proxy proxy = l != null ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) l.first, ((Integer) l.second).intValue())) : null;
        ov1.a();
        NetworkStatusHelper.i().isMobile();
        URL p = aVar.p();
        Network d = NetworkStatusHelper.d();
        if (z && d != null && Build.VERSION.SDK_INT >= 23) {
            ALog.e("awcn.HttpConnector", "openConnection by cellular", aVar.n(), new Object[0]);
            if (proxy != null) {
                httpURLConnection = (HttpURLConnection) d.openConnection(p, proxy);
            } else {
                httpURLConnection = (HttpURLConnection) d.openConnection(p);
            }
        } else if (proxy != null) {
            httpURLConnection = (HttpURLConnection) p.openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) p.openConnection();
        }
        httpURLConnection.setConnectTimeout(aVar.e());
        httpURLConnection.setReadTimeout(aVar.l());
        httpURLConnection.setRequestMethod(aVar.k());
        if (aVar.a()) {
            httpURLConnection.setDoOutput(true);
        }
        Map<String, String> g = aVar.g();
        for (Map.Entry<String, String> entry : g.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        String str = g.get(BizTime.HOST);
        if (str == null) {
            str = aVar.h();
        }
        String e = aVar.j().a() ? ag2.e(str, ":", String.valueOf(aVar.j().c())) : str;
        httpURLConnection.setRequestProperty(BizTime.HOST, e);
        if (NetworkStatusHelper.b().equals("cmwap")) {
            httpURLConnection.setRequestProperty("x-online-host", e);
        }
        if (!g.containsKey("Accept-Encoding")) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        }
        if (p.getProtocol().equalsIgnoreCase("https")) {
            i(httpURLConnection, aVar, str);
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }

    private static void f(anet.channel.request.a aVar, b bVar, RequestCb requestCb, int i, Throwable th) {
        String b2 = fe0.b(i);
        ALog.e("awcn.HttpConnector", "onException", aVar.n(), "errorCode", Integer.valueOf(i), "errMsg", b2, "url", aVar.q(), "host", aVar.h());
        if (bVar != null) {
            bVar.a = i;
        }
        if (!aVar.r.isDone.get()) {
            aVar.r.statusCode = i;
            aVar.r.msg = b2;
            aVar.r.rspEnd = System.currentTimeMillis();
            anet.channel.fulltrace.a.f().log(aVar.r.span, "netRspRecvEnd", null);
            if (i != -204) {
                w6.b().commitStat(new ExceptionStatistic(i, b2, aVar.r, th));
            }
        }
        if (requestCb != null) {
            requestCb.onFinish(i, b2, aVar.r);
        }
    }

    private static void g(HttpURLConnection httpURLConnection, anet.channel.request.a aVar, b bVar, RequestCb requestCb) throws IOException, CancellationException {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        httpURLConnection.getURL().toString();
        anet.channel.util.a aVar2 = null;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                ALog.k("awcn.HttpConnector", "File not found", aVar.n(), "url", aVar.q());
            }
            try {
                inputStream = httpURLConnection.getErrorStream();
            } catch (Exception e2) {
                ALog.d("awcn.HttpConnector", "get error stream failed.", aVar.n(), e2, new Object[0]);
                inputStream = null;
            }
        }
        if (inputStream == null) {
            f(aVar, bVar, requestCb, fe0.ERROR_IO_EXCEPTION, null);
            return;
        }
        if (requestCb == null) {
            int i = bVar.c;
            if (i <= 0) {
                i = 1024;
            } else if (bVar.d) {
                i *= 2;
            }
            byteArrayOutputStream = new ByteArrayOutputStream(i);
        } else {
            byteArrayOutputStream = null;
        }
        try {
            anet.channel.util.a aVar3 = new anet.channel.util.a(inputStream);
            try {
                InputStream gZIPInputStream = bVar.d ? new GZIPInputStream(aVar3) : aVar3;
                pd pdVar = null;
                while (!Thread.currentThread().isInterrupted()) {
                    if (pdVar == null) {
                        pdVar = rd.a().c(2048);
                    }
                    int e3 = pdVar.e(gZIPInputStream);
                    if (e3 != -1) {
                        if (byteArrayOutputStream != null) {
                            pdVar.i(byteArrayOutputStream);
                        } else {
                            requestCb.onDataReceive(pdVar, false);
                            pdVar = null;
                        }
                        long j = (long) e3;
                        aVar.r.recDataSize += j;
                        aVar.r.rspBodyInflateSize += j;
                    } else {
                        if (byteArrayOutputStream != null) {
                            pdVar.f();
                        } else {
                            requestCb.onDataReceive(pdVar, true);
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.toByteArray();
                        }
                        aVar.r.recDataTime = System.currentTimeMillis() - aVar.r.rspStart;
                        aVar.r.rspBodyDeflateSize = aVar3.a();
                        try {
                            gZIPInputStream.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                }
                throw new CancellationException("task cancelled");
            } catch (Throwable th2) {
                th = th2;
                aVar2 = aVar3;
                aVar.r.recDataTime = System.currentTimeMillis() - aVar.r.rspStart;
                aVar.r.rspBodyDeflateSize = aVar2.a();
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            aVar.r.recDataTime = System.currentTimeMillis() - aVar.r.rspStart;
            aVar.r.rspBodyDeflateSize = aVar2.a();
            inputStream.close();
            throw th;
        }
    }

    private static int h(HttpURLConnection httpURLConnection, anet.channel.request.a aVar) {
        int i = 0;
        if (aVar.a()) {
            OutputStream outputStream = null;
            try {
                outputStream = httpURLConnection.getOutputStream();
                int v = aVar.v(outputStream);
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e) {
                        ALog.d("awcn.HttpConnector", "postData", aVar.n(), e, new Object[0]);
                    }
                }
                i = v;
            } catch (Exception e2) {
                ALog.d("awcn.HttpConnector", "postData error", aVar.n(), e2, new Object[0]);
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e3) {
                        ALog.d("awcn.HttpConnector", "postData", aVar.n(), e3, new Object[0]);
                    }
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e4) {
                        ALog.d("awcn.HttpConnector", "postData", aVar.n(), e4, new Object[0]);
                    }
                }
                throw th;
            }
            long j = (long) i;
            aVar.r.reqBodyInflateSize = j;
            aVar.r.reqBodyDeflateSize = j;
            aVar.r.sendDataSize = j;
        }
        return i;
    }

    private static void i(HttpURLConnection httpURLConnection, anet.channel.request.a aVar, String str) {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            ALog.e("awcn.HttpConnector", "supportHttps", "[supportHttps]Froyo 以下版本不支持https", new Object[0]);
            return;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        if (aVar.o() != null) {
            httpsURLConnection.setSSLSocketFactory(aVar.o());
        } else if (wy0.b() != null) {
            httpsURLConnection.setSSLSocketFactory(wy0.b());
            if (ALog.g(2)) {
                ALog.f("awcn.HttpConnector", "HttpSslUtil", aVar.n(), "SslSocketFactory", wy0.b());
            }
        }
        if (aVar.i() != null) {
            httpsURLConnection.setHostnameVerifier(aVar.i());
        } else if (wy0.a() != null) {
            httpsURLConnection.setHostnameVerifier(wy0.a());
            if (ALog.g(2)) {
                ALog.f("awcn.HttpConnector", "HttpSslUtil", aVar.n(), "HostnameVerifier", wy0.a());
            }
        } else {
            httpsURLConnection.setHostnameVerifier(new C0003a(str));
        }
    }
}
