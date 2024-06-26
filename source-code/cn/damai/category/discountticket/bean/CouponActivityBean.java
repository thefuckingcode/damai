package cn.damai.category.discountticket.bean;

import android.text.TextUtils;
import cn.damai.category.discountticket.bean.biz.ApplyResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class CouponActivityBean {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String COUPON_ALREADY_GOT = "30110102";
    public static final String COUPON_NOT_COUNT = "30110107";
    public boolean applicable;
    public String couponActSpreadId;
    public String desc;
    public String effectiveEndTime;
    public String effectiveStartTime;
    public String gainType;
    public String gainWholly;
    public String id;
    public String name;
    public String status;
    public List<CouponSubActBean> subCouponActExs;
    public String unapplicableCause;

    private boolean isGot() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1097244511")) {
            return ((Boolean) ipChange.ipc$dispatch("1097244511", new Object[]{this})).booleanValue();
        } else if (hasSubCoupons()) {
            return TextUtils.equals(COUPON_ALREADY_GOT, this.subCouponActExs.get(0).unapplicableCode);
        } else {
            return false;
        }
    }

    public String getDecreaseMoneyNum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782601853")) {
            return (String) ipChange.ipc$dispatch("782601853", new Object[]{this});
        } else if (hasSubCoupons()) {
            return this.subCouponActExs.get(0).decreaseMoneyNum;
        } else {
            return null;
        }
    }

    public String getOverAmountText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1813065294")) {
            return (String) ipChange.ipc$dispatch("-1813065294", new Object[]{this});
        } else if (hasSubCoupons()) {
            return this.subCouponActExs.get(0).overAmountText;
        } else {
            return null;
        }
    }

    public String getUnapplicableCause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "511886350")) {
            return (String) ipChange.ipc$dispatch("511886350", new Object[]{this});
        } else if (hasSubCoupons()) {
            return this.subCouponActExs.get(0).unapplicableCause;
        } else {
            return null;
        }
    }

    public boolean hasSubCoupons() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1452507302")) {
            return xf2.e(this.subCouponActExs) > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1452507302", new Object[]{this})).booleanValue();
    }

    public boolean isCanApply() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1985709193")) {
            return this.applicable;
        }
        return ((Boolean) ipChange.ipc$dispatch("1985709193", new Object[]{this})).booleanValue();
    }

    public boolean isGotCoupon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "564340953")) {
            return !this.applicable && isGot();
        }
        return ((Boolean) ipChange.ipc$dispatch("564340953", new Object[]{this})).booleanValue();
    }

    public void updateCouponAfterApply(ApplyResult applyResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "848209017")) {
            ipChange.ipc$dispatch("848209017", new Object[]{this, applyResult});
            return;
        }
        this.applicable = applyResult.updateApplicable;
        if (hasSubCoupons()) {
            this.subCouponActExs.get(0).unapplicableCode = applyResult.updateUnapplicableCode;
        }
    }
}
