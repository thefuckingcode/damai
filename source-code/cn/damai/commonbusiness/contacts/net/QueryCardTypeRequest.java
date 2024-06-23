package cn.damai.commonbusiness.contacts.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class QueryCardTypeRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<String> needReturnTypeList = new ArrayList();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1952601072")) {
            return "mtop.damai.wireless.user.customer.typelist";
        }
        return (String) ipChange.ipc$dispatch("1952601072", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "771081789")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("771081789", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-804850823")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-804850823", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-174629501")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-174629501", new Object[]{this});
    }
}
