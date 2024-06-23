package tb;

import android.text.TextUtils;
import cn.damai.common.user.a;
import cn.damai.common.user.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class os0 extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String b = "xiannv";
    private static os0 c;

    public static os0 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1422220251")) {
            return (os0) ipChange.ipc$dispatch("1422220251", new Object[0]);
        }
        if (c == null) {
            c = new os0();
        }
        return c;
    }

    public a.b g(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1591965539")) {
            return (a.b) ipChange.ipc$dispatch("1591965539", new Object[]{this, Integer.valueOf(i), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("item_id", str2);
        }
        String str3 = b;
        return e(str3, "xiannv_mustsee", "item_" + i, hashMap, Boolean.TRUE);
    }
}
