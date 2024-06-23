package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class nu0 {
    private static transient /* synthetic */ IpChange $ipChange;

    static {
        new nu0();
    }

    private nu0() {
    }

    public static int a(double d) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "973021104")) {
            return (int) (d * 100.0d);
        }
        return ((Integer) ipChange.ipc$dispatch("973021104", new Object[]{Double.valueOf(d)})).intValue();
    }

    public static int b(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1291808891")) {
            return i;
        }
        return ((Integer) ipChange.ipc$dispatch("-1291808891", new Object[]{Integer.valueOf(i)})).intValue();
    }

    public static int c(long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-861214427")) {
            return (int) (j ^ (j >>> 32));
        }
        return ((Integer) ipChange.ipc$dispatch("-861214427", new Object[]{Long.valueOf(j)})).intValue();
    }

    public static int d(Long l) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "777051140")) {
            return l.hashCode();
        }
        return ((Integer) ipChange.ipc$dispatch("777051140", new Object[]{l})).intValue();
    }

    public static int e(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2138078374")) {
            return str.hashCode();
        }
        return ((Integer) ipChange.ipc$dispatch("-2138078374", new Object[]{str})).intValue();
    }
}
