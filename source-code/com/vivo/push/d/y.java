package com.vivo.push.d;

import com.vivo.push.b.r;

/* compiled from: Taobao */
final class y implements Runnable {
    final /* synthetic */ r a;
    final /* synthetic */ x b;

    y(x xVar, r rVar) {
        this.b = xVar;
        this.a = rVar;
    }

    public final void run() {
        x xVar = this.b;
        ((z) xVar).b.onPublish(x.a(xVar), this.a.h(), this.a.g());
    }
}
