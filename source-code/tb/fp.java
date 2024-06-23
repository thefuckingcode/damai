package tb;

import cn.damai.common.image.DMImageCreator;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.viewholder.CreditExchangeInfoViewHolder;
import com.alibaba.pictures.moimage.MoImageView;

/* compiled from: Taobao */
public final /* synthetic */ class fp implements DMImageCreator.DMImageSuccListener {
    public final /* synthetic */ CreditExchangeInfoViewHolder a;
    public final /* synthetic */ MoImageView b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ fp(CreditExchangeInfoViewHolder creditExchangeInfoViewHolder, MoImageView moImageView, boolean z) {
        this.a = creditExchangeInfoViewHolder;
        this.b = moImageView;
        this.c = z;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
    public final void onSuccess(DMImageCreator.e eVar) {
        CreditExchangeInfoViewHolder.g(this.a, this.b, this.c, eVar);
    }
}
