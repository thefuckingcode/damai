package com.alibaba.analytics.core.store;

import android.util.Log;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.analytics.utils.UTServerAppStatusTrigger;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import tb.gj2;
import tb.h82;
import tb.i82;
import tb.u81;

/* compiled from: Taobao */
public class LogStoreMgr implements UTServerAppStatusTrigger.UTServerAppStatusChangeCallback {
    private static LogStoreMgr f = new LogStoreMgr();
    public static i82 g = new i82();
    private static int h = 0;
    private static final Object i = new Object();
    private static final Object j = new Object();
    private ILogStore a = new a(Variables.n().j());
    private List<u81> b = new CopyOnWriteArrayList();
    private List<ILogChangeListener> c = Collections.synchronizedList(new ArrayList());
    private ScheduledFuture d = null;
    private Runnable e = new Runnable() {
        /* class com.alibaba.analytics.core.store.LogStoreMgr.AnonymousClass1 */

        public void run() {
            LogStoreMgr.this.n();
        }
    };

    /* compiled from: Taobao */
    class CleanDbTask implements Runnable {
        CleanDbTask() {
        }

        public void run() {
            int f;
            Logger.d();
            int g = LogStoreMgr.this.g();
            if (g > 0) {
                LogStoreMgr.g.onEvent(h82.a(h82.i, "time_ex", Double.valueOf((double) g)));
            }
            int count = LogStoreMgr.this.a.count();
            if (count > 9000 && (f = LogStoreMgr.this.f(count)) > 0) {
                LogStoreMgr.g.onEvent(h82.a(h82.i, "count_ex", Double.valueOf((double) f)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class CleanLogTask implements Runnable {
        CleanLogTask() {
        }

        public void run() {
            Logger.f("LogStoreMgr", "CleanLogTask");
            int count = LogStoreMgr.this.a.count();
            if (count > 9000) {
                LogStoreMgr.this.f(count);
            }
        }
    }

    private LogStoreMgr() {
        gj2.c().f(new CleanDbTask());
        UTServerAppStatusTrigger.d(this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int f(int i2) {
        int i3;
        if (i2 > 9000) {
            i3 = this.a.clearOldLogByCount((i2 - 9000) + 1000);
        } else {
            i3 = 0;
        }
        Logger.f("LogStoreMgr", "clearOldLogByCount", Integer.valueOf(i3));
        return i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int g() {
        Logger.d();
        Calendar instance = Calendar.getInstance();
        instance.add(5, -3);
        return this.a.clearOldLogByField("time", String.valueOf(instance.getTimeInMillis()));
    }

    private void j(int i2, int i3) {
        for (int i4 = 0; i4 < this.c.size(); i4++) {
            ILogChangeListener iLogChangeListener = this.c.get(i4);
            if (iLogChangeListener != null) {
                if (i2 == 1) {
                    iLogChangeListener.onInsert((long) i3, h());
                } else if (i2 == 2) {
                    iLogChangeListener.onDelete((long) i3, h());
                }
            }
        }
    }

    public static LogStoreMgr l() {
        return f;
    }

    public void d(u81 u81) {
        int size;
        if (Logger.n()) {
            Logger.m("LogStoreMgr", "Log", u81.b());
        }
        synchronized (j) {
            this.b.add(u81);
            size = this.b.size();
        }
        if (size >= 45 || Variables.n().M()) {
            this.d = gj2.c().d(null, this.e, 0);
        } else {
            ScheduledFuture scheduledFuture = this.d;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                this.d = gj2.c().d(this.d, this.e, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
            }
        }
        synchronized (i) {
            int i2 = h + 1;
            h = i2;
            if (i2 > 5000) {
                h = 0;
                gj2.c().f(new CleanLogTask());
            }
        }
    }

    public void e(u81 u81) {
        d(u81);
        n();
    }

    public long h() {
        return (long) this.a.count();
    }

    public int i(List<u81> list) {
        return this.a.delete(list);
    }

    public List<u81> k(int i2) {
        return this.a.get(i2);
    }

    public void m(ILogChangeListener iLogChangeListener) {
        this.c.add(iLogChangeListener);
    }

    public void n() {
        ArrayList arrayList = null;
        try {
            synchronized (j) {
                if (this.b.size() > 0) {
                    arrayList = new ArrayList(this.b);
                    this.b.clear();
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                this.a.insert(arrayList);
                j(1, arrayList.size());
            }
        } catch (Throwable th) {
            Log.w("LogStoreMgr", "", th);
        }
    }

    public void o(ILogChangeListener iLogChangeListener) {
        this.c.remove(iLogChangeListener);
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onBackground() {
        Logger.f("LogStoreMgr", "onBackground", Boolean.TRUE);
        this.d = gj2.c().d(null, this.e, 0);
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onForeground() {
    }

    public void p(List<u81> list) {
        this.a.updateLogPriority(list);
    }
}
