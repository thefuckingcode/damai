package cn.damai.tetris.component.ip.mtop;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class PraiseRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<String> cancleTargetIdList = new ArrayList();
    public List<String> praiseTargetIdList = new ArrayList();
    public String targetType;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1989082581")) {
            return "mtop.damai.wireless.comment.batch.praise";
        }
        return (String) ipChange.ipc$dispatch("-1989082581", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1419102562")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1419102562", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-827145890")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-827145890", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "178654142")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("178654142", new Object[]{this});
    }
}
