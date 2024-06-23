package tb;

import android.view.View;
import com.alibaba.pictures.bricks.orderconfirm.OrderPriceInfoViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class xm1 implements View.OnClickListener {
    public final /* synthetic */ OrderPriceInfoViewHolder a;
    public final /* synthetic */ String b;

    public /* synthetic */ xm1(OrderPriceInfoViewHolder orderPriceInfoViewHolder, String str) {
        this.a = orderPriceInfoViewHolder;
        this.b = str;
    }

    public final void onClick(View view) {
        OrderPriceInfoViewHolder.g(this.a, this.b, view);
    }
}
