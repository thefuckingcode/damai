package com.taobao.android.tlog.protocol.utils;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: Taobao */
public class RSAUtils {
    public static final String KEY_ALGORITHM = "RSA";
    private static final int MAX_DECRYPT_BLOCK = 128;
    private static final int MAX_ENCRYPT_BLOCK = 117;

    public static byte[] decryptByPrivateKey(byte[] bArr, String str) throws Exception {
        byte[] bArr2;
        PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str)));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, generatePrivate);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 > 0) {
                if (i3 > 128) {
                    bArr2 = instance.doFinal(bArr, i, 128);
                } else {
                    bArr2 = instance.doFinal(bArr, i, i3);
                }
                byteArrayOutputStream.write(bArr2, 0, bArr2.length);
                i2++;
                i = i2 * 128;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public static byte[] encryptByPublicKey(byte[] bArr, String str) throws Exception {
        byte[] bArr2;
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str)));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, generatePublic);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 > 0) {
                if (i3 > 117) {
                    bArr2 = instance.doFinal(bArr, i, 117);
                } else {
                    bArr2 = instance.doFinal(bArr, i, i3);
                }
                byteArrayOutputStream.write(bArr2, 0, bArr2.length);
                i2++;
                i = i2 * 117;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }
}
