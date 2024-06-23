package com.youku.network.call;

import com.youku.network.a;

/* compiled from: Taobao */
public class d implements a {
    private a a;
    private e b;

    public d(a aVar, e eVar) {
        this.a = aVar;
        this.b = eVar;
    }

    private void b(com.youku.network.d dVar) {
        this.b.a(dVar);
    }

    @Override // com.youku.network.a
    public void a(com.youku.network.d dVar) {
        b(dVar);
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(dVar);
        }
    }
}
