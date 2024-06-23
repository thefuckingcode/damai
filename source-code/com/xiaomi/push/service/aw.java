package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.xiaomi.push.aa;
import com.xiaomi.push.ab;
import com.xiaomi.push.bp;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

/* compiled from: Taobao */
public class aw {
    private static long a;

    /* compiled from: Taobao */
    public static class a {
        int a;

        /* renamed from: a  reason: collision with other field name */
        byte[] f902a;

        public a(byte[] bArr, int i) {
            this.f902a = bArr;
            this.a = i;
        }
    }

    /* compiled from: Taobao */
    public static class b {
        public long a;

        /* renamed from: a  reason: collision with other field name */
        public Bitmap f903a;

        public b(Bitmap bitmap, long j) {
            this.f903a = bitmap;
            this.a = j;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        int i;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            com.xiaomi.channel.commonutils.logger.b.m182a("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * 48.0f);
        int i2 = options.outWidth;
        if (i2 <= round || (i = options.outHeight) <= round) {
            return 1;
        }
        return Math.min(i2 / round, i / round);
    }

    public static Bitmap a(Context context, String str) {
        Throwable th;
        InputStream inputStream;
        IOException e;
        InputStream inputStream2;
        int a2;
        Uri parse = Uri.parse(str);
        InputStream inputStream3 = null;
        try {
            inputStream = context.getContentResolver().openInputStream(parse);
            try {
                a2 = a(context, inputStream);
                inputStream2 = context.getContentResolver().openInputStream(parse);
            } catch (IOException e2) {
                e = e2;
                inputStream2 = null;
                try {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    ab.a(inputStream2);
                    ab.a(inputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream3 = inputStream2;
                    ab.a(inputStream3);
                    ab.a(inputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                ab.a(inputStream3);
                ab.a(inputStream);
                throw th;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = a2;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2, null, options);
                ab.a(inputStream2);
                ab.a(inputStream);
                return decodeStream;
            } catch (IOException e3) {
                e = e3;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                ab.a(inputStream2);
                ab.a(inputStream);
                return null;
            }
        } catch (IOException e4) {
            e = e4;
            inputStream2 = null;
            inputStream = null;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            ab.a(inputStream2);
            ab.a(inputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            ab.a(inputStream3);
            ab.a(inputStream);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d5, code lost:
        if (r1 == null) goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d7, code lost:
        r1.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f4, code lost:
        if (r1 == null) goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f7, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ff  */
    private static a a(String str, boolean z) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        IOException e;
        InputStream inputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(JosStatusCodes.RTN_CODE_COMMON_ERROR);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setRequestProperty("User-agent", "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser");
                httpURLConnection.connect();
                int contentLength = httpURLConnection.getContentLength();
                if (!z || contentLength <= 102400) {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200) {
                        com.xiaomi.channel.commonutils.logger.b.m182a("Invalid Http Response Code " + responseCode + " received");
                        ab.a((Closeable) null);
                        httpURLConnection.disconnect();
                        return null;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        int i = z ? 102400 : 2048000;
                        byte[] bArr = new byte[1024];
                        while (true) {
                            if (i <= 0) {
                                break;
                            }
                            int read = inputStream.read(bArr, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            i -= read;
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (i <= 0) {
                            com.xiaomi.channel.commonutils.logger.b.m182a("length 102400 exhausted.");
                            a aVar = new a(null, 102400);
                            ab.a(inputStream);
                            httpURLConnection.disconnect();
                            return aVar;
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        a aVar2 = new a(byteArray, byteArray.length);
                        ab.a(inputStream);
                        httpURLConnection.disconnect();
                        return aVar2;
                    } catch (SocketTimeoutException unused) {
                        com.xiaomi.channel.commonutils.logger.b.d("Connect timeout to " + str);
                        ab.a(inputStream);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            ab.a(inputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream2 = inputStream;
                            ab.a(inputStream2);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m182a("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + str);
                    ab.a((Closeable) null);
                    httpURLConnection.disconnect();
                    return null;
                }
            } catch (SocketTimeoutException unused2) {
                inputStream = null;
                com.xiaomi.channel.commonutils.logger.b.d("Connect timeout to " + str);
                ab.a(inputStream);
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                ab.a(inputStream);
            } catch (Throwable th3) {
                th = th3;
                ab.a(inputStream2);
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (SocketTimeoutException unused3) {
            httpURLConnection = null;
            inputStream = null;
            com.xiaomi.channel.commonutils.logger.b.d("Connect timeout to " + str);
            ab.a(inputStream);
        } catch (IOException e4) {
            e = e4;
            httpURLConnection = null;
            inputStream = null;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            ab.a(inputStream);
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            ab.a(inputStream2);
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    public static b a(Context context, String str, boolean z) {
        Throwable th;
        Exception e;
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0);
        Bitmap b2 = b(context, str);
        if (b2 != null) {
            bVar.f903a = b2;
            return bVar;
        }
        try {
            a a2 = a(str, z);
            if (a2 == null) {
                ab.a((Closeable) null);
                return bVar;
            }
            bVar.a = (long) a2.a;
            byte[] bArr = a2.f902a;
            if (bArr != null) {
                if (z) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int a3 = a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = a3;
                        bVar.f903a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayInputStream = byteArrayInputStream2;
                        try {
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            ab.a(byteArrayInputStream);
                            return bVar;
                        } catch (Throwable th2) {
                            th = th2;
                            ab.a(byteArrayInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayInputStream = byteArrayInputStream2;
                        ab.a(byteArrayInputStream);
                        throw th;
                    }
                } else {
                    bVar.f903a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            a(context, a2.f902a, str);
            ab.a(byteArrayInputStream);
            return bVar;
        } catch (Exception e3) {
            e = e3;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            ab.a(byteArrayInputStream);
            return bVar;
        }
    }

    private static void a(Context context) {
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (file.exists()) {
            if (a == 0) {
                a = aa.a(file);
            }
            if (a > 15728640) {
                try {
                    File[] listFiles = file.listFiles();
                    for (int i = 0; i < listFiles.length; i++) {
                        if (!listFiles[i].isDirectory() && Math.abs(System.currentTimeMillis() - listFiles[i].lastModified()) > 1209600) {
                            listFiles[i].delete();
                        }
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
                a = 0;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    private static void a(Context context, byte[] bArr, String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        BufferedOutputStream bufferedOutputStream;
        if (bArr == null) {
            com.xiaomi.channel.commonutils.logger.b.m182a("cannot save small icon cause bitmap is null");
            return;
        }
        a(context);
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, bp.a(str));
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file2);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    ab.a(bufferedOutputStream2);
                    ab.a(fileOutputStream);
                    if (a != 0) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    ab.a(bufferedOutputStream2);
                    ab.a(fileOutputStream);
                    throw th;
                }
            }
            try {
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                ab.a(bufferedOutputStream);
            } catch (Exception e3) {
                e = e3;
                bufferedOutputStream2 = bufferedOutputStream;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                ab.a(bufferedOutputStream2);
                ab.a(fileOutputStream);
                if (a != 0) {
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream2 = bufferedOutputStream;
                ab.a(bufferedOutputStream2);
                ab.a(fileOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            ab.a(bufferedOutputStream2);
            ab.a(fileOutputStream);
            if (a != 0) {
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            ab.a(bufferedOutputStream2);
            ab.a(fileOutputStream);
            throw th;
        }
        ab.a(fileOutputStream);
        if (a != 0) {
            a = aa.a(new File(context.getCacheDir().getPath() + File.separator + "mipush_icon")) + file2.length();
        }
    }

    private static Bitmap b(Context context, String str) {
        Throwable th;
        Bitmap bitmap;
        Exception e;
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon", bp.a(str));
        FileInputStream fileInputStream = null;
        Bitmap bitmap2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                bitmap2 = BitmapFactory.decodeStream(fileInputStream2);
                file.setLastModified(System.currentTimeMillis());
                ab.a(fileInputStream2);
                return bitmap2;
            } catch (Exception e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                bitmap = bitmap2;
                try {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    ab.a(fileInputStream);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    ab.a(fileInputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                ab.a(fileInputStream2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bitmap = null;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            ab.a(fileInputStream);
            return bitmap;
        }
    }
}
