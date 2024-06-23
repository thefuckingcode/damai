package tb;

import android.text.TextUtils;
import com.alibaba.security.common.d.c;
import com.heytap.msp.push.encrypt.AESEncrypt;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: Taobao */
public class c23 {
    public static String a = null;
    public static final String b = "Y29tLm5lYXJtZS5tY3M=";
    public static String c = "";

    private static String a() {
        if (TextUtils.isEmpty(c)) {
            c = new String(u03.l(b));
        }
        byte[] c2 = c(b(c));
        return c2 != null ? new String(c2, Charset.forName("UTF-8")) : "";
    }

    public static byte[] b(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static byte[] c(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i = 0; i < length; i += 2) {
            byte b2 = bArr[i];
            int i2 = i + 1;
            bArr[i] = bArr[i2];
            bArr[i2] = b2;
        }
        return bArr;
    }

    public static String d(String str) {
        boolean z;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        boolean z2 = false;
        try {
            str2 = z23.a(str, a());
            w33.a("sdkDecrypt desDecrypt des data " + str2);
            z = true;
        } catch (Exception e) {
            w33.a("sdkDecrypt DES excepiton " + e.toString());
            z = false;
        }
        if (!TextUtils.isEmpty(str2)) {
            z2 = z;
        }
        if (z2) {
            return str2;
        }
        try {
            str2 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            a = "AES";
            r43.f().d(a);
            w33.a("sdkDecrypt desDecrypt aes data " + str2);
            return str2;
        } catch (Exception e2) {
            w33.a("sdkDecrypt AES excepiton " + e2.toString());
            return str2;
        }
    }

    public static String e(String str) {
        boolean z;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        boolean z2 = false;
        try {
            str2 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            w33.a("sdkDecrypt aesDecrypt aes data " + str2);
            z = true;
        } catch (Exception e) {
            w33.a("sdkDecrypt AES excepiton " + e.toString());
            z = false;
        }
        if (!TextUtils.isEmpty(str2)) {
            z2 = z;
        }
        if (z2) {
            return str2;
        }
        try {
            str2 = z23.a(str, a());
            a = c.a;
            r43.f().d(a);
            w33.a("sdkDecrypt aesDecrypt des data " + str2);
            return str2;
        } catch (Exception e2) {
            w33.a("sdkDecrypt DES excepiton " + e2.toString());
            return str2;
        }
    }

    public static String f(String str) {
        w33.a("sdkDecrypt start data " + str);
        if (TextUtils.isEmpty(a)) {
            a = r43.f().e();
        }
        if (c.a.equals(a)) {
            w33.a("sdkDecrypt start DES");
            return d(str);
        }
        w33.a("sdkDecrypt start AES");
        return e(str);
    }
}
