package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class cc0 extends kf1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final List<Long> d = new ArrayList(100);
    private boolean e = false;

    public void k(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251709533")) {
            ipChange.ipc$dispatch("1251709533", new Object[]{this, Long.valueOf(j)});
        } else if (!this.e) {
            this.d.add(Long.valueOf(j));
            int size = this.d.size();
            if (size == 100) {
                this.e = true;
                long j2 = 0;
                for (int i = 0; i < size; i++) {
                    j2 += this.d.get(i).longValue();
                }
                b(kf1.TYPE_VIEW_DRAW, ((double) j2) / ((double) size), 0);
            }
        }
    }
}
