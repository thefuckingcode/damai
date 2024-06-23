package com.xiaomi.push;

import com.xiaomi.push.ao;

/* compiled from: Taobao */
class aq implements Runnable {
    final /* synthetic */ ao.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ao f98a;

    aq(ao aoVar, ao.b bVar) {
        this.f98a = aoVar;
        this.a = bVar;
    }

    public void run() {
        this.f98a.a(this.a);
    }
}
