package cn.damai.commonbusiness.seatbiz.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.f92;
import tb.xf2;

/* compiled from: Taobao */
public class OrderPrice implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 326;
    public String consumeUserAssertTag;
    private boolean isLocal = false;
    private boolean isNetSuccess = true;
    public double localOriginalAmount;
    public double localRealAmount;
    public long promotionAmount;
    public String promotionAmountTag;
    public List<PromotionInfo> promotionDetails;
    public long realAmount;
    public boolean useSkuPrice = true;

    public OrderPrice() {
    }

    public static OrderPrice makeLocal(double[] dArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1645277060")) {
            return (OrderPrice) ipChange.ipc$dispatch("1645277060", new Object[]{dArr});
        }
        OrderPrice orderPrice = new OrderPrice();
        orderPrice.isLocal = true;
        orderPrice.localRealAmount = dArr[0];
        orderPrice.localOriginalAmount = dArr[1];
        return orderPrice;
    }

    public String getFormatOriginPriceText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2069103310")) {
            return (String) ipChange.ipc$dispatch("2069103310", new Object[]{this});
        } else if (!isHasPromotion()) {
            return null;
        } else {
            return "¥" + xf2.c(this.localOriginalAmount);
        }
    }

    public String getFormatRealAmountText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-92549541")) {
            return xf2.c(((double) this.realAmount) / 100.0d);
        }
        return (String) ipChange.ipc$dispatch("-92549541", new Object[]{this});
    }

    public String getFormatRealPriceText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1602243606")) {
            return (String) ipChange.ipc$dispatch("1602243606", new Object[]{this});
        } else if (this.isLocal) {
            return xf2.c(this.localRealAmount);
        } else {
            if (this.isNetSuccess) {
                return xf2.c(((double) this.realAmount) / 100.0d);
            }
            return xf2.c(this.localRealAmount);
        }
    }

    public String getPromotionAmountTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "481315936")) {
            return this.promotionAmountTag;
        }
        return (String) ipChange.ipc$dispatch("481315936", new Object[]{this});
    }

    public boolean hasPromotionDetails() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1845671840")) {
            return !f92.d(this.promotionDetails);
        }
        return ((Boolean) ipChange.ipc$dispatch("1845671840", new Object[]{this})).booleanValue();
    }

    public boolean isHasPromotion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-840483962")) {
            return this.promotionAmount > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-840483962", new Object[]{this})).booleanValue();
    }

    public boolean isNetSuccess() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1694970007")) {
            return this.isNetSuccess;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1694970007", new Object[]{this})).booleanValue();
    }

    public void prepareAfterNet(double[] dArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330910422")) {
            ipChange.ipc$dispatch("1330910422", new Object[]{this, dArr});
        } else if (dArr != null && dArr.length >= 2) {
            this.localOriginalAmount = dArr[1];
            if (!isNetSuccess()) {
                this.localRealAmount = dArr[0];
                this.promotionAmountTag = "优惠以订单确认页为准";
            }
        }
    }

    public void setNetSuccess(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1461308935")) {
            ipChange.ipc$dispatch("1461308935", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isNetSuccess = z;
    }

    public OrderPrice(boolean z) {
        this.isNetSuccess = z;
    }
}
