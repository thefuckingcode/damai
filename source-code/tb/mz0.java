package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class mz0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static long a(int i, short s, byte b, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2040100548")) {
            return ((Long) ipChange.ipc$dispatch("-2040100548", new Object[]{Integer.valueOf(i), Short.valueOf(s), Byte.valueOf(b), Boolean.valueOf(z)})).longValue();
        }
        long j = 0;
        if (z) {
            j = 1;
        }
        return (((((j << 8) + ((long) b)) << 16) + ((long) s)) << 32) + ((long) i);
    }
}
