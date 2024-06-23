package tb;

import android.app.Application;
import android.content.Context;
import android.taobao.windvane.connect.api.ApiConstants;
import cn.damai.common.AppConfig;
import cn.damai.common.app.ShareperfenceConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class a20 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static a20 b;
    private List<String> a = new ArrayList();

    private a20() {
        new HashMap();
        new ArrayList();
    }

    private void a(String str, Map<String, String> map, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1049542294")) {
            ipChange.ipc$dispatch("-1049542294", new Object[]{this, str, map, context});
        } else if (d(str, map)) {
            map.put("timestamp", (System.currentTimeMillis() / 1000) + "");
            map.put(ApiConstants.APPSECRET, y10.b());
            map.put("clientGUID", g70.a(xs0.a()) + "1");
            map.put("systemVersion", g70.e());
            map.put("phoneModels", g70.b());
            map.put("appClientKey", y10.a("appClientKey"));
            new HashMap().putAll(map);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(map.keySet());
            Collections.sort(arrayList);
            String c = y10.c(arrayList, map);
            if (c != null) {
                map.put("sign", c.toLowerCase());
            }
            map.remove(ApiConstants.APPSECRET);
        }
    }

    public static a20 b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "129014715")) {
            return (a20) ipChange.ipc$dispatch("129014715", new Object[0]);
        }
        if (b == null) {
            synchronized (a20.class) {
                if (b == null) {
                    b = new a20();
                }
            }
        }
        return b;
    }

    public Map<String, String> c(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1691806952")) {
            return (Map) ipChange.ipc$dispatch("-1691806952", new Object[]{this, str, map});
        }
        Application a2 = xs0.a();
        int r = AppConfig.r();
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("source", "10101");
        map.put("version", r + "");
        try {
            map.put("channel_from", n6.a(a2));
            map.put(Constants.KEY_OS_TYPE, "2");
            map.put("appType", "1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(str, map, a2);
        return map;
    }

    public boolean d(String str, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "876948899")) {
            return this.a.contains(str) || map.containsKey(ShareperfenceConstants.OLD_LOGIN_KEY) || map.containsKey("loginKey");
        }
        return ((Boolean) ipChange.ipc$dispatch("876948899", new Object[]{this, str, map})).booleanValue();
    }
}
