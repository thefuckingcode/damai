package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ab extends XMPushService.j {
    final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f870a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ab(int i, XMPushService xMPushService, Cif ifVar) {
        super(i);
        this.f870a = xMPushService;
        this.a = ifVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "send ack message for obsleted message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m782a() {
        try {
            Cif a2 = y.a((Context) this.f870a, this.a);
            a2.m617a().a("message_obsleted", "1");
            ah.a(this.f870a, a2);
        } catch (gh e) {
            b.a(e);
            this.f870a.a(10, e);
        }
    }
}
