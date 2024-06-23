package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ub1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static long a(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1521979405")) {
            return ((Long) ipChange.ipc$dispatch("1521979405", new Object[]{bArr})).longValue();
        } else if (bArr.length > 8) {
            return -1;
        } else {
            long j = 0;
            for (byte b : bArr) {
                j = (j << 8) | (((long) b) & 255);
            }
            return j;
        }
    }
}
