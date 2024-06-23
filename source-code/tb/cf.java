package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class cf<EventData, BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    private EventData a;

    public cf(EventData eventdata) {
        this.a = eventdata;
    }

    public final EventData a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "98995005")) {
            return this.a;
        }
        return (EventData) ipChange.ipc$dispatch("98995005", new Object[]{this});
    }
}
