package tb;

import com.alibaba.appmonitor.offline.TempEventMgr;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class rd1 {
    private static rd1 b;
    public List<qd1> a;

    private rd1(int i) {
        this.a = new ArrayList(i);
    }

    public static rd1 c() {
        if (b == null) {
            b = new rd1(3);
        }
        return b;
    }

    public void a(qd1 qd1) {
        if (this.a.contains(qd1)) {
            this.a.remove(qd1);
        }
        this.a.add(qd1);
    }

    public qd1 b(String str, String str2) {
        List<qd1> list;
        if (str == null || str2 == null || (list = this.a) == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            qd1 qd1 = this.a.get(i);
            if (qd1 != null && qd1.getModule().equals(str) && qd1.c().equals(str2)) {
                return qd1;
            }
        }
        qd1 u = TempEventMgr.t().u(str, str2);
        if (u != null) {
            this.a.add(u);
        }
        return u;
    }
}
