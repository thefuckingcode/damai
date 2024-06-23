package cn.damai.commonbusiness.seatbiz.promotion.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CouponReceiveRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String asac;
    public String buyerId;
    public String calcNextApplicable;
    public String couponActSpreadId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1330962606")) {
            return "mtop.damai.wireless.mkt.coupon.applyCoupon4User";
        }
        return (String) ipChange.ipc$dispatch("-1330962606", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1748658376")) {
            return DMBaseMtopRequest.HttpMethod.GET;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("1748658376", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1490033893")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1490033893", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-483569449")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-483569449", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "836774117")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("836774117", new Object[]{this});
    }
}
