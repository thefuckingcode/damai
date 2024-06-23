package tb;

import com.efs.sdk.base.Constants;

/* compiled from: Taobao */
public final class v23 extends m13 {
    private static boolean c(g23 g23) {
        if (!g23.g()) {
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
        byte[] a = t33.a(g23.c);
        if (a == null) {
            t43.b(Constants.TAG, "gzip error", null);
        } else {
            g23.e(a);
            g23.d("gzip");
        }
        b(g23);
    }
}
