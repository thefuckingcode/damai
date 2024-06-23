package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import android.util.Base64InputStream;
import anet.channel.detect.Ipv6Detector;
import anet.channel.entity.ENV;
import anet.channel.statist.AmdcStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tb.a90;
import tb.b90;
import tb.gm;
import tb.h9;
import tb.il0;
import tb.jl1;
import tb.ju2;
import tb.ke1;
import tb.rh1;
import tb.ss0;
import tb.w6;

/* compiled from: Taobao */
class a {
    static AtomicInteger a = new AtomicInteger(0);
    static HostnameVerifier b = new C0005a();
    static Random c = new Random();

    /* renamed from: anet.channel.strategy.dispatch.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    static class C0005a implements HostnameVerifier {
        C0005a() {
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(a90.a(), sSLSession);
        }
    }

    private static String a(String str, String str2, int i, Map<String, String> map, int i2) {
        StringBuilder sb = new StringBuilder(64);
        if (i2 == 2 && "https".equalsIgnoreCase(str) && c.nextBoolean()) {
            str = "http";
        }
        sb.append(str);
        sb.append(ke1.SCHEME_SLASH);
        if (str2 != null) {
            if (h9.k() && Inet64Util.p() && ju2.c(str2)) {
                try {
                    str2 = Inet64Util.e(str2);
                } catch (Exception unused) {
                }
            }
            if (ju2.d(str2)) {
                sb.append(jl1.ARRAY_START);
                sb.append(str2);
                sb.append(jl1.ARRAY_END);
            } else {
                sb.append(str2);
            }
            if (i == 0) {
                i = "https".equalsIgnoreCase(str) ? 443 : 80;
            }
            sb.append(":");
            sb.append(i);
        } else {
            sb.append(a90.a());
        }
        sb.append(a90.serverPath);
        TreeMap treeMap = new TreeMap();
        treeMap.put("appkey", map.remove("appkey"));
        treeMap.put("v", map.remove("v"));
        treeMap.put("deviceId", map.remove("deviceId"));
        treeMap.put("platform", map.remove("platform"));
        sb.append(jl1.CONDITION_IF);
        sb.append(ju2.b(treeMap, "utf-8"));
        return sb.toString();
    }

    static void b(String str, long j, long j2) {
        try {
            il0 il0 = new il0();
            il0.a = "amdc";
            il0.b = "http";
            il0.c = str;
            il0.d = j;
            il0.e = j2;
            rh1.a().commitFlow(il0);
        } catch (Exception e) {
            ALog.d("awcn.DispatchCore", "commit flow info failed!", null, e, new Object[0]);
        }
    }

    static void c(String str, String str2, URL url, int i, int i2) {
        if ((i2 != 1 || i == 2) && ss0.j()) {
            try {
                AmdcStatistic amdcStatistic = new AmdcStatistic();
                amdcStatistic.errorCode = str;
                amdcStatistic.errorMsg = str2;
                if (url != null) {
                    amdcStatistic.host = url.getHost();
                    amdcStatistic.url = url.toString();
                }
                amdcStatistic.retryTimes = i;
                w6.b().commitStat(amdcStatistic);
            } catch (Exception unused) {
            }
        }
    }

    static List<IConnStrategy> d(String str) {
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        if (!NetworkStatusHelper.o()) {
            list = anet.channel.strategy.a.a().getConnStrategyListByHost(a90.a());
            ListIterator<IConnStrategy> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                IConnStrategy next = listIterator.next();
                if (!next.getProtocol().protocol.equalsIgnoreCase(str)) {
                    listIterator.remove();
                } else if (Inet64Util.p() && ju2.c(next.getIp())) {
                    listIterator.remove();
                } else if ((Inet64Util.o() || Ipv6Detector.d() == 0) && ju2.d(next.getIp())) {
                    listIterator.remove();
                }
            }
        }
        return list;
    }

    static String e(InputStream inputStream, boolean z) {
        Throwable th;
        IOException e;
        FilterInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        if (z) {
            try {
                bufferedInputStream = new GZIPInputStream(bufferedInputStream);
            } catch (IOException e2) {
                e = e2;
                try {
                    ALog.d("awcn.DispatchCore", "", null, e, new Object[0]);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused2) {
                    }
                    throw th;
                }
            }
        }
        FilterInputStream base64InputStream = new Base64InputStream(bufferedInputStream, 0);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = base64InputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String str = new String(byteArrayOutputStream.toByteArray(), "utf-8");
            try {
                base64InputStream.close();
            } catch (IOException unused3) {
            }
            return str;
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = base64InputStream;
            ALog.d("awcn.DispatchCore", "", null, e, new Object[0]);
            bufferedInputStream.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = base64InputStream;
            bufferedInputStream.close();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x02ba A[Catch:{ all -> 0x02dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02ce A[SYNTHETIC, Splitter:B:115:0x02ce] */
    /* JADX WARNING: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    public static int f(String str, Map map, int i) {
        URL url;
        HttpURLConnection httpURLConnection;
        Throwable th;
        String message;
        String str2 = "AMDC" + String.valueOf(a.incrementAndGet());
        int i2 = 2;
        ALog.f("awcn.DispatchCore", "send amdc request", str2, "url", str, "\nhost", map.get("domain").toString());
        ENV env = (ENV) map.remove("Env");
        String str3 = (String) map.remove(a90.NETWORK_ID);
        try {
            url = new URL(str);
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection.setConnectTimeout(20000);
                    httpURLConnection.setReadTimeout(20000);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.addRequestProperty(IRequestConst.CONNECTION, "close");
                    httpURLConnection.addRequestProperty("Accept-Encoding", "gzip");
                    httpURLConnection.setInstanceFollowRedirects(false);
                    if (url.getProtocol().equals("https")) {
                        try {
                            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(b);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    byte[] bytes = ju2.b(map, "utf-8").getBytes();
                    outputStream.write(bytes);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (ALog.g(1)) {
                        ALog.c("awcn.DispatchCore", "amdc response. code: " + responseCode, str2, "\nheaders", httpURLConnection.getHeaderFields());
                    }
                    if (responseCode != 200) {
                        if (!(responseCode == 302 || responseCode == 307)) {
                            i2 = 1;
                        }
                        c(String.valueOf(responseCode), "response code not 200", url, i, i2);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e) {
                            ALog.d("awcn.DispatchCore", "http disconnect failed", null, e, new Object[0]);
                        }
                        return i2;
                    }
                    String headerField = httpURLConnection.getHeaderField("x-am-code");
                    if (!"1000".equals(headerField)) {
                        if (!"1007".equals(headerField) && !"1008".equals(headerField)) {
                            i2 = 1;
                        }
                        c(headerField, "return code: " + headerField, url, i, i2);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e2) {
                            ALog.d("awcn.DispatchCore", "http disconnect failed", null, e2, new Object[0]);
                        }
                        return i2;
                    }
                    String headerField2 = httpURLConnection.getHeaderField("x-am-sign");
                    if (TextUtils.isEmpty(headerField2)) {
                        c("-1001", "response sign is empty", url, i, 1);
                        try {
                            httpURLConnection.disconnect();
                            return 1;
                        } catch (Exception e3) {
                            ALog.d("awcn.DispatchCore", "http disconnect failed", null, e3, new Object[0]);
                            return 1;
                        }
                    } else {
                        String e4 = e(httpURLConnection.getInputStream(), "gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding()));
                        if (ALog.g(1)) {
                            ALog.c("awcn.DispatchCore", "amdc response body", str2, "\nbody", e4);
                        }
                        try {
                            b(str, (long) bytes.length, (long) httpURLConnection.getContentLength());
                            if (TextUtils.isEmpty(e4)) {
                                c("-1002", "read answer error", url, i, 1);
                                try {
                                    httpURLConnection.disconnect();
                                    return 1;
                                } catch (Exception e5) {
                                    ALog.d("awcn.DispatchCore", "http disconnect failed", null, e5, new Object[0]);
                                    return 1;
                                }
                            } else {
                                IAmdcSign c2 = AmdcRuntimeInfo.c();
                                String sign = c2 != null ? c2.sign(e4) : null;
                                if (!sign.equalsIgnoreCase(headerField2)) {
                                    ALog.e("awcn.DispatchCore", "check ret sign failed", str2, "retSign", headerField2, "checkSign", sign);
                                    c("-1003", "check sign failed", url, i, 1);
                                    try {
                                        httpURLConnection.disconnect();
                                        return 1;
                                    } catch (Exception e6) {
                                        ALog.d("awcn.DispatchCore", "http disconnect failed", null, e6, new Object[0]);
                                        return 1;
                                    }
                                } else {
                                    try {
                                        JSONObject jSONObject = (JSONObject) new JSONTokener(e4).nextValue();
                                        if (ss0.e() != env) {
                                            ALog.k("awcn.DispatchCore", "env change, do not notify result", str2, new Object[0]);
                                            try {
                                                httpURLConnection.disconnect();
                                                return 0;
                                            } catch (Exception e7) {
                                                ALog.d("awcn.DispatchCore", "http disconnect failed", null, e7, new Object[0]);
                                                return 0;
                                            }
                                        } else if (!NetworkStatusHelper.j(NetworkStatusHelper.i()).equals(str3)) {
                                            ALog.e("awcn.DispatchCore", "the network has changed ! do not notify result", str2, new Object[0]);
                                            try {
                                                httpURLConnection.disconnect();
                                                return 0;
                                            } catch (Exception e8) {
                                                ALog.d("awcn.DispatchCore", "http disconnect failed", null, e8, new Object[0]);
                                                return 0;
                                            }
                                        } else {
                                            HttpDispatcher.f().d(new b90(1, jSONObject));
                                            c(headerField, "request success", url, i, 0);
                                            try {
                                                httpURLConnection.disconnect();
                                            } catch (Exception e9) {
                                                ALog.d("awcn.DispatchCore", "http disconnect failed", null, e9, new Object[0]);
                                            }
                                            return 0;
                                        }
                                    } catch (JSONException unused) {
                                        HttpDispatcher.f().d(new b90(0, null));
                                        ALog.e("awcn.DispatchCore", "resolve amdc anser failed", str2, new Object[0]);
                                        c("-1004", "resolve answer failed", url, i, 1);
                                        try {
                                            httpURLConnection.disconnect();
                                            return 1;
                                        } catch (Exception e10) {
                                            ALog.d("awcn.DispatchCore", "http disconnect failed", null, e10, new Object[0]);
                                            return 1;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            httpURLConnection = httpURLConnection;
                            try {
                                message = th.getMessage();
                                if (TextUtils.isEmpty(message)) {
                                    message = th.toString();
                                }
                                c("-1000", message, url, i, 1);
                                ALog.d("awcn.DispatchCore", "amdc request fail", str2, th, new Object[0]);
                                if (httpURLConnection != null) {
                                    return 1;
                                }
                                try {
                                    httpURLConnection.disconnect();
                                    return 1;
                                } catch (Exception e11) {
                                    ALog.d("awcn.DispatchCore", "http disconnect failed", null, e11, new Object[0]);
                                    return 1;
                                }
                            } catch (Throwable th4) {
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception e12) {
                                        ALog.d("awcn.DispatchCore", "http disconnect failed", null, e12, new Object[0]);
                                    }
                                }
                                throw th4;
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    message = th.getMessage();
                    if (TextUtils.isEmpty(message)) {
                    }
                    c("-1000", message, url, i, 1);
                    ALog.d("awcn.DispatchCore", "amdc request fail", str2, th, new Object[0]);
                    if (httpURLConnection != null) {
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                httpURLConnection = null;
                message = th.getMessage();
                if (TextUtils.isEmpty(message)) {
                }
                c("-1000", message, url, i, 1);
                ALog.d("awcn.DispatchCore", "amdc request fail", str2, th, new Object[0]);
                if (httpURLConnection != null) {
                }
            }
        } catch (Throwable th7) {
            th = th7;
            httpURLConnection = null;
            url = null;
            message = th.getMessage();
            if (TextUtils.isEmpty(message)) {
            }
            c("-1000", message, url, i, 1);
            ALog.d("awcn.DispatchCore", "amdc request fail", str2, th, new Object[0]);
            if (httpURLConnection != null) {
            }
        }
    }

    public static void g(Map map) {
        String str;
        IConnStrategy iConnStrategy;
        boolean z;
        String str2;
        if (map != null) {
            String schemeByHost = anet.channel.strategy.a.a().getSchemeByHost(a90.a(), "http");
            List<IConnStrategy> d = d(schemeByHost);
            String[] c2 = Inet64Util.p() ? a90.c() : null;
            boolean z2 = false;
            for (int i = 0; i < 3; i++) {
                HashMap hashMap = new HashMap(map);
                boolean z3 = true;
                if (i != 2) {
                    iConnStrategy = !d.isEmpty() ? d.remove(0) : null;
                    if (iConnStrategy != null) {
                        str = a(schemeByHost, iConnStrategy.getIp(), iConnStrategy.getPort(), hashMap, i);
                    } else {
                        if (c2 == null || c2.length <= 0 || z2) {
                            z = z2;
                            str2 = null;
                        } else {
                            str2 = c2[c.nextInt(c2.length)];
                            z = true;
                        }
                        str = a(schemeByHost, str2, 0, hashMap, i);
                        z2 = z;
                    }
                } else {
                    String[] b2 = a90.b();
                    if (b2 == null || b2.length <= 0) {
                        str = a(schemeByHost, null, 0, hashMap, i);
                    } else {
                        str = a(schemeByHost, b2[c.nextInt(b2.length)], 0, hashMap, i);
                    }
                    iConnStrategy = null;
                }
                int f = f(str, hashMap, i);
                if (iConnStrategy != null) {
                    gm gmVar = new gm();
                    if (f != 0) {
                        z3 = false;
                    }
                    gmVar.a = z3;
                    anet.channel.strategy.a.a().notifyConnEvent(a90.a(), iConnStrategy, gmVar);
                }
                if (f == 0 || f == 2) {
                    return;
                }
            }
        }
    }
}
