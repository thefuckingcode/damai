package com.vivo.push.d;

import com.vivo.push.o;
import com.vivo.push.util.p;
import com.vivo.push.util.y;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class g extends z {
    g(o oVar) {
        super(oVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.l
    public final void a(o oVar) {
        p.d("OnClearCacheTask", "delete push info " + this.a.getPackageName());
        y.b(this.a).a();
    }
}
