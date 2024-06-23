package com.vivo.push.d;

import com.vivo.push.a.a;
import com.vivo.push.b.d;
import com.vivo.push.b.f;
import com.vivo.push.b.y;
import com.vivo.push.l;
import com.vivo.push.o;
import com.vivo.push.util.t;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class b extends l {
    b(o oVar) {
        super(oVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.l
    public final void a(o oVar) {
        boolean z;
        com.vivo.push.model.b a = t.a(this.a);
        if (((d) oVar).d()) {
            try {
                z = f.a(this.a);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            z = f.b(this.a);
        }
        if (z) {
            com.vivo.push.model.b a2 = t.a(this.a);
            if (a == null || a2 == null || a2.a() == null || !a2.a().equals(a.a())) {
                if (!(a == null || a.a() == null)) {
                    a.a(this.a, a.a(), new y(a.a()));
                }
                if (a2 != null && a2.a() != null) {
                    a.a(this.a, a2.a(), new f());
                }
            }
        }
    }
}
