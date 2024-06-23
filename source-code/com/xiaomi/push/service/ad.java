package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ad extends XMPushService.j {
    final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f872a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f873a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ad(int i, XMPushService xMPushService, Cif ifVar, String str) {
        super(i);
        this.f872a = xMPushService;
        this.a = ifVar;
        this.f873a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m784a() {
        try {
            Cif a2 = y.a((Context) this.f872a, this.a);
            a2.m617a().a("absent_target_package", this.f873a);
            ah.a(this.f872a, a2);
        } catch (gh e) {
            b.a(e);
            this.f872a.a(10, e);
        }
    }
}
