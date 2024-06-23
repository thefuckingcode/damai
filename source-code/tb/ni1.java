package tb;

import androidx.collection.LongSparseArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ni1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ni1 b;
    private LongSparseArray<mi1> a = new LongSparseArray<>();

    private ni1() {
    }

    public static ni1 a() {
        ni1 ni1;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305954299")) {
            return (ni1) ipChange.ipc$dispatch("1305954299", new Object[0]);
        }
        ni1 ni12 = b;
        if (ni12 != null) {
            return ni12;
        }
        synchronized (ep1.class) {
            if (b == null) {
                b = new ni1();
            }
            ni1 = b;
        }
        return ni1;
    }

    public mi1 b(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "871884612")) {
            return (mi1) ipChange.ipc$dispatch("871884612", new Object[]{this, Long.valueOf(j)});
        }
        mi1 mi1 = this.a.get(j);
        if (mi1 != null) {
            return mi1;
        }
        mi1 mi12 = new mi1();
        this.a.put(j, mi12);
        return mi12;
    }

    public void c(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "866891887")) {
            ipChange.ipc$dispatch("866891887", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.a.remove(j);
    }
}
