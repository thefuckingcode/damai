package cn.damai.baseview.scrollable;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;

    static int a(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-249932899")) {
            return ((Integer) ipChange.ipc$dispatch("-249932899", new Object[]{context, Integer.valueOf(i)})).intValue();
        }
        return (int) ((((float) i) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
