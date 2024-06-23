package tb;

import android.os.Build;
import com.taobao.monitor.impl.data.firstframe.FirstFrameCollector;
import com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.procedure.IPage;
import java.util.Map;

/* compiled from: Taobao */
public class pp implements IPage.PageLifecycleCallback {
    private final on1 a;
    private CustomPageLifecycleDispatcher b;

    public pp(on1 on1) {
        this.a = on1;
        IDispatcher a2 = b0.a(b0.CUSTOM_PAGE_LIFECYCLE_DISPATCHER);
        if (a2 instanceof CustomPageLifecycleDispatcher) {
            this.b = (CustomPageLifecycleDispatcher) a2;
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageAppear() {
        if (lc0.D && Build.VERSION.SDK_INT >= 16) {
            new FirstFrameCollector(this.a).d();
        }
        if (!e90.c(this.b)) {
            this.b.f(this.a);
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageCreate(String str, String str2, Map<String, Object> map) {
        ws0.q.b(this.a.h());
        if (!e90.c(this.b)) {
            this.a.J(str);
            this.a.M(str2);
            this.b.g(this.a, map);
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageDestroy() {
        if (!e90.c(this.b)) {
            this.b.h(this.a);
        }
    }

    @Override // com.taobao.monitor.procedure.IPage.PageLifecycleCallback
    public void onPageDisappear() {
        if (!e90.c(this.b)) {
            this.b.i(this.a);
        }
    }
}
