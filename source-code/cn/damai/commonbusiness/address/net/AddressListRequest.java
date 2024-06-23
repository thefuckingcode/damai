package cn.damai.commonbusiness.address.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.commonbusiness.address.api.AddressApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class AddressListRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String loginKey;
    public String returnAll;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1014335833")) {
            return AddressApi.API_GET_ADDRESS_LIST;
        }
        return (String) ipChange.ipc$dispatch("-1014335833", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2024369254")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("2024369254", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1013560162")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1013560162", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1153400890")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1153400890", new Object[]{this});
    }
}
