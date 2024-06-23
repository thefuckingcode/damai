package cn.damai.mine.relationship.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class RelationSelfRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public int pageNo;
    public int pageSize;
    public String targetId;
    public int targetType;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-268430981")) {
            return "mtop.damai.wireless.follow.relation.fans.list";
        }
        return (String) ipChange.ipc$dispatch("-268430981", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "181666834")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("181666834", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-296939506")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-296939506", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1899305742")) {
            return "1.2";
        }
        return (String) ipChange.ipc$dispatch("1899305742", new Object[]{this});
    }
}
