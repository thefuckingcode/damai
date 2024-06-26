package android.taobao.windvane.util;

import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: Taobao */
public class RsaUtil {
    private static final String encryptMode = "RSA/ECB/PKCS1Padding";
    private static final String keyMode = "RSA";

    public static String decryptData(String str, Key key) throws IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        return new String(decryptData(Base64.decode(str, 0), key));
    }

    public static String encryptData(String str, Key key) throws IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        return Base64.encodeToString(encryptData(str.getBytes(), key), 0);
    }

    public static String getKeyString(Key key) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return Base64.encodeToString(key.getEncoded(), 0);
    }

    public static PrivateKey getPrivateKey(String str) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
    }

    public static PublicKey getPublicKey(String str) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
    }

    public static void main(String[] strArr) throws Exception {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
        instance.initialize(1024);
        KeyPair generateKeyPair = instance.generateKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) generateKeyPair.getPublic();
        String keyString = getKeyString(rSAPublicKey);
        String keyString2 = getKeyString((RSAPrivateKey) generateKeyPair.getPrivate());
        Cipher instance2 = Cipher.getInstance("RSA");
        byte[] bytes = "我们都很好！邮件：@sina.com".getBytes();
        instance2.init(1, rSAPublicKey);
        byte[] doFinal = instance2.doFinal(bytes);
        PublicKey publicKey = getPublicKey(keyString);
        PrivateKey privateKey = getPrivateKey(keyString2);
        instance2.init(2, privateKey);
        byte[] doFinal2 = instance2.doFinal(doFinal);
        getKeyString(publicKey);
        getKeyString(privateKey);
        new String(doFinal2);
    }

    public static byte[] decryptData(byte[] bArr, Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher instance = Cipher.getInstance(encryptMode);
        instance.init(2, key);
        return instance.doFinal(bArr);
    }

    public static byte[] encryptData(byte[] bArr, Key key) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher instance = Cipher.getInstance(encryptMode);
        instance.init(1, key);
        return instance.doFinal(bArr);
    }
}
