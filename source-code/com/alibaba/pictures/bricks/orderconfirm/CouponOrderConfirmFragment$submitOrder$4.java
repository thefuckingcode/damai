package com.alibaba.pictures.bricks.orderconfirm;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class CouponOrderConfirmFragment$submitOrder$4 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ CouponOrderConfirmFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CouponOrderConfirmFragment$submitOrder$4(CouponOrderConfirmFragment couponOrderConfirmFragment) {
        super(0);
        this.this$0 = couponOrderConfirmFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "38329288")) {
            ipChange.ipc$dispatch("38329288", new Object[]{this});
            return;
        }
        this.this$0.hideLoadingDialog();
    }
}
