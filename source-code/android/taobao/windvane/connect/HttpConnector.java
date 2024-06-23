package android.taobao.windvane.connect;

import android.net.Uri;
import android.taobao.windvane.WVCookieManager;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.security.SSLTunnelSocketFactory;
import android.taobao.windvane.util.NetWork;
import android.taobao.windvane.util.TaoLog;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import org.apache.http.HttpHost;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import tb.gl1;

/* compiled from: Taobao */
public class HttpConnector {
    public static final String CACHE_CONTROL = "cache-control";
    public static final String CONTENT_LENGTH = "content-length";
    public static final String CONTENT_TYPE = "content-type";
    public static final String DATE = "date";
    public static final String ETAG = "etag";
    public static final String EXPIRES = "expires";
    public static final String IF_MODIFY_SINCE = "If-Modified-Since";
    public static final String IF_NONE_MATCH = "If-None-Match";
    public static final String LAST_MODIFIED = "last-modified";
    public static final String REDIRECT_LOCATION = "location";
    public static final String RESPONSE_CODE = "response-code";
    public static final String SET_COOKIE = "Set-Cookie";
    private static String TAG = "HttpConnector";
    public static final String URL = "url";
    private HttpConnectListener<HttpResponse> mListener = null;
    private int redirectTime = 0;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class HttpOverFlowException extends Exception {
        public HttpOverFlowException(String str) {
            super(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class HttpsErrorException extends Exception {
        public HttpsErrorException(String str) {
            super(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class NetWorkErrorException extends Exception {
        public NetWorkErrorException(String str) {
            super(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class RedirectException extends Exception {
        public RedirectException(String str) {
            super(str);
        }
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:270:0x03f7 */
    /* JADX DEBUG: Multi-variable search result rejected for r11v14, resolved type: java.io.DataInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r11v26, resolved type: java.io.DataInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r11v40, resolved type: java.io.DataInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r11v46, resolved type: java.io.DataInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x03b2, code lost:
        if (r7 != null) goto L_0x03f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x03f7, code lost:
        if (r7 == null) goto L_0x03fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x03f9, code lost:
        r7.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x03fc, code lost:
        r2 = r17.mListener;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x03fe, code lost:
        if (r2 == null) goto L_0x0408;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0400, code lost:
        r2.onFinish(new android.taobao.windvane.connect.HttpResponse(), 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x040d, code lost:
        return new android.taobao.windvane.connect.HttpResponse();
     */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x034f A[Catch:{ all -> 0x0445 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x037b A[Catch:{ all -> 0x041b }] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x038a A[SYNTHETIC, Splitter:B:224:0x038a] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0395 A[SYNTHETIC, Splitter:B:229:0x0395] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x03a0 A[SYNTHETIC, Splitter:B:234:0x03a0] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x03cd  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x040e A[SYNTHETIC, Splitter:B:277:0x040e] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x042e  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x0440  */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0449 A[SYNTHETIC, Splitter:B:301:0x0449] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0454 A[SYNTHETIC, Splitter:B:306:0x0454] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x045f A[SYNTHETIC, Splitter:B:311:0x045f] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0473  */
    private HttpResponse dataConnect(HttpRequest httpRequest) throws NetWorkErrorException, HttpOverFlowException, RedirectException, HttpsErrorException {
        GZIPInputStream gZIPInputStream;
        HttpsURLConnection httpsURLConnection;
        DataInputStream dataInputStream;
        InputStream inputStream;
        Throwable th;
        RedirectException redirectException;
        HttpConnectListener<HttpResponse> httpConnectListener;
        HttpOverFlowException httpOverFlowException;
        HttpConnectListener<HttpResponse> httpConnectListener2;
        HttpsURLConnection httpsURLConnection2;
        InputStream inputStream2;
        SSLHandshakeException sSLHandshakeException;
        GZIPInputStream gZIPInputStream2;
        HttpConnectListener<HttpResponse> httpConnectListener3;
        Throwable cause;
        HttpsURLConnection httpsURLConnection3;
        OutOfMemoryError outOfMemoryError;
        HttpConnectListener<HttpResponse> httpConnectListener4;
        HttpsURLConnection httpsURLConnection4;
        Throwable th2;
        HttpConnectListener<HttpResponse> httpConnectListener5;
        DataInputStream dataInputStream2;
        HttpsURLConnection httpsURLConnection5;
        HttpsURLConnection httpsURLConnection6;
        HttpsURLConnection httpsURLConnection7;
        HttpsURLConnection httpsURLConnection8;
        HttpURLConnection httpURLConnection;
        SSLHandshakeException e;
        OutOfMemoryError e2;
        GZIPInputStream gZIPInputStream3;
        SSLTunnelSocketFactory sSLTunnelSocketFactory;
        Uri uri = httpRequest.getUri();
        HttpConnectListener<HttpResponse> httpConnectListener6 = this.mListener;
        if (httpConnectListener6 != null) {
            httpConnectListener6.onStart();
        }
        HttpResponse httpResponse = new HttpResponse();
        boolean equalsIgnoreCase = "https".equalsIgnoreCase(uri.getScheme());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
        DataInputStream dataInputStream3 = 0;
        try {
            URL url = new URL(uri.toString());
            String host = url.getHost();
            if (equalsIgnoreCase) {
                try {
                    TaoLog.i(TAG, "proxy or https");
                    HttpHost httpsProxyInfo = NetWork.getHttpsProxyInfo(GlobalConfig.context);
                    if (httpsProxyInfo != null) {
                        sSLTunnelSocketFactory = new SSLTunnelSocketFactory(httpsProxyInfo.getHostName(), httpsProxyInfo.getPort(), null, "taobao_hybrid_8.5.0");
                    } else {
                        TaoLog.d(TAG, "https:proxy: none");
                        sSLTunnelSocketFactory = null;
                    }
                    HttpsURLConnection httpsURLConnection9 = (HttpsURLConnection) url.openConnection();
                    if (sSLTunnelSocketFactory != null) {
                        httpsURLConnection9.setSSLSocketFactory(sSLTunnelSocketFactory);
                    }
                    httpsURLConnection9.setHostnameVerifier(new StrictHostnameVerifier());
                    try {
                        httpsURLConnection9.setRequestProperty(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
                        httpsURLConnection8 = httpsURLConnection9;
                    } catch (RedirectException e3) {
                        redirectException = e3;
                        httpsURLConnection5 = httpsURLConnection9;
                    } catch (HttpOverFlowException e4) {
                        httpOverFlowException = e4;
                        httpsURLConnection6 = httpsURLConnection9;
                        httpConnectListener2 = this.mListener;
                        if (httpConnectListener2 != null) {
                        }
                        throw httpOverFlowException;
                    } catch (SSLHandshakeException e5) {
                        sSLHandshakeException = e5;
                        gZIPInputStream2 = null;
                        inputStream2 = null;
                        httpsURLConnection2 = httpsURLConnection9;
                        httpConnectListener3 = this.mListener;
                        if (httpConnectListener3 != null) {
                        }
                        cause = sSLHandshakeException.getCause();
                        if (cause != null) {
                        }
                    } catch (OutOfMemoryError e6) {
                        outOfMemoryError = e6;
                        gZIPInputStream2 = null;
                        inputStream2 = null;
                        httpsURLConnection2 = httpsURLConnection9;
                        try {
                            httpConnectListener4 = this.mListener;
                            if (httpConnectListener4 != null) {
                            }
                            outOfMemoryError.printStackTrace();
                            byteArrayOutputStream.reset();
                            if (dataInputStream3 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            if (gZIPInputStream2 != null) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            dataInputStream = dataInputStream3;
                            inputStream = inputStream2;
                            gZIPInputStream = gZIPInputStream2;
                            httpsURLConnection = httpsURLConnection2;
                            if (dataInputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (gZIPInputStream != null) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e8) {
                                e8.printStackTrace();
                            }
                            if (httpsURLConnection != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        inputStream = null;
                        dataInputStream = null;
                        gZIPInputStream = null;
                        httpsURLConnection7 = httpsURLConnection9;
                        dataInputStream3 = httpsURLConnection7;
                        try {
                            String message = th2.getMessage();
                            httpConnectListener5 = this.mListener;
                            if (httpConnectListener5 != null) {
                            }
                            th2.printStackTrace();
                            byteArrayOutputStream.reset();
                            throw new NetWorkErrorException(message);
                        } catch (Throwable th5) {
                            th = th5;
                            httpsURLConnection = dataInputStream3;
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Exception e9) {
                                    e9.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                }
                            }
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                }
                            }
                            byteArrayOutputStream.close();
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                } catch (RedirectException e12) {
                    redirectException = e12;
                    httpConnectListener = this.mListener;
                    if (httpConnectListener != null) {
                    }
                    throw redirectException;
                } catch (HttpOverFlowException e13) {
                    httpOverFlowException = e13;
                    httpConnectListener2 = this.mListener;
                    if (httpConnectListener2 != null) {
                    }
                    throw httpOverFlowException;
                } catch (SSLHandshakeException e14) {
                    sSLHandshakeException = e14;
                    gZIPInputStream2 = null;
                    httpsURLConnection2 = null;
                    inputStream2 = null;
                    httpConnectListener3 = this.mListener;
                    if (httpConnectListener3 != null) {
                    }
                    cause = sSLHandshakeException.getCause();
                    if (cause != null) {
                    }
                } catch (OutOfMemoryError e15) {
                    outOfMemoryError = e15;
                    gZIPInputStream2 = null;
                    httpsURLConnection2 = null;
                    inputStream2 = null;
                    httpConnectListener4 = this.mListener;
                    if (httpConnectListener4 != null) {
                    }
                    outOfMemoryError.printStackTrace();
                    byteArrayOutputStream.reset();
                    if (dataInputStream3 != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (gZIPInputStream2 != null) {
                    }
                    byteArrayOutputStream.close();
                } catch (Throwable th6) {
                    th2 = th6;
                    inputStream = null;
                    dataInputStream = null;
                    gZIPInputStream = null;
                    String message2 = th2.getMessage();
                    httpConnectListener5 = this.mListener;
                    if (httpConnectListener5 != null) {
                    }
                    th2.printStackTrace();
                    byteArrayOutputStream.reset();
                    throw new NetWorkErrorException(message2);
                }
            } else {
                httpsURLConnection8 = (HttpURLConnection) url.openConnection();
            }
            try {
                setConnectProp(httpsURLConnection8, httpRequest);
                HttpConnectListener<HttpResponse> httpConnectListener7 = this.mListener;
                if (httpConnectListener7 != null) {
                    httpConnectListener7.onProcess(0);
                }
                int i = 1;
                if (gl1.TYPE_OPEN_URL_METHOD_POST.equalsIgnoreCase(httpRequest.getMethod())) {
                    TaoLog.d(TAG, "post data: " + new String(httpRequest.getPostData()));
                    httpsURLConnection8.setDoOutput(true);
                    httpsURLConnection8.setDoInput(true);
                    httpsURLConnection8.setRequestMethod("POST");
                    httpsURLConnection8.connect();
                    OutputStream outputStream = httpsURLConnection8.getOutputStream();
                    outputStream.write(httpRequest.getPostData());
                    outputStream.flush();
                    outputStream.close();
                } else {
                    try {
                        httpsURLConnection8.connect();
                    } catch (AssertionError e16) {
                        throw new NetWorkErrorException(e16.getMessage());
                    }
                }
                int responseCode = httpsURLConnection8.getResponseCode();
                TaoLog.d(TAG, "responeCode:" + responseCode);
                if (responseCode >= 300 && responseCode < 400 && responseCode != 304 && httpRequest.isRedirect()) {
                    int i2 = this.redirectTime;
                    if (i2 <= 5) {
                        this.redirectTime = i2 + 1;
                        String headerField = httpsURLConnection8.getHeaderField("location");
                        if (headerField != null) {
                            if (!headerField.toLowerCase().startsWith("http")) {
                                headerField = new URL("http", host, headerField).toString();
                            }
                            if (responseCode != 305) {
                                httpRequest.setUri(Uri.parse(headerField));
                                HttpResponse dataConnect = dataConnect(httpRequest);
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e17) {
                                    e17.printStackTrace();
                                }
                                httpsURLConnection8.disconnect();
                                return dataConnect;
                            }
                            HttpResponse dataConnect2 = dataConnect(new HttpRequest(headerField));
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e18) {
                                e18.printStackTrace();
                            }
                            httpsURLConnection8.disconnect();
                            return dataConnect2;
                        }
                    } else {
                        throw new RedirectException("too many redirect");
                    }
                }
                httpResponse.setHttpCode(responseCode);
                while (true) {
                    String headerFieldKey = httpsURLConnection8.getHeaderFieldKey(i);
                    if (headerFieldKey == null) {
                        break;
                    }
                    i++;
                    String headerField2 = httpsURLConnection8.getHeaderField(headerFieldKey);
                    httpResponse.addHeader(headerFieldKey, headerField2);
                    if (SET_COOKIE.equals(headerFieldKey)) {
                        WVCookieManager.setCookie(uri.toString(), headerField2);
                    }
                }
                if (responseCode < 200 || responseCode >= 300) {
                    gZIPInputStream2 = null;
                    dataInputStream3 = null;
                    inputStream2 = null;
                } else {
                    int contentLength = httpsURLConnection8.getContentLength();
                    if (contentLength <= 5242880) {
                        inputStream = httpsURLConnection8.getInputStream();
                        try {
                            String contentEncoding = httpsURLConnection8.getContentEncoding();
                            if (contentEncoding == null || !"gzip".equals(contentEncoding)) {
                                dataInputStream = new DataInputStream(inputStream);
                                gZIPInputStream3 = null;
                            } else {
                                GZIPInputStream gZIPInputStream4 = new GZIPInputStream(inputStream);
                                try {
                                    gZIPInputStream3 = gZIPInputStream4;
                                    dataInputStream = new DataInputStream(gZIPInputStream4);
                                } catch (RedirectException e19) {
                                    redirectException = e19;
                                    httpConnectListener = this.mListener;
                                    if (httpConnectListener != null) {
                                    }
                                    throw redirectException;
                                } catch (HttpOverFlowException e20) {
                                    httpOverFlowException = e20;
                                    httpConnectListener2 = this.mListener;
                                    if (httpConnectListener2 != null) {
                                    }
                                    throw httpOverFlowException;
                                } catch (SSLHandshakeException e21) {
                                    e = e21;
                                    inputStream2 = inputStream;
                                    gZIPInputStream2 = gZIPInputStream4;
                                    dataInputStream3 = null;
                                    sSLHandshakeException = e;
                                    httpsURLConnection2 = httpsURLConnection8;
                                    httpConnectListener3 = this.mListener;
                                    if (httpConnectListener3 != null) {
                                    }
                                    cause = sSLHandshakeException.getCause();
                                    if (cause != null) {
                                    }
                                } catch (OutOfMemoryError e22) {
                                    e2 = e22;
                                    inputStream2 = inputStream;
                                    gZIPInputStream2 = gZIPInputStream4;
                                    dataInputStream3 = null;
                                    outOfMemoryError = e2;
                                    httpsURLConnection2 = httpsURLConnection8;
                                    httpConnectListener4 = this.mListener;
                                    if (httpConnectListener4 != null) {
                                    }
                                    outOfMemoryError.printStackTrace();
                                    byteArrayOutputStream.reset();
                                    if (dataInputStream3 != null) {
                                    }
                                    if (inputStream2 != null) {
                                    }
                                    if (gZIPInputStream2 != null) {
                                    }
                                    byteArrayOutputStream.close();
                                } catch (Throwable th7) {
                                    th2 = th7;
                                    gZIPInputStream = gZIPInputStream4;
                                    dataInputStream3 = httpsURLConnection8;
                                    dataInputStream = null;
                                    String message22 = th2.getMessage();
                                    httpConnectListener5 = this.mListener;
                                    if (httpConnectListener5 != null) {
                                    }
                                    th2.printStackTrace();
                                    byteArrayOutputStream.reset();
                                    throw new NetWorkErrorException(message22);
                                }
                            }
                            int i3 = 2048;
                            try {
                                byte[] bArr = new byte[2048];
                                int i4 = 0;
                                while (true) {
                                    int read = dataInputStream.read(bArr, 0, i3);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                    HttpConnectListener<HttpResponse> httpConnectListener8 = this.mListener;
                                    if (httpConnectListener8 != null) {
                                        i4 += read;
                                        if (i4 > contentLength) {
                                            contentLength = i4;
                                        }
                                        httpConnectListener8.onProcess((int) ((((float) i4) / ((float) contentLength)) * 100.0f));
                                        i3 = 2048;
                                    }
                                }
                                httpResponse.setData(byteArrayOutputStream.toByteArray());
                                inputStream2 = inputStream;
                                gZIPInputStream2 = gZIPInputStream3;
                                dataInputStream3 = dataInputStream;
                            } catch (RedirectException e23) {
                                redirectException = e23;
                                httpsURLConnection5 = httpsURLConnection8;
                                httpConnectListener = this.mListener;
                                if (httpConnectListener != null) {
                                }
                                throw redirectException;
                            } catch (HttpOverFlowException e24) {
                                httpOverFlowException = e24;
                                httpsURLConnection6 = httpsURLConnection8;
                                httpConnectListener2 = this.mListener;
                                if (httpConnectListener2 != null) {
                                }
                                throw httpOverFlowException;
                            } catch (SSLHandshakeException e25) {
                                inputStream2 = inputStream;
                                gZIPInputStream2 = gZIPInputStream3;
                                sSLHandshakeException = e25;
                                dataInputStream3 = dataInputStream;
                                httpsURLConnection2 = httpsURLConnection8;
                                httpConnectListener3 = this.mListener;
                                if (httpConnectListener3 != null) {
                                }
                                cause = sSLHandshakeException.getCause();
                                if (cause != null) {
                                }
                            } catch (OutOfMemoryError e26) {
                                inputStream2 = inputStream;
                                gZIPInputStream2 = gZIPInputStream3;
                                outOfMemoryError = e26;
                                dataInputStream3 = dataInputStream;
                                httpsURLConnection2 = httpsURLConnection8;
                                httpConnectListener4 = this.mListener;
                                if (httpConnectListener4 != null) {
                                }
                                outOfMemoryError.printStackTrace();
                                byteArrayOutputStream.reset();
                                if (dataInputStream3 != null) {
                                }
                                if (inputStream2 != null) {
                                }
                                if (gZIPInputStream2 != null) {
                                }
                                byteArrayOutputStream.close();
                            } catch (Throwable th8) {
                                th2 = th8;
                                gZIPInputStream = gZIPInputStream3;
                                httpsURLConnection7 = httpsURLConnection8;
                                dataInputStream3 = httpsURLConnection7;
                                String message222 = th2.getMessage();
                                httpConnectListener5 = this.mListener;
                                if (httpConnectListener5 != null) {
                                }
                                th2.printStackTrace();
                                byteArrayOutputStream.reset();
                                throw new NetWorkErrorException(message222);
                            }
                        } catch (RedirectException e27) {
                            redirectException = e27;
                            httpConnectListener = this.mListener;
                            if (httpConnectListener != null) {
                                httpConnectListener.onError(-1, "too many redirect");
                            }
                            throw redirectException;
                        } catch (HttpOverFlowException e28) {
                            httpOverFlowException = e28;
                            httpConnectListener2 = this.mListener;
                            if (httpConnectListener2 != null) {
                                httpConnectListener2.onError(-2, "connect file is too large");
                            }
                            throw httpOverFlowException;
                        } catch (SSLHandshakeException e29) {
                            e = e29;
                            inputStream2 = inputStream;
                            gZIPInputStream2 = null;
                            dataInputStream3 = null;
                            sSLHandshakeException = e;
                            httpsURLConnection2 = httpsURLConnection8;
                            httpConnectListener3 = this.mListener;
                            if (httpConnectListener3 != null) {
                                httpConnectListener3.onError(-3, "ssl handshake exception");
                            }
                            cause = sSLHandshakeException.getCause();
                            if (cause != null) {
                                if (dataInputStream3 != null) {
                                    try {
                                        dataInputStream3.close();
                                    } catch (Exception e30) {
                                        e30.printStackTrace();
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e31) {
                                        e31.printStackTrace();
                                    }
                                }
                                if (gZIPInputStream2 != null) {
                                    try {
                                        gZIPInputStream2.close();
                                    } catch (Exception e32) {
                                        e32.printStackTrace();
                                    }
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e33) {
                                    e33.printStackTrace();
                                }
                            } else {
                                try {
                                    throw cause;
                                } catch (Throwable th9) {
                                    throw new HttpsErrorException(th9.getMessage());
                                }
                            }
                        } catch (OutOfMemoryError e34) {
                            e2 = e34;
                            inputStream2 = inputStream;
                            gZIPInputStream2 = null;
                            dataInputStream3 = null;
                            outOfMemoryError = e2;
                            httpsURLConnection2 = httpsURLConnection8;
                            httpConnectListener4 = this.mListener;
                            if (httpConnectListener4 != null) {
                                httpConnectListener4.onError(-5, "out of memory error");
                            }
                            outOfMemoryError.printStackTrace();
                            byteArrayOutputStream.reset();
                            if (dataInputStream3 != null) {
                                try {
                                    dataInputStream3.close();
                                } catch (Exception e35) {
                                    e35.printStackTrace();
                                }
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e36) {
                                    e36.printStackTrace();
                                }
                            }
                            if (gZIPInputStream2 != null) {
                                try {
                                    gZIPInputStream2.close();
                                } catch (Exception e37) {
                                    e37.printStackTrace();
                                }
                            }
                            byteArrayOutputStream.close();
                        } catch (Throwable th10) {
                            th2 = th10;
                            httpURLConnection = httpsURLConnection8;
                            dataInputStream = null;
                            dataInputStream2 = httpURLConnection;
                            gZIPInputStream = null;
                            dataInputStream3 = dataInputStream2;
                            String message2222 = th2.getMessage();
                            httpConnectListener5 = this.mListener;
                            if (httpConnectListener5 != null) {
                                httpConnectListener5.onError(-4, "network exception: " + message2222);
                            }
                            th2.printStackTrace();
                            byteArrayOutputStream.reset();
                            throw new NetWorkErrorException(message2222);
                        }
                    } else {
                        throw new HttpOverFlowException("The Content-Length is too large:" + contentLength);
                    }
                }
            } catch (RedirectException e38) {
                redirectException = e38;
                httpConnectListener = this.mListener;
                if (httpConnectListener != null) {
                }
                throw redirectException;
            } catch (HttpOverFlowException e39) {
                httpOverFlowException = e39;
                httpConnectListener2 = this.mListener;
                if (httpConnectListener2 != null) {
                }
                throw httpOverFlowException;
            } catch (SSLHandshakeException e40) {
                sSLHandshakeException = e40;
                gZIPInputStream2 = null;
                httpsURLConnection3 = httpsURLConnection8;
                dataInputStream3 = null;
                inputStream2 = null;
                httpsURLConnection2 = httpsURLConnection3;
                httpConnectListener3 = this.mListener;
                if (httpConnectListener3 != null) {
                }
                cause = sSLHandshakeException.getCause();
                if (cause != null) {
                }
            } catch (OutOfMemoryError e41) {
                outOfMemoryError = e41;
                gZIPInputStream2 = null;
                httpsURLConnection4 = httpsURLConnection8;
                dataInputStream3 = null;
                inputStream2 = null;
                httpsURLConnection2 = httpsURLConnection4;
                httpConnectListener4 = this.mListener;
                if (httpConnectListener4 != null) {
                }
                outOfMemoryError.printStackTrace();
                byteArrayOutputStream.reset();
                if (dataInputStream3 != null) {
                }
                if (inputStream2 != null) {
                }
                if (gZIPInputStream2 != null) {
                }
                byteArrayOutputStream.close();
            } catch (Throwable th11) {
                th2 = th11;
                httpURLConnection = httpsURLConnection8;
                inputStream = null;
                dataInputStream = null;
                dataInputStream2 = httpURLConnection;
                gZIPInputStream = null;
                dataInputStream3 = dataInputStream2;
                String message22222 = th2.getMessage();
                httpConnectListener5 = this.mListener;
                if (httpConnectListener5 != null) {
                }
                th2.printStackTrace();
                byteArrayOutputStream.reset();
                throw new NetWorkErrorException(message22222);
            }
            try {
                HttpConnectListener<HttpResponse> httpConnectListener9 = this.mListener;
                if (httpConnectListener9 != null) {
                    httpConnectListener9.onFinish(httpResponse, 0);
                }
                if (dataInputStream3 != null) {
                    try {
                        dataInputStream3.close();
                    } catch (Exception e42) {
                        e42.printStackTrace();
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e43) {
                        e43.printStackTrace();
                    }
                }
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (Exception e44) {
                        e44.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e45) {
                    e45.printStackTrace();
                }
                httpsURLConnection8.disconnect();
                return httpResponse;
            } catch (RedirectException e46) {
                redirectException = e46;
                httpConnectListener = this.mListener;
                if (httpConnectListener != null) {
                }
                throw redirectException;
            } catch (HttpOverFlowException e47) {
                httpOverFlowException = e47;
                httpConnectListener2 = this.mListener;
                if (httpConnectListener2 != null) {
                }
                throw httpOverFlowException;
            } catch (SSLHandshakeException e48) {
                e = e48;
                sSLHandshakeException = e;
                httpsURLConnection2 = httpsURLConnection8;
                httpConnectListener3 = this.mListener;
                if (httpConnectListener3 != null) {
                }
                cause = sSLHandshakeException.getCause();
                if (cause != null) {
                }
            } catch (OutOfMemoryError e49) {
                e2 = e49;
                outOfMemoryError = e2;
                httpsURLConnection2 = httpsURLConnection8;
                httpConnectListener4 = this.mListener;
                if (httpConnectListener4 != null) {
                }
                outOfMemoryError.printStackTrace();
                byteArrayOutputStream.reset();
                if (dataInputStream3 != null) {
                }
                if (inputStream2 != null) {
                }
                if (gZIPInputStream2 != null) {
                }
                byteArrayOutputStream.close();
            } catch (Throwable th12) {
                dataInputStream = dataInputStream3;
                inputStream = inputStream2;
                gZIPInputStream = gZIPInputStream2;
                dataInputStream3 = httpsURLConnection8;
                th2 = th12;
                String message222222 = th2.getMessage();
                httpConnectListener5 = this.mListener;
                if (httpConnectListener5 != null) {
                }
                th2.printStackTrace();
                byteArrayOutputStream.reset();
                throw new NetWorkErrorException(message222222);
            }
        } catch (RedirectException e50) {
            redirectException = e50;
            httpConnectListener = this.mListener;
            if (httpConnectListener != null) {
            }
            throw redirectException;
        } catch (HttpOverFlowException e51) {
            httpOverFlowException = e51;
            httpConnectListener2 = this.mListener;
            if (httpConnectListener2 != null) {
            }
            throw httpOverFlowException;
        } catch (SSLHandshakeException e52) {
            sSLHandshakeException = e52;
            gZIPInputStream2 = null;
            httpsURLConnection3 = null;
            dataInputStream3 = null;
            inputStream2 = null;
            httpsURLConnection2 = httpsURLConnection3;
            httpConnectListener3 = this.mListener;
            if (httpConnectListener3 != null) {
            }
            cause = sSLHandshakeException.getCause();
            if (cause != null) {
            }
        } catch (OutOfMemoryError e53) {
            outOfMemoryError = e53;
            gZIPInputStream2 = null;
            httpsURLConnection4 = null;
            dataInputStream3 = null;
            inputStream2 = null;
            httpsURLConnection2 = httpsURLConnection4;
            httpConnectListener4 = this.mListener;
            if (httpConnectListener4 != null) {
            }
            outOfMemoryError.printStackTrace();
            byteArrayOutputStream.reset();
            if (dataInputStream3 != null) {
            }
            if (inputStream2 != null) {
            }
            if (gZIPInputStream2 != null) {
            }
            byteArrayOutputStream.close();
        } catch (Throwable th13) {
            th2 = th13;
            inputStream = null;
            dataInputStream = null;
            dataInputStream2 = null;
            gZIPInputStream = null;
            dataInputStream3 = dataInputStream2;
            String message2222222 = th2.getMessage();
            httpConnectListener5 = this.mListener;
            if (httpConnectListener5 != null) {
            }
            th2.printStackTrace();
            byteArrayOutputStream.reset();
            throw new NetWorkErrorException(message2222222);
        }
    }

    private void setConnectProp(HttpURLConnection httpURLConnection, HttpRequest httpRequest) {
        int retryTime = httpRequest.getRetryTime() + 1;
        httpURLConnection.setConnectTimeout(httpRequest.getConnectTimeout() * retryTime);
        httpURLConnection.setReadTimeout(httpRequest.getReadTimeout() * retryTime);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty(BizTime.HOST, httpRequest.getUri().getHost());
        httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String cookie = WVCookieManager.getCookie(httpURLConnection.getURL().toString());
        if (cookie != null) {
            httpURLConnection.setRequestProperty(IRequestConst.COOKIE, cookie);
        }
        Map<String, String> headers = httpRequest.getHeaders();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        httpURLConnection.setUseCaches(false);
    }

    public HttpResponse syncConnect(String str) {
        return syncConnect(new HttpRequest(str), null);
    }

    public HttpResponse syncConnect(HttpRequest httpRequest) {
        return syncConnect(httpRequest, null);
    }

    public HttpResponse syncConnect(HttpRequest httpRequest, HttpConnectListener<HttpResponse> httpConnectListener) {
        Objects.requireNonNull(httpRequest, "Http connect error, request is null");
        String str = null;
        this.mListener = httpConnectListener;
        int i = 0;
        this.redirectTime = 0;
        int retryTime = httpRequest.getRetryTime();
        while (i < retryTime) {
            try {
                return dataConnect(httpRequest);
            } catch (NetWorkErrorException e) {
                e.printStackTrace();
                str = e.toString();
                i++;
                try {
                    Thread.sleep((long) (i * 2 * 1000));
                } catch (InterruptedException unused) {
                    TaoLog.e(TAG, "HttpConnector retry Sleep has been interrupted, go ahead");
                }
            } catch (HttpOverFlowException e2) {
                e2.printStackTrace();
                str = e2.toString();
            } catch (RedirectException e3) {
                e3.printStackTrace();
                str = e3.toString();
            } catch (HttpsErrorException e4) {
                e4.printStackTrace();
                str = e4.toString();
            }
        }
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setErrorMsg(str);
        return httpResponse;
    }
}
