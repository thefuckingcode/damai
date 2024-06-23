package tb;

import android.view.View;
import cn.damai.ticklet.ui.detailholder.TicketExtFAQViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class cl2 implements View.OnClickListener {
    public final /* synthetic */ TicketExtFAQViewHolder a;
    public final /* synthetic */ String b;

    public /* synthetic */ cl2(TicketExtFAQViewHolder ticketExtFAQViewHolder, String str) {
        this.a = ticketExtFAQViewHolder;
        this.b = str;
    }

    public final void onClick(View view) {
        TicketExtFAQViewHolder.a(this.a, this.b, view);
    }
}
