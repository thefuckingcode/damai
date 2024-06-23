package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.eu;
import com.xiaomi.push.service.bk;
import com.xiaomi.push.service.o;

/* compiled from: Taobao */
class ev implements eu.a {
    private volatile long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private PendingIntent f320a = null;

    /* renamed from: a  reason: collision with other field name */
    protected Context f321a = null;

    public ev(Context context) {
        this.f321a = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            b.d("[Alarm] invoke setExact method meet error. " + e);
        }
    }

    @Override // com.xiaomi.push.eu.a, com.xiaomi.push.eu.a
    public void a() {
        if (this.f320a != null) {
            try {
                ((AlarmManager) this.f321a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f320a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f320a = null;
                b.c("[Alarm] unregister timer");
                this.a = 0;
                throw th;
            }
            this.f320a = null;
            b.c("[Alarm] unregister timer");
            this.a = 0;
        }
        this.a = 0;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f321a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        int i = Build.VERSION.SDK_INT;
        this.f320a = i >= 31 ? PendingIntent.getBroadcast(this.f321a, 0, intent, 33554432) : PendingIntent.getBroadcast(this.f321a, 0, intent, 0);
        if (i >= 23) {
            bk.a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j), this.f320a);
        } else {
            a(alarmManager, j, this.f320a);
        }
        b.c("[Alarm] register timer " + j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r8.a < r4) goto L_0x003c;
     */
    @Override // com.xiaomi.push.eu.a
    public void a(boolean z) {
        long a2 = o.a(this.f321a).m853a();
        if (z || this.a != 0) {
            if (z) {
                a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (z || this.a == 0) {
                a2 -= elapsedRealtime % a2;
            } else {
                if (this.a <= elapsedRealtime) {
                    this.a += a2;
                }
                Intent intent = new Intent(bk.p);
                intent.setPackage(this.f321a.getPackageName());
                a(intent, this.a);
            }
            this.a = elapsedRealtime + a2;
            Intent intent2 = new Intent(bk.p);
            intent2.setPackage(this.f321a.getPackageName());
            a(intent2, this.a);
        }
    }

    @Override // com.xiaomi.push.eu.a, com.xiaomi.push.eu.a
    /* renamed from: a  reason: collision with other method in class */
    public boolean m465a() {
        return this.a != 0;
    }
}
