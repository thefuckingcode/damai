package tb;

import com.efs.sdk.base.a.c.a.a;
import com.efs.sdk.base.a.c.a.c;

/* compiled from: Taobao */
public final class n53 extends m13 {
    @Override // tb.m13
    public final void a(g23 g23) {
        Double d;
        c a = c.a();
        String str = g23.a.a;
        a aVar = a.e;
        if (c.a.nextDouble() * 100.0d <= ((!aVar.e.containsKey(str) || (d = aVar.e.get(str)) == null) ? 100.0d : d.doubleValue())) {
            b(g23);
        }
    }
}
