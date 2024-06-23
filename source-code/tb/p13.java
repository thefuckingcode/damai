package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.efs.sdk.base.http.IHttpUtil;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Map;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
public final class p13 implements IHttpUtil {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        private static final p13 a = new p13((byte) 0);
    }

    private p13() {
    }

    /* synthetic */ p13(byte b) {
        this();
    }

    private static HttpURLConnection a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        if (map == null) {
            map = Collections.emptyMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return httpURLConnection;
    }

    @NonNull
    private static vy0 b(@NonNull String str, @Nullable Map<String, String> map, @Nullable File file, @Nullable byte[] bArr) {
        FileInputStream fileInputStream;
        Throwable th;
        DataOutputStream dataOutputStream;
        OutputStream outputStream;
        String str2;
        vy0 vy0 = new vy0();
        HttpURLConnection httpURLConnection = null;
        FileInputStream fileInputStream2 = null;
        httpURLConnection = null;
        httpURLConnection = null;
        try {
            HttpURLConnection a2 = a(str, map);
            try {
                a2.setRequestMethod("POST");
                a2.setRequestProperty(IRequestConst.CONNECTION, "close");
                a2.setRequestProperty("Content-Type", "multipart/form-data;boundary=----WebKitFormBoundaryP0Rfzlf32iRoMhmb");
                outputStream = a2.getOutputStream();
                try {
                    dataOutputStream = new DataOutputStream(outputStream);
                } catch (UnknownHostException e) {
                    th = e;
                    fileInputStream = null;
                    dataOutputStream = null;
                    httpURLConnection = a2;
                    vy0.e(-2);
                    str2 = "post file '" + str + "' error， maybe network is disconnect";
                    t43.c("efs.util.http", str2, th);
                    e(httpURLConnection);
                    w23.c(outputStream);
                    w23.c(dataOutputStream);
                    w23.c(fileInputStream);
                    vy0.f(str);
                    return vy0;
                } catch (SocketTimeoutException e2) {
                    th = e2;
                    fileInputStream = null;
                    dataOutputStream = null;
                    httpURLConnection = a2;
                    vy0.e(-3);
                    str2 = "post file '" + str + "' error";
                    t43.c("efs.util.http", str2, th);
                    e(httpURLConnection);
                    w23.c(outputStream);
                    w23.c(dataOutputStream);
                    w23.c(fileInputStream);
                    vy0.f(str);
                    return vy0;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    dataOutputStream = null;
                    httpURLConnection = a2;
                    try {
                        str2 = "post file '" + str + "' error";
                        t43.c("efs.util.http", str2, th);
                        e(httpURLConnection);
                        w23.c(outputStream);
                        w23.c(dataOutputStream);
                        w23.c(fileInputStream);
                        vy0.f(str);
                        return vy0;
                    } catch (Throwable th3) {
                        e(httpURLConnection);
                        w23.c(outputStream);
                        w23.c(dataOutputStream);
                        w23.c(fileInputStream);
                        throw th3;
                    }
                }
                try {
                    dataOutputStream.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb\r\n");
                    if (bArr != null) {
                        dataOutputStream.writeBytes("Content-Disposition: form-data;name=\"file\";filename=\"f\"\r\n");
                        dataOutputStream.writeBytes(SocketClient.NETASCII_EOL);
                        dataOutputStream.write(bArr, 0, bArr.length);
                    } else if (file == null || !file.exists()) {
                        e(a2);
                        w23.c(outputStream);
                        w23.c(dataOutputStream);
                        w23.c(null);
                        return vy0;
                    } else {
                        dataOutputStream.writeBytes("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
                        dataOutputStream.writeBytes(SocketClient.NETASCII_EOL);
                        fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr2 = new byte[4096];
                            while (true) {
                                int read = fileInputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                dataOutputStream.write(bArr2, 0, read);
                            }
                            fileInputStream2 = fileInputStream;
                        } catch (UnknownHostException e3) {
                            th = e3;
                            httpURLConnection = a2;
                            vy0.e(-2);
                            str2 = "post file '" + str + "' error， maybe network is disconnect";
                            t43.c("efs.util.http", str2, th);
                            e(httpURLConnection);
                            w23.c(outputStream);
                            w23.c(dataOutputStream);
                            w23.c(fileInputStream);
                            vy0.f(str);
                            return vy0;
                        } catch (SocketTimeoutException e4) {
                            th = e4;
                            httpURLConnection = a2;
                            vy0.e(-3);
                            str2 = "post file '" + str + "' error";
                            t43.c("efs.util.http", str2, th);
                            e(httpURLConnection);
                            w23.c(outputStream);
                            w23.c(dataOutputStream);
                            w23.c(fileInputStream);
                            vy0.f(str);
                            return vy0;
                        } catch (Throwable th4) {
                            th = th4;
                            httpURLConnection = a2;
                            str2 = "post file '" + str + "' error";
                            t43.c("efs.util.http", str2, th);
                            e(httpURLConnection);
                            w23.c(outputStream);
                            w23.c(dataOutputStream);
                            w23.c(fileInputStream);
                            vy0.f(str);
                            return vy0;
                        }
                    }
                    dataOutputStream.writeBytes(SocketClient.NETASCII_EOL);
                    dataOutputStream.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb--\r\n");
                    vy0 = c(a2);
                    e(a2);
                    w23.c(outputStream);
                    w23.c(dataOutputStream);
                    w23.c(fileInputStream2);
                } catch (UnknownHostException e5) {
                    th = e5;
                    fileInputStream = null;
                    httpURLConnection = a2;
                    vy0.e(-2);
                    str2 = "post file '" + str + "' error， maybe network is disconnect";
                    t43.c("efs.util.http", str2, th);
                    e(httpURLConnection);
                    w23.c(outputStream);
                    w23.c(dataOutputStream);
                    w23.c(fileInputStream);
                    vy0.f(str);
                    return vy0;
                } catch (SocketTimeoutException e6) {
                    th = e6;
                    fileInputStream = null;
                    httpURLConnection = a2;
                    vy0.e(-3);
                    str2 = "post file '" + str + "' error";
                    t43.c("efs.util.http", str2, th);
                    e(httpURLConnection);
                    w23.c(outputStream);
                    w23.c(dataOutputStream);
                    w23.c(fileInputStream);
                    vy0.f(str);
                    return vy0;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = null;
                    httpURLConnection = a2;
                    str2 = "post file '" + str + "' error";
                    t43.c("efs.util.http", str2, th);
                    e(httpURLConnection);
                    w23.c(outputStream);
                    w23.c(dataOutputStream);
                    w23.c(fileInputStream);
                    vy0.f(str);
                    return vy0;
                }
            } catch (UnknownHostException e7) {
                th = e7;
                fileInputStream = null;
                outputStream = null;
                dataOutputStream = null;
                httpURLConnection = a2;
                vy0.e(-2);
                str2 = "post file '" + str + "' error， maybe network is disconnect";
                t43.c("efs.util.http", str2, th);
                e(httpURLConnection);
                w23.c(outputStream);
                w23.c(dataOutputStream);
                w23.c(fileInputStream);
                vy0.f(str);
                return vy0;
            } catch (SocketTimeoutException e8) {
                th = e8;
                fileInputStream = null;
                outputStream = null;
                dataOutputStream = null;
                httpURLConnection = a2;
                vy0.e(-3);
                str2 = "post file '" + str + "' error";
                t43.c("efs.util.http", str2, th);
                e(httpURLConnection);
                w23.c(outputStream);
                w23.c(dataOutputStream);
                w23.c(fileInputStream);
                vy0.f(str);
                return vy0;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
                outputStream = null;
                dataOutputStream = null;
                httpURLConnection = a2;
                str2 = "post file '" + str + "' error";
                t43.c("efs.util.http", str2, th);
                e(httpURLConnection);
                w23.c(outputStream);
                w23.c(dataOutputStream);
                w23.c(fileInputStream);
                vy0.f(str);
                return vy0;
            }
        } catch (UnknownHostException e9) {
            th = e9;
            fileInputStream = null;
            outputStream = null;
            dataOutputStream = null;
            vy0.e(-2);
            str2 = "post file '" + str + "' error， maybe network is disconnect";
            t43.c("efs.util.http", str2, th);
            e(httpURLConnection);
            w23.c(outputStream);
            w23.c(dataOutputStream);
            w23.c(fileInputStream);
            vy0.f(str);
            return vy0;
        } catch (SocketTimeoutException e10) {
            th = e10;
            fileInputStream = null;
            outputStream = null;
            dataOutputStream = null;
            vy0.e(-3);
            str2 = "post file '" + str + "' error";
            t43.c("efs.util.http", str2, th);
            e(httpURLConnection);
            w23.c(outputStream);
            w23.c(dataOutputStream);
            w23.c(fileInputStream);
            vy0.f(str);
            return vy0;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
            outputStream = null;
            dataOutputStream = null;
            str2 = "post file '" + str + "' error";
            t43.c("efs.util.http", str2, th);
            e(httpURLConnection);
            w23.c(outputStream);
            w23.c(dataOutputStream);
            w23.c(fileInputStream);
            vy0.f(str);
            return vy0;
        }
        vy0.f(str);
        return vy0;
    }

    private static vy0 c(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        vy0 vy0 = new vy0();
        if (httpURLConnection == null) {
            return vy0;
        }
        try {
            vy0.e(httpURLConnection.getResponseCode());
            inputStream = httpURLConnection.getInputStream();
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            t43.c("efs.util.http", "get response error", th);
                            w23.c(inputStream);
                            w23.c(byteArrayOutputStream);
                            return vy0;
                        } catch (Throwable th3) {
                            w23.c(inputStream);
                            w23.c(byteArrayOutputStream);
                            throw th3;
                        }
                    }
                }
                vy0.c = byteArrayOutputStream.toString();
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                t43.c("efs.util.http", "get response error", th);
                w23.c(inputStream);
                w23.c(byteArrayOutputStream);
                return vy0;
            }
        } catch (Throwable th5) {
            byteArrayOutputStream = null;
            th = th5;
            inputStream = null;
            t43.c("efs.util.http", "get response error", th);
            w23.c(inputStream);
            w23.c(byteArrayOutputStream);
            return vy0;
        }
        w23.c(inputStream);
        w23.c(byteArrayOutputStream);
        return vy0;
    }

    public static p13 d() {
        return a.a;
    }

    private static void e(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                w23.c(httpURLConnection.getInputStream());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final vy0 get(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        String str2;
        vy0 vy0 = new vy0();
        int i = 0;
        while (true) {
            if (i >= 3) {
                break;
            }
            httpURLConnection = null;
            try {
                httpURLConnection = a(str, map);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
                httpURLConnection.connect();
                vy0 = c(httpURLConnection);
                e(httpURLConnection);
                break;
            } catch (UnknownHostException e) {
                e = e;
                vy0.e(-2);
                str2 = "get request '" + str + "' error， maybe network is disconnect";
            } catch (SocketTimeoutException e2) {
                e = e2;
                vy0.e(-3);
                str2 = "post file '" + str + "' error";
            } catch (Throwable th) {
                e(httpURLConnection);
                throw th;
            }
            e(httpURLConnection);
        }
        vy0.f(str);
        return vy0;
        t43.c("efs.util.http", str2, e);
        e(httpURLConnection);
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final vy0 post(@NonNull String str, @Nullable Map<String, String> map, @NonNull File file) {
        return b(str, map, file, null);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x000a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v13 */
    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final vy0 post(@NonNull String str, @Nullable Map<String, String> map, @NonNull byte[] bArr) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        String str2;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3;
        HttpURLConnection httpURLConnection4;
        vy0 vy0 = new vy0();
        OutputStream outputStream = null;
        try {
            HttpURLConnection a2 = a(str, map);
            try {
                a2.setRequestMethod("POST");
                a2.setRequestProperty(IRequestConst.CONNECTION, "close");
                outputStream = a2.getOutputStream();
                outputStream.write(bArr);
                vy0 = c(a2);
                httpURLConnection4 = a2;
            } catch (UnknownHostException e) {
                th = e;
                httpURLConnection = a2;
                vy0.e(-2);
                str2 = "post data to '" + str + "' error， maybe network is disconnect";
                httpURLConnection3 = httpURLConnection;
                t43.c("efs.util.http", str2, th);
                httpURLConnection4 = httpURLConnection3;
                w23.c(outputStream);
                e(httpURLConnection4);
                vy0.f(str);
                return vy0;
            } catch (SocketTimeoutException e2) {
                th = e2;
                httpURLConnection2 = a2;
                vy0.e(-3);
                str2 = "post file '" + str + "' error";
                httpURLConnection3 = httpURLConnection2;
                t43.c("efs.util.http", str2, th);
                httpURLConnection4 = httpURLConnection3;
                w23.c(outputStream);
                e(httpURLConnection4);
                vy0.f(str);
                return vy0;
            } catch (Throwable th2) {
                th = th2;
                map = a2;
                str2 = "post data '" + str + "' error";
                httpURLConnection3 = map;
                t43.c("efs.util.http", str2, th);
                httpURLConnection4 = httpURLConnection3;
                w23.c(outputStream);
                e(httpURLConnection4);
                vy0.f(str);
                return vy0;
            }
        } catch (UnknownHostException e3) {
            th = e3;
            httpURLConnection = null;
            vy0.e(-2);
            str2 = "post data to '" + str + "' error， maybe network is disconnect";
            httpURLConnection3 = httpURLConnection;
            t43.c("efs.util.http", str2, th);
            httpURLConnection4 = httpURLConnection3;
            w23.c(outputStream);
            e(httpURLConnection4);
            vy0.f(str);
            return vy0;
        } catch (SocketTimeoutException e4) {
            th = e4;
            httpURLConnection2 = null;
            vy0.e(-3);
            str2 = "post file '" + str + "' error";
            httpURLConnection3 = httpURLConnection2;
            t43.c("efs.util.http", str2, th);
            httpURLConnection4 = httpURLConnection3;
            w23.c(outputStream);
            e(httpURLConnection4);
            vy0.f(str);
            return vy0;
        } catch (Throwable th3) {
            w23.c(outputStream);
            e(map);
            throw th3;
        }
        w23.c(outputStream);
        e(httpURLConnection4);
        vy0.f(str);
        return vy0;
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final vy0 postAsFile(String str, Map<String, String> map, byte[] bArr) {
        return b(str, map, null, bArr);
    }
}
