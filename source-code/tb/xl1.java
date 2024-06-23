package tb;

import android.content.DialogInterface;
import cn.damai.trade.coupon.ui.orderdeatile.OrderDetailActivity;

/* compiled from: Taobao */
public final /* synthetic */ class xl1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ OrderDetailActivity a;

    public /* synthetic */ xl1(OrderDetailActivity orderDetailActivity) {
        this.a = orderDetailActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        OrderDetailActivity.b.c(this.a, dialogInterface, i);
    }
}
