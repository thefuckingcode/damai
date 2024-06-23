package cn.damai.setting.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class QueryPrivacyPermissonRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<Integer> typeList = new ArrayList<Integer>() {
        /* class cn.damai.setting.net.QueryPrivacyPermissonRequest.AnonymousClass1 */

        {
            add(1);
            add(2);
        }
    };

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1480383505")) {
            return "mtop.damai.wireless.user.permission.getlist";
        }
        return (String) ipChange.ipc$dispatch("-1480383505", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2007291934")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("2007291934", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1782124826")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1782124826", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "687353218")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("687353218", new Object[]{this});
    }
}
