package cn.damai.issue.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class IssueEditRequest extends IssueRequest {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.issue.net.IssueRequest, cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "888901635")) {
            return "mtop.damai.wireless.comment.modify";
        }
        return (String) ipChange.ipc$dispatch("888901635", new Object[]{this});
    }

    @Override // cn.damai.issue.net.IssueRequest, cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1238328938")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1238328938", new Object[]{this});
    }
}
