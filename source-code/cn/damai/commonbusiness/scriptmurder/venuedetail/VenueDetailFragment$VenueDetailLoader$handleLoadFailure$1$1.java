package cn.damai.commonbusiness.scriptmurder.venuedetail;

import androidx.fragment.app.FragmentActivity;
import cn.damai.common.net.mtop.Util;
import cn.damai.common.util.toastutil.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.page.state.State;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class VenueDetailFragment$VenueDetailLoader$handleLoadFailure$1$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IResponse $response;
    final /* synthetic */ FragmentActivity $this_apply;
    final /* synthetic */ VenueDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VenueDetailFragment$VenueDetailLoader$handleLoadFailure$1$1(VenueDetailFragment venueDetailFragment, FragmentActivity fragmentActivity, IResponse iResponse) {
        super(0);
        this.this$0 = venueDetailFragment;
        this.$this_apply = fragmentActivity;
        this.$response = iResponse;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-225705493")) {
            ipChange.ipc$dispatch("-225705493", new Object[]{this});
            return;
        }
        this.this$0.hideLoadingDialog(this.$this_apply);
        String errorMsg = Util.getErrorMsg(this.$response.getRetCode(), this.$response.getRetMessage());
        if (this.this$0.getPageLoader().getRealItemCount() > 0) {
            a.i(this.$this_apply, errorMsg);
        } else {
            this.this$0.getPageStateManager().setState(State.FAILED);
        }
    }
}
