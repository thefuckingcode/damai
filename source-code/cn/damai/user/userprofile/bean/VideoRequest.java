package cn.damai.user.userprofile.bean;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class VideoRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    private String accountapi = "mtop.damai.wireless.search.video.search";
    public long artistId;
    public int pageNumber;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "518979193")) {
            return this.accountapi;
        }
        return (String) ipChange.ipc$dispatch("518979193", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "213154516")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("213154516", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-102048176")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-102048176", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1608251380")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1608251380", new Object[]{this});
    }
}
