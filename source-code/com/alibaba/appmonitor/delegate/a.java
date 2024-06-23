package com.alibaba.appmonitor.delegate;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.analytics.core.selfmonitor.exception.AppMonitorException;
import com.alibaba.analytics.core.selfmonitor.exception.ExceptionEventBuilder;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.event.EventRepo;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.appmonitor.offline.TempEventMgr;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecurityThridRequestAuthentication;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.l9;
import tb.mj2;
import tb.nj2;
import tb.pj2;
import tb.qd1;
import tb.rd1;
import tb.zf2;

/* compiled from: Taobao */
public final class a {
    public static boolean a;
    private static Application b;
    static volatile boolean c;
    private static Map<String, String> d = new ConcurrentHashMap();

    /* renamed from: com.alibaba.appmonitor.delegate.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0080a {
        @Deprecated
        public static boolean a(String str, String str2) {
            return com.alibaba.appmonitor.sample.a.h().e(str, str2, Boolean.TRUE, null);
        }

        public static void b(String str, String str2, String str3, String str4) {
            c(str, str2, null, str3, str4);
        }

        public static void c(String str, String str2, String str3, String str4, String str5) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("_status", "0");
                        if (a.c && Variables.L()) {
                            EventType eventType = EventType.ALARM;
                            if (eventType.isOpen() && (a.e() || com.alibaba.appmonitor.sample.a.h().e(str, str2, Boolean.FALSE, hashMap))) {
                                Logger.f("commitFail ", "module", str, "monitorPoint", str2, "errorCode:", str4, "errorMsg:", str5);
                                if (com.alibaba.appmonitor.sample.a.h().k(eventType, str, str2)) {
                                    Context j = Variables.n().j();
                                    TempEventMgr.t().e(eventType, new mj2(str, str2, str3, str4, str5, false, NetworkUtil.c(j), NetworkUtil.d(j)));
                                    return;
                                }
                                EventRepo.s().a(eventType.getEventId(), str, str2, str3, str4, str5);
                                return;
                            }
                        }
                        Logger.r("log discard !", "module", str, "monitorPoint", str2, "errorCode:", str4, "errorMsg:", str5);
                        return;
                    }
                }
                Logger.v("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        public static void d(String str, String str2) {
            e(str, str2, null);
        }

        public static void e(String str, String str2, String str3) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        if (a.c && Variables.L()) {
                            EventType eventType = EventType.ALARM;
                            if (eventType.isOpen() && (a.e() || com.alibaba.appmonitor.sample.a.h().e(str, str2, Boolean.TRUE, null))) {
                                Logger.f("commitSuccess", "module", str, "monitorPoint", str2, "arg", str3);
                                if (com.alibaba.appmonitor.sample.a.h().k(eventType, str, str2)) {
                                    Context j = Variables.n().j();
                                    TempEventMgr.t().e(eventType, new mj2(str, str2, str3, null, null, true, NetworkUtil.c(j), NetworkUtil.d(j)));
                                    return;
                                }
                                EventRepo.s().c(eventType.getEventId(), str, str2, str3);
                                return;
                            }
                        }
                        Logger.r("log discard !", "module", str, "monitorPoint", str2, "arg", str3);
                        return;
                    }
                }
                Logger.v("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        public static void f(int i) {
            com.alibaba.appmonitor.sample.a.h().o(EventType.ALARM, i);
        }

        public static void g(int i) {
            EventType eventType = EventType.ALARM;
            eventType.setStatisticsInterval(i);
            a.o(eventType, i);
        }
    }

    /* compiled from: Taobao */
    public static class b {
        @Deprecated
        public static boolean a(String str, String str2) {
            return com.alibaba.appmonitor.sample.a.h().f(EventType.COUNTER, str, str2);
        }

        public static void b(String str, String str2, double d) {
            c(str, str2, null, d);
        }

