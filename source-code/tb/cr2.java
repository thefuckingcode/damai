package tb;

import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.store.LogStoreMgr;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.appmonitor.model.UTDimensionValueSet;
import com.alibaba.appmonitor.pool.ReuseJSONArray;
import com.alibaba.appmonitor.pool.a;
import com.alibaba.fastjson.JSON;
import com.alibaba.motu.tbrest.rest.RestConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class cr2 {
    public static void a(rq2 rq2) {
        if (rq2 != null) {
            LogStoreMgr.l().d(new u81(rq2.a, String.valueOf(rq2.b), rq2.c, rq2.d, rq2.e, rq2.f));
            a.a().offer(rq2);
        }
    }

    public static void b(UTDimensionValueSet uTDimensionValueSet, se0 se0) {
        Integer eventId = uTDimensionValueSet.getEventId();
        if (eventId != null) {
            EventType eventType = EventType.getEventType(eventId.intValue());
            rq2 rq2 = (rq2) a.a().poll(rq2.class, new Object[0]);
            rq2.b = RestConstants.EventID.AGGREGATION_LOG;
            rq2.c = se0.a;
            rq2.d = se0.b;
            rq2.f.putAll(com.alibaba.appmonitor.delegate.a.c());
            if (uTDimensionValueSet.getMap() != null) {
                rq2.f.putAll(uTDimensionValueSet.getMap());
                rq2.f.remove("commitDay");
            }
            HashMap hashMap = new HashMap();
            hashMap.put("meta", q52.b());
            hashMap.put("_event_id", eventId);
            ReuseJSONArray reuseJSONArray = (ReuseJSONArray) a.a().poll(ReuseJSONArray.class, new Object[0]);
            reuseJSONArray.add(se0.b());
            a.a().offer(se0);
            hashMap.put("data", reuseJSONArray);
            rq2.f.put(eventType.getAggregateEventArgsKey(), JSON.toJSONString(hashMap));
            rq2.f.put(LogField.EVENTID.toString(), String.valueOf((int) RestConstants.EventID.AGGREGATION_LOG));
            c(rq2);
            a.a().offer(reuseJSONArray);
        }
    }

    public static void c(rq2 rq2) {
        LogStoreMgr.l().d(new u81(rq2.a, String.valueOf(rq2.b), rq2.c, rq2.d, rq2.e, rq2.f));
        a.a().offer(rq2);
    }

    public static void d(Map<UTDimensionValueSet, List<se0>> map) {
        Integer eventId;
        for (Map.Entry<UTDimensionValueSet, List<se0>> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            UTDimensionValueSet key = entry.getKey();
            List<se0> value = entry.getValue();
            if (!(value.size() == 0 || (eventId = key.getEventId()) == null)) {
                EventType eventType = EventType.getEventType(eventId.intValue());
                int i = 0;
                rq2 rq2 = (rq2) a.a().poll(rq2.class, new Object[0]);
                rq2.b = eventId.intValue();
                rq2.f.putAll(com.alibaba.appmonitor.delegate.a.c());
                if (key.getMap() != null) {
                    rq2.f.putAll(key.getMap());
                    rq2.f.remove("commitDay");
                }
                HashMap hashMap = new HashMap();
                hashMap.put("meta", q52.b());
                ReuseJSONArray reuseJSONArray = (ReuseJSONArray) a.a().poll(ReuseJSONArray.class, new Object[0]);
                for (se0 se0 : value) {
                    reuseJSONArray.add(se0.b());
                    if (i == 0) {
                        sb.append(se0.a);
                        sb2.append(se0.b);
                    } else {
                        sb.append(",");
                        sb.append(se0.a);
                        sb2.append(",");
                        sb2.append(se0.b);
                    }
                    i++;
                    a.a().offer(se0);
                }
                hashMap.put("data", reuseJSONArray);
                rq2.f.put(eventType.getAggregateEventArgsKey(), JSON.toJSONString(hashMap));
                String sb3 = sb.toString();
                String sb4 = sb2.toString();
                rq2.f.put(LogField.ARG1.toString(), sb3);
                rq2.f.put(LogField.ARG2.toString(), sb4);
                rq2.c = sb3;
                rq2.d = sb4;
                c(rq2);
                a.a().offer(reuseJSONArray);
            }
            a.a().offer(key);
        }
    }
}
