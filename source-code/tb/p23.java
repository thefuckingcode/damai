package tb;

import android.content.Context;
import com.loc.l;
import com.loc.o1;
import com.loc.u1;
import com.loc.v1;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public abstract class p23 extends l63 {
    protected Context l;
    protected u1 m;
    protected byte[] n;

    public p23(Context context, u1 u1Var) {
        if (context != null) {
            this.l = context.getApplicationContext();
        }
        this.m = u1Var;
        A();
    }

    private static byte[] J() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(v1.p("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                v13.e(th, "bre", "gbh");
            }
            return byteArray;
        } catch (Throwable th2) {
            v13.e(th2, "bre", "gbh");
            return null;
        }
    }

    private byte[] K() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (R()) {
                Context context = this.l;
                boolean T = T();
                u1 u1Var = this.m;
                byte[] f = o1.f(context, T, u1Var != null && "navi".equals(u1Var.a()));
                byteArrayOutputStream.write(N(f));
                byteArrayOutputStream.write(f);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] p = v1.p(Q());
            if (p == null || p.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(N(p));
                byteArrayOutputStream.write(p);
            }
            byte[] p2 = v1.p(S());
            if (p2 == null || p2.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(N(p2));
                byteArrayOutputStream.write(p2);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                v13.e(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            v13.e(th2, "bre", "gred");
        }
        return new byte[]{0};
    }

    private byte[] L() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] O = O();
            if (O != null) {
                if (O.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byteArrayOutputStream.write(N(O));
                    byteArrayOutputStream.write(O);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        v13.e(th, "bre", "grrd");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                v13.e(th2, "bre", "grrd");
            }
            return byteArray2;
        } catch (Throwable th3) {
            v13.e(th3, "bre", "grrd");
        }
        return new byte[]{0};
    }

    private byte[] M() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] P = P();
            if (P != null) {
                if (P.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byte[] g = o1.g(P);
                    byteArrayOutputStream.write(N(g));
                    byteArrayOutputStream.write(g);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        v13.e(th, "bre", "gred");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                v13.e(th2, "bre", "gred");
            }
            return byteArray2;
        } catch (Throwable th3) {
            v13.e(th3, "bre", "gred");
        }
        return new byte[]{0};
    }

    protected static byte[] N(byte[] bArr) {
        return v1.o(bArr.length);
    }

    public abstract byte[] O();

    public abstract byte[] P();

    /* access modifiers changed from: protected */
    public String Q() {
        return "2.1";
    }

    public boolean R() {
        return true;
    }

    public String S() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.m.f(), this.m.a());
    }

    /* access modifiers changed from: protected */
    public boolean T() {
        return false;
    }

    @Override // com.loc.bl
    public Map<String, String> q() {
        String j = l.j(this.l);
        String a = o1.a();
        String c = o1.c(this.l, a, "key=".concat(String.valueOf(j)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a);
        hashMap.put("key", j);
        hashMap.put("scode", c);
        return hashMap;
    }

    @Override // com.loc.bl
    public final byte[] r() {
        byte[] bArr = this.n;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(J());
            byteArrayOutputStream.write(K());
            byteArrayOutputStream.write(L());
            byteArrayOutputStream.write(M());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.n = byteArray;
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                v13.e(th, "bre", "geb");
            }
            return byteArray;
        } catch (Throwable th2) {
            v13.e(th2, "bre", "geb");
            return null;
        }
    }
}
