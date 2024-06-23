package com.taobao.monitor.impl.trace;

import com.taobao.monitor.annotation.UnsafeMethod;
import com.taobao.monitor.impl.trace.AbsDispatcher;
import tb.on1;

/* compiled from: Taobao */
public class RenderDispatcher extends AbsDispatcher<PageRenderStandard> {

    /* compiled from: Taobao */
    public interface PageRenderStandard {
        void onPageInteractive(on1 on1, long j);

        void onPageLoadError(on1 on1, int i);

        void onPageRenderPercent(on1 on1, float f, long j);

        void onPageRenderStart(on1 on1, long j);

        void onPageVisible(on1 on1, long j);
    }

    /* compiled from: Taobao */
    class a implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ on1 a;
        final /* synthetic */ long b;

        a(RenderDispatcher renderDispatcher, on1 on1, long j) {
            this.a = on1;
            this.b = j;
        }

        /* renamed from: a */
        public void callListener(PageRenderStandard pageRenderStandard) {
            pageRenderStandard.onPageRenderStart(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    class b implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ on1 a;
        final /* synthetic */ float b;
        final /* synthetic */ long c;

        b(RenderDispatcher renderDispatcher, on1 on1, float f, long j) {
            this.a = on1;
            this.b = f;
            this.c = j;
        }

        /* renamed from: a */
        public void callListener(PageRenderStandard pageRenderStandard) {
            pageRenderStandard.onPageRenderPercent(this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    class c implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ on1 a;
        final /* synthetic */ long b;

        c(RenderDispatcher renderDispatcher, on1 on1, long j) {
            this.a = on1;
            this.b = j;
        }

        /* renamed from: a */
        public void callListener(PageRenderStandard pageRenderStandard) {
            pageRenderStandard.onPageVisible(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    class d implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ on1 a;
        final /* synthetic */ long b;

        d(RenderDispatcher renderDispatcher, on1 on1, long j) {
            this.a = on1;
            this.b = j;
        }

        /* renamed from: a */
        public void callListener(PageRenderStandard pageRenderStandard) {
            pageRenderStandard.onPageInteractive(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    class e implements AbsDispatcher.ListenerCaller<PageRenderStandard> {
        final /* synthetic */ on1 a;
        final /* synthetic */ int b;

        e(RenderDispatcher renderDispatcher, on1 on1, int i) {
            this.a = on1;
            this.b = i;
        }

        /* renamed from: a */
        public void callListener(PageRenderStandard pageRenderStandard) {
            pageRenderStandard.onPageLoadError(this.a, this.b);
        }
    }

    @UnsafeMethod
    public void f(on1 on1, long j) {
        c(new d(this, on1, j));
    }

    @UnsafeMethod
    public void g(on1 on1, int i) {
        c(new e(this, on1, i));
    }

    @UnsafeMethod
    public void h(on1 on1, float f, long j) {
        c(new b(this, on1, f, j));
    }

    @UnsafeMethod
    public void i(on1 on1, long j) {
        c(new a(this, on1, j));
    }

    @UnsafeMethod
    public void j(on1 on1, long j) {
        c(new c(this, on1, j));
    }
}
