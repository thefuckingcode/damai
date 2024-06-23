package cn.damai.trade.newtradeorder.ui.orderdetail.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;

/* compiled from: Taobao */
public class HNOrderInvoiceInfoRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String orderId;
    public String userId = Login.getUserId();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "657032072")) {
            return OrderDetailConstantsApi.API_HN_ORDER_APPLY_INVOICE_INFO;
        }
        return (String) ipChange.ipc$dispatch("657032072", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "144202149")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("144202149", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1940763423")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1940763423", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1470198501")) {
            return "2.0";
        }
        return (String) ipChange.ipc$dispatch("-1470198501", new Object[]{this});
    }
}
