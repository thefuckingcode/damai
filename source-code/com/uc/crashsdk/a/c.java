package com.uc.crashsdk.a;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import mtopsdk.network.util.Constants;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
public class c {
    static final /* synthetic */ boolean a = true;
    private static String b = "";

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, false);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, true);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        return a(bArr, bArr2, z, true);
    }

    private static boolean b(File file, String str, String str2) {
        try {
            byte[] a2 = a(file);
            if (a2 != null) {
                if (a2.length != 0) {
                    return a(a2, str, str2);
                }
            }
            return false;
        } catch (Exception e) {
            g.a(e);
            return false;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, boolean z, boolean z2) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(z ? 1 : 2, secretKeySpec, ivParameterSpec);
        if (!z) {
            return instance.doFinal(bArr);
        }
        if (!z2) {
            bArr = a(bArr);
        }
        return instance.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + 16)];
        int length = bArr.length;
        bArr2[0] = (byte) ((length >> 0) & 255);
        bArr2[1] = (byte) ((length >> 8) & 255);
        bArr2[2] = (byte) ((length >> 16) & 255);
        bArr2[3] = (byte) ((length >> 24) & 255);
        for (int i = 4; i < 16; i++) {
            bArr2[i] = 0;
        }
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        return bArr2;
    }

    public static byte[] a() {
        return new byte[]{48, 25, 6, 55};
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0094 A[SYNTHETIC, Splitter:B:40:0x0094] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static byte[] a(String str, byte[] bArr) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        ?? r4;
        OutputStream outputStream;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", IRequestConst.CONTENT_TYPE_POST);
                httpURLConnection.setRequestProperty(Constants.Protocol.CONTENT_LENGTH, String.valueOf(bArr.length));
                outputStream = httpURLConnection.getOutputStream();
            } catch (Throwable unused) {
                inputStream = null;
                outputStream = inputStream;
                r4 = outputStream;
                g.a(outputStream);
                g.a(inputStream);
                g.a((Closeable) r4);
                if (httpURLConnection != null) {
                }
                return null;
            }
            try {
                outputStream.write(bArr);
                if (httpURLConnection.getResponseCode() != 200) {
                    g.a(outputStream);
                    g.a((Closeable) null);
                    g.a((Closeable) null);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused2) {
                    }
                    return null;
                }
                inputStream = httpURLConnection.getInputStream();
                try {
                    byte[] bArr2 = new byte[1024];
                    r4 = new ByteArrayOutputStream(inputStream.available());
                    while (true) {
                        try {
                            int read = inputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            r4.write(bArr2, 0, read);
                        } catch (Throwable unused3) {
                            g.a(outputStream);
                            g.a(inputStream);
                            g.a((Closeable) r4);
                            if (httpURLConnection != null) {
                            }
                            return null;
                        }
                    }
                    byte[] byteArray = r4.toByteArray();
                    g.a(outputStream);
                    g.a(inputStream);
                    g.a((Closeable) r4);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused4) {
                    }
                    return byteArray;
                } catch (Throwable unused5) {
                    r4 = 0;
                    g.a(outputStream);
                    g.a(inputStream);
                    g.a((Closeable) r4);
                    if (httpURLConnection != null) {
                    }
                    return null;
                }
            } catch (Throwable unused6) {
                inputStream = null;
                r4 = 0;
                g.a(outputStream);
                g.a(inputStream);
                g.a((Closeable) r4);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused7) {
                    }
                }
                return null;
            }
        } catch (Throwable unused8) {
            httpURLConnection = null;
            inputStream = null;
            outputStream = inputStream;
            r4 = outputStream;
            g.a(outputStream);
            g.a(inputStream);
            g.a((Closeable) r4);
            if (httpURLConnection != null) {
            }
            return null;
        }
    }

    public static void a(byte[] bArr, int i, byte[] bArr2) {
        if (a || bArr2.length == 4) {
            for (int i2 = 0; i2 < 4; i2++) {
                bArr[i2 + i] = bArr2[i2];
            }
            return;
        }
        throw new AssertionError();
    }

    private static byte[] a(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        byte[] bArr;
        Exception e;
        BufferedInputStream bufferedInputStream = null;
        if (!file.isFile()) {
            return null;
        }
        try {
            int length = (int) file.length();
            fileInputStream = new FileInputStream(file);
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                try {
                    byte[] bArr2 = new byte[length];
                    int i = 0;
                    while (i < length) {
                        int read = bufferedInputStream2.read(bArr2, i, length - i);
                        if (-1 == read) {
                            break;
                        }
                        i += read;
                    }
                    g.a(bufferedInputStream2);
                    g.a(fileInputStream);
                    return bArr2;
                } catch (Exception e2) {
                    e = e2;
                    bufferedInputStream = bufferedInputStream2;
                    bArr = null;
                    try {
                        g.b(e);
                        g.a(bufferedInputStream);
                        g.a(fileInputStream);
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        g.a(bufferedInputStream);
                        g.a(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = bufferedInputStream2;
                    g.a(bufferedInputStream);
                    g.a(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bArr = null;
                g.b(e);
                g.a(bufferedInputStream);
                g.a(fileInputStream);
                return bArr;
            }
        } catch (Exception e4) {
            e = e4;
            bArr = null;
            fileInputStream = null;
            g.b(e);
            g.a(bufferedInputStream);
            g.a(fileInputStream);
            return bArr;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            g.a(bufferedInputStream);
            g.a(fileInputStream);
            throw th;
        }
    }

    public static boolean a(File file, String str, String str2) {
        for (int i = 0; i < 2; i++) {
            if (b(file, str, str2)) {
                return true;
            }
            a.a("crashsdk", "upload try again: " + str);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x013e A[SYNTHETIC, Splitter:B:49:0x013e] */
    private static boolean a(byte[] bArr, String str, String str2) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        StringBuilder sb;
        OutputStream outputStream;
        a.a("Uploading to " + str2);
        OutputStream outputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                sb = new StringBuilder();
                sb.append("------------izQ290kHh6g3Yn2IeyJCoc\r\n");
                sb.append("Content-Disposition: form-data; name=\"file\";");
                sb.append(" filename=\"");
                sb.append(str);
                sb.append("\"\r\n");
                sb.append("Content-Type: application/octet-stream\r\n");
                sb.append(SocketClient.NETASCII_EOL);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----------izQ290kHh6g3Yn2IeyJCoc");
                httpURLConnection.setRequestProperty("Content-Disposition", "form-data; name=\"file\"; filename=" + str);
                httpURLConnection.setRequestProperty(Constants.Protocol.CONTENT_LENGTH, String.valueOf(sb.length() + 40 + bArr.length));
                outputStream = httpURLConnection.getOutputStream();
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
                byteArrayOutputStream = null;
                try {
                    g.b(th);
                    g.a(outputStream2);
                    g.a(inputStream);
                    g.a(byteArrayOutputStream);
                    if (httpURLConnection != null) {
                    }
                    return false;
                } catch (Throwable unused) {
                }
            }
            try {
                outputStream.write(sb.toString().getBytes());
                outputStream.write(bArr);
                outputStream.write("\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n".getBytes());
                int responseCode = httpURLConnection.getResponseCode();
                a.a("crashsdk", "Response code: " + responseCode);
                if (responseCode != 200) {
                    g.a(outputStream);
                    g.a((Closeable) null);
                    g.a((Closeable) null);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused2) {
                    }
                    return false;
                }
                inputStream = httpURLConnection.getInputStream();
                try {
                    byte[] bArr2 = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                    while (true) {
                        try {
                            int read = inputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } catch (Throwable th3) {
                            th = th3;
                            outputStream2 = outputStream;
                            g.b(th);
                            g.a(outputStream2);
                            g.a(inputStream);
                            g.a(byteArrayOutputStream);
                            if (httpURLConnection != null) {
                            }
                            return false;
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (byteArray != null) {
                        a.a("crashsdk", "Log upload response: " + new String(byteArray));
                        g.a(outputStream);
                        g.a(inputStream);
                        g.a(byteArrayOutputStream);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused3) {
                        }
                        return true;
                    }
                    g.a(outputStream);
                    g.a(inputStream);
                    g.a(byteArrayOutputStream);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused4) {
                    }
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    outputStream2 = outputStream;
                    g.b(th);
                    g.a(outputStream2);
                    g.a(inputStream);
                    g.a(byteArrayOutputStream);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused5) {
                        }
                    }
                    return false;
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                byteArrayOutputStream = null;
                outputStream2 = outputStream;
                g.b(th);
                g.a(outputStream2);
                g.a(inputStream);
                g.a(byteArrayOutputStream);
                if (httpURLConnection != null) {
                }
                return false;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            httpURLConnection = null;
            byteArrayOutputStream = null;
            g.b(th);
            g.a(outputStream2);
            g.a(inputStream);
            g.a(byteArrayOutputStream);
            if (httpURLConnection != null) {
            }
            return false;
        }
        throw th;
    }
}
