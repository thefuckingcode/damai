package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* compiled from: Taobao */
class cq implements bg.a {
    final /* synthetic */ XMPushService a;

    cq(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.bg.a
    public void a() {
        XMPushService.a(this.a);
        if (bg.a().m821a() <= 0) {
            XMPushService xMPushService = this.a;
            xMPushService.a(new XMPushService.g(12, null));
        }
    }
}
