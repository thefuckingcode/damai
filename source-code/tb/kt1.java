package tb;

import android.view.View;
import cn.damai.common.user.a;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class kt1 extends b {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    private static class a {
        private static final kt1 a = new kt1();
    }

    private Map<String, String> f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1525898066")) {
            return (Map) ipChange.ipc$dispatch("1525898066", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("type", ta.PROJECT_PAGE);
        return hashMap;
    }

    public static final kt1 h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1344849797") ? (kt1) ipChange.ipc$dispatch("-1344849797", new Object[0]) : a.a;
    }

    public a.b g(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-239735898")) {
            return (a.b) ipChange.ipc$dispatch("-239735898", new Object[]{this, str, str2, str3, str4});
        }
        Map<String, String> f = f(str);
        f.put("titlelabel", str4);
        return e(ta.PROJECT_PAGE, str2, str3, f, Boolean.FALSE);
    }

    public a.b i(String str, String str2, String str3, boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-148652635")) {
            return e(ta.PROJECT_PAGE, str2, str3, f(str), Boolean.valueOf(z));
        }
        return (a.b) ipChange.ipc$dispatch("-148652635", new Object[]{this, str, str2, str3, Boolean.valueOf(z)});
    }

    public void j(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1873450704")) {
            ipChange.ipc$dispatch("1873450704", new Object[]{this, view, str});
        } else if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str);
            hashMap.put("type", ta.PROJECT_PAGE);
            c.e().G(view, "book_checkin", "bottom", ta.PROJECT_PAGE, hashMap);
        }
    }
}
