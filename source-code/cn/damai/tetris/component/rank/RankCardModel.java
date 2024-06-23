package cn.damai.tetris.component.rank;

import cn.damai.tetris.component.rank.RankCardContract;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class RankCardModel extends AbsModel implements RankCardContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    RankItemBean itemBean;

    @Override // cn.damai.tetris.component.rank.RankCardContract.Model
    public RankItemBean getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "635620847")) {
            return this.itemBean;
        }
        return (RankItemBean) ipChange.ipc$dispatch("635620847", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1634298627")) {
            ipChange.ipc$dispatch("1634298627", new Object[]{this, baseNode});
        } else if (baseNode != null) {
            try {
                this.itemBean = (RankItemBean) s41.d(baseNode.getItem(), RankItemBean.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
