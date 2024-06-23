package tb;

import android.text.TextUtils;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.analytics.utils.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class nb2 {
    private List<mb2> a;
    private Set<String> b;
    private String c;
    private Comparator<mb2> d;
    private IStrategyFilter e;
    private int f;
    private boolean g;

    /* compiled from: Taobao */
    class a implements Comparator<mb2> {
        a(nb2 nb2) {
        }

        /* renamed from: a */
        public int compare(mb2 mb2, mb2 mb22) {
            return mb2.b() - mb22.b();
        }
    }

    /* compiled from: Taobao */
    class b implements IStrategyFilter {
        b(nb2 nb2) {
        }

        @Override // anet.channel.strategy.IStrategyFilter
        public boolean accept(IConnStrategy iConnStrategy) {
            return iConnStrategy.getIpType() == 0 && iConnStrategy.getIpSource() == 0 && iConnStrategy.getPort() == 443;
        }
    }

    public nb2() {
        this.c = "";
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = false;
        this.a = new ArrayList();
        this.b = new HashSet();
        this.d = new a(this);
        this.e = new b(this);
    }

    private void a() {
        List<IConnStrategy> c2 = c();
        e(c2);
        if (c2 == null || c2.size() == 0) {
            this.a.clear();
            this.b.clear();
            rm2.b().g(0);
            return;
        }
        boolean h = h(c2);
        Logger.f("SipStrategyList", "shouldRefreshList", Boolean.valueOf(h));
        if (h) {
            this.a.clear();
            this.b.clear();
            rm2.b().g(c2.size());
            for (IConnStrategy iConnStrategy : c2) {
                String ip = iConnStrategy.getIp();
                this.a.add(new mb2(ip, iConnStrategy.getPort()));
                this.b.add(ip);
            }
        }
    }

    private List<IConnStrategy> c() {
        return anet.channel.strategy.a.a().getConnStrategyListByHost(nm2.a().getTnetHostPort().a(), this.e);
    }

    private void e(List<IConnStrategy> list) {
        if (Logger.n()) {
            if (list == null || list.size() == 0) {
                Logger.f("SipStrategyList", "connStrategyList is Empty");
                return;
            }
            for (IConnStrategy iConnStrategy : list) {
                Logger.f("SipStrategyList", TbAuthConstants.IP, iConnStrategy.getIp(), "port", Integer.valueOf(iConnStrategy.getPort()), "IpType", Integer.valueOf(iConnStrategy.getIpType()), "IpSource", Integer.valueOf(iConnStrategy.getIpSource()));
            }
        }
    }

    private void f() {
        if (Logger.n()) {
            List<mb2> list = this.a;
            if (list == null || list.size() == 0) {
                Logger.f("", "sipConnStrategyList is Empty");
                return;
            }
            for (mb2 mb2 : this.a) {
                Logger.f("SipStrategyList", TbAuthConstants.IP, mb2.c(), e03.POINT_FAIL_COUNT_MEASURE, Integer.valueOf(mb2.b()));
            }
            Logger.f("SipStrategyList", "amdcSipFailCountAll", Integer.valueOf(this.f), "AmdcSipFailCountAll config", Integer.valueOf(w32.d().b()));
        }
    }

    private boolean h(List<IConnStrategy> list) {
        if (this.a.size() != list.size()) {
            return true;
        }
        for (IConnStrategy iConnStrategy : list) {
            if (!this.b.contains(iConnStrategy.getIp())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        if (this.g) {
            return 0;
        }
        List<IConnStrategy> c2 = c();
        e(c2);
        if (c2 != null) {
            return c2.size();
        }
        return 0;
    }

    public mm2 d() {
        if (this.f >= w32.d().b()) {
            this.g = true;
            this.c = "";
            return null;
        }
        try {
            a();
        } catch (Throwable th) {
            Logger.h("SipStrategyList", th, new Object[0]);
        }
        List<mb2> list = this.a;
        if (list == null || list.isEmpty()) {
            this.c = "";
            return null;
        }
        mb2 mb2 = this.a.get(0);
        if (mb2 == null) {
            this.c = "";
            return null;
        } else if (mb2.b() >= w32.d().a()) {
            this.c = "";
            return null;
        } else {
            mm2 mm2 = new mm2();
            mm2.e(mb2.c());
            mm2.h(2);
            mm2.g(2);
            this.c = mb2.c();
            return mm2;
        }
    }

    public void g(boolean z) {
        List<mb2> list;
        mb2 mb2;
        if (!TextUtils.isEmpty(this.c) && (list = this.a) != null && !list.isEmpty() && (mb2 = this.a.get(0)) != null && this.c.equalsIgnoreCase(mb2.c())) {
            if (z) {
                mb2.d(0);
                this.f = 0;
            } else {
                mb2.a();
                this.f++;
                Collections.sort(this.a, this.d);
            }
            f();
        }
    }
}
