package com.alipay.sdk.m.n;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
public class e {
    public static String a = "DESede/CBC/PKCS5Padding";

    public static byte[] a(String str, byte[] bArr, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher instance = Cipher.getInstance(a);
            instance.init(2, secretKeySpec, new IvParameterSpec(c.a(instance, str2)));
            return instance.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher instance = Cipher.getInstance(a);
            instance.init(1, secretKeySpec, new IvParameterSpec(c.a(instance, str2)));
            return instance.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str, String str2, String str3) {
        try {
            return new String(a(str, a.a(str2), str3));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str, String str2, String str3) {
        try {
            return a.a(b(str, str2.getBytes(), str3));
        } catch (Exception unused) {
            return null;
        }
    }
}
