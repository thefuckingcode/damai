package tb;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class sm1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1970018109")) {
            return (String) ipChange.ipc$dispatch("1970018109", new Object[]{context, str});
        } else if (context == null) {
            return "";
        } else {
            if ("待付款".equals(str)) {
                return "#FF3E29";
            }
            if ("待发货".equals(str)) {
                return "#FFA913";
            }
            if ("已发货".equals(str) || "交易完成".equals(str)) {
                return "#2CB95E";
            }
            if ("交易关闭".equals(str)) {
                return "#888888";
            }
            return "";
        }
    }

    public static String b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-458219609")) {
            return (String) ipChange.ipc$dispatch("-458219609", new Object[]{str});
        } else if (str == null) {
            return null;
        } else {
            return Pattern.compile("^\\s*|\\s*$").matcher(str).replaceAll("");
        }
    }
}
