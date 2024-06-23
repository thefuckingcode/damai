package com.alibaba.appmonitor.offline;

import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.core.selfmonitor.CrashListener;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.analytics.utils.UTServerAppStatusTrigger;
import com.alibaba.appmonitor.event.EventRepo;
import com.alibaba.appmonitor.event.EventType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import tb.gj2;
import tb.mj2;
import tb.nj2;
import tb.oj2;
import tb.pj2;
import tb.qd1;
import tb.tp;
import tb.wo;
import tb.xd0;

/* compiled from: Taobao */
public class TempEventMgr implements SystemConfigMgr.IKVChangeListener, CrashListener, UTServerAppStatusTrigger.UTServerAppStatusChangeCallback {
    private static TempEventMgr j = new TempEventMgr();
    private List<oj2> a = Collections.synchronizedList(new ArrayList());
    private List<oj2> b = Collections.synchronizedList(new ArrayList());
    private List<oj2> c = Collections.synchronizedList(new ArrayList());
    private List<qd1> d = Collections.synchronizedList(new ArrayList());
    private long e = -2;
    private ScheduledFuture f = null;
    private ScheduledFuture g = null;
    private Runnable h = new Runnable() {
        /* class com.alibaba.appmonitor.offline.TempEventMgr.AnonymousClass1 */

        public void run() {
            TempEventMgr.this.w();
        }
    };
    private Runnable i = new Runnable() {
        /* class com.alibaba.appmonitor.offline.TempEventMgr.AnonymousClass2 */

        public void run() {
            TempEventMgr.this.o();
        }
    };

    /* compiled from: Taobao */
    private class CleanTableTask implements Runnable {
        private CleanTableTask() {
        }

        public void run() {
            TempEventMgr.this.l();
            TempEventMgr.this.m();
            TempEventMgr.this.n();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[EventType.values().length];
            a = iArr;
            iArr[EventType.ALARM.ordinal()] = 1;
            a[EventType.COUNTER.ordinal()] = 2;
            try {
                a[EventType.STAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private TempEventMgr() {
        UTServerAppStatusTrigger.d(this);
        wo.b().a(this);
        SystemConfigMgr.i().l("offline_duration", this);
        gj2.c().f(new CleanTableTask());
        v();
    }

    private void g(List<?> list) {
        ArrayList arrayList;
        if (list != null && list.size() > 0) {
            synchronized (list) {
                arrayList = new ArrayList(list);
                list.clear();
            }
            Variables.n().k().q(arrayList);
        }
    }

    private void h(List<qd1> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            synchronized (list) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    qd1 qd1 = list.get(i2);
                    qd1 u = u(qd1.getModule(), qd1.c());
                    if (u != null) {
                        qd1._id = u._id;
                        arrayList.add(qd1);
                    } else {
                        arrayList2.add(qd1);
                    }
                }
                list.clear();
            }
            if (arrayList.size() > 0) {
                Variables.n().k().s(arrayList);
            }
            if (arrayList2.size() > 0) {
                Variables.n().k().q(arrayList2);
            }
        }
    }

    private void i(Class<? extends xd0> cls) {
        k(cls);
        if (Variables.n().k().d(cls) > 50000) {
            j(cls, 10000);
        }
    }

    private long j(Class<? extends xd0> cls, int i2) {
        String p = Variables.n().k().p(cls);
        tp k = Variables.n().k();
        return (long) k.f(cls, " _id in ( select _id from " + p + "  ORDER BY  _id ASC LIMIT " + i2 + " )", null);
    }

