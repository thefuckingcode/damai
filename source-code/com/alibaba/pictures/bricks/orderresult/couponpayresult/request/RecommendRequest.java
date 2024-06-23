package com.alibaba.pictures.bricks.orderresult.couponpayresult.request;

import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.RecommendListMo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class RecommendRequest extends DamaiBaseRequest<RecommendListMo> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String cityId;

    public RecommendRequest() {
        this.API_NAME = "mtop.damai.wireless.pay.success.recommend.get";
        this.VERSION = "1.0";
        this.NEED_ECODE = false;
        this.NEED_SESSION = false;
    }

    @Nullable
    public final String getCityId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1409499438")) {
            return this.cityId;
        }
        return (String) ipChange.ipc$dispatch("-1409499438", new Object[]{this});
    }

    public final void setCityId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2139901620")) {
            ipChange.ipc$dispatch("-2139901620", new Object[]{this, str});
            return;
        }
        this.cityId = str;
    }
}
