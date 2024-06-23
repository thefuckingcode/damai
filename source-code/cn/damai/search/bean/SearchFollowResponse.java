package cn.damai.search.bean;

import cn.damai.commonbusiness.search.bean.FollowDataBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SearchFollowResponse extends LiveDataResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    public FollowDataBean data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public Object getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1670615246")) {
            return this.data;
        }
        return ipChange.ipc$dispatch("-1670615246", new Object[]{this});
    }
}
