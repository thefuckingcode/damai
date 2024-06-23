package com.taobao.monitor.impl.processor.launcher;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.FrameMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.application.common.IAppLaunchListener;
import com.taobao.application.common.b;
import com.taobao.application.common.impl.a;
import com.taobao.monitor.impl.common.ProcessStart;
import com.taobao.monitor.impl.processor.AbsProcessor;
import com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher;
import com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher;
import com.taobao.monitor.impl.trace.ApplicationGCDispatcher;
import com.taobao.monitor.impl.trace.ApplicationLowMemoryDispatcher;
import com.taobao.monitor.impl.trace.FPSDispatcher;
import com.taobao.monitor.impl.trace.FragmentFunctionListener;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.ImageStageDispatcher;
import com.taobao.monitor.impl.trace.NetworkStageDispatcher;
import com.taobao.monitor.impl.trace.PageLeaveDispatcher;
import com.taobao.monitor.impl.trace.RenderDispatcher;
import com.taobao.monitor.impl.trace.WindowEventDispatcher;
import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.d;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.b0;
import tb.bt1;
import tb.dm2;
import tb.i4;
import tb.k3;
import tb.lc0;
import tb.ls2;
import tb.mn2;
import tb.on1;
import tb.qs0;
import tb.t32;
import tb.ts1;
import tb.us1;
import tb.ws0;
import tb.ws1;
import tb.xs1;
import tb.yn1;
import tb.zm2;
import tb.zq2;

/* compiled from: Taobao */
public class LauncherProcessor extends AbsProcessor implements ActivityLifeCycleDispatcher.IActivityLifeCycle, ApplicationBackgroundChangedDispatcher.BackgroundChangedListener, ApplicationGCDispatcher.ApplicationGCListener, ApplicationLowMemoryDispatcher.LowMemoryListener, FPSDispatcher.FPSListener, FragmentFunctionListener, ImageStageDispatcher.IImageStageListener, NetworkStageDispatcher.INetworkStageListener, PageLeaveDispatcher.PageLeaveListener, RenderDispatcher.PageRenderStandard, WindowEventDispatcher.OnEventListener {
    public static final String COLD = "COLD";
    public static final String HOT = "HOT";
    public static volatile String S = "COLD";
    public static boolean T = false;
    public static String U = "onlyPullProcess";
    public static final String WARM = "WARM";
    private String A = S;
    private volatile boolean B = false;
    IAppLaunchListener C = a.g().d();
    private boolean D = true;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private boolean M = true;
    private Map<String, Long> N = new HashMap();
    private boolean O = true;
    private boolean P = true;
    private boolean Q = true;
    private boolean R = false;
    protected String d;
    private String e;
    private IProcedure f;
    private IDispatcher g;
    private IDispatcher h;
    private IDispatcher i;
    private IDispatcher j;
    private IDispatcher k;
    private IDispatcher l;
    private IDispatcher m;
    private IDispatcher n;
    private IDispatcher o;
    private IDispatcher p;
    private IDispatcher q;
    private List<String> r = new ArrayList(4);
    private List<String> s = new ArrayList(4);
    private List<Integer> t = new ArrayList();
    private int u = 0;
    private int v = 0;
    private long w;
    private boolean x = false;
    private long[] y;
    private HashMap<String, Integer> z = new HashMap<>();

    public LauncherProcessor() {
        super(false);
        d();
    }

    private void h() {
        this.w = COLD.equals(S) ? ws0.j : dm2.a();
        this.f.addProperty("errorCode", 1);
        this.f.addProperty("launchType", S);
        this.f.addProperty("isFirstInstall", Boolean.valueOf(ws0.b));
        this.f.addProperty("isFirstLaunch", Boolean.valueOf(ws0.d));
        this.f.addProperty("installType", ws0.g);
        this.f.addProperty("oppoCPUResource", ws0.l);
        this.f.addProperty("leaveType", "other");
        this.f.addProperty("lastProcessStartTime", Long.valueOf(ws0.k));
        this.f.addProperty("systemInitDuration", Long.valueOf(ws0.j - ws0.i));
        this.f.addProperty("timestampInterval", Long.valueOf(System.currentTimeMillis() - SystemClock.uptimeMillis()));
        this.f.addProperty("channelExistWhenLaunch", Boolean.valueOf(bt1.b()));
        this.f.stage("processStartTime", ws0.i);
        this.f.stage("launchStartTime", ws0.j);
        ws0.b = false;
        ws0.d = false;
        if (WARM.equals(S)) {
            this.f.addProperty("warnType", U);
        }
    }

