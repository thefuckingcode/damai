package tb;

import android.content.Context;
import android.content.SharedPreferences;
import cn.damai.common.app.ShareperfenceConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.kvdata.SPProviderProxy;

/* compiled from: Taobao */
public class xw0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HOMEPAGE_ANNOUNCEMENT_CONTENT = "homepage_announcement_content";
    public static final String HOMEPAGE_ANNOUNCEMENT_SHOW_STATUS = "homepage_announcement_show_status";
    public static final String HOMEPAGE_GET = "homepageTopCache";
    public static final String HOMEPAGE_GUESS = "homepageGuessCache";
    public static final String HOMEPAGE_IS_FIRST_LAUNCH = "homepage_is_first_launch";

    private static SharedPreferences a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "786679111")) {
            return (SharedPreferences) ipChange.ipc$dispatch("786679111", new Object[]{context});
        } else if (context == null) {
            return null;
        } else {
            return SPProviderProxy.getSharedPreferences(ShareperfenceConstants.HOMEPAGE_NAME);
        }
    }

    public static String b(String str, String str2, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1690362922")) {
            return (String) ipChange.ipc$dispatch("-1690362922", new Object[]{str, str2, context});
        }
        SharedPreferences a = a(context);
        if (a == null) {
            return str2;
        }
        return a.getString(str, str2);
    }

    public static void c(String str, String str2, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1278354685")) {
            ipChange.ipc$dispatch("-1278354685", new Object[]{str, str2, context});
            return;
        }
        SharedPreferences a = a(context);
        if (a != null) {
            a.edit().putString(str, str2).commit();
        }
    }
}
