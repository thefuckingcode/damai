package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class j62 {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private String b;

    public String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2069377480")) {
            return this.a;
        }
        return (String) ipChange.ipc$dispatch("-2069377480", new Object[]{this});
    }

    public String b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-512399847")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("-512399847", new Object[]{this});
    }

    public void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671688614")) {
            ipChange.ipc$dispatch("671688614", new Object[]{this, str});
            return;
        }
        this.a = str;
    }

    public void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "123679205")) {
            ipChange.ipc$dispatch("123679205", new Object[]{this, str});
            return;
        }
        this.b = str;
    }
}
