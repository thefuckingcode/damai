package com.amap.api.col.s;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public abstract class da extends br {
    protected Context a;
    protected bv b;
    protected byte[] c;

    public da(Context context, bv bvVar) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
        this.b = bvVar;
        q();
    }

    private byte[] A() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            Context context = this.a;
            bv bvVar = this.b;
            byte[] a2 = bn.a(context, bvVar != null && "navi".equals(bvVar.b()));
            byteArrayOutputStream.write(a(a2));
            byteArrayOutputStream.write(a2);
            byte[] a3 = bw.a(d());
            if (a3 == null || a3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a3));
                byteArrayOutputStream.write(a3);
            }
            byte[] a4 = bw.a(j());
            if (a4 == null || a4.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a4));
                byteArrayOutputStream.write(a4);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ci.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            ci.a(th2, "bre", "gred");
        }
        return new byte[]{0};
    }

    private static byte[] B() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ci.a(th, "bre", "grrd");
            }
            return byteArray;
        } catch (Throwable th2) {
            ci.a(th2, "bre", "grrd");
        }
        return new byte[]{0};
    }

    private byte[] C() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] b2 = b();
            if (b2 != null) {
                if (b2.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byte[] a2 = bn.a(b2);
                    byteArrayOutputStream.write(a(a2));
                    byteArrayOutputStream.write(a2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        ci.a(th, "bre", "gred");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                ci.a(th2, "bre", "gred");
            }
            return byteArray2;
        } catch (Throwable th3) {
            ci.a(th3, "bre", "gred");
        }
        return new byte[]{0};
    }

    private static byte[] a(byte[] bArr) {
        return bw.a(bArr.length);
    }

    private static byte[] z() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(bw.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ci.a(th, "bre", "gbh");
            }
            return byteArray;
        } catch (Throwable th2) {
            ci.a(th2, "bre", "gbh");
            return null;
        }
    }

    public abstract byte[] b();

    /* access modifiers changed from: protected */
    public String d() {
        return "2.1";
    }

    @Override // com.amap.api.col.s.df
    public final Map<String, String> e() {
        String f = bk.f(this.a);
        String a2 = bn.a();
        String a3 = bn.a(this.a, a2, "key=".concat(String.valueOf(f)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a2);
        hashMap.put("key", f);
        hashMap.put("scode", a3);
        return hashMap;
    }

    @Override // com.amap.api.col.s.df
    public final byte[] g() {
        byte[] bArr = this.c;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(z());
            byteArrayOutputStream.write(A());
            byteArrayOutputStream.write(B());
            byteArrayOutputStream.write(C());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.c = byteArray;
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ci.a(th, "bre", "geb");
            }
            return byteArray;
        } catch (Throwable th2) {
            ci.a(th2, "bre", "geb");
            return null;
        }
    }

    public final String j() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.b.d(), this.b.b());
    }
}
