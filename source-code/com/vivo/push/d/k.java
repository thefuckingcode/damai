package com.vivo.push.d;

import com.vivo.push.b.l;
import com.vivo.push.o;
import com.vivo.push.util.w;

/* compiled from: Taobao */
public final class k extends z {
    k(o oVar) {
        super(oVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.l
    public final void a(o oVar) {
        l lVar = (l) oVar;
        int d = lVar.d();
        int e = lVar.e();
        w.b().a("key_dispatch_environment", d);
        w.b().a("key_dispatch_area", e);
    }
}
