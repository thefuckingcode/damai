package tb;

import anet.channel.util.ALog;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
public class rt0 {
    private static byte[] a(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "HmacSHA256");
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(secretKeySpec);
            return instance.doFinal(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String b(byte[] bArr, byte[] bArr2) {
        try {
            return ag2.b(a(bArr, bArr2));
        } catch (Throwable th) {
            ALog.e("awcn.HMacUtil", "hmacSha1Hex", null, "result", "", th);
            return "";
        }
    }
}
