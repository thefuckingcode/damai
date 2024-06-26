package cn.damai.trade.oldtradeorder.ui.orderdetail.detail.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class ZLOrderDetailRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public String isAddress;
    public String loginkey = d20.q();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1962475879")) {
            return "mtop.damai.wireless.order.orderinfo";
        }
        return (String) ipChange.ipc$dispatch("-1962475879", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-522174796")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-522174796", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1916086832")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1916086832", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "205260844")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("205260844", new Object[]{this});
    }
}
