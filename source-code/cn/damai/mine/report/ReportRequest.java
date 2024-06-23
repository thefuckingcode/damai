package cn.damai.mine.report;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ReportRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String extraInfo;
    public String reason;
    public int reasonType;
    public String targetId;
    public int targetType;
    public int type;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "308880985")) {
            return "mtop.damai.wireless.comment.content.report";
        }
        return (String) ipChange.ipc$dispatch("308880985", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2079035124")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("2079035124", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2007853680")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("2007853680", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1818349588")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1818349588", new Object[]{this});
    }
}
