package com.amap.api.mapcore.util;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
public class iz extends jb {
    public static int a = 13;
    public static int b = 6;
    private Context e;

    public iz(Context context, jb jbVar) {
        super(jbVar);
        this.e = context;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.jb
    public byte[] a(byte[] bArr) {
        byte[] a2 = a(this.e);
        byte[] bArr2 = new byte[(a2.length + bArr.length)];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(bArr, 0, bArr2, a2.length, bArr.length);
        return bArr2;
    }

    private byte[] a(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            gn.a(byteArrayOutputStream, "1.2." + a + "." + b);
            gn.a(byteArrayOutputStream, "Android");
            gn.a(byteArrayOutputStream, gg.w(context));
            gn.a(byteArrayOutputStream, gg.n(context));
            gn.a(byteArrayOutputStream, gg.i(context));
            gn.a(byteArrayOutputStream, Build.getMANUFACTURER());
            gn.a(byteArrayOutputStream, Build.getMODEL());
            gn.a(byteArrayOutputStream, android.os.Build.DEVICE);
            gn.a(byteArrayOutputStream, gg.y(context));
            gn.a(byteArrayOutputStream, gc.c(context));
            gn.a(byteArrayOutputStream, gc.d(context));
            gn.a(byteArrayOutputStream, gc.f(context));
            byteArrayOutputStream.write(new byte[]{0});
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            throw th2;
        }
        return bArr;
    }
}
