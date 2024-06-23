package tb;

import android.app.Activity;
import android.view.View;
import cn.damai.homepage.ui.view.HomePageGuideBar;

/* compiled from: Taobao */
public final /* synthetic */ class mw0 implements View.OnClickListener {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ HomePageGuideBar b;

    public /* synthetic */ mw0(Activity activity, HomePageGuideBar homePageGuideBar) {
        this.a = activity;
        this.b = homePageGuideBar;
    }

    public final void onClick(View view) {
        HomePageGuideBar.e(this.a, this.b, view);
    }
}
