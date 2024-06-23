package com.vivo.push.b;

import com.vivo.push.a;

/* compiled from: Taobao */
public final class j extends s {
    private int a = -1;
    private int b = -1;

    public j() {
        super(12);
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final void c(a aVar) {
        super.c(aVar);
        aVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.a);
        aVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.b);
    }

    public final int d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    /* access modifiers changed from: protected */
    @Override // com.vivo.push.o, com.vivo.push.b.s
    public final void d(a aVar) {
        super.d(aVar);
        this.a = aVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.a);
        this.b = aVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.b);
    }
}
