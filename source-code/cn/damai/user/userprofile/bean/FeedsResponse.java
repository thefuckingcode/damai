package cn.damai.user.userprofile.bean;

import cn.damai.user.userprofile.LiveDataResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FeedsResponse extends LiveDataResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    public FeedsData data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public Object getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2060043634")) {
            return this.data;
        }
        return ipChange.ipc$dispatch("-2060043634", new Object[]{this});
    }
}
