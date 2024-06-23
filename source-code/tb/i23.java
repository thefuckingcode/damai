package tb;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.b.a;
import com.efs.sdk.base.a.b.c;
import com.efs.sdk.base.a.b.e;
import tb.k53;

/* compiled from: Taobao */
public final class i23 extends m13 {
    @Override // tb.m13
    public final void a(g23 g23) {
        e a;
        byte[] bArr;
        if (g23.b.a) {
            b(g23);
            return;
        }
        a aVar = a.b.a;
        if (Constants.LOG_TYPE_WA.equals(g23.a.a) || c.a().a) {
            k13 k13 = g23.a;
            if ((k13.c != 0 || ((bArr = g23.c) != null && bArr.length != 0)) && (a = aVar.c.a(k13.b)) != null) {
                a.a(g23);
                return;
            }
            return;
        }
        if (!aVar.a) {
            k53 k53 = k53.a.a;
            int i = com.efs.sdk.base.a.c.a.c.a().e.a;
            if (k53.b != null || com.efs.sdk.base.a.d.a.a().d) {
                k53.b.b(k53.a("disk_limit", i));
            }
        }
        aVar.a = true;
    }
}
