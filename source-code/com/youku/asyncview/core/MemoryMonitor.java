package com.youku.asyncview.core;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

/* compiled from: Taobao */
public class MemoryMonitor {
    private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        /* class com.youku.asyncview.core.MemoryMonitor.AnonymousClass2 */

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
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
            if (MemoryMonitor.this.mMemStateListener != null && MemoryMonitor.this.isLowMem()) {
                MemoryMonitor.this.mMemStateListener.onLowMemory();
            }
        }
    };
    private ComponentCallbacks mComponentCallbacks = new ComponentCallbacks() {
        /* class com.youku.asyncview.core.MemoryMonitor.AnonymousClass1 */

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
            if (MemoryMonitor.this.mMemStateListener != null) {
                MemoryMonitor.this.mMemStateListener.onLowMemory();
            }
        }
    };
    private Context mContext;
    private final long mDalvikMax = ((long) (((double) (Runtime.getRuntime().maxMemory() >> 20)) * 0.8d));
    private MemoryStateListener mMemStateListener;

    public MemoryMonitor(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isLowMem() {
        return ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) >> 20) > this.mDalvikMax;
    }

    public void setMemoryStateListener(MemoryStateListener memoryStateListener) {
        this.mMemStateListener = memoryStateListener;
    }

    public void start() {
        this.mContext.getApplicationContext().registerComponentCallbacks(this.mComponentCallbacks);
        ((Application) this.mContext.getApplicationContext()).registerActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
    }

    public void stop() {
        this.mContext.getApplicationContext().unregisterComponentCallbacks(this.mComponentCallbacks);
        ((Application) this.mContext.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
    }
}
