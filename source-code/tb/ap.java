package tb;

import cn.damai.common.image.DMImageCreator;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.viewholder.CreditExchangeHeaderViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class ap implements DMImageCreator.DMImageFailListener {
    public final /* synthetic */ CreditExchangeHeaderViewHolder a;

    public /* synthetic */ ap(CreditExchangeHeaderViewHolder creditExchangeHeaderViewHolder) {
        this.a = creditExchangeHeaderViewHolder;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
    public final void onFail(DMImageCreator.d dVar) {
        CreditExchangeHeaderViewHolder.f(this.a, dVar);
    }
}
