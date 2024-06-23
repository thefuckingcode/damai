package com.alipay.sdk.m.o;

import android.content.Context;
import android.net.NetworkInfo;
import android.taobao.windvane.connect.HttpConnector;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.sdk.m.u.e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: Taobao */
public final class a {
    public static final String a = "msp";
    public static final String b = "application/octet-stream;binary/octet-stream";
    public static final CookieManager c = new CookieManager();

    /* renamed from: com.alipay.sdk.m.o.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class C0130a {
        public final String a;
        public final byte[] b;
        public final Map<String, String> c;

        public C0130a(String str, Map<String, String> map, byte[] bArr) {
            this.a = str;
            this.b = bArr;
            this.c = map;
        }

        public String toString() {
            return String.format("<UrlConnectionConfigure url=%s headers=%s>", this.a, this.c);
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        public final Map<String, List<String>> a;
        public final String b;
        public final byte[] c;

        public b(Map<String, List<String>> map, String str, byte[] bArr) {
            this.a = map;
            this.b = str;
            this.c = bArr;
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x0181 */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01c2 A[SYNTHETIC, Splitter:B:100:0x01c2] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0188 A[SYNTHETIC, Splitter:B:64:0x0188] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x019f A[SYNTHETIC, Splitter:B:78:0x019f] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01a6 A[SYNTHETIC, Splitter:B:82:0x01a6] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01ad A[SYNTHETIC, Splitter:B:86:0x01ad] */
    public static b a(Context context, C0130a aVar) {
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        Throwable th2;
        if (context == null) {
            return null;
        }
        try {
            e.d(com.alipay.sdk.m.l.a.z, "conn config: " + aVar);
            URL url = new URL(aVar.a);
            Proxy b2 = b(context);
            e.d(com.alipay.sdk.m.l.a.z, "conn proxy: " + b2);
            if (b2 != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(b2);
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            try {
                System.setProperty("http.keepAlive", "false");
                if (httpURLConnection instanceof HttpsURLConnection) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                }
                CookieManager cookieManager = c;
                if (cookieManager.getCookieStore().getCookies().size() > 0) {
                    httpURLConnection.setRequestProperty(IRequestConst.COOKIE, TextUtils.join(";", cookieManager.getCookieStore().getCookies()));
                }
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty(IRequestConst.USER_AGENT, a);
                byte[] bArr = aVar.b;
                if (bArr == null || bArr.length <= 0) {
                    httpURLConnection.setRequestMethod("GET");
                } else {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", b);
                    httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                    httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
                    httpURLConnection.setRequestProperty(IRequestConst.CONNECTION_VALUE, "timeout=180, max=100");
                }
                Map<String, String> map = aVar.c;
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (entry.getKey() != null) {
                            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                }
                httpURLConnection.setDoInput(true);
                if ("POST".equals(httpURLConnection.getRequestMethod())) {
                    httpURLConnection.setDoOutput(true);
                }
                if ("POST".equals(httpURLConnection.getRequestMethod())) {
                    bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    try {
                        bufferedOutputStream.write(aVar.b);
                        bufferedOutputStream.flush();
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = null;
                        try {
                            e.a(th);
                            if (httpURLConnection != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            if (bufferedOutputStream != null) {
                            }
                            return null;
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    bufferedOutputStream = null;
                }
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] a2 = a(bufferedInputStream);
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    String join = (headerFields == null || headerFields.get(null) == null) ? null : TextUtils.join(",", headerFields.get(null));
                    List<String> list = headerFields.get(HttpConnector.SET_COOKIE);
                    if (list != null) {
                        for (String str : list) {
                            List<HttpCookie> parse = HttpCookie.parse(str);
                            if (parse != null && !parse.isEmpty()) {
                                c.getCookieStore().add(url.toURI(), parse.get(0));
                            }
                        }
                    }
                    b bVar = new b(headerFields, join, a2);
                    httpURLConnection.disconnect();
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable unused2) {
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return bVar;
                } catch (Throwable th4) {
                    th = th4;
                    e.a(th);
                    if (httpURLConnection != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    return null;
                }
            } catch (Throwable th5) {
                th2 = th5;
                th = th2;
                bufferedInputStream = null;
                bufferedOutputStream = null;
                e.a(th);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused4) {
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable unused5) {
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable unused6) {
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th2 = th6;
            httpURLConnection = null;
            th = th2;
            bufferedInputStream = null;
            bufferedOutputStream = null;
            e.a(th);
            if (httpURLConnection != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (bufferedOutputStream != null) {
            }
            return null;
        }
        if (bufferedOutputStream != null) {
            bufferedOutputStream.close();
        }
        throw th;
        throw th;
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        if (bufferedOutputStream != null) {
        }
        throw th;
    }

    public static Proxy b(Context context) {
        String a2 = a(context);
        if (a2 != null && !a2.contains("wap")) {
            return null;
        }
        try {
            String property = System.getProperty("https.proxyHost");
            String property2 = System.getProperty("https.proxyPort");
            if (!TextUtils.isEmpty(property)) {
                return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, Integer.parseInt(property2)));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(Context context) {
        try {
            NetworkInfo a2 = com.alipay.sdk.m.w.b.a(null, context);
            if (a2 != null && a2.isAvailable()) {
                if (a2.getType() == 1) {
                    return "wifi";
                }
                return a2.getExtraInfo().toLowerCase();
            }
        } catch (Exception unused) {
        }
        return "none";
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
