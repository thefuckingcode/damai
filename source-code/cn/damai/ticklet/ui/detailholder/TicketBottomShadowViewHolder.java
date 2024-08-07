package cn.damai.ticklet.ui.detailholder;

import android.view.View;
import cn.damai.ticklet.bean.TicketExtServiceBean;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class TicketBottomShadowViewHolder extends BaseViewHolder<TicketExtServiceBean> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TicketBottomShadowViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1815018511")) {
            ipChange.ipc$dispatch("-1815018511", new Object[]{this, iItem});
            return;
        }
        k21.i(iItem, "item");
    }
}
