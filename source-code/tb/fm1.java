package tb;

import android.view.View;
import com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;

/* compiled from: Taobao */
public final /* synthetic */ class fm1 implements View.OnClickListener {
    public final /* synthetic */ OrderDetailFragment a;
    public final /* synthetic */ OrderDetail b;

    public /* synthetic */ fm1(OrderDetailFragment orderDetailFragment, OrderDetail orderDetail) {
        this.a = orderDetailFragment;
        this.b = orderDetail;
    }

    public final void onClick(View view) {
        OrderDetailFragment.m153bottomViewRender$lambda15(this.a, this.b, view);
    }
}
