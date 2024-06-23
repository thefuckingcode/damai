package tb;

import android.app.Activity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;

/* compiled from: Taobao */
public class me2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1524245543")) {
            return ((Integer) ipChange.ipc$dispatch("1524245543", new Object[]{activity})).intValue();
        }
        int identifier = activity.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return activity.getResources().getDimensionPixelSize(identifier);
        }
        return -1;
    }
}
