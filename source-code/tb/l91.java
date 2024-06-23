package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class l91 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static boolean a = true;

    public static void a(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1773850234")) {
            ipChange.ipc$dispatch("1773850234", new Object[]{str, objArr});
        } else if (a) {
            r91.a(str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1673823618")) {
            ipChange.ipc$dispatch("-1673823618", new Object[]{str, objArr});
        } else if (a) {
            r91.b(str, objArr);
        }
    }
}
