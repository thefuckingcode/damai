package cn.damai.ticklet.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class TickletSouvenirRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String performId;
    public String productSystemId;

    public TickletSouvenirRequest(String str, String str2) {
        this.performId = str;
        this.productSystemId = str2;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "309681682")) {
            return "mtop.damai.wireless.ticklet2.souvenir.detail.get";
        }
        return (String) ipChange.ipc$dispatch("309681682", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1837628507")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1837628507", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1944328727")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1944328727", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1817548891")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1817548891", new Object[]{this});
    }
}
