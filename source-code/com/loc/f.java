package com.loc;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: Taobao */
public final class f {
    public static PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(v1.v("EUlNB")).generatePublic(new X509EncodedKeySpec(b.c(str)));
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused2) {
            throw new Exception("公钥非法");
        } catch (NullPointerException unused3) {
            throw new Exception("公钥数据为空");
        }
    }

    public static byte[] b(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher instance = Cipher.getInstance(v1.v("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
