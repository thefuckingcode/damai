package com.youku.playerservice.axp.utils;

import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.u91;

/* compiled from: Taobao */
public class BinaryUtil {
    private static final char[] HEX_DIGITS = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', u91.LEVEL_D, u91.LEVEL_E, YKUpsConvert.CHAR_F};
    private static final String TAG = "BinaryUtil";

    public static String bytesToHexString(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            char[] cArr2 = HEX_DIGITS;
            cArr[i2] = cArr2[(bArr[i] >>> 4) & 15];
            cArr[i2 + 1] = cArr2[bArr[i] & 15];
        }
        return new String(cArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002d A[SYNTHETIC, Splitter:B:20:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0034  */
    public static byte[] calculateMd5(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        byte[] bArr = new byte[1024];
        FileInputStream fileInputStream2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            try {
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (Exception unused) {
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
                fileInputStream.close();
                try {
                    fileInputStream.close();
                } catch (Exception unused3) {
                }
                return instance.digest();
            } catch (Exception unused4) {
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
        } catch (NoSuchAlgorithmException unused5) {
            return null;
        }
    }

    public static byte[] calculateMd5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String encodeMD5(File file) {
        byte[] calculateMd5 = calculateMd5(file);
        if (calculateMd5 == null) {
            return null;
        }
        return bytesToHexString(calculateMd5);
    }

    public static String encodeMD5(byte[] bArr) {
        byte[] calculateMd5 = calculateMd5(bArr);
        if (calculateMd5 == null) {
            return null;
        }
        return bytesToHexString(calculateMd5);
    }

    public static byte[] fromBase64String(String str) {
        return Base64.decodeBase64(str.getBytes());
    }

    public static String toBase64String(byte[] bArr) {
        return new String(Base64.encodeBase64(bArr));
    }
}
