package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: Taobao */
public class rj {
    private static transient /* synthetic */ IpChange $ipChange;

    @SafeVarargs
    public static <T> ArrayList<T> a(T... tArr) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-809620153")) {
            return new ArrayList<>(Arrays.asList(tArr));
        }
        return (ArrayList) ipChange.ipc$dispatch("-809620153", new Object[]{tArr});
    }
}
