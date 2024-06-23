package tb;

import android.os.SystemClock;
import android.view.FrameMetrics;
import com.taobao.application.common.b;
import com.taobao.monitor.impl.processor.AbsProcessor;
import com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher;
import com.taobao.monitor.impl.trace.ApplicationGCDispatcher;
import com.taobao.monitor.impl.trace.ApplicationLowMemoryDispatcher;
import com.taobao.monitor.impl.trace.FPSDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.ImageStageDispatcher;
import com.taobao.monitor.impl.trace.NetworkStageDispatcher;
import com.taobao.monitor.impl.trace.RenderDispatcher;
import com.taobao.monitor.performance.IWXApmAdapter;
import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class kz2 extends AbsProcessor implements ApplicationBackgroundChangedDispatcher.BackgroundChangedListener, ApplicationGCDispatcher.ApplicationGCListener, ApplicationLowMemoryDispatcher.LowMemoryListener, FPSDispatcher.FPSListener, ImageStageDispatcher.IImageStageListener, NetworkStageDispatcher.INetworkStageListener, RenderDispatcher.PageRenderStandard, IWXApmAdapter {
    private boolean A = true;
    private final IProcedure d;
    private IDispatcher e;
    private IDispatcher f;
    private IDispatcher g;
    private IDispatcher h;
    private IDispatcher i;
    private IDispatcher j;
    private List<Integer> k = new ArrayList();
    private int l = 0;
    private int m = 0;
    private boolean n = true;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private boolean w = false;
    private long x;
    private boolean y = true;
    private boolean z = true;

    public kz2(String str) {
        super(false);
        d f2 = new d.b().g(true).k(true).i(true).h(lc0.s ? ws1.b.getCurrentActivityProcedure() : null).f();
        ts1 ts1 = ts1.b;
        this.d = ts1.createProcedure(zm2.a("/" + str), f2);
        this.e = a(b0.WINDOW_EVENT_DISPATCHER);
        this.f = a(b0.APPLICATION_LOW_MEMORY_DISPATCHER);
        this.g = a(b0.ACTIVITY_FPS_DISPATCHER);
        this.h = a(b0.APPLICATION_GC_DISPATCHER);
        this.i = a(b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER);
        this.j = a(b0.PAGE_RENDER_DISPATCHER);
    }

    @Override // com.taobao.monitor.performance.IWXApmAdapter
    public void addBiz(String str, Map<String, Object> map) {
        this.d.addBiz(str, map);
    }

    @Override // com.taobao.monitor.performance.IWXApmAdapter
    public void addBizAbTest(String str, Map<String, Object> map) {
        this.d.addBizAbTest(str, map);
    }

    @Override // com.taobao.monitor.performance.IWXApmAdapter
    public void addBizStage(String str, Map<String, Object> map) {
        this.d.addBizStage(str, map);
    }

    @Override // com.taobao.monitor.performance.IWXApmAdapter
    public void addProperty(String str, Object obj) {
        this.d.addProperty(str, obj);
    }

    @Override // com.taobao.monitor.performance.IWXApmAdapter
    public void addStatistic(String str, double d2) {
        this.d.addStatistic(str, Double.valueOf(d2));
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.monitor.impl.processor.AbsProcessor
    public void d() {
        super.d();
        this.x = dm2.a();
        this.d.begin();
        this.d.addProperty("timestampInterval", Long.valueOf(System.currentTimeMillis() - SystemClock.uptimeMillis()));
        this.d.stage("procedureStartTime", dm2.a());
        this.h.addListener(this);
        this.f.addListener(this);
        this.e.addListener(this);
        this.g.addListener(this);
        this.i.addListener(this);
        this.j.addListener(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.monitor.impl.processor.AbsProcessor
    public void e() {
        if (!this.w) {
            this.d.stage("procedureEndTime", dm2.a());
            this.d.addStatistic("gcCount", Integer.valueOf(this.m));
            this.d.addStatistic("fps", this.k.toString());
            this.d.addStatistic("jankCount", Integer.valueOf(this.l));
            this.d.addProperty("deviceLevel", Integer.valueOf(b.d().getInt("deviceLevel", -1)));
            this.d.addProperty("runtimeLevel", Integer.valueOf(i4.d().f().d));
            this.d.addProperty("cpuUsageOfDevcie", Float.valueOf(i4.d().b().d));
            this.d.addProperty("memoryRuntimeLevel", Integer.valueOf(i4.d().e().k));
            this.d.addStatistic("imgLoadCount", Integer.valueOf(this.o));
            this.d.addStatistic("imgLoadSuccessCount", Integer.valueOf(this.p));
            this.d.addStatistic("imgLoadFailCount", Integer.valueOf(this.q));
            this.d.addStatistic("imgLoadCancelCount", Integer.valueOf(this.r));
            this.d.addStatistic("networkRequestCount", Integer.valueOf(this.s));
            this.d.addStatistic("networkRequestSuccessCount", Integer.valueOf(this.t));
            this.d.addStatistic("networkRequestFailCount", Integer.valueOf(this.u));
            this.d.addStatistic("networkRequestCancelCount", Integer.valueOf(this.v));
            this.f.removeListener(this);
            this.e.removeListener(this);
            this.g.removeListener(this);
            this.h.removeListener(this);
            this.i.removeListener(this);
            this.j.removeListener(this);
            this.d.end();
            super.e();
        }
        this.w = true;
    }

    @Override // com.taobao.monitor.impl.trace.FPSDispatcher.FPSListener
    public void frameDataPerSecond(int i2, int i3, int i4, int i5, List<FrameMetrics> list) {
        if (this.k.size() < 200 && this.n) {
            this.l += i3;
            this.k.add(Integer.valueOf(i2));
        }
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationGCDispatcher.ApplicationGCListener
    public void gc() {
        this.m++;
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher.BackgroundChangedListener
    public void onChanged(int i2, long j2) {
        if (i2 == 1) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("timestamp", Long.valueOf(j2));
            this.d.event("foreground2Background", hashMap);
            if (lc0.t) {
                b();
                return;
            }
            return;
        }
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("timestamp", Long.valueOf(j2));
        this.d.event("background2Foreground", hashMap2);
    }

    @Override // com.taobao.monitor.performance.IWXApmAdapter
    public void onEnd() {
        e();
    }

    @Override // com.taobao.monitor.performance.IWXApmAdapter
    public void onEvent(String str, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, obj);
        this.d.event(str, hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.ImageStageDispatcher.IImageStageListener
    public void onImageStage(int i2) {
        if (!this.n) {
            return;
        }
        if (i2 == 0) {
            this.o++;
        } else if (i2 == 1) {
            this.p++;
        } else if (i2 == 2) {
            this.q++;
        } else if (i2 == 3) {
            this.r++;
        }
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationLowMemoryDispatcher.LowMemoryListener
    public void onLowMemory() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("timestamp", Long.valueOf(dm2.a()));
        this.d.event("onLowMemory", hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.NetworkStageDispatcher.INetworkStageListener
    public void onNetworkStage(int i2) {
        if (!this.n) {
            return;
        }
        if (i2 == 0) {
            this.s++;
        } else if (i2 == 1) {
            this.t++;
        } else if (i2 == 2) {
            this.u++;
        } else if (i2 == 3) {
            this.v++;
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageInteractive(on1 on1, long j2) {
        if (this.A && this.n && on1.t()) {
            this.d.addProperty("interactiveDuration", Long.valueOf(j2 - this.x));
            this.d.addProperty("loadDuration", Long.valueOf(j2 - this.x));
            this.d.stage("interactiveTime", j2);
            this.A = false;
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageLoadError(on1 on1, int i2) {
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageRenderPercent(on1 on1, float f2, long j2) {
        if (this.n && on1.t()) {
            this.d.addProperty("onRenderPercent", Float.valueOf(f2));
            this.d.addProperty("drawPercentTime", Long.valueOf(j2));
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageRenderStart(on1 on1, long j2) {
        if (this.y && this.n && on1.t()) {
            this.d.addProperty("pageInitDuration", Long.valueOf(j2 - this.x));
            this.d.stage("renderStartTime", j2);
            this.y = false;
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageVisible(on1 on1, long j2) {
        if (this.z && this.n && on1.t()) {
            this.d.addProperty("displayDuration", Long.valueOf(j2 - this.x));
            this.d.stage("displayedTime", j2);
            this.z = false;
        }
    }

    @Override // com.taobao.monitor.performance.IWXApmAdapter
    public void onStage(String str, long j2) {
        this.d.stage(str, j2);
    }

    @Override // com.taobao.monitor.performance.IWXApmAdapter
    public void onStart(String str) {
        d();
        this.d.addProperty("instanceId", str);
    }

    @Override // com.taobao.monitor.performance.IWXApmAdapter
    public void onStop() {
        this.n = false;
    }

    @Override // com.taobao.monitor.performance.IWXApmAdapter
    public void onStart() {
        this.n = true;
    }
}
