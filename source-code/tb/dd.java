package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class dd<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    public final boolean a;
    public final T b;
    public final String c;
    public final String d;
    public final long e;

    public dd(T t) {
        this.e = System.nanoTime();
        this.a = true;
        this.b = t;
        this.c = null;
        this.d = null;
    }

    public boolean a(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-229001816")) {
            return System.nanoTime() - this.e <= ((long) i);
        }
        return ((Boolean) ipChange.ipc$dispatch("-229001816", new Object[]{this, Integer.valueOf(i)})).booleanValue();
    }

    public dd(String str, String str2) {
        this.e = System.nanoTime();
        this.a = false;
        this.b = null;
        this.c = str;
        this.d = str2;
    }
}
