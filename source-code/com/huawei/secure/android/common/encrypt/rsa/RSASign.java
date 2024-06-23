package com.huawei.secure.android.common.encrypt.rsa;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public abstract class RSASign {
    private static final String a = "SHA256WithRSA";
    private static final String b = "SHA256WithRSA/PSS";
    private static final String c = "RSASign";
    private static final String d = "UTF-8";
    private static final String e = "";

    private static String a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(c, "sign content or key is null");
            return "";
        }
        PrivateKey privateKey = EncryptUtil.getPrivateKey(str2);
        if (z) {
            return newSign(str, privateKey);
        }
        return sign(str, privateKey);
    }

    public static boolean isBuildVersionHigherThan23() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static String newSign(String str, String str2) {
        if (isBuildVersionHigherThan23()) {
            return a(str, str2, true);
        }
        b.b(c, "sdk version is too low");
        return "";
    }

    public static boolean newVerifySign(String str, String str2, String str3) {
        if (isBuildVersionHigherThan23()) {
            return a(str, str2, str3, true);
        }
        b.b(c, "sdk version is too low");
        return false;
    }

    @Deprecated
    public static String sign(String str, String str2) {
        return a(str, str2, false);
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        return a(str, str2, str3, false);
    }

    @Deprecated
    public static String sign(String str, PrivateKey privateKey) {
        return a(str, privateKey, false);
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, PublicKey publicKey) {
        return a(str, str2, publicKey, false);
    }

    public static byte[] sign(byte[] bArr, PrivateKey privateKey, boolean z) {
        Signature signature;
        byte[] bArr2 = new byte[0];
        if (bArr == null || privateKey == null || !RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            b.b(c, "content or privateKey is null , or length is too short");
            return bArr2;
        }
        if (z) {
            try {
                signature = Signature.getInstance(b);
                signature.setParameter(new PSSParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } catch (NoSuchAlgorithmException e2) {
                String str = c;
                b.b(str, "sign NoSuchAlgorithmException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                String str2 = c;
                b.b(str2, "sign InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (SignatureException e4) {
                String str3 = c;
                b.b(str3, "sign SignatureException: " + e4.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e5) {
                String str4 = c;
                b.b(str4, "sign InvalidAlgorithmParameterException: " + e5.getMessage());
                return bArr2;
            } catch (Exception e6) {
                String str5 = c;
                b.b(str5, "sign Exception: " + e6.getMessage());
                return bArr2;
            }
        } else {
            signature = Signature.getInstance(a);
        }
        signature.initSign(privateKey);
        signature.update(bArr);
        return signature.sign();
    }

    public static boolean verifySign(byte[] bArr, byte[] bArr2, PublicKey publicKey, boolean z) {
        Signature signature;
        if (bArr == null || publicKey == null || bArr2 == null || !RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            b.b(c, "content or publicKey is null , or length is too short");
            return false;
        }
        if (z) {
            try {
                signature = Signature.getInstance(b);
                signature.setParameter(new PSSParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } catch (GeneralSecurityException e2) {
                String str = c;
                b.b(str, "check sign exception: " + e2.getMessage());
                return false;
            } catch (Exception e3) {
                String str2 = c;
                b.b(str2, "exception : " + e3.getMessage());
                return false;
            }
        } else {
            signature = Signature.getInstance(a);
        }
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }

    public static String newSign(String str, PrivateKey privateKey) {
        if (isBuildVersionHigherThan23()) {
            return a(str, privateKey, true);
        }
        b.b(c, "sdk version is too low");
        return "";
    }

    public static boolean newVerifySign(String str, String str2, PublicKey publicKey) {
        if (isBuildVersionHigherThan23()) {
            return a(str, str2, publicKey, true);
        }
        b.b(c, "sdk version is too low");
        return false;
    }

    private static String a(String str, PrivateKey privateKey, boolean z) {
        try {
            return Base64.encodeToString(sign(str.getBytes("UTF-8"), privateKey, z), 0);
        } catch (UnsupportedEncodingException e2) {
            String str2 = c;
            b.b(str2, "sign UnsupportedEncodingException: " + e2.getMessage());
            return "";
        }
    }

    private static boolean a(String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            b.b(c, "content or public key or sign value is null");
            return false;
        }
        RSAPublicKey publicKey = EncryptUtil.getPublicKey(str3);
        if (z) {
            return newVerifySign(str, str2, publicKey);
        }
        return verifySign(str, str2, publicKey);
    }

    private static boolean a(String str, String str2, PublicKey publicKey, boolean z) {
        try {
            return verifySign(str.getBytes("UTF-8"), Base64.decode(str2, 0), publicKey, z);
        } catch (UnsupportedEncodingException e2) {
            String str3 = c;
            b.b(str3, "verifySign UnsupportedEncodingException: " + e2.getMessage());
            return false;
        } catch (Exception e3) {
            String str4 = c;
            b.b(str4, "base64 decode Exception : " + e3.getMessage());
            return false;
        }
    }

    public static boolean verifySign(ByteBuffer byteBuffer, byte[] bArr, PublicKey publicKey, boolean z) {
        Signature signature;
        if (byteBuffer == null || publicKey == null || bArr == null || !RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            b.b(c, "content or publicKey is null , or length is too short");
            return false;
        }
        if (z) {
            try {
                signature = Signature.getInstance(b);
                signature.setParameter(new PSSParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } catch (GeneralSecurityException e2) {
                String str = c;
                b.b(str, "check sign exception: " + e2.getMessage());
                return false;
            } catch (Exception e3) {
                String str2 = c;
                b.b(str2, "exception : " + e3.getMessage());
                return false;
            }
        } else {
            signature = Signature.getInstance(a);
        }
        signature.initVerify(publicKey);
        signature.update(byteBuffer);
        return signature.verify(bArr);
    }

    public static byte[] sign(ByteBuffer byteBuffer, PrivateKey privateKey, boolean z) {
        Signature signature;
        byte[] bArr = new byte[0];
        if (byteBuffer == null || privateKey == null || !RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            b.b(c, "content or privateKey is null , or length is too short");
            return bArr;
        }
        if (z) {
            try {
                signature = Signature.getInstance(b);
                signature.setParameter(new PSSParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } catch (NoSuchAlgorithmException e2) {
                String str = c;
                b.b(str, "sign NoSuchAlgorithmException: " + e2.getMessage());
                return bArr;
            } catch (InvalidKeyException e3) {
                String str2 = c;
                b.b(str2, "sign InvalidKeyException: " + e3.getMessage());
                return bArr;
            } catch (SignatureException e4) {
                String str3 = c;
                b.b(str3, "sign SignatureException: " + e4.getMessage());
                return bArr;
            } catch (InvalidAlgorithmParameterException e5) {
                String str4 = c;
                b.b(str4, "sign InvalidAlgorithmParameterException: " + e5.getMessage());
                return bArr;
            } catch (Exception e6) {
                String str5 = c;
                b.b(str5, "sign Exception: " + e6.getMessage());
                return bArr;
            }
        } else {
            signature = Signature.getInstance(a);
        }
        signature.initSign(privateKey);
        signature.update(byteBuffer);
        byte[] sign = signature.sign();
        String str6 = c;
        b.c(str6, "result is : " + Arrays.toString(sign));
        return sign;
    }
}
