package tb;

import android.view.View;
import com.alibaba.pictures.bricks.coupon.order.bean.Good;
import com.alibaba.pictures.bricks.coupon.order.view.CouponsViewHolder;
import com.alient.oneservice.ut.TrackInfo;

/* compiled from: Taobao */
public final /* synthetic */ class to implements View.OnClickListener {
    public final /* synthetic */ TrackInfo a;
    public final /* synthetic */ CouponsViewHolder b;
    public final /* synthetic */ Good c;

    public /* synthetic */ to(TrackInfo trackInfo, CouponsViewHolder couponsViewHolder, Good good) {
        this.a = trackInfo;
        this.b = couponsViewHolder;
        this.c = good;
    }

    public final void onClick(View view) {
        CouponsViewHolder.j(this.a, this.b, this.c, view);
    }
}
