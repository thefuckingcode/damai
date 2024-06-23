package cn.damai.launcher.altriax;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitOnlineMonitorDelegate;
import tb.g91;
import tb.xs0;
import tb.z4;

/* compiled from: Taobao */
public class DMInitOnlineMonitorImpl implements DMInitOnlineMonitorDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMInitOnlineMonitorDelegate
    public void initOnlineMonitor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898798836")) {
            ipChange.ipc$dispatch("898798836", new Object[]{this});
            return;
        }
        g91.f("MainScheduler", "initOnlineMonitor");
        z4.d(xs0.a(), true);
    }
}
