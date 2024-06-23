package tb;

import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class vz0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final boolean a;
    private final boolean b;
    @Nullable
    private l32 c;

    public vz0(boolean z, boolean z2, @Nullable l32 l32) {
        this.a = z;
        this.b = z2;
        this.c = l32;
    }

    @Nullable
    public l32 a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1772501468")) {
            return this.c;
        }
        return (l32) ipChange.ipc$dispatch("1772501468", new Object[]{this});
    }

    public boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-800247417")) {
            return this.b;
        }
        return ((Boolean) ipChange.ipc$dispatch("-800247417", new Object[]{this})).booleanValue();
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1659735090")) {
            return this.a;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1659735090", new Object[]{this})).booleanValue();
    }
}
