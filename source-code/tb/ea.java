package tb;

import android.view.FrameMetrics;
import com.taobao.monitor.impl.processor.AbsProcessor;
import com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher;
import com.taobao.monitor.impl.trace.ApplicationGCDispatcher;
import com.taobao.monitor.impl.trace.ApplicationLowMemoryDispatcher;
import com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher;
import com.taobao.monitor.impl.trace.FPSDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.ImageStageDispatcher;
import com.taobao.monitor.impl.trace.NetworkStageDispatcher;
import com.taobao.monitor.impl.trace.PageLeaveDispatcher;
import com.taobao.monitor.impl.trace.RenderDispatcher;
import com.taobao.monitor.impl.trace.WindowEventDispatcher;
import com.taobao.monitor.procedure.IPage;
import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public abstract class ea extends AbsProcessor implements ApplicationBackgroundChangedDispatcher.BackgroundChangedListener, ApplicationGCDispatcher.ApplicationGCListener, ApplicationLowMemoryDispatcher.LowMemoryListener, CustomPageLifecycleDispatcher.CustomPageLifecycle, FPSDispatcher.FPSListener, ImageStageDispatcher.IImageStageListener, NetworkStageDispatcher.INetworkStageListener, PageLeaveDispatcher.PageLeaveListener, RenderDispatcher.PageRenderStandard, WindowEventDispatcher.OnEventListener, IPage.PageBeginStandard, IPage.PageDataSetter, IPage.PageLifecycleCallback, IPage.PageRenderStandard {
    protected int A;
    protected int B;
    protected int C;
    protected final List<FrameMetrics> D;
    protected int E;
    protected final on1 d;
    protected IProcedure e;
    protected CustomPageLifecycleDispatcher f;
    private WindowEventDispatcher g;
    private ApplicationLowMemoryDispatcher h;
    private FPSDispatcher i;
    private ApplicationGCDispatcher j;
    private ApplicationBackgroundChangedDispatcher k;
    private NetworkStageDispatcher l;
    private ImageStageDispatcher m;
    private RenderDispatcher n;
    private PageLeaveDispatcher o;
    protected boolean p;
    protected boolean q;
    protected int r;
    protected int s;
    protected int t;
    protected int u;
    protected int v;
    protected int w;
    protected int x;
    protected int y;
    protected final List<Integer> z;

    public ea() {
        this.p = true;
        this.q = true;
        this.z = new ArrayList();
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = new ArrayList();
        this.E = 0;
        this.d = new on1();
    }

    @Override // com.taobao.monitor.procedure.IPage.PageDataSetter
    public void addProperty(String str, Object obj) {
        this.e.addProperty(str, obj);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.monitor.impl.processor.AbsProcessor
    public void e() {
        super.e();
        if (!e90.c(this.f)) {
            this.f.removeListener(this);
        }
        if (!e90.c(this.h)) {
            this.h.removeListener(this);
        }
        if (!e90.c(this.g)) {
            this.g.removeListener(this);
        }
        if (!e90.c(this.i)) {
            this.i.removeListener(this);
        }
        if (!e90.c(this.j)) {
            this.j.removeListener(this);
        }
        if (!e90.c(this.k)) {
            this.k.removeListener(this);
        }
        if (!e90.c(this.m)) {
            this.m.removeListener(this);
        }
        if (!e90.c(this.l)) {
            this.l.removeListener(this);
        }
        if (!e90.c(this.n)) {
            this.n.removeListener(this);
        }
        if (!e90.c(this.o)) {
            this.o.removeListener(this);
        }
        us1.PROCEDURE_MANAGER.p(this.d);
    }

    /* access modifiers changed from: protected */
    public abstract String f();

    @Override // com.taobao.monitor.impl.trace.FPSDispatcher.FPSListener
    public void frameDataPerSecond(int i2, int i3, int i4, int i5, List<FrameMetrics> list) {
        if (this.z.size() < 200 && this.q) {
            this.C += i3;
            this.A += i4;
            this.B += i5;
            this.z.add(Integer.valueOf(i2));
            if (this.D.size() <= 200 && list != null) {
                this.D.addAll(list);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void g() {
        IDispatcher a = a(b0.WINDOW_EVENT_DISPATCHER);
        if (a instanceof WindowEventDispatcher) {
            this.g = (WindowEventDispatcher) a;
        }
        IDispatcher a2 = a(b0.APPLICATION_LOW_MEMORY_DISPATCHER);
        if (a2 instanceof ApplicationLowMemoryDispatcher) {
            this.h = (ApplicationLowMemoryDispatcher) a2;
        }
        IDispatcher a3 = a(b0.ACTIVITY_FPS_DISPATCHER);
        if (a3 instanceof FPSDispatcher) {
            this.i = (FPSDispatcher) a3;
        }
        IDispatcher a4 = a(b0.APPLICATION_GC_DISPATCHER);
        if (a4 instanceof ApplicationGCDispatcher) {
            this.j = (ApplicationGCDispatcher) a4;
        }
        IDispatcher a5 = a(b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER);
        if (a5 instanceof ApplicationBackgroundChangedDispatcher) {
            this.k = (ApplicationBackgroundChangedDispatcher) a5;
        }
        IDispatcher a6 = a(b0.NETWORK_STAGE_DISPATCHER);
        if (a6 instanceof NetworkStageDispatcher) {
            this.l = (NetworkStageDispatcher) a6;
        }
        IDispatcher a7 = a(b0.IMAGE_STAGE_DISPATCHER);
        if (a7 instanceof ImageStageDispatcher) {
            this.m = (ImageStageDispatcher) a7;
        }
        IDispatcher a8 = a(b0.PAGE_RENDER_DISPATCHER);
        if (a8 instanceof RenderDispatcher) {
            this.n = (RenderDispatcher) a8;
        }
        IDispatcher a9 = a(b0.PAGE_LEAVE_DISPATCHER);
        if (a9 instanceof PageLeaveDispatcher) {
            this.o = (PageLeaveDispatcher) a9;
        }
        if (!e90.c(this.j)) {
            this.j.addListener(this);
        }
        if (!e90.c(this.h)) {
            this.h.addListener(this);
        }
        if (!e90.c(this.g)) {
            this.g.addListener(this);
        }
        if (!e90.c(this.i)) {
            this.i.addListener(this);
        }
        if (!e90.c(this.k)) {
            this.k.addListener(this);
        }
        if (!e90.c(this.l)) {
            this.l.addListener(this);
        }
        if (!e90.c(this.m)) {
            this.m.addListener(this);
        }
        if (!e90.c(this.n)) {
            this.n.addListener(this);
        }
        if (!e90.c(this.o)) {
            this.o.addListener(this);
        }
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationGCDispatcher.ApplicationGCListener
    public void gc() {
        if (this.q) {
            this.E++;
        }
    }

    /* access modifiers changed from: protected */
    public void h() {
        IProcedure createProcedure = ts1.b.createProcedure(zm2.a(f()), new d.b().g(false).k(true).i(true).h(null).f());
        this.e = createProcedure;
        createProcedure.begin();
        if (this.d.a() != null) {
            us1.PROCEDURE_MANAGER.l(this.d.a(), this.d, this.e);
        } else if (this.d.e() != null) {
            us1.PROCEDURE_MANAGER.n(this.d.e(), this.d, this.e);
        } else {
            us1.PROCEDURE_MANAGER.o(this.d, this.e);
        }
    }

    /* access modifiers changed from: protected */
    public boolean i(on1 on1) {
        return on1 != null && on1 == this.d;
    }

    /* access modifiers changed from: protected */
    public void j(String str) {
    }

    public void k(boolean z2) {
        this.p = z2;
    }

    /* access modifiers changed from: protected */
    public void l() {
        IDispatcher b = e90.b(b0.CUSTOM_PAGE_LIFECYCLE_DISPATCHER);
        if (b instanceof CustomPageLifecycleDispatcher) {
            this.f = (CustomPageLifecycleDispatcher) b;
        }
        if (!e90.c(this.f)) {
            this.f.addListener(this);
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageDataSetter
    public void onEvent(String str, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        hashMap.put("ext", obj);
        this.e.event(str, hashMap);
    }

    @Override // com.taobao.monitor.impl.trace.ImageStageDispatcher.IImageStageListener
    public void onImageStage(int i2) {
        if (!this.q) {
            return;
        }
        if (i2 == 0) {
            this.r++;
        } else if (i2 == 1) {
            this.s++;
        } else if (i2 == 2) {
            this.t++;
        } else if (i2 == 3) {
            this.u++;
        }
    }

    @Override // com.taobao.monitor.impl.trace.PageLeaveDispatcher.PageLeaveListener
    public void onLeave(on1 on1, int i2) {
        if (!i(on1)) {
            return;
        }
        if (i2 == -5) {
            j("jumpNextPage");
        } else if (i2 == -4) {
            j("back");
            b();
        } else if (i2 == -3) {
            j("F2B");
            b();
        }
    }

    @Override // com.taobao.monitor.impl.trace.NetworkStageDispatcher.INetworkStageListener
    public void onNetworkStage(int i2) {
        if (!this.q) {
            return;
        }
        if (i2 == 0) {
            this.v++;
        } else if (i2 == 1) {
            this.w++;
        } else if (i2 == 2) {
            this.x++;
        } else if (i2 == 3) {
            this.y++;
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageAppear(on1 on1) {
        if (i(on1)) {
            this.q = true;
            onPageAppear();
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageCreate(on1 on1, Map<String, Object> map) {
        if (i(on1)) {
            g();
            d();
            onPageCreate(on1.m(), on1.p(), map);
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageDestroy(on1 on1) {
        if (i(on1)) {
            onPageDestroy();
            b();
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageDisappear(on1 on1) {
        if (i(on1)) {
            this.q = false;
            onPageDisappear();
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageInteractive(on1 on1, long j2) {
        if (this.p && i(on1)) {
            onPageInteractive(j2);
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageLoadError(on1 on1, int i2) {
        if (this.p && i(on1)) {
            onPageLoadError(i2);
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageRenderPercent(on1 on1, float f2, long j2) {
        if (this.p && i(on1)) {
            onPageRenderPercent(f2, j2);
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageRenderStart(on1 on1, long j2) {
        if (this.p && i(on1)) {
            onPageRenderStart(j2);
        }
    }

    @Override // com.taobao.monitor.impl.trace.RenderDispatcher.PageRenderStandard
    public void onPageVisible(on1 on1, long j2) {
        if (this.p && i(on1)) {
            onPageVisible(j2);
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageDataSetter
    public void onStage(String str, long j2) {
        this.e.stage(str, j2);
    }

    public ea(on1 on1) {
        this.p = true;
        this.q = true;
        this.z = new ArrayList();
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = new ArrayList();
        this.E = 0;
        this.d = on1;
        l();
        h();
    }
}
