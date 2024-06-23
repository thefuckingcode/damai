package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.request;

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
        if (!AndroidInstantRuntime.support(ipChange, "596484097")) {
            return "mtop.damai.wireless.mkt.coupon.applyCoupon4User";
        }
        return (String) ipChange.ipc$dispatch("596484097", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1871482937")) {
            return DMBaseMtopRequest.HttpMethod.GET;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("1871482937", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-853018036")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-853018036", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1803313096")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1803313096", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1530746476")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1530746476", new Object[]{this});
    }
}
