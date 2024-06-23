package tb;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: Taobao */
public class h3 implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        j3.getInstance().pushToActivityStack(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        j3.getInstance().popFromActivityStack(activity);
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
}
