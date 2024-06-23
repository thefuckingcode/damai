package com.meizu.cloud.pushsdk.b.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.meizu.cloud.pushinternal.DebugLogger;

/* compiled from: Taobao */
public class a {
    private AlarmManager a;
    private Context b;
    private Runnable c;
    private long d;
    private int e;
    private C0183a f;
    private PendingIntent g;
    private String h;
    private boolean i;

    /* access modifiers changed from: private */
    /* renamed from: com.meizu.cloud.pushsdk.b.a.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0183a extends BroadcastReceiver {
        private C0183a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equals("alarm.util")) {
                DebugLogger.i("AlarmUtils", "on receive delayed task, keyword: " + a.this.h);
                a.this.i = true;
                a.this.c();
                a.this.c.run();
            }
        }
    }

    public a(Context context, Runnable runnable, long j) {
        this(context, runnable, j, true);
    }

    public a(Context context, Runnable runnable, long j, boolean z) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = runnable;
        this.d = j;
        this.e = !z ? 1 : 0;
        this.a = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.i = true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        try {
            C0183a aVar = this.f;
            if (aVar != null) {
                this.b.unregisterReceiver(aVar);
                this.f = null;
            }
        } catch (Exception e2) {
            DebugLogger.e("AlarmUtils", "clean error, " + e2.getMessage());
        }
    }

    public boolean a() {
        if (!this.i) {
            DebugLogger.e("AlarmUtils", "last task not completed");
            return false;
        }
        this.i = false;
        C0183a aVar = new C0183a();
        this.f = aVar;
        this.b.registerReceiver(aVar, new IntentFilter("alarm.util"));
        this.h = String.valueOf(System.currentTimeMillis());
        this.g = PendingIntent.getBroadcast(this.b, 0, new Intent("alarm.util"), 1073741824);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            this.a.setExactAndAllowWhileIdle(this.e, System.currentTimeMillis() + this.d, this.g);
        } else if (i2 >= 19) {
            this.a.setExact(this.e, System.currentTimeMillis() + this.d, this.g);
        } else {
            this.a.set(this.e, System.currentTimeMillis() + this.d, this.g);
        }
        DebugLogger.i("AlarmUtils", "start delayed task, keyword: " + this.h);
        return true;
    }

    public void b() {
        if (!(this.a == null || this.g == null || this.i)) {
            DebugLogger.i("AlarmUtils", "cancel  delayed task, keyword: " + this.h);
            this.a.cancel(this.g);
        }
        c();
    }
}
