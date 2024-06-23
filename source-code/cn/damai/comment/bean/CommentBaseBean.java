package cn.damai.comment.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class CommentBaseBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private Object data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public Object getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-478441743")) {
            return this.data;
        }
        return ipChange.ipc$dispatch("-478441743", new Object[]{this});
    }

    public void setData(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1835349903")) {
            ipChange.ipc$dispatch("-1835349903", new Object[]{this, obj});
            return;
        }
        this.data = obj;
    }
}
