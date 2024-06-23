package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class pr {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "807139929")) {
            return i42.q(str);
        }
        return (String) ipChange.ipc$dispatch("807139929", new Object[]{str});
    }
}
