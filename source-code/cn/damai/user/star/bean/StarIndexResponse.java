package cn.damai.user.star.bean;

import cn.damai.user.userprofile.LiveDataResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class StarIndexResponse extends LiveDataResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    public StarInfo data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public StarInfo getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "325709347")) {
            return this.data;
        }
        return (StarInfo) ipChange.ipc$dispatch("325709347", new Object[]{this});
    }
}
