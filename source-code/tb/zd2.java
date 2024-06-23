package tb;

import android.view.View;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class zd2 extends b {
    private static transient /* synthetic */ IpChange $ipChange;
    private static zd2 c;
    public String b = "business_homepage";

    public static zd2 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1894714061")) {
            return (zd2) ipChange.ipc$dispatch("-1894714061", new Object[0]);
        }
        if (c == null) {
            c = new zd2();
        }
        return c;
    }

    public void g(View view, int i, String str, int i2, boolean z, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12012036")) {
            ipChange.ipc$dispatch("-12012036", new Object[]{this, view, Integer.valueOf(i), str, Integer.valueOf(i2), Boolean.valueOf(z), str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("biz_id", str);
        hashMap.put("biz_type", i2 + "");
        if (z) {
            hashMap.put(wz1.VIEW_TYPE, "1");
        } else {
            hashMap.put(wz1.VIEW_TYPE, "0");
        }
        hashMap.put("contentlabel", str2);
        c e = c.e();
        e.G(view, "item_" + i, "banners", this.b, hashMap);
    }
}
