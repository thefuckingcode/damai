package com.heytap.msp.push.encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import tb.w33;

/* compiled from: Taobao */
public class AESEncrypt {
    private static final String ALGORITHM = "AES";
    private static final String IV_CONNECT = "%IV1%";
    private static final int KEY_BYTE_SIZE = 256;
    public static final String SDK_APP_SECRET = "isvrbeT7qUywVEZ1Ia0/aUVA/TcFaeV0wC8qFLc8rg4=";
    private static final String TRANSFORMATION = "AES/CTR/NoPadding";

    public static String decrypt(String str, String str2) {
        String[] split = str2.split(IV_CONNECT);
        byte[] b = a.b(split[0]);
        byte[] b2 = a.b(split[1]);
        SecretKeySpec secretKeySpec = new SecretKeySpec(a.b(str), "AES");
        Cipher instance = Cipher.getInstance(TRANSFORMATION);
        instance.init(2, secretKeySpec, new IvParameterSpec(b2));
        return new String(instance.doFinal(b));
    }

    public static String encrypt(String str) {
        try {
            return encrypt(SDK_APP_SECRET, str);
        } catch (Exception e) {
            w33.a(e.getLocalizedMessage());
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(a.b(str), "AES");
        Cipher instance = Cipher.getInstance(TRANSFORMATION);
        instance.init(1, secretKeySpec);
        String d = a.d(instance.getIV());
        String d2 = a.d(instance.doFinal(str2.getBytes()));
        return d2 + IV_CONNECT + d;
    }

    public static String genKey() {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(256);
        return a.d(instance.generateKey().getEncoded());
    }
}
