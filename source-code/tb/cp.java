package tb;

import android.graphics.Bitmap;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.viewholder.CreditExchangeHeaderViewHolder;
import com.alibaba.pictures.moimage.MoImageView;

/* compiled from: Taobao */
public final /* synthetic */ class cp implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ MoImageView b;

    public /* synthetic */ cp(Bitmap bitmap, MoImageView moImageView) {
        this.a = bitmap;
        this.b = moImageView;
    }

    public final void run() {
        CreditExchangeHeaderViewHolder.h(this.a, this.b);
    }
}
