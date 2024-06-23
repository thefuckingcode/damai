package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.bx;

/* compiled from: Taobao */
class by implements Runnable {
    final /* synthetic */ bx a;

    by(bx bxVar) {
        this.a = bxVar;
    }

    public void run() {
        try {
            for (bx.a aVar : bx.a(this.a).values()) {
                aVar.run();
            }
        } catch (Exception e) {
            b.m182a("Sync job exception :" + e.getMessage());
        }
        this.a.f951a = false;
    }
}
