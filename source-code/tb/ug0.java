package tb;

import android.content.DialogInterface;
import cn.damai.tetris.component.star.view.FansRankingViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class ug0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ FansRankingViewHolder a;
    public final /* synthetic */ int b;

    public /* synthetic */ ug0(FansRankingViewHolder fansRankingViewHolder, int i) {
        this.a = fansRankingViewHolder;
        this.b = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.l(this.b, dialogInterface, i);
    }
}
