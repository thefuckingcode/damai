package cn.damai.user.userprofile.bean;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MyCommentRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public int commentType = 32;
    public int dataSource = 2;
    public String ipId;
    public int pageIndex = 1;
    public int pageSize = 1;
    public long publisherId;
    public int targetType = 0;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "424760721")) {
            return "mtop.damai.wireless.comment.list.get";
        }
        return (String) ipChange.ipc$dispatch("424760721", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1665018180")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1665018180", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1139744712")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1139744712", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1702469852")) {
            return "2.0";
        }
        return (String) ipChange.ipc$dispatch("-1702469852", new Object[]{this});
    }
}
