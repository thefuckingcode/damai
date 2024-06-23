package cn.damai.tetris.mvp;

import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.NodeData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommonModel extends AbsModel implements CommonContract$Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private NodeData data;

    @Override // cn.damai.tetris.mvp.CommonContract$Model
    public NodeData getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1236759326")) {
            return this.data;
        }
        return (NodeData) ipChange.ipc$dispatch("-1236759326", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1406051831")) {
            ipChange.ipc$dispatch("1406051831", new Object[]{this, baseNode});
            return;
        }
        this.data = baseNode.getItem();
    }
}
