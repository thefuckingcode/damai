package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class fu1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static long a = 86400000;

    public static boolean a() {
        long j;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1892207759")) {
            return ((Boolean) ipChange.ipc$dispatch("-1892207759", new Object[0])).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            j = Long.parseLong(d20.B("projectSeeTime"));
        } catch (Exception unused) {
            j = 0;
        }
        if (j == 0 || currentTimeMillis - j > a) {
            return true;
        }
        return false;
    }

    public static void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1214189814")) {
            ipChange.ipc$dispatch("1214189814", new Object[0]);
            return;
        }
        d20.T("projectSeeTime", System.currentTimeMillis() + "");
    }
}
