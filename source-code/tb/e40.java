package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
public class e40 {
    private static transient /* synthetic */ IpChange $ipChange;
    private c40 a = new c40();
    private c40 b = new c40();
    private c40 c = new c40();

    e40() {
    }

    public static e40 d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1600606779") ? (e40) ipChange.ipc$dispatch("-1600606779", new Object[0]) : new e40();
    }

    public c40 a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2018737447")) {
            return this.c;
        }
        return (c40) ipChange.ipc$dispatch("-2018737447", new Object[]{this});
    }

    public c40 b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-542645792")) {
            return this.a;
        }
        return (c40) ipChange.ipc$dispatch("-542645792", new Object[]{this});
    }

    public void c(LinkedHashMap<String, ArrayList<String>> linkedHashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1300972556")) {
            ipChange.ipc$dispatch("1300972556", new Object[]{this, linkedHashMap});
            return;
        }
        for (Map.Entry<String, ArrayList<String>> entry : linkedHashMap.entrySet()) {
            String key = entry.getKey();
            if ("floorDict".equalsIgnoreCase(key)) {
                this.a.c(entry.getValue());
            } else if ("rowDict".equalsIgnoreCase(key)) {
                this.b.c(entry.getValue());
            } else if ("chairDict".equalsIgnoreCase(key)) {
                this.c.c(entry.getValue());
            }
        }
        s30.d(this.a.a(), "floorDict");
        s30.d(this.b.a(), "rowDict");
        s30.d(this.c.a(), "chairDict");
    }

    public c40 e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1510993390")) {
            return this.b;
        }
        return (c40) ipChange.ipc$dispatch("1510993390", new Object[]{this});
    }
}
