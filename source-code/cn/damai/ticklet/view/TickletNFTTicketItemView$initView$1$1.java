package cn.damai.ticklet.view;

import android.view.View;
import cn.damai.ticklet.bean.PerformNftExtAttr;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class TickletNFTTicketItemView$initView$1$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ View $partent;
    final /* synthetic */ TickletNFTTicketItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TickletNFTTicketItemView$initView$1$1(TickletNFTTicketItemView tickletNFTTicketItemView, View view) {
        super(0);
        this.this$0 = tickletNFTTicketItemView;
        this.$partent = view;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1852693528")) {
            ipChange.ipc$dispatch("1852693528", new Object[]{this});
            return;
        }
        PerformNftExtAttr performNftExtAttr = this.this$0.mPerformData;
        if (performNftExtAttr != null) {
            TickletNFTTicketItemView tickletNFTTicketItemView = this.this$0;
            View view = this.$partent;
            k21.h(view, "partent");
            tickletNFTTicketItemView.handleNFTAction(view, performNftExtAttr);
        }
    }
}
