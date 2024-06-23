package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* compiled from: Taobao */
class bi extends XMPushService.j {
    final /* synthetic */ bg.b.c a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bi(bg.b.c cVar, int i) {
        super(i);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m830a() {
        bg.b.c cVar = this.a;
        if (cVar.a == cVar.f932a.f919a) {
            b.b("clean peer, chid = " + this.a.f932a.g);
            this.a.f932a.f919a = null;
        }
    }
}
