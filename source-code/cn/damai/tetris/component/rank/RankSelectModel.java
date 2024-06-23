package cn.damai.tetris.component.rank;

import cn.damai.tetris.component.rank.RankSelectContract;
import cn.damai.tetris.component.rank.bean.RankSelectBean;
import cn.damai.tetris.component.rank.bean.RankSelectItemBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.f92;
import tb.k21;
import tb.s41;

/* compiled from: Taobao */
public final class RankSelectModel extends AbsModel<RankSelectBean> implements RankSelectContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private RankSelectBean bean;

    @Override // cn.damai.tetris.component.rank.RankSelectContract.Model
    @Nullable
    public RankSelectBean getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-936518016")) {
            return this.bean;
        }
        return (RankSelectBean) ipChange.ipc$dispatch("-936518016", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(@NotNull BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1214505327")) {
            ipChange.ipc$dispatch("1214505327", new Object[]{this, baseNode});
            return;
        }
        k21.i(baseNode, "baseNode");
        this.bean = (RankSelectBean) s41.d(baseNode.getItem(), RankSelectBean.class);
        if (getBean() != null) {
            RankSelectBean bean2 = getBean();
            k21.f(bean2);
            List<RankSelectItemBean> list = bean2.result;
            if (!f92.d(list)) {
                k21.f(list);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    RankSelectItemBean rankSelectItemBean = list.get(i);
                    k21.f(rankSelectItemBean);
                    rankSelectItemBean.pos = i;
                }
            }
        }
    }
}
