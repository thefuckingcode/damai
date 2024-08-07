package cn.damai.mine.param;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SaveUserRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String birthday;
    public String loginKey;
    public String nickName;
    public int sex;
    public String userIntro;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1821993678")) {
            return "mtop.damai.wireless.user.saveUserProfile";
        }
        return (String) ipChange.ipc$dispatch("1821993678", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2067500831")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("2067500831", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-486667301")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-486667301", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-305236895")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-305236895", new Object[]{this});
    }
}
