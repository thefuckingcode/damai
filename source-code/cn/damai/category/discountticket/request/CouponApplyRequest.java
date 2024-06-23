package cn.damai.category.discountticket.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CouponApplyRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String calcNextApplicable = "true";
    public String couponActSpreadId;

    public CouponApplyRequest(String str) {
        this.couponActSpreadId = str;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "306020287")) {
            return "mtop.damai.wireless.mkt.coupon.applyCoupon4User";
        }
        return (String) ipChange.ipc$dispatch("306020287", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1733842510")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1733842510", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "990233418")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("990233418", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1821210286")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1821210286", new Object[]{this});
    }
}
