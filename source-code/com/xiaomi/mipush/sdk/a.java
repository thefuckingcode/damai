package com.xiaomi.mipush.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import java.util.HashSet;
import java.util.Set;

@TargetApi(14)
/* compiled from: Taobao */
public class a implements Application.ActivityLifecycleCallbacks {
    private Set<String> a = new HashSet();

    private static void a(Application application) {
        application.registerActivityLifecycleCallbacks(new a());
    }

    public static void a(Context context) {
        a((Application) context.getApplicationContext());
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        eo a2;
        String packageName;
        String a3;
        int i;
        Intent intent = activity.getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("messageId");
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (!TextUtils.isEmpty(stringExtra) && intExtra > 0 && !this.a.contains(stringExtra)) {
                this.a.add(stringExtra);
                if (intExtra == 3000) {
                    a2 = eo.a(activity.getApplicationContext());
                    packageName = activity.getPackageName();
                    a3 = en.m443a(intExtra);
                    i = 3008;
                } else if (intExtra == 1000) {
                    a2 = eo.a(activity.getApplicationContext());
                    packageName = activity.getPackageName();
                    a3 = en.m443a(intExtra);
                    i = 1008;
                } else {
                    return;
                }
                a2.a(packageName, a3, stringExtra, i, null);
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
