package cn.damai.trade.newtradeorder.ui.orderdetail.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;

/* compiled from: Taobao */
public class HNOrderInvoiceSubmitRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String deliveryWay;
    public String dutyParagraph;
    public String invoiceDeliveryInfo;
    public String invoiceType;
    public String orderId;
    public String title;
    public String userId = Login.getUserId();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2038046670")) {
            return OrderDetailConstantsApi.API_HN_ORDER_SUBMIT_INVOICE_INFO;
        }
        return (String) ipChange.ipc$dispatch("-2038046670", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "738688571")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("738688571", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1869962249")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1869962249", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "129690053")) {
            return "2.0";
        }
        return (String) ipChange.ipc$dispatch("129690053", new Object[]{this});
    }
}
