package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class u71 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean a(List<?> list) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1972693645")) {
            return list == null || list.size() <= 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1972693645", new Object[]{list})).booleanValue();
    }
}
