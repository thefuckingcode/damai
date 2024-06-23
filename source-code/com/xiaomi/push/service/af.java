package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.ia;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class af extends XMPushService.j {
    final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ii f876a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f877a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    af(int i, ii iiVar, Cif ifVar, XMPushService xMPushService) {
        super(i);
        this.f876a = iiVar;
        this.a = ifVar;
        this.f877a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "send ack message for clear push message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m786a() {
        try {
            ia iaVar = new ia();
            iaVar.c(ht.CancelPushMessageACK.f497a);
            iaVar.a(this.f876a.m632a());
            iaVar.a(this.f876a.a());
            iaVar.b(this.f876a.b());
            iaVar.e(this.f876a.c());
            iaVar.a(0);
            iaVar.d("success clear push message.");
            ah.a(this.f877a, ah.b(this.a.b(), this.a.m618a(), iaVar, hj.Notification));
        } catch (gh e) {
            b.d("clear push message. " + e);
            this.f877a.a(10, e);
        }
    }
}
