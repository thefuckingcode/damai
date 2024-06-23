package cn.damai.comment.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.discover.content.net.ContentDetailApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentPublishRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String commentType;
    public String mainCommentId;
    public String targetId;
    public String targetType;
    public String text;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "839967750")) {
            return ContentDetailApi.CONTENT_COMMENT_PUBLISH;
        }
        return (String) ipChange.ipc$dispatch("839967750", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1788736916")) {
            return DMBaseMtopRequest.HttpMethod.POST;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("1788736916", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "504876263")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("504876263", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1069676451")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1069676451", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1287262823")) {
            return "2.1";
        }
        return (String) ipChange.ipc$dispatch("-1287262823", new Object[]{this});
    }
}
