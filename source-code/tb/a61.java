package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class a61 {
    private static transient /* synthetic */ IpChange $ipChange;
    public final String a;
    public final Object b;

    public a61(String str, Object obj) {
        this.a = str;
        this.b = obj;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1351170659")) {
            return ((Boolean) ipChange.ipc$dispatch("1351170659", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj == null || a61.class != obj.getClass()) {
                return false;
            }
            String str = this.a;
            String str2 = ((a61) obj).a;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
            return false;
        }
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "673469466")) {
            return ((Integer) ipChange.ipc$dispatch("673469466", new Object[]{this})).intValue();
        }
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "48293674")) {
            return (String) ipChange.ipc$dispatch("48293674", new Object[]{this});
        }
        return "KeyValue{key='" + this.a + '\'' + ", value=" + this.b + '}';
    }
}
