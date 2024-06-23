package com.xiaomi.mipush.sdk;

import com.xiaomi.channel.commonutils.logger.b;

/* compiled from: Taobao */
class ac implements Runnable {
    final /* synthetic */ NotificationClickedActivity a;

    ac(NotificationClickedActivity notificationClickedActivity) {
        this.a = notificationClickedActivity;
    }

    public void run() {
        b.e("clicked activity finish by timeout.");
        this.a.finish();
    }
}
