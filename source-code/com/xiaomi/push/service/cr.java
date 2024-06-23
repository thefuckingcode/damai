package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
class cr extends ContentObserver {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cr(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.a = xMPushService;
    }

    public void onChange(boolean z) {
        super.onChange(z);
        boolean a2 = XMPushService.a(this.a);
        b.m182a("SuperPowerMode:" + a2);
        XMPushService.a(this.a);
        if (a2) {
            XMPushService xMPushService = this.a;
            xMPushService.a(new XMPushService.g(24, null));
            return;
        }
        this.a.a(true);
    }
}
