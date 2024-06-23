package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a.f;
import com.tencent.open.a.g;
import com.tencent.open.b.h;
import com.tencent.open.log.SLog;
import com.tencent.open.log.d;
import com.tencent.tauth.IRequestListener;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class HttpUtils {

    /* compiled from: Taobao */
    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    public static class a {
        public final String a;
        public final int b;

        private a(String str, int i) {
            this.a = str;
            this.b = i;
        }
    }

    private HttpUtils() {
    }

    private static void a(Context context, QQToken qQToken, String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            com.tencent.connect.a.a.a(context, qQToken, "requireApi", str);
        }
    }

    private static Map<String, byte[]> b(Bundle bundle) {
        HashMap hashMap = new HashMap(0);
        if (!(bundle == null || bundle.size() == 0)) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof byte[]) {
                    hashMap.put(str, (byte[]) obj);
                }
            }
        }
        return hashMap;
    }

    public static String encodeUrl(Bundle bundle) {
        return encodeUrl(a(bundle));
    }

    public static int getErrorCodeFromException(IOException iOException) {
        if (iOException instanceof CharConversionException) {
            return -20;
        }
        if (iOException instanceof MalformedInputException) {
            return -21;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof EOFException) {
            return -26;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof HttpRetryException) {
            return -29;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof MalformedURLException) {
            return -3;
        }
        if (iOException instanceof InvalidClassException) {
            return -33;
        }
        if (iOException instanceof InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof NotActiveException) {
            return -35;
        }
        if (iOException instanceof NotSerializableException) {
            return -36;
        }
        if (iOException instanceof OptionalDataException) {
            return -37;
        }
        if (iOException instanceof StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof ProtocolException) {
            return -40;
        }
        if (iOException instanceof SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof SSLKeyException) {
            return -42;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof BindException) {
            return -45;
        }
        if (iOException instanceof ConnectException) {
            return -46;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof SyncFailedException) {
            return -49;
        }
        if (iOException instanceof UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof UnknownHostException) {
            return -51;
        }
        if (iOException instanceof UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return -53;
        }
        return iOException instanceof ZipException ? -54 : -2;
    }

    public static a getProxy(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            networkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.getType() == 0) {
            String b = b(context);
            int a2 = a(context);
            if (!TextUtils.isEmpty(b) && a2 >= 0) {
                return new a(b, a2);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00f6, code lost:
        r4 = -4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0106, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0107, code lost:
        r17 = r0;
        r0 = r1;
        r1 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0128, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x012a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x012b, code lost:
        r0.printStackTrace();
        com.tencent.open.b.h.a().a(r13, r15, 0, 0, -4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x013c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x013d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x013e, code lost:
        r0.printStackTrace();
        com.tencent.open.b.h.a().a(r13, r15, 0, 0, getErrorCodeFromException(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0152, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0153, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0154, code lost:
        r0.printStackTrace();
        com.tencent.open.b.h.a().a(r13, r15, 0, 0, -3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0165, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0178, code lost:
        r15 = android.os.SystemClock.elapsedRealtime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x017c, code lost:
        if (r1 >= r14) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x017e, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x018d, code lost:
        com.tencent.open.b.h.a().a(r13, r15, 0, 0, -8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0196, code lost:
        throw r17;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0106 A[ExcHandler: SocketTimeoutException (r0v16 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), Splitter:B:16:0x00e7] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x012a A[ExcHandler: JSONException (r0v12 'e' org.json.JSONException A[CUSTOM_DECLARE]), Splitter:B:12:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x013d A[ExcHandler: IOException (r0v11 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:12:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0153 A[ExcHandler: MalformedURLException (r0v10 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:12:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x018d A[SYNTHETIC] */
    public static JSONObject request(QQToken qQToken, Context context, String str, Bundle bundle, String str2) throws IOException, JSONException, NetworkUnavailableException, HttpStatusException {
        String str3;
        QQToken qQToken2;
        String str4;
        int i;
        long j;
        long j2;
        JSONObject jSONObject;
        int i2;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        g a2;
        int i3;
        SLog.i("openSDK_LOG.HttpUtils", "OpenApi request");
        if (m.b(context)) {
            if (!str.toLowerCase().startsWith("http")) {
                str4 = j.a().a(context, "https://openmobile.qq.com/") + str;
                str3 = j.a().a(context, "https://openmobile.qq.com/") + str;
                qQToken2 = qQToken;
            } else {
                qQToken2 = qQToken;
                str4 = str;
                str3 = str4;
            }
            a(context, qQToken2, str);
            JSONObject jSONObject4 = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i4 = 0;
            int a3 = i.a(context, qQToken.getAppId()).a("Common_HttpRetryCount");
            SLog.v("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + a3 + "   appid:" + qQToken.getAppId() + "     url:" + str3);
            int i5 = a3 == 0 ? 3 : a3;
            SLog.v("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + i5 + "   appid:" + qQToken.getAppId() + "     url:" + str3);
            long j3 = elapsedRealtime;
            while (true) {
                int i6 = i4 + 1;
                try {
                    a2 = a(str4, str2, bundle);
                    int d = a2.d();
                    SLog.i("openSDK_LOG.HttpUtils", "request statusCode " + d);
                    if (d == 200) {
                        jSONObject = m.d(a2.a());
                        i3 = jSONObject.getInt("ret");
                        break;
                    }
                    jSONObject3 = jSONObject4;
                    i2 = i6;
                    h.a().a(str3, j3, 0, 0, d);
                    throw new HttpStatusException(d);
                } catch (SocketTimeoutException e) {
                    SocketTimeoutException e2 = e;
                    jSONObject3 = jSONObject4;
                    i2 = i6;
                    SocketTimeoutException socketTimeoutException = e2;
                    jSONObject2 = jSONObject3;
                    socketTimeoutException.printStackTrace();
                    i = -8;
                    j2 = 0;
                    j = 0;
                    if (i2 < i5) {
                    }
                } catch (MalformedURLException e3) {
                } catch (IOException e4) {
                } catch (JSONException e5) {
                }
                i4 = i2;
                jSONObject4 = jSONObject2;
            }
            h.a().a(str3, j3, j2, j, i);
            return jSONObject;
        }
        throw new NetworkUnavailableException(NetworkUnavailableException.ERROR_INFO);
        j = (long) a2.b();
        i = i3;
        j2 = (long) a2.c();
        h.a().a(str3, j3, j2, j, i);
        return jSONObject;
    }

    public static void requestAsync(final QQToken qQToken, final Context context, final String str, final Bundle bundle, final String str2, final IRequestListener iRequestListener) {
        SLog.i("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        l.a(new Runnable() {
            /* class com.tencent.open.utils.HttpUtils.AnonymousClass1 */

            public void run() {
                try {
                    JSONObject request = HttpUtils.request(qQToken, context, str, bundle, str2);
                    IRequestListener iRequestListener = iRequestListener;
                    if (iRequestListener != null) {
                        iRequestListener.onComplete(request);
                        SLog.i("openSDK_LOG.HttpUtils", "OpenApi onComplete");
                    }
                } catch (MalformedURLException e2) {
                    IRequestListener iRequestListener2 = iRequestListener;
                    if (iRequestListener2 != null) {
                        iRequestListener2.onMalformedURLException(e2);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException" + e2.toString());
                    }
                } catch (SocketTimeoutException e3) {
                    IRequestListener iRequestListener3 = iRequestListener;
                    if (iRequestListener3 != null) {
                        iRequestListener3.onSocketTimeoutException(e3);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException" + e3.toString());
                    }
                } catch (NetworkUnavailableException e4) {
                    IRequestListener iRequestListener4 = iRequestListener;
                    if (iRequestListener4 != null) {
                        iRequestListener4.onNetworkUnavailableException(e4);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException" + e4.toString());
                    }
                } catch (HttpStatusException e5) {
                    IRequestListener iRequestListener5 = iRequestListener;
                    if (iRequestListener5 != null) {
                        iRequestListener5.onHttpStatusException(e5);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException" + e5.toString());
                    }
                } catch (IOException e6) {
                    IRequestListener iRequestListener6 = iRequestListener;
                    if (iRequestListener6 != null) {
                        iRequestListener6.onIOException(e6);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException" + e6.toString());
                    }
                } catch (JSONException e7) {
                    IRequestListener iRequestListener7 = iRequestListener;
                    if (iRequestListener7 != null) {
                        iRequestListener7.onJSONException(e7);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException" + e7.toString());
                    }
                } catch (Exception e8) {
                    IRequestListener iRequestListener8 = iRequestListener;
                    if (iRequestListener8 != null) {
                        iRequestListener8.onUnknowException(e8);
                        SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException" + e8.toString());
                    }
                }
            }
        });
    }

    /* compiled from: Taobao */
    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";
        public final int statusCode;

        public HttpStatusException(String str) {
            super(str);
            this.statusCode = -1;
        }

        public HttpStatusException(int i) {
            super(ERROR_INFO + i);
            this.statusCode = i;
        }
    }

    public static String encodeUrl(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : map.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(str));
            sb.append("=");
            sb.append(URLEncoder.encode(map.get(str)));
        }
        return sb.toString();
    }

    private static String b(Context context) {
        if (Build.VERSION.SDK_INT >= 11) {
            return System.getProperty("http.proxyHost");
        }
        if (context == null) {
            return Proxy.getDefaultHost();
        }
        String host = Proxy.getHost(context);
        if (TextUtils.isEmpty(host)) {
            return Proxy.getDefaultHost();
        }
        return host;
    }

    private static g a(String str, String str2, Bundle bundle) throws IOException {
        Bundle bundle2;
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        if (str2.equalsIgnoreCase("GET")) {
            Map<String, String> a2 = a(bundle2);
            Bundle b = d.b(bundle2);
            if (b != bundle2) {
                SLog.i("openSDK_LOG.HttpUtils", "-->openUrl encodedParam =" + b.toString() + " -- url = " + str);
            } else {
                SLog.i("openSDK_LOG.HttpUtils", "-->openUrl encodedParam =" + a2.toString() + " -- url = " + str);
            }
            return f.a().a(str, a2);
        } else if (str2.equalsIgnoreCase("POST")) {
            Map<String, String> a3 = a(bundle2);
            Map<String, byte[]> b2 = b(bundle2);
            if (b2 == null || b2.size() == 0) {
                return f.a().b(str, a3);
            }
            SLog.w("openSDK_LOG.HttpUtils", "openUrl: has binary " + b2.size());
            return f.a().a(str, a3, b2);
        } else {
            SLog.e("openSDK_LOG.HttpUtils", "openUrl: http method " + str2 + " is not supported.");
            throw new IOException("http method is not supported.");
        }
    }

    private static Map<String, String> a(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (!(bundle == null || bundle.size() == 0)) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (!(obj instanceof String) && !(obj instanceof String[])) {
                    SLog.w("openSDK_LOG.HttpUtils", "parseBundleToMap: the type " + obj.getClass() + " is unsupported");
                } else if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < strArr.length; i++) {
                        if (i != 0) {
                            sb.append(",");
                        }
                        sb.append(strArr[i]);
                    }
                    hashMap.put(str, sb.toString());
                } else {
                    hashMap.put(str, (String) obj);
                }
            }
        }
        return hashMap;
    }

    private static int a(Context context) {
        if (Build.VERSION.SDK_INT >= 11) {
            String property = System.getProperty("http.proxyPort");
            if (!TextUtils.isEmpty(property)) {
                try {
                    return Integer.parseInt(property);
                } catch (NumberFormatException unused) {
                }
            }
            return -1;
        } else if (context == null) {
            return Proxy.getDefaultPort();
        } else {
            int port = Proxy.getPort(context);
            if (port < 0) {
                return Proxy.getDefaultPort();
            }
            return port;
        }
    }
}
