package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;

/* compiled from: Taobao */
public class mn {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FLAG_NONE = -2;
    public static final int FLAG_UNDEFINE = -1;
    public int a;
    public int b;
    public int c;

    public mn(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-155897734")) {
            return ((Boolean) ipChange.ipc$dispatch("-155897734", new Object[]{this, obj})).booleanValue();
        }
        mn mnVar = (mn) obj;
        if (this == obj) {
            return true;
        }
        if (this.a == mnVar.a && this.b == mnVar.b && this.c == mnVar.c) {
            return true;
        }
        return false;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573813747")) {
            return (String) ipChange.ipc$dispatch("573813747", new Object[]{this});
        }
        return "pos@[" + this.a + AVFSCacheConstants.COMMA_SEP + this.b + AVFSCacheConstants.COMMA_SEP + this.c + jl1.ARRAY_END_STR;
    }
}
