package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class al {
    private static volatile al a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f87a;

    /* renamed from: a  reason: collision with other field name */
    private Object f88a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private Map<String, ScheduledFuture> f89a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private ScheduledThreadPoolExecutor f90a = new ScheduledThreadPoolExecutor(1);

    /* compiled from: Taobao */
    public static abstract class a implements Runnable {
        public abstract String a();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b implements Runnable {
        a a;

        public b(a aVar) {
            this.a = aVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
        }

        /* access modifiers changed from: package-private */
        public void b() {
        }

        public void run() {
            a();
            this.a.run();
            b();
        }
    }

    private al(Context context) {
        this.f87a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static al a(Context context) {
        if (a == null) {
            synchronized (al.class) {
                if (a == null) {
                    a = new al(context);
                }
            }
        }
        return a;
    }

    private static String a(String str) {
        return "last_job_time" + str;
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f88a) {
            scheduledFuture = this.f89a.get(aVar.a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f90a.schedule(runnable, (long) i, TimeUnit.SECONDS);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m251a(a aVar) {
        return b(aVar, 0);
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        return a(aVar, i, i2, false);
    }

    public boolean a(a aVar, int i, int i2, boolean z) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        String a2 = a(aVar.a());
        am amVar = new am(this, aVar, z, a2);
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f87a.getLong(a2, 0)) / 1000;
            if (abs < ((long) (i - i2))) {
                i2 = (int) (((long) i) - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f90a.scheduleAtFixedRate(amVar, (long) i2, (long) i, TimeUnit.SECONDS);
            synchronized (this.f88a) {
                this.f89a.put(aVar.a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m252a(String str) {
        synchronized (this.f88a) {
            ScheduledFuture scheduledFuture = this.f89a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f89a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    public boolean b(a aVar, int i) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f90a.schedule(new an(this, aVar), (long) i, TimeUnit.SECONDS);
        synchronized (this.f88a) {
            this.f89a.put(aVar.a(), schedule);
        }
        return true;
    }
}
