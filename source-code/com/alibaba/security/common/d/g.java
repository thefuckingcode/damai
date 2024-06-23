package com.alibaba.security.common.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Base64;
import com.alibaba.security.common.c.a;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class g {
    private static String a = "g";
    private static String b;
    private static String c;

    public static String a() {
        return b;
    }

    private static String b(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted") || context.getExternalCacheDir() == null) {
            c = context.getFilesDir().getAbsolutePath() + File.separator + "gesture";
        } else {
            c = context.getExternalCacheDir().getAbsolutePath() + File.separator + "gesture";
        }
        return c;
    }

    private static String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder("");
            for (byte b2 : digest) {
                int i = b2;
                if (b2 < 0) {
                    i = b2 + 256;
                }
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i == 1 ? 1 : 0));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    private static byte[] d(String str) throws IOException {
        Throwable th;
        byte[] bArr;
        FileInputStream fileInputStream = null;
        byte[] bArr2 = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                bArr2 = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr2);
                fileInputStream2.close();
                return bArr2;
            } catch (Exception unused) {
                bArr = bArr2;
                fileInputStream = fileInputStream2;
                try {
                    a.b();
                    if (fileInputStream != null) {
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
            bArr = null;
            a.b();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return bArr;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:17|18|19|20|21|22|(2:23|(1:25)(1:61))|26|27|28|29|30|31) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00d0 */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e4 A[SYNTHETIC, Splitter:B:43:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00eb A[SYNTHETIC, Splitter:B:47:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f2 A[SYNTHETIC, Splitter:B:54:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f9 A[SYNTHETIC, Splitter:B:58:0x00f9] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    public static String a(String str, Context context) {
        FileOutputStream fileOutputStream;
        Throwable th;
        InputStream inputStream;
        String str2 = c(str) + str.substring(str.lastIndexOf("."));
        if (!Environment.getExternalStorageState().equals("mounted") || context.getExternalCacheDir() == null) {
            c = context.getFilesDir().getAbsolutePath() + File.separator + "gesture";
        } else {
            c = context.getExternalCacheDir().getAbsolutePath() + File.separator + "gesture";
        }
        String str3 = c;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str3, str2);
        if (file2.exists()) {
            return file2.getPath();
        }
        InputStream inputStream2 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            if (httpURLConnection.getResponseCode() != 200) {
                return "";
            }
            inputStream = httpURLConnection.getInputStream();
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    String path = file2.getPath();
                    inputStream.close();
                    fileOutputStream.close();
                    return path;
                } catch (Exception unused) {
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (fileOutputStream == null) {
                        return "";
                    }
                    try {
                        fileOutputStream.close();
                        return "";
                    } catch (IOException unused3) {
                        return "";
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused6) {
                fileOutputStream = null;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                }
                if (fileOutputStream == null) {
                }
            } catch (Throwable th3) {
                fileOutputStream = null;
                th = th3;
                if (inputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused7) {
            fileOutputStream = null;
            if (inputStream2 != null) {
            }
            if (fileOutputStream == null) {
            }
        } catch (Throwable th4) {
            fileOutputStream = null;
            th = th4;
            inputStream = null;
            if (inputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    public static byte[] b(String str) {
        try {
            File file = new File(str);
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            bufferedInputStream.read(bArr, 0, length);
            bufferedInputStream.close();
            return bArr;
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x009a A[SYNTHETIC, Splitter:B:22:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a1 A[SYNTHETIC, Splitter:B:30:0x00a1] */
    public static String a(byte[] bArr, Context context) {
        FileOutputStream fileOutputStream;
        Throwable th;
        String valueOf = String.valueOf((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
        if (!Environment.getExternalStorageState().equals("mounted") || context.getExternalCacheDir() == null) {
            b = context.getFilesDir().getAbsolutePath() + File.separator + "verify";
        } else {
            b = context.getExternalCacheDir().getAbsolutePath() + File.separator + "verify";
        }
        String str = b;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str, valueOf);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                fileOutputStream.close();
                String path = file2.getPath();
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                return path;
            } catch (IOException unused2) {
                if (fileOutputStream != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private static String a(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted") || context.getExternalCacheDir() == null) {
            b = context.getFilesDir().getAbsolutePath() + File.separator + "verify";
        } else {
            b = context.getExternalCacheDir().getAbsolutePath() + File.separator + "verify";
        }
        return b;
    }

    public static byte[] a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > 50 && i >= 0) {
            byteArrayOutputStream.reset();
            i -= 10;
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (i == 0 || i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == createBitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static Bitmap a(String str) {
        if (str != null && new File(str).exists()) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inSampleSize = a(options);
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                options.inPurgeable = true;
                options.inInputShareable = true;
                return BitmapFactory.decodeStream(new FileInputStream(str), null, options);
            } catch (Exception unused) {
                a.b();
            }
        }
        return null;
    }

    private static int a(BitmapFactory.Options options) {
        int i = options.outHeight;
        int i2 = options.outWidth;
        int i3 = 1;
        if (i > 480 || i2 > 800) {
            int i4 = i / 2;
            int i5 = i2 / 2;
            while (i4 / i3 > 480 && i5 / i3 > 800) {
                i3 *= 2;
            }
        }
        return i3;
    }

    public static void a(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    listFiles[i].delete();
                }
            }
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    public static String a(Context context, String str, String str2) {
        try {
            byte[] d = d(str2);
            if (d == null) {
                return null;
            }
            String a2 = c.a(str);
            int i = 0;
            Key a3 = c.a(Base64.decode(a2, 0));
            Cipher instance = Cipher.getInstance(c.b);
            byte[] bArr = new byte[8];
            while (i < 8 && i < a2.getBytes().length) {
                bArr[i] = a2.getBytes()[i];
                i++;
            }
            instance.init(2, a3, new IvParameterSpec(bArr));
            return a(instance.doFinal(d), context);
        } catch (Exception unused) {
            return null;
        }
    }
}
