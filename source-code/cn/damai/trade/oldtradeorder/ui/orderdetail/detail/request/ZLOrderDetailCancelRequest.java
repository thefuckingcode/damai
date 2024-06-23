package cn.damai.trade.oldtradeorder.ui.orderdetail.detail.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class ZLOrderDetailCancelRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public String loginkey = d20.q();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-855239245")) {
            return "mtop.damai.wireless.my.cancelOrder";
        }
        return (String) ipChange.ipc$dispatch("-855239245", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-901966118")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-901966118", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2008846550")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("2008846550", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1312497478")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1312497478", new Object[]{this});
    }
}
