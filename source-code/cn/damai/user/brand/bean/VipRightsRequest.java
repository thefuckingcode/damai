package cn.damai.user.brand.bean;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class VipRightsRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    private String accountapi = "mtop.damai.wireless.vip.brand.rights.gain";
    public String brandId;
    public String cardObjId;
    public String cardRightsReferId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "278975337")) {
            return this.accountapi;
        }
        return (String) ipChange.ipc$dispatch("278975337", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-477010972")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-477010972", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1926118560")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1926118560", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1848255236")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1848255236", new Object[]{this});
    }
}
