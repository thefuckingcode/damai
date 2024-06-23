package com.ali.user.mobile.rpc.safe;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: Taobao */
public class Rsa {
    private static final String ALGORITHM = "RSA";
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057 A[SYNTHETIC, Splitter:B:25:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    public static String encrypt(String str, String str2) {
        Exception e;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        try {
            PublicKey publicKeyFromX509 = getPublicKeyFromX509("RSA", str2);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, publicKeyFromX509);
            byte[] bytes = str.getBytes("UTF-8");
            int blockSize = instance.getBlockSize();
            byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i = 0; i < bytes.length; i += blockSize) {
                try {
                    byteArrayOutputStream.write(instance.doFinal(bytes, i, bytes.length - i < blockSize ? bytes.length - i : blockSize));
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        return null;
                    }
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            return null;
                        }
                        try {
                            return null;
                        } catch (IOException e3) {
                            return null;
                        }
                    } finally {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e32) {
                                e32.printStackTrace();
                            }
                        }
                    }
                }
            }
            String str3 = new String(Base64.encode(byteArrayOutputStream.toByteArray()));
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return str3;
        } catch (Exception e5) {
            e = e5;
            byteArrayOutputStream = null;
            e.printStackTrace();
            if (byteArrayOutputStream != null) {
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            th.printStackTrace();
        }
    }

    private static PublicKey getPublicKeyFromX509(String str, String str2) throws NoSuchAlgorithmException, Exception {
        KeyFactory keyFactory;
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(str2));
        try {
            keyFactory = KeyFactory.getInstance(str);
        } catch (Throwable unused) {
            keyFactory = KeyFactory.getInstance(str);
        }
        if (keyFactory == null) {
            keyFactory = KeyFactory.getInstance(str);
        }
        return keyFactory.generatePublic(x509EncodedKeySpec);
    }

    public static String sign(String str, String str2) {
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str2)));
            Signature instance = Signature.getInstance("SHA1WithRSA");
            instance.initSign(generatePrivate);
            instance.update(str.getBytes("utf-8"));
            return Base64.encode(instance.sign());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
