package tb;

import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class xd1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DAMAI_MINE_CHANGE_EMAIL_KEY = "mine_change_email";
    public static final String DAMAI_MINE_CHANGE_EMAIL_NAMESPACE = "damai_mine_change_email_namespace";
    public static final String DAMAI_MINE_CHANGE_MOBILE_KEY = "mine_change_mobile";
    public static final String DAMAI_MINE_CHANGE_MOBILE_SWITCH_NAMESPACE = "damai_mine_change_mobile_switch";
    public static final String DAMAI_MINE_THIRD_ACCOUNT_SETTING_KEY = "third_account_setting";
    public static final String DAMAI_MINE_THIRD_ACCOUNT_SETTING_NAMESPACE = "damai_mine_third_account_setting";
    private static xd1 a;

    private xd1() {
    }

    public static xd1 a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "785369179")) {
            return (xd1) ipChange.ipc$dispatch("785369179", new Object[0]);
        }
        if (a == null) {
            synchronized (xd1.class) {
                if (a == null) {
                    a = new xd1();
                }
            }
        }
        return a;
    }

    public boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1307450626")) {
            return OrangeConfigCenter.c().a(DAMAI_MINE_CHANGE_EMAIL_NAMESPACE, DAMAI_MINE_CHANGE_EMAIL_KEY, 1) != 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1307450626", new Object[]{this})).booleanValue();
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "923941654")) {
            return OrangeConfigCenter.c().a(DAMAI_MINE_CHANGE_MOBILE_SWITCH_NAMESPACE, DAMAI_MINE_CHANGE_MOBILE_KEY, 1) != 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("923941654", new Object[]{this})).booleanValue();
    }

    public boolean d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2007603923")) {
            return OrangeConfigCenter.c().a(DAMAI_MINE_THIRD_ACCOUNT_SETTING_NAMESPACE, DAMAI_MINE_THIRD_ACCOUNT_SETTING_KEY, 1) != 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("2007603923", new Object[]{this})).booleanValue();
    }

    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "805930259")) {
            ipChange.ipc$dispatch("805930259", new Object[]{this});
            return;
        }
        OrangeConfigCenter.c().e(DAMAI_MINE_CHANGE_EMAIL_NAMESPACE);
    }

    public void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1302485565")) {
            ipChange.ipc$dispatch("1302485565", new Object[]{this});
            return;
        }
        OrangeConfigCenter.c().e(DAMAI_MINE_CHANGE_MOBILE_SWITCH_NAMESPACE);
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1159234490")) {
            ipChange.ipc$dispatch("1159234490", new Object[]{this});
            return;
        }
        OrangeConfigCenter.c().g(DAMAI_MINE_CHANGE_EMAIL_NAMESPACE);
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-629985162")) {
            ipChange.ipc$dispatch("-629985162", new Object[]{this});
            return;
        }
        OrangeConfigCenter.c().g(DAMAI_MINE_CHANGE_MOBILE_SWITCH_NAMESPACE);
    }
}
