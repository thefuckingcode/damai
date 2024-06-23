package com.amap.api.col.s;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public final class bs {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return bw.e(c(str));
    }

    public static String b(String str) {
        return bw.f(d(str));
    }

    private static byte[] c(String str) {
        try {
            return e(str);
        } catch (Throwable th) {
            ci.a(th, MessageDigestAlgorithms.MD5, "gmb");
            return new byte[0];
        }
    }

    private static byte[] d(String str) {
        try {
            return e(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] e(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance(bw.c("ETUQ1"));
        instance.update(bw.a(str));
        return instance.digest();
    }

    private static byte[] a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable th) {
            ci.a(th, MessageDigestAlgorithms.MD5, "gmb");
            return null;
        }
    }

    public static String a(byte[] bArr) {
        return bw.e(a(bArr, bw.c("ETUQ1")));
    }
}
