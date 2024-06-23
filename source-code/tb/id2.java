package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class id2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a = 400;
    @Nullable
    private String b;
    @Nullable
    private Long c;
    private boolean d;

    private final boolean b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1047481809")) {
            return ((Boolean) ipChange.ipc$dispatch("-1047481809", new Object[]{this})).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Long l = this.c;
        return currentTimeMillis - (l != null ? l.longValue() : 0) > ((long) this.a);
    }

    @Nullable
    public final String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1149540178")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("1149540178", new Object[]{this});
    }

    public final boolean c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-483117263")) {
            return b() && this.d;
        }
        return ((Boolean) ipChange.ipc$dispatch("-483117263", new Object[]{this})).booleanValue();
    }

    public final void d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2060185477")) {
            ipChange.ipc$dispatch("2060185477", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.d = z;
    }
}
