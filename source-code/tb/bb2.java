package tb;

import cn.damai.baseview.scrollable.CloseUpIdleAnimationTime;
import cn.damai.baseview.scrollable.ScrollableLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class bb2 implements CloseUpIdleAnimationTime {
    private static transient /* synthetic */ IpChange $ipChange;
    private final long a;

    public bb2(long j) {
        this.a = j;
    }

    @Override // cn.damai.baseview.scrollable.CloseUpIdleAnimationTime
    public long compute(ScrollableLayout scrollableLayout, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2002371489")) {
            return this.a;
        }
        return ((Long) ipChange.ipc$dispatch("2002371489", new Object[]{this, scrollableLayout, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).longValue();
    }
}
