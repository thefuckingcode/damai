package tb;

import cn.damai.player.video.opt.PlayOptHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class gj1 implements PlayOptHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.player.video.opt.PlayOptHelper
    public boolean isOutConditionSupportPlay() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1750244212")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1750244212", new Object[]{this})).booleanValue();
    }
}
