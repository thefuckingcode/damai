package cn.damai.tetris.component.common;

import cn.damai.tetris.component.common.ExpandTextContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ExpandTextModel extends AbsModel implements ExpandTextContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    String content;

    @Override // cn.damai.tetris.component.common.ExpandTextContract.Model
    public String getContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-597520765")) {
            return this.content;
        }
        return (String) ipChange.ipc$dispatch("-597520765", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1498493137")) {
            ipChange.ipc$dispatch("-1498493137", new Object[]{this, baseNode});
        } else if (baseNode != null && baseNode.getItem() != null) {
            this.content = baseNode.getItem().getString("ipIntroduce");
        }
    }
}
