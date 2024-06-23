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
public class f3 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static f3 d;
    private Application.ActivityLifecycleCallbacks a;
    private Application b;
    private HashMap<Integer, WeakReference<d3>> c = new HashMap<>();

    /* compiled from: Taobao */
    public class a implements Application.ActivityLifecycleCallbacks {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2052554887")) {
                ipChange.ipc$dispatch("-2052554887", new Object[]{this, activity, bundle});
            }
        }

        public void onActivityDestroyed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1987924074")) {
                ipChange.ipc$dispatch("1987924074", new Object[]{this, activity});
            }
        }

        public void onActivityPaused(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1399997885")) {
                ipChange.ipc$dispatch("1399997885", new Object[]{this, activity});
                return;
            }
            f3.this.c(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED, activity, null);
        }

        public void onActivityResumed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "61759852")) {
                ipChange.ipc$dispatch("61759852", new Object[]{this, activity});
                return;
            }
            f3.this.c(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED, activity, null);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1023429744")) {
                ipChange.ipc$dispatch("-1023429744", new Object[]{this, activity, bundle});
            }
        }

        public void onActivityStarted(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-752496126")) {
                ipChange.ipc$dispatch("-752496126", new Object[]{this, activity});
            }
        }

        public void onActivityStopped(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-961327562")) {
                ipChange.ipc$dispatch("-961327562", new Object[]{this, activity});
            }
        }
    }

    private f3(Application application) {
        this.b = application;
        a aVar = new a();
        this.a = aVar;
        this.b.registerActivityLifecycleCallbacks(aVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(String str, Activity activity, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "448538424")) {
            ipChange.ipc$dispatch("448538424", new Object[]{this, str, activity, obj});
            return;
        }
        HashMap<Integer, WeakReference<d3>> hashMap = this.c;
        if (!(hashMap == null || hashMap.size() == 0)) {
            ArrayList<Integer> arrayList = null;
            for (Integer num : this.c.keySet()) {
                WeakReference<d3> weakReference = this.c.get(num);
                if (weakReference != null) {
                    d3 d3Var = weakReference.get();
                    if (d3Var == null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(num);
                    } else if (d3Var.a(activity)) {
                        str.hashCode();
                        if (str.equals(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED)) {
                            d3Var.onActivityPaused(activity);
                        } else if (str.equals(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED)) {
                            d3Var.onActivityResumed(activity);
                        }
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

    public static f3 d(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434009774")) {
            return (f3) ipChange.ipc$dispatch("434009774", new Object[]{application});
        }
        if (d == null) {
            synchronized (f3.class) {
                if (d == null) {
                    d = new f3(application);
                }
            }
        }
        return d;
    }

    public void b(d3 d3Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1954399263")) {
            ipChange.ipc$dispatch("-1954399263", new Object[]{this, d3Var});
        } else if (d3Var != null) {
            this.c.put(Integer.valueOf(d3Var.hashCode()), new WeakReference<>(d3Var));
        }
    }

    public void e(d3 d3Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1533434178")) {
            ipChange.ipc$dispatch("1533434178", new Object[]{this, d3Var});
        } else if (d3Var != null) {
            this.c.remove(Integer.valueOf(d3Var.hashCode()));
        }
    }
}
