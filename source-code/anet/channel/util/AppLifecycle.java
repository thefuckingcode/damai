package anet.channel.util;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import anet.channel.thread.ThreadPoolExecutorFactory;
import com.taobao.android.tlog.protocol.model.joint.point.ForegroundJointPoint;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.h9;
import tb.ss0;

/* compiled from: Taobao */
public class AppLifecycle {
    private static CopyOnWriteArraySet<AppLifecycleListener> a = new CopyOnWriteArraySet<>();
    public static volatile long b = 0;
    public static volatile boolean c = false;
    private static Application.ActivityLifecycleCallbacks d = new a();
    private static ComponentCallbacks2 e = new b();

    /* compiled from: Taobao */
    public interface AppLifecycleListener {
        void background();

        void forground();
    }

    /* compiled from: Taobao */
    static class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (ss0.i()) {
                AppLifecycle.c = true;
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            AppLifecycle.e();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (ss0.i()) {
                AppLifecycle.c = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    /* compiled from: Taobao */
    static class b implements ComponentCallbacks2 {
        b() {
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            ALog.f("awcn.AppLifeCycle", "onTrimMemory", null, "level", Integer.valueOf(i));
            if (i == 20) {
                AppLifecycle.d();
            }
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 14 && h9.m()) {
            ((Application) ss0.c().getApplicationContext()).registerActivityLifecycleCallbacks(d);
            ss0.c().registerComponentCallbacks(e);
        }
    }

    private static void c(final boolean z) {
        ALog.f("awcn.AppLifeCycle", "notifyListener", null, ForegroundJointPoint.TYPE, Boolean.valueOf(z));
        ThreadPoolExecutorFactory.i(new Runnable() {
            /* class anet.channel.util.AppLifecycle.AnonymousClass1 */

            public void run() {
                Iterator it = AppLifecycle.a.iterator();
                while (it.hasNext()) {
                    AppLifecycleListener appLifecycleListener = (AppLifecycleListener) it.next();
                    try {
                        if (z) {
                            appLifecycleListener.forground();
                        } else {
                            appLifecycleListener.background();
                        }
                    } catch (Exception e) {
                        ALog.d("awcn.AppLifeCycle", "notifyListener exception.", null, e, new Object[0]);
                    }
                }
            }
        });
    }

    public static void d() {
        if (!ss0.i()) {
            ss0.k(true);
            b = System.currentTimeMillis();
            c(false);
        }
    }

    public static void e() {
        if (ss0.i()) {
            ss0.k(false);
            c = false;
            c(true);
        }
    }

    public static void f(AppLifecycleListener appLifecycleListener) {
        if (appLifecycleListener != null) {
            a.add(appLifecycleListener);
        }
    }

    public static void g(AppLifecycleListener appLifecycleListener) {
        a.remove(appLifecycleListener);
    }
}
