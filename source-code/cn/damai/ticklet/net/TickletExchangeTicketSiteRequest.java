package cn.damai.ticklet.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class TickletExchangeTicketSiteRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String performId;
    public String productSystemId;
    public String userLat;
    public String userLng;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1382374393")) {
            return "mtop.damai.wireless.ticklet2.extension.exchangesite.list";
        }
        return (String) ipChange.ipc$dispatch("1382374393", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1576979796")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1576979796", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "569020624")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("569020624", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-744856180")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-744856180", new Object[]{this});
    }
}
