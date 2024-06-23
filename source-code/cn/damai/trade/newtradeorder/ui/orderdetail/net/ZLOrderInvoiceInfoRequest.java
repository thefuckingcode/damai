package cn.damai.trade.newtradeorder.ui.orderdetail.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class ZLOrderInvoiceInfoRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String loginKey = d20.q();
    public String orderId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-995290700")) {
            return OrderDetailConstantsApi.API_ZL_ORDER_INVOICE_INFO;
        }
        return (String) ipChange.ipc$dispatch("-995290700", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "409450745")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("409450745", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-439933131")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-439933131", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1172446023")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1172446023", new Object[]{this});
    }
}