        public static void c(String str, String str2, String str3, double d) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        if (a.c && Variables.L()) {
                            EventType eventType = EventType.COUNTER;
                            if (eventType.isOpen() && (a.e() || com.alibaba.appmonitor.sample.a.h().f(eventType, str, str2))) {
                                Logger.f("commitCount", "module", str, "monitorPoint", str2, "args", str3, "value", Double.valueOf(d));
                                if (com.alibaba.appmonitor.sample.a.h().k(eventType, str, str2)) {
                                    Context j = Variables.n().j();
                                    TempEventMgr.t().e(eventType, new nj2(str, str2, str3, d, NetworkUtil.c(j), NetworkUtil.d(j)));
                                    return;
                                }
                                EventRepo.s().l(eventType.getEventId(), str, str2, str3, d);
                                return;
                            }
                        }
                        Logger.r("log discard !", "module", str, "monitorPoint", str2, "args", str3, "value", Double.valueOf(d));
                        return;
                    }
                }
                Logger.v("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        public static void d(int i) {
            com.alibaba.appmonitor.sample.a.h().o(EventType.COUNTER, i);
        }

        public static void e(int i) {
            EventType eventType = EventType.COUNTER;
            eventType.setStatisticsInterval(i);
            a.o(eventType, i);
        }
    }

    /* compiled from: Taobao */
    public static class c {
        @Deprecated
        public static boolean a(String str, String str2) {
            return com.alibaba.appmonitor.sample.a.h().f(EventType.COUNTER, str, str2);
        }

        public static void b(String str, String str2, double d) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        if (a.c && Variables.L()) {
                            EventType eventType = EventType.COUNTER;
                            if (eventType.isOpen() && (a.e() || com.alibaba.appmonitor.sample.a.h().f(eventType, str, str2))) {
                                Logger.f("commitOffLineCount", "module", str, "monitorPoint", str2, "value", Double.valueOf(d));
                                EventRepo.s().l(eventType.getEventId(), str, str2, null, d);
                                return;
                            }
                        }
                        Logger.r("log discard !", "module", str, "monitorPoint", str2);
                        return;
                    }
                }
                Logger.v("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        public static void c(int i) {
            com.alibaba.appmonitor.sample.a.h().o(EventType.COUNTER, i);
        }

        public static void d(int i) {
            EventType eventType = EventType.COUNTER;
            eventType.setStatisticsInterval(i);
            a.o(eventType, i);
        }
    }

    /* compiled from: Taobao */
    public static class d {
        public static void a(String str, String str2, String str3) {
            try {
                if (a.c && Variables.L()) {
                    EventType eventType = EventType.STAT;
                    if (eventType.isOpen() && (a.e() || com.alibaba.appmonitor.sample.a.h().f(eventType, str, str2))) {
                        Logger.f("AppMonitorDelegate", "statEvent begin. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                        EventRepo.s().e(Integer.valueOf(eventType.getEventId()), str, str2, str3);
                        return;
                    }
                }
                Logger.r("log discard !", "module", str, "monitorPoint", str2);
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        @Deprecated
        public static boolean b(String str, String str2) {
            return com.alibaba.appmonitor.sample.a.h().f(EventType.STAT, str, str2);
        }

        public static void c(String str, String str2, double d) {
            d(str, str2, null, d);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
            if (com.alibaba.appmonitor.sample.a.h().g(r0, r8, r9, r10 != null ? r10.getMap() : null) != false) goto L_0x002f;
         */
        public static void d(String str, String str2, DimensionValueSet dimensionValueSet, double d) {
            try {
                if (a.c && Variables.L()) {
                    EventType eventType = EventType.STAT;
                    if (eventType.isOpen()) {
                        if (!a.e()) {
                        }
                        Logger.f("AppMonitorDelegate", "statEvent commit. module: ", str, " monitorPoint: ", str2);
                        qd1 b = rd1.c().b(str, str2);
                        if (b != null) {
                            List<Measure> measures = b.b().getMeasures();
                            if (measures.size() == 1) {
                                e(str, str2, dimensionValueSet, ((MeasureValueSet) com.alibaba.appmonitor.pool.a.a().poll(MeasureValueSet.class, new Object[0])).setValue(measures.get(0).getName(), d));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                Logger.r("log discard !", "module", str, "monitorPoint", str2);
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
            if (com.alibaba.appmonitor.sample.a.h().g(r0, r11, r12, r13 != null ? r13.getMap() : null) != false) goto L_0x0033;
         */
        public static void e(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
            try {
                if (a.c && Variables.L()) {
                    EventType eventType = EventType.STAT;
                    if (eventType.isOpen()) {
                        if (!a.e()) {
                        }
                        Logger.f("statEvent commit", "module", str, "monitorPoint", str2);
                        if (com.alibaba.appmonitor.sample.a.h().k(eventType, str, str2)) {
                            Context j = Variables.n().j();
                            TempEventMgr.t().e(eventType, new pj2(str, str2, dimensionValueSet, measureValueSet, NetworkUtil.c(j), NetworkUtil.d(j)));
                            return;
                        }
                        EventRepo.s().j(eventType.getEventId(), str, str2, measureValueSet, dimensionValueSet);
                        return;
                    }
                }
                Logger.r("log discard !", "module", str, "monitorPoint", str2);
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        public static void f(String str, String str2, String str3) {
            try {
                if (a.c && Variables.L()) {
                    EventType eventType = EventType.STAT;
                    if (eventType.isOpen() && (a.e() || com.alibaba.appmonitor.sample.a.h().f(eventType, str, str2))) {
                        Logger.f("statEvent end. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                        EventRepo.s().n(str, str2, str3);
                        return;
                    }
                }
                Logger.r("log discard !", " module ", str, "monitorPoint", str2, " measureName", str3);
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        public static void g(int i) {
            com.alibaba.appmonitor.sample.a.h().o(EventType.STAT, i);
        }

        public static void h(int i) {
            EventType eventType = EventType.STAT;
            eventType.setStatisticsInterval(i);
            a.o(eventType, i);
        }
    }

    public static synchronized void a() {
        synchronized (a.class) {
            try {
                Logger.f("AppMonitorDelegate", "start destory");
                if (c) {
                    CommitTask.uploadAllEvent();
                    CommitTask.destroy();
                    CleanTask.destroy();
                    Application application = b;
                    if (application != null) {
                        NetworkUtil.s(application.getApplicationContext());
                    }
                    c = false;
                }
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }
        return;
    }

    public static void b(boolean z) {
        Logger.f("AppMonitorDelegate", "[enableLog]");
        Logger.s(z);
    }

    public static Map<String, String> c() {
        return d;
    }

    public static synchronized void d(Application application) {
        synchronized (a.class) {
            Logger.f("AppMonitorDelegate", "start init");
            try {
                if (!c) {
                    b = application;
                    CleanTask.init();
                    CommitTask.init();
                    l9.a();
                    c = true;
                }
            } catch (Throwable unused) {
                a();
            }
        }
    }

    public static boolean e() {
        if (com.alibaba.analytics.core.config.b.a()) {
            return false;
        }
        return a;
    }

    public static void f(String str, String str2, MeasureSet measureSet) {
        g(str, str2, measureSet, null);
    }

    public static void g(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) {
        h(str, str2, measureSet, dimensionSet, false);
    }

    public static void h(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        try {
            if (c) {
                if (!zf2.e(str)) {
                    if (!zf2.e(str2)) {
                        qd1 qd1 = new qd1(str, str2, measureSet, dimensionSet, z);
                        rd1.c().a(qd1);
                        TempEventMgr.t().f(qd1);
                        return;
                    }
                }
                Logger.f("AppMonitorDelegate", "register stat event. module: ", str, " monitorPoint: ", str2);
                if (e()) {
                    throw new AppMonitorException("register error. module and monitorPoint can't be null");
                }
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
        }
    }

    public static void i(String str, String str2, MeasureSet measureSet, boolean z) {
        h(str, str2, measureSet, null, z);
    }

    public static void j(String str) {
        d.remove(str);
    }

    public static void k(String str, String str2) {
        if (!zf2.f(str) && str2 != null) {
            d.put(str, str2);
        }
    }

    public static void l(boolean z, boolean z2, String str, String str2) {
        IUTRequestAuthentication iUTRequestAuthentication;
        if (z) {
            iUTRequestAuthentication = new UTSecurityThridRequestAuthentication(str, str2);
        } else {
            iUTRequestAuthentication = new UTBaseRequestAuthentication(str, str2, z2);
        }
        Variables.n().c0(iUTRequestAuthentication);
    }

    public static void m(int i) {
        Logger.f("AppMonitorDelegate", "[setSampling]");
        EventType[] values = EventType.values();
        for (EventType eventType : values) {
            eventType.setDefaultSampling(i);
            com.alibaba.appmonitor.sample.a.h().o(eventType, i);
        }
    }

    public static void n(int i) {
        EventType[] values = EventType.values();
        for (EventType eventType : values) {
            eventType.setStatisticsInterval(i);
            o(eventType, i);
        }
    }

    public static void o(EventType eventType, int i) {
        try {
            if (c && eventType != null) {
                CommitTask.setStatisticsInterval(eventType.getEventId(), i);
                if (i > 0) {
                    eventType.setOpen(true);
                } else {
                    eventType.setOpen(false);
                }
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
        }
    }

    public static synchronized void p() {
        synchronized (a.class) {
            try {
                Logger.f("AppMonitorDelegate", "triggerUpload");
                if (c && Variables.L()) {
                    CommitTask.uploadAllEvent();
                }
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }
        return;
    }

    public static void q(String str, String str2, String str3, double d2, double d3, double d4) {
        Logger.f("AppMonitorDelegate", "[updateMeasure]");
        try {
            if (c && !zf2.e(str)) {
                if (!zf2.e(str2)) {
                    qd1 b2 = rd1.c().b(str, str2);
                    if (b2 != null && b2.b() != null) {
                        b2.b().upateMeasure(new Measure(str3, Double.valueOf(d4), Double.valueOf(d2), Double.valueOf(d3)));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
