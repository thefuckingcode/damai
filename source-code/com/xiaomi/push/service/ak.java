package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.bg;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ak implements bg.b.a {
    final /* synthetic */ XMPushService a;

    ak(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        if (cVar2 == bg.c.binded) {
            x.a(this.a, true);
            x.a(this.a);
        } else if (cVar2 == bg.c.unbind) {
            b.m182a("onChange unbind");
            x.a(this.a, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
        }
    }
}
