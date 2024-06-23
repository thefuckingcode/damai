package tb;

import android.text.TextUtils;
import cn.damai.common.util.ToastUtil;
import cn.damai.common.util.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class cw0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1856857007")) {
            return (String) ipChange.ipc$dispatch("1856857007", new Object[0]);
        }
        try {
            return a.n(xs0.a().getAssets().open("home_appglobalconfig_mock_lottie_template.json"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-148730356") ? (String) ipChange.ipc$dispatch("-148730356", new Object[0]) : d20.B("MOCK_LOTTIE_URL");
    }

    public static boolean c(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1657374611")) {
            return !TextUtils.isEmpty(str) && str.startsWith("testlottie=");
        }
        return ((Boolean) ipChange.ipc$dispatch("1657374611", new Object[]{str})).booleanValue();
    }

    public static void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "152069434")) {
            ipChange.ipc$dispatch("152069434", new Object[]{str});
            return;
        }
        String replaceFirst = str.replaceFirst("testlottie=", "");
        if (replaceFirst.startsWith("http")) {
            d20.T("MOCK_LOTTIE_URL", replaceFirst);
            ToastUtil.a().j(xs0.a(), "mockLottieUrl已保存");
            return;
        }
        d20.T("MOCK_LOTTIE_URL", "");
        ToastUtil.a().j(xs0.a(), "mockLottieUrl已清除");
    }
}
