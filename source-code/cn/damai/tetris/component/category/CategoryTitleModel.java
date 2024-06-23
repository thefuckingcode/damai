package cn.damai.tetris.component.category;

import cn.damai.tetris.component.category.CategoryTitleContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.NodeData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CategoryTitleModel extends AbsModel implements CategoryTitleContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    boolean hasCurrentCity = false;

    @Override // cn.damai.tetris.component.category.CategoryTitleContract.Model
    public boolean hasCurrentCity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-945756310")) {
            return this.hasCurrentCity;
        }
        return ((Boolean) ipChange.ipc$dispatch("-945756310", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46338209")) {
            ipChange.ipc$dispatch("-46338209", new Object[]{this, baseNode});
            return;
        }
        NodeData item = baseNode.getItem();
        if (item.get("hasCurrentCity") != null) {
            try {
                this.hasCurrentCity = item.getBoolean("hasCurrentCity").booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
