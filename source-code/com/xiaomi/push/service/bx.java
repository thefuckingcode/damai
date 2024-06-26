package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.ai;
import com.xiaomi.push.al;
import com.xiaomi.push.bj;
import com.xiaomi.push.t;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public final class bx implements ar {
    private static volatile bx a;

    /* renamed from: a  reason: collision with other field name */
    private long f947a;

    /* renamed from: a  reason: collision with other field name */
    Context f948a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f949a;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, a> f950a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f951a = false;

    /* compiled from: Taobao */
    public static abstract class a implements Runnable {
        long a;

        /* renamed from: a  reason: collision with other field name */
        String f952a;

        a(String str, long j) {
            this.f952a = str;
            this.a = j;
        }

        /* access modifiers changed from: package-private */
        public abstract void a(bx bxVar);

        public void run() {
            if (bx.a != null) {
                Context context = bx.a.f948a;
                if (bj.d(context)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences sharedPreferences = bx.a.f949a;
                    if (currentTimeMillis - sharedPreferences.getLong(":ts-" + this.f952a, 0) > this.a || ai.a(context)) {
                        SharedPreferences.Editor edit = bx.a.f949a.edit();
                        t.a(edit.putLong(":ts-" + this.f952a, System.currentTimeMillis()));
                        a(bx.a);
                    }
                }
            }
        }
    }

    private bx(Context context) {
        this.f948a = context.getApplicationContext();
        this.f949a = context.getSharedPreferences("sync", 0);
    }

    public static bx a(Context context) {
        if (a == null) {
            synchronized (bx.class) {
                if (a == null) {
                    a = new bx(context);
                }
            }
        }
        return a;
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f949a;
        return sharedPreferences.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.ar
    public void a() {
        if (!this.f951a) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f947a >= DateUtils.MILLIS_PER_HOUR) {
                this.f947a = currentTimeMillis;
                this.f951a = true;
                al.a(this.f948a).a(new by(this), (int) (Math.random() * 10.0d));
            }
        }
    }

    public void a(a aVar) {
        if (this.f950a.putIfAbsent(aVar.f952a, aVar) == null) {
            al.a(this.f948a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = a.f949a.edit();
        t.a(edit.putString(str + ":" + str2, str3));
    }
}
