package tb;

import com.alibaba.pictures.bricks.orderresult.CouponPayResultFragment;
import com.alibaba.pictures.bricks.view.irecycler.OnRefreshListener;

/* compiled from: Taobao */
public final /* synthetic */ class jo implements OnRefreshListener {
    public final /* synthetic */ CouponPayResultFragment a;

    public /* synthetic */ jo(CouponPayResultFragment couponPayResultFragment) {
        this.a = couponPayResultFragment;
    }

    @Override // com.alibaba.pictures.bricks.view.irecycler.OnRefreshListener
    public final void onRefresh() {
        CouponPayResultFragment.m171onFreshListener$lambda0(this.a);
    }
}
