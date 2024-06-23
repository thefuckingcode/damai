package cn.damai.tetris.component.rank;

import android.view.View;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.tetris.component.rank.RankProjectContract;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class RankProjectView extends AbsView<RankProjectPresenter> implements RankProjectContract.View<RankProjectPresenter>, OnItemClickListener<RankItemBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final RankListItemHolder mHolder;

    public RankProjectView(@Nullable View view) {
        super(view);
        this.mHolder = new RankListItemHolder(view, this);
    }

    @Override // cn.damai.tetris.component.rank.RankProjectContract.View
    public void setData(@Nullable RankItemBean rankItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "302239423")) {
            ipChange.ipc$dispatch("302239423", new Object[]{this, rankItemBean, Integer.valueOf(i)});
            return;
        }
        this.mHolder.a(rankItemBean, i);
    }

    @Override // cn.damai.tetris.component.rank.RankProjectContract.View
    public void updateFollowState(@Nullable FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "930004997")) {
            ipChange.ipc$dispatch("930004997", new Object[]{this, followDataBean});
            return;
        }
        RankListItemHolder rankListItemHolder = this.mHolder;
        k21.f(followDataBean);
        rankListItemHolder.updateFollowState(followDataBean);
    }

    public void onItemClick(@Nullable RankItemBean rankItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1728317737")) {
            ipChange.ipc$dispatch("1728317737", new Object[]{this, rankItemBean, Integer.valueOf(i)});
            return;
        }
        RankProjectPresenter rankProjectPresenter = (RankProjectPresenter) getPresenter();
        RankItemBean rankItemBean2 = this.mHolder.b;
        if (rankItemBean2 != null && rankProjectPresenter != null) {
            rankProjectPresenter.itemClick(this, rankItemBean2, i);
        }
    }

    public void onWantSeeClick(@Nullable RankItemBean rankItemBean, int i, @NotNull FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "198760834")) {
            ipChange.ipc$dispatch("198760834", new Object[]{this, rankItemBean, Integer.valueOf(i), followDataBean});
            return;
        }
        k21.i(followDataBean, "followDataBean");
        RankProjectPresenter rankProjectPresenter = (RankProjectPresenter) getPresenter();
        RankItemBean rankItemBean2 = this.mHolder.b;
        if (rankItemBean2 != null && rankProjectPresenter != null) {
            rankProjectPresenter.wantSeeClick(this, rankItemBean2, i, followDataBean);
        }
    }
}
