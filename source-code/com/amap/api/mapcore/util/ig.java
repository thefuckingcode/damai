package com.amap.api.mapcore.util;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.amap.api.mapcore.util.Cif;
import com.amap.api.mapcore.util.id;
import com.amap.api.maps.AMapException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.PushbackInputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
public class ig {
    private int a;
    private int b;
    private boolean c;
    private SSLContext d;
    private Proxy e;
    private volatile boolean f;
    private long g;
    private long h;
    private String i;
    private b j;
    private id.a k;

    /* compiled from: Taobao */
    public static class a {
        public HttpURLConnection a;
        public int b;

        public a(HttpURLConnection httpURLConnection, int i) {
            this.a = httpURLConnection;
            this.b = i;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private Vector<c> a;
        private volatile c b;

        private b() {
            this.a = new Vector<>();
            this.b = new c();
        }

        public c a() {
            return this.b;
        }

        public void b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.b.a(str);
            }
        }

        public c a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.b;
            }
            for (int i = 0; i < this.a.size(); i++) {
                c cVar = this.a.get(i);
                if (cVar != null && cVar.a().equals(str)) {
                    return cVar;
                }
            }
            c cVar2 = new c();
            cVar2.b(str);
            this.a.add(cVar2);
            return cVar2;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c implements HostnameVerifier {
        private String a;
        private String b;

        private c() {
        }

        public void a(String str) {
            this.a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.a)) {
                return this.a.equals(str);
            }
            if (!TextUtils.isEmpty(this.b)) {
                return defaultHostnameVerifier.verify(this.b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }

        public String a() {
            return this.b;
        }
    }

    ig(int i2, int i3, Proxy proxy, boolean z) {
        this(i2, i3, proxy, z, null);
    }

    public static boolean a(int i2) {
        return i2 == 2;
    }

    private void b() {
        try {
            this.i = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            ha.a(th, "ht", ReportManager.g);
        }
    }

    private void c(int i2) {
        if (i2 == 2) {
            this.a = Math.max(this.a - 5000, 5000);
            this.b = Math.max(this.b - 5000, 5000);
        } else if (i2 == 3) {
            try {
                this.a = 5000;
                this.b = 5000;
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f = true;
    }

    ig(int i2, int i3, Proxy proxy, boolean z, id.a aVar) {
        this.f = false;
        this.g = -1;
        this.h = 0;
        this.a = i2;
        this.b = i3;
        this.e = proxy;
        this.c = gi.a().b(z);
        if (gi.c()) {
            this.c = false;
        }
        this.k = aVar;
        b();
        if (this.c) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                this.d = instance;
            } catch (Throwable th) {
                ha.a(th, "ht", "ne");
            }
        }
        this.j = new b();
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        this.h = j2;
    }

    private String a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a2 = a(map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (a2 != null) {
            stringBuffer.append("?");
            stringBuffer.append(a2);
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    public void b(long j2) {
        this.g = j2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x000c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.amap.api.mapcore.util.ig] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 9 */
    public ik b(String str, String str2, boolean z, String str3, Map<String, String> map, Map<String, String> map2, boolean z2, int i2) throws gb {
        gb e2;
        Throwable th;
        a aVar;
        a aVar2 = null;
        r13 = null;
        r13 = null;
        r13 = null;
        r13 = null;
        r13 = null;
        r13 = null;
        r13 = null;
        r13 = null;
        HttpURLConnection httpURLConnection = null;
        aVar2 = null;
        ?? r1 = str;
        try {
            a a2 = a(a(r1, map2), a(str2, map2), z, str3, map, false, i2);
            try {
                httpURLConnection = a2.a;
                ik a3 = a(a2, z2);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th2) {
                        ha.a(th2, "ht", "mgr");
                    }
                }
                return a3;
            } catch (ConnectException unused) {
                throw new gb(AMapException.ERROR_CONNECTION);
            } catch (MalformedURLException unused2) {
                throw new gb("url异常 - MalformedURLException");
            } catch (UnknownHostException unused3) {
                throw new gb("未知主机 - UnKnowHostException");
            } catch (SocketException unused4) {
                throw new gb(AMapException.ERROR_SOCKET);
            } catch (SocketTimeoutException unused5) {
                throw new gb("socket 连接超时 - SocketTimeoutException");
            } catch (InterruptedIOException unused6) {
                throw new gb(AMapException.ERROR_UNKNOWN);
            } catch (IOException unused7) {
                throw new gb("IO 操作异常 - IOException");
            } catch (gb e3) {
                e2 = e3;
                throw e2;
            } catch (Throwable th3) {
                th = th3;
                aVar2 = aVar;
                r1 = httpURLConnection;
                th.printStackTrace();
                throw new gb(AMapException.ERROR_UNKNOWN);
            }
        } catch (ConnectException unused8) {
            throw new gb(AMapException.ERROR_CONNECTION);
        } catch (MalformedURLException unused9) {
            throw new gb("url异常 - MalformedURLException");
        } catch (UnknownHostException unused10) {
            throw new gb("未知主机 - UnKnowHostException");
        } catch (SocketException unused11) {
            throw new gb(AMapException.ERROR_SOCKET);
        } catch (SocketTimeoutException unused12) {
            throw new gb("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused13) {
            throw new gb(AMapException.ERROR_UNKNOWN);
        } catch (IOException unused14) {
            throw new gb("IO 操作异常 - IOException");
        } catch (gb e4) {
            e2 = e4;
            throw e2;
        } catch (Throwable th4) {
            try {
                gd.a(i2);
                b(aVar2);
            } catch (Throwable th5) {
                ha.a(th5, "ht", "mgr");
            }
            if (r1 != 0) {
                r1.disconnect();
            }
            throw th4;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v13, resolved type: java.io.DataOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00b7 */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x018c A[SYNTHETIC, Splitter:B:116:0x018c] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0196 A[SYNTHETIC, Splitter:B:120:0x0196] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01a7 A[SYNTHETIC, Splitter:B:127:0x01a7] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01d5 A[SYNTHETIC, Splitter:B:147:0x01d5] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e0 A[SYNTHETIC, Splitter:B:152:0x01e0] */
    /* JADX WARNING: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d A[Catch:{ all -> 0x0171 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d A[Catch:{ all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d A[Catch:{ all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007f A[Catch:{ all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0084 A[Catch:{ all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0086 A[Catch:{ all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008a A[Catch:{ all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c2 A[SYNTHETIC, Splitter:B:43:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cc  */
    public void a(String str, String str2, boolean z, String str3, Map<String, String> map, Map<String, String> map2, byte[] bArr, Cif.a aVar, int i2) {
        boolean z2;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Throwable th;
        boolean z3;
        a a2;
        InputStream inputStream2;
        DataOutputStream dataOutputStream2;
        int responseCode;
        boolean z4;
        InputStream inputStream3;
        int read;
        if (aVar != null) {
            a aVar2 = null;
            try {
                String a3 = a(str, map2);
                String a4 = a(str2, map2);
                if (bArr != null) {
                    try {
                        if (bArr.length > 0) {
                            z3 = true;
                            long currentTimeMillis = System.currentTimeMillis();
                            int i3 = 0;
                            a2 = a(a3, a4, z, str3, map, z3, i2);
                            try {
                                httpURLConnection = a2.a;
                                try {
                                    httpURLConnection.setRequestProperty("RANGE", "bytes=" + this.h + "-");
                                    if (!z3) {
                                        DataOutputStream dataOutputStream3 = new DataOutputStream(httpURLConnection.getOutputStream());
                                        try {
                                            dataOutputStream3.write(bArr);
                                            dataOutputStream3.close();
                                            dataOutputStream2 = dataOutputStream3;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            z2 = true;
                                            aVar2 = a2;
                                            inputStream = null;
                                            dataOutputStream = dataOutputStream3;
                                            try {
                                                aVar.onException(th);
                                                if (z2) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (httpURLConnection != null) {
                                                }
                                                if (dataOutputStream != null) {
                                                }
                                            } catch (Throwable th3) {
                                                ha.a(th3, "ht", "mdr");
                                            }
                                        }
                                    } else {
                                        dataOutputStream2 = null;
                                    }
                                    httpURLConnection.connect();
                                    String a5 = a(httpURLConnection);
                                    responseCode = httpURLConnection.getResponseCode();
                                    if (!(responseCode == 206) || !z4) {
                                        aVar.onException(new gb("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode, a5, this.i));
                                        a(a2);
                                        b(a2);
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable th4) {
                                            ha.a(th4, "ht", "mdr");
                                        }
                                        if (dataOutputStream2 == null) {
                                            try {
                                                dataOutputStream2.close();
                                                return;
                                            } catch (Throwable th5) {
                                                ha.a(th5, "ht", "mdr");
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        a(a2, false, currentTimeMillis, System.currentTimeMillis());
                                        InputStream inputStream4 = httpURLConnection.getInputStream();
                                        try {
                                            byte[] bArr2 = new byte[1024];
                                            while (true) {
                                                if (Thread.interrupted() || this.f || (read = inputStream4.read(bArr2, i3, 1024)) <= 0) {
                                                    inputStream3 = inputStream4;
                                                } else {
                                                    long j2 = this.g;
                                                    if (j2 != -1) {
                                                        inputStream3 = inputStream4;
                                                        try {
                                                            if (this.h >= j2) {
                                                                break;
                                                            }
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            aVar2 = a2;
                                                            z2 = true;
                                                            inputStream = inputStream3;
                                                            dataOutputStream = dataOutputStream2;
                                                            aVar.onException(th);
                                                            if (z2) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (httpURLConnection != null) {
                                                            }
                                                            if (dataOutputStream != null) {
                                                            }
                                                        }
                                                    } else {
                                                        inputStream3 = inputStream4;
                                                    }
                                                    if (read == 1024) {
                                                        aVar.onDownload(bArr2, this.h);
                                                    } else {
                                                        byte[] bArr3 = new byte[read];
                                                        System.arraycopy(bArr2, 0, bArr3, 0, read);
                                                        aVar.onDownload(bArr3, this.h);
                                                    }
                                                    this.h += (long) read;
                                                    inputStream4 = inputStream3;
                                                    i3 = 0;
                                                }
                                            }
                                            inputStream3 = inputStream4;
                                            try {
                                                if (this.f) {
                                                    aVar.onStop();
                                                } else {
                                                    aVar.onFinish();
                                                }
                                                if (inputStream3 != null) {
                                                    try {
                                                        inputStream3.close();
                                                    } catch (IOException e2) {
                                                        ha.a(e2, "ht", "mdr");
                                                    } catch (Throwable th7) {
                                                        ha.a(th7, "ht", "mdr");
                                                    }
                                                }
                                                try {
                                                    httpURLConnection.disconnect();
                                                } catch (Throwable th8) {
                                                    ha.a(th8, "ht", "mdr");
                                                }
                                                if (dataOutputStream2 != null) {
                                                    try {
                                                        dataOutputStream2.close();
                                                        return;
                                                    } catch (Throwable th9) {
                                                        ha.a(th9, "ht", "mdr");
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } catch (Throwable th10) {
                                                th = th10;
                                                aVar2 = a2;
                                                z2 = false;
                                                inputStream = inputStream3;
                                                dataOutputStream = dataOutputStream2;
                                                aVar.onException(th);
                                                if (z2) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (httpURLConnection != null) {
                                                }
                                                if (dataOutputStream != null) {
                                                }
                                            }
                                        } catch (Throwable th11) {
                                            th = th11;
                                            inputStream3 = inputStream4;
                                            aVar2 = a2;
                                            z2 = true;
                                            inputStream = inputStream3;
                                            dataOutputStream = dataOutputStream2;
                                            aVar.onException(th);
                                            if (z2) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection != null) {
                                            }
                                            if (dataOutputStream != null) {
                                            }
                                        }
                                    }
                                } catch (Throwable th12) {
                                    th = th12;
                                    inputStream2 = null;
                                    z2 = true;
                                    aVar2 = a2;
                                    inputStream = inputStream2;
                                    dataOutputStream = inputStream2;
                                    aVar.onException(th);
                                    if (z2) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    if (dataOutputStream != null) {
                                    }
                                }
                            } catch (Throwable th13) {
                                th = th13;
                                httpURLConnection = null;
                                inputStream2 = null;
                                z2 = true;
                                aVar2 = a2;
                                inputStream = inputStream2;
                                dataOutputStream = inputStream2;
                                aVar.onException(th);
                                if (z2) {
                                }
                                if (inputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                            }
                        }
                    } catch (Throwable th14) {
                        th = th14;
                        inputStream = null;
                        httpURLConnection = null;
                        dataOutputStream = null;
                        z2 = false;
                        aVar.onException(th);
                        if (z2) {
                        }
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                    }
                }
                z3 = false;
                long currentTimeMillis2 = System.currentTimeMillis();
                int i32 = 0;
                try {
                    a2 = a(a3, a4, z, str3, map, z3, i2);
                    httpURLConnection = a2.a;
                    httpURLConnection.setRequestProperty("RANGE", "bytes=" + this.h + "-");
                    if (!z3) {
                    }
                    httpURLConnection.connect();
                    String a52 = a(httpURLConnection);
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                    }
                    if (!(responseCode == 206) || !(responseCode == 200)) {
                    }
                } catch (Throwable th15) {
                    th = th15;
                    inputStream = null;
                    httpURLConnection = null;
                    dataOutputStream = null;
                    z2 = true;
                    aVar.onException(th);
                    if (z2) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                }
            } catch (Throwable th16) {
                th = th16;
                inputStream = null;
                httpURLConnection = null;
                dataOutputStream = null;
                z2 = false;
                aVar.onException(th);
                if (z2) {
                    try {
                        a(aVar2);
                        b(aVar2);
                    } catch (Throwable unused) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        ha.a(e3, "ht", "mdr");
                    } catch (Throwable th17) {
                        ha.a(th17, "ht", "mdr");
                    }
                }
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th18) {
                        ha.a(th18, "ht", "mdr");
                    }
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                ha.a(e4, "ht", "mdr");
            } catch (Throwable th19) {
                ha.a(th19, "ht", "mdr");
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (dataOutputStream != null) {
            dataOutputStream.close();
        }
        throw th;
        if (httpURLConnection != null) {
        }
        if (dataOutputStream != null) {
        }
        throw th;
        throw th;
        if (dataOutputStream != null) {
        }
        throw th;
    }

    public static int b(int i2) {
        if (i2 != 2 || gd.a()) {
            return i2;
        }
        return 1;
    }

    private void b(a aVar) {
        a(aVar, true, 0, 0);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x000f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.amap.api.mapcore.util.ig] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    public Map<String, String> a(String str, String str2, boolean z, String str3, Map<String, String> map, Map<String, String> map2, boolean z2, int i2) throws gb {
        gb e2;
        Throwable th;
        boolean z3 = true;
        a aVar = null;
        r14 = null;
        r14 = null;
        r14 = null;
        r14 = null;
        r14 = null;
        r14 = null;
        r14 = null;
        r14 = null;
        HttpURLConnection httpURLConnection = null;
        aVar = null;
        aVar = null;
        ?? r1 = str;
        try {
            String a2 = a(r1, map2);
            String a3 = a(str2, map2);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                a a4 = a(a2, a3, z, str3, map, false, i2);
                try {
                    httpURLConnection = a4.a;
                    if (httpURLConnection.getResponseCode() < 400) {
                        try {
                            a(a4, false, currentTimeMillis, System.currentTimeMillis());
                            HashMap hashMap = new HashMap();
                            int i3 = 0;
                            while (true) {
                                if (i3 < 50) {
                                    String headerFieldKey = httpURLConnection.getHeaderFieldKey(i3);
                                    if (headerFieldKey == null) {
                                        break;
                                    }
                                    hashMap.put(headerFieldKey.toLowerCase(), httpURLConnection.getHeaderField(headerFieldKey));
                                    i3++;
                                }
                            }
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable th2) {
                                ha.a(th2, "hth", "mgr");
                            }
                            return hashMap;
                        } catch (ConnectException unused) {
                            throw new gb(AMapException.ERROR_CONNECTION);
                        } catch (MalformedURLException unused2) {
                            throw new gb("url异常 - MalformedURLException");
                        } catch (UnknownHostException unused3) {
                            throw new gb("未知主机 - UnKnowHostException");
                        } catch (SocketException unused4) {
                            throw new gb(AMapException.ERROR_SOCKET);
                        } catch (SocketTimeoutException unused5) {
                            throw new gb("socket 连接超时 - SocketTimeoutException");
                        } catch (InterruptedIOException unused6) {
                            throw new gb(AMapException.ERROR_UNKNOWN);
                        } catch (IOException unused7) {
                            throw new gb("IO 操作异常 - IOException");
                        } catch (gb e3) {
                            e2 = e3;
                            throw e2;
                        } catch (Throwable th3) {
                            th = th3;
                            z3 = false;
                            aVar = a4;
                            r1 = httpURLConnection;
                            th.printStackTrace();
                            throw new gb(AMapException.ERROR_UNKNOWN);
                        }
                    } else {
                        throw new gb("http读取header失败");
                    }
                } catch (ConnectException unused8) {
                    throw new gb(AMapException.ERROR_CONNECTION);
                } catch (MalformedURLException unused9) {
                    throw new gb("url异常 - MalformedURLException");
                } catch (UnknownHostException unused10) {
                    throw new gb("未知主机 - UnKnowHostException");
                } catch (SocketException unused11) {
                    throw new gb(AMapException.ERROR_SOCKET);
                } catch (SocketTimeoutException unused12) {
                    throw new gb("socket 连接超时 - SocketTimeoutException");
                } catch (InterruptedIOException unused13) {
                    throw new gb(AMapException.ERROR_UNKNOWN);
                } catch (IOException unused14) {
                    throw new gb("IO 操作异常 - IOException");
                } catch (gb e4) {
                    e2 = e4;
                    throw e2;
                } catch (Throwable th4) {
                    th = th4;
                    aVar = a4;
                    r1 = httpURLConnection;
                    th.printStackTrace();
                    throw new gb(AMapException.ERROR_UNKNOWN);
                }
            } catch (ConnectException unused15) {
                throw new gb(AMapException.ERROR_CONNECTION);
            } catch (MalformedURLException unused16) {
                throw new gb("url异常 - MalformedURLException");
            } catch (UnknownHostException unused17) {
                throw new gb("未知主机 - UnKnowHostException");
            } catch (SocketException unused18) {
                throw new gb(AMapException.ERROR_SOCKET);
            } catch (SocketTimeoutException unused19) {
                throw new gb("socket 连接超时 - SocketTimeoutException");
            } catch (InterruptedIOException unused20) {
                throw new gb(AMapException.ERROR_UNKNOWN);
            } catch (IOException unused21) {
                throw new gb("IO 操作异常 - IOException");
            } catch (gb e5) {
                e2 = e5;
                throw e2;
            } catch (Throwable th5) {
                th = th5;
                r1 = 0;
                th.printStackTrace();
                throw new gb(AMapException.ERROR_UNKNOWN);
            }
        } catch (ConnectException unused22) {
            throw new gb(AMapException.ERROR_CONNECTION);
        } catch (MalformedURLException unused23) {
            throw new gb("url异常 - MalformedURLException");
        } catch (UnknownHostException unused24) {
            throw new gb("未知主机 - UnKnowHostException");
        } catch (SocketException unused25) {
            throw new gb(AMapException.ERROR_SOCKET);
        } catch (SocketTimeoutException unused26) {
            throw new gb("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused27) {
            throw new gb(AMapException.ERROR_UNKNOWN);
        } catch (IOException unused28) {
            throw new gb("IO 操作异常 - IOException");
        } catch (gb e6) {
            e2 = e6;
            throw e2;
        } catch (Throwable th6) {
            if (z3) {
                try {
                    a(aVar);
                    b(aVar);
                } catch (Throwable th7) {
                    ha.a(th7, "hth", "mgr");
                }
            }
            if (r1 != 0) {
                r1.disconnect();
            }
            throw th6;
        }
    }

    public static int a(int i2, ii iiVar) {
        try {
            if (gd.c()) {
                return 4;
            }
            if ((iiVar == null || iiVar.isSupportIPV6()) && i2 == 2 && i2 == b(i2)) {
                return 2;
            }
            return 1;
        } catch (Throwable th) {
            hd.c(th, "htu", "gt");
        }
    }

    private String a(String str, String str2, int i2) {
        if (i2 == 2 || i2 == 4) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            } catch (Throwable unused) {
            }
        }
        return str;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x0017 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.amap.api.mapcore.util.ig$a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.amap.api.mapcore.util.ig] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* access modifiers changed from: package-private */
    public ik a(String str, String str2, boolean z, String str3, Map<String, String> map, byte[] bArr, boolean z2, int i2) throws gb {
        ConnectException e2;
        MalformedURLException e3;
        UnknownHostException e4;
        SocketException e5;
        SocketTimeoutException e6;
        IOException e7;
        gb e8;
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        a aVar = this;
        try {
            a a2 = aVar.a(str, str2, z, str3, map, true, i2);
            try {
                HttpURLConnection httpURLConnection2 = a2.a;
                if (bArr != null && bArr.length > 0) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    dataOutputStream.write(bArr);
                    dataOutputStream.close();
                }
                ik a3 = a(a2, z2);
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable th2) {
                        ha.a(th2, "ht", "mPt");
                    }
                }
                return a3;
            } catch (ConnectException e9) {
                e2 = e9;
                e2.printStackTrace();
                throw new gb(AMapException.ERROR_CONNECTION);
            } catch (MalformedURLException e10) {
                e3 = e10;
                e3.printStackTrace();
                throw new gb("url异常 - MalformedURLException");
            } catch (UnknownHostException e11) {
                e4 = e11;
                e4.printStackTrace();
                throw new gb("未知主机 - UnKnowHostException");
            } catch (SocketException e12) {
                e5 = e12;
                e5.printStackTrace();
                throw new gb(AMapException.ERROR_SOCKET);
            } catch (SocketTimeoutException e13) {
                e6 = e13;
                e6.printStackTrace();
                throw new gb("socket 连接超时 - SocketTimeoutException");
            } catch (InterruptedIOException unused) {
                throw new gb(AMapException.ERROR_UNKNOWN);
            } catch (IOException e14) {
                e7 = e14;
                e7.printStackTrace();
                throw new gb("IO 操作异常 - IOException");
            } catch (gb e15) {
                e8 = e15;
                ha.a(e8, "ht", "mPt");
                throw e8;
            } catch (Throwable th3) {
                th = th3;
                aVar = a2;
                ha.a(th, "ht", "mPt");
                throw new gb(AMapException.ERROR_UNKNOWN);
            }
        } catch (ConnectException e16) {
            e2 = e16;
            e2.printStackTrace();
            throw new gb(AMapException.ERROR_CONNECTION);
        } catch (MalformedURLException e17) {
            e3 = e17;
            e3.printStackTrace();
            throw new gb("url异常 - MalformedURLException");
        } catch (UnknownHostException e18) {
            e4 = e18;
            e4.printStackTrace();
            throw new gb("未知主机 - UnKnowHostException");
        } catch (SocketException e19) {
            e5 = e19;
            e5.printStackTrace();
            throw new gb(AMapException.ERROR_SOCKET);
        } catch (SocketTimeoutException e20) {
            e6 = e20;
            e6.printStackTrace();
            throw new gb("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException unused2) {
            throw new gb(AMapException.ERROR_UNKNOWN);
        } catch (IOException e21) {
            e7 = e21;
            e7.printStackTrace();
            throw new gb("IO 操作异常 - IOException");
        } catch (gb e22) {
            e8 = e22;
            ha.a(e8, "ht", "mPt");
            throw e8;
        } catch (Throwable th4) {
            try {
                gd.a(i2);
                b(aVar);
            } catch (Throwable th5) {
                ha.a(th5, "ht", "mPt");
            }
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th4;
        }
    }

    private String a(int i2, String str, Map<String, String> map) {
        String str2 = i2 != 1 ? "" : id.b;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        String uri = parse.buildUpon().encodedAuthority(str2).build().toString();
        if (map != null) {
            map.put("targetHost", host);
        }
        if (this.c) {
            this.j.b(str2);
        }
        return uri;
    }

    /* access modifiers changed from: package-private */
    public a a(String str, String str2, boolean z, String str3, Map<String, String> map, boolean z2, int i2) throws IOException {
        HttpsURLConnection httpsURLConnection;
        gg.c();
        String a2 = a(str, str2, i2);
        c(i2);
        if (map == null) {
            map = new HashMap<>();
        }
        c a3 = this.j.a();
        if (z && !TextUtils.isEmpty(str3)) {
            a3 = this.j.a(str3);
        }
        String a4 = a(id.a, a2, map);
        if (this.c) {
            a4 = gi.a(a4);
        }
        URL url = new URL(a4);
        id.a aVar = this.k;
        URLConnection a5 = aVar != null ? aVar.a(this.e, url) : null;
        if (a5 == null) {
            Proxy proxy = this.e;
            if (proxy != null) {
                a5 = url.openConnection(proxy);
            } else {
                a5 = url.openConnection();
            }
        }
        if (this.c) {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) a5;
            httpsURLConnection2.setSSLSocketFactory(this.d.getSocketFactory());
            httpsURLConnection2.setHostnameVerifier(a3);
            httpsURLConnection = httpsURLConnection2;
        } else {
            httpsURLConnection = (HttpURLConnection) a5;
        }
        if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
            httpsURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
        }
        a(map, httpsURLConnection);
        if (z2) {
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
        } else {
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setDoInput(true);
        }
        return new a(httpsURLConnection, i2);
    }

    private String a(HttpURLConnection httpURLConnection) {
        List<String> list;
        if (httpURLConnection == null) {
            return "";
        }
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if (!(headerFields == null || (list = headerFields.get("gsid")) == null || list.size() <= 0)) {
                return list.get(0);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private void a(a aVar) {
        if (aVar != null) {
            gd.a(aVar.b);
        }
    }

    private void a(a aVar, boolean z, long j2, long j3) {
        boolean z2;
        boolean z3;
        String str;
        boolean z4 = false;
        String str2 = null;
        try {
            str2 = aVar.a.getURL().toString();
            int i2 = aVar.b;
            boolean z5 = i2 == 3;
            if (i2 == 2 || i2 == 4) {
                z4 = true;
            }
            z3 = z4;
            z2 = z5;
            str = str2;
        } catch (Throwable unused) {
            str = str2;
            z3 = false;
            z2 = false;
        }
        if (!TextUtils.isEmpty(str)) {
            gd.a(str, z3, z2, z, Math.max(0L, j3 - j2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x012d A[SYNTHETIC, Splitter:B:73:0x012d] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0138 A[SYNTHETIC, Splitter:B:78:0x0138] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0143 A[SYNTHETIC, Splitter:B:83:0x0143] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x014e A[SYNTHETIC, Splitter:B:88:0x014e] */
    private ik a(a aVar, boolean z) throws gb, IOException {
        Throwable th;
        PushbackInputStream pushbackInputStream;
        InputStream inputStream;
        PushbackInputStream pushbackInputStream2;
        List<String> list;
        String str = "";
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HttpURLConnection httpURLConnection = aVar.a;
            httpURLConnection.connect();
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            int responseCode = httpURLConnection.getResponseCode();
            if (!(headerFields == null || (list = headerFields.get("gsid")) == null || list.size() <= 0)) {
                str = list.get(0);
            }
            if (responseCode == 200) {
                a(aVar, false, currentTimeMillis, System.currentTimeMillis());
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        pushbackInputStream = new PushbackInputStream(inputStream, 2);
                        try {
                            byte[] bArr = new byte[2];
                            pushbackInputStream.read(bArr);
                            pushbackInputStream.unread(bArr);
                            FilterInputStream gZIPInputStream = (bArr[0] == 31 && bArr[1] == -117 && !z) ? new GZIPInputStream(pushbackInputStream) : pushbackInputStream;
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = gZIPInputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr2, 0, read);
                            }
                            hd.c();
                            ik ikVar = new ik();
                            ikVar.a = byteArrayOutputStream2.toByteArray();
                            ikVar.b = headerFields;
                            ikVar.c = this.i;
                            ikVar.d = str;
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Throwable th2) {
                                ha.a(th2, "ht", "par");
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th3) {
                                    ha.a(th3, "ht", "par");
                                }
                            }
                            try {
                                pushbackInputStream.close();
                            } catch (Throwable th4) {
                                ha.a(th4, "ht", "par");
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (Throwable th5) {
                                ha.a(th5, "ht", "par");
                            }
                            return ikVar;
                        } catch (IOException unused) {
                            byteArrayOutputStream = byteArrayOutputStream2;
                            pushbackInputStream2 = null;
                            try {
                                throw new gb("IO 操作异常 - IOException", str, this.i);
                            } catch (Throwable th6) {
                                th = th6;
                                if (byteArrayOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (pushbackInputStream != null) {
                                }
                                if (pushbackInputStream2 != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            pushbackInputStream2 = null;
                            if (byteArrayOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (pushbackInputStream != null) {
                            }
                            if (pushbackInputStream2 != null) {
                            }
                            throw th;
                        }
                    } catch (IOException unused2) {
                        pushbackInputStream = null;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        pushbackInputStream2 = pushbackInputStream;
                        throw new gb("IO 操作异常 - IOException", str, this.i);
                    } catch (Throwable th8) {
                        th = th8;
                        pushbackInputStream = null;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        pushbackInputStream2 = pushbackInputStream;
                        if (byteArrayOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (pushbackInputStream != null) {
                        }
                        if (pushbackInputStream2 != null) {
                        }
                        throw th;
                    }
                } catch (IOException unused3) {
                    inputStream = null;
                    pushbackInputStream = null;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    pushbackInputStream2 = pushbackInputStream;
                    throw new gb("IO 操作异常 - IOException", str, this.i);
                } catch (Throwable th9) {
                    th = th9;
                    inputStream = null;
                    pushbackInputStream = null;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    pushbackInputStream2 = pushbackInputStream;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th10) {
                            ha.a(th10, "ht", "par");
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th11) {
                            ha.a(th11, "ht", "par");
                        }
                    }
                    if (pushbackInputStream != null) {
                        try {
                            pushbackInputStream.close();
                        } catch (Throwable th12) {
                            ha.a(th12, "ht", "par");
                        }
                    }
                    if (pushbackInputStream2 != null) {
                        try {
                            pushbackInputStream2.close();
                        } catch (Throwable th13) {
                            ha.a(th13, "ht", "par");
                        }
                    }
                    throw th;
                }
            } else {
                gb gbVar = new gb("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode + AltriaXLaunchTime.SPACE + str + " " + this.i, str, this.i);
                gbVar.a(responseCode);
                throw gbVar;
            }
        } catch (IOException unused4) {
            pushbackInputStream2 = null;
            inputStream = null;
            pushbackInputStream = null;
            throw new gb("IO 操作异常 - IOException", str, this.i);
        } catch (Throwable th14) {
            th = th14;
            pushbackInputStream2 = null;
            inputStream = null;
            pushbackInputStream = null;
            if (byteArrayOutputStream != null) {
            }
            if (inputStream != null) {
            }
            if (pushbackInputStream != null) {
            }
            if (pushbackInputStream2 != null) {
            }
            throw th;
        }
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, map.get(str));
            }
        }
        try {
            httpURLConnection.addRequestProperty("csid", this.i);
        } catch (Throwable th) {
            ha.a(th, "ht", "adh");
        }
        httpURLConnection.setConnectTimeout(this.a);
        httpURLConnection.setReadTimeout(this.b);
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
}
