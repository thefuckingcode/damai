package com.huawei.hms.hatool;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;

/* compiled from: Taobao */
public final class t0 {
    public static String a(File file) {
        Throwable th;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                p0 p0Var = new p0(1024);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    p0Var.a(bArr, read);
                }
                if (p0Var.b() == 0) {
                    a((Closeable) fileInputStream2);
                    return "";
                }
                String str = new String(p0Var.a(), "UTF-8");
                a((Closeable) fileInputStream2);
                return str;
            } catch (FileNotFoundException unused) {
                fileInputStream = fileInputStream2;
                y.f("hmsSdk", "getInfoFromFile(): No files need to be read");
                a((Closeable) fileInputStream);
                return "";
            } catch (IOException unused2) {
                fileInputStream = fileInputStream2;
                try {
                    y.f("hmsSdk", "getInfoFromFile(): stream.read or new string exception");
                    a((Closeable) fileInputStream);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                a((Closeable) fileInputStream);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            y.f("hmsSdk", "getInfoFromFile(): No files need to be read");
            a((Closeable) fileInputStream);
            return "";
        } catch (IOException unused4) {
            y.f("hmsSdk", "getInfoFromFile(): stream.read or new string exception");
            a((Closeable) fileInputStream);
            return "";
        }
    }

    public static String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            a((Closeable) byteArrayOutputStream);
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                y.f("hmsSdk", "closeQuietly(): Exception when closing the closeable!");
            }
        }
    }

    public static void a(File file, String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        String str2;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
            } catch (FileNotFoundException unused) {
                fileOutputStream2 = fileOutputStream;
            } catch (IOException unused2) {
                fileOutputStream2 = fileOutputStream;
                str2 = "saveInfoToFile(): io exc from write info to file!";
                try {
                    y.f("hmsSdk", str2);
                    fileOutputStream = fileOutputStream2;
                    a((Closeable) fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    a((Closeable) fileOutputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                a((Closeable) fileOutputStream2);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            str2 = "saveInfoToFile(): No files need to be read";
            y.f("hmsSdk", str2);
            fileOutputStream = fileOutputStream2;
            a((Closeable) fileOutputStream);
        } catch (IOException unused4) {
            str2 = "saveInfoToFile(): io exc from write info to file!";
            y.f("hmsSdk", str2);
            fileOutputStream = fileOutputStream2;
            a((Closeable) fileOutputStream);
        }
        a((Closeable) fileOutputStream);
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                y.f("hmsSdk", "closeStream(): Exception: close OutputStream error!");
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (Exception unused) {
            y.f("hmsSdk", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
        }
        httpURLConnection.disconnect();
        y.a("hmsSdk", " connHttp disconnect");
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[1024];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        deflater.end();
        a((OutputStream) byteArrayOutputStream);
        return byteArray;
    }
}
