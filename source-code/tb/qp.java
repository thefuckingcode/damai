package tb;

import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.RenderDispatcher;
import com.taobao.monitor.procedure.IPage;

/* compiled from: Taobao */
public class qp implements IPage.PageRenderStandard {
    private final on1 a;
    private RenderDispatcher b;

    public qp(on1 on1) {
        this.a = on1;
        IDispatcher a2 = b0.a(b0.PAGE_RENDER_DISPATCHER);
        if (a2 instanceof RenderDispatcher) {
            this.b = (RenderDispatcher) a2;
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageInteractive(long j) {
        if (!e90.c(this.b)) {
            this.b.f(this.a, j);
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageLoadError(int i) {
        if (!e90.c(this.b)) {
            this.b.g(this.a, i);
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageRenderPercent(float f, long j) {
        if (!e90.c(this.b)) {
            this.b.h(this.a, f, j);
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageRenderStart(long j) {
        if (!e90.c(this.b)) {
            this.b.i(this.a, j);
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageRenderStandard
    public void onPageVisible(long j) {
        if (!e90.c(this.b)) {
            this.b.j(this.a, j);
        }
    }
}
