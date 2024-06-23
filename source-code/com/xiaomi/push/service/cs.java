package com.xiaomi.push.service;

import com.xiaomi.push.bj;
import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class cs extends XMPushService.j {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cs(XMPushService xMPushService, int i) {
        super(i);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "prepare the mi push account.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m846a() {
        ah.a(this.a);
        if (bj.b(this.a)) {
            this.a.a(true);
        }
    }
}
