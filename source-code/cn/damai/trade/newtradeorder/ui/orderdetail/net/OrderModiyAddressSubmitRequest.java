package cn.damai.trade.newtradeorder.ui.orderdetail.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderModiyAddressSubmitRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String addressId;
    public String orderId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "133142529")) {
            return OrderDetailConstantsApi.API_ORDER_DETAIL_SUBMIT_NEW_ADDRESS;
        }
        return (String) ipChange.ipc$dispatch("133142529", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1609235892")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1609235892", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "927426504")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("927426504", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1994088044")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1994088044", new Object[]{this});
    }
}
