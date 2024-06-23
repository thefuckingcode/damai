package tb;

import android.view.View;
import cn.damai.tetris.component.star.view.FansRankingViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class vg0 implements View.OnClickListener {
    public final /* synthetic */ FansRankingViewHolder a;
    public final /* synthetic */ int b;

    public /* synthetic */ vg0(FansRankingViewHolder fansRankingViewHolder, int i) {
        this.a = fansRankingViewHolder;
        this.b = i;
    }

    public final void onClick(View view) {
        this.a.m(this.b, view);
    }
}
