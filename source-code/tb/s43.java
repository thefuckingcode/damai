package tb;

import com.efs.sdk.base.a.e.a;
import com.efs.sdk.base.a.e.b;
import tb.k53;

/* compiled from: Taobao */
public final class s43 extends m13 {
    @Override // tb.m13
    public final void a(g23 g23) {
        vy0 vy0;
        if (!g23.b.a) {
            b(g23);
            return;
        }
        a a = a.a();
        if (!g23.b.b || b.b().e(g23.a.a, g23.a())) {
            k53.a.a.c.b();
            k53.a.a.c.c();
            vy0 = a.b.a(g23, false);
        } else {
            vy0 = new vy0();
            vy0.c = "flow_limit";
        }
        g23.b.c = vy0;
        b(g23);
    }
}
