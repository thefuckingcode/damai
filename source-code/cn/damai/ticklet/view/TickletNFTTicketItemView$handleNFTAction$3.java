package cn.damai.ticklet.view;

import cn.damai.common.util.toastutil.a;
import cn.damai.ticklet.bean.PerformNftExtAttr;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class TickletNFTTicketItemView$handleNFTAction$3 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ PerformNftExtAttr $data;
    final /* synthetic */ TickletNFTTicketItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TickletNFTTicketItemView$handleNFTAction$3(TickletNFTTicketItemView tickletNFTTicketItemView, PerformNftExtAttr performNftExtAttr) {
        super(0);
        this.this$0 = tickletNFTTicketItemView;
        this.$data = performNftExtAttr;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83348114")) {
            ipChange.ipc$dispatch("83348114", new Object[]{this});
            return;
        }
        a.i(this.this$0.getContext(), this.$data.nftUserValidateMessage);
    }
}
