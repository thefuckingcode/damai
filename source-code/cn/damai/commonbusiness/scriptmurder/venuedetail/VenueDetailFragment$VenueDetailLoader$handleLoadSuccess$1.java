package cn.damai.commonbusiness.scriptmurder.venuedetail;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class VenueDetailFragment$VenueDetailLoader$handleLoadSuccess$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ VenueDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VenueDetailFragment$VenueDetailLoader$handleLoadSuccess$1(VenueDetailFragment venueDetailFragment) {
        super(0);
        this.this$0 = venueDetailFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-545034537")) {
            ipChange.ipc$dispatch("-545034537", new Object[]{this});
            return;
        }
        VenueDetailFragment venueDetailFragment = this.this$0;
        venueDetailFragment.hideLoadingDialog(venueDetailFragment.getActivity());
    }
}
