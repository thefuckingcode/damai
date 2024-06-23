package tb;

import cn.damai.homepage.ui.view.HomePageGuideBar;
import cn.damai.message.observer.Action;

/* compiled from: Taobao */
public final /* synthetic */ class rw0 implements Action {
    public final /* synthetic */ HomePageGuideBar a;

    public /* synthetic */ rw0(HomePageGuideBar homePageGuideBar) {
        this.a = homePageGuideBar;
    }

    @Override // cn.damai.message.observer.Action
    public final void call(Object obj) {
        HomePageGuideBar.a(this.a, obj);
    }
}
