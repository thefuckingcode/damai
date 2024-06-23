package com.alibaba.ut.comm;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import tb.q91;

/* compiled from: Taobao */
public class ActivityLifecycleCB {
    public static ActivityLifecycleCB d = new ActivityLifecycleCB();
    public ArrayList<ActivityResumedCallBack> a = new ArrayList<>();
    public ArrayList<ActivityPausedCallBack> b = new ArrayList<>();
    public ArrayList<ActivityDestroyCallBack> c = new ArrayList<>();

    /* compiled from: Taobao */
    public interface ActivityDestroyCallBack {
        void onActivityDestroyed(Activity activity);
    }

    /* compiled from: Taobao */
    public interface ActivityPausedCallBack {
        void onActivityPaused(Activity activity);
    }

    /* compiled from: Taobao */
    public interface ActivityResumedCallBack {
        void onActivityResumed(Activity activity);
    }

    /* compiled from: Taobao */
    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            Iterator<ActivityDestroyCallBack> it = ActivityLifecycleCB.this.c.iterator();
            while (it.hasNext()) {
                it.next().onActivityDestroyed(activity);
            }
        }

        public void onActivityPaused(Activity activity) {
            q91.e(null, "activity", activity);
            Iterator<ActivityPausedCallBack> it = ActivityLifecycleCB.this.b.iterator();
            while (it.hasNext()) {
                it.next().onActivityPaused(activity);
            }
        }

        public void onActivityResumed(Activity activity) {
            q91.e(null, "activity", activity);
            Iterator<ActivityResumedCallBack> it = ActivityLifecycleCB.this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityResumed(activity);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static ActivityLifecycleCB d() {
        return d;
    }

    public void a(ActivityDestroyCallBack activityDestroyCallBack) {
        if (!this.c.contains(activityDestroyCallBack)) {
            this.c.add(activityDestroyCallBack);
        }
    }

    public void b(ActivityPausedCallBack activityPausedCallBack) {
        if (!this.b.contains(activityPausedCallBack)) {
            this.b.add(activityPausedCallBack);
        }
    }

    public void c(ActivityResumedCallBack activityResumedCallBack) {
        if (!this.a.contains(activityResumedCallBack)) {
            this.a.add(activityResumedCallBack);
        }
    }

    public void e(Application application) {
        application.registerActivityLifecycleCallbacks(new a());
    }
}
