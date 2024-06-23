package tb;

import android.app.Activity;
import android.view.View;
import cn.damai.homepage.ui.view.HomePageGuideBar;

/* compiled from: Taobao */
public final /* synthetic */ class qw0 implements View.OnClickListener {
    public final /* synthetic */ HomePageGuideBar a;
    public final /* synthetic */ Activity b;

    public /* synthetic */ qw0(HomePageGuideBar homePageGuideBar, Activity activity) {
        this.a = homePageGuideBar;
        this.b = activity;
    }

    public final void onClick(View view) {
        HomePageGuideBar.d(this.a, this.b, view);
    }
}
