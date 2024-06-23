package cn.damai.ticklet.view;

import android.view.View;
import cn.damai.ticklet.bean.TicketNftExtAttr;
import cn.damai.ticklet.net.PrepareIssueRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.br;
import tb.ur2;

/* compiled from: Taobao */
public final class TickletNFTTicketItemView$handleNFTAction$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ View $partent;
    final /* synthetic */ TickletNFTTicketItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TickletNFTTicketItemView$handleNFTAction$1(TickletNFTTicketItemView tickletNFTTicketItemView, View view) {
        super(0);
        this.this$0 = tickletNFTTicketItemView;
        this.$partent = view;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "670154128")) {
            ipChange.ipc$dispatch("670154128", new Object[]{this});
            return;
        }
        PrepareIssueRequest prepareIssueRequest = new PrepareIssueRequest();
        prepareIssueRequest.voucherUniqueKey = this.this$0.mVoucherUniqueKey;
        prepareIssueRequest.request(new TickletNFTTicketItemView$handleNFTAction$1$listener$1(this.$partent, this.this$0, TicketNftExtAttr.class));
        br.c(TickletNFTTicketItemView.NFT_LOADING_ACTION, Boolean.TRUE);
    }
}
