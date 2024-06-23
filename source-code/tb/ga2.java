package tb;

import cn.damai.commonbusiness.scriptmurder.shopdetail.ShopDetailFragment;
import com.youku.kubus.Event;

/* compiled from: Taobao */
public final /* synthetic */ class ga2 implements Runnable {
    public final /* synthetic */ ShopDetailFragment a;
    public final /* synthetic */ Event b;

    public /* synthetic */ ga2(ShopDetailFragment shopDetailFragment, Event event) {
        this.a = shopDetailFragment;
        this.b = event;
    }

    public final void run() {
        ShopDetailFragment.m12onMessageGet$lambda3$lambda2(this.a, this.b);
    }
}
