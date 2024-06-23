package tb;

import android.view.View;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.seat.adapter.SeatListDetailV2Adapter;

/* compiled from: Taobao */
public final /* synthetic */ class j72 implements View.OnClickListener {
    public final /* synthetic */ SeatListDetailV2Adapter.ModelTitleViewHolder a;
    public final /* synthetic */ TicketMainUiModel b;

    public /* synthetic */ j72(SeatListDetailV2Adapter.ModelTitleViewHolder modelTitleViewHolder, TicketMainUiModel ticketMainUiModel) {
        this.a = modelTitleViewHolder;
        this.b = ticketMainUiModel;
    }

    public final void onClick(View view) {
        SeatListDetailV2Adapter.ModelTitleViewHolder.c(this.a, this.b, view);
    }
}
