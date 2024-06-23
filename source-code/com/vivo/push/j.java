package com.vivo.push;

import com.vivo.push.b.b;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class j implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ String b;
    final /* synthetic */ e c;

    j(e eVar, b bVar, String str) {
        this.c = eVar;
        this.a = bVar;
        this.b = str;
    }

    public final void run() {
        this.c.a(this.a);
        this.c.e(this.b);
    }
}
