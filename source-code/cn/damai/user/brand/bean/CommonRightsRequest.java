package cn.damai.user.brand.bean;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommonRightsRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    private String brandCouponApi = "mtop.damai.wireless.guide.brand.coupon.gain";
    public String brandId;
    public String couponActivityId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1111026875")) {
            return this.brandCouponApi;
        }
        return (String) ipChange.ipc$dispatch("1111026875", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "837292242")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("837292242", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1601114930")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1601114930", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1016203698")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1016203698", new Object[]{this});
    }
}
