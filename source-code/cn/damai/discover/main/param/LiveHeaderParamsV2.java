package cn.damai.discover.main.param;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class LiveHeaderParamsV2 extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1907611840")) {
            return "discoveryLive";
        }
        return (String) ipChange.ipc$dispatch("-1907611840", new Object[]{this});
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "953265757")) {
            return "2.0";
        }
        return (String) ipChange.ipc$dispatch("953265757", new Object[]{this});
    }
}
