package tb;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class cp1 implements Comparable<cp1> {
    private static transient /* synthetic */ IpChange $ipChange;
    public final int a;
    public final byte[] b;

    public cp1(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    /* renamed from: a */
    public int compareTo(@NonNull cp1 cp1) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1821374983")) {
            return this.a - cp1.a;
        }
        return ((Integer) ipChange.ipc$dispatch("1821374983", new Object[]{this, cp1})).intValue();
    }
}
