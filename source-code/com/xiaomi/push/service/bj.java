package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* compiled from: Taobao */
class bj extends XMPushService.j {
    final /* synthetic */ bg.b.c a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bj(bg.b.c cVar, int i) {
        super(i);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "check peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m831a() {
        bg a2 = bg.a();
        bg.b bVar = this.a.f932a;
        if (a2.a(bVar.g, bVar.f928b).f919a == null) {
            XMPushService xMPushService = bg.b.this.f921a;
            bg.b bVar2 = this.a.f932a;
            xMPushService.a(bVar2.g, bVar2.f928b, 2, null, null);
        }
    }
}
