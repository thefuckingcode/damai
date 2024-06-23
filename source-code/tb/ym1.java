package tb;

import android.view.View;
import com.alibaba.pictures.bricks.orderconfirm.OrderPriceInfoViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class ym1 implements View.OnClickListener {
    public final /* synthetic */ OrderPriceInfoViewHolder a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ ym1(OrderPriceInfoViewHolder orderPriceInfoViewHolder, String str, String str2) {
        this.a = orderPriceInfoViewHolder;
        this.b = str;
        this.c = str2;
    }

    public final void onClick(View view) {
        OrderPriceInfoViewHolder.i(this.a, this.b, this.c, view);
    }
}
