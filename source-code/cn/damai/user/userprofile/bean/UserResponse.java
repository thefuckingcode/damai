package cn.damai.user.userprofile.bean;

import cn.damai.user.userprofile.LiveDataResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class UserResponse extends LiveDataResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    public UserData data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public UserData getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1906035795")) {
            return this.data;
        }
        return (UserData) ipChange.ipc$dispatch("1906035795", new Object[]{this});
    }
}
