package com.vivo.push.d;

/* compiled from: Taobao */
final class m implements Runnable {
    final /* synthetic */ com.vivo.push.b.m a;
    final /* synthetic */ l b;

    m(l lVar, com.vivo.push.b.m mVar) {
        this.b = lVar;
        this.a = mVar;
    }

    public final void run() {
        l lVar = this.b;
        ((z) lVar).b.onListTags(lVar.a, this.a.h(), this.a.d(), this.a.g());
    }
}
