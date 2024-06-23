package com.alibaba.pictures.bricks.coupon.order;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class OrderDetailFragment$refresh$4 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ OrderDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OrderDetailFragment$refresh$4(OrderDetailFragment orderDetailFragment) {
        super(0);
        this.this$0 = orderDetailFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "551886189")) {
            ipChange.ipc$dispatch("551886189", new Object[]{this});
            return;
        }
        this.this$0.stopLoading();
    }
}
