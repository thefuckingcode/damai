package tb;

import android.view.View;
import com.alibaba.pictures.bricks.coupon.order.bean.Good;
import com.alibaba.pictures.bricks.coupon.order.view.CouponsViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class ro implements View.OnClickListener {
    public final /* synthetic */ CouponsViewHolder a;
    public final /* synthetic */ Good b;

    public /* synthetic */ ro(CouponsViewHolder couponsViewHolder, Good good) {
        this.a = couponsViewHolder;
        this.b = good;
    }

    public final void onClick(View view) {
        CouponsViewHolder.l(this.a, this.b, view);
    }
}
