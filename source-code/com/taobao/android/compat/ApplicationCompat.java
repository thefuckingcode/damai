package com.taobao.android.compat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: Taobao */
public class ApplicationCompat extends Application {
    private final ArrayList<ActivityLifecycleCallbacksCompat> mActivityLifecycleCallbacks = new ArrayList<>();

    /* compiled from: Taobao */
    public static class AbstractActivityLifecycleCallbacks implements ActivityLifecycleCallbacksCompat {
        @Override // com.taobao.android.compat.ApplicationCompat.ActivityLifecycleCallbacksCompat
        public void onActivityCreated(Activity activity, @Nullable Bundle bundle) {
        }

        @Override // com.taobao.android.compat.ApplicationCompat.ActivityLifecycleCallbacksCompat
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // com.taobao.android.compat.ApplicationCompat.ActivityLifecycleCallbacksCompat
        public void onActivityPaused(Activity activity) {
        }

        @Override // com.taobao.android.compat.ApplicationCompat.ActivityLifecycleCallbacksCompat
        public void onActivityResumed(Activity activity) {
        }

        @Override // com.taobao.android.compat.ApplicationCompat.ActivityLifecycleCallbacksCompat
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // com.taobao.android.compat.ApplicationCompat.ActivityLifecycleCallbacksCompat
        public void onActivityStarted(Activity activity) {
        }

        @Override // com.taobao.android.compat.ApplicationCompat.ActivityLifecycleCallbacksCompat
        public void onActivityStopped(Activity activity) {
        }
    }

    /* compiled from: Taobao */
    public interface ActivityLifecycleCallbacksCompat {
        void onActivityCreated(Activity activity, @Nullable Bundle bundle);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivitySaveInstanceState(Activity activity, Bundle bundle);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);
    }

    @Nullable
    private ActivityLifecycleCallbacksCompat[] collectActivityLifecycleCallbacks() {
        ActivityLifecycleCallbacksCompat[] activityLifecycleCallbacksCompatArr;
        synchronized (this.mActivityLifecycleCallbacks) {
            if (this.mActivityLifecycleCallbacks.size() > 0) {
                ArrayList<ActivityLifecycleCallbacksCompat> arrayList = this.mActivityLifecycleCallbacks;
                activityLifecycleCallbacksCompatArr = (ActivityLifecycleCallbacksCompat[]) arrayList.toArray(new ActivityLifecycleCallbacksCompat[arrayList.size()]);
            } else {
                activityLifecycleCallbacksCompatArr = null;
            }
        }
        return activityLifecycleCallbacksCompatArr;
    }

    /* access modifiers changed from: package-private */
    public void dispatchActivityCreatedCompat(Activity activity, @Nullable Bundle bundle) {
        ActivityLifecycleCallbacksCompat[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ActivityLifecycleCallbacksCompat activityLifecycleCallbacksCompat : collectActivityLifecycleCallbacks) {
                activityLifecycleCallbacksCompat.onActivityCreated(activity, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchActivityDestroyedCompat(Activity activity) {
        ActivityLifecycleCallbacksCompat[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ActivityLifecycleCallbacksCompat activityLifecycleCallbacksCompat : collectActivityLifecycleCallbacks) {
                activityLifecycleCallbacksCompat.onActivityDestroyed(activity);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchActivityPausedCompat(Activity activity) {
        ActivityLifecycleCallbacksCompat[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ActivityLifecycleCallbacksCompat activityLifecycleCallbacksCompat : collectActivityLifecycleCallbacks) {
                activityLifecycleCallbacksCompat.onActivityPaused(activity);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchActivityResumedCompat(Activity activity) {
        ActivityLifecycleCallbacksCompat[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ActivityLifecycleCallbacksCompat activityLifecycleCallbacksCompat : collectActivityLifecycleCallbacks) {
                activityLifecycleCallbacksCompat.onActivityResumed(activity);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchActivitySaveInstanceStateCompat(Activity activity, Bundle bundle) {
        ActivityLifecycleCallbacksCompat[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ActivityLifecycleCallbacksCompat activityLifecycleCallbacksCompat : collectActivityLifecycleCallbacks) {
                activityLifecycleCallbacksCompat.onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchActivityStartedCompat(Activity activity) {
        ActivityLifecycleCallbacksCompat[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ActivityLifecycleCallbacksCompat activityLifecycleCallbacksCompat : collectActivityLifecycleCallbacks) {
                activityLifecycleCallbacksCompat.onActivityStarted(activity);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchActivityStoppedCompat(Activity activity) {
        ActivityLifecycleCallbacksCompat[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ActivityLifecycleCallbacksCompat activityLifecycleCallbacksCompat : collectActivityLifecycleCallbacks) {
                activityLifecycleCallbacksCompat.onActivityStopped(activity);
            }
        }
    }

    @TargetApi(14)
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacksCompat activityLifecycleCallbacksCompat) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.registerActivityLifecycleCallbacks(new a(activityLifecycleCallbacksCompat));
            return;
        }
        synchronized (this.mActivityLifecycleCallbacks) {
            this.mActivityLifecycleCallbacks.add(activityLifecycleCallbacksCompat);
        }
    }

    @TargetApi(14)
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacksCompat activityLifecycleCallbacksCompat) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.unregisterActivityLifecycleCallbacks(new a(activityLifecycleCallbacksCompat));
            return;
        }
        synchronized (this.mActivityLifecycleCallbacks) {
            this.mActivityLifecycleCallbacks.remove(activityLifecycleCallbacksCompat);
        }
    }
}
