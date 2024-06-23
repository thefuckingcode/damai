package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.youku.android.liveservice.LivePlayerController;
import com.youku.network.HttpIntent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import mtopsdk.network.util.Constants;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* compiled from: Taobao */
public final class q implements Callable<u> {
    public static final HttpRequestRetryHandler e = new ad();
    public l a;
    public Context b;
    public o c;
    public String d;
    public HttpUriRequest f;
    public HttpContext g = new BasicHttpContext();
    public CookieStore h = new BasicCookieStore();
    public CookieManager i;
    public AbstractHttpEntity j;
    public HttpHost k;
    public URL l;
    public int m = 0;
    public boolean n = false;
    public boolean o = false;
    public String p = null;
    public String q;

    public q(l lVar, o oVar) {
        this.a = lVar;
        this.b = lVar.a;
        this.c = oVar;
    }

    public static long a(String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if ("max-age".equalsIgnoreCase(strArr[i2])) {
                int i3 = i2 + 1;
                if (strArr[i3] != null) {
                    try {
                        return Long.parseLong(strArr[i3]);
                    } catch (Exception unused) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return 0;
    }

    public static HttpUrlHeader a(HttpResponse httpResponse) {
        HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
        Header[] allHeaders = httpResponse.getAllHeaders();
        for (Header header : allHeaders) {
            httpUrlHeader.setHead(header.getName(), header.getValue());
        }
        return httpUrlHeader;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x009f A[SYNTHETIC, Splitter:B:23:0x009f] */
    private u a(HttpResponse httpResponse, int i2, String str) {
        Throwable th;
        String str2;
        Thread.currentThread().getId();
        HttpEntity entity = httpResponse.getEntity();
        ByteArrayOutputStream byteArrayOutputStream = null;
        String str3 = null;
        if (entity != null && httpResponse.getStatusLine().getStatusCode() == 200) {
            Thread.currentThread().getId();
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    a(entity, byteArrayOutputStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    this.o = false;
                    this.a.c(System.currentTimeMillis() - currentTimeMillis);
                    this.a.a((long) byteArray.length);
                    p pVar = new p(a(httpResponse), i2, str, byteArray);
                    long b2 = b(httpResponse);
                    Header contentType = httpResponse.getEntity().getContentType();
                    if (contentType != null) {
                        HashMap<String, String> a2 = a(contentType.getValue());
                        str3 = a2.get("charset");
                        str2 = a2.get("Content-Type");
                    } else {
                        str2 = null;
                    }
                    pVar.b(str2);
                    pVar.a(str3);
                    pVar.a(System.currentTimeMillis());
                    pVar.b(b2);
                    try {
                        byteArrayOutputStream2.close();
                        return pVar;
                    } catch (IOException e2) {
                        throw new RuntimeException("ArrayOutputStream close error!", e2.getCause());
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            throw new RuntimeException("ArrayOutputStream close error!", e3.getCause());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        } else if (entity != null) {
            return null;
        } else {
            httpResponse.getStatusLine().getStatusCode();
            return null;
        }
    }

    public static HashMap<String, String> a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split = str.split(";");
        for (String str2 : split) {
            String[] split2 = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
            hashMap.put(split2[0], split2[1]);
        }
        return hashMap;
    }

    private void a(HttpEntity httpEntity, OutputStream outputStream) {
        InputStream a2 = b.a(httpEntity);
        httpEntity.getContentLength();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = a2.read(bArr);
                if (read == -1 || this.c.h()) {
                    outputStream.flush();
                } else {
                    outputStream.write(bArr, 0, read);
                    this.c.f();
                }
            }
            outputStream.flush();
            r.a(a2);
        } catch (Exception e2) {
            e2.getCause();
            throw new IOException("HttpWorker Request Error!" + e2.getLocalizedMessage());
        } catch (Throwable th) {
            r.a(a2);
            throw th;
        }
    }

    public static long b(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split = firstHeader.getValue().split("=");
            if (split.length >= 2) {
                try {
                    return a(split);
                } catch (NumberFormatException unused) {
                }
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader("Expires");
        if (firstHeader2 != null) {
            return b.b(firstHeader2.getValue()) - System.currentTimeMillis();
        }
        return 0;
    }

    private URI b() {
        String a2 = this.c.a();
        String str = this.d;
        if (str != null) {
            a2 = str;
        }
        if (a2 != null) {
            return new URI(a2);
        }
        throw new RuntimeException("url should not be null");
    }

    private HttpUriRequest c() {
        HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        if (this.j == null) {
            byte[] b2 = this.c.b();
            String b3 = this.c.b("gzip");
            if (b2 != null) {
                if (TextUtils.equals(b3, "true")) {
                    this.j = b.a(b2);
                } else {
                    this.j = new ByteArrayEntity(b2);
                }
                this.j.setContentType(this.c.c());
            }
        }
        AbstractHttpEntity abstractHttpEntity = this.j;
        if (abstractHttpEntity != null) {
            HttpPost httpPost = new HttpPost(b());
            httpPost.setEntity(abstractHttpEntity);
            this.f = httpPost;
        } else {
            this.f = new HttpGet(b());
        }
        return this.f;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[Catch:{ HttpException -> 0x03c7, URISyntaxException -> 0x03ba, SSLHandshakeException -> 0x039a, SSLPeerUnverifiedException -> 0x037a, SSLException -> 0x035a, ConnectionPoolTimeoutException -> 0x033a, ConnectTimeoutException -> 0x031a, SocketTimeoutException -> 0x02f9, NoHttpResponseException -> 0x02d8, HttpHostConnectException -> 0x02b9, UnknownHostException -> 0x0297, IOException -> 0x0277, NullPointerException -> 0x0258, Exception -> 0x023b }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x022f  */
    /* renamed from: d */
    public u call() {
        boolean z;
        HttpHost httpHost;
        HttpHost httpHost2;
        List<Cookie> cookies;
        int statusCode;
        u a2;
        while (true) {
            try {
                NetworkInfo[] allNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getAllNetworkInfo();
                boolean z2 = true;
                if (allNetworkInfo != null) {
                    int length = allNetworkInfo.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        NetworkInfo networkInfo = allNetworkInfo[i2];
                        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting()) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                    if (!z) {
                        ArrayList<Header> d2 = this.c.d();
                        if (d2 != null && !d2.isEmpty()) {
                            Iterator<Header> it = d2.iterator();
                            while (it.hasNext()) {
                                c().addHeader(it.next());
                            }
                        }
                        b.a((HttpRequest) c());
                        b.b((HttpRequest) c());
                        c().addHeader(HttpIntent.COOKIE, i().getCookie(this.c.a()));
                        this.g.setAttribute("http.cookie-store", this.h);
                        this.a.a().a(e);
                        long currentTimeMillis = System.currentTimeMillis();
                        f();
                        this.f.getURI().toString();
                        HttpParams params = this.a.a().getParams();
                        NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo((ConnectivityManager) this.b.getSystemService("connectivity"));
                        HttpHost httpHost3 = null;
                        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                            String defaultHost = Proxy.getDefaultHost();
                            int defaultPort = Proxy.getDefaultPort();
                            if (defaultHost != null) {
                                httpHost = new HttpHost(defaultHost, defaultPort);
                                if (httpHost == null || !TextUtils.equals(httpHost.getHostName(), LivePlayerController.CLIENT_IP) || httpHost.getPort() != 8087) {
                                    httpHost3 = httpHost;
                                }
                                params.setParameter("http.route.default-proxy", httpHost3);
                                httpHost2 = this.k;
                                if (httpHost2 == null) {
                                    URL h2 = h();
                                    HttpHost httpHost4 = new HttpHost(h2.getHost(), g(), h2.getProtocol());
                                    this.k = httpHost4;
                                    httpHost2 = httpHost4;
                                }
                                if (g() == 80) {
                                    httpHost2 = new HttpHost(h().getHost());
                                }
                                HttpResponse execute = this.a.a().execute(httpHost2, (HttpRequest) this.f, this.g);
                                this.a.b(System.currentTimeMillis() - currentTimeMillis);
                                cookies = this.h.getCookies();
                                if (this.c.e()) {
                                    i().removeAllCookie();
                                }
                                if (!cookies.isEmpty()) {
                                    for (Cookie cookie : cookies) {
                                        if (cookie.getDomain() != null) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(cookie.getName());
                                            sb.append("=");
                                            sb.append(cookie.getValue());
                                            sb.append("; domain=");
                                            sb.append(cookie.getDomain());
                                            sb.append(cookie.isSecure() ? "; Secure" : "");
                                            i().setCookie(this.c.a(), sb.toString());
                                            CookieSyncManager.getInstance().sync();
                                        }
                                    }
                                }
                                statusCode = execute.getStatusLine().getStatusCode();
                                String reasonPhrase = execute.getStatusLine().getReasonPhrase();
                                if (statusCode != 200) {
                                    if (statusCode != 304) {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        throw new HttpException(Integer.valueOf(execute.getStatusLine().getStatusCode()), execute.getStatusLine().getReasonPhrase());
                                    }
                                }
                                a2 = a(execute, statusCode, reasonPhrase);
                                if (((a2 != null || a2.b() == null) ? -1 : (long) a2.b().length) == -1 && (a2 instanceof p)) {
                                    Long.parseLong(((p) a2).a().getHead(Constants.Protocol.CONTENT_LENGTH));
                                }
                                if (this.c.a() != null && !TextUtils.isEmpty(f())) {
                                    f();
                                }
                                return a2;
                            }
                        }
                        httpHost = null;
                        httpHost3 = httpHost;
                        params.setParameter("http.route.default-proxy", httpHost3);
                        httpHost2 = this.k;
                        if (httpHost2 == null) {
                        }
                        if (g() == 80) {
                        }
                        HttpResponse execute2 = this.a.a().execute(httpHost2, (HttpRequest) this.f, this.g);
                        this.a.b(System.currentTimeMillis() - currentTimeMillis);
                        cookies = this.h.getCookies();
                        if (this.c.e()) {
                        }
                        if (!cookies.isEmpty()) {
                        }
                        statusCode = execute2.getStatusLine().getStatusCode();
                        String reasonPhrase2 = execute2.getStatusLine().getReasonPhrase();
                        if (statusCode != 200) {
                        }
                        a2 = a(execute2, statusCode, reasonPhrase2);
                        try {
                            Long.parseLong(((p) a2).a().getHead(Constants.Protocol.CONTENT_LENGTH));
                        } catch (Exception unused) {
                        }
                        f();
                        return a2;
                    }
                    throw new HttpException(1, "The network is not available");
                }
                z = false;
                if (!z) {
                }
            } catch (HttpException e2) {
                e();
                if (this.c.f() != null) {
                    e2.getCode();
                    e2.getMsg();
                }
                e2.toString();
                throw e2;
            } catch (URISyntaxException e3) {
                throw new RuntimeException("Url parser error!", e3.getCause());
            } catch (SSLHandshakeException e4) {
                e();
                if (this.c.f() != null) {
                    e4.toString();
                }
                e4.toString();
                throw new HttpException(2, String.valueOf(e4));
            } catch (SSLPeerUnverifiedException e5) {
                e();
                if (this.c.f() != null) {
                    e5.toString();
                }
                e5.toString();
                throw new HttpException(2, String.valueOf(e5));
            } catch (SSLException e6) {
                e();
                if (this.c.f() != null) {
                    e6.toString();
                }
                e6.toString();
                throw new HttpException(6, String.valueOf(e6));
            } catch (ConnectionPoolTimeoutException e7) {
                e();
                if (this.c.f() != null) {
                    e7.toString();
                }
                e7.toString();
                throw new HttpException(3, String.valueOf(e7));
            } catch (ConnectTimeoutException e8) {
                e();
                if (this.c.f() != null) {
                    e8.toString();
                }
                e8.toString();
                throw new HttpException(3, String.valueOf(e8));
            } catch (SocketTimeoutException e9) {
                e();
                if (this.c.f() != null) {
                    e9.toString();
                }
                e9.toString();
                throw new HttpException(4, String.valueOf(e9));
            } catch (NoHttpResponseException e10) {
                e();
                if (this.c.f() != null) {
                    e10.toString();
                }
                e10.toString();
                throw new HttpException(5, String.valueOf(e10));
            } catch (HttpHostConnectException e11) {
                e();
                if (this.c.f() != null) {
                    e11.toString();
                }
                throw new HttpException(8, String.valueOf(e11));
            } catch (UnknownHostException e12) {
                e();
                if (this.c.f() != null) {
                    e12.toString();
                }
                e12.toString();
                throw new HttpException(9, String.valueOf(e12));
            } catch (IOException e13) {
                e();
                if (this.c.f() != null) {
                    e13.toString();
                }
                e13.toString();
                throw new HttpException(6, String.valueOf(e13));
            } catch (NullPointerException e14) {
                e();
                int i3 = this.m;
                if (i3 <= 0) {
                    this.m = i3 + 1;
                } else {
                    e14.toString();
                    throw new HttpException(0, String.valueOf(e14));
                }
            } catch (Exception e15) {
                e();
                if (this.c.f() != null) {
                    e15.toString();
                }
                throw new HttpException(0, String.valueOf(e15));
            }
        }
    }

    private void e() {
        HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    private String f() {
        if (!TextUtils.isEmpty(this.q)) {
            return this.q;
        }
        String b2 = this.c.b("operationType");
        this.q = b2;
        return b2;
    }

    private int g() {
        URL h2 = h();
        return h2.getPort() == -1 ? h2.getDefaultPort() : h2.getPort();
    }

    private URL h() {
        URL url = this.l;
        if (url != null) {
            return url;
        }
        URL url2 = new URL(this.c.a());
        this.l = url2;
        return url2;
    }

    private CookieManager i() {
        CookieManager cookieManager = this.i;
        if (cookieManager != null) {
            return cookieManager;
        }
        CookieManager instance = CookieManager.getInstance();
        this.i = instance;
        return instance;
    }

    public final o a() {
        return this.c;
    }
}
