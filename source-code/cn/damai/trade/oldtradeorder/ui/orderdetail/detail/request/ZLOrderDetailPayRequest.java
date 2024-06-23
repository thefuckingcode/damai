package cn.damai.trade.oldtradeorder.ui.orderdetail.detail.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class ZLOrderDetailPayRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String ext1;
    public String loginkey = d20.q();
    public String orderId;
    public String pageurl = "http://m.damai.cn/orderlist.aspx";
    public String type;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "357005725")) {
            return "mtop.damai.wireless.my.getPayParm";
        }
        return (String) ipChange.ipc$dispatch("357005725", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1195271120")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1195271120", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-684386132")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-684386132", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1770224848")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1770224848", new Object[]{this});
    }
}
