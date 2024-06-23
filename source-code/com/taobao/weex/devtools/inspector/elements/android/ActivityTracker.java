package com.taobao.weex.devtools.inspector.elements.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import com.taobao.weex.devtools.common.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: Taobao */
public final class ActivityTracker {
    private static final ActivityTracker sInstance = new ActivityTracker();
    @GuardedBy("Looper.getMainLooper()")
    private final ArrayList<Activity> mActivities;
    private final List<Activity> mActivitiesUnmodifiable;
    @Nullable
    private AutomaticTracker mAutomaticTracker;
    private final List<Listener> mListeners = new CopyOnWriteArrayList();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static abstract class AutomaticTracker {

        /* access modifiers changed from: private */
        @TargetApi(14)
        /* compiled from: Taobao */
        public static class AutomaticTrackerICSAndBeyond extends AutomaticTracker {
            private final Application mApplication;
            private final Application.ActivityLifecycleCallbacks mLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
                /* class com.taobao.weex.devtools.inspector.elements.android.ActivityTracker.AutomaticTracker.AutomaticTrackerICSAndBeyond.AnonymousClass1 */

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    AutomaticTrackerICSAndBeyond.this.mTracker.add(activity);
                }

                public void onActivityDestroyed(Activity activity) {
                    AutomaticTrackerICSAndBeyond.this.mTracker.remove(activity);
                }

                public void onActivityPaused(Activity activity) {
                }

                public void onActivityResumed(Activity activity) {
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityStarted(Activity activity) {
                }

                public void onActivityStopped(Activity activity) {
                }
            };
            private final ActivityTracker mTracker;

            public AutomaticTrackerICSAndBeyond(Application application, ActivityTracker activityTracker) {
                super();
                this.mApplication = application;
                this.mTracker = activityTracker;
            }

            @Override // com.taobao.weex.devtools.inspector.elements.android.ActivityTracker.AutomaticTracker
            public void register() {
                this.mApplication.registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
            }

            @Override // com.taobao.weex.devtools.inspector.elements.android.ActivityTracker.AutomaticTracker
            public void unregister() {
                this.mApplication.unregisterActivityLifecycleCallbacks(this.mLifecycleCallbacks);
            }
        }

        private AutomaticTracker() {
        }

        @Nullable
        public static AutomaticTracker newInstanceIfPossible(Application application, ActivityTracker activityTracker) {
            if (Build.VERSION.SDK_INT >= 14) {
                return new AutomaticTrackerICSAndBeyond(application, activityTracker);
            }
            return null;
        }

        public abstract void register();

        public abstract void unregister();
    }

    /* compiled from: Taobao */
    public interface Listener {
        void onActivityAdded(Activity activity);

        void onActivityRemoved(Activity activity);
    }

    public ActivityTracker() {
        ArrayList<Activity> arrayList = new ArrayList<>();
        this.mActivities = arrayList;
        this.mActivitiesUnmodifiable = Collections.unmodifiableList(arrayList);
    }

    public static ActivityTracker get() {
        return sInstance;
    }

    public void add(Activity activity) {
        Util.throwIfNull(activity);
        Util.throwIfNot(Looper.myLooper() == Looper.getMainLooper());
        this.mActivities.add(activity);
        for (Listener listener : this.mListeners) {
            listener.onActivityAdded(activity);
        }
    }

    public boolean beginTrackingIfPossible(Application application) {
        AutomaticTracker newInstanceIfPossible;
        if (this.mAutomaticTracker != null || (newInstanceIfPossible = AutomaticTracker.newInstanceIfPossible(application, this)) == null) {
            return false;
        }
        newInstanceIfPossible.register();
        this.mAutomaticTracker = newInstanceIfPossible;
        return true;
    }

    public boolean endTracking() {
        AutomaticTracker automaticTracker = this.mAutomaticTracker;
        if (automaticTracker == null) {
            return false;
        }
        automaticTracker.unregister();
        this.mAutomaticTracker = null;
        return true;
    }

    public List<Activity> getActivitiesView() {
        return this.mActivitiesUnmodifiable;
    }

    public void registerListener(Listener listener) {
        this.mListeners.add(listener);
    }

    public void remove(Activity activity) {
        Util.throwIfNull(activity);
        Util.throwIfNot(Looper.myLooper() == Looper.getMainLooper());
        if (this.mActivities.remove(activity)) {
            for (Listener listener : this.mListeners) {
                listener.onActivityRemoved(activity);
            }
        }
    }

    public Activity tryGetTopActivity() {
        if (this.mActivitiesUnmodifiable.isEmpty()) {
            return null;
        }
        List<Activity> list = this.mActivitiesUnmodifiable;
        return list.get(list.size() - 1);
    }

    public void unregisterListener(Listener listener) {
        this.mListeners.remove(listener);
    }
}
