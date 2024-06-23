package tb;

import com.alibaba.appmonitor.event.EventType;
import com.alibaba.appmonitor.pool.Reusable;
import com.alibaba.appmonitor.pool.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class sd1 implements Reusable {
    private Map<qd1, se0> a = Collections.synchronizedMap(new HashMap());

    public se0 a(Integer num, String str, String str2, String str3, Class<? extends se0> cls) {
        boolean z;
        qd1 qd1;
        se0 se0;
        boolean z2 = false;
        if (num.intValue() == EventType.STAT.getEventId()) {
            qd1 = rd1.c().b(str, str2);
            z = false;
        } else {
            qd1 = (qd1) a.a().poll(qd1.class, str, str2, str3);
            z = true;
        }
        se0 se02 = null;
        if (qd1 != null) {
            if (this.a.containsKey(qd1)) {
                se02 = this.a.get(qd1);
                z2 = z;
            } else {
                synchronized (sd1.class) {
                    se0 = (se0) a.a().poll(cls, num, str, str2, str3);
                    this.a.put(qd1, se0);
                }
                se02 = se0;
            }
            if (z2) {
                a.a().offer(qd1);
            }
        }
        return se02;
    }

    public List<se0> b() {
        return new ArrayList(this.a.values());
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void clean() {
        for (se0 se0 : this.a.values()) {
            a.a().offer(se0);
        }
        this.a.clear();
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void fill(Object... objArr) {
        if (this.a == null) {
            this.a = Collections.synchronizedMap(new HashMap());
        }
    }
}
