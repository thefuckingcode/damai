package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bq;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class h implements Runnable {
    final /* synthetic */ a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bq f19a;

    h(a aVar, bq bqVar) {
        this.a = aVar;
        this.f19a = bqVar;
    }

    public void run() {
        this.f19a.run();
    }
}
