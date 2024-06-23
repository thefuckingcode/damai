package com.xiaomi.clientreport.manager;

import com.xiaomi.push.br;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class i implements Runnable {
    final /* synthetic */ a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ br f20a;

    i(a aVar, br brVar) {
        this.a = aVar;
        this.f20a = brVar;
    }

    public void run() {
        this.f20a.run();
    }
}
