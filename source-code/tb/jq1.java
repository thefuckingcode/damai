package tb;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager;
import com.taobao.android.tlog.protocol.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.iq1;
import tb.kr1;

/* compiled from: Taobao */
public class jq1 implements Application.ActivityLifecycleCallbacks {
    @Nullable
    private final String a = dz1.b(jq1.class).getSimpleName();
    private int b;
    private boolean c;

    private final void a(Activity activity) {
        br1.Companion.a().j(kr1.Companion.a().c(activity));
    }

    private final void b(String str, Activity activity, Object obj) {
        iq1 a2 = iq1.Companion.a();
        Map<Integer, WeakReference<iq1.b>> d = a2 == null ? null : a2.d();
        ArrayList<Integer> arrayList = null;
        for (Integer num : d.keySet()) {
            int intValue = num.intValue();
            WeakReference<iq1.b> weakReference = d.get(Integer.valueOf(intValue));
            iq1.b bVar = weakReference == null ? null : weakReference.get();
            if (bVar == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(Integer.valueOf(intValue));
            } else if (bVar.a(activity)) {
                if (k21.d(str, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED)) {
                    bVar.b(activity);
                } else if (k21.d(str, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED)) {
                    bVar.c(activity);
                }
            }
        }
        if (arrayList != null) {
            for (Integer num2 : arrayList) {
                po2.c(d).remove(num2);
            }
        }
    }

    private final void c() {
    }

    private final void d() {
    }

    private final void e(Activity activity) {
        String simpleName = activity.getClass().getSimpleName();
        k21.h(simpleName, "activity::class.java.simpleName");
        if (!or1.c(simpleName)) {
            String simpleName2 = activity.getClass().getSimpleName();
            k21.h(simpleName2, "activity::class.java.simpleName");
            if (or1.f(simpleName2) || !kr1.Companion.a().l().get()) {
                String simpleName3 = activity.getClass().getSimpleName();
                k21.h(simpleName3, "activity::class.java.simpleName");
                or1.g(simpleName3, "openPopupManager", "need_popup", null);
                PopupPriorityManager popupPriorityManager = new PopupPriorityManager(activity);
                popupPriorityManager.q(null);
                popupPriorityManager.i(null);
                popupPriorityManager.l(true);
                return;
            }
            String simpleName4 = activity.getClass().getSimpleName();
            k21.h(simpleName4, "activity::class.java.simpleName");
            or1.g(simpleName4, "openPopupManager", "without_popup", null);
            return;
        }
        String simpleName5 = activity.getClass().getSimpleName();
        k21.h(simpleName5, "activity::class.java.simpleName");
        or1.g(simpleName5, "openPopupManager", "local_popup", null);
    }

    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        k21.i(activity, "activity");
        f03.INSTANCE.a(this.a, k21.r("onActivityCreated ", activity));
        kr1 a2 = kr1.Companion.a();
        if (a2 != null) {
            a2.s(activity);
        }
        e(activity);
    }

    public void onActivityDestroyed(@NotNull Activity activity) {
        kr1 a2;
        k21.i(activity, "activity");
        f03.INSTANCE.a(this.a, k21.r("onActivityDestroyed ", activity));
        a(activity);
        kr1.a aVar = kr1.Companion;
        kr1 a3 = aVar.a();
        if ((a3 == null ? null : a3.j()) == activity && (a2 = aVar.a()) != null) {
            a2.s(null);
        }
    }

    public void onActivityPaused(@NotNull Activity activity) {
        k21.i(activity, "activity");
        f03.INSTANCE.a(this.a, k21.r("onActivityPaused ", activity));
        b(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED, activity, null);
    }

    public void onActivityResumed(@NotNull Activity activity) {
        k21.i(activity, "activity");
        f03.INSTANCE.a(this.a, k21.r("onActivityResumed ", activity));
        b(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED, activity, null);
    }

    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        k21.i(activity, "activity");
        k21.i(bundle, "outState");
        f03.INSTANCE.a(this.a, k21.r("onActivitySaveInstanceState ", activity));
    }

    public void onActivityStarted(@NotNull Activity activity) {
        k21.i(activity, "activity");
        f03.INSTANCE.a(this.a, k21.r("onActivityStarted ", activity));
        int i = this.b + 1;
        this.b = i;
        if (i == 1 && !this.c) {
            d();
        }
    }

    public void onActivityStopped(@NotNull Activity activity) {
        k21.i(activity, "activity");
        f03.INSTANCE.a(this.a, k21.r("onActivityStopped ", activity));
        boolean isChangingConfigurations = activity.isChangingConfigurations();
        this.c = isChangingConfigurations;
        int i = this.b - 1;
        this.b = i;
        if (i == 0 && !isChangingConfigurations) {
            c();
        }
    }
}
