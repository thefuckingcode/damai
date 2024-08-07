package tb;

import android.util.Base64;
import com.efs.sdk.base.Constants;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public final class k23 {
    public static String a(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        try {
            BigInteger bigInteger = new BigInteger(1, MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes()));
            return String.format(Locale.CHINA, "%032x", bigInteger);
        } catch (NoSuchAlgorithmException e) {
            t43.c(Constants.TAG, "md5 error", e);
            return "";
        }
    }

    public static String b(byte[] bArr) {
        return new String(Base64.encode(bArr, 11));
    }

    public static String c(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            t43.c(Constants.TAG, "urlEncode error", e);
            return "";
        }
    }

    public static String d(byte[] bArr) {
        try {
            return new String(Base64.decode(bArr, 11));
        } catch (Throwable th) {
            t43.c(Constants.TAG, "decode error", th);
            return "";
        }
    }
}
