package com.alibaba.appmonitor.sample;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import tb.h82;
import tb.vq2;
import tb.xd0;
import tb.zf2;

/* compiled from: Taobao */
public class a extends vq2 {
    private static a c;
    private static final String[] d = {"ap_stat", "ap_counter", "ap_alarm"};
    private Map<EventType, AMConifg> a = Collections.synchronizedMap(new HashMap(3));
    private int b;

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.alibaba.appmonitor.sample.a */
    /* JADX WARN: Multi-variable type inference failed */
    private a() {
        p();
        EventType[] values = EventType.values();
        for (EventType eventType : values) {
            Class<? extends xd0> cls = eventType.getCls();
            AMConifg d2 = d(Variables.n().k().i(cls, null, "module,mp ASC ", -1));
            if (d2 == null) {
                try {
                    AMConifg aMConifg = (AMConifg) cls.newInstance();
                    try {
                        aMConifg.module = "event_type";
                        aMConifg.setSampling(eventType.getDefaultSampling());
                    } catch (Exception unused) {
                    }
                    d2 = aMConifg;
                } catch (Exception unused2) {
                }
            }
            this.a.put(eventType, d2);
        }
    }

    private AMConifg d(List<AMConifg> list) {
        AMConifg aMConifg;
        int size = list.size();
        int i = 0;
        while (i < size && !"event_type".equalsIgnoreCase(list.get(i).module)) {
            i++;
        }
        if (i < size) {
            aMConifg = list.remove(i);
            Logger.r("remove root element", new Object[0]);
        } else {
            Logger.r("cannot found the root element", new Object[0]);
            aMConifg = null;
        }
        if (aMConifg == null) {
            return null;
        }
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            AMConifg aMConifg2 = list.get(i2);
            if (TextUtils.isEmpty(aMConifg2.monitorPoint)) {
                aMConifg.add(aMConifg2.module, aMConifg2);
            } else {
                aMConifg.getOrBulidNext(aMConifg2.module).add(aMConifg2.monitorPoint, aMConifg2);
            }
        }
        return aMConifg;
    }

    public static a h() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    private boolean m(EventType eventType, String str, String str2) {
        if (eventType == null || eventType != EventType.COUNTER || !h82.module.equalsIgnoreCase(str)) {
            return false;
        }
        return h82.UPLOAD_TRAFFIC_OFFLINE.equalsIgnoreCase(str2) || h82.TNET_REQUEST_SEND_OFFLINE.equalsIgnoreCase(str2);
    }

    private AMConifg n(Class<? extends AMConifg> cls, JSONObject jSONObject) {
        AMConifg aMConifg = null;
        try {
            AMConifg aMConifg2 = (AMConifg) cls.newInstance();
            try {
                if (jSONObject.containsKey("offline")) {
                    aMConifg2.offline = jSONObject.getString("offline");
                }
                if (jSONObject.containsKey("cp")) {
                    aMConifg2.setSampling(jSONObject.getIntValue("cp"));
                }
                if (aMConifg2 instanceof AlarmConfig) {
                    AlarmConfig alarmConfig = (AlarmConfig) aMConifg2;
                    if (jSONObject.containsKey("scp")) {
                        alarmConfig.successSampling = jSONObject.getIntValue("scp");
                    }
                    if (jSONObject.containsKey("fcp")) {
                        alarmConfig.failSampling = jSONObject.getIntValue("fcp");
                    }
                    return alarmConfig;
                } else if (!(aMConifg2 instanceof StatConfig)) {
                    return aMConifg2;
                } else {
                    StatConfig statConfig = (StatConfig) aMConifg2;
                    if (!jSONObject.containsKey("detail")) {
                        return aMConifg2;
                    }
                    statConfig.detail = jSONObject.getIntValue("detail");
                    return aMConifg2;
                }
            } catch (Throwable unused) {
                aMConifg = aMConifg2;
                Logger.i("new AppMonitorConfig error", new Object[0]);
                return aMConifg;
            }
        } catch (Throwable unused2) {
            Logger.i("new AppMonitorConfig error", new Object[0]);
            return aMConifg;
        }
    }

    @Override // tb.vq2
    public String[] a() {
        return d;
    }

    @Override // tb.vq2
    public void b(String str) {
        super.b(str);
    }

    @Override // tb.vq2
    public void c(String str, Map<String, String> map) {
        AMConifg aMConifg;
        Logger.f("", "namespace", str, "config:", map);
        if (!zf2.e(str) && map != null) {
            ArrayList arrayList = new ArrayList();
            EventType eventTypeByNameSpace = EventType.getEventTypeByNameSpace(str);
            Class cls = eventTypeByNameSpace.getCls();
            try {
                if (map.containsKey("event_type")) {
                    aMConifg = n(cls, JSON.parseObject(map.get("event_type")));
                    map.remove("event_type");
                } else {
                    try {
                        aMConifg = (AMConifg) cls.newInstance();
                        if (aMConifg instanceof AlarmConfig) {
                            AlarmConfig alarmConfig = (AlarmConfig) aMConifg;
                            alarmConfig.successSampling = eventTypeByNameSpace.getDefaultSampling();
                            alarmConfig.failSampling = eventTypeByNameSpace.getDefaultSampling();
                        } else {
                            aMConifg.setSampling(eventTypeByNameSpace.getDefaultSampling());
                        }
                    } catch (Throwable unused) {
                        return;
                    }
                }
                aMConifg.module = "event_type";
                for (String str2 : map.keySet()) {
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = JSON.parseObject(map.get(str2));
                    } catch (Throwable th) {
                        Logger.h(null, th, new Object[0]);
                    }
                    if (jSONObject != null) {
                        try {
                            AMConifg n = n(cls, jSONObject);
                            n.module = str2;
                            JSONObject jSONObject2 = jSONObject.getJSONObject("mps");
                            if (jSONObject2 != null) {
                                for (String str3 : jSONObject2.keySet()) {
                                    AMConifg n2 = n(cls, jSONObject2.getJSONObject(str3));
                                    n2.module = str2;
                                    n2.monitorPoint = str3;
                                    n.add(str3, n2);
                                    arrayList.add(n2);
                                }
                            }
                            aMConifg.add(str2, n);
                            arrayList.add(n);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                }
                arrayList.add(aMConifg);
                this.a.put(eventTypeByNameSpace, aMConifg);
                Variables.n().k().b(aMConifg.getClass());
                Variables.n().k().q(arrayList);
            } catch (Throwable th3) {
                Logger.i("", "parse config error", th3);
            }
        }
    }

    public boolean e(String str, String str2, Boolean bool, Map<String, String> map) {
        return i(str, str2, bool, map);
    }

    public boolean f(EventType eventType, String str, String str2) {
        return l(eventType, str, str2, null);
    }

    public boolean g(EventType eventType, String str, String str2, Map<String, String> map) {
        return l(eventType, str, str2, map);
    }

    public boolean i(String str, String str2, Boolean bool, Map<String, String> map) {
        AMConifg aMConifg = this.a.get(EventType.ALARM);
        if (aMConifg == null || !(aMConifg instanceof AlarmConfig)) {
            return false;
        }
        return ((AlarmConfig) aMConifg).isSampled(this.b, str, str2, bool, map);
    }

    public boolean j(String str, String str2) {
        AMConifg aMConifg = this.a.get(EventType.STAT);
        if (aMConifg == null) {
            return false;
        }
        return ((StatConfig) aMConifg).isDetail(str, str2);
    }

    public boolean k(EventType eventType, String str, String str2) {
        if (m(eventType, str, str2)) {
            return true;
        }
        AMConifg aMConifg = this.a.get(eventType);
        if (aMConifg != null) {
            return aMConifg.isOffline(str, str2);
        }
        return false;
    }

    public boolean l(EventType eventType, String str, String str2, Map<String, String> map) {
        AMConifg aMConifg = this.a.get(eventType);
        if (aMConifg != null) {
            return aMConifg.isSampled(this.b, str, str2, map);
        }
        Logger.f("eventTypeSample  ==null", new Object[0]);
        return false;
    }

    public void o(EventType eventType, int i) {
        AMConifg aMConifg = this.a.get(eventType);
        if (aMConifg != null) {
            aMConifg.setSampling(i);
        }
        Logger.f("setSampling end", new Object[0]);
    }

    public void p() {
        this.b = new Random().nextInt(10000);
    }
}
