package cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class LoginCheckRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-761863198")) {
            return "mtop.damai.wireless.user.islogin";
        }
        return (String) ipChange.ipc$dispatch("-761863198", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1218080629")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1218080629", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1129487801")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1129487801", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1405873525")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1405873525", new Object[]{this});
    }
}
