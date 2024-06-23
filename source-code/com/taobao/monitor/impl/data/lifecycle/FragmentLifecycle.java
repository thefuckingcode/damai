package com.taobao.monitor.impl.data.lifecycle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.a;
import com.taobao.monitor.procedure.IPage;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.b0;
import tb.dm2;
import tb.e90;
import tb.i20;
import tb.jn0;
import tb.k3;
import tb.on1;
import tb.qn1;
import tb.us1;

/* compiled from: Taobao */
public class FragmentLifecycle extends FragmentManager.FragmentLifecycleCallbacks {
    private static final Map<WeakReference<Fragment>, Long> f = new ConcurrentHashMap();
    private final Map<Fragment, IPage> a = new HashMap();
    private FragmentLifecycleDispatcher b;
    private a c;
    private final Activity d;
    private final String e;

    public FragmentLifecycle(Activity activity, String str) {
        this.d = activity;
        this.e = str;
        IDispatcher a2 = b0.a(b0.FRAGMENT_LIFECYCLE_DISPATCHER);
        if (a2 instanceof FragmentLifecycleDispatcher) {
            this.b = (FragmentLifecycleDispatcher) a2;
        }
        IDispatcher a3 = b0.a(b0.FRAGMENT_LIFECYCLE_FUNCTION_DISPATCHER);
        if (a3 instanceof a) {
            this.c = (a) a3;
        }
    }

    public static long a(Fragment fragment) {
        Fragment fragment2;
        for (Map.Entry<WeakReference<Fragment>, Long> entry : f.entrySet()) {
            if (!(entry.getKey() == null || (fragment2 = entry.getKey().get()) == null || fragment2 != fragment)) {
                return entry.getValue().longValue();
            }
        }
        return -1;
    }

    private Map<String, Object> b(Activity activity, Fragment fragment) {
        HashMap hashMap = new HashMap();
        hashMap.put("schemaUrl", k3.c(activity));
        hashMap.put("activityName", k3.d(activity));
        hashMap.put("fullPageName", jn0.a(fragment));
        return hashMap;
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentActivityCreated(fragmentManager, fragment, bundle);
        if (!e90.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentActivityCreated", dm2.a());
        }
        i20.a("FragmentLifecycle", "onFragmentActivityCreated", fragment.getClass().getSimpleName());
        if (!e90.c(this.b)) {
            this.b.f(fragment, dm2.a());
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        super.onFragmentAttached(fragmentManager, fragment, context);
        if (!e90.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentAttached", dm2.a());
        }
        i20.a("FragmentLifecycle", "onFragmentAttached", fragment.getClass().getSimpleName());
        if (!e90.c(this.b)) {
            this.b.g(fragment, dm2.a());
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentCreated(fragmentManager, fragment, bundle);
        if (!e90.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentCreated", dm2.a());
        }
        i20.a("FragmentLifecycle", "onFragmentCreated", fragment.getClass().getSimpleName());
        if (!e90.c(this.b)) {
            this.b.h(fragment, dm2.a());
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentDestroyed(fragmentManager, fragment);
        if (!e90.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentDestroyed", dm2.a());
        }
        i20.a("FragmentLifecycle", "onFragmentDestroyed", fragment.getClass().getSimpleName());
        if (!e90.c(this.b)) {
            this.b.i(fragment, dm2.a());
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentDetached(fragmentManager, fragment);
        IPage iPage = this.a.get(fragment);
        if (iPage != null) {
            iPage.getPageLifecycleCallback().onPageDestroy();
            us1.PROCEDURE_MANAGER.p(iPage);
            this.a.remove(fragment);
        }
        if (!e90.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentDetached", dm2.a());
        }
        i20.a("FragmentLifecycle", "onFragmentDetached", fragment.getClass().getSimpleName());
        if (!e90.c(this.b)) {
            this.b.j(fragment, dm2.a());
        }
        Iterator<Map.Entry<WeakReference<Fragment>, Long>> it = f.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<WeakReference<Fragment>, Long> next = it.next();
            if (next.getKey() == null || next.getKey().get() == null || next.getKey().get() == fragment) {
                it.remove();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentPaused(fragmentManager, fragment);
        if (!e90.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentPaused", dm2.a());
        }
        i20.a("FragmentLifecycle", "onFragmentPaused", fragment.getClass().getSimpleName());
        if (!e90.c(this.b)) {
            this.b.k(fragment, dm2.a());
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        super.onFragmentPreAttached(fragmentManager, fragment, context);
        i20.a("FragmentLifecycle", "onFragmentPreAttached", fragment.getClass().getSimpleName());
        IPage a2 = new qn1().c(fragment).j(this.d.getWindow()).d(this.e).a();
        this.a.put(fragment, a2);
        a2.getPageLifecycleCallback().onPageCreate(jn0.b(fragment), k3.c(this.d), b(this.d, fragment));
        if (!e90.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentPreAttached", dm2.a());
        }
        if (!e90.c(this.b)) {
            this.b.l(fragment, dm2.a());
        }
        f.put(new WeakReference<>(fragment), Long.valueOf(dm2.a()));
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentPreCreated(fragmentManager, fragment, bundle);
        if (!e90.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentPreCreated", dm2.a());
        }
        i20.a("FragmentLifecycle", "onFragmentPreCreated", fragment.getClass().getSimpleName());
        if (!e90.c(this.b)) {
            this.b.m(fragment, dm2.a());
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentResumed(fragmentManager, fragment);
        IPage iPage = this.a.get(fragment);
        if (iPage != null) {
            iPage.getPageLifecycleCallback().onPageAppear();
        }
        if (!e90.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentResumed", dm2.a());
        }
        i20.a("FragmentLifecycle", "onFragmentResumed", fragment.getClass().getSimpleName());
        if (!e90.c(this.b)) {
            this.b.n(fragment, dm2.a());
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentSaveInstanceState(fragmentManager, fragment, bundle);
        if (!e90.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentSaveInstanceState", dm2.a());
        }
        i20.a("FragmentLifecycle", "onFragmentSaveInstanceState", fragment.getClass().getSimpleName());
        if (!e90.c(this.b)) {
            this.b.o(fragment, dm2.a());
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStarted(fragmentManager, fragment);
        if (!e90.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentStarted", dm2.a());
        }
        i20.a("FragmentLifecycle", "onFragmentStarted", fragment.getClass().getSimpleName());
        if (!e90.c(this.b)) {
            this.b.p(fragment, dm2.a());
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStopped(fragmentManager, fragment);
        IPage iPage = this.a.get(fragment);
        if (iPage instanceof on1) {
            iPage.getPageLifecycleCallback().onPageDisappear();
        }
        if (!e90.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentStopped", dm2.a());
        }
        i20.a("FragmentLifecycle", "onFragmentStopped", fragment.getClass().getSimpleName());
        if (!e90.c(this.b)) {
            this.b.q(fragment, dm2.a());
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        super.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
        if (!e90.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentViewCreated", dm2.a());
        }
        i20.a("FragmentLifecycle", "onFragmentViewCreated", fragment.getClass().getSimpleName());
        if (!e90.c(this.b)) {
            this.b.r(fragment, dm2.a());
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentViewDestroyed(fragmentManager, fragment);
        if (!e90.c(this.c)) {
            this.c.onFunction(fragment.getActivity(), fragment, "onFragmentViewDestroyed", dm2.a());
        }
        i20.a("FragmentLifecycle", "onFragmentViewDestroyed", fragment.getClass().getSimpleName());
        if (!e90.c(this.b)) {
            this.b.s(fragment, dm2.a());
        }
    }
}
