package com.alibaba.pictures.bricks.bean;

import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class CouponRuleBean {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OrderDetail orderInfo;
    @Nullable
    private List<CouponServiceRuleBean> ruleList;

    public CouponRuleBean(@Nullable List<CouponServiceRuleBean> list, @Nullable OrderDetail orderDetail) {
        this.ruleList = list;
        this.orderInfo = orderDetail;
    }

    @Nullable
    public final OrderDetail getOrderInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-390918257")) {
            return this.orderInfo;
        }
        return (OrderDetail) ipChange.ipc$dispatch("-390918257", new Object[]{this});
    }

    @Nullable
    public final List<CouponServiceRuleBean> getRuleList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1332847497")) {
            return this.ruleList;
        }
        return (List) ipChange.ipc$dispatch("-1332847497", new Object[]{this});
    }

    public final void setOrderInfo(@Nullable OrderDetail orderDetail) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1527060619")) {
            ipChange.ipc$dispatch("1527060619", new Object[]{this, orderDetail});
            return;
        }
        this.orderInfo = orderDetail;
    }

    public final void setRuleList(@Nullable List<CouponServiceRuleBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1141855285")) {
            ipChange.ipc$dispatch("1141855285", new Object[]{this, list});
            return;
        }
        this.ruleList = list;
    }
}
