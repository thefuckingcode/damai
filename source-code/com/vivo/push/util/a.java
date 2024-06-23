package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
public class a {
    private static volatile a c;
    private byte[] a;
    private byte[] b;

    private a(Context context) {
        w.b().a(ContextDelegate.getContext(context));
        w b2 = w.b();
        this.a = b2.c();
        this.b = b2.d();
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context.getApplicationContext());
                }
            }
        }
        return c;
    }

    public final String b(String str) throws Exception {
        return new String(f.a(f.a(a()), f.a(b()), Base64.decode(str, 2)), "utf-8");
    }

    private byte[] b() {
        byte[] bArr = this.b;
        if (bArr == null || bArr.length <= 0) {
            return w.b().d();
        }
        return bArr;
    }

    public final String a(String str) throws Exception {
        String a2 = f.a(a());
        String a3 = f.a(b());
        byte[] bytes = str.getBytes("utf-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(a3.getBytes("utf-8"), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(a2.getBytes("utf-8")));
        return Base64.encodeToString(instance.doFinal(bytes), 2);
    }

    private byte[] a() {
        byte[] bArr = this.a;
        if (bArr == null || bArr.length <= 0) {
            return w.b().c();
        }
        return bArr;
    }
}
