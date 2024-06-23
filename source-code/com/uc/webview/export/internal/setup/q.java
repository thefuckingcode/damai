package com.uc.webview.export.internal.setup;

/* compiled from: Taobao */
final class q implements Runnable {
    final /* synthetic */ l a;
    final /* synthetic */ UCMRunningInfo b;
    final /* synthetic */ p c;

    q(p pVar, l lVar, UCMRunningInfo uCMRunningInfo) {
        this.c = pVar;
        this.a = lVar;
        this.b = uCMRunningInfo;
    }

    public final void run() {
        o.b(this.c.a, this.b);
    }
}
