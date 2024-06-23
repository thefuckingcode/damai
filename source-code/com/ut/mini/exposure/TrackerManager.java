package com.ut.mini.exposure;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.Application;
import android.app.TabActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.ViewGroup;
import com.ut.mini.internal.ExposureViewHandle;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
public class TrackerManager {
    private static TrackerManager mInstance;
    public HashMap<String, String> commonInfoMap = new HashMap<>();
    private ActivityLifecycleForTracker mActivityLifecycle;
    private ExposureViewHandle mExposureViewHandle;
    private Handler mHandle;
    private Set<Class> mNeedToTrackActivitys = Collections.synchronizedSet(new HashSet());

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class ActivityLifecycleForTracker implements Application.ActivityLifecycleCallbacks {
        private ActivityLifecycleForTracker() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (activity != null && !(activity instanceof TabActivity) && !(activity instanceof ActivityGroup)) {
                if ("com.taobao.weex.WXActivity".equalsIgnoreCase(activity.getClass().getName()) || TrackerManager.this.mNeedToTrackActivitys.contains(activity.getClass())) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
                        if (viewGroup != null && (viewGroup.getChildAt(0) instanceof TrackerFrameLayout)) {
                            viewGroup.removeViewAt(0);
                        }
                    } catch (Exception e) {
                        ExpLogger.e(null, e, new Object[0]);
                    }
                }
            }
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            if (activity != null && !(activity instanceof TabActivity) && !(activity instanceof ActivityGroup)) {
                if (("com.taobao.weex.WXActivity".equalsIgnoreCase(activity.getClass().getName()) || TrackerManager.this.mNeedToTrackActivitys.contains(activity.getClass())) && ExposureConfigMgr.trackerExposureOpen) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
                        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
                            return;
                        }
                        if (viewGroup.getChildAt(0) instanceof TrackerFrameLayout) {
                            ExpLogger.d(null, "no attachTrackerFrameLayout ", activity.toString());
                            return;
                        }
                        TrackerFrameLayout trackerFrameLayout = new TrackerFrameLayout(activity);
                        while (viewGroup.getChildCount() > 0) {
                            View childAt = viewGroup.getChildAt(0);
                            viewGroup.removeViewAt(0);
                            trackerFrameLayout.addView(childAt, childAt.getLayoutParams());
                        }
                        viewGroup.addView(trackerFrameLayout, new ViewGroup.LayoutParams(-1, -1));
                    } catch (Exception e) {
                        ExpLogger.e(null, e, new Object[0]);
                    }
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

    private TrackerManager() {
        if (this.mHandle == null) {
            HandlerThread handlerThread = new HandlerThread("ut_exposure");
            handlerThread.start();
            this.mHandle = new Handler(handlerThread.getLooper());
        }
    }

    public static TrackerManager getInstance() {
        if (mInstance == null) {
            synchronized (TrackerManager.class) {
                if (mInstance == null) {
                    mInstance = new TrackerManager();
                }
            }
        }
        return mInstance;
    }

    public boolean addToTrack(Activity activity) {
        if (activity == null) {
            return false;
        }
        return this.mNeedToTrackActivitys.add(activity.getClass());
    }

    public void enableExposureLog(boolean z) {
        ExpLogger.enableLog = z;
    }

    public ExposureViewHandle getExposureViewHandle() {
        return this.mExposureViewHandle;
    }

    public Handler getThreadHandle() {
        return this.mHandle;
    }

    public void init(Application application) {
        if (ExposureConfigMgr.trackerExposureOpen) {
            ActivityLifecycleForTracker activityLifecycleForTracker = new ActivityLifecycleForTracker();
            this.mActivityLifecycle = activityLifecycleForTracker;
            application.registerActivityLifecycleCallbacks(activityLifecycleForTracker);
        }
        ExposureConfigMgr.init();
    }

    public void registerExposureViewHandler(ExposureViewHandle exposureViewHandle) {
        this.mExposureViewHandle = exposureViewHandle;
    }

    public boolean removeToTrack(Activity activity) {
        if (activity == null) {
            return false;
        }
        return this.mNeedToTrackActivitys.remove(activity.getClass());
    }

    public void setCommonInfoMap(HashMap<String, String> hashMap) {
        this.commonInfoMap.clear();
        this.commonInfoMap.putAll(hashMap);
    }

    public void unRegisterExposureViewHandler(ExposureViewHandle exposureViewHandle) {
        this.mExposureViewHandle = null;
    }

    public void unregisterActivityLifecycleCallbacks(Application application) {
        ActivityLifecycleForTracker activityLifecycleForTracker = this.mActivityLifecycle;
        if (activityLifecycleForTracker != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleForTracker);
        }
    }
}
