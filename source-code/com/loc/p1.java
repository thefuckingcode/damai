package com.loc;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import tb.jl1;
import tb.u91;
import tb.v00;
import tb.v13;

/* compiled from: Taobao */
public final class p1 {
    private static final char[] a = {YKUpsConvert.CHAR_A, 'B', 'C', u91.LEVEL_D, u91.LEVEL_E, YKUpsConvert.CHAR_F, 'G', 'H', u91.LEVEL_I, 'J', 'K', u91.LEVEL_L, 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', u91.LEVEL_V, u91.LEVEL_W, 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, '+', v00.DIR};
    private static final byte[] b = new byte[128];

    static {
        for (int i = 0; i < 128; i++) {
            b[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            b[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            b[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            b[i4] = (byte) ((i4 - 48) + 52);
        }
        byte[] bArr = b;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static String a(String str) {
        return v1.g(g(str));
    }

    public static byte[] b(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator instance = KeyGenerator.getInstance(v1.v("EQUVT"));
        if (instance == null) {
            return null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        PublicKey y = v1.y();
        if (y == null) {
            return null;
        }
        byte[] c = c(encoded, y);
        byte[] d = d(encoded, bArr);
        byte[] bArr2 = new byte[(c.length + d.length)];
        System.arraycopy(c, 0, bArr2, 0, c.length);
        System.arraycopy(d, 0, bArr2, c.length, d.length);
        return bArr2;
    }

    static byte[] c(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance(v1.v("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    private static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            return j(bArr, bArr2, v1.w());
        } catch (Throwable th) {
            v13.e(th, "er", "asEn");
            return null;
        }
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, v1.v("EQUVT"));
        Cipher instance = Cipher.getInstance(v1.v("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr2);
    }

    public static String f(byte[] bArr) {
        try {
            return k(bArr);
        } catch (Throwable th) {
            v13.e(th, "er", "e64");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024 A[LOOP:2: B:11:0x0024->B:14:0x0031, LOOP_START, PHI: r4 
      PHI: (r4v1 int) = (r4v0 int), (r4v8 int) binds: [B:10:0x0022, B:14:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0096 A[EDGE_INSN: B:49:0x0096->B:43:0x0096 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0096 A[EDGE_INSN: B:51:0x0096->B:43:0x0096 ?: BREAK  , SYNTHETIC] */
    public static byte[] g(String str) {
        byte b2;
        byte b3;
        int i = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] p = v1.p(str);
        int length = p.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i < length) {
            while (true) {
                int i2 = i + 1;
                b2 = b[p[i]];
                if (i2 >= length || b2 != -1) {
                    if (b2 != -1) {
                        break;
                    }
                    while (true) {
                        int i3 = i2 + 1;
                        b3 = b[p[i2]];
                        if (i3 >= length || b3 != -1) {
                            if (b3 != -1) {
                                break;
                            }
                            byteArrayOutputStream.write((b2 << 2) | ((b3 & 48) >>> 4));
                            while (i3 != length) {
                                int i4 = i3 + 1;
                                byte b4 = p[i3];
                                if (b4 == 61) {
                                    return byteArrayOutputStream.toByteArray();
                                }
                                byte b5 = b[b4];
                                if (i4 >= length || b5 != -1) {
                                    if (b5 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(((b3 & 15) << 4) | ((b5 & 60) >>> 2));
                                    while (i4 != length) {
                                        int i5 = i4 + 1;
                                        byte b6 = p[i4];
                                        if (b6 == 61) {
                                            return byteArrayOutputStream.toByteArray();
                                        }
                                        byte b7 = b[b6];
                                        if (i5 >= length || b7 != -1) {
                                            if (b7 == -1) {
                                                break;
                                            }
                                            byteArrayOutputStream.write(b7 | ((b5 & 3) << 6));
                                            i = i5;
                                        } else {
                                            i4 = i5;
                                        }
                                    }
                                    return byteArrayOutputStream.toByteArray();
                                }
                                i3 = i4;
                            }
                            return byteArrayOutputStream.toByteArray();
                        }
                        i2 = i3;
                    }
                    if (b3 != -1) {
                    }
                } else {
                    i = i2;
                }
            }
            if (b2 != -1) {
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] h(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return j(bArr, bArr2, bArr3);
    }

    public static String i(byte[] bArr) {
        try {
            return k(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] j(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, v1.v("EQUVT"));
        Cipher instance = Cipher.getInstance(v1.v("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        try {
            instance.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return instance.doFinal(bArr2);
    }

    private static String k(byte[] bArr) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                char[] cArr = a;
                stringBuffer.append(cArr[i3 >>> 2]);
                stringBuffer.append(cArr[(i3 & 3) << 4]);
                str = jl1.EQUAL2;
                break;
            }
            int i4 = i2 + 1;
            int i5 = bArr[i2] & 255;
            if (i4 == length) {
                char[] cArr2 = a;
                stringBuffer.append(cArr2[i3 >>> 2]);
                stringBuffer.append(cArr2[((i3 & 3) << 4) | ((i5 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) >>> 4)]);
                stringBuffer.append(cArr2[(i5 & 15) << 2]);
                str = "=";
                break;
            }
            int i6 = i4 + 1;
            int i7 = bArr[i4] & 255;
            char[] cArr3 = a;
            stringBuffer.append(cArr3[i3 >>> 2]);
            stringBuffer.append(cArr3[((i3 & 3) << 4) | ((i5 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) >>> 4)]);
            stringBuffer.append(cArr3[((i5 & 15) << 2) | ((i7 & 192) >>> 6)]);
            stringBuffer.append(cArr3[i7 & 63]);
            i = i6;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
