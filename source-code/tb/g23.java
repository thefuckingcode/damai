package tb;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;

/* compiled from: Taobao */
public final class g23 {
    public k13 a;
    public t23 b = new t23();
    public byte[] c;
    public File d;

    public g23(String str, byte b2) {
        this.a = new k13(str, b2);
    }

    public static g23 b(ILogProtocol iLogProtocol) {
        Exception e;
        g23 g23 = null;
        try {
            g23 g232 = new g23(iLogProtocol.getLogType(), iLogProtocol.getLogProtocol());
            try {
                int bodyType = iLogProtocol.getBodyType();
                if (bodyType == 0) {
                    g232.f(0);
                    g232.e(iLogProtocol.generate());
                    return g232;
                } else if (bodyType != 1) {
                    t43.b(Constants.TAG, "Can not support body type: " + iLogProtocol.getBodyType(), null);
                    return g232;
                } else {
                    g232.f(1);
                    g232.d = new File(iLogProtocol.getFilePath());
                    return g232;
                }
            } catch (Exception e2) {
                e = e2;
                g23 = g232;
                t43.c(Constants.TAG, "log send error", e);
                return g23;
            }
        } catch (Exception e3) {
            e = e3;
            t43.c(Constants.TAG, "log send error", e);
            return g23;
        }
    }

    private void j() {
        byte[] bArr;
        k13 k13 = this.a;
        int i = k13.c;
        if (i == 0 && (bArr = this.c) != null) {
            k13.f = (long) bArr.length;
        } else if (i == 1 && this.d.exists()) {
            this.a.f = this.d.length();
        }
    }

    public final long a() {
        j();
        return this.a.f;
    }

    public final void c(int i) {
        this.a.e = i;
        j();
    }

    public final void d(String str) {
        this.a.d = str;
    }

    public final void e(byte[] bArr) {
        this.c = bArr;
        j();
    }

    public final void f(int i) {
        this.a.c = i;
    }

    public final boolean g() {
        return !"none".equals(this.a.d);
    }

    public final boolean h() {
        return 1 != this.a.e;
    }

    public final void i() {
        this.b.a = true;
    }
}
