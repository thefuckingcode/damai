package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public final class am {
    private static transient /* synthetic */ IpChange $ipChange;
    private static am b;
    private int a;

    private am() {
    }

    public static am b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471842559")) {
            return (am) ipChange.ipc$dispatch("-471842559", new Object[0]);
        }
        if (b == null) {
            synchronized (am.class) {
                if (b == null) {
                    b = new am();
                }
            }
        }
        return b;
    }

    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1845450398")) {
            return this.a;
        }
        return ((Integer) ipChange.ipc$dispatch("-1845450398", new Object[]{this})).intValue();
    }

    public void c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1185630316")) {
            ipChange.ipc$dispatch("1185630316", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1119647244")) {
            ipChange.ipc$dispatch("-1119647244", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1985281048")) {
            ipChange.ipc$dispatch("-1985281048", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.a = i;
    }

    public void f(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-975672887")) {
            ipChange.ipc$dispatch("-975672887", new Object[]{this, Float.valueOf(f)});
        }
    }

    public void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-113460819")) {
            ipChange.ipc$dispatch("-113460819", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-468816749")) {
            ipChange.ipc$dispatch("-468816749", new Object[]{this, Integer.valueOf(i)});
        }
    }
}
