package tb;

import android.view.View;
import com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;

/* compiled from: Taobao */
public final /* synthetic */ class im1 implements View.OnClickListener {
    public final /* synthetic */ OrderDetail a;
    public final /* synthetic */ OrderDetailFragment b;

    public /* synthetic */ im1(OrderDetail orderDetail, OrderDetailFragment orderDetailFragment) {
        this.a = orderDetail;
        this.b = orderDetailFragment;
    }

    public final void onClick(View view) {
        OrderDetailFragment.m156bottomViewRender$lambda9(this.a, this.b, view);
    }
}
