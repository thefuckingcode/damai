package tb;

import com.alibaba.pictures.bricks.alime.IAliMeCouponFaq;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class n4 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final n4 INSTANCE = new n4();
    @Nullable
    private static IAliMeCouponFaq a;

    private n4() {
    }

    @Nullable
    public final synchronized IAliMeCouponFaq a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-602750938")) {
            return (IAliMeCouponFaq) ipChange.ipc$dispatch("-602750938", new Object[]{this});
        }
        return a;
    }

    public final synchronized void b(@Nullable IAliMeCouponFaq iAliMeCouponFaq) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2041848725")) {
            ipChange.ipc$dispatch("-2041848725", new Object[]{this, iAliMeCouponFaq});
            return;
        }
        a = iAliMeCouponFaq;
    }
}
