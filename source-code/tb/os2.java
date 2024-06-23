package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class os2 {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Integer a = 100;
    @Nullable
    private Boolean b;
    @Nullable
    private Integer c;
    @Nullable
    private Integer d;
    @Nullable
    private Integer e;
    @Nullable
    private Boolean f;

    public os2() {
        Boolean bool = Boolean.FALSE;
        this.b = bool;
        this.f = bool;
    }

    @Nullable
    public final Boolean a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-774762160")) {
            return this.b;
        }
        return (Boolean) ipChange.ipc$dispatch("-774762160", new Object[]{this});
    }

    @Nullable
    public final Boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "951667361")) {
            return this.f;
        }
        return (Boolean) ipChange.ipc$dispatch("951667361", new Object[]{this});
    }

    @Nullable
    public final Integer c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1169014989")) {
            return this.d;
        }
        return (Integer) ipChange.ipc$dispatch("1169014989", new Object[]{this});
    }

    @Nullable
    public final Integer d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1834470451")) {
            return this.e;
        }
        return (Integer) ipChange.ipc$dispatch("1834470451", new Object[]{this});
    }

    @Nullable
    public final Integer e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1950084638")) {
            return this.c;
        }
        return (Integer) ipChange.ipc$dispatch("1950084638", new Object[]{this});
    }

    @Nullable
    public final Integer f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "778781433")) {
            return this.a;
        }
        return (Integer) ipChange.ipc$dispatch("778781433", new Object[]{this});
    }

    public final void g(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516962586")) {
            ipChange.ipc$dispatch("-516962586", new Object[]{this, bool});
            return;
        }
        this.b = bool;
    }

    public final void h(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "66117381")) {
            ipChange.ipc$dispatch("66117381", new Object[]{this, num});
            return;
        }
        this.d = num;
    }

    public final void i(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1447955807")) {
            ipChange.ipc$dispatch("1447955807", new Object[]{this, num});
            return;
        }
        this.e = num;
    }

    public final void j(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1345848724")) {
            ipChange.ipc$dispatch("-1345848724", new Object[]{this, num});
            return;
        }
        this.c = num;
    }

    public final void k(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1213632679")) {
            ipChange.ipc$dispatch("-1213632679", new Object[]{this, num});
            return;
        }
        this.a = num;
    }
}
