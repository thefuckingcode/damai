package com.taobao.application.common.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.taobao.application.common.Apm;
import com.taobao.application.common.IApmEventListener;
import com.taobao.application.common.IAppLaunchListener;
import com.taobao.application.common.IAppPreferences;
import com.taobao.application.common.IApplicationMonitor;
import com.taobao.application.common.IPageListener;
import com.uc.webview.export.extension.UCCore;
import java.util.concurrent.ConcurrentHashMap;
import tb.t91;
import tb.uk2;
import tb.z6;

/* compiled from: Taobao */
public class a implements Apm, IApplicationMonitor {
    private final ICallbackGroup<Application.ActivityLifecycleCallbacks> a;
    private final ICallbackGroup<Application.ActivityLifecycleCallbacks> b;
    private final IListenerGroup<IPageListener> c;
    private final IListenerGroup<IAppLaunchListener> d;
    private final IListenerGroup<IApmEventListener> e;
    private final Handler f;
    private volatile Activity g;
    private ConcurrentHashMap<Application.ActivityLifecycleCallbacks, Boolean> h;

    /* compiled from: Taobao */
    private static class b {
        static final a a = new a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private <T> T a(Object obj) {
        return obj;
    }

    public static a g() {
        return b.a;
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    @TargetApi(14)
    public void addActivityLifecycle(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks, boolean z) {
        if (activityLifecycleCallbacks == null) {
            throw new IllegalArgumentException();
        } else if (this.h.put(activityLifecycleCallbacks, Boolean.valueOf(z)) != null) {
            throw new IllegalArgumentException();
        } else if (z) {
            this.a.addCallback(activityLifecycleCallbacks);
        } else {
            this.b.addCallback(activityLifecycleCallbacks);
        }
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public void addApmEventListener(IApmEventListener iApmEventListener) {
        this.e.addListener(iApmEventListener);
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public void addAppLaunchListener(IAppLaunchListener iAppLaunchListener) {
        this.d.addListener(iAppLaunchListener);
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public void addPageListener(IPageListener iPageListener) {
        this.c.addListener(iPageListener);
    }

    public IApmEventListener b() {
        return (IApmEventListener) a(this.e);
    }

    @TargetApi(14)
    public Application.ActivityLifecycleCallbacks c() {
        return (Application.ActivityLifecycleCallbacks) a(this.b);
    }

    public IAppLaunchListener d() {
        return (IAppLaunchListener) a(this.d);
    }

    public IPageListener e() {
        return (IPageListener) a(this.c);
    }

    @TargetApi(14)
    public Application.ActivityLifecycleCallbacks f() {
        return (Application.ActivityLifecycleCallbacks) a(this.a);
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public IAppPreferences getAppPreferences() {
        return z6.b();
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public Handler getAsyncHandler() {
        return this.f;
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public Looper getAsyncLooper() {
        return this.f.getLooper();
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public Activity getTopActivity() {
        return this.g;
    }

    public void h(Runnable runnable) {
        this.f.post(runnable);
    }

    public void i(Activity activity) {
        this.g = activity;
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public void removeActivityLifecycle(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null) {
            Boolean bool = this.h.get(activityLifecycleCallbacks);
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                this.h.remove(activityLifecycleCallbacks);
                if (booleanValue) {
                    this.a.removeCallback(activityLifecycleCallbacks);
                } else {
                    this.b.removeCallback(activityLifecycleCallbacks);
                }
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public void removeApmEventListener(IApmEventListener iApmEventListener) {
        this.e.removeListener(iApmEventListener);
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public void removeAppLaunchListener(IAppLaunchListener iAppLaunchListener) {
        this.d.removeListener(iAppLaunchListener);
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public void removePageListener(IPageListener iPageListener) {
        this.c.removeListener(iPageListener);
    }

    private a() {
        this.a = new b();
        this.b = new ApplicationCallbackGroup();
        this.c = new PageListenerGroup();
        this.d = new AppLaunchListenerGroup();
        this.e = new ApmEventListenerGroup();
        this.h = new ConcurrentHashMap<>();
        HandlerThread a2 = uk2.a("Apm-Sec");
        a2.start();
        this.f = new Handler(a2.getLooper());
        t91.b("ApmImpl", UCCore.LEGACY_EVENT_INIT);
    }
}
