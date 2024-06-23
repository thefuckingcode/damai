package tb;

import com.taobao.monitor.impl.data.visible.VisibleCalculator;
import com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher;
import com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.PageLeaveDispatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class sw2 implements ApplicationBackgroundChangedDispatcher.BackgroundChangedListener, CustomPageLifecycleDispatcher.CustomPageLifecycle, PageLeaveDispatcher.PageLeaveListener {
    private final Map<on1, Boolean> a = new HashMap();
    private final Map<on1, Boolean> b = new HashMap();
    private final Map<on1, Boolean> c = new HashMap();
    private final Map<on1, VisibleCalculator> d = new HashMap();

    public sw2() {
        IDispatcher b2 = e90.b(b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER);
        if (b2 instanceof ApplicationBackgroundChangedDispatcher) {
            ((ApplicationBackgroundChangedDispatcher) b2).addListener(this);
        }
        IDispatcher b3 = e90.b(b0.PAGE_LEAVE_DISPATCHER);
        if (b3 instanceof PageLeaveDispatcher) {
            ((PageLeaveDispatcher) b3).addListener(this);
        }
    }

    private boolean a(on1 on1) {
        Boolean bool = Boolean.TRUE;
        return !bool.equals(this.a.get(on1)) || !bool.equals(this.b.get(on1)) || !bool.equals(this.c.get(on1));
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher.BackgroundChangedListener
    public void onChanged(int i, long j) {
        if (i == 0) {
            this.b.clear();
            this.c.clear();
            ArrayList<on1> arrayList = new ArrayList(this.d.keySet());
            this.d.clear();
            for (on1 on1 : arrayList) {
                this.d.put(on1, new VisibleCalculator(on1));
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.PageLeaveDispatcher.PageLeaveListener
    public void onLeave(on1 on1, int i) {
        VisibleCalculator visibleCalculator;
        if (on1 != null && (visibleCalculator = this.d.get(on1)) != null) {
            if (i == -5) {
                visibleCalculator.errorNotify(-5);
            } else if (i == -4) {
                visibleCalculator.errorNotify(-4);
            } else if (i == -3) {
                visibleCalculator.errorNotify(-3);
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageAppear(on1 on1) {
        this.b.put(on1, Boolean.TRUE);
        VisibleCalculator visibleCalculator = this.d.get(on1);
        if (visibleCalculator != null) {
            visibleCalculator.startPageCalculateExecutor(on1.o());
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageCreate(on1 on1, Map<String, Object> map) {
        this.a.put(on1, Boolean.TRUE);
        if (!this.d.containsKey(on1)) {
            this.d.put(on1, new VisibleCalculator(on1));
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageDestroy(on1 on1) {
        VisibleCalculator visibleCalculator = this.d.get(on1);
        if (visibleCalculator != null) {
            if (a(on1)) {
                visibleCalculator.errorNotify(-6);
            }
            visibleCalculator.stopPageCalculateExecutor();
        }
        this.a.remove(on1);
        this.b.remove(on1);
        this.c.remove(on1);
        this.d.remove(on1);
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageDisappear(on1 on1) {
        this.c.put(on1, Boolean.TRUE);
        VisibleCalculator visibleCalculator = this.d.get(on1);
        if (visibleCalculator != null) {
            visibleCalculator.stopPageCalculateExecutor();
        }
    }
}
