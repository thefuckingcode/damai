package tb;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class e3 implements Application.ActivityLifecycleCallbacks {
    private static transient /* synthetic */ IpChange $ipChange;

    public abstract boolean a(Activity activity);

    public void onActivityCreated(Activity activity, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "323003019")) {
            ipChange.ipc$dispatch("323003019", new Object[]{this, activity, bundle});
        }
    }

    public void onActivityDestroyed(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "596811544")) {
            ipChange.ipc$dispatch("596811544", new Object[]{this, activity});
        }
    }

    public void onActivityPaused(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428268081")) {
            ipChange.ipc$dispatch("-428268081", new Object[]{this, activity});
        }
    }

    public void onActivityResumed(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-779910246")) {
            ipChange.ipc$dispatch("-779910246", new Object[]{this, activity});
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-283334622")) {
            ipChange.ipc$dispatch("-283334622", new Object[]{this, activity, bundle});
        }
    }

    public void onActivityStarted(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1594166224")) {
            ipChange.ipc$dispatch("-1594166224", new Object[]{this, activity});
        }
    }

    public void onActivityStopped(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1802997660")) {
            ipChange.ipc$dispatch("-1802997660", new Object[]{this, activity});
        }
    }
}
