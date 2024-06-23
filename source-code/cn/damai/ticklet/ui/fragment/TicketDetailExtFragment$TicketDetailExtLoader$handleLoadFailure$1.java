package cn.damai.ticklet.ui.fragment;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.page.state.State;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class TicketDetailExtFragment$TicketDetailExtLoader$handleLoadFailure$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ TicketDetailExtFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TicketDetailExtFragment$TicketDetailExtLoader$handleLoadFailure$1(TicketDetailExtFragment ticketDetailExtFragment) {
        super(0);
        this.this$0 = ticketDetailExtFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1233620921")) {
            ipChange.ipc$dispatch("1233620921", new Object[]{this});
        } else if (this.this$0.getPageLoader().getRealItemCount() == 0) {
            this.this$0.getPageStateManager().setState(State.FAILED);
        }
    }
}
