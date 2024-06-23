package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: Taobao */
public abstract class d {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum a {
        GET("GET"),
        POST("POST");
        
        public String d;

        /* access modifiers changed from: public */
        a(String str) {
            this.d = str;
        }

        public String a() {
            return this.d;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0071 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:65:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:71:? */
    /* JADX DEBUG: Multi-variable search result rejected for r8v4, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v8, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v12, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v21, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v22, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v23, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v24, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v25, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v26, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r8v27, resolved type: java.io.BufferedOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00b5 */
    public static String a(Context context, String str, String str2, Map<String, String> map) {
        String str3;
        int i;
        InputStream inputStream;
        InputStream inputStream2;
        OutputStream outputStream;
        Throwable th;
        OutputStream outputStream2;
        HttpURLConnection httpURLConnection;
        BufferedOutputStream bufferedOutputStream;
        InputStream inputStream3;
        InputStream inputStream4;
        InputStream inputStream5;
        str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        HttpURLConnection httpURLConnection2 = null;
        if (str2 == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        i = -1;
        try {
            httpURLConnection = a(context, str, map, a.POST.a());
            if (httpURLConnection == null) {
                IOUtil.closeSecure((OutputStream) null);
                IOUtil.closeSecure((InputStream) null);
                IOUtil.closeSecure((InputStream) null);
                s.a(httpURLConnection);
                HMSLog.i("PushHttpClient", "close connection");
                return null;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                try {
                    bufferedOutputStream.write(str2.getBytes("UTF-8"));
                    bufferedOutputStream.flush();
                    i = httpURLConnection.getResponseCode();
                    StringBuilder sb = new StringBuilder();
                    sb.append("http post response code: ");
                    sb.append(i);
                    HMSLog.d("PushHttpClient", sb.toString());
                    if (i >= 400) {
                        inputStream2 = httpURLConnection.getErrorStream();
                    } else {
                        inputStream2 = httpURLConnection.getInputStream();
                    }
                } catch (IOException unused) {
                    inputStream2 = null;
                    bufferedOutputStream = bufferedOutputStream;
                    inputStream = inputStream2;
                    HMSLog.w("PushHttpClient", "http execute encounter IOException - http code:" + i);
                    outputStream2 = bufferedOutputStream;
                    IOUtil.closeSecure(outputStream2);
                    IOUtil.closeSecure(inputStream2);
                    IOUtil.closeSecure(inputStream);
                    s.a(httpURLConnection);
                    HMSLog.i("PushHttpClient", "close connection");
                    return str3;
                } catch (RuntimeException unused2) {
                    inputStream2 = null;
                    bufferedOutputStream = bufferedOutputStream;
                    inputStream = inputStream2;
                    HMSLog.w("PushHttpClient", "http execute encounter RuntimeException - http code:" + i);
                    outputStream2 = bufferedOutputStream;
                    IOUtil.closeSecure(outputStream2);
                    IOUtil.closeSecure(inputStream2);
                    IOUtil.closeSecure(inputStream);
                    s.a(httpURLConnection);
                    HMSLog.i("PushHttpClient", "close connection");
                    return str3;
                } catch (Exception unused3) {
                    inputStream2 = null;
                    bufferedOutputStream = bufferedOutputStream;
                    inputStream = inputStream2;
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("http execute encounter unknown exception - http code:");
                        sb2.append(i);
                        HMSLog.w("PushHttpClient", sb2.toString());
                        outputStream2 = bufferedOutputStream;
                        IOUtil.closeSecure(outputStream2);
                        IOUtil.closeSecure(inputStream2);
                        IOUtil.closeSecure(inputStream);
                        s.a(httpURLConnection);
                        HMSLog.i("PushHttpClient", "close connection");
                        return str3;
                    } catch (Throwable th2) {
                        httpURLConnection2 = httpURLConnection;
                        th = th2;
                        outputStream = bufferedOutputStream;
                        IOUtil.closeSecure(outputStream);
                        IOUtil.closeSecure(inputStream2);
                        IOUtil.closeSecure(inputStream);
                        s.a(httpURLConnection2);
                        HMSLog.i("PushHttpClient", "close connection");
                        throw th;
                    }
                } catch (Throwable th3) {
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection;
                    th = th3;
                    inputStream2 = null;
                    outputStream = bufferedOutputStream;
                    IOUtil.closeSecure(outputStream);
                    IOUtil.closeSecure(inputStream2);
                    IOUtil.closeSecure(inputStream);
                    s.a(httpURLConnection2);
                    HMSLog.i("PushHttpClient", "close connection");
                    throw th;
                }
                try {
                    inputStream = new BufferedInputStream(inputStream2);
                } catch (IOException unused4) {
                    inputStream = null;
                    HMSLog.w("PushHttpClient", "http execute encounter IOException - http code:" + i);
                    outputStream2 = bufferedOutputStream;
                    IOUtil.closeSecure(outputStream2);
                    IOUtil.closeSecure(inputStream2);
                    IOUtil.closeSecure(inputStream);
                    s.a(httpURLConnection);
                    HMSLog.i("PushHttpClient", "close connection");
                    return str3;
                } catch (RuntimeException unused5) {
                    inputStream = null;
                    HMSLog.w("PushHttpClient", "http execute encounter RuntimeException - http code:" + i);
                    outputStream2 = bufferedOutputStream;
                    IOUtil.closeSecure(outputStream2);
                    IOUtil.closeSecure(inputStream2);
                    IOUtil.closeSecure(inputStream);
                    s.a(httpURLConnection);
                    HMSLog.i("PushHttpClient", "close connection");
                    return str3;
                } catch (Exception unused6) {
                    inputStream = null;
                } catch (Throwable th4) {
                    httpURLConnection2 = httpURLConnection;
                    th = th4;
                    inputStream = null;
                    outputStream = bufferedOutputStream;
                    IOUtil.closeSecure(outputStream);
                    IOUtil.closeSecure(inputStream2);
                    IOUtil.closeSecure(inputStream);
                    s.a(httpURLConnection2);
                    HMSLog.i("PushHttpClient", "close connection");
                    throw th;
                }
            } catch (IOException unused7) {
                inputStream3 = null;
                inputStream2 = inputStream3;
                bufferedOutputStream = inputStream3;
                inputStream = inputStream2;
                HMSLog.w("PushHttpClient", "http execute encounter IOException - http code:" + i);
                outputStream2 = bufferedOutputStream;
                IOUtil.closeSecure(outputStream2);
                IOUtil.closeSecure(inputStream2);
                IOUtil.closeSecure(inputStream);
                s.a(httpURLConnection);
                HMSLog.i("PushHttpClient", "close connection");
                return str3;
            } catch (RuntimeException unused8) {
                inputStream4 = null;
                inputStream2 = inputStream4;
                bufferedOutputStream = inputStream4;
                inputStream = inputStream2;
                HMSLog.w("PushHttpClient", "http execute encounter RuntimeException - http code:" + i);
                outputStream2 = bufferedOutputStream;
                IOUtil.closeSecure(outputStream2);
                IOUtil.closeSecure(inputStream2);
                IOUtil.closeSecure(inputStream);
                s.a(httpURLConnection);
                HMSLog.i("PushHttpClient", "close connection");
                return str3;
            } catch (Exception unused9) {
                inputStream5 = null;
                inputStream2 = inputStream5;
                bufferedOutputStream = inputStream5;
                inputStream = inputStream2;
                StringBuilder sb22 = new StringBuilder();
                sb22.append("http execute encounter unknown exception - http code:");
                sb22.append(i);
                HMSLog.w("PushHttpClient", sb22.toString());
                outputStream2 = bufferedOutputStream;
                IOUtil.closeSecure(outputStream2);
                IOUtil.closeSecure(inputStream2);
                IOUtil.closeSecure(inputStream);
                s.a(httpURLConnection);
                HMSLog.i("PushHttpClient", "close connection");
                return str3;
            } catch (Throwable th5) {
                inputStream2 = null;
                inputStream = null;
                httpURLConnection2 = httpURLConnection;
                th = th5;
                outputStream = null;
                IOUtil.closeSecure(outputStream);
                IOUtil.closeSecure(inputStream2);
                IOUtil.closeSecure(inputStream);
                s.a(httpURLConnection2);
                HMSLog.i("PushHttpClient", "close connection");
                throw th;
            }
            try {
                str3 = s.a(inputStream);
                IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                IOUtil.closeSecure(inputStream2);
                IOUtil.closeSecure(inputStream);
                s.a(httpURLConnection);
                HMSLog.i("PushHttpClient", "close connection");
                return str3;
            } catch (IOException unused10) {
                HMSLog.w("PushHttpClient", "http execute encounter IOException - http code:" + i);
                outputStream2 = bufferedOutputStream;
                IOUtil.closeSecure(outputStream2);
                IOUtil.closeSecure(inputStream2);
                IOUtil.closeSecure(inputStream);
                s.a(httpURLConnection);
                HMSLog.i("PushHttpClient", "close connection");
                return str3;
            } catch (RuntimeException unused11) {
                HMSLog.w("PushHttpClient", "http execute encounter RuntimeException - http code:" + i);
                outputStream2 = bufferedOutputStream;
                IOUtil.closeSecure(outputStream2);
                IOUtil.closeSecure(inputStream2);
                IOUtil.closeSecure(inputStream);
                s.a(httpURLConnection);
                HMSLog.i("PushHttpClient", "close connection");
                return str3;
            } catch (Exception unknown) {
                StringBuilder sb222 = new StringBuilder();
                sb222.append("http execute encounter unknown exception - http code:");
                sb222.append(i);
                HMSLog.w("PushHttpClient", sb222.toString());
                outputStream2 = bufferedOutputStream;
                IOUtil.closeSecure(outputStream2);
                IOUtil.closeSecure(inputStream2);
                IOUtil.closeSecure(inputStream);
                s.a(httpURLConnection);
                HMSLog.i("PushHttpClient", "close connection");
                return str3;
            }
        } catch (IOException unused12) {
            httpURLConnection = null;
            inputStream3 = null;
            inputStream2 = inputStream3;
            bufferedOutputStream = inputStream3;
            inputStream = inputStream2;
            HMSLog.w("PushHttpClient", "http execute encounter IOException - http code:" + i);
            outputStream2 = bufferedOutputStream;
            IOUtil.closeSecure(outputStream2);
            IOUtil.closeSecure(inputStream2);
            IOUtil.closeSecure(inputStream);
            s.a(httpURLConnection);
            HMSLog.i("PushHttpClient", "close connection");
            return str3;
        } catch (RuntimeException unused13) {
            httpURLConnection = null;
            inputStream4 = null;
            inputStream2 = inputStream4;
            bufferedOutputStream = inputStream4;
            inputStream = inputStream2;
            HMSLog.w("PushHttpClient", "http execute encounter RuntimeException - http code:" + i);
            outputStream2 = bufferedOutputStream;
            IOUtil.closeSecure(outputStream2);
            IOUtil.closeSecure(inputStream2);
            IOUtil.closeSecure(inputStream);
            s.a(httpURLConnection);
            HMSLog.i("PushHttpClient", "close connection");
            return str3;
        } catch (Exception unused14) {
            httpURLConnection = null;
            inputStream5 = null;
            inputStream2 = inputStream5;
            bufferedOutputStream = inputStream5;
            inputStream = inputStream2;
            StringBuilder sb2222 = new StringBuilder();
            sb2222.append("http execute encounter unknown exception - http code:");
            sb2222.append(i);
            HMSLog.w("PushHttpClient", sb2222.toString());
            outputStream2 = bufferedOutputStream;
            IOUtil.closeSecure(outputStream2);
            IOUtil.closeSecure(inputStream2);
            IOUtil.closeSecure(inputStream);
            s.a(httpURLConnection);
            HMSLog.i("PushHttpClient", "close connection");
            return str3;
        } catch (Throwable th6) {
            th = th6;
            outputStream = null;
            inputStream2 = null;
            inputStream = null;
            IOUtil.closeSecure(outputStream);
            IOUtil.closeSecure(inputStream2);
            IOUtil.closeSecure(inputStream);
            s.a(httpURLConnection2);
            HMSLog.i("PushHttpClient", "close connection");
            throw th;
        }
    }

    public static HttpURLConnection a(Context context, String str, Map<String, String> map, String str2) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        a(context, httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue(), "UTF-8"));
                }
            }
        }
        return httpURLConnection;
    }

    public static void a(Context context, HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SecureSSLSocketFactory secureSSLSocketFactory = null;
            try {
                secureSSLSocketFactory = SecureSSLSocketFactory.getInstance(context);
            } catch (NoSuchAlgorithmException unused) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Algorithm Exception.");
            } catch (KeyStoreException unused2) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Key Store exception.");
            } catch (GeneralSecurityException unused3) {
                HMSLog.w("PushHttpClient", "Get SocketFactory General Security Exception.");
            } catch (IOException unused4) {
                HMSLog.w("PushHttpClient", "Get SocketFactory IO Exception.");
            } catch (IllegalAccessException unused5) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Access Exception.");
            } catch (IllegalArgumentException unused6) {
                HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Argument Exception.");
            }
            if (secureSSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(secureSSLSocketFactory);
                httpsURLConnection.setHostnameVerifier(SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                return;
            }
            throw new Exception("No ssl socket factory set.");
        }
    }
}
