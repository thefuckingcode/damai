package cn.damai.mine.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class ProfileInfoBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    public ProfileInfo profileInfo;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public ProfileInfo getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "799595040")) {
            return this.profileInfo;
        }
        return (ProfileInfo) ipChange.ipc$dispatch("799595040", new Object[]{this});
    }
}
