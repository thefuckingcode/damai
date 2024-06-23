package com.vivo.push.b;

import com.vivo.push.a;

/* compiled from: Taobao */
public final class l extends s {
    private int a = -1;
    private int b = -1;

    public l() {
        super(2016);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final void c(a aVar) {
        super.c(aVar);
        aVar.a("key_dispatch_environment", this.a);
        aVar.a("key_dispatch_area", this.b);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final void d(a aVar) {
        super.d(aVar);
        this.a = aVar.b("key_dispatch_environment", 1);
        this.b = aVar.b("key_dispatch_area", 1);
    }

    public final int e() {
        return this.b;
    }

    public final int d() {
        return this.a;
    }
}
