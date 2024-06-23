package tb;

import android.view.View;
import cn.damai.tetris.component.home.adapter.RecentShowAdapter;
import cn.damai.tetris.component.home.bean.HomePageRecentBean;

/* compiled from: Taobao */
public final /* synthetic */ class mx1 implements View.OnClickListener {
    public final /* synthetic */ RecentShowAdapter.RankItemViewHolder a;
    public final /* synthetic */ int b;
    public final /* synthetic */ HomePageRecentBean.Labels.HomePageRecentItems c;

    public /* synthetic */ mx1(RecentShowAdapter.RankItemViewHolder rankItemViewHolder, int i, HomePageRecentBean.Labels.HomePageRecentItems homePageRecentItems) {
        this.a = rankItemViewHolder;
        this.b = i;
        this.c = homePageRecentItems;
    }

    public final void onClick(View view) {
        this.a.e(this.b, this.c, view);
    }
}
