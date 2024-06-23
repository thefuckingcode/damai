package tb;

import android.util.Base64;
import com.alibaba.security.common.d.c;
import java.nio.charset.Charset;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* compiled from: Taobao */
public abstract class z23 {
    public static String a(String str, String str2) {
        Cipher instance = Cipher.getInstance(c.a);
        instance.init(2, b(str2));
        return new String(instance.doFinal(Base64.decode(str, 0)), Charset.defaultCharset()).trim();
    }

    private static Key b(String str) {
        return SecretKeyFactory.getInstance(c.a).generateSecret(new DESKeySpec(Base64.decode(str, 0)));
    }
}
