package com.vivo.push.b;

import com.vivo.push.a;

/* compiled from: Taobao */
public final class i extends s {
    private String a;
    private String b;
    private String c;

    public i(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final void c(a aVar) {
        super.c(aVar);
        aVar.a("app_id", this.a);
        aVar.a("client_id", this.b);
        aVar.a("client_token", this.c);
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.c;
    }

    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final String toString() {
        return "OnBindCommand";
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final void d(a aVar) {
        super.d(aVar);
        this.a = aVar.a("app_id");
        this.b = aVar.a("client_id");
        this.c = aVar.a("client_token");
    }
}
