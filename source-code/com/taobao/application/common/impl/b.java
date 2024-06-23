package com.taobao.application.common.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* access modifiers changed from: package-private */
@TargetApi(14)
/* compiled from: Taobao */
public class b implements Application.ActivityLifecycleCallbacks, ICallbackGroup<Application.ActivityLifecycleCallbacks> {
    private final ArrayList<Application.ActivityLifecycleCallbacks> a = new ArrayList<>();

    b() {
    }

    /* renamed from: a */
    public void addCallback(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null) {
            synchronized (this.a) {
                if (!this.a.contains(activityLifecycleCallbacks)) {
                    this.a.add(activityLifecycleCallbacks);
                }
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: b */
    public void removeCallback(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null) {
            synchronized (this.a) {
                this.a.remove(activityLifecycleCallbacks);
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.a) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityCreated(activity, bundle);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        synchronized (this.a) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityDestroyed(activity);
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        synchronized (this.a) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityPaused(activity);
            }
        }
    }

    public void onActivityResumed(Activity activity) {
        synchronized (this.a) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityResumed(activity);
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.a) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        synchronized (this.a) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityStarted(activity);
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        synchronized (this.a) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityStopped(activity);
            }
        }
    }
}
