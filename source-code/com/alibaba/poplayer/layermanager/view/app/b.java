package com.alibaba.poplayer.layermanager.view.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Window;
import com.alibaba.poplayer.PopLayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import tb.cr1;
import tb.eu2;

/* compiled from: Taobao */
public class b implements Application.ActivityLifecycleCallbacks {
    a a;
    private ArrayList<a> b;
    private boolean c = false;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        WeakReference<Activity> a;
        c b;

        public a(WeakReference<Activity> weakReference, c cVar) {
            this.a = weakReference;
            this.b = cVar;
        }

        public void a() {
            Activity activity = (Activity) eu2.c(this.a);
            if (activity != null) {
                Window.Callback callback = activity.getWindow().getCallback();
                if (!(callback instanceof c)) {
                    this.b.a = callback;
                    activity.getWindow().setCallback(this.b);
                }
            }
        }

        public void b() {
            Activity activity = (Activity) eu2.c(this.a);
            if (activity != null) {
                activity.getWindow().setCallback(this.b.a);
            }
        }
    }

    public b(a aVar) {
        this.a = aVar;
        this.b = new ArrayList<>();
    }

    private a a(Activity activity) {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (activity == eu2.c(next.a)) {
                return next;
            }
        }
        return null;
    }

    private void c(Activity activity) {
        a a2 = a(activity);
        if (a2 != null) {
            a2.b();
            this.b.remove(a2);
        }
    }

    public void b(Activity activity) {
        a a2 = a(activity);
        if (a2 == null) {
            a2 = new a(new WeakReference(activity), new c(this.a, activity.getWindow().getCallback()));
            this.b.add(a2);
        }
        a2.a();
        if (!this.c) {
            cr1.b("App registerActivityLifecycleCallback.", new Object[0]);
            PopLayer.getReference().getApp().registerActivityLifecycleCallbacks(this);
            this.c = true;
        }
    }

    public void d() {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.b.clear();
        if (this.c) {
            cr1.b("App unregisterActivityLifecycleCallback.", new Object[0]);
            PopLayer.getReference().getApp().unregisterActivityLifecycleCallbacks(this);
            this.c = false;
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        if (activity.isChild() && (activity.getParent() instanceof Activity)) {
            return;
        }
        if (!this.c) {
            cr1.b("App Service,bad onPause event " + activity.getClass().getSimpleName(), new Object[0]);
            return;
        }
        this.a.i(activity.getApplicationContext());
        cr1.b("App Service.onPause : " + activity.getClass().getSimpleName(), new Object[0]);
        c(activity);
        this.a.d(activity);
    }

    public void onActivityResumed(Activity activity) {
        if (activity.isChild() && (activity.getParent() instanceof Activity)) {
            return;
        }
        if (!this.c) {
            cr1.b("App Service,bad onResume event " + activity.getClass().getSimpleName(), new Object[0]);
            return;
        }
        this.a.i(activity);
        cr1.b("App Service,onResume : " + activity.getClass().getSimpleName(), new Object[0]);
        this.a.e(activity);
        b(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
