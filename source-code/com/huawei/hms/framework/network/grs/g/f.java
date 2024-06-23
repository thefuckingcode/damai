package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.taobao.windvane.connect.HttpConnector;
import android.text.TextUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.h.f.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: Taobao */
public class f extends a implements Callable<d> {
    private static final String i = "f";

    public f(String str, int i2, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo) {
        super(str, i2, cVar, context, str2, grsBaseInfo, null);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a9, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r9.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d2, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d9, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b0 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ce A[SYNTHETIC, Splitter:B:49:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0115 A[SYNTHETIC, Splitter:B:68:0x0115] */
    @Override // java.util.concurrent.Callable
    public d call() {
        long j;
        HttpsURLConnection httpsURLConnection;
        long j2;
        IOException e;
        String str = i;
        Logger.i(str, "Get call execute");
        long j3 = 0;
        HttpsURLConnection httpsURLConnection2 = null;
        InputStream inputStream = null;
        byte[] bArr = null;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            j3 = System.currentTimeMillis();
            httpsURLConnection = a.a(c(), a(), e());
            if (httpsURLConnection == null) {
                try {
                    Logger.w(str, "create HttpsURLConnection instance by url return null.");
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (RuntimeException unused) {
                            Logger.w(i, "RequestCallableV1 disconnect HttpsURLConnection catch RuntimeException");
                        } catch (Throwable unused2) {
                            Logger.w(i, "RequestCallableV1 disconnect HttpsURLConnection catch Throwable");
                        }
                    }
                    return null;
                } catch (IOException e2) {
                    e = e2;
                    j3 = elapsedRealtime;
                    j2 = j3;
                    try {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        j = System.currentTimeMillis();
                        Logger.w(i, "RequestCallable run task catch IOException", e);
                        this.a = new d(e, elapsedRealtime2 - j3);
                        if (httpsURLConnection != null) {
                        }
                        j3 = j2;
                        this.a.b(c());
                        this.a.a(d());
                        this.a.b(j3);
                        this.a.a(j);
                        if (b() != null) {
                        }
                        return this.a;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        httpsURLConnection2 = httpsURLConnection;
                        if (httpsURLConnection2 != null) {
                            try {
                                httpsURLConnection2.disconnect();
                            } catch (RuntimeException unused3) {
                                Logger.w(i, "RequestCallableV1 disconnect HttpsURLConnection catch RuntimeException");
                            } catch (Throwable unused4) {
                                Logger.w(i, "RequestCallableV1 disconnect HttpsURLConnection catch Throwable");
                            }
                        }
                        throw th2;
                    }
                }
            } else {
                httpsURLConnection.setRequestMethod("GET");
                String a = b() != null ? b().a() : "";
                if (TextUtils.isEmpty(a)) {
                    a = "&";
                }
                httpsURLConnection.setRequestProperty(HttpConnector.IF_NONE_MATCH, a);
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode == 200) {
                    try {
                        inputStream = httpsURLConnection.getInputStream();
                        byte[] byteArray = IoUtils.toByteArray(inputStream);
                        IoUtils.closeSecure(inputStream);
                        bArr = byteArray;
                    } catch (Throwable th3) {
                        IoUtils.closeSecure(inputStream);
                        throw th3;
                    }
                }
                Map headerFields = httpsURLConnection.getHeaderFields();
                httpsURLConnection.disconnect();
                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                j = System.currentTimeMillis();
                this.a = new d(responseCode, headerFields, bArr == null ? new byte[0] : bArr, elapsedRealtime3 - elapsedRealtime);
                try {
                    httpsURLConnection.disconnect();
                } catch (RuntimeException unused5) {
                } catch (Throwable unused6) {
                    Logger.w(i, "RequestCallableV1 disconnect HttpsURLConnection catch Throwable");
                    this.a.b(c());
                    this.a.a(d());
                    this.a.b(j3);
                    this.a.a(j);
                    if (b() != null) {
                    }
                    return this.a;
                }
                this.a.b(c());
                this.a.a(d());
                this.a.b(j3);
                this.a.a(j);
                if (b() != null) {
                    b().a(this.a);
                }
                return this.a;
            }
            Logger.w(i, "RequestCallableV1 disconnect HttpsURLConnection catch RuntimeException");
            this.a.b(c());
            this.a.a(d());
            this.a.b(j3);
            this.a.a(j);
            if (b() != null) {
            }
            return this.a;
        } catch (IOException e3) {
            e = e3;
            httpsURLConnection = null;
            j2 = 0;
            long elapsedRealtime22 = SystemClock.elapsedRealtime();
            j = System.currentTimeMillis();
            Logger.w(i, "RequestCallable run task catch IOException", e);
            this.a = new d(e, elapsedRealtime22 - j3);
            if (httpsURLConnection != null) {
            }
            j3 = j2;
            this.a.b(c());
            this.a.a(d());
            this.a.b(j3);
            this.a.a(j);
            if (b() != null) {
            }
            return this.a;
        } catch (Throwable th4) {
        }
    }
}
