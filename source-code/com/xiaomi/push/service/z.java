package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class z extends XMPushService.j {
    final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1003a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    z(int i, XMPushService xMPushService, Cif ifVar) {
        super(i);
        this.f1003a = xMPushService;
        this.a = ifVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m878a() {
        try {
            ah.a(this.f1003a, ah.a(this.a.b(), this.a.m618a()));
        } catch (gh e) {
            b.a(e);
            this.f1003a.a(10, e);
        }
    }
}
