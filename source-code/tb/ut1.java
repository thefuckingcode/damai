package tb;

import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ut1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static a.b a(long j, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-386106199")) {
            return new a.b().d(String.valueOf(j)).i(str);
        }
        return (a.b) ipChange.ipc$dispatch("-386106199", new Object[]{Long.valueOf(j), str});
    }

    public static a.b b(long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "661605445")) {
            return a(j, ln2.PROJECT_TICKET_PAGE);
        }
        return (a.b) ipChange.ipc$dispatch("661605445", new Object[]{Long.valueOf(j)});
    }

    public static a.b c(long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "967433141")) {
            return a(j, ln2.PROJECT_PAGE_WARM_PROMPT);
        }
        return (a.b) ipChange.ipc$dispatch("967433141", new Object[]{Long.valueOf(j)});
    }
}
