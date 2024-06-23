package com.alibaba.pictures.bricks.orderresult;

import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.RecommendListMo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.fb0;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class CouponPayResultFragment$queryAnotherShow$3 extends Lambda implements Function1<fb0<RecommendListMo>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ CouponPayResultFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CouponPayResultFragment$queryAnotherShow$3(CouponPayResultFragment couponPayResultFragment) {
        super(1);
        this.this$0 = couponPayResultFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(fb0<RecommendListMo> fb0) {
        invoke(fb0);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull fb0<RecommendListMo> fb0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "12782725")) {
            ipChange.ipc$dispatch("12782725", new Object[]{this, fb0});
            return;
        }
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
        this.this$0.returnAnotherShowError(fb0.e(), fb0.f());
    }
}
