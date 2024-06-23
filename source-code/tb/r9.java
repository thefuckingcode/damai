package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
public class r9 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1927003271")) {
            ipChange.ipc$dispatch("-1927003271", new Object[]{str, map});
        }
    }
}
