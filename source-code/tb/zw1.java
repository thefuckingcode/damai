package tb;

import android.view.View;
import cn.damai.tetris.component.rank.RankFilterViewManager;

/* compiled from: Taobao */
public final /* synthetic */ class zw1 implements View.OnClickListener {
    public final /* synthetic */ RankFilterViewManager a;

    public /* synthetic */ zw1(RankFilterViewManager rankFilterViewManager) {
        this.a = rankFilterViewManager;
    }

    public final void onClick(View view) {
        RankFilterViewManager.c(this.a, view);
    }
}
