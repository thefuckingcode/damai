package tb;

import android.text.TextUtils;
import android.view.View;
import cn.damai.common.user.a;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class ig extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static ig b = null;
    public static String c = "category";
    public static String d = "category";

    public static void f(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1053783500")) {
            ipChange.ipc$dispatch("-1053783500", new Object[]{str, str2, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        hashMap.put("titlelabel", str2);
        ig m = m();
        c.e().x(m.e(str, "top", "tab_item_" + i, hashMap, Boolean.TRUE));
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (r5.equals("pinpai") == false) goto L_0x002b;
     */
    public static String g(String str) {
        IpChange ipChange = $ipChange;
        char c2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-2109897967")) {
            return (String) ipChange.ipc$dispatch("-2109897967", new Object[]{str});
        } else if (TextUtils.isEmpty(str)) {
            return str;
        } else {
            str.hashCode();
            switch (str.hashCode()) {
                case -988144925:
                    break;
                case -703049414:
                    if (str.equals("zhekou")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 50511102:
                    if (str.equals("category")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    return sc.PAGE_NAME;
                case 1:
                    return "discount";
                case 2:
                    return "category";
                default:
                    return str;
            }
        }
    }

    public static ig m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2001398363")) {
            return (ig) ipChange.ipc$dispatch("2001398363", new Object[0]);
        }
        if (b == null) {
            b = new ig();
        }
        return b;
    }

    public a.b h(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1351023631")) {
            return new a.b().i(g(str));
        }
        return (a.b) ipChange.ipc$dispatch("-1351023631", new Object[]{this, str});
    }

    public a.b i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831598381")) {
            return (a.b) ipChange.ipc$dispatch("-1831598381", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("city", str2);
        return e(g(c), "select", "citysbtn", hashMap, Boolean.FALSE);
    }

    public a.b j(int i, int i2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "759069689")) {
            return (a.b) ipChange.ipc$dispatch("759069689", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("physical_city", str2);
        return e(g(c), "citys_" + i, "filter_city_" + i2, hashMap, Boolean.FALSE);
    }

    public a.b k(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "578684310")) {
            return (a.b) ipChange.ipc$dispatch("578684310", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("time_type", str2);
        return e(g(c), "select", "timerange", hashMap, Boolean.FALSE);
    }

    public a.b l(int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064321395")) {
            return (a.b) ipChange.ipc$dispatch("-1064321395", new Object[]{this, Integer.valueOf(i), str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("time_type", str2);
        hashMap.put("time_name", str3);
        String g = g(c);
        return e(g, "selectbtn", "timerange_" + i, hashMap, Boolean.FALSE);
    }

    public a.b n(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1259141950")) {
            return (a.b) ipChange.ipc$dispatch("1259141950", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        String g = g(c);
        return e(g, "categoryselect", "categoryselect_" + i, hashMap, Boolean.FALSE);
    }

    public a.b o(int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1833821059")) {
            return (a.b) ipChange.ipc$dispatch("-1833821059", new Object[]{this, Integer.valueOf(i), str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("sorttype_name", str2);
        hashMap.put("sorttype_id", str3);
        String g = g(c);
        return e(g, "selectbtn", "sorttype_" + i, hashMap, Boolean.FALSE);
    }

    public a.b p(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-662020600")) {
            return new a.b().i(g(str));
        }
        return (a.b) ipChange.ipc$dispatch("-662020600", new Object[]{this, str});
    }

    public a.b q() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-445969153")) {
            return e(g(c), "top", "search", null, Boolean.TRUE);
        }
        return (a.b) ipChange.ipc$dispatch("-445969153", new Object[]{this});
    }

    public a.b r(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1408986193")) {
            return (a.b) ipChange.ipc$dispatch("-1408986193", new Object[]{this, Integer.valueOf(i), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("item_id", str2);
        }
        String g = g(c);
        return e(g, "xiannv_mustsee", "item_" + i, hashMap, Boolean.TRUE);
    }

    public void s(View view, int i, String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-735709803")) {
            ipChange.ipc$dispatch("-735709803", new Object[]{this, view, Integer.valueOf(i), str, str2, str3, str4});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("item_id", str2);
        }
        hashMap.put("card_type", str3);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("alg", str4);
        }
        c e = c.e();
        e.G(view, "item_" + i, "categorylist", g(c), hashMap);
    }
}
