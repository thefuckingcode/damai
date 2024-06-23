package com.meizu.cloud.pushsdk.util;

import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.c.g.a;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: Taobao */
public class c {
    private static final Charset a = Charset.forName("UTF-8");

    public static String a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return new String(a(a(str), b(str2)), a);
        } catch (Exception e) {
            DebugLogger.e("RSAUtils", "decrypt " + e.getMessage());
            return null;
        }
    }

    private static RSAPublicKey a(String str) {
        String str2;
        StringBuilder sb;
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(b(str)));
        } catch (NoSuchAlgorithmException e) {
            sb = new StringBuilder();
            sb.append("loadPublicKey NoSuchAlgorithmException ");
            str2 = e.getMessage();
        } catch (InvalidKeySpecException e2) {
            sb = new StringBuilder();
            sb.append("loadPublicKey InvalidKeySpecException ");
            str2 = e2.getMessage();
        }
        sb.append(str2);
        DebugLogger.e("RSAUtils", sb.toString());
        return null;
    }

    private static byte[] a(PublicKey publicKey, byte[] bArr) throws Exception {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, publicKey);
        return instance.doFinal(bArr);
    }

    private static byte[] b(String str) {
        return a.a(str);
    }
}
