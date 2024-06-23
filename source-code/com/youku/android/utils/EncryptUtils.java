package com.youku.android.utils;

import android.util.Base64;
import android.util.Log;
import androidx.annotation.Keep;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

@Keep
/* compiled from: Taobao */
public class EncryptUtils {
    private static final String TAG = "EncryptUtils";

    public static String aes128Decrypt(String str, String str2) {
        if (str2 == null) {
            try {
                Log.e(TAG, "Key null");
                return null;
            } catch (Throwable th) {
                System.out.println(th.toString());
                return null;
            }
        } else if (str2.length() != 16) {
            Log.e(TAG, "Key is not 16");
            return null;
        } else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            return new String(instance.doFinal(Base64.decode(str, 0)), "utf-8");
        }
    }

    public static String aes128Encrypt(String str, String str2) {
        if (str2 == null) {
            try {
                Log.e(TAG, "Key null");
                return null;
            } catch (Throwable unused) {
                return null;
            }
        } else if (str2.length() != 16) {
            Log.e(TAG, "Key not 16");
            return null;
        } else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(1, secretKeySpec);
            return Base64.encodeToString(instance.doFinal(str.getBytes("utf-8")), 0);
        }
    }

    public static String base64Decrypt(String str) {
        try {
            return new String(Base64.decode(str.getBytes("utf-8"), 0), "utf-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String base64Encrypt(String str) {
        try {
            return Base64.encodeToString(str.getBytes("utf-8"), 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}
