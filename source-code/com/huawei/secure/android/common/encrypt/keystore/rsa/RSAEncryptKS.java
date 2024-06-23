package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public abstract class RSAEncryptKS {
    private static final String a = "RSAEncryptKS";
    private static final String b = "AndroidKeyStore";
    private static final String c = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    private static final String d = "";
    private static final int e = 2048;
    private static final int f = 3072;

    private static byte[] a(String str, byte[] bArr, boolean z) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.b(a, "alias or content is null");
            return bArr2;
        } else if (!a()) {
            b.b(a, "sdk version is too low");
            return bArr2;
        } else {
            PublicKey b2 = b(str, z);
            if (b2 == null) {
                b.b(a, "Public key is null");
                return bArr2;
            }
            try {
                Cipher instance = Cipher.getInstance(c);
                instance.init(1, b2, new OAEPParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", new MGF1ParameterSpec(MessageDigestAlgorithms.SHA_1), PSource.PSpecified.DEFAULT));
                return instance.doFinal(bArr);
            } catch (NoSuchAlgorithmException e2) {
                String str2 = a;
                b.b(str2, "NoSuchAlgorithmException: " + e2.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e3) {
                String str3 = a;
                b.b(str3, "NoSuchPaddingException: " + e3.getMessage());
                return bArr2;
            } catch (InvalidKeyException e4) {
                String str4 = a;
                b.b(str4, "InvalidKeyException: " + e4.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e5) {
                String str5 = a;
                b.b(str5, "InvalidAlgorithmParameterException: " + e5.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e6) {
                String str6 = a;
                b.b(str6, "IllegalBlockSizeException: " + e6.getMessage());
                return bArr2;
            } catch (BadPaddingException e7) {
                String str7 = a;
                b.b(str7, "BadPaddingException: " + e7.getMessage());
                return bArr2;
            } catch (Exception e8) {
                String str8 = a;
                b.b(str8, "Exception: " + e8.getMessage());
                return bArr2;
            }
        }
    }

    private static PublicKey b(String str, boolean z) {
        if (!b(str)) {
            a(str, z);
        }
        Certificate c2 = c(str);
        if (c2 != null) {
            return c2.getPublicKey();
        }
        return null;
    }

    private static Certificate c(String str) {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            return instance.getCertificate(str);
        } catch (KeyStoreException e2) {
            String str2 = a;
            b.b(str2, "KeyStoreException: " + e2.getMessage());
            return null;
        } catch (CertificateException e3) {
            String str3 = a;
            b.b(str3, "CertificateException: " + e3.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e4) {
            String str4 = a;
            b.b(str4, "NoSuchAlgorithmException: " + e4.getMessage());
            return null;
        } catch (IOException e5) {
            String str5 = a;
            b.b(str5, "IOException: " + e5.getMessage());
            return null;
        } catch (Exception e6) {
            String str6 = a;
            b.b(str6, "Exception: " + e6.getMessage());
            return null;
        }
    }

    @Deprecated
    public static String decrpyt(String str, String str2) {
        try {
            return new String(decrpyt(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            String str3 = a;
            b.b(str3, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        } catch (Exception e3) {
            String str4 = a;
            b.b(str4, "Exception: " + e3.getMessage());
            return "";
        }
    }

    public static String decrpytNew(String str, String str2) {
        try {
            return new String(decrpytNew(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            String str3 = a;
            b.b(str3, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        } catch (Exception e3) {
            String str4 = a;
            b.b(str4, "Exception: " + e3.getMessage());
            return "";
        }
    }

    @Deprecated
    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encrypt(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e2) {
            String str3 = a;
            b.b(str3, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        }
    }

    public static String encryptNew(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encryptNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e2) {
            String str3 = a;
            b.b(str3, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        }
    }

    @Deprecated
    public static byte[] decrpyt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.b(a, "alias or encrypted content is null");
            return bArr2;
        } else if (!a()) {
            b.b(a, "sdk version is too low");
            return bArr2;
        } else {
            PrivateKey a2 = a(str);
            if (a2 == null) {
                b.b(a, "Private key is null");
                return bArr2;
            }
            try {
                Cipher instance = Cipher.getInstance(c);
                instance.init(2, a2, new OAEPParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", new MGF1ParameterSpec(MessageDigestAlgorithms.SHA_1), PSource.PSpecified.DEFAULT));
                return instance.doFinal(bArr);
            } catch (NoSuchAlgorithmException e2) {
                String str2 = a;
                b.b(str2, "NoSuchAlgorithmException: " + e2.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e3) {
                String str3 = a;
                b.b(str3, "NoSuchPaddingException: " + e3.getMessage());
                return bArr2;
            } catch (InvalidKeyException e4) {
                String str4 = a;
                b.b(str4, "InvalidKeyException: " + e4.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e5) {
                String str5 = a;
                b.b(str5, "InvalidAlgorithmParameterException: " + e5.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e6) {
                String str6 = a;
                b.b(str6, "IllegalBlockSizeException: " + e6.getMessage());
                return bArr2;
            } catch (BadPaddingException e7) {
                String str7 = a;
                b.b(str7, "BadPaddingException: " + e7.getMessage());
                return bArr2;
            } catch (Exception e8) {
                String str8 = a;
                b.b(str8, "Exception: " + e8.getMessage());
                return bArr2;
            }
        }
    }

    public static byte[] decrpytNew(String str, byte[] bArr) {
        return decrpyt(str, bArr);
    }

    @Deprecated
    public static byte[] encrypt(String str, byte[] bArr) {
        return a(str, bArr, false);
    }

    public static byte[] encryptNew(String str, byte[] bArr) {
        return a(str, bArr, true);
    }

    private static boolean b(String str) {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (instance.getKey(str, null) != null) {
                return true;
            }
            return false;
        } catch (KeyStoreException e2) {
            String str2 = a;
            b.b(str2, "KeyStoreException: " + e2.getMessage());
            return false;
        } catch (CertificateException e3) {
            String str3 = a;
            b.b(str3, "CertificateException: " + e3.getMessage());
            return false;
        } catch (UnrecoverableKeyException e4) {
            String str4 = a;
            b.b(str4, "UnrecoverableKeyException: " + e4.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e5) {
            String str5 = a;
            b.b(str5, "NoSuchAlgorithmException: " + e5.getMessage());
            return false;
        } catch (IOException e6) {
            String str6 = a;
            b.b(str6, "IOException: " + e6.getMessage());
            return false;
        } catch (Exception e7) {
            String str7 = a;
            b.b(str7, "Exception: " + e7.getMessage());
            return false;
        }
    }

    private static synchronized KeyPair a(String str, boolean z) {
        synchronized (RSAEncryptKS.class) {
            KeyPair keyPair = null;
            if (b(str)) {
                b.b(a, "Key pair exits");
                return null;
            }
            b.c(a, "generate key pair.");
            try {
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                if (!z) {
                    instance.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests(MessageDigestAlgorithms.SHA_256, MessageDigestAlgorithms.SHA_512).setEncryptionPaddings("OAEPPadding").setKeySize(2048).build());
                } else {
                    instance.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests(MessageDigestAlgorithms.SHA_256, MessageDigestAlgorithms.SHA_512).setEncryptionPaddings("OAEPPadding").setKeySize(f).build());
                }
                keyPair = instance.generateKeyPair();
            } catch (NoSuchAlgorithmException e2) {
                String str2 = a;
                b.b(str2, "NoSuchAlgorithmException: " + e2.getMessage());
            } catch (NoSuchProviderException e3) {
                String str3 = a;
                b.b(str3, "NoSuchProviderException: " + e3.getMessage());
            } catch (InvalidAlgorithmParameterException e4) {
                String str4 = a;
                b.b(str4, "InvalidAlgorithmParameterException: " + e4.getMessage());
            } catch (Exception e5) {
                String str5 = a;
                b.b(str5, "Exception: " + e5.getMessage());
            }
            return keyPair;
        }
    }

    private static PrivateKey a(String str) {
        if (!b(str)) {
            return null;
        }
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            return (PrivateKey) instance.getKey(str, null);
        } catch (KeyStoreException e2) {
            String str2 = a;
            b.b(str2, "KeyStoreException: " + e2.getMessage());
            return null;
        } catch (CertificateException e3) {
            String str3 = a;
            b.b(str3, "CertificateException: " + e3.getMessage());
            return null;
        } catch (UnrecoverableKeyException e4) {
            String str4 = a;
            b.b(str4, "UnrecoverableKeyException: " + e4.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e5) {
            String str5 = a;
            b.b(str5, "NoSuchAlgorithmException: " + e5.getMessage());
            return null;
        } catch (IOException e6) {
            String str6 = a;
            b.b(str6, "IOException: " + e6.getMessage());
            return null;
        } catch (Exception e7) {
            String str7 = a;
            b.b(str7, "Exception: " + e7.getMessage());
            return null;
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
