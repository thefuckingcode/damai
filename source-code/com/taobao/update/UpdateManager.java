package com.taobao.update;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import com.taobao.update.framework.UpdateRuntime;
import java.util.List;
import tb.hs2;
import tb.ns2;
import tb.ul;

/* compiled from: Taobao */
public class UpdateManager {
    private static UpdateManager f;
    private Application a;
    private ActivityManager b;
    private volatile UpdateSDK c;
    private Application.ActivityLifecycleCallbacks d = new a();
    private ComponentCallbacks2 e = new b();

    /* compiled from: Taobao */
    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            UpdateManager.this.a.unregisterActivityLifecycleCallbacks(this);
            UpdateManager.this.onForeground();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    /* compiled from: Taobao */
    class b implements ComponentCallbacks2 {
        b() {
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        @TargetApi(14)
        public void onTrimMemory(int i) {
            if (i == 20) {
                UpdateManager updateManager = UpdateManager.this;
                if (updateManager.f(updateManager.a) != null) {
                    UpdateManager updateManager2 = UpdateManager.this;
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = updateManager2.f(updateManager2.a).getRunningAppProcesses();
                    if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(0);
                        if (runningAppProcessInfo.uid == UpdateManager.this.a.getApplicationInfo().uid && runningAppProcessInfo.importance == 100) {
                            return;
                        }
                    }
                    UpdateManager.this.a.registerActivityLifecycleCallbacks(UpdateManager.this.d);
                    UpdateManager.this.onBackground();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ActivityManager f(Application application) {
        try {
            if (this.b == null) {
                this.b = (ActivityManager) application.getSystemService("activity");
            }
        } catch (Throwable unused) {
        }
        return this.b;
    }

    public static UpdateManager getInstance() {
        if (f == null) {
            synchronized (UpdateManager.class) {
                if (f == null) {
                    f = new UpdateManager();
                }
            }
        }
        return f;
    }

    public void init(final ul ulVar, boolean z) {
        Application application;
        if (ulVar == null || (application = ulVar.application) == null) {
            Log.d("update-sdk", "initialize app config is null || application == null!");
            return;
        }
        this.a = application;
        String processName = ns2.getProcessName(application);
        UpdateRuntime.processName = processName;
        if (processName.equals(ulVar.application.getPackageName())) {
            Log.d("update-sdk", "initialize app in process " + UpdateRuntime.processName);
            UpdateRuntime.init(this.a, ulVar);
            UpdateRuntime.execute(new Runnable() {
                /* class com.taobao.update.UpdateManager.AnonymousClass3 */

                public void run() {
                    hs2 enableMonitor = new hs2(ulVar).enableApkUpdate().enableMonitor(null);
                    if (ulVar.autoStart) {
                        enableMonitor.enableCheckUpdateOnStartup();
                    }
                    UpdateManager.this.c = new UpdateSDK(enableMonitor);
                    UpdateManager.this.c.init(enableMonitor);
                }
            });
            if (z) {
                ulVar.application.registerComponentCallbacks(this.e);
            }
        }
    }

    public void onBackground() {
        if (this.c != null) {
            this.c.onBackground();
        }
    }

    public void onExit() {
        if (this.c != null) {
            this.c.onExit();
        }
    }

    public void onForeground() {
        if (this.c != null) {
            this.c.onForeground();
        }
    }
}
