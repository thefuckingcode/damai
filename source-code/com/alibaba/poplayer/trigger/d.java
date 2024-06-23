package com.alibaba.poplayer.trigger;

import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.trigger.Event;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.List;
import tb.cr1;

/* compiled from: Taobao */
public class d<T extends Event> extends c {
    public d(b bVar) {
        super(bVar);
    }

    public void c(T t, List<BaseConfigItem> list) {
        if (!(list == null || list.isEmpty())) {
            b(1024);
            long currentTimeStamp = PopLayer.getReference().getCurrentTimeStamp();
            long j = AbsPerformance.LONG_NIL;
            BaseConfigItem baseConfigItem = null;
            for (int i = 0; i < list.size(); i++) {
                long startTimeStamp = list.get(i).getStartTimeStamp() - currentTimeStamp;
                if (startTimeStamp > 0 && startTimeStamp < j) {
                    baseConfigItem = list.get(i);
                    j = startTimeStamp;
                }
            }
            if (j > 0 && baseConfigItem != null) {
                cr1.b("TriggerTimerMgr.checkTimeAndRescheduleIfNeed.UUID{%s}.timeNotStart.leftTime{%sms}.startLater", baseConfigItem.uuid, Long.valueOf(j));
                a(t, j, 1024);
            }
        }
    }
}
