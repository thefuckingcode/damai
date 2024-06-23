package com.alibaba.pictures.bricks.orderconfirm;

import android.view.View;
import com.alibaba.pictures.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class CouponOrderConfirmFragment$initView$4 extends Lambda implements Function1<View, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ CouponOrderConfirmFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CouponOrderConfirmFragment$initView$4(CouponOrderConfirmFragment couponOrderConfirmFragment) {
        super(1);
        this.this$0 = couponOrderConfirmFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(View view) {
        invoke(view);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-966477203")) {
            ipChange.ipc$dispatch("-966477203", new Object[]{this, view});
            return;
        }
        k21.i(view, AdvanceSetting.NETWORK_TYPE);
        this.this$0.getBottomArrow().setImageResource(R$drawable.bricks_down_arrow);
    }
}
