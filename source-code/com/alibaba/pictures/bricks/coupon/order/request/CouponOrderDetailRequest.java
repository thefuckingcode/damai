package com.alibaba.pictures.bricks.coupon.order.request;

import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class CouponOrderDetailRequest extends DamaiBaseRequest<OrderDetail> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String latitude;
    @Nullable
    private String longitude;
    @Nullable
    private String orderId;

    public CouponOrderDetailRequest() {
        this.API_NAME = "mtop.damai.wireless.secondaryorder.orderdetail";
        this.VERSION = "1.0";
        this.NEED_ECODE = true;
        this.NEED_SESSION = true;
    }

    @Nullable
    public final String getLatitude() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1781513393")) {
            return this.latitude;
        }
        return (String) ipChange.ipc$dispatch("1781513393", new Object[]{this});
    }

    @Nullable
    public final String getLongitude() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-832401216")) {
            return this.longitude;
        }
        return (String) ipChange.ipc$dispatch("-832401216", new Object[]{this});
    }

    @Nullable
    public final String getOrderId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1626883226")) {
            return this.orderId;
        }
        return (String) ipChange.ipc$dispatch("1626883226", new Object[]{this});
    }

    public final void setLatitude(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-489987507")) {
            ipChange.ipc$dispatch("-489987507", new Object[]{this, str});
            return;
        }
        this.latitude = str;
    }

    public final void setLongitude(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1999838794")) {
            ipChange.ipc$dispatch("-1999838794", new Object[]{this, str});
            return;
        }
        this.longitude = str;
    }

    public final void setOrderId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1572486172")) {
            ipChange.ipc$dispatch("1572486172", new Object[]{this, str});
            return;
        }
        this.orderId = str;
    }
}
