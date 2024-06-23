package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ae extends XMPushService.j {
    final /* synthetic */ Cif a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f874a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f875a;
    final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ae(int i, XMPushService xMPushService, Cif ifVar, String str, String str2) {
        super(i);
        this.f874a = xMPushService;
        this.a = ifVar;
        this.f875a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m785a() {
        try {
            Cif a2 = y.a((Context) this.f874a, this.a);
            a2.f618a.a("error", this.f875a);
            a2.f618a.a("reason", this.b);
            ah.a(this.f874a, a2);
        } catch (gh e) {
            b.a(e);
            this.f874a.a(10, e);
        }
    }
}
