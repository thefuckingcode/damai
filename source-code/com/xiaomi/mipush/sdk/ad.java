package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.b;

/* compiled from: Taobao */
class ad extends BroadcastReceiver {
    final /* synthetic */ NotificationClickedActivity a;

    ad(NotificationClickedActivity notificationClickedActivity) {
        this.a = notificationClickedActivity;
    }

    public void onReceive(Context context, Intent intent) {
        b.b("clicked activity finish by normal.");
        this.a.finish();
    }
}
