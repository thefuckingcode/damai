package tb;

import com.alibaba.pictures.share.ShareManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ba2 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final ba2 INSTANCE = new ba2();
    private static Map<String, String> a;

    private ba2() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: tb.ba2 */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(ba2 ba2, String str, String str2, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            map = new LinkedHashMap();
        }
        ba2.a(str, str2, map);
    }

    private final void d(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1016521453")) {
            ipChange.ipc$dispatch("-1016521453", new Object[]{this, map});
            return;
        }
        Map<String, String> map2 = a;
        if (map2 != null) {
            map.putAll(map2);
        }
    }

    public final void a(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1897605375")) {
            ipChange.ipc$dispatch("1897605375", new Object[]{this, str, str2, map});
            return;
        }
        k21.i(str, "ctrlName");
        k21.i(str2, "spm");
        k21.i(map, "args");
        d(map);
        ShareManager.IDogCat m = ShareManager.INSTANCE.b().m();
        if (m != null) {
            m.click(str, str2, map);
        }
    }

    public final void c(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1239769628")) {
            ipChange.ipc$dispatch("1239769628", new Object[]{this, str, map});
            return;
        }
        k21.i(str, "eventName");
        k21.i(map, "args");
        d(map);
        ShareManager.IDogCat m = ShareManager.INSTANCE.b().m();
        if (m != null) {
            m.custom(str, map);
        }
    }
}
