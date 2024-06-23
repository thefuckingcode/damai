package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import com.xiaomi.channel.commonutils.logger.b;

/* compiled from: Taobao */
class cn implements Runnable {
    final /* synthetic */ XMPushService a;

    cn(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void run() {
        try {
            PackageManager packageManager = this.a.getApplicationContext().getPackageManager();
            ComponentName componentName = new ComponentName(this.a.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable th) {
            b.m182a("[Alarm] disable ping receiver may be failure. " + th);
        }
    }
}
