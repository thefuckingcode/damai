package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public final class e12 {
    private static transient /* synthetic */ IpChange $ipChange;
    private volatile int a;
    private volatile int b;
    private volatile int c;
    private volatile int d;
    private volatile int e;

    public e12() {
        h(1000);
    }

    public final int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-876294325")) {
            return this.d;
        }
        return ((Integer) ipChange.ipc$dispatch("-876294325", new Object[]{this})).intValue();
    }

    public final int b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "333271456")) {
            return this.c;
        }
        return ((Integer) ipChange.ipc$dispatch("333271456", new Object[]{this})).intValue();
    }

    public final int c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1821350829")) {
            return this.b;
        }
        return ((Integer) ipChange.ipc$dispatch("-1821350829", new Object[]{this})).intValue();
    }

    public final int d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-606991696")) {
            return this.a;
        }
        return ((Integer) ipChange.ipc$dispatch("-606991696", new Object[]{this})).intValue();
    }

    public final void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1431596692")) {
            ipChange.ipc$dispatch("-1431596692", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.e = i;
    }

    public final void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-157161697")) {
            ipChange.ipc$dispatch("-157161697", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.d = i;
    }

    public final void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "395976706")) {
            ipChange.ipc$dispatch("395976706", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (this.c != i) {
            this.b = this.c;
        }
        this.c = i;
    }

    public final void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-398714790")) {
            ipChange.ipc$dispatch("-398714790", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.a = i;
    }
}
