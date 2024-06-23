package cn.damai.homepage.request;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.hx0;

/* compiled from: Taobao */
public class HomeParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String comboDamaiCityId;

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1368786331")) {
            return hx0.patternName;
        }
        return (String) ipChange.ipc$dispatch("-1368786331", new Object[]{this});
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1631116290")) {
            return "2.4";
        }
        return (String) ipChange.ipc$dispatch("1631116290", new Object[]{this});
    }
}
