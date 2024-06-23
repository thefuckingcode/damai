package com.taobao.monitor.impl.trace;

import com.taobao.monitor.impl.trace.AbsDispatcher;
import java.util.Map;
import tb.on1;

/* compiled from: Taobao */
public class CustomPageLifecycleDispatcher extends AbsDispatcher<CustomPageLifecycle> {

    /* compiled from: Taobao */
    public interface CustomPageLifecycle {
        void onPageAppear(on1 on1);

        void onPageCreate(on1 on1, Map<String, Object> map);

        void onPageDestroy(on1 on1);

        void onPageDisappear(on1 on1);
    }

    /* compiled from: Taobao */
    class a implements AbsDispatcher.ListenerCaller<CustomPageLifecycle> {
        final /* synthetic */ on1 a;
        final /* synthetic */ Map b;

        a(CustomPageLifecycleDispatcher customPageLifecycleDispatcher, on1 on1, Map map) {
            this.a = on1;
            this.b = map;
        }

        /* renamed from: a */
        public void callListener(CustomPageLifecycle customPageLifecycle) {
            customPageLifecycle.onPageCreate(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    class b implements AbsDispatcher.ListenerCaller<CustomPageLifecycle> {
        final /* synthetic */ on1 a;

        b(CustomPageLifecycleDispatcher customPageLifecycleDispatcher, on1 on1) {
            this.a = on1;
        }

        /* renamed from: a */
        public void callListener(CustomPageLifecycle customPageLifecycle) {
            customPageLifecycle.onPageAppear(this.a);
        }
    }

    /* compiled from: Taobao */
    class c implements AbsDispatcher.ListenerCaller<CustomPageLifecycle> {
        final /* synthetic */ on1 a;

        c(CustomPageLifecycleDispatcher customPageLifecycleDispatcher, on1 on1) {
            this.a = on1;
        }

        /* renamed from: a */
        public void callListener(CustomPageLifecycle customPageLifecycle) {
            customPageLifecycle.onPageDisappear(this.a);
        }
    }

    /* compiled from: Taobao */
    class d implements AbsDispatcher.ListenerCaller<CustomPageLifecycle> {
        final /* synthetic */ on1 a;

        d(CustomPageLifecycleDispatcher customPageLifecycleDispatcher, on1 on1) {
            this.a = on1;
        }

        /* renamed from: a */
        public void callListener(CustomPageLifecycle customPageLifecycle) {
            customPageLifecycle.onPageDestroy(this.a);
        }
    }

    public void f(on1 on1) {
        c(new b(this, on1));
    }

    public void g(on1 on1, Map<String, Object> map) {
        c(new a(this, on1, map));
    }

    public void h(on1 on1) {
        c(new d(this, on1));
    }

    public void i(on1 on1) {
        c(new c(this, on1));
    }
}
