package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ew0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1991141679")) {
            return ((Integer) ipChange.ipc$dispatch("1991141679", new Object[]{str})).intValue();
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            g91.c("HomeNumberUtil.parseInt", e.getMessage());
            return -1;
        }
    }
}
