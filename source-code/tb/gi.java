package tb;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.util.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class gi {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766777203")) {
            return (String) ipChange.ipc$dispatch("1766777203", new Object[]{context});
        }
        String str = "";
        try {
            g91.b("CityListDefaultUitl", "read cache -> start time = " + System.currentTimeMillis());
            str = d20.B(ShareperfenceConstants.CITY_DATA_New);
            g91.b("CityListDefaultUitl", "read cache -> start time = " + System.currentTimeMillis());
            if (xf2.j(str)) {
                g91.b("CityListDefaultUitl", "read default -> start time = " + System.currentTimeMillis());
                str = a.n(context.getAssets().open("damai_city_list.json"));
                if (!TextUtils.isEmpty(str)) {
                    d20.T(ShareperfenceConstants.CITY_DATA_New, str);
                }
                g91.b("CityListDefaultUitl", "read default -> end time = " + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
