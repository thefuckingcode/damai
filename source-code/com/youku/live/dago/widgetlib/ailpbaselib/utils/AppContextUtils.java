package com.youku.live.dago.widgetlib.ailpbaselib.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* compiled from: Taobao */
public final class AppContextUtils {
    private static transient /* synthetic */ IpChange $ipChange;
    private static Application.ActivityLifecycleCallbacks mCallbacks = new Application.ActivityLifecycleCallbacks() {
        /* class com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void onActivityCreated(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1518801553")) {
                ipChange.ipc$dispatch("1518801553", new Object[]{this, activity, bundle});
                return;
            }
            AppContextUtils.sActivityList.add(activity);
            AppContextUtils.setTopActivityWeakRef(activity);
        }

        public void onActivityDestroyed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1969960366")) {
                ipChange.ipc$dispatch("-1969960366", new Object[]{this, activity});
                return;
            }
            AppContextUtils.sActivityList.remove(activity);
        }

        public void onActivityPaused(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-937995051")) {
                ipChange.ipc$dispatch("-937995051", new Object[]{this, activity});
            }
        }

        public void onActivityResumed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "598422868")) {
                ipChange.ipc$dispatch("598422868", new Object[]{this, activity});
                return;
            }
            AppContextUtils.setTopActivityWeakRef(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-495761240")) {
                ipChange.ipc$dispatch("-495761240", new Object[]{this, activity, bundle});
            }
        }

        public void onActivityStarted(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-215833110")) {
                ipChange.ipc$dispatch("-215833110", new Object[]{this, activity});
                return;
            }
            AppContextUtils.setTopActivityWeakRef(activity);
        }

        public void onActivityStopped(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-424664546")) {
                ipChange.ipc$dispatch("-424664546", new Object[]{this, activity});
            }
        }
    };
    static List<Activity> sActivityList = new LinkedList();
    @SuppressLint({"StaticFieldLeak"})
    private static Application sApplication;
    static WeakReference<Activity> sTopActivityWeakRef;

    private AppContextUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Application getApp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005728214")) {
            return (Application) ipChange.ipc$dispatch("1005728214", new Object[0]);
        }
        Application application = sApplication;
        Objects.requireNonNull(application, "u should init first");
        return application;
    }

    public static void init(@NonNull Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1382604573")) {
            ipChange.ipc$dispatch("1382604573", new Object[]{application});
            return;
        }
        sApplication = application;
        application.registerActivityLifecycleCallbacks(mCallbacks);
    }

    /* access modifiers changed from: private */
    public static void setTopActivityWeakRef(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1291374319")) {
            ipChange.ipc$dispatch("-1291374319", new Object[]{activity});
            return;
        }
        WeakReference<Activity> weakReference = sTopActivityWeakRef;
        if (weakReference == null || !activity.equals(weakReference.get())) {
            sTopActivityWeakRef = new WeakReference<>(activity);
        }
    }
}
