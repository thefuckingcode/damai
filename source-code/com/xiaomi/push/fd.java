package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
class fd extends XMPushService.j {
    final /* synthetic */ fc a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    fd(fc fcVar, int i) {
        super(i);
        this.a = fcVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "Handling bind stats";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m471a() {
        this.a.c();
    }
}
