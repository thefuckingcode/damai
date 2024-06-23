package cn.damai.commonbusiness.banner.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class PaySuccessBannerRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String damaiCityId = d20.c();
    public String orderId;
    public String projectId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-479268852")) {
            return "mtop.damai.wireless.configure.paysuccess.get";
        }
        return (String) ipChange.ipc$dispatch("-479268852", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "39843233")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("39843233", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "849533405")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("849533405", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1688467871")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1688467871", new Object[]{this});
    }
}
