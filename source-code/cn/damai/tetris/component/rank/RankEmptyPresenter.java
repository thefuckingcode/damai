package cn.damai.tetris.component.rank;

import cn.damai.tetris.component.rank.RankEmptyContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public class RankEmptyPresenter extends BasePresenter<RankEmptyContract.Model, RankEmptyContract.View, BaseSection> implements RankEmptyContract.Presenter<RankEmptyContract.Model, RankEmptyContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public RankEmptyPresenter(RankEmptyView rankEmptyView, String str, w9 w9Var) {
        super(rankEmptyView, str, w9Var);
    }

    public void init(RankEmptyContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-469452393")) {
            ipChange.ipc$dispatch("-469452393", new Object[]{this, model});
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "320995607")) {
            ipChange.ipc$dispatch("320995607", new Object[]{this, Integer.valueOf(i), obj});
        }
    }
}
