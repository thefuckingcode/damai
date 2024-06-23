package cn.damai.discover.main.param;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class LiveHeaderParam extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 4691762288987561894L;
    public String currentCityId = d20.c();
    public String funcVersion = "1.0";

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2010487383")) {
            return "live";
        }
        return (String) ipChange.ipc$dispatch("-2010487383", new Object[]{this});
    }
}