    private void j() {
        if (!this.B) {
            this.C.onLaunchChanged(!this.A.equals(COLD), 4);
            this.B = true;
        }
    }

    private int k() {
        return !this.A.equals(COLD);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.monitor.impl.processor.AbsProcessor
    public void d() {
        super.d();
        this.y = mn2.a();
        IProcedure launcherProcedure = ws1.b.getLauncherProcedure();
        this.f = launcherProcedure;
        if (launcherProcedure == null || !launcherProcedure.isAlive()) {
            IProcedure createProcedure = ts1.b.createProcedure(zm2.a("/startup"), new d.b().g(false).k(true).j(lc0.E).i(true).h(null).f());
            this.f = createProcedure;
            createProcedure.begin();
            us1.PROCEDURE_MANAGER.s(this.f);
            SharedPreferences.Editor edit = qs0.e().a().getSharedPreferences(xs1.DEFAULT_SAVE_DIR, 0).edit();
            edit.putString(ls2.KEY_LAST_LAUNCH_SESSION, this.f.topicSession());
            edit.apply();
        }
        this.f.stage("procedureStartTime", dm2.a());
        this.g = a(b0.WINDOW_EVENT_DISPATCHER);
        this.h = a(b0.APPLICATION_LOW_MEMORY_DISPATCHER);
        this.i = a(b0.PAGE_RENDER_DISPATCHER);
        this.j = a(b0.ACTIVITY_FPS_DISPATCHER);
        this.k = a(b0.APPLICATION_GC_DISPATCHER);
        this.l = a(b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER);
        this.m = a(b0.NETWORK_STAGE_DISPATCHER);
        this.n = a(b0.IMAGE_STAGE_DISPATCHER);
        this.o = a(b0.FRAGMENT_LIFECYCLE_FUNCTION_DISPATCHER);
        this.p = a(b0.PAGE_RENDER_DISPATCHER);
        this.q = a(b0.PAGE_LEAVE_DISPATCHER);
        this.h.addListener(this);
        this.j.addListener(this);
        this.k.addListener(this);
        this.g.addListener(this);
        this.i.addListener(this);
        this.l.addListener(this);
        this.m.addListener(this);
        this.n.addListener(this);
        this.o.addListener(this);
        this.p.addListener(this);
        this.q.addListener(this);
        h();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.monitor.impl.processor.AbsProcessor
    public void e() {
        if (!this.R) {
            this.R = true;
            j();
            if (this.D) {
                this.f.addProperty("utSession", zq2.a().getUtsid());
            }
            if (!TextUtils.isEmpty(this.d)) {
                this.f.addProperty("currentPageName", this.d.substring(this.d.lastIndexOf(".") + 1));
                this.f.addProperty("fullPageName", this.d);
                try {
                    if (!TextUtils.isEmpty(this.d) && this.N.containsKey(this.d)) {
                        long longValue = this.N.get(this.d).longValue();
                        this.f.addProperty("appInitDuration", Long.valueOf(longValue - this.w));
                        this.f.stage("renderStartTime", longValue);
                    }
                } catch (Exception unused) {
                }
            }
            this.N.clear();
            this.f.addProperty("processStartType", Integer.valueOf(ProcessStart.a()));
            this.f.addProperty("linkPageName", this.r.toString());
            this.f.addProperty("linkPageUrl", this.s.toString());
            this.r.clear();
            this.s.clear();
            this.f.addProperty("deviceLevel", Integer.valueOf(b.d().getInt("deviceLevel", -1)));
            this.f.addProperty("runtimeLevel", Integer.valueOf(i4.d().f().d));
            this.f.addProperty("cpuUsageOfDevcie", Float.valueOf(i4.d().b().d));
            this.f.addProperty("memoryRuntimeLevel", Integer.valueOf(i4.d().e().k));
            this.f.addProperty("hasSplash", Boolean.valueOf(ws0.c));
            this.f.addStatistic("gcCount", Integer.valueOf(this.v));
            this.f.addStatistic("fps", this.t.toString());
            this.f.addStatistic("jankCount", Integer.valueOf(this.u));
            this.f.addStatistic("image", Integer.valueOf(this.E));
            this.f.addStatistic("imageOnRequest", Integer.valueOf(this.E));
            this.f.addStatistic("imageSuccessCount", Integer.valueOf(this.F));
            this.f.addStatistic("imageFailedCount", Integer.valueOf(this.G));
            this.f.addStatistic("imageCanceledCount", Integer.valueOf(this.H));
            this.f.addStatistic("network", Integer.valueOf(this.I));
            this.f.addStatistic("networkOnRequest", Integer.valueOf(this.I));
            this.f.addStatistic("networkSuccessCount", Integer.valueOf(this.J));
            this.f.addStatistic("networkFailedCount", Integer.valueOf(this.K));
            this.f.addStatistic("networkCanceledCount", Integer.valueOf(this.L));
            long[] a = mn2.a();
            this.f.addStatistic("totalRx", Long.valueOf(a[0] - this.y[0]));
            this.f.addStatistic("totalTx", Long.valueOf(a[1] - this.y[1]));
            this.f.stage("procedureEndTime", dm2.a());
            ws0.c = false;
            this.l.removeListener(this);
            this.h.removeListener(this);
            this.k.removeListener(this);
            this.j.removeListener(this);
            this.g.removeListener(this);
            this.i.removeListener(this);
            this.n.removeListener(this);
            this.m.removeListener(this);
            this.o.removeListener(this);
            this.p.removeListener(this);
            this.q.removeListener(this);
            this.f.end();
            super.e();
        }
    }

    @Override // com.taobao.monitor.impl.trace.FPSDispatcher.FPSListener
    public void frameDataPerSecond(int i2, int i3, int i4, int i5, List<FrameMetrics> list) {
        if (this.t.size() < 200) {
            this.t.add(Integer.valueOf(i2));
            this.u += i3;
        }
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationGCDispatcher.ApplicationGCListener
    public void gc() {
        this.v++;
    }

    /* access modifiers changed from: protected */
    public boolean i(Activity activity) {
        return k3.b(activity).equals(this.d);
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityCreated(Activity activity, Map<String, Object> map, long j2) {
        String d2 = k3.d(activity);
        this.e = k3.b(activity);
        String b = t32.b(map.get("schemaUrl"), "");
        if (!this.x) {
            this.f.addProperty("systemRecovery", Boolean.FALSE);
            if (COLD.equals(S) && this.e.equals(ws0.e)) {
                this.f.addProperty("systemRecovery", Boolean.TRUE);
                this.d = this.e;
                this.r.add(d2);
            }
            Object obj = map.get("outLink");
            if (obj != null) {
                this.f.addProperty("outLink", obj);
            }
            Object obj2 = map.get("blackPage");
            if (obj2 != null) {
                this.f.addProperty("blackPage", obj2);
            }
            if (!TextUtils.isEmpty(b)) {
                this.f.addProperty("schemaUrl", b);
            }
            this.f.addProperty("firstPageName", d2);
            this.f.stage("firstPageCreateTime", j2);
            this.A = S;
            S = HOT;
            this.x = true;
        }
        if (this.r.size() < 10) {
            if (TextUtils.isEmpty(this.d)) {
                this.r.add(d2);
            }
            if (!TextUtils.isEmpty(b)) {
                this.s.add(b);
            }
        }
        if (TextUtils.isEmpty(this.d) && !yn1.e(this.e) && (yn1.k() || yn1.i(this.e))) {
            this.d = this.e;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("timestamp", Long.valueOf(j2));
        hashMap.put("pageName", d2);
        this.f.event(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED, hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityDestroyed(Activity activity, long j2) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("timestamp", Long.valueOf(j2));
        hashMap.put("pageName", k3.d(activity));
        this.f.event(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED, hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityPaused(Activity activity, long j2) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("timestamp", Long.valueOf(j2));
        hashMap.put("pageName", k3.d(activity));
        this.f.event(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED, hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityResumed(Activity activity, long j2) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("timestamp", Long.valueOf(j2));
        hashMap.put("pageName", k3.d(activity));
        this.f.event(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED, hashMap);
        if (this.D && !TextUtils.isEmpty(zq2.a().getUtsid())) {
            qs0.e().d().post(new Runnable() {
                /* class com.taobao.monitor.impl.processor.launcher.LauncherProcessor.AnonymousClass1 */

                public void run() {
                    LauncherProcessor.this.f.addProperty("utSession", zq2.a().getUtsid());
                    LauncherProcessor.this.D = false;
                }
            });
        }
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityStarted(Activity activity, long j2) {
        if (HOT.equals(S) && !this.x) {
            this.x = true;
            String b = k3.b(activity);
            this.e = b;
            this.d = b;
            if (activity.getIntent() != null && !TextUtils.isEmpty(activity.getIntent().getDataString())) {
                this.f.addProperty("schemaUrl", activity.getIntent().getDataString());
            }
            this.f.addProperty("firstPageName", k3.b(activity));
            this.f.stage("firstPageCreateTime", j2);
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("timestamp", Long.valueOf(j2));
        hashMap.put("pageName", k3.d(activity));
        this.f.event(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STARTED, hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityStopped(Activity activity, long j2) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("timestamp", Long.valueOf(j2));
        hashMap.put("pageName", k3.d(activity));
        this.f.event(Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STOPPED, hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher.BackgroundChangedListener
    public void onChanged(int i2, long j2) {
        if (i2 == 1) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("timestamp", Long.valueOf(j2));
            this.f.event("foreground2Background", hashMap);
        }
    }

    @Override // com.taobao.monitor.impl.trace.FragmentFunctionListener
    public void onFunction(Activity activity, Fragment fragment, String str, long j2) {
        int i2;
        if (fragment != null && activity != null && TextUtils.equals(activity.getClass().getName(), this.e)) {
            String str2 = fragment.getClass().getSimpleName() + JSMethod.NOT_SET + str;
            Integer num = this.z.get(str2);
            if (num == null) {
                i2 = 0;
            } else {
                i2 = Integer.valueOf(num.intValue() + 1);
            }
            this.z.put(str2, i2);
            this.f.stage(str2 + i2, j2);
        }
    }

    @Override // com.taobao.monitor.impl.trace.ImageStageDispatcher.IImageStageListener
    public void onImageStage(int i2) {
        if (i2 == 0) {
            this.E++;
        } else if (i2 == 1) {
            this.F++;
        } else if (i2 == 2) {
            this.G++;
        } else if (i2 == 3) {
            this.H++;
        }
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onKey(Activity activity, KeyEvent keyEvent, long j2) {
        int action = keyEvent.getAction();
        int keyCode = keyEvent.getKeyCode();
        if (action != 0) {
            return;
        }
        if (keyCode == 4 || keyCode == 3) {
            if (TextUtils.isEmpty(this.d)) {
                this.d = k3.b(activity);
                if (activity != null) {
                    try {
                        if (this.N.containsKey(k3.b(activity))) {
                            long longValue = this.N.get(activity.getClass().getName()).longValue();
                            this.f.addProperty("appInitDuration", Long.valueOf(longValue - this.w));
                            this.f.stage("renderStartTime", longValue);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            HashMap hashMap = new HashMap(2);
            hashMap.put("timestamp", Long.valueOf(j2));
            hashMap.put("key", Integer.valueOf(keyEvent.getKeyCode()));
            this.f.event("keyEvent", hashMap);
        }
    }

    @Override // com.taobao.monitor.impl.trace.PageLeaveDispatcher.PageLeaveListener
    public void onLeave(on1 on1, int i2) {
        if (on1 != null && on1.t() && i(on1.a())) {
            this.f.stage("leaveTime", dm2.a());
            if (i2 == -5) {
                this.f.addProperty("leaveType", "jumpNextPage");
            } else if (i2 == -4) {
                this.f.addProperty("leaveType", "back");
            }
            b();
        }
        if (i2 == -3) {
            this.f.stage("leaveTime", dm2.a());
            this.f.addProperty("leaveType", "F2B");
            b();
        }
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationLowMemoryDispatcher.LowMemoryListener
    public void onLowMemory() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("timestamp", Long.valueOf(dm2.a()));
        this.f.event("onLowMemory", hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.NetworkStageDispatcher.INetworkStageListener
    public void onNetworkStage(int i2) {
        if (i2 == 0) {
            this.I++;
        } else if (i2 == 1) {
            this.J++;
        } else if (i2 == 2) {
            this.K++;
        } else if (i2 == 3) {
            this.L++;
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageInteractive(on1 on1, long j2) {
        Activity a;
        if (this.P && (a = on1.a()) != null && i(a)) {
            this.f.addProperty("interactiveDuration", Long.valueOf(j2 - this.w));
            this.f.addProperty("launchDuration", Long.valueOf(j2 - this.w));
            this.f.stage("interactiveTime", j2);
            this.C.onLaunchChanged(k(), 2);
            j();
            this.P = false;
            if (on1.l() != null) {
                onPageLoadError(on1, 0);
                this.f.addProperty("errorCode", 0);
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageLoadError(on1 on1, int i2) {
        Activity a = on1.a();
        if (this.Q && a != null && i(a)) {
            this.f.addProperty("errorCode", Integer.valueOf(i2));
            this.Q = false;
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageRenderPercent(on1 on1, float f2, long j2) {
        Activity a = on1.a();
        if (a != null && i(a)) {
            this.f.addProperty("onRenderPercent", Float.valueOf(f2));
            this.f.addProperty("drawPercentTime", Long.valueOf(j2));
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageRenderStart(on1 on1, long j2) {
        Activity a = on1.a();
        String h2 = on1.h();
        if (!TextUtils.isEmpty(h2) && a != null && !this.N.containsKey(h2)) {
            this.N.put(on1.h(), Long.valueOf(j2));
            if (i(a)) {
                this.f.addProperty("appInitDuration", Long.valueOf(j2 - this.w));
                this.f.stage("renderStartTime", j2);
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageVisible(on1 on1, long j2) {
        Activity a = on1.a();
        if (a != null && this.O) {
            if (!yn1.e(this.e) && TextUtils.isEmpty(this.d)) {
                this.d = this.e;
            }
            if (i(a)) {
                this.f.addProperty("displayDuration", Long.valueOf(j2 - this.w));
                this.f.stage("displayedTime", j2);
                this.f.stage("firstScreenPaint", j2);
                this.C.onLaunchChanged(k(), 1);
                this.O = false;
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onTouch(Activity activity, MotionEvent motionEvent, long j2) {
        if (this.M && !yn1.e(k3.b(activity))) {
            if (TextUtils.isEmpty(this.d)) {
                String b = k3.b(activity);
                this.d = b;
                try {
                    if (!TextUtils.isEmpty(b) && this.N.containsKey(this.d)) {
                        long longValue = this.N.get(this.d).longValue();
                        this.f.addProperty("appInitDuration", Long.valueOf(longValue - this.w));
                        this.f.stage("renderStartTime", longValue);
                    }
                } catch (Exception unused) {
                }
            }
            if (i(activity)) {
                this.f.stage("firstInteractiveTime", j2);
                this.f.addProperty("firstInteractiveDuration", Long.valueOf(j2 - this.w));
                this.M = false;
            }
        }
    }

    public LauncherProcessor(String str) {
        super(false);
        S = str;
        this.A = str;
        d();
    }
}
