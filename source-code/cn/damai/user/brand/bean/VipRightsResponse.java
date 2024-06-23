package cn.damai.user.brand.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class VipRightsResponse extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    public VipRightsData data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public VipRightsData getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-88073657")) {
            return this.data;
        }
        return (VipRightsData) ipChange.ipc$dispatch("-88073657", new Object[]{this});
    }
}
