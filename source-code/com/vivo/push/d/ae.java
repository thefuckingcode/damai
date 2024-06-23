package com.vivo.push.d;

import com.vivo.push.b.i;

/* compiled from: Taobao */
final class ae implements Runnable {
    final /* synthetic */ i a;
    final /* synthetic */ ad b;

    ae(ad adVar, i iVar) {
        this.b = adVar;
        this.a = iVar;
    }

    public final void run() {
        ad adVar = this.b;
        ((z) adVar).b.onUnBind(ad.a(adVar), this.a.h(), this.a.d());
    }
}
