package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public final class k30 {
    private static transient /* synthetic */ IpChange $ipChange;
    private HashMap<String, String> a = new HashMap<>();

    public void a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "742359839")) {
            ipChange.ipc$dispatch("742359839", new Object[]{this, str, str2});
            return;
        }
        this.a.put(str, str2);
    }

    public long b(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-670865576")) {
            return Long.valueOf(this.a.get(str)).longValue();
        }
        return ((Long) ipChange.ipc$dispatch("-670865576", new Object[]{this, str})).longValue();
    }
}
