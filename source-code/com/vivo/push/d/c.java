package com.vivo.push.d;

import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.l;
import com.vivo.push.o;
import com.vivo.push.util.p;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class c extends l {
    c(o oVar) {
        super(oVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.l
    public final void a(o oVar) {
        p.a(ClientConfigManagerImpl.getInstance(this.a).isDebug());
    }
}
