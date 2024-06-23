package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class cd {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DEFAULT_CACHE_VALID_MILLS = 1500;

    public int cacheValidMills() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1004998363")) {
            return 1500;
        }
        return ((Integer) ipChange.ipc$dispatch("-1004998363", new Object[]{this})).intValue();
    }

    public abstract boolean is4Preload();
}
