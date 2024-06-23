package tb;

import android.view.View;
import cn.damai.homepage.ui.view.HomePageGuideBar;
import com.alibaba.pictures.bricks.view.DMUpMarqueeView;

/* compiled from: Taobao */
public final /* synthetic */ class sw0 implements DMUpMarqueeView.OnItemClickListener {
    public final /* synthetic */ HomePageGuideBar a;

    public /* synthetic */ sw0(HomePageGuideBar homePageGuideBar) {
        this.a = homePageGuideBar;
    }

    @Override // com.alibaba.pictures.bricks.view.DMUpMarqueeView.OnItemClickListener
    public final void onItemClick(int i, View view) {
        HomePageGuideBar.g(this.a, i, view);
    }
}
