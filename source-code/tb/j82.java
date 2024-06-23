package tb;

import com.alibaba.analytics.core.selfmonitor.SelfMonitorEventListener;
import com.alibaba.analytics.core.store.LogStoreMgr;
import com.alibaba.analytics.core.sync.a;
import com.alibaba.analytics.core.sync.d;
import com.alibaba.analytics.core.sync.e;
import com.alibaba.analytics.core.sync.f;
import com.alibaba.analytics.core.sync.h;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.delegate.a;
import com.alibaba.appmonitor.event.EventType;

/* compiled from: Taobao */
public class j82 implements SelfMonitorEventListener {
    private static j82 a = new j82();

    public static j82 a() {
        return a;
    }

    public void b() {
        try {
            f.i().l.a(this);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
        try {
            e.h().d.a(this);
        } catch (Throwable th2) {
            Logger.h(null, th2, new Object[0]);
        }
        try {
            h.mMonitor.a(this);
        } catch (Throwable th3) {
            Logger.h(null, th3, new Object[0]);
        }
        try {
            a.mMonitor.a(this);
        } catch (Throwable th4) {
            Logger.h(null, th4, new Object[0]);
        }
        try {
            LogStoreMgr.g.a(this);
        } catch (Throwable th5) {
            Logger.h(null, th5, new Object[0]);
        }
        try {
            d.mMonitor.a(this);
        } catch (Throwable th6) {
            Logger.h(null, th6, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.core.selfmonitor.SelfMonitorEventListener
    public void onEvent(h82 h82) {
        EventType eventType = h82.b;
        if (eventType == EventType.COUNTER) {
            a.b.c(h82.module, h82.a, h82.c, h82.d.doubleValue());
        } else if (eventType == EventType.STAT) {
            a.d.e(h82.module, h82.a, h82.e, h82.f);
        }
    }
}
