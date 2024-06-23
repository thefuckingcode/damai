package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fl;
import com.xiaomi.push.gh;
import com.xiaomi.push.hi;
import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class bt extends XMPushService.j {
    private fl a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f941a = null;

    public bt(XMPushService xMPushService, fl flVar) {
        super(4);
        this.f941a = xMPushService;
        this.a = flVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j, com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void m836a() {
        try {
            fl flVar = this.a;
            if (flVar != null) {
                this.f941a.a(flVar);
                if (this.a.f364a != null && hi.a(this.f941a, 1)) {
                    this.a.f364a.d = System.currentTimeMillis();
                    bz.a("category_coord_up", "coord_up", "com.xiaomi.xmsf", this.a.f364a);
                }
            }
        } catch (gh e) {
            b.a(e);
            this.f941a.a(10, e);
        }
    }
}
