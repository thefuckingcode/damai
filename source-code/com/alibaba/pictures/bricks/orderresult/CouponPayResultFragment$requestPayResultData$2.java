package com.alibaba.pictures.bricks.orderresult;

import com.alibaba.pictures.bricks.orderresult.couponpayresult.PayResultUtListener;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.DmCouponPaySuccessBean;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.PayResultDataHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.bp1;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class CouponPayResultFragment$requestPayResultData$2 extends Lambda implements Function1<DmCouponPaySuccessBean, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ CouponPayResultFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CouponPayResultFragment$requestPayResultData$2(CouponPayResultFragment couponPayResultFragment) {
        super(1);
        this.this$0 = couponPayResultFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(DmCouponPaySuccessBean dmCouponPaySuccessBean) {
        invoke(dmCouponPaySuccessBean);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull DmCouponPaySuccessBean dmCouponPaySuccessBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1198860456")) {
            ipChange.ipc$dispatch("-1198860456", new Object[]{this, dmCouponPaySuccessBean});
            return;
        }
        k21.i(dmCouponPaySuccessBean, AdvanceSetting.NETWORK_TYPE);
        this.this$0.mGaiaXList.clear();
        PayResultDataHolder payResultDataHolder = new PayResultDataHolder();
        payResultDataHolder.setMPayResponse(dmCouponPaySuccessBean);
        payResultDataHolder.setType(0);
        this.this$0.mGaiaXList.add(payResultDataHolder);
        CouponPayResultAdapter couponPayResultAdapter = this.this$0.mGaiaXAdapter;
        if (couponPayResultAdapter != null) {
            couponPayResultAdapter.a(this.this$0.mGaiaXList);
        }
        bp1.INSTANCE.h(this.this$0.getOrderId(), dmCouponPaySuccessBean.getPayState(), dmCouponPaySuccessBean.resultDesc);
        PayResultUtListener payResultUtListener = this.this$0.getPayResultUtListener();
        if (payResultUtListener != null) {
            String payState = dmCouponPaySuccessBean.getPayState();
            k21.h(payState, "it.payState");
            String str = dmCouponPaySuccessBean.resultDesc;
            k21.h(str, "it.resultDesc");
            payResultUtListener.updateUTParam(payState, str);
        }
        this.this$0.queryAnotherShow();
    }
}
