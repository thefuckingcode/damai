package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bk;

/* compiled from: Taobao */
class cm implements Runnable {
    final /* synthetic */ XMPushService a;

    cm(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void run() {
        this.a.f852a = true;
        try {
            b.m182a("try to trigger the wifi digest broadcast.");
            Object systemService = this.a.getApplicationContext().getSystemService("MiuiWifiService");
            if (systemService != null) {
                bk.b(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
            }
        } catch (Throwable unused) {
        }
    }
}
