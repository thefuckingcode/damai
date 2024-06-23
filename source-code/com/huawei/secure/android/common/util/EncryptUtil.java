package com.huawei.secure.android.common.util;

import android.os.Build;
import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: Taobao */
public class EncryptUtil {
    private static final String a = "EncryptUtil";
    private static final String b = "RSA";

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    @Deprecated
    public static byte[] generateSecureRandom(int i) {
        SecureRandom secureRandom;
        byte[] bArr = new byte[i];
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                secureRandom = SecureRandom.getInstanceStrong();
                if (secureRandom == null) {
                    try {
                        secureRandom = SecureRandom.getInstance("SHA1PRNG");
                    } catch (NoSuchAlgorithmException unused) {
                        LogsUtil.e(a, "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                        return new byte[0];
                    } catch (Exception e) {
                        String str = a;
                        LogsUtil.e(str, "getSecureRandomBytes getInstance: exception : " + e.getMessage());
                        return new byte[0];
                    }
                }
                secureRandom.nextBytes(bArr);
                return bArr;
            }
        } catch (NoSuchAlgorithmException unused2) {
            LogsUtil.e(a, "getSecureRandomBytes: NoSuchAlgorithmException");
        }
        secureRandom = null;
        if (secureRandom == null) {
        }
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    @Deprecated
    public static String generateSecureRandomStr(int i) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i));
    }

    @Deprecated
    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                String str2 = a;
                LogsUtil.e(str2, "load Key Exception:" + e.getMessage(), true);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            LogsUtil.e(a, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (Exception unused2) {
            LogsUtil.e(a, "base64 decode Exception", true);
            return null;
        }
    }

    @Deprecated
    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                String str2 = a;
                LogsUtil.e(str2, "load Key Exception:" + e.getMessage(), true);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            LogsUtil.e(a, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (Exception unused2) {
            LogsUtil.e(a, "base64 decode Exception", true);
            return null;
        }
    }
}
