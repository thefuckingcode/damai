package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
class LifecycleDispatcher {
    private static AtomicBoolean sInitialized = new AtomicBoolean(false);

    @VisibleForTesting
    /* compiled from: Taobao */
    static class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        DispatcherActivityCallback() {
        }

        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            ReportFragment.injectIfNeededIn(activity);
        }

        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    private LifecycleDispatcher() {
    }

    static void init(Context context) {
        if (!sInitialized.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
        }
    }
}
