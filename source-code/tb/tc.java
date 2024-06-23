package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class tc {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final tc INSTANCE = new tc();
    @NotNull
    private static String a = "a2o4t";

    private tc() {
    }

    @NotNull
    public final String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2118287752")) {
            return a;
        }
        return (String) ipChange.ipc$dispatch("2118287752", new Object[]{this});
    }
}
