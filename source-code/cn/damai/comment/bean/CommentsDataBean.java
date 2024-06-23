package cn.damai.comment.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class CommentsDataBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private CommentsResultBean data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public CommentsResultBean getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-94512867")) {
            return this.data;
        }
        return (CommentsResultBean) ipChange.ipc$dispatch("-94512867", new Object[]{this});
    }
}
