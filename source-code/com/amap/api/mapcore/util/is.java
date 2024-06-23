package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
public class is {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;

    public is(Context context, String str, String str2, String str3) throws gb {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new gb("无效的参数 - IllegalArgumentException");
        }
        this.a = context.getApplicationContext();
        this.c = str;
        this.d = str2;
        this.b = str3;
    }

    public void a(String str) throws gb {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new gb("无效的参数 - IllegalArgumentException");
        }
        this.e = str;
    }

    public byte[] a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public byte[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[]{0, 0};
        }
        byte[] a2 = gn.a(this.e);
        if (a2 == null) {
            return new byte[]{0, 0};
        }
        return gn.a(a2.length, 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    public byte[] a() {
        Throwable th;
        int i = 0;
        byte[] bArr = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                gn.a(byteArrayOutputStream2, this.c);
                gn.a(byteArrayOutputStream2, this.d);
                gn.a(byteArrayOutputStream2, this.b);
                gn.a(byteArrayOutputStream2, String.valueOf(gg.r(this.a)));
                try {
                    i = (int) (System.currentTimeMillis() / 1000);
                } catch (Throwable unused) {
                }
                byteArrayOutputStream2.write(a(i));
                byteArrayOutputStream2.write(b(this.e));
                byteArrayOutputStream2.write(gn.a(this.e));
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
                    hd.c(th, "se", "tds");
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
            hd.c(th, "se", "tds");
            if (byteArrayOutputStream != null) {
            }
            return bArr;
        }
        return bArr;
        throw th;
    }
}
