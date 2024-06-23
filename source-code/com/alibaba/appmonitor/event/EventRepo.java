package com.alibaba.appmonitor.event;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.model.UTDimensionValueSet;
import com.alibaba.appmonitor.pool.a;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tb.cr2;
import tb.d4;
import tb.fe2;
import tb.gj2;
import tb.hc0;
import tb.qd1;
import tb.rd1;
import tb.sd1;
import tb.se0;
import tb.zf2;
import tb.zn;

/* compiled from: Taobao */
public class EventRepo {
    private static EventRepo g;
    private Map<String, hc0> a = new ConcurrentHashMap();
    private Map<UTDimensionValueSet, sd1> b = new ConcurrentHashMap();
    private AtomicInteger c = new AtomicInteger(0);
    private AtomicInteger d = new AtomicInteger(0);
    private AtomicInteger e = new AtomicInteger(0);
    private SimpleDateFormat f = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT);

    private EventRepo() {
    }

    private void g(EventType eventType, AtomicInteger atomicInteger) {
        if (atomicInteger.incrementAndGet() >= eventType.getTriggerCount()) {
            Logger.f("EventRepo", eventType.toString(), " event size exceed trigger count.");
            w(eventType.getEventId());
        }
    }

    private UTDimensionValueSet p(int i, Long l, String str, String str2) {
        UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) a.a().poll(UTDimensionValueSet.class, new Object[0]);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Context j = Variables.n().j();
            uTDimensionValueSet.setValue(LogField.ACCESS.toString(), NetworkUtil.c(j));
            uTDimensionValueSet.setValue(LogField.ACCESS_SUBTYPE.toString(), NetworkUtil.d(j));
        } else {
            uTDimensionValueSet.setValue(LogField.ACCESS.toString(), str);
            uTDimensionValueSet.setValue(LogField.ACCESS_SUBTYPE.toString(), str2);
        }
        uTDimensionValueSet.setValue(LogField.USERID.toString(), Variables.n().B());
        uTDimensionValueSet.setValue(LogField.USERNICK.toString(), Variables.n().C());
        uTDimensionValueSet.setValue(LogField.EVENTID.toString(), String.valueOf(i));
        if (l == null) {
            l = Long.valueOf(System.currentTimeMillis() / 1000);
        }
        uTDimensionValueSet.setValue("commitDay", this.f.format(new Date(l.longValue() * 1000)));
        return uTDimensionValueSet;
    }

    private AtomicInteger q(int i) {
        if (65501 == i) {
            return this.c;
        }
        if (65502 == i) {
            return this.d;
        }
        if (65503 == i) {
            return this.e;
        }
        return null;
    }

    private se0 r(UTDimensionValueSet uTDimensionValueSet, String str, String str2, String str3, Class<? extends se0> cls) {
        Integer eventId;
        sd1 sd1;
        if (!zf2.g(str) || !zf2.g(str2) || (eventId = uTDimensionValueSet.getEventId()) == null) {
            return null;
        }
        synchronized (this.b) {
            sd1 = this.b.get(uTDimensionValueSet);
            if (sd1 == null) {
                sd1 = (sd1) a.a().poll(sd1.class, new Object[0]);
                this.b.put(uTDimensionValueSet, sd1);
                Logger.f("EventRepo", "put in Map utDimensionValues", uTDimensionValueSet);
            }
        }
        return sd1.a(eventId, str, str2, str3, cls);
    }

    public static synchronized EventRepo s() {
        EventRepo eventRepo;
        synchronized (EventRepo.class) {
            if (g == null) {
                g = new EventRepo();
            }
            eventRepo = g;
        }
        return eventRepo;
    }

    private String t(String str, String str2) {
        qd1 b2 = rd1.c().b(str, str2);
        if (b2 != null) {
            return b2.d();
        }
        return null;
    }

    private void v(String str, String str2) {
        qd1 b2 = rd1.c().b(str, str2);
        if (b2 != null) {
            b2.f();
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        b(i, str, str2, str3, str4, str5, null, null, null);
    }

    public void b(int i, String str, String str2, String str3, String str4, String str5, Long l, String str6, String str7) {
        UTDimensionValueSet p = p(i, l, str6, str7);
        d4 d4Var = (d4) r(p, str, str2, str3, d4.class);
        if (d4Var != null) {
            d4Var.d(l);
            d4Var.c(str4, str5);
        }
        if (Variables.n().G()) {
            d4 d4Var2 = (d4) a.a().poll(d4.class, Integer.valueOf(i), str, str2, str3);
            d4Var2.d(l);
            d4Var2.c(str4, str5);
            cr2.b(p, d4Var2);
        }
        g(EventType.getEventType(i), this.c);
    }

    public void c(int i, String str, String str2, String str3) {
        d(i, str, str2, str3, null, null, null);
    }

    public void d(int i, String str, String str2, String str3, Long l, String str4, String str5) {
        UTDimensionValueSet p = p(i, l, str4, str5);
        d4 d4Var = (d4) r(p, str, str2, str3, d4.class);
        if (d4Var != null) {
            d4Var.e(l);
        }
        if (Variables.n().G()) {
            d4 d4Var2 = (d4) a.a().poll(d4.class, Integer.valueOf(i), str, str2, str3);
            d4Var2.e(l);
            cr2.b(p, d4Var2);
        }
        g(EventType.getEventType(i), this.c);
    }

    public void e(Integer num, String str, String str2, String str3) {
        String t = t(str, str2);
        if (t != null) {
            f(t, num, str, str2, str3);
        }
    }

    public void f(String str, Integer num, String str2, String str3, String str4) {
        hc0 hc0;
        qd1 b2 = rd1.c().b(str2, str3);
        if (b2 == null || b2.b() == null) {
            Logger.i("log discard!,metric is null,please call AppMonitor.register() once before Transaction.begin(measure)", new Object[0]);
        } else if (b2.b().getMeasure(str4) != null) {
            synchronized (hc0.class) {
                hc0 = this.a.get(str);
                if (hc0 == null) {
                    hc0 = (hc0) a.a().poll(hc0.class, num, str2, str3);
                    this.a.put(str, hc0);
                }
            }
            hc0.h(str4);
        }
    }

    public void h() {
        ArrayList arrayList = new ArrayList(this.a.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            hc0 hc0 = this.a.get(str);
            if (hc0 != null && hc0.g()) {
                this.a.remove(str);
            }
        }
    }

    public void i(String str, Integer num, String str2, String str3, DimensionValueSet dimensionValueSet) {
        hc0 hc0;
        synchronized (hc0.class) {
            hc0 = this.a.get(str);
            if (hc0 == null) {
                hc0 = (hc0) a.a().poll(hc0.class, num, str2, str3);
                this.a.put(str, hc0);
            }
        }
        hc0.c(dimensionValueSet);
    }

    public void j(int i, String str, String str2, MeasureValueSet measureValueSet, DimensionValueSet dimensionValueSet) {
        k(i, str, str2, measureValueSet, dimensionValueSet, null, null, null);
    }

    public void k(int i, String str, String str2, MeasureValueSet measureValueSet, DimensionValueSet dimensionValueSet, Long l, String str3, String str4) {
        qd1 b2 = rd1.c().b(str, str2);
        if (b2 != null) {
            if (b2.a() != null) {
                b2.a().setConstantValue(dimensionValueSet);
            }
            if (b2.b() != null) {
                b2.b().setConstantValue(measureValueSet);
            }
            UTDimensionValueSet p = p(i, l, str3, str4);
            fe2 fe2 = (fe2) r(p, str, str2, null, fe2.class);
            if (fe2 != null) {
                fe2.d(dimensionValueSet, measureValueSet);
            }
            if (Variables.n().G()) {
                fe2 fe22 = (fe2) a.a().poll(fe2.class, Integer.valueOf(i), str, str2);
                fe22.d(dimensionValueSet, measureValueSet);
                cr2.b(p, fe22);
            }
            g(EventType.getEventType(i), this.e);
            return;
        }
        Logger.i("metric is null,stat commit failed,please call AppMonitor.register() once before AppMonitor.STAT.commit()", new Object[0]);
    }

    public void l(int i, String str, String str2, String str3, double d2) {
        m(i, str, str2, str3, d2, null, null, null);
    }

    public void m(int i, String str, String str2, String str3, double d2, Long l, String str4, String str5) {
        UTDimensionValueSet p = p(i, l, str4, str5);
        zn znVar = (zn) r(p, str, str2, str3, zn.class);
        if (znVar != null) {
            znVar.c(d2, l);
        }
        if (Variables.n().G()) {
            zn znVar2 = (zn) a.a().poll(zn.class, Integer.valueOf(i), str, str2, str3);
            znVar2.c(d2, l);
            cr2.b(p, znVar2);
        }
        g(EventType.getEventType(i), this.d);
    }

    public void n(String str, String str2, String str3) {
        String t = t(str, str2);
        if (t != null) {
            o(t, str3, true);
        }
    }

    public void o(String str, String str2, boolean z) {
        hc0 hc0 = this.a.get(str);
        if (hc0 != null && hc0.d(str2)) {
            this.a.remove(str);
            if (z) {
                v(hc0.a, hc0.b);
            }
            j(hc0.d, hc0.a, hc0.b, hc0.f(), hc0.e());
            a.a().offer(hc0);
        }
    }

    public Map<UTDimensionValueSet, List<se0>> u(int i) {
        HashMap hashMap = new HashMap();
        synchronized (this.b) {
            Iterator<Map.Entry<UTDimensionValueSet, sd1>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<UTDimensionValueSet, sd1> next = it.next();
                UTDimensionValueSet key = next.getKey();
                sd1 value = next.getValue();
                if (key.getEventId().intValue() == i) {
                    if (value != null) {
                        hashMap.put(key, value.b());
                    } else {
                        Logger.f("error", "utDimensionValues", key);
                    }
                    it.remove();
                }
            }
        }
        q(i).set(0);
        return hashMap;
    }

    public void w(int i) {
        final Map<UTDimensionValueSet, List<se0>> u = u(i);
        gj2.c().f(new Runnable() {
            /* class com.alibaba.appmonitor.event.EventRepo.AnonymousClass1 */

            public void run() {
                cr2.d(u);
            }
        });
    }
}
