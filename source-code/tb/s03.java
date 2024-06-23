package tb;

import com.efs.sdk.base.Constants;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
public final class s03 {
    private static final IvParameterSpec a = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    private static SecretKeySpec a(String str) {
        return new SecretKeySpec(str.getBytes(), "AES");
    }

    public static byte[] b(String str, String str2) {
        try {
            return d(str.getBytes("UTF-8"), str2);
        } catch (UnsupportedEncodingException e) {
            t43.c(Constants.TAG, "getBytes error", e);
            return null;
        }
    }

    public static byte[] c(byte[] bArr, String str) {
        try {
            SecretKeySpec a2 = a(str);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, a2, a);
            return instance.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            t43.c(Constants.TAG, "aes decrypt error", e);
            return null;
        }
    }

    public static byte[] d(byte[] bArr, String str) {
        try {
            SecretKeySpec a2 = a(str);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, a2, a);
            return instance.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            t43.c(Constants.TAG, "aes encrypt error", e);
            return null;
        }
    }
}
