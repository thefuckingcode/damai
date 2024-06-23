package com.youku.usercenter.passport.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.staticdataencrypt.IStaticDataEncryptComponent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public final class EncryptUtil {
    private static final String AES_INIT_IV = "0122030405660708";
    private static final String PASSPORT_KEY = "passportKey";
    private static final String TAG = "EncryptUtil";

    public static String decryptAES(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(decryptAES(Base64.decode(str, 0), getKey(str2)));
    }

    public static String decryptData(Context context, String str, String str2) throws Exception {
        return decryptAES(str, getMixedKey(context, str2));
    }

    public static String encryptAES(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, getKey(str2), new IvParameterSpec(AES_INIT_IV.getBytes()));
        return Base64.encodeToString(instance.doFinal(str.getBytes()), 0);
    }

    public static String encryptData(Context context, String str, String str2) throws Exception {
        return encryptAES(str, getMixedKey(context, str2));
    }

    public static String encryptMD5(String str, boolean z) {
        try {
            return encryptMD5(str.getBytes(), z);
        } catch (Exception e) {
            Logger.w("encryptMD5 Exception", e);
            return "";
        }
    }

    public static String encryptSHA256(String str, boolean z) {
        try {
            return encryptSHA256(str.getBytes(), z);
        } catch (Exception e) {
            Logger.w("encryptSHA256 Exception", e);
            return null;
        }
    }

    private static SecretKeySpec getKey(String str) throws Exception {
        byte[] bytes = str.getBytes();
        int roundUpToPowerOfTwo = roundUpToPowerOfTwo(bytes.length);
        if (roundUpToPowerOfTwo < 16) {
            roundUpToPowerOfTwo = 16;
        }
        byte[] bArr = new byte[roundUpToPowerOfTwo];
        for (int i = 0; i < bytes.length; i++) {
            bArr[i] = bytes[i];
        }
        return new SecretKeySpec(bArr, "AES");
    }

    private static String getMixedKey(Context context, String str) {
        String encryptSHA256 = encryptSHA256(str, true);
        String deviceId = SysUtil.getDeviceId(context);
        byte[] bytes = encryptSHA256.getBytes();
        byte[] bytes2 = deviceId.getBytes();
        int i = 0;
        while (i < bytes.length && i < bytes2.length) {
            bytes2[i] = (byte) (bytes2[i] & bytes[i]);
            i++;
        }
        return encryptMD5(bytes2, true);
    }

    public static int roundUpToPowerOfTwo(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        return (i6 | (i6 >>> 16)) + 1;
    }

    public static String sdkStaticDecrypt(Context context, String str) {
        IStaticDataEncryptComponent staticDataEncryptComp;
        try {
            SecurityGuardManager instance = SecurityGuardManager.getInstance(context);
            if (instance == null || (staticDataEncryptComp = instance.getStaticDataEncryptComp()) == null) {
                return null;
            }
            return staticDataEncryptComp.staticSafeDecrypt(16, PASSPORT_KEY, str);
        } catch (Throwable th) {
            Logger.w(TAG, "decryptSG Exception", th);
            return null;
        }
    }

    public static String sdkStaticEncrypt(Context context, String str) {
        IStaticDataEncryptComponent staticDataEncryptComp;
        try {
            SecurityGuardManager instance = SecurityGuardManager.getInstance(context);
            if (instance == null || (staticDataEncryptComp = instance.getStaticDataEncryptComp()) == null) {
                return null;
            }
            return staticDataEncryptComp.staticSafeEncrypt(16, PASSPORT_KEY, str);
        } catch (Throwable th) {
            Logger.w(TAG, "encryptSG Exception", th);
            return null;
        }
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            if (i != bArr.length - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static String encryptMD5(byte[] bArr, boolean z) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.reset();
            instance.update(bArr);
            return toHexString(instance.digest(), z);
        } catch (NoSuchAlgorithmException e) {
            Logger.w("encryptMD5 Exception", e);
            return "";
        }
    }

    public static String encryptSHA256(byte[] bArr, boolean z) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            instance.reset();
            instance.update(bArr);
            return toHexString(instance.digest(), z);
        } catch (NoSuchAlgorithmException e) {
            Logger.w("encryptSHA256 Exception", e);
            return null;
        }
    }

    private static byte[] decryptAES(byte[] bArr, SecretKeySpec secretKeySpec) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(AES_INIT_IV.getBytes()));
        return instance.doFinal(bArr);
    }

    public static String toHexString(byte[] bArr, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
