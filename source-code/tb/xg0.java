package tb;

import android.view.View;
import cn.damai.tetris.component.star.bean.FansRankingBean;
import cn.damai.tetris.component.star.view.FansRankingViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class xg0 implements View.OnClickListener {
    public final /* synthetic */ FansRankingViewHolder a;
    public final /* synthetic */ FansRankingBean b;

    public /* synthetic */ xg0(FansRankingViewHolder fansRankingViewHolder, FansRankingBean fansRankingBean) {
        this.a = fansRankingViewHolder;
        this.b = fansRankingBean;
    }

    public final void onClick(View view) {
        this.a.n(this.b, view);
    }
}
