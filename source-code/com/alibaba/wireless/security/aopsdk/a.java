package com.alibaba.wireless.security.aopsdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: ActivityListener */
public class a implements Application.ActivityLifecycleCallbacks {
    private static final String c = "ActivityListener";
    public static String d;
    private int a;
    private boolean b;

    public boolean a(Context context, Activity activity) {
        try {
            return d.a(context, activity);
        } catch (Throwable th) {
            return this.a > 0;
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity != null) {
            com.alibaba.wireless.security.aopsdk.i.a.b(c, "onActivityCreated " + activity.getClass().getName());
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (activity != null) {
            com.alibaba.wireless.security.aopsdk.i.a.b(c, "onActivityResumed " + activity.getClass().getName());
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityPaused(Activity activity) {
        if (activity != null) {
            com.alibaba.wireless.security.aopsdk.i.a.b(c, "onActivityPaused " + activity.getClass().getName());
            int i = this.a - 1;
            this.a = i;
            this.b = false;
            if (i <= 0) {
                this.a = 0;
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        if (activity != null) {
            this.a++;
            Intent intent = activity.getIntent();
            String str = null;
            if (intent != null) {
                str = intent.getDataString();
            }
            if (str == null) {
                str = "null";
            }
            com.alibaba.wireless.security.aopsdk.h.a.b(str);
            com.alibaba.wireless.security.aopsdk.h.a.a(activity.getClass().getName());
            if (!this.b) {
                this.b = true;
                com.alibaba.wireless.security.aopsdk.h.a.a(true);
            }
            com.alibaba.wireless.security.aopsdk.i.a.b(c, "onActivityStarted " + activity.getClass().getName() + "; StartCount=" + this.a + "; foreground=" + this.b);
        }
    }

    public void onActivityStopped(Activity activity) {
        if (activity != null) {
            if (!d.d() || !a(activity, activity)) {
                com.alibaba.wireless.security.aopsdk.h.a.a(false);
                com.alibaba.wireless.security.aopsdk.h.a.a((String) null);
                com.alibaba.wireless.security.aopsdk.h.a.b((String) null);
                this.b = false;
            } else {
                this.b = true;
                com.alibaba.wireless.security.aopsdk.i.a.b(c, "Reflect foreground detected");
            }
            com.alibaba.wireless.security.aopsdk.i.a.b(c, "onActivityStopped " + activity.getClass().getName() + "; StartCount=" + this.a + "; foreground=" + this.b);
        }
    }
}
