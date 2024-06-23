package tb;

import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class e92 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(Collection collection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518632443")) {
            return ((Integer) ipChange.ipc$dispatch("1518632443", new Object[]{collection})).intValue();
        } else if (collection == null) {
            return 0;
        } else {
            return collection.size();
        }
    }

    @Nullable
    public static <T> T b(List<T> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "655402705")) {
            return (T) ipChange.ipc$dispatch("655402705", new Object[]{list, Integer.valueOf(i)});
        } else if (!d(list) && i >= 0 && i <= list.size() - 1) {
            return list.get(i);
        } else {
            return null;
        }
    }

    public static int c(Collection collection) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2145859593")) {
            return a(collection);
        }
        return ((Integer) ipChange.ipc$dispatch("2145859593", new Object[]{collection})).intValue();
    }

    public static boolean d(Collection collection) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1236394164")) {
            return collection == null || collection.size() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1236394164", new Object[]{collection})).booleanValue();
    }

    public static boolean e(Map map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1210757484")) {
            return map == null || map.size() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1210757484", new Object[]{map})).booleanValue();
    }

    public static boolean f(Collection collection) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2031521355")) {
            return !d(collection);
        }
        return ((Boolean) ipChange.ipc$dispatch("2031521355", new Object[]{collection})).booleanValue();
    }

    public static boolean g(Map map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-470608621")) {
            return !e(map);
        }
        return ((Boolean) ipChange.ipc$dispatch("-470608621", new Object[]{map})).booleanValue();
    }
}
