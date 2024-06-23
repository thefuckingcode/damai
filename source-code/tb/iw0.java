package tb;

import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.v2.HomePageFragment;

/* compiled from: Taobao */
public final /* synthetic */ class iw0 implements Runnable {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ int b;

    public /* synthetic */ iw0(RecyclerView recyclerView, int i) {
        this.a = recyclerView;
        this.b = i;
    }

    public final void run() {
        HomePageFragment.m47xe042fecd(this.a, this.b);
    }
}
