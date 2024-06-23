package tb;

import cn.damai.common.user.a;
import cn.damai.common.user.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class fw1 extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HOME_SCAN_PAGE = "scan";
    public static final String HOME_TICKET_SCAN_PAGE = "ticket_scan";

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final fw1 a = new fw1();
    }

    public static final fw1 f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-77638405") ? (fw1) ipChange.ipc$dispatch("-77638405", new Object[0]) : a.a;
    }

    public a.b g(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1821838401")) {
            return b(str);
        }
        return (a.b) ipChange.ipc$dispatch("1821838401", new Object[]{this, str});
    }
}
