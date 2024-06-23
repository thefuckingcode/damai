package com.taobao.android.compat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import com.taobao.android.compat.ApplicationCompat;
import com.taobao.android.tlog.protocol.Constants;
import javax.annotation.Nullable;
import tb.u30;

@TargetApi(14)
/* compiled from: Taobao */
class a implements Application.ActivityLifecycleCallbacks {
    private final ApplicationCompat.ActivityLifecycleCallbacksCompat a;

    a(ApplicationCompat.ActivityLifecycleCallbacksCompat activityLifecycleCallbacksCompat) {
        this.a = activityLifecycleCallbacksCompat;
    }

    private static void a(ApplicationCompat.ActivityLifecycleCallbacksCompat activityLifecycleCallbacksCompat, Activity activity, Bundle bundle, String str) {
        long nanoTime = System.nanoTime();
        long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
        if (Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED.equals(str)) {
            activityLifecycleCallbacksCompat.onActivityCreated(activity, bundle);
        } else if (Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STARTED.equals(str)) {
            activityLifecycleCallbacksCompat.onActivityStarted(activity);
        } else if (Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED.equals(str)) {
            activityLifecycleCallbacksCompat.onActivityResumed(activity);
        } else if (Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED.equals(str)) {
            activityLifecycleCallbacksCompat.onActivityPaused(activity);
        } else if (Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STOPPED.equals(str)) {
            activityLifecycleCallbacksCompat.onActivityStopped(activity);
        } else if (Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED.equals(str)) {
            activityLifecycleCallbacksCompat.onActivityDestroyed(activity);
        } else if (Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_SAVEINSTANCESTATE.equals(str)) {
            activityLifecycleCallbacksCompat.onActivitySaveInstanceState(activity, bundle);
        }
        Log.i("Coord", "LifeTiming - " + activityLifecycleCallbacksCompat.getClass().getName() + " " + str + " " + ((Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000) + "ms (cpu) / " + ((System.nanoTime() - nanoTime) / 1000000) + "ms (real)");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return this.a.equals(((a) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void onActivityCreated(Activity activity, @Nullable Bundle bundle) {
        if (u30.b()) {
            a(this.a, activity, bundle, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED);
        } else {
            this.a.onActivityCreated(activity, bundle);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (u30.b()) {
            a(this.a, activity, null, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED);
        } else {
            this.a.onActivityDestroyed(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        if (u30.b()) {
            a(this.a, activity, null, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED);
        } else {
            this.a.onActivityPaused(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        if (u30.b()) {
            a(this.a, activity, null, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED);
        } else {
            this.a.onActivityResumed(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (u30.b()) {
            a(this.a, activity, bundle, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_SAVEINSTANCESTATE);
        } else {
            this.a.onActivitySaveInstanceState(activity, bundle);
        }
    }

    public void onActivityStarted(Activity activity) {
        if (u30.b()) {
            a(this.a, activity, null, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STARTED);
        } else {
            this.a.onActivityStarted(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        if (u30.b()) {
            a(this.a, activity, null, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STOPPED);
        } else {
            this.a.onActivityStopped(activity);
        }
    }
}
