package com.alibaba.pictures.bricks.orderconfirm;

import com.alibaba.pictures.bricks.orderconfirm.bean.CouponSubmitOrderBean;
import com.alibaba.pictures.bricks.orderconfirm.request.CouponOrderRenderRequest;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import tb.fb0;
import tb.k21;
import tb.ur2;
import tb.wz2;

/* compiled from: Taobao */
public final class CouponOrderConfirmFragment$submitOrder$3 extends Lambda implements Function1<fb0<CouponSubmitOrderBean>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ String $payTypeCode;
    final /* synthetic */ CouponOrderConfirmFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CouponOrderConfirmFragment$submitOrder$3(CouponOrderConfirmFragment couponOrderConfirmFragment, String str) {
        super(1);
        this.this$0 = couponOrderConfirmFragment;
        this.$payTypeCode = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(fb0<CouponSubmitOrderBean> fb0) {
        invoke(fb0);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull fb0<CouponSubmitOrderBean> fb0) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1057921151")) {
            ipChange.ipc$dispatch("1057921151", new Object[]{this, fb0});
            return;
        }
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
        String e = fb0.e();
        if (e != null && (o.J(e, "DM_", true))) {
            z = true;
        }
        if (z) {
            BricksToastUtil.INSTANCE.b(fb0.f());
        } else {
            BricksToastUtil.INSTANCE.b("麦麦很忙，系统很累请稍后重试");
        }
        String str = new CouponOrderRenderRequest().API_NAME;
        String e2 = fb0.e();
        String f = fb0.f();
        wz2.a(wz2.b(str, "券提交订单接口", e2, f, "itemId: " + this.this$0.getItemId() + "  skuId：" + this.this$0.getSkuId() + "  支付方式：" + this.$payTypeCode), "-4312", "券提交订单接口错误");
    }
}
