package cn.damai.launcher.altriax;

import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitOrangeDelegate;
import tb.ol1;
import tb.xs0;

/* compiled from: Taobao */
public class DMInitOrangeImpl implements DMInitOrangeDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMNormalInitDelegate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "759882840")) {
            ipChange.ipc$dispatch("759882840", new Object[]{this});
            return;
        }
        OrangeConfigCenter.c();
        OrangeConfigCenter.d(xs0.a());
        ol1.c();
    }
}