    private int k(Class<? extends xd0> cls) {
        Calendar instance = Calendar.getInstance();
        instance.add(5, -7);
        tp k = Variables.n().k();
        return k.f(cls, "commit_time< " + (instance.getTimeInMillis() / 1000), null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l() {
        i(mj2.class);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m() {
        i(nj2.class);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n() {
        i(pj2.class);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o() {
        Logger.d();
        EventType[] values = EventType.values();
        char c2 = 0;
        for (EventType eventType : values) {
            while (true) {
                List<? extends oj2> s = s(eventType, 500);
                Object[] objArr = new Object[4];
                objArr[c2] = "type";
                int i2 = 1;
                objArr[1] = eventType;
                int i3 = 2;
                objArr[2] = "events.size()";
                int i4 = 3;
                objArr[3] = Integer.valueOf(s.size());
                Logger.f(null, objArr);
                if (s.size() == 0) {
                    break;
                }
                int i5 = 0;
                while (i5 < s.size()) {
                    int i6 = a.a[eventType.ordinal()];
                    if (i6 == i2) {
                        mj2 mj2 = (mj2) s.get(i5);
                        if (mj2.a()) {
                            EventRepo.s().d(eventType.getEventId(), mj2.a, mj2.b, mj2.h, Long.valueOf(mj2.c), mj2.d, mj2.e);
                        } else {
                            EventRepo.s().b(eventType.getEventId(), mj2.a, mj2.b, mj2.h, mj2.f, mj2.g, Long.valueOf(mj2.c), mj2.d, mj2.e);
                        }
                    } else if (i6 == i3) {
                        nj2 nj2 = (nj2) s.get(i5);
                        EventRepo.s().m(eventType.getEventId(), nj2.a, nj2.b, nj2.f, nj2.g, Long.valueOf(nj2.c), nj2.d, nj2.e);
                    } else if (i6 == i4) {
                        pj2 pj2 = (pj2) s.get(i5);
                        EventRepo.s().j(eventType.getEventId(), pj2.a, pj2.b, pj2.b(), pj2.a());
                    }
                    i5++;
                    i2 = 1;
                    i3 = 2;
                    i4 = 3;
                }
                p(s);
                c2 = 0;
            }
        }
    }

    private void p(List<? extends oj2> list) {
        Variables.n().k().g(list);
    }

    private Class<? extends xd0> q(EventType eventType) {
        if (EventType.ALARM == eventType) {
            return mj2.class;
        }
        if (EventType.COUNTER == eventType) {
            return nj2.class;
        }
        if (EventType.STAT == eventType) {
            return pj2.class;
        }
        return oj2.class;
    }

    private long r() {
        int j2 = SystemConfigMgr.i().j("offline_duration");
        return (long) (j2 <= 0 ? 21600000 : j2 <= 3600 ? 3600000 : j2 * 1000);
    }

    public static TempEventMgr t() {
        return j;
    }

    private void v() {
        long r = r();
        if (this.e != r) {
            this.e = r;
            this.g = gj2.c().e(this.g, this.i, this.e);
        }
    }

    public void e(EventType eventType, oj2 oj2) {
        if (EventType.ALARM == eventType) {
            this.a.add(oj2);
        } else if (EventType.COUNTER == eventType) {
            this.b.add(oj2);
        } else if (EventType.STAT == eventType) {
            this.c.add(oj2);
        }
        if (this.a.size() >= 100 || this.b.size() >= 100 || this.c.size() >= 100) {
            this.f = gj2.c().d(null, this.h, 0);
            return;
        }
        ScheduledFuture scheduledFuture = this.f;
        if (scheduledFuture == null || (scheduledFuture != null && scheduledFuture.isDone())) {
            this.f = gj2.c().d(this.f, this.h, 30000);
        }
    }

    public void f(qd1 qd1) {
        if (qd1 != null) {
            this.d.add(qd1);
        }
        if (this.d.size() >= 100) {
            this.f = gj2.c().d(null, this.h, 0);
        } else {
            this.f = gj2.c().d(this.f, this.h, 30000);
        }
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onBackground() {
        Logger.f("TempEventMgr", "onBackground", Boolean.TRUE);
        this.f = gj2.c().d(null, this.h, 0);
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        if ("offline_duration".equalsIgnoreCase(str)) {
            v();
        }
    }

    @Override // com.alibaba.analytics.core.selfmonitor.CrashListener
    public void onCrash(Thread thread, Throwable th) {
        Logger.d();
        w();
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onForeground() {
    }

    /* JADX DEBUG: Type inference failed for r7v2. Raw type applied. Possible types: java.util.List<? extends tb.xd0>, java.util.List<? extends tb.oj2> */
    public List<? extends oj2> s(EventType eventType, int i2) {
        tp k = Variables.n().k();
        Class<? extends xd0> q = q(eventType);
        return k.i(q, "commit_time<" + ((System.currentTimeMillis() / 1000) - (r() / 1000)), "access,sub_access,module,monitor_point", i2);
    }

    public qd1 u(String str, String str2) {
        tp k = Variables.n().k();
        List<? extends xd0> i2 = k.i(qd1.class, "module=\"" + str + "\" and " + "monitor_point=\"" + str2 + "\"", null, 1);
        if (i2 == null || i2.size() <= 0) {
            return null;
        }
        return (qd1) i2.get(0);
    }

    public void w() {
        Logger.d();
        g(this.a);
        g(this.b);
        g(this.c);
        h(this.d);
    }
}
