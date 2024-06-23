package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.eu;
import com.xiaomi.push.service.XMJobService;

@TargetApi(21)
/* compiled from: Taobao */
public class ew implements eu.a {
    JobScheduler a;

    /* renamed from: a  reason: collision with other field name */
    Context f322a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f323a = false;

    ew(Context context) {
        this.f322a = context;
        this.a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.xiaomi.push.eu.a, com.xiaomi.push.eu.a
    public void a() {
        this.f323a = false;
        this.a.cancel(1);
    }

    /* access modifiers changed from: package-private */
    public void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f322a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        JobInfo build = builder.build();
        b.c("schedule Job = " + build.getId() + " in " + j);
        this.a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.eu.a
    public void a(boolean z) {
        if (z || this.f323a) {
            long b = (long) gc.b();
            if (z) {
                a();
                b -= SystemClock.elapsedRealtime() % b;
            }
            this.f323a = true;
            a(b);
        }
    }

    @Override // com.xiaomi.push.eu.a, com.xiaomi.push.eu.a
    /* renamed from: a  reason: collision with other method in class */
    public boolean m466a() {
        return this.f323a;
    }
}
