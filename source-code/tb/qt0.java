package tb;

import android.net.Uri;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class qt0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static List<String> a = new ArrayList();
    public static String b = "https://m.damai.cn";
    public static String c = "http://market.wapa.damai.cn";
    public static String d = "downgradetest/";
    public static String e = "/damai/order/item/index.html";
    public static String f = ("/damai/" + d + "order/item/index.html");
    public static String g = "/damai/order/list/index.html";
    public static String h = ("/damai/" + d + "order/list/index.html");
    public static String i = "/damai/activity/savecomment/index.html";
    public static String j = "/shows/pages/save-comment.html";
    public static String k = "/damai/detail/item.html";
    public static String l = ("/damai/" + d + "detail/item.html");

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AppConfig.EnvMode.values().length];
            a = iArr;
            try {
                iArr[AppConfig.EnvMode.prepare.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("/damai/");
        sb.append(d);
        sb.append("perform/item.html");
    }

    public static String a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1729250611")) {
            return (String) ipChange.ipc$dispatch("-1729250611", new Object[0]);
        }
        if (a.a[AppConfig.g().ordinal()] != 1) {
            return b + k;
        }
        return c + l;
    }

    public static List<String> b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1898644913")) {
            return (List) ipChange.ipc$dispatch("-1898644913", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h);
        arrayList.add(g);
        return arrayList;
    }

    public static List<String> c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1747849963")) {
            return (List) ipChange.ipc$dispatch("-1747849963", new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(f);
        arrayList.add(e);
        return arrayList;
    }

    public static List<String> d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "88694117")) {
            return (List) ipChange.ipc$dispatch("88694117", new Object[0]);
        }
        a.add(e);
        a.add(g);
        a.add(f);
        a.add(h);
        a.add(i);
        a.add(j);
        return a;
    }

    public static boolean e(String str, List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-83512032")) {
            return ((Boolean) ipChange.ipc$dispatch("-83512032", new Object[]{str, list})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            for (String str2 : list) {
                Uri parse = Uri.parse(str);
                if (parse.getPath() != null && parse.getPath().equals(str2)) {
                    return true;
                }
            }
            return false;
        }
    }
}
