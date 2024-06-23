package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.BigDecimal;

/* compiled from: Taobao */
public class ik1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static double a(double d, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "89813162")) {
            return new BigDecimal(Double.toString(d)).divide(new BigDecimal(Integer.toString(i))).doubleValue();
        }
        return ((Double) ipChange.ipc$dispatch("89813162", new Object[]{Double.valueOf(d), Integer.valueOf(i)})).doubleValue();
    }

    public static double b(double d, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1199558431")) {
            return new BigDecimal(Double.toString(d)).multiply(new BigDecimal(Integer.toString(i))).doubleValue();
        }
        return ((Double) ipChange.ipc$dispatch("1199558431", new Object[]{Double.valueOf(d), Integer.valueOf(i)})).doubleValue();
    }

    public static String c(double d) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "256887362")) {
            return uf2.a(d);
        }
        return (String) ipChange.ipc$dispatch("256887362", new Object[]{Double.valueOf(d)});
    }
}
