package cn.damai.tetris.component.rank.bean;

import cn.damai.tetris.v2.structure.container.ValueTarget;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class RankCityIdTarget implements ValueTarget<RankCityValue> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.structure.container.ValueTarget
    public Class<RankCityValue> getValueClass() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1351339527")) {
            return RankCityValue.class;
        }
        return (Class) ipChange.ipc$dispatch("-1351339527", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.structure.container.ValueTarget
    public RankCityValue getDefault() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-414898090")) {
            return new RankCityValue(d20.c(), d20.d());
        }
        return (RankCityValue) ipChange.ipc$dispatch("-414898090", new Object[]{this});
    }
}
