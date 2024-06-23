package cn.damai.commonbusiness.seatbiz.sku.qilin.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class SuanjiaRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<SuanjiaItem> itemsJson = new ArrayList();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1557574676")) {
            return "mtop.damai.wireless.mkt.promotion.calcOrderPromotion";
        }
        return (String) ipChange.ipc$dispatch("-1557574676", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "997545409")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("997545409", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2078323197")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("2078323197", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "610162047")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("610162047", new Object[]{this});
    }
}
