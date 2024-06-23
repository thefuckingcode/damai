package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class bm {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static bm b = new bm();
    private int a;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final bm a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1826339645")) {
                return (bm) ipChange.ipc$dispatch("-1826339645", new Object[]{this});
            }
            if (bm.b == null) {
                synchronized (bm.class) {
                    if (bm.b == null) {
                        a aVar = bm.Companion;
                        bm.b = new bm(null);
                    }
                    ur2 ur2 = ur2.INSTANCE;
                }
            }
            return bm.b;
        }
    }

    private bm() {
    }

    public /* synthetic */ bm(m40 m40) {
        this();
    }

    public final int c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1967125018")) {
            return this.a;
        }
        return ((Integer) ipChange.ipc$dispatch("-1967125018", new Object[]{this})).intValue();
    }

    public final void d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348258544")) {
            ipChange.ipc$dispatch("1348258544", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public final void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-975853840")) {
            ipChange.ipc$dispatch("-975853840", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public final void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1462226972")) {
            ipChange.ipc$dispatch("-1462226972", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.a = i;
    }

    public final void g(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1232019277")) {
            ipChange.ipc$dispatch("1232019277", new Object[]{this, Float.valueOf(f)});
        }
    }

    public final void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1078653647")) {
            ipChange.ipc$dispatch("-1078653647", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public final void i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "54237327")) {
            ipChange.ipc$dispatch("54237327", new Object[]{this, Integer.valueOf(i)});
        }
    }
}
