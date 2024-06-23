package tb;

import android.view.View;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.common.user.a;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class sc extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PAGE_NAME = "category_brand";
    public static sc b = new sc();

    public static void f(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1516495634")) {
            ipChange.ipc$dispatch("-1516495634", new Object[]{Integer.valueOf(i), str});
            return;
        }
        HashMap<String, String> g = a03.g();
        a03.h(g, "brand_id", str);
        sc scVar = b;
        c.e().x(scVar.e(PAGE_NAME, "brand_card_" + i, "card", g, Boolean.TRUE));
    }

    public static void g(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-759000743")) {
            ipChange.ipc$dispatch("-759000743", new Object[]{Integer.valueOf(i), str, str2});
            return;
        }
        HashMap<String, String> g = a03.g();
        g.put("brand_id", str);
        g.put("status", str2);
        sc scVar = b;
        c.e().x(scVar.e(PAGE_NAME, "brand_card_" + i, StarFragment.KEY_FOLLOW, g, Boolean.FALSE));
    }

    public static void h(int i, int i2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058796631")) {
            ipChange.ipc$dispatch("1058796631", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            return;
        }
        HashMap<String, String> g = a03.g();
        a03.h(g, "item_id", str);
        c.e().x(b.e(PAGE_NAME, "brand_card_" + i, "item_" + i2, g, Boolean.TRUE));
    }

    public static void i(View view, int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1073509967")) {
            ipChange.ipc$dispatch("-1073509967", new Object[]{view, Integer.valueOf(i), str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("brand_id", str2);
        c e = c.e();
        e.G(view, "card", "brand_card_" + i, PAGE_NAME, hashMap);
    }

    public static void j(View view, int i, int i2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1552045137")) {
            ipChange.ipc$dispatch("1552045137", new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2), str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("item_id", str2);
        c.e().G(view, "item_" + i2, "brand_card_" + i, PAGE_NAME, hashMap);
    }

    public static a.b k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-808585539")) {
            return (a.b) ipChange.ipc$dispatch("-808585539", new Object[0]);
        }
        return new a.b().i(PAGE_NAME).k("品牌").a(d20.d());
    }
}
