package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class c40 {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<String> a = new ArrayList<>();

    public ArrayList<String> a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-731062958")) {
            return this.a;
        }
        return (ArrayList) ipChange.ipc$dispatch("-731062958", new Object[]{this});
    }

    public String b(short s) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "298616956")) {
            return (String) ipChange.ipc$dispatch("298616956", new Object[]{this, Short.valueOf(s)});
        }
        try {
            return this.a.get(s);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void c(ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "985395864")) {
            ipChange.ipc$dispatch("985395864", new Object[]{this, arrayList});
            return;
        }
        this.a.clear();
        this.a.addAll(arrayList);
    }
}
