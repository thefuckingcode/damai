package com.vivo.push.util;

import java.util.List;

/* compiled from: Taobao */
final class l implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ k b;

    l(k kVar, List list) {
        this.b = kVar;
        this.a = list;
    }

    public final void run() {
        if (this.b.b != null) {
            w.b().a("com.vivo.push.notify_key", this.b.c);
            NotifyAdapterUtil.pushNotification(this.b.a, this.a, this.b.b, this.b.c, this.b.e, this.b.f);
        }
    }
}
