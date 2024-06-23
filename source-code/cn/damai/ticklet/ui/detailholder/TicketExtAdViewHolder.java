package cn.damai.ticklet.ui.detailholder;

import android.view.View;
import cn.damai.ticklet.bean.TicketExtAdBean;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class TicketExtAdViewHolder extends BaseViewHolder<TicketExtAdBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private TickletDetailAdvertItemViewHolder viewHolder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TicketExtAdViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.viewHolder = new TickletDetailAdvertItemViewHolder(view);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "13484158")) {
            ipChange.ipc$dispatch("13484158", new Object[]{this, iItem});
            return;
        }
        k21.i(iItem, "item");
        this.viewHolder.b((TicketExtAdBean) getValue());
    }

    @NotNull
    public final TickletDetailAdvertItemViewHolder getViewHolder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "814687161")) {
            return this.viewHolder;
        }
        return (TickletDetailAdvertItemViewHolder) ipChange.ipc$dispatch("814687161", new Object[]{this});
    }

    public final void setViewHolder(@NotNull TickletDetailAdvertItemViewHolder tickletDetailAdvertItemViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "254740967")) {
            ipChange.ipc$dispatch("254740967", new Object[]{this, tickletDetailAdvertItemViewHolder});
            return;
        }
        k21.i(tickletDetailAdvertItemViewHolder, "<set-?>");
        this.viewHolder = tickletDetailAdvertItemViewHolder;
    }
}
