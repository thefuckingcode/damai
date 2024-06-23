package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ac extends XMPushService.j {
    final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f871a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ac(int i, XMPushService xMPushService, Cif ifVar) {
        super(i);
        this.f871a = xMPushService;
        this.a = ifVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "send ack message for unrecognized new miui message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m783a() {
        try {
            Cif a2 = y.a((Context) this.f871a, this.a);
            a2.m617a().a("miui_message_unrecognized", "1");
            ah.a(this.f871a, a2);
        } catch (gh e) {
            b.a(e);
            this.f871a.a(10, e);
        }
    }
}
