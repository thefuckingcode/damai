package com.vivo.push;

import com.vivo.push.e;
import com.vivo.push.util.p;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class g implements IPushActionListener {
    final /* synthetic */ e.a a;
    final /* synthetic */ e b;

    g(e eVar, e.a aVar) {
        this.b = eVar;
        this.a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        if (i == 0) {
            Object[] b2 = this.a.b();
            if (b2 == null || b2.length == 0) {
                p.a("PushClientManager", "bind app result is null");
            } else {
                this.b.a((String) this.a.b()[0]);
            }
        } else {
            this.b.k = null;
            this.b.j.b("APP_TOKEN");
        }
    }
}
