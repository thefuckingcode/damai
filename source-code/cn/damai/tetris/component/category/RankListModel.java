package cn.damai.tetris.component.category;

import cn.damai.commonbusiness.rank.RankItemBean;
import cn.damai.tetris.component.category.RankListContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;
import tb.s71;

/* compiled from: Taobao */
public class RankListModel extends AbsModel implements RankListContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    RankItemBean bean1;
    int index;

    @Override // cn.damai.tetris.component.category.RankListContract.Model
    public RankItemBean getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1485383708")) {
            return this.bean1;
        }
        return (RankItemBean) ipChange.ipc$dispatch("1485383708", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.category.RankListContract.Model
    public int getIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-813439065")) {
            return this.index;
        }
        return ((Integer) ipChange.ipc$dispatch("-813439065", new Object[]{this})).intValue();
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-180249985")) {
            ipChange.ipc$dispatch("-180249985", new Object[]{this, baseNode});
            return;
        }
        this.index = baseNode.getOffset();
        RankListBean rankListBean = (RankListBean) s41.d(baseNode.getItem(), RankListBean.class);
        if (rankListBean != null) {
            RankItemBean rankItemBean = new RankItemBean();
            this.bean1 = rankItemBean;
            rankItemBean.type = 1;
            if (!s71.a(rankListBean.verticalPicList) && rankListBean.verticalPicList.get(0) != null) {
                this.bean1.pic = rankListBean.verticalPicList.get(0);
            }
            RankItemBean rankItemBean2 = this.bean1;
            rankItemBean2.shortName = rankListBean.shortName;
            rankItemBean2.shortDesc = rankListBean.shortDesc;
            rankItemBean2.followDesc = rankListBean.followDesc;
            rankItemBean2.id = rankListBean.id;
        }
    }
}
