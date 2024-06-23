package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bk;
import com.xiaomi.push.eu;

/* compiled from: Taobao */
public class XMJobService extends Service {
    static Service a;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f830a = null;

    @TargetApi(21)
    /* compiled from: Taobao */
    static class a extends JobService {
        Binder a;

        /* renamed from: a  reason: collision with other field name */
        private Handler f831a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        private static class HandlerC0253a extends Handler {
            JobService a;

            HandlerC0253a(JobService jobService) {
                super(jobService.getMainLooper());
                this.a = jobService;
            }

            public void handleMessage(Message message) {
                if (message.what == 1) {
                    JobParameters jobParameters = (JobParameters) message.obj;
                    b.m182a("Job finished " + jobParameters.getJobId());
                    this.a.jobFinished(jobParameters, false);
                    if (jobParameters.getJobId() == 1) {
                        eu.a(false);
                    }
                }
            }
        }

        a(Service service) {
            this.a = null;
            this.a = (Binder) bk.a((Object) this, "onBind", new Intent());
            bk.a((Object) this, "attachBaseContext", service);
        }

        public boolean onStartJob(JobParameters jobParameters) {
            b.m182a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f831a == null) {
                this.f831a = new HandlerC0253a(this);
            }
            Handler handler = this.f831a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            b.m182a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f830a;
        return iBinder != null ? iBinder : new Binder();
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f830a = new a(this).a;
        }
        a = this;
    }

    public void onDestroy() {
        super.onDestroy();
        a = null;
    }
}
