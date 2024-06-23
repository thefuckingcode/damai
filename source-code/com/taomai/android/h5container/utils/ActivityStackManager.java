package com.taomai.android.h5container.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.taobao.android.tlog.protocol.Constants;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.j91;
import tb.jl1;
import tb.k21;
import tb.m40;
import tb.ur2;

/* compiled from: Taobao */
public final class ActivityStackManager implements Application.ActivityLifecycleCallbacks {
    @NotNull
    public static final b Companion = new b(null);
    @NotNull
    public static final String TAG = "ActivityStackManager";
    @NotNull
    private static final Lazy b = kotlin.b.a(LazyThreadSafetyMode.SYNCHRONIZED, ActivityStackManager$Companion$instance$2.INSTANCE);
    private final LinkedList<a> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/taomai/android/h5container/utils/ActivityStackManager$IActivityStackBackEvent;", "", "", "jsonData", "Ltb/ur2;", "onPageBackResult", "h5container_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface IActivityStackBackEvent {
        void onPageBackResult(@Nullable String str);
    }

    /* compiled from: Taobao */
    public static final class a {
        @Nullable
        private WeakReference<Activity> a;
        @Nullable
        private String b;

        public a(@Nullable Activity activity, @Nullable String str) {
            this.a = new WeakReference<>(activity);
            this.b = str;
        }

        @Nullable
        public final WeakReference<Activity> a() {
            return this.a;
        }

        @NotNull
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            WeakReference<Activity> weakReference = this.a;
            k21.f(weakReference);
            if (weakReference.get() != null) {
                WeakReference<Activity> weakReference2 = this.a;
                k21.f(weakReference2);
                Activity activity = weakReference2.get();
                k21.f(activity);
                str = activity.getClass().getSimpleName();
            } else {
                str = "null";
            }
            sb.append(str);
            sb.append(jl1.ARRAY_START_STR);
            sb.append(this.b);
            sb.append(jl1.ARRAY_END_STR);
            return sb.toString();
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private b() {
        }

        @NotNull
        public final ActivityStackManager a() {
            Lazy lazy = ActivityStackManager.b;
            b bVar = ActivityStackManager.Companion;
            return (ActivityStackManager) lazy.getValue();
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }
    }

    private ActivityStackManager() {
        this.a = new LinkedList<>();
    }

    private final void b(Activity activity, String str) {
        synchronized (this.a) {
            this.a.add(new a(activity, str));
        }
    }

    static /* synthetic */ void c(ActivityStackManager activityStackManager, Activity activity, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        activityStackManager.b(activity, str);
    }

    private final void e(Activity activity) {
        Activity activity2;
        WeakReference<Activity> a2;
        synchronized (this.a) {
            Iterator<a> it = this.a.iterator();
            while (true) {
                if (it.hasNext()) {
                    a next = it.next();
                    if (next == null || (a2 = next.a()) == null) {
                        activity2 = null;
                        continue;
                    } else {
                        activity2 = a2.get();
                        continue;
                    }
                    if (activity == activity2) {
                        this.a.remove(next);
                        break;
                    }
                } else {
                    break;
                }
            }
            ur2 ur2 = ur2.INSTANCE;
        }
    }

    public final boolean d(int i, @Nullable String str) {
        boolean z;
        WeakReference<Activity> a2;
        WeakReference<Activity> a3;
        int i2 = 0;
        if (i >= 0 && Math.abs(i) > this.a.size()) {
            return false;
        }
        synchronized (this.a) {
            int size = this.a.size() + i;
            z = true;
            a aVar = this.a.get(size - 1);
            LinkedList<a> linkedList = new LinkedList();
            int size2 = this.a.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    z = false;
                    break;
                }
                a aVar2 = this.a.get(size2);
                if (aVar2 != null && aVar == aVar2) {
                    break;
                }
                linkedList.add(aVar2);
            }
            if (z) {
                if (str != null) {
                    Activity activity = (aVar == null || (a3 = aVar.a()) == null) ? null : a3.get();
                    if (!(activity instanceof IActivityStackBackEvent)) {
                        activity = null;
                    }
                    IActivityStackBackEvent iActivityStackBackEvent = (IActivityStackBackEvent) activity;
                    if (iActivityStackBackEvent != null) {
                        iActivityStackBackEvent.onPageBackResult(str);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("popToData ");
                    if (iActivityStackBackEvent != null) {
                        i2 = iActivityStackBackEvent.hashCode();
                    }
                    sb.append(String.valueOf(i2));
                    j91.a(TAG, sb.toString());
                }
                for (a aVar3 : linkedList) {
                    Activity activity2 = (aVar3 == null || (a2 = aVar3.a()) == null) ? null : a2.get();
                    if (activity2 != null && !activity2.isFinishing()) {
                        activity2.finish();
                    }
                }
                this.a.removeAll(linkedList);
            }
        }
        return z;
    }

    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        k21.i(activity, "activity");
        j91.a(TAG, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED + String.valueOf(activity.hashCode()));
        c(this, activity, null, 2, null);
    }

    public void onActivityDestroyed(@NotNull Activity activity) {
        k21.i(activity, "activity");
        j91.a(TAG, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED + String.valueOf(activity.hashCode()));
        e(activity);
    }

    public void onActivityPaused(@NotNull Activity activity) {
        k21.i(activity, "activity");
    }

    public void onActivityResumed(@NotNull Activity activity) {
        k21.i(activity, "activity");
        j91.a(TAG, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED + String.valueOf(activity.hashCode()));
    }

    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        k21.i(activity, "activity");
        k21.i(bundle, "outState");
    }

    public void onActivityStarted(@NotNull Activity activity) {
        k21.i(activity, "activity");
    }

    public void onActivityStopped(@NotNull Activity activity) {
        k21.i(activity, "activity");
    }

    public /* synthetic */ ActivityStackManager(m40 m40) {
        this();
    }
}
