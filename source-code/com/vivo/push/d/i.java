package com.vivo.push.d;

import java.util.List;

/* compiled from: Taobao */
final class i implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ h e;

    i(h hVar, int i, List list, List list2, String str) {
        this.e = hVar;
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = str;
    }

    public final void run() {
        h hVar = this.e;
        ((z) hVar).b.onDelTags(h.a(hVar), this.a, this.b, this.c, this.d);
    }
}
