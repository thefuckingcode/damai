package tb;

import com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment;
import com.alibaba.pictures.bricks.view.LinearPullToRefreshView;

/* compiled from: Taobao */
public final /* synthetic */ class jm1 implements LinearPullToRefreshView.OnRefreshListener {
    public final /* synthetic */ OrderDetailFragment a;

    public /* synthetic */ jm1(OrderDetailFragment orderDetailFragment) {
        this.a = orderDetailFragment;
    }

    @Override // com.alibaba.pictures.bricks.view.LinearPullToRefreshView.OnRefreshListener
    public final void onRefresh() {
        OrderDetailFragment.m157initView$lambda0(this.a);
    }
}
