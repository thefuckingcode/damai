package tb;

import cn.damai.common.AppConfig;
import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class hl2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Boolean a() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-614485258")) {
            return (Boolean) ipChange.ipc$dispatch("-614485258", new Object[0]);
        }
        if (OrangeConfigCenter.c().a(AppConfig.TICKLET_LOCAL_DATA_NAMESPACE, AppConfig.TICKLET_LOCAL_DATA_DEFAULT, 1) == 1) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
