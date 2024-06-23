package cn.damai.commonbusiness.seatbiz.sku.qilin.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.network.ApiConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DengjiRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public long itemId;
    public String operateType = "1";
    public String targetId;
    public int targetType;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1546994162")) {
            return ApiConstant.API_NAME_RELATION_UPDATE;
        }
        return (String) ipChange.ipc$dispatch("-1546994162", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "712385503")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("712385503", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1377406821")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1377406821", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "620742561")) {
            return "1.2";
        }
        return (String) ipChange.ipc$dispatch("620742561", new Object[]{this});
    }
}
