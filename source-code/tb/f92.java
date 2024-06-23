package tb;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class f92 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(Collection collection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-854904448")) {
            return ((Integer) ipChange.ipc$dispatch("-854904448", new Object[]{collection})).intValue();
        } else if (collection == null) {
            return 0;
        } else {
            return collection.size();
        }
    }

    @Nullable
    public static <T> T b(List<T> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "985071148")) {
            return (T) ipChange.ipc$dispatch("985071148", new Object[]{list, Integer.valueOf(i)});
        } else if (!d(list) && i >= 0 && i <= list.size() - 1) {
            return list.get(i);
        } else {
            return null;
        }
    }

    public static boolean c(ArrayMap arrayMap) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1873736910")) {
            return arrayMap == null || arrayMap.size() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1873736910", new Object[]{arrayMap})).booleanValue();
    }

    public static boolean d(Collection collection) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-66033881")) {
            return collection == null || collection.size() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-66033881", new Object[]{collection})).booleanValue();
    }

    public static boolean e(LongSparseArray longSparseArray) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-776573957")) {
            return longSparseArray == null || longSparseArray.size() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-776573957", new Object[]{longSparseArray})).booleanValue();
    }

    public static boolean f(Map map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "127122415")) {
            return map == null || map.size() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("127122415", new Object[]{map})).booleanValue();
    }

    public static boolean g(Collection collection) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-342015536")) {
            return !d(collection);
        }
        return ((Boolean) ipChange.ipc$dispatch("-342015536", new Object[]{collection})).booleanValue();
    }

    public static boolean h(Map map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1946004712")) {
            return !f(map);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1946004712", new Object[]{map})).booleanValue();
    }

    public static void i(Map<String, String> map, Map<String, String> map2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1546641759")) {
            ipChange.ipc$dispatch("-1546641759", new Object[]{map, map2});
        } else if (map != null && map2 != null && map2.size() > 0) {
            map.putAll(map2);
        }
    }
}
