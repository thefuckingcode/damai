package tb;

import android.content.Context;
import android.text.TextUtils;
import com.loc.u1;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* compiled from: Taobao */
public final class r53 extends p23 {
    Map<String, String> o = null;
    private String p = "";
    String q = "";
    String r = "";
    byte[] s = null;
    byte[] t = null;
    boolean u = false;
    String v = null;
    Map<String, String> w = null;
    boolean x = false;

    public r53(Context context, u1 u1Var) {
        super(context, u1Var);
    }

    @Override // tb.p23
    public final byte[] O() {
        return this.s;
    }

    @Override // tb.p23
    public final byte[] P() {
        return this.t;
    }

    @Override // tb.p23
    public final boolean R() {
        return this.u;
    }

    @Override // tb.p23
    public final String S() {
        return this.v;
    }

    /* access modifiers changed from: protected */
    @Override // tb.p23
    public final boolean T() {
        return this.x;
    }

    public final void U(Map<String, String> map) {
        this.w = map;
    }

    public final void V(String str) {
        this.v = str;
    }

    public final void W(Map<String, String> map) {
        this.o = map;
    }

    public final void X(boolean z) {
        this.u = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002a A[SYNTHETIC, Splitter:B:19:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    public final void Y(byte[] bArr) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            if (bArr != null) {
                try {
                    byteArrayOutputStream2.write(p23.N(bArr));
                    byteArrayOutputStream2.write(bArr);
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        th.printStackTrace();
                        if (byteArrayOutputStream == null) {
                            try {
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } finally {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
            this.t = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
        }
    }

    public final void Z(String str) {
        this.q = str;
    }

    public final void a0(boolean z) {
        this.x = z;
    }

    @Override // com.loc.bl
    public final Map<String, String> b() {
        return this.o;
    }

    public final void b0(byte[] bArr) {
        this.s = bArr;
    }

    public final void c0(String str) {
        this.r = str;
    }

    public final void d0(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.p = str;
        } else {
            this.p = "";
        }
    }

    @Override // com.loc.bl
    public final String j() {
        return this.q;
    }

    @Override // com.loc.bl, tb.l63
    public final String m() {
        return this.r;
    }

    @Override // com.loc.bl, tb.p23
    public final Map<String, String> q() {
        return this.w;
    }

    @Override // com.loc.bl
    public final String s() {
        return this.p;
    }

    @Override // com.loc.bl
    public final String t() {
        return "loc";
    }
}
