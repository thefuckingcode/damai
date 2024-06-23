package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
public class fg implements fz {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f350a = 0;

    /* renamed from: a  reason: collision with other field name */
    fw f351a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f352a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f353a;

    /* renamed from: a  reason: collision with other field name */
    private String f354a;
    private long b = 0;
    private long c = 0;
    private long d = 0;
    private long e = 0;
    private long f = 0;

    fg(XMPushService xMPushService) {
        this.f352a = xMPushService;
        this.f354a = "";
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            b.m182a("Failed to obtain traffic data during initialization: " + e2);
            this.f = -1;
            this.e = -1;
        }
    }

    private void b() {
        this.b = 0;
        this.d = 0;
        this.f350a = 0;
        this.c = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (bj.b(this.f352a)) {
            this.f350a = elapsedRealtime;
        }
        if (this.f352a.m763c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        b.c("stat connpt = " + this.f354a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        fa faVar = new fa();
        faVar.f329a = 0;
        faVar.a(ez.CHANNEL_ONLINE_RATE.a());
        faVar.a(this.f354a);
        faVar.d((int) (System.currentTimeMillis() / 1000));
        faVar.b((int) (this.b / 1000));
        faVar.c((int) (this.d / 1000));
        fh.m474a().a(faVar);
        b();
    }

    /* access modifiers changed from: package-private */
    public Exception a() {
        return this.f353a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m473a() {
        XMPushService xMPushService = this.f352a;
        if (xMPushService != null) {
            String a2 = bj.m282a((Context) xMPushService);
            boolean c2 = bj.c(this.f352a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.f350a;
            if (j > 0) {
                this.b += elapsedRealtime - j;
                this.f350a = 0;
            }
            long j2 = this.c;
            if (j2 != 0) {
                this.d += elapsedRealtime - j2;
                this.c = 0;
            }
            if (c2) {
                if ((!TextUtils.equals(this.f354a, a2) && this.b > 30000) || this.b > 5400000) {
                    c();
                }
                this.f354a = a2;
                if (this.f350a == 0) {
                    this.f350a = elapsedRealtime;
                }
                if (this.f352a.m763c()) {
                    this.c = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar) {
        this.a = 0;
        this.f353a = null;
        this.f351a = fwVar;
        this.f354a = bj.m282a((Context) this.f352a);
        fj.a(0, ez.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, int i, Exception exc) {
        long j;
        if (this.a == 0 && this.f353a == null) {
            this.a = i;
            this.f353a = exc;
            fj.b(fwVar.m499a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long a2 = fwVar.m497a() - this.c;
            if (a2 < 0) {
                a2 = 0;
            }
            this.d += a2 + ((long) (gc.b() / 2));
            this.c = 0;
        }
        m473a();
        int myUid = Process.myUid();
        long j2 = -1;
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            b.m182a("Failed to obtain traffic data: " + e2);
            j = -1;
        }
        b.c("Stats rx=" + (j2 - this.f) + ", tx=" + (j - this.e));
        this.f = j2;
        this.e = j;
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, Exception exc) {
        fj.a(0, ez.CHANNEL_CON_FAIL.a(), 1, fwVar.m499a(), bj.c(this.f352a) ? 1 : 0);
        m473a();
    }

    @Override // com.xiaomi.push.fz
    public void b(fw fwVar) {
        m473a();
        this.c = SystemClock.elapsedRealtime();
        fj.a(0, ez.CONN_SUCCESS.a(), fwVar.m499a(), fwVar.a());
    }
}
