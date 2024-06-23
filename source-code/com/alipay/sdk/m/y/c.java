package com.alipay.sdk.m.y;

import com.alipay.sdk.m.z.a;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
public final class c {
    public static String a = "idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#";

    public static String a() {
        String str = new String();
        for (int i = 0; i < a.length() - 1; i += 4) {
            str = str + a.charAt(i);
        }
        return str;
    }

    public static String a(String str, String str2) {
        try {
            PBEKeySpec a2 = a(str);
            byte[] bytes = str2.getBytes();
            byte[] b = b();
            SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(a2).getEncoded(), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec(b));
            byte[] salt = a2.getSalt();
            ByteBuffer allocate = ByteBuffer.allocate(salt.length + instance.getOutputSize(bytes.length));
            allocate.put(salt);
            instance.doFinal(ByteBuffer.wrap(bytes), allocate);
            return a(allocate.array());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(b & 15));
        }
        return stringBuffer.toString();
    }

    public static PBEKeySpec a(String str) {
        Class<?> cls = Class.forName(new String(a.a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
        Object newInstance = cls.newInstance();
        byte[] bArr = new byte[16];
        Method method = cls.getMethod("nextBytes", bArr.getClass());
        method.setAccessible(true);
        method.invoke(newInstance, bArr);
        return new PBEKeySpec(str.toCharArray(), bArr, 10, 128);
    }

    public static String b(String str, String str2) {
        byte[] bArr;
        try {
            PBEKeySpec a2 = a(str);
            int length = str2.length() / 2;
            byte[] bArr2 = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr2[i] = Integer.valueOf(str2.substring(i2, i2 + 2), 16).byteValue();
            }
            byte[] b = b();
            if (length <= 16) {
                bArr = null;
            } else {
                SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(a2.getPassword(), Arrays.copyOf(bArr2, 16), 10, 128)).getEncoded(), "AES");
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(2, secretKeySpec, new IvParameterSpec(b));
                bArr = instance.doFinal(bArr2, 16, length - 16);
            }
            if (bArr != null) {
                String str3 = new String(bArr);
                if (a.c(str3)) {
                    return str3;
                }
                return null;
            }
            throw new Exception();
        } catch (Exception unused) {
        }
    }

    public static byte[] b() {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 48; i += 2) {
                sb.append("AsAgAtA5A6AdAgABABACADAfAsAdAfAsAgAaAgA3A5A6=8=0".charAt(i));
            }
            return a.a(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
