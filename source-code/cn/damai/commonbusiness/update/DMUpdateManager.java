package cn.damai.commonbusiness.update;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.update.UpdateSDK;
import com.taobao.update.framework.UpdateRuntime;
import java.util.List;
import tb.hs2;
import tb.ns2;
import tb.ul;

/* compiled from: Taobao */
public class DMUpdateManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static DMUpdateManager f;
    private Application a;
    private ActivityManager b;
    private volatile UpdateSDK c;
    private Application.ActivityLifecycleCallbacks d = new a();
    private ComponentCallbacks2 e = new b();

    /* compiled from: Taobao */
    public class a implements Application.ActivityLifecycleCallbacks {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-867187054")) {
                ipChange.ipc$dispatch("-867187054", new Object[]{this, activity, bundle});
            }
        }

        public void onActivityDestroyed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "726052913")) {
                ipChange.ipc$dispatch("726052913", new Object[]{this, activity});
            }
        }

        public void onActivityPaused(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1565043882")) {
                ipChange.ipc$dispatch("-1565043882", new Object[]{this, activity});
            }
        }

        public void onActivityResumed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1660221709")) {
                ipChange.ipc$dispatch("-1660221709", new Object[]{this, activity});
                return;
            }
            DMUpdateManager.this.a.unregisterActivityLifecycleCallbacks(this);
            DMUpdateManager.this.k();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "483372905")) {
                ipChange.ipc$dispatch("483372905", new Object[]{this, activity, bundle});
            }
        }

        public void onActivityStarted(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1820489609")) {
                ipChange.ipc$dispatch("1820489609", new Object[]{this, activity});
            }
        }

        public void onActivityStopped(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1611658173")) {
                ipChange.ipc$dispatch("1611658173", new Object[]{this, activity});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements ComponentCallbacks2 {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onConfigurationChanged(Configuration configuration) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-329946036")) {
                ipChange.ipc$dispatch("-329946036", new Object[]{this, configuration});
            }
        }

        public void onLowMemory() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "737108659")) {
                ipChange.ipc$dispatch("737108659", new Object[]{this});
            }
        }

        @TargetApi(14)
        public void onTrimMemory(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-100666236")) {
                ipChange.ipc$dispatch("-100666236", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 20) {
                DMUpdateManager dMUpdateManager = DMUpdateManager.this;
                if (dMUpdateManager.f(dMUpdateManager.a) != null) {
                    DMUpdateManager dMUpdateManager2 = DMUpdateManager.this;
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = dMUpdateManager2.f(dMUpdateManager2.a).getRunningAppProcesses();
                    if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(0);
                        if (runningAppProcessInfo.uid == DMUpdateManager.this.a.getApplicationInfo().uid && runningAppProcessInfo.importance == 100) {
                            return;
                        }
                    }
                    DMUpdateManager.this.a.registerActivityLifecycleCallbacks(DMUpdateManager.this.d);
                    DMUpdateManager.this.j();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ActivityManager f(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1348966517")) {
            return (ActivityManager) ipChange.ipc$dispatch("-1348966517", new Object[]{this, application});
        }
        try {
            if (this.b == null) {
                this.b = (ActivityManager) application.getSystemService("activity");
            }
        } catch (Throwable unused) {
        }
        return this.b;
    }

    public static DMUpdateManager g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1223020059")) {
            return (DMUpdateManager) ipChange.ipc$dispatch("1223020059", new Object[0]);
        }
        if (f == null) {
            synchronized (DMUpdateManager.class) {
                if (f == null) {
                    f = new DMUpdateManager();
                }
            }
        }
        return f;
    }

    public UpdateSDK h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "946516523")) {
            return this.c;
        }
        return (UpdateSDK) ipChange.ipc$dispatch("946516523", new Object[]{this});
    }

    public void i(final ul ulVar, boolean z) {
        Application application;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2119994505")) {
            ipChange.ipc$dispatch("-2119994505", new Object[]{this, ulVar, Boolean.valueOf(z)});
        } else if (ulVar == null || (application = ulVar.application) == null) {
            Log.d("update-sdk", "initialize app config is null || application == null!");
        } else {
            this.a = application;
            String processName = ns2.getProcessName(application);
            UpdateRuntime.processName = processName;
            if (processName.equals(ulVar.application.getPackageName())) {
                Log.d("update-sdk", "initialize app in process " + UpdateRuntime.processName);
                UpdateRuntime.init(this.a, ulVar);
                UpdateRuntime.execute(new Runnable() {
                    /* class cn.damai.commonbusiness.update.DMUpdateManager.AnonymousClass3 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1616871555")) {
                            ipChange.ipc$dispatch("-1616871555", new Object[]{this});
                            return;
                        }
                        hs2 enableMonitor = new hs2(ulVar).enableMonitor(null);
                        if (ulVar.autoStart) {
                            enableMonitor.enableCheckUpdateOnStartup();
                        }
                        DMUpdateManager.this.c = new UpdateSDK(enableMonitor);
                        DMUpdateManager.this.c.init(enableMonitor);
                    }
                });
                if (z) {
                    ulVar.application.registerComponentCallbacks(this.e);
                }
            }
        }
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "577757830")) {
            ipChange.ipc$dispatch("577757830", new Object[]{this});
        } else if (this.c != null) {
            this.c.onBackground();
        }
    }

    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1205918289")) {
            ipChange.ipc$dispatch("1205918289", new Object[]{this});
        } else if (this.c != null) {
            this.c.onForeground();
        }
    }
}
