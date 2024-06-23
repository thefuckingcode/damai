package tb;

import android.app.Activity;
import android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class mt0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final mt0 INSTANCE = new mt0();

    private mt0() {
    }

    public final int a(@NotNull Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1644389549")) {
            return ((Integer) ipChange.ipc$dispatch("-1644389549", new Object[]{this, activity})).intValue();
        }
        k21.i(activity, "activity");
        if (Build.VERSION.SDK_INT >= 23) {
            return u50.INSTANCE.a(activity, 45.0f) + me2.a(activity);
        }
        return u50.INSTANCE.a(activity, 45.0f);
    }
}
