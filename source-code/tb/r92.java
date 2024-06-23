package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class r92 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a;
    private final int b;
    @NotNull
    private final String c;

    public r92(int i, int i2, @NotNull String str) {
        k21.i(str, "channelTitle");
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public final int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1416007524")) {
            return this.b;
        }
        return ((Integer) ipChange.ipc$dispatch("1416007524", new Object[]{this})).intValue();
    }

    public final int b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1574928438")) {
            return this.a;
        }
        return ((Integer) ipChange.ipc$dispatch("-1574928438", new Object[]{this})).intValue();
    }

    @NotNull
    public final String c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-822406400")) {
            return this.c;
        }
        return (String) ipChange.ipc$dispatch("-822406400", new Object[]{this});
    }

    public boolean equals(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-158555424")) {
            return ((Boolean) ipChange.ipc$dispatch("-158555424", new Object[]{this, obj})).booleanValue();
        }
        if (this != obj) {
            if (obj instanceof r92) {
                r92 r92 = (r92) obj;
                if (!(this.a == r92.a && this.b == r92.b && k21.d(this.c, r92.c))) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-2089134441")) {
            return ((Integer) ipChange.ipc$dispatch("-2089134441", new Object[]{this})).intValue();
        }
        int i2 = ((this.a * 31) + this.b) * 31;
        String str = this.c;
        if (str != null) {
            i = str.hashCode();
        }
        return i2 + i;
    }

    @NotNull
    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "491425357")) {
            return (String) ipChange.ipc$dispatch("491425357", new Object[]{this});
        }
        return "ShareChannelUIData(channelId=" + this.a + ", channelIconRes=" + this.b + ", channelTitle=" + this.c + jl1.BRACKET_END_STR;
    }
}
