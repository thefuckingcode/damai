package com.alibaba.pictures.bricks.orderconfirm.request;

import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.alibaba.pictures.bricks.orderconfirm.bean.CouponOrderRenderBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class CouponOrderRenderRequest extends DamaiBaseRequest<CouponOrderRenderBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int buyAmount = 1;
    @Nullable
    private String dmChannel;
    @Nullable
    private String itemId;
    @Nullable
    private String skuId;

    public CouponOrderRenderRequest() {
        this.API_NAME = "mtop.damai.wireless.trade.common.order.confirm";
        this.VERSION = "1.0";
        this.NEED_ECODE = true;
        this.NEED_SESSION = true;
    }

    public final int getBuyAmount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1769262674")) {
            return this.buyAmount;
        }
        return ((Integer) ipChange.ipc$dispatch("1769262674", new Object[]{this})).intValue();
    }

    @Nullable
    public final String getDmChannel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1952180189")) {
            return this.dmChannel;
        }
        return (String) ipChange.ipc$dispatch("1952180189", new Object[]{this});
    }

    @Nullable
    public final String getItemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "353554049")) {
            return this.itemId;
        }
        return (String) ipChange.ipc$dispatch("353554049", new Object[]{this});
    }

    @Nullable
    public final String getSkuId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-462397509")) {
            return this.skuId;
        }
        return (String) ipChange.ipc$dispatch("-462397509", new Object[]{this});
    }

    public final void setBuyAmount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1476122360")) {
            ipChange.ipc$dispatch("1476122360", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.buyAmount = i;
    }

    public final void setDmChannel(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1577161159")) {
            ipChange.ipc$dispatch("-1577161159", new Object[]{this, str});
            return;
        }
        this.dmChannel = str;
    }

    public final void setItemId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "975148925")) {
            ipChange.ipc$dispatch("975148925", new Object[]{this, str});
            return;
        }
        this.itemId = str;
    }

    public final void setSkuId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1041946651")) {
            ipChange.ipc$dispatch("1041946651", new Object[]{this, str});
            return;
        }
        this.skuId = str;
    }
}
