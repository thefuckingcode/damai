package tb;

import cn.damai.common.user.b;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class hq1 extends b {
    private static transient /* synthetic */ IpChange $ipChange;
    private static hq1 b;

    public static hq1 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1313089087")) {
            return (hq1) ipChange.ipc$dispatch("1313089087", new Object[0]);
        }
        if (b == null) {
            b = new hq1();
        }
        return b;
    }

    public void g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1371743540")) {
            ipChange.ipc$dispatch("1371743540", new Object[]{this, str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        c.e().x(e("select_pic", "bottom", str, hashMap, Boolean.TRUE));
    }
}
