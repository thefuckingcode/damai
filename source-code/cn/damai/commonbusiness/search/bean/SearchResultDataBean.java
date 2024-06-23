package cn.damai.commonbusiness.search.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class SearchResultDataBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    public SearchResultBean data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public SearchResultBean getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "563101946")) {
            return this.data;
        }
        return (SearchResultBean) ipChange.ipc$dispatch("563101946", new Object[]{this});
    }
}
