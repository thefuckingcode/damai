package cn.damai.commonbusiness.search.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class FollowResultBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private FollowDataBean data;

    public void setData(FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "819576813")) {
            ipChange.ipc$dispatch("819576813", new Object[]{this, followDataBean});
            return;
        }
        this.data = followDataBean;
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public FollowDataBean getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-294637149")) {
            return this.data;
        }
        return (FollowDataBean) ipChange.ipc$dispatch("-294637149", new Object[]{this});
    }
}
