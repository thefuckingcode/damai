package com.alibaba.pictures.bricks.orderconfirm;

import com.alibaba.pictures.bricks.orderconfirm.bean.CouponOrderRenderBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class CouponOrderConfirmFragment$requestOrderRender$2 extends Lambda implements Function1<CouponOrderRenderBean, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ CouponOrderConfirmFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CouponOrderConfirmFragment$requestOrderRender$2(CouponOrderConfirmFragment couponOrderConfirmFragment) {
        super(1);
        this.this$0 = couponOrderConfirmFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(CouponOrderRenderBean couponOrderRenderBean) {
        invoke(couponOrderRenderBean);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull CouponOrderRenderBean couponOrderRenderBean) {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "-164863146")) {
            ipChange.ipc$dispatch("-164863146", new Object[]{this, couponOrderRenderBean});
            return;
        }
        k21.i(couponOrderRenderBean, AdvanceSetting.NETWORK_TYPE);
        this.this$0.parsePayType(couponOrderRenderBean);
        this.this$0.setRequestData(couponOrderRenderBean.baseRequestData);
        CouponOrderConfirmFragment couponOrderConfirmFragment = this.this$0;
        CouponOrderRenderBean.BaseRequestData baseRequestData = couponOrderRenderBean.baseRequestData;
        if (baseRequestData != null) {
            i = baseRequestData.buyAmount;
        }
        couponOrderConfirmFragment.setBuyAmount(i);
        this.this$0.getAdapter().setData(couponOrderRenderBean.dataList);
        this.this$0.bottomViewRender(couponOrderRenderBean.priceInfo);
        this.this$0.getBottomLayout().setVisibility(0);
        this.this$0.getErrContainer().setVisibility(8);
        CouponOrderConfirmFragment couponOrderConfirmFragment2 = this.this$0;
        couponOrderConfirmFragment2.removeErrorView(couponOrderConfirmFragment2.getErrContainer());
    }
}
