package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
public final class dl {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;

    public dl(Context context, String str, String str2, String str3) throws bj {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new bj("无效的参数 - IllegalArgumentException");
        }
        this.a = context.getApplicationContext();
        this.c = str;
        this.d = str2;
        this.b = str3;
    }

    private static byte[] a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private byte[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[]{0, 0};
        }
        byte[] a2 = bw.a(this.e);
        if (a2 == null) {
            return new byte[]{0, 0};
        }
        return bw.a(a2.length);
    }

    public final void a(String str) throws bj {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new bj("无效的参数 - IllegalArgumentException");
        }
        this.e = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    public final byte[] a() {
        Throwable th;
        int i = 0;
        byte[] bArr = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bw.a(byteArrayOutputStream2, this.c);
                bw.a(byteArrayOutputStream2, this.d);
                bw.a(byteArrayOutputStream2, this.b);
                bw.a(byteArrayOutputStream2, String.valueOf(bo.n(this.a)));
                try {
                    i = (int) (System.currentTimeMillis() / 1000);
                } catch (Throwable unused) {
                }
                byteArrayOutputStream2.write(a(i));
                byteArrayOutputStream2.write(b(this.e));
                byteArrayOutputStream2.write(bw.a(this.e));
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
                    cl.c(th, "se", "tds");
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
            cl.c(th, "se", "tds");
            if (byteArrayOutputStream != null) {
            }
            return bArr;
        }
        return bArr;
        throw th;
    }
}
