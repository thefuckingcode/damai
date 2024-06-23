package com.xiaomi.push.service;

import com.alipay.sdk.m.e0.a;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fh;
import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class bq {
    private static int d = 300000;
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f938a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f939a;
    private int b = 0;
    private int c = 0;

    public bq(XMPushService xMPushService) {
        this.f939a = xMPushService;
        this.a = 500;
        this.f938a = 0;
    }

    private int a() {
        if (this.b > 8) {
            return a.a;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i = this.b;
        if (i > 4) {
            return (int) (random * 60000.0d);
        }
        if (i > 1) {
            return (int) (random * 10000.0d);
        }
        if (this.f938a == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f938a < 310000) {
            int i2 = this.a;
            int i3 = d;
            if (i2 >= i3) {
                return i2;
            }
            int i4 = this.c + 1;
            this.c = i4;
            if (i4 >= 4) {
                return i3;
            }
            this.a = (int) (((double) i2) * 1.5d);
            return i2;
        }
        this.a = 1000;
        this.c = 0;
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m835a() {
        this.f938a = System.currentTimeMillis();
        this.f939a.a(1);
        this.b = 0;
    }

    public void a(boolean z) {
        if (!this.f939a.m758a()) {
            b.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f939a.m759a(1)) {
                this.b++;
            }
            this.f939a.a(1);
            XMPushService xMPushService = this.f939a;
            xMPushService.getClass();
            xMPushService.a(new XMPushService.e());
        } else if (!this.f939a.m759a(1)) {
            int a2 = a();
            this.b++;
            b.m182a("schedule reconnect in " + a2 + "ms");
            XMPushService xMPushService2 = this.f939a;
            xMPushService2.getClass();
            xMPushService2.a(new XMPushService.e(), (long) a2);
            if (this.b == 2 && fh.m474a().m479a()) {
                ap.b();
            }
            if (this.b == 3) {
                ap.a();
            }
        }
    }
}
