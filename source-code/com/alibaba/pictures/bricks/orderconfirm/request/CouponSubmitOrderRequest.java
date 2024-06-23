package com.alibaba.pictures.bricks.orderconfirm.request;

import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.alibaba.pictures.bricks.orderconfirm.bean.CouponSubmitOrderBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class CouponSubmitOrderRequest extends DamaiBaseRequest<CouponSubmitOrderBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String buyAmount;
    @Nullable
    private String dmChannel;
    @Nullable
    private String itemId;
    @Nullable
    private String itemType;
    @Nullable
    private String payTypeCode;
    @Nullable
    private String skuId;
    @Nullable
    private String totalPrice;

    public CouponSubmitOrderRequest() {
        this.API_NAME = "mtop.damai.wireless.trade.common.order.create";
        this.VERSION = "1.0";
        this.NEED_ECODE = true;
        this.NEED_SESSION = true;
    }

    @Nullable
    public final String getBuyAmount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "259743027")) {
            return this.buyAmount;
        }
        return (String) ipChange.ipc$dispatch("259743027", new Object[]{this});
    }

    @Nullable
    public final String getDmChannel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1216776977")) {
            return this.dmChannel;
        }
        return (String) ipChange.ipc$dispatch("-1216776977", new Object[]{this});
    }

    @Nullable
    public final String getItemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-345199953")) {
            return this.itemId;
        }
        return (String) ipChange.ipc$dispatch("-345199953", new Object[]{this});
    }

    @Nullable
    public final String getItemType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "929511694")) {
            return this.itemType;
        }
        return (String) ipChange.ipc$dispatch("929511694", new Object[]{this});
    }

    @Nullable
    public final String getPayTypeCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-128759100")) {
            return this.payTypeCode;
        }
        return (String) ipChange.ipc$dispatch("-128759100", new Object[]{this});
    }

    @Nullable
    public final String getSkuId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1316177357")) {
            return this.skuId;
        }
        return (String) ipChange.ipc$dispatch("1316177357", new Object[]{this});
    }

    @Nullable
    public final String getTotalPrice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1992688390")) {
            return this.totalPrice;
        }
        return (String) ipChange.ipc$dispatch("1992688390", new Object[]{this});
    }

    public final void setBuyAmount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1791861667")) {
            ipChange.ipc$dispatch("1791861667", new Object[]{this, str});
            return;
        }
        this.buyAmount = str;
    }

    public final void setDmChannel(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1030585497")) {
            ipChange.ipc$dispatch("-1030585497", new Object[]{this, str});
            return;
        }
        this.dmChannel = str;
    }

    public final void setItemId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "788611343")) {
            ipChange.ipc$dispatch("788611343", new Object[]{this, str});
            return;
        }
        this.itemId = str;
    }

    public final void setItemType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1132236400")) {
            ipChange.ipc$dispatch("-1132236400", new Object[]{this, str});
            return;
        }
        this.itemType = str;
    }

    public final void setPayTypeCode(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1996516046")) {
            ipChange.ipc$dispatch("-1996516046", new Object[]{this, str});
            return;
        }
        this.payTypeCode = str;
    }

    public final void setSkuId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "343192649")) {
            ipChange.ipc$dispatch("343192649", new Object[]{this, str});
            return;
        }
        this.skuId = str;
    }

    public final void setTotalPrice(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-466085480")) {
            ipChange.ipc$dispatch("-466085480", new Object[]{this, str});
            return;
        }
        this.totalPrice = str;
    }
}
