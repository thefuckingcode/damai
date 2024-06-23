package com.alibaba.pictures.bricks.coupon.order.bean;

import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPayInfo;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.pictures.bricks.bean.CouponOrderInfoBean;
import com.alibaba.pictures.bricks.bean.CouponServiceRuleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class OrderDetail implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String buttonJumpUrl;
    @Nullable
    private String buttonStatus;
    @Nullable
    private ArrayList<String> faqItems;
    @Nullable
    private Goods goodsVO;
    @Nullable
    private List<GaiaXBean> gx;
    @Nullable
    private String itemId;
    @Nullable
    private Notice noticeVO;
    @Nullable
    private CouponOrderInfoBean orderInfoVO;
    @Nullable
    private ArrayList<OrderDetailPayInfo> paymentInfoList;
    @Nullable
    private ArrayList<CouponServiceRuleBean> ruleContexts;
    @Nullable
    private JSONObject shopAndItemInfoVO;
    @Nullable
    private StatusInfo statusInfo;
    @Nullable
    private String yellowTips;
    @Nullable
    private String yellowTipsIcon;

    @Nullable
    public final String getButtonJumpUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1005890838")) {
            return this.buttonJumpUrl;
        }
        return (String) ipChange.ipc$dispatch("1005890838", new Object[]{this});
    }

    @Nullable
    public final String getButtonStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1113885715")) {
            return this.buttonStatus;
        }
        return (String) ipChange.ipc$dispatch("1113885715", new Object[]{this});
    }

    @Nullable
    public final ArrayList<String> getFaqItems() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1486399041")) {
            return this.faqItems;
        }
        return (ArrayList) ipChange.ipc$dispatch("1486399041", new Object[]{this});
    }

    @Nullable
    public final Goods getGoodsVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1847347838")) {
            return this.goodsVO;
        }
        return (Goods) ipChange.ipc$dispatch("1847347838", new Object[]{this});
    }

    @Nullable
    public final List<GaiaXBean> getGx() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2012035737")) {
            return this.gx;
        }
        return (List) ipChange.ipc$dispatch("-2012035737", new Object[]{this});
    }

    @Nullable
    public final String getItemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-724317219")) {
            return this.itemId;
        }
        return (String) ipChange.ipc$dispatch("-724317219", new Object[]{this});
    }

    @Nullable
    public final Notice getNoticeVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1101938892")) {
            return this.noticeVO;
        }
        return (Notice) ipChange.ipc$dispatch("-1101938892", new Object[]{this});
    }

    @Nullable
    public final CouponOrderInfoBean getOrderInfoVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-98927594")) {
            return this.orderInfoVO;
        }
        return (CouponOrderInfoBean) ipChange.ipc$dispatch("-98927594", new Object[]{this});
    }

    @Nullable
    public final ArrayList<OrderDetailPayInfo> getPaymentInfoList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1368627073")) {
            return this.paymentInfoList;
        }
        return (ArrayList) ipChange.ipc$dispatch("1368627073", new Object[]{this});
    }

    @Nullable
    public final ArrayList<CouponServiceRuleBean> getRuleContexts() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1642343947")) {
            return this.ruleContexts;
        }
        return (ArrayList) ipChange.ipc$dispatch("1642343947", new Object[]{this});
    }

    @Nullable
    public final JSONObject getShopAndItemInfoVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "107115134")) {
            return this.shopAndItemInfoVO;
        }
        return (JSONObject) ipChange.ipc$dispatch("107115134", new Object[]{this});
    }

    @Nullable
    public final StatusInfo getStatusInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "140950907")) {
            return this.statusInfo;
        }
        return (StatusInfo) ipChange.ipc$dispatch("140950907", new Object[]{this});
    }

    @JSONField(deserialize = false, serialize = false)
    @Nullable
    public final GaiaXBean getValidGaiaXBean(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2042399691")) {
            return (GaiaXBean) ipChange.ipc$dispatch("-2042399691", new Object[]{this, str});
        }
        k21.i(str, "templateId");
        List<GaiaXBean> list = this.gx;
        if (list == null) {
            return null;
        }
        for (T t : list) {
            if (t != null && k21.d(t.getTemplateId(), str) && t.isValid()) {
                return t;
            }
        }
        return null;
    }

    @Nullable
    public final String getYellowTips() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1538153189")) {
            return this.yellowTips;
        }
        return (String) ipChange.ipc$dispatch("-1538153189", new Object[]{this});
    }

    @Nullable
    public final String getYellowTipsIcon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-91429068")) {
            return this.yellowTipsIcon;
        }
        return (String) ipChange.ipc$dispatch("-91429068", new Object[]{this});
    }

    public final void setButtonJumpUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-750818784")) {
            ipChange.ipc$dispatch("-750818784", new Object[]{this, str});
            return;
        }
        this.buttonJumpUrl = str;
    }

    public final void setButtonStatus(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "568599851")) {
            ipChange.ipc$dispatch("568599851", new Object[]{this, str});
            return;
        }
        this.buttonStatus = str;
    }

    public final void setFaqItems(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1245699793")) {
            ipChange.ipc$dispatch("-1245699793", new Object[]{this, arrayList});
            return;
        }
        this.faqItems = arrayList;
    }

    public final void setGoodsVO(@Nullable Goods goods) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2021271954")) {
            ipChange.ipc$dispatch("-2021271954", new Object[]{this, goods});
            return;
        }
        this.goodsVO = goods;
    }

    public final void setGx(@Nullable List<GaiaXBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "621981765")) {
            ipChange.ipc$dispatch("621981765", new Object[]{this, list});
            return;
        }
        this.gx = list;
    }

    public final void setItemId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1920877985")) {
            ipChange.ipc$dispatch("1920877985", new Object[]{this, str});
            return;
        }
        this.itemId = str;
    }

    public final void setNoticeVO(@Nullable Notice notice) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1663402962")) {
            ipChange.ipc$dispatch("1663402962", new Object[]{this, notice});
            return;
        }
        this.noticeVO = notice;
    }

    public final void setOrderInfoVO(@Nullable CouponOrderInfoBean couponOrderInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-67525164")) {
            ipChange.ipc$dispatch("-67525164", new Object[]{this, couponOrderInfoBean});
            return;
        }
        this.orderInfoVO = couponOrderInfoBean;
    }

    public final void setPaymentInfoList(@Nullable ArrayList<OrderDetailPayInfo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656281175")) {
            ipChange.ipc$dispatch("1656281175", new Object[]{this, arrayList});
            return;
        }
        this.paymentInfoList = arrayList;
    }

    public final void setRuleContexts(@Nullable ArrayList<CouponServiceRuleBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1875389605")) {
            ipChange.ipc$dispatch("1875389605", new Object[]{this, arrayList});
            return;
        }
        this.ruleContexts = arrayList;
    }

    public final void setShopAndItemInfoVO(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "865026502")) {
            ipChange.ipc$dispatch("865026502", new Object[]{this, jSONObject});
            return;
        }
        this.shopAndItemInfoVO = jSONObject;
    }

    public final void setStatusInfo(@Nullable StatusInfo statusInfo2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-124584165")) {
            ipChange.ipc$dispatch("-124584165", new Object[]{this, statusInfo2});
            return;
        }
        this.statusInfo = statusInfo2;
    }

    public final void setYellowTips(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1746975267")) {
            ipChange.ipc$dispatch("1746975267", new Object[]{this, str});
            return;
        }
        this.yellowTips = str;
    }

    public final void setYellowTipsIcon(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951407830")) {
            ipChange.ipc$dispatch("-1951407830", new Object[]{this, str});
            return;
        }
        this.yellowTipsIcon = str;
    }
}
