package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hj;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ch implements Runnable {
    final /* synthetic */ ii a;

    ch(ii iiVar) {
        this.a = iiVar;
    }

    public void run() {
        byte[] a2 = it.a(ah.a(this.a.c(), this.a.b(), this.a, hj.Notification));
        if (cg.a() instanceof XMPushService) {
            ((XMPushService) cg.a()).a(this.a.c(), a2, true);
        } else {
            b.m182a("UNDatas UploadNotificationDatas failed because not xmsf");
        }
    }
}
