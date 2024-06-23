package tb;

import android.view.View;
import com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;

/* compiled from: Taobao */
public final /* synthetic */ class hm1 implements View.OnClickListener {
    public final /* synthetic */ OrderDetailFragment a;
    public final /* synthetic */ OrderDetail b;

    public /* synthetic */ hm1(OrderDetailFragment orderDetailFragment, OrderDetail orderDetail) {
        this.a = orderDetailFragment;
        this.b = orderDetail;
    }

    public final void onClick(View view) {
        OrderDetailFragment.m152bottomViewRender$lambda13(this.a, this.b, view);
    }
}
