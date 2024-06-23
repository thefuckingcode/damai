package cn.damai.common.badge.update;

import android.text.TextUtils;
import cn.damai.common.badge.bean.BadgeMarkResponse;
import cn.damai.common.badge.bean.BadgeNodeItem;
import cn.damai.common.badge.bean.BadgeQueryResponse;
import cn.damai.common.badge.listener.BadgeListenerManager;
import cn.damai.common.badge.request.BadgeMTopCallback;
import cn.damai.common.badge.request.BadgeMTopRequestHelper;
import cn.damai.common.badge.update.BadgeLoginMonitor;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import java.util.List;
import tb.m9;
import tb.n9;
import tb.p9;
import tb.rj;

/* compiled from: Taobao */
public class a implements BadgeLoginMonitor.LoginCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    private BadgeMTopRequestHelper a = new BadgeMTopRequestHelper();
    private m9 b = new m9();
    private BadgeListenerManager c;

    /* renamed from: cn.damai.common.badge.update.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0010a implements BadgeMTopCallback {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ List a;

        C0010a(List list) {
            this.a = list;
        }

        @Override // cn.damai.common.badge.request.BadgeMTopCallback
        public void failed(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1698801704")) {
                ipChange.ipc$dispatch("-1698801704", new Object[]{this, str, str2});
                return;
            }
            a.this.c.notifyFailListener(this.a, str, str2);
        }

        @Override // cn.damai.common.badge.request.BadgeMTopCallback
        public void success(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-127975998")) {
                ipChange.ipc$dispatch("-127975998", new Object[]{this, obj});
            } else if (obj != null && (obj instanceof BadgeQueryResponse)) {
                a.this.e((BadgeQueryResponse) obj);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements BadgeMTopCallback {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        @Override // cn.damai.common.badge.request.BadgeMTopCallback
        public void failed(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1706561063")) {
                ipChange.ipc$dispatch("-1706561063", new Object[]{this, str, str2});
                return;
            }
            a.this.c.notifyFailListener(this.a, str, str2);
        }

        @Override // cn.damai.common.badge.request.BadgeMTopCallback
        public void success(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2138079839")) {
                ipChange.ipc$dispatch("-2138079839", new Object[]{this, obj});
                return;
            }
            BadgeMarkResponse badgeMarkResponse = (BadgeMarkResponse) obj;
            if (badgeMarkResponse != null) {
                a.this.d(badgeMarkResponse);
            }
        }
    }

    public a(BadgeListenerManager badgeListenerManager) {
        this.c = badgeListenerManager;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d(BadgeMarkResponse badgeMarkResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "145348926")) {
            ipChange.ipc$dispatch("145348926", new Object[]{this, badgeMarkResponse});
            return;
        }
        for (BadgeNodeItem badgeNodeItem : p9.a(badgeMarkResponse)) {
            if (!(badgeNodeItem == null || badgeNodeItem.getNodeId() == null || !this.b.a(badgeNodeItem))) {
                h(badgeNodeItem);
                this.b.f(badgeNodeItem);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e(BadgeQueryResponse badgeQueryResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1169761765")) {
            ipChange.ipc$dispatch("-1169761765", new Object[]{this, badgeQueryResponse});
            return;
        }
        for (BadgeNodeItem badgeNodeItem : p9.b(badgeQueryResponse)) {
            if (!(badgeNodeItem == null || badgeNodeItem.getNodeId() == null || !this.b.a(badgeNodeItem))) {
                h(badgeNodeItem);
                this.b.f(badgeNodeItem);
            }
        }
    }

    private void h(BadgeNodeItem badgeNodeItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1133469550")) {
            ipChange.ipc$dispatch("1133469550", new Object[]{this, badgeNodeItem});
        } else if (badgeNodeItem != null) {
            this.c.notifyListener(badgeNodeItem.getNodeId(), badgeNodeItem);
        }
    }

    private void i(List<String> list) {
        BadgeNodeItem badgeNodeItem;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1075015464")) {
            ipChange.ipc$dispatch("1075015464", new Object[]{this, list});
        } else if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                BadgeNodeItem e = this.b.e(it.next());
                if (e != null) {
                    if (e.getCount() == 0) {
                        h(e);
                        it.remove();
                    } else if (e.getElimination() == 0 && (badgeNodeItem = (BadgeNodeItem) e.clone()) != null) {
                        badgeNodeItem.setCount(0);
                        badgeNodeItem.setVersion(badgeNodeItem.getVersion() + 1);
                        h(badgeNodeItem);
                        this.b.f(badgeNodeItem);
                    }
                }
            }
        }
    }

    public void f(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-975221194")) {
            ipChange.ipc$dispatch("-975221194", new Object[]{this, list});
        } else if (list != null && list.size() != 0) {
            i(list);
            if (list.size() != 0) {
                this.a.c(JSON.toJSONString(list), new b(list));
            }
        }
    }

    public void g(String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1868186042")) {
            ipChange.ipc$dispatch("1868186042", new Object[]{this, strArr});
        } else if (strArr != null && strArr.length != 0) {
            f(rj.a(strArr));
        }
    }

    public void j(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "525211773")) {
            ipChange.ipc$dispatch("525211773", new Object[]{this, list});
        } else if (list != null && list.size() != 0) {
            this.a.e(JSON.toJSONString(list), new C0010a(list));
        }
    }

    public void k(String str) {
        BadgeNodeItem c2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777367471")) {
            ipChange.ipc$dispatch("-777367471", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str) && (c2 = this.b.c(str)) != null) {
            h(c2);
        }
    }

    public void l(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1546234168")) {
            ipChange.ipc$dispatch("1546234168", new Object[]{this, list});
        } else if (list != null && list.size() != 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    BadgeNodeItem c2 = this.b.c(str);
                    if (c2 != null) {
                        h(c2);
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // cn.damai.common.badge.update.BadgeLoginMonitor.LoginCallback
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1950697051")) {
            ipChange.ipc$dispatch("1950697051", new Object[]{this});
            return;
        }
        n9.c();
        m9 m9Var = this.b;
        if (m9Var != null) {
            m9Var.b();
        }
    }

    @Override // cn.damai.common.badge.update.BadgeLoginMonitor.LoginCallback
    public void onLogoutSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1941126084")) {
            ipChange.ipc$dispatch("-1941126084", new Object[]{this});
            return;
        }
        n9.c();
        m9 m9Var = this.b;
        if (m9Var != null) {
            m9Var.b();
        }
    }
}
