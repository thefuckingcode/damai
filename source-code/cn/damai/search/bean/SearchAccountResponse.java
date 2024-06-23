package cn.damai.search.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SearchAccountResponse extends LiveDataResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    public SearchAccountBean data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public Object getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1272604400")) {
            return this.data;
        }
        return ipChange.ipc$dispatch("1272604400", new Object[]{this});
    }
}
