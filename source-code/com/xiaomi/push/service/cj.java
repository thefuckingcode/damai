package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class cj extends XMPushService.j {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f963a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f964a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cj(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.a = xMPushService;
        this.f963a = str;
        this.f964a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "send mi push message";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m844a() {
        try {
            ah.a(this.a, this.f963a, this.f964a);
        } catch (gh e) {
            b.a(e);
            this.a.a(10, e);
        }
    }
}
