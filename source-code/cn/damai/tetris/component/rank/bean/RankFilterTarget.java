package cn.damai.tetris.component.rank.bean;

import cn.damai.tetris.v2.structure.container.ValueTarget;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RankFilterTarget implements ValueTarget<RankFilterValue> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.structure.container.ValueTarget
    public Class<RankFilterValue> getValueClass() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-420510041")) {
            return RankFilterValue.class;
        }
        return (Class) ipChange.ipc$dispatch("-420510041", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.structure.container.ValueTarget
    public RankFilterValue getDefault() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "146887029")) {
            return new RankFilterValue(null, null);
        }
        return (RankFilterValue) ipChange.ipc$dispatch("146887029", new Object[]{this});
    }
}
