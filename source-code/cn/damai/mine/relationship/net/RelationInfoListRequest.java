package cn.damai.mine.relationship.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RelationInfoListRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean needQueryDynamicNum;
    public boolean needQueryFansNum;
    public boolean needQueryRecentShowInfo;
    public int pageNo;
    public int pageSize;
    public String sourceId;
    public String targetTypeList;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "268372123")) {
            return "mtop.damai.wireless.follow.relation.follow.list";
        }
        return (String) ipChange.ipc$dispatch("268372123", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-18239246")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-18239246", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "866845934")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("866845934", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1858858450")) {
            return "1.2";
        }
        return (String) ipChange.ipc$dispatch("-1858858450", new Object[]{this});
    }
}
