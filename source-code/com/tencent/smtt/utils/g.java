package com.tencent.smtt.utils;

import android.os.Build;
import com.lzy.okgo.model.HttpHeaders;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* compiled from: HttpUtil */
public class g {

    /* compiled from: HttpUtil */
    public interface a {
        void a(int i);
    }

    public static String a(String str, byte[] bArr, a aVar, boolean z) {
        String str2;
        if (z) {
            try {
                str2 = i.a().c();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            str2 = h.a().b();
        }
        String str3 = str + str2;
        if (z) {
            try {
                bArr = i.a().a(bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            bArr = h.a().a(bArr);
        }
        if (bArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded");
        hashMap.put(HttpHeaders.HEAD_KEY_CONTENT_LENGTH, String.valueOf(bArr.length));
        HttpURLConnection a2 = a(str3, hashMap);
        if (a2 == null) {
            return null;
        }
        b(a2, bArr);
        return a(a2, aVar, z);
    }

    public static String a(String str, Map<String, String> map, byte[] bArr, a aVar, boolean z) {
        HttpURLConnection a2;
        if (bArr == null || (a2 = a(str, map)) == null) {
            return null;
        }
        if (z) {
            a(a2, bArr);
        } else {
            b(a2, bArr);
        }
        return a(a2, aVar, false);
    }

    private static HttpURLConnection a(String str, Map<String, String> map) {
        Exception e;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setConnectTimeout(20000);
                if (Build.VERSION.SDK_INT > 13) {
                    httpURLConnection2.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE);
                } else {
                    httpURLConnection2.setRequestProperty("http.keepAlive", "false");
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                }
                return httpURLConnection2;
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = httpURLConnection2;
                e.printStackTrace();
                return httpURLConnection;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return httpURLConnection;
        }
    }

    private static void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        Throwable th;
        GZIPOutputStream gZIPOutputStream;
        Exception e;
        try {
            gZIPOutputStream = new GZIPOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream(), 204800));
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.flush();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            gZIPOutputStream = null;
            try {
                e.printStackTrace();
                a(null);
                a(gZIPOutputStream);
            } catch (Throwable th2) {
                th = th2;
                a(null);
                a(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
            a(null);
            a(gZIPOutputStream);
            throw th;
        }
        a(null);
        a(gZIPOutputStream);
    }

    private static void b(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            a(outputStream);
            throw th;
        }
        a(outputStream);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v8, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A[Catch:{ all -> 0x0073 }, LOOP:0: B:22:0x0046->B:24:0x004d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0054 A[Catch:{ all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0061 A[Catch:{ all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0052 A[EDGE_INSN: B:43:0x0052->B:25:0x0052 ?: BREAK  , SYNTHETIC] */
    private static String a(HttpURLConnection httpURLConnection, a aVar, boolean z) {
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        String str;
        Closeable closeable;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        int read;
        InputStream inflaterInputStream;
        InputStream inputStream3 = null;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (aVar != null) {
                aVar.a(responseCode);
            }
            if (responseCode == 200) {
                InputStream inputStream4 = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                    if (contentEncoding != null && contentEncoding.equalsIgnoreCase("deflate")) {
                        inflaterInputStream = new InflaterInputStream(inputStream4, new Inflater(true));
                    }
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    bArr = new byte[128];
                    while (true) {
                        read = inputStream4.read(bArr);
                        if (read != -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!z) {
                        str = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                    } else {
                        str = new String(h.a().c(byteArrayOutputStream.toByteArray()));
                    }
                    inputStream3 = inputStream4;
                    closeable = byteArrayOutputStream;
                } else {
                    inflaterInputStream = new GZIPInputStream(inputStream4);
                }
                inputStream4 = inflaterInputStream;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream4;
                    inputStream2 = null;
                    try {
                        th.printStackTrace();
                        return null;
                    } finally {
                        a(inputStream);
                        a(inputStream2);
                    }
                }
                try {
                    bArr = new byte[128];
                    while (true) {
                        read = inputStream4.read(bArr);
                        if (read != -1) {
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!z) {
                    }
                    inputStream3 = inputStream4;
                    closeable = byteArrayOutputStream;
                } catch (Throwable th3) {
                    inputStream2 = byteArrayOutputStream;
                    th = th3;
                    inputStream = inputStream4;
                    th.printStackTrace();
                    return null;
                }
            } else {
                closeable = null;
                str = null;
            }
            a(inputStream3);
            a(closeable);
            return str;
        } catch (Throwable th4) {
            th = th4;
            inputStream2 = null;
            inputStream = inputStream2;
            th.printStackTrace();
            return null;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
