package com.alibaba.pictures.ut;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTPageHitHelper;
import com.ut.mini.exposure.TrackerFrameLayout;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.youku.live.dago.liveplayback.widget.Constants;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.oq2;
import tb.ot2;
import tb.ur2;

/* compiled from: Taobao */
public final class ExposureDog {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private String b;
    private Boolean c = Boolean.FALSE;
    private String d;
    private String e;
    private String f;
    private String g;
    private final Lazy h = kotlin.b.b(ExposureDog$params$2.INSTANCE);
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private final Handler m = new Handler(Looper.getMainLooper());
    private final View n;

    /* compiled from: Taobao */
    public static final class ExpGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private Runnable a;
        @NotNull
        private a b;
        @NotNull
        private View c;

        public ExpGlobalLayoutListener(@NotNull a aVar, @NotNull View view) {
            k21.i(aVar, "attachListener");
            k21.i(view, "view");
            this.b = aVar;
            this.c = view;
        }

        @NotNull
        public final a a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "214107030")) {
                return this.b;
            }
            return (a) ipChange.ipc$dispatch("214107030", new Object[]{this});
        }

        @Nullable
        public final Runnable b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-983512390")) {
                return this.a;
            }
            return (Runnable) ipChange.ipc$dispatch("-983512390", new Object[]{this});
        }

        @NotNull
        public final View c() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1815061820")) {
                return this.c;
            }
            return (View) ipChange.ipc$dispatch("1815061820", new Object[]{this});
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1759818441")) {
                ipChange.ipc$dispatch("1759818441", new Object[]{this});
            } else if (this.b.a() > 0) {
                this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Runnable runnable = this.a;
                if (runnable != null) {
                    this.c.removeCallbacks(runnable);
                }
            } else if (DogCat.INSTANCE.t(this.c)) {
                this.b.b(SystemClock.elapsedRealtime());
                this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Runnable runnable2 = this.a;
                if (runnable2 != null) {
                    this.c.removeCallbacks(runnable2);
                }
            } else {
                Runnable runnable3 = this.a;
                if (runnable3 != null) {
                    this.c.removeCallbacks(runnable3);
                } else {
                    this.a = new ExposureDog$ExpGlobalLayoutListener$onGlobalLayout$1(this);
                }
                this.c.postDelayed(this.a, 500);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0016R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/alibaba/pictures/ut/ExposureDog$ExposureObserver;", "Landroidx/lifecycle/LifecycleObserver;", "Ljava/lang/Runnable;", "Ltb/ur2;", "onResume", "onDestroy", "run", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "Landroidx/fragment/app/FragmentActivity;", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "Lcom/alibaba/pictures/ut/ExposureDog;", "exposureDog", "Lcom/alibaba/pictures/ut/ExposureDog;", "getExposureDog", "()Lcom/alibaba/pictures/ut/ExposureDog;", "setExposureDog", "(Lcom/alibaba/pictures/ut/ExposureDog;)V", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/alibaba/pictures/ut/ExposureDog;)V", "ut_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public static final class ExposureObserver implements LifecycleObserver, Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private FragmentActivity activity;
        @Nullable
        private ExposureDog exposureDog;
        @Nullable
        private Handler handler = new Handler(Looper.getMainLooper());

        public ExposureObserver(@Nullable FragmentActivity fragmentActivity, @Nullable ExposureDog exposureDog2) {
            this.activity = fragmentActivity;
            this.exposureDog = exposureDog2;
        }

        @Nullable
        public final FragmentActivity getActivity() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1808389486")) {
                return this.activity;
            }
            return (FragmentActivity) ipChange.ipc$dispatch("-1808389486", new Object[]{this});
        }

        @Nullable
        public final ExposureDog getExposureDog() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1973248980")) {
                return this.exposureDog;
            }
            return (ExposureDog) ipChange.ipc$dispatch("-1973248980", new Object[]{this});
        }

        @Nullable
        public final Handler getHandler() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1047556546")) {
                return this.handler;
            }
            return (Handler) ipChange.ipc$dispatch("1047556546", new Object[]{this});
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            Lifecycle lifecycle;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-772343433")) {
                ipChange.ipc$dispatch("-772343433", new Object[]{this});
                return;
            }
            FragmentActivity fragmentActivity = this.activity;
            if (!(fragmentActivity == null || (lifecycle = fragmentActivity.getLifecycle()) == null)) {
                lifecycle.removeObserver(this);
            }
            this.activity = null;
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            this.handler = null;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public final void onResume() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1614047124")) {
                ipChange.ipc$dispatch("-1614047124", new Object[]{this});
                return;
            }
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.postDelayed(this, 400);
            }
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-792663097")) {
                ipChange.ipc$dispatch("-792663097", new Object[]{this});
                return;
            }
            ExposureDog exposureDog2 = this.exposureDog;
            if (exposureDog2 != null) {
                exposureDog2.l();
            }
            onDestroy();
        }

        public final void setActivity(@Nullable FragmentActivity fragmentActivity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-308334486")) {
                ipChange.ipc$dispatch("-308334486", new Object[]{this, fragmentActivity});
                return;
            }
            this.activity = fragmentActivity;
        }

        public final void setExposureDog(@Nullable ExposureDog exposureDog2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-180571170")) {
                ipChange.ipc$dispatch("-180571170", new Object[]{this, exposureDog2});
                return;
            }
            this.exposureDog = exposureDog2;
        }

        public final void setHandler(@Nullable Handler handler2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1759173568")) {
                ipChange.ipc$dispatch("1759173568", new Object[]{this, handler2});
                return;
            }
            this.handler = handler2;
        }
    }

    /* compiled from: Taobao */
    public static final class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private Map<String, String> a = new HashMap();
        @NotNull
        private JSONArray b = new JSONArray();
        private long c;
        @Nullable
        private ViewTreeObserver.OnGlobalLayoutListener d;
        @Nullable
        private String e;
        @Nullable
        private String f;
        @NotNull
        private String g;
        @Nullable
        private Map<String, String> h;

        public a(@NotNull View view, @Nullable String str, @Nullable String str2, @NotNull String str3, @Nullable Map<String, String> map) {
            k21.i(view, "view");
            k21.i(str3, "block");
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = map;
            if (view.getWindowId() != null) {
                if (DogCat.INSTANCE.t(view)) {
                    this.c = SystemClock.elapsedRealtime();
                }
                this.d = new ExpGlobalLayoutListener(this, view);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this.d);
            }
        }

        public final long a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1989735510")) {
                return this.c;
            }
            return ((Long) ipChange.ipc$dispatch("1989735510", new Object[]{this})).longValue();
        }

        public final void b(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1831925330")) {
                ipChange.ipc$dispatch("-1831925330", new Object[]{this, Long.valueOf(j)});
                return;
            }
            this.c = j;
        }

        public void onViewAttachedToWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1558798919")) {
                ipChange.ipc$dispatch("1558798919", new Object[]{this, view});
                return;
            }
            k21.i(view, "v");
            if (this.c == 0) {
                if (DogCat.INSTANCE.t(view)) {
                    this.c = SystemClock.elapsedRealtime();
                } else if (this.d == null) {
                    this.d = new ExpGlobalLayoutListener(this, view);
                    view.getViewTreeObserver().addOnGlobalLayoutListener(this.d);
                }
            }
        }

        public void onViewDetachedFromWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-814321404")) {
                ipChange.ipc$dispatch("-814321404", new Object[]{this, view});
                return;
            }
            k21.i(view, "v");
            long j = 0;
            if (this.c > 0) {
                j = SystemClock.elapsedRealtime() - this.c;
            }
            this.c = j;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((Object) Constants.ACTION_PARAMS_AREA, (Object) Double.valueOf(1.0d));
            jSONObject.put((Object) "duration", (Object) Long.valueOf(this.c));
            jSONObject.put((Object) "exargs", (Object) this.h);
            String str = this.f;
            if (str == null) {
                str = DogCat.INSTANCE.q(view);
            }
            if (str == null) {
                str = DogCat.INSTANCE.f();
            }
            DogCat dogCat = DogCat.INSTANCE;
            String a2 = dogCat.a(str, null);
            String A = dogCat.A(a2);
            if (A == null) {
                A = dogCat.l(view);
            }
            if (!(a2 == null || a2.length() == 0)) {
                jSONObject.put((Object) "spm", (Object) a2);
            }
            jSONObject.put((Object) "viewid", (Object) A);
            this.b.add(jSONObject);
            Map<String, String> map = this.a;
            String jSONString = this.b.toJSONString();
            k21.h(jSONString, "js.toJSONString()");
            map.put("expdata", jSONString);
            String str2 = this.e;
            if (!(str2 == null || str2.length() == 0)) {
                z = false;
            }
            if (z) {
                UTPageHitHelper instance = UTPageHitHelper.getInstance();
                k21.h(instance, "UTPageHitHelper.getInstance()");
                this.e = instance.getCurrentPageName();
            }
            UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(this.e, 2201, this.g, null, null, this.a);
            UTAnalytics instance2 = UTAnalytics.getInstance();
            k21.h(instance2, "UTAnalytics.getInstance()");
            instance2.getDefaultTracker().send(uTOriginalCustomHitBuilder.build());
            try {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.d);
                view.removeOnAttachStateChangeListener(this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private boolean a;
        private long b;
        final /* synthetic */ ExposureDog c;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(ExposureDog exposureDog) {
            this.c = exposureDog;
            this.a = exposureDog.n.getVisibility() == 0;
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "1169347549")) {
                ipChange.ipc$dispatch("1169347549", new Object[]{this});
                return;
            }
            if (!this.a) {
                if (this.c.n.getVisibility() == 0) {
                    z = true;
                }
                this.a = z;
                this.b = SystemClock.elapsedRealtime();
            }
            if (this.a && this.c.n.getVisibility() != 0 && SystemClock.elapsedRealtime() - this.b >= ((long) 500)) {
                this.c.n.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                UTAnalytics instance = UTAnalytics.getInstance();
                k21.h(instance, "UTAnalytics.getInstance()");
                instance.getDefaultTracker().commitExposureData();
            }
        }
    }

    public ExposureDog(@Nullable View view) {
        this.n = view;
    }

    private final void m() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1796384296")) {
            ipChange.ipc$dispatch("-1796384296", new Object[]{this});
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object) Constants.ACTION_PARAMS_AREA, (Object) Double.valueOf(1.0d));
        jSONObject.put((Object) "duration", (Object) 0);
        jSONObject.put((Object) "exargs", (Object) p());
        s(this.n, this.e, null);
        String str = this.f;
        if (!(str == null || str.length() == 0)) {
            jSONObject.put((Object) "spm", (Object) this.f);
        }
        jSONObject.put((Object) "viewid", (Object) this.b);
        jSONArray.add(jSONObject);
        HashMap hashMap = new HashMap();
        String jSONString = jSONArray.toJSONString();
        k21.h(jSONString, "js.toJSONString()");
        hashMap.put("expdata", jSONString);
        String str2 = this.d;
        if (str2 == null || str2.length() == 0) {
            UTPageHitHelper instance = UTPageHitHelper.getInstance();
            k21.h(instance, "UTPageHitHelper.getInstance()");
            this.d = instance.getCurrentPageName();
        }
        String str3 = this.d;
        if (!(str3 == null || str3.length() == 0)) {
            z = false;
        }
        if (!z) {
            UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(this.d, 2201, this.a, null, null, hashMap);
            UTAnalytics instance2 = UTAnalytics.getInstance();
            k21.h(instance2, "UTAnalytics.getInstance()");
            instance2.getDefaultTracker().send(uTOriginalCustomHitBuilder.build());
        }
    }

    private final void n(View view, String str, String str2, String str3, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1925154073")) {
            ipChange.ipc$dispatch("1925154073", new Object[]{this, view, str, str2, str3, map});
        } else if (str3 != null) {
            view.addOnAttachStateChangeListener(new a(view, str, str2, str3, map));
        } else {
            ot2.c("exposureWindow-error,block==null");
            ur2 ur2 = ur2.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void o(FragmentActivity fragmentActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1422428782")) {
            ipChange.ipc$dispatch("1422428782", new Object[]{this, fragmentActivity});
        } else if (fragmentActivity != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) fragmentActivity.findViewById(16908290);
                if (viewGroup != null && viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    if (childAt instanceof TrackerFrameLayout) {
                        Method declaredMethod = ((TrackerFrameLayout) childAt).getClass().getDeclaredMethod(AgooConstants.MESSAGE_TRACE, Integer.TYPE, Boolean.TYPE);
                        k21.h(declaredMethod, "root.javaClass.getDeclar…:class.javaPrimitiveType)");
                        if (declaredMethod != null) {
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(childAt, 0, Boolean.TRUE);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public final Map<String, String> p() {
        Object value;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1543852504")) {
            value = ipChange.ipc$dispatch("-1543852504", new Object[]{this});
        } else {
            value = this.h.getValue();
        }
        return (Map) value;
    }

    /* access modifiers changed from: private */
    public final void s(View view, String str, String str2) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-941948411")) {
            ipChange.ipc$dispatch("-941948411", new Object[]{this, view, str, str2});
            return;
        }
        if ((str == null || str.length() == 0) && this.i) {
            str = this.a + '.' + this.b;
        }
        DogCat dogCat = DogCat.INSTANCE;
        String a2 = dogCat.a(str, str2);
        if (a2 == null) {
            a2 = dogCat.f();
        }
        this.f = a2;
        String str3 = this.b;
        if (str3 == null || str3.length() == 0) {
            z = true;
        }
        if (z || (!k21.d(this.c, Boolean.TRUE))) {
            StringBuilder sb = new StringBuilder();
            String str4 = this.f;
            if (str4 == null) {
                str4 = "view";
            }
            sb.append(str4);
            sb.append(JSMethod.NOT_SET);
            sb.append(dogCat.l(view));
            this.b = sb.toString();
        }
    }

    private final void t(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "889229445")) {
            ipChange.ipc$dispatch("889229445", new Object[]{this, runnable});
            return;
        }
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        k21.h(mainLooper, "Looper.getMainLooper()");
        if (currentThread == mainLooper.getThread()) {
            runnable.run();
        } else {
            this.m.post(runnable);
        }
    }

    private final void u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1508159462")) {
            ipChange.ipc$dispatch("-1508159462", new Object[]{this});
            return;
        }
        View view = this.n;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
        }
    }

    /* access modifiers changed from: private */
    public final String x(View view) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-73986931")) {
            return (String) ipChange.ipc$dispatch("-73986931", new Object[]{this, view});
        }
        String str = this.g;
        String p = str == null || str.length() == 0 ? DogCat.INSTANCE.p(this.d) : this.g;
        this.g = p;
        if (!(p == null || p.length() == 0)) {
            z = false;
        }
        if (z) {
            String str2 = null;
            while (str2 == null && view != null && i2 <= 100) {
                Object tag = view.getTag(oq2.b());
                if (!(tag instanceof String)) {
                    tag = null;
                }
                str2 = (String) tag;
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    parent = null;
                }
                view = (View) parent;
                i2++;
            }
            this.g = str2;
        }
        return this.g;
    }

    @NotNull
    public final ExposureDog j(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1105378751")) {
            return (ExposureDog) ipChange.ipc$dispatch("1105378751", new Object[]{this, str});
        }
        this.a = str;
        return this;
    }

    public final void k() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-722982556")) {
            ipChange.ipc$dispatch("-722982556", new Object[]{this});
            return;
        }
        String str = this.d;
        if (!(str == null || str.length() == 0)) {
            this.d = DogCat.INSTANCE.i(this.d);
        }
        String str2 = this.a;
        if (str2 == null || str2.length() == 0) {
            this.a = DogCat.INSTANCE.k(this.d, this.e);
        }
        if (this.n == null) {
            m();
            return;
        }
        if (this.l) {
            u();
        }
        if (this.k) {
            String str3 = this.a;
            if (str3 == null || str3.length() == 0) {
                z = true;
            }
            if (!z) {
                try {
                    UTAnalytics instance = UTAnalytics.getInstance();
                    k21.h(instance, "UTAnalytics.getInstance()");
                    instance.getDefaultTracker().setCommitImmediatelyExposureBlock(this.a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (this.j) {
            n(this.n, this.d, this.e, this.a, p());
        } else {
            l();
        }
    }

    public final void l() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1622017516")) {
            ipChange.ipc$dispatch("-1622017516", new Object[]{this});
            return;
        }
        View view = this.n;
        if (view != null) {
            Activity m2 = DogCat.m(view);
            if (!(m2 instanceof FragmentActivity)) {
                ot2.c("error exposure " + this.a + ' ' + this.n + " in " + m2);
                return;
            }
            FragmentActivity fragmentActivity = (FragmentActivity) m2;
            Lifecycle lifecycle = fragmentActivity.getLifecycle();
            k21.h(lifecycle, "activity.lifecycle");
            if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                String str = this.e;
                if (str == null) {
                    str = DogCat.INSTANCE.q(this.n);
                }
                this.e = str;
                if (str == null || str.length() == 0) {
                    z = true;
                }
                if (!z) {
                    String str2 = this.e;
                    k21.f(str2);
                    if (StringsKt__StringsKt.z0(str2, new String[]{"."}, false, 0, 6, null).size() >= 3) {
                        t(new ExposureDog$exposure$1(this, m2));
                        return;
                    }
                }
                this.n.post(new ExposureDog$exposure$2(this, m2));
                return;
            }
            fragmentActivity.getLifecycle().addObserver(new ExposureObserver(fragmentActivity, this));
        }
    }

    @NotNull
    public final ExposureDog q(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94757762")) {
            return (ExposureDog) ipChange.ipc$dispatch("-94757762", new Object[]{this, str});
        }
        this.d = str;
        return this;
    }

    @NotNull
    public final ExposureDog r(@Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-704211421")) {
            return (ExposureDog) ipChange.ipc$dispatch("-704211421", new Object[]{this, map});
        }
        if (map != null) {
            p().putAll(map);
        }
        return this;
    }

    @NotNull
    public final ExposureDog v(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "723432313")) {
            return (ExposureDog) ipChange.ipc$dispatch("723432313", new Object[]{this, str, str2, str3});
        }
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z) {
            return w(str2, str3);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('.');
        if (str2 == null) {
            str2 = "default";
        }
        sb.append(str2);
        sb.append('.');
        if (str3 == null) {
            str3 = "0";
        }
        sb.append(str3);
        this.e = sb.toString();
        return this;
    }

    @NotNull
    public final ExposureDog w(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2011603067")) {
            return (ExposureDog) ipChange.ipc$dispatch("-2011603067", new Object[]{this, str, str2});
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "default";
        }
        sb.append(str);
        sb.append('.');
        if (str2 == null) {
            str2 = "0";
        }
        sb.append(str2);
        this.e = sb.toString();
        return this;
    }

    @NotNull
    public final ExposureDog y(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "56758232")) {
            return (ExposureDog) ipChange.ipc$dispatch("56758232", new Object[]{this, str});
        }
        this.b = str;
        this.c = Boolean.TRUE;
        return this;
    }
}
