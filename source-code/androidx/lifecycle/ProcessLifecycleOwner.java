package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;

/* compiled from: Taobao */
public class ProcessLifecycleOwner implements LifecycleOwner {
    @VisibleForTesting
    static final long TIMEOUT_MS = 700;
    private static final ProcessLifecycleOwner sInstance = new ProcessLifecycleOwner();
    private Runnable mDelayedPauseRunnable = new Runnable() {
        /* class androidx.lifecycle.ProcessLifecycleOwner.AnonymousClass1 */

        public void run() {
            ProcessLifecycleOwner.this.dispatchPauseIfNeeded();
            ProcessLifecycleOwner.this.dispatchStopIfNeeded();
        }
    };
    private Handler mHandler;
    ReportFragment.ActivityInitializationListener mInitializationListener = new ReportFragment.ActivityInitializationListener() {
        /* class androidx.lifecycle.ProcessLifecycleOwner.AnonymousClass2 */

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onCreate() {
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onResume() {
            ProcessLifecycleOwner.this.activityResumed();
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onStart() {
            ProcessLifecycleOwner.this.activityStarted();
        }
    };
    private boolean mPauseSent = true;
    private final LifecycleRegistry mRegistry = new LifecycleRegistry(this);
    private int mResumedCounter = 0;
    private int mStartedCounter = 0;
    private boolean mStopSent = true;

    private ProcessLifecycleOwner() {
    }

    @NonNull
    public static LifecycleOwner get() {
        return sInstance;
    }

    static void init(Context context) {
        sInstance.attach(context);
    }

    /* access modifiers changed from: package-private */
    public void activityPaused() {
        int i = this.mResumedCounter - 1;
        this.mResumedCounter = i;
        if (i == 0) {
            this.mHandler.postDelayed(this.mDelayedPauseRunnable, TIMEOUT_MS);
        }
    }

    /* access modifiers changed from: package-private */
    public void activityResumed() {
        int i = this.mResumedCounter + 1;
        this.mResumedCounter = i;
        if (i != 1) {
            return;
        }
        if (this.mPauseSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            this.mPauseSent = false;
            return;
        }
        this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
    }

    /* access modifiers changed from: package-private */
    public void activityStarted() {
        int i = this.mStartedCounter + 1;
        this.mStartedCounter = i;
        if (i == 1 && this.mStopSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
            this.mStopSent = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void activityStopped() {
        this.mStartedCounter--;
        dispatchStopIfNeeded();
    }

    /* access modifiers changed from: package-private */
    public void attach(Context context) {
        this.mHandler = new Handler();
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() {
            /* class androidx.lifecycle.ProcessLifecycleOwner.AnonymousClass3 */

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (Build.VERSION.SDK_INT < 29) {
                    ReportFragment.get(activity).setProcessListener(ProcessLifecycleOwner.this.mInitializationListener);
                }
            }

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ProcessLifecycleOwner.this.activityPaused();
            }

            public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                activity.registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() {
                    /* class androidx.lifecycle.ProcessLifecycleOwner.AnonymousClass3.AnonymousClass1 */

                    public void onActivityPostResumed(@NonNull Activity activity) {
                        ProcessLifecycleOwner.this.activityResumed();
                    }

                    public void onActivityPostStarted(@NonNull Activity activity) {
                        ProcessLifecycleOwner.this.activityStarted();
                    }
                });
            }

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ProcessLifecycleOwner.this.activityStopped();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void dispatchPauseIfNeeded() {
        if (this.mResumedCounter == 0) {
            this.mPauseSent = true;
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchStopIfNeeded() {
        if (this.mStartedCounter == 0 && this.mPauseSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            this.mStopSent = true;
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }
}
