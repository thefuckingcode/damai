package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.o;

/* compiled from: Taobao */
class ge extends XMPushService.j {
    final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ gd f417a;
    final /* synthetic */ long b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ge(gd gdVar, int i, long j, long j2) {
        super(i);
        this.f417a = gdVar;
        this.a = j;
        this.b = j2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "check the ping-pong." + this.b;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m513a() {
        Thread.yield();
        if (this.f417a.m505c() && !this.f417a.a(this.a)) {
            o.a(this.f417a.b).m856b();
            this.f417a.b.a(22, (Exception) null);
        }
    }
}
