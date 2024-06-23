package com.taobao.monitor;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.taobao.application.common.a;
import com.taobao.monitor.impl.common.Constants;
import com.taobao.monitor.impl.common.ThreadSwitcher;
import com.taobao.monitor.impl.data.lifecycle.ActivityLifecycle;
import com.taobao.monitor.impl.processor.launcher.LauncherProcessor;
import com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher;
import com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher;
import com.taobao.monitor.impl.trace.ApplicationGCDispatcher;
import com.taobao.monitor.impl.trace.ApplicationLowMemoryDispatcher;
import com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher;
import com.taobao.monitor.impl.trace.FPSDispatcher;
import com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher;
import com.taobao.monitor.impl.trace.ImageStageDispatcher;
import com.taobao.monitor.impl.trace.NetworkStageDispatcher;
import com.taobao.monitor.impl.trace.PageLeaveDispatcher;
import com.taobao.monitor.impl.trace.RenderDispatcher;
import com.taobao.monitor.impl.trace.WindowEventDispatcher;
import com.taobao.monitor.network.UploadStorage;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import tb.a0;
import tb.a70;
import tb.aq1;
import tb.b0;
import tb.bt1;
import tb.dm2;
import tb.e90;
import tb.iz2;
import tb.lc0;
import tb.o61;
import tb.qs0;
import tb.sf1;
import tb.sw2;
import tb.t32;
import tb.u6;
import tb.uh1;
import tb.un1;
import tb.us1;
import tb.vh1;
import tb.vn1;
import tb.ws0;
import tb.xn1;
import tb.xs1;
import tb.zp1;

/* compiled from: Taobao */
public class APMLauncher {
    private static boolean a;
    static List<Observer> b = new ArrayList();
    private static final u6 c = new u6();

    private static void f() {
        qs0.e().d().post(new Runnable() {
            /* class com.taobao.monitor.APMLauncher.AnonymousClass3 */

            public void run() {
                APMLauncher.m();
                APMLauncher.i();
                APMLauncher.p();
                APMLauncher.o();
            }
        });
    }

    public static void g(Application application, Map<String, Object> map) {
        if (!a) {
            a = true;
            n(application, map);
            k();
            h();
            f();
            b.add(l(application));
            j(b);
            a.a();
        }
    }

    private static void h() {
        e90.a(b0.APPLICATION_LOW_MEMORY_DISPATCHER, new ApplicationLowMemoryDispatcher());
        e90.a(b0.APPLICATION_GC_DISPATCHER, new ApplicationGCDispatcher());
        e90.a(b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER, new ApplicationBackgroundChangedDispatcher());
        FPSDispatcher fPSDispatcher = new FPSDispatcher();
        e90.a(b0.ACTIVITY_FPS_DISPATCHER, fPSDispatcher);
        ThreadSwitcher.a().e(fPSDispatcher);
        e90.a(b0.WINDOW_EVENT_DISPATCHER, new WindowEventDispatcher());
        e90.a(b0.PAGE_RENDER_DISPATCHER, new RenderDispatcher());
        e90.a(b0.PAGE_LEAVE_DISPATCHER, new PageLeaveDispatcher());
        ActivityLifeCycleDispatcher activityLifeCycleDispatcher = new ActivityLifeCycleDispatcher();
        activityLifeCycleDispatcher.addListener(new o61());
        e90.a(b0.ACTIVITY_LIFECYCLE_DISPATCHER, activityLifeCycleDispatcher);
        e90.a(b0.FRAGMENT_LIFECYCLE_DISPATCHER, new FragmentLifecycleDispatcher());
        e90.a(b0.FRAGMENT_LIFECYCLE_FUNCTION_DISPATCHER, new com.taobao.monitor.impl.trace.a());
        CustomPageLifecycleDispatcher customPageLifecycleDispatcher = new CustomPageLifecycleDispatcher();
        customPageLifecycleDispatcher.addListener(new xn1());
        customPageLifecycleDispatcher.addListener(new sw2());
        e90.a(b0.CUSTOM_PAGE_LIFECYCLE_DISPATCHER, customPageLifecycleDispatcher);
        e90.a(b0.IMAGE_STAGE_DISPATCHER, new ImageStageDispatcher());
        aq1.b().a(new zp1());
        e90.a(b0.NETWORK_STAGE_DISPATCHER, new NetworkStageDispatcher());
        vh1.a().c(new uh1());
        sf1.a().c(new uh1());
    }

    /* access modifiers changed from: private */
    public static void i() {
    }

    private static void j(final List<Observer> list) {
        if (Build.VERSION.SDK_INT <= 28) {
            q(new Runnable() {
                /* class com.taobao.monitor.APMLauncher.AnonymousClass2 */

                public void run() {
                    com.taobao.monitor.impl.common.a.a(list);
                }
            });
        }
    }

    private static void k() {
        qs0.e().d().postDelayed(new Runnable() {
            /* class com.taobao.monitor.APMLauncher.AnonymousClass1 */

            /* renamed from: com.taobao.monitor.APMLauncher$1$a */
            /* compiled from: Taobao */
            class a implements MessageQueue.IdleHandler {
                a(AnonymousClass1 r1) {
                }

                public boolean queueIdle() {
                    if (ws0.f != 0) {
                        return false;
                    }
                    LauncherProcessor.S = LauncherProcessor.WARM;
                    LauncherProcessor.T = true;
                    APMLauncher.c.d(LauncherProcessor.WARM);
                    return false;
                }
            }

            public void run() {
                Looper.getMainLooper();
                Looper.myQueue().addIdleHandler(new a(this));
            }
        }, 3000);
    }

