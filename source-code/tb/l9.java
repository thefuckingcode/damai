package tb;

import com.alibaba.analytics.utils.Logger;
import com.alibaba.analytics.utils.UTServerAppStatusTrigger;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.appmonitor.sample.a;

/* compiled from: Taobao */
public class l9 implements UTServerAppStatusTrigger.UTServerAppStatusChangeCallback {
    private static l9 a = new l9();

    private l9() {
        UTServerAppStatusTrigger.d(this);
    }

    public static l9 a() {
        return a;
    }

    private void b(boolean z) {
        int i = 0;
        Logger.f("BackgroundTrigger", "isAppOnForeground", Boolean.valueOf(z));
        if (z) {
            a.h().p();
            EventType[] values = EventType.values();
            int length = values.length;
            while (i < length) {
                EventType eventType = values[i];
                com.alibaba.appmonitor.delegate.a.o(eventType, eventType.getForegroundStatisticsInterval());
                i++;
            }
            return;
        }
        EventType[] values2 = EventType.values();
        int length2 = values2.length;
        while (i < length2) {
            EventType eventType2 = values2[i];
            com.alibaba.appmonitor.delegate.a.o(eventType2, eventType2.getBackgroundStatisticsInterval());
            i++;
        }
        com.alibaba.appmonitor.delegate.a.p();
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onBackground() {
        b(false);
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onForeground() {
        b(true);
    }
}
