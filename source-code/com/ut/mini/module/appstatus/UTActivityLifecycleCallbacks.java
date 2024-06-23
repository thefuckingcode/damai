package com.ut.mini.module.appstatus;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: Taobao */
public class UTActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private static UTActivityLifecycleCallbacks mInstance;

    private UTActivityLifecycleCallbacks() {
    }

    public static UTActivityLifecycleCallbacks getInstance() {
        if (mInstance == null) {
            synchronized (UTActivityLifecycleCallbacks.class) {
                if (mInstance == null) {
                    mInstance = new UTActivityLifecycleCallbacks();
                }
            }
        }
        return mInstance;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        UTAppStatusMonitor.getInstance().onActivityCreated(activity, bundle);
    }

    public void onActivityDestroyed(Activity activity) {
        UTAppStatusMonitor.getInstance().onActivityDestroyed(activity);
    }

    public void onActivityPaused(Activity activity) {
        UTAppStatusMonitor.getInstance().onActivityPaused(activity);
    }

    public void onActivityResumed(Activity activity) {
        UTAppStatusMonitor.getInstance().onActivityResumed(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        UTAppStatusMonitor.getInstance().onActivitySaveInstanceState(activity, bundle);
    }

    public void onActivityStarted(Activity activity) {
        UTAppStatusMonitor.getInstance().onActivityStarted(activity);
    }

    public void onActivityStopped(Activity activity) {
        UTAppStatusMonitor.getInstance().onActivityStopped(activity);
    }
}
