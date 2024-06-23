package tb;

import android.view.View;
import cn.damai.common.user.a;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class ix0 extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HOME_PAGE = "home";
    private static ix0 b;

    public static ix0 g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112491451")) {
            return (ix0) ipChange.ipc$dispatch("112491451", new Object[0]);
        }
        if (b == null) {
            b = new ix0();
        }
        return b;
    }

    public a.b f(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1032554986")) {
            return (a.b) ipChange.ipc$dispatch("-1032554986", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("city", d20.d() + "市");
        hashMap.put("titlelabel", str);
        return e(ax0.CHANNEL_PAGE, "top", "tab_" + i, hashMap, Boolean.FALSE);
    }

    public a.b h(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1551053339")) {
            return (a.b) ipChange.ipc$dispatch("1551053339", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("city", d20.d());
        hashMap.put("titlelabel", str);
        return e("home", "top", "tab_" + i, hashMap, Boolean.FALSE);
    }

    public a.b i(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-439815727")) {
            return (a.b) ipChange.ipc$dispatch("-439815727", new Object[]{this, str, Integer.valueOf(i), str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("city", d20.d());
        hashMap.put("titlelabel", str2);
        return e(str, "top", "tab_" + i, hashMap, Boolean.TRUE);
    }

    public void j(View view, String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1528136987")) {
            ipChange.ipc$dispatch("-1528136987", new Object[]{this, view, str, Integer.valueOf(i), str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("city", d20.d() + "市");
        hashMap.put("titlelabel", str2);
        c e = c.e();
        e.G(view, "tab_" + i, "top", str, hashMap);
    }
}
