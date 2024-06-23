package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import mtopsdk.network.util.Constants;

/* compiled from: Taobao */
public abstract class a0 {

    /* compiled from: Taobao */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static b0 a(String str, byte[] bArr, Map<String, String> map) {
        return a(str, bArr, map, "POST");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0061, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0062, code lost:
        r4 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0074, code lost:
        r4 = r9;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:17:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[ExcHandler: a (unused com.huawei.hms.hatool.a0$a), SYNTHETIC, Splitter:B:17:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x00ef  */
    public static b0 a(String str, byte[] bArr, Map<String, String> map, String str2) {
        OutputStream outputStream;
        Throwable th;
        HttpURLConnection httpURLConnection;
        BufferedOutputStream bufferedOutputStream;
        int responseCode;
        if (TextUtils.isEmpty(str)) {
            return new b0(-100, "");
        }
        int i = -102;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            httpURLConnection = a(str, bArr.length, map, str2);
            if (httpURLConnection == null) {
                try {
                    b0 b0Var = new b0(-101, "");
                    t0.a((Closeable) null);
                    t0.a((Closeable) null);
                    if (httpURLConnection != null) {
                        t0.a(httpURLConnection);
                    }
                    return b0Var;
                } catch (a unused) {
                    outputStream = null;
                    y.f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");
                    b0 b0Var2 = new b0(-101, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                        t0.a(httpURLConnection);
                    }
                    return b0Var2;
                } catch (SecurityException unused2) {
                    outputStream = null;
                    y.f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
                    b0 b0Var3 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                        t0.a(httpURLConnection);
                    }
                    return b0Var3;
                } catch (SSLPeerUnverifiedException unused3) {
                    outputStream = null;
                    y.f("hmsSdk", "Certificate has not been verified,Request is restricted!");
                    b0 b0Var4 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                        t0.a(httpURLConnection);
                    }
                    return b0Var4;
                } catch (SSLHandshakeException unused4) {
                    outputStream = null;
                    y.f("hmsSdk", "Chain validation failed,Certificate expired");
                    b0 b0Var5 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                        t0.a(httpURLConnection);
                    }
                    return b0Var5;
                } catch (ConnectException unused5) {
                    outputStream = null;
                    y.f("hmsSdk", "Network is unreachable or Connection refused");
                    b0 b0Var6 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                        t0.a(httpURLConnection);
                    }
                    return b0Var6;
                } catch (UnknownHostException unused6) {
                    outputStream = null;
                    y.f("hmsSdk", "No address associated with hostname or No network");
                    b0 b0Var7 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                        t0.a(httpURLConnection);
                    }
                    return b0Var7;
                } catch (IOException unused7) {
                    outputStream = null;
                    try {
                        y.f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
                        b0 b0Var8 = new b0(i, "");
                        t0.a((Closeable) bufferedOutputStream2);
                        t0.a((Closeable) outputStream);
                        if (httpURLConnection != null) {
                            t0.a(httpURLConnection);
                        }
                        return b0Var8;
                    } catch (Throwable th2) {
                        th = th2;
                        t0.a((Closeable) bufferedOutputStream2);
                        t0.a((Closeable) outputStream);
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                        t0.a(httpURLConnection);
                    }
                    throw th;
                }
            } else {
                outputStream = httpURLConnection.getOutputStream();
                try {
                    bufferedOutputStream = new BufferedOutputStream(outputStream);
                } catch (a unused8) {
                    y.f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");
                    b0 b0Var22 = new b0(-101, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return b0Var22;
                } catch (SecurityException unused9) {
                    y.f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
                    b0 b0Var32 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return b0Var32;
                } catch (SSLPeerUnverifiedException unused10) {
                    y.f("hmsSdk", "Certificate has not been verified,Request is restricted!");
                    b0 b0Var42 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return b0Var42;
                } catch (SSLHandshakeException unused11) {
                    y.f("hmsSdk", "Chain validation failed,Certificate expired");
                    b0 b0Var52 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return b0Var52;
                } catch (ConnectException unused12) {
                    y.f("hmsSdk", "Network is unreachable or Connection refused");
                    b0 b0Var62 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return b0Var62;
                } catch (UnknownHostException unused13) {
                    y.f("hmsSdk", "No address associated with hostname or No network");
                    b0 b0Var72 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return b0Var72;
                } catch (IOException unused14) {
                    y.f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
                    b0 b0Var82 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return b0Var82;
                }
                try {
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.flush();
                    responseCode = httpURLConnection.getResponseCode();
                    b0 b0Var9 = new b0(responseCode, b(httpURLConnection));
                    t0.a((Closeable) bufferedOutputStream);
                    t0.a((Closeable) outputStream);
                    t0.a(httpURLConnection);
                    return b0Var9;
                } catch (a unused15) {
                } catch (SecurityException unused16) {
                    i = responseCode;
                    bufferedOutputStream2 = bufferedOutputStream;
                    y.f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
                    b0 b0Var322 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return b0Var322;
                } catch (SSLPeerUnverifiedException unused17) {
                    i = responseCode;
                    bufferedOutputStream2 = bufferedOutputStream;
                    y.f("hmsSdk", "Certificate has not been verified,Request is restricted!");
                    b0 b0Var422 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return b0Var422;
                } catch (SSLHandshakeException unused18) {
                    i = responseCode;
                    bufferedOutputStream2 = bufferedOutputStream;
                    y.f("hmsSdk", "Chain validation failed,Certificate expired");
                    b0 b0Var522 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return b0Var522;
                } catch (ConnectException unused19) {
                    i = responseCode;
                    bufferedOutputStream2 = bufferedOutputStream;
                    y.f("hmsSdk", "Network is unreachable or Connection refused");
                    b0 b0Var622 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return b0Var622;
                } catch (UnknownHostException unused20) {
                    i = responseCode;
                    bufferedOutputStream2 = bufferedOutputStream;
                    y.f("hmsSdk", "No address associated with hostname or No network");
                    b0 b0Var722 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return b0Var722;
                } catch (IOException unused21) {
                    i = responseCode;
                    bufferedOutputStream2 = bufferedOutputStream;
                    y.f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
                    b0 b0Var822 = new b0(i, "");
                    t0.a((Closeable) bufferedOutputStream2);
                    t0.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return b0Var822;
                } catch (Throwable th4) {
                }
            }
        } catch (a unused22) {
            httpURLConnection = null;
            outputStream = null;
            y.f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");
            b0 b0Var222 = new b0(-101, "");
            t0.a((Closeable) bufferedOutputStream2);
            t0.a((Closeable) outputStream);
            if (httpURLConnection != null) {
            }
            return b0Var222;
        } catch (SecurityException unused23) {
            httpURLConnection = null;
            outputStream = null;
            y.f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
            b0 b0Var3222 = new b0(i, "");
            t0.a((Closeable) bufferedOutputStream2);
            t0.a((Closeable) outputStream);
            if (httpURLConnection != null) {
            }
            return b0Var3222;
        } catch (SSLPeerUnverifiedException unused24) {
            httpURLConnection = null;
            outputStream = null;
            y.f("hmsSdk", "Certificate has not been verified,Request is restricted!");
            b0 b0Var4222 = new b0(i, "");
            t0.a((Closeable) bufferedOutputStream2);
            t0.a((Closeable) outputStream);
            if (httpURLConnection != null) {
            }
            return b0Var4222;
        } catch (SSLHandshakeException unused25) {
            httpURLConnection = null;
            outputStream = null;
            y.f("hmsSdk", "Chain validation failed,Certificate expired");
            b0 b0Var5222 = new b0(i, "");
            t0.a((Closeable) bufferedOutputStream2);
            t0.a((Closeable) outputStream);
            if (httpURLConnection != null) {
            }
            return b0Var5222;
        } catch (ConnectException unused26) {
            httpURLConnection = null;
            outputStream = null;
            y.f("hmsSdk", "Network is unreachable or Connection refused");
            b0 b0Var6222 = new b0(i, "");
            t0.a((Closeable) bufferedOutputStream2);
            t0.a((Closeable) outputStream);
            if (httpURLConnection != null) {
            }
            return b0Var6222;
        } catch (UnknownHostException unused27) {
            httpURLConnection = null;
            outputStream = null;
            y.f("hmsSdk", "No address associated with hostname or No network");
            b0 b0Var7222 = new b0(i, "");
            t0.a((Closeable) bufferedOutputStream2);
            t0.a((Closeable) outputStream);
            if (httpURLConnection != null) {
            }
            return b0Var7222;
        } catch (IOException unused28) {
            httpURLConnection = null;
            outputStream = null;
            y.f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
            b0 b0Var8222 = new b0(i, "");
            t0.a((Closeable) bufferedOutputStream2);
            t0.a((Closeable) outputStream);
            if (httpURLConnection != null) {
            }
            return b0Var8222;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            outputStream = null;
            t0.a((Closeable) bufferedOutputStream2);
            t0.a((Closeable) outputStream);
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    public static HttpURLConnection a(String str, int i, Map<String, String> map, String str2) {
        if (TextUtils.isEmpty(str)) {
            y.b("hmsSdk", "CreateConnection: invalid urlPath.");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty(Constants.Protocol.CONTENT_LENGTH, String.valueOf(i));
        httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031  */
    public static void a(HttpURLConnection httpURLConnection) {
        SecureSSLSocketFactory secureSSLSocketFactory;
        String str;
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            secureSSLSocketFactory = null;
            try {
                secureSSLSocketFactory = SecureSSLSocketFactory.getInstance(b.i());
            } catch (NoSuchAlgorithmException unused) {
                str = "getSocketFactory(): Algorithm Exception!";
            } catch (KeyStoreException unused2) {
                str = "getSocketFactory(): Key Store exception";
            } catch (GeneralSecurityException unused3) {
                str = "getSocketFactory(): General Security Exception";
            } catch (IOException unused4) {
                str = "getSocketFactory(): IO Exception!";
            } catch (IllegalAccessException unused5) {
                str = "getSocketFactory(): Illegal Access Exception ";
            }
            if (secureSSLSocketFactory == null) {
                httpsURLConnection.setSSLSocketFactory(secureSSLSocketFactory);
                httpsURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
                return;
            }
            throw new a("No ssl socket factory set");
        }
        return;
        y.f("hmsSdk", str);
        if (secureSSLSocketFactory == null) {
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x0001 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        com.huawei.hms.hatool.t0.a((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r4 = r4.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        com.huawei.hms.hatool.y.f("hmsSdk", "When Response Content From Connection inputStream operation exception! " + r4);
        com.huawei.hms.hatool.t0.a((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        return "";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000f */
    public static String b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        inputStream = httpURLConnection.getInputStream();
        httpURLConnection = t0.a(inputStream);
        t0.a((Closeable) inputStream);
        return httpURLConnection;
    }
}
