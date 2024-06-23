package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class i9 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static i9 b;
    private String a = "1.3";

    private i9() {
        if (!fh2.a()) {
            this.a = "1.2";
        }
    }

    public static synchronized i9 b() {
        synchronized (i9.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-6306839")) {
                return (i9) ipChange.ipc$dispatch("-6306839", new Object[0]);
            }
            if (b == null) {
                b = new i9();
            }
            return b;
        }
    }

    public String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2046498725")) {
            return this.a;
        }
        return (String) ipChange.ipc$dispatch("2046498725", new Object[]{this});
    }
}
