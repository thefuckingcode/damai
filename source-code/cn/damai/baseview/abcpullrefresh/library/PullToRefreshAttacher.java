package cn.damai.baseview.abcpullrefresh.library;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import cn.damai.baseview.abcpullrefresh.library.listeners.HeaderViewListener;
import cn.damai.baseview.abcpullrefresh.library.listeners.OnLoadMoreListener;
import cn.damai.baseview.abcpullrefresh.library.listeners.OnRefreshListener;
import cn.damai.baseview.abcpullrefresh.library.viewdelegates.ViewDelegate;
import com.alibaba.security.biometrics.service.common.ABDefaultConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.WeakHashMap;
import tb.nu2;
import tb.yu0;

@TargetApi(14)
/* compiled from: Taobao */
public class PullToRefreshAttacher {
    private static transient /* synthetic */ IpChange $ipChange;
    private EnvironmentDelegate a;
    private yu0 b;
    private OnRefreshListener c;
    private OnLoadMoreListener d;
    private Activity e;
    private View f;
    private HeaderViewListener g;
    private final int h;
    private final float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private boolean o;
    private boolean p;
    private View q;
    private final WeakHashMap<View, ViewDelegate> r;
    private final boolean s;
    private final int t;
    private final boolean u;
    private boolean v = false;
    private final int[] w = new int[2];
    private final Rect x = new Rect();
    private final AddHeaderViewRunnable y;
    private final Runnable z = new Runnable() {
        /* class cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher.AnonymousClass2 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-399607200")) {
                ipChange.ipc$dispatch("-399607200", new Object[]{this});
                return;
            }
            PullToRefreshAttacher.this.s();
        }
    };

    /* compiled from: Taobao */
    public class AddHeaderViewRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;

        private AddHeaderViewRunnable() {
        }

        private View getDecorView() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-976758741")) {
                return PullToRefreshAttacher.this.k().getWindow().getDecorView();
            }
            return (View) ipChange.ipc$dispatch("-976758741", new Object[]{this});
        }

        public void finish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-534253526")) {
                ipChange.ipc$dispatch("-534253526", new Object[]{this});
                return;
            }
            getDecorView().removeCallbacks(this);
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1290718238")) {
                ipChange.ipc$dispatch("-1290718238", new Object[]{this});
            } else if (!PullToRefreshAttacher.this.p()) {
                if (getDecorView().getWindowToken() != null) {
                    PullToRefreshAttacher pullToRefreshAttacher = PullToRefreshAttacher.this;
                    pullToRefreshAttacher.c(pullToRefreshAttacher.f);
                    return;
                }
                start();
            }
        }

        public void start() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1418981547")) {
                ipChange.ipc$dispatch("1418981547", new Object[]{this});
                return;
            }
            getDecorView().post(this);
        }

        /* synthetic */ AddHeaderViewRunnable(PullToRefreshAttacher pullToRefreshAttacher, a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    public class a implements EnvironmentDelegate {
        private static transient /* synthetic */ IpChange $ipChange;

        a(PullToRefreshAttacher pullToRefreshAttacher) {
        }

        @Override // cn.damai.baseview.abcpullrefresh.library.EnvironmentDelegate
        public Context getContextForInflater(Activity activity) {
            ActionBar actionBar;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "330584219")) {
                return (Context) ipChange.ipc$dispatch("330584219", new Object[]{this, activity});
            }
            Context context = null;
            if (Build.VERSION.SDK_INT >= 14 && (actionBar = activity.getActionBar()) != null) {
                context = actionBar.getThemedContext();
            }
            return context == null ? activity : context;
        }
    }

    protected PullToRefreshAttacher(Activity activity, d dVar) {
        if (activity != null) {
            if (dVar == null) {
                nu2.d("PullToRefreshAttacher", "Given null options so using default options.");
                dVar = new d();
            }
            this.e = activity;
            this.r = new WeakHashMap<>();
            this.i = dVar.d;
            this.s = dVar.e;
            this.t = dVar.f;
            this.u = dVar.g;
            EnvironmentDelegate environmentDelegate = dVar.a;
            this.a = environmentDelegate == null ? h() : environmentDelegate;
            yu0 yu0 = dVar.c;
            this.b = yu0 == null ? i() : yu0;
            this.h = ViewConfiguration.get(activity).getScaledTouchSlop();
            View inflate = LayoutInflater.from(this.a.getContextForInflater(activity)).inflate(dVar.b, (ViewGroup) activity.getWindow().getDecorView(), false);
            this.f = inflate;
            if (inflate != null) {
                inflate.setVisibility(4);
                this.b.f(activity, this.f);
                AddHeaderViewRunnable addHeaderViewRunnable = new AddHeaderViewRunnable(this, null);
                this.y = addHeaderViewRunnable;
                addHeaderViewRunnable.start();
                return;
            }
            throw new IllegalArgumentException("Must supply valid layout id for header.");
        }
        throw new IllegalArgumentException("activity cannot be null");
    }

    private void A(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1498860246")) {
            ipChange.ipc$dispatch("-1498860246", new Object[]{this, Boolean.valueOf(z2)});
            return;
        }
        this.o = false;
        if (this.u) {
            m().removeCallbacks(this.z);
        }
        o();
    }

    private void H(View view, boolean z2, boolean z3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2004701607")) {
            ipChange.ipc$dispatch("2004701607", new Object[]{this, view, Boolean.valueOf(z2), Boolean.valueOf(z3)});
        } else if (!p() && this.o != z2) {
            B();
            if (!z2 || !e(z3)) {
                A(z3);
                return;
            }
            A(z3);
            J(view, z3);
        }
    }

    private void J(View view, boolean z2) {
        OnRefreshListener onRefreshListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "626219354")) {
            ipChange.ipc$dispatch("626219354", new Object[]{this, view, Boolean.valueOf(z2)});
            return;
        }
        this.o = true;
        if (z2 && (onRefreshListener = this.c) != null) {
            onRefreshListener.onRefreshStarted(view);
        }
        I();
        if (!this.u) {
            return;
        }
        if (this.t > 0) {
            m().postDelayed(this.z, (long) this.t);
        } else {
            m().post(this.z);
        }
    }

    private boolean e(boolean z2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1667235438")) {
            return !this.o && (!z2 || this.c != null);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1667235438", new Object[]{this, Boolean.valueOf(z2)})).booleanValue();
    }

    private boolean f(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1812872188")) {
            return ((Boolean) ipChange.ipc$dispatch("-1812872188", new Object[]{this, view})).booleanValue();
        } else if (!this.n || !this.s || view == null || this.k - this.l < n(view)) {
            return false;
        } else {
            H(view, true, true);
            return true;
        }
    }

    private float n(View view) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1784166227")) {
            return ((float) view.getHeight()) * this.i;
        }
        return ((Float) ipChange.ipc$dispatch("1784166227", new Object[]{this, view})).floatValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "164314414")) {
            return ((Boolean) ipChange.ipc$dispatch("164314414", new Object[]{this})).booleanValue();
        }
        if (this.v) {
            nu2.d("PullToRefreshAttacher", "PullToRefreshAttacher is destroyed.");
        }
        return this.v;
    }

    /* access modifiers changed from: package-private */
    public void B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880507487")) {
            ipChange.ipc$dispatch("-880507487", new Object[]{this});
            return;
        }
        this.n = false;
        this.p = false;
        this.l = -1.0f;
        this.k = -1.0f;
        this.j = -1.0f;
    }

    /* access modifiers changed from: package-private */
    public final void C(HeaderViewListener headerViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1309595593")) {
            ipChange.ipc$dispatch("1309595593", new Object[]{this, headerViewListener});
            return;
        }
        this.g = headerViewListener;
    }

    /* access modifiers changed from: package-private */
    public void D(OnLoadMoreListener onLoadMoreListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-155826668")) {
            ipChange.ipc$dispatch("-155826668", new Object[]{this, onLoadMoreListener});
            return;
        }
        this.d = onLoadMoreListener;
    }

    /* access modifiers changed from: package-private */
    public void E(OnRefreshListener onRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "952235459")) {
            ipChange.ipc$dispatch("952235459", new Object[]{this, onRefreshListener});
            return;
        }
        this.c = onRefreshListener;
    }

    /* access modifiers changed from: package-private */
    public final void F() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1522896159")) {
            ipChange.ipc$dispatch("1522896159", new Object[]{this});
            return;
        }
        H(null, false, false);
    }

    /* access modifiers changed from: package-private */
    public final void G(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-536160252")) {
            ipChange.ipc$dispatch("-536160252", new Object[]{this, Boolean.valueOf(z2)});
            return;
        }
        H(null, z2, false);
    }

    /* access modifiers changed from: package-private */
    public void I() {
        HeaderViewListener headerViewListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2114396990")) {
            ipChange.ipc$dispatch("-2114396990", new Object[]{this});
            return;
        }
        K(this.f);
        if (this.b.g() && (headerViewListener = this.g) != null) {
            headerViewListener.onStateChanged(this.f, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void K(View view) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970365147")) {
            ipChange.ipc$dispatch("-970365147", new Object[]{this, view});
            return;
        }
        this.e.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.x);
        WindowManager.LayoutParams layoutParams = null;
        if (view.getLayoutParams() instanceof WindowManager.LayoutParams) {
            layoutParams = (WindowManager.LayoutParams) view.getLayoutParams();
        } else if (view.getTag() instanceof WindowManager.LayoutParams) {
            layoutParams = (WindowManager.LayoutParams) view.getTag();
        }
        if (layoutParams != null && layoutParams.y != (i2 = this.x.top)) {
            layoutParams.y = i2;
            this.e.getWindowManager().updateViewLayout(view, layoutParams);
        }
    }

    /* access modifiers changed from: package-private */
    public void L(Class<?> cls, ViewDelegate viewDelegate) {
        WeakHashMap<View, ViewDelegate> weakHashMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1883755883")) {
            ipChange.ipc$dispatch("1883755883", new Object[]{this, cls, viewDelegate});
            return;
        }
        for (View view : this.r.keySet()) {
            if (!(!cls.isInstance(view) || (weakHashMap = this.r) == null || view == null)) {
                weakHashMap.put(view, viewDelegate);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c(View view) {
        int i2;
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1638843446")) {
            ipChange.ipc$dispatch("1638843446", new Object[]{this, view});
            return;
        }
        this.e.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.x);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i3 = layoutParams.width;
            i2 = layoutParams.height;
        } else {
            i3 = -1;
            i2 = -2;
        }
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i3, i2, 1000, ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE, -3);
        layoutParams2.x = 0;
        layoutParams2.y = this.x.top;
        layoutParams2.gravity = 48;
        view.setTag(layoutParams2);
        this.e.getWindowManager().addView(view, layoutParams2);
    }

    /* access modifiers changed from: package-private */
    public void d(View view, ViewDelegate viewDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1629846138")) {
            ipChange.ipc$dispatch("-1629846138", new Object[]{this, view, viewDelegate});
        } else if (!p()) {
            if (view == null) {
                nu2.d("PullToRefreshAttacher", "Refreshable View is null.");
                return;
            }
            if (viewDelegate == null) {
                viewDelegate = c.b(view);
            }
            this.r.put(view, viewDelegate);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-730137677")) {
            ipChange.ipc$dispatch("-730137677", new Object[]{this});
            return;
        }
        this.r.clear();
    }

    /* access modifiers changed from: protected */
    public EnvironmentDelegate h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-178528960")) {
            return new a(this);
        }
        return (EnvironmentDelegate) ipChange.ipc$dispatch("-178528960", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public yu0 i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1005927488")) {
            return new b();
        }
        return (yu0) ipChange.ipc$dispatch("-1005927488", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-326919329")) {
            ipChange.ipc$dispatch("-326919329", new Object[]{this});
        } else if (!this.v) {
            z(this.f);
            g();
            this.e = null;
            this.f = null;
            this.g = null;
            this.a = null;
            this.b = null;
            this.v = true;
        }
    }

    /* access modifiers changed from: protected */
    public final Activity k() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1622330888")) {
            return this.e;
        }
        return (Activity) ipChange.ipc$dispatch("-1622330888", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public yu0 l() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "906189551")) {
            return this.b;
        }
        return (yu0) ipChange.ipc$dispatch("906189551", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public final View m() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1703485651")) {
            return this.f;
        }
        return (View) ipChange.ipc$dispatch("1703485651", new Object[]{this});
    }

    /* access modifiers changed from: package-private */
    public void o() {
        HeaderViewListener headerViewListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "775451293")) {
            ipChange.ipc$dispatch("775451293", new Object[]{this});
        } else if (this.b.a() && (headerViewListener = this.g) != null) {
            headerViewListener.onStateChanged(this.f, 2);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean q() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1591006788")) {
            return this.o;
        }
        return ((Boolean) ipChange.ipc$dispatch("1591006788", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean r(View view, MotionEvent motionEvent) {
        ViewDelegate viewDelegate;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1540322716")) {
            return ((Boolean) ipChange.ipc$dispatch("1540322716", new Object[]{this, view, motionEvent})).booleanValue();
        }
        if (view.isShown() && this.r.containsKey(view)) {
            view.getLocationOnScreen(this.w);
            int[] iArr = this.w;
            int i2 = iArr[0];
            int i3 = iArr[1];
            this.x.set(i2, i3, view.getWidth() + i2, view.getHeight() + i3);
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (this.x.contains(rawX, rawY) && (viewDelegate = this.r.get(view)) != null) {
                Rect rect = this.x;
                return viewDelegate.isReadyForPull(view, (float) (rawX - rect.left), (float) (rawY - rect.top));
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "219329062")) {
            ipChange.ipc$dispatch("219329062", new Object[]{this});
        } else if (!p()) {
            this.b.d();
            HeaderViewListener headerViewListener = this.g;
            if (headerViewListener != null) {
                headerViewListener.onStateChanged(this.f, 1);
            }
        }
    }

    public void t(Configuration configuration) {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-726597860")) {
            ipChange.ipc$dispatch("-726597860", new Object[]{this, configuration});
            return;
        }
        yu0 yu0 = this.b;
        if (yu0 != null && (activity = this.e) != null && configuration != null) {
            yu0.b(activity, configuration);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (r2 != 3) goto L_0x009d;
     */
    public final boolean u(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1417065364")) {
            return ((Boolean) ipChange.ipc$dispatch("1417065364", new Object[]{this, motionEvent})).booleanValue();
        } else if (q()) {
            return false;
        } else {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (!this.n) {
                            float f2 = this.j;
                            if (f2 > 0.0f) {
                                float f3 = y2 - f2;
                                if (Math.abs(f3) > Math.abs(x2 - this.m) && f3 > ((float) this.h)) {
                                    this.n = true;
                                    x(y2);
                                } else if (f3 < ((float) (-this.h))) {
                                    B();
                                }
                            }
                        }
                    }
                }
                B();
            } else if (e(true)) {
                for (View view : this.r.keySet()) {
                    if (r(view, motionEvent)) {
                        this.m = x2;
                        this.j = y2;
                        this.q = view;
                    }
                }
            }
            return this.n;
        }
    }

    /* access modifiers changed from: package-private */
    public void v(View view, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448009275")) {
            ipChange.ipc$dispatch("1448009275", new Object[]{this, view, Float.valueOf(f2)});
            return;
        }
        float n2 = n(view);
        float f3 = f2 - this.l;
        if (f3 < n2) {
            this.b.c(f3 / n2);
        } else if (this.s) {
            this.b.e();
        } else {
            H(view, true, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1805078403")) {
            ipChange.ipc$dispatch("1805078403", new Object[]{this});
        } else if (!this.o) {
            A(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void x(float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1632557852")) {
            ipChange.ipc$dispatch("-1632557852", new Object[]{this, Float.valueOf(f2)});
            return;
        }
        I();
        this.l = f2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        if (r0 != 3) goto L_0x0085;
     */
    public final boolean y(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "873624336")) {
            return ((Boolean) ipChange.ipc$dispatch("873624336", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            this.p = true;
        }
        if (this.p && !this.n) {
            u(motionEvent);
            return true;
        } else if (this.q == null) {
            return false;
        } else {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    if (q()) {
                        return false;
                    }
                    float y2 = motionEvent.getY();
                    if (this.n) {
                        float f2 = this.k;
                        if (y2 != f2) {
                            float f3 = y2 - f2;
                            if (f3 >= ((float) (-this.h))) {
                                v(this.q, y2);
                                if (f3 > 0.0f) {
                                    this.k = y2;
                                }
                            } else {
                                w();
                                B();
                            }
                        }
                    }
                }
                return true;
            }
            f(this.q);
            if (this.n) {
                w();
            }
            B();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void z(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "94210704")) {
            ipChange.ipc$dispatch("94210704", new Object[]{this, view});
            return;
        }
        this.y.finish();
        if (view.getWindowToken() != null) {
            this.e.getWindowManager().removeViewImmediate(view);
        }
    }
}
