package cn.damai.user.userprofile.bean;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.xf2;

/* compiled from: Taobao */
public class DeleteRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String articleId;
    public String commentId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1835925125")) {
            return !xf2.j(this.articleId) ? "mtop.damai.wireless.community.article.delete" : "mtop.damai.wireless.comment.delete";
        }
        return (String) ipChange.ipc$dispatch("-1835925125", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "882906130")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("882906130", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-715841522")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-715841522", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "331811598")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("331811598", new Object[]{this});
    }
}
