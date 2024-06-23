package tb;

import cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean.SkuPerform;
import cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean.SkuPerformBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class st0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<SkuPerformBase> a;
    private SkuPerform b;

    st0() {
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2098600904")) {
            ipChange.ipc$dispatch("2098600904", new Object[]{this});
            return;
        }
        b();
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883510920")) {
            ipChange.ipc$dispatch("883510920", new Object[]{this});
            return;
        }
        this.b = null;
    }

    public SkuPerform c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1799663875")) {
            return this.b;
        }
        return (SkuPerform) ipChange.ipc$dispatch("-1799663875", new Object[]{this});
    }

    public void d(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "931686155")) {
            ipChange.ipc$dispatch("931686155", new Object[]{this, Long.valueOf(j)});
        }
    }

    public void e(SkuPerform skuPerform) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1681964613")) {
            ipChange.ipc$dispatch("1681964613", new Object[]{this, skuPerform});
            return;
        }
        this.b = skuPerform;
    }

    public void f(SkuPerformBase skuPerformBase) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2118577819")) {
            ipChange.ipc$dispatch("-2118577819", new Object[]{this, skuPerformBase});
        }
    }

    public void g(List<SkuPerformBase> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "436324569")) {
            ipChange.ipc$dispatch("436324569", new Object[]{this, list});
            return;
        }
        this.a = list;
    }
}
