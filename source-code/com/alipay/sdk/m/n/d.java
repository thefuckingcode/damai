package com.alipay.sdk.m.n;

import com.alipay.sdk.m.u.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: Taobao */
public class d {
    public static final String a = "RSA";

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055 A[SYNTHETIC, Splitter:B:29:0x0055] */
    public static byte[] a(String str, String str2) {
        Throwable th;
        Exception e;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        bArr = null;
        try {
            PublicKey b = b("RSA", str2);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, b);
            byte[] bytes = str.getBytes("UTF-8");
            int blockSize = instance.getBlockSize();
            byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i = 0; i < bytes.length; i += blockSize) {
                try {
                    byteArrayOutputStream.write(instance.doFinal(bytes, i, bytes.length - i < blockSize ? bytes.length - i : blockSize));
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.a(e);
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e3) {
                                e.a(e3);
                            }
                        }
                        throw th;
                    }
                }
            }
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                e.a(e4);
            }
        } catch (Exception e5) {
            e = e5;
            byteArrayOutputStream = null;
            e.a(e);
            if (byteArrayOutputStream != null) {
            }
            return bArr;
        } catch (Throwable th3) {
            th = th3;
            if (byteArrayOutputStream2 != null) {
            }
            throw th;
        }
        return bArr;
    }

    public static PublicKey b(String str, String str2) throws NoSuchAlgorithmException, Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(a.a(str2)));
    }
}
