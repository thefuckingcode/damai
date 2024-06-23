package tb;

import androidx.lifecycle.Observer;
import cn.damai.tetris.component.star.bean.FansRankingBean;
import cn.damai.tetris.component.star.net.FinishTaskResponse;
import cn.damai.tetris.component.star.view.FansRankingViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class yg0 implements Observer {
    public final /* synthetic */ FansRankingViewHolder a;
    public final /* synthetic */ FansRankingBean.TaskBean b;

    public /* synthetic */ yg0(FansRankingViewHolder fansRankingViewHolder, FansRankingBean.TaskBean taskBean) {
        this.a = fansRankingViewHolder;
        this.b = taskBean;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.a.k(this.b, (FinishTaskResponse) obj);
    }
}
