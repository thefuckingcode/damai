package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
public abstract class HMACSHA256 {
    private static final String a = "HMACSHA256";
    private static final String b = "HmacSHA256";
    private static final String c = "";
    private static final int d = 32;

    public static byte[] hmacEncrypt(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            b.b(a, "content or key is null.");
            return new byte[0];
        } else if (bArr2.length < 32) {
            b.b(a, "hmac key length is not right");
            return new byte[0];
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, b);
                Mac instance = Mac.getInstance(secretKeySpec.getAlgorithm());
                instance.init(secretKeySpec);
                return instance.doFinal(bArr);
            } catch (InvalidKeyException | NoSuchAlgorithmException e) {
                String str = a;
                b.b(str, "hmacsha256 encrypt exception" + e.getMessage());
                return new byte[0];
            }
        }
    }

    public static String hmacSHA256Encrypt(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : hmacSHA256Encrypt(str, HexUtil.hexStr2ByteArray(str2));
    }

    public static String hmacSHA256Encrypt(String str, byte[] bArr) {
        byte[] bArr2;
        if (TextUtils.isEmpty(str) || bArr == null) {
            return "";
        }
        if (bArr.length < 32) {
            b.b(a, "hmac key length is not right");
            return "";
        }
        try {
            bArr2 = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            String str2 = a;
            b.b(str2, "hmacsha256 encrypt exception" + e.getMessage());
            bArr2 = new byte[0];
        }
        return HexUtil.byteArray2HexStr(hmacEncrypt(bArr2, bArr));
    }
}
