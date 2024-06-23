package tb;

import android.view.View;
import cn.damai.tetris.component.rank.RankListItemHolder;

/* compiled from: Taobao */
public final /* synthetic */ class bx1 implements View.OnClickListener {
    public final /* synthetic */ RankListItemHolder a;

    public /* synthetic */ bx1(RankListItemHolder rankListItemHolder) {
        this.a = rankListItemHolder;
    }

    public final void onClick(View view) {
        RankListItemHolder.d(this.a, view);
    }
}
