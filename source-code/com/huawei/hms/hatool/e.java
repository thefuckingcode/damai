package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: Taobao */
public class e {
    static {
        Charset.forName("UTF-8");
    }

    public static String a(String str, String str2) {
        try {
            return a(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            y.c("hmsSdk", "Unsupported encoding exception,utf-8");
            return "";
        }
    }

    public static String a(String str, byte[] bArr) {
        String str2;
        if (bArr == null || bArr.length == 0) {
            y.f("hmsSdk", "encrypt: content is empty or null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(a(bArr, a(HexUtil.hexStr2ByteArray(str))));
        } catch (NoSuchAlgorithmException unused) {
            str2 = "encrypt(): getInstance - No such algorithm,transformation";
            y.f("hmsSdk", str2);
            return "";
        } catch (InvalidKeySpecException unused2) {
            str2 = "encrypt(): Invalid key specification";
            y.f("hmsSdk", str2);
            return "";
        }
    }

    public static PublicKey a(byte[] bArr) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) {
        String str;
        if (publicKey != null) {
            try {
                Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
                instance.init(1, publicKey);
                return instance.doFinal(bArr);
            } catch (UnsupportedEncodingException unused) {
                str = "rsaEncrypt(): getBytes - Unsupported coding format!";
                y.f("hmsSdk", str);
                return new byte[0];
            } catch (NoSuchAlgorithmException unused2) {
                str = "rsaEncrypt(): getInstance - No such algorithm,transformation";
                y.f("hmsSdk", str);
                return new byte[0];
            } catch (InvalidKeyException unused3) {
                str = "rsaEncrypt(): init - Invalid key!";
                y.f("hmsSdk", str);
                return new byte[0];
            } catch (NoSuchPaddingException unused4) {
                str = "rsaEncrypt():  No such filling parameters ";
                y.f("hmsSdk", str);
                return new byte[0];
            } catch (BadPaddingException unused5) {
                str = "rsaEncrypt():False filling parameters!";
                y.f("hmsSdk", str);
                return new byte[0];
            } catch (IllegalBlockSizeException unused6) {
                str = "rsaEncrypt(): doFinal - The provided block is not filled with";
                y.f("hmsSdk", str);
                return new byte[0];
            }
        } else {
            throw new UnsupportedEncodingException("The loaded public key is null");
        }
    }
}
