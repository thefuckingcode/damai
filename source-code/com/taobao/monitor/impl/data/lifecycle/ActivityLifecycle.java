package com.taobao.monitor.impl.data.lifecycle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.UiThread;
import androidx.fragment.app.FragmentActivity;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.monitor.impl.common.Constants;
import com.taobao.monitor.impl.data.fps.FPSCollector;
import com.taobao.monitor.impl.data.windowevent.a;
import com.taobao.monitor.impl.processor.launcher.LauncherProcessor;
import com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher;
import com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.procedure.IPage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;
import tb.b0;
import tb.b3;
import tb.dm2;
import tb.e90;
import tb.i20;
import tb.k3;
import tb.lc0;
import tb.qn1;
import tb.qs0;
import tb.u6;
import tb.us1;
import tb.ws0;
import tb.x32;
import tb.xb2;
import tb.xs1;

@TargetApi(14)
@UiThread
/* compiled from: Taobao */
public class ActivityLifecycle implements Application.ActivityLifecycleCallbacks, Observer {
    private static volatile boolean n;
    private static final List<String> o;
    private int a;
    private final Map<Activity, a> b = new HashMap();
    private final Map<Activity, xb2> c = new HashMap();
    private final Map<Activity, FPSCollector> d = new HashMap();
    private final Map<Activity, IPage> e = new HashMap();
    private WeakReference<Activity> f = new WeakReference<>(null);
    private final Context g;
    private ActivityLifeCycleDispatcher h = null;
    private final Application.ActivityLifecycleCallbacks i = com.taobao.application.common.impl.a.g().f();
    private final Application.ActivityLifecycleCallbacks j = com.taobao.application.common.impl.a.g().c();
    private final BackgroundForegroundEventImpl k = new BackgroundForegroundEventImpl();
    private int l = 0;
    private final b3 m;

    static {
        ArrayList arrayList = new ArrayList();
        o = arrayList;
        arrayList.add("com.taobao.tao.welcome.Welcome");
        arrayList.add("com.taobao.browser.BrowserActivity");
        arrayList.add("com.taobao.tao.TBMainActivity");
    }

    public ActivityLifecycle(Application application) {
        b3 b3Var = new b3();
        this.m = b3Var;
        b3Var.a(this.l);
        this.g = application;
        IDispatcher a2 = b0.a(b0.ACTIVITY_LIFECYCLE_DISPATCHER);
        if (a2 instanceof ActivityLifeCycleDispatcher) {
            this.h = (ActivityLifeCycleDispatcher) a2;
        }
    }

    private void b(final String str) {
        qs0.e().d().post(new Runnable() {
            /* class com.taobao.monitor.impl.data.lifecycle.ActivityLifecycle.AnonymousClass1 */

            public void run() {
                SharedPreferences.Editor edit = qs0.e().a().getSharedPreferences(xs1.DEFAULT_SAVE_DIR, 0).edit();
                edit.putString(Constants.LAST_TOP_ACTIVITY, str);
                edit.commit();
            }
        });
    }

