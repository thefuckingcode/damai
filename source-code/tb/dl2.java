package tb;

import android.view.View;
import cn.damai.ticklet.ui.detailholder.TicketExtFAQViewHolder;

/* compiled from: Taobao */
public final /* synthetic */ class dl2 implements View.OnClickListener {
    public final /* synthetic */ TicketExtFAQViewHolder a;
    public final /* synthetic */ String b;

    public /* synthetic */ dl2(TicketExtFAQViewHolder ticketExtFAQViewHolder, String str) {
        this.a = ticketExtFAQViewHolder;
        this.b = str;
    }

    public final void onClick(View view) {
        TicketExtFAQViewHolder.c(this.a, this.b, view);
    }
}
