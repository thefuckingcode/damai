package cn.damai.issue.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class IssueRenderLiveDataResponse extends LiveDataCommonResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    public IssueRenderResponse data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public Object getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-742220704")) {
            return this.data;
        }
        return ipChange.ipc$dispatch("-742220704", new Object[]{this});
    }
}
