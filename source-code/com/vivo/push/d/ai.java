package com.vivo.push.d;

import com.vivo.push.a.a;
import com.vivo.push.b.c;
import com.vivo.push.e;
import com.vivo.push.l;
import com.vivo.push.model.b;
import com.vivo.push.o;
import com.vivo.push.util.s;
import com.vivo.push.util.t;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ai extends l {
    ai(o oVar) {
        super(oVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.l
    public final void a(o oVar) {
        c cVar = (c) oVar;
        b a = t.a(this.a);
        if (a == null) {
            e.a().a(cVar.h(), 1005, new Object[0]);
            return;
        }
        String a2 = a.a();
        if (a.c()) {
            e.a().a(cVar.h(), 1004, new Object[0]);
            oVar = new com.vivo.push.b.e();
        } else {
            int a3 = s.a(cVar);
            if (a3 != 0) {
                e.a().a(cVar.h(), a3, new Object[0]);
                return;
            }
        }
        a.a(this.a, a2, oVar);
    }
}
