package com.alibaba.pictures.bricks.orderresult;

import com.alibaba.pictures.bricks.view.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* compiled from: Taobao */
public final class CouponPayResultFragment$requestPayResultData$4 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ CouponPayResultFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CouponPayResultFragment$requestPayResultData$4(CouponPayResultFragment couponPayResultFragment) {
        super(0);
        this.this$0 = couponPayResultFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1439501098")) {
            ipChange.ipc$dispatch("1439501098", new Object[]{this});
            return;
        }
        IRecyclerView mGaiaXRecyclerView = this.this$0.getMGaiaXRecyclerView();
        if (mGaiaXRecyclerView != null) {
            mGaiaXRecyclerView.setRefreshing(false);
        }
    }
}
