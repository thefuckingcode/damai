package tb;

import android.app.Activity;
import android.view.View;
import cn.damai.homepage.ui.view.HomePageGuideBar;

/* compiled from: Taobao */
public final /* synthetic */ class ow0 implements View.OnClickListener {
    public final /* synthetic */ HomePageGuideBar a;
    public final /* synthetic */ Activity b;

    public /* synthetic */ ow0(HomePageGuideBar homePageGuideBar, Activity activity) {
        this.a = homePageGuideBar;
        this.b = activity;
    }

    public final void onClick(View view) {
        HomePageGuideBar.b(this.a, this.b, view);
    }
}
