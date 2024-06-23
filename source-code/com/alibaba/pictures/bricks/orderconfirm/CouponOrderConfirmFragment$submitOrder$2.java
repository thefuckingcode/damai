package com.alibaba.pictures.bricks.orderconfirm;

import com.alibaba.pictures.bricks.orderconfirm.bean.CouponSubmitOrderBean;
import com.alibaba.pictures.bricks.util.PaymentService;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class CouponOrderConfirmFragment$submitOrder$2 extends Lambda implements Function1<CouponSubmitOrderBean, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ String $payTypeCode;
    final /* synthetic */ CouponOrderConfirmFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CouponOrderConfirmFragment$submitOrder$2(String str, CouponOrderConfirmFragment couponOrderConfirmFragment) {
        super(1);
        this.$payTypeCode = str;
        this.this$0 = couponOrderConfirmFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(CouponSubmitOrderBean couponSubmitOrderBean) {
        invoke(couponSubmitOrderBean);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull CouponSubmitOrderBean couponSubmitOrderBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1774688831")) {
            ipChange.ipc$dispatch("-1774688831", new Object[]{this, couponSubmitOrderBean});
            return;
        }
        k21.i(couponSubmitOrderBean, AdvanceSetting.NETWORK_TYPE);
        couponSubmitOrderBean.payTypeCode = this.$payTypeCode;
        PaymentService paymentService = this.this$0.getPaymentService();
        if (paymentService != null) {
            paymentService.startPay(couponSubmitOrderBean);
        }
    }
}
