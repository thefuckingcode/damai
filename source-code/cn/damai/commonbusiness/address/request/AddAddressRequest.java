package cn.damai.commonbusiness.address.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.commonbusiness.address.api.AddressApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class AddAddressRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String addressDetail;
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
        if (!AndroidInstantRuntime.support(ipChange, "-1357024230")) {
            return AddressApi.API_ADD_ADDRESS;
        }
        return (String) ipChange.ipc$dispatch("-1357024230", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1660160768")) {
            return DMBaseMtopRequest.HttpMethod.POST;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("1660160768", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1875351379")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1875351379", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-458696945")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-458696945", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "810712493")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("810712493", new Object[]{this});
    }
}
