package tb;

import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
public class gp1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String a = "authority_window";
    public static String b = "state";

    public static void a() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1985912103")) {
            ipChange.ipc$dispatch("-1985912103", new Object[0]);
            return;
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Map<String, String> map = lp1.PERMISSION_NAME_MAP;
        if (!map.isEmpty()) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (true) {
                String str = "";
                if (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    if (i != 0) {
                        str = ",";
                    }
                    sb.append(str + next.getKey());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(hp1.g(next.getKey()) ? "1" : "0");
                    sb2.append(sb3.toString());
                    i++;
                } else {
                    hashMap.put("titlelabel", sb.toString());
                    hashMap.put("status", sb2.toString());
                    c.e().A(hashMap, "state", "overview");
                    try {
                        HashMap hashMap2 = new HashMap();
                        int a2 = vo.a(xs0.a());
                        hashMap2.put("cpu_arch", a2 + str);
                        hashMap2.put("apk_arch", vo.b(xs0.a()) + str);
                        hashMap2.put("runtime_arch", vo.e(xs0.a()) + str);
                        c.e().A(hashMap2, "userstate", "cpu_state");
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        }
    }
}
