package cn.damai.tetris.component.discover.mvp;

import android.view.View;
import cn.damai.comment.view.DMHotDiscussView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.discover.mvp.DiscussContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DiscussView extends AbsView<DiscussContract.Presenter> implements DiscussContract.View<DiscussContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMHotDiscussView dmHotDiscussView;
    private View titleLayout;

    public DiscussView(View view) {
        super(view);
        this.dmHotDiscussView = (DMHotDiscussView) view.findViewById(R$id.theme_discuss_view);
        this.titleLayout = view.findViewById(R$id.item_feed_vote_ui);
    }

    @Override // cn.damai.tetris.component.discover.mvp.DiscussContract.View
    public DMHotDiscussView getHotDiscussView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-297543582")) {
            return this.dmHotDiscussView;
        }
        return (DMHotDiscussView) ipChange.ipc$dispatch("-297543582", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.discover.mvp.DiscussContract.View
    public View getTitleView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "308529044")) {
            return this.titleLayout;
        }
        return (View) ipChange.ipc$dispatch("308529044", new Object[]{this});
    }
}
