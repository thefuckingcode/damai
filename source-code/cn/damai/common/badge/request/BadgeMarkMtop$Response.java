package cn.damai.common.badge.request;

import cn.damai.common.badge.bean.BadgeMarkResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class BadgeMarkMtop$Response extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private BadgeMarkResponse data;

    public void setData(BadgeMarkResponse badgeMarkResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2007095855")) {
            ipChange.ipc$dispatch("2007095855", new Object[]{this, badgeMarkResponse});
            return;
        }
        this.data = badgeMarkResponse;
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public BadgeMarkResponse getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-278867381")) {
            return this.data;
        }
        return (BadgeMarkResponse) ipChange.ipc$dispatch("-278867381", new Object[]{this});
    }
}
