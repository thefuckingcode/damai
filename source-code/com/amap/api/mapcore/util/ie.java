package com.amap.api.mapcore.util;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public abstract class ie extends gj {
    protected Context d;
    protected gm e;

    public ie(Context context, gm gmVar) {
        if (context != null) {
            this.d = context.getApplicationContext();
        }
        this.e = gmVar;
    }

    private byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(gn.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ha.a(th, "bre", "gbh");
            }
            return byteArray;
        } catch (Throwable th2) {
            ha.a(th2, "bre", "gbh");
            return null;
        }
    }

    private byte[] l() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] e2 = e();
            if (e2 != null) {
                if (e2.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byteArrayOutputStream.write(a(e2));
                    byteArrayOutputStream.write(e2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        ha.a(th, "bre", "grrd");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                ha.a(th2, "bre", "grrd");
            }
            return byteArray2;
        } catch (Throwable th3) {
            ha.a(th3, "bre", "grrd");
        }
        return new byte[]{0};
    }

    private byte[] m() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] f = f();
            if (f != null) {
                if (f.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byte[] a = gf.a(this.d, f);
                    byteArrayOutputStream.write(a(a));
                    byteArrayOutputStream.write(a);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        ha.a(th, "bre", "gred");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                ha.a(th2, "bre", "gred");
            }
            return byteArray2;
        } catch (Throwable th3) {
            ha.a(th3, "bre", "gred");
        }
        return new byte[]{0};
    }

    private boolean n() {
        gm gmVar = this.e;
        return gmVar != null && "navi".equals(gmVar.a());
    }

    public abstract byte[] e();

    public abstract byte[] f();

    /* access modifiers changed from: protected */
    public String g() {
        return "2.1";
    }

    @Override // com.amap.api.mapcore.util.ii
    public final byte[] getEntityBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(a());
            byteArrayOutputStream.write(i());
            byteArrayOutputStream.write(l());
            byteArrayOutputStream.write(m());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ha.a(th, "bre", "geb");
            }
            return byteArray;
        } catch (Throwable th2) {
            ha.a(th2, "bre", "geb");
            return null;
        }
    }

    @Override // com.amap.api.mapcore.util.ii
    public Map<String, String> getParams() {
        String f = gc.f(this.d);
        String a = gf.a();
        Context context = this.d;
        String a2 = gf.a(context, a, "key=" + f);
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a);
        hashMap.put("key", f);
        hashMap.put("scode", a2);
        return hashMap;
    }

    public boolean h() {
        return true;
    }

    public byte[] i() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (h()) {
                byte[] a = gf.a(this.d, k(), n());
                byteArrayOutputStream.write(a(a));
                byteArrayOutputStream.write(a);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a2 = gn.a(g());
            if (a2 == null || a2.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a2));
                byteArrayOutputStream.write(a2);
            }
            byte[] a3 = gn.a(j());
            if (a3 == null || a3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a3));
                byteArrayOutputStream.write(a3);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ha.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            ha.a(th2, "bre", "gred");
        }
        return new byte[]{0};
    }

    public String j() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.e.c(), this.e.a());
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return false;
    }

    /* access modifiers changed from: protected */
    public byte[] a(byte[] bArr) {
        return gn.a(bArr.length, 2);
    }
}
