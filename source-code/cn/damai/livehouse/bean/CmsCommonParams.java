package cn.damai.livehouse.bean;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;
import tb.wj2;

/* compiled from: Taobao */
public class CmsCommonParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId = d20.c();
    public String comboDamaiCityId = d20.c();
    public String currentCityId = d20.c();

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-425081129")) {
            return wj2.PROJECT_FILTER_OPTION_C_ID;
        }
        return (String) ipChange.ipc$dispatch("-425081129", new Object[]{this});
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-953896588")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-953896588", new Object[]{this});
    }
}
