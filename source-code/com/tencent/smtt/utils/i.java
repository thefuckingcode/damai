package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.smtt.sdk.a.a;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import kotlin.UByte;

/* compiled from: PostEncryption */
public class i {
    private static final char[] a = "0123456789abcdef".toCharArray();
    private static i b;
    private String c = (this.e + String.valueOf(new Random().nextInt(89999999) + 10000000));
    private String d;
    private String e = String.valueOf(new Random().nextInt(89999999) + 10000000);

    private i() {
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (b == null) {
                b = new i();
            }
            iVar = b;
        }
        return iVar;
    }

    public void b() throws Exception {
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0012 */
    public String c() throws Exception {
        if (this.d == null) {
            byte[] bytes = this.c.getBytes();
            Cipher cipher = null;
            cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            try {
                b();
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.d = b(cipher.doFinal(bytes));
        }
        return this.d;
    }

    public byte[] a(byte[] bArr) throws Exception {
        return a.a(this.e.getBytes(), bArr, 1);
    }

    private String b(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 2;
            char[] cArr2 = a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }
}
