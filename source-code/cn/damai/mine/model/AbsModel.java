package cn.damai.mine.model;

import cn.damai.commonbusiness.seatbiz.utils.RequestHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class AbsModel {
    private static transient /* synthetic */ IpChange $ipChange;
    protected RequestHolder mHolder = new RequestHolder();

    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1808617091")) {
            ipChange.ipc$dispatch("-1808617091", new Object[]{this});
            return;
        }
        this.mHolder.c();
    }
}
