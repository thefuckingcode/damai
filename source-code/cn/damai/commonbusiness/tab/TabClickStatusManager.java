package cn.damai.commonbusiness.tab;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class TabClickStatusManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static TabClickStatusManager b;
    private HomeTabStatus a = HomeTabStatus.SELECTED;

    /* compiled from: Taobao */
    public enum HomeTabStatus {
        SELECTED,
        RE_SELECTED
    }

    public static synchronized TabClickStatusManager b() {
        synchronized (TabClickStatusManager.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-576563927")) {
                return (TabClickStatusManager) ipChange.ipc$dispatch("-576563927", new Object[0]);
            }
            if (b == null) {
                b = new TabClickStatusManager();
            }
            return b;
        }
    }

    public HomeTabStatus a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1072798712")) {
            return this.a;
        }
        return (HomeTabStatus) ipChange.ipc$dispatch("1072798712", new Object[]{this});
    }

    public void c(HomeTabStatus homeTabStatus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "181035996")) {
            ipChange.ipc$dispatch("181035996", new Object[]{this, homeTabStatus});
            return;
        }
        this.a = homeTabStatus;
    }

    public void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1508256177")) {
            ipChange.ipc$dispatch("-1508256177", new Object[]{this, str});
        }
    }
}
