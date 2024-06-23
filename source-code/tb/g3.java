package tb;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.tlog.protocol.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
public class g3 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static g3 d;
    private Application.ActivityLifecycleCallbacks a;
    private Application b;
    private HashMap<Integer, WeakReference<e3>> c = new HashMap<>();

    /* compiled from: Taobao */
    public class a implements Application.ActivityLifecycleCallbacks {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1622492307")) {
                ipChange.ipc$dispatch("-1622492307", new Object[]{this, activity, bundle});
            }
        }

        public void onActivityDestroyed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1086431754")) {
                ipChange.ipc$dispatch("-1086431754", new Object[]{this, activity});
            }
        }

        public void onActivityPaused(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1173683279")) {
                ipChange.ipc$dispatch("-1173683279", new Object[]{this, activity});
                return;
            }
            g3.this.c(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED, activity, null);
        }

        public void onActivityResumed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1882022392")) {
                ipChange.ipc$dispatch("1882022392", new Object[]{this, activity});
                return;
            }
            g3.this.c(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED, activity, null);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1498320516")) {
                ipChange.ipc$dispatch("1498320516", new Object[]{this, activity, bundle});
            }
        }

        public void onActivityStarted(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1067766414")) {
                ipChange.ipc$dispatch("1067766414", new Object[]{this, activity});
            }
        }

        public void onActivityStopped(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "858934978")) {
                ipChange.ipc$dispatch("858934978", new Object[]{this, activity});
            }
        }
    }

    private g3(Application application) {
        this.b = application;
        a aVar = new a();
        this.a = aVar;
        this.b.registerActivityLifecycleCallbacks(aVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(String str, Activity activity, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1844878380")) {
            ipChange.ipc$dispatch("1844878380", new Object[]{this, str, activity, obj});
            return;
        }
        HashMap<Integer, WeakReference<e3>> hashMap = this.c;
        if (!(hashMap == null || hashMap.size() == 0)) {
            ArrayList<Integer> arrayList = null;
            for (Integer num : this.c.keySet()) {
                e3 e3Var = this.c.get(num).get();
                if (e3Var == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(num);
                } else if (e3Var.a(activity)) {
                    str.hashCode();
                    if (str.equals(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED)) {
                        e3Var.onActivityPaused(activity);
                    } else if (str.equals(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED)) {
                        e3Var.onActivityResumed(activity);
                    }
                }
            }
            if (arrayList != null) {
                for (Integer num2 : arrayList) {
                    this.c.remove(num2);
                }
            }
        }
    }

    public static g3 d(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1287229886")) {
            return (g3) ipChange.ipc$dispatch("1287229886", new Object[]{application});
        }
        if (d == null) {
            synchronized (g3.class) {
                if (d == null) {
                    d = new g3(application);
                }
            }
        }
        return d;
    }

    public void b(e3 e3Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1774634257")) {
            ipChange.ipc$dispatch("-1774634257", new Object[]{this, e3Var});
        } else if (e3Var != null) {
            this.c.put(Integer.valueOf(e3Var.hashCode()), new WeakReference<>(e3Var));
        }
    }

    public void e(e3 e3Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1529677142")) {
            ipChange.ipc$dispatch("1529677142", new Object[]{this, e3Var});
        } else if (e3Var != null) {
            this.c.remove(Integer.valueOf(e3Var.hashCode()));
        }
    }
}
