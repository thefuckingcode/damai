package cn.damai.launcher.altriax;

import cn.damai.common.uploader.AusConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitAusDelegate;
import tb.xs0;

/* compiled from: Taobao */
public class DMInitAusImpl implements DMInitAusDelegate {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // me.ele.altriax.launcher.biz.bridge.delegate.DMInitAusDelegate
    public void initAus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1186270396")) {
            ipChange.ipc$dispatch("-1186270396", new Object[]{this});
            return;
        }
        AusConfigCenter.initUploader(xs0.a());
    }
}
