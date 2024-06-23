package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class a5 {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;
    private String c;
    private tw1<Integer> d;

    public String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-624907988")) {
            return this.c;
        }
        return (String) ipChange.ipc$dispatch("-624907988", new Object[]{this});
    }

    public int b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1703043465")) {
            return this.b;
        }
        return ((Integer) ipChange.ipc$dispatch("1703043465", new Object[]{this})).intValue();
    }

    public tw1<Integer> c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "98806413")) {
            return this.d;
        }
        return (tw1) ipChange.ipc$dispatch("98806413", new Object[]{this});
    }

    public int d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1248389848")) {
            return this.a;
        }
        return ((Integer) ipChange.ipc$dispatch("1248389848", new Object[]{this})).intValue();
    }

    public void e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1809932082")) {
            ipChange.ipc$dispatch("1809932082", new Object[]{this, str});
            return;
        }
        this.c = str;
    }

    public void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2129445063")) {
            ipChange.ipc$dispatch("-2129445063", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.b = i;
    }

    public void g(tw1<Integer> tw1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677744353")) {
            ipChange.ipc$dispatch("-1677744353", new Object[]{this, tw1});
            return;
        }
        this.d = tw1;
    }

    public void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-43170358")) {
            ipChange.ipc$dispatch("-43170358", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.a = i;
    }
}
