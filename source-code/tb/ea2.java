package tb;

import cn.damai.commonbusiness.scriptmurder.shopdetail.ShopDetailActivity;
import cn.damai.commonbusiness.view.StopAbleViewFlipper;

/* compiled from: Taobao */
public final /* synthetic */ class ea2 implements StopAbleViewFlipper.ChangeListener {
    public final /* synthetic */ ShopDetailActivity a;

    public /* synthetic */ ea2(ShopDetailActivity shopDetailActivity) {
        this.a = shopDetailActivity;
    }

    @Override // cn.damai.commonbusiness.view.StopAbleViewFlipper.ChangeListener
    public final void onViewEnd() {
        ShopDetailActivity.m10initFlipper$lambda10(this.a);
    }
}
