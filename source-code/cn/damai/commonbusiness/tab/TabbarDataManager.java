package cn.damai.commonbusiness.tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.common.DamaiConstants;
import cn.damai.commonbusiness.home.bean.TabExtraBean;
import cn.damai.commonbusiness.tab.TabbarLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.f92;
import tb.xs0;
import tb.z91;

/* compiled from: Taobao */
public class TabbarDataManager implements TabbarDataObserver {
    private static transient /* synthetic */ IpChange $ipChange;
    private static TabbarDataManager d;
    private List<DamaiTabbarManager> a = new ArrayList();
    private LoginBroadcastReceiver b;
    private HashMap<String, TabExtraBean> c = new HashMap<>();

    /* compiled from: Taobao */
    public class LoginBroadcastReceiver extends BroadcastReceiver {
        private static transient /* synthetic */ IpChange $ipChange;

        private LoginBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-685073219")) {
                ipChange.ipc$dispatch("-685073219", new Object[]{this, context, intent});
            } else if (z91.BROADCAST_LOGOUT_SUCCESS.equals(intent.getAction())) {
                TabbarDataManager.this.d();
                if (TabbarDataManager.this.c.size() > 0) {
                    TabbarDataManager.this.c.clear();
                    TabbarDataManager.this.h();
                }
            }
        }
    }

    private TabbarDataManager() {
        l();
    }

    public static TabbarDataManager e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-753663164")) {
            return (TabbarDataManager) ipChange.ipc$dispatch("-753663164", new Object[0]);
        }
        if (d == null) {
            synchronized (TabbarDataManager.class) {
                if (d == null) {
                    d = new TabbarDataManager();
                }
            }
        }
        return d;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1548878971")) {
            ipChange.ipc$dispatch("1548878971", new Object[]{this});
        } else if (!f92.d(this.a)) {
            for (DamaiTabbarManager damaiTabbarManager : this.a) {
                damaiTabbarManager.e(this.c);
            }
        }
    }

    public void c(DamaiTabbarManager damaiTabbarManager) {
        List<DamaiTabbarManager> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1512811201")) {
            ipChange.ipc$dispatch("1512811201", new Object[]{this, damaiTabbarManager});
        } else if (damaiTabbarManager != null && (list = this.a) != null && !list.contains(damaiTabbarManager)) {
            Iterator<DamaiTabbarManager> it = this.a.iterator();
            while (it.hasNext()) {
                DamaiTabbarManager next = it.next();
                if (next == null) {
                    it.remove();
                } else if (next.f() == null || !next.f().equals(damaiTabbarManager.f())) {
                    Activity g = damaiTabbarManager.g();
                    Activity g2 = next.g();
                    if (!(g == null || g2 == null || !g2.getLocalClassName().equals(g.getLocalClassName()))) {
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            }
            this.a.add(damaiTabbarManager);
        }
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-169630497")) {
            ipChange.ipc$dispatch("-169630497", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).r(DamaiConstants.TAB_MINE, TabbarLayout.BadgeType.NONE);
        }
    }

    @Nullable
    public TabExtraBean f(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "505963008")) {
            return this.c.get(str);
        }
        return (TabExtraBean) ipChange.ipc$dispatch("505963008", new Object[]{this, str});
    }

    public HashMap<String, TabExtraBean> g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "199120599")) {
            return this.c;
        }
        return (HashMap) ipChange.ipc$dispatch("199120599", new Object[]{this});
    }

    public void i(String str, TabExtraBean tabExtraBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "189415787")) {
            ipChange.ipc$dispatch("189415787", new Object[]{this, str, tabExtraBean});
        } else if (!TextUtils.isEmpty(str) && tabExtraBean != null) {
            this.c.put(str, tabExtraBean);
            h();
        }
    }

    public void j(DamaiTabbarManager damaiTabbarManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1737682994")) {
            ipChange.ipc$dispatch("1737682994", new Object[]{this, damaiTabbarManager});
            return;
        }
        List<DamaiTabbarManager> list = this.a;
        if (list != null) {
            list.remove(damaiTabbarManager);
        }
    }

    public void k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1478432484")) {
            ipChange.ipc$dispatch("-1478432484", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str) && this.c.remove(str) != null) {
            h();
        }
    }

    public void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1135213848")) {
            ipChange.ipc$dispatch("1135213848", new Object[]{this});
        } else if (this.b == null) {
            try {
                this.b = new LoginBroadcastReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(z91.BROADCAST_LOGOUT_SUCCESS);
                xs0.a().registerReceiver(this.b, intentFilter);
            } catch (Throwable th) {
                this.b = null;
                th.printStackTrace();
            }
        }
    }

    @Override // cn.damai.commonbusiness.tab.TabbarDataObserver
    public void onTabbarBadgeChanged(String str, TabbarLayout.BadgeType badgeType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1558891834")) {
            ipChange.ipc$dispatch("-1558891834", new Object[]{this, str, badgeType});
        } else if (this.a != null && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.a.size(); i++) {
                this.a.get(i).r(str, badgeType);
            }
        }
    }
}
