package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
class ck extends XMPushService.j {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ck(XMPushService xMPushService, int i) {
        super(i);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "disconnect for service destroy.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m845a() {
        if (this.a.f836a != null) {
            this.a.f836a.b(15, (Exception) null);
            this.a.f836a = null;
        }
    }
}
