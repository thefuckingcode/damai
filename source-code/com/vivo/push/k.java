package com.vivo.push;

import com.vivo.push.e;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    k(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    public final void run() {
        e.a aVar = this.b.d(this.a);
        if (aVar != null) {
            aVar.a(1003, new Object[0]);
        }
    }
}
