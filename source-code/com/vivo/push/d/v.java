package com.vivo.push.d;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.vivo.push.util.p;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
final class v implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Map b;
    final /* synthetic */ u c;

    v(u uVar, Context context, Map map) {
        this.c = uVar;
        this.a = context;
        this.b = map;
    }

    public final void run() {
        String packageName = this.a.getPackageName();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.a.getSystemService("activity")).getRunningTasks(100);
            if (runningTasks != null) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    ComponentName componentName = runningTaskInfo.topActivity;
                    if (componentName.getPackageName().equals(packageName)) {
                        p.d("OnNotificationClickTask", "topClassName=" + componentName.getClassName());
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        u.a(intent, this.b);
                        this.a.startActivity(intent);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            p.a("OnNotificationClickTask", "start recentIntent is error", e);
        }
        Intent launchIntentForPackage = this.a.getPackageManager().getLaunchIntentForPackage(this.a.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(268435456);
            u.a(launchIntentForPackage, this.b);
            this.a.startActivity(launchIntentForPackage);
            return;
        }
        p.a("OnNotificationClickTask", "LaunchIntent is null");
    }
}
