package tb;

import android.view.View;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuPriceDetailFragment;

/* compiled from: Taobao */
public final /* synthetic */ class hh1 implements View.OnClickListener {
    public final /* synthetic */ NcovSkuPriceDetailFragment a;
    public final /* synthetic */ TicketMainUiModel b;

    public /* synthetic */ hh1(NcovSkuPriceDetailFragment ncovSkuPriceDetailFragment, TicketMainUiModel ticketMainUiModel) {
        this.a = ncovSkuPriceDetailFragment;
        this.b = ticketMainUiModel;
    }

    public final void onClick(View view) {
        NcovSkuPriceDetailFragment.a(this.a, this.b, view);
    }
}
