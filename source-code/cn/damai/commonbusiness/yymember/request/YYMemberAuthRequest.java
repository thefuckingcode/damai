package cn.damai.commonbusiness.yymember.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class YYMemberAuthRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2070489415")) {
            return "mtop.film.pfusercenter.relation.onekeybind.damai";
        }
        return (String) ipChange.ipc$dispatch("-2070489415", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1373579924")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1373579924", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1624728048")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1624728048", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "97247308")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("97247308", new Object[]{this});
    }
}
