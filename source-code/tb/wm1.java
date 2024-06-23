package tb;

import android.view.View;
import com.alibaba.pictures.bricks.orderconfirm.OrderPriceInfoViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class wm1 implements View.OnClickListener {
    public final /* synthetic */ OrderPriceInfoViewHolder a;
    public final /* synthetic */ String b;

    public /* synthetic */ wm1(OrderPriceInfoViewHolder orderPriceInfoViewHolder, String str) {
        this.a = orderPriceInfoViewHolder;
        this.b = str;
    }

    public final void onClick(View view) {
        OrderPriceInfoViewHolder.h(this.a, this.b, view);
    }
}
