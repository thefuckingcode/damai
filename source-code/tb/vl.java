package tb;

import cn.damai.tetris.core.IContext;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class vl<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final IContext a;
    private String b;
    private T c;

    public vl(IContext iContext) {
        this.a = iContext;
    }

    public IContext a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2012579904")) {
            return this.a;
        }
        return (IContext) ipChange.ipc$dispatch("2012579904", new Object[]{this});
    }

    public T b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-310647925")) {
            return this.c;
        }
        return (T) ipChange.ipc$dispatch("-310647925", new Object[]{this});
    }

    public String c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1387595639")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("-1387595639", new Object[]{this});
    }

    public void d(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928708841")) {
            ipChange.ipc$dispatch("-928708841", new Object[]{this, t});
            return;
        }
        this.c = t;
    }

    public void e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-358548619")) {
            ipChange.ipc$dispatch("-358548619", new Object[]{this, str});
            return;
        }
        this.b = str;
    }
}
