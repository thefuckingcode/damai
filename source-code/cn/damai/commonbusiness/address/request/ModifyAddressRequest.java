package cn.damai.commonbusiness.address.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.commonbusiness.address.api.AddressApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ModifyAddressRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String addressDetail;
    public String addressId;
    public String city;
    public String cityCode;
    public String consigneeName;
    public String county;
    public String countyCode;
    public String loginKey;
    public String mobile;
    public String nationPrefix;
    public String province;
    public String provinceCode;
    public String street;
    public String streetCode;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1129771583")) {
            return AddressApi.API_MODIFY_ADDRESS;
        }
        return (String) ipChange.ipc$dispatch("-1129771583", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1744235129")) {
            return DMBaseMtopRequest.HttpMethod.POST;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("1744235129", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1071039628")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1071039628", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-308176376")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-308176376", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1037965140")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1037965140", new Object[]{this});
    }
}
