package tb;

import android.view.View;
import cn.damai.tetris.component.star.bean.FansRankingBean;
import cn.damai.tetris.component.star.view.FansRankingViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class wg0 implements View.OnClickListener {
    public final /* synthetic */ FansRankingViewHolder a;
    public final /* synthetic */ FansRankingBean b;

    public /* synthetic */ wg0(FansRankingViewHolder fansRankingViewHolder, FansRankingBean fansRankingBean) {
        this.a = fansRankingViewHolder;
        this.b = fansRankingBean;
    }

    public final void onClick(View view) {
        this.a.o(this.b, view);
    }
}
