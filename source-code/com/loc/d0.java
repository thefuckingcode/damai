package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
public final class d0 {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;

    public d0(Context context, String str, String str2, String str3) throws k {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new k("无效的参数 - IllegalArgumentException");
        }
        this.a = context.getApplicationContext();
        this.c = str;
        this.d = str2;
        this.b = str3;
    }

    private static byte[] c(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private byte[] d(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[]{0, 0};
        }
        byte[] p = v1.p(this.e);
        return p == null ? new byte[]{0, 0} : v1.o(p.length);
    }

    public final void a(String str) throws k {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new k("无效的参数 - IllegalArgumentException");
        }
        this.e = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    public final byte[] b() {
        Throwable th;
        int i = 0;
        byte[] bArr = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                v1.l(byteArrayOutputStream2, this.c);
                v1.l(byteArrayOutputStream2, this.d);
                v1.l(byteArrayOutputStream2, this.b);
                v1.l(byteArrayOutputStream2, String.valueOf(o.a0(this.a)));
                try {
                    i = (int) (System.currentTimeMillis() / 1000);
                } catch (Throwable unused) {
                }
                byteArrayOutputStream2.write(c(i));
                byteArrayOutputStream2.write(d(this.e));
                byteArrayOutputStream2.write(v1.p(this.e));
                bArr = byteArrayOutputStream2.toByteArray();
                try {
                    byteArrayOutputStream2.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    an.m(th, "se", "tds");
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return bArr;
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
        } catch (Throwable th5) {
            th = th5;
            an.m(th, "se", "tds");
            if (byteArrayOutputStream != null) {
            }
            return bArr;
        }
        return bArr;
        throw th;
    }
}
