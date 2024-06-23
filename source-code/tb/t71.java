package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class t71 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static <T> int a(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1600782970")) {
            return ((Integer) ipChange.ipc$dispatch("1600782970", new Object[]{list})).intValue();
        } else if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    public static boolean b(List<?> list) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-989587523")) {
            return list == null || list.size() <= 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-989587523", new Object[]{list})).booleanValue();
    }

    public static boolean c(Map map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "17928773")) {
            return map == null || map.size() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("17928773", new Object[]{map})).booleanValue();
    }
}
