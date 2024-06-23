package cn.damai.launcher.altriax;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitUTDelegate;
import tb.xs0;
import tb.z4;

/* compiled from: Taobao */
public class DMInitUTImpl implements DMInitUTDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMNormalInitDelegate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-113153175")) {
            ipChange.ipc$dispatch("-113153175", new Object[]{this});
            return;
        }
        z4.f(xs0.a());
    }
}
