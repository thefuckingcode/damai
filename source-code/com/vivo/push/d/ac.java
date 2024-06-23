package com.vivo.push.d;

import java.util.List;

/* compiled from: Taobao */
final class ac implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ aa e;

    ac(aa aaVar, int i, List list, List list2, String str) {
        this.e = aaVar;
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = str;
    }

    public final void run() {
        aa aaVar = this.e;
        ((z) aaVar).b.onSetAlias(aa.b(aaVar), this.a, this.b, this.c, this.d);
    }
}
