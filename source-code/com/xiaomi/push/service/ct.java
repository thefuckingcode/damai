package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.u;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ct implements u.a {
    final /* synthetic */ XMPushService.j a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f965a;

    ct(XMPushService xMPushService, XMPushService.j jVar) {
        this.f965a = xMPushService;
        this.a = jVar;
    }

    @Override // com.xiaomi.push.service.u.a
    public void a() {
        this.f965a.a(this.a);
    }
}
