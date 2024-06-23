package tb;

import com.efs.sdk.base.a.b.e;
import com.efs.sdk.base.a.d.a;
import java.io.File;
import tb.k53;

/* compiled from: Taobao */
public final class q33 implements e {
    @Override // com.efs.sdk.base.a.b.e
    public final void a(File file) {
        w23.d(file, n13.g(a.a().c, a.a().a));
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(String str) {
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(g23 g23) {
        if (g23.c != null) {
            w23.f(new File(n13.g(a.a().c, a.a().a), w23.b(g23)), g23.c);
            k53.a.a.c.b();
            k53.a.a.c.c();
        }
    }

    @Override // com.efs.sdk.base.a.b.e
    public final boolean a(File file, g23 g23) {
        if (!file.exists()) {
            return false;
        }
        g23.d = file;
        g23.i();
        g23.f(1);
        return true;
    }
}
