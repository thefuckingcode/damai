package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.xiaomi.channel.commonutils.logger.b;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class p implements Runnable {
    final /* synthetic */ ComponentName a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f812a;

    p(Context context, ComponentName componentName) {
        this.f812a = context;
        this.a = componentName;
    }

    public void run() {
        try {
            PackageManager packageManager = this.f812a.getPackageManager();
            if (packageManager.getComponentEnabledSetting(this.a) != 2) {
                packageManager.setComponentEnabledSetting(this.a, 2, 1);
            }
        } catch (Throwable th) {
            b.m182a("close static register of network status receiver failed:" + th);
        }
    }
}
