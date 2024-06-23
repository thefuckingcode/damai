package cn.damai.trade.newtradeorder.ui.orderdetail.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class ZLOrderInvoiceDetailRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String loginKey = d20.q();
    public String orderId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-639762793")) {
            return OrderDetailConstantsApi.API_ZL_ORDER_INVOICE_DETAIL;
        }
        return (String) ipChange.ipc$dispatch("-639762793", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-803929482")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-803929482", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1732773234")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1732773234", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1527973930")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1527973930", new Object[]{this});
    }
}
