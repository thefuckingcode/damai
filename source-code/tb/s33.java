package tb;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.d.a;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* compiled from: Taobao */
public final class s33 extends m13 {
    private ILogEncryptAction b;

    public s33() {
        this.b = a.a().o == null ? new h23() : a.a().o;
    }

    private static boolean c(g23 g23) {
        if (!g23.h() && !Constants.LOG_TYPE_WA.equals(g23.a.a)) {
            k13 k13 = g23.a;
            if ((1 != k13.b || g23.b.a) && 1 != k13.c) {
                return false;
            }
        }
        return true;
    }

    @Override // tb.m13
    public final void a(g23 g23) {
        if (c(g23)) {
            b(g23);
            return;
        }
        byte[] encrypt = this.b.encrypt(a.a().b, g23.c);
        if (encrypt != null) {
            g23.e(encrypt);
            g23.c(this.b.getDeVal());
        }
        b(g23);
    }
}
