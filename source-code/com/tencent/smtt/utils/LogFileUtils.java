package com.tencent.smtt.utils;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LogFileUtils {
    private static OutputStream a;

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0069, code lost:
        if (r6 != null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r6.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
        if (r6 == null) goto L_0x0074;
     */
    public static synchronized void writeDataToStorage(File file, String str, byte[] bArr, String str2, boolean z) {
        OutputStream outputStream;
        synchronized (LogFileUtils.class) {
            byte[] encrypt = encrypt(str, str2);
            if (encrypt != null) {
                str2 = null;
            } else {
                encrypt = null;
            }
            try {
                file.getParentFile().mkdirs();
                if (file.isFile() && file.exists() && file.length() > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
                    file.delete();
                    file.createNewFile();
                }
                if (a == null) {
                    a = new BufferedOutputStream(new FileOutputStream(file, z));
                }
                if (str2 != null) {
                    a.write(str2.getBytes());
                } else {
                    a.write(bArr);
                    a.write(encrypt);
                    a.write(new byte[]{10, 10});
                }
                outputStream = a;
            } catch (Throwable unused) {
                outputStream = a;
            }
        }
    }

    public static void closeOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                Log.e("LOG_FILE", "Couldn't close stream!", e);
            }
        }
    }

    public static byte[] encrypt(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return instance.update(bytes);
        } catch (Throwable th) {
            Log.e("LOG_FILE", "encrypt exception:" + th.getMessage());
            return null;
        }
    }

    public static String createKey() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static byte[] encryptKey(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return instance.update(bytes);
        } catch (Throwable th) {
            Log.e("LOG_FILE", "encrypt exception:" + th.getMessage());
            return null;
        }
    }

    public static byte[] createHeaderText(String str, String str2) {
        try {
            byte[] encryptKey = encryptKey(str, str2);
            String format = String.format("%03d", Integer.valueOf(encryptKey.length));
            byte[] bArr = new byte[(encryptKey.length + 3)];
            bArr[0] = (byte) format.charAt(0);
            bArr[1] = (byte) format.charAt(1);
            bArr[2] = (byte) format.charAt(2);
            System.arraycopy(encryptKey, 0, bArr, 3, encryptKey.length);
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }
}
