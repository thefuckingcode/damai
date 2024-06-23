package tb;

import cn.damai.common.askpermission.IPermissionAction;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class nt0 implements IPermissionAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public nt0() {
    }

    @Override // cn.damai.common.askpermission.IPermissionAction
    public void onCall(j02 j02, List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1494249618")) {
            ipChange.ipc$dispatch("-1494249618", new Object[]{this, j02, list});
        }
    }

    public nt0(boolean z) {
    }
}
