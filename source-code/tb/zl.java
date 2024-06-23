package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class zl {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final zl DEFAULT = new b().e(3000).d();
    public static final int DURATION_INFINITE = -1;
    public static final int DURATION_LONG = 5000;
    public static final int DURATION_SHORT = 3000;
    final int a;
    final int b;
    final int c;

    /* compiled from: Taobao */
    public static class b {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a = 3000;
        private int b = 0;
        private int c = 0;

        public zl d() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "497408257")) {
                return new zl(this);
            }
            return (zl) ipChange.ipc$dispatch("497408257", new Object[]{this});
        }

        public b e(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1823940573")) {
                return (b) ipChange.ipc$dispatch("1823940573", new Object[]{this, Integer.valueOf(i)});
            }
            this.a = i;
            return this;
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683049235")) {
            return (String) ipChange.ipc$dispatch("683049235", new Object[]{this});
        }
        return "Configuration{durationInMilliseconds=" + this.a + ", inAnimationResId=" + this.b + ", outAnimationResId=" + this.c + '}';
    }

    private zl(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
    }
}
