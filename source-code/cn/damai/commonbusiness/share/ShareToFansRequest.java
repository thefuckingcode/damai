package cn.damai.commonbusiness.share;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ShareToFansRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String shareContent;
    public String shareDigest;
    public String shareType;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-787020756")) {
            return "mtop.damai.wireless.community.share.tofans";
        }
        return (String) ipChange.ipc$dispatch("-787020756", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1319754367")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1319754367", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-53702211")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-53702211", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1380715967")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1380715967", new Object[]{this});
    }
}
