package com.meizu.cloud.pushsdk.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import mtopsdk.network.util.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class b {
    private static final String a = "b";
    private static final Object b = new Object();
    private static b c;

    private b(Context context) {
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        } catch (Exception e) {
            e.printStackTrace();
        }
        a.a(context);
    }

    public static b a(Context context) {
        if (c == null) {
            synchronized (b) {
                if (c == null) {
                    c = new b(context);
                }
            }
        }
        return c;
    }

    private Map<String, String> a(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>(2);
        }
        byte[] c2 = a.a().c();
        if (c2 == null || c2.length <= 0) {
            byte[] b2 = a.a().b();
            if (b2 != null && b2.length > 0) {
                String str = new String(a.a().b());
                String str2 = a;
                DebugLogger.d(str2, "attach x_a_key: " + str);
                map.put("X-A-Key", str);
            }
        } else {
            String str3 = new String(c2);
            String str4 = a;
            DebugLogger.d(str4, "attach x_s_key: " + str3);
            map.put("X-S-Key", str3);
        }
        return map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a A[SYNTHETIC, Splitter:B:12:0x001a] */
    private void a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        Throwable th;
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(httpURLConnection.getOutputStream());
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.flush();
                try {
                    gZIPOutputStream2.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = gZIPOutputStream2;
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (gZIPOutputStream != null) {
            }
            throw th;
        }
    }

    private void a(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("X-S-Key");
            String str = a;
            DebugLogger.d(str, "get x_s_key = " + headerField);
            if (!TextUtils.isEmpty(headerField)) {
                a.a().a(headerField);
            }
        } catch (NullPointerException unused) {
        }
    }

    private byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fc, code lost:
        if (r1 != null) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0123, code lost:
        if (r1 != null) goto L_0x00fe;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012a A[SYNTHETIC, Splitter:B:49:0x012a] */
    private c b(String str, Map<String, String> map, String str2) throws Exception {
        HttpURLConnection httpURLConnection;
        Throwable th;
        Exception e;
        InputStream inputStream;
        byte[] bArr;
        c cVar = null;
        InputStream inputStream2 = null;
        cVar = null;
        cVar = null;
        cVar = null;
        if (str2 != null) {
            byte[] a2 = a.a().a(str2.getBytes());
            String str3 = a2 != null ? new String(Base64.encode(a2, 2)) : null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(PushConstants.URL_UPLOAD_DATA).openConnection();
                httpURLConnection.setRequestMethod(str);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, "keep-alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", IRequestConst.CONTENT_TYPE_POST);
                httpURLConnection.setRequestProperty(Constants.Protocol.CONTENT_ENCODING, "gzip");
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                if (str3 != null) {
                    try {
                        a(httpURLConnection, str3.getBytes());
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = null;
                        try {
                            DebugLogger.e(a, "realStringPartRequest error " + e.getMessage());
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream2 = inputStream;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException unused) {
                                }
                            }
                            httpURLConnection.disconnect();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStream2 != null) {
                        }
                        httpURLConnection.disconnect();
                        throw th;
                    }
                }
                int responseCode = httpURLConnection.getResponseCode();
                String str4 = a;
                DebugLogger.d(str4, "code = " + responseCode);
                a(httpURLConnection);
                b(httpURLConnection);
                inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    try {
                        bArr = a(inputStream);
                        if (bArr != null) {
                            String str5 = new String(bArr);
                            DebugLogger.d(str4, "body = " + str5);
                            try {
                                new JSONObject(str5).getInt("code");
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        DebugLogger.e(a, "realStringPartRequest error " + e.getMessage());
                    }
                } else {
                    bArr = null;
                }
                cVar = bArr != null ? new c(responseCode, new String(bArr)) : new c(responseCode, null);
            } catch (MalformedURLException e5) {
                e5.printStackTrace();
            }
        }
        return cVar;
        httpURLConnection.disconnect();
        return cVar;
    }

    private void b(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("Key-Timeout");
            String str = a;
            DebugLogger.d(str, "get keyTimeout = " + headerField);
        } catch (NullPointerException unused) {
        }
    }

    public c a(String str, Map<String, String> map, String str2) {
        try {
            return b(str, a(map), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
