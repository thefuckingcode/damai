package tb;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.taobao.phenix.compat.stat.NavigationInfoObtainer;

/* compiled from: Taobao */
public class bh1 implements Application.ActivityLifecycleCallbacks, NavigationInfoObtainer {
    private static final bh1 c = new bh1();
    private String a;
    private String b;

    public static bh1 a() {
        return c;
    }

    @Override // com.taobao.phenix.compat.stat.NavigationInfoObtainer
    public String getCurrentUrl() {
        return this.b;
    }

    @Override // com.taobao.phenix.compat.stat.NavigationInfoObtainer
    public String getCurrentWindowName() {
        return this.a;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (activity != null) {
            this.a = activity.getLocalClassName();
            Intent intent = activity.getIntent();
            if (intent != null) {
                this.b = intent.getDataString();
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
