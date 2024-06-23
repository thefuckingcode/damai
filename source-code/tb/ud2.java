package tb;

import android.content.Context;
import cn.damai.common.askpermission.IPermissionChecker;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
public class ud2 implements IPermissionChecker {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.askpermission.IPermissionChecker
    public boolean hasPermission(Context context, String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293352568")) {
            return ((Boolean) ipChange.ipc$dispatch("293352568", new Object[]{this, context, strArr})).booleanValue();
        } else if (strArr != null) {
            return hasPermission(context, Arrays.asList(strArr));
        } else {
            return true;
        }
    }

    @Override // cn.damai.common.askpermission.IPermissionChecker
    public boolean hasPermission(Context context, List<String> list) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1480517056")) {
            return hp1.f(context, list);
        }
        return ((Boolean) ipChange.ipc$dispatch("1480517056", new Object[]{this, context, list})).booleanValue();
    }
}
