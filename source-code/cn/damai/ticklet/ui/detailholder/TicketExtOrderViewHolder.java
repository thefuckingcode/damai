package cn.damai.ticklet.ui.detailholder;

import android.os.Bundle;
import android.view.View;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.ticklet.bean.TicketExtServiceBean;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.page.GenericFragment;
import org.jetbrains.annotations.NotNull;
import tb.eo1;
import tb.k21;
import tb.sl2;

/* compiled from: Taobao */
public final class TicketExtOrderViewHolder extends TicketExtServiceViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TicketExtOrderViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
    }

    private final void goOrderPage(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1298194835")) {
            ipChange.ipc$dispatch("1298194835", new Object[]{this, str, str2, str3, str4});
        } else if (!k21.d("0", str4)) {
            c.e().x(b.getInstance().e(sl2.TICKLET_DETAIL_PAGE, "ticket_info", "orderinfo", sl2.j().s(str2, str), Boolean.TRUE));
            if (!(str3 == null || str3.length() == 0)) {
                if (!(str4 == null || str4.length() == 0)) {
                    z = false;
                }
                if (!z) {
                    eo1.a(getContext(), str3, str4, str2);
                    return;
                }
            }
            eo1.a(getContext(), null, str4, str2);
        }
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, cn.damai.ticklet.ui.detailholder.TicketExtServiceViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1102835759")) {
            ipChange.ipc$dispatch("1102835759", new Object[]{this, iItem});
            return;
        }
        k21.i(iItem, "item");
        super.bindData(iItem);
        if (((TicketExtServiceBean) getValue()).isHideArrowProhibitJump()) {
            getArrowView().setVisibility(8);
        }
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1377829210")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1377829210", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2053705625")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("2053705625", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1020379409")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1020379409", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public void onItemClick(@NotNull View view) {
        IContext pageContext;
        GenericFragment fragment;
        Bundle arguments;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-85648408")) {
            ipChange.ipc$dispatch("-85648408", new Object[]{this, view});
            return;
        }
        k21.i(view, "view");
        super.onItemClick(view);
        IItem data = getData();
        if (data != null && (pageContext = data.getPageContext()) != null && (fragment = pageContext.getFragment()) != null && (arguments = fragment.getArguments()) != null) {
            goOrderPage(arguments.getString(TicketDetailExtFragment.PERFORM_ID), arguments.getString("projectId"), ((TicketExtServiceBean) getValue()).getOrderId(), ((TicketExtServiceBean) getValue()).getOrderDetailSource());
        }
    }
}
