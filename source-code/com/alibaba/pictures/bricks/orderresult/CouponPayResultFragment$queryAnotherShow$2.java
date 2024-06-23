package com.alibaba.pictures.bricks.orderresult;

import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.RecommendListMo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class CouponPayResultFragment$queryAnotherShow$2 extends Lambda implements Function1<RecommendListMo, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ CouponPayResultFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CouponPayResultFragment$queryAnotherShow$2(CouponPayResultFragment couponPayResultFragment) {
        super(1);
        this.this$0 = couponPayResultFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(RecommendListMo recommendListMo) {
        invoke(recommendListMo);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull RecommendListMo recommendListMo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-768569382")) {
            ipChange.ipc$dispatch("-768569382", new Object[]{this, recommendListMo});
            return;
        }
        k21.i(recommendListMo, AdvanceSetting.NETWORK_TYPE);
        this.this$0.returnAnotherShow(recommendListMo);
    }
}
