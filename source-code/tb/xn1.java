package tb;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher;
import com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.impl.trace.PageLeaveDispatcher;
import com.taobao.monitor.impl.trace.WindowEventDispatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class xn1 implements ApplicationBackgroundChangedDispatcher.BackgroundChangedListener, CustomPageLifecycleDispatcher.CustomPageLifecycle, WindowEventDispatcher.OnEventListener {
    private final List<on1> a = new ArrayList();
    private PageLeaveDispatcher b;

    public xn1() {
        IDispatcher b2 = e90.b(b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER);
        if (b2 instanceof ApplicationBackgroundChangedDispatcher) {
            ((ApplicationBackgroundChangedDispatcher) b2).addListener(this);
        }
        IDispatcher b3 = e90.b(b0.WINDOW_EVENT_DISPATCHER);
        if (b3 instanceof WindowEventDispatcher) {
            ((WindowEventDispatcher) b3).addListener(this);
        }
        IDispatcher b4 = e90.b(b0.PAGE_LEAVE_DISPATCHER);
        if (b4 instanceof PageLeaveDispatcher) {
            this.b = (PageLeaveDispatcher) b4;
        }
    }

    @Override // com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher.BackgroundChangedListener
    public void onChanged(int i, long j) {
        if (i == 1) {
            for (on1 on1 : this.a) {
                this.b.f(on1, -3);
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onKey(Activity activity, KeyEvent keyEvent, long j) {
        for (on1 on1 : this.a) {
            if (!ow2.a(activity, on1.o())) {
                return;
            }
            if (ow2.a(activity, on1.o())) {
                int action = keyEvent.getAction();
                int keyCode = keyEvent.getKeyCode();
                if (action == 0 && keyCode == 4) {
                    this.b.f(on1, -4);
                }
            }
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageAppear(on1 on1) {
        if (!this.a.contains(on1)) {
            this.a.add(on1);
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageCreate(on1 on1, Map<String, Object> map) {
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageDestroy(on1 on1) {
        this.a.remove(on1);
        if (!e90.c(this.b)) {
            this.b.f(on1, -4);
        }
    }

    @Override // com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher.CustomPageLifecycle
    public void onPageDisappear(on1 on1) {
        if (!on1.u() && !e90.c(this.b)) {
            this.b.f(on1, -5);
        }
    }

    @Override // com.taobao.monitor.impl.trace.WindowEventDispatcher.OnEventListener
    public void onTouch(Activity activity, MotionEvent motionEvent, long j) {
    }
}
