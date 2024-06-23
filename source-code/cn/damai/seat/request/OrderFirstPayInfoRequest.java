package cn.damai.seat.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderFirstPayInfoRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ORDER_FIRST_PAY_INFO = "mtop.damai.wireless.seat.chooseSeatParam";
    public long orderId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2124882192")) {
            return ORDER_FIRST_PAY_INFO;
        }
        return (String) ipChange.ipc$dispatch("-2124882192", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "840604477")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("840604477", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1581942905")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1581942905", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "42854531")) {
            return "2.0";
        }
        return (String) ipChange.ipc$dispatch("42854531", new Object[]{this});
    }
}
