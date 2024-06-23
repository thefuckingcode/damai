package tb;

import cn.damai.common.badge.DMBadgeListener;
import cn.damai.common.badge.listener.BadgeListenerManager;
import cn.damai.common.badge.update.BadgeLoginMonitor;
import cn.damai.common.badge.update.BadgeLoginMonitorImpl;
import cn.damai.common.badge.update.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class yp {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static yp e = null;
    public static String f = "MARK_QUERY_NOLOGIN";
    private boolean a = false;
    private a b;
    private BadgeListenerManager c;
    private BadgeLoginMonitor d;

    private yp() {
        b();
    }

    public static synchronized yp a() {
        synchronized (yp.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "62814299")) {
                return (yp) ipChange.ipc$dispatch("62814299", new Object[0]);
            }
            if (e == null) {
                yp ypVar = new yp();
                e = ypVar;
                ypVar.b();
            }
            return e;
        }
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-613891635")) {
            ipChange.ipc$dispatch("-613891635", new Object[]{this});
        } else if (!this.a) {
            o9 o9Var = new o9();
            this.c = o9Var;
            this.b = new a(o9Var);
            BadgeLoginMonitorImpl badgeLoginMonitorImpl = new BadgeLoginMonitorImpl();
            this.d = badgeLoginMonitorImpl;
            badgeLoginMonitorImpl.setLoginCallback(this.b);
            this.d.startLoginMonitor();
            this.a = true;
        }
    }

    public void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567017560")) {
            ipChange.ipc$dispatch("1567017560", new Object[]{this, str});
            return;
        }
        this.b.g(str);
    }

    public void d(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1314404652")) {
            ipChange.ipc$dispatch("-1314404652", new Object[]{this, list});
            return;
        }
        this.b.j(list);
    }

    public void e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "297155290")) {
            ipChange.ipc$dispatch("297155290", new Object[]{this, str});
            return;
        }
        this.b.k(str);
    }

    public void f(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2047910401")) {
            ipChange.ipc$dispatch("2047910401", new Object[]{this, list});
            return;
        }
        this.b.l(list);
    }

    public void g(String str, DMBadgeListener dMBadgeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1840839704")) {
            ipChange.ipc$dispatch("1840839704", new Object[]{this, str, dMBadgeListener});
            return;
        }
        this.c.registerListener(str, dMBadgeListener);
    }

    public void h(List<String> list, DMBadgeListener dMBadgeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-464842351")) {
            ipChange.ipc$dispatch("-464842351", new Object[]{this, list, dMBadgeListener});
            return;
        }
        this.c.registerListener(list, dMBadgeListener);
    }

    public void i(String str, DMBadgeListener dMBadgeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "697791313")) {
            ipChange.ipc$dispatch("697791313", new Object[]{this, str, dMBadgeListener});
            return;
        }
        this.c.unRegisterListener(str, dMBadgeListener);
    }

    public void j(List<String> list, DMBadgeListener dMBadgeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1583348982")) {
            ipChange.ipc$dispatch("-1583348982", new Object[]{this, list, dMBadgeListener});
            return;
        }
        this.c.unRegisterListener(list, dMBadgeListener);
    }
}
