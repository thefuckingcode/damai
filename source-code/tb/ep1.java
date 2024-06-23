package tb;

import androidx.collection.LongSparseArray;
import cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean.SkuPerform;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ep1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ep1 b;
    private LongSparseArray<st0> a = new LongSparseArray<>();

    private ep1() {
        new LongSparseArray();
    }

    public static long a(long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "174605087")) {
            return j ^ 2147483647L;
        }
        return ((Long) ipChange.ipc$dispatch("174605087", new Object[]{Long.valueOf(j)})).longValue();
    }

    public static long b(SkuPerform skuPerform) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-15674050")) {
            return ((Long) ipChange.ipc$dispatch("-15674050", new Object[]{skuPerform})).longValue();
        } else if (skuPerform != null) {
            return skuPerform.performId ^ 2147483647L;
        } else {
            return -1;
        }
    }

    public static ep1 d() {
        ep1 ep1;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033579653")) {
            return (ep1) ipChange.ipc$dispatch("-1033579653", new Object[0]);
        }
        ep1 ep12 = b;
        if (ep12 != null) {
            return ep12;
        }
        synchronized (ep1.class) {
            if (b == null) {
                b = new ep1();
            }
            ep1 = b;
        }
        return ep1;
    }

    public st0 c(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-38950862")) {
            return (st0) ipChange.ipc$dispatch("-38950862", new Object[]{this, Long.valueOf(j)});
        }
        st0 st0 = this.a.get(j);
        if (st0 != null) {
            return st0;
        }
        st0 st02 = new st0();
        this.a.put(j, st02);
        return st02;
    }

    public void e(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-75825945")) {
            ipChange.ipc$dispatch("-75825945", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.a.remove(j);
    }
}
