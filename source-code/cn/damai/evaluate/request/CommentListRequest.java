package cn.damai.evaluate.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CommentListRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String commentId;
    public String commentType;
    public String commentTypes;
    public String contentLabelId;
    public String contentLabelList;
    public String dataModule;
    public String ipId;
    public String isQueryAppend;
    public boolean isQueryCommentEntry;
    public boolean isQueryContent;
    public boolean isQueryContentTargetInfo;
    public boolean isQueryGradeStat;
    public String isQueryHotComment;
    public String isQueryIpInfo;
    public String isQueryMainComment;
    public String isQueryProjectInfo;
    public boolean isShowContentLabel;
    public String itemId;
    public String mainCommentId;
    public String mainGradeList;
    public boolean myself;
    public String onTop;
    public String pageIndex;
    public String pageSize;
    public String queryStoreInfo;
    public String queryUploadFlag;
    public String scriptId;
    public String sort;
    public String storeId;
    public String targetType;
    public String tourId;
    public String venueId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-795370675")) {
            return "mtop.damai.wireless.comment.list.get";
        }
        return (String) ipChange.ipc$dispatch("-795370675", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1472117907")) {
            return DMBaseMtopRequest.HttpMethod.POST;
        }
        return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("-1472117907", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1907863424")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1907863424", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1709177084")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1709177084", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1372366048")) {
            return "3.1";
        }
        return (String) ipChange.ipc$dispatch("1372366048", new Object[]{this});
    }
}
