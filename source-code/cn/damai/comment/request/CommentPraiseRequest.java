package cn.damai.comment.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.discover.content.net.ContentDetailApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentPraiseRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public int operate;
    public String targetId;
    public int targetType;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1938162291")) {
            return ContentDetailApi.CONTENT_COMMENT_PRAISE;
        }
        return (String) ipChange.ipc$dispatch("1938162291", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "955859482")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("955859482", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "672853014")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("672853014", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-189068282")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-189068282", new Object[]{this});
    }
}
