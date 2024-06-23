package com.alibaba.pictures.bricks.orderresult.couponpayresult.request;

import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.DmCouponPaySuccessBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class PaySuccessRequest extends DamaiBaseRequest<DmCouponPaySuccessBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String orderId;

    public PaySuccessRequest() {
        this.API_NAME = "mtop.damai.wireless.order.paymentCompletion4Secondary";
        this.VERSION = "1.0";
        this.NEED_ECODE = true;
        this.NEED_SESSION = false;
    }

    @Nullable
    public final String getOrderId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1598836890")) {
            return this.orderId;
        }
        return (String) ipChange.ipc$dispatch("1598836890", new Object[]{this});
    }

    public final void setOrderId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "703049756")) {
            ipChange.ipc$dispatch("703049756", new Object[]{this, str});
            return;
        }
        this.orderId = str;
    }
}
