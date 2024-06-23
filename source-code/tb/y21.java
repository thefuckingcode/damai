package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class y21 {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;

    public y21() {
        this(0, 0);
    }

    public boolean a(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1064476304")) {
            return i >= c() && i <= d();
        }
        return ((Boolean) ipChange.ipc$dispatch("-1064476304", new Object[]{this, Integer.valueOf(i)})).booleanValue();
    }

    public int b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-476160784")) {
            return this.b;
        }
        return ((Integer) ipChange.ipc$dispatch("-476160784", new Object[]{this})).intValue();
    }

    public int c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-654021713")) {
            return this.a;
        }
        return ((Integer) ipChange.ipc$dispatch("-654021713", new Object[]{this})).intValue();
    }

    public int d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-327574213")) {
            return (c() + b()) - 1;
        }
        return ((Integer) ipChange.ipc$dispatch("-327574213", new Object[]{this})).intValue();
    }

    public y21(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
