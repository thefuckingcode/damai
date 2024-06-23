package cn.damai.dramachannel.model;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class DramaCommingParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId = d20.c();
    public String comboDamaiCityId = d20.c();

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1290911427")) {
            return "category_drama_second";
        }
        return (String) ipChange.ipc$dispatch("-1290911427", new Object[]{this});
    }
}
