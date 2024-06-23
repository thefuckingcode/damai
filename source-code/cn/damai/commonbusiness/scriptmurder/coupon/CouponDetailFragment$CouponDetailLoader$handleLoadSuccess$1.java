package cn.damai.commonbusiness.scriptmurder.coupon;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class CouponDetailFragment$CouponDetailLoader$handleLoadSuccess$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ CouponDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CouponDetailFragment$CouponDetailLoader$handleLoadSuccess$1(CouponDetailFragment couponDetailFragment) {
        super(0);
        this.this$0 = couponDetailFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "575533845")) {
            ipChange.ipc$dispatch("575533845", new Object[]{this});
            return;
        }
        CouponDetailFragment couponDetailFragment = this.this$0;
        couponDetailFragment.hideLoadingDialog(couponDetailFragment.getActivity());
    }
}
