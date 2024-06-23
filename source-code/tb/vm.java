package tb;

import android.app.Activity;
import com.alibaba.ut.IWebView;
import com.alibaba.ut.comm.ActivityLifecycleCB;
import com.alibaba.ut.comm.JsBridge;
import com.ut.mini.UTAnalytics;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
public class vm implements ActivityLifecycleCB.ActivityPausedCallBack, ActivityLifecycleCB.ActivityResumedCallBack {
    private Set<Integer> a = new HashSet();

    public void a() {
        ActivityLifecycleCB.d().c(this);
        ActivityLifecycleCB.d().b(this);
    }

    @Override // com.alibaba.ut.comm.ActivityLifecycleCB.ActivityPausedCallBack
    public void onActivityPaused(Activity activity) {
        q91.d(null, "activity", activity);
        IWebView a2 = hw2.a(activity);
        if (a2 != null && !this.a.contains(Integer.valueOf(a2.getDelegateHashCode()))) {
            UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(activity);
            JsBridge.g(a2, "Aplus4UT.onPageHide", null);
        }
    }

    @Override // com.alibaba.ut.comm.ActivityLifecycleCB.ActivityResumedCallBack
    public void onActivityResumed(Activity activity) {
        q91.d(null, "activity", activity);
        IWebView a2 = hw2.a(activity);
        if (a2 != null && !this.a.contains(Integer.valueOf(a2.getDelegateHashCode()))) {
            JsBridge.g(a2, "Aplus4UT.onPageShow", null);
        }
    }
}
