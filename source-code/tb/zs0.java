package tb;

import cn.damai.common.user.a;
import cn.damai.common.user.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class zs0 extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String GRAB_PAGE = "snatch_ticket";
    private static zs0 b;

    public static zs0 g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1886013989")) {
            return (zs0) ipChange.ipc$dispatch("-1886013989", new Object[0]);
        }
        if (b == null) {
            b = new zs0();
        }
        return b;
    }

    public a.b f(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "203674297")) {
            return new a.b().d(str).i(GRAB_PAGE);
        }
        return (a.b) ipChange.ipc$dispatch("203674297", new Object[]{this, str});
    }

    public a.b h(int i, int i2, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2070270721")) {
            return (a.b) ipChange.ipc$dispatch("-2070270721", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", str);
        hashMap.put("titlelabel", str2);
        hashMap.put("item_id", str3);
        return e(GRAB_PAGE, "card_" + i, "item_" + i2, hashMap, Boolean.TRUE);
    }

    public a.b i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237971181")) {
            return (a.b) ipChange.ipc$dispatch("237971181", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("city", str2);
        return e(GRAB_PAGE, "top", "share", hashMap, Boolean.TRUE);
    }
}
