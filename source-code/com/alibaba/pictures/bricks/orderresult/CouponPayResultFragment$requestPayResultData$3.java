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
import tb.fb0;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class CouponPayResultFragment$requestPayResultData$3 extends Lambda implements Function1<fb0<DmCouponPaySuccessBean>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ CouponPayResultFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CouponPayResultFragment$requestPayResultData$3(CouponPayResultFragment couponPayResultFragment) {
        super(1);
        this.this$0 = couponPayResultFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(fb0<DmCouponPaySuccessBean> fb0) {
        invoke(fb0);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull fb0<DmCouponPaySuccessBean> fb0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1223867683")) {
            ipChange.ipc$dispatch("-1223867683", new Object[]{this, fb0});
            return;
        }
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
        this.this$0.mGaiaXList.clear();
        PayResultDataHolder payResultDataHolder = new PayResultDataHolder();
        payResultDataHolder.setMPayResponse(this.this$0.createPayResultErrorMsg());
        payResultDataHolder.setType(0);
        this.this$0.mGaiaXList.add(payResultDataHolder);
        CouponPayResultAdapter couponPayResultAdapter = this.this$0.mGaiaXAdapter;
        if (couponPayResultAdapter != null) {
            couponPayResultAdapter.a(this.this$0.mGaiaXList);
        }
        DmCouponPaySuccessBean createPayResultErrorMsg = this.this$0.createPayResultErrorMsg();
        if (createPayResultErrorMsg != null) {
            CouponPayResultFragment couponPayResultFragment = this.this$0;
            bp1.INSTANCE.h(createPayResultErrorMsg.orderId, createPayResultErrorMsg.getPayState(), createPayResultErrorMsg.resultDesc);
            PayResultUtListener payResultUtListener = couponPayResultFragment.getPayResultUtListener();
            if (payResultUtListener != null) {
                String payState = createPayResultErrorMsg.getPayState();
                k21.h(payState, "this.payState");
                String str = createPayResultErrorMsg.resultDesc;
                k21.h(str, "this.resultDesc");
                payResultUtListener.updateUTParam(payState, str);
            }
        }
    }
}