    private static Observer l(Application application) {
        ActivityLifecycle activityLifecycle = new ActivityLifecycle(application);
        application.registerActivityLifecycleCallbacks(activityLifecycle);
        return activityLifecycle;
    }

    /* access modifiers changed from: private */
    public static void m() {
        ws0.l = System.getProperty("oppoCPUResource", "false");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d5  */
    private static void n(Application application, Map<String, Object> map) {
        String str;
        String string;
        boolean z;
        String string2;
        ws0.j = dm2.a();
        u6 u6Var = c;
        u6Var.d(LauncherProcessor.COLD);
        u6Var.e(SystemClock.uptimeMillis());
        u6Var.f(System.currentTimeMillis());
        if (map != null) {
            ws0.h = t32.b(map.get("appVersion"), "unknown");
            Object obj = map.get("deviceId");
            if (obj instanceof String) {
                String str2 = (String) obj;
                try {
                    str2 = URLEncoder.encode(str2, "UTF-8");
                } catch (Exception unused) {
                }
                str = "ALI_APM/" + str2 + "/monitor/procedure";
                ThreadSwitcher.a().f(us1.d().c());
                qs0.e().f(application).h(str);
                UploadStorage.a().d(str);
                boolean z2 = false;
                SharedPreferences sharedPreferences = qs0.e().a().getSharedPreferences(xs1.DEFAULT_SAVE_DIR, 0);
                string = sharedPreferences.getString("appVersion", "");
                SharedPreferences.Editor edit = sharedPreferences.edit();
                z = true;
                if (!TextUtils.isEmpty(string)) {
                    ws0.b = true;
                    ws0.d = true;
                    ws0.g = "NEW";
                    edit.putString("appVersion", ws0.h);
                } else {
                    ws0.b = false;
                    ws0.d = !string.equals(ws0.h);
                    ws0.g = "UPDATE";
                    if (ws0.d) {
                        edit.putString("appVersion", ws0.h);
                    }
                    string2 = sharedPreferences.getString(Constants.LAST_TOP_ACTIVITY, "");
                    ws0.e = string2;
                    if (!TextUtils.isEmpty(string2)) {
                        edit.putString(Constants.LAST_TOP_ACTIVITY, "");
                    } else {
                        z = z2;
                    }
                    if (z) {
                        edit.apply();
                    }
                    ws0.k = u6.a.a();
                    u6 u6Var2 = c;
                    u6Var2.a(ws0.d);
                    u6Var2.b(ws0.b);
                    u6Var2.c(ws0.k);
                    new a70().a(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL());
                    vn1.a().b(new un1());
                }
                z2 = true;
                string2 = sharedPreferences.getString(Constants.LAST_TOP_ACTIVITY, "");
                ws0.e = string2;
                if (!TextUtils.isEmpty(string2)) {
                }
                if (z) {
                }
                ws0.k = u6.a.a();
                u6 u6Var22 = c;
                u6Var22.a(ws0.d);
                u6Var22.b(ws0.b);
                u6Var22.c(ws0.k);
                new a70().a(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL());
                vn1.a().b(new un1());
            }
        }
        str = "ALI_APM/device-id/monitor/procedure";
        ThreadSwitcher.a().f(us1.d().c());
        qs0.e().f(application).h(str);
        UploadStorage.a().d(str);
        boolean z22 = false;
        SharedPreferences sharedPreferences2 = qs0.e().a().getSharedPreferences(xs1.DEFAULT_SAVE_DIR, 0);
        string = sharedPreferences2.getString("appVersion", "");
        SharedPreferences.Editor edit2 = sharedPreferences2.edit();
        z = true;
        if (!TextUtils.isEmpty(string)) {
        }
        z22 = true;
        string2 = sharedPreferences2.getString(Constants.LAST_TOP_ACTIVITY, "");
        ws0.e = string2;
        if (!TextUtils.isEmpty(string2)) {
        }
        if (z) {
        }
        ws0.k = u6.a.a();
        u6 u6Var222 = c;
        u6Var222.a(ws0.d);
        u6Var222.b(ws0.b);
        u6Var222.c(ws0.k);
        new a70().a(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL());
        vn1.a().b(new un1());
    }

    /* access modifiers changed from: private */
    public static void o() {
        if (Build.VERSION.SDK_INT >= 24) {
            ws0.i = (dm2.a() + Process.getStartUptimeMillis()) - SystemClock.uptimeMillis();
            c.h(System.currentTimeMillis() - (SystemClock.uptimeMillis() - ws0.i));
        } else {
            long a2 = bt1.a();
            c.h(a2);
            if (a2 != -1) {
                ws0.i = dm2.a() - (System.currentTimeMillis() - a2);
            } else {
                ws0.i = dm2.a() - Process.getElapsedCpuTime();
            }
        }
        c.g(ws0.i);
    }

    /* access modifiers changed from: private */
    public static void p() {
        if (lc0.f) {
            a0.a().b(new iz2());
        }
    }

    private static void q(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
