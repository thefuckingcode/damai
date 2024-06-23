package com.alibaba.pictures.bricks.orderresult.couponpayresult.bean;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.m40;

/* compiled from: Taobao */
public final class PayResultDataHolder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_ANOTHER_SHOW = 2;
    public static final int TYPE_PAY_RESULT = 0;
    public static final int TYPE_RECOMMEND_TITLE = 1;
    @Nullable
    private String mOrderId;
    @Nullable
    private DmCouponPaySuccessBean mPayResponse;
    @Nullable
    private String mProjectId;
    @Nullable
    private JSONObject mRecommendResponse;
    private int type;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    @Nullable
    public final String getMOrderId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-144911055")) {
            return this.mOrderId;
        }
        return (String) ipChange.ipc$dispatch("-144911055", new Object[]{this});
    }

    @Nullable
    public final DmCouponPaySuccessBean getMPayResponse() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1955010687")) {
            return this.mPayResponse;
        }
        return (DmCouponPaySuccessBean) ipChange.ipc$dispatch("1955010687", new Object[]{this});
    }

    @Nullable
    public final String getMProjectId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1061938308")) {
            return this.mProjectId;
        }
        return (String) ipChange.ipc$dispatch("-1061938308", new Object[]{this});
    }

    @Nullable
    public final JSONObject getMRecommendResponse() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "740490779")) {
            return this.mRecommendResponse;
        }
        return (JSONObject) ipChange.ipc$dispatch("740490779", new Object[]{this});
    }

    public final int getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1387641308")) {
            return this.type;
        }
        return ((Integer) ipChange.ipc$dispatch("-1387641308", new Object[]{this})).intValue();
    }

    public final void setMOrderId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-79603251")) {
            ipChange.ipc$dispatch("-79603251", new Object[]{this, str});
            return;
        }
        this.mOrderId = str;
    }

    public final void setMPayResponse(@Nullable DmCouponPaySuccessBean dmCouponPaySuccessBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369022749")) {
            ipChange.ipc$dispatch("1369022749", new Object[]{this, dmCouponPaySuccessBean});
            return;
        }
        this.mPayResponse = dmCouponPaySuccessBean;
    }

    public final void setMProjectId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-670232606")) {
            ipChange.ipc$dispatch("-670232606", new Object[]{this, str});
            return;
        }
        this.mProjectId = str;
    }

    public final void setMRecommendResponse(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2051322721")) {
            ipChange.ipc$dispatch("2051322721", new Object[]{this, jSONObject});
            return;
        }
        this.mRecommendResponse = jSONObject;
    }

    public final void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-155757570")) {
            ipChange.ipc$dispatch("-155757570", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.type = i;
    }
}
