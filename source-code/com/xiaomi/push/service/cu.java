package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ae;
import com.xiaomi.push.fx;
import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class cu extends XMPushService.j {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f966a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f967a;
    final /* synthetic */ int b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cu(XMPushService xMPushService, int i, int i2, String str, byte[] bArr) {
        super(i);
        this.a = xMPushService;
        this.b = i2;
        this.f966a = str;
        this.f967a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m847a() {
        u.m872a((Context) this.a);
        bg.a().m826a("5");
        ae.a(this.b);
        XMPushService.a(this.a).c(fx.a());
        b.m182a("clear account and start registration. " + this.f966a);
        this.a.a(this.f967a, this.f966a);
    }
}
