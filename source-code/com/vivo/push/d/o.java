package com.vivo.push.d;

import com.vivo.push.b.n;

/* compiled from: Taobao */
final class o implements Runnable {
    final /* synthetic */ n a;
    final /* synthetic */ n b;

    o(n nVar, n nVar2) {
        this.b = nVar;
        this.a = nVar2;
    }

    public final void run() {
        n nVar = this.b;
        ((z) nVar).b.onLog(nVar.a, this.a.d(), this.a.e(), this.a.f());
    }
}