    public boolean a(String str) {
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.g.getSystemService("activity")).getRunningTasks(10);
            if (runningTasks == null || runningTasks.size() <= 0) {
                return false;
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo.topActivity.getPackageName().equals(this.g.getPackageName()) && runningTaskInfo.topActivity.getClassName().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        b3 b3Var = this.m;
        int i2 = this.l + 1;
        this.l = i2;
        b3Var.a(i2);
        ws0.f++;
        String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
        IPage a2 = new qn1().l(lc0.a).f(lc0.b || x32.b(k3.b(activity))).b(activity).j(activity.getWindow()).d(replaceAll).a();
        this.e.put(activity, a2);
        a2.getPageLifecycleCallback().onPageCreate(k3.d(activity), k3.c(activity), k3.a(activity));
        if (!e90.c(this.h)) {
            this.h.f(activity, k3.a(activity), dm2.a());
        }
        if ((activity instanceof FragmentActivity) && (lc0.j || x32.b(k3.b(activity)))) {
            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentLifecycle(activity, replaceAll), true);
        }
        if (lc0.C && !this.b.containsKey(activity)) {
            this.b.put(activity, new a(activity).a());
        }
        i20.a("ActivityLifeCycle", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED, activity.getClass().getSimpleName());
        com.taobao.application.common.impl.a.g().i(activity);
        this.i.onActivityCreated(activity, bundle);
        this.j.onActivityCreated(activity, bundle);
    }

    public void onActivityDestroyed(Activity activity) {
        i20.a("ActivityLifeCycle", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED, activity.getClass().getSimpleName());
        IPage iPage = this.e.get(activity);
        if (iPage != null) {
            iPage.getPageLifecycleCallback().onPageDestroy();
            this.e.remove(activity);
            us1.PROCEDURE_MANAGER.p(iPage);
        }
        if (!e90.c(this.h)) {
            this.h.g(activity, dm2.a());
        }
        if (this.a == 0) {
            b("");
            com.taobao.application.common.impl.a.g().i(null);
        }
        if (lc0.C && this.b.containsKey(activity)) {
            this.b.get(activity).b();
            this.b.remove(activity);
        }
        this.i.onActivityDestroyed(activity);
        this.j.onActivityDestroyed(activity);
        b3 b3Var = this.m;
        int i2 = this.l - 1;
        this.l = i2;
        b3Var.a(i2);
    }

    public void onActivityPaused(Activity activity) {
        i20.a("ActivityLifeCycle", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED, activity.getClass().getSimpleName());
        if (!e90.c(this.h)) {
            this.h.h(activity, dm2.a());
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16 && this.c.containsKey(activity)) {
            this.c.get(activity).f();
            this.c.remove(activity);
        }
        if (lc0.B && i2 >= 16 && this.d.containsKey(activity)) {
            this.d.get(activity).c();
            this.c.remove(activity);
        }
        this.i.onActivityPaused(activity);
        this.j.onActivityPaused(activity);
    }

    public void onActivityResumed(Activity activity) {
        i20.a("ActivityLifeCycle", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED, activity.getClass().getSimpleName());
        String name = activity.getClass().getName();
        if (o.contains(name) && n && this.f.get() == null) {
            n = false;
            if (!a(name)) {
                this.f = new WeakReference<>(activity);
                activity.finish();
                return;
            }
        }
        IPage iPage = this.e.get(activity);
        if (iPage != null) {
            iPage.getPageLifecycleCallback().onPageAppear();
        }
        if (!e90.c(this.h)) {
            this.h.i(activity, dm2.a());
        }
        if ((lc0.b || lc0.f) && lc0.w && !lc0.B && !this.c.containsKey(activity) && Build.VERSION.SDK_INT >= 16) {
            this.c.put(activity, new xb2(activity, iPage));
        } else if (lc0.w && lc0.B && Build.VERSION.SDK_INT >= 16 && !this.c.containsKey(activity)) {
            this.d.put(activity, new FPSCollector(activity));
        }
        com.taobao.application.common.impl.a.g().i(activity);
        this.i.onActivityResumed(activity);
        this.j.onActivityResumed(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.i.onActivitySaveInstanceState(activity, bundle);
        this.j.onActivitySaveInstanceState(activity, bundle);
    }

    public void onActivityStarted(Activity activity) {
        i20.a("ActivityLifeCycle", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STARTED, activity.getClass().getSimpleName());
        int i2 = this.a + 1;
        this.a = i2;
        if (i2 == 1) {
            IDispatcher b2 = e90.b(b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER);
            if (b2 instanceof ApplicationBackgroundChangedDispatcher) {
                ((ApplicationBackgroundChangedDispatcher) b2).f(0, dm2.a());
            }
            i20.a("ActivityLifeCycle", "background2Foreground");
            this.k.d();
        }
        ws0.a = false;
        if (!e90.c(this.h)) {
            this.h.j(activity, dm2.a());
        }
        if (!lc0.C && !this.b.containsKey(activity)) {
            this.b.put(activity, new a(activity).a());
        }
        com.taobao.application.common.impl.a.g().i(activity);
        this.i.onActivityStarted(activity);
        this.j.onActivityStarted(activity);
    }

    public void onActivityStopped(Activity activity) {
        i20.a("ActivityLifeCycle", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STOPPED, activity.getClass().getSimpleName());
        if (!e90.c(this.h)) {
            this.h.k(activity, dm2.a());
        }
        if (!lc0.C && this.b.containsKey(activity)) {
            this.b.get(activity).b();
            this.b.remove(activity);
        }
        int i2 = this.a - 1;
        this.a = i2;
        if (i2 == 0) {
            ws0.a = true;
            us1.PROCEDURE_MANAGER.b();
            IDispatcher b2 = e90.b(b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER);
            if (b2 instanceof ApplicationBackgroundChangedDispatcher) {
                ((ApplicationBackgroundChangedDispatcher) b2).f(1, dm2.a());
            }
            i20.a("ActivityLifeCycle", "foreground2Background");
            ws0.p = "background";
            ws0.n = -1;
            this.k.e();
            b(k3.b(activity));
            new u6().d(LauncherProcessor.S);
        }
        this.i.onActivityStopped(activity);
        this.j.onActivityStopped(activity);
        IPage iPage = this.e.get(activity);
        if (iPage != null) {
            iPage.getPageLifecycleCallback().onPageDisappear();
        }
    }

    public void update(Observable observable, Object obj) {
        if (obj != null && (obj instanceof IllegalArgumentException) && ((IllegalArgumentException) obj).getMessage().contains("ActivityRecord not found")) {
            n = true;
        }
    }
}
