package cn.damai.dramachannel.bean;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class DramaParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId = d20.c();
    public String comboDamaiCityId = d20.c();
    public String currentCityId = d20.c();
    public String sortType = "10";

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1746091414")) {
            return "category_drama_new";
        }
        return (String) ipChange.ipc$dispatch("-1746091414", new Object[]{this});
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "109211271")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("109211271", new Object[]{this});
    }
}
