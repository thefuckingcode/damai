package tb;

import cn.damai.common.image.DMImageCreator;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.viewholder.CreditExchangeHeaderViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class bp implements DMImageCreator.DMImageSuccListener {
    public final /* synthetic */ CreditExchangeHeaderViewHolder a;

    public /* synthetic */ bp(CreditExchangeHeaderViewHolder creditExchangeHeaderViewHolder) {
        this.a = creditExchangeHeaderViewHolder;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
    public final void onSuccess(DMImageCreator.e eVar) {
        CreditExchangeHeaderViewHolder.e(this.a, eVar);
    }
}
