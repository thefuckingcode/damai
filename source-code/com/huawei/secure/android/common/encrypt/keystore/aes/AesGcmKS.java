package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* compiled from: Taobao */
public class AesGcmKS {
    private static final String a = "GCMKS";
    private static final String b = "AndroidKeyStore";
    private static final String c = "AES/GCM/NoPadding";
    private static final String d = "";
    private static final int e = 12;
    private static final int f = 256;
    private static Map<String, SecretKey> g = new HashMap();

    private static SecretKey a(String str) {
        b.c(a, "load key");
        SecretKey secretKey = null;
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            Key key = instance.getKey(str, null);
            if (key instanceof SecretKey) {
                secretKey = (SecretKey) key;
            } else {
                b.c(a, "generate key");
                KeyGenerator instance2 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                instance2.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
                secretKey = instance2.generateKey();
            }
        } catch (KeyStoreException e2) {
            b.b(a, "KeyStoreException : " + e2.getMessage());
        } catch (IOException e3) {
            b.b(a, "IOException : " + e3.getMessage());
        } catch (CertificateException e4) {
            b.b(a, "CertificateException : " + e4.getMessage());
        } catch (NoSuchAlgorithmException e5) {
            b.b(a, "NoSuchAlgorithmException : " + e5.getMessage());
        } catch (UnrecoverableKeyException e6) {
            b.b(a, "UnrecoverableKeyException : " + e6.getMessage());
        } catch (InvalidAlgorithmParameterException e7) {
            b.b(a, "InvalidAlgorithmParameterException : " + e7.getMessage());
        } catch (NoSuchProviderException e8) {
            b.b(a, "NoSuchProviderException : " + e8.getMessage());
        } catch (Exception e9) {
            b.b(a, "Exception: " + e9.getMessage());
        }
        g.put(str, secretKey);
        return secretKey;
    }

    private static SecretKey b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (g.get(str) == null) {
            a(str);
        }
        return g.get(str);
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(a, "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            b.b(a, "decrypt: UnsupportedEncodingException : " + e2.getMessage());
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(a, "alias or encrypt content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            b.b(a, "encrypt: UnsupportedEncodingException : " + e2.getMessage());
            return "";
        }
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.b(a, "alias or encrypt content is null");
            return bArr2;
        } else if (!a()) {
            b.b(a, "sdk version is too low");
            return bArr2;
        } else if (bArr.length > 12) {
            return decrypt(b(str), bArr);
        } else {
            b.b(a, "Decrypt source data is invalid.");
            return bArr2;
        }
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.b(a, "alias or encrypt content is null");
            return bArr2;
        } else if (a()) {
            return encrypt(b(str), bArr);
        } else {
            b.b(a, "sdk version is too low");
            return bArr2;
        }
    }

    public static byte[] encrypt(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null) {
            b.b(a, "content is null");
            return bArr2;
        } else if (secretKey == null) {
            b.b(a, "secret key is null");
            return bArr2;
        } else if (!a()) {
            b.b(a, "sdk version is too low");
            return bArr2;
        } else {
            try {
                Cipher instance = Cipher.getInstance(c);
                instance.init(1, secretKey);
                byte[] doFinal = instance.doFinal(bArr);
                byte[] iv = instance.getIV();
                if (iv != null) {
                    if (iv.length == 12) {
                        byte[] copyOf = Arrays.copyOf(iv, iv.length + doFinal.length);
                        System.arraycopy(doFinal, 0, copyOf, iv.length, doFinal.length);
                        return copyOf;
                    }
                }
                b.b(a, "IV is invalid.");
                return bArr2;
            } catch (NoSuchAlgorithmException e2) {
                b.b(a, "NoSuchAlgorithmException : " + e2.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e3) {
                b.b(a, "NoSuchPaddingException : " + e3.getMessage());
                return bArr2;
            } catch (BadPaddingException e4) {
                b.b(a, "BadPaddingException : " + e4.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e5) {
                b.b(a, "IllegalBlockSizeException : " + e5.getMessage());
                return bArr2;
            } catch (InvalidKeyException e6) {
                b.b(a, "InvalidKeyException : " + e6.getMessage());
                return bArr2;
            } catch (Exception e7) {
                b.b(a, "Exception: " + e7.getMessage());
                return bArr2;
            }
        }
    }

    public static byte[] decrypt(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (secretKey == null) {
            b.b(a, "Decrypt secret key is null");
            return bArr2;
        } else if (bArr == null) {
            b.b(a, "content is null");
            return bArr2;
        } else if (!a()) {
            b.b(a, "sdk version is too low");
            return bArr2;
        } else if (bArr.length <= 12) {
            b.b(a, "Decrypt source data is invalid.");
            return bArr2;
        } else {
            byte[] copyOf = Arrays.copyOf(bArr, 12);
            try {
                Cipher instance = Cipher.getInstance(c);
                instance.init(2, secretKey, new GCMParameterSpec(128, copyOf));
                return instance.doFinal(bArr, 12, bArr.length - 12);
            } catch (NoSuchAlgorithmException e2) {
                b.b(a, "NoSuchAlgorithmException : " + e2.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e3) {
                b.b(a, "NoSuchPaddingException : " + e3.getMessage());
                return bArr2;
            } catch (InvalidKeyException e4) {
                b.b(a, "InvalidKeyException : " + e4.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e5) {
                b.b(a, "InvalidAlgorithmParameterException : " + e5.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e6) {
                b.b(a, "IllegalBlockSizeException : " + e6.getMessage());
                return bArr2;
            } catch (BadPaddingException e7) {
                b.b(a, "BadPaddingException : " + e7.getMessage());
                return bArr2;
            } catch (Exception e8) {
                b.b(a, "Exception: " + e8.getMessage());
                return bArr2;
            }
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
