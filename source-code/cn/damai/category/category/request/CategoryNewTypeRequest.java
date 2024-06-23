package cn.damai.category.category.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CategoryNewTypeRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1316439580")) {
            return "mtop.damai.wireless.search.cms.category.get";
        }
        return (String) ipChange.ipc$dispatch("-1316439580", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2023143113")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("2023143113", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-164761339")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-164761339", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "851297143")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("851297143", new Object[]{this});
    }
}
