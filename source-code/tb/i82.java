package tb;

import com.alibaba.analytics.core.selfmonitor.SelfMonitorEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
public class i82 {
    private static SelfMonitorEventListener b;
    private List<SelfMonitorEventListener> a = Collections.synchronizedList(new ArrayList());

    public void a(SelfMonitorEventListener selfMonitorEventListener) {
        try {
            this.a.add(selfMonitorEventListener);
        } catch (Exception unused) {
        }
    }

    public void onEvent(h82 h82) {
        try {
            SelfMonitorEventListener selfMonitorEventListener = b;
            if (selfMonitorEventListener != null) {
                selfMonitorEventListener.onEvent(h82);
            }
            for (int i = 0; i < this.a.size(); i++) {
                this.a.get(i).onEvent(h82);
            }
        } catch (Exception unused) {
        }
    }
}
