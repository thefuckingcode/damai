package cn.damai.launcher.altriax;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitNavDelegate;
import tb.ah1;
import tb.gm0;

/* compiled from: Taobao */
public class DMInitNavImpl implements DMInitNavDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMNormalInitDelegate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1514871499")) {
            ipChange.ipc$dispatch("1514871499", new Object[]{this});
            return;
        }
        gm0.f().e();
        new ah1().a();
    }
}
