package com.vivo.push.d;

import com.vivo.push.l;
import com.vivo.push.model.UnvarnishedMessage;

/* compiled from: Taobao */
final class q implements Runnable {
    final /* synthetic */ UnvarnishedMessage a;
    final /* synthetic */ p b;

    q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.b = pVar;
        this.a = unvarnishedMessage;
    }

    public final void run() {
        p pVar = this.b;
        ((z) pVar).b.onTransmissionMessage(((l) pVar).a, this.a);
    }
}
