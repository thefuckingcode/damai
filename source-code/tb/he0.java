package tb;

import android.content.Context;
import cn.damai.videoplayer.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class he0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static final String a(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "155526049")) {
            return (String) ipChange.ipc$dispatch("155526049", new Object[]{context, Integer.valueOf(i)});
        } else if (new StringBuilder(i).toString().startsWith("29")) {
            return context.getResources().getString(R$string.error_tips_29);
        } else {
            return context.getResources().getString(R$string.error_tips_default);
        }
    }

    public static final String b(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "837487979")) {
            return context.getResources().getString(R$string.error_tips_default);
        }
        return (String) ipChange.ipc$dispatch("837487979", new Object[]{context});
    }
}
