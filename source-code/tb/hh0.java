package tb;

import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.v2.feed.container.FeedTabContainer;

/* compiled from: Taobao */
public final /* synthetic */ class hh0 implements Runnable {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ int b;

    public /* synthetic */ hh0(RecyclerView recyclerView, int i) {
        this.a = recyclerView;
        this.b = i;
    }

    public final void run() {
        FeedTabContainer.m49scrollToTop$lambda3$lambda2$lambda1(this.a, this.b);
    }
}
