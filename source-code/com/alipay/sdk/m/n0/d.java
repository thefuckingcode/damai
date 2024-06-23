package com.alipay.sdk.m.n0;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.motu.crashreporter.Constants;
import com.alipay.sdk.m.l0.b;
import com.alipay.sdk.m.l0.c;
import com.alipay.sdk.m.l0.e;
import com.alipay.sdk.m.l0.f;
import com.alipay.sdk.m.m0.a;
import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.StringUtils;
import tb.ok1;

/* compiled from: Taobao */
public class d {
    public static final Object i = new Object();
    public static d j;
    public static final String k = (".UTSystemConfig" + File.separator + "Global");
    public Context a = null;
    public String b = null;
    public e c = null;
    public String d = "xx_utdid_key";
    public String e = "xx_utdid_domain";
    public a f = null;
    public a g = null;
    public Pattern h = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public d(Context context) {
        this.a = context;
        this.g = new a(context, k, "Alvin2", false, true);
        this.f = new a(context, ".DataStorage", "ContextData", false, true);
        this.c = new e();
        this.d = String.format("K_%d", Integer.valueOf(f.a(this.d)));
        this.e = String.format("D_%d", Integer.valueOf(f.a(this.e)));
    }

    public static d a(Context context) {
        if (context != null && j == null) {
            synchronized (i) {
                if (j == null) {
                    d dVar = new d(context);
                    j = dVar;
                    dVar.e();
                }
            }
        }
        return j;
    }

    private void c(String str) {
        a aVar;
        if (b(str)) {
            if (str.endsWith(StringUtils.LF)) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24 && (aVar = this.g) != null) {
                aVar.a("UTDID2", str);
                this.g.a();
            }
        }
    }

    private void d(String str) {
        a aVar;
        if (str != null && (aVar = this.f) != null && !str.equals(aVar.a(this.d))) {
            this.f.a(this.d, str);
            this.f.a();
        }
    }

    private void e() {
        a aVar = this.g;
        if (aVar != null) {
            if (f.m180a(aVar.a("UTDID2"))) {
                String a2 = this.g.a(Constants.UTDID);
                if (!f.m180a(a2)) {
                    c(a2);
                }
            }
            boolean z = false;
            boolean z2 = true;
            if (!f.m180a(this.g.a("DID"))) {
                this.g.b("DID");
                z = true;
            }
            if (!f.m180a(this.g.a("EI"))) {
                this.g.b("EI");
                z = true;
            }
            if (!f.m180a(this.g.a("SI"))) {
                this.g.b("SI");
            } else {
                z2 = z;
            }
            if (z2) {
                this.g.a();
            }
        }
    }

    private byte[] f() throws Exception {
        String str;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] a2 = c.a(currentTimeMillis);
        byte[] a3 = c.a(nextInt);
        byteArrayOutputStream.write(a2, 0, 4);
        byteArrayOutputStream.write(a3, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = com.alipay.sdk.m.l0.d.a(this.a);
        } catch (Exception unused) {
            str = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(c.a(f.a(str)), 0, 4);
        byteArrayOutputStream.write(c.a(f.a(a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private String g() {
        a aVar = this.g;
        if (aVar == null) {
            return null;
        }
        String a2 = aVar.a("UTDID2");
        if (f.m180a(a2) || this.c.a(a2) == null) {
            return null;
        }
        return a2;
    }

    public synchronized String b() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        return a();
    }

    private boolean b(String str) {
        if (str != null) {
            if (str.endsWith(StringUtils.LF)) {
                str = str.substring(0, str.length() - 1);
            }
            return 24 == str.length() && !this.h.matcher(str).find();
        }
    }

    public synchronized String a() {
        String c2 = c();
        this.b = c2;
        if (!TextUtils.isEmpty(c2)) {
            return this.b;
        }
        try {
            byte[] f2 = f();
            if (f2 != null) {
                String c3 = b.c(f2, 2);
                this.b = c3;
                c(c3);
                String a2 = this.c.a(f2);
                if (a2 != null) {
                    d(a2);
                }
                return this.b;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public synchronized String c() {
        String g2 = g();
        if (b(g2)) {
            d(this.c.a(g2));
            this.b = g2;
            return g2;
        }
        String a2 = this.f.a(this.d);
        if (!f.m180a(a2)) {
            String a3 = new f().a(a2);
            if (!b(a3)) {
                a3 = this.c.b(a2);
            }
            if (b(a3) && !f.m180a(a3)) {
                this.b = a3;
                c(a3);
                return this.b;
            }
        }
        return null;
    }

    public static String a(byte[] bArr) throws Exception {
        byte[] bArr2 = {69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, SignedBytes.MAX_POWER_OF_TWO, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, ok1.OP_CREATE_JSON, -80, -68, -78, -117, 53, 30, -122, SignedBytes.MAX_POWER_OF_TWO, -104, 74, -49, 106, 85, -38, -93};
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(e.a(bArr2), instance.getAlgorithm()));
        return b.c(instance.doFinal(bArr), 2);
    }
}
