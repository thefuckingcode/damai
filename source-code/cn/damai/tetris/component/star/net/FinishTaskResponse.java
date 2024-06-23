package cn.damai.tetris.component.star.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FinishTaskResponse extends LiveDataResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    public DoTaskResult data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public DoTaskResult getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "419870644")) {
            return this.data;
        }
        return (DoTaskResult) ipChange.ipc$dispatch("419870644", new Object[]{this});
    }
}
