package cn.damai.musicfestival.model;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.common.nav.DMNav;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.d20;

/* compiled from: Taobao */
public class MusicPageNav implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void openH5MusicIpPage(Context context, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1659924587")) {
            ipChange.ipc$dispatch("1659924587", new Object[]{context, str});
        } else if (!TextUtils.isEmpty(str) && context != null) {
            if (!AppConfig.v()) {
                str2 = "https://m.damai.cn/app/dmfe/music/pages/detail/index.html?type=5&id=" + str;
            } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
                str2 = "https://market.wapa.damai.cn/app/dmfe/music/pages/detail/index.html?type=5&id=" + str;
            } else {
                str2 = "https://m.damai.cn/app/dmfe/music/pages/detail/index.html?type=5&id=" + str;
            }
            DMNav.from(context).toUri(str2);
        }
    }

    public static void openH5MusicMoreListPage(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1618086871")) {
            ipChange.ipc$dispatch("1618086871", new Object[]{context, str});
        } else if (!TextUtils.isEmpty(str) && context != null) {
            try {
                if (str.startsWith("http")) {
                    String c = d20.c();
                    if (!TextUtils.isEmpty(c)) {
                        str = Uri.parse(str).buildUpon().appendQueryParameter("cityId", c).toString();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            DMNav.from(context).toUri(str);
        }
    }
}
