package tb;

import android.text.TextUtils;
import android.view.View;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class pc0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int UT_TYPE_CLICK = 2;
    public static final int UT_TYPE_EXPOSURE = 1;

    public static void a(JSONArray jSONArray, JSONArray jSONArray2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1587432529")) {
            ipChange.ipc$dispatch("-1587432529", new Object[]{jSONArray, jSONArray2});
            return;
        }
        d(null, 2, jSONArray, jSONArray2, null);
    }

    public static void b(View view, JSONArray jSONArray, JSONArray jSONArray2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2101082910")) {
            ipChange.ipc$dispatch("2101082910", new Object[]{view, jSONArray, jSONArray2});
            return;
        }
        d(view, 1, jSONArray, jSONArray2, null);
    }

    public static void c(View view, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1259723846")) {
            ipChange.ipc$dispatch("1259723846", new Object[]{view, jSONArray, jSONArray2, jSONArray3});
            return;
        }
        d(view, 1, jSONArray, jSONArray2, jSONArray3);
    }

    private static void d(View view, int i, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2070943451")) {
            ipChange.ipc$dispatch("-2070943451", new Object[]{view, Integer.valueOf(i), jSONArray, jSONArray2, jSONArray3});
            return;
        }
        try {
            if (c31.b(jSONArray) >= 3) {
                String string = jSONArray.getString(0);
                String string2 = jSONArray.getString(1);
                String string3 = jSONArray.getString(2);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    if (!TextUtils.isEmpty(string3)) {
                        HashMap hashMap = new HashMap();
                        int b = c31.b(jSONArray2);
                        boolean z = true;
                        for (int i2 = 0; i2 < b; i2 += 2) {
                            String string4 = jSONArray2.getString(i2);
                            int i3 = i2 + 1;
                            String str = "";
                            String string5 = i3 < b ? jSONArray2.getString(i3) : str;
                            if (!TextUtils.isEmpty(string4)) {
                                if (string5 != null) {
                                    str = string5;
                                }
                                if ("openNewPage".equals(string4)) {
                                    z = "1".equals(str) || "true".equals(str) || TextUtils.isEmpty(str);
                                } else if (!z || i != 2 || (!za.PRE_CONTENT_ID.equals(string4) && !za.PRE_CONTENT_TYPE.equals(string4))) {
                                    hashMap.put(string4, str);
                                }
                            }
                        }
                        hashMap.put("usercode", d20.E());
                        hashMap.put("city", d20.d() + "市");
                        if (i == 1) {
                            c.e().G(view, string3, string2, string, hashMap);
                        } else {
                            c.e().x(new a.b().i(string).f(string2).l(string3).g(z).j(hashMap));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
